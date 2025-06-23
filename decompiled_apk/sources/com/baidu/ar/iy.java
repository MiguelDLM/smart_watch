package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class iy {
    private static ft zr;
    private static final List<String> zs = Arrays.asList(StatisticConstants.EVENT_FILTER_ADJUST, StatisticConstants.EVENT_FILTER_SWITCH, StatisticConstants.EVENT_BEAUTIFY_ADJUST);

    public static void b(fs fsVar) {
        ft ftVar = new ft() { // from class: com.baidu.ar.iy.1
            @Override // com.baidu.ar.ft
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                if (i == 1801) {
                    iy.n(hashMap);
                } else if (i == 1901) {
                    iy.m(hashMap);
                }
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(1801);
                arrayList.add(1901);
                return arrayList;
            }
        };
        zr = ftVar;
        fsVar.c(ftVar);
    }

    public static void c(fs fsVar) {
        ft ftVar = zr;
        if (ftVar != null) {
            if (fsVar != null) {
                fsVar.d(ftVar);
            }
            zr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.containsKey("event_name") && hashMap.containsKey("event_id") && "statistic_lua_event".equals((String) hashMap.get("event_name"))) {
            String str = (String) hashMap.get("event_id");
            Object obj = hashMap.get("event_map");
            if (obj == null || !(obj instanceof Map)) {
                StatisticApi.onEvent(str);
            } else {
                StatisticApi.onEvent(str, (Map<String, String>) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = (String) hashMap.get("id");
            String str2 = (String) hashMap.get("type");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            HashMap hashMap2 = new HashMap();
            if (hashMap.size() > 1) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (entry.getValue() != null) {
                        hashMap2.put(entry.getKey(), entry.getValue().toString());
                    }
                }
                hashMap2.remove("type");
                if (hashMap2.containsKey("id")) {
                    hashMap2.remove("id");
                    hashMap2.put("event_param", str);
                }
            }
            if (zs.contains(str2)) {
                StatisticApi.onEventDebounce(str2, 200L, hashMap2);
            } else {
                StatisticApi.onEvent(str2, hashMap2);
            }
        }
    }
}
