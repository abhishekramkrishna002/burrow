package in.burrow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.ExpandableListAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by fasal on 26-07-2015.
 */
public class ExpandableNotificationsActivity extends ActionBarActivity {
    private ExpandableListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.back_icon)
    ImageButton backButton;
    @Bind(R.id.home_icon)
    ImageButton homeButton;
    @Bind(R.id.title)
    TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_main_screen1);
        ButterKnife.bind(this);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(ExpandableNotificationsActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        titleTextView.setText("Notifications");
        //setSupportActionBar(toolbar);


    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Building 1", "Building 2"};
        String group_number[] = {"4", "4"};
        String person_names[] = {"Raghu", "Mahesh", "Croatia", "Cameroon", "Raghu", "Mahesh", "Croatia", "Cameroon"
        };

        int Images[] = {R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp,
                R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp,
                R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 4;
        int j = 0;
        Group gru = null;
        for (String group_name : group_names) {
            //Group fru=null;
            gru = new Group();

            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(person_names[j]);
                ch.setImage(Images[j]);
                ch_list.add(ch);
            }

            for (String group_numbers : group_number) {

                gru.setNumber(group_numbers);

            }
            gru.setItems(ch_list);
            list.add(gru);
            size = size + 4;
        }


        return list;
    }

    @OnClick(R.id.back_icon)
    public void backButton(View v) {
        finish();
    }

    @OnClick(R.id.home_icon)
    public void homeButton(View v) {
        // menuConatiner.setVisibility(View.VISIBLE);
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
                Intent intent = new Intent(ExpandableNotificationsActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
        }
        return true;
    }


}