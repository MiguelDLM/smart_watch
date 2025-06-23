package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class a implements ParamBuilder<a> {

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, String> f10006a;

    public a a(String str, String str2) {
        if (this.f10006a == null) {
            this.f10006a = new LinkedHashMap();
        }
        this.f10006a.put(str, str2);
        return this;
    }

    public String a() {
        Map<String, String> map = this.f10006a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f10006a.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f10006a.get(str2));
            str = i == 0 ? str + str2 + "=" + encodeUrlParamsValue : str + "&" + str2 + "=" + encodeUrlParamsValue;
            i++;
        }
        return str;
    }
}
