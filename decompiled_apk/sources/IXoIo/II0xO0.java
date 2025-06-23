package IXoIo;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;

/* loaded from: classes13.dex */
public final class II0xO0 {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Method f746X0o0xo = II0xO0();

    /* renamed from: XO, reason: collision with root package name */
    public static final String f747XO = "!!NO_NAME!!";

    /* renamed from: I0Io, reason: collision with root package name */
    public Method f748I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Method f749II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Object f750oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f751oxoX;

    public II0xO0(Object obj) {
        this.f750oIX0oI = obj;
    }

    public static Method II0xO0() {
        try {
            return Object.class.getMethod(TTDownloadField.TT_HASHCODE, null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Object X0o0xo(Object obj, Method method) {
        try {
            return method.invoke(obj, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Method I0Io() {
        if (this.f748I0Io == null) {
            this.f748I0Io = (Method) X0o0xo(this.f750oIX0oI, oIX0oI.f757XO);
        }
        Method method = this.f748I0Io;
        if (method == f746X0o0xo) {
            return null;
        }
        return method;
    }

    public final String oIX0oI() {
        if (this.f751oxoX == null) {
            this.f751oxoX = (String) X0o0xo(this.f750oIX0oI, oIX0oI.f755Oxx0IOOO);
        }
        String str = this.f751oxoX;
        if (str == f747XO) {
            return null;
        }
        return str;
    }

    public final Method oxoX() {
        if (this.f749II0xO0 == null) {
            this.f749II0xO0 = (Method) X0o0xo(this.f750oIX0oI, oIX0oI.f756X0o0xo);
        }
        Method method = this.f749II0xO0;
        if (method == f746X0o0xo) {
            return null;
        }
        return method;
    }
}
