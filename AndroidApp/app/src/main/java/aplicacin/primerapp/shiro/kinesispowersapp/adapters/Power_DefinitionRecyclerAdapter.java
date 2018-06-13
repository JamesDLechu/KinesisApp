package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;

/**
 * Created by Shiro on 12/01/2018.
 */

public class Power_DefinitionRecyclerAdapter extends RecyclerView.Adapter<Power_DefinitionRecyclerAdapter.ViewHolder>{

    private Context context;
    private PowerModel powerModel;

    public Power_DefinitionRecyclerAdapter(Context context, PowerModel powerModel){
        this.context= context;
        this.powerModel= powerModel;
    }

    @Override
    public Power_DefinitionRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.power_definition_list_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Power_DefinitionRecyclerAdapter.ViewHolder holder, int position) {
        PowerModel powerModel= this.powerModel;

        holder.definition.setText(powerModel.getPowerModelDefinition());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView definition;

        public ViewHolder(View itemView) {
            super(itemView);

            definition= itemView.findViewById(R.id.textViewTextPowerDefinitionAdapter);
        }
    }
}
