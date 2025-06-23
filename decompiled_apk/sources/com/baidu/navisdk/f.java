package com.baidu.navisdk;

import com.baidu.navisdk.adapter.IBNaviViewListener;

/* loaded from: classes7.dex */
public class f extends IBNaviViewListener {
    private static f b;

    /* renamed from: a, reason: collision with root package name */
    private IBNaviViewListener f6791a = null;

    private f() {
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        b = new f();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onBottomBarClick(IBNaviViewListener.Action action) {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onBottomBarClick(action);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onFloatViewClicked() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onFloatViewClicked();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onFullViewButtonClick(boolean z) {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onFullViewButtonClick(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onFullViewWindowClick(boolean z) {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onFullViewWindowClick(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onMainInfoPanCLick() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onMainInfoPanCLick();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onMapClicked(double d, double d2) {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onMapClicked(d, d2);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onMapMoved() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onMapMoved();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onNaviBackClick() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onNaviBackClick();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onNaviSettingClick() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onNaviSettingClick();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onNaviTurnClick() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onNaviTurnClick();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onRefreshBtnClick() {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onRefreshBtnClick();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNaviViewListener
    public void onZoomLevelChange(int i) {
        IBNaviViewListener iBNaviViewListener = this.f6791a;
        if (iBNaviViewListener != null) {
            iBNaviViewListener.onZoomLevelChange(i);
        }
    }

    public void a(IBNaviViewListener iBNaviViewListener) {
        this.f6791a = iBNaviViewListener;
    }
}
