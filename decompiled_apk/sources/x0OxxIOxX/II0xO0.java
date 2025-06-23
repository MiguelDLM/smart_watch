package x0OxxIOxX;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.internal.an;
import com.octopus.ad.R;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.view.BannerAdViewImpl;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.internal.xoIox;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import oOoIIO0.I0Io;
import x0.XX;
import x0.XxX0x0xxx;
import x0.oo0xXOI0I;
import x0.oxXx0IX;

/* loaded from: classes11.dex */
public class II0xO0 extends AsyncTask<Void, Integer, x0OxxIOxX.oIX0oI> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final Set<String> f33847IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f33848IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f33849O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public final Bundle f33850Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public String f33851OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f33852Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f33853OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public String f33854X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f33855XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f33856XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public SoftReference<com.octopus.ad.internal.oxoX> f33857XO;

    /* renamed from: o00, reason: collision with root package name */
    public Date f33858o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public com.octopus.ad.internal.I0Io f33859oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final Set<String> f33860xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public static final x0OxxIOxX.oIX0oI f33846xxX = new x0OxxIOxX.oIX0oI(true);

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final String f33845XxX0x0xxx = oo0xXOI0I.II0xO0("emulator");

    /* renamed from: x0OxxIOxX.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C1145II0xO0 {

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public String f33862II0XooXoX;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public String f33865X0o0xo;

        /* renamed from: oxoX, reason: collision with root package name */
        public Date f33868oxoX;

        /* renamed from: xoIox, reason: collision with root package name */
        public boolean f33869xoIox;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final HashSet<String> f33867oIX0oI = new HashSet<>();

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Bundle f33863II0xO0 = new Bundle();

        /* renamed from: I0Io, reason: collision with root package name */
        public final HashSet<String> f33861I0Io = new HashSet<>();

        /* renamed from: XO, reason: collision with root package name */
        public int f33866XO = -1;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public boolean f33864Oxx0IOOO = false;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public int f33870xxIXOIIO = -1;

        public void II0XooXoX(boolean z) {
            this.f33870xxIXOIIO = z ? 1 : 0;
        }

        public Date II0xO0() {
            return this.f33868oxoX;
        }

        public void IXxxXO(String str) {
            this.f33862II0XooXoX = str;
        }

        public void OOXIXo(String str) {
            this.f33861I0Io.add(str);
        }

        public Set<String> Oo() {
            return this.f33867oIX0oI;
        }

        public void Oxx0IOOO(Date date) {
            this.f33868oxoX = date;
        }

        public void X0o0xo(Class<? extends Object> cls, Bundle bundle) {
            this.f33863II0xO0.putBundle(cls.getName(), bundle);
        }

        public void XO(String str) {
            this.f33867oIX0oI.add(str);
        }

        public Bundle oIX0oI(Class<? extends Object> cls) {
            return this.f33863II0xO0.getBundle(cls.getName());
        }

        public void oO(String str) {
            this.f33865X0o0xo = str;
        }

        public void oOoXoXO(boolean z) {
            this.f33869xoIox = z;
        }

        public int ooOOo0oXI() {
            return this.f33866XO;
        }

        public void oxoX(int i) {
            this.f33866XO = i;
        }

        public String xxIXOIIO() {
            return this.f33865X0o0xo;
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f33871oIX0oI;

        static {
            int[] iArr = new int[l.values().length];
            f33871oIX0oI = iArr;
            try {
                iArr[l.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33871oIX0oI[l.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33871oIX0oI[l.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33871oIX0oI[l.REWARDVIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33871oIX0oI[l.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public II0xO0() {
        this.f33847IIXOooo = new HashSet();
        this.f33850Oo = null;
        this.f33860xoXoI = new HashSet();
    }

    private void X0o0xo(int i) {
        com.octopus.ad.internal.oxoX oxox = this.f33857XO.get();
        if (oxox != null) {
            oxox.a(i);
        }
        com.octopus.ad.internal.utilities.oIX0oI.oIX0oI();
    }

    public static void XO(Context context, String str, l lVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C1145II0xO0 XO2 = new I0Io.II0xO0().X0o0xo().XO();
        int i = oIX0oI.f33871oIX0oI[lVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            xXoOI00O.I0Io i0Io = new xXoOI00O.I0Io(context, str, 1);
                            i0Io.XIxXXX0x0(true);
                            i0Io.oI0IIXIo(XO2);
                            i0Io.OxI(true);
                            return;
                        }
                        return;
                    }
                    InterstitialAdViewImpl interstitialAdViewImpl = new InterstitialAdViewImpl(context, true, false);
                    interstitialAdViewImpl.setAdSlotId(str);
                    interstitialAdViewImpl.setIsBoost(true);
                    interstitialAdViewImpl.oXIO0o0XI(XO2);
                    interstitialAdViewImpl.OoO(true);
                    return;
                }
                InterstitialAdViewImpl interstitialAdViewImpl2 = new InterstitialAdViewImpl(context, false, false);
                interstitialAdViewImpl2.setAdSlotId(str);
                interstitialAdViewImpl2.setIsBoost(true);
                interstitialAdViewImpl2.oXIO0o0XI(XO2);
                interstitialAdViewImpl2.OoO(true);
                return;
            }
            BannerAdViewImpl bannerAdViewImpl = new BannerAdViewImpl(context);
            bannerAdViewImpl.setAdSlotId(str);
            bannerAdViewImpl.setIsBoost(true);
            bannerAdViewImpl.oXIO0o0XI(XO2);
            bannerAdViewImpl.OoO(true);
            return;
        }
        BannerAdViewImpl bannerAdViewImpl2 = new BannerAdViewImpl(context, new FrameLayout(context), (View) null);
        bannerAdViewImpl2.setAdSlotId(str);
        bannerAdViewImpl2.setIsBoost(true);
        bannerAdViewImpl2.oXIO0o0XI(XO2);
        bannerAdViewImpl2.OoO(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0125, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) == false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02ab A[Catch: Exception -> 0x011a, IllegalArgumentException -> 0x0350, SecurityException -> 0x035e, IOException -> 0x036c, MalformedURLException -> 0x037a, TryCatch #2 {IllegalArgumentException -> 0x0350, MalformedURLException -> 0x037a, IOException -> 0x036c, SecurityException -> 0x035e, Exception -> 0x011a, blocks: (B:6:0x0018, B:9:0x0023, B:11:0x010f, B:15:0x0128, B:17:0x0134, B:18:0x0145, B:20:0x0174, B:21:0x0179, B:23:0x01df, B:24:0x01eb, B:26:0x01f1, B:29:0x01fd, B:34:0x0242, B:36:0x0258, B:39:0x025f, B:40:0x0281, B:42:0x02ab, B:43:0x02bc, B:45:0x02ff, B:48:0x0302, B:50:0x0308, B:51:0x0313, B:53:0x0268, B:56:0x0278, B:58:0x0218, B:59:0x0177, B:60:0x013d, B:61:0x011d), top: B:5:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ff A[Catch: Exception -> 0x011a, IllegalArgumentException -> 0x0350, SecurityException -> 0x035e, IOException -> 0x036c, MalformedURLException -> 0x037a, TryCatch #2 {IllegalArgumentException -> 0x0350, MalformedURLException -> 0x037a, IOException -> 0x036c, SecurityException -> 0x035e, Exception -> 0x011a, blocks: (B:6:0x0018, B:9:0x0023, B:11:0x010f, B:15:0x0128, B:17:0x0134, B:18:0x0145, B:20:0x0174, B:21:0x0179, B:23:0x01df, B:24:0x01eb, B:26:0x01f1, B:29:0x01fd, B:34:0x0242, B:36:0x0258, B:39:0x025f, B:40:0x0281, B:42:0x02ab, B:43:0x02bc, B:45:0x02ff, B:48:0x0302, B:50:0x0308, B:51:0x0313, B:53:0x0268, B:56:0x0278, B:58:0x0218, B:59:0x0177, B:60:0x013d, B:61:0x011d), top: B:5:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0302 A[Catch: Exception -> 0x011a, IllegalArgumentException -> 0x0350, SecurityException -> 0x035e, IOException -> 0x036c, MalformedURLException -> 0x037a, TryCatch #2 {IllegalArgumentException -> 0x0350, MalformedURLException -> 0x037a, IOException -> 0x036c, SecurityException -> 0x035e, Exception -> 0x011a, blocks: (B:6:0x0018, B:9:0x0023, B:11:0x010f, B:15:0x0128, B:17:0x0134, B:18:0x0145, B:20:0x0174, B:21:0x0179, B:23:0x01df, B:24:0x01eb, B:26:0x01f1, B:29:0x01fd, B:34:0x0242, B:36:0x0258, B:39:0x025f, B:40:0x0281, B:42:0x02ab, B:43:0x02bc, B:45:0x02ff, B:48:0x0302, B:50:0x0308, B:51:0x0313, B:53:0x0268, B:56:0x0278, B:58:0x0218, B:59:0x0177, B:60:0x013d, B:61:0x011d), top: B:5:0x0018 }] */
    @Override // android.os.AsyncTask
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x0OxxIOxX.oIX0oI doInBackground(java.lang.Void... r11) {
        /*
            Method dump skipped, instructions count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x0OxxIOxX.II0xO0.doInBackground(java.lang.Void[]):x0OxxIOxX.oIX0oI");
    }

    @Override // android.os.AsyncTask
    @TargetApi(11)
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public void onCancelled(x0OxxIOxX.oIX0oI oix0oi) {
        super.onCancelled(oix0oi);
        com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.cancel_request));
    }

    public void Oxx0IOOO(com.octopus.ad.internal.oxoX oxox) {
        this.f33857XO = new SoftReference<>(oxox);
        com.octopus.ad.internal.I0Io b = oxox.b();
        if (b != null && b.XO() != null) {
            XxX0x0xxx.oxoX(b.XO().getApplicationContext());
            XX.oxoX(b.XO().getApplicationContext());
            if (!oxoX.II0xO0(b.XO().getApplicationContext()).XO(b.XO())) {
                X0o0xo(80001);
                cancel(true);
                return;
            }
            return;
        }
        X0o0xo(80002);
        cancel(true);
    }

    public final HttpURLConnection oIX0oI(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(xoIox.f19060xXxxox0I);
        httpURLConnection.setReadTimeout(xoIox.f19050IIX0o);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    public final boolean oOoXoXO(int i) {
        if (i != 200) {
            com.octopus.ad.internal.utilities.oIX0oI.IIXOooo(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.http_bad_status, i));
            return false;
        }
        return true;
    }

    @Override // android.os.AsyncTask
    /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(x0OxxIOxX.oIX0oI oix0oi) {
        if (oix0oi == null) {
            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.no_response));
            X0o0xo(oOoIIO0.I0Io.f32017XO);
            return;
        }
        if ("204".equals(this.f33852Oxx0xo)) {
            XO(this.f33859oI0IIXIo.XO(), oix0oi.xxX(), this.f33859oI0IIXIo.o00());
            X0o0xo(oOoIIO0.I0Io.f32017XO);
        } else {
            if (oix0oi.xxIXOIIO()) {
                X0o0xo(80003);
                return;
            }
            com.octopus.ad.internal.oxoX oxox = this.f33857XO.get();
            if (oxox != null) {
                oxox.oIX0oI(oix0oi);
            }
        }
    }

    public final void xxIXOIIO(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", xoIox.oIX0oI().Oo());
        httpURLConnection.setRequestProperty("Content-Type", an.d);
        httpURLConnection.setRequestProperty("Accept", an.d);
        String II0xO02 = oxXx0IX.II0xO0();
        if (!TextUtils.isEmpty(II0xO02)) {
            httpURLConnection.setRequestProperty("Cookie", II0xO02);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public II0xO0(C1145II0xO0 c1145II0xO0) {
        this.f33858o00 = c1145II0xO0.f33868oxoX;
        this.f33851OxI = c1145II0xO0.f33865X0o0xo;
        this.f33849O0xOxO = c1145II0xO0.f33866XO;
        this.f33847IIXOooo = Collections.unmodifiableSet(c1145II0xO0.f33867oIX0oI);
        this.f33850Oo = c1145II0xO0.f33863II0xO0;
        this.f33860xoXoI = Collections.unmodifiableSet(c1145II0xO0.f33861I0Io);
        this.f33848IXxxXO = c1145II0xO0.f33864Oxx0IOOO;
        this.f33854X0IIOO = c1145II0xO0.f33862II0XooXoX;
        this.f33855XI0IXoo = c1145II0xO0.f33870xxIXOIIO;
        this.f33856XIxXXX0x0 = c1145II0xO0.f33869xoIox;
    }
}
