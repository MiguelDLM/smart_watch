package com.baidu.navisdk.module.future.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes7.dex */
public class FutureTripYellowBannerContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private a f7181a;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a();
    }

    public FutureTripYellowBannerContainer(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f7181a;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setInterceptListener(a aVar) {
        this.f7181a = aVar;
    }

    public FutureTripYellowBannerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FutureTripYellowBannerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
