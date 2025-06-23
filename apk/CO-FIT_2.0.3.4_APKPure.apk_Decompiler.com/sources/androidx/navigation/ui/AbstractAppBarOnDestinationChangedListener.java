package androidx.navigation.ui;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.huawei.openalliance.ad.constant.bn;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAbstractAppBarOnDestinationChangedListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractAppBarOnDestinationChangedListener.kt\nandroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    @oOoXoXO
    private ValueAnimator animator;
    @oOoXoXO
    private DrawerArrowDrawable arrowDrawable;
    @OOXIXo
    private final AppBarConfiguration configuration;
    @OOXIXo
    private final Context context;
    @oOoXoXO
    private final WeakReference<Openable> openableLayoutWeakReference;

    public AbstractAppBarOnDestinationChangedListener(@OOXIXo Context context2, @OOXIXo AppBarConfiguration appBarConfiguration) {
        WeakReference<Openable> weakReference;
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(appBarConfiguration, XO.f15419Oxx0IOOO);
        this.context = context2;
        this.configuration = appBarConfiguration;
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        if (openableLayout != null) {
            weakReference = new WeakReference<>(openableLayout);
        } else {
            weakReference = null;
        }
        this.openableLayoutWeakReference = weakReference;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private final void setActionBarUpIndicator(boolean z) {
        Pair pair;
        int i;
        float f;
        DrawerArrowDrawable drawerArrowDrawable = this.arrowDrawable;
        if (drawerArrowDrawable == null || (pair = Xo0.oIX0oI(drawerArrowDrawable, Boolean.TRUE)) == null) {
            DrawerArrowDrawable drawerArrowDrawable2 = new DrawerArrowDrawable(this.context);
            this.arrowDrawable = drawerArrowDrawable2;
            pair = Xo0.oIX0oI(drawerArrowDrawable2, Boolean.FALSE);
        }
        DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) pair.component1();
        boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
        if (z) {
            i = R.string.nav_app_bar_open_drawer_description;
        } else {
            i = R.string.nav_app_bar_navigate_up_description;
        }
        setNavigationIcon(drawerArrowDrawable3, i);
        if (z) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        if (booleanValue) {
            float progress = drawerArrowDrawable3.getProgress();
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawerArrowDrawable3, "progress", new float[]{progress, f});
            this.animator = ofFloat;
            IIX0o.x0XOIxOo(ofFloat, "null cannot be cast to non-null type android.animation.ObjectAnimator");
            ofFloat.start();
            return;
        }
        drawerArrowDrawable3.setProgress(f);
    }

    public void onDestinationChanged(@OOXIXo NavController navController, @OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle) {
        Openable openable;
        IIX0o.x0xO0oo(navController, "controller");
        IIX0o.x0xO0oo(navDestination, "destination");
        if (!(navDestination instanceof FloatingWindow)) {
            WeakReference<Openable> weakReference = this.openableLayoutWeakReference;
            if (weakReference != null) {
                openable = weakReference.get();
            } else {
                openable = null;
            }
            if (this.openableLayoutWeakReference == null || openable != null) {
                String fillInLabel = navDestination.fillInLabel(this.context, bundle);
                if (fillInLabel != null) {
                    setTitle(fillInLabel);
                }
                boolean isTopLevelDestination = this.configuration.isTopLevelDestination(navDestination);
                boolean z = false;
                if (openable != null || !isTopLevelDestination) {
                    if (openable != null && isTopLevelDestination) {
                        z = true;
                    }
                    setActionBarUpIndicator(z);
                    return;
                }
                setNavigationIcon((Drawable) null, 0);
                return;
            }
            navController.removeOnDestinationChangedListener(this);
        }
    }

    public abstract void setNavigationIcon(@oOoXoXO Drawable drawable, @StringRes int i);

    public abstract void setTitle(@oOoXoXO CharSequence charSequence);
}
