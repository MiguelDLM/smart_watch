package com.baidu.navisdk.module.routeresultbase.view.template.selector;

import java.util.List;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f7567a;

    public static boolean a(String str) {
        List<String> list = f7567a;
        if (list == null) {
            return false;
        }
        return list.contains(str);
    }

    public static List<String> b() {
        return f7567a;
    }

    public static void a() {
        List<String> list = f7567a;
        if (list != null) {
            list.clear();
            f7567a = null;
        }
    }
}
