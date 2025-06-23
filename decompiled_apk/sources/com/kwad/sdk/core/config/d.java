package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d {
    private static volatile SdkConfigData auu;
    private static final AtomicBoolean aut = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    public static boolean CA() {
        if (c.asB.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean CB() {
        if (c.asC.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int CC() {
        return c.asJ.getValue().intValue();
    }

    public static boolean CD() {
        return c.asK.getValue().booleanValue();
    }

    public static boolean CE() {
        return a(c.asN);
    }

    public static boolean CF() {
        return a(c.asP);
    }

    public static boolean CG() {
        if (!c.asQ.getValue().booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean CH() {
        return a(c.asO);
    }

    public static boolean CI() {
        if (c.asS.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int CJ() {
        return c.asT.getValue().intValue();
    }

    @NonNull
    public static SdkConfigData CK() {
        if (auu != null) {
            return auu;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            auu = CL();
        } else {
            synchronized (mLock) {
                try {
                    if (auu == null) {
                        return CL();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return auu;
    }

    private static SdkConfigData CL() {
        auu = new SdkConfigData();
        String ct = y.ct(ServiceProvider.Lw());
        if (!TextUtils.isEmpty(ct)) {
            try {
                auu.parseJson(new JSONObject(ct));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        } else {
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "configCache is empty");
        }
        return auu;
    }

    public static boolean CM() {
        if (c.arS.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean CN() {
        if (c.arT.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean CO() {
        return c.arW.getValue().booleanValue();
    }

    public static boolean CP() {
        if (c.ats.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int CQ() {
        return c.arU.getValue().intValue();
    }

    public static int CR() {
        return c.ata.getValue().intValue();
    }

    public static int CS() {
        return c.asZ.getValue().intValue();
    }

    public static boolean CT() {
        if (c.atb.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean CU() {
        return c.atc.getValue().booleanValue();
    }

    public static float CV() {
        float floatValue = c.atd.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float CW() {
        return c.ate.getValue().floatValue();
    }

    public static boolean CX() {
        return c.atg.getValue().booleanValue();
    }

    public static boolean CY() {
        if (c.atk.getValue().intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean CZ() {
        if (c.atr.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean Cc() {
        if (c.arL.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int Cd() {
        return c.arM.getValue().intValue();
    }

    public static int Ce() {
        return c.arN.getValue().intValue();
    }

    public static boolean Cf() {
        if (c.arP.getValue().intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean Cg() {
        if (c.arN.getValue().intValue() == 2) {
            return true;
        }
        return false;
    }

    public static int Ch() {
        return c.arO.getValue().intValue();
    }

    public static boolean Ci() {
        if (c.arQ.getValue().intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean Cj() {
        if (c.arR.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int Ck() {
        return c.arQ.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void Cl() {
        com.kwad.components.ad.d.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> Cm() {
        return c.asi.getValue();
    }

    @NonNull
    public static List<String> Cn() {
        return c.ash.getValue();
    }

    public static int Co() {
        return c.atD.getValue().intValue();
    }

    public static int Cp() {
        return c.atE.getValue().intValue();
    }

    public static String Cq() {
        return c.asc.getValue();
    }

    public static String Cr() {
        return c.asd.getValue();
    }

    public static boolean Cs() {
        if (c.arH.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int Ct() {
        return c.arI.getValue().intValue();
    }

    public static boolean Cu() {
        if (c.arJ.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int Cv() {
        return c.arK.getValue().intValue();
    }

    public static int Cw() {
        return c.asp.getValue().intValue();
    }

    public static int Cx() {
        return c.asq.getValue().intValue();
    }

    public static int Cy() {
        return c.asr.getValue().intValue();
    }

    public static long Cz() {
        return c.ass.getValue().intValue() * 60000;
    }

    public static long Da() {
        return c.atp.getValue().longValue();
    }

    public static boolean Db() {
        return c.atv.Dw();
    }

    public static com.kwad.sdk.core.network.idc.a.b Dc() {
        return c.atx.getValue();
    }

    public static int Dd() {
        return c.aty.getValue().intValue();
    }

    public static long De() {
        return c.atz.getValue().longValue();
    }

    public static int Df() {
        return c.atA.getValue().intValue();
    }

    public static boolean Dg() {
        if (c.atB.getValue().floatValue() == 1.0f) {
            return true;
        }
        return false;
    }

    public static boolean Dh() {
        return c.atC.Dw();
    }

    public static boolean Di() {
        return c.atF.Dw();
    }

    public static String Dj() {
        return c.atG.getValue();
    }

    public static String Dk() {
        return c.atH.getValue();
    }

    public static String Dl() {
        return c.atI.getValue();
    }

    public static int Dm() {
        return c.atL.getValue().intValue();
    }

    public static boolean Dn() {
        return c.atP.getValue().booleanValue();
    }

    public static int Do() {
        return c.atQ.getValue().intValue();
    }

    public static boolean Dp() {
        return c.aum.Dw();
    }

    public static boolean Dq() {
        return c.auo.Dw();
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.Dr();
    }

    public static boolean ab(long j) {
        if ((j & c.arX.getValue().longValue()) != 0) {
            return true;
        }
        return false;
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context Lw = ServiceProvider.Lw();
            b.a(Lw, bVar);
            g.execute(new az() { // from class: com.kwad.sdk.core.config.d.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    d.bf(Lw);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.Dr();
    }

    @WorkerThread
    public static synchronized void bf(Context context) {
        synchronized (d.class) {
            AtomicBoolean atomicBoolean = aut;
            if (atomicBoolean.get()) {
                return;
            }
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "loadCache");
            c.init();
            Cl();
            b.be(context);
            CK();
            atomicBoolean.set(true);
        }
    }

    public static int cb(String str) {
        return c.aus.dv(str);
    }

    public static void f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            auu = sdkConfigData;
        }
    }

    public static String getLogObiwanData() {
        return c.ato.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.aun.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.auj.getValue();
    }

    public static String getUserAgent() {
        return c.asX.getValue();
    }

    public static boolean gt() {
        return c.atj.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return aut.get();
    }

    public static boolean xn() {
        return c.atJ.getValue().booleanValue();
    }

    public static int yS() {
        return c.arB.getValue().intValue();
    }

    public static boolean yT() {
        return false;
    }

    public static boolean yU() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (c.arG.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static int zA() {
        return c.arV.getValue().intValue();
    }

    public static boolean zB() {
        return c.auf.Dw();
    }

    public static boolean zK() {
        return c.aup.Dw();
    }

    public static boolean zg() {
        if (c.asy.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean zi() {
        if (c.asz.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean zj() {
        if (c.asx.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static String zk() {
        return c.asL.getImei();
    }

    public static String zl() {
        return c.asL.getOaid();
    }

    public static List<String> zm() {
        return c.asg.getValue();
    }

    public static boolean zn() {
        if (c.asW.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean zo() {
        if (c.asY.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean zq() {
        return c.att.getValue().booleanValue();
    }

    public static boolean zr() {
        return c.atu.getValue().booleanValue();
    }

    public static int zs() {
        if (auu != null) {
            return auu.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int zt() {
        return c.atw.getValue().intValue();
    }

    public static double zu() {
        return c.atf.getValue().floatValue();
    }

    public static boolean zv() {
        return c.atN.getValue().booleanValue();
    }

    public static boolean zz() {
        return c.aub.getValue().booleanValue();
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        if (num == null) {
            num = kVar.Dr();
        }
        return num.intValue();
    }

    public static long a(n nVar) {
        Long l = (Long) b(nVar);
        if (l == null) {
            l = nVar.Dr();
        }
        return l.longValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        return num != null ? num.intValue() > 0 : kVar.Dr().intValue() > 0;
    }

    public static double a(f fVar) {
        Double d = (Double) b(fVar);
        if (d == null) {
            d = fVar.Dr();
        }
        return d.doubleValue();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = dVar.Dr();
        }
        return bool.booleanValue();
    }

    public static String a(q qVar) {
        String str = (String) b(qVar);
        return str != null ? str : qVar.Dr();
    }
}
