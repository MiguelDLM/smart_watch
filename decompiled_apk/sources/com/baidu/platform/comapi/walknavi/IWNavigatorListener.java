package com.baidu.platform.comapi.walknavi;

/* loaded from: classes8.dex */
public interface IWNavigatorListener {
    void onNaviExit();

    void onPageJump(int i, Object obj);

    void onWalkNaviModeChange(int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener);
}
