package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aplicacin.primerapp.shiro.kinesispowersapp.R;

/**
 * Created by Shiro on 15/01/2018.
 */

public class Power_Exercises_ItemRecyclerAdapter extends RecyclerView.Adapter<Power_Exercises_ItemRecyclerAdapter.ViewHolder> {

    private Context context;
    private String textToDisplay;

    public Power_Exercises_ItemRecyclerAdapter(Context context, String textToDisplay){
        this.context= context;
        this.textToDisplay= textToDisplay;
    }

    @Override
    public Power_Exercises_ItemRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.power_exercise_item_list_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Power_Exercises_ItemRecyclerAdapter.ViewHolder holder, int position) {
        holder.textView.setText(textToDisplay);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView= itemView.findViewById(R.id.textViewPowerExerciseItemAdapter);
        }
    }
}
