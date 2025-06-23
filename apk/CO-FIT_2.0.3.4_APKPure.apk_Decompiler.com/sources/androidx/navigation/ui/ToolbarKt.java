package androidx.navigation.ui;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.appcompat.widget.Toolbar;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nToolbar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Toolbar.kt\nandroidx/navigation/ui/ToolbarKt\n+ 2 AppBarConfiguration.kt\nandroidx/navigation/ui/AppBarConfigurationKt\n*L\n1#1,73:1\n248#2,9:74\n248#2,9:83\n*S KotlinDebug\n*F\n+ 1 Toolbar.kt\nandroidx/navigation/ui/ToolbarKt\n*L\n47#1:74,9\n69#1:83,9\n*E\n"})
public final class ToolbarKt {
    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @oOoXoXO DrawerLayout drawerLayout) {
        IIX0o.x0xO0oo(toolbar, "<this>");
        IIX0o.x0xO0oo(navController, "navController");
        NavigationUI.setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(drawerLayout).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE)).build());
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout((Openable) null).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE)).build();
        }
        setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @OOXIXo AppBarConfiguration appBarConfiguration) {
        IIX0o.x0xO0oo(toolbar, "<this>");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(appBarConfiguration, XO.f15419Oxx0IOOO);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }
}
