package oOoIIO0;

import android.os.Bundle;
import java.util.Date;
import java.util.Set;
import x0OxxIOxX.II0xO0;

/* loaded from: classes11.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f32011I0Io = 80001;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f32012II0XooXoX = 80102;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f32013II0xO0 = 80000;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f32014OOXIXo = 80201;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f32015Oxx0IOOO = 80101;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f32016X0o0xo = 80003;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f32017XO = 80100;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f32018oOoXoXO = 80202;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f32019ooOOo0oXI = 80203;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f32020oxoX = 80002;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f32021x0XOIxOo = x0OxxIOxX.II0xO0.f33845XxX0x0xxx;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f32022xoIox = 80200;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f32023xxIXOIIO = 80103;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final II0xO0.C1145II0xO0 f32024oIX0oI;

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final II0xO0.C1145II0xO0 f32025oIX0oI;

        public II0xO0() {
            II0xO0.C1145II0xO0 c1145II0xO0 = new II0xO0.C1145II0xO0();
            this.f32025oIX0oI = c1145II0xO0;
            c1145II0xO0.OOXIXo(I0Io.f32021x0XOIxOo);
        }

        public II0xO0 I0Io(Class<? extends Object> cls, Bundle bundle) {
            this.f32025oIX0oI.X0o0xo(cls, bundle);
            return this;
        }

        public II0xO0 II0XooXoX(int i) {
            this.f32025oIX0oI.oxoX(i);
            return this;
        }

        public II0xO0 II0xO0(String str) {
            this.f32025oIX0oI.XO(str);
            return this;
        }

        public II0xO0 OOXIXo(boolean z) {
            this.f32025oIX0oI.II0XooXoX(z);
            return this;
        }

        public II0xO0 Oxx0IOOO(String str) {
            boolean z;
            com.octopus.ad.internal.x0XOIxOo.oIX0oI(str, "Content URL must be non-null.");
            com.octopus.ad.internal.x0XOIxOo.II0xO0(str, "Content URL must be non-empty.");
            if (str.length() <= 512) {
                z = true;
            } else {
                z = false;
            }
            com.octopus.ad.internal.x0XOIxOo.oxoX(z, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.f32025oIX0oI.oO(str);
            return this;
        }

        public I0Io X0o0xo() {
            return new I0Io(this);
        }

        public II0xO0 XO(Date date) {
            this.f32025oIX0oI.Oxx0IOOO(date);
            return this;
        }

        public II0xO0 oxoX(String str) {
            this.f32025oIX0oI.OOXIXo(str);
            return this;
        }

        public II0xO0 xoIox(String str) {
            this.f32025oIX0oI.IXxxXO(str);
            return this;
        }

        public II0xO0 xxIXOIIO(boolean z) {
            this.f32025oIX0oI.oOoXoXO(z);
            return this;
        }
    }

    public int I0Io() {
        return this.f32024oIX0oI.ooOOo0oXI();
    }

    public String II0xO0() {
        return this.f32024oIX0oI.xxIXOIIO();
    }

    public <T> Bundle X0o0xo(Class<T> cls) {
        return this.f32024oIX0oI.oIX0oI(cls);
    }

    public II0xO0.C1145II0xO0 XO() {
        return this.f32024oIX0oI;
    }

    public Date oIX0oI() {
        return this.f32024oIX0oI.II0xO0();
    }

    public Set<String> oxoX() {
        return this.f32024oIX0oI.Oo();
    }

    public I0Io(II0xO0 iI0xO0) {
        this.f32024oIX0oI = iI0xO0.f32025oIX0oI;
    }
}
