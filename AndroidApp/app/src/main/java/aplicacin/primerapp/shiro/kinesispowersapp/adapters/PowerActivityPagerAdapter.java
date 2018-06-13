package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import aplicacin.primerapp.shiro.kinesispowersapp.fragments.Power_Definition_Fragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.Power_ExercisesFragment;
import aplicacin.primerapp.shiro.kinesispowersapp.fragments.Power_VideosFragment;

/**
 * Created by Shiro on 11/01/2018.
 */

public class PowerActivityPagerAdapter extends FragmentStatePagerAdapter {

    private int countTabs;

    public PowerActivityPagerAdapter(FragmentManager fm, int countTabs) {
        super(fm);
        this.countTabs= countTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Power_Definition_Fragment();
            case 1:
                return new Power_ExercisesFragment();
            case 2:
                return new Power_VideosFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTabs;
    }
}
