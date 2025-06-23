package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6234a = x.q;
    private static final String b = "pauseDlByPk";
    private static final String c = "cancelDlByPk";
    private static final String d = "resumeDownload";
    private static final String e = "getDownloadStatus";
    private static at g;
    private au f;

    private at(Context context) {
        this.f = au.a(context, f6234a);
    }

    public static at a(Context context) {
        if (g == null) {
            synchronized (at.class) {
                try {
                    if (g == null) {
                        g = new at(context);
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f.a(null, c, str);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, b, str, 1);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b2 = this.f.b(null, d, context, jSONObject, str, str2);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bw.a(context, str)) {
            return 103;
        }
        Object b2 = this.f.b(null, e, str);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return -1;
    }
}
