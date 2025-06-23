package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public abstract class BNBaseFloatView {
    private static final String TAG = "BNBaseFloatView";
    private Activity mActivity;
    private Context mContext;
    private View mFloatLayout;
    private int mTouchSlop;
    private WindowManager mWindowManager;
    private float mXInFloatView;
    private float mXInScreen;
    private float mYInFloatView;
    private float mYInScreen;
    private WindowManager.LayoutParams wmParams;
    private boolean isShowing = false;
    private float mDownX = 0.0f;
    private float mDownY = 0.0f;
    private boolean isMoved = false;

    public BNBaseFloatView(Activity activity) {
        this.mActivity = activity;
        this.mContext = activity.getApplicationContext();
        initWindowsManger();
        intParams();
        this.mFloatLayout = initViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMotionEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                this.mXInScreen = motionEvent.getRawX();
                this.mYInScreen = motionEvent.getRawY() - ScreenUtil.getInstance().getStatusBarHeight(this.mActivity);
                if (Math.abs(this.mDownX - motionEvent.getRawX()) > this.mTouchSlop || Math.abs(this.mDownY - motionEvent.getRawY()) > this.mTouchSlop) {
                    this.isMoved = true;
                }
                updateViewPosition();
                return false;
            }
            updateViewPosition();
            return this.isMoved;
        }
        this.mXInFloatView = motionEvent.getX();
        this.mYInFloatView = motionEvent.getY();
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        this.isMoved = false;
        return false;
    }

    private void initWindowsManger() {
        this.wmParams = new WindowManager.LayoutParams();
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.wmParams.type = 2038;
        } else if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && i >= 24) {
            this.wmParams.type = 2002;
        } else if (i >= 25) {
            this.wmParams.type = 2002;
        } else {
            this.wmParams.type = 2005;
        }
        WindowManager.LayoutParams layoutParams = this.wmParams;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.x = ScreenUtil.getInstance().dip2px(25);
        WindowManager.LayoutParams layoutParams2 = this.wmParams;
        layoutParams2.y = 0;
        layoutParams2.width = ScreenUtil.getInstance().dip2px(300);
        this.wmParams.height = ScreenUtil.getInstance().dip2px(200);
    }

    private void intParams() {
        this.mTouchSlop = ScreenUtil.getInstance().dip2px(4);
    }

    private void updateViewPosition() {
        WindowManager.LayoutParams layoutParams = this.wmParams;
        layoutParams.x = (int) (this.mXInScreen - this.mXInFloatView);
        layoutParams.y = (int) (this.mYInScreen - this.mYInFloatView);
        try {
            this.mWindowManager.updateViewLayout(this.mFloatLayout, layoutParams);
        } catch (Exception unused) {
        }
    }

    public void dispose() {
        this.isShowing = false;
        View view = this.mFloatLayout;
        if (view != null) {
            this.mWindowManager.removeView(view);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getFloatView() {
        return this.mFloatLayout;
    }

    public void hide() {
        LogUtil.e(TAG, "hide");
        try {
            View view = this.mFloatLayout;
            if (view != null && view.getParent() != null) {
                this.mWindowManager.removeView(this.mFloatLayout);
            }
            this.isShowing = false;
        } catch (Exception e) {
            LogUtil.e(TAG, "hide float excetion e:" + e.getMessage());
        }
    }

    public abstract View initViews();

    public boolean isShow() {
        return this.isShowing;
    }

    public boolean show() {
        LogUtil.e(TAG, "show :" + isShow());
        if (isShow()) {
            return true;
        }
        try {
            this.mFloatLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.navisdk.ui.widget.BNBaseFloatView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return BNBaseFloatView.this.handleMotionEvent(motionEvent);
                }
            });
            this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
            this.isShowing = true;
            return true;
        } catch (Exception e) {
            LogUtil.e(TAG, "float excetion e:" + e.getMessage());
            this.isShowing = false;
            return false;
        }
    }
}
