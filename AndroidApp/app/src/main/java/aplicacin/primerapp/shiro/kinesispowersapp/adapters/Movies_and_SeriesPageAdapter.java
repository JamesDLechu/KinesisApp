package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import aplicacin.primerapp.shiro.kinesispowersapp.fragments.MoviesFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.SeriesFragment;

/**
 * Created by Shiro on 11/01/2018.
 */

public class Movies_and_SeriesPageAdapter extends FragmentStatePagerAdapter{

    private int tabCount;

    public Movies_and_SeriesPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MoviesFragment();
            case 1:
                return new SeriesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
