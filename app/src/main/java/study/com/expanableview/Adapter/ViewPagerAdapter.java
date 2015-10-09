package study.com.expanableview.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

import study.com.expanableview.Fragment.Fragment_EListView;
import study.com.expanableview.Fragment.Fragment_ERecyclerView;
import study.com.expanableview.Fragment.Fragment_Tab3;
import study.com.expanableview.Fragment.Fragment_Tab4;
import study.com.expanableview.Model.ParentObject;


/**
 * Created by mooqoo on 10/9/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final String TAG = "ViewPagerAdapter";

    String[] tabNameArray;
    List<ParentObject> parentList;

    //Constructor
    public ViewPagerAdapter(FragmentManager fm, String[] tabNameArray) {
        super(fm);
        this.tabNameArray = tabNameArray;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            Fragment_EListView tab1 = Fragment_EListView.newInstance();
            return tab1;
        }
        else if(position == 1 )
        {
            Fragment_ERecyclerView tab2 = Fragment_ERecyclerView.newInstance();
            return tab2;
        }
        else if(position == 2)
        {
            Fragment_Tab3 tab3 = Fragment_Tab3.newInstance();
            return tab3;
        }
        else if(position == 3)
        {
            Fragment_Tab4 tab4 = Fragment_Tab4.newInstance();
            return tab4;
        }
        else {
            Log.e(TAG,"getItem: invalid position. No Fragment exist!");
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNameArray[position];
    }

    @Override
    public int getCount() {
        return tabNameArray.length;
    }
}
