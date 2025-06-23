package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.iab.omid.library.huawei.Omid;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class gk implements gs, hg {
    public static final String Code = "1.2.4";
    private static boolean I = gw.Code(gw.f);
    private static final String V = "AdsessionAgent";
    private Context B;
    private final List<AdSession> Z = new ArrayList();

    private static AdSessionStatePublisher Code(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionStatePublisher();
        }
        return null;
    }

    private static String V(AdSession adSession) {
        if (adSession != null) {
            return adSession.getAdSessionId();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.hg
    public void B() {
        if (!this.Z.isEmpty()) {
            try {
                Iterator<AdSession> it = this.Z.iterator();
                while (it.hasNext()) {
                    it.next().finish();
                    fb.Code(V, " adSession finish");
                }
            } catch (Throwable unused) {
                fb.V(V, "finish, fail");
            }
        }
        this.Z.clear();
    }

    @Override // com.huawei.hms.ads.hg
    public void C() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().removeAllFriendlyObstructions();
            }
        } catch (Throwable unused) {
            fb.V(V, "removeAllFriendlyObstructions, fail");
        }
    }

    @Override // com.huawei.hms.ads.hg
    public String F() {
        if (this.Z.isEmpty()) {
            return null;
        }
        return V(this.Z.get(0));
    }

    public Context I() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.hg
    public hc S() {
        if (this.Z.isEmpty() || !hc.Code()) {
            return null;
        }
        return new hc(Code(this.Z.get(0)));
    }

    @Override // com.huawei.hms.ads.hg
    public void Z() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (AdSession adSession : this.Z) {
                fb.Code(V, "adsession start");
                adSession.start();
            }
        } catch (Throwable unused) {
            fb.V(V, "start, fail");
        }
    }

    public void Code(Context context, List<Om> list, ha haVar) {
        if (!Code() || context == null || list == null) {
            fb.V(V, "not available, not init");
            return;
        }
        if (list.isEmpty() || haVar == null) {
            fb.V(V, "oms is empty or sessionWrapper is null, not init");
            return;
        }
        fb.V(V, "init");
        this.B = context;
        Code(list, haVar);
    }

    @Override // com.huawei.hms.ads.hg
    public void I(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().removeFriendlyObstruction(view);
            }
        } catch (Throwable unused) {
            fb.V(V, "addFriendlyObstruction, fail");
        }
    }

    public List<AdSession> V() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(View view) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().registerAdView(view);
            }
        } catch (Throwable unused) {
            fb.V(V, "registerAdView, fail");
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void V(View view) {
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(View view, hf hfVar, String str) {
        if (this.Z.isEmpty() || hfVar == null || !hf.Code()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().addFriendlyObstruction(view, hf.Code(hfVar), str);
            }
        } catch (Throwable unused) {
            fb.V(V, "addFriendlyObstruction-f, fail");
        }
    }

    private void Code(ha haVar, hk hkVar) {
        String str;
        if (hkVar == null) {
            str = "init AdSessionContext failed";
        } else {
            if (!hb.Code()) {
                return;
            }
            AdSessionContext Code2 = new hb(this.B).Code(hkVar, null);
            if (Code2 != null) {
                Code(Code2, haVar);
                return;
            }
            str = "adSessionContext is null";
        }
        fb.V(V, str);
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(he heVar, String str) {
        if (this.Z.isEmpty() || heVar == null || !he.Code()) {
            return;
        }
        try {
            Iterator<AdSession> it = this.Z.iterator();
            while (it.hasNext()) {
                it.next().error(he.Code(heVar), str);
            }
        } catch (Throwable unused) {
            fb.V(V, "error, fail");
        }
    }

    private void Code(AdSessionContext adSessionContext, ha haVar) {
        try {
            if (ha.Code() && haVar != null) {
                AdSessionConfiguration V2 = haVar.V();
                if (V2 == null) {
                    fb.V(V, "adSessionConfiguration is null");
                    return;
                }
                fb.V(V, "initAdSession");
                AdSession createAdSession = Code(this.B) ? AdSession.createAdSession(V2, adSessionContext) : null;
                if (createAdSession == null) {
                    fb.V(V, "adSession is null");
                    return;
                } else {
                    this.Z.add(createAdSession);
                    return;
                }
            }
            fb.V(V, "init AdSession failed");
        } catch (Throwable unused) {
            fb.I(V, "initAdSession error");
        }
    }

    private void Code(List<Om> list, ha haVar) {
        if (!hk.Code()) {
            fb.V(V, "init VerficationScriptResourceWrapper failed");
            return;
        }
        for (Om om : list) {
            fb.V(V, "Init Verfication Script");
            hk hkVar = new hk();
            hkVar.Code(om);
            Code(haVar, hkVar);
        }
    }

    public static boolean Code() {
        return I;
    }

    private static boolean Code(Context context) {
        Omid.activate(context);
        return true;
    }
}
