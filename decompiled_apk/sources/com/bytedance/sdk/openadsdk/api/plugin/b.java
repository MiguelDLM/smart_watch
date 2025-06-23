package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final StringBuffer f10692a = new StringBuffer();

    public static void a(String str, String str2) {
        StringBuffer stringBuffer = f10692a;
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(';');
        stringBuffer.append(str);
        stringBuffer.append(';');
        stringBuffer.append(str2);
        stringBuffer.append('\n');
    }

    public static String a() {
        return f10692a.toString();
    }
}
