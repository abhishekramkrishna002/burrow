package in.burrow;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;
    @Bind(R.id.toolbar_title)
    TextView toolBarTitle;
    @Bind(R.id.buildings_container)
    LinearLayout buildingsContainer;
    Activity activity;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.menu_container)
    LinearLayout menuConatiner;
    @Bind(R.id.toolbar_menu)
    Toolbar menuToolbar;

    @Bind(R.id.profile)
    LinearLayout profile;
    @Bind(R.id.notifcation)
    LinearLayout notifications;
    @Bind(R.id.sent)
    LinearLayout sentHistory;
    @Bind(R.id.rent_overview)
    LinearLayout rentOverview;

    @OnClick(R.id.sent)
    public void showSent(View v)
    {
        Intent intent=new Intent(MainActivity.this,ExpandableHistoryActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.notifcation)
    public void showNotifications(View v)
    {
        Intent intent=new Intent(MainActivity.this,ExpandableNotificationsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activity = this;
         /*
        set up action bar ::start
         */
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_apps_white_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"you clicked",Toast.LENGTH_SHORT).show();
                menuConatiner.setVisibility(View.VISIBLE);
            }
        });
        Typeface customFont = Typeface.createFromAsset(getAssets(), "burrow_font.ttf");
        toolBarTitle.setTypeface(customFont);


        menuToolbar.setTitle("Menu");
        menuToolbar.setNavigationIcon(getDrawable(R.drawable.ic_close_white_24dp));
        menuToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuConatiner.setVisibility(View.GONE);


            }
        });


        /*
        set up action bar ::end
         */


        Snackbar.make(floatingActionButton, "To add new building press on the add button", Snackbar.LENGTH_LONG).show();
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        for (int i = 0; i < 4; i++) {
            View view = layoutInflater.inflate(R.layout.building_list_item, buildingsContainer, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), BuildingDetailActivity.class);
                    Pair<View, String> p1 = Pair.create(v, "profile");
//                    Pair<View, String> p2 = Pair.create((View)floatingActionButton, "fab");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity, p1);
//                    ActivityOptionsCompat options = ActivityOptionsCompat.
//                            makeSceneTransitionAnimation(activity, v, "profile");


                    startActivity(intent, options.toBundle());
                }
            });
            buildingsContainer.addView(view);
        }


    }

    @OnClick(R.id.fab)
    public void addBuilding(View view) {

        Intent intent = new Intent(this, BuildingAddActivity.class);
        Pair<View, String> p1 = Pair.create(view, "fab");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(activity, p1);
        startActivity(intent,options.toBundle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {

            case R.id.action_search :
                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                return  true;
        }
        return true;
    }


}
