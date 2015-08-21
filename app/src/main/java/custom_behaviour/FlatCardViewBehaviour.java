package custom_behaviour;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by abhishek on 10-08-2015.
 */
public class FlatCardViewBehaviour extends CoordinatorLayout.Behavior<CardView> {
    public FlatCardViewBehaviour(Context context, AttributeSet attributeSet)
    {

    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CardView child, View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CardView child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
