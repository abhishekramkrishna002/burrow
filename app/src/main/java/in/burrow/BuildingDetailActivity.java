package in.burrow;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import adapter.FlatsAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.materialdialog.MaterialDialog;


public class BuildingDetailActivity extends ActionBarActivity {

    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
//    @Bind(R.id.flats_container)
//    LinearLayout flatsContainer;

    @Bind(R.id.list_flats)
    RecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_menu)
    Toolbar menuToolbar;
    @Bind(R.id.menu_container)
    LinearLayout menuConatiner;
    @Bind(R.id.back_icon)
    ImageButton backButton;
    @Bind(R.id.home_icon)
    ImageButton homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.building_detail_view);
        setContentView(R.layout.building_detail_view_new_1);
        ButterKnife.bind(this);
        /*
        set up action bar ::start
         */
//        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_apps_white_24dp));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(MainActivity.this,"you clicked",Toast.LENGTH_SHORT).show();
//                menuConatiner.setVisibility(View.VISIBLE);
//            }
//        });


        menuToolbar.setTitle("Menu");
        menuToolbar.setNavigationIcon(getDrawable(R.drawable.ic_close_white_24dp));
        menuToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuConatiner.setVisibility(View.GONE);


            }
        });


        setSupportActionBar(toolbar);
//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(getDrawable(R.drawable.ic_chevron_left_white_24dp));
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setIcon(getDrawable(R.drawable.ic_apps_white_24dp));


        collapsingToolbarLayout.setTitle("Flats");

        /*
        set up action bar ::end
         */
        Snackbar.make(floatingActionButton, "To add new flat press on the add button", Snackbar.LENGTH_LONG).show();
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        for (int i = 0; i < 4; i++) {
//            View view = layoutInflater.inflate(R.layout.flat_list_item, flatsContainer, false);
//            ((TextView) view.findViewById(R.id.index_flat)).setText(i + 1 + "");
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(BuildingDetailActivity.this,AddTenantActivity.class);
//                    startActivity(intent);
//                }
//            });
//            flatsContainer.addView(view);
//        }
//
        recyclerView.setAdapter(new FlatsAdapter(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @OnClick(R.id.back_icon)
    public void backButton(View v) {
        finish();
    }

    @OnClick(R.id.home_icon)
    public void homeButton(View v) {
        menuConatiner.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_1, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intent = new Intent(BuildingDetailActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
        }
        return true;
    }

    MaterialDialog mMaterialDialog;

    @OnClick(R.id.fab)
    public void addFlat(View view) {
        mMaterialDialog = new MaterialDialog(this);
        View v = LayoutInflater.from(this).inflate(R.layout.flat_add_layout, null, false);
        (v.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
            }
        });
        mMaterialDialog.setView(v);
        mMaterialDialog.show();
    }

}
