package XIXIX;

import XIXIX.II0XooXoX.oIX0oI;
import java.util.List;

/* loaded from: classes9.dex */
public class II0XooXoX<T extends oIX0oI> {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static int f3745Oxx0IOOO;

    /* renamed from: I0Io, reason: collision with root package name */
    public Object[] f3746I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f3747II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public T f3748X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f3749XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3750oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f3751oxoX;

    /* loaded from: classes9.dex */
    public static abstract class oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public static int f3752Oo = -1;

        /* renamed from: XO, reason: collision with root package name */
        public int f3753XO = f3752Oo;

        public abstract oIX0oI oIX0oI();
    }

    public II0XooXoX(int i, T t) {
        if (i > 0) {
            this.f3747II0xO0 = i;
            this.f3746I0Io = new Object[i];
            this.f3751oxoX = 0;
            this.f3748X0o0xo = t;
            this.f3749XO = 1.0f;
            xxIXOIIO();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized II0XooXoX oIX0oI(int i, oIX0oI oix0oi) {
        II0XooXoX iI0XooXoX;
        synchronized (II0XooXoX.class) {
            iI0XooXoX = new II0XooXoX(i, oix0oi);
            int i2 = f3745Oxx0IOOO;
            iI0XooXoX.f3750oIX0oI = i2;
            f3745Oxx0IOOO = i2 + 1;
        }
        return iI0XooXoX;
    }

    public int I0Io() {
        return this.f3746I0Io.length;
    }

    public synchronized void II0XooXoX(List<T> list) {
        while (list.size() + this.f3751oxoX + 1 > this.f3747II0xO0) {
            try {
                OOXIXo();
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            int i2 = t.f3753XO;
            if (i2 != oIX0oI.f3752Oo) {
                if (i2 == this.f3750oIX0oI) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.f3753XO + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            t.f3753XO = this.f3750oIX0oI;
            this.f3746I0Io[this.f3751oxoX + 1 + i] = t;
        }
        this.f3751oxoX += size;
    }

    public synchronized T II0xO0() {
        T t;
        try {
            if (this.f3751oxoX == -1 && this.f3749XO > 0.0f) {
                xxIXOIIO();
            }
            Object[] objArr = this.f3746I0Io;
            int i = this.f3751oxoX;
            t = (T) objArr[i];
            t.f3753XO = oIX0oI.f3752Oo;
            this.f3751oxoX = i - 1;
        } catch (Throwable th) {
            throw th;
        }
        return t;
    }

    public final void OOXIXo() {
        int i = this.f3747II0xO0;
        int i2 = i * 2;
        this.f3747II0xO0 = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.f3746I0Io[i3];
        }
        this.f3746I0Io = objArr;
    }

    public synchronized void Oxx0IOOO(T t) {
        try {
            int i = t.f3753XO;
            if (i != oIX0oI.f3752Oo) {
                if (i == this.f3750oIX0oI) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.f3753XO + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            int i2 = this.f3751oxoX + 1;
            this.f3751oxoX = i2;
            if (i2 >= this.f3746I0Io.length) {
                OOXIXo();
            }
            t.f3753XO = this.f3750oIX0oI;
            this.f3746I0Io[this.f3751oxoX] = t;
        } catch (Throwable th) {
            throw th;
        }
    }

    public int X0o0xo() {
        return this.f3750oIX0oI;
    }

    public float XO() {
        return this.f3749XO;
    }

    public void oOoXoXO(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f3749XO = f;
    }

    public int oxoX() {
        return this.f3751oxoX + 1;
    }

    public final void xoIox(float f) {
        int i = this.f3747II0xO0;
        int i2 = (int) (i * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f3746I0Io[i3] = this.f3748X0o0xo.oIX0oI();
        }
        this.f3751oxoX = i - 1;
    }

    public final void xxIXOIIO() {
        xoIox(this.f3749XO);
    }
}
