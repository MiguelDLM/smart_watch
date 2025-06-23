package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.google.android.material.navigation.NavigationBarView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavigationUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavigationUI.kt\nandroidx/navigation/ui/NavigationUI$setupWithNavController$12\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n*L\n1#1,714:1\n56#2,4:715\n*S KotlinDebug\n*F\n+ 1 NavigationUI.kt\nandroidx/navigation/ui/NavigationUI$setupWithNavController$12\n*L\n695#1:715,4\n*E\n"})
public final class NavigationUI$setupWithNavController$12 implements NavController.OnDestinationChangedListener {
    final /* synthetic */ NavController $navController;
    final /* synthetic */ WeakReference<NavigationBarView> $weakReference;

    public NavigationUI$setupWithNavController$12(WeakReference<NavigationBarView> weakReference, NavController navController) {
        this.$weakReference = weakReference;
        this.$navController = navController;
    }

    public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        IIX0o.x0xO0oo(navController, "controller");
        IIX0o.x0xO0oo(navDestination, "destination");
        NavigationBarView navigationBarView = this.$weakReference.get();
        if (navigationBarView == null) {
            this.$navController.removeOnDestinationChangedListener(this);
        } else if (!(navDestination instanceof FloatingWindow)) {
            Menu menu = navigationBarView.getMenu();
            IIX0o.oO(menu, "view.menu");
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                IIX0o.II0XooXoX(item, "getItem(index)");
                if (NavigationUI.matchDestination$navigation_ui_release(navDestination, item.getItemId())) {
                    item.setChecked(true);
                }
            }
        }
    }
}
