package com.kwad.sdk.core.videocache.a;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.ae;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes11.dex */
public final class f implements c {
    private static String eS(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getHost() != null && parse.getHost().contains("yximgs.com")) {
            Uri.Builder buildUpon = parse.buildUpon();
            HashMap hashMap = new HashMap();
            if (parse.isHierarchical()) {
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                for (String str2 : queryParameterNames) {
                    hashMap.put(str2, parse.getQueryParameter(str2));
                }
                buildUpon.clearQuery();
                for (String str3 : queryParameterNames) {
                    if (!"tag".equals(str3) && !"di".equals(str3) && str3 != null) {
                        buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                    }
                }
            }
            return buildUpon.toString();
        }
        return str;
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(47);
        if (lastIndexOf != -1 && lastIndexOf > lastIndexOf2 && lastIndexOf + 6 > str.length()) {
            return str.substring(lastIndexOf + 1, str.length());
        }
        return "";
    }

    @Override // com.kwad.sdk.core.videocache.a.c
    public final String generate(String str) {
        String eS = eS(str);
        String extension = getExtension(eS);
        String bx = ae.bx(eS);
        if (TextUtils.isEmpty(extension)) {
            return bx;
        }
        return bx + FileUtils.FILE_EXTENSION_SEPARATOR + extension;
    }
}
