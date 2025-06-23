package com.baidu.navisdk.comapi.mapcontrol;

import com.baidu.navisdk.comapi.base.b;

/* loaded from: classes7.dex */
public interface BNMapObserver extends b {
    public static final int TYPE_GESTURE = 2;
    public static final int TYPE_MAP_VIEW = 1;

    /* loaded from: classes7.dex */
    public static class EventGesture {
        public static final int EVENT_DOUBLE_FINGER_ROTATE = 521;
        public static final int EVENT_DOUBLE_FINGER_ZOOM = 520;
        public static final int EVENT_DOUBLE_TAP = 513;
        public static final int EVENT_DOWN = 515;
        public static final int EVENT_FLING = 516;
        public static final int EVENT_LONGPRESS = 517;

        @Deprecated
        public static final int EVENT_OBVIOUS_MOVE = 519;
        public static final int EVENT_SCROLL = 518;
        public static final int EVENT_SINGLE_TAP = 514;
    }

    /* loaded from: classes7.dex */
    public static class EventMapView {
        public static final int EVENT_CLICKED_BACKGROUD = 272;
        public static final int EVENT_CLICKED_BASE_LAYER = 261;
        public static final int EVENT_CLICKED_BASE_POI_LAYER = 264;
        public static final int EVENT_CLICKED_CAR_LOGO = 521;
        public static final int EVENT_CLICKED_COMPASS_LAYER = 262;
        public static final int EVENT_CLICKED_CUSTOM_LAYER = 512;
        public static final int EVENT_CLICKED_DEST_NODE_BUBBLE = 529;
        public static final int EVENT_CLICKED_DYNAMIC_LAYER_ITEM = 531;
        public static final int EVENT_CLICKED_END_LAYER = 513;
        public static final int EVENT_CLICKED_FAV_POI_LAYER = 276;
        public static final int EVENT_CLICKED_INDOOR_PARK_SPACE = 530;
        public static final int EVENT_CLICKED_POI_BKG_LAYER = 265;
        public static final int EVENT_CLICKED_POI_LAYER = 277;
        public static final int EVENT_CLICKED_POPUP_LAYER = 263;
        public static final int EVENT_CLICKED_RC_PREDICTION_BUBBLE = 520;
        public static final int EVENT_CLICKED_ROUTE = 514;
        public static final int EVENT_CLICKED_ROUTE_AROUND_ELEMENT = 518;
        public static final int EVENT_CLICKED_ROUTE_PAN_ITEM = 528;
        public static final int EVENT_CLICKED_ROUTE_SPEC_LAYER = 278;
        public static final int EVENT_CLICKED_ROUTE_UGC_ITEM = 515;
        public static final int EVENT_CLICKED_START_LAYER = 516;
        public static final int EVENT_CLICKED_STREET_ARROW = 273;
        public static final int EVENT_CLICKED_THROUGH_NODE_LAYER = 517;
        public static final int EVENT_CLICKED_TRAFFIC_LIGHT = 519;
        public static final int EVENT_CLICKED_UGC_ITEM = 515;
        public static final int EVENT_MAP_ANIMATION_FINISHED = 257;
        public static final int EVENT_MAP_GLRENDER = 275;
        public static final int EVENT_MAP_NETWORKING_CHANGED = 258;
        public static final int EVENT_MAP_RESIZE = 256;
        public static final int EVENT_MAP_SAVE_SCREEN = 259;
        public static final int EVENT_MAP_SAVE_SCREEN_BUFFER = 260;
        public static final int EVENT_MAP_ZOOM_UPDATE = 274;
    }
}
