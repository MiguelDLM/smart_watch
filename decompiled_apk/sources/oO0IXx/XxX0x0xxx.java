package oO0IXx;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class XxX0x0xxx implements xxX, xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public com.univocity.parsers.common.x0xO0oo f31915I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xxX f31916II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<xxX, com.univocity.parsers.common.x0xO0oo> f31917oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI extends com.univocity.parsers.common.x0xO0oo {

        /* renamed from: I0Io, reason: collision with root package name */
        public final int[] f31918I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String[] f31919II0xO0;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ com.univocity.parsers.common.oO f31921oxoX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(com.univocity.parsers.common.oO oOVar, com.univocity.parsers.common.oO oOVar2) {
            super(oOVar);
            this.f31921oxoX = oOVar2;
            this.f31919II0xO0 = XxX0x0xxx.this.II0xO0();
            this.f31918I0Io = XxX0x0xxx.this.I0Io();
        }

        @Override // com.univocity.parsers.common.x0xO0oo, com.univocity.parsers.common.oO
        public String[] X0o0xo() {
            String[] strArr = this.f31919II0xO0;
            if (strArr == null || strArr.length == 0) {
                return this.f31921oxoX.X0o0xo();
            }
            return strArr;
        }

        @Override // com.univocity.parsers.common.x0xO0oo, com.univocity.parsers.common.oO
        public int[] x0XOIxOo() {
            int[] iArr = this.f31918I0Io;
            if (iArr == null || iArr.length == 0) {
                return this.f31921oxoX.x0XOIxOo();
            }
            return iArr;
        }
    }

    public int[] I0Io() {
        return null;
    }

    public String[] II0xO0() {
        return null;
    }

    public abstract xxX X0o0xo(String[] strArr, com.univocity.parsers.common.oO oOVar);

    @Override // oO0IXx.xxX
    public void XO(com.univocity.parsers.common.oO oOVar) {
        oxoX(this.f31916II0xO0, null);
        this.f31916II0xO0 = xoXoI.f31964oIX0oI;
        for (Map.Entry<xxX, com.univocity.parsers.common.x0xO0oo> entry : this.f31917oIX0oI.entrySet()) {
            entry.getKey().XO(entry.getValue());
        }
    }

    @Override // oO0IXx.xxIXOIIO
    public boolean oIX0oI() {
        return true;
    }

    @Override // oO0IXx.xxX
    public void oO(com.univocity.parsers.common.oO oOVar) {
        this.f31917oIX0oI = new HashMap();
        this.f31916II0xO0 = xoXoI.f31964oIX0oI;
    }

    @Override // oO0IXx.xxX
    public final void x0XOIxOo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        xxX X0o0xo2 = X0o0xo(strArr, oOVar);
        if (X0o0xo2 == null) {
            X0o0xo2 = xoXoI.f31964oIX0oI;
        }
        xxX xxx2 = this.f31916II0xO0;
        if (X0o0xo2 != xxx2) {
            com.univocity.parsers.common.x0xO0oo x0xo0oo = this.f31917oIX0oI.get(X0o0xo2);
            this.f31915I0Io = x0xo0oo;
            if (x0xo0oo == null) {
                oIX0oI oix0oi = new oIX0oI(oOVar, oOVar);
                this.f31915I0Io = oix0oi;
                X0o0xo2.oO(oix0oi);
                this.f31917oIX0oI.put(X0o0xo2, this.f31915I0Io);
            }
            xxX xxx3 = this.f31916II0xO0;
            if (xxx3 != xoXoI.f31964oIX0oI) {
                oxoX(xxx3, X0o0xo2);
            }
            this.f31916II0xO0 = X0o0xo2;
            if (I0Io() != null) {
                int[] I0Io2 = I0Io();
                String[] strArr2 = new String[I0Io2.length];
                for (int i = 0; i < I0Io2.length; i++) {
                    int i2 = I0Io2[i];
                    if (i2 < strArr.length) {
                        strArr2[i] = strArr[i2];
                    }
                }
                strArr = strArr2;
            }
            this.f31916II0xO0.x0XOIxOo(strArr, this.f31915I0Io);
            return;
        }
        xxx2.x0XOIxOo(strArr, this.f31915I0Io);
    }

    public void oxoX(xxX xxx2, xxX xxx3) {
    }
}
