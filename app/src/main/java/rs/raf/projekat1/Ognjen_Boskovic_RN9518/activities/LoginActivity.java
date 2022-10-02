package rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;

public class LoginActivity extends AppCompatActivity {

    public static final String IME = "ime";
    public static final String PREZIME = "prezime";
    public static final String NAZIV_BANKE = "banka";
    public static final String PASSWORD = "12345";
    private ImageView imageView;
    private TextView textView;
    private EditText imeEt;
    private EditText prezimeEt;
    private EditText nazivBankeEt;
    private EditText sifraEt;
    private Button prijavaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init(){
        initView();
        initListeners();
    }

    private void initView(){
        imageView = findViewById(R.id.loginMonetIv);
        textView = findViewById(R.id.textView);
        imeEt = findViewById(R.id.imeEt);
        prezimeEt = findViewById(R.id.prezimeEt);
        nazivBankeEt = findViewById(R.id.bankaEt);
        sifraEt = findViewById(R.id.sifraEt);
        prijavaBtn = findViewById(R.id.prijavaBtn);
    }

    private void initListeners(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        prijavaBtn.setOnClickListener(v -> {
            if(!imeEt.getText().toString().matches("") && !prezimeEt.getText().toString().matches("") && !nazivBankeEt.getText().toString().matches("") && !sifraEt.getText().toString().matches("") ){
                if(sifraEt.getText().toString().length() >= 5){
                    if(sifraEt.getText().toString().equals(PASSWORD)){
                        sharedPreferences.edit()
                                .putString(IME, imeEt.getText().toString())
                                .putString(PREZIME, prezimeEt.getText().toString())
                                .putString(NAZIV_BANKE, nazivBankeEt.getText().toString())
                                .apply();
                        Intent intent = new Intent(this,HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "Netacna sifra", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Sifra mora imati minimum 5 karaktera", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Sva polja su obavezna", Toast.LENGTH_SHORT).show();
            }
        });
    }

}