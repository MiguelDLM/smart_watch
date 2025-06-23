package XO0;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.simple.eventbus.ThreadMode;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public ThreadMode f3853I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Method f3854II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Reference<Object> f3855oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public I0Io f3856oxoX;

    public Oxx0IOOO(Object obj, II0XooXoX iI0XooXoX) {
        this.f3855oIX0oI = new WeakReference(obj);
        this.f3854II0xO0 = iI0XooXoX.f3837oIX0oI;
        this.f3853I0Io = iI0XooXoX.f3835I0Io;
        this.f3856oxoX = iI0XooXoX.f3836II0xO0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) obj;
        if (this.f3855oIX0oI.get() == null) {
            if (oxx0IOOO.f3855oIX0oI.get() != null) {
                return false;
            }
        } else if (!this.f3855oIX0oI.get().equals(oxx0IOOO.f3855oIX0oI.get())) {
            return false;
        }
        Method method = this.f3854II0xO0;
        if (method == null) {
            if (oxx0IOOO.f3854II0xO0 != null) {
                return false;
            }
        } else if (!method.equals(oxx0IOOO.f3854II0xO0)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        Reference<Object> reference = this.f3855oIX0oI;
        int i = 0;
        if (reference == null) {
            hashCode = 0;
        } else {
            hashCode = reference.hashCode();
        }
        int i2 = (hashCode + 31) * 31;
        Method method = this.f3854II0xO0;
        if (method != null) {
            i = method.hashCode();
        }
        return i2 + i;
    }
}
