package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

public final class AppBarConfigurationKt {
    @OOXIXo
    public static final AppBarConfiguration AppBarConfiguration(@OOXIXo NavGraph navGraph, @oOoXoXO Openable openable, @OOXIXo oIX0oI<Boolean> oix0oi) {
        IIX0o.x0xO0oo(navGraph, "navGraph");
        IIX0o.x0xO0oo(oix0oi, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(navGraph).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oix0oi)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph navGraph, Openable openable, oIX0oI oix0oi, int i, Object obj) {
        if ((i & 2) != 0) {
            openable = null;
        }
        if ((i & 4) != 0) {
            oix0oi = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        }
        IIX0o.x0xO0oo(navGraph, "navGraph");
        IIX0o.x0xO0oo(oix0oi, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(navGraph).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oix0oi)).build();
    }

    @OOXIXo
    public static final AppBarConfiguration AppBarConfiguration(@OOXIXo Menu menu, @oOoXoXO Openable openable, @OOXIXo oIX0oI<Boolean> oix0oi) {
        IIX0o.x0xO0oo(menu, "topLevelMenu");
        IIX0o.x0xO0oo(oix0oi, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(menu).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oix0oi)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu menu, Openable openable, oIX0oI oix0oi, int i, Object obj) {
        if ((i & 2) != 0) {
            openable = null;
        }
        if ((i & 4) != 0) {
            oix0oi = AppBarConfigurationKt$AppBarConfiguration$2.INSTANCE;
        }
        IIX0o.x0xO0oo(menu, "topLevelMenu");
        IIX0o.x0xO0oo(oix0oi, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(menu).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oix0oi)).build();
    }

    @OOXIXo
    public static final AppBarConfiguration AppBarConfiguration(@OOXIXo Set<Integer> set, @oOoXoXO Openable openable, @OOXIXo oIX0oI<Boolean> oix0oi) {
        IIX0o.x0xO0oo(set, "topLevelDestinationIds");
        IIX0o.x0xO0oo(oix0oi, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(set).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oix0oi)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set set, Openable openable, oIX0oI oix0oi, int i, Object obj) {
        if ((i & 2) != 0) {
            openable = null;
        }
        if ((i & 4) != 0) {
            oix0oi = AppBarConfigurationKt$AppBarConfiguration$3.INSTANCE;
        }
        IIX0o.x0xO0oo(set, "topLevelDestinationIds");
        IIX0o.x0xO0oo(oix0oi, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder((Set<Integer>) set).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oix0oi)).build();
    }
}
