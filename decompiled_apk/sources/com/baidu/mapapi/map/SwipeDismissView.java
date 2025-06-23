package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mapapi.map.WearMapView;

/* loaded from: classes7.dex */
public class SwipeDismissView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    WearMapView.OnDismissCallback f5862a;

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.f5862a = null;
        a(context, view);
    }

    public void a(Context context, View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new ae(this)));
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.f5862a = onDismissCallback;
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.f5862a = null;
        a(context, view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i, View view) {
        super(context, attributeSet, i);
        this.f5862a = null;
        a(context, view);
    }
}
