package rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.IME;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.NAZIV_BANKE;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.PREZIME;

public class IzmeniActivity extends AppCompatActivity {

    private EditText imeEt;
    private EditText prezimeEt;
    private EditText bankaEt;
    private Button izmeniBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izmeni);
        init();
    }

    private void init(){
        initView();
        initListeners();
    }

    private void initView(){
        imeEt = findViewById(R.id.imeProfilEt);
        prezimeEt = findViewById(R.id.prezimeProfilEt);
        bankaEt = findViewById(R.id.bankaProfilEt);
        izmeniBtn = findViewById(R.id.sacuvanIzmeneBtn);
    }

    private void initListeners(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        izmeniBtn.setOnClickListener(v -> {
            if(!imeEt.getText().toString().matches("") && !prezimeEt.getText().toString().matches("") && !bankaEt.getText().toString().matches("")){
                sharedPreferences.edit()
                        .putString(IME, imeEt.getText().toString())
                        .putString(PREZIME, prezimeEt.getText().toString())
                        .putString(NAZIV_BANKE, bankaEt.getText().toString())
                        .apply();
                finish();
            }else{
                Toast.makeText(this, "Sva polja su obavezna", Toast.LENGTH_SHORT).show();
            }
        });
    }
}