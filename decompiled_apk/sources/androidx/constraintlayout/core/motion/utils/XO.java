package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final /* synthetic */ class XO {
    static {
        String str = TypedValues.PositionType.NAME;
    }

    public static int II0xO0(int i) {
        if (i != 100) {
            if (i != 101) {
                switch (i) {
                    case 501:
                    case 502:
                        return 8;
                    case 503:
                    case 504:
                    case 505:
                    case 506:
                    case 507:
                        return 4;
                    case 508:
                        return 2;
                    default:
                        return -1;
                }
            }
            return 8;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int oIX0oI(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 501;
            case 1:
                return 503;
            case 2:
                return 504;
            case 3:
                return 502;
            case 4:
                return 505;
            case 5:
                return 506;
            case 6:
                return 507;
            default:
                return -1;
        }
    }
}
