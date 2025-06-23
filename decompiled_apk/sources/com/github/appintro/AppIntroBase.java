package com.github.appintro;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.indicator.DotIndicatorController;
import com.github.appintro.indicator.IndicatorController;
import com.github.appintro.indicator.ProgressIndicatorController;
import com.github.appintro.internal.AppIntroViewPager;
import com.github.appintro.internal.LayoutUtil;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.PermissionWrapper;
import com.github.appintro.internal.viewpager.PagerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.XX;
import kotlin.Xo0;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public abstract class AppIntroBase extends AppCompatActivity implements AppIntroViewPagerListener {

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED = "colorTransitionEnabled";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_CURRENT_ITEM = "currentItem";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_IS_BUTTONS_ENABLED = "isButtonsEnabled";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_IS_FULL_PAGING_ENABLED = "isFullPagingEnabled";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_IS_INDICATOR_ENABLED = "isIndicatorEnabled";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED = "isSkipButtonsEnabled";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_PERMISSION_MAP = "permissionMap";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED = "retainIsButtonsEnabled";

    @OOXIXo
    @Deprecated
    private static final String ARG_BUNDLE_SLIDES_NUMBER = "slidesNumber";

    @Deprecated
    private static final int DEFAULT_SCROLL_DURATION_FACTOR = 1;

    @Deprecated
    private static final long DEFAULT_VIBRATE_DURATION = 20;

    @Deprecated
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    private View backButton;
    private View doneButton;
    private ViewGroup indicatorContainer;

    @oOoXoXO
    private IndicatorController indicatorController;
    private boolean isColorTransitionsEnabled;
    private boolean isSystemBackButtonLocked;
    private boolean isVibrate;
    private boolean isWizardMode;
    private View nextButton;
    private AppIntroViewPager pager;
    private PagerAdapter pagerAdapter;
    private int savedCurrentItem;
    private View skipButton;
    private int slidesNumber;
    private Vibrator vibrator;

    @OOXIXo
    private static final Companion Companion = new Companion(null);

    @OOXIXo
    @Deprecated
    private static final String TAG = LogHelper.makeLogTag((Class<?>) AppIntroBase.class);
    private boolean isButtonsEnabled = true;
    private boolean isSkipButtonEnabled = true;
    private boolean isIndicatorEnabled = true;
    private long vibrateDuration = 20;
    private int currentlySelectedItem = -1;

    @OOXIXo
    private final List<Fragment> fragments = new ArrayList();

    @OOXIXo
    private HashMap<Integer, PermissionWrapper> permissionsMap = new HashMap<>();
    private boolean retainIsButtonsEnabled = true;

    @OOXIXo
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes9.dex */
    public final class NextSlideOnClickListener implements View.OnClickListener {
        private boolean isLastSlide;
        final /* synthetic */ AppIntroBase this$0;

        public NextSlideOnClickListener(AppIntroBase this$0, boolean z) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
            this.isLastSlide = z;
        }

        public final boolean isLastSlide() {
            return this.isLastSlide;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@OOXIXo View view) {
            IIX0o.x0xO0oo(view, "view");
            this.this$0.dispatchVibration();
            if (!this.this$0.onCanRequestNextPage()) {
                this.this$0.onIllegallyRequestedNextPage();
                return;
            }
            if (this.this$0.shouldRequestPermission()) {
                this.this$0.requestPermissions();
                return;
            }
            PagerAdapter pagerAdapter = this.this$0.pagerAdapter;
            AppIntroViewPager appIntroViewPager = null;
            if (pagerAdapter == null) {
                IIX0o.XOxIOxOx("pagerAdapter");
                pagerAdapter = null;
            }
            AppIntroViewPager appIntroViewPager2 = this.this$0.pager;
            if (appIntroViewPager2 == null) {
                IIX0o.XOxIOxOx("pager");
            } else {
                appIntroViewPager = appIntroViewPager2;
            }
            Fragment item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
            if (this.isLastSlide) {
                this.this$0.onDonePressed(item);
            } else {
                this.this$0.onNextPressed(item);
            }
            this.this$0.goToNextSlide(this.isLastSlide);
        }

        public final void setLastSlide(boolean z) {
            this.isLastSlide = z;
        }
    }

    /* loaded from: classes9.dex */
    public final class OnPageChangeListener implements ViewPager.OnPageChangeListener {
        final /* synthetic */ AppIntroBase this$0;

        public OnPageChangeListener(AppIntroBase this$0) {
            IIX0o.x0xO0oo(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (this.this$0.isColorTransitionsEnabled()) {
                PagerAdapter pagerAdapter = this.this$0.pagerAdapter;
                PagerAdapter pagerAdapter2 = null;
                if (pagerAdapter == null) {
                    IIX0o.XOxIOxOx("pagerAdapter");
                    pagerAdapter = null;
                }
                if (i < pagerAdapter.getCount() - 1) {
                    PagerAdapter pagerAdapter3 = this.this$0.pagerAdapter;
                    if (pagerAdapter3 == null) {
                        IIX0o.XOxIOxOx("pagerAdapter");
                        pagerAdapter3 = null;
                    }
                    Fragment item = pagerAdapter3.getItem(i);
                    PagerAdapter pagerAdapter4 = this.this$0.pagerAdapter;
                    if (pagerAdapter4 == null) {
                        IIX0o.XOxIOxOx("pagerAdapter");
                    } else {
                        pagerAdapter2 = pagerAdapter4;
                    }
                    this.this$0.performColorTransition(item, pagerAdapter2.getItem(i + 1), f);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IndicatorController indicatorController;
            if (this.this$0.slidesNumber >= 1 && (indicatorController = this.this$0.getIndicatorController()) != null) {
                indicatorController.selectPosition(i);
            }
            this.this$0.updateButtonsVisibility();
            AppIntroViewPager appIntroViewPager = this.this$0.pager;
            AppIntroViewPager appIntroViewPager2 = null;
            if (appIntroViewPager == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager = null;
            }
            appIntroViewPager.setPermissionSlide(this.this$0.isPermissionSlide());
            this.this$0.onPageSelected(i);
            if (this.this$0.slidesNumber > 0) {
                if (this.this$0.currentlySelectedItem == -1) {
                    AppIntroBase appIntroBase = this.this$0;
                    PagerAdapter pagerAdapter = appIntroBase.pagerAdapter;
                    if (pagerAdapter == null) {
                        IIX0o.XOxIOxOx("pagerAdapter");
                        pagerAdapter = null;
                    }
                    appIntroBase.dispatchSlideChangedCallbacks(null, pagerAdapter.getItem(i));
                } else {
                    AppIntroBase appIntroBase2 = this.this$0;
                    PagerAdapter pagerAdapter2 = appIntroBase2.pagerAdapter;
                    if (pagerAdapter2 == null) {
                        IIX0o.XOxIOxOx("pagerAdapter");
                        pagerAdapter2 = null;
                    }
                    Fragment item = pagerAdapter2.getItem(this.this$0.currentlySelectedItem);
                    PagerAdapter pagerAdapter3 = this.this$0.pagerAdapter;
                    if (pagerAdapter3 == null) {
                        IIX0o.XOxIOxOx("pagerAdapter");
                        pagerAdapter3 = null;
                    }
                    AppIntroViewPager appIntroViewPager3 = this.this$0.pager;
                    if (appIntroViewPager3 == null) {
                        IIX0o.XOxIOxOx("pager");
                    } else {
                        appIntroViewPager2 = appIntroViewPager3;
                    }
                    appIntroBase2.dispatchSlideChangedCallbacks(item, pagerAdapter3.getItem(appIntroViewPager2.getCurrentItem()));
                }
            }
            this.this$0.currentlySelectedItem = i;
        }
    }

    public static /* synthetic */ void askForPermissions$default(AppIntroBase appIntroBase, String[] strArr, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = true;
            }
            appIntroBase.askForPermissions(strArr, i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: askForPermissions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchSlideChangedCallbacks(Fragment fragment, Fragment fragment2) {
        if (fragment instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment).onSlideDeselected();
        }
        if (fragment2 instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment2).onSlideSelected();
        }
        onSlideChanged(fragment, fragment2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final void dispatchVibration() {
        if (this.isVibrate) {
            Vibrator vibrator = this.vibrator;
            if (vibrator == null) {
                IIX0o.XOxIOxOx("vibrator");
                vibrator = null;
            }
            vibrator.vibrate(this.vibrateDuration);
        }
    }

    private final int getCurrentSlideNumber() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        return appIntroViewPager.getCurrentSlideNumber(this.fragments.size());
    }

    @ColorInt
    private final int getSlideColor(SlideBackgroundColorHolder slideBackgroundColorHolder) {
        if (slideBackgroundColorHolder.getDefaultBackgroundColorRes() != 0) {
            return ContextCompat.getColor(this, slideBackgroundColorHolder.getDefaultBackgroundColorRes());
        }
        return slideBackgroundColorHolder.getDefaultBackgroundColor();
    }

    public static /* synthetic */ void goToNextSlide$default(AppIntroBase appIntroBase, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                AppIntroViewPager appIntroViewPager = appIntroBase.pager;
                if (appIntroViewPager == null) {
                    IIX0o.XOxIOxOx("pager");
                    appIntroViewPager = null;
                }
                z = appIntroViewPager.isLastSlide(appIntroBase.fragments.size());
            }
            appIntroBase.goToNextSlide(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToNextSlide");
    }

    private final void handleDeniedPermission(String str) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
            onUserDeniedPermission(str);
            PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
            if (permissionWrapper != null && !permissionWrapper.getRequired()) {
                this.permissionsMap.remove(Integer.valueOf(permissionWrapper.getPosition()));
                goToNextSlide$default(this, false, 1, null);
                return;
            }
            return;
        }
        onUserDisabledPermission(str);
    }

    private final void initializeIndicator() {
        ViewGroup viewGroup = this.indicatorContainer;
        View view = null;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("indicatorContainer");
            viewGroup = null;
        }
        IndicatorController indicatorController = this.indicatorController;
        if (indicatorController != null) {
            view = indicatorController.newInstance(this);
        }
        viewGroup.addView(view);
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.initialize(this.slidesNumber);
        }
        IndicatorController indicatorController3 = this.indicatorController;
        if (indicatorController3 != null) {
            indicatorController3.selectPosition(this.currentlySelectedItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPermissionSlide() {
        HashMap<Integer, PermissionWrapper> hashMap = this.permissionsMap;
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        return hashMap.containsKey(Integer.valueOf(appIntroViewPager.getCurrentSlideNumber(this.fragments.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0, reason: not valid java name */
    public static final void m257onCreate$lambda0(AppIntroBase this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        AppIntroViewPager appIntroViewPager = this$0.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.goToPreviousSlide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1, reason: not valid java name */
    public static final void m258onCreate$lambda1(AppIntroBase this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dispatchVibration();
        PagerAdapter pagerAdapter = this$0.pagerAdapter;
        AppIntroViewPager appIntroViewPager = null;
        if (pagerAdapter == null) {
            IIX0o.XOxIOxOx("pagerAdapter");
            pagerAdapter = null;
        }
        AppIntroViewPager appIntroViewPager2 = this$0.pager;
        if (appIntroViewPager2 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager = appIntroViewPager2;
        }
        this$0.onSkipPressed(pagerAdapter.getItem(appIntroViewPager.getCurrentItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPostCreate$lambda-2, reason: not valid java name */
    public static final void m259onPostCreate$lambda2(AppIntroBase this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        PagerAdapter pagerAdapter = this$0.pagerAdapter;
        if (pagerAdapter == null) {
            IIX0o.XOxIOxOx("pagerAdapter");
            pagerAdapter = null;
        }
        AppIntroViewPager appIntroViewPager = this$0.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        if (pagerAdapter.getItem(appIntroViewPager.getCurrentItem()) != null) {
            PagerAdapter pagerAdapter2 = this$0.pagerAdapter;
            if (pagerAdapter2 == null) {
                IIX0o.XOxIOxOx("pagerAdapter");
                pagerAdapter2 = null;
            }
            AppIntroViewPager appIntroViewPager2 = this$0.pager;
            if (appIntroViewPager2 == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager2 = null;
            }
            this$0.dispatchSlideChangedCallbacks(null, pagerAdapter2.getItem(appIntroViewPager2.getCurrentItem()));
            return;
        }
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void performColorTransition(Fragment fragment, Fragment fragment2, float f) {
        if ((fragment instanceof SlideBackgroundColorHolder) && (fragment2 instanceof SlideBackgroundColorHolder)) {
            if (fragment.isAdded() && fragment2.isAdded()) {
                SlideBackgroundColorHolder slideBackgroundColorHolder = (SlideBackgroundColorHolder) fragment;
                SlideBackgroundColorHolder slideBackgroundColorHolder2 = (SlideBackgroundColorHolder) fragment2;
                Object evaluate = this.argbEvaluator.evaluate(f, Integer.valueOf(getSlideColor(slideBackgroundColorHolder)), Integer.valueOf(getSlideColor(slideBackgroundColorHolder2)));
                if (evaluate != null) {
                    int intValue = ((Integer) evaluate).intValue();
                    slideBackgroundColorHolder.setBackgroundColor(intValue);
                    slideBackgroundColorHolder2.setBackgroundColor(intValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            return;
        }
        throw new IllegalStateException("Color transitions are only available if all slides implement SlideBackgroundColorHolder.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPermissions() {
        setSwipeLock(true);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper != null) {
            ActivityCompat.requestPermissions(this, permissionWrapper.getPermissions(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRequestPermission() {
        return this.permissionsMap.containsKey(Integer.valueOf(getCurrentSlideNumber()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtonsVisibility() {
        boolean z;
        boolean z2 = false;
        View view = null;
        if (this.isButtonsEnabled) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager = null;
            }
            boolean isLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager2 = null;
            }
            boolean isFirstSlide = appIntroViewPager2.isFirstSlide(this.fragments.size());
            View view2 = this.nextButton;
            if (view2 == null) {
                IIX0o.XOxIOxOx("nextButton");
                view2 = null;
            }
            AppIntroBaseKt.setVisible(view2, !isLastSlide);
            View view3 = this.doneButton;
            if (view3 == null) {
                IIX0o.XOxIOxOx("doneButton");
                view3 = null;
            }
            AppIntroBaseKt.setVisible(view3, isLastSlide);
            View view4 = this.skipButton;
            if (view4 == null) {
                IIX0o.XOxIOxOx("skipButton");
                view4 = null;
            }
            if (this.isSkipButtonEnabled && !isLastSlide) {
                z = true;
            } else {
                z = false;
            }
            AppIntroBaseKt.setVisible(view4, z);
            View view5 = this.backButton;
            if (view5 == null) {
                IIX0o.XOxIOxOx("backButton");
            } else {
                view = view5;
            }
            if (this.isWizardMode && !isFirstSlide) {
                z2 = true;
            }
            AppIntroBaseKt.setVisible(view, z2);
            return;
        }
        View view6 = this.nextButton;
        if (view6 == null) {
            IIX0o.XOxIOxOx("nextButton");
            view6 = null;
        }
        AppIntroBaseKt.setVisible(view6, false);
        View view7 = this.doneButton;
        if (view7 == null) {
            IIX0o.XOxIOxOx("doneButton");
            view7 = null;
        }
        AppIntroBaseKt.setVisible(view7, false);
        View view8 = this.backButton;
        if (view8 == null) {
            IIX0o.XOxIOxOx("backButton");
            view8 = null;
        }
        AppIntroBaseKt.setVisible(view8, false);
        View view9 = this.skipButton;
        if (view9 == null) {
            IIX0o.XOxIOxOx("skipButton");
        } else {
            view = view9;
        }
        AppIntroBaseKt.setVisible(view, false);
    }

    public final void addSlide(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        if (isRtl$appintro_release()) {
            this.fragments.add(0, fragment);
        } else {
            this.fragments.add(fragment);
        }
        PagerAdapter pagerAdapter = null;
        if (this.isWizardMode) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager = null;
            }
            appIntroViewPager.setOffscreenPageLimit(this.fragments.size());
        }
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 == null) {
            IIX0o.XOxIOxOx("pagerAdapter");
        } else {
            pagerAdapter = pagerAdapter2;
        }
        pagerAdapter.notifyDataSetChanged();
    }

    @xoIox
    public final void askForPermissions(@OOXIXo String[] permissions, int i) {
        IIX0o.x0xO0oo(permissions, "permissions");
        askForPermissions$default(this, permissions, i, false, 4, null);
    }

    @oOoXoXO
    public final IndicatorController getIndicatorController() {
        return this.indicatorController;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public final int getTotalSlidesNumber() {
        return this.slidesNumber;
    }

    public final long getVibrateDuration() {
        return this.vibrateDuration;
    }

    @xoIox
    public final void goToNextSlide() {
        goToNextSlide$default(this, false, 1, null);
    }

    public final void goToPreviousSlide() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.goToPreviousSlide();
    }

    public final boolean isButtonsEnabled() {
        return this.isButtonsEnabled;
    }

    public final boolean isColorTransitionsEnabled() {
        return this.isColorTransitionsEnabled;
    }

    public final boolean isIndicatorEnabled() {
        return this.isIndicatorEnabled;
    }

    public final boolean isRtl$appintro_release() {
        Context applicationContext = getApplicationContext();
        IIX0o.oO(applicationContext, "applicationContext");
        return LayoutUtil.isRtl(applicationContext);
    }

    public final boolean isSkipButtonEnabled() {
        return this.isSkipButtonEnabled;
    }

    public final boolean isSystemBackButtonLocked() {
        return this.isSystemBackButtonLocked;
    }

    public final boolean isVibrate() {
        return this.isVibrate;
    }

    public final boolean isWizardMode() {
        return this.isWizardMode;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isSystemBackButtonLocked) {
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        AppIntroViewPager appIntroViewPager2 = null;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        if (appIntroViewPager.isFirstSlide(this.fragments.size())) {
            super.onBackPressed();
            return;
        }
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager2 = appIntroViewPager3;
        }
        appIntroViewPager2.goToPreviousSlide();
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public boolean onCanRequestNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        AppIntroViewPager appIntroViewPager = null;
        if (pagerAdapter == null) {
            IIX0o.XOxIOxOx("pagerAdapter");
            pagerAdapter = null;
        }
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager = appIntroViewPager2;
        }
        ActivityResultCaller item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
        if ((item instanceof SlidePolicy) && !((SlidePolicy) item).isPolicyRespected()) {
            LogHelper.d(TAG, "Slide policy not respected, denying change request.");
            return false;
        }
        LogHelper.d(TAG, "Change request will be allowed.");
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        requestWindowFeature(1);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(bundle);
        this.indicatorController = new DotIndicatorController(this);
        showStatusBar(false);
        setContentView(getLayoutId());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.indicator_container);
        if (viewGroup != null) {
            this.indicatorContainer = viewGroup;
            View findViewById = findViewById(R.id.next);
            if (findViewById != null) {
                this.nextButton = findViewById;
                View findViewById2 = findViewById(R.id.done);
                if (findViewById2 != null) {
                    this.doneButton = findViewById2;
                    View findViewById3 = findViewById(R.id.skip);
                    if (findViewById3 != null) {
                        this.skipButton = findViewById3;
                        View findViewById4 = findViewById(R.id.back);
                        if (findViewById4 != null) {
                            this.backButton = findViewById4;
                            View view = this.nextButton;
                            AppIntroViewPager appIntroViewPager = null;
                            if (view == null) {
                                IIX0o.XOxIOxOx("nextButton");
                                view = null;
                            }
                            TooltipCompat.setTooltipText(view, getString(R.string.app_intro_next_button));
                            View view2 = this.skipButton;
                            if (view2 == null) {
                                IIX0o.XOxIOxOx("skipButton");
                                view2 = null;
                            }
                            if (view2 instanceof ImageButton) {
                                View view3 = this.skipButton;
                                if (view3 == null) {
                                    IIX0o.XOxIOxOx("skipButton");
                                    view3 = null;
                                }
                                TooltipCompat.setTooltipText(view3, getString(R.string.app_intro_skip_button));
                            }
                            View view4 = this.doneButton;
                            if (view4 == null) {
                                IIX0o.XOxIOxOx("doneButton");
                                view4 = null;
                            }
                            if (view4 instanceof ImageButton) {
                                View view5 = this.doneButton;
                                if (view5 == null) {
                                    IIX0o.XOxIOxOx("doneButton");
                                    view5 = null;
                                }
                                TooltipCompat.setTooltipText(view5, getString(R.string.app_intro_done_button));
                            }
                            View view6 = this.backButton;
                            if (view6 == null) {
                                IIX0o.XOxIOxOx("backButton");
                                view6 = null;
                            }
                            if (view6 instanceof ImageButton) {
                                View view7 = this.backButton;
                                if (view7 == null) {
                                    IIX0o.XOxIOxOx("backButton");
                                    view7 = null;
                                }
                                TooltipCompat.setTooltipText(view7, getString(R.string.app_intro_back_button));
                            }
                            if (isRtl$appintro_release()) {
                                View view8 = this.nextButton;
                                if (view8 == null) {
                                    IIX0o.XOxIOxOx("nextButton");
                                    view8 = null;
                                }
                                view8.setScaleX(-1.0f);
                                View view9 = this.backButton;
                                if (view9 == null) {
                                    IIX0o.XOxIOxOx("backButton");
                                    view9 = null;
                                }
                                view9.setScaleX(-1.0f);
                            }
                            Object systemService = getSystemService("vibrator");
                            if (systemService != null) {
                                this.vibrator = (Vibrator) systemService;
                                FragmentManager supportFragmentManager = getSupportFragmentManager();
                                IIX0o.oO(supportFragmentManager, "supportFragmentManager");
                                this.pagerAdapter = new PagerAdapter(supportFragmentManager, this.fragments);
                                View findViewById5 = findViewById(R.id.view_pager);
                                IIX0o.oO(findViewById5, "findViewById(R.id.view_pager)");
                                this.pager = (AppIntroViewPager) findViewById5;
                                View view10 = this.doneButton;
                                if (view10 == null) {
                                    IIX0o.XOxIOxOx("doneButton");
                                    view10 = null;
                                }
                                view10.setOnClickListener(new NextSlideOnClickListener(this, true));
                                View view11 = this.nextButton;
                                if (view11 == null) {
                                    IIX0o.XOxIOxOx("nextButton");
                                    view11 = null;
                                }
                                view11.setOnClickListener(new NextSlideOnClickListener(this, false));
                                View view12 = this.backButton;
                                if (view12 == null) {
                                    IIX0o.XOxIOxOx("backButton");
                                    view12 = null;
                                }
                                view12.setOnClickListener(new View.OnClickListener() { // from class: com.github.appintro.oIX0oI
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view13) {
                                        AppIntroBase.m257onCreate$lambda0(AppIntroBase.this, view13);
                                    }
                                });
                                View view13 = this.skipButton;
                                if (view13 == null) {
                                    IIX0o.XOxIOxOx("skipButton");
                                    view13 = null;
                                }
                                view13.setOnClickListener(new View.OnClickListener() { // from class: com.github.appintro.II0xO0
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view14) {
                                        AppIntroBase.m258onCreate$lambda1(AppIntroBase.this, view14);
                                    }
                                });
                                AppIntroViewPager appIntroViewPager2 = this.pager;
                                if (appIntroViewPager2 == null) {
                                    IIX0o.XOxIOxOx("pager");
                                    appIntroViewPager2 = null;
                                }
                                PagerAdapter pagerAdapter = this.pagerAdapter;
                                if (pagerAdapter == null) {
                                    IIX0o.XOxIOxOx("pagerAdapter");
                                    pagerAdapter = null;
                                }
                                appIntroViewPager2.setAdapter(pagerAdapter);
                                AppIntroViewPager appIntroViewPager3 = this.pager;
                                if (appIntroViewPager3 == null) {
                                    IIX0o.XOxIOxOx("pager");
                                    appIntroViewPager3 = null;
                                }
                                appIntroViewPager3.addOnPageChangeListener$appintro_release(new OnPageChangeListener(this));
                                AppIntroViewPager appIntroViewPager4 = this.pager;
                                if (appIntroViewPager4 == null) {
                                    IIX0o.XOxIOxOx("pager");
                                } else {
                                    appIntroViewPager = appIntroViewPager4;
                                }
                                appIntroViewPager.setOnNextPageRequestedListener(this);
                                setScrollDurationFactor(1);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
                        }
                        throw new IllegalStateException("Missing Back button: R.id.back");
                    }
                    throw new IllegalStateException("Missing Skip button: R.id.skip");
                }
                throw new IllegalStateException("Missing Done button: R.id.done");
            }
            throw new IllegalStateException("Missing Next button: R.id.next");
        }
        throw new IllegalStateException("Missing Indicator Container: R.id.indicator_container");
    }

    public void onDonePressed(@oOoXoXO Fragment fragment) {
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onIllegallyRequestedNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        AppIntroViewPager appIntroViewPager = null;
        if (pagerAdapter == null) {
            IIX0o.XOxIOxOx("pagerAdapter");
            pagerAdapter = null;
        }
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager = appIntroViewPager2;
        }
        ActivityResultCaller item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
        if (item instanceof SlidePolicy) {
            SlidePolicy slidePolicy = (SlidePolicy) item;
            if (!slidePolicy.isPolicyRespected()) {
                slidePolicy.onUserIllegallyRequestedNextPage();
            }
        }
    }

    public void onIntroFinished() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @OOXIXo KeyEvent event) {
        IIX0o.x0xO0oo(event, "event");
        if (i != 23 && i != 66 && i != 96) {
            return super.onKeyDown(i, event);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        AppIntroViewPager appIntroViewPager2 = null;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        boolean isLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
        goToNextSlide(isLastSlide);
        if (isLastSlide) {
            PagerAdapter pagerAdapter = this.pagerAdapter;
            if (pagerAdapter == null) {
                IIX0o.XOxIOxOx("pagerAdapter");
                pagerAdapter = null;
            }
            AppIntroViewPager appIntroViewPager3 = this.pager;
            if (appIntroViewPager3 == null) {
                IIX0o.XOxIOxOx("pager");
            } else {
                appIntroViewPager2 = appIntroViewPager3;
            }
            onDonePressed(pagerAdapter.getItem(appIntroViewPager2.getCurrentItem()));
            return false;
        }
        return false;
    }

    public void onNextPressed(@oOoXoXO Fragment fragment) {
    }

    public void onNextSlide() {
    }

    public void onPageSelected(int i) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(@oOoXoXO Bundle bundle) {
        super.onPostCreate(bundle);
        this.slidesNumber = this.fragments.size();
        initializeIndicator();
        this.retainIsButtonsEnabled = this.isButtonsEnabled;
        AppIntroViewPager appIntroViewPager = null;
        if (isRtl$appintro_release()) {
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager2 = null;
            }
            appIntroViewPager2.setCurrentItem(this.fragments.size() - this.savedCurrentItem);
        } else {
            AppIntroViewPager appIntroViewPager3 = this.pager;
            if (appIntroViewPager3 == null) {
                IIX0o.XOxIOxOx("pager");
                appIntroViewPager3 = null;
            }
            appIntroViewPager3.setCurrentItem(this.savedCurrentItem);
        }
        AppIntroViewPager appIntroViewPager4 = this.pager;
        if (appIntroViewPager4 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager = appIntroViewPager4;
        }
        appIntroViewPager.post(new Runnable() { // from class: com.github.appintro.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                AppIntroBase.m259onPostCreate$lambda2(AppIntroBase.this);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @OOXIXo String[] permissions, @OOXIXo int[] grantResults) {
        IIX0o.x0xO0oo(permissions, "permissions");
        IIX0o.x0xO0oo(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        setSwipeLock(false);
        if (i != 1) {
            return;
        }
        ArrayList arrayList = new ArrayList(grantResults.length);
        int length = grantResults.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = grantResults[i2];
            i2++;
            arrayList.add(Xo0.oIX0oI(permissions[i3], Integer.valueOf(i4)));
            i3++;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) ((Pair) obj).component2()).intValue() == -1) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(OxxIIOOXO.xo0x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add((String) ((Pair) it.next()).component1());
        }
        AppIntroViewPager appIntroViewPager = null;
        if (arrayList3.isEmpty()) {
            this.permissionsMap.remove(Integer.valueOf(getCurrentSlideNumber()));
            goToNextSlide$default(this, false, 1, null);
            return;
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            handleDeniedPermission((String) it2.next());
        }
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager = appIntroViewPager2;
        }
        appIntroViewPager.reCenterCurrentSlide$appintro_release();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@OOXIXo Bundle savedInstanceState) {
        IIX0o.x0xO0oo(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.slidesNumber = savedInstanceState.getInt(ARG_BUNDLE_SLIDES_NUMBER);
        this.retainIsButtonsEnabled = savedInstanceState.getBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED);
        setButtonsEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED));
        setSkipButtonEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED));
        setIndicatorEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED));
        this.savedCurrentItem = savedInstanceState.getInt(ARG_BUNDLE_CURRENT_ITEM);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.setFullPagingEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED));
        HashMap<Integer, PermissionWrapper> hashMap = (HashMap) savedInstanceState.getSerializable(ARG_BUNDLE_PERMISSION_MAP);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.permissionsMap = hashMap;
        setColorTransitionsEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@OOXIXo Bundle outState) {
        IIX0o.x0xO0oo(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_BUNDLE_SLIDES_NUMBER, this.slidesNumber);
        outState.putBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED, this.retainIsButtonsEnabled);
        outState.putBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED, isButtonsEnabled());
        outState.putBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED, isSkipButtonEnabled());
        outState.putBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED, isIndicatorEnabled());
        AppIntroViewPager appIntroViewPager = this.pager;
        AppIntroViewPager appIntroViewPager2 = null;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        outState.putInt(ARG_BUNDLE_CURRENT_ITEM, appIntroViewPager.getCurrentItem());
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            IIX0o.XOxIOxOx("pager");
        } else {
            appIntroViewPager2 = appIntroViewPager3;
        }
        outState.putBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED, appIntroViewPager2.isFullPagingEnabled());
        outState.putSerializable(ARG_BUNDLE_PERMISSION_MAP, this.permissionsMap);
        outState.putBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED, isColorTransitionsEnabled());
    }

    public void onSkipPressed(@oOoXoXO Fragment fragment) {
    }

    public void onSlideChanged(@oOoXoXO Fragment fragment, @oOoXoXO Fragment fragment2) {
    }

    public void onUserDeniedPermission(@OOXIXo String permissionName) {
        IIX0o.x0xO0oo(permissionName, "permissionName");
    }

    public void onUserDisabledPermission(@OOXIXo String permissionName) {
        IIX0o.x0xO0oo(permissionName, "permissionName");
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onUserRequestedPermissionsDialog() {
        LogHelper.d(TAG, IIX0o.XIxXXX0x0("Requesting Permissions on ", Integer.valueOf(getCurrentSlideNumber())));
        requestPermissions();
    }

    public final void setButtonsEnabled(boolean z) {
        this.isButtonsEnabled = z;
        updateButtonsVisibility();
    }

    public final void setColorTransitionsEnabled(boolean z) {
        this.isColorTransitionsEnabled = z;
    }

    public final void setCustomTransformer(@oOoXoXO ViewPager.PageTransformer pageTransformer) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.setPageTransformer(true, pageTransformer);
    }

    public final void setImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final void setIndicatorColor(@ColorInt int i, @ColorInt int i2) {
        IndicatorController indicatorController = this.indicatorController;
        if (indicatorController != null) {
            indicatorController.setSelectedIndicatorColor(i);
        }
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.setUnselectedIndicatorColor(i2);
        }
    }

    public final void setIndicatorController(@oOoXoXO IndicatorController indicatorController) {
        this.indicatorController = indicatorController;
    }

    public final void setIndicatorEnabled(boolean z) {
        this.isIndicatorEnabled = z;
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup == null) {
            IIX0o.XOxIOxOx("indicatorContainer");
            viewGroup = null;
        }
        AppIntroBaseKt.setVisible(viewGroup, z);
    }

    public final void setNavBarColor(@ColorInt int i) {
        getWindow().setNavigationBarColor(i);
    }

    public final void setNavBarColorRes(@ColorRes int i) {
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, i));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "setNextPageSwipeLock has been deprecated in favor of setSwipeLock or SlidePolicy", replaceWith = @XX(expression = "setSwipeLock", imports = {}))
    public final void setNextPageSwipeLock(boolean z) {
        LogHelper.w$default(TAG, "Calling setNextPageSwipeLock has not effect here. Please switch to setSwipeLock or SlidePolicy", null, 4, null);
    }

    public final void setProgressIndicator() {
        this.indicatorController = new ProgressIndicatorController(this, null, 0, 6, null);
    }

    public final void setScrollDurationFactor(int i) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.setScrollDurationFactor(i);
    }

    public final void setSkipButtonEnabled(boolean z) {
        this.isSkipButtonEnabled = z;
        updateButtonsVisibility();
    }

    public final void setStatusBarColor(@ColorInt int i) {
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(i);
    }

    public final void setStatusBarColorRes(@ColorRes int i) {
        setStatusBarColor(ContextCompat.getColor(this, i));
    }

    public final void setSwipeLock(boolean z) {
        if (z) {
            this.retainIsButtonsEnabled = this.isButtonsEnabled;
            setButtonsEnabled(true);
        } else {
            setButtonsEnabled(this.retainIsButtonsEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.setFullPagingEnabled(!z);
    }

    public final void setSystemBackButtonLocked(boolean z) {
        this.isSystemBackButtonLocked = z;
    }

    public final void setTransformer(@OOXIXo AppIntroPageTransformerType appIntroTransformer) {
        IIX0o.x0xO0oo(appIntroTransformer, "appIntroTransformer");
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.setAppIntroPageTransformer(appIntroTransformer);
    }

    public final void setVibrate(boolean z) {
        this.isVibrate = z;
    }

    public final void setVibrateDuration(long j) {
        this.vibrateDuration = j;
    }

    public final void setWizardMode(boolean z) {
        this.isWizardMode = z;
        setSkipButtonEnabled(!z);
        updateButtonsVisibility();
    }

    public final void showStatusBar(boolean z) {
        if (z) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().setFlags(1024, 1024);
        }
    }

    @xoIox
    public final void askForPermissions(@OOXIXo String[] permissions, int i, boolean z) {
        IIX0o.x0xO0oo(permissions, "permissions");
        if (Build.VERSION.SDK_INT >= 23) {
            if (i > 0) {
                this.permissionsMap.put(Integer.valueOf(i), new PermissionWrapper(permissions, i, z));
                return;
            }
            throw new IllegalStateException(IIX0o.XIxXXX0x0("Invalid Slide Number: ", Integer.valueOf(i)).toString());
        }
    }

    @xoIox
    public final void goToNextSlide(boolean z) {
        if (z) {
            onIntroFinished();
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            IIX0o.XOxIOxOx("pager");
            appIntroViewPager = null;
        }
        appIntroViewPager.goToNextSlide();
        onNextSlide();
    }
}
