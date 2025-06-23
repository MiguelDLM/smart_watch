package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.c;
import com.huawei.openalliance.ad.inter.data.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class dl implements dm {
    private static long V;

    private Map<String, String> Code(AdContentData adContentData) {
        HashMap hashMap = new HashMap();
        if (adContentData != null && adContentData.S() != null) {
            MetaData S = adContentData.S();
            String b = S.b();
            String a2 = S.a();
            if (b != null && a2 != null) {
                hashMap.put(com.huawei.openalliance.ad.uriaction.i.Code, b);
                hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, a2);
            }
        }
        return hashMap;
    }

    private void Code(final Context context, final d dVar) {
        long Code = com.huawei.openalliance.ad.utils.w.Code();
        fb.V("DownloadChecker", "trigger action list lastTime:%s curTime:%s", Long.valueOf(V), Long.valueOf(Code));
        if (Code - V < 500) {
            fb.V("DownloadChecker", "trigger action list too frequently");
        } else {
            V = Code;
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.Code(dVar, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(d dVar, Context context) {
        if (dVar == null || context == null) {
            return;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.l) {
            fb.V("DownloadChecker", "native trigger action list result:%s", Boolean.valueOf(((com.huawei.openalliance.ad.inter.data.l) dVar).B(context, null)));
        } else if (!(dVar instanceof c)) {
            fb.V("DownloadChecker", "not baseAd no need trigger action list");
        } else {
            AdContentData n = dVar.n();
            fb.V("DownloadChecker", "trigger action list result:%s", Boolean.valueOf(com.huawei.openalliance.ad.uriaction.q.Code(context, n, Code(n)).Code()));
        }
    }

    @Override // com.huawei.hms.ads.dm
    public boolean Code(Context context, d dVar, boolean z) {
        if (context == null || dVar == null) {
            return false;
        }
        if (dVar instanceof com.huawei.openalliance.ad.inter.data.s) {
            return true;
        }
        int E = dVar.E();
        fb.Code("DownloadChecker", "api control flag:%s", Integer.valueOf(E));
        if (E != 0) {
            if (E != 1) {
                if (E != 2) {
                    fb.I("DownloadChecker", "invalid apiDownloadFlag value!");
                }
                return false;
            }
            if (z) {
                Code(context, dVar);
            }
            return false;
        }
        return true;
    }
}
