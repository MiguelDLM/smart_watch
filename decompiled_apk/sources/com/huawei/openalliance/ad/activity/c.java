package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ju;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.q;

/* loaded from: classes10.dex */
public class c {
    public static void Code(Context context, l lVar, AdContentData adContentData) {
        ImageInfo imageInfo;
        fb.Code("NativeActivityStarter", "startComplianceActivity");
        if (Code(lVar)) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) PPSShareActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("title", lVar.Code());
            intent.putExtra("description", lVar.V());
            if (lVar.B() != null && !lVar.B().isEmpty() && (imageInfo = lVar.B().get(0)) != null) {
                intent.putExtra(ju.f, aa.V(imageInfo));
                intent.putExtra("imageUrl", imageInfo.Z());
            }
            intent.putExtra("cshareUrl", lVar.az());
            intent.putExtra("contentId", lVar.a());
            intent.putExtra("slotId", lVar.o());
            intent.putExtra("templateId", lVar.as());
            intent.putExtra(ju.g, aa.V(adContentData));
            bc.Code(context, intent);
        } catch (Throwable th) {
            fb.I("NativeActivityStarter", "start Activity error: %s", th.getClass().getSimpleName());
        }
    }

    private static boolean Code(l lVar) {
        String str;
        if (q.Code()) {
            str = "repeat click too fast";
        } else {
            if (lVar != null) {
                return false;
            }
            str = "nativeAd is null";
        }
        fb.Code("NativeActivityStarter", str);
        return true;
    }
}
