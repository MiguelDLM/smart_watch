package com.baidu.platform.comapi.walknavi.h.b;

import android.text.TextUtils;
import com.baidu.R;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f9768a = {R.drawable.wn_dest, R.drawable.wn_faraway_route, R.drawable.wn_gps, R.drawable.wn_ladder, R.drawable.wn_overline_bridge, R.drawable.wn_park, R.drawable.wn_reroute, R.drawable.wn_ring, R.drawable.wn_square, R.drawable.wn_start, R.drawable.wn_turn_front, R.drawable.wn_turn_goto_leftroad_front, R.drawable.wn_turn_goto_leftroad_uturn, R.drawable.wn_turn_goto_rightroad_front, R.drawable.wn_turn_goto_rightroad_uturn, R.drawable.wn_turn_left, R.drawable.wn_turn_left_back, R.drawable.wn_turn_left_diagonal_passroad_front, R.drawable.wn_turn_left_diagonal_passroad_left, R.drawable.wn_turn_left_diagonal_passroad_left_back, R.drawable.wn_turn_left_diagonal_passroad_left_front, R.drawable.wn_turn_left_diagonal_passroad_right, R.drawable.wn_turn_left_diagonal_passroad_right_front, R.drawable.wn_turn_left_front, R.drawable.wn_turn_left_front_straight, R.drawable.wn_turn_left_passroad_front, R.drawable.wn_turn_left_passroad_uturn, R.drawable.wn_turn_passroad_left, R.drawable.wn_turn_passroad_right, R.drawable.wn_turn_right, R.drawable.wn_turn_right_back, R.drawable.wn_turn_right_diagonal_passroad_front, R.drawable.wn_turn_right_diagonal_passroad_left, R.drawable.wn_turn_right_diagonal_passroad_left_front, R.drawable.wn_turn_right_diagonal_passroad_right, R.drawable.wn_turn_right_diagonal_passroad_right_back, R.drawable.wn_turn_right_diagonal_passroad_right_front, R.drawable.wn_turn_right_front, R.drawable.wn_turn_right_front_straight, R.drawable.wn_turn_right_passroad_front, R.drawable.wn_turn_right_passroad_uturn, R.drawable.wn_underground_passage, R.drawable.wn_uturn, R.drawable.wn_waypoint, R.drawable.wn_left_three_left_side, R.drawable.wn_left_three_middle, R.drawable.wn_left_three_right_side, R.drawable.wn_left_two_left_side, R.drawable.wn_left_two_right_side, R.drawable.wn_right_three_left_side, R.drawable.wn_right_three_middle, R.drawable.wn_right_three_right_side, R.drawable.wn_right_two_left_side, R.drawable.wn_right_two_right_side, R.drawable.wn_three_left_side, R.drawable.wn_three_middle, R.drawable.wn_three_right_side, R.drawable.wn_two_left_side, R.drawable.wn_two_right_side, R.drawable.wn_ship, R.drawable.wn_door, R.drawable.wn_elevator, R.drawable.wn_stair, R.drawable.wn_escalator, R.drawable.wn_securitycheck, R.drawable.wn_indoor_bianjie};
    private static final int[] b = {R.drawable.wn_dest_blue, R.drawable.wn_faraway_route_blue, R.drawable.wn_gps_blue, R.drawable.wn_ladder_blue, R.drawable.wn_overline_bridge_blue, R.drawable.wn_park_blue, R.drawable.wn_reroute_blue, R.drawable.wn_ring_blue, R.drawable.wn_square_blue, R.drawable.wn_start_blue, R.drawable.wn_turn_front_blue, R.drawable.wn_turn_goto_leftroad_front_blue, R.drawable.wn_turn_goto_leftroad_uturn_blue, R.drawable.wn_turn_goto_rightroad_front_blue, R.drawable.wn_turn_goto_rightroad_uturn_blue, R.drawable.wn_turn_left_blue, R.drawable.wn_turn_left_back_blue, R.drawable.wn_turn_left_diagonal_passroad_front_blue, R.drawable.wn_turn_left_diagonal_passroad_left_blue, R.drawable.wn_turn_left_diagonal_passroad_left_back_blue, R.drawable.wn_turn_left_diagonal_passroad_left_front_blue, R.drawable.wn_turn_left_diagonal_passroad_right_blue, R.drawable.wn_turn_left_diagonal_passroad_right_front_blue, R.drawable.wn_turn_left_front_blue, R.drawable.wn_turn_left_front_straight_blue, R.drawable.wn_turn_left_passroad_front_blue, R.drawable.wn_turn_left_passroad_uturn_blue, R.drawable.wn_turn_passroad_left_blue, R.drawable.wn_turn_passroad_right_blue, R.drawable.wn_turn_right_blue, R.drawable.wn_turn_right_back_blue, R.drawable.wn_turn_right_diagonal_passroad_front_blue, R.drawable.wn_turn_right_diagonal_passroad_left_blue, R.drawable.wn_turn_right_diagonal_passroad_left_front_blue, R.drawable.wn_turn_right_diagonal_passroad_right_blue, R.drawable.wn_turn_right_diagonal_passroad_right_back_blue, R.drawable.wn_turn_right_diagonal_passroad_right_front_blue, R.drawable.wn_turn_right_front_blue, R.drawable.wn_turn_right_front_straight_blue, R.drawable.wn_turn_right_passroad_front_blue, R.drawable.wn_turn_right_passroad_uturn_blue, R.drawable.wn_underground_passage_blue, R.drawable.wn_uturn_blue, R.drawable.wn_waypoint_blue, R.drawable.wn_ship_blue, R.drawable.wn_door_blue, R.drawable.wn_elevator_blue, R.drawable.wn_stair_blue, R.drawable.wn_escalator_blue, R.drawable.wn_securitycheck_blue};
    private static final int[] c;
    private static final String[] d;
    private static final String[] e;

    static {
        int i = R.drawable.wn_dest_white;
        int i2 = R.drawable.wn_faraway_route_white;
        int i3 = R.drawable.wn_gps_white;
        int i4 = R.drawable.wn_ladder_white;
        int i5 = R.drawable.wn_overline_bridge_white;
        int i6 = R.drawable.wn_park_white;
        int i7 = R.drawable.wn_reroute_white;
        int i8 = R.drawable.wn_ring_white;
        int i9 = R.drawable.wn_square_white;
        int i10 = R.drawable.wn_start_white;
        int i11 = R.drawable.wn_turn_front_white;
        int i12 = R.drawable.wn_turn_goto_leftroad_front_white;
        int i13 = R.drawable.wn_turn_goto_leftroad_uturn_white;
        int i14 = R.drawable.wn_turn_goto_rightroad_front_white;
        int i15 = R.drawable.wn_turn_goto_rightroad_uturn_white;
        int i16 = R.drawable.wn_turn_left_white;
        int i17 = R.drawable.wn_turn_left_back_white;
        int i18 = R.drawable.wn_turn_left_diagonal_passroad_front_white;
        int i19 = R.drawable.wn_turn_left_diagonal_passroad_left_white;
        int i20 = R.drawable.wn_turn_left_diagonal_passroad_left_back_white;
        int i21 = R.drawable.wn_turn_left_diagonal_passroad_left_front_white;
        int i22 = R.drawable.wn_turn_left_diagonal_passroad_right_white;
        int i23 = R.drawable.wn_turn_left_diagonal_passroad_right_front_white;
        int i24 = R.drawable.wn_turn_left_front_white;
        int i25 = R.drawable.wn_turn_left_front_straight_white;
        int i26 = R.drawable.wn_turn_left_passroad_front_white;
        int i27 = R.drawable.wn_turn_left_passroad_uturn_white;
        int i28 = R.drawable.wn_turn_passroad_left_white;
        int i29 = R.drawable.wn_turn_passroad_right_white;
        int i30 = R.drawable.wn_turn_right_white;
        int i31 = R.drawable.wn_turn_right_back_white;
        int i32 = R.drawable.wn_turn_right_diagonal_passroad_front_white;
        int i33 = R.drawable.wn_turn_right_diagonal_passroad_left_white;
        int i34 = R.drawable.wn_turn_right_diagonal_passroad_left_front_white;
        int i35 = R.drawable.wn_turn_right_diagonal_passroad_right_white;
        int i36 = R.drawable.wn_turn_right_diagonal_passroad_right_back_white;
        int i37 = R.drawable.wn_turn_right_diagonal_passroad_right_front_white;
        int i38 = R.drawable.wn_turn_right_front_white;
        int i39 = R.drawable.wn_turn_right_front_straight_white;
        int i40 = R.drawable.wn_turn_right_passroad_front_white;
        int i41 = R.drawable.wn_turn_right_passroad_uturn_white;
        int i42 = R.drawable.wn_underground_passage_white;
        int i43 = R.drawable.wn_uturn_white;
        int i44 = R.drawable.wn_waypoint_white;
        int i45 = R.drawable.wn_left_three_left_side_white;
        int i46 = R.drawable.wn_left_three_middle_white;
        int i47 = R.drawable.wn_left_three_right_side_white;
        int i48 = R.drawable.wn_left_two_left_side_white;
        int i49 = R.drawable.wn_left_two_right_side_white;
        int i50 = R.drawable.wn_right_three_left_side_white;
        int i51 = R.drawable.wn_right_three_middle_white;
        int i52 = R.drawable.wn_right_three_right_side_white;
        c = new int[]{i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, i44, i45, i46, i47, i48, i49, i50, i51, i52, R.drawable.wn_right_two_left_side_white, i52, R.drawable.wn_three_left_side_white, R.drawable.wn_three_middle_white, R.drawable.wn_three_right_side_white, R.drawable.wn_two_left_side_white, R.drawable.wn_two_right_side_white, R.drawable.wn_ship_white, R.drawable.wn_door_white, R.drawable.wn_elevator_white, R.drawable.wn_stair_white, R.drawable.wn_escalator_white, R.drawable.wn_securitycheck_white, R.drawable.wn_indoor_bianjie_white};
        d = new String[]{"wn_dest.png", "wn_faraway_route", "wn_gps.png", "wn_ladder.png", "wn_overline_bridge.png", "wn_park.png", "wn_reroute.png", "wn_ring.png", "wn_square.png", "wn_start.png", "wn_turn_front.png", "wn_turn_goto_leftroad_front.png", "wn_turn_goto_leftroad_uturn.png", "wn_turn_goto_rightroad_front.png", "wn_turn_goto_rightroad_uturn.png", "wn_turn_left.png", "wn_turn_left_back.png", "wn_turn_left_diagonal_passroad_front.png", "wn_turn_left_diagonal_passroad_left.png", "wn_turn_left_diagonal_passroad_left_back.png", "wn_turn_left_diagonal_passroad_left_front.png", "wn_turn_left_diagonal_passroad_right.png", "wn_turn_left_diagonal_passroad_right_front.png", "wn_turn_left_front.png", "wn_turn_left_front_straight.png", "wn_turn_left_passroad_front.png", "wn_turn_left_passroad_uturn.png", "wn_turn_passroad_left.png", "wn_turn_passroad_right.png", "wn_turn_right.png", "wn_turn_right_back.png", "wn_turn_right_diagonal_passroad_front.png", "wn_turn_right_diagonal_passroad_left.png", "wn_turn_right_diagonal_passroad_left_front.png", "wn_turn_right_diagonal_passroad_right.png", "wn_turn_right_diagonal_passroad_right_back.png", "wn_turn_right_diagonal_passroad_right_front.png", "wn_turn_right_front.png", "wn_turn_right_front_straight.png", "wn_turn_right_passroad_front.png", "wn_turn_right_passroad_uturn.png", "wn_underground_passage.png", "wn_uturn.png", "wn_waypoint.png", "wn_turn_left_3branch_left.png", "wn_turn_left_3branch_mid.png", "wn_turn_left_3branch_right.png", "wn_turn_left_2branch_left.png", "wn_turn_left_2branch_right.png", "wn_turn_right_3branch_left.png", "wn_turn_right_3branch_mid.png", "wn_turn_right_3branch_right.png", "wn_turn_right_2branch_left.png", "wn_turn_right_2branch_right.png", "wn_turn_front_3branch_left.png", "wn_turn_front_3branch_center.png", "wn_turn_front_3branch_right.png", "wn_turn_front_2branch_left.png", "wn_turn_front_2branch_right.png", "wn_ship.png", "wn_door.png", "wn_elevator.png", "wn_stair.png", "wn_escalator.png", "wn_security_check.png", "wn_indoor_bianjie.png"};
        e = new String[]{"wsdk_drawable_rg_ic_dest.png", "wsdk_drawable_rg_ic_faraway_route.png", "wsdk_drawable_rg_ic_gps.png", "wsdk_drawable_rg_ic_ladder.png", "wsdk_drawable_rg_ic_overline_bridge.png", "wsdk_drawable_rg_ic_park.png", "wsdk_drawable_rg_ic_reroute.png", "wsdk_drawable_rg_ic_ring.png", "wsdk_drawable_rg_ic_square.png", "wsdk_drawable_rg_ic_start.png", "wsdk_drawable_rg_ic_turn_front.png", "wsdk_drawable_rg_ic_turn_goto_leftroad_front.png", "wsdk_drawable_rg_ic_turn_goto_leftroad_uturn.png", "wsdk_drawable_rg_ic_turn_goto_rightroad_front.png", "wsdk_drawable_rg_ic_turn_goto_rightroad_uturn.png", "wsdk_drawable_rg_ic_turn_left.png", "wsdk_drawable_rg_ic_turn_left_back.png", "wsdk_drawable_rg_ic_turn_left_diagonal_passroad_front.png", "wsdk_drawable_rg_ic_turn_left_diagonal_passroad_left.png", "wsdk_drawable_rg_ic_turn_left_diagonal_passroad_left_back.png", "wsdk_drawable_rg_ic_turn_left_diagonal_passroad_left_front.png", "wsdk_drawable_rg_ic_turn_left_diagonal_passroad_right.png", "wsdk_drawable_rg_ic_turn_left_diagonal_passroad_right_front.png", "wsdk_drawable_rg_ic_turn_left_front.png", "wsdk_drawable_rg_ic_turn_left_front_straight.png", "wsdk_drawable_rg_ic_turn_left_passroad_front.png", "wsdk_drawable_rg_ic_turn_left_passroad_uturn.png", "wsdk_drawable_rg_ic_turn_passroad_left.png", "wsdk_drawable_rg_ic_turn_passroad_right.png", "wsdk_drawable_rg_ic_turn_right.png", "wsdk_drawable_rg_ic_turn_right_back.png", "wsdk_drawable_rg_ic_turn_right_diagonal_passroad_front.png", "wsdk_drawable_rg_ic_turn_right_diagonal_passroad_left.png", "wsdk_drawable_rg_ic_turn_right_diagonal_passroad_left_front.png", "wsdk_drawable_rg_ic_turn_right_diagonal_passroad_right.png", "wsdk_drawable_rg_ic_turn_right_diagonal_passroad_right_back.png", "wsdk_drawable_rg_ic_turn_right_diagonal_passroad_right_front.png", "wsdk_drawable_rg_ic_turn_right_front.png", "wsdk_drawable_rg_ic_turn_right_front_straight.png", "wsdk_drawable_rg_ic_turn_right_passroad_front.png", "wsdk_drawable_rg_ic_turn_right_passroad_uturn.png", "wsdk_drawable_rg_ic_underground_passage.png", "wsdk_drawable_rg_ic_uturn.png", "wsdk_drawable_rg_ic_waypoint.png", "wsdk_drawable_rg_ic_left_three_left_side.png", "wsdk_drawable_rg_ic_left_three_middle.png", "wsdk_drawable_rg_ic_left_three_right_side.png", "wsdk_drawable_rg_ic_left_two_left_side.png", "wsdk_drawable_rg_ic_left_two_right_side.png", "wsdk_drawable_rg_ic_right_three_left_side.png", "wsdk_drawable_rg_ic_right_three_middle.png", "wsdk_drawable_rg_ic_right_three_right_side.png", "wsdk_drawable_rg_ic_right_two_left_side.png", "wsdk_drawable_rg_ic_right_two_right_side.png", "wsdk_drawable_rg_ic_three_left_side.png", "wsdk_drawable_rg_ic_three_middle.png", "wsdk_drawable_rg_ic_three_right_side.png", "wsdk_drawable_rg_ic_two_left_side.png", "wsdk_drawable_rg_ic_two_right_side.png", "wsdk_drawable_rg_ic_ship.png", "wsdk_drawable_rg_ic_door.png", "wsdk_drawable_rg_ic_elevator.png", "wsdk_drawable_rg_ic_stair.png", "wsdk_drawable_rg_ic_escalator.png", "wsdk_drawable_rg_ic_securitycheck.png", "wsdk_drawable_rg_ic_indoor_bianjie.png"};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] a(com.baidu.mapapi.walknavi.model.RouteGuideKind r3) {
        /*
            r0 = 2
            int[] r0 = new int[r0]
            int[] r1 = com.baidu.platform.comapi.walknavi.h.b.d.f9770a
            int r3 = r3.ordinal()
            r3 = r1[r3]
            r1 = 1
            r2 = 0
            switch(r3) {
                case 1: goto L6b;
                case 2: goto L62;
                case 3: goto L59;
                case 4: goto L50;
                case 5: goto L47;
                case 6: goto L3e;
                case 7: goto L35;
                case 8: goto L2c;
                case 9: goto L23;
                case 10: goto L1a;
                case 11: goto L11;
                default: goto L10;
            }
        L10:
            goto L73
        L11:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_14_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_14_down
            r0[r1] = r3
            goto L73
        L1a:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_13_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_13_down
            r0[r1] = r3
            goto L73
        L23:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_10_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_10_down
            r0[r1] = r3
            goto L73
        L2c:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_9_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_9_down
            r0[r1] = r3
            goto L73
        L35:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_8_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_8_down
            r0[r1] = r3
            goto L73
        L3e:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_6_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_6_down
            r0[r1] = r3
            goto L73
        L47:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_5_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_5_down
            r0[r1] = r3
            goto L73
        L50:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_4_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_4_down
            r0[r1] = r3
            goto L73
        L59:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_3_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_3_down
            r0[r1] = r3
            goto L73
        L62:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_2_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_2_down
            r0[r1] = r3
            goto L73
        L6b:
            int r3 = com.baidu.R.drawable.wsdk_walk_type_1_up
            r0[r2] = r3
            int r3 = com.baidu.R.drawable.wsdk_walk_type_1_down
            r0[r1] = r3
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.h.b.c.a(com.baidu.mapapi.walknavi.model.RouteGuideKind):int[]");
    }

    public static int b(String str) {
        int i = R.drawable.wn_start_white;
        if (!TextUtils.isEmpty(str)) {
            int length = d.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (d[i2].equalsIgnoreCase(str)) {
                    return c[i2];
                }
            }
        }
        return i;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = d.length;
            for (int i = 0; i < length; i++) {
                if (d[i].equalsIgnoreCase(str)) {
                    return e[i];
                }
            }
            return "start.png";
        }
        return "start.png";
    }

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = d.length;
            for (int i = 0; i < length; i++) {
                if (d[i].equalsIgnoreCase(str)) {
                    int[] iArr = f9768a;
                    if (i < iArr.length) {
                        return iArr[i];
                    }
                }
            }
        }
        return 0;
    }
}
