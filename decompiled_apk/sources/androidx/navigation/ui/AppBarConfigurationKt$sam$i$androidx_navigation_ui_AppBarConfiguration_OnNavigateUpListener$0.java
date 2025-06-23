package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.IIXOooo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XI0IXoo;

/* loaded from: classes.dex */
public final class AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements AppBarConfiguration.OnNavigateUpListener, XI0IXoo {
    private final /* synthetic */ Oox.oIX0oI function;

    public AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(Oox.oIX0oI function) {
        IIX0o.x0xO0oo(function, "function");
        this.function = function;
    }

    public final boolean equals(@oOoXoXO Object obj) {
        if ((obj instanceof AppBarConfiguration.OnNavigateUpListener) && (obj instanceof XI0IXoo)) {
            return IIX0o.Oxx0IOOO(getFunctionDelegate(), ((XI0IXoo) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.XI0IXoo
    @OOXIXo
    public final IIXOooo<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener
    public final /* synthetic */ boolean onNavigateUp() {
        return ((Boolean) this.function.invoke()).booleanValue();
    }
}
