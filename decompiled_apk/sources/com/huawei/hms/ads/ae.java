package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ae extends ag {
    private static final String Z = "JsbAdClick";

    public ae() {
        super(aj.C);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        final JSONObject jSONObject = new JSONObject(str);
        final int optInt = jSONObject.optInt("adType", -1);
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.ae.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    MetaData S = adContentData.S();
                    if (S != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(com.huawei.openalliance.ad.uriaction.i.Code, S.b());
                        hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, S.a());
                        if (optInt == 3 && adContentData.t() != null) {
                            VideoInfo videoInfo = new VideoInfo(adContentData.t());
                            hashMap.put(com.huawei.openalliance.ad.constant.bb.m, adContentData.D());
                            hashMap.put(com.huawei.openalliance.ad.constant.bb.p, String.valueOf(adContentData.J()));
                            hashMap.put(com.huawei.openalliance.ad.constant.bb.s, adContentData.H() ? "true" : "false");
                            hashMap.put(com.huawei.openalliance.ad.constant.bb.r, videoInfo.a());
                        }
                        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(ae.this.Code(context), adContentData, hashMap);
                        if (!Code.Code()) {
                            fb.Code(ae.Z, "fail open land page");
                            i = 3003;
                        } else if (ae.this.Code(adContentData)) {
                            MaterialClickInfo C = ae.this.C(str);
                            Integer B = ae.this.B(str);
                            boolean z = C.D() == null && C.L() == null;
                            if (B != null && 13 == B.intValue() && z) {
                                C.B(1);
                            }
                            adContentData.Code(ae.this.S(jSONObject.optString("versionCode")));
                            ae.this.Code(Code, context, adContentData, C, B);
                        } else {
                            fb.V(ae.Z, "ad is not in whitelist");
                            i = 3004;
                        }
                    }
                    i = 1000;
                } else {
                    fb.Code(ae.Z, "ad not exist");
                    i = 3002;
                }
                ag.Code(remoteCallResultCallback, ae.this.Code, i, null, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.uriaction.p pVar, Context context, AdContentData adContentData, MaterialClickInfo materialClickInfo, Integer num) {
        int intValue = num == null ? 12 : num.intValue();
        fb.V(Z, "source = %s", Integer.valueOf(intValue));
        jc.Code(context, adContentData, (String) null, 0, 0, pVar.I(), intValue, com.huawei.openalliance.ad.utils.b.Code(context), materialClickInfo);
    }
}
