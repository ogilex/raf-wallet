package rs.raf.projekat1.Ognjen_Boskovic_RN9518.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import rs.raf.projekat1.Ognjen_Boskovic_RN9518.R;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewpager.ListPagerAdapter;
import rs.raf.projekat1.Ognjen_Boskovic_RN9518.viewpager.PagerAdapter;

public class ListFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view){
        initView(view);
        initTabs();
    }

    private void initView(View view){
        viewPager = view.findViewById(R.id.listViewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
    }

    private void initTabs(){
        viewPager.setAdapter(new ListPagerAdapter(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (Fragment fragment : getChildFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}
