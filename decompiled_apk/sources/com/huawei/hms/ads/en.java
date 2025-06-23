package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class en extends af {

    /* loaded from: classes10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.n {
        private int B;
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        public a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2, int i) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
            this.B = i;
        }

        private ArrayList<FeedbackInfo> Code(com.huawei.openalliance.ad.inter.data.g gVar) {
            if (!com.huawei.openalliance.ad.utils.ad.Code(gVar.e_()) || com.huawei.openalliance.ad.utils.ad.Code(gVar.m()) || com.huawei.openalliance.ad.utils.ad.Code(gVar.p()) || gVar.m().size() != gVar.p().size()) {
                return null;
            }
            ArrayList<FeedbackInfo> arrayList = new ArrayList<>();
            for (int i = 0; i < gVar.m().size(); i++) {
                FeedbackInfo feedbackInfo = new FeedbackInfo();
                feedbackInfo.Code(gVar.m().get(i));
                feedbackInfo.Code(com.huawei.openalliance.ad.utils.ay.Code(gVar.p().get(i), -1L));
                feedbackInfo.Code(1);
                arrayList.add(feedbackInfo);
            }
            return arrayList;
        }

        private <T> void I(List<T> list) {
            if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
                ag.Code(this.Z, this.I, 1000, list, true);
            } else {
                fb.V("JsbReqNativeAd", " ads list is empty.");
                ag.Code(this.Z, this.I, 1005, null, true);
            }
        }

        private void V(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList();
            Code(list, arrayList);
            I(arrayList);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.n
        public void Code(int i) {
            ag.Code(this.Z, this.I, bu.Code(i), null, true);
        }

        private void Code(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList();
            Code(list, arrayList);
            I(arrayList);
        }

        private <T> void Code(List<com.huawei.openalliance.ad.inter.data.g> list, List<T> list2) {
            if (com.huawei.openalliance.ad.utils.ad.Code(list)) {
                return;
            }
            for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
                if (gVar != null && gVar.n() != null) {
                    int i = this.B;
                    if (i == 3) {
                        AdContentData n = gVar.n();
                        n.L(n.aC());
                        if (!com.huawei.openalliance.ad.utils.ad.Code(Code(gVar))) {
                            n.L(Code(gVar));
                        }
                        n.a(n.aQ());
                        list2.add(gVar.n());
                    } else if (i == 2) {
                        list2.add(new H5Ad(gVar.n()));
                    }
                }
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.n
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
            if (com.huawei.openalliance.ad.utils.ai.Code(map)) {
                fb.Code("JsbReqNativeAd", " ads map is empty.");
                ag.Code(this.Z, this.I, 1005, null, true);
                return;
            }
            List<com.huawei.openalliance.ad.inter.data.g> list = map.get(this.Code);
            int i = this.B;
            if (i == 2) {
                Code(list);
            } else {
                if (i != 3) {
                    return;
                }
                V(list);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements com.huawei.openalliance.ad.inter.listeners.e {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.e
        public void Code(List<String> list) {
            ag.Code(this.V, this.Code, 200, new JsbCallBackData(com.huawei.openalliance.ad.utils.aa.V(list), false, ah.Code));
        }
    }

    public en() {
        super(aj.V);
    }

    private List<Integer> Code(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                int optInt = jSONArray.optInt(i, -111111);
                if (optInt != -111111) {
                    arrayList.add(Integer.valueOf(optInt));
                }
            }
        }
        return arrayList;
    }

    private String D(String str) {
        HashMap hashMap = new HashMap();
        Map map = (Map) com.huawei.openalliance.ad.utils.aa.V(str, Map.class, new Class[0]);
        if (map != null && map.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                if (entry != null) {
                    arrayList.add(new ImpEX((String) entry.getKey(), com.huawei.openalliance.ad.utils.ay.S((String) entry.getValue())));
                }
            }
            if (arrayList.size() > 0) {
                hashMap.put("contentBundle", arrayList);
            }
        }
        if (hashMap.size() > 0) {
            return com.huawei.openalliance.ad.utils.aa.V(hashMap);
        }
        return null;
    }

    private List<String> V(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.af
    public void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("slotId");
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.W);
        JSONArray optJSONArray = jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.aw.X);
        String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.aR);
        int optInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.aQ, 2);
        int optInt2 = jSONObject.optInt("adType", 3);
        int optInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.b, -111111);
        int optInt4 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.c, -111111);
        int optInt5 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.d, -111111);
        int optInt6 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.e, 4);
        int optInt7 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.g, -111111);
        int optInt8 = jSONObject.optInt("maxCount", 0);
        List<String> V = V(jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.aw.f));
        boolean optBoolean = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.aJ, true);
        boolean optBoolean2 = jSONObject.optBoolean("directCacheVideo", false);
        boolean optBoolean3 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.aK, false);
        RequestOptions Code = c.Code(V(context, str));
        com.huawei.openalliance.ad.inter.m mVar = new com.huawei.openalliance.ad.inter.m(context, new String[]{optString}, optInt2, V);
        if (optInt7 != -111111) {
            mVar.Z(Integer.valueOf(optInt7));
        }
        if (optInt3 != -111111) {
            mVar.Code(Integer.valueOf(optInt3));
        }
        if (optInt4 != -111111) {
            mVar.V(Integer.valueOf(optInt4));
        }
        if (optInt5 != -111111) {
            mVar.I(Integer.valueOf(optInt5));
        }
        if (optInt8 > 0) {
            mVar.V(optInt8);
        }
        mVar.Code(Code);
        mVar.Code(D(optString2));
        mVar.Z(Z(optString2));
        mVar.Code(Code(optJSONArray));
        mVar.Code(optBoolean);
        mVar.V(optBoolean2);
        mVar.Code(new b(remoteCallResultCallback, this.Code));
        mVar.Code(new a(context, optString, remoteCallResultCallback, this.Code, optInt));
        mVar.B((Integer) 3);
        mVar.Code(I(str));
        mVar.Z(optBoolean3);
        mVar.C(optString3);
        mVar.Code(optInt6, false);
    }
}
