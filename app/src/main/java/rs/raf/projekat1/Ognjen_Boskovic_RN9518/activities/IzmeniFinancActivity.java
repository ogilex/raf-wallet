package rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Tip;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewmodels.PrihodiViewModel;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.FINANCE_KEY_EDIT;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.ID;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.KOLICINA;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.NASLOV;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment.OPIS;

public class IzmeniFinancActivity extends AppCompatActivity {

    private EditText naslovEt;
    private EditText kolicinaEt;
    private Button odustaniBtn;
    private Button sacuvajBtn;
    private Financija financija;
    private EditText opisEt;
    private PrihodiViewModel prihodiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izmeni_financ);
        prihodiViewModel = new ViewModelProvider(this).get(PrihodiViewModel.class);
        init();
    }

    private void init(){
        initView();
        parseIntent();
        initListeners();
    }

    private void initView(){
        naslovEt = findViewById(R.id.financijaEditNaslov);
        kolicinaEt = findViewById(R.id.financijaEditKolicina);
        opisEt = findViewById(R.id.editOpisEt);
        odustaniBtn = findViewById(R.id.odustaniEditBtn);
        sacuvajBtn = findViewById(R.id.sacuvajEditBtn);
    }

    private void parseIntent(){
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            this.financija = (Financija) intent.getExtras().getSerializable(FINANCE_KEY_EDIT);
            naslovEt.setText(this.financija.getNaslov());
            kolicinaEt.setText(this.financija.getKolicina()+"");
            opisEt.setText(this.financija.getOpis());
        }
    }

    private void initListeners(){

        odustaniBtn.setOnClickListener(v -> {
            finish();
        });
        sacuvajBtn.setOnClickListener(v -> {
            Intent returnIntent = new Intent();
            this.financija.setNaslov(naslovEt.getText().toString());
            this.financija.setKolicina(Integer.parseInt(kolicinaEt.getText().toString()));
            this.financija.setOpis(opisEt.getText().toString());
            returnIntent.putExtra(NASLOV, this.financija.getNaslov());
            returnIntent.putExtra(KOLICINA, this.financija.getKolicina());
            returnIntent.putExtra(OPIS, this.financija.getOpis());
            setResult(Activity.RESULT_OK, returnIntent);

            finish();

        });
    }

}