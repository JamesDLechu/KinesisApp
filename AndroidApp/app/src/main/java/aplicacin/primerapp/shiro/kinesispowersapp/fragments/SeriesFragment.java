package aplicacin.primerapp.shiro.kinesispowersapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.activities.Movies_and_SeriesActivity;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.MoviesRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Movie;

public class SeriesFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public SeriesFragment() {
        // Required empty public constructor
    }

    public static SeriesFragment newInstance(String param1, String param2) {
        SeriesFragment fragment = new SeriesFragment();
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
        View view= inflater.inflate(R.layout.fragment_series, container, false);

        RecyclerView recyclerView= view.findViewById(R.id.recyclerViewSeriesFragment);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        MoviesRecyclerAdapter adapter= new MoviesRecyclerAdapter(getContext(),getSeries());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnMovieClickListener(new MoviesRecyclerAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent= new Intent(getContext(), Movies_and_SeriesActivity.class);
                intent.putExtra(Movies_and_SeriesActivity.movieKEY, movie);
                startActivity(intent);
            }
        });

        return view;
    }

    private ArrayList<Movie> getSeries(){
        return new ArrayList<Movie>(){
            {
                add(new Movie("chrysanthemum","Empty",R.drawable.chrysanthemum));
                add(new Movie("desert","Empty",R.drawable.desert));
                add(new Movie("hydrangeas","Empty",R.drawable.hydrangeas));
                add(new Movie("jellyfish","Empty",R.drawable.jellyfish));
                add(new Movie("koala","Empty",R.drawable.koala));
                add(new Movie("lighthouse","Empty",R.drawable.lighthouse));
                add(new Movie("penguins","Empty",R.drawable.penguins));
                add(new Movie("tulips","Empty",R.drawable.tulips));

            }
        };
    }

}
