package com.baidu.tts;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes8.dex */
public class j2 {

    /* renamed from: a, reason: collision with root package name */
    public int f10115a;
    public int b;
    public String c;
    public int d;
    public String e;
    public long f;
    public long g;
    public JSONArray h;

    public Map<String, Object> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(this.b));
        String str = this.e;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("sn", str);
        linkedHashMap.put("error_code", Integer.valueOf(this.d));
        linkedHashMap.put("sub_error_code", Integer.valueOf(this.f10115a));
        linkedHashMap.put("error_des", this.c);
        linkedHashMap.put("time_online", Long.valueOf(this.f));
        linkedHashMap.put("time_offline", Long.valueOf(this.g));
        Object obj = this.h;
        if (obj == null) {
            obj = "{}";
        }
        linkedHashMap.put("speak_caton", obj);
        return linkedHashMap;
    }
}
