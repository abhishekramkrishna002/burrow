package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import adapter.WorkAdapter;
import in.burrow.R;


/**
 * Created by fasal on 10-07-2015.
 */
public class HowItWorksFragment extends Fragment {
    Activity activity;
    ViewPager viewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_tab_layout, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        this.activity = activity;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewpager = (ViewPager) activity.findViewById(R.id.pager);
        viewpager.setAdapter(new WorkAdapter(activity));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               // Toast.makeText(activity, "new page " + position, Toast.LENGTH_SHORT).show();
                ((ImageView) activity.findViewById(R.id.index_1)).setImageResource(R.drawable.empty_circel);
                ((ImageView) activity.findViewById(R.id.index_2)).setImageResource(R.drawable.empty_circel);
                ((ImageView) activity.findViewById(R.id.index_3)).setImageResource(R.drawable.empty_circel);
                switch (position) {
                    case 0:
                        ((ImageView) activity.findViewById(R.id.index_1)).setImageResource(R.drawable.full_circle);
                        break;
                    case 1:
                        ((ImageView) activity.findViewById(R.id.index_2)).setImageResource(R.drawable.full_circle);
                        break;
                    case 2:
                        ((ImageView) activity.findViewById(R.id.index_3)).setImageResource(R.drawable.full_circle);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
