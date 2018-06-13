package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.activities.PowerActivity;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.AllPowersRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.PowerCategoryRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerCategoryModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Power_Exercise;

public class AllPowersFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static final String allPowerKEY= "all_Power_KEY";
    private static AllPowersRecyclerAdapter adapter;
    private static ArrayList<PowerModel> powersList;

    public AllPowersFragment() {
        // Required empty public constructor
    }

    public static AllPowersFragment newInstance(String param1, String param2) {
        AllPowersFragment fragment = new AllPowersFragment();
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
        View view=  inflater.inflate(R.layout.fragment_all_powers, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recyclerViewAllPowersFragment);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(), 2);
        adapter= new AllPowersRecyclerAdapter(getContext(), powersList);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnPowerItemClickListener(new AllPowersRecyclerAdapter.OnPowerItemClickListener() {
            @Override
            public void onPowerItemClick(PowerModel powerModel) {
                Intent intent= new Intent(getContext(), PowerActivity.class);
                intent.putExtra(PowerActivity.PowerTypeKEY, powerModel);
                startActivity(intent);
            }
        });
        return view;
    }

    public static void loadData(String query){
        adapter.getFilter().filter(query);
    }

    public static void putArguments(Bundle bundle){
        powersList= bundle.getParcelableArrayList(allPowerKEY);
    }
}
