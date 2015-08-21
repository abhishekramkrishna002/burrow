package fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.burrow.MainActivity;
import in.burrow.R;


/**
 * Created by fasal on 21-07-2015.
 */
public class SelectFragment extends Fragment {
    Activity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.select_type,container,false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btOwner = (Button) activity.findViewById(R.id.btOwner);
        btOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = ((ActionBarActivity) activity).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new HowItWorksFragment());
                ft.commit();
//                 Intent intent=new Intent(getActivity(), MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}
