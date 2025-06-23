package x0OOI;

import OIxOX.II0XooXoX;
import com.univocity.parsers.common.DataProcessingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f33838I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33839II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f33840Oxx0IOOO = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Method f33841X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Method f33842XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Field f33843oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Class<?> f33844oxoX;

    public II0xO0(Class<?> cls, Field field, IXoIo.II0xO0 iI0xO0) {
        Method method;
        this.f33844oxoX = cls;
        this.f33843oIX0oI = field;
        if (iI0xO0 != null) {
            method = iI0xO0.I0Io();
        } else {
            method = null;
        }
        this.f33841X0o0xo = method;
        this.f33842XO = iI0xO0 != null ? iI0xO0.oxoX() : null;
        II0xO0();
    }

    public Field I0Io() {
        return this.f33843oIX0oI;
    }

    public boolean II0XooXoX() {
        if (this.f33839II0xO0 < 0) {
            return true;
        }
        return false;
    }

    public final void II0xO0() {
        String str;
        II0XooXoX iI0XooXoX = (II0XooXoX) this.f33843oIX0oI.getAnnotation(II0XooXoX.class);
        if (iI0XooXoX != null) {
            int index = iI0XooXoX.index();
            this.f33839II0xO0 = index;
            if (index >= 0) {
                this.f33838I0Io = null;
                return;
            }
            str = iI0XooXoX.field();
        } else {
            str = "";
        }
        if (str.isEmpty()) {
            str = this.f33843oIX0oI.getName();
        }
        this.f33838I0Io = str;
    }

    public final void OOXIXo(Method method) {
        if (method == null && !this.f33840Oxx0IOOO) {
            this.f33843oIX0oI.setAccessible(true);
            this.f33840Oxx0IOOO = true;
        }
    }

    public int Oxx0IOOO() {
        return this.f33839II0xO0;
    }

    public Class<?> X0o0xo() {
        return this.f33843oIX0oI.getDeclaringClass();
    }

    public Class<?> XO() {
        return this.f33843oIX0oI.getType();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        II0xO0 iI0xO0 = (II0xO0) obj;
        if (this.f33839II0xO0 != iI0xO0.f33839II0xO0 || !this.f33843oIX0oI.equals(iI0xO0.f33843oIX0oI)) {
            return false;
        }
        String str = this.f33838I0Io;
        if (str == null ? iI0xO0.f33838I0Io != null : !str.equals(iI0xO0.f33838I0Io)) {
            return false;
        }
        return this.f33844oxoX.equals(iI0xO0.f33844oxoX);
    }

    public int hashCode() {
        int i;
        int hashCode = ((this.f33843oIX0oI.hashCode() * 31) + this.f33839II0xO0) * 31;
        String str = this.f33838I0Io;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return ((hashCode + i) * 31) + this.f33844oxoX.hashCode();
    }

    public boolean oIX0oI(Object obj) {
        Class<?> declaringClass;
        Method method = this.f33842XO;
        if (method != null) {
            declaringClass = method.getDeclaringClass();
        } else {
            declaringClass = this.f33843oIX0oI.getDeclaringClass();
        }
        return declaringClass.isAssignableFrom(obj.getClass());
    }

    public void oOoXoXO(Object obj, Object obj2) {
        OOXIXo(this.f33842XO);
        try {
            Method method = this.f33842XO;
            if (method != null) {
                method.invoke(obj, obj2);
            } else {
                this.f33843oIX0oI.set(obj, obj2);
            }
        } catch (Throwable th) {
            DataProcessingException dataProcessingException = new DataProcessingException("Unable to set value '" + obj2 + "' for field " + this.f33843oIX0oI.getName() + "' in " + this.f33844oxoX.getName(), th);
            dataProcessingException.markAsNonFatal();
            dataProcessingException.setValue(obj2);
            throw dataProcessingException;
        }
    }

    public String oxoX() {
        return this.f33838I0Io;
    }

    public Object xoIox(Object obj) {
        OOXIXo(this.f33841X0o0xo);
        try {
            Method method = this.f33841X0o0xo;
            if (method != null) {
                return method.invoke(obj, null);
            }
            return this.f33843oIX0oI.get(obj);
        } catch (Throwable th) {
            throw new DataProcessingException("Unable to get value from field " + this.f33843oIX0oI.getName() + "' in " + this.f33844oxoX.getName(), th);
        }
    }

    public boolean xxIXOIIO() {
        if (this.f33839II0xO0 >= 0) {
            return true;
        }
        return false;
    }
}
