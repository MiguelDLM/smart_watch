package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: classes10.dex */
public class o extends p {
    private static final String Code = "SpecifiedAgdDownloadAction";
    private int C;
    private int V;

    public o(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
        this.C = 1;
    }

    private AppDownloadTask Code(AppInfo appInfo) {
        AdContentData adContentData;
        AppDownloadTask Code2 = com.huawei.openalliance.ad.download.app.g.I().Code(appInfo);
        if (Code2 == null && (Code2 = new AppDownloadTask.a().Code(appInfo).Code()) != null) {
            Code2.Code(Integer.valueOf(this.V));
            Code2.I(Integer.valueOf(this.C));
            Code2.Code(this.Z);
        }
        if (Code2 != null && (adContentData = this.Z) != null) {
            Code2.B(adContentData.w());
            Code2.Z(this.Z.L());
            Code2.C(this.Z.a());
            Code2.I(this.Z.D());
            Code2.b(this.Z.aE());
            Code2.C(this.Z.aF());
        }
        return Code2;
    }

    public void V(int i) {
        this.C = i;
    }

    public void Code(int i) {
        this.V = i;
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        fb.V(Code, "handle SpecifiedAgdDownloadAction");
        AdContentData adContentData = this.Z;
        if (adContentData == null || adContentData.y() == null) {
            fb.V(Code, "getAppInfo is null");
            return V();
        }
        AppInfo y = this.Z.y();
        if (y != null && com.huawei.openalliance.ad.utils.g.Code(this.I, y.Code())) {
            fb.V(Code, "app installed");
            return V();
        }
        AppDownloadTask Code2 = Code(y);
        if (Code2 == null) {
            fb.V(Code, "downloadTask is null");
            return V();
        }
        Code2.Code(Integer.valueOf(this.V));
        Code(v.Code);
        com.huawei.openalliance.ad.download.app.g.I().Code(Code2);
        return true;
    }
}
