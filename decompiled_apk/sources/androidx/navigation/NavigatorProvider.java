package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.navigation.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavigatorProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavigatorProvider.kt\nandroidx/navigation/NavigatorProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1#2:179\n*E\n"})
@SuppressLint({"TypeParameterUnusedInFormals"})
/* loaded from: classes.dex */
public class NavigatorProvider {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final Map<Class<?>, String> annotationNames = new LinkedHashMap();

    @OOXIXo
    private final Map<String, Navigator<? extends NavDestination>> _navigators = new LinkedHashMap();

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final String getNameForNavigator$navigation_common_release(@OOXIXo Class<? extends Navigator<?>> navigatorClass) {
            IIX0o.x0xO0oo(navigatorClass, "navigatorClass");
            String str = (String) NavigatorProvider.annotationNames.get(navigatorClass);
            if (str == null) {
                Navigator.Name name = (Navigator.Name) navigatorClass.getAnnotation(Navigator.Name.class);
                if (name != null) {
                    str = name.value();
                } else {
                    str = null;
                }
                if (validateName$navigation_common_release(str)) {
                    NavigatorProvider.annotationNames.put(navigatorClass, str);
                } else {
                    throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + navigatorClass.getSimpleName()).toString());
                }
            }
            IIX0o.ooOOo0oXI(str);
            return str;
        }

        public final boolean validateName$navigation_common_release(@oOoXoXO String str) {
            if (str != null && str.length() > 0) {
                return true;
            }
            return false;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oOoXoXO
    public final Navigator<? extends NavDestination> addNavigator(@OOXIXo Navigator<? extends NavDestination> navigator) {
        IIX0o.x0xO0oo(navigator, "navigator");
        return addNavigator(Companion.getNameForNavigator$navigation_common_release(navigator.getClass()), navigator);
    }

    @OOXIXo
    public final <T extends Navigator<?>> T getNavigator(@OOXIXo Class<T> navigatorClass) {
        IIX0o.x0xO0oo(navigatorClass, "navigatorClass");
        return (T) getNavigator(Companion.getNameForNavigator$navigation_common_release(navigatorClass));
    }

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Navigator<? extends NavDestination>> getNavigators() {
        return o0.OX00O0xII(this._navigators);
    }

    @oOoXoXO
    @CallSuper
    public Navigator<? extends NavDestination> addNavigator(@OOXIXo String name, @OOXIXo Navigator<? extends NavDestination> navigator) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(navigator, "navigator");
        if (Companion.validateName$navigation_common_release(name)) {
            Navigator<? extends NavDestination> navigator2 = this._navigators.get(name);
            if (IIX0o.Oxx0IOOO(navigator2, navigator)) {
                return navigator;
            }
            boolean z = false;
            if (navigator2 != null && navigator2.isAttached()) {
                z = true;
            }
            if (!z) {
                if (!navigator.isAttached()) {
                    return this._navigators.put(name, navigator);
                }
                throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
            }
            throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @OOXIXo
    @CallSuper
    public <T extends Navigator<?>> T getNavigator(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        if (Companion.validateName$navigation_common_release(name)) {
            Navigator<? extends NavDestination> navigator = this._navigators.get(name);
            if (navigator != null) {
                return navigator;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + name + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
