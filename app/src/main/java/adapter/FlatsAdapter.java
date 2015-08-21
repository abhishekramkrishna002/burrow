package adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.burrow.AddTenantActivity;
import in.burrow.BuildingDetailActivity;
import in.burrow.ProfileTenantActivity;
import in.burrow.R;

/**
 * Created by abhishek on 29-07-2015.
 */
public class FlatsAdapter extends RecyclerView.Adapter<FlatsAdapter.FlatViewHolder> {

    Activity activity;

    public FlatsAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public FlatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View flatItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.flat_list_item, parent, false);

        return new FlatViewHolder(flatItem);

    }

    @Override
    public void onBindViewHolder(FlatViewHolder holder, int position) {

        ((TextView) (holder.view).findViewById(R.id.index_flat)).setText(position + 1 + "");


        if (position > 0) {
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, AddTenantActivity.class);
                    activity.startActivity(intent);
                }
            });
        }
        if(position==0){
            TextView tenantName=((TextView) (holder.view).findViewById(R.id.tenant_name));
            tenantName.setText("Robert James");
            tenantName.setTextColor(activity.getResources().getColor(R.color.black));
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, ProfileTenantActivity.class);
                    activity.startActivity(intent);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FlatViewHolder extends RecyclerView.ViewHolder {


        public View view;

        public FlatViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;


        }

    }
}
