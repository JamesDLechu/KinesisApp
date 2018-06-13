package aplicacin.primerapp.shiro.kinesispowersapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.Movies_and_Series_ItemRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Movie;

public class Movies_and_SeriesActivity extends AppCompatActivity {

    public static final String movieKEY= "movie_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_and__series);

        Bundle extras= getIntent().getExtras();
        Movie movie= extras.getParcelable(movieKEY);

        Toolbar toolbar= findViewById(R.id.toolbarMoviesAndSeriesActivity);
        toolbar.setTitle(movie.getMovieName());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView= findViewById(R.id.recyclerViewMoviesAnsSeriesActivity);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        Movies_and_Series_ItemRecyclerAdapter adapter=
                new Movies_and_Series_ItemRecyclerAdapter(this, movie);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
