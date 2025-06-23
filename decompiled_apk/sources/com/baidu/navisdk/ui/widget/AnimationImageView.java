package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public class AnimationImageView extends ImageView {

    /* loaded from: classes8.dex */
    public interface OnFrameAnimationListener {
        void onEnd();

        void onStart();
    }

    public AnimationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadAnimation(int i) {
        setImageResource(i);
        ((AnimationDrawable) getDrawable()).start();
    }

    public AnimationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimationImageView(Context context) {
        super(context);
    }

    public void loadAnimation(int i, final OnFrameAnimationListener onFrameAnimationListener) {
        setImageResource(i);
        AnimationDrawable animationDrawable = (AnimationDrawable) getDrawable();
        animationDrawable.start();
        if (onFrameAnimationListener != null) {
            onFrameAnimationListener.onStart();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < animationDrawable.getNumberOfFrames(); i3++) {
            i2 += animationDrawable.getDuration(i3);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.navisdk.ui.widget.AnimationImageView.1
            @Override // java.lang.Runnable
            public void run() {
                OnFrameAnimationListener onFrameAnimationListener2 = onFrameAnimationListener;
                if (onFrameAnimationListener2 != null) {
                    onFrameAnimationListener2.onEnd();
                }
            }
        }, i2);
    }
}
