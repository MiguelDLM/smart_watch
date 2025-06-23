package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCollapsingToolbarLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollapsingToolbarLayout.kt\nandroidx/navigation/ui/CollapsingToolbarLayoutKt\n+ 2 AppBarConfiguration.kt\nandroidx/navigation/ui/AppBarConfigurationKt\n*L\n1#1,79:1\n248#2,9:80\n248#2,9:89\n*S KotlinDebug\n*F\n+ 1 CollapsingToolbarLayout.kt\nandroidx/navigation/ui/CollapsingToolbarLayoutKt\n*L\n51#1:80,9\n75#1:89,9\n*E\n"})
/* loaded from: classes.dex */
public final class CollapsingToolbarLayoutKt {
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @oOoXoXO DrawerLayout drawerLayout) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "<this>");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE)).build());
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE)).build();
        }
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
    }

    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @OOXIXo AppBarConfiguration configuration) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "<this>");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(configuration, "configuration");
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, configuration);
    }
}
