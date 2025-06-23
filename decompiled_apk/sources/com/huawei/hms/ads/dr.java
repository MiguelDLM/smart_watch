package com.huawei.hms.ads;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class dr {
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 33;
    private static final int F = 44;
    private static final int I = 4096;
    private static final int L = 249;
    private static final int S = 3;
    private static final int Z = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final long f17259a = 62914560;
    private static final String b = "dr";
    public int Code;
    private int[] E;
    private int G;
    private Bitmap J;
    private int[] K;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int T;
    private int U;
    public int V;
    private int W;
    private final int c;
    private InputStream d;
    private boolean j;
    private boolean k;
    private boolean l;
    private short[] m;
    private byte[] n;
    private byte[] p;
    private byte[] q;
    private int r;
    private int v;
    private int w;
    private int x;
    private int y;
    private final Object e = new Object();
    private final Object f = new Object();
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private byte[] o = new byte[512];
    private int s = 100;
    private int t = 0;
    private int u = 0;
    private int[] z = null;
    private int[] A = null;
    private int H = 0;
    private int M = 0;
    private int X = 0;
    private int[] Y = null;

    public dr(InputStream inputStream, int i) {
        this.d = inputStream;
        this.c = i;
        Z();
    }

    private void B() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) C());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.u = 1;
            return;
        }
        S();
        if (!this.j || D()) {
            return;
        }
        int[] Code = Code(this.v);
        this.z = Code;
        this.y = Code[this.x];
    }

    private int C() {
        try {
            return this.d.read();
        } catch (Exception unused) {
            this.u = 1;
            return 0;
        }
    }

    private Bitmap Code(int[] iArr, int i, int i2, Bitmap bitmap) {
        if (bitmap == null) {
            Bitmap.Config config = com.huawei.openalliance.ad.utils.w.V() > f17259a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (fb.Code()) {
                fb.Code(b, "create image with config %s", config);
            }
            bitmap = Bitmap.createBitmap(i, i2, config);
        }
        bitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return bitmap;
    }

    private boolean D() {
        return this.u != 0;
    }

    private int F() {
        return C() | (C() << 8);
    }

    private dt L() {
        int a2;
        dt dtVar = null;
        try {
            a2 = a();
        } catch (Exception | StackOverflowError unused) {
            this.u = 1;
            fb.I(b, "read image error");
        } catch (OutOfMemoryError unused2) {
            this.u = 1;
            fb.I(b, "run out of memory");
            f();
        }
        if (D()) {
            return null;
        }
        b();
        d();
        if (D()) {
            return null;
        }
        e();
        if (D()) {
            return null;
        }
        Bitmap bitmap = this.J;
        if (bitmap != null) {
            int i = this.M + 1;
            this.M = i;
            dtVar = new dt(i, bitmap, this.s);
        }
        if (this.i) {
            this.E[this.G] = a2;
        }
        g();
        return dtVar;
    }

    private void S() {
        this.Code = F();
        this.V = F();
        this.j = (C() & 128) != 0;
        this.v = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.x = C();
        C();
    }

    private void Z() {
        if (this.d == null) {
            Code(true);
            return;
        }
        B();
        if (D()) {
            Code(true);
            V();
        }
    }

    private int a() {
        int[] iArr;
        this.N = F();
        this.O = F();
        this.P = F();
        this.Q = F();
        int C2 = C();
        int i = 0;
        this.k = (C2 & 128) != 0;
        this.l = (C2 & 64) != 0;
        int pow = (int) Math.pow(2.0d, (C2 & 7) + 1);
        this.w = pow;
        if (this.k) {
            int[] Code = Code(pow);
            this.A = Code;
            this.E = Code;
        } else {
            this.E = this.z;
            if (this.x == this.G) {
                this.y = 0;
            }
        }
        if (this.i && (iArr = this.E) != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = this.G;
            if (length > i2) {
                int i3 = iArr[i2];
                iArr[i2] = 0;
                i = i3;
            }
        }
        if (this.E == null) {
            this.u = 1;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [short] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        short s;
        int i7 = this.P * this.Q;
        V(i7);
        int C2 = C();
        int i8 = 1 << C2;
        int i9 = i8 + 1;
        int i10 = i8 + 2;
        int i11 = C2 + 1;
        int i12 = (1 << i11) - 1;
        for (int i13 = 0; i13 < i8; i13++) {
            this.m[i13] = 0;
            this.n[i13] = (byte) i13;
        }
        int i14 = i11;
        int i15 = i10;
        int i16 = i12;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = 0;
        int i25 = 0;
        while (i17 < i7) {
            if (i18 != 0) {
                i = i9;
                i2 = i24;
                i3 = i8;
                int i26 = i23;
                i4 = i11;
                i5 = i26;
            } else if (i19 >= i14) {
                int i27 = i20 & i16;
                i20 >>= i14;
                i19 -= i14;
                if (i27 > i15 || i27 == i9) {
                    break;
                }
                if (i27 == i8) {
                    i14 = i11;
                    i15 = i10;
                    i16 = i12;
                    i23 = -1;
                } else {
                    int i28 = i23;
                    i4 = i11;
                    if (i28 == -1) {
                        this.p[i18] = this.n[i27 == true ? 1 : 0];
                        i24 = i27 == true ? 1 : 0;
                        i18++;
                        i11 = i4;
                        i9 = i9;
                        i23 = i24;
                    } else {
                        i = i9;
                        if (i27 == i15) {
                            byte[] bArr = this.p;
                            i6 = i27 == true ? 1 : 0;
                            bArr[i18] = (byte) i24;
                            s = i28;
                            i18++;
                        } else {
                            i6 = i27 == true ? 1 : 0;
                            s = i27;
                        }
                        while (s > i8) {
                            this.p[i18] = this.n[s];
                            s = this.m[s];
                            i18++;
                            i8 = i8;
                        }
                        i3 = i8;
                        byte[] bArr2 = this.n;
                        i2 = bArr2[s] & 255;
                        if (i15 >= 4096) {
                            break;
                        }
                        int i29 = i18 + 1;
                        byte b2 = (byte) i2;
                        this.p[i18] = b2;
                        this.m[i15] = (short) i28;
                        bArr2[i15] = b2;
                        i15++;
                        if ((i15 & i16) == 0 && i15 < 4096) {
                            i14++;
                            i16 += i15;
                        }
                        i5 = i6;
                        i18 = i29;
                    }
                }
            } else {
                if (i21 == 0) {
                    i21 = h();
                    if (i21 <= 0) {
                        break;
                    } else {
                        i22 = 0;
                    }
                }
                i20 += (this.o[i22] & 255) << i19;
                i19 += 8;
                i22++;
                i21--;
            }
            i18--;
            this.q[i25] = this.p[i18];
            i17++;
            i25++;
            i8 = i3;
            i9 = i;
            i24 = i2;
            int i30 = i4;
            i23 = i5;
            i11 = i30;
        }
        for (int i31 = i25; i31 < i7; i31++) {
            this.q[i31] = 0;
        }
    }

    private void c() {
        C();
        int C2 = C();
        int i = (C2 & 28) >> 2;
        this.t = i;
        if (i == 0) {
            this.t = 1;
        }
        this.i = (C2 & 1) != 0;
        int F2 = F() * 10;
        this.s = F2;
        int i2 = this.c;
        if (i2 > F2) {
            this.s = i2;
        }
        this.G = C();
        C();
    }

    private void d() {
        do {
            h();
            if (this.X <= 0) {
                return;
            }
        } while (!D());
    }

    private void e() {
        int i;
        try {
            i();
            int i2 = 0;
            int i3 = 0;
            int i4 = 8;
            int i5 = 1;
            while (true) {
                int i6 = this.Q;
                if (i2 >= i6) {
                    this.J = Code(this.Y, this.Code, this.V, this.J);
                    return;
                }
                if (this.l) {
                    if (i3 >= i6) {
                        i5++;
                        if (i5 == 2) {
                            i3 = 4;
                        } else if (i5 == 3) {
                            i3 = 2;
                            i4 = 4;
                        } else if (i5 == 4) {
                            i3 = 1;
                            i4 = 2;
                        }
                    }
                    i = i3 + i4;
                } else {
                    i = i3;
                    i3 = i2;
                }
                int i7 = i3 + this.O;
                if (i7 < this.V) {
                    int i8 = this.Code;
                    int i9 = i7 * i8;
                    int i10 = this.N + i9;
                    int i11 = this.P;
                    int i12 = i10 + i11;
                    if (i9 + i8 < i12) {
                        i12 = i9 + i8;
                    }
                    int i13 = i11 * i2;
                    while (i10 < i12) {
                        int i14 = i13 + 1;
                        int i15 = this.E[this.q[i13] & 255];
                        if (i15 != 0) {
                            this.Y[i10] = i15;
                        }
                        i10++;
                        i13 = i14;
                    }
                }
                i2++;
                i3 = i;
            }
        } catch (Exception | StackOverflowError unused) {
            this.u = 1;
            fb.I(b, "set pixel error");
        }
    }

    private void f() {
        this.u = 3;
    }

    private void g() {
        this.H = this.t;
        this.R = this.N;
        this.T = this.O;
        this.U = this.P;
        this.W = this.Q;
        this.r = this.y;
        this.K = this.Y;
        this.i = false;
        this.t = 0;
        this.A = null;
        this.s = this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int h() {
        /*
            r4 = this;
            int r0 = r4.C()
            r4.X = r0
            r1 = 0
            if (r0 <= 0) goto L30
        L9:
            int r0 = r4.X     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            if (r1 >= r0) goto L29
            java.io.InputStream r2 = r4.d     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            byte[] r3 = r4.o     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            int r0 = r0 - r1
            int r0 = r2.read(r3, r1, r0)     // Catch: java.lang.Exception -> L1c java.io.IOException -> L24
            r2 = -1
            if (r0 != r2) goto L1a
            goto L29
        L1a:
            int r1 = r1 + r0
            goto L9
        L1c:
            java.lang.String r0 = com.huawei.hms.ads.dr.b
            java.lang.String r2 = "read block fail"
        L20:
            com.huawei.hms.ads.fb.I(r0, r2)
            goto L29
        L24:
            java.lang.String r0 = com.huawei.hms.ads.dr.b
            java.lang.String r2 = "read block IOException"
            goto L20
        L29:
            int r0 = r4.X
            if (r1 >= r0) goto L30
            r0 = 1
            r4.u = r0
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dr.h():int");
    }

    private void i() {
        if (this.Y == null) {
            this.Y = new int[this.Code * this.V];
        }
        int i = this.H;
        if (i > 0) {
            if (3 == i) {
                this.K = null;
            }
            int[] iArr = this.K;
            if (iArr != null) {
                this.Y = iArr;
                if (2 == i) {
                    int i2 = !this.i ? this.r : 0;
                    for (int i3 = 0; i3 < this.W; i3++) {
                        int i4 = ((this.T + i3) * this.Code) + this.R;
                        int i5 = this.U + i4;
                        while (i4 < i5) {
                            this.Y[i4] = i2;
                            i4++;
                        }
                    }
                }
            }
        }
    }

    private boolean j() {
        boolean z;
        synchronized (this.f) {
            z = this.h;
        }
        return z;
    }

    public boolean I() {
        boolean z;
        synchronized (this.e) {
            z = this.g;
        }
        return z;
    }

    public void V() {
        synchronized (this.e) {
            try {
                if (!this.g) {
                    this.g = true;
                    com.huawei.openalliance.ad.utils.ax.Code((Closeable) this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void V(int i) {
        byte[] bArr = this.q;
        if (bArr == null || bArr.length < i) {
            this.q = new byte[i];
        }
        if (this.m == null) {
            this.m = new short[4096];
        }
        if (this.n == null) {
            this.n = new byte[4096];
        }
        if (this.p == null) {
            this.p = new byte[4097];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0050, code lost:
    
        if (j() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0052, code lost:
    
        V();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0055, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.huawei.hms.ads.dt Code() {
        /*
            r4 = this;
            boolean r0 = r4.I()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lc
            r4.Code(r2)
            return r1
        Lc:
            boolean r0 = r4.j()
            if (r0 != 0) goto L4c
            boolean r0 = r4.D()
            if (r0 == 0) goto L1c
            r4.Code(r2)
            goto L4c
        L1c:
            int r0 = r4.C()
            if (r0 == 0) goto Lc
            r3 = 33
            if (r0 == r3) goto L3c
            r3 = 44
            if (r0 == r3) goto L35
            r3 = 59
            if (r0 == r3) goto L31
            r4.u = r2
            goto Lc
        L31:
            r4.Code(r2)
            goto Lc
        L35:
            com.huawei.hms.ads.dt r0 = r4.L()
            if (r0 == 0) goto Lc
            return r0
        L3c:
            int r0 = r4.C()
            r3 = 249(0xf9, float:3.49E-43)
            if (r3 != r0) goto L48
            r4.c()
            goto Lc
        L48:
            r4.d()
            goto Lc
        L4c:
            boolean r0 = r4.j()
            if (r0 == 0) goto L55
            r4.V()
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dr.Code():com.huawei.hms.ads.dt");
    }

    private void Code(boolean z) {
        synchronized (this.f) {
            this.h = z;
        }
    }

    private int[] Code(int i) {
        int i2;
        int[] iArr = new int[256];
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.d.read(bArr);
        } catch (Exception unused) {
            fb.I(b, "read color table fail");
            i2 = 0;
        }
        if (i2 < i3) {
            this.u = 1;
        } else {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = bArr[i4] & 255;
                int i7 = i4 + 2;
                int i8 = bArr[i4 + 1] & 255;
                i4 += 3;
                iArr[i5] = (i8 << 8) | (i6 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i7] & 255);
            }
        }
        return iArr;
    }
}
