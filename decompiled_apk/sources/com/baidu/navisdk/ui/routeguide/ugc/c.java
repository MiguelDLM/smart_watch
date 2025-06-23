package com.baidu.navisdk.ui.routeguide.ugc;

import com.baidu.navisdk.ui.routeguide.model.x;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f9148a;

    private static String a(int i) {
        switch (i) {
            case 0:
                return "北环团雾";
            case 1:
                return "北环结冰";
            case 2:
                return "北环大雪";
            case 3:
                return "北环积水";
            case 4:
                return "北环封路";
            case 5:
                return "北环管制";
            case 6:
                return "北环危险";
            case 7:
                return "北环施工";
            case 8:
                return "北环事故";
            default:
                return "北环拥堵";
        }
    }

    private static int b(int i) {
        switch (i) {
            case 0:
                return 401;
            case 1:
                return 403;
            case 2:
                return 404;
            case 3:
                return 405;
            case 4:
                return 104;
            case 5:
                return 103;
            case 6:
                return 107;
            case 7:
                return 110;
            case 8:
                return 102;
            default:
                return 101;
        }
    }

    public static void a() {
        if (g.UGC.b()) {
            int i = f9148a;
            int i2 = i % 10;
            f9148a = i + 1;
            x A = x.A();
            A.b(b(i2));
            A.c(0);
            A.a(a(i2));
            A.c("用户上报，" + a(i2));
            A.d("用户上报，" + a(i2));
            A.b("853f2deee30ad8582ab97c18");
            A.d(5);
            A.a(20);
            A.r = 3;
            A.f(0);
        }
    }
}
