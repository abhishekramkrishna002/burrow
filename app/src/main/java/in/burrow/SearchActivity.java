package in.burrow;

import android.app.Activity;
import android.content.Intent;
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
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import custom_view.SlidingTabLayout;


public class SearchActivity extends ActionBarActivity {


    Activity activity;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        ButterKnife.bind(this);
        activity = this;
         /*
        set up action bar ::start
         */
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.ic_chevron_left_white_24dp));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search Activity");
        /*
        set up action bar ::end
         */




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {

            case android.R.id.home :
                finish();
                return  true;
        }
        return true;
    }
}
