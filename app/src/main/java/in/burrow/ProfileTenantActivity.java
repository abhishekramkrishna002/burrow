package in.burrow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import adapter.ProfileViewPagerAdapter;
import adapter.ViewPagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_view.SlidingTabLayout;


public class ProfileTenantActivity extends ActionBarActivity {


    Activity activity;
    @Bind(R.id.menu_container)
    LinearLayout menuConatiner;
    @Bind(R.id.back_icon)
    ImageButton backButton;
    @Bind(R.id.home_icon)
    ImageButton homeButton;
    @Bind(R.id.toolbar_menu)
    Toolbar menuToolbar;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pager)
    ViewPager viewPager;
    @Bind(R.id.tabs)
    SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_tenant_layout);
        ButterKnife.bind(this);
        activity = this;
         /*
        set up action bar ::start
         */
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("Flat Name");
        menuToolbar.setTitle("Menu");
        menuToolbar.setNavigationIcon(getDrawable(R.drawable.ic_close_white_24dp));
        menuToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuConatiner.setVisibility(View.GONE);


            }
        });
//        getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.ic_chevron_left_white_24dp));
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_apps_white_24dp));
//        getSupportActionBar().setTitle("Flat Name");
        /*
        set up action bar ::end
         */

        viewPager.setAdapter(new ProfileViewPagerAdapter(
                getSupportFragmentManager(),
                new String[]{"summary".toUpperCase(), "rent".toUpperCase()}));
        tabs.setDistributeEvenly(true);
        tabs.setBackgroundColor(getResources().getColor(R.color.green));
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.yellow);
            }
        });
        tabs.setViewPager(viewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
        //return true;
    }

    @OnClick(R.id.back_icon)
    public void backButton(View v) {
        finish();
    }

    @OnClick(R.id.home_icon)
    public void homeButton(View v) {
        menuConatiner.setVisibility(View.VISIBLE);
    }


}
