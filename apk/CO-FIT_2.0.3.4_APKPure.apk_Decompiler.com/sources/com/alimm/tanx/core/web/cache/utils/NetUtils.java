package com.alimm.tanx.core.web.cache.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetUtils {
    public static String getOriginUrl(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            URL url = new URL(str);
            int port = url.getPort();
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getHost());
            if (port != -1) {
                str2 = ":" + port;
            }
            sb.append(str2);
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static Map<String, String> multimapToSingle(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            List<String> list = (List) next.getValue();
            sb.delete(0, sb.length());
            if (list != null && list.size() > 0) {
                for (String append : list) {
                    sb.append(append);
                    sb.append(x.aL);
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            hashMap.put(next.getKey(), sb.toString());
        }
        return hashMap;
    }
}
