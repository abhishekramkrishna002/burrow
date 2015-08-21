package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.burrow.R;

/**
 * Created by abhishek on 28-07-2015.
 */
public class AddTenantTabThree extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_tenant_tab_three, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView=(TextView)getActivity().findViewById(R.id.conditions_list);
        String listItems="1: condition 1 goes here<br><br>2: condition 2 goes here<br><br>3: condition 3 goes here<br><br>";
        textView.setText(Html.fromHtml(listItems));
    }
}
