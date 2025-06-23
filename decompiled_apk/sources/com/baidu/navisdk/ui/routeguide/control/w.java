package com.baidu.navisdk.ui.routeguide.control;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;

/* loaded from: classes8.dex */
public class w implements com.baidu.navisdk.framework.interfaces.pronavi.m, com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private static String f8606a;
    private static int b;
    private static int c;

    public static void b(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGTrajectoryRestoreC", "setTrajectoryRestoreData:" + bundle);
        }
        if (bundle != null && bundle.containsKey(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_ID)) {
            f8606a = bundle.getString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_ID, null);
            b = bundle.getInt(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_TYPE, 0);
            if (TextUtils.isEmpty(f8606a)) {
                return;
            }
            c = 1048576;
            return;
        }
        f8606a = null;
        b = 0;
        c = 0;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.m
    public void a(String str, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGTrajectoryRestoreC", "setTrajectoryRestoreData:" + str + ", type:" + i);
        }
        f8606a = str;
        b = i;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.m
    public void c() {
        if (!TextUtils.isEmpty(f8606a)) {
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            c = JNIGuidanceControl.getInstance().getRouteLabelType(selectRouteIdx);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGTrajectoryRestoreC", "obtainRouteLabelType mRouteLabelType:" + c + ",curRouteIdx: " + selectRouteIdx);
            }
            if ((c & 1048576) != 1048576) {
                f8606a = null;
                b = 0;
            }
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.m
    public boolean a() {
        return !TextUtils.isEmpty(f8606a) && (c & 1048576) == 1048576;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.m
    public void a(Bundle bundle, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGTrajectoryRestoreC", "addTrajectoryRestoreDataIfNeed:" + i + ", bundle:" + bundle);
        }
        if (bundle == null || i != 1003) {
            return;
        }
        if (gVar.d()) {
            gVar.e("RGTrajectoryRestoreC", "addTrajectoryRestoreDataIfNeed:" + f8606a + ", mRouteLabelType:" + c + ",mTrajectoryType: " + b);
        }
        if (a()) {
            bundle.putString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_ID, f8606a);
            bundle.putInt(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_TYPE, b);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.m
    public int b() {
        return b;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.m
    public int a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGTrajectoryRestoreC", "convertRoutePlanEntryValue:" + i);
        }
        if (i == 1003) {
            return 2;
        }
        return i;
    }

    public static void a(Bundle bundle) {
        if (!TextUtils.isEmpty(f8606a) && (c & 1048576) == 1048576) {
            bundle.putString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_ID, f8606a);
            bundle.putInt(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_TYPE, b);
        } else {
            bundle.putString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_ID, null);
            bundle.putInt(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_TRAJECTORY_RESTORE_TYPE, 0);
        }
    }
}
