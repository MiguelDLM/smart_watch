package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class ci extends ISplashApi.b {
    private fn n;
    private AdContentData o;
    private WeakReference<Context> p;
    private Context q;
    private String r;

    public ci(Context context, fn fnVar, AdContentData adContentData) {
        this.q = context.getApplicationContext();
        this.p = new WeakReference<>(context);
        this.n = fnVar;
        this.o = adContentData;
    }

    private void B(Bundle bundle) {
        AdContentData adContentData = this.o;
        if (adContentData == null) {
            fb.V("SplashProxy", "contentRecord is null");
            return;
        }
        if (bundle != null) {
            try {
                if (adContentData.D() != null && this.o.D().equals(this.r)) {
                    fb.V("SplashProxy", "Duplicate escalation videoTime event for %s", this.o.D());
                    return;
                }
                this.o.B(bundle.getLong(bn.f.G));
                jc.V(this.q, this.o, com.huawei.openalliance.ad.constant.ai.h);
                this.r = this.o.D();
            } catch (Throwable th) {
                fb.I("SplashProxy", "reportPlayTime err: %s", th.getClass().getSimpleName());
            }
        }
    }

    private int Code(int i) {
        Integer b = com.huawei.openalliance.ad.utils.w.b(this.q);
        if (com.huawei.openalliance.ad.utils.w.I()) {
            return i;
        }
        if (b != null && b.intValue() >= 30454100) {
            return i;
        }
        fb.V("SplashProxy", "HMS version is low, interactMode is %s", Integer.valueOf(i));
        if (i == 4) {
            i = 1;
        }
        if (i == 3) {
            return 2;
        }
        return i;
    }

    private void I(Bundle bundle) {
        try {
            jc.Code(this.q, this.o, com.huawei.openalliance.ad.constant.ai.Z, Long.valueOf(bundle.getLong(bn.f.g)), Long.valueOf(bundle.getLong("endTime")), Integer.valueOf((int) bundle.getLong(bn.f.i)), Integer.valueOf((int) bundle.getLong(bn.f.j)));
        } catch (Throwable th) {
            fb.I("SplashProxy", "reportPlayEnd err: %s", th.getClass().getSimpleName());
        }
    }

    private void V(Bundle bundle) {
        jc.Code(this.q, this.o, com.huawei.openalliance.ad.constant.ai.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    private void Z(Bundle bundle) {
        try {
            cy.Code(this.q, bundle.getInt(bn.f.m), bundle.getString("reason"), this.o);
        } catch (Throwable th) {
            fb.I("SplashProxy", "report img loadFailed err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isDestroyed() {
        Context context = this.p.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isDestroyed();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isFinishing() {
        Context context = this.p.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isFinishing();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdDismissed() {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.a();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdFailedToLoad(int i) {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.I(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public String notifyAdLoaded() {
        fn fnVar = this.n;
        if (fnVar == null) {
            return null;
        }
        fnVar.Code(this.o);
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdFailToDisplay() {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.n();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdShowEnd(long j, int i) {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.Code(this.o, j, i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onDisplayTimeUp() {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.j();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onEasterEggPrepare() {
        jf.Code(this.q).Code(this.o);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onFeedback(int i) {
        fb.V("SplashProxy", "onFeedback");
        di.Code(this.q).Code();
        cy.Code(this.q);
        Intent intent = new Intent();
        intent.setAction(com.huawei.openalliance.ad.constant.x.aj);
        intent.setPackage(com.huawei.openalliance.ad.utils.w.Z(this.q));
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aj, Code(i));
        if (!(this.q instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.huawei.openalliance.ad.utils.bc.Code(this.q, intent);
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.C();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoadFailed() {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.Z(this.o);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoaded() {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.F();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onSkipAd(int i, int i2) {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.Code(i, i2);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onStartEasterEggFailed(Bundle bundle) {
        jf.Code(this.q).I(this.o, bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean onTouch(int i, int i2, long j, String str, int i3) {
        fb.V("SplashProxy", "onTouch");
        fn fnVar = this.n;
        if (fnVar != null) {
            return fnVar.Code(i, i2, this.o, Long.valueOf(j), (MaterialClickInfo) com.huawei.openalliance.ad.utils.aa.V(str, MaterialClickInfo.class, new Class[0]), i3);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean processWhyEventUnified() {
        return com.huawei.openalliance.ad.utils.w.Code(this.q, this.o);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void removeExSplashBlock() {
        com.huawei.openalliance.ad.utils.bb.V(this.q);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportEvents(String str, Bundle bundle) {
        if (com.huawei.openalliance.ad.utils.ay.Code(str)) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1888605810:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.B)) {
                    c = 0;
                    break;
                }
                break;
            case -1694029870:
                if (str.equals(com.huawei.openalliance.ad.constant.s.q)) {
                    c = 1;
                    break;
                }
                break;
            case -493598457:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.Z)) {
                    c = 2;
                    break;
                }
                break;
            case 886907255:
                if (str.equals(com.huawei.openalliance.ad.constant.s.j)) {
                    c = 3;
                    break;
                }
                break;
            case 1878759457:
                if (str.equals(com.huawei.openalliance.ad.constant.ai.h)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                V(bundle);
                return;
            case 1:
                Z(bundle);
                return;
            case 2:
                I(bundle);
                return;
            case 3:
                Code(bundle);
                return;
            case 4:
                B(bundle);
                return;
            default:
                return;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportShowStartEvent() {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.L();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportSplashEvent(Bundle bundle) {
        cy.Code(this.q, bundle, this.o);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void toShowSpare(int i) {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.V(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void updatePhyShowStart(long j) {
        fn fnVar = this.n;
        if (fnVar != null) {
            fnVar.Code(j);
        }
    }

    private void Code(Bundle bundle) {
        try {
            boolean z = bundle.getBoolean(bn.f.l);
            AdEventReport Code = jc.Code(this.o);
            Code.I(z);
            com.huawei.openalliance.ad.ipc.g.V(this.q).Code(com.huawei.openalliance.ad.constant.s.j, com.huawei.openalliance.ad.utils.aa.V(Code), null, null);
        } catch (Throwable th) {
            fb.I("SplashProxy", "reportSoundClickEvent err: %s", th.getClass().getSimpleName());
        }
    }
}
