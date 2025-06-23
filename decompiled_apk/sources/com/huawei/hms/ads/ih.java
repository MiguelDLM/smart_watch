package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ih extends hw<kr> implements iu<kr> {
    public ih(Context context, kr krVar) {
        Code((ih) krVar);
        this.V = context != null ? context.getApplicationContext() : context;
    }

    @Override // com.huawei.hms.ads.iu
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Code = nVar != null ? nVar.n() : null;
    }

    @Override // com.huawei.hms.ads.hw
    public String S() {
        return "PlacementVideoViewPresenter_" + hashCode();
    }

    @Override // com.huawei.hms.ads.iu
    public void Code(final com.huawei.openalliance.ad.inter.data.p pVar) {
        if (pVar == null) {
            return;
        }
        fb.V(S(), "checkVideoHash");
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.ih.1
            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                final boolean I = pVar.I();
                String Z = pVar.Z();
                if (TextUtils.isEmpty(Z) || !Z.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.huawei.openalliance.ad.constant.bb.E, pVar.Z());
                            com.huawei.openalliance.ad.ipc.g.V(ih.this.V).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ih.1.2
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                    String data = callResult.getData();
                                    if (TextUtils.isEmpty(data) || !data.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
                                        return;
                                    }
                                    fb.V(ih.this.S(), "got video cached url");
                                    pVar.V(data);
                                }
                            }, String.class);
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ih.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    fb.Code(ih.this.S(), "video path: %s", pVar.e());
                                    ((kr) ih.this.I()).Code(pVar, I);
                                }
                            };
                        } catch (JSONException unused) {
                            fb.Code(ih.this.S(), "check video cache jsonEx");
                            runnable = new Runnable() { // from class: com.huawei.hms.ads.ih.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    fb.Code(ih.this.S(), "video path: %s", pVar.e());
                                    ((kr) ih.this.I()).Code(pVar, I);
                                }
                            };
                        }
                    } catch (Throwable th) {
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ih.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                fb.Code(ih.this.S(), "video path: %s", pVar.e());
                                ((kr) ih.this.I()).Code(pVar, I);
                            }
                        });
                        throw th;
                    }
                } else {
                    runnable = new Runnable() { // from class: com.huawei.hms.ads.ih.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fb.V(ih.this.S(), "video is cached.");
                            ((kr) ih.this.I()).Code(pVar, I);
                        }
                    };
                }
                com.huawei.openalliance.ad.utils.bf.Code(runnable);
                if (2 == pVar.c() || pVar.I()) {
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ih.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ((kr) ih.this.I()).Code(pVar, true);
                        }
                    });
                }
            }
        });
    }
}
