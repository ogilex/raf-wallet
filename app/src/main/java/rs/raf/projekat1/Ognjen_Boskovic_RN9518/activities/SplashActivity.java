package rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import timber.log.Timber;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.IME;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.NAZIV_BANKE;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.PREZIME;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        if(sharedPreferences.contains(IME) && sharedPreferences.contains(PREZIME) && sharedPreferences.contains(NAZIV_BANKE)){
            Intent intent = new Intent(this,HomeActivity.class);
            Timber.e("Radim nesto ");
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }
}