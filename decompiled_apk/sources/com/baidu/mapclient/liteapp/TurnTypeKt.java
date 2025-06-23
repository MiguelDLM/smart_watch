package com.baidu.mapclient.liteapp;

import OXOo.OOXIXo;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class TurnTypeKt {

    /* loaded from: classes7.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RouteGuideKind.values().length];
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Front.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Right_Front.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Right_Back.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Left_Back.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Left.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Left_Front.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Right_Front_Straight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Left_Front_Straight.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Left_PassRoad_Front.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Right_PassRoad_Front.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Left_PassRoad_UTurn.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_Right_PassRoad_UTurn.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Right.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Right_Front.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Front.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Left_Front.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Left.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Left_Back.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Left.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Left_Front.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Front.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Right_Front.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Right.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Right_Back.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_PassRoad_Left.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[RouteGuideKind.NE_Maneuver_Kind_PassRoad_Right.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int bdBikeRouteGuideKindToTurnType(@OOXIXo RouteGuideKind routeGuideKind) {
        IIX0o.x0xO0oo(routeGuideKind, "routeGuideKind");
        switch (WhenMappings.$EnumSwitchMapping$0[routeGuideKind.ordinal()]) {
            case 1:
            default:
                return 5;
            case 2:
                return 42;
            case 3:
                return 35;
            case 4:
                return 34;
            case 5:
                return 15;
            case 6:
                return 16;
            case 7:
                return 23;
            case 8:
                return 43;
            case 9:
                return 24;
            case 10:
                return 25;
            case 11:
                return 44;
            case 12:
                return 26;
            case 13:
                return 45;
            case 14:
                return 21;
            case 15:
                return 22;
            case 16:
                return 17;
            case 17:
                return 20;
            case 18:
                return 19;
            case 19:
                return 18;
            case 20:
                return 37;
            case 21:
                return 38;
            case 22:
                return 36;
            case 23:
                return 41;
            case 24:
                return 40;
            case 25:
                return 39;
            case 26:
                return 27;
            case 27:
                return 28;
        }
    }

    public static final int bdWalkRouteGuideKindToTurnType(@OOXIXo RouteGuideKind routeGuideKind) {
        IIX0o.x0xO0oo(routeGuideKind, "routeGuideKind");
        switch (WhenMappings.$EnumSwitchMapping$0[routeGuideKind.ordinal()]) {
            case 1:
            default:
                return 2;
            case 2:
                return 85;
            case 3:
                return 92;
            case 4:
                return 60;
            case 5:
                return 18;
            case 6:
                return 50;
            case 7:
                return 43;
            case 8:
                return 84;
            case 9:
                return 42;
            case 10:
                return 46;
            case 11:
                return 88;
            case 12:
                return 49;
            case 13:
                return 91;
            case 14:
                return 37;
            case 15:
                return 36;
            case 16:
                return 22;
            case 17:
                return 30;
            case 18:
                return 31;
            case 19:
                return 26;
            case 20:
                return 70;
            case 21:
                return 69;
            case 22:
                return 64;
            case 23:
                return 78;
            case 24:
                return 79;
            case 25:
                return 74;
            case 26:
                return 53;
            case 27:
                return 56;
        }
    }
}
