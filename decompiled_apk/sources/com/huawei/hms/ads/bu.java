package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public abstract class bu {
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x002f. Please report as an issue. */
    public static int Code(int i) {
        if (i == -1) {
            return 1006;
        }
        if (i == 200) {
            return 1000;
        }
        if (i != 204) {
            if (i == 496) {
                return 1007;
            }
            if (i == 498 || i == 804) {
                return 1001;
            }
            if (i == 1001) {
                return 1002;
            }
            if (i != 1100) {
                if (i == 704) {
                    return 1008;
                }
                if (i == 705) {
                    return 1009;
                }
                if (i != 801) {
                    if (i != 802) {
                        switch (i) {
                            case 700:
                                break;
                            case 701:
                                break;
                            case 702:
                                break;
                            default:
                                switch (i) {
                                    case 900:
                                        break;
                                    case 901:
                                        break;
                                    case 902:
                                        break;
                                    default:
                                        return 1010;
                                }
                        }
                    }
                    return 1003;
                }
                return 1004;
            }
        }
        return 1005;
    }
}
