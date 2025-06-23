package com.baidu.platform.comapi.walknavi.fsm;

/* loaded from: classes8.dex */
public abstract class RGState {
    public static final String METHOD_NAME_ENTER = "enter";
    public static final String METHOD_NAME_EXCUTE = "excute";
    public static final String METHOD_NAME_EXIT = "exit";
    public static final String PACKAGE_NAME = RGState.class.getPackage().getName();
    public static final String CLASS_PREFIX = RGState.class.getSimpleName();

    public void enter() {
    }

    public void excute() {
        onActionUI();
        onActionNaviEngine();
        onActionLayers();
        onActionMapStatus();
    }

    public void exit() {
    }

    public abstract void onActionLayers();

    public abstract void onActionMapStatus();

    public abstract void onActionNaviEngine();

    public abstract void onActionUI();
}
