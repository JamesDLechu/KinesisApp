package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import aplicacin.primerapp.shiro.kinesispowersapp.fragments.AllPowersFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.PowerCategoryFragment;

/**
 * Created by Shiro on 05/01/2018.
 */

public class MainPageAdapter extends FragmentStatePagerAdapter {

    private int countTabs;

    public MainPageAdapter(FragmentManager fm, int countTabs){
        super(fm);
        this.countTabs= countTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PowerCategoryFragment();
            case 1:
                return new AllPowersFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTabs;
    }
}
