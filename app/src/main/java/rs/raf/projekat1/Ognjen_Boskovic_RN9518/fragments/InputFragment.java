package rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Tip;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.PrihodiViewModel;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.RashodiViewModel;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.PrihodiViewModel.currIdx;

public class InputFragment extends Fragment {

    private TextView textView;
    private Spinner spinner;
    private EditText naslovEt;
    private EditText kolicinaEt;
    private EditText opisEt;
    private Button inputBtn;
    private PrihodiViewModel prihodiViewModel;
    private RashodiViewModel rashodiViewModel;

    public InputFragment(){
        super(R.layout.fragment_input);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prihodiViewModel = new ViewModelProvider(requireActivity()).get(PrihodiViewModel.class);
        rashodiViewModel = new ViewModelProvider(requireActivity()).get(RashodiViewModel.class);
        init(view);

    }

    private void init(View view){
        initView(view);
        initListeners();
    }

    private void initView(View view){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.financije, R.layout.support_simple_spinner_dropdown_item);
        textView = view.findViewById(R.id.textView3);
        spinner = view.findViewById(R.id.inputSpinner);
        spinner.setAdapter(adapter);
        naslovEt = view.findViewById(R.id.inputNaslovEt);
        kolicinaEt = view.findViewById(R.id.inputKolicinaEt);
        inputBtn = view.findViewById(R.id.inputBtn);
        opisEt = view.findViewById(R.id.opisUnosEt);
    }

    private void initListeners(){
        inputBtn.setOnClickListener(v -> {
            String naslov = naslovEt.getText().toString();
            String kolicina = kolicinaEt.getText().toString();
            int kolicinaBroj = Integer.parseInt(kolicina);
            String opis = opisEt.getText().toString();
            if(spinner.getSelectedItemPosition() == 0){
                Financija financija = new Financija(currIdx++, naslov, kolicinaBroj, Tip.PRIHOD, opis);
                prihodiViewModel.addPrihod(financija);
            }else{
                Financija financija = new Financija(currIdx++, naslov, kolicinaBroj, Tip.RASHOD, opis);
                rashodiViewModel.addRashod(financija);
            }
            naslovEt.getText().clear();
            kolicinaEt.getText().clear();
            opisEt.getText().clear();

        });

    }

}
