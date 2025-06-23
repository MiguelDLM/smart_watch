package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public class VisibleStateFrameLayout extends FrameLayout {

    /* renamed from: XO, reason: collision with root package name */
    public VisibilityChanged f10471XO;

    /* loaded from: classes8.dex */
    public interface VisibilityChanged {
        void callback(boolean z);
    }

    public VisibleStateFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        VisibilityChanged visibilityChanged = this.f10471XO;
        if (visibilityChanged == null || view != this) {
            return;
        }
        visibilityChanged.callback(i == 0);
    }

    public void setVisibilityChanged(VisibilityChanged visibilityChanged) {
        this.f10471XO = visibilityChanged;
    }

    public VisibleStateFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisibleStateFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
