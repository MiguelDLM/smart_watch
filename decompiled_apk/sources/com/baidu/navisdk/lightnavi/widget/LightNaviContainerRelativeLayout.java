package com.baidu.navisdk.lightnavi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.navisdk.ui.widget.BNUIBoundRelativeLayout;

/* loaded from: classes7.dex */
public class LightNaviContainerRelativeLayout extends BNUIBoundRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private a f6894a;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public LightNaviContainerRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f6894a != null && isShown()) {
            this.f6894a.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnTouchCallBack(a aVar) {
        this.f6894a = aVar;
    }

    public LightNaviContainerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LightNaviContainerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
