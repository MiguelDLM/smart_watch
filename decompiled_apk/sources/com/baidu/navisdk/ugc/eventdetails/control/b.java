package com.baidu.navisdk.ugc.eventdetails.control;

import android.util.SparseIntArray;
import com.baidu.ar.base.MsgField;
import com.garmin.fit.OxXXx0X;
import com.sina.weibo.sdk.common.Version;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static SparseIntArray f8060a;
    private static int[] b;

    private static int[] a() {
        return new int[]{3101, 4301, 4306, 4309, OxXXx0X.Ix00, 4310, 4304, OxXXx0X.xIOOIO, OxXXx0X.I0IIXxxo, OxXXx0X.XIoox00ox, OxXXx0X.OIOxOX, 4321, 4322, 4323, 5000, 5001, 5002, 5003, 5004, 5005, 5006, 5007, 5008, 5009, MsgField.MSG_SESSION_INVALID, MsgField.MSG_VPS_STATISTIC, 2102, 2103, MsgField.MSG_ID_TRACK_MODEL_CAN_DISAPPEARING, MsgField.MSG_ID_TRACK_MSG_ID_TRACK_LOST, 2110, 2111, 2112, 2120, 2121, 2122, MsgField.MSG_ON_CREATE_CASE_END, Version.WBSDK_VERSION, 5013, 5014, 2205, 2203, 2206, OxXXx0X.f13185oXIoO};
    }

    private static int[] b() {
        return new int[]{MsgField.IMSG_MODE_SHOWING};
    }

    private static void c() {
        if (b == null) {
            b = new int[]{5000, 5001, 5002, 5003, 5004, 5005, 5006, 5007, 5008, 5009, MsgField.MSG_SESSION_INVALID, MsgField.MSG_VPS_STATISTIC, 4301, 4306, 4309, OxXXx0X.Ix00, 4310, 4304, 4321, 4322, 4323, 2102, 2103, MsgField.MSG_ID_TRACK_MODEL_CAN_DISAPPEARING, MsgField.MSG_ID_TRACK_MSG_ID_TRACK_LOST, 2110, 2111, 2112, 2120, 2121, 2122, MsgField.MSG_ON_CREATE_CASE_END, OxXXx0X.xIOOIO, OxXXx0X.I0IIXxxo, OxXXx0X.XIoox00ox, OxXXx0X.OIOxOX, Version.WBSDK_VERSION, 5014, 5013, 2205, 2203, 2206, OxXXx0X.f13185oXIoO};
        }
    }

    public static boolean d(int i) {
        if (i == 4309 || i == 4310 || i == 5013 || i == 5014) {
            return true;
        }
        switch (i) {
            case 2102:
            case 2103:
            case MsgField.MSG_ID_TRACK_MODEL_CAN_DISAPPEARING /* 2104 */:
            case MsgField.MSG_ID_TRACK_MSG_ID_TRACK_LOST /* 2105 */:
                return true;
            default:
                switch (i) {
                    case 2110:
                    case 2111:
                    case 2112:
                        return true;
                    default:
                        switch (i) {
                            case 2120:
                            case 2121:
                            case 2122:
                                return true;
                            default:
                                switch (i) {
                                    case MsgField.MSG_ON_CREATE_CASE_END /* 2201 */:
                                    case Version.WBSDK_VERSION /* 2202 */:
                                    case 2203:
                                    case OxXXx0X.f13185oXIoO /* 2204 */:
                                    case 2205:
                                    case 2206:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 4301:
                                            case 5000:
                                            case 5001:
                                            case 5002:
                                            case 5003:
                                            case 5004:
                                            case 5005:
                                            case 5006:
                                            case 5007:
                                            case 5008:
                                            case 5009:
                                            case MsgField.MSG_SESSION_INVALID /* 50010 */:
                                            case MsgField.MSG_VPS_STATISTIC /* 50011 */:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 4304:
                                                    case OxXXx0X.Ix00 /* 4305 */:
                                                    case 4306:
                                                        return true;
                                                    default:
                                                        switch (i) {
                                                            case OxXXx0X.xIOOIO /* 4312 */:
                                                            case OxXXx0X.I0IIXxxo /* 4313 */:
                                                            case OxXXx0X.XIoox00ox /* 4314 */:
                                                            case OxXXx0X.OIOxOX /* 4315 */:
                                                                return true;
                                                            default:
                                                                switch (i) {
                                                                    case 4321:
                                                                    case 4322:
                                                                    case 4323:
                                                                        return true;
                                                                    default:
                                                                        return false;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0013. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0016. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0019. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x001c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0054  */
    @androidx.annotation.DrawableRes
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r1) {
        /*
            r0 = 4309(0x10d5, float:6.038E-42)
            if (r1 == r0) goto L90
            r0 = 4310(0x10d6, float:6.04E-42)
            if (r1 == r0) goto L8d
            r0 = 5013(0x1395, float:7.025E-42)
            if (r1 == r0) goto L8a
            r0 = 5014(0x1396, float:7.026E-42)
            if (r1 == r0) goto L87
            switch(r1) {
                case 2102: goto L84;
                case 2103: goto L81;
                case 2104: goto L7e;
                case 2105: goto L7b;
                default: goto L13;
            }
        L13:
            switch(r1) {
                case 2110: goto L78;
                case 2111: goto L75;
                case 2112: goto L72;
                default: goto L16;
            }
        L16:
            switch(r1) {
                case 2120: goto L6f;
                case 2121: goto L6c;
                case 2122: goto L69;
                default: goto L19;
            }
        L19:
            switch(r1) {
                case 2201: goto L66;
                case 2202: goto L63;
                case 2203: goto L60;
                case 2204: goto L60;
                case 2205: goto L63;
                case 2206: goto L5d;
                default: goto L1c;
            }
        L1c:
            switch(r1) {
                case 3101: goto L5a;
                case 4301: goto L57;
                case 5000: goto L54;
                case 5001: goto L90;
                case 5002: goto L51;
                case 5003: goto L8d;
                case 5004: goto L4e;
                case 5005: goto L4b;
                case 5006: goto L48;
                case 5007: goto L57;
                case 5008: goto L45;
                case 5009: goto L42;
                default: goto L1f;
            }
        L1f:
            switch(r1) {
                case 4304: goto L3f;
                case 4305: goto L51;
                case 4306: goto L54;
                default: goto L22;
            }
        L22:
            switch(r1) {
                case 4312: goto L3c;
                case 4313: goto L39;
                case 4314: goto L36;
                case 4315: goto L33;
                default: goto L25;
            }
        L25:
            switch(r1) {
                case 4321: goto L30;
                case 4322: goto L2d;
                case 4323: goto L2a;
                default: goto L28;
            }
        L28:
            r1 = 0
            return r1
        L2a:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_pathway_not_light
            return r1
        L2d:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_pathway_not_lay
            return r1
        L30:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_pathway_jolt
            return r1
        L33:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ugc_icon_truck_cannot_driving
            return r1
        L36:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_limit_weight
            return r1
        L39:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_limit_width
            return r1
        L3c:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_limit_height
            return r1
        L3f:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ugc_interaction_small_fenglu
            return r1
        L42:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_mg_cross_mutilane
            return r1
        L45:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_mg_nunmpy
            return r1
        L48:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_mg_emergency_gate
            return r1
        L4b:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_mg_bicycle_lane
            return r1
        L4e:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_mg_regulation_driver
            return r1
        L51:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_limit_turn_right
            return r1
        L54:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_limit_go_straight
            return r1
        L57:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_pathway
            return r1
        L5a:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_yongdu
            return r1
        L5d:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panshanlu
            return r1
        L60:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_zhai_yellow
            return r1
        L63:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_man
            return r1
        L66:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_lot_of_trucks
            return r1
        L69:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_fast
            return r1
        L6c:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_fast
            return r1
        L6f:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_tortoise
            return r1
        L72:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_tortoise
            return r1
        L75:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_tortoise
            return r1
        L78:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_tortoise
            return r1
        L7b:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_tortoise
            return r1
        L7e:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_fast
            return r1
        L81:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_fast
            return r1
        L84:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_speed_fast
            return r1
        L87:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_vrrious_police_check
            return r1
        L8a:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_vrrious_camera
            return r1
        L8d:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_limit_turn_round
            return r1
        L90:
            int r1 = com.baidu.navisdk.embed.R.drawable.nsdk_ic_panel_limit_turn_lef
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.control.b.a(int):int");
    }

    public static int b(int i) {
        d();
        SparseIntArray sparseIntArray = f8060a;
        if (sparseIntArray != null) {
            return sparseIntArray.get(i, 1);
        }
        return 1;
    }

    private static void d() {
        if (f8060a == null) {
            f8060a = new SparseIntArray();
            for (int i : b()) {
                f8060a.put(i, 2);
            }
            for (int i2 : a()) {
                f8060a.put(i2, 3);
            }
        }
    }

    public static boolean c(int i) {
        c();
        for (int i2 : b) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }
}
