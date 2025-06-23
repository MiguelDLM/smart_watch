package com.baidu.navisdk.ui.widget.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;

/* loaded from: classes8.dex */
public class BNSwipeView extends LinearLayout implements BNVoiceCircleProgressBarCallback {
    private BNVoiceCircleProgressBarCallback mProgressBarCallback;

    public BNSwipeView(Context context) {
        super(context);
        setupViews();
    }

    private void setupViews() {
        setOrientation(0);
        setGravity(17);
    }

    public void setGuidanceView(View view) {
        if (view == null) {
            return;
        }
        removeAllViews();
        addView(view, new LinearLayout.LayoutParams(-1, -1));
    }

    public void setProgressBarCallback(BNVoiceCircleProgressBarCallback bNVoiceCircleProgressBarCallback) {
        this.mProgressBarCallback = bNVoiceCircleProgressBarCallback;
    }

    @Override // com.baidu.navisdk.ui.widget.loadmore.BNVoiceCircleProgressBarCallback
    public void setProgressRotation(float f) {
        BNVoiceCircleProgressBarCallback bNVoiceCircleProgressBarCallback = this.mProgressBarCallback;
        if (bNVoiceCircleProgressBarCallback != null) {
            bNVoiceCircleProgressBarCallback.setProgressRotation(f);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.loadmore.BNVoiceCircleProgressBarCallback
    public void setStartEndTrim(float f, float f2) {
        BNVoiceCircleProgressBarCallback bNVoiceCircleProgressBarCallback = this.mProgressBarCallback;
        if (bNVoiceCircleProgressBarCallback != null) {
            bNVoiceCircleProgressBarCallback.setStartEndTrim(f, f2);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.loadmore.BNVoiceCircleProgressBarCallback
    public void startAnimation() {
        BNVoiceCircleProgressBarCallback bNVoiceCircleProgressBarCallback = this.mProgressBarCallback;
        if (bNVoiceCircleProgressBarCallback != null) {
            bNVoiceCircleProgressBarCallback.startAnimation();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.loadmore.BNVoiceCircleProgressBarCallback
    public void stopAnimation() {
        BNVoiceCircleProgressBarCallback bNVoiceCircleProgressBarCallback = this.mProgressBarCallback;
        if (bNVoiceCircleProgressBarCallback != null) {
            bNVoiceCircleProgressBarCallback.stopAnimation();
        }
    }

    public BNSwipeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupViews();
    }

    public void setGuidanceView(@LayoutRes int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null);
        if (inflate == null) {
            return;
        }
        removeAllViews();
        addView(inflate, new LinearLayout.LayoutParams(-1, -1));
    }

    public BNSwipeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupViews();
    }
}
