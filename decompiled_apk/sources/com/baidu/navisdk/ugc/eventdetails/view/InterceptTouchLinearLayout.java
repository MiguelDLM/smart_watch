package com.baidu.navisdk.ugc.eventdetails.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public class InterceptTouchLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private h f8081a;

    public InterceptTouchLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h hVar = this.f8081a;
        if (hVar != null && hVar.a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnInterceptTouchListener(h hVar) {
        this.f8081a = hVar;
    }

    public InterceptTouchLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptTouchLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
