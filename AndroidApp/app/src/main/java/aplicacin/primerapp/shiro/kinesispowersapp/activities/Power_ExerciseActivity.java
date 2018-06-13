package aplicacin.primerapp.shiro.kinesispowersapp.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.Power_Exercises_ItemRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Power_Exercise;

public class Power_ExerciseActivity extends AppCompatActivity {

    public static final String ExerciseKEY= "exerciseKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power__exercise);

        Bundle extra= getIntent().getExtras();
        Power_Exercise exercise= extra.getParcelable(ExerciseKEY);

        Toolbar toolbar= findViewById(R.id.toolbarPowerExerciseActivity);
        toolbar.setTitle(exercise.getPowerExerciseNumber());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView= findViewById(R.id.recyclerViewPowerExercisesActivity);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        Power_Exercises_ItemRecyclerAdapter adapter=
                new Power_Exercises_ItemRecyclerAdapter(this, exercise.getPowerExerciseDescription());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
