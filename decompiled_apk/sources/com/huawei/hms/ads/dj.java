package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public abstract class dj {
    protected Context Code;
    private dj I;
    private a V;

    /* loaded from: classes10.dex */
    public interface a {
        void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);

        void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo);
    }

    public dj(Context context) {
        this.Code = context;
    }

    public Context Code() {
        return this.Code;
    }

    public abstract void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j);

    public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.V(appInfo);
        }
    }

    public void Code(a aVar) {
        this.V = aVar;
    }

    public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        dj djVar = this.I;
        if (djVar == null) {
            V(appInfo);
        } else {
            djVar.Code(this.V);
            this.I.Code(appInfo, adContentData, j);
        }
    }

    public void Code(dj djVar) {
        this.I = djVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.Code(appInfo);
        }
    }
}
