package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.jj;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: classes10.dex */
public class n extends p {
    private static final String Code = "OuterWebCCTAction";

    public n(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        AdContentData adContentData = this.Z;
        if (adContentData == null || !(ja.Code(adContentData.v()) || am.Z(this.I))) {
            return V();
        }
        fb.Code(Code, "handleUri by cct, pkgName is : %s", this.I.getPackageName());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String i = this.Z.i();
        if (!ay.Code(i)) {
            Uri parse = Uri.parse(i);
            intent.setData(parse);
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                jj.Code().Code(this.I, parse, true);
                Code("web");
                return true;
            } catch (ActivityNotFoundException unused) {
                fb.Z(Code, "fail to open uri by cct");
            } catch (Throwable th) {
                fb.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return V();
    }
}
