package com.huawei.hms.ads;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.Tencent;

/* loaded from: classes10.dex */
public class jt implements jr {
    private static final int B = 600;
    private static final String C = "com.tencent.tauth.Tencent";
    private static final String Code = "QQSharer";
    private static final int I = 40;
    private static final int V = 30;
    private static final int Z = 200;

    @NonNull
    private static Bundle Code(jv jvVar, jx jxVar) {
        Bundle bundle = new Bundle();
        if (jvVar != null && jxVar != null) {
            boolean booleanValue = jxVar.V().booleanValue();
            bundle.putString("title", jy.Code(jvVar.V(), booleanValue ? 30 : 40));
            bundle.putString("summary", jy.Code(jvVar.I(), jxVar.V().booleanValue() ? 200 : 600));
            bundle.putString("targetUrl", jvVar.Z());
            String Code2 = jvVar.Code();
            bundle.putString(Code2.startsWith("http") ? "imageUrl" : "imageLocalUrl", Code2);
            bundle.putInt("req_type", 1);
            bundle.putInt("cflag", booleanValue ? 2 : 1);
        }
        return bundle;
    }

    @Override // com.huawei.hms.ads.jr
    public void Code(Activity activity, jv jvVar, jx jxVar) {
        fb.V(Code, "start QQ share");
        Tencent.createInstance(jxVar.Code(), activity).shareToQQ(activity, Code(jvVar, jxVar), new DefaultUiListener());
    }

    @Override // com.huawei.hms.ads.jr
    public boolean Code() {
        return jy.Code(C);
    }
}
