package com.baidu.navisdk.function;

/* loaded from: classes7.dex */
public enum b {
    FUNC_FORCE_LANDSCAPE(false),
    FUNC_POWER_SAVE_MODE(true),
    FUNC_NEARBY_SEARCH(true),
    FUNC_UGC(true),
    FUNC_UGC_REPORT_BTN(true, FUNC_UGC),
    FUNC_UGC_DETAILS(true, FUNC_UGC),
    FUNC_NAVI_DIY(true),
    FUNC_NAVI_MORESTE(true),
    FUNC_CAR_MANAGE(true),
    FUNC_ASSIST_ITEMS(true),
    FUNC_ROAD_CONDITION(true),
    FUNC_SIMPLE_GUIDE_MODE(true),
    FUNC_RED_PROMPT(true),
    FUNC_CUSTOM_VOICE(true),
    FUNC_RECORD_SENSOR_DATA(false),
    FUNC_BLUETOOTH_SOUND(true),
    FUNC_MUSIC_CONTROL(true),
    FUNC_PHONE_VOICE(true),
    FUNC_CAR_LOGO_SELECT(true),
    FUNC_CAR_LOGO_3D_SELECT(true),
    FUNC_TRAVEL_SHARE(true),
    FUNC_WEATHER(true),
    FUNC_REFRESH(true),
    FUNC_HUD(true),
    FUNC_PARK(true),
    FUNC_FLOAT_SETTING(true),
    FUNC_STAR_VOICE(true),
    FUNC_TEAM_TRIP(true),
    FUNC_PLATE_LIMIT(true),
    FUNC_LICENSE_PASS(true),
    FUNC_DIY_SPEAK(true),
    FUNC_SCENIC_SETTING(true),
    FUNC_CAR_MODE_3D(true),
    FUNC_ORIENTATION_CHANGE_BTN(true),
    FUNC_SETTING_ROUTE_SEARCH(true),
    FUNC_SETTING_ROUTE_SORT(true),
    FUNC_SETTING_BOTTOM_BAR(true),
    FUNC_SETTING_BOTTOM_BAR_SUPPORT_ANIM(true),
    FUNC_SETTING_MORE(true),
    FUNC_XIAODU(true),
    FUNC_XIAODU_SCENEAID(true),
    FUNC_DIY_SPEAK_MUSIC_MONITOR(true, FUNC_DIY_SPEAK),
    FUNC_DIY_NONLOCAL_GUIDE_TIPS(true, FUNC_DIY_SPEAK),
    FUNC_ENTER_NAVI_RESULT_PAGE(true),
    FUNC_SUPPORT_HIGHWAY_MINI_PANEL(true),
    FUNC_SUPPORT_TTS_VOLUME_INCREASE(false),
    FUNC_VOICE_PLAYER_BTN_FAST_SWITCH(false),
    FUNC_CHARGE_STATION_PANEL(false),
    FUNC_AR(false),
    FUNC_HD_NAVI_SETTING_ITEM(false),
    FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO(true),
    FUNC_NORMAL_HD_NAVI_SETTING_ITEM(true),
    FUNC_NAVI_ANGLE(true),
    FUNC_DAY_NIGHT(true),
    FUNC_NAVI_SCALE(true),
    FUNC_VOICE_SELECTOR(true),
    FUNC_ROUTE_PREFER(true),
    FUNC_GROUP_SHORTCUT(true),
    FUNC_ROAD_CONDITION_SWITCH(true);


    /* renamed from: a, reason: collision with root package name */
    private boolean f6856a;
    private Boolean b = null;
    private b c;

    b(boolean z) {
        this.f6856a = z;
    }

    public void a(boolean z) {
        this.f6856a = z;
    }

    public void b(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    public boolean a() {
        if (!this.f6856a) {
            return false;
        }
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        b bVar = this.c;
        if (bVar == null) {
            return true;
        }
        return bVar.a();
    }

    b(boolean z, b bVar) {
        this.f6856a = z;
        this.c = bVar;
    }
}
