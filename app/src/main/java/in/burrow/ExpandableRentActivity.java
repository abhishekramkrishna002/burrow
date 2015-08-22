package in.burrow;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import android.R;
import adapter.ExpandableListRentAdapter;


/**
 * Created by fasal on 26-07-2015.
 */
public class ExpandableRentActivity extends Activity {
    private ExpandableListRentAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_main_screen1);

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListRentAdapter(ExpandableRentActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


    }
    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Building 1", "Building 2"};
        String group_number[] = {"4", "4"};
        String person_names[] = {"Raghu", "Mahesh", "Croatia", "Cameroon", "Raghu", "Mahesh", "Croatia", "Cameroon"
        };

        int Images[] = {R.drawable.ic_face_black_24dp,R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp,
                R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp, R.drawable.ic_face_black_24dp,
                R.drawable.ic_face_black_24dp,R.drawable.ic_face_black_24dp};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 4;
        int j = 0;
        Group gru=null;
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


}