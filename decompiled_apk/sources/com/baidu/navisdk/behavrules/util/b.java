package com.baidu.navisdk.behavrules.util;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static a f6662a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    public static void a(a aVar) {
        f6662a = aVar;
    }

    public static void b(String str, String str2) {
        a aVar = f6662a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public static void a(String str, String str2) {
        a aVar = f6662a;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }
}
