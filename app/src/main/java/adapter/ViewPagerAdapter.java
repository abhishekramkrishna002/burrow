package adapter;

/**
 * Created by abhishek on 28-07-2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragments.AddTenantTabOne;
import fragments.AddTenantTabThree;
import fragments.AddTenantTabTwo;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[]) {
        super(fm);

        this.Titles = mTitles;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
                //AddTenantTabOne addTenantTabOne = new ;
                return new AddTenantTabOne();

            case 1:
                return new AddTenantTabTwo();

            case 2:
                return new AddTenantTabThree();

            default:
                return null;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return Titles.length;
    }
}