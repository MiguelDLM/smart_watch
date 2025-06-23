package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class BNUIBoundRelativeLayout extends RelativeLayout {
    private UIBounderProxy mUIBounderProxy;

    /* loaded from: classes8.dex */
    public static class UIBounderProxy {
        private WeakReference<ViewTreeObserver.OnGlobalLayoutListener> mListener;
        private ViewGroup mOwner;
        private boolean mAlreadySetListener = false;
        private boolean mAlreadyAttachedToWindow = false;

        public UIBounderProxy(ViewGroup viewGroup) {
            this.mOwner = viewGroup;
        }

        private void addGlobalLayoutListener() {
            WeakReference<ViewTreeObserver.OnGlobalLayoutListener> weakReference;
            if (!this.mAlreadySetListener && (weakReference = this.mListener) != null && weakReference.get() != null && this.mOwner.getViewTreeObserver().isAlive()) {
                this.mOwner.getViewTreeObserver().addOnGlobalLayoutListener(this.mListener.get());
                this.mAlreadySetListener = true;
            }
        }

        public void onAttachedToWindow() {
            this.mAlreadyAttachedToWindow = true;
            addGlobalLayoutListener();
        }

        public void onDetachedFromWindow() {
            this.mAlreadyAttachedToWindow = false;
            WeakReference<ViewTreeObserver.OnGlobalLayoutListener> weakReference = this.mListener;
            if (weakReference != null && weakReference.get() != null && this.mOwner.getViewTreeObserver().isAlive()) {
                this.mOwner.getViewTreeObserver().removeGlobalOnLayoutListener(this.mListener.get());
                this.mAlreadySetListener = false;
            }
        }

        public void setOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.mListener = new WeakReference<>(onGlobalLayoutListener);
            if (this.mOwner.isAttachedToWindow()) {
                addGlobalLayoutListener();
            }
        }
    }

    public BNUIBoundRelativeLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mUIBounderProxy = new UIBounderProxy(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mUIBounderProxy.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mUIBounderProxy.onDetachedFromWindow();
    }

    public void setOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.mUIBounderProxy.setOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public BNUIBoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BNUIBoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
