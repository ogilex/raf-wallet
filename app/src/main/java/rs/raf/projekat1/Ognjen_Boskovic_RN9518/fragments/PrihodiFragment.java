package rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.DetaljanActivity;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.IzmeniFinancActivity;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Tip;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.adapters.PrihodAdapter;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.recycler.diff.FinancijaDiffItemCallback;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.PrihodiViewModel;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.DetaljanActivity.FINANCE_KEY_DISPLAY;


public class PrihodiFragment extends Fragment {

    private RecyclerView recyclerView;

    private PrihodiViewModel prihodiViewModel;
    private PrihodAdapter adapter;


    public static final String ID = "id";
    public static String NASLOV = "naslov";
    public static String KOLICINA = "kolicina";
    public static String OPIS = "opis";

    public static String FINANCE_KEY_EDIT = "finance_key_edit";
    public static final int MESSAGE_REQUEST_CODE = 111;

    public PrihodiFragment() {
        super(R.layout.fragment_list_prihodi);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prihodiViewModel = new ViewModelProvider(requireActivity()).get(PrihodiViewModel.class);
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
        recyclerView = view.findViewById(R.id.prihodiRv);

    }

    private void initObservers(){
        prihodiViewModel.getPrihode().observe(getViewLifecycleOwner(), prihodi -> {
            adapter.submitList(prihodi);
        });
    }

    private void initRecycler(){
        adapter = new PrihodAdapter(new FinancijaDiffItemCallback(), deletePrihod -> {
           prihodiViewModel.removePrihod(deletePrihod);
           return null;
        }, editPrihod -> {
            Intent intent = new Intent(getActivity(), IzmeniFinancActivity.class);
            intent.putExtra(FINANCE_KEY_EDIT, editPrihod);
            startActivityForResult(intent, MESSAGE_REQUEST_CODE);
            return null;
        }, clickPrihod -> {
            Intent intent = new Intent(getActivity(), DetaljanActivity.class);
            intent.putExtra(FINANCE_KEY_DISPLAY, clickPrihod);
            startActivityForResult(intent, MESSAGE_REQUEST_CODE);
            return null;
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MESSAGE_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK) {
                int id = data.getIntExtra(ID, -1);
                String naslov = data.getStringExtra(NASLOV);
                int kolicina = data.getIntExtra(KOLICINA, -1);
                String opis = data.getStringExtra(OPIS);

                prihodiViewModel.editPrihod(id, naslov, kolicina, opis);
                adapter.notifyDataSetChanged();
            }
        }
    }

}
