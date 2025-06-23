package com.baidu.navisdk.module.asr;

import androidx.annotation.NonNull;
import com.baidu.nplatform.comapi.MapItem;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final com.baidu.navisdk.module.userclassification.e f7035a = new a();

    public static void b() {
        com.baidu.navisdk.module.userclassification.f.a().a(f7035a);
    }

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.module.userclassification.e {
        @Override // com.baidu.navisdk.module.userclassification.e
        public Set<String> a() {
            HashSet hashSet = new HashSet();
            hashSet.add("xd_query");
            return hashSet;
        }

        @Override // com.baidu.navisdk.module.userclassification.e
        public void a(@NonNull Map<String, JSONObject> map, boolean z, long j) {
            JSONObject jSONObject = map.get("xd_query");
            if (jSONObject == null) {
                return;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("son_key");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(keys.next());
                    if (jSONObject3 != null) {
                        String string = jSONObject3.getString("id");
                        int optInt = jSONObject3.optInt(MapItem.KEY_IS_MAP_ITEM, 1);
                        com.baidu.navisdk.asr.query.a.a(com.baidu.navisdk.framework.a.c().a()).a(string, new com.baidu.navisdk.asr.query.c(jSONObject3.optInt("week", 3), jSONObject3.optInt("day", 2), optInt));
                    }
                }
            } catch (JSONException e) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                if (gVar.c()) {
                    gVar.c("RGAsrQueryInitializer", "jsonException e = " + e);
                }
            }
            com.baidu.navisdk.module.userclassification.f.a().b(g.f7035a);
        }
    }
}
