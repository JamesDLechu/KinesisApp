package aplicacin.primerapp.shiro.kinesispowersapp.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.adapters.PowerActivityPagerAdapter;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.Power_Definition_Fragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.Power_ExercisesFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerCategoryModel;
import aplicacin.primerapp.shiro.kinesispowersapp.models.PowerModel;

public class PowerActivity extends AppCompatActivity {

    public static String PowerTypeKEY= "powerTypeKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);

        Toolbar toolbar= findViewById(R.id.toolbarPower);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Bundle extras= getIntent().getExtras();
        PowerModel powerModel= extras.getParcelable(PowerTypeKEY);

        Bundle args= new Bundle();
        args.putParcelable(Power_Definition_Fragment.powerKEY, powerModel);
        Power_Definition_Fragment.putArguments(args);
        Power_ExercisesFragment.putArguments(args);

        CollapsingToolbarLayout collapsingToolbarLayout= findViewById(R.id.collapsingToolbarPower);
        collapsingToolbarLayout.setTitle(powerModel.getPowerModelName());

        ImageView powerImage= findViewById(R.id.imageViewPowerActivity);
        powerImage.setImageDrawable(ContextCompat.getDrawable(this, powerModel.getPowerModelImage()));

        TabLayout tabLayout= findViewById(R.id.tabLayoutPowerActivity);
        tabLayout.addTab(tabLayout.newTab().setText("¿Qué es?"));
        tabLayout.addTab(tabLayout.newTab().setText("Ejercicios"));
        tabLayout.addTab(tabLayout.newTab().setText("Vídeos"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager= findViewById(R.id.viewPagerPowerActivity);
        viewPager.setAdapter(new PowerActivityPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(2);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
