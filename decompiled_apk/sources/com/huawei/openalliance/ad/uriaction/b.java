package com.huawei.openalliance.ad.uriaction;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: classes10.dex */
public class b extends p {
    private static final String Code = "AppDeepLinkAction";

    public b(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Z() {
        jc.Code(this.I, this.Z, ai.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.g.Code(this.I, this.Z.y().k()) ? 2 : 1));
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        String str;
        AdContentData adContentData;
        fb.V(Code, "handle AppDeepLinkAction");
        try {
            adContentData = this.Z;
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            fb.I(Code, str);
            Z();
            return V();
        } catch (Exception unused2) {
            str = "handle intent url fail";
            fb.I(Code, str);
            Z();
            return V();
        }
        if (adContentData != null && adContentData.y() != null) {
            AppInfo y = this.Z.y();
            Intent Code2 = com.huawei.openalliance.ad.utils.g.Code(this.I, y.j(), y.k());
            if (Code2 == null) {
                fb.I(Code, "cannot find target activity");
                Z();
                return V();
            }
            Code2.addFlags(268435456);
            jn.a aVar = new jn.a();
            aVar.Code(y).Code(this.Z).Code(Code2);
            com.huawei.openalliance.ad.utils.g.Code(this.I, Code2, aVar.Code());
            if (!TextUtils.isEmpty(y.Code())) {
                AppDownloadTask Code3 = new AppDownloadTask.a().Code(y).Code();
                Code3.Code(this.Z);
                Code3.I(System.currentTimeMillis());
                com.huawei.openalliance.ad.download.app.l.Code(this.I).Code(y.Code(), Code3);
            }
            Code(v.Code);
            jc.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
            return true;
        }
        fb.V(Code, "getAppInfo is null");
        return V();
    }
}
