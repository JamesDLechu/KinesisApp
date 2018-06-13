package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.activities.Power_ExerciseActivity;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.Power_ExercisesRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Power_Exercise;

public class Power_ExercisesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private static PowerModel power;
    public static final String powerKEY= "powerKey";

    public Power_ExercisesFragment() {
    }

    public static Power_ExercisesFragment newInstance(String param1, String param2) {
        Power_ExercisesFragment fragment = new Power_ExercisesFragment();
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
        View view= inflater.inflate(R.layout.fragment_power__exercises, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recyclerViewPowerExercisesFragment);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        Power_ExercisesRecyclerAdapter adapter=
                new Power_ExercisesRecyclerAdapter(getContext(), power.getPowerModelExercises());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnExerciseClickListener(new Power_ExercisesRecyclerAdapter.OnExerciseClickListener() {
            @Override
            public void onExerciseClick(Power_Exercise exercise) {
                Intent intent= new Intent(getContext(), Power_ExerciseActivity.class);
                intent.putExtra(Power_ExerciseActivity.ExerciseKEY, exercise);
                startActivity(intent);
            }
        });

        return view;
    }

    public static void putArguments(Bundle extras){
        power= extras.getParcelable(powerKEY);
    }

}
