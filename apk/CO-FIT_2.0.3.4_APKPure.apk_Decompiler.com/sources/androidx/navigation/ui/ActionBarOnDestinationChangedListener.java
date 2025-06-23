package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.IIX0o;

public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    @OOXIXo
    private final AppCompatActivity activity;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ActionBarOnDestinationChangedListener(@OXOo.OOXIXo androidx.appcompat.app.AppCompatActivity r3, @OXOo.OOXIXo androidx.navigation.ui.AppBarConfiguration r4) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            androidx.appcompat.app.ActionBarDrawerToggle$Delegate r0 = r3.getDrawerToggleDelegate()
            if (r0 == 0) goto L_0x001f
            android.content.Context r0 = r0.getActionBarThemedContext()
            java.lang.String r1 = "checkNotNull(activity.dr…  .actionBarThemedContext"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            r2.<init>(r0, r4)
            r2.activity = r3
            return
        L_0x001f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Activity "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = " does not have a DrawerToggleDelegate set"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.ActionBarOnDestinationChangedListener.<init>(androidx.appcompat.app.AppCompatActivity, androidx.navigation.ui.AppBarConfiguration):void");
    }

    public void setNavigationIcon(@oOoXoXO Drawable drawable, @StringRes int i) {
        boolean z;
        ActionBar supportActionBar = this.activity.getSupportActionBar();
        if (supportActionBar != null) {
            IIX0o.oO(supportActionBar, "checkNotNull(activity.su…ctionBar()\"\n            }");
            if (drawable != null) {
                z = true;
            } else {
                z = false;
            }
            supportActionBar.setDisplayHomeAsUpEnabled(z);
            ActionBarDrawerToggle.Delegate drawerToggleDelegate = this.activity.getDrawerToggleDelegate();
            if (drawerToggleDelegate != null) {
                IIX0o.oO(drawerToggleDelegate, "checkNotNull(activity.dr…legate set\"\n            }");
                drawerToggleDelegate.setActionBarUpIndicator(drawable, i);
                return;
            }
            throw new IllegalStateException(("Activity " + this.activity + " does not have a DrawerToggleDelegate set").toString());
        }
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }

    public void setTitle(@oOoXoXO CharSequence charSequence) {
        ActionBar supportActionBar = this.activity.getSupportActionBar();
        if (supportActionBar != null) {
            IIX0o.oO(supportActionBar, "checkNotNull(activity.su…ctionBar()\"\n            }");
            supportActionBar.setTitle(charSequence);
            return;
        }
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
