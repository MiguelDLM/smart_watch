package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.baidu.lbsapi.auth.LBSAuthManager;

/* loaded from: classes7.dex */
public class b {
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static String h = null;
    public static String i = null;
    public static int j = 0;
    public static int k = -2;
    public static long l = -1;

    /* renamed from: a, reason: collision with root package name */
    public String f5731a;
    public String b;
    public String c;
    public String d;
    private boolean m;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5732a = new b();
    }

    private b() {
        this.f5731a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.m = false;
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        return a.f5732a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.c != null) {
            stringBuffer.append("&cu=");
            str = this.c;
        } else {
            stringBuffer.append("&im=");
            str = this.f5731a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(e);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.523f);
        return stringBuffer.toString();
    }

    public String a(boolean z) {
        return a(z, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(boolean r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.a(boolean, java.lang.String):java.lang.String");
    }

    public void a(Context context) {
        if (context == null || this.m) {
            return;
        }
        try {
            this.c = LBSAuthManager.getInstance(context).getCUID();
        } catch (Exception unused) {
            this.c = null;
        }
        try {
            e = context.getPackageName();
        } catch (Exception unused2) {
            e = null;
        }
        try {
            i = o.f(context);
        } catch (Exception unused3) {
            i = null;
        }
        o.n = "" + this.c;
        this.m = true;
    }

    public void a(String str, String str2) {
        f = str;
        e = str2;
    }
}
