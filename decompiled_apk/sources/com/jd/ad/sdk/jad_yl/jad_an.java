package com.jd.ad.sdk.jad_yl;

import android.text.TextUtils;

/* loaded from: classes10.dex */
public enum jad_an {
    NET_CONNECTION_IS_NULL_ERROR(10001, "http connection is null"),
    NET_HTTP_RESPONSE_IS_NULL_ERROR(10002, "http response is null"),
    NET_HTTP_OTHER_ERROR(10003, "http other error");

    public int jad_an;
    public String jad_bo;

    jad_an(int i, String str) {
        this.jad_an = i;
        this.jad_bo = str;
    }

    public String jad_an(String... strArr) {
        StringBuilder sb = new StringBuilder(this.jad_bo);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(":");
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
