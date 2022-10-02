package rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.model.Financija;



public class DetaljanActivity extends AppCompatActivity {

    private EditText naslovEt;
    private EditText kolicinaEt;
    private EditText opisEt;
    private Financija financija;
    public static final String FINANCE_KEY_DISPLAY = "finance_key_display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaljan);
        init();
    }

    private void init(){
        initView();
        parseIntent();
    }

    private void initView(){
        naslovEt = findViewById(R.id.financijaPrikazNaslov);
        kolicinaEt = findViewById(R.id.financijaPrikazKolicina);
        opisEt = findViewById(R.id.financijaPrikazOpis);
    }

    private void parseIntent(){
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            this.financija = (Financija) intent.getExtras().getSerializable(FINANCE_KEY_DISPLAY);
            naslovEt.setText(this.financija.getNaslov());
            kolicinaEt.setText(this.financija.getKolicina()+"");
            opisEt.setText(this.financija.getOpis());
        }
    }
}