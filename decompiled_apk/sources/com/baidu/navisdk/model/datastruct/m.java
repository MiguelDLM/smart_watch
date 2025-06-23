package com.baidu.navisdk.model.datastruct;

/* loaded from: classes7.dex */
public class m {
    private static final int[] e = {-10647319, -12202902, -20992, -43949, -4248030};
    private static final int[] f = {-10647319, -14629239, -16640, -45747, -3211250};

    /* renamed from: a, reason: collision with root package name */
    public int f6935a;
    public int b;
    public int c;
    public int d;

    public static int b(int i) {
        if (i < 0 || i > 4) {
            i = 0;
        }
        return e[i];
    }

    public int a() {
        int i = this.b;
        if (i < 0 || i > 4) {
            this.b = 0;
        }
        return e[this.b];
    }

    public String toString() {
        return "RoadConditionItem{curItemEndIndex=" + this.f6935a + ", roadConditionType=" + this.b + ", endAddDist=" + this.c + ", endTravelTime=" + this.d + '}';
    }

    public static int a(int i) {
        if (i < 0 || i > 4) {
            i = 0;
        }
        return f[i];
    }
}
