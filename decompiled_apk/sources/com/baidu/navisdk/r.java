package com.baidu.navisdk;

/* loaded from: classes7.dex */
public class r {
    public static String a(int i) {
        if (i == 101) {
            return "拥堵";
        }
        if (i == 102) {
            return "事故";
        }
        if (i == 104) {
            return "封路";
        }
        if (i == 107) {
            return "危险";
        }
        if (i == 110) {
            return "施工";
        }
        if (i == 405) {
            return "积水";
        }
        if (i == 5010) {
            return "疑似阻断";
        }
        switch (i) {
            case 5000:
                return "禁止直行";
            case 5001:
                return "禁止左转";
            case 5002:
                return "禁止右转";
            case 5003:
                return "禁止掉头";
            case 5004:
                return "禁止通行";
            default:
                return "未知";
        }
    }

    public static boolean b(int i) {
        if (i == 101 || i == 102 || i == 104 || i == 107 || i == 110 || i == 405 || i == 5010) {
            return true;
        }
        switch (i) {
            case 5000:
            case 5001:
            case 5002:
            case 5003:
            case 5004:
                return true;
            default:
                return false;
        }
    }
}
