package com.huawei.hms.ads;

import android.app.Activity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.UUID;

/* loaded from: classes10.dex */
public class kb implements jr {
    private static final String B = "com.tencent.mm.opensdk.openapi.WXAPIFactory";
    private static final String Code = "WeiXinShare";
    private static final int I = 512;
    private static final int V = 32768;
    private static final int Z = 1024;

    private static int Code(jx jxVar) {
        return !jxVar.V().booleanValue() ? 1 : 0;
    }

    @Override // com.huawei.hms.ads.jr
    public void Code(Activity activity, jv jvVar, jx jxVar) {
        fb.V(Code, "start WeXin share");
        String Code2 = jxVar.Code();
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(jq.Code(activity), Code2, true);
        createWXAPI.registerApp(Code2);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = jvVar.Z();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = jy.Code(jvVar.V(), 512);
        wXMediaMessage.description = jy.Code(jvVar.I(), 1024);
        wXMediaMessage.thumbData = jy.Code(activity, jvVar, 32768);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = UUID.randomUUID().toString();
        req.message = wXMediaMessage;
        req.scene = Code(jxVar);
        createWXAPI.sendReq(req);
    }

    @Override // com.huawei.hms.ads.jr
    public boolean Code() {
        return jy.Code(B);
    }
}
