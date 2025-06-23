package IIOIX;

import IIOIX.oIX0oI;
import Xo.I0Io;
import android.net.Uri;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import xIx.oxoX;

/* loaded from: classes13.dex */
public class II0xO0 extends IIOIX.oIX0oI {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static Queue<String> f257X0o0xo = new ConcurrentLinkedQueue();

    /* renamed from: XO, reason: collision with root package name */
    public static Map<String, com.tanx.exposer.achieve.II0xO0> f258XO = new ConcurrentHashMap();

    /* renamed from: IIOIX.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0005II0xO0 extends oIX0oI.II0xO0 {

        /* renamed from: IIOIX.II0xO0$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC0006II0xO0 implements Runnable {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ String f260Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f261XO;

            public RunnableC0006II0xO0(int i, String str) {
                this.f261XO = i;
                this.f260Oo = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                I0Io i0Io = I0Io.X0o0xo.f4155oIX0oI;
                C0005II0xO0 c0005II0xO0 = C0005II0xO0.this;
                i0Io.X0o0xo(c0005II0xO0.f271II0xO0, this.f261XO, this.f260Oo, c0005II0xO0.f272oIX0oI);
                if (!i0Io.OOXIXo(C0005II0xO0.this.f271II0xO0)) {
                    II0xO0.f258XO.remove(C0005II0xO0.this.f271II0xO0.x0XOIxOo());
                }
            }
        }

        /* renamed from: IIOIX.II0xO0$II0xO0$oIX0oI */
        /* loaded from: classes13.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                I0Io i0Io = I0Io.X0o0xo.f4155oIX0oI;
                C0005II0xO0 c0005II0xO0 = C0005II0xO0.this;
                i0Io.XO(c0005II0xO0.f271II0xO0, c0005II0xO0.f272oIX0oI);
                II0xO0.f258XO.remove(C0005II0xO0.this.f271II0xO0.x0XOIxOo());
                if (II0xO0.f257X0o0xo.size() >= 1000) {
                    II0xO0.f257X0o0xo.poll();
                }
                II0xO0.f257X0o0xo.offer(C0005II0xO0.this.f271II0xO0.x0XOIxOo());
            }
        }

        public C0005II0xO0(com.tanx.exposer.achieve.II0xO0 iI0xO0, boolean z) {
            super(iI0xO0, z);
        }

        @Override // IIOIX.oIX0oI.II0xO0, xIOXX.I0Io
        public void oIX0oI(int i, String str) {
            IxIo.II0xO0.oIX0oI(new RunnableC0006II0xO0(i, str), 0L);
        }

        @Override // IIOIX.oIX0oI.II0xO0, xIOXX.I0Io
        public void tanxc_do() {
            IxIo.II0xO0.oIX0oI(new oIX0oI(), 0L);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f263IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f264Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f266XO;

        public oIX0oI(String str, String str2, String str3) {
            this.f266XO = str;
            this.f264Oo = str2;
            this.f263IXxxXO = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0xO0 iI0xO0 = II0xO0.this;
            iI0xO0.X0o0xo(this.f266XO, this.f264Oo, this.f263IXxxXO, iI0xO0.f268II0xO0);
        }
    }

    public II0xO0(AdMonitorType adMonitorType, List<String> list, oxoX oxox) {
        super(adMonitorType, list, oxox);
    }

    public final void X0o0xo(String str, String str2, String str3, AdMonitorType adMonitorType) {
        String oxoX2;
        if (f257X0o0xo.contains(str3)) {
            x0oxIIIX.II0xO0.II0XooXoX(this.f267I0Io, adMonitorType);
            return;
        }
        com.tanx.exposer.achieve.II0xO0 iI0xO0 = f258XO.get(str3);
        if (iI0xO0 != null) {
            I0Io.X0o0xo.f4155oIX0oI.oxoX(iI0xO0);
            oxoX oxox = this.f267I0Io;
            if (oxox != null) {
                XOxoX.oIX0oI.oxoX("tanx_deduplication_request_pending", oxox.toString());
                return;
            }
            return;
        }
        x0oxIIIX.II0xO0.Oxx0IOOO(this.f267I0Io, this.f268II0xO0, str2, str3);
        oxoX oxox2 = this.f267I0Io;
        if (oxox2 == null) {
            oxoX2 = str;
        } else {
            oxoX2 = XOxoX.I0Io.oxoX(str, oxox2.II0xO0());
        }
        com.tanx.exposer.achieve.II0xO0 iI0xO02 = new com.tanx.exposer.achieve.II0xO0(str, oxoX2, this.f268II0xO0, str2, str3, this.f270oxoX.XO());
        iI0xO02.Oxx0IOOO(this.f267I0Io);
        new X0ooXIooI.II0xO0(this.f270oxoX.II0XooXoX()).oIX0oI(oxoX2, new C0005II0xO0(iI0xO02, false));
        f258XO.put(str3, iI0xO02);
    }

    @Override // IIOIX.oIX0oI
    public AdMonitorCommitResult oIX0oI() {
        for (String str : this.f269oIX0oI) {
            String I0Io2 = XOxoX.I0Io.I0Io(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(I0Io2)) {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    x0oxIIIX.II0xO0.xxIXOIIO(this.f267I0Io, this.f268II0xO0, "domain_not_right");
                } else if (f257X0o0xo.contains(I0Io2)) {
                    x0oxIIIX.II0xO0.II0XooXoX(this.f267I0Io, this.f268II0xO0);
                } else {
                    IxIo.II0xO0.oIX0oI(new oIX0oI(str, host, I0Io2), 0L);
                }
            } else {
                x0oxIIIX.II0xO0.xxIXOIIO(this.f267I0Io, this.f268II0xO0, "url_is_empty_or_hash_error");
            }
        }
        return AdMonitorCommitResult.COMMITED;
    }
}
