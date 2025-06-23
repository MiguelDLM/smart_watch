package com.baidu.navisdk.module.future.panel.histrogram;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class FutureTripLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    private b f7170a;

    /* loaded from: classes7.dex */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            if (FutureTripLinearLayoutManager.this.f7170a != null && FutureTripLinearLayoutManager.this.f7170a.b()) {
                if (LogUtil.LOGGABLE && FutureTripLinearLayoutManager.this.f7170a.a() <= 1.0f) {
                    LogUtil.e("calculateSpeedPerPixel", "你确定设置为这样快速的么");
                }
                return super.calculateSpeedPerPixel(displayMetrics) * FutureTripLinearLayoutManager.this.f7170a.a();
            }
            return super.calculateSpeedPerPixel(displayMetrics);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        float a();

        boolean b();
    }

    public FutureTripLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i);
        startSmoothScroll(aVar);
    }
}
