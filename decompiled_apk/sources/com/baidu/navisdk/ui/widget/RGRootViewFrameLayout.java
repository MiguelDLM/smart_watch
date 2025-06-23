package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class RGRootViewFrameLayout extends FrameLayout {
    private WeakReference<ViewTreeObserver.OnGlobalLayoutListener> mListener;

    public RGRootViewFrameLayout(@NonNull Context context) {
        super(context);
    }

    public void addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.mListener = new WeakReference<>(onGlobalLayoutListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        WeakReference<ViewTreeObserver.OnGlobalLayoutListener> weakReference;
        super.onAttachedToWindow();
        if (getViewTreeObserver().isAlive() && (weakReference = this.mListener) != null && weakReference.get() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.mListener.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        WeakReference<ViewTreeObserver.OnGlobalLayoutListener> weakReference;
        super.onDetachedFromWindow();
        if (getViewTreeObserver().isAlive() && (weakReference = this.mListener) != null && weakReference.get() != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mListener.get());
        }
    }

    public RGRootViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RGRootViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
