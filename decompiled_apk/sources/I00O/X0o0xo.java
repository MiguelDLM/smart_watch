package I00O;

import java.util.Arrays;

/* loaded from: classes13.dex */
public abstract class X0o0xo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int[] f51II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oxoX<T>[] f54oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f50I0Io = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f55oxoX = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f52X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public int f53XO = 0;

    public X0o0xo(int i) {
        oxoX<T>[] oxoxArr = new oxoX[i];
        this.f54oIX0oI = oxoxArr;
        int[] iArr = new int[i];
        this.f51II0xO0 = iArr;
        Arrays.fill(iArr, -1);
        oxoxArr[0] = new oxoX<>(II0xO0(), 0);
        iArr[0] = 0;
    }

    public synchronized void I0Io(oxoX<T> oxox) {
        try {
            int i = oxox.f58II0xO0;
            if (i != -1) {
                int[] iArr = this.f51II0xO0;
                int i2 = this.f55oxoX;
                int i3 = i2 + 1;
                this.f55oxoX = i3;
                iArr[i2] = i;
                if (i3 == this.f54oIX0oI.length) {
                    this.f55oxoX = 0;
                }
                this.f52X0o0xo--;
            }
            notify();
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract T II0xO0();

    public synchronized oxoX<T> oIX0oI() {
        int i;
        oxoX<T>[] oxoxArr;
        while (true) {
            i = this.f52X0o0xo;
            oxoxArr = this.f54oIX0oI;
            if (i != oxoxArr.length) {
                break;
            }
            try {
                wait(50L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new oxoX<>(II0xO0(), -1);
            }
        }
        if (i == oxoxArr.length) {
            return new oxoX<>(II0xO0(), -1);
        }
        int[] iArr = this.f51II0xO0;
        int i2 = iArr[this.f50I0Io];
        if (i2 == -1) {
            i2 = this.f53XO + 1;
            this.f53XO = i2;
            iArr[i2] = i2;
            oxoxArr[i2] = new oxoX<>(II0xO0(), i2);
        }
        oxoX<T>[] oxoxArr2 = this.f54oIX0oI;
        oxoX<T> oxox = oxoxArr2[i2];
        int i3 = this.f50I0Io + 1;
        this.f50I0Io = i3;
        if (i3 == oxoxArr2.length) {
            this.f50I0Io = 0;
        }
        this.f52X0o0xo++;
        return oxox;
    }
}
