package com.baidu.location.e.a;

import com.baidu.location.e.a.a;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f5727a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;
    private static int e = -1;
    private static int f = -1;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f5728a = new b(null);
    }

    /* renamed from: com.baidu.location.e.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC0131b {
        SUBWAY_STATIC,
        TRAFFIC_STATUS,
        VDR_INDOOR_SPEED_STATUS,
        INDOOR_POI_DATA_STATUS,
        OUTDOOR_POI_DATA_STATUS,
        GPS_CHECKER_STATUS
    }

    private b() {
    }

    public static b a() {
        return a.f5728a;
    }

    public /* synthetic */ b(c cVar) {
        this();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(EnumC0131b enumC0131b) {
        switch (d.f5730a[enumC0131b.ordinal()]) {
            case 1:
                if (f5727a == 0) {
                    return a.e.b;
                }
                return null;
            case 2:
                if (b == 0) {
                    return a.f.b;
                }
                return null;
            case 3:
                if (c == 0) {
                    return a.c.b;
                }
                return null;
            case 4:
                if (d == 0) {
                    return a.b.f5722a;
                }
                return null;
            case 5:
                if (e == 0) {
                    return a.d.f5724a;
                }
                return null;
            case 6:
                if (f == 0) {
                    return a.C0130a.f5721a;
                }
                return null;
            default:
                return null;
        }
    }
}
