package IIOIX;

import Xo.I0Io;
import android.net.Uri;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.List;
import xIx.I0Io;
import xIx.oxoX;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public oxoX f267I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public AdMonitorType f268II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public List<String> f269oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public xIx.II0xO0 f270oxoX = I0Io.I0Io().xxIXOIIO();

    /* loaded from: classes13.dex */
    public static class II0xO0 implements xIOXX.I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        public com.tanx.exposer.achieve.II0xO0 f271II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final boolean f272oIX0oI;

        /* renamed from: IIOIX.oIX0oI$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC0007II0xO0 implements Runnable {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ String f274Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f275XO;

            public RunnableC0007II0xO0(int i, String str) {
                this.f275XO = i;
                this.f274Oo = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Xo.I0Io i0Io = I0Io.X0o0xo.f4155oIX0oI;
                II0xO0 iI0xO0 = II0xO0.this;
                i0Io.X0o0xo(iI0xO0.f271II0xO0, this.f275XO, this.f274Oo, iI0xO0.f272oIX0oI);
            }
        }

        /* renamed from: IIOIX.oIX0oI$II0xO0$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC0008oIX0oI implements Runnable {
            public RunnableC0008oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Xo.I0Io i0Io = I0Io.X0o0xo.f4155oIX0oI;
                II0xO0 iI0xO0 = II0xO0.this;
                i0Io.XO(iI0xO0.f271II0xO0, iI0xO0.f272oIX0oI);
            }
        }

        public II0xO0(com.tanx.exposer.achieve.II0xO0 iI0xO0, boolean z) {
            this.f271II0xO0 = iI0xO0;
            this.f272oIX0oI = z;
        }

        @Override // xIOXX.I0Io
        public void oIX0oI(int i, String str) {
            IxIo.II0xO0.oIX0oI(new RunnableC0007II0xO0(i, str), 0L);
        }

        @Override // xIOXX.I0Io
        public void tanxc_do() {
            IxIo.II0xO0.oIX0oI(new RunnableC0008oIX0oI(), 0L);
        }
    }

    /* renamed from: IIOIX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC0009oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f277IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f278Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f280XO;

        public RunnableC0009oIX0oI(String str, String str2, String str3) {
            this.f280XO = str;
            this.f278Oo = str2;
            this.f277IXxxXO = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            oIX0oI.this.I0Io(this.f280XO, this.f278Oo, this.f277IXxxXO);
        }
    }

    public oIX0oI(AdMonitorType adMonitorType, List<String> list, oxoX oxox) {
        this.f268II0xO0 = adMonitorType;
        this.f269oIX0oI = list;
        this.f267I0Io = oxox;
    }

    public final void I0Io(String str, String str2, String str3) {
        String oxoX2;
        oxoX oxox = this.f267I0Io;
        if (oxox == null) {
            oxoX2 = str;
        } else {
            oxoX2 = XOxoX.I0Io.oxoX(str, oxox.II0xO0());
        }
        x0oxIIIX.II0xO0.Oxx0IOOO(this.f267I0Io, this.f268II0xO0, str2, str3);
        com.tanx.exposer.achieve.II0xO0 iI0xO0 = new com.tanx.exposer.achieve.II0xO0(str, oxoX2, this.f268II0xO0, str2, str3, this.f270oxoX.XO());
        iI0xO0.Oxx0IOOO(this.f267I0Io);
        new X0ooXIooI.II0xO0(this.f270oxoX.II0XooXoX()).oIX0oI(oxoX2, new II0xO0(iI0xO0, false));
    }

    public AdMonitorCommitResult oIX0oI() {
        for (String str : this.f269oIX0oI) {
            String I0Io2 = XOxoX.I0Io.I0Io(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(I0Io2)) {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    x0oxIIIX.II0xO0.xxIXOIIO(this.f267I0Io, this.f268II0xO0, "domain_not_right");
                } else {
                    IxIo.II0xO0.oIX0oI(new RunnableC0009oIX0oI(str, host, I0Io2), 0L);
                }
            } else {
                x0oxIIIX.II0xO0.xxIXOIIO(this.f267I0Io, this.f268II0xO0, "url_is_empty_or_hash_error");
            }
        }
        return AdMonitorCommitResult.COMMITED;
    }
}
