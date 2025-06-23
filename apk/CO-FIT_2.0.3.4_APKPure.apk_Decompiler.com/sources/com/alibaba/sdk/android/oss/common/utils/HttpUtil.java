package com.alibaba.sdk.android.oss.common.utils;

import OoOoXO0.xoXoI;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(urlEncode(str2, str));
            if (str3 != null) {
                sb.append("=");
                sb.append(urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static String urlEncode(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace(xoXoI.f16451X0o0xo, "%20").replace("*", "%2A").replace("%7E", "~").replace("%2F", "/");
        } catch (Exception e) {
            throw new IllegalArgumentException("failed to encode url!", e);
        }
    }
}
