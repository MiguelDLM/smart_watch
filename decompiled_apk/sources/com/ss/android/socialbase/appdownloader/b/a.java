package com.ss.android.socialbase.appdownloader.b;

import XXO0.oIX0oI;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;

/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26157a;

    static {
        boolean z;
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = Build.ID;
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if ("REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL)) {
            z = true;
        } else {
            z = false;
        }
        sb.append("AppDownloader");
        if (!isEmpty) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (!isEmpty) {
            sb.append(" ");
            sb.append(str);
        }
        if (z || !isEmpty2) {
            sb.append(x.aL);
            if (z) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (!isEmpty2) {
                sb.append(" Build/");
                sb.append(str2);
            }
        }
        sb.append(oIX0oI.I0Io.f4095I0Io);
        f26157a = sb.toString();
    }
}
