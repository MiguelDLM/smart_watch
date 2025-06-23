package xXoOI00O;

import android.util.Log;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.oOoXoXO;
import java.lang.ref.SoftReference;
import java.util.concurrent.RejectedExecutionException;
import o0IXXIx.xoIox;

/* loaded from: classes11.dex */
public class oxoX extends oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final SoftReference<I0Io> f34819I0Io;

    /* loaded from: classes11.dex */
    public class oIX0oI implements x0OxxIOxX.I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ x0OxxIOxX.oIX0oI f34821II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ X0o0xo f34822oIX0oI;

        public oIX0oI(X0o0xo x0o0xo, x0OxxIOxX.oIX0oI oix0oi) {
            this.f34822oIX0oI = x0o0xo;
            this.f34821II0xO0 = oix0oi;
        }

        @Override // x0OxxIOxX.I0Io
        public l a() {
            return l.NATIVE;
        }

        @Override // x0OxxIOxX.I0Io
        public com.octopus.ad.internal.view.I0Io b() {
            return null;
        }

        @Override // x0OxxIOxX.I0Io
        public NativeAdResponse c() {
            return this.f34822oIX0oI;
        }

        @Override // x0OxxIOxX.I0Io
        public String d() {
            return "";
        }

        @Override // x0OxxIOxX.I0Io
        public int e() {
            return this.f34821II0xO0.xII();
        }

        @Override // x0OxxIOxX.I0Io
        public String f() {
            return this.f34821II0xO0.OI0();
        }

        @Override // x0OxxIOxX.I0Io
        public String g() {
            return null;
        }

        @Override // x0OxxIOxX.I0Io
        public long h() {
            return this.f34821II0xO0.XX();
        }

        @Override // x0OxxIOxX.I0Io
        public void i() {
            this.f34822oIX0oI.destroy();
        }
    }

    public oxoX(I0Io i0Io) {
        this.f34819I0Io = new SoftReference<>(i0Io);
    }

    @Override // com.octopus.ad.internal.oOoXoXO
    public void II0xO0() {
        I0Io i0Io = this.f34819I0Io.get();
        if (i0Io != null) {
            i0Io.cancel(true);
        }
    }

    public void X0o0xo(x0OxxIOxX.I0Io i0Io) {
        oxoX();
        I0Io i0Io2 = this.f34819I0Io.get();
        if (i0Io2 != null) {
            i0Io2.oOXoIIIo().oIX0oI(i0Io);
        } else {
            i0Io.i();
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public void a() {
        I0Io i0Io = this.f34819I0Io.get();
        if (i0Io == null) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Before execute request manager, you should set ad request!");
            return;
        }
        I0Io();
        try {
            i0Io.Oxx0IOOO(this);
            i0Io.executeOnExecutor(xoIox.II0xO0().I0Io(), new Void[0]);
        } catch (IllegalStateException e) {
            Log.d("octopus", "ignored:" + e.getMessage());
        } catch (RejectedExecutionException e2) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public com.octopus.ad.internal.I0Io b() {
        I0Io i0Io = this.f34819I0Io.get();
        if (i0Io != null) {
            return i0Io.IoOoX();
        }
        return null;
    }

    @Override // com.octopus.ad.internal.oxoX
    public void oIX0oI(x0OxxIOxX.oIX0oI oix0oi) {
        I0Io i0Io = this.f34819I0Io.get();
        if (i0Io != null) {
            if (!oix0oi.IXxxXO()) {
                com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.response_no_ads));
                i0Io.oOXoIIIo().a(oOoIIO0.I0Io.f32017XO);
            } else {
                X0o0xo x0o0xo = (X0o0xo) oix0oi.X00IoxXI();
                x0o0xo.o0(i0Io.IoOoX().oIX0oI());
                x0o0xo.XI0oooXX(i0Io.Oxx0xo());
                X0o0xo(new oIX0oI(x0o0xo, oix0oi));
            }
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public void a(int i) {
        oxoX();
        I0Io i0Io = this.f34819I0Io.get();
        if (i0Io != null) {
            i0Io.oOXoIIIo().a(i);
        }
    }
}
