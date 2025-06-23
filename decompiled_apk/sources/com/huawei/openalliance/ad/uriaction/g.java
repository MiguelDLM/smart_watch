package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.bg;

/* loaded from: classes10.dex */
public class g extends p {
    private static final String Code = "HarmonyAppAction";

    public g(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        try {
            fb.V(Code, "handle harmony app action");
            AppInfo y = this.Z.y();
            if (y == null || TextUtils.isEmpty(y.Code())) {
                fb.V(Code, "parameters occur error");
            } else if (Boolean.parseBoolean((String) bg.Code(this.I, this.Z, 11, String.class))) {
                Code(v.Z);
                return true;
            }
        } catch (Throwable th) {
            fb.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
        }
        return V();
    }
}
