package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public final class ToastUtils {
    private static final int COLOR_DEFAULT = -16777217;
    private static final ToastUtils DEFAULT_TOAST_UTILS = make();
    private static final String NOTHING = "toast nothing";
    private static final String NULL = "toast null";
    private static final String TAG_TOAST = "TAG_TOAST";
    private static IToast iToast;
    private String mMode;
    private int mGravity = -1;
    private int mXOffset = -1;
    private int mYOffset = -1;
    private int mBgColor = COLOR_DEFAULT;
    private int mBgResource = -1;
    private int mTextColor = COLOR_DEFAULT;
    private int mTextSize = -1;
    private boolean isLong = false;
    private Drawable[] mIcons = new Drawable[4];
    private boolean isNotUseSystemToast = false;

    /* loaded from: classes8.dex */
    public static final class ActivityToast extends AbsToast {
        private static int sShowingIndex;
        private Utils.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

        public ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        private View getToastViewSnapshot(int i) {
            Bitmap view2Bitmap = UtilsBridge.view2Bitmap(this.mToastView);
            ImageView imageView = new ImageView(Utils.getApp());
            imageView.setTag(ToastUtils.TAG_TOAST + i);
            imageView.setImageBitmap(view2Bitmap);
            return imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isShowing() {
            if (this.mActivityLifecycleCallbacks != null) {
                return true;
            }
            return false;
        }

        private void registerLifecycleCallback() {
            final int i = sShowingIndex;
            Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Utils.ActivityLifecycleCallbacks() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.2
                @Override // com.blankj.utilcode.util.Utils.ActivityLifecycleCallbacks
                public void onActivityCreated(@NonNull Activity activity) {
                    if (activity != null) {
                        if (ActivityToast.this.isShowing()) {
                            ActivityToast.this.showWithActivity(activity, i, false);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
            };
            this.mActivityLifecycleCallbacks = activityLifecycleCallbacks;
            UtilsBridge.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }

        private void showSystemToast(int i) {
            SystemToast systemToast = new SystemToast(this.mToastUtils);
            systemToast.mToast = this.mToast;
            systemToast.show(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showWithActivity(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.mToast.getGravity();
                layoutParams.bottomMargin = this.mToast.getYOffset() + UtilsBridge.getNavBarHeight();
                layoutParams.leftMargin = this.mToast.getXOffset();
                View toastViewSnapshot = getToastViewSnapshot(i);
                if (z) {
                    toastViewSnapshot.setAlpha(0.0f);
                    toastViewSnapshot.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(toastViewSnapshot, layoutParams);
            }
        }

        private void unregisterLifecycleCallback() {
            UtilsBridge.removeActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            this.mActivityLifecycleCallbacks = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.AbsToast, com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            Window window;
            if (isShowing()) {
                unregisterLifecycleCallback();
                for (Activity activity : UtilsBridge.getActivityList()) {
                    if (UtilsBridge.isActivityAlive(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ToastUtils.TAG_TOAST);
                        sb.append(sShowingIndex - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            super.cancel();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            long j;
            if (this.mToast == null) {
                return;
            }
            if (!UtilsBridge.isAppForeground()) {
                showSystemToast(i);
                return;
            }
            boolean z = false;
            for (Activity activity : UtilsBridge.getActivityList()) {
                if (UtilsBridge.isActivityAlive(activity)) {
                    showWithActivity(activity, sShowingIndex, true);
                    z = true;
                }
            }
            if (z) {
                registerLifecycleCallback();
                Runnable runnable = new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityToast.this.cancel();
                    }
                };
                if (i == 0) {
                    j = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                } else {
                    j = 3500;
                }
                UtilsBridge.runOnUiThreadDelayed(runnable, j);
                sShowingIndex++;
                return;
            }
            showSystemToast(i);
        }
    }

    /* loaded from: classes8.dex */
    public interface IToast {
        void cancel();

        void setToastView(View view);

        void setToastView(CharSequence charSequence);

        void show(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface MODE {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
    }

    /* loaded from: classes8.dex */
    public static final class SystemToast extends AbsToast {

        /* loaded from: classes8.dex */
        public static class SafeHandler extends Handler {
            private Handler impl;

            public SafeHandler(Handler handler) {
                this.impl = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(@NonNull Message message) {
                if (message != null) {
                    try {
                        this.impl.dispatchMessage(message);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                throw new NullPointerException("Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                if (message != null) {
                    this.impl.handleMessage(message);
                    return;
                }
                throw new NullPointerException("Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public SystemToast(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.mToast);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new SafeHandler((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            Toast toast = this.mToast;
            if (toast == null) {
                return;
            }
            toast.setDuration(i);
            this.mToast.show();
        }
    }

    /* loaded from: classes8.dex */
    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        private static final int SPACING = UtilsBridge.dp2px(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(UtilsBridge.getAppScreenWidth() - SPACING, Integer.MIN_VALUE), i2);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    /* loaded from: classes8.dex */
    public static final class WindowManagerToast extends AbsToast {
        private Utils.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
        private WindowManager.LayoutParams mParams;
        private WindowManager mWM;

        public WindowManagerToast(ToastUtils toastUtils, int i) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mParams = layoutParams;
            layoutParams.type = i;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.AbsToast, com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            try {
                WindowManager windowManager = this.mWM;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.mToastView);
                    this.mWM = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            long j;
            if (this.mToast == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.mParams;
            layoutParams2.flags = 152;
            layoutParams2.packageName = Utils.getApp().getPackageName();
            this.mParams.gravity = this.mToast.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.mParams;
            int i2 = layoutParams3.gravity;
            if ((i2 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i2 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.mToast.getXOffset();
            this.mParams.y = this.mToast.getYOffset();
            this.mParams.horizontalMargin = this.mToast.getHorizontalMargin();
            this.mParams.verticalMargin = this.mToast.getVerticalMargin();
            WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService("window");
            this.mWM = windowManager;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.mToastView, this.mParams);
                } catch (Exception unused) {
                }
            }
            Runnable runnable = new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.WindowManagerToast.1
                @Override // java.lang.Runnable
                public void run() {
                    WindowManagerToast.this.cancel();
                }
            };
            if (i == 0) {
                j = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
            } else {
                j = 3500;
            }
            UtilsBridge.runOnUiThreadDelayed(runnable, j);
        }
    }

    public static void cancel() {
        IToast iToast2 = iToast;
        if (iToast2 != null) {
            iToast2.cancel();
            iToast = null;
        }
    }

    private int getDuration() {
        return this.isLong ? 1 : 0;
    }

    private static CharSequence getToastFriendlyText(CharSequence charSequence) {
        if (charSequence == null) {
            return NULL;
        }
        if (charSequence.length() == 0) {
            return NOTHING;
        }
        return charSequence;
    }

    public static ToastUtils make() {
        return new ToastUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IToast newToast(ToastUtils toastUtils) {
        if (!toastUtils.isNotUseSystemToast && NotificationManagerCompat.from(Utils.getApp()).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new SystemToast(toastUtils);
            }
            if (!UtilsBridge.isGrantedDrawOverlays()) {
                return new SystemToast(toastUtils);
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 25) {
            return new WindowManagerToast(toastUtils, 2005);
        }
        if (UtilsBridge.isGrantedDrawOverlays()) {
            if (i >= 26) {
                new WindowManagerToast(toastUtils, 2038);
            } else {
                new WindowManagerToast(toastUtils, 2002);
            }
        }
        return new ActivityToast(toastUtils);
    }

    public static void showLong(CharSequence charSequence) {
        show(charSequence, 1, DEFAULT_TOAST_UTILS);
    }

    public static void showShort(CharSequence charSequence) {
        show(charSequence, 0, DEFAULT_TOAST_UTILS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View tryApplyUtilsToastView(CharSequence charSequence) {
        if (!MODE.DARK.equals(this.mMode) && !MODE.LIGHT.equals(this.mMode)) {
            Drawable[] drawableArr = this.mIcons;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View layoutId2View = UtilsBridge.layoutId2View(com.blankj.utilcode.R.layout.utils_toast_view);
        TextView textView = (TextView) layoutId2View.findViewById(R.id.message);
        if (MODE.DARK.equals(this.mMode)) {
            ((GradientDrawable) layoutId2View.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.mIcons[0] != null) {
            View findViewById = layoutId2View.findViewById(com.blankj.utilcode.R.id.utvLeftIconView);
            ViewCompat.setBackground(findViewById, this.mIcons[0]);
            findViewById.setVisibility(0);
        }
        if (this.mIcons[1] != null) {
            View findViewById2 = layoutId2View.findViewById(com.blankj.utilcode.R.id.utvTopIconView);
            ViewCompat.setBackground(findViewById2, this.mIcons[1]);
            findViewById2.setVisibility(0);
        }
        if (this.mIcons[2] != null) {
            View findViewById3 = layoutId2View.findViewById(com.blankj.utilcode.R.id.utvRightIconView);
            ViewCompat.setBackground(findViewById3, this.mIcons[2]);
            findViewById3.setVisibility(0);
        }
        if (this.mIcons[3] != null) {
            View findViewById4 = layoutId2View.findViewById(com.blankj.utilcode.R.id.utvBottomIconView);
            ViewCompat.setBackground(findViewById4, this.mIcons[3]);
            findViewById4.setVisibility(0);
        }
        return layoutId2View;
    }

    public final ToastUtils setBgColor(@ColorInt int i) {
        this.mBgColor = i;
        return this;
    }

    public final ToastUtils setBgResource(@DrawableRes int i) {
        this.mBgResource = i;
        return this;
    }

    public final ToastUtils setBottomIcon(int i) {
        return setBottomIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setDurationIsLong(boolean z) {
        this.isLong = z;
        return this;
    }

    public final ToastUtils setGravity(int i, int i2, int i3) {
        this.mGravity = i;
        this.mXOffset = i2;
        this.mYOffset = i3;
        return this;
    }

    public final ToastUtils setLeftIcon(@DrawableRes int i) {
        return setLeftIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setMode(String str) {
        this.mMode = str;
        return this;
    }

    public final ToastUtils setNotUseSystemToast() {
        this.isNotUseSystemToast = true;
        return this;
    }

    public final ToastUtils setRightIcon(@DrawableRes int i) {
        return setRightIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setTextColor(@ColorInt int i) {
        this.mTextColor = i;
        return this;
    }

    public final ToastUtils setTextSize(int i) {
        this.mTextSize = i;
        return this;
    }

    public final ToastUtils setTopIcon(@DrawableRes int i) {
        return setTopIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final void show(CharSequence charSequence) {
        show(charSequence, getDuration(), this);
    }

    /* loaded from: classes8.dex */
    public static abstract class AbsToast implements IToast {
        protected Toast mToast = new Toast(Utils.getApp());
        protected ToastUtils mToastUtils;
        protected View mToastView;

        public AbsToast(ToastUtils toastUtils) {
            this.mToastUtils = toastUtils;
            if (toastUtils.mGravity != -1 || this.mToastUtils.mXOffset != -1 || this.mToastUtils.mYOffset != -1) {
                this.mToast.setGravity(this.mToastUtils.mGravity, this.mToastUtils.mXOffset, this.mToastUtils.mYOffset);
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        @CallSuper
        public void cancel() {
            Toast toast = this.mToast;
            if (toast != null) {
                toast.cancel();
            }
            this.mToast = null;
            this.mToastView = null;
        }

        public void setBg(TextView textView) {
            if (this.mToastUtils.mBgResource != -1) {
                this.mToastView.setBackgroundResource(this.mToastUtils.mBgResource);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.mToastUtils.mBgColor != ToastUtils.COLOR_DEFAULT) {
                Drawable background = this.mToastView.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                } else {
                    this.mToastView.setBackgroundColor(this.mToastUtils.mBgColor);
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void setToastView(View view) {
            this.mToastView = view;
            this.mToast.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void setToastView(CharSequence charSequence) {
            View tryApplyUtilsToastView = this.mToastUtils.tryApplyUtilsToastView(charSequence);
            if (tryApplyUtilsToastView != null) {
                setToastView(tryApplyUtilsToastView);
                return;
            }
            View view = this.mToast.getView();
            this.mToastView = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                setToastView(UtilsBridge.layoutId2View(com.blankj.utilcode.R.layout.utils_toast_view));
            }
            TextView textView = (TextView) this.mToastView.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.mToastUtils.mTextColor != ToastUtils.COLOR_DEFAULT) {
                textView.setTextColor(this.mToastUtils.mTextColor);
            }
            if (this.mToastUtils.mTextSize != -1) {
                textView.setTextSize(this.mToastUtils.mTextSize);
            }
            setBg(textView);
        }
    }

    public static void showLong(@StringRes int i) {
        show(UtilsBridge.getString(i), 1, DEFAULT_TOAST_UTILS);
    }

    public static void showShort(@StringRes int i) {
        show(UtilsBridge.getString(i), 0, DEFAULT_TOAST_UTILS);
    }

    public final ToastUtils setBottomIcon(Drawable drawable) {
        this.mIcons[3] = drawable;
        return this;
    }

    public final ToastUtils setLeftIcon(Drawable drawable) {
        this.mIcons[0] = drawable;
        return this;
    }

    public final ToastUtils setRightIcon(Drawable drawable) {
        this.mIcons[2] = drawable;
        return this;
    }

    public final ToastUtils setTopIcon(Drawable drawable) {
        this.mIcons[1] = drawable;
        return this;
    }

    public final void show(@StringRes int i) {
        show(UtilsBridge.getString(i), getDuration(), this);
    }

    public static void showLong(@StringRes int i, Object... objArr) {
        show(UtilsBridge.getString(i), 1, DEFAULT_TOAST_UTILS);
    }

    public static void showShort(@StringRes int i, Object... objArr) {
        show(UtilsBridge.getString(i, objArr), 0, DEFAULT_TOAST_UTILS);
    }

    public final void show(@StringRes int i, Object... objArr) {
        show(UtilsBridge.getString(i, objArr), getDuration(), this);
    }

    public static void showLong(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), 1, DEFAULT_TOAST_UTILS);
    }

    public static void showShort(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), 0, DEFAULT_TOAST_UTILS);
    }

    public final void show(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), getDuration(), this);
    }

    public final void show(View view) {
        show(view, getDuration(), this);
    }

    private static void show(CharSequence charSequence, int i, ToastUtils toastUtils) {
        show(null, getToastFriendlyText(charSequence), i, toastUtils);
    }

    private static void show(View view, int i, ToastUtils toastUtils) {
        show(view, null, i, toastUtils);
    }

    private static void show(@Nullable final View view, final CharSequence charSequence, final int i, ToastUtils toastUtils) {
        UtilsBridge.runOnUiThread(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.cancel();
                IToast unused = ToastUtils.iToast = ToastUtils.newToast(ToastUtils.this);
                if (view != null) {
                    ToastUtils.iToast.setToastView(view);
                } else {
                    ToastUtils.iToast.setToastView(charSequence);
                }
                ToastUtils.iToast.show(i);
            }
        });
    }
}
