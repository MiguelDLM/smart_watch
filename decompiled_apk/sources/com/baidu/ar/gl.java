package com.baidu.ar;

/* loaded from: classes7.dex */
public class gl {
    private static volatile gh uW;
    private static volatile gg uX;

    public static boolean eH() {
        return true;
    }

    private static boolean eI() {
        return true;
    }

    public static gh eJ() {
        if (uW != null) {
            return uW;
        }
        if (eH() && uW == null) {
            uW = (gh) kr.cq("com.baidu.ar.gk");
        }
        return uW;
    }

    public static gg eK() {
        if (uX != null) {
            return uX;
        }
        if (eI() && uX == null) {
            uX = (gg) kr.cq("com.baidu.ar.gj");
        }
        return uX;
    }

    public static void release() {
        if (uW != null) {
            uW.release();
            uW = null;
        }
        if (uX != null) {
            uX.release();
            uX = null;
        }
    }
}
