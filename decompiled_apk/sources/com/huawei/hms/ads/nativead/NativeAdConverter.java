package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.by;
import com.huawei.openalliance.ad.inter.data.g;

@GlobalApi
/* loaded from: classes10.dex */
public class NativeAdConverter {
    @GlobalApi
    public static NativeAd deserialization(Context context, String str) {
        return deserialization(context, str, null);
    }

    @GlobalApi
    public static String serialization(NativeAd nativeAd) {
        if (nativeAd instanceof by) {
            return g.a.Code(((by) nativeAd).Code());
        }
        return null;
    }

    @GlobalApi
    public static NativeAd deserialization(Context context, String str, NativeAdConfiguration nativeAdConfiguration) {
        g Code = g.a.Code(str);
        if (Code == null) {
            return null;
        }
        by byVar = new by(context, Code);
        if (nativeAdConfiguration != null) {
            byVar.Code(nativeAdConfiguration);
        }
        return byVar;
    }
}
