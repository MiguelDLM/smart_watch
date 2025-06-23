package com.baidu.navisdk.asr;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f6541a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str);

        boolean a();

        void stopTTS();
    }

    public static void a(a aVar) {
        f6541a = aVar;
    }

    public static void b() {
        f6541a = null;
    }

    public static void c() {
        a aVar = f6541a;
        if (aVar != null) {
            aVar.stopTTS();
        }
    }

    public static boolean a() {
        a aVar = f6541a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public static void a(String str) {
        a aVar = f6541a;
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
