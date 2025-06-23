package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class js implements jr {
    private static final String Code = "MoreShareProcessor";
    private static final String I = "text/plain";
    private static final String V = "text/plain";
    private static final String Z = "";
    private String B;

    private List<Intent> Code(List<ResolveInfo> list, List<String> list2) {
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (list2.contains(resolveInfo.activityInfo.packageName)) {
                fb.Code(Code, "%s Not showing", resolveInfo.activityInfo.packageName);
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.B);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.jr
    @RequiresApi(api = 23)
    public void Code(Activity activity, jv jvVar, jx jxVar) {
        if (activity == null || activity.getApplicationContext() == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(jvVar.I() == null ? "" : jvVar.I());
        sb.append(jvVar.Z() != null ? jvVar.Z() : "");
        this.B = sb.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        List<Intent> Code2 = Code(applicationContext.getPackageManager().queryIntentActivities(intent, 131072), jxVar.Z());
        Intent createChooser = Intent.createChooser(Code2.remove(0), jvVar.V() != null ? jvVar.V() : "text/plain");
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) Code2.toArray(new Parcelable[0]));
        createChooser.setFlags(268435456);
        applicationContext.startActivity(createChooser);
    }

    @Override // com.huawei.hms.ads.jr
    public boolean Code() {
        return true;
    }
}
