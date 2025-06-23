package com.huawei.hms.ads;

import android.app.Activity;
import com.huawei.works.share.WeApi;
import com.huawei.works.share.modelmsg.WeCardObject;
import com.huawei.works.share.modelmsg.WeMediaMessage;

/* loaded from: classes10.dex */
public class jz implements jr {
    private static final String Code = "WeLinkShare";
    private static final String I = "1";
    private static final String V = "com.huawei.works.share.WeApi";
    private static final String Z = "0";

    @Override // com.huawei.hms.ads.jr
    public void Code(Activity activity, jv jvVar, jx jxVar) {
        try {
            fb.V(Code, "start WeLink share");
            WeCardObject weCardObject = new WeCardObject();
            weCardObject.title = jvVar.V();
            weCardObject.desc = jvVar.I();
            weCardObject.uri = jvVar.Code();
            weCardObject.sourceURL = jvVar.Z();
            weCardObject.shareType = "image-txt";
            weCardObject.isPCDisplay = jxVar.I().booleanValue() ? "1" : "0";
            WeApi.getInstance(activity).share(new WeMediaMessage(weCardObject));
        } catch (Throwable th) {
            fb.I(Code, "WeLink share occurs a exception, caused: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.jr
    public boolean Code() {
        return jy.Code(V);
    }
}
