package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes10.dex */
public class cm implements cv {
    private static final String I = "BaseDeviceImpl";
    protected Context Code;
    protected com.huawei.openalliance.ad.utils.aq V;

    public cm(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = com.huawei.openalliance.ad.utils.aq.Code(applicationContext);
    }

    @Override // com.huawei.hms.ads.cv
    public boolean B() {
        return false;
    }

    @Override // com.huawei.hms.ads.cv
    public String C() {
        return null;
    }

    @Override // com.huawei.hms.ads.cv
    public int Code(View view) {
        return 0;
    }

    @Override // com.huawei.hms.ads.cv
    public boolean I() {
        return true;
    }

    @Override // com.huawei.hms.ads.cv
    public boolean S() {
        return false;
    }

    @Override // com.huawei.hms.ads.cv
    public boolean V() {
        return true;
    }

    @Override // com.huawei.hms.ads.cv
    public String Z() {
        return null;
    }

    @Override // com.huawei.hms.ads.cv
    public boolean Code() {
        return true;
    }

    @Override // com.huawei.hms.ads.cv
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.cv
    public boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            fb.I(I, "check widget available error");
            return false;
        }
    }
}
