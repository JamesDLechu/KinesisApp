package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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
 * Created by Shiro on 13/01/2018.
 */

public class PowerCategory_ItemRecyclerAdapter extends RecyclerView.Adapter<PowerCategory_ItemRecyclerAdapter.ViewHolder>{

    private Context context;
    private ArrayList<PowerCategoryModel> powerCategoryModels;
    private OnPowerCategoryItemClickListener onPowerCategoryItemClickListener;

    public interface OnPowerCategoryItemClickListener{
        void onPowerCategoryItemClick(PowerCategoryModel powerCategoryModel);
    }

    public void setOnPowerCategoryModelClickListener(OnPowerCategoryItemClickListener onPowerCategoryModelClickListener){
        this.onPowerCategoryItemClickListener= onPowerCategoryModelClickListener;
    }

    public PowerCategory_ItemRecyclerAdapter(Context context, ArrayList<PowerCategoryModel> powerCategoryModels){
        this.context= context;
        this.powerCategoryModels= powerCategoryModels;
    }

    @Override
    public PowerCategory_ItemRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.power_category_item_list_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PowerCategory_ItemRecyclerAdapter.ViewHolder holder, int position) {
        final PowerCategoryModel model= powerCategoryModels.get(position);

        holder.categoryItemName.setText(model.getPowerCategoryModelName());
        Glide.with(context)
                .load(ContextCompat.getDrawable(context, model.getPowerCategoryModelImage()))
                .into(holder.categoryItemPicture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPowerCategoryItemClickListener.onPowerCategoryItemClick(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return powerCategoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryItemPicture;
        TextView categoryItemName;

        public ViewHolder(View itemView) {
            super(itemView);

            categoryItemName= itemView.findViewById(R.id.textViewPowerCategory_ItemAdapter);
            categoryItemPicture= itemView.findViewById(R.id.imageViewPowerCategory_ItemAdapter);
        }
    }
}
