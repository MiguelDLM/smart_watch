package com.baidu.navisdk.util.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes8.dex */
public class ScreenUtil {
    public static final int DEFAULT_HEIGHT = 1920;
    public static final int DEFAULT_WIDTH = 1080;
    public static final int DENSITY_DEFAULT = 160;
    public static final int ROTATION_BOTTOM = 2;
    public static final int ROTATION_INVALID = -1;
    public static final int ROTATION_LEFT = 3;
    public static final int ROTATION_RIGHT = 1;
    public static final int ROTATION_TOP = 0;
    public static final int SCREEN_SIZE_Y_LARGE = 640;
    private static final String TAG = "ScreenUtil";
    private static ScreenUtil mInstance;
    private DisplayMetrics mDM;
    private Display mDefaultDisplay;
    private int mDensityDpi;
    private int mOldLayoutHeight;
    private int mOldLayoutWidth;
    private float mDensity = 0.0f;
    private int mWidthPixels = 0;
    private int mHeightPixels = 0;
    private int mAbsoluteWidth = 0;
    private int mAbsoluteHeight = 0;
    private int mStatusBarHeight = 0;
    private int mDPI = 0;
    private boolean isNavibarShown = false;

    private ScreenUtil() {
    }

    public static int getBottomBarHeight(Context context) {
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
            return 0;
        } catch (Exception e) {
            LogUtil.e(TAG, "getBottomBarHeight" + e.getMessage());
            return 0;
        }
    }

    private Display getDefaultDisplay(Context context) {
        WindowManager windowManager;
        if (this.mDefaultDisplay == null && context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            this.mDefaultDisplay = windowManager.getDefaultDisplay();
        }
        return this.mDefaultDisplay;
    }

    public static ScreenUtil getInstance() {
        if (mInstance == null) {
            mInstance = new ScreenUtil();
        }
        return mInstance;
    }

    private int getStatusBarHeightForLowApi(Context context) {
        if (context instanceof Activity) {
            Rect rect = new Rect();
            Window window = ((Activity) context).getWindow();
            if (window != null && window.getDecorView() != null) {
                window.getDecorView().getWindowVisibleDisplayFrame(rect);
            }
            return rect.top;
        }
        return (int) Math.ceil(context.getResources().getDisplayMetrics().density * 25.0f);
    }

    public int dip2px(int i) {
        return (int) ((this.mDensity * i) + 0.5f);
    }

    public int getAbsoluteHeight() {
        return this.mAbsoluteHeight;
    }

    public int getAbsoluteWidth() {
        return this.mAbsoluteWidth;
    }

    public int getDPI() {
        return this.mDPI;
    }

    public int getDefaultHeight(Context context) {
        Display defaultDisplay = getDefaultDisplay(context);
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return DEFAULT_HEIGHT;
    }

    public int getDefaultWidth(Context context) {
        Display defaultDisplay = getDefaultDisplay(context);
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return DEFAULT_WIDTH;
    }

    public float getDensity() {
        return this.mDensity;
    }

    public int getDensityDpi() {
        return this.mDensityDpi;
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mDM;
    }

    public int getDisplayRotation(Activity activity) {
        if (activity == null) {
            return 0;
        }
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return 1;
            }
            return 2;
        }
        return 3;
    }

    public int getDp(Context context, int i) {
        if (context != null && context.getResources() != null) {
            return px2dip(context.getResources().getDimensionPixelSize(i));
        }
        return 0;
    }

    public int getHeightPixels() {
        return this.mHeightPixels;
    }

    public int getNaviBarHeight() {
        return getAbsoluteHeight() - this.mHeightPixels;
    }

    public int getScreenOrientation(Activity activity) {
        if (activity == null) {
            return -1;
        }
        return activity.getResources().getConfiguration().orientation;
    }

    public int getStatusBarHeight(Activity activity) {
        if (this.mStatusBarHeight == 0) {
            if (activity == null) {
                return 0;
            }
            resetStatusBarHeight(activity);
        }
        return this.mStatusBarHeight;
    }

    public int getStatusBarHeightFullScreen(Context context) {
        int i = 0;
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = context.getResources().getDimensionPixelSize(identifier);
        }
        if (i <= 0) {
            return dip2px(25);
        }
        return i;
    }

    public int getWidthPixels() {
        return this.mWidthPixels;
    }

    public void init(Context context) {
        boolean z;
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDM = displayMetrics;
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        DisplayMetrics displayMetrics2 = this.mDM;
        int max = Math.max(displayMetrics2.widthPixels, displayMetrics2.heightPixels);
        if (min == this.mWidthPixels && max == this.mHeightPixels) {
            return;
        }
        this.mWidthPixels = min;
        this.mHeightPixels = max;
        DisplayMetrics displayMetrics3 = this.mDM;
        this.mDensity = displayMetrics3.density;
        this.mDensityDpi = displayMetrics3.densityDpi;
        DisplayMetrics displayMetrics4 = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics4);
        this.mAbsoluteWidth = Math.min(displayMetrics4.widthPixels, displayMetrics4.heightPixels);
        int max2 = Math.max(displayMetrics4.widthPixels, displayMetrics4.heightPixels);
        this.mAbsoluteHeight = max2;
        if (max2 > this.mHeightPixels) {
            z = true;
        } else {
            z = false;
        }
        this.isNavibarShown = z;
        int i = this.mDM.densityDpi;
        this.mDPI = i;
        if (i == 0) {
            this.mDPI = 160;
        }
    }

    public boolean isNavibarShown() {
        return this.isNavibarShown;
    }

    public void keepScreenOn(boolean z, Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (z) {
                activity.getWindow().addFlags(128);
            } else {
                activity.getWindow().clearFlags(128);
            }
        }
    }

    public int percentHeight(float f) {
        return (int) (f * getHeightPixels());
    }

    public int percentWidth(float f) {
        return (int) (f * getWidthPixels());
    }

    public int px2dip(int i) {
        return (int) ((i / this.mDensity) + 0.5f);
    }

    public void resetStatusBarHeight(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                this.mStatusBarHeight = activity.getResources().getDimensionPixelSize(identifier);
            } else {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                this.mStatusBarHeight = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            }
        } catch (Exception e) {
            Log.e(TAG, "an error occurred when getField status_bar_height ", e);
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.mStatusBarHeight = rect.top;
        }
    }

    public void setNavibarShown(boolean z) {
        LogUtil.e("setUIViewBound", "setNavibarShown - " + z);
        this.isNavibarShown = z;
    }

    public void setScreenOrientation(Activity activity, int i) {
        if (activity != null) {
            activity.setRequestedOrientation(i);
        }
    }

    public int dip2px(float f) {
        return (int) ((this.mDensity * f) + 0.5f);
    }

    public int px2dip(float f) {
        return (int) ((f / this.mDensity) + 0.5f);
    }
}
