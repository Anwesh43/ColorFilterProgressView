package com.anwesome.ui.colorfilterprogressview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by anweshmishra on 14/05/17.
 */
public class CFPVList {
    private Activity activity;
    private ScrollView scrollView;
    private CFPVLayout cfpvLayout;
    private boolean isShown = false;
    public CFPVList(Activity activity) {
        this.activity = activity;
        cfpvLayout = new CFPVLayout(activity);
        scrollView = new ScrollView(activity);
        scrollView.addView(cfpvLayout,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addImage(Bitmap bitmap,int...color) {
        if(!isShown) {
            cfpvLayout.addImage(bitmap, color);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(cfpvLayout);
            isShown = true;
        }
    }
}
