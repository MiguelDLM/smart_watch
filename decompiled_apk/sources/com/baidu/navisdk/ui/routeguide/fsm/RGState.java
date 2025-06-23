package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.navisdk.pronavi.ui.base.b;

/* loaded from: classes8.dex */
public abstract class RGState {
    public static final String METHOD_NAME_ENTER = "enter";
    public static final String METHOD_NAME_EXCUTE = "excute";
    public static final String METHOD_NAME_EXIT = "exit";
    public static final String METHOD_NAME_INTERCEPT = "intercept";
    protected Bundle enterParams = null;
    protected Bundle exitParams = null;
    public static final String PACKAGE_NAME = RGState.class.getPackage().getName();
    public static final String CLASS_PREFIX = RGState.class.getSimpleName();

    public void enter() {
        enter(null);
    }

    public void excute() {
        excute(null);
    }

    public void exit() {
    }

    @Nullable
    public b getUiContext() {
        return com.baidu.navisdk.ui.routeguide.b.V().s();
    }

    public boolean intercept(Bundle bundle) {
        this.enterParams = bundle;
        return false;
    }

    public abstract void onActionLayers();

    public abstract void onActionMapStatus();

    public abstract void onActionNaviEngine();

    public abstract void onActionUI();

    public void enter(Bundle bundle) {
        this.enterParams = bundle;
    }

    public void excute(Bundle bundle) {
        this.enterParams = bundle;
        onActionUI();
        onActionNaviEngine();
        onActionLayers();
        onActionMapStatus();
    }

    public void exit(Bundle bundle) {
        this.exitParams = bundle;
        exit();
    }
}
