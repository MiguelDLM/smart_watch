package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ia extends hw<kd> implements in<kd> {
    public ia(Context context, kd kdVar) {
        Code((ia) kdVar);
        this.V = context;
    }

    private void V(final ImageInfo imageInfo) {
        String str;
        String str2;
        if (imageInfo == null) {
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            str = adContentData.a();
            str2 = this.Code.L();
        } else {
            str = null;
            str2 = null;
        }
        com.huawei.openalliance.ad.utils.z.Code(this.V, sourceParam, str, str2, new com.huawei.openalliance.ad.utils.an() { // from class: com.huawei.hms.ads.ia.2
            @Override // com.huawei.openalliance.ad.utils.an
            public void Code() {
                fb.I("NativeVideoP", "cover image load fail");
            }

            @Override // com.huawei.openalliance.ad.utils.an
            public void Code(String str3, final Drawable drawable) {
                ImageInfo imageInfo2 = imageInfo;
                if (imageInfo2 == null || !TextUtils.equals(str3, imageInfo2.Z())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ia.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((kd) ia.this.I()).Code(imageInfo, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.in
    public void Code(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return;
        }
        V(imageInfo);
    }

    @Override // com.huawei.hms.ads.hw
    public String S() {
        return "NativeVideoP";
    }

    @Override // com.huawei.hms.ads.in
    public void Code(final VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        final boolean Code = videoInfo.Code();
        String V = videoInfo.V();
        if (TextUtils.isEmpty(V) || !V.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
            fb.V("NativeVideoP", "check if video cached.");
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.ia.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.bb.E, videoInfo.V());
                            com.huawei.openalliance.ad.ipc.g.V(ia.this.V).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ia.1.1
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
                                        return;
                                    }
                                    videoInfo.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ia.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    fb.Code("NativeVideoP", "video path: %s", videoInfo.V());
                                    kd kdVar = (kd) ia.this.I();
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    kdVar.Code(videoInfo, Code);
                                }
                            };
                        } catch (JSONException unused) {
                            fb.Code("NativeVideoP", "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ia.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    fb.Code("NativeVideoP", "video path: %s", videoInfo.V());
                                    kd kdVar = (kd) ia.this.I();
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    kdVar.Code(videoInfo, Code);
                                }
                            };
                        }
                        com.huawei.openalliance.ad.utils.bf.Code(runnable);
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ia.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                fb.Code("NativeVideoP", "video path: %s", videoInfo.V());
                                kd kdVar = (kd) ia.this.I();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                kdVar.Code(videoInfo, Code);
                            }
                        });
                        throw th;
                    }
                }
            });
        } else {
            fb.V("NativeVideoP", "video is cached.");
            ((kd) I()).Code(videoInfo, Code);
        }
    }

    @Override // com.huawei.hms.ads.in
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.Code = lVar != null ? lVar.n() : null;
    }

    @Override // com.huawei.hms.ads.in
    public void Code(boolean z) {
        jc.Code(this.V, this.Code, z);
    }
}
