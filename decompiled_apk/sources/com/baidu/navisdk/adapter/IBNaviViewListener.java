package com.baidu.navisdk.adapter;

/* loaded from: classes7.dex */
public abstract class IBNaviViewListener {

    /* loaded from: classes7.dex */
    public enum Action {
        ContinueNavi,
        OpenSetting
    }

    public void onBottomBarClick(Action action) {
    }

    public void onFloatViewClicked() {
    }

    public void onFullViewButtonClick(boolean z) {
    }

    public void onFullViewWindowClick(boolean z) {
    }

    public void onMainInfoPanCLick() {
    }

    public void onMapClicked(double d, double d2) {
    }

    public void onMapMoved() {
    }

    public void onNaviBackClick() {
    }

    public void onNaviSettingClick() {
    }

    public void onNaviTurnClick() {
    }

    public void onRefreshBtnClick() {
    }

    public void onZoomLevelChange(int i) {
    }
}
