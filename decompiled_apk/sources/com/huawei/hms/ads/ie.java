package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ie extends ib<kl> implements iq {

    /* renamed from: com.huawei.hms.ads.ie$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        public AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.bb.E, this.Code);
                com.huawei.openalliance.ad.ipc.g.V(ie.this.V).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ie.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        final String data = callResult.getData();
                        if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
                            return;
                        }
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ie.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((kl) ie.this.I()).Code(data);
                            }
                        });
                    }
                }, String.class);
            } catch (JSONException unused) {
                fb.Code("PPSVideoViewPresenter", "check video cache jsonEx");
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ie.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((kl) ie.this.I()).Code(AnonymousClass1.this.Code);
                    }
                });
            }
        }
    }

    public ie(Context context, kl klVar) {
        super(context, klVar);
    }

    @Override // com.huawei.hms.ads.iq
    public void Code(long j, long j2, long j3, long j4) {
        jc.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ai.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.iq
    public void F() {
        jc.Code(this.V, this.Code, com.huawei.openalliance.ad.constant.ai.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.ib
    public void V(String str) {
        ((kl) I()).B();
        fb.V("PPSVideoViewPresenter", "onMaterialLoaded - begin to load video");
        if (TextUtils.isEmpty(str) || !str.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
            fb.V("PPSVideoViewPresenter", "check if video cached.");
            com.huawei.openalliance.ad.utils.h.I(new AnonymousClass1(str));
        } else {
            fb.V("PPSVideoViewPresenter", "video is cached.");
            ((kl) I()).Code(str);
        }
    }

    @Override // com.huawei.hms.ads.iq
    public void Code(boolean z) {
        AdEventReport Code = jc.Code(this.Code);
        Code.I(z);
        com.huawei.openalliance.ad.ipc.g.V(this.V).Code(com.huawei.openalliance.ad.constant.s.j, com.huawei.openalliance.ad.utils.aa.V(Code), null, null);
    }
}
