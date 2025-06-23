package com.octopus.ad;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.octopus.ad.internal.utilities.DeviceInfo;
import java.util.Locale;
import x0.oxXx0IX;

/* loaded from: classes11.dex */
public class AdActivity extends Activity {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static Class<AdActivity> f18562IXxxXO = AdActivity.class;

    /* renamed from: Oo, reason: collision with root package name */
    public static boolean f18563Oo = false;

    /* renamed from: XO, reason: collision with root package name */
    public I0Io f18564XO;

    /* loaded from: classes11.dex */
    public interface I0Io {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        WebView h();
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f18565oIX0oI;

        static {
            int[] iArr = new int[b.values().length];
            f18565oIX0oI = iArr;
            try {
                iArr[b.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18565oIX0oI[b.landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18565oIX0oI[b.portrait.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public enum b {
        portrait,
        landscape,
        none
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (i != 3) {
                i++;
                if (AdActivity.f18563Oo) {
                    AdActivity.f18563Oo = false;
                    AdActivity.this.finish();
                    i = 3;
                }
                SystemClock.sleep(500L);
            }
        }
    }

    public static void I0Io(Activity activity, int i) {
        XO(activity, i);
    }

    public static void II0xO0(Activity activity) {
        XO(activity, activity.getResources().getConfiguration().orientation);
    }

    public static void X0o0xo(Activity activity) {
        activity.setRequestedOrientation(-1);
    }

    @TargetApi(9)
    public static void XO(Activity activity, int i) {
        boolean z;
        String str = DeviceInfo.oxoX().f18671Oxx0IOOO;
        Locale locale = Locale.US;
        String upperCase = str.toUpperCase(locale);
        if (DeviceInfo.oxoX().f18673XO.toUpperCase(locale).equals("AMAZON") && (upperCase.equals("KFTT") || upperCase.equals("KFJWI") || upperCase.equals("KFJWA"))) {
            z = true;
        } else {
            z = false;
        }
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (i == 1) {
            int rotation = defaultDisplay.getRotation();
            if (rotation != 1 && rotation != 2) {
                activity.setRequestedOrientation(1);
                return;
            } else {
                activity.setRequestedOrientation(9);
                return;
            }
        }
        if (i == 2) {
            int rotation2 = defaultDisplay.getRotation();
            if (!z) {
                if (rotation2 != 0 && rotation2 != 1) {
                    activity.setRequestedOrientation(8);
                    return;
                } else {
                    activity.setRequestedOrientation(0);
                    return;
                }
            }
            if (rotation2 != 0 && rotation2 != 1) {
                activity.setRequestedOrientation(0);
            } else {
                activity.setRequestedOrientation(8);
            }
        }
    }

    public static Class<AdActivity> oIX0oI() {
        return f18562IXxxXO;
    }

    public static void oxoX(Activity activity, b bVar) {
        int i = activity.getResources().getConfiguration().orientation;
        int i2 = II0xO0.f18565oIX0oI[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    i = 1;
                }
            } else {
                i = 2;
            }
            XO(activity, i);
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        I0Io i0Io = this.f18564XO;
        if (i0Io != null) {
            i0Io.e();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("ACTIVITY_TYPE");
        if (TextUtils.isEmpty(stringExtra)) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.adactivity_no_type));
            finish();
        } else if ("INTERSTITIAL".equals(stringExtra)) {
            oI.II0xO0 iI0xO0 = new oI.II0xO0(this);
            this.f18564XO = iI0xO0;
            iI0xO0.a();
        } else if ("BROWSER".equals(stringExtra)) {
            oI.oIX0oI oix0oi = new oI.oIX0oI(this);
            this.f18564XO = oix0oi;
            oix0oi.a();
        } else if (x0OxxIOxX.oIX0oI.f33875x0xO.equals(stringExtra)) {
            oI.I0Io i0Io = new oI.I0Io(this);
            this.f18564XO = i0Io;
            i0Io.a();
        } else if ("DOWNLOADBROWSER".equals(stringExtra)) {
            oI.oIX0oI oix0oi2 = new oI.oIX0oI(this);
            this.f18564XO = oix0oi2;
            oix0oi2.a();
            new Thread(new oIX0oI()).start();
        }
        CookieSyncManager.createInstance(this);
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        I0Io i0Io = this.f18564XO;
        if (i0Io != null) {
            i0Io.d();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        I0Io i0Io = this.f18564XO;
        if (i0Io != null) {
            oxXx0IX.oxoX(i0Io.h());
            this.f18564XO.c();
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        I0Io i0Io = this.f18564XO;
        if (i0Io != null) {
            oxXx0IX.X0o0xo(i0Io.h());
            this.f18564XO.b();
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }
}
