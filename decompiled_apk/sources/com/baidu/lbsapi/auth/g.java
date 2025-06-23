package com.baidu.lbsapi.auth;

import android.content.Context;
import com.sma.smartv3.network.BaiDu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private Context f5588a;
    private List<HashMap<String, String>> b = null;
    private a<String> c = null;

    /* loaded from: classes7.dex */
    public interface a<Result> {
        void a(Result result);
    }

    public g(Context context) {
        this.f5588a = context;
    }

    private List<HashMap<String, String>> a(HashMap<String, String> hashMap, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap hashMap2 = new HashMap();
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                String str = it.next().toString();
                hashMap2.put(str, hashMap.get(str));
            }
            arrayList.add(hashMap2);
        } else {
            for (String str2 : strArr) {
                HashMap hashMap3 = new HashMap();
                Iterator<String> it2 = hashMap.keySet().iterator();
                while (it2.hasNext()) {
                    String str3 = it2.next().toString();
                    hashMap3.put(str3, hashMap.get(str3));
                }
                hashMap3.put(BaiDu.MCODE_KEY, str2);
                arrayList.add(hashMap3);
            }
        }
        return arrayList;
    }

    private void a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        a<String> aVar = this.c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    public void a(HashMap<String, String> hashMap, String[] strArr, String str, int i, String str2, String str3, a<String> aVar) {
        this.b = a(hashMap, strArr);
        this.c = aVar;
        new Thread(new h(this, str, i, str2, str3)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HashMap<String, String>> list, String str, int i, String str2, String str3) {
        int i2;
        b.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            b.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < list.size()) {
            b.a("syncConnect resuest " + i3 + "  start!!!");
            HashMap<String, String> hashMap = list.get(i3);
            i iVar = new i(this.f5588a);
            if (iVar.a()) {
                String a2 = iVar.a(hashMap, str, i, str2, str3);
                if (a2 == null) {
                    a2 = "";
                }
                b.a("syncConnect resuest " + i3 + "  result:" + a2);
                arrayList.add(a2);
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        b.a("auth end and break");
                        a(a2);
                        return;
                    }
                } catch (JSONException unused) {
                    b.a("continue-------------------------------");
                }
            } else {
                b.a("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            b.a("syncConnect end");
            i3++;
        }
        b.a("--iiiiii:" + i3 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() <= 0 || i3 != list.size() || arrayList.size() <= 0 || i3 != arrayList.size() || i3 - 1 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i2));
            if (!jSONObject2.has("status") || jSONObject2.getInt("status") == 0) {
                return;
            }
            b.a("i-1 result is not 0,return first result");
            a((String) arrayList.get(0));
        } catch (JSONException e) {
            a(ErrorMessage.a("JSONException:" + e.getMessage()));
        }
    }
}
