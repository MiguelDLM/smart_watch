package com.huawei.hms.ads;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.PPSNotificationActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class fx extends gc {
    private static final int C = 1;
    private static final String I = "AppInstalledNotification";
    private AdContentData B;
    private int S;
    private com.huawei.openalliance.ad.inter.data.AppInfo Z;

    public fx(Context context, AdContentData adContentData, String str) {
        super(context);
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo;
        this.B = adContentData;
        this.Z = adContentData.y();
        if (TextUtils.isEmpty(str) || (appInfo = this.Z) == null) {
            return;
        }
        appInfo.V(str);
    }

    private boolean D() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return (appInfo == null || appInfo.p() != 1 || TextUtils.isEmpty(this.Z.q())) ? false : true;
    }

    private boolean F() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return (appInfo == null || TextUtils.isEmpty(appInfo.Code())) ? false : true;
    }

    @Override // com.huawei.hms.ads.gc
    public String B() {
        return I;
    }

    @Override // com.huawei.hms.ads.gc
    public String C() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return appInfo != null ? com.huawei.openalliance.ad.utils.ay.V(appInfo.q()) : "";
    }

    @Override // com.huawei.hms.ads.gc
    public int Code() {
        if (F()) {
            return this.Z.Code().hashCode();
        }
        return 1;
    }

    @Override // com.huawei.hms.ads.gc
    public void I() {
        if (D()) {
            ge.Code(this.Code).Code(this.Z.Code());
            super.I();
            if (this.B == null || !com.huawei.openalliance.ad.utils.bc.d(this.Code)) {
                return;
            }
            gb.I(this.Code, this.B);
        }
    }

    @Override // com.huawei.hms.ads.gc
    public PendingIntent S() {
        return V(ge.Code);
    }

    public int V() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.gc
    public String Z() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo = this.Z;
        return appInfo != null ? appInfo.L() : "";
    }

    private PendingIntent Code(String str) {
        if (!F()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.Code.getPackageName());
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.Z);
        intent.putExtra(fz.I, this.S);
        intent.putExtra("contentRecord", this.B);
        return PendingIntent.getBroadcast(this.Code, Code(), intent, 201326592);
    }

    private PendingIntent V(String str) {
        if (!F()) {
            return null;
        }
        Intent intent = new Intent(this.Code, (Class<?>) PPSNotificationActivity.class);
        intent.setAction(str);
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.Z);
        intent.putExtra(fz.I, this.S);
        intent.putExtra("contentRecord", this.B);
        return PendingIntent.getActivity(this.Code, Code(), intent, 201326592);
    }

    private void V(Notification.Builder builder) {
        Context context;
        ApplicationInfo applicationInfo;
        Drawable loadIcon;
        if (!F() || (context = this.Code) == null || (applicationInfo = com.huawei.openalliance.ad.utils.g.V(context, this.Z.Code()).applicationInfo) == null || (loadIcon = applicationInfo.loadIcon(this.Code.getPackageManager())) == null) {
            return;
        }
        builder.setLargeIcon(com.huawei.openalliance.ad.utils.z.Code(loadIcon));
    }

    public void Code(int i) {
        this.S = i;
    }

    @Override // com.huawei.hms.ads.gc
    public void Code(Notification.Builder builder) {
        if (builder == null || !F()) {
            return;
        }
        V(builder);
        builder.setDeleteIntent(Code(ge.V));
    }
}
