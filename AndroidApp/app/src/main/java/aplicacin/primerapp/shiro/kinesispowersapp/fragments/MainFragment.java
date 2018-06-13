package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.MainPageAdapter;

public class MainFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private int MENU_HIDDEN= 0;
    private int MENU_SEARCH= 1;
    private int menuState= MENU_HIDDEN;


    public MainFragment() {
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_main, container, false);

        TabLayout tabLayout= view.findViewById(R.id.tabLayoutMain);
        tabLayout.addTab(tabLayout.newTab().setText("Categoría"));
        tabLayout.addTab(tabLayout.newTab().setText("Todos"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager= view.findViewById(R.id.viewPagerMain);
        viewPager.setAdapter(new MainPageAdapter(getChildFragmentManager(),tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(1);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position= tab.getPosition();
                viewPager.setCurrentItem(position);

                if(position == 1)
                    menuState= MENU_SEARCH;
                else
                    menuState= MENU_HIDDEN;
                getActivity().invalidateOptionsMenu();
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

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        if(menuState == MENU_SEARCH)
            menu.findItem(R.id.searchButton).setVisible(true);

        super.onPrepareOptionsMenu(menu);
    }
}
