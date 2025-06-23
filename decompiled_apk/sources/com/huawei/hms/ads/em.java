package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class em extends af {

    /* loaded from: classes10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.i {
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

        private List<H5Ad> Code(List<AdContentData> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (AdContentData adContentData : list) {
                    if (adContentData != null && adContentData.d() > System.currentTimeMillis()) {
                        if (TextUtils.isEmpty(adContentData.aa())) {
                            adContentData.S(UUID.randomUUID().toString());
                        }
                        arrayList.add(new H5Ad(adContentData));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.i
        public void Code(int i) {
            ag.Code(this.Z, this.I, bu.Code(i), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.i
        public void Code(Map<String, List<AdContentData>> map) {
            if (map == null || map.size() <= 0) {
                fb.V("JsbReqInterstitialAd", " ads map is empty.");
            } else {
                List<H5Ad> Code = Code(map.get(this.Code));
                if (Code.size() > 0) {
                    ag.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.aa.V(Code), true);
                    return;
                }
                fb.Code("JsbReqInterstitialAd", " ads is empty.");
            }
            ag.Code(this.Z, this.I, 1005, null, true);
        }
    }

    public em() {
        super(aj.Z);
    }

    @Override // com.huawei.hms.ads.af
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String optString = new JSONObject(str).optString("slotId");
        AdParam I = I(context, str);
        aa aaVar = new aa(context);
        aaVar.Code(optString);
        aaVar.Code((Integer) 3);
        aaVar.Code(new a(context, optString, remoteCallResultCallback, this.Code));
        aaVar.Code(I);
    }
}
