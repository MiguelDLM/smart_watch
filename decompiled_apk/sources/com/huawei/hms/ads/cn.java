package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import java.util.Locale;

/* loaded from: classes10.dex */
public class cn extends cm {
    private static final int B = 0;
    private static final String I = "BaseHwnDeviceImpl";
    private static final String Z = "display_notch_status";

    public cn(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean Code(Context context) {
        try {
            int i = Settings.Secure.getInt(context.getContentResolver(), Z);
            fb.Code(I, "isNotchEnable, displayNotch: %s", Integer.valueOf(i));
            return i == 0;
        } catch (Throwable th) {
            fb.V(I, "isNotchEnable err:" + th.getClass().getSimpleName());
            return Build.VERSION.SDK_INT >= 26 && Code((View) null) > 0;
        }
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean V() {
        String Code = com.huawei.openalliance.ad.utils.bc.Code("ro.product.locale.region");
        if (!TextUtils.isEmpty(Code)) {
            return "cn".equalsIgnoreCase(Code);
        }
        String Code2 = com.huawei.openalliance.ad.utils.bc.Code("ro.product.locale");
        if (!TextUtils.isEmpty(Code2)) {
            return Code2.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String Z2 = com.huawei.openalliance.ad.utils.bc.Z();
        if (TextUtils.isEmpty(Z2)) {
            return false;
        }
        return "cn".equalsIgnoreCase(Z2);
    }
}
