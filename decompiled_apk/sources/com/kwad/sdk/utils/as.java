package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes11.dex */
public final class as {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        String str2;
        if (map != null && map.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                str2 = "&";
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (map.get(next) != null) {
                    sb.append(next);
                    sb.append("=");
                    sb.append(map.get(next));
                    sb.append("&");
                }
            }
            String substring = sb.toString().substring(0, r6.length() - 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (!str.contains(LocationInfo.NA)) {
                str2 = LocationInfo.NA;
            }
            sb2.append(str2);
            return sb2.toString() + substring;
        }
        return str;
    }
}
