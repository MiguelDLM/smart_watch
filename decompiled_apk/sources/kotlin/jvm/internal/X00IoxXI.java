package kotlin.jvm.internal;

/* loaded from: classes6.dex */
public abstract class X00IoxXI<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T[] f29313I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f29314II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f29315oIX0oI;

    public X00IoxXI(int i) {
        this.f29315oIX0oI = i;
        this.f29313I0Io = (T[]) new Object[i];
    }

    public static /* synthetic */ void oxoX() {
    }

    public abstract int I0Io(@OXOo.OOXIXo T t);

    public final int II0xO0() {
        return this.f29314II0xO0;
    }

    @OXOo.OOXIXo
    public final T Oxx0IOOO(@OXOo.OOXIXo T values, @OXOo.OOXIXo T result) {
        IIX0o.x0xO0oo(values, "values");
        IIX0o.x0xO0oo(result, "result");
        kotlin.collections.oOXoIIIo it = new X0.oOoXoXO(0, this.f29315oIX0oI - 1).iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t = this.f29313I0Io[nextInt];
            if (t != null) {
                if (i < nextInt) {
                    int i3 = nextInt - i;
                    System.arraycopy(values, i, result, i2, i3);
                    i2 += i3;
                }
                int I0Io2 = I0Io(t);
                System.arraycopy(t, 0, result, i2, I0Io2);
                i2 += I0Io2;
                i = nextInt + 1;
            }
        }
        int i4 = this.f29315oIX0oI;
        if (i < i4) {
            System.arraycopy(values, i, result, i2, i4 - i);
        }
        return result;
    }

    public final void X0o0xo(int i) {
        this.f29314II0xO0 = i;
    }

    public final int XO() {
        int i;
        int i2 = 0;
        kotlin.collections.oOXoIIIo it = new X0.oOoXoXO(0, this.f29315oIX0oI - 1).iterator();
        while (it.hasNext()) {
            T t = this.f29313I0Io[it.nextInt()];
            if (t != null) {
                i = I0Io(t);
            } else {
                i = 1;
            }
            i2 += i;
        }
        return i2;
    }

    public final void oIX0oI(@OXOo.OOXIXo T spreadArgument) {
        IIX0o.x0xO0oo(spreadArgument, "spreadArgument");
        T[] tArr = this.f29313I0Io;
        int i = this.f29314II0xO0;
        this.f29314II0xO0 = i + 1;
        tArr[i] = spreadArgument;
    }
}
