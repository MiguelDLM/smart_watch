package xXoOI00O;

import android.content.Context;
import android.graphics.Bitmap;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.c;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.xoIox;
import oOoIIO0.Oxx0IOOO;
import oOoIIO0.ooOOo0oXI;
import x0.XX;
import x0.Xx000oIo;
import x0.XxX0x0xxx;
import x0.x0o;
import x0OxxIOxX.II0xO0;

/* loaded from: classes11.dex */
public class I0Io extends x0OxxIOxX.II0xO0 implements Oxx0IOOO, com.octopus.ad.internal.oIX0oI {

    /* renamed from: IIX0o, reason: collision with root package name */
    public II0xO0 f34703IIX0o;

    /* renamed from: IO, reason: collision with root package name */
    public long f34704IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f34705IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public long f34706X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public String f34707Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public String f34708oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public com.octopus.ad.internal.I0Io f34709oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public c f34710oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public boolean f34711ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f34713xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public ooOOo0oXI f34715xXxxox0I;

    /* renamed from: xII, reason: collision with root package name */
    public boolean f34714xII = false;

    /* renamed from: x0o, reason: collision with root package name */
    public boolean f34712x0o = false;

    /* loaded from: classes11.dex */
    public class II0xO0 implements com.octopus.ad.internal.II0xO0, Xx000oIo.I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        public NativeAdResponse f34717II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Xx000oIo f34718oIX0oI;

        /* renamed from: xXoOI00O.I0Io$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1164II0xO0 implements Xx000oIo.II0xO0 {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ NativeAdResponse f34720oIX0oI;

            public C1164II0xO0(NativeAdResponse nativeAdResponse) {
                this.f34720oIX0oI = nativeAdResponse;
            }

            @Override // x0.Xx000oIo.II0xO0
            public void oIX0oI(Bitmap bitmap) {
                this.f34720oIX0oI.setIcon(bitmap);
            }

            @Override // x0.Xx000oIo.II0xO0
            public void onFail() {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, "Image downloading logFailed for url " + this.f34720oIX0oI.getIconUrl());
            }
        }

        /* loaded from: classes11.dex */
        public class oIX0oI implements Xx000oIo.II0xO0 {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ NativeAdResponse f34722oIX0oI;

            public oIX0oI(NativeAdResponse nativeAdResponse) {
                this.f34722oIX0oI = nativeAdResponse;
            }

            @Override // x0.Xx000oIo.II0xO0
            public void oIX0oI(Bitmap bitmap) {
                this.f34722oIX0oI.oO(bitmap);
            }

