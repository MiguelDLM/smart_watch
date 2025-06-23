package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ep extends af {

    /* loaded from: classes10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.q {
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
        }

        private List<H5Ad> Code(List<com.huawei.openalliance.ad.inter.data.i> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (com.huawei.openalliance.ad.inter.data.i iVar : list) {
                    if (iVar != null) {
                        arrayList.add(new H5Ad(iVar.n()));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(int i) {
            ag.Code(this.Z, this.I, bu.Code(i), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> Code = Code(map.get(this.Code));
                if (Code.size() > 0) {
                    ag.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.aa.V(Code), true);
                    return;
                }
            }
            fb.V("JsbReqRewardAd", " ads map is empty.");
            ag.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public ep() {
        super(aj.I);
    }

    @Override // com.huawei.hms.ads.af
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("slotId");
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.W);
        int optInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.e, 4);
        RequestOptions V = V(context, str);
        com.huawei.openalliance.ad.inter.p pVar = new com.huawei.openalliance.ad.inter.p(context, new String[]{optString});
        pVar.Code(V);
        pVar.Code((Integer) 3);
        pVar.Code(Z(optString2));
        pVar.Code(I(str));
        pVar.Code(new a(context, optString, remoteCallResultCallback, this.Code));
        pVar.Code(optInt, false);
    }
}
