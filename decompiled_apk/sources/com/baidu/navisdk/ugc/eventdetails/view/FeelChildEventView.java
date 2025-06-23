package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public class FeelChildEventView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private h f8080a;

    public FeelChildEventView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h hVar = this.f8080a;
        if (hVar != null && hVar.a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnInterceptCallback(h hVar) {
        this.f8080a = hVar;
    }

    public FeelChildEventView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeelChildEventView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
