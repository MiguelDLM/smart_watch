package com.github.appintro.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.AppIntroBase;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.AppIntroViewPagerListener;
import com.github.appintro.internal.viewpager.ViewPagerTransformer;
import java.lang.reflect.Field;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;

/* loaded from: classes9.dex */
public final class AppIntroViewPager extends ViewPager {

    @Deprecated
    private static final int ON_ILLEGALLY_REQUESTED_NEXT_PAGE_MAX_INTERVAL = 1000;
    private float currentTouchDownX;
    private float currentTouchDownY;

    @oOoXoXO
    private ScrollerCustomDuration customScroller;
    private long illegallyRequestedNextPageLastCalled;
    private boolean isFullPagingEnabled;
    private boolean isPermissionSlide;

    @oOoXoXO
    private AppIntroViewPagerListener onNextPageRequestedListener;

    @oOoXoXO
    private ViewPager.OnPageChangeListener pageChangeListener;

    @OOXIXo
    private static final Companion Companion = new Companion(null);

    @OOXIXo
    @Deprecated
    private static final String TAG = LogHelper.INSTANCE.makeLogTag(IO.oxoX(AppIntroViewPager.class));

    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppIntroViewPager(@OOXIXo Context context, @OOXIXo AttributeSet attrs) {
        super(context, attrs);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
        this.isFullPagingEnabled = true;
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("sInterpolator");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(null);
            if (obj != null) {
                ScrollerCustomDuration scrollerCustomDuration = new ScrollerCustomDuration(context, (Interpolator) obj);
                this.customScroller = scrollerCustomDuration;
                declaredField.set(this, scrollerCustomDuration);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.animation.Interpolator");
        } catch (NoSuchFieldException e) {
            LogHelper.e(TAG, "Failed to access the viewpager interpolator", e);
        }
    }

    private final boolean handleTouchEvent(MotionEvent motionEvent) {
        AppIntroViewPagerListener appIntroViewPagerListener;
        AppIntroViewPagerListener appIntroViewPagerListener2;
        if (!this.isFullPagingEnabled) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.currentTouchDownX = motionEvent.getX();
            this.currentTouchDownY = motionEvent.getY();
        } else {
            boolean z = true;
            if (motionEvent.getAction() == 1) {
                performClick();
            }
            AppIntroViewPagerListener appIntroViewPagerListener3 = this.onNextPageRequestedListener;
            if (appIntroViewPagerListener3 != null) {
                z = appIntroViewPagerListener3.onCanRequestNextPage();
            }
            if (!z && isSwipeForward(this.currentTouchDownX, motionEvent.getX())) {
                if (userIllegallyRequestNextPage() && (appIntroViewPagerListener2 = this.onNextPageRequestedListener) != null) {
                    appIntroViewPagerListener2.onIllegallyRequestedNextPage();
                }
                return false;
            }
            if (this.isPermissionSlide && isSwipeForward(this.currentTouchDownX, motionEvent.getX()) && (appIntroViewPagerListener = this.onNextPageRequestedListener) != null) {
                appIntroViewPagerListener.onUserRequestedPermissionsDialog();
            }
        }
        return this.isFullPagingEnabled;
    }

    private final boolean isSwipeForward(float f, float f2) {
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (LayoutUtil.isRtl(context)) {
            if (f2 <= f) {
                return false;
            }
        } else if (f <= f2) {
            return false;
        }
        return true;
    }

    private final boolean userIllegallyRequestNextPage() {
        if (System.currentTimeMillis() - this.illegallyRequestedNextPageLastCalled >= 1000) {
            this.illegallyRequestedNextPageLastCalled = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    public final void addOnPageChangeListener$appintro_release(@OOXIXo AppIntroBase.OnPageChangeListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        super.addOnPageChangeListener(listener);
        this.pageChangeListener = listener;
    }

    public final int getCurrentSlideNumber(int i) {
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (LayoutUtil.isRtl(context)) {
            return i - getCurrentItem();
        }
        return getCurrentItem() + 1;
    }

    @oOoXoXO
    public final AppIntroViewPagerListener getOnNextPageRequestedListener() {
        return this.onNextPageRequestedListener;
    }

    public final void goToNextSlide() {
        int i;
        int currentItem = getCurrentItem();
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (!LayoutUtil.isRtl(context)) {
            i = 1;
        } else {
            i = -1;
        }
        setCurrentItem(currentItem + i);
    }

    public final void goToPreviousSlide() {
        int i;
        int currentItem = getCurrentItem();
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (!LayoutUtil.isRtl(context)) {
            i = -1;
        } else {
            i = 1;
        }
        setCurrentItem(currentItem + i);
    }

    public final boolean isFirstSlide(int i) {
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (LayoutUtil.isRtl(context)) {
            if ((getCurrentItem() - i) + 1 != 0) {
                return false;
            }
        } else if (getCurrentItem() != 0) {
            return false;
        }
        return true;
    }

    public final boolean isFullPagingEnabled() {
        return this.isFullPagingEnabled;
    }

    public final boolean isLastSlide(int i) {
        Context context = getContext();
        IIX0o.oO(context, "context");
        if (LayoutUtil.isRtl(context)) {
            if (getCurrentItem() != 0) {
                return false;
            }
        } else if ((getCurrentItem() - i) + 1 != 0) {
            return false;
        }
        return true;
    }

    public final boolean isPermissionSlide() {
        return this.isPermissionSlide;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        if (!handleTouchEvent(event)) {
            return false;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        if (!handleTouchEvent(event)) {
            return false;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void reCenterCurrentSlide$appintro_release() {
        int currentItem = getCurrentItem();
        setCurrentItem(Math.max(currentItem - 1, 0), false);
        setCurrentItem(currentItem, false);
    }

    public final void setAppIntroPageTransformer(@OOXIXo AppIntroPageTransformerType appIntroTransformer) {
        IIX0o.x0xO0oo(appIntroTransformer, "appIntroTransformer");
        setPageTransformer(true, new ViewPagerTransformer(appIntroTransformer));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        int currentItem = super.getCurrentItem();
        super.setCurrentItem(i);
        if (currentItem == 0 && i == 0 && (onPageChangeListener = this.pageChangeListener) != null) {
            onPageChangeListener.onPageSelected(0);
        }
    }

    public final void setFullPagingEnabled(boolean z) {
        this.isFullPagingEnabled = z;
    }

    public final void setOnNextPageRequestedListener(@oOoXoXO AppIntroViewPagerListener appIntroViewPagerListener) {
        this.onNextPageRequestedListener = appIntroViewPagerListener;
    }

    public final void setPermissionSlide(boolean z) {
        this.isPermissionSlide = z;
    }

    public final void setScrollDurationFactor(double d) {
        ScrollerCustomDuration scrollerCustomDuration = this.customScroller;
        if (scrollerCustomDuration != null) {
            scrollerCustomDuration.setScrollDurationFactor(d);
        }
    }
}
