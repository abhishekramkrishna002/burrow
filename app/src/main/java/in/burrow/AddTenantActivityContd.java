package in.burrow;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import adapter.ViewPagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import custom_view.SlidingTabLayout;
import me.drakeet.materialdialog.MaterialDialog;


public class AddTenantActivityContd extends ActionBarActivity {


    Activity activity;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pager)
    ViewPager viewPager;
    @Bind(R.id.tabs)
    SlidingTabLayout tabs;
//    @Bind(R.id.search_container)
//    LinearLayout searchContainer;
//    @Bind(R.id.search_edit_text)
//    EditText searchEditText;
//    @Bind(R.id.fab)
//    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tenant_layout_cont);
        ButterKnife.bind(this);
        activity = this;
         /*
        set up action bar ::start
         */
        setSupportActionBar(toolbar);

        // getSupportActionBar().setIcon(getDrawable(R.drawable.ic_apps_white_24dp));
        getSupportActionBar().setTitle("Add Tenant");
        getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.ic_chevron_left_white_24dp));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        set up action bar ::end
         */

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), new String[]{"1", "2", "3"}));
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


}
