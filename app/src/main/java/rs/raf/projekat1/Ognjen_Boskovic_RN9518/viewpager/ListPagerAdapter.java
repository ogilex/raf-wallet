package rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.InputFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.ListFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.PrihodiFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.ProfileFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.RashodiFragment;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments.StateFragment;

public class ListPagerAdapter extends FragmentPagerAdapter {

    private final int ITEM_COUNT = 2;
    public static final int PRIHODI = 0;
    public static final int RASHODI = 1;

    public ListPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case PRIHODI: fragment = new PrihodiFragment(); break;
            default:fragment = new RashodiFragment(); break;
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
            case PRIHODI: return "Prihodi";
            default: return "Rashodi";
        }
    }
}
