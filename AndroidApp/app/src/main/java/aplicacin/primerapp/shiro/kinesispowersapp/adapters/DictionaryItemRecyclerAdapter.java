package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.DictionaryItem;

/**
 * Created by Shiro on 09/01/2018.
 */

public class DictionaryItemRecyclerAdapter extends RecyclerView.Adapter<DictionaryItemRecyclerAdapter.ViewHolder>
            implements Filterable{

    private Context context;
    private List<DictionaryItem> dictionaryItemList;
    private List<DictionaryItem> dictionaryItemListFiltered;
    private OnDictionaryItemClickListener listener;

    public interface OnDictionaryItemClickListener{
        void onDictionaryItemClick(DictionaryItem dictionaryItem);
    }

    public void setOnDictionaryItemClickListener(OnDictionaryItemClickListener listener){
        this.listener= listener;
    }

    public DictionaryItemRecyclerAdapter(Context context, List<DictionaryItem> dictionaryItemList){
        this.context= context;
        this.dictionaryItemList= dictionaryItemList;
        this.dictionaryItemListFiltered= dictionaryItemList;
    }

    @Override
    public DictionaryItemRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dictionary_item_list_adapter,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DictionaryItemRecyclerAdapter.ViewHolder holder, int position) {
        final DictionaryItem dictionaryItem = dictionaryItemListFiltered.get(position);

        holder.dictionaryItemName.setText(dictionaryItem.getDiccionaryItemName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDictionaryItemClick(dictionaryItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dictionaryItemListFiltered.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView dictionaryItemName;
        public ViewHolder(View itemView) {
            super(itemView);
            dictionaryItemName= itemView.findViewById(R.id.textViewDiccionaryItemNameAdapter);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString= charSequence.toString();

                if(charString.isEmpty())
                    dictionaryItemListFiltered= dictionaryItemList;
                else{
                    List<DictionaryItem> filteredList= new ArrayList<>();
                    for(DictionaryItem item : dictionaryItemList){

                        if(item.getDiccionaryItemName().toLowerCase().contains(charString.toLowerCase())
                                || item.getDiccionaryItemName().toLowerCase().contains(charSequence))
                            filteredList.add(item);
                    }
                    dictionaryItemListFiltered= filteredList;
                }

                FilterResults results= new FilterResults();
                results.values= dictionaryItemListFiltered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                dictionaryItemListFiltered= (ArrayList<DictionaryItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
