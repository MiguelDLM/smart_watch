package androidx.navigation.ui;

import OXOo.OOXIXo;
import android.view.MenuItem;
import androidx.navigation.NavController;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class MenuItemKt {
    public static final boolean onNavDestinationSelected(@OOXIXo MenuItem menuItem, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(menuItem, "<this>");
        IIX0o.x0xO0oo(navController, "navController");
        return NavigationUI.onNavDestinationSelected(menuItem, navController);
    }
}
