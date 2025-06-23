package com.baidu.navisdk.behavrules.data;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<c> f6646a;

    public a(List<c> list) {
        this.f6646a = list;
    }

    public String a(String str, String str2) throws b {
        String[] strArr;
        int i;
        String[] strArr2;
        int i2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            strArr = null;
            i = 0;
        } else {
            strArr = (" " + str + " ").split("\\[\\[\\]\\]");
            i = strArr.length;
        }
        if (TextUtils.isEmpty(str2)) {
            strArr2 = null;
            i2 = 0;
        } else {
            strArr2 = str2.split("&");
            i2 = strArr2.length;
        }
        if (i2 + 1 != i) {
            throw new b("dataIdCount don't match ttsCount");
        }
        if (strArr == null || strArr2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(strArr[i3]);
            String a2 = a(strArr2[i3]);
            if (a2 != null) {
                sb.append(a2);
            } else {
                throw new b("parsedString is null, id = " + strArr2[i3]);
            }
        }
        sb.append(strArr[strArr.length - 1]);
        return sb.toString().trim();
    }

    private String a(String str) {
        if (this.f6646a == null) {
            return null;
        }
        for (int i = 0; i < this.f6646a.size(); i++) {
            String a2 = this.f6646a.get(i).a(str);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return null;
    }
}