            @Override // x0.Xx000oIo.II0xO0
            public void onFail() {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, "Image downloading logFailed for url " + this.f34722oIX0oI.getImageUrl());
            }
        }

        public II0xO0() {
        }

        @Override // x0.Xx000oIo.I0Io
        public void II0xO0() {
            if (I0Io.this.f34715xXxxox0I != null) {
                I0Io.this.f34715xXxxox0I.onAdLoaded(this.f34717II0xO0);
            }
            this.f34718oIX0oI = null;
            this.f34717II0xO0 = null;
            I0Io.this.f34712x0o = false;
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(boolean z) {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void oIX0oI(x0OxxIOxX.I0Io i0Io) {
            if (!i0Io.a().equals(l.NATIVE)) {
                a(oOoIIO0.I0Io.f32023xxIXOIIO);
                return;
            }
            NativeAdResponse c = i0Io.c();
            if (c == null) {
                return;
            }
            this.f34717II0xO0 = c;
            X0o0xo x0o0xo = (X0o0xo) c;
            if (I0Io.this.f34709oo.oI0IIXIo()) {
                x0o0xo.I0();
                return;
            }
            if (x0o0xo.O0xOxO() != 1) {
                I0Io.this.f34714xII = true;
                I0Io.this.f34704IO = System.currentTimeMillis();
                I0Io.this.X0o0xo(i0Io.e());
                I0Io.this.o00(i0Io.f());
                I0Io.this.oO(i0Io.h());
                I0Io.this.ooXIXxIX(c.II0XooXoX());
                x0o0xo.xX0IIXIx0();
                if (!I0Io.this.f34711ooXIXxIX && !I0Io.this.f34713xI) {
                    if (I0Io.this.f34715xXxxox0I != null) {
                        I0Io.this.f34715xXxxox0I.onAdLoaded(c);
                    }
                    I0Io.this.f34712x0o = false;
                    return;
                }
                this.f34718oIX0oI = new Xx000oIo();
                if (I0Io.this.f34711ooXIXxIX) {
                    this.f34718oIX0oI.oxoX(new oIX0oI(c), c.getImageUrl());
                }
                if (I0Io.this.f34713xI) {
                    this.f34718oIX0oI.oxoX(new C1164II0xO0(c), c.getIconUrl());
                }
                this.f34718oIX0oI.X0o0xo(this);
                this.f34718oIX0oI.oIX0oI();
                return;
            }
            a(oOoIIO0.I0Io.f32017XO);
            x0o0xo.O00XxXI();
            if (!x0o0xo.oXIO0o0XI()) {
                x0OxxIOxX.II0xO0.XO(I0Io.this.f34709oo.XO(), x0o0xo.oX(), I0Io.this.getMediaType());
            }
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(int i) {
            if (I0Io.this.f34715xXxxox0I != null) {
                I0Io.this.f34715xXxxox0I.onAdFailed(i);
            }
            I0Io.this.f34712x0o = false;
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a() {
            NativeAdResponse nativeAdResponse = this.f34717II0xO0;
            if (nativeAdResponse != null) {
                nativeAdResponse.destroy();
                this.f34717II0xO0 = null;
            }
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(String str, String str2) {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(long j) {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void b() {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void c() {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void d() {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void e() {
        }
    }

    public I0Io(Context context, String str, int i) {
        XxX0x0xxx.oxoX(context.getApplicationContext());
        XX.oxoX(context.getApplicationContext());
        com.octopus.ad.internal.I0Io i0Io = new com.octopus.ad.internal.I0Io(context, x0o.X0o0xo());
        this.f34709oo = i0Io;
        i0Io.oxoX(str);
        this.f34709oo.II0xO0(i);
        this.f34709oo.I0Io(l.NATIVE);
        c cVar = new c(this);
        this.f34710oo0xXOI0I = cVar;
        cVar.X0o0xo(-1);
        this.f34703IIX0o = new II0xO0();
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        NativeAdResponse nativeAdResponse;
        try {
            II0xO0 iI0xO0 = this.f34703IIX0o;
            if (iI0xO0 != null && (nativeAdResponse = iI0xO0.f34717II0xO0) != null) {
                X0o0xo x0o0xo = (X0o0xo) nativeAdResponse;
                x0o0xo.IoOoX(i, str, str2);
                x0o0xo.O00XxXI();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        NativeAdResponse nativeAdResponse;
        try {
            II0xO0 iI0xO0 = this.f34703IIX0o;
            if (iI0xO0 != null && (nativeAdResponse = iI0xO0.f34717II0xO0) != null) {
                ((X0o0xo) nativeAdResponse).XoI0Ixx0(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void IXxxXO(boolean z) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.set_opens_native_browser, z));
        this.f34709oo.ooOOo0oXI(z);
    }

    public com.octopus.ad.internal.I0Io IoOoX() {
        return this.f34709oo;
    }

    public void Oo(ooOOo0oXI ooooo0oxi) {
        this.f34715xXxxox0I = ooooo0oxi;
    }

    public void OxI(boolean z) {
        IXxxXO(z);
    }

    public boolean Oxx0xo() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.get_opens_native_browser, this.f34709oo.xoXoI()));
        return this.f34709oo.xoXoI();
    }

    public int X0IIOO() {
        return this.f34705IoOoX;
    }

    public void X0o0xo(int i) {
        this.f34705IoOoX = i;
    }

    public void XI0IXoo(String str) {
        this.f34709oo.II0XooXoX(str);
    }

    public void XIxXXX0x0(boolean z) {
        this.f34709oo.xxIXOIIO(z);
    }

    public void Xx000oIo() {
        this.f34703IIX0o.a();
    }

    public String XxX0x0xxx() {
        return this.f34708oOXoIIIo;
    }

    @Override // com.octopus.ad.internal.oIX0oI
    public l getMediaType() {
        return this.f34709oo.o00();
    }

    public void o00(String str) {
        this.f34708oOXoIIIo = str;
    }

    public boolean oI0IIXIo(II0xO0.C1145II0xO0 c1145II0xO0) {
        if (this.f34712x0o) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, "Still loading last nativead ad , won't load a new ad");
            return false;
        }
        if (!this.f34709oo.OxI()) {
            return false;
        }
        this.f34710oo0xXOI0I.oxoX();
        this.f34710oo0xXOI0I.xxIXOIIO();
        this.f34710oo0xXOI0I.Oxx0IOOO();
        this.f34712x0o = true;
        return true;
    }

    public void oO(long j) {
        xoIox.f19058ooXIXxIX = j;
        this.f34706X00IoxXI = j;
    }

    public com.octopus.ad.internal.II0xO0 oOXoIIIo() {
        return this.f34703IIX0o;
    }

    public String oo() {
        return this.f34709oo.oIX0oI();
    }

    public boolean oo0xXOI0I() {
        if (System.currentTimeMillis() - this.f34704IO < this.f34706X00IoxXI) {
            return true;
        }
        return false;
    }

    public void ooXIXxIX(String str) {
        this.f34707Xx000oIo = str;
    }

    @Override // com.octopus.ad.internal.oIX0oI
    public boolean oxoX() {
        return this.f34709oo.OxI();
    }

    public void x0xO0oo(String str) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.set_placement_id, str));
        this.f34709oo.oxoX(str);
    }

    public boolean xI() {
        return this.f34714xII;
    }

    public void xXxxox0I(String str) {
        this.f34709oo.oOoXoXO(str);
    }

    public String xoXoI() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.get_placement_id, this.f34709oo.xoIox()));
        return this.f34709oo.xoIox();
    }
}
