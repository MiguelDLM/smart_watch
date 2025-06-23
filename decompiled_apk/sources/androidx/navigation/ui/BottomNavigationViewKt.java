package androidx.navigation.ui;

import OXOo.OOXIXo;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class BottomNavigationViewKt {
    public static final void setupWithNavController(@OOXIXo NavigationBarView navigationBarView, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(navigationBarView, "<this>");
        IIX0o.x0xO0oo(navController, "navController");
        NavigationUI.setupWithNavController(navigationBarView, navController);
    }
}
