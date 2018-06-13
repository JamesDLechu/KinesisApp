package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Power_Exercise;

/**
 * Created by Shiro on 12/01/2018.
 */

public class Power_ExercisesRecyclerAdapter extends RecyclerView.Adapter<Power_ExercisesRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Power_Exercise> exercisesList;
    private OnExerciseClickListener onExerciseClickListener;

    public interface OnExerciseClickListener{
        void onExerciseClick(Power_Exercise exercise);
    }

    public void setOnExerciseClickListener(OnExerciseClickListener onExerciseClickListener){
        this.onExerciseClickListener= onExerciseClickListener;
    }

    public Power_ExercisesRecyclerAdapter(Context context, ArrayList<Power_Exercise> exercisesList){
        this.context= context;
        this.exercisesList= exercisesList;
    }

    @Override
    public Power_ExercisesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.power_exercise_list_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Power_ExercisesRecyclerAdapter.ViewHolder holder, int position) {
        final Power_Exercise exercise= exercisesList.get(position);

        holder.number.setText(exercise.getPowerExerciseNumber());
        holder.description.setText(exercise.getPowerExerciseDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onExerciseClickListener.onExerciseClick(exercise);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercisesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView number;
        TextView description;

        public ViewHolder(View itemView) {
            super(itemView);

            number= itemView.findViewById(R.id.textViewTitlePowerExerciseAdapter);
            description= itemView.findViewById(R.id.textViewTextPowerExerciseAdapter);
        }
    }
}
