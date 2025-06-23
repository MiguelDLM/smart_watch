package oXO0oOx0;

import android.os.Handler;
import android.os.Looper;
import com.tanx.exposer.achieve.AdMonitorType;
import xIx.oxoX;

/* loaded from: classes13.dex */
public class II0xO0 implements oXO0oOx0.oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public Handler f32145II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public oXO0oOx0.oIX0oI f32146oIX0oI;

    /* loaded from: classes13.dex */
    public class I0Io implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f32147IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f32148Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ AdMonitorType f32149Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f32151XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ oxoX f32152oI0IIXIo;

        public I0Io(int i, String str, String str2, AdMonitorType adMonitorType, oxoX oxox) {
            this.f32151XO = i;
            this.f32148Oo = str;
            this.f32147IXxxXO = str2;
            this.f32149Oxx0xo = adMonitorType;
            this.f32152oI0IIXIo = oxox;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f32146oIX0oI != null) {
                II0xO0.this.f32146oIX0oI.tanxc_if(this.f32151XO, this.f32148Oo, this.f32147IXxxXO, this.f32149Oxx0xo, this.f32152oI0IIXIo);
            }
        }
    }

    /* renamed from: oXO0oOx0.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC1130II0xO0 implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f32153IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f32154Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ AdMonitorType f32155Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f32157XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ oxoX f32158oI0IIXIo;

        public RunnableC1130II0xO0(int i, String str, String str2, AdMonitorType adMonitorType, oxoX oxox) {
            this.f32157XO = i;
            this.f32154Oo = str;
            this.f32153IXxxXO = str2;
            this.f32155Oxx0xo = adMonitorType;
            this.f32158oI0IIXIo = oxox;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f32146oIX0oI != null) {
                II0xO0.this.f32146oIX0oI.tanxc_do(this.f32157XO, this.f32154Oo, this.f32153IXxxXO, this.f32155Oxx0xo, this.f32158oI0IIXIo);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ oxoX f32159IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ AdMonitorType f32160Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f32162XO;

        public oIX0oI(String str, AdMonitorType adMonitorType, oxoX oxox) {
            this.f32162XO = str;
            this.f32160Oo = adMonitorType;
            this.f32159IXxxXO = oxox;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f32146oIX0oI != null) {
                II0xO0.this.f32146oIX0oI.tanxc_do(this.f32162XO, this.f32160Oo, this.f32159IXxxXO);
            }
        }
    }

    public final synchronized Handler I0Io() {
        try {
            if (this.f32145II0xO0 == null) {
                this.f32145II0xO0 = new Handler(tanxc_do());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f32145II0xO0;
    }

    public void II0xO0(oXO0oOx0.oIX0oI oix0oi) {
        this.f32146oIX0oI = oix0oi;
    }

    @Override // oXO0oOx0.oIX0oI
    public Looper tanxc_do() {
        oXO0oOx0.oIX0oI oix0oi = this.f32146oIX0oI;
        if (oix0oi != null && oix0oi.tanxc_do() != null) {
            return this.f32146oIX0oI.tanxc_do();
        }
        return Looper.myLooper();
    }

    @Override // oXO0oOx0.oIX0oI
    public void tanxc_if(int i, String str, String str2, AdMonitorType adMonitorType, oxoX oxox) {
        if (this.f32146oIX0oI != null) {
            I0Io().post(new I0Io(i, str, str2, adMonitorType, oxox));
        }
    }

    @Override // oXO0oOx0.oIX0oI
    public void tanxc_do(String str, AdMonitorType adMonitorType, oxoX oxox) {
        if (this.f32146oIX0oI != null) {
            I0Io().post(new oIX0oI(str, adMonitorType, oxox));
        }
    }

    @Override // oXO0oOx0.oIX0oI
    public void tanxc_do(int i, String str, String str2, AdMonitorType adMonitorType, oxoX oxox) {
        if (this.f32146oIX0oI != null) {
            I0Io().post(new RunnableC1130II0xO0(i, str, str2, adMonitorType, oxox));
        }
    }
}
