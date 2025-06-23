package com.baidu.platform.comapi.walknavi.fsm;

import android.util.Log;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class FSMTable {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f9756a = new byte[0];
    public static HashMap<String, HashMap<String, String>> dictFSM;
    public static HashMap<String, String> dictStateBrowseMap;
    public static HashMap<String, String> dictStateCar3D;
    public static HashMap<String, String> dictStateEntry;
    public static HashMap<String, String> dictStateNorth2D;
    public static HashMap<String, String> dictStateOverview;
    public static HashMap<String, String> dictStateSeg;
    public static HashMap<String, String> dictStateSegEntry;

    private static void a() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateEntry = hashMap;
        hashMap.clear();
        dictStateEntry.put("[查看全览]按钮点击", "Overview");
        dictStateEntry.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.Car3D);
        dictStateEntry.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.North2D);
        dictStateEntry.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateEntry.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.Car3D);
        dictStateEntry.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.Car3D);
        dictStateEntry.put(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D, RGFSMTable.FsmState.North2D);
    }

    private static void b() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateSegEntry = hashMap;
        hashMap.clear();
        dictStateSegEntry.put("[查看全览]按钮点击", "Overview");
        dictStateSegEntry.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.Car3D);
        dictStateSegEntry.put(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR, RGFSMTable.FsmState.Car3D);
        dictStateSegEntry.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.North2D);
        dictStateSegEntry.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateSegEntry.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.Car3D);
        dictStateSegEntry.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.Car3D);
    }

    private static void c() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateNorth2D = hashMap;
        hashMap.clear();
        dictStateNorth2D.put("强诱导转到分段", "Seg");
        dictStateNorth2D.put("[查看全览]按钮点击", "Overview");
        dictStateNorth2D.put(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D, RGFSMTable.FsmState.Car3D);
        dictStateNorth2D.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.Car3D);
        dictStateNorth2D.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.Car3D);
        dictStateNorth2D.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateNorth2D.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.North2D);
        dictStateNorth2D.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.North2D);
    }

    private static void d() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateCar3D = hashMap;
        hashMap.clear();
        dictStateCar3D.put("强诱导转到分段", "Seg");
        dictStateCar3D.put("[查看全览]按钮点击", "Overview");
        dictStateCar3D.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.North2D);
        dictStateCar3D.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.North2D);
        dictStateCar3D.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateCar3D.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.Car3D);
        dictStateCar3D.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.Car3D);
        dictStateCar3D.put(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D, RGFSMTable.FsmState.North2D);
    }

    private static void e() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateBrowseMap = hashMap;
        hashMap.clear();
        dictStateBrowseMap.put("强诱导转到分段", "Seg");
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.Car3D);
        dictStateBrowseMap.put("[查看全览]按钮点击", "Overview");
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR, RGFSMTable.FsmState.Car3D);
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.BACK);
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.BrowseMap);
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.BACK);
        dictStateBrowseMap.put(RGFSMTable.FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, RGFSMTable.FsmState.BACK);
    }

    private static void f() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateOverview = hashMap;
        hashMap.clear();
        dictStateOverview.put("强诱导转到分段", "Seg");
        dictStateOverview.put("[查看全览]按钮点击", "Overview");
        dictStateOverview.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.Car3D);
        dictStateOverview.put(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR, RGFSMTable.FsmState.Car3D);
        dictStateOverview.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.North2D);
        dictStateOverview.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateOverview.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.BrowseMap);
        dictStateOverview.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.Car3D);
        dictStateOverview.put(RGFSMTable.FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, RGFSMTable.FsmState.Car3D);
    }

    private static void g() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateSeg = hashMap;
        hashMap.clear();
        dictStateSeg.put("强诱导转到分段", "Seg");
        dictStateSeg.put("[查看全览]按钮点击", "Overview");
        dictStateSeg.put(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D, RGFSMTable.FsmState.Car3D);
        dictStateSeg.put(RGFSMTable.FsmEvent.BTN_CLICK_LOC_CAR, RGFSMTable.FsmState.Car3D);
        dictStateSeg.put(RGFSMTable.FsmEvent.MAP_COMPASS_CLICK, RGFSMTable.FsmState.North2D);
        dictStateSeg.put(RGFSMTable.FsmEvent.MAP_MOVE, RGFSMTable.FsmState.BrowseMap);
        dictStateSeg.put(RGFSMTable.FsmEvent.TOUCH_MAP, RGFSMTable.FsmState.BrowseMap);
        dictStateSeg.put(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED, RGFSMTable.FsmState.Car3D);
        dictStateSeg.put(RGFSMTable.FsmEvent.MSG_AUTO_LOC_CAR_WHEN_TIMEOUT, RGFSMTable.FsmState.Car3D);
    }

    private static void h() {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        dictFSM = hashMap;
        hashMap.clear();
        dictFSM.put("Entry", dictStateEntry);
        dictFSM.put("SegEntry", dictStateSegEntry);
        dictFSM.put(RGFSMTable.FsmState.North2D, dictStateNorth2D);
        dictFSM.put(RGFSMTable.FsmState.Car3D, dictStateCar3D);
        dictFSM.put(RGFSMTable.FsmState.BrowseMap, dictStateBrowseMap);
        dictFSM.put("Overview", dictStateOverview);
        dictFSM.put("Seg", dictStateSeg);
    }

    public static void initTransition() {
        a();
        b();
        c();
        d();
        e();
        f();
        g();
        h();
    }

    public static String queryDestState(String str, String str2) {
        synchronized (f9756a) {
            try {
                new HashMap();
                HashMap<String, String> hashMap = dictFSM.get(str);
                if (hashMap == null) {
                    Log.e(FSMTable.class.getSimpleName(), "不存在该状态对应的状态机，请完善逻辑!");
                    return null;
                }
                String str3 = hashMap.get(str2);
                if (str3 == null) {
                    Log.e(FSMTable.class.getSimpleName(), "处于状态 (" + str + ")时， 不存在执行event = " + str2 + " 的跳转，请考虑是否完善逻辑!");
                    return null;
                }
                return str3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void release() {
        HashMap<String, HashMap<String, String>> hashMap = dictFSM;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, String> hashMap2 = dictStateEntry;
        if (hashMap2 != null) {
            hashMap2.clear();
            dictStateEntry = null;
        }
        HashMap<String, String> hashMap3 = dictStateSegEntry;
        if (hashMap3 != null) {
            hashMap3.clear();
            dictStateSegEntry = null;
        }
        HashMap<String, String> hashMap4 = dictStateNorth2D;
        if (hashMap4 != null) {
            hashMap4.clear();
            dictStateNorth2D = null;
        }
        HashMap<String, String> hashMap5 = dictStateCar3D;
        if (hashMap5 != null) {
            hashMap5.clear();
            dictStateCar3D = null;
        }
        HashMap<String, String> hashMap6 = dictStateBrowseMap;
        if (hashMap6 != null) {
            hashMap6.clear();
            dictStateBrowseMap = null;
        }
        HashMap<String, String> hashMap7 = dictStateOverview;
        if (hashMap7 != null) {
            hashMap7.clear();
            dictStateOverview = null;
        }
        HashMap<String, String> hashMap8 = dictStateSeg;
        if (hashMap8 != null) {
            hashMap8.clear();
            dictStateSeg = null;
        }
    }
}
