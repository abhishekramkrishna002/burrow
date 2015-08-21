package in.burrow;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragments.HowItWorksFragment;
import fragments.SelectFragment;
import fragments.SplashFragment;


public class InitialActivity extends ActionBarActivity {
    LinearLayout layoutTop, layoutBottom;
    static FragmentManager fm = null;
    private static int SPLASH_TIME_OUT = 4000;
    public static Activity activity;
    EditText edit;
    // LayoutInflater li=getLayoutInflater();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main_init);
        activity = this;


        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new SplashFragment());
        ft.commit();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                //ft.replace(R.id.fragment_container, new HowItWorksFragment());
                ft.replace(R.id.fragment_container, new SelectFragment());
                ft.commit();

            }
        }, SPLASH_TIME_OUT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        activity.getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
