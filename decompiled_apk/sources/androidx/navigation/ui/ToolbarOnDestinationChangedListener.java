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
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nToolbarOnDestinationChangedListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToolbarOnDestinationChangedListener.kt\nandroidx/navigation/ui/ToolbarOnDestinationChangedListener\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
/* loaded from: classes.dex */
public final class ToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {

    @OOXIXo
    private final WeakReference<Toolbar> toolbarWeakReference;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ToolbarOnDestinationChangedListener(@OXOo.OOXIXo androidx.appcompat.widget.Toolbar r3, @OXOo.OOXIXo androidx.navigation.ui.AppBarConfiguration r4) {
        /*
            r2 = this;
            java.lang.String r0 = "toolbar"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "toolbar.context"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            r2.<init>(r0, r4)
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r3)
            r2.toolbarWeakReference = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ToolbarOnDestinationChangedListener.<init>(androidx.appcompat.widget.Toolbar, androidx.navigation.ui.AppBarConfiguration):void");
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener, androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@OOXIXo NavController controller, @OOXIXo NavDestination destination, @oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(controller, "controller");
        IIX0o.x0xO0oo(destination, "destination");
        if (this.toolbarWeakReference.get() == null) {
            controller.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(controller, destination, bundle);
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    public void setNavigationIcon(@oOoXoXO Drawable drawable, @StringRes int i) {
        boolean z;
        Toolbar toolbar = this.toolbarWeakReference.get();
        if (toolbar != null) {
            if (drawable == null && toolbar.getNavigationIcon() != null) {
                z = true;
            } else {
                z = false;
            }
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i);
            if (z) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    public void setTitle(@oOoXoXO CharSequence charSequence) {
        Toolbar toolbar = this.toolbarWeakReference.get();
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
        }
    }
}
