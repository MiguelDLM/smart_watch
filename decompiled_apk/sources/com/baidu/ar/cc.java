package com.baidu.ar;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.ar.baidumap.bean.NavigationRes;
import com.baidu.ar.baidumap.bean.VpasResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class cc {
    public static List<NavigationRes> P(String str) {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
            NavigationRes navigationRes = new NavigationRes();
            if (jSONObject.has("arkey")) {
                navigationRes.setArkey(jSONObject.getString("arkey"));
            }
            if (jSONObject.has("url")) {
                navigationRes.setUrl(jSONObject.getString("url"));
            }
            if (jSONObject.has("version")) {
                navigationRes.setVersion(jSONObject.getString("version"));
            }
            arrayList.add(navigationRes);
        }
        return arrayList;
    }

    public static ArrayList<HashMap<String, Object>> Q(String str) {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("arkey", jSONObject.getString("arkey"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("anchor");
                HashMap hashMap2 = new HashMap();
                hashMap2.put(RequestParameters.POSITION, jSONObject2.getString(RequestParameters.POSITION));
                hashMap2.put("scale", jSONObject2.getString("scale"));
                hashMap2.put("rotation", jSONObject2.getString("rotation"));
                hashMap.put("anchor", hashMap2);
                HashMap hashMap3 = new HashMap();
                JSONObject jSONObject3 = jSONObject.getJSONObject("config");
                hashMap3.put("preload_distance", jSONObject3.getString("preload_distance"));
                hashMap3.put("load_distance", jSONObject3.getString("load_distance"));
                hashMap.put("config", hashMap3);
                arrayList.add(hashMap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static VpasResource R(String str) {
        JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
        JSONObject jSONObject2 = jSONObject.getJSONObject("navigation_resource");
        VpasResource vpasResource = new VpasResource();
        if (jSONObject2 != null) {
            NavigationRes navigationRes = new NavigationRes();
            if (jSONObject2.has("arkey")) {
                navigationRes.setArkey(jSONObject2.getString("arkey"));
            }
            if (jSONObject2.has("url")) {
                navigationRes.setUrl(jSONObject2.getString("url"));
            }
            if (jSONObject2.has("version")) {
                navigationRes.setVersion(jSONObject2.getString("version"));
            }
            if (jSONObject.has("navigation_contents")) {
                navigationRes.setNavigationContents(Q(jSONObject.getString("navigation_contents")));
            }
            vpasResource.setNavigationRes(navigationRes);
        }
        return vpasResource;
    }
}
