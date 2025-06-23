package com.baidu.navisdk.module.routeresultbase.framework.utils;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7507a;

    static {
        int i = R.drawable.nsdk_map_route_turn_undefine;
        int i2 = R.drawable.nsdk_map_route_turn_front;
        int i3 = R.drawable.nsdk_map_route_turn_right_front;
        int i4 = R.drawable.nsdk_map_route_turn_right;
        int i5 = R.drawable.nsdk_map_route_turn_right_back;
        int i6 = R.drawable.nsdk_map_route_turn_back;
        int i7 = R.drawable.nsdk_map_route_turn_left_back;
        int i8 = R.drawable.nsdk_map_route_turn_left;
        int i9 = R.drawable.nsdk_map_route_turn_left_front;
        int i10 = R.drawable.nsdk_map_route_turn_left_side;
        int i11 = R.drawable.nsdk_map_route_turn_right_side;
        int i12 = R.drawable.nsdk_map_route_turn_branch_left;
        int i13 = R.drawable.nsdk_map_route_turn_branch_center;
        int i14 = R.drawable.nsdk_map_route_turn_branch_right;
        int i15 = R.drawable.nsdk_map_route_turn_ring;
        int i16 = R.drawable.nsdk_map_route_turn_ring_out;
        int i17 = R.drawable.nsdk_map_route_turn_left_side_main;
        int i18 = R.drawable.nsdk_map_route_turn_branch_left_straight;
        int i19 = R.drawable.nsdk_map_route_turn_right_side_main;
        int i20 = R.drawable.nsdk_map_route_turn_branch_right_straight;
        int i21 = R.drawable.nsdk_map_route_start;
        int i22 = R.drawable.nsdk_map_route_end;
        int i23 = R.drawable.nsdk_map_route_turn_via_1;
        int i24 = R.drawable.nsdk_map_route_turn_inferry;
        f7507a = new int[]{i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i13, i10, i11, i21, i22, i23, i23, i23, i23, i24, i24, R.drawable.nsdk_map_route_turn_tollgate, i17, i19, i17, i19, i18, i13, i20, i12, i13, i14, i18, i13, i20, i17, i19, i18, i13, i20, i8, i8, i8, i8, i8, i4, i4, i4, i4, i4};
    }

    public static int a() {
        f fVar = (f) c.a().a("RoutePlanModel");
        if (fVar != null) {
            return fVar.f();
        }
        return 0;
    }
}
