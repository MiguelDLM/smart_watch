package com.aliyun.sls.android.producer;

import com.huawei.openalliance.ad.constant.x;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class HttpConfigProxy {
    private static final Map<String, String> PLUGIN_USER_AGENTS = new LinkedHashMap();

    static {
        addPluginUserAgent("sls-android-sdk", "2.6.12");
    }

    private HttpConfigProxy() {
    }

    public static void addPluginUserAgent(String str, String str2) {
        PLUGIN_USER_AGENTS.put(str, str2);
    }

    public static String getUserAgent() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : PLUGIN_USER_AGENTS.entrySet()) {
            sb.append(entry.getKey());
            sb.append("/");
            sb.append(entry.getValue());
            sb.append(x.aL);
        }
        return sb.substring(0, sb.length() - 1);
    }
}
