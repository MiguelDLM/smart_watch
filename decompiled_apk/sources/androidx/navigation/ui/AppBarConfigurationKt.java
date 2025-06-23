package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class AppBarConfigurationKt {
    @OOXIXo
    public static final AppBarConfiguration AppBarConfiguration(@OOXIXo NavGraph navGraph, @oOoXoXO Openable openable, @OOXIXo Oox.oIX0oI<Boolean> fallbackOnNavigateUpListener) {
        IIX0o.x0xO0oo(navGraph, "navGraph");
        IIX0o.x0xO0oo(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(navGraph).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph navGraph, Openable openable, Oox.oIX0oI fallbackOnNavigateUpListener, int i, Object obj) {
        if ((i & 2) != 0) {
            openable = null;
        }
        if ((i & 4) != 0) {
            fallbackOnNavigateUpListener = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        }
        IIX0o.x0xO0oo(navGraph, "navGraph");
        IIX0o.x0xO0oo(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(navGraph).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
    }

    @OOXIXo
    public static final AppBarConfiguration AppBarConfiguration(@OOXIXo Menu topLevelMenu, @oOoXoXO Openable openable, @OOXIXo Oox.oIX0oI<Boolean> fallbackOnNavigateUpListener) {
        IIX0o.x0xO0oo(topLevelMenu, "topLevelMenu");
        IIX0o.x0xO0oo(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(topLevelMenu).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu topLevelMenu, Openable openable, Oox.oIX0oI fallbackOnNavigateUpListener, int i, Object obj) {
        if ((i & 2) != 0) {
            openable = null;
        }
        if ((i & 4) != 0) {
            fallbackOnNavigateUpListener = new Oox.oIX0oI<Boolean>() { // from class: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        IIX0o.x0xO0oo(topLevelMenu, "topLevelMenu");
        IIX0o.x0xO0oo(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(topLevelMenu).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
    }

    @OOXIXo
    public static final AppBarConfiguration AppBarConfiguration(@OOXIXo Set<Integer> topLevelDestinationIds, @oOoXoXO Openable openable, @OOXIXo Oox.oIX0oI<Boolean> fallbackOnNavigateUpListener) {
        IIX0o.x0xO0oo(topLevelDestinationIds, "topLevelDestinationIds");
        IIX0o.x0xO0oo(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder(topLevelDestinationIds).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set topLevelDestinationIds, Openable openable, Oox.oIX0oI fallbackOnNavigateUpListener, int i, Object obj) {
        if ((i & 2) != 0) {
            openable = null;
        }
        if ((i & 4) != 0) {
            fallbackOnNavigateUpListener = new Oox.oIX0oI<Boolean>() { // from class: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            };
        }
        IIX0o.x0xO0oo(topLevelDestinationIds, "topLevelDestinationIds");
        IIX0o.x0xO0oo(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        return new AppBarConfiguration.Builder((Set<Integer>) topLevelDestinationIds).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
    }
}
