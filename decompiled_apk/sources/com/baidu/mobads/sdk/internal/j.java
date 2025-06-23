package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes7.dex */
public enum j {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD(MapBundleKey.MapObjKey.OBJ_AD, 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);

    String j;
    int k;

    j(String str, int i) {
        this.j = str;
        this.k = i;
    }

    public String b() {
        return this.j;
    }

    public int c() {
        return this.k;
    }

    public static j b(String str) {
        for (j jVar : values()) {
            if (jVar != null && TextUtils.isEmpty(jVar.j) && jVar.j.equals(str)) {
                return jVar;
            }
        }
        return null;
    }
}
