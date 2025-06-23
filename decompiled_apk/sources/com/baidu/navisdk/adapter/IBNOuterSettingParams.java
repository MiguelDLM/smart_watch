package com.baidu.navisdk.adapter;

import com.baidu.navisdk.comapi.mapcontrol.MapParams;

/* loaded from: classes7.dex */
public interface IBNOuterSettingParams {

    /* loaded from: classes7.dex */
    public enum BNavSettingItem {
        FUNC_NAVI_ANGLE,
        FUNC_DAY_NIGHT,
        FUNC_NAVI_SCALE,
        FUNC_VOICE_SELECTOR,
        FUNC_DIY_SPEAK,
        FUNC_ROUTE_PREFER,
        FUNC_GROUP_SHORTCUT,
        FUNC_ROAD_CONDITION_SWITCH,
        FUNC_BLUETOOTH_SOUND,
        FUNC_HD_NAVI_SETTING_ITEM
    }

    /* loaded from: classes7.dex */
    public interface CarPowerType {
        public static final int Invalid = -1;
        public static final int NewEnergy = 1;
        public static final int Normal = 0;
    }

    /* loaded from: classes7.dex */
    public interface DIYImageType extends MapParams.NLMDIYImageType {
        public static final int CarLogo = 0;
        public static final int CarLogo3D = 3;
        public static final int EndPoint = 2;
        public static final int StartPoint = 1;
    }

    /* loaded from: classes7.dex */
    public interface DayNightMode {
        public static final int DAY_NIGHT_MODE_AUTO = 1;
        public static final int DAY_NIGHT_MODE_DAY = 2;
        public static final int DAY_NIGHT_MODE_NIGHT = 3;
    }

    /* loaded from: classes7.dex */
    public interface NaviPerspectiveMode {
        public static final int CAR_3D = 1;
        public static final int NORTH_2D = 2;
    }

    /* loaded from: classes7.dex */
    public interface PreViewMode {
        public static final int ArcRoadBar = 3;
        public static final int MapMini = 0;
        public static final int NoAll = 2;
        public static final int RoadBar = 1;
    }

    /* loaded from: classes7.dex */
    public interface RouteChangeType {
        public static final int ROUTE_CHANGE_CA_ROUTE = 5;
        public static final int ROUTE_CHANGE_INVALID = 0;
        public static final int ROUTE_CHANGE_SERVER_PUSH_ROUTE = 3;
        public static final int ROUTE_CHANGE_SWITCH_ROUTE = 1;
        public static final int ROUTE_CHANGE_SWITCH_TO_FUZZY_GUIDE = 6;
        public static final int ROUTE_CHANGE_UPDATE_ROUTE = 2;
        public static final int ROUTE_CHANGE_YAW_REROUTE = 4;
    }

    /* loaded from: classes7.dex */
    public interface VoiceMode {
        public static final int JustPlayWarning = 3;
        public static final int NOVICE = 0;
        public static final int QUITE = 2;
        public static final int VETERAN = 1;
    }
}
