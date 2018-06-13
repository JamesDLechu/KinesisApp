package aplicacin.primerapp.shiro.kinesispowersapp.adapters.BottomNavigationView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Shiro on 08/01/2018.
 */

public class NoSwipeViewPager extends ViewPager {
    private boolean enabled;

    public NoSwipeViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        enabled= true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.enabled && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.enabled && super.onInterceptTouchEvent(ev);
    }

    public void setPagingEnabled(boolean enabled){
        this.enabled= enabled;
    }
}
