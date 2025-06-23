package com.huawei.openalliance.ad.activity;

import android.os.Bundle;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ge;

/* loaded from: classes10.dex */
public class PPSNotificationActivity extends d {
    private static final String Code = "PPSNotificationActivity";

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fb.Code(Code, "PPSNotification onCreate");
        ge.Code(this).Code(this, getIntent());
        finish();
    }
}
