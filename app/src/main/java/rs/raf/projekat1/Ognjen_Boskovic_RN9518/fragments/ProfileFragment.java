package rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.IzmeniActivity;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity;

import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.IME;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.NAZIV_BANKE;
import static rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities.LoginActivity.PREZIME;

public class ProfileFragment extends Fragment {

    private TextView imeTv;
    private TextView prezTv;
    private TextView bankaTv;
    private Button izmeniBtn;
    private Button odjavaBtn;

    public ProfileFragment(){
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){
        initView(view);
        initListeners();
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(getActivity().getPackageName(),Context.MODE_PRIVATE);
        imeTv.setText(sharedPreferences.getString(IME, ""));
        prezTv.setText(sharedPreferences.getString(PREZIME, ""));
        bankaTv.setText(sharedPreferences.getString(NAZIV_BANKE, ""));
    }

    private void initView(View view){
        imeTv = view.findViewById(R.id.imeProfil);
        prezTv = view.findViewById(R.id.prezimeProfil);
        bankaTv = view.findViewById(R.id.bankaProfil);
        izmeniBtn = view.findViewById(R.id.btnIzmeniProfil);
        odjavaBtn = view.findViewById(R.id.btnOdjaviProfil);
    }

    private void initListeners(){
        izmeniBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IzmeniActivity.class);
            startActivity(intent);
        });
        odjavaBtn.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences(getActivity().getPackageName(), Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
    }
}
