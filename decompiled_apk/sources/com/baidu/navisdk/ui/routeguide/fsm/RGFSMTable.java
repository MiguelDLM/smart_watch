package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class RGFSMTable {
    private static HashMap<String, HashMap<String, String>> dictFSM;
    private static HashMap<String, String> dictStateArriveDest;
    private static HashMap<String, String> dictStateBrowseMap;
    private static HashMap<String, String> dictStateCar3D;
    private static HashMap<String, String> dictStateColladamap;
    private static HashMap<String, String> dictStateDynamicLayer;
    private static HashMap<String, String> dictStateEnlargeRoadmap;
    private static HashMap<String, String> dictStateFullview;
    private static HashMap<String, String> dictStateHUD;
    private static HashMap<String, String> dictStateHUDMirror;
    private static HashMap<String, String> dictStateHighway;
    private static HashMap<String, String> dictStateIndoorPark;
    private static HashMap<String, String> dictStateIndoorParkBrowse;
    private static HashMap<String, String> dictStateIndoorParkChoose;
    private static HashMap<String, String> dictStateNaviReady;
    private static HashMap<String, String> dictStateNearbySearch;
    private static HashMap<String, String> dictStateNorth2D;
    private static HashMap<String, String> dictStatePip;
    private static HashMap<String, String> dictStateSimpleGuide;
    private static HashMap<String, String> dictStateVoice;
    private static List<String> glassStates;
    private static final byte[] lock = new byte[0];

    /* loaded from: classes8.dex */
    public static class FsmEvent {
        public static final String BROWSER_STATE_EXIT = "退出游览态";
        public static final String BTN_CLICK_AR = "[AR]按钮点击";
        public static final String BTN_CLICK_BACK = "[返回]按钮点击";
        public static final String BTN_CLICK_CAR_3D = "[3D车头向上]按钮点击";
        public static final String BTN_CLICK_FULL_VIEW = "[一键全览]按钮点击";
        public static final String BTN_CLICK_HUD_ENTER = "[HUD]按钮点击";
        public static final String BTN_CLICK_LOC_CAR = "[回车位]按钮点击";
        public static final String BTN_CLICK_NORTH_2D = "[2D正北]按钮点击";
        public static final String BTN_CLICK_ZOOM = "[放大缩小]按钮点击";
        public static final String CONTINUE_NAVI = "继续导航";
        public static final String ENTRY_DYNAMIC_LAYER = "进入动态图层状态";
        public static final String ENTRY_INDOOR_PARK = "进入停车位导航态";
        public static final String ENTRY_INDOOR_PARK_CHOOSE = "进入停车位选择态";
        public static final String ENTRY_NAVI_READY = "进入导航准备状态";
        public static final String ENTRY_NEARBY_SEARCH = "进入沿途搜索态";
        public static final String ENTRY_PIP = "进入画中画状态";
        public static final String EXIT_DYNAMIC_LAYER = "退出动态图层状态";
        public static final String EXIT_INDOOR_PARK = "退出停车位导航态";
        public static final String EXIT_NAVI_READY = "退出导航准备状态";
        public static final String EXIT_NEARBY_SEARCH = "退出沿途搜索态";
        public static final String EXIT_PIP = "退出画中画状态";
        public static final String MAP_COMPASS_CLICK = "指南针点击";
        public static final String MAP_MOVE = "拖动地图";
        public static final String MSG_AUTO_LOC_CAR_WHEN_TIMEOUT = "收到自动回车位消息";
        public static final String MSG_COLLADA_HIDE = "收到collada隐藏消息";
        public static final String MSG_COLLADA_SHOW = "收到collada显示消息";
        public static final String MSG_ENLARGE_ROADMAP_HIDE = "收到放大图隐藏消息";
        public static final String MSG_ENLARGE_ROADMAP_SHOW = "收到放大图显示消息";
        public static final String MSG_ENTER_ARRIVE_DEST = "导航结束进入目的地态消息";
        public static final String MSG_EXIT_ARRIVE_DEST = "退出目的地态消息";
        public static final String MSG_HUD_GOTO_MIRROR = "从HUD去HUD镜像页";
        public static final String MSG_MIRROR_GOTO_HUD = "从HUD镜像页回到HUD";
        public static final String MSG_PORT_LAND_SCREEN_CHANGED = "收到横竖屏变化消息";
        public static final String MSG_YAWING_REROUTED = "收到偏航算路成功消息";
        public static final String MSG_YAWING_START = "收到偏航开始的消息";
        public static final String TOUCH_ENLARGE_ROAD_MAP = "触碰放大图";
        public static final String TOUCH_MAP = "触碰地图";
        public static final String VOICE_HUDMIRROR = "从语音进入HUD镜像页";
        public static final String VOICE_STATE_ENTRY = "进入语音态";
        public static final String VOICE_STATE_EXIT = "退出语音态";
    }

    /* loaded from: classes8.dex */
    public static class FsmParamsKey {
        public static final String IS_AR_NAVI = "is_ar_navi";
        public static final String IS_NEED_EXECUTE_GLASS_FMS = "is_need_execute_glass_fms";
        public static final String ORIENTATION_CHANGE = "orientation_change";
        public static final String RUN_EVENT = "run_event";
    }

    /* loaded from: classes8.dex */
    public static class FsmState {
        public static final String ArriveDest = "ArriveDest";
        public static final String BACK = "BACK";
        public static final String BrowseMap = "BrowseMap";
        public static final String Car3D = "Car3D";
        public static final String Colladamap = "Colladamap";
        public static final String DynamicLayer = "DynamicLayer";
        public static final String EnlargeRoadmap = "EnlargeRoadmap";
        public static final String Fullview = "Fullview";
        public static final String HUD = "HUD";
        public static final String HUDMirror = "HUDMirror";
        public static final String Highway = "Highway";
        public static final String IndoorPark = "IndoorPark";
        public static final String IndoorParkBrowse = "IndoorParkBrowse";
        public static final String IndoorParkChoose = "IndoorParkChoose";
        public static final String NaviReady = "NaviReady";
        public static final String NearbySearch = "NearbySearch";
        public static final String North2D = "North2D";
        public static final String Pip = "PIP";
        public static final String SimpleGuide = "SimpleGuide";
        public static final String Voice = "Voice";
    }

    public static void destory() {
        HashMap<String, HashMap<String, String>> hashMap = dictFSM;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, String> hashMap2 = dictStateNorth2D;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        HashMap<String, String> hashMap3 = dictStateCar3D;
        if (hashMap3 != null) {
            hashMap3.clear();
        }
        HashMap<String, String> hashMap4 = dictStateFullview;
        if (hashMap4 != null) {
            hashMap4.clear();
        }
        HashMap<String, String> hashMap5 = dictStateEnlargeRoadmap;
        if (hashMap5 != null) {
            hashMap5.clear();
        }
        HashMap<String, String> hashMap6 = dictStateColladamap;
        if (hashMap6 != null) {
            hashMap6.clear();
        }
        HashMap<String, String> hashMap7 = dictStateBrowseMap;
        if (hashMap7 != null) {
            hashMap7.clear();
        }
        HashMap<String, String> hashMap8 = dictStateHUD;
        if (hashMap8 != null) {
            hashMap8.clear();
        }
        HashMap<String, String> hashMap9 = dictStateHUDMirror;
        if (hashMap9 != null) {
            hashMap9.clear();
        }
        HashMap<String, String> hashMap10 = dictStateHighway;
        if (hashMap10 != null) {
            hashMap10.clear();
        }
    }

    private static void initArriveDest() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateArriveDest = hashMap;
        hashMap.clear();
        dictStateArriveDest.put(FsmEvent.MSG_EXIT_ARRIVE_DEST, FsmState.SimpleGuide);
        dictStateArriveDest.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.ArriveDest);
        dictStateArriveDest.put(FsmEvent.MAP_MOVE, FsmState.ArriveDest);
        dictStateArriveDest.put(FsmEvent.TOUCH_MAP, FsmState.ArriveDest);
        dictStateArriveDest.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateArriveDest.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateArriveDest.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initDictFSM() {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        dictFSM = hashMap;
        hashMap.clear();
        dictFSM.put(FsmState.SimpleGuide, dictStateSimpleGuide);
        dictFSM.put(FsmState.North2D, dictStateNorth2D);
        dictFSM.put(FsmState.Car3D, dictStateCar3D);
        dictFSM.put(FsmState.Fullview, dictStateFullview);
        dictFSM.put(FsmState.EnlargeRoadmap, dictStateEnlargeRoadmap);
        dictFSM.put(FsmState.Colladamap, dictStateColladamap);
        dictFSM.put(FsmState.BrowseMap, dictStateBrowseMap);
        dictFSM.put(FsmState.HUD, dictStateHUD);
        dictFSM.put(FsmState.HUDMirror, dictStateHUDMirror);
        dictFSM.put(FsmState.NaviReady, dictStateNaviReady);
        dictFSM.put(FsmState.Voice, dictStateVoice);
        dictFSM.put(FsmState.ArriveDest, dictStateArriveDest);
        dictFSM.put(FsmState.NearbySearch, dictStateNearbySearch);
        dictFSM.put(FsmState.IndoorPark, dictStateIndoorPark);
        dictFSM.put(FsmState.IndoorParkBrowse, dictStateIndoorParkBrowse);
        dictFSM.put(FsmState.IndoorParkChoose, dictStateIndoorParkChoose);
        dictFSM.put(FsmState.Pip, dictStatePip);
        dictFSM.put(FsmState.DynamicLayer, dictStateDynamicLayer);
    }

    private static void initDynamicLayerStates() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateDynamicLayer = hashMap;
        hashMap.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateDynamicLayer.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateDynamicLayer.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.DynamicLayer);
        dictStateDynamicLayer.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateDynamicLayer.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateDynamicLayer.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateDynamicLayer.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateDynamicLayer.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.DynamicLayer);
        dictStateDynamicLayer.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateDynamicLayer.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateDynamicLayer.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateDynamicLayer.put(FsmEvent.VOICE_STATE_EXIT, FsmState.BACK);
        dictStateDynamicLayer.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
        dictStateDynamicLayer.put(FsmEvent.EXIT_DYNAMIC_LAYER, FsmState.BACK);
        dictStateDynamicLayer.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateDynamicLayer.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
    }

    private static void initGlassStates() {
        ArrayList arrayList = new ArrayList();
        glassStates = arrayList;
        arrayList.add(FsmState.North2D);
        glassStates.add(FsmState.Car3D);
        glassStates.add(FsmState.Fullview);
    }

    private static void initIndoorParkBrowseStates() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateIndoorParkBrowse = hashMap;
        hashMap.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.IndoorParkBrowse);
        dictStateIndoorParkBrowse.put(FsmEvent.MAP_MOVE, FsmState.IndoorParkBrowse);
        dictStateIndoorParkBrowse.put(FsmEvent.TOUCH_MAP, FsmState.IndoorParkBrowse);
        dictStateIndoorParkBrowse.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.IndoorPark);
        dictStateIndoorParkBrowse.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.IndoorParkBrowse);
        dictStateIndoorParkBrowse.put(FsmEvent.CONTINUE_NAVI, FsmState.IndoorPark);
        dictStateIndoorParkBrowse.put(FsmEvent.BROWSER_STATE_EXIT, FsmState.IndoorPark);
        dictStateIndoorParkBrowse.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateIndoorParkBrowse.put(FsmEvent.EXIT_INDOOR_PARK, FsmState.SimpleGuide);
        dictStateIndoorParkBrowse.put(FsmEvent.ENTRY_INDOOR_PARK_CHOOSE, FsmState.IndoorParkChoose);
    }

    private static void initIndoorParkChooseStates() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateIndoorParkChoose = hashMap;
        hashMap.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateIndoorParkChoose.put(FsmEvent.EXIT_INDOOR_PARK, FsmState.SimpleGuide);
    }

    private static void initIndoorParkStates() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateIndoorPark = hashMap;
        hashMap.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateIndoorPark.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.IndoorPark);
        dictStateIndoorPark.put(FsmEvent.EXIT_INDOOR_PARK, FsmState.SimpleGuide);
        dictStateIndoorPark.put(FsmEvent.MAP_MOVE, FsmState.IndoorParkBrowse);
        dictStateIndoorPark.put(FsmEvent.TOUCH_MAP, FsmState.IndoorParkBrowse);
        dictStateIndoorPark.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateIndoorPark.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateIndoorPark.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateIndoorPark.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.BACK);
        dictStateIndoorPark.put(FsmEvent.ENTRY_INDOOR_PARK_CHOOSE, FsmState.IndoorParkChoose);
    }

    private static void initNaviReady() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateNaviReady = hashMap;
        hashMap.clear();
        dictStateNaviReady.put(FsmEvent.MAP_COMPASS_CLICK, FsmState.BACK);
        dictStateNaviReady.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateNaviReady.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateNaviReady.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateNaviReady.put(FsmEvent.EXIT_NAVI_READY, FsmState.SimpleGuide);
        dictStateNaviReady.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.NaviReady);
        dictStateNaviReady.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateNaviReady.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateNaviReady.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateNaviReady.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateNaviReady.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initPipStates() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStatePip = hashMap;
        hashMap.put(FsmEvent.EXIT_PIP, FsmState.BACK);
        dictStatePip.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
    }

    private static void initTransBrowseMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateBrowseMap = hashMap;
        hashMap.clear();
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateBrowseMap.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateBrowseMap.put(FsmEvent.MAP_COMPASS_CLICK, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateBrowseMap.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateBrowseMap.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateBrowseMap.put(FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateBrowseMap.put(FsmEvent.BROWSER_STATE_EXIT, FsmState.BACK);
        dictStateBrowseMap.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateBrowseMap.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateBrowseMap.put(FsmEvent.VOICE_STATE_EXIT, FsmState.BrowseMap);
        dictStateBrowseMap.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateBrowseMap.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateBrowseMap.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateBrowseMap.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransCar3D() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateCar3D = hashMap;
        hashMap.clear();
        dictStateCar3D.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateCar3D.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateCar3D.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateCar3D.put(FsmEvent.MAP_COMPASS_CLICK, FsmState.North2D);
        dictStateCar3D.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateCar3D.put(FsmEvent.TOUCH_MAP, FsmState.Car3D);
        dictStateCar3D.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateCar3D.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateCar3D.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateCar3D.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Car3D);
        dictStateCar3D.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateCar3D.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateCar3D.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateCar3D.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransColladamap() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateColladamap = hashMap;
        hashMap.clear();
        dictStateColladamap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateColladamap.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateColladamap.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateColladamap.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateColladamap.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateColladamap.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateColladamap.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Colladamap);
        dictStateColladamap.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateColladamap.put(FsmEvent.MSG_COLLADA_HIDE, FsmState.BACK);
        dictStateColladamap.put(FsmEvent.ENTRY_NAVI_READY, FsmState.NaviReady);
        dictStateColladamap.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateColladamap.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateColladamap.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateColladamap.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateColladamap.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransEnlargeRoadmap() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateEnlargeRoadmap = hashMap;
        hashMap.clear();
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateEnlargeRoadmap.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateEnlargeRoadmap.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateEnlargeRoadmap.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_ENLARGE_ROADMAP_HIDE, FsmState.BACK);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.EnlargeRoadmap);
        dictStateEnlargeRoadmap.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateEnlargeRoadmap.put(FsmEvent.ENTRY_NAVI_READY, FsmState.NaviReady);
        dictStateEnlargeRoadmap.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateEnlargeRoadmap.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateEnlargeRoadmap.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateEnlargeRoadmap.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateEnlargeRoadmap.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateEnlargeRoadmap.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransFullview() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateFullview = hashMap;
        hashMap.clear();
        dictStateFullview.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.BACK);
        dictStateFullview.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateFullview.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.BrowseMap);
        dictStateFullview.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateFullview.put(FsmEvent.MAP_COMPASS_CLICK, FsmState.BACK);
        dictStateFullview.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateFullview.put(FsmEvent.TOUCH_MAP, FsmState.Fullview);
        dictStateFullview.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateFullview.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateFullview.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateFullview.put(FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, FsmState.Fullview);
        dictStateFullview.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Fullview);
        dictStateFullview.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateFullview.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateFullview.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateFullview.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransHUD() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateHUD = hashMap;
        hashMap.clear();
        dictStateHUD.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateHUD.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateHUD.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateHUD.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateHUD.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateHUD.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateHUD.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateHUD.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
    }

    private static void initTransHUDMirror() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateHUDMirror = hashMap;
        hashMap.clear();
        dictStateHUDMirror.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateHUDMirror.put(FsmEvent.MSG_MIRROR_GOTO_HUD, FsmState.HUD);
        dictStateHUDMirror.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateHUDMirror.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateHUDMirror.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateHUDMirror.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateHUDMirror.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateHUDMirror.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateHUDMirror.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
    }

    private static void initTransHighway() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateHighway = hashMap;
        hashMap.clear();
        dictStateHighway.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateHighway.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateHighway.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateHighway.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateHighway.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateHighway.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateHighway.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateHighway.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateHighway.put(FsmEvent.MSG_MIRROR_GOTO_HUD, FsmState.HUD);
        dictStateHighway.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateHighway.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateHighway.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Highway);
        dictStateHighway.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateHighway.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateHighway.put(FsmEvent.CONTINUE_NAVI, FsmState.Highway);
        dictStateHighway.put(FsmEvent.ENTRY_NAVI_READY, FsmState.NaviReady);
        dictStateHighway.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateHighway.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateHighway.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateHighway.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateHighway.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransNearbySearch() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateNearbySearch = hashMap;
        hashMap.clear();
        dictStateNearbySearch.put(FsmEvent.BTN_CLICK_BACK, FsmState.BACK);
        dictStateNearbySearch.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateNearbySearch.put(FsmEvent.BTN_CLICK_ZOOM, FsmState.NearbySearch);
        dictStateNearbySearch.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateNearbySearch.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateNearbySearch.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateNearbySearch.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateNearbySearch.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.NearbySearch);
        dictStateNearbySearch.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateNearbySearch.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateNearbySearch.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateNearbySearch.put(FsmEvent.VOICE_STATE_EXIT, FsmState.BACK);
        dictStateNearbySearch.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateNearbySearch.put(FsmEvent.EXIT_NEARBY_SEARCH, FsmState.BACK);
        dictStateNearbySearch.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateNearbySearch.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateNearbySearch.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransNorth2D() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateNorth2D = hashMap;
        hashMap.clear();
        dictStateNorth2D.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateNorth2D.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateNorth2D.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateNorth2D.put(FsmEvent.MAP_COMPASS_CLICK, FsmState.Car3D);
        dictStateNorth2D.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateNorth2D.put(FsmEvent.TOUCH_MAP, FsmState.North2D);
        dictStateNorth2D.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateNorth2D.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateNorth2D.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateNorth2D.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.North2D);
        dictStateNorth2D.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateNorth2D.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateNorth2D.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateNorth2D.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    private static void initTransSimpleGuide() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateSimpleGuide = hashMap;
        hashMap.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateSimpleGuide.put(FsmEvent.MAP_COMPASS_CLICK, FsmState.Car3D);
        dictStateSimpleGuide.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateSimpleGuide.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateSimpleGuide.put(FsmEvent.BTN_CLICK_HUD_ENTER, FsmState.HUD);
        dictStateSimpleGuide.put(FsmEvent.MSG_HUD_GOTO_MIRROR, FsmState.HUDMirror);
        dictStateSimpleGuide.put(FsmEvent.MSG_MIRROR_GOTO_HUD, FsmState.HUD);
        dictStateSimpleGuide.put(FsmEvent.MSG_ENLARGE_ROADMAP_SHOW, FsmState.EnlargeRoadmap);
        dictStateSimpleGuide.put(FsmEvent.MSG_COLLADA_SHOW, FsmState.Colladamap);
        dictStateSimpleGuide.put(FsmEvent.MSG_YAWING_REROUTED, FsmState.SimpleGuide);
        dictStateSimpleGuide.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.SimpleGuide);
        dictStateSimpleGuide.put(FsmEvent.CONTINUE_NAVI, FsmState.SimpleGuide);
        dictStateSimpleGuide.put(FsmEvent.ENTRY_NAVI_READY, FsmState.NaviReady);
        dictStateSimpleGuide.put(FsmEvent.VOICE_STATE_ENTRY, FsmState.Voice);
        dictStateSimpleGuide.put(FsmEvent.MSG_ENTER_ARRIVE_DEST, FsmState.ArriveDest);
        dictStateSimpleGuide.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateSimpleGuide.put(FsmEvent.ENTRY_INDOOR_PARK, FsmState.IndoorPark);
        dictStateSimpleGuide.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
        dictStateSimpleGuide.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
    }

    public static void initTransition() {
        initTransSimpleGuide();
        initTransNorth2D();
        initTransCar3D();
        initTransFullview();
        initTransEnlargeRoadmap();
        initTransColladamap();
        initTransBrowseMap();
        initTransHUD();
        initTransHUDMirror();
        initNaviReady();
        initVoiceState();
        initArriveDest();
        initTransNearbySearch();
        initIndoorParkStates();
        initIndoorParkBrowseStates();
        initIndoorParkChooseStates();
        initPipStates();
        initDynamicLayerStates();
        initDictFSM();
        initGlassStates();
    }

    private static void initVoiceState() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateVoice = hashMap;
        hashMap.clear();
        dictStateVoice.put(FsmEvent.VOICE_STATE_EXIT, FsmState.BACK);
        dictStateVoice.put(FsmEvent.MSG_YAWING_START, FsmState.SimpleGuide);
        dictStateVoice.put(FsmEvent.MAP_MOVE, FsmState.BrowseMap);
        dictStateVoice.put(FsmEvent.BROWSER_STATE_EXIT, FsmState.BACK);
        dictStateVoice.put(FsmEvent.BTN_CLICK_LOC_CAR, FsmState.Car3D);
        dictStateVoice.put(FsmEvent.BTN_CLICK_CAR_3D, FsmState.North2D);
        dictStateVoice.put(FsmEvent.BTN_CLICK_NORTH_2D, FsmState.Car3D);
        dictStateVoice.put(FsmEvent.TOUCH_MAP, FsmState.BrowseMap);
        dictStateVoice.put(FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, FsmState.Voice);
        dictStateVoice.put(FsmEvent.ENTRY_NAVI_READY, FsmState.NaviReady);
        dictStateVoice.put(FsmEvent.ENTRY_NEARBY_SEARCH, FsmState.NearbySearch);
        dictStateVoice.put(FsmEvent.BTN_CLICK_FULL_VIEW, FsmState.Fullview);
        dictStateVoice.put(FsmEvent.VOICE_HUDMIRROR, FsmState.HUDMirror);
        dictStateVoice.put(FsmEvent.ENTRY_PIP, FsmState.Pip);
        dictStateVoice.put(FsmEvent.ENTRY_DYNAMIC_LAYER, FsmState.DynamicLayer);
    }

    public static boolean isGlassState(String str) {
        if (str != null && str.length() != 0) {
            return glassStates.contains(str);
        }
        return false;
    }

    public static boolean isNeedRefreshMapState(String str) {
        if (str != null && str.length() != 0) {
            return FsmState.SimpleGuide.equals(str);
        }
        return false;
    }

    public static String queryDestState(String str, String str2) {
        synchronized (lock) {
            try {
                HashMap<String, String> hashMap = dictFSM.get(str);
                if (hashMap == null) {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RouteGuide", "不存在该状态对应的状态机，请完善逻辑!");
                    }
                    return null;
                }
                String str3 = hashMap.get(str2);
                if (str3 == null) {
                    g gVar2 = g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RouteGuide", "处于状态 (" + str + ")时， 不存在执行event = " + str2 + " 的跳转，请考虑是否完善逻辑!");
                    }
                    return null;
                }
                return str3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
