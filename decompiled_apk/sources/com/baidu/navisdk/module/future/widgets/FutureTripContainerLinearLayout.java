package com.baidu.navisdk.module.future.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes7.dex */
public class FutureTripContainerLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private a f7172a;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public FutureTripContainerLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f7172a != null && isShown()) {
            this.f7172a.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnTouchCallBack(a aVar) {
        this.f7172a = aVar;
    }

    public FutureTripContainerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FutureTripContainerLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
