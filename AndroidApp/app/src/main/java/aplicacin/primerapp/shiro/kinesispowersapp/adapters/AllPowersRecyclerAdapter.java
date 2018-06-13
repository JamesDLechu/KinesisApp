package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerCategoryModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;

/**
 * Created by Shiro on 07/01/2018.
 */

public class AllPowersRecyclerAdapter extends RecyclerView.Adapter<AllPowersRecyclerAdapter.ViewHolder>
        implements Filterable {
    private Context context;
    private List<PowerModel> powersListItems;
    private List<PowerModel> powersListItemsFiltered;
    private OnPowerItemClickListener onPowerItemClickListener;

    public interface OnPowerItemClickListener{
        void onPowerItemClick(PowerModel powerModel);
    }

    public void setOnPowerItemClickListener(OnPowerItemClickListener onPowerItemClickListener){
        this.onPowerItemClickListener= onPowerItemClickListener;
    }

    public AllPowersRecyclerAdapter(Context context, List<PowerModel> powersList){
        this.context= context;
        this.powersListItems= powersList;
        this.powersListItemsFiltered= powersList;
    }

    @Override
    public AllPowersRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.powers_list_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllPowersRecyclerAdapter.ViewHolder holder, int position) {
        final PowerModel powerModel= powersListItemsFiltered.get(position);

        holder.powerName.setText(powerModel.getPowerModelName());
        Glide.with(context)
                .load(powerModel.getPowerModelImage())
                .into(holder.powerImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPowerItemClickListener.onPowerItemClick(powerModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return powersListItemsFiltered.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView powerImage;
        TextView powerName;
        public ViewHolder(View itemView) {
            super(itemView);

            powerImage= itemView.findViewById(R.id.imageViewAllPowersAdapter);
            powerName= itemView.findViewById(R.id.textViewAllPowersAdapter);
        }
    }

    //ESTO ES LO IMPORTANTE PARA REALIZAR EL FILTRADO
    //Check in BindViewHolder and getItemCount the value assigned is the filteredList
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    powersListItemsFiltered = powersListItems;
                } else {
                    List<PowerModel> filteredList = new ArrayList<>();
                    for (PowerModel powerItem : powersListItems) {

                        if (powerItem.getPowerModelName().toLowerCase().contains(charString.toLowerCase())
                                || powerItem.getPowerModelName().contains(charSequence))
                            filteredList.add(powerItem);
                    }
                    powersListItemsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = powersListItemsFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                powersListItemsFiltered = (ArrayList<PowerModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
