package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jl;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ay;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class e extends p {
    private static final String Code = "FeatureAbilityAction";
    private static final String V = "openErrorPage";

    public e(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Code(int i) {
        jc.Code(this.I, this.Z, ai.d, (Integer) 1, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        jl jlVar = this.B;
        if (jlVar != null) {
            jlVar.Code(-1);
        }
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        try {
            fb.V(Code, "handle Feature ability action");
            Context context = this.I;
            if (context != null && this.Z != null) {
                if (!ck.Code(context).B()) {
                    fb.I(Code, "UnSupport, because device's system is not HarmonyOs");
                    Code(-1);
                    Z();
                    return V();
                }
                if (!com.huawei.openalliance.ad.utils.f.Code(this.I)) {
                    fb.I(Code, "UnSupport AGDS");
                    Code(-1);
                    Z();
                    return V();
                }
                if (TextUtils.isEmpty(this.Z.aG())) {
                    fb.I(Code, "parameters is empty!");
                    Code(-1);
                    Z();
                    return V();
                }
                PPSAbilityDataContent pPSAbilityDataContent = (PPSAbilityDataContent) aa.V(this.Z.aG(), PPSAbilityDataContent.class, new Class[0]);
                if (pPSAbilityDataContent == null) {
                    fb.I(Code, "abilityDataContent is not json!");
                    Code(-1);
                    Z();
                    return V();
                }
                if (!ay.Code(pPSAbilityDataContent.I()) && !ay.Code(pPSAbilityDataContent.B()) && !ay.Code(pPSAbilityDataContent.Z())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("slotid", this.Z.L());
                    jSONObject.put("content_id", this.Z.a());
                    jSONObject.put("templateId", this.Z.aE());
                    jSONObject.put("apiVer", this.Z.aF());
                    jSONObject.put(bb.e, this.Z.D());
                    CallResult Code2 = com.huawei.openalliance.ad.ipc.b.Code(this.I).Code(s.J, null, String.class);
                    if (Code2 != null && 200 == Code2.getCode()) {
                        com.huawei.openalliance.ad.ipc.g.V(this.I).Code(s.J, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.uriaction.e.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                                fb.V(e.Code, "OPEN_FA_ACTION.onRemoteCallResult: %s, %s", Integer.valueOf(callResult.getCode()), callResult.getMsg());
                                if (e.this.B != null && callResult.getCode() == -1) {
                                    e.this.Z();
                                } else if (e.this.B != null && callResult.getCode() == 200) {
                                    e.this.B.Code(200);
                                }
                                if (callResult.getCode() != -1 || e.V.equals(callResult.getMsg())) {
                                    return;
                                }
                                e.this.V();
                            }
                        }, String.class);
                        Code(v.I);
                        return true;
                    }
                    fb.I(Code, "kit version is too old");
                    Code(-1);
                    Z();
                    return V();
                }
                fb.I(Code, "packageName or moduleName or serviceName is empty");
                Code(-1);
                Z();
                return V();
            }
            fb.I(Code, "context or contentRecord is null");
            Z();
            return V();
        } catch (Throwable th) {
            fb.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            if (this.I != null && this.Z != null) {
                Code(-1);
            }
            Z();
            return V();
        }
    }
}
