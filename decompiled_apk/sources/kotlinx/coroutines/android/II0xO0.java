package kotlinx.coroutines.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.oOXoIIIo;

/* loaded from: classes6.dex */
public final class II0xO0 extends kotlin.coroutines.oIX0oI implements oOXoIIIo {

    @oOoXoXO
    private volatile Object _preHandler;

    public II0xO0() {
        super(oOXoIIIo.f30339II0XooXoX);
        this._preHandler = this;
    }

    public final Method IIXOooo() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // kotlinx.coroutines.oOXoIIIo
    public void IXxxXO(@OOXIXo CoroutineContext coroutineContext, @OOXIXo Throwable th) {
        Object obj;
        int i = Build.VERSION.SDK_INT;
        if (26 <= i && i < 28) {
            Method IIXOooo2 = IIXOooo();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            if (IIXOooo2 != null) {
                obj = IIXOooo2.invoke(null, null);
            } else {
                obj = null;
            }
            if (obj instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) obj;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
