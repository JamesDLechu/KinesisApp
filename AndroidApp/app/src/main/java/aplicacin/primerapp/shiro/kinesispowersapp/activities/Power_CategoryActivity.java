package aplicacin.primerapp.shiro.kinesispowersapp.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import aplicacin.primerapp.shiro.kinesispowersapp.Contact;
import aplicacin.primerapp.shiro.kinesispowersapp.ContactsAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.AllPowersRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.PowerCategory_ItemRecyclerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerCategoryModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Power_Exercise;

public class Power_CategoryActivity extends AppCompatActivity{

    public static final String categoryModelKEY= "categoryModel_KEY";
    private SearchView searchView;
    private AllPowersRecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power__category);

        Bundle extras = getIntent().getExtras();
        PowerCategoryModel category = extras.getParcelable(categoryModelKEY);

        Toolbar toolbar = findViewById(R.id.toolbarPowerCategoryActivity);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarPowerCategoryActivity);
        collapsingToolbarLayout.setTitle(category.getPowerCategoryModelName());

        ImageView imageView = findViewById(R.id.imageViewPowerCategoryActivity);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, category.getPowerCategoryModelImage()));

        recyclerView = findViewById(R.id.recyclerViewPowerCategoryActivity);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(this, 2);
        adapter = new AllPowersRecyclerAdapter(this, category.getPowerCategoryModelListItems());

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnPowerItemClickListener(new AllPowersRecyclerAdapter.OnPowerItemClickListener() {
            @Override
            public void onPowerItemClick(PowerModel powerModel) {
                Intent intent= new Intent(Power_CategoryActivity.this, PowerActivity.class);
                intent.putExtra(PowerActivity.PowerTypeKEY, powerModel);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.searchButton).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.searchButton).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.searchButton:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified()){
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}
