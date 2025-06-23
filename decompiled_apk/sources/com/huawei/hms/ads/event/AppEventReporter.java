package com.huawei.hms.ads.event;

import android.content.Context;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.cx;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.aa;
import java.util.Map;

@AllApi
/* loaded from: classes10.dex */
public class AppEventReporter {
    @AllApi
    public static void reportEventData(Context context, Map<String, String> map) {
        g.V(context).Code(cx.S, aa.V(map), null, null);
    }
}
