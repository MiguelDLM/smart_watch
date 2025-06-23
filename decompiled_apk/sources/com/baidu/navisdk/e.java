package com.baidu.navisdk;

import com.baidu.navisdk.adapter.IBNUIController;

/* loaded from: classes7.dex */
public class e implements com.baidu.navisdk.function.f {

    /* renamed from: a, reason: collision with root package name */
    private final IBNUIController f6790a;

    public e(IBNUIController iBNUIController) {
        this.f6790a = iBNUIController;
    }

    @Override // com.baidu.navisdk.function.f
    public void a() {
        com.baidu.navisdk.function.b.FUNC_STAR_VOICE.a(false);
        com.baidu.navisdk.function.b.FUNC_CUSTOM_VOICE.a(false);
        com.baidu.navisdk.function.b.FUNC_TEAM_TRIP.a(false);
        com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a(false);
        com.baidu.navisdk.function.b.FUNC_CAR_LOGO_SELECT.a(false);
        com.baidu.navisdk.function.b.FUNC_CAR_LOGO_3D_SELECT.a(false);
        com.baidu.navisdk.function.b.FUNC_UGC.a(true);
        com.baidu.navisdk.function.b.FUNC_UGC_DETAILS.a(true);
        com.baidu.navisdk.function.b.FUNC_UGC_REPORT_BTN.a(true);
        com.baidu.navisdk.function.b.FUNC_TRAVEL_SHARE.a(false);
        com.baidu.navisdk.function.b.FUNC_WEATHER.a(false);
        com.baidu.navisdk.function.b.FUNC_PARK.a(false);
        com.baidu.navisdk.function.b.FUNC_MUSIC_CONTROL.a(false);
        com.baidu.navisdk.function.b.FUNC_PHONE_VOICE.a(false);
        com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a(false);
        com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a(false);
        com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a(false);
        com.baidu.navisdk.function.b.FUNC_REFRESH.a(this.f6790a.isRefreshButtonVisible());
        com.baidu.navisdk.function.b.FUNC_ORIENTATION_CHANGE_BTN.a(false);
        com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SEARCH.a(true);
        com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SORT.a(true);
        com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a(this.f6790a.isBottomBarExpanded());
        com.baidu.navisdk.function.b.FUNC_SETTING_MORE.a(true);
        com.baidu.navisdk.function.b.FUNC_XIAODU.a(false);
        com.baidu.navisdk.function.b.FUNC_XIAODU_SCENEAID.a(true);
        com.baidu.navisdk.function.b.FUNC_DIY_SPEAK_MUSIC_MONITOR.a(false);
        com.baidu.navisdk.function.b.FUNC_HUD.a(false);
        com.baidu.navisdk.function.b.FUNC_AR.a(false);
        com.baidu.navisdk.function.b.FUNC_CAR_MANAGE.a(false);
        com.baidu.navisdk.function.b.FUNC_LICENSE_PASS.a(false);
        com.baidu.navisdk.function.b.FUNC_NAVI_MORESTE.a(false);
    }
}
