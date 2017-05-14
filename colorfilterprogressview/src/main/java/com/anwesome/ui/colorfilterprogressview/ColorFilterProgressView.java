package com.anwesome.ui.colorfilterprogressview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 14/05/17.
 */
public class ColorFilterProgressView extends View {
    private Bitmap bitmap;
    private int color = Color.WHITE,render = 0,w,h;
    private float maxL = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ColorFilterRect colorFilterRect = new ColorFilterRect();
    private ProgressBar progressBar = new ProgressBar();
    private AnimationHandler animationHandler;
    public ColorFilterProgressView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
        this.animationHandler = new AnimationHandler(this);
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void onDraw(Canvas canvas) {
        if(render == 0) {
            w = canvas.getWidth();
            h = canvas.getHeight();
            bitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
        }
        canvas.drawBitmap(bitmap,0,0,paint);
        colorFilterRect.draw(canvas);
        progressBar.draw(canvas);
        render++;
    }
    public void update(float factor) {
        maxL = w*factor;
        postInvalidate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            animationHandler.startAnim();
        }
        return true;
    }
    private class ColorFilterRect {

        public void draw(Canvas canvas) {
            paint.setColor(Color.argb(130,Color.red(color),Color.green(color),Color.blue(color)));
            canvas.drawRect(new RectF(0,0,maxL,h),paint);
        }
    }
    private class ProgressBar {
        public void draw(Canvas canvas) {
            paint.setStrokeWidth(h/30);
            paint.setColor(Color.RED);
            canvas.drawLine(0,h-paint.getStrokeWidth(),maxL,h-paint.getStrokeWidth(),paint);
        }
    }
}
