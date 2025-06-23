package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.oxoX;

public final class NavigatorProviderKt {
    @OOXIXo
    public static final <T extends Navigator<? extends NavDestination>> T get(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo String str) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(str, "name");
        return navigatorProvider.getNavigator(str);
    }

    public static final void plusAssign(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo Navigator<? extends NavDestination> navigator) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(navigator, "navigator");
        navigatorProvider.addNavigator(navigator);
    }

    @oOoXoXO
    public static final Navigator<? extends NavDestination> set(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo String str, @OOXIXo Navigator<? extends NavDestination> navigator) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(navigator, "navigator");
        return navigatorProvider.addNavigator(str, navigator);
    }

    @OOXIXo
    public static final <T extends Navigator<? extends NavDestination>> T get(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo oxoX<T> oxox) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(oxox, "clazz");
        return navigatorProvider.getNavigator(II0xO0.X0o0xo(oxox));
    }
}
