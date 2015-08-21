package in.burrow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.materialdialog.MaterialDialog;


public class AddTenantActivity extends ActionBarActivity {


    Activity activity;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.search_container)
    LinearLayout searchContainer;
    @Bind(R.id.search_edit_text)
    EditText searchEditText;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tenant_layout);
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

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().contains(".com")) {
                    if (s.toString().contentEquals("robert.james@gmail.com")) {
                        searchContainer.removeAllViews();
                        View view = LayoutInflater.from(AddTenantActivity.this).
                                inflate(R.layout.tenant_search_item, searchContainer, false);

                        searchContainer.addView(view);
                        fab.setImageResource(R.drawable.ic_check_white_24dp);
                    } else {
                        searchContainer.removeAllViews();
                        View view = LayoutInflater.from(AddTenantActivity.this).
                                inflate(R.layout.tenant_search_item_not_found, searchContainer, false);
                        ((Button) view.findViewById(R.id.invite_tenant)).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MaterialDialog mMaterialDialog = new MaterialDialog(AddTenantActivity.this).
                                        setView(LayoutInflater.from(AddTenantActivity.this).inflate(R.layout.send_invite_confirm, null, false));

                                mMaterialDialog.setPositiveButton("Yes",new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Intent intent=new Intent(AddTenantActivity.this,AddTenantActivityContd.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                
                                mMaterialDialog.setNegativeButton("No",new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                });
                                mMaterialDialog.show();
                            }
                        });
                        searchContainer.addView(view);
                        fab.setImageResource(R.drawable.ic_close_white_24dp);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
