package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ig extends fu<kn> implements it<kn> {
    private Context I;

    public ig(Context context, kn knVar) {
        Code((ig) knVar);
        this.I = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final com.huawei.openalliance.ad.inter.data.p pVar) {
        if (pVar == null) {
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(pVar.e());
        sourceParam.Code(52428800L);
        sourceParam.V(pVar.C());
        sourceParam.V(pVar.I());
        sourceParam.I(true);
        com.huawei.openalliance.ad.utils.z.Code(this.I, sourceParam, new com.huawei.openalliance.ad.utils.an() { // from class: com.huawei.hms.ads.ig.3
            @Override // com.huawei.openalliance.ad.utils.an
            public void Code() {
                fb.I("PlacementImageViewPresenter", "placement image load failed");
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ig.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ig.this.I().Code(null, null);
                    }
                });
            }

            @Override // com.huawei.openalliance.ad.utils.an
            public void Code(String str, final Drawable drawable) {
                com.huawei.openalliance.ad.inter.data.p pVar2 = pVar;
                if (pVar2 == null || !TextUtils.equals(str, pVar2.e())) {
                    return;
                }
                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ig.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ig.this.I().Code(pVar, drawable);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.it
    public void Code(final com.huawei.openalliance.ad.inter.data.n nVar) {
        final com.huawei.openalliance.ad.inter.data.p S;
        if (nVar == null || (S = nVar.S()) == null) {
            return;
        }
        String Z = S.Z();
        if (Z == null) {
            Code((com.huawei.openalliance.ad.inter.data.p) null);
        } else if (Z.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString())) {
            Code(Z, S);
        } else {
            com.huawei.openalliance.ad.utils.h.V(new Runnable() { // from class: com.huawei.hms.ads.ig.2
                @Override // java.lang.Runnable
                public void run() {
                    SourceParam sourceParam = new SourceParam();
                    sourceParam.I(S.Z());
                    sourceParam.V(S.C());
                    sourceParam.Code(com.huawei.openalliance.ad.constant.x.j);
                    sourceParam.V(S.L() == 0);
                    sourceParam.I(true);
                    Integer c = com.huawei.openalliance.ad.utils.aq.Code(ig.this.I).c();
                    if (c != null) {
                        sourceParam.V(c.intValue());
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("content_id", nVar.a());
                        jSONObject.put("slotid", nVar.o());
                        jSONObject.put("content", com.huawei.openalliance.ad.utils.aa.V(sourceParam));
                        com.huawei.openalliance.ad.ipc.g.V(ig.this.I).Code(com.huawei.openalliance.ad.constant.s.L, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ig.2.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                String data = callResult.getData();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                ig.this.Code(data, S);
                            }
                        }, String.class);
                    } catch (JSONException unused) {
                        fb.I("PlacementImageViewPresenter", "loadImageInfo jsonex");
                    }
                }
            });
        }
    }

    public void Code(final com.huawei.openalliance.ad.inter.data.p pVar) {
        if (pVar == null) {
            I().Code(null, null);
        } else {
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.ig.1
                @Override // java.lang.Runnable
                public void run() {
                    if (pVar.I()) {
                        ig.this.V(pVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, com.huawei.openalliance.ad.inter.data.p pVar) {
        if (str == null) {
            Code((com.huawei.openalliance.ad.inter.data.p) null);
        } else {
            pVar.V(str);
            Code(pVar);
        }
    }
}
