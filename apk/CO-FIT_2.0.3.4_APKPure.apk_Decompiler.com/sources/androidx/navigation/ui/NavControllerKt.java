package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavController.kt\nandroidx/navigation/ui/NavControllerKt\n+ 2 AppBarConfiguration.kt\nandroidx/navigation/ui/AppBarConfigurationKt\n*L\n1#1,39:1\n248#2,9:40\n*S KotlinDebug\n*F\n+ 1 NavController.kt\nandroidx/navigation/ui/NavControllerKt\n*L\n30#1:40,9\n*E\n"})
public final class NavControllerKt {
    public static final boolean navigateUp(@OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(navController, "<this>");
        return NavigationUI.navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE)).build());
    }

    public static final boolean navigateUp(@OOXIXo NavController navController, @OOXIXo AppBarConfiguration appBarConfiguration) {
        IIX0o.x0xO0oo(navController, "<this>");
        IIX0o.x0xO0oo(appBarConfiguration, "appBarConfiguration");
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}
