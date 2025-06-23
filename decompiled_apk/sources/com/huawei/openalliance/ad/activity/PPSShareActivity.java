package com.huawei.openalliance.ad.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ju;
import com.huawei.hms.ads.jv;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.aa;

/* loaded from: classes10.dex */
public class PPSShareActivity extends d {
    private static final String Code = "PPSShareActivity";
    private static final String V = "shareClick";
    private com.huawei.openalliance.ad.views.dialog.b Z;
    private boolean I = true;
    private final DialogInterface.OnDismissListener B = new DialogInterface.OnDismissListener() { // from class: com.huawei.openalliance.ad.activity.PPSShareActivity.1
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PPSShareActivity.this.finish();
        }
    };

    private jv V() {
        SafeIntent safeIntent = (SafeIntent) getIntent();
        try {
            jv jvVar = new jv(safeIntent.getStringExtra("title"), safeIntent.getStringExtra("description"), safeIntent.getStringExtra("imageUrl"), safeIntent.getStringExtra("cshareUrl"));
            jvVar.Code(getPackageManager().getApplicationInfo(getPackageName(), 0).icon);
            jvVar.B(safeIntent.getStringExtra("contentId"));
            jvVar.S(safeIntent.getStringExtra("slotId"));
            jvVar.C(safeIntent.getStringExtra("templateId"));
            jvVar.Code((ImageInfo) aa.V(safeIntent.getStringExtra(ju.f), ImageInfo.class, new Class[0]));
            jvVar.Code((AdContentData) aa.V(safeIntent.getStringExtra(ju.g), AdContentData.class, new Class[0]));
            return jvVar;
        } catch (RuntimeException e) {
            fb.I(Code, "getIntentParams runtime exception: %s", e.getClass().getSimpleName());
            return null;
        } catch (Throwable th) {
            fb.I(Code, "getIntentParams error: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public void Code() {
        setContentView(R.layout.hiad_activity_share);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        fb.V(Code, "onCreate");
        super.onCreate(bundle);
        Code();
        jv V2 = V();
        if (V2 == null) {
            finish();
            return;
        }
        com.huawei.openalliance.ad.views.dialog.b bVar = new com.huawei.openalliance.ad.views.dialog.b(this, V2);
        this.Z = bVar;
        bVar.Code();
        this.Z.Code(this.B);
        cy.Code(this, V, V2.L());
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onDestroy() {
        fb.V(Code, "onDestroy");
        super.onDestroy();
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onResume() {
        super.onResume();
        fb.V(Code, "onResume");
        if (this.I) {
            this.I = false;
            return;
        }
        com.huawei.openalliance.ad.views.dialog.b bVar = this.Z;
        if (bVar != null) {
            bVar.V();
        }
    }
}
