package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: classes10.dex */
public class l extends p {
    private static final String Code = "OpenMiniPageAction";
    private int V;

    public l(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
    }

    private AppDownloadTask Code(AppInfo appInfo) {
        AppDownloadTask Code2 = com.huawei.openalliance.ad.download.app.g.I().Code(appInfo);
        if (Code2 != null) {
            AdContentData adContentData = this.Z;
            if (adContentData != null) {
                Code2.Z(adContentData.L());
                Code2.B(this.Z.w());
                Code2.C(this.Z.a());
                Code2.I(this.Z.D());
                Code2.b(this.Z.aE());
                Code2.C(this.Z.aF());
            }
        } else {
            Code2 = new AppDownloadTask.a().Code(appInfo).Code();
            if (Code2 != null) {
                Code2.Code(Integer.valueOf(this.V));
                Code2.Code(this.Z);
                AdContentData adContentData2 = this.Z;
                if (adContentData2 != null) {
                    Code2.B(adContentData2.w());
                    Code2.Z(this.Z.L());
                    Code2.C(this.Z.a());
                    Code2.I(this.Z.D());
                    Code2.b(this.Z.aE());
                    Code2.C(this.Z.aF());
                }
            }
        }
        return Code2;
    }

    public void Code(int i) {
        this.V = i;
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        String str;
        fb.V(Code, "handle OpenMiniPageAction");
        AdContentData adContentData = this.Z;
        if (adContentData == null || adContentData.y() == null) {
            str = "getAppInfo is null";
        } else {
            AppInfo y = this.Z.y();
            if (y == null || !com.huawei.openalliance.ad.utils.g.Code(this.I, y.Code())) {
                AppDownloadTask Code2 = Code(y);
                if (Code2 != null) {
                    Code2.S(this.Z.at());
                    Code2.F(this.Z.au());
                    Code2.Code(Integer.valueOf(this.V));
                    Code2.D(this.Z.M());
                    Code2.I((Integer) 1);
                    Code(v.F);
                    com.huawei.openalliance.ad.download.app.g.I().Code(Code2);
                    return true;
                }
                str = "downloadTask is null";
            } else {
                str = "app installed";
            }
        }
        fb.V(Code, str);
        return V();
    }
}
