package com.baidu.xclient.gdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.xclient.gdid.jni.Native;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    public static Object a(int i, Object obj, Object obj2, Object obj3) {
        return c.a().a(i, obj, obj2, obj3);
    }

    public static String b() {
        return c.a().e();
    }

    public static String c(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).f();
    }

    public static String d(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).i();
    }

    public static String e(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).j();
    }

    public static String f(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).g();
    }

    public static String g(Context context) {
        return com.baidu.xclient.gdid.jni.c.a(context).h();
    }

    public static boolean h(Context context) {
        return TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(context).a());
    }

    public static String a(Context context) {
        return (String) com.baidu.xclient.gdid.e.d.d(context).first;
    }

    public static String b(Context context) {
        return "";
    }

    public static void c() {
        c.a().b();
    }

    public static String a(String str) {
        return c.a().a(str);
    }

    public static String b(String str) {
        return c.a().b(str);
    }

    public static JSONObject a() {
        return c.a().c();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return new Native().dc(bArr, bArr2);
    }

    public static void a(Context context, String str, String str2) {
        c.a().a(context, str, str2);
    }

    public static void a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        c.a().a(context, str, str2, hashMap);
    }

    public static void a(HashMap<String, String> hashMap) {
        c.a().a(hashMap);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return new Native().ac(bArr, bArr2);
    }
}
