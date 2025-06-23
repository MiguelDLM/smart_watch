package com.baidu.ar;

import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class l {
    private static volatile Map<String, Integer> eu = ak();
    private static volatile Map<String, Integer> ev = al();

    private static Map<String, Integer> ak() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.ar.vo.VOAR", Integer.valueOf(FeatureCodes.VO));
        Integer valueOf = Integer.valueOf(FeatureCodes.POSE);
        hashMap.put("com.baidu.ar.pose.PoseAR", valueOf);
        hashMap.put("com.baidu.ar.stretch.StretchAR", valueOf);
        hashMap.put("com.baidu.ar.gesture.GestureAR", 1500);
        return hashMap;
    }

    private static Map<String, Integer> al() {
        HashMap hashMap = new HashMap();
        hashMap.put("ability_face_model", 1200);
        hashMap.put("ability_face_filter", 1000);
        hashMap.put("ability_makeup_filter", Integer.valueOf(FeatureCodes.BEAUTY_MAKEUP));
        hashMap.put("ability_vo", Integer.valueOf(FeatureCodes.VO));
        Integer valueOf = Integer.valueOf(FeatureCodes.POSE);
        hashMap.put("ability_pose", valueOf);
        hashMap.put("ability_body_detect", valueOf);
        hashMap.put("ability_gesture", 1500);
        hashMap.put("ability_image_segmentation", Integer.valueOf(FeatureCodes.BODY_SEG));
        hashMap.put("ability_sky_segmentation", Integer.valueOf(FeatureCodes.SKY_SEG));
        hashMap.put("ability_hair_segmentation", Integer.valueOf(FeatureCodes.HAIR_SEG));
        hashMap.put("ability_object_detect", 2000);
        hashMap.put("ability_3d_track", 3100);
        return hashMap;
    }

    public static boolean r(String str) {
        if (eu.containsKey(str)) {
            return ARAuth.checkFeatureAuth(eu.get(str).intValue());
        }
        return true;
    }

    public static boolean s(String str) {
        if (ev.containsKey(str)) {
            return ARAuth.checkFeatureAuth(ev.get(str).intValue());
        }
        return true;
    }

    public static boolean t(String str) {
        if (ev.containsKey(str)) {
            return ARAuth.enableFeature(ev.get(str).intValue());
        }
        return true;
    }
}
