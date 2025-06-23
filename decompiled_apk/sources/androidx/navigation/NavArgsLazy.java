package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.X0IIOO;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.oxoX;

/* loaded from: classes.dex */
public final class NavArgsLazy<Args extends NavArgs> implements X0IIOO<Args> {

    @OOXIXo
    private final Oox.oIX0oI<Bundle> argumentProducer;

    @oOoXoXO
    private Args cached;

    @OOXIXo
    private final oxoX<Args> navArgsClass;

    public NavArgsLazy(@OOXIXo oxoX<Args> navArgsClass, @OOXIXo Oox.oIX0oI<Bundle> argumentProducer) {
        IIX0o.x0xO0oo(navArgsClass, "navArgsClass");
        IIX0o.x0xO0oo(argumentProducer, "argumentProducer");
        this.navArgsClass = navArgsClass;
        this.argumentProducer = argumentProducer;
    }

    @Override // kotlin.X0IIOO
    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.X0IIOO
    @OOXIXo
    public Args getValue() {
        Args args = this.cached;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.argumentProducer.invoke();
        Method method = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
        if (method == null) {
            Class X0o0xo2 = XO0OX.II0xO0.X0o0xo(this.navArgsClass);
            Class<Bundle>[] methodSignature = NavArgsLazyKt.getMethodSignature();
            method = X0o0xo2.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
            NavArgsLazyKt.getMethodMap().put(this.navArgsClass, method);
            IIX0o.oO(method, "navArgsClass.java.getMet…                        }");
        }
        Object invoke2 = method.invoke(null, invoke);
        IIX0o.x0XOIxOo(invoke2, "null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
        Args args2 = (Args) invoke2;
        this.cached = args2;
        return args2;
    }
}
