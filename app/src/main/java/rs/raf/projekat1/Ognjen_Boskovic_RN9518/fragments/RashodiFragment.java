package rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.DetaljanActivity;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.IzmeniFinancActivity;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.adapters.PrihodAdapter;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.adapters.RashodAdapter;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.diff.FinancijaDiffItemCallback;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.PrihodiViewModel;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.RashodiViewModel;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.FINANCE_KEY_EDIT;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.ID;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.KOLICINA;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.MESSAGE_REQUEST_CODE;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.NASLOV;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.OPIS;

public class RashodiFragment extends Fragment {

    private RecyclerView recyclerView;

    private RashodiViewModel rashodiViewModel;
    private RashodAdapter adapter;

    public RashodiFragment(){
        super(R.layout.fragment_list_rashodi);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rashodiViewModel = new ViewModelProvider(requireActivity()).get(RashodiViewModel.class);
        init(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView.setAdapter(null);
        adapter = null;
        recyclerView = null;
    }

    private void init(View view){
        initView(view);
        initObservers();
        initRecycler();

    }

    private void initView(View view){
        recyclerView = view.findViewById(R.id.rashodiRv);

    }

    private void initObservers(){
        rashodiViewModel.getRashode().observe(getViewLifecycleOwner(), rashodi -> {
            adapter.submitList(rashodi);
        });
    }

    private void initRecycler(){
        adapter = new RashodAdapter(new FinancijaDiffItemCallback(), deleteRashod -> {
            rashodiViewModel.removeRashod(deleteRashod);
            return null;
        }, editRashod -> {
            Intent intent = new Intent(getActivity(), IzmeniFinancActivity.class);
            intent.putExtra(FINANCE_KEY_EDIT, editRashod);
            startActivityForResult(intent, MESSAGE_REQUEST_CODE);
            return null;
        }, clickRashod -> {
            Intent intent = new Intent(getActivity(), DetaljanActivity.class);
            intent.putExtra("finance_key_display", clickRashod);
            startActivity(intent);
            return null;
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MESSAGE_REQUEST_CODE){
            if(requestCode == Activity.RESULT_OK) {
                int id = data.getIntExtra(ID, -1);
                String naslov = data.getStringExtra(NASLOV);
                int kolicina = data.getIntExtra(KOLICINA, -1);
                String opis = data.getStringExtra(OPIS);

                rashodiViewModel.editRashod(id, naslov, kolicina, opis);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
