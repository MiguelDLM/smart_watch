package okhttp3.internal.platform.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.lang.reflect.Method;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public final class CloseGuard {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @oOoXoXO
    private final Method getMethod;

    @oOoXoXO
    private final Method openMethod;

    @oOoXoXO
    private final Method warnIfOpenMethod;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final CloseGuard get() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new CloseGuard(method3, method2, method);
        }

        private Companion() {
        }
    }

    public CloseGuard(@oOoXoXO Method method, @oOoXoXO Method method2, @oOoXoXO Method method3) {
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }

    @oOoXoXO
    public final Object createAndOpen(@OOXIXo String closer) {
        IIX0o.x0xO0oo(closer, "closer");
        Method method = this.getMethod;
        if (method != null) {
            try {
                Object invoke = method.invoke(null, null);
                Method method2 = this.openMethod;
                IIX0o.ooOOo0oXI(method2);
                method2.invoke(invoke, closer);
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean warnIfOpen(@oOoXoXO Object obj) {
        if (obj != null) {
            try {
                Method method = this.warnIfOpenMethod;
                IIX0o.ooOOo0oXI(method);
                method.invoke(obj, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
