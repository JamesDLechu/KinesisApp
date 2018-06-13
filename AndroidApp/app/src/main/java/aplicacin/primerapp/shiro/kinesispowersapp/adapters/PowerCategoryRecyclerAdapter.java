package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerCategoryModel;

/**
 * Created by Shiro on 06/01/2018.
 */

public class PowerCategoryRecyclerAdapter extends RecyclerView.Adapter<PowerCategoryRecyclerAdapter.ViewHolder> {

    private Context context;
    private int layout;
    private ArrayList<PowerCategoryModel> powerTypesList;
    private OnPowerTypeClickListener onPowerTypeClickListener;

    public interface OnPowerTypeClickListener{
        void onPowerTypeClick(PowerCategoryModel powerCategoryModel);
    }
    public void setOnPowerTypeClickListener(OnPowerTypeClickListener onPowerTypeClickListener){
        this.onPowerTypeClickListener= onPowerTypeClickListener;
    }

    public PowerCategoryRecyclerAdapter(Context context, ArrayList<PowerCategoryModel> powerTypesList, int layout){
        this.context= context;
        this.powerTypesList= powerTypesList;
        this.layout= layout;
    }

    @Override
    public PowerCategoryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PowerCategoryRecyclerAdapter.ViewHolder holder, int position) {
        final PowerCategoryModel powerCategoryModel = powerTypesList.get(position);

        holder.powerTypeName.setText(powerCategoryModel.getPowerCategoryModelName());
        Glide.with(context)
                .load(powerCategoryModel.getPowerCategoryModelImage())
                .into(holder.powerTypeImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPowerTypeClickListener.onPowerTypeClick(powerCategoryModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return powerTypesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView powerTypeName;
        ImageView powerTypeImage;

        public ViewHolder(View itemView) {
            super(itemView);

            powerTypeName= itemView.findViewById(R.id.textViewPowerCategoryAdapter);
            powerTypeImage= itemView.findViewById(R.id.imageViewPowerCategoryAdapter);
        }
    }
}
