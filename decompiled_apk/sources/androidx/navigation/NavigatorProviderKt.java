package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.oxoX;

/* loaded from: classes.dex */
public final class NavigatorProviderKt {
    @OOXIXo
    public static final <T extends Navigator<? extends NavDestination>> T get(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo String name) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(name, "name");
        return (T) navigatorProvider.getNavigator(name);
    }

    public static final void plusAssign(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo Navigator<? extends NavDestination> navigator) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(navigator, "navigator");
        navigatorProvider.addNavigator(navigator);
    }

    @oOoXoXO
    public static final Navigator<? extends NavDestination> set(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo String name, @OOXIXo Navigator<? extends NavDestination> navigator) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(navigator, "navigator");
        return navigatorProvider.addNavigator(name, navigator);
    }

    @OOXIXo
    public static final <T extends Navigator<? extends NavDestination>> T get(@OOXIXo NavigatorProvider navigatorProvider, @OOXIXo oxoX<T> clazz) {
        IIX0o.x0xO0oo(navigatorProvider, "<this>");
        IIX0o.x0xO0oo(clazz, "clazz");
        return (T) navigatorProvider.getNavigator(XO0OX.II0xO0.X0o0xo(clazz));
    }
}
