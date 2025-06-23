package com.huawei.openalliance.ad.activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class PPSLauncherActivity extends d {
    public static final String Code = "69";
    private static final String V = "PPSLauncherActivity";

    private void Code() {
        com.huawei.openalliance.ad.download.app.c.Code(this, Code, (AdContentData) null, (RemoteCallResultCallback) null, (Class) null);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb;
        Intent launchIntentForPackage;
        try {
            super.onCreate(bundle);
            if (Code(this)) {
                fb.V(V, "app is active.");
                launchIntentForPackage = new Intent();
                launchIntentForPackage.setComponent(new ComponentName(getPackageName(), PPSBridgeActivity.class.getName()));
                launchIntentForPackage.setFlags(268435456);
                launchIntentForPackage.setClipData(x.cM);
            } else {
                fb.V(V, " app is not active. start launch app");
                launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                launchIntentForPackage.setClipData(x.cM);
            }
            startActivity(launchIntentForPackage);
            Code();
            try {
                finish();
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                sb.append("finish activity error:");
                sb.append(th.getClass().getName());
                fb.V(V, sb.toString());
            }
        } catch (Throwable th2) {
            try {
                fb.V(V, "intent is not supported:" + th2.getClass().getName());
                try {
                    finish();
                } catch (Throwable th3) {
                    th = th3;
                    sb = new StringBuilder();
                    sb.append("finish activity error:");
                    sb.append(th.getClass().getName());
                    fb.V(V, sb.toString());
                }
            } catch (Throwable th4) {
                try {
                    finish();
                } catch (Throwable th5) {
                    fb.V(V, "finish activity error:" + th5.getClass().getName());
                }
                throw th4;
            }
        }
    }

    public boolean Code(Context context) {
        ComponentName componentName;
        ComponentName componentName2;
        int i;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(10)) {
            componentName = runningTaskInfo.topActivity;
            if (componentName.getClassName().equalsIgnoreCase(PPSLauncherActivity.class.getName())) {
                i = runningTaskInfo.numActivities;
                if (i < 2) {
                    return false;
                }
            }
            componentName2 = runningTaskInfo.topActivity;
            if (componentName2.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
