package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Application;
import android.util.Log;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdInfo;
import com.alimm.tanx.core.TanxInitListener;
import com.alimm.tanx.core.config.SettingConfig;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.ui.TanxSdk;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4730a = false;

    /* loaded from: classes.dex */
    public static class a implements TanxInitListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4731a;

        public a(b bVar) {
            this.f4731a = bVar;
        }

        @Override // com.alimm.tanx.core.TanxInitListener
        public void error(int i, String str) {
            b bVar = this.f4731a;
            if (bVar != null) {
                bVar.a(i, str);
            }
            boolean unused = l.f4730a = false;
        }

        @Override // com.alimm.tanx.core.TanxInitListener
        public void succ() {
            boolean unused = l.f4730a = true;
            b bVar = this.f4731a;
            if (bVar != null) {
                bVar.success();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str);

        void success();
    }

    public static boolean b() {
        if (!com.adp.sdk.utils.b.a("com.alimm.tanx.ui.TanxSdk")) {
            Log.e("adsplus", "tanx not found");
            return false;
        }
        return true;
    }

    public static synchronized boolean a(Application application, b bVar) {
        boolean z;
        String str;
        String str2;
        synchronized (l.class) {
            try {
                if (f4730a) {
                    return true;
                }
                if (application == null) {
                    return false;
                }
                AdInfo adInfo = com.adp.sdk.a.b;
                if (adInfo != null && (!a(adInfo.getTanx()) || !a(com.adp.sdk.a.b.getTanx()))) {
                    if (!com.adp.sdk.a.b.getTanx().contains(xoXoI.f2670oxoX)) {
                        if (bVar != null) {
                            bVar.a(-1, "tanx appid or appkey is not correct");
                        }
                        return false;
                    }
                    if (com.adp.sdk.a.b.getTanx().split(xoXoI.f2670oxoX).length < 2) {
                        if (bVar != null) {
                            bVar.a(-1, "tanx appid or appkey is not correct");
                        }
                        return false;
                    }
                    String trim = com.adp.sdk.a.b.getTanx().split(xoXoI.f2670oxoX)[0].trim();
                    String trim2 = com.adp.sdk.a.b.getTanx().split(xoXoI.f2670oxoX)[1].trim();
                    ADPConfig aDPConfig = ADP.adpConfig;
                    if (aDPConfig != null) {
                        z = !aDPConfig.isEnablePersonalRecommend();
                        if (aDPConfig.getDebug()) {
                            Log.e("adsplus", "init tx:" + z);
                        }
                    } else {
                        z = false;
                    }
                    if (z && (str2 = ADP.oaid) != null && str2.length() > 0 && !ADP.oaid.contains("00000000-0000-0000-0000-000000000000")) {
                        z = false;
                    }
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("1");
                    hashMap.put("quality", arrayList);
                    TanxConfig build = new TanxConfig.Builder().appName(com.adp.sdk.a.b.getAppname()).appId(trim).appKey(trim2).oaidSwitch(z).imeiSwitch(z).idAllSwitch(z).netDebug(false).debug(false).dark(new SettingConfig().setNightConfig()).setUserTag(hashMap).build();
                    if (!z && (str = ADP.oaid) != null && str.length() > 0 && !ADP.oaid.contains("00000000-0000-0000-0000-000000000000")) {
                        build.setmOaid(ADP.oaid);
                    }
                    TanxSdk.init(application, build, new a(bVar));
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean a() {
        return f4730a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
