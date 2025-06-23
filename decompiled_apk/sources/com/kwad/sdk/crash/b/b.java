package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes11.dex */
public final class b {
    private Set<String> aHg = new HashSet();
    private Set<String> aHh = new HashSet();

    public final synchronized String[] Ih() {
        Set<String> set;
        set = this.aHh;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized String[] It() {
        Set<String> set;
        set = this.aHg;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aHg.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.aHh.add(str2);
                }
            }
        }
    }
}
