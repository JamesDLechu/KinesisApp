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
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.Dictionary_ItemDefinitionRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.DictionaryItem;

public class Dictionary_ItemDefinitionActivity extends AppCompatActivity {

    public static final String dictionaryItemKEY= "item_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary__item_definition);

        Bundle extras= getIntent().getExtras();
        DictionaryItem dictionaryItem= extras.getParcelable(dictionaryItemKEY);

        Toolbar toolbar= findViewById(R.id.toolbarDictionaryItemActivity);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getWindow().getContext().getResources().getColor(android.R.color.black));

        RecyclerView recyclerView= findViewById(R.id.recyclerViewDictionary_ItemActivity);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        Dictionary_ItemDefinitionRecyclerAdapter adapter=
                new Dictionary_ItemDefinitionRecyclerAdapter(this, dictionaryItem);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
