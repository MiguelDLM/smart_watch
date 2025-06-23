package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;

public final class CollapsingToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    @OOXIXo
    private final WeakReference<CollapsingToolbarLayout> mCollapsingToolbarLayoutWeakReference;
    @OOXIXo
    private final WeakReference<Toolbar> mToolbarWeakReference;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarOnDestinationChangedListener(@OXOo.OOXIXo com.google.android.material.appbar.CollapsingToolbarLayout r3, @OXOo.OOXIXo androidx.appcompat.widget.Toolbar r4, @OXOo.OOXIXo androidx.navigation.ui.AppBarConfiguration r5) {
        /*
            r2 = this;
            java.lang.String r0 = "collapsingToolbarLayout"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "toolbar"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "collapsingToolbarLayout.context"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            r2.<init>(r0, r5)
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r3)
            r2.mCollapsingToolbarLayoutWeakReference = r5
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r4)
            r2.mToolbarWeakReference = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.CollapsingToolbarOnDestinationChangedListener.<init>(com.google.android.material.appbar.CollapsingToolbarLayout, androidx.appcompat.widget.Toolbar, androidx.navigation.ui.AppBarConfiguration):void");
    }

    public void onDestinationChanged(@OOXIXo NavController navController, @OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(navController, "controller");
        IIX0o.x0xO0oo(navDestination, "destination");
        CollapsingToolbarLayout collapsingToolbarLayout = this.mCollapsingToolbarLayoutWeakReference.get();
        Toolbar toolbar = this.mToolbarWeakReference.get();
        if (collapsingToolbarLayout == null || toolbar == null) {
            navController.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(navController, navDestination, bundle);
        }
    }

    public void setNavigationIcon(@oOoXoXO Drawable drawable, @StringRes int i) {
        boolean z;
        Toolbar toolbar = this.mToolbarWeakReference.get();
        if (toolbar != null) {
            if (drawable != null || toolbar.getNavigationIcon() == null) {
                z = false;
            } else {
                z = true;
            }
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i);
            if (z) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }

    public void setTitle(@oOoXoXO CharSequence charSequence) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.mCollapsingToolbarLayoutWeakReference.get();
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(charSequence);
        }
    }
}
