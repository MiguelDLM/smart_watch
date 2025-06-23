package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes13.dex */
public class a extends RelativeLayout {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String f26943Oxx0xo = "com.tencent.open.b.a";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oIX0oI f26944IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f26945Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Rect f26946XO;

    /* loaded from: classes13.dex */
    public interface oIX0oI {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.f26946XO = null;
        this.f26945Oo = false;
        this.f26944IXxxXO = null;
        this.f26946XO = new Rect();
    }

    public void oIX0oI(oIX0oI oix0oi) {
        this.f26944IXxxXO = oix0oi;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f26946XO);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f26946XO.top) - size;
        oIX0oI oix0oi = this.f26944IXxxXO;
        if (oix0oi != null && size != 0) {
            if (height > 100) {
                oix0oi.a((Math.abs(this.f26946XO.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                oix0oi.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
