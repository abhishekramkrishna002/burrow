package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import in.burrow.Child;
import in.burrow.Group;
import in.burrow.R;

/**
 * Created by fasal on 26-07-2015.
 */
public class ExpandableListHistoryAdapter extends BaseExpandableListAdapter {
    private Activity activity;
    private ArrayList<Group> groups;

    public ExpandableListHistoryAdapter(Activity activity, ArrayList<Group> groups) {
        this.activity = activity;
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Child> chList = groups.get(groupPosition).getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child> chList = groups.get(groupPosition).getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Group group = (Group) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity
                    .getSystemService(activity.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.group_item, null);

        }
        ImageView categoryImage = (ImageView)
                convertView.findViewById(R.id.arrow);
        if (isExpanded) {
            categoryImage.setImageResource(R.drawable.up);

        } else {
            categoryImage.setImageResource(R.drawable.expand);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.group_name);
        TextView iv = (TextView) convertView.findViewById(R.id.group_number);
        tv.setText(group.getName());
        iv.setText(group.getNumber());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Child child = (Child) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) activity
                    .getSystemService(activity.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_child_screen2, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.history_name);
        ImageView iv = (ImageView) convertView.findViewById(R.id.flag);

        tv.setText(child.getName().toString());
        iv.setImageResource(child.getImage());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
