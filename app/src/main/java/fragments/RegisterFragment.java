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
import android.widget.EditText;
import android.widget.LinearLayout;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import in.burrow.InitialActivity;
import in.burrow.MainActivity;
import in.burrow.R;


/**
 * Created by fasal on 21-07-2015.
 */
public class RegisterFragment extends Fragment {
    Activity activity;
    LinearLayout layoutTop, layoutBottom;
    EditText date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutTop = (LinearLayout) activity.findViewById(R.id.layout_top);
        layoutBottom = (LinearLayout) activity.findViewById(R.id.layout_bottom);
        final AwesomeValidation mAwesomeValidation = new AwesomeValidation(ValidationStyle.UNDERLABEL);
        mAwesomeValidation.setContext(activity);
        Button next = (Button) activity.findViewById(R.id.next);
        Button btcontinue = (Button) activity.findViewById(R.id.btContinue);
        date = (EditText) activity.findViewById(R.id.date_of_birth);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {

                                date.setText(i2 + "/" + i1 + "/" + i);

                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                dpd.show(activity.getFragmentManager(), "Datepickerdialog");

            }
        });
//      EditText  edit = (EditText)activity.findViewById(R.id.editTextName);
//        mAwesomeValidation.addValidation(edit, "[a-zA-Z\\s]+", "Field is required");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.next) {
                    mAwesomeValidation.validate();
                    if (mAwesomeValidation.validate() == true) {
                        layoutTop.setVisibility(v.GONE);
                    }
                }
            }
        });
        layoutTop.bringToFront();
        layoutTop.invalidate();
        btcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction ft = ((ActionBarActivity) activity).getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.fragment_container, new SelectFragment(), "login_fragment");
//                ft.commit();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });

    }
}
