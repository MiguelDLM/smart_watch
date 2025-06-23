package androidx.navigation.ui;

import OXOo.OOXIXo;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class NavigationViewKt {
    public static final void setupWithNavController(@OOXIXo NavigationView navigationView, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(navigationView, "<this>");
        IIX0o.x0xO0oo(navController, "navController");
        NavigationUI.setupWithNavController(navigationView, navController);
    }
}
