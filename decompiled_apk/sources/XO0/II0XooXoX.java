package XO0;

import java.lang.reflect.Method;
import org.simple.eventbus.ThreadMode;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public ThreadMode f3835I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public I0Io f3836II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Method f3837oIX0oI;

    public II0XooXoX(Method method, I0Io i0Io, ThreadMode threadMode) {
        this.f3837oIX0oI = method;
        method.setAccessible(true);
        this.f3836II0xO0 = i0Io;
        this.f3835I0Io = threadMode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        II0XooXoX iI0XooXoX = (II0XooXoX) obj;
        I0Io i0Io = this.f3836II0xO0;
        if (i0Io == null) {
            if (iI0XooXoX.f3836II0xO0 != null) {
                return false;
            }
        } else if (!i0Io.equals(iI0XooXoX.f3836II0xO0)) {
            return false;
        }
        Method method = this.f3837oIX0oI;
        if (method == null) {
            if (iI0XooXoX.f3837oIX0oI != null) {
                return false;
            }
        } else if (!method.getName().equals(iI0XooXoX.f3837oIX0oI.getName())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        I0Io i0Io = this.f3836II0xO0;
        int i = 0;
        if (i0Io == null) {
            hashCode = 0;
        } else {
            hashCode = i0Io.hashCode();
        }
        int i2 = (hashCode + 31) * 31;
        Method method = this.f3837oIX0oI;
        if (method != null) {
            i = method.getName().hashCode();
        }
        return i2 + i;
    }
}
