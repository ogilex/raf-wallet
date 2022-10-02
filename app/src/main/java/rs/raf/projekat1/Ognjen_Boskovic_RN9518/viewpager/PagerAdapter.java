package rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.InputFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.ListFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.ProfileFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.StateFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private final int ITEM_COUNT = 4;
    public static final int STANJE = 0;
    public static final int UNOS = 1;
    public static final int LISTA = 2;
    public static final int PROFIL = 3;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case STANJE: fragment = new StateFragment(); break;
            case UNOS: fragment = new InputFragment(); break;
            case LISTA: fragment = new ListFragment(); break;
            default:fragment = new ProfileFragment(); break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case STANJE: return "Stanje";
            case UNOS: return "Unos";
            case LISTA: return "Lista";
            case PROFIL: return "Profil";
            default: return "Rashodi";
        }
    }


}
