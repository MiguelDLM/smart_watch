package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.jn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: classes10.dex */
public class m extends p {
    private static final String Code = "OuterWebAction";

    public m(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private String Z() {
        for (String str : ed.Code(this.I).l()) {
            if (com.huawei.openalliance.ad.utils.g.Code(this.I, str)) {
                return str;
            }
        }
        return "";
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        AdContentData adContentData = this.Z;
        if (adContentData == null || !(ja.Code(adContentData.v()) || am.Z(this.I))) {
            return V();
        }
        fb.V(Code, "handle outer browser action");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String i = this.Z.i();
        if (!ay.Code(i)) {
            intent.setData(Uri.parse(i));
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                if (ja.V(this.Z.v())) {
                    fb.Code(Code, "handleUri, use default browser");
                    String Z = Z();
                    if (TextUtils.isEmpty(Z)) {
                        fb.I(Code, "can not find default browser");
                    } else {
                        intent.setPackage(Z);
                    }
                }
                PackageManager packageManager = this.I.getPackageManager();
                if (packageManager != null && !packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                    Code("web");
                    jn.a aVar = new jn.a();
                    aVar.Code(this.Z).Code(intent);
                    com.huawei.openalliance.ad.utils.g.Code(this.I, intent, aVar.Code());
                    return true;
                }
            } catch (ActivityNotFoundException unused) {
                fb.Z(Code, "fail to open uri");
            } catch (Throwable th) {
                fb.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return V();
    }
}
