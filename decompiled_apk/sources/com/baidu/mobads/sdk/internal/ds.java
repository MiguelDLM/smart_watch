package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ds {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f6319a;

    public ds(Context context, Activity activity, Boolean bool) {
        this.f6319a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f6319a;
    }

    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
