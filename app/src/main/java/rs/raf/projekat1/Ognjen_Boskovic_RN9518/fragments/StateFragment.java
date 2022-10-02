package rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.PrihodiViewModel;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.RashodiViewModel;

public class StateFragment extends Fragment {

    private PrihodiViewModel prihodiViewModel;
    private RashodiViewModel rashodiViewModel;

    private TextView prihodTv;
    private TextView rashodTv;
    private TextView razlikaTv;

    public StateFragment(){
        super(R.layout.fragment_state);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prihodiViewModel = new ViewModelProvider(requireActivity()).get(PrihodiViewModel.class);
        rashodiViewModel = new ViewModelProvider(requireActivity()).get(RashodiViewModel.class);
        init(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        izracunajRazliku();
    }

    private void initView(View view){
        prihodTv = view.findViewById(R.id.kolicinaPrihodStanjeTv);
        rashodTv = view.findViewById(R.id.kolicinaRashovStanjeTc);
        razlikaTv = view.findViewById(R.id.razlikaStanjeTv);
        izracunajRazliku();
    }

    private void init(View view){
        initView(view);
        initObservers();
    }

    private void initObservers(){
        prihodiViewModel.getPrihode().observe(getViewLifecycleOwner(), prihodi -> {
            prihodTv.setText(prihodiViewModel.sumPrihod()+"");
        });
        rashodiViewModel.getRashode().observe(getViewLifecycleOwner(), rashodi -> {
            rashodTv.setText(rashodiViewModel.sumRashod()+"");
        });


    }

    private void izracunajRazliku(){
        int razlika = prihodiViewModel.sumPrihod() - rashodiViewModel.sumRashod();

        if(razlika > 0 ){
            razlikaTv.setTextColor(Color.GREEN);
        }else{
            razlikaTv.setTextColor(Color.RED);
        }
        razlikaTv.setText(razlika+"");
    }

}
