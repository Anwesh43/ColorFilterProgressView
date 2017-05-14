package com.anwesome.ui.colorfilterprogressview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 14/05/17.
 */
public class CFPVLayout extends ViewGroup {
    private int w,h,gap;
    public void onMeasure(int wspec,int hspec) {
        int newH = gap;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
            if(i % 3 == 2) {
                newH += 2*gap;
            }
        }
        if(getChildCount()%3 != 0) {
            newH += 2*gap;
        }
        setMeasuredDimension(w,Math.max(w,newH));
    }
    public void addImage(Bitmap bitmap,int...color) {
        ColorFilterProgressView colorFilterProgressView = new ColorFilterProgressView(getContext(),bitmap);
        if(color.length == 1) {
            colorFilterProgressView.setColor(color[0]);
        }
        addView(colorFilterProgressView,new LayoutParams(gap,gap));
        requestLayout();
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int x = gap,y = h/20;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            child.layout(x,y,x+gap,y+gap);
            if(i%3 == 2) {
                x = gap;
                y += 2*gap;
            }
            else {
                x += 2*gap;
            }
        }
    }
    public CFPVLayout(Context context) {
        super(context);
        initDimension(context);
    }
    public void initDimension(Context context) {
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
            gap = w/7;
        }
    }
}
