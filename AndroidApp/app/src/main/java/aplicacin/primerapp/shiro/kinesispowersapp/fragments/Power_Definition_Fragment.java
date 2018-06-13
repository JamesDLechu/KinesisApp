package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.Power_DefinitionRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;

public class Power_Definition_Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static final String powerKEY= "powerKey";
    private static PowerModel power;

    public Power_Definition_Fragment() {
    }

    public static Power_Definition_Fragment newInstance(String param1, String param2) {
        Power_Definition_Fragment fragment = new Power_Definition_Fragment();
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
        View view= inflater.inflate(R.layout.fragment_power__definition_, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recyclerViewPowerDefinitionFragment);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        Power_DefinitionRecyclerAdapter adapter= new Power_DefinitionRecyclerAdapter(getContext(), power);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public static void putArguments(Bundle extra){
        power= extra.getParcelable(powerKEY);
    }

}
