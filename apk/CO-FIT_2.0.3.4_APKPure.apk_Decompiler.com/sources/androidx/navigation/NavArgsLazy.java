package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.II0xO0;
import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.X0IIOO;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.oxoX;

public final class NavArgsLazy<Args extends NavArgs> implements X0IIOO<Args> {
    @OOXIXo
    private final oIX0oI<Bundle> argumentProducer;
    @oOoXoXO
    private Args cached;
    @OOXIXo
    private final oxoX<Args> navArgsClass;

    public NavArgsLazy(@OOXIXo oxoX<Args> oxox, @OOXIXo oIX0oI<Bundle> oix0oi) {
        IIX0o.x0xO0oo(oxox, "navArgsClass");
        IIX0o.x0xO0oo(oix0oi, "argumentProducer");
        this.navArgsClass = oxox;
        this.argumentProducer = oix0oi;
    }

    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public Args getValue() {
        Args args = this.cached;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.argumentProducer.invoke();
        Method method = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
        if (method == null) {
            Class<Args> X0o0xo2 = II0xO0.X0o0xo(this.navArgsClass);
            Class[] methodSignature = NavArgsLazyKt.getMethodSignature();
            method = X0o0xo2.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
            NavArgsLazyKt.getMethodMap().put(this.navArgsClass, method);
            IIX0o.oO(method, "navArgsClass.java.getMet…                        }");
        }
        Args invoke2 = method.invoke((Object) null, new Object[]{invoke});
        IIX0o.x0XOIxOo(invoke2, "null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
        Args args2 = (NavArgs) invoke2;
        this.cached = args2;
        return args2;
    }
}
