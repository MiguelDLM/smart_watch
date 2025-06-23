package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.bg;

/* loaded from: classes10.dex */
public class h extends p {
    private static final String Code = "HarmonyServiceAction";

    public h(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        try {
            fb.V(Code, "handle harmony service action");
            AppInfo y = this.Z.y();
            if (y == null || TextUtils.isEmpty(y.Code()) || TextUtils.isEmpty(y.A())) {
                fb.V(Code, "parameters occur error");
            } else if (Boolean.parseBoolean((String) bg.Code(this.I, this.Z, 12, String.class))) {
                Code(v.I);
                return true;
            }
        } catch (Throwable th) {
            fb.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
        }
        return V();
    }
}
