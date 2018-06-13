package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.activities.Power_CategoryActivity;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.PowerCategoryRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerCategoryModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Power_Exercise;

public class PowerCategoryFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ArrayList<PowerModel> powersList= new ArrayList<PowerModel>();

    public PowerCategoryFragment() {
        // Required empty public constructor
    }

    public static PowerCategoryFragment newInstance(String param1, String param2) {
        PowerCategoryFragment fragment = new PowerCategoryFragment();
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
        View view= inflater.inflate(R.layout.fragment_power_category, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recyclerViewPowerTypeFragment);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(), 2);
        PowerCategoryRecyclerAdapter adapter=
                new PowerCategoryRecyclerAdapter(getContext(), getPowerTypeList(), R.layout.power_category_list_adapter);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        for(PowerCategoryModel category : getPowerTypeList()){
            powersList.addAll(category.getPowerCategoryModelListItems());
        }

        Bundle extra= new Bundle();
        extra.putParcelableArrayList(AllPowersFragment.allPowerKEY, powersList);
        AllPowersFragment.putArguments(extra);

        adapter.setOnPowerTypeClickListener(new PowerCategoryRecyclerAdapter.OnPowerTypeClickListener() {
            @Override
            public void onPowerTypeClick(PowerCategoryModel powerCategoryModel) {
                Intent intent= new Intent(getContext(), Power_CategoryActivity.class);
                intent.putExtra(Power_CategoryActivity.categoryModelKEY, powerCategoryModel);
                startActivity(intent);
            }
        });
        return view;
    }

    public ArrayList<PowerCategoryModel> getPowerTypeList(){
        return new ArrayList<PowerCategoryModel>(){
            {
                add(new PowerCategoryModel(getString(R.string.Kinetics),R.drawable.psychokinesis,
                        new ArrayList<PowerModel>(){
                            {
                                add(new PowerModel(getString(R.string.aerokinesis_name),getString(R.string.aerokinesis_definition),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise(getString(R.string.aerokinesis_exercise_1_name),
                                                        getString(R.string.aerokinesis_exercise_1_definition)));
                                                add(new Power_Exercise(getString(R.string.aerokinesis_exercise_2_name),
                                                        getString(R.string.aerokinesis_exercise_2_definition)));
                                                add(new Power_Exercise(getString(R.string.aerokinesis_exercise_3_name),
                                                        getString(R.string.aerokinesis_exercise_3_definition)));
                                                add(new Power_Exercise(getString(R.string.aerokinesis_exercise_4_name),
                                                        getString(R.string.aerokinesis_exercise_4_definition)));
                                            }
                                        },
                                        R.drawable.aerokinesis));
                                add(new PowerModel(getString(R.string.atmokinesis_name),getString(R.string.atmokinesis_definition),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.atmokinesis));
                                add(new PowerModel("Crioquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.criokinesis));
                                add(new PowerModel("Cronokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.chronokinesis));
                                add(new PowerModel("Electrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.electrokinesis));
                                add(new PowerModel("Fragokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.fragokinesis));
                                add(new PowerModel("Geokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.geokinesis));
                                add(new PowerModel("Hidrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.hidrokinesis));
                                add(new PowerModel("Levitación",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.levitacion));
                                add(new PowerModel("Magnetokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.magnetokinesis));
                                add(new PowerModel("Pirokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.pyrokinesis));
                                add(new PowerModel("Proyección Astral",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.proyeccion_astral));
                                add(new PowerModel("Telequinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.telequinesis));
                                add(new PowerModel("Umbrakinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.umbrakinesis));
                                add(new PowerModel("Visión Remota",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.vision_remota));
                            }
                        }));
                add(new PowerCategoryModel(getString(R.string.Extrasensorials),R.drawable.esper,
                        new ArrayList<PowerModel>(){
                            {
                                add(new PowerModel(getString(R.string.claircognizance_name),
                                        getString(R.string.claircognizance_description),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise( getString(R.string.claircognizance_exercise_1_name),
                                                        getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.aerokinesis));
                                add(new PowerModel("Atmoquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.atmokinesis));
                                add(new PowerModel("Crioquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.criokinesis));
                                add(new PowerModel("Cronokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.chronokinesis));
                                add(new PowerModel("Electrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.electrokinesis));
                                add(new PowerModel("Fragokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.fragokinesis));
                                add(new PowerModel("Geokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.geokinesis));
                                add(new PowerModel("Hidrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.hidrokinesis));
                                add(new PowerModel("Levitación",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.levitacion));
                                add(new PowerModel("Magnetokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.magnetokinesis));
                                add(new PowerModel("Pirokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.pyrokinesis));
                                add(new PowerModel("Proyección Astral",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.proyeccion_astral));
                                add(new PowerModel("Telequinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.telequinesis));
                                add(new PowerModel("Umbrakinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.umbrakinesis));
                                add(new PowerModel("Visión Remota",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.vision_remota));
                            }
                        }));
                add(new PowerCategoryModel(getString(R.string.Various),R.drawable.otros,
                        new ArrayList<PowerModel>(){
                            {
                                add(new PowerModel("Aerokinesis",getString(R.string.example),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.aerokinesis));
                                add(new PowerModel("Atmoquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.atmokinesis));
                                add(new PowerModel("Crioquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.criokinesis));
                                add(new PowerModel("Cronokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.chronokinesis));
                                add(new PowerModel("Electrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.electrokinesis));
                                add(new PowerModel("Fragokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.fragokinesis));
                                add(new PowerModel("Geokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.geokinesis));
                                add(new PowerModel("Hidrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.hidrokinesis));
                                add(new PowerModel("Levitación",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.levitacion));
                                add(new PowerModel("Magnetokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.magnetokinesis));
                                add(new PowerModel("Pirokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.pyrokinesis));
                                add(new PowerModel("Proyección Astral",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.proyeccion_astral));
                                add(new PowerModel("Telequinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.telequinesis));
                                add(new PowerModel("Umbrakinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.umbrakinesis));
                                add(new PowerModel("Visión Remota",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.vision_remota));
                            }
                        }));
                add(new PowerCategoryModel(getString(R.string.Magic),R.drawable.magia,
                        new ArrayList<PowerModel>(){
                            {
                                add(new PowerModel("Aerokinesis",getString(R.string.example),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.aerokinesis));
                                add(new PowerModel("Atmoquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.atmokinesis));
                                add(new PowerModel("Crioquinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.criokinesis));
                                add(new PowerModel("Cronokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.chronokinesis));
                                add(new PowerModel("Electrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.electrokinesis));
                                add(new PowerModel("Fragokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.fragokinesis));
                                add(new PowerModel("Geokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.geokinesis));
                                add(new PowerModel("Hidrokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.hidrokinesis));
                                add(new PowerModel("Levitación",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.levitacion));
                                add(new PowerModel("Magnetokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.magnetokinesis));
                                add(new PowerModel("Pirokinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.pyrokinesis));
                                add(new PowerModel("Proyección Astral",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.proyeccion_astral));
                                add(new PowerModel("Telequinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.telequinesis));
                                add(new PowerModel("Umbrakinesis",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.umbrakinesis));
                                add(new PowerModel("Visión Remota",getString(R.string.app_name),
                                        new ArrayList<Power_Exercise>(){
                                            {
                                                add(new Power_Exercise("Exercise 1", getString(R.string.example)));
                                            }
                                        },
                                        R.drawable.vision_remota));
                            }
                        }));
            }
        };
    }
}
