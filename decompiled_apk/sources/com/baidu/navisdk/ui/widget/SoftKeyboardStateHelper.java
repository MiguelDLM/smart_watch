package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class SoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int SOFT_KEYBOARD_HEIGHT_MIN = 200;
    private boolean hasNavigationBar;
    private boolean isSoftKeyboardOpened;
    private int lastSoftKeyboardHeightInPx;
    private final List<SoftKeyboardStateListener> listeners;
    private Activity mActivity;
    private int mPreviousHeight;
    private Rect mRect;
    private final View viewRoot;
    private int windowHeight;

    /* loaded from: classes8.dex */
    public interface SoftKeyboardStateListener {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i);
    }

    public SoftKeyboardStateHelper(Activity activity, View view) {
        this(activity, view, false);
    }

    private void notifyOnSoftKeyboardClosed() {
        for (SoftKeyboardStateListener softKeyboardStateListener : this.listeners) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardClosed();
            }
        }
    }

    private void notifyOnSoftKeyboardOpened(int i) {
        this.lastSoftKeyboardHeightInPx = i;
        for (SoftKeyboardStateListener softKeyboardStateListener : this.listeners) {
            if (softKeyboardStateListener != null) {
                softKeyboardStateListener.onSoftKeyboardOpened(i);
            }
        }
    }

    public void addSoftKeyboardStateListener(SoftKeyboardStateListener softKeyboardStateListener) {
        this.listeners.add(softKeyboardStateListener);
    }

    public int getLastSoftKeyboardHeightInPx() {
        return this.lastSoftKeyboardHeightInPx;
    }

    public boolean isSoftKeyboardOpened() {
        return this.isSoftKeyboardOpened;
    }

    public void onDestroy() {
        this.mActivity = null;
        View view = this.viewRoot;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.listeners.clear();
        this.mRect = null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        Activity activity = this.mActivity;
        if (activity != null && this.viewRoot != null) {
            if (this.windowHeight <= 0) {
                this.windowHeight = activity.getWindow().getDecorView().getRootView().getHeight();
            }
            this.mRect.setEmpty();
            this.viewRoot.getWindowVisibleDisplayFrame(this.mRect);
            int i2 = this.windowHeight - this.mRect.bottom;
            int bottomBarHeight = ScreenUtil.getBottomBarHeight(this.mActivity.getApplicationContext());
            if (i2 != bottomBarHeight && Math.abs(i2 - bottomBarHeight) > 1 && (i = i2 - this.mPreviousHeight) != bottomBarHeight) {
                if (i2 == 0 || i == (-bottomBarHeight)) {
                    this.hasNavigationBar = false;
                }
            } else {
                this.hasNavigationBar = true;
            }
            if (this.hasNavigationBar) {
                i2 -= bottomBarHeight;
            }
            boolean z = this.isSoftKeyboardOpened;
            if (!z && i2 > 200) {
                this.isSoftKeyboardOpened = true;
                notifyOnSoftKeyboardOpened(i2);
            } else if (z && i2 < 200) {
                this.isSoftKeyboardOpened = false;
                notifyOnSoftKeyboardClosed();
            }
            this.mPreviousHeight = i2;
        }
    }

    public void removeSoftKeyboardStateListener(SoftKeyboardStateListener softKeyboardStateListener) {
        this.listeners.remove(softKeyboardStateListener);
    }

    public void setIsSoftKeyboardOpened(boolean z) {
        this.isSoftKeyboardOpened = z;
    }

    public SoftKeyboardStateHelper(Activity activity, View view, boolean z) {
        this.listeners = new ArrayList(4);
        this.windowHeight = 0;
        this.mRect = new Rect();
        this.viewRoot = view;
        this.isSoftKeyboardOpened = z;
        this.mActivity = activity;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
