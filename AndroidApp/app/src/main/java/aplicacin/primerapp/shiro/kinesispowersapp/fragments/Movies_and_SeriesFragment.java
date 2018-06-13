package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.Movies_and_SeriesPageAdapter;

public class Movies_and_SeriesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Movies_and_SeriesFragment() {
        // Required empty public constructor
    }

    public static Movies_and_SeriesFragment newInstance(String param1, String param2) {
        Movies_and_SeriesFragment fragment = new Movies_and_SeriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movies_and_series, container, false);

        TabLayout tabLayout= view.findViewById(R.id.tabLayoutMoviesAndSeriesFragment);
        tabLayout.addTab(tabLayout.newTab().setText("Peliculas"));
        tabLayout.addTab(tabLayout.newTab().setText("Series"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager= view.findViewById(R.id.viewPagerMoviesAndSeriesFragment);
        viewPager.setAdapter(new Movies_and_SeriesPageAdapter(getChildFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(1);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position= tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

}
