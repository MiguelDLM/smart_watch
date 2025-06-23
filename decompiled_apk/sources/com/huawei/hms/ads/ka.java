package com.huawei.hms.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

/* loaded from: classes10.dex */
public class ka implements jr {
    private static final int B = 110;
    private static final String C = "#%s# %s";
    private static final String Code = "WeiBoShare";
    private static final Integer F = 100;
    private static final int I = 32768;
    private static final String L = "";
    private static final String S = "com.sina.weibo.sdk.auth.AuthInfo";
    private static final int V = 5242880;
    private static final int Z = 30;

    /* renamed from: a, reason: collision with root package name */
    private static final String f17320a = "";
    private Boolean D = Boolean.TRUE;

    private static String Code(jv jvVar) {
        return String.format(C, jy.Code(jvVar.V(), 30), jy.Code(jvVar.I(), 110));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Activity activity, jv jvVar, IWBAPI iwbapi) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        Code(jvVar, weiboMultiMessage);
        Code(BitmapFactory.decodeStream(new ByteArrayInputStream(jy.Code(activity, jvVar, 5242880))), weiboMultiMessage);
        Code(jvVar, BitmapFactory.decodeStream(new ByteArrayInputStream(jy.Code(activity, jvVar, 32768))), weiboMultiMessage);
        iwbapi.shareMessage(activity, weiboMultiMessage, true);
    }

    @Override // com.huawei.hms.ads.jr
    public void Code(Activity activity, jv jvVar, jx jxVar) {
        fb.V(Code, "start WeiBo share");
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(activity);
        createWBAPI.setLoggerEnable(true);
        AuthInfo authInfo = new AuthInfo(activity, jxVar.Code(), "", "");
        if (!this.D.booleanValue()) {
            V(activity, jvVar, createWBAPI);
        } else {
            Code(activity, jvVar, createWBAPI, authInfo);
            this.D = Boolean.FALSE;
        }
    }

    private static void Code(final Activity activity, final jv jvVar, final IWBAPI iwbapi, AuthInfo authInfo) {
        iwbapi.registerApp(activity, authInfo, new SdkListener() { // from class: com.huawei.hms.ads.ka.1
            @Override // com.sina.weibo.sdk.openapi.SdkListener
            public void onInitFailure(Exception exc) {
            }

            @Override // com.sina.weibo.sdk.openapi.SdkListener
            public void onInitSuccess() {
                ka.V(activity, jvVar, iwbapi);
            }
        });
    }

    private static void Code(Bitmap bitmap, WeiboMultiMessage weiboMultiMessage) {
        ImageObject imageObject = new ImageObject();
        imageObject.setImageData(bitmap);
        weiboMultiMessage.imageObject = imageObject;
    }

    private static void Code(jv jvVar, Bitmap bitmap, WeiboMultiMessage weiboMultiMessage) {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.actionUrl = jvVar.Z();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.defaultText = "分享网页";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, F.intValue(), byteArrayOutputStream);
            webpageObject.thumbData = byteArrayOutputStream.toByteArray();
        } finally {
            try {
                weiboMultiMessage.mediaObject = webpageObject;
            } finally {
            }
        }
        weiboMultiMessage.mediaObject = webpageObject;
    }

    private static void Code(jv jvVar, WeiboMultiMessage weiboMultiMessage) {
        TextObject textObject = new TextObject();
        textObject.text = Code(jvVar);
        weiboMultiMessage.textObject = textObject;
    }

    @Override // com.huawei.hms.ads.jr
    public boolean Code() {
        return jy.Code(S);
    }
}
