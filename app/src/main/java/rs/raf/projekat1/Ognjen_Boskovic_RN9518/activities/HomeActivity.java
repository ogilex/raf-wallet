package rs.raf.projekat1.Ognjen_Boskovic_RN9518.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewpager.PagerAdapter;

public class HomeActivity extends AppCompatActivity {

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        initViewPager();
        initNavigation();
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.customViewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

    }

    private void initNavigation() {
        ((BottomNavigationView) findViewById(R.id.bottomNavigation)).setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav1:
                    viewPager.setCurrentItem(PagerAdapter.STANJE, false);
                    break;
                case R.id.nav2:
                    viewPager.setCurrentItem(PagerAdapter.UNOS, false);
                    break;
                case R.id.nav3:
                    viewPager.setCurrentItem(PagerAdapter.LISTA, false);
                    break;
                case R.id.nav4:
                    viewPager.setCurrentItem(PagerAdapter.PROFIL, false);
                    break;
            }
            return true;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }




}