package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.DictionaryItem;

/**
 * Created by Shiro on 13/01/2018.
 */

public class Dictionary_ItemDefinitionRecyclerAdapter
            extends RecyclerView.Adapter<Dictionary_ItemDefinitionRecyclerAdapter.ViewHolder>{

    private Context context;
    private DictionaryItem dictionaryItem;

    public Dictionary_ItemDefinitionRecyclerAdapter(Context context, DictionaryItem dictionaryItem){
        this.context= context;
        this.dictionaryItem= dictionaryItem;
    }

    @Override
    public Dictionary_ItemDefinitionRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dictionary_item_definition_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Dictionary_ItemDefinitionRecyclerAdapter.ViewHolder holder, int position) {
        DictionaryItem dictionaryItem= this.dictionaryItem;

        holder.title.setText(dictionaryItem.getDiccionaryItemName());
        holder.definition.setText(dictionaryItem.getDiccionaryItemDescription());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView definition;

        public ViewHolder(View itemView) {
            super(itemView);

            title= itemView.findViewById(R.id.textViewDictionary_ItemTitleAdapter);
            definition= itemView.findViewById(R.id.textViewDictionary_ItemDescriptionAdapter);
        }
    }
}
