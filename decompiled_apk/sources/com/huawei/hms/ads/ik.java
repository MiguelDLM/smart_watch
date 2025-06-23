package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.utils.d;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ik extends fu<kk> implements iw<kk> {
    private Context B;
    private SplashView.SplashAdLoadListener C;
    private ed I;
    private com.huawei.openalliance.ad.inter.listeners.b Z;

    public ik(Context context, kk kkVar) {
        Code((ik) kkVar);
        this.B = context.getApplicationContext();
        this.I = ed.Code(context);
    }

    private void D() {
        fb.I("SplashPresenter", "notifyNotSupport");
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.Z;
        if (bVar != null) {
            bVar.Code(1001);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(1001));
        }
    }

    @Override // com.huawei.hms.ads.iw
    public void F() {
        fb.Code("SplashPresenter", "notifyAdDismissed");
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.C;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        com.huawei.openalliance.ad.utils.bb.V(this.B);
    }

    @Override // com.huawei.hms.ads.iw
    public boolean S() {
        return d.L(this.B);
    }

    @Override // com.huawei.hms.ads.iw
    public boolean V() {
        if (com.huawei.openalliance.ad.utils.w.Code(this.B)) {
            return true;
        }
        D();
        F();
        return false;
    }

    @Override // com.huawei.hms.ads.iw
    public void Code() {
        I().Code(((Integer) com.huawei.openalliance.ad.utils.ba.Code(new Callable<Integer>() { // from class: com.huawei.hms.ads.ik.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public Integer call() {
                return Integer.valueOf(ik.this.I.I());
            }
        }, 1)).intValue());
    }

    @Override // com.huawei.hms.ads.iw
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.C = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.iw
    public void Code(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.Z = bVar;
    }

    @Override // com.huawei.hms.ads.iw
    public void Code(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slotid", str);
            jSONObject.put("adType", i);
            com.huawei.openalliance.ad.ipc.g.V(this.B).Code("rptSplashDismissForExSplash", jSONObject.toString(), null, null);
        } catch (JSONException unused) {
            fb.I("SplashPresenter", "onSplashDismissForExsplash JSONException");
        }
    }
}
