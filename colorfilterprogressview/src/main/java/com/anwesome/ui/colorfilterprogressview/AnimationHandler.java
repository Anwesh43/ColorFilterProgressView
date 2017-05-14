package com.anwesome.ui.colorfilterprogressview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 14/05/17.
 */
public class AnimationHandler extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener{
    private int dir = 0;
    private boolean isAnimating = false;
    private ColorFilterProgressView colorFilterProgressView;
    public AnimationHandler(ColorFilterProgressView colorFilterProgressView) {
        this.colorFilterProgressView = colorFilterProgressView;
    }
    private ValueAnimator upAnim = ValueAnimator.ofFloat(0,1),downAnim = ValueAnimator.ofFloat(1,0);
    {{
        upAnim.setDuration(500);
        downAnim.setDuration(500);
        upAnim.addUpdateListener(this);
        downAnim.addUpdateListener(this);
        upAnim.addListener(this);
        downAnim.addListener(this);
    }}
    private void startUpAnim() {
        upAnim.start();
    }
    private void startDownAnim() {
        downAnim.start();
    }
    public void startAnim() {
        if(!isAnimating) {
            if (dir == 0) {
                startUpAnim();
            } else {
                startDownAnim();
            }
            dir = dir == 0 ? 1 : 0;
        }
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float factor = (float)valueAnimator.getAnimatedValue();
        colorFilterProgressView.update(factor);
    }
    public void onAnimationEnd(Animator animator) {
        if(isAnimating) {
            isAnimating = false;
        }
    }
}
