package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.IIXOooo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XI0IXoo;

public final class AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements AppBarConfiguration.OnNavigateUpListener, XI0IXoo {
    private final /* synthetic */ oIX0oI function;

    public AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "function");
        this.function = oix0oi;
    }

    public final boolean equals(@oOoXoXO Object obj) {
        if (!(obj instanceof AppBarConfiguration.OnNavigateUpListener) || !(obj instanceof XI0IXoo)) {
            return false;
        }
        return IIX0o.Oxx0IOOO(getFunctionDelegate(), ((XI0IXoo) obj).getFunctionDelegate());
    }

    @OOXIXo
    public final IIXOooo<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ boolean onNavigateUp() {
        return ((Boolean) this.function.invoke()).booleanValue();
    }
}
