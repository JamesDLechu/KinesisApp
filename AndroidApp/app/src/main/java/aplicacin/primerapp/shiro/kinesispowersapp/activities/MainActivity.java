package aplicacin.primerapp.shiro.kinesispowersapp.activities;

import android.app.SearchManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.BottomNavigationView.BottomBarAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.BottomNavigationView.NoSwipeViewPager;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.AllPowersFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.DictionaryFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.MainFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.Movies_and_SeriesFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener{

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private NoSwipeViewPager viewPager;
    private BottomBarAdapter bottomAdapter;
    private SearchView searchView;

    private int HIDE_MENU= 0;
    private int SHOW_SEARCH_MENU= 1;
    private int menuState= HIDE_MENU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigationView= findViewById(R.id.navigationViewMain);
        drawerLayout= findViewById(R.id.drawerLayoutMain);
        viewPager= findViewById(R.id.viewPagerMainActivity);
        bottomAdapter= new BottomBarAdapter(getSupportFragmentManager());
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigationViewMainActivity);

        bottomAdapter.addFragments(new MainFragment());
        bottomAdapter.addFragments(new DictionaryFragment());
        bottomAdapter.addFragments(new Movies_and_SeriesFragment());

        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(bottomAdapter);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.addDrawerListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuState= HIDE_MENU;
                invalidateOptionsMenu();

                switch (item.getItemId()){
                    case R.id.bottomNavViewHome:
                        viewPager.setCurrentItem(0);
                        AllPowersFragment.loadData("");
                        break;
                    case R.id.bottomNavViewDiccionary:
                        viewPager.setCurrentItem(1);
                        menuState= SHOW_SEARCH_MENU;
                        DictionaryFragment.loadData("");
                        invalidateOptionsMenu();
                        break;
                    case R.id.bottomNavViewMoviesAndSeries:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        boolean fragmentTransaction= false;
        Fragment fragment= null;

        switch (item.getItemId()){
            case R.id.navMenuPrincipal:
                break;
            case R.id.navMenuDiccionario:
                break;
            case R.id.navMenuInfo:
                break;
        }

        if(fragmentTransaction){
            createFragment(fragment,item);
            drawerLayout.closeDrawers();
        }

        return true;
    }

    private BottomNavigationView setFragmentByDefault(){
        viewPager.setCurrentItem(0);
        return null;
    }

    private void createFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.viewPagerMainActivity,fragment)
                .commit();
        item.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.searchButton).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                AllPowersFragment.loadData(query);
                DictionaryFragment.loadData(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                AllPowersFragment.loadData(query);
                DictionaryFragment.loadData(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                return true;
            case R.id.searchButton:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(menuState == SHOW_SEARCH_MENU){
            menu.findItem(R.id.searchButton).setVisible(true);
        }
        return true;
    }

    //Quit searchable action
    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {}

    @Override
    public void onDrawerOpened(View drawerView) {}

    @Override
    public void onDrawerClosed(View drawerView) {}

    @Override
    public void onDrawerStateChanged(int newState) {}
}
