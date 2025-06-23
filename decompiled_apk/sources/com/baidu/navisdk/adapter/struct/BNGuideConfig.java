package com.baidu.navisdk.adapter.struct;

import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.adapter.IBNRouteGuideManager;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class BNGuideConfig {
    public static final int ABOVE_HEIGHT = 50;
    public static final int BOTTOM_HEIGHT = 60;
    private final IBNRouteGuideManager.NaviAddViewCallback aboveBottomView;
    private final IBNRouteGuideManager.NaviAddViewCallback belowBottomView;
    private final IBNRouteGuideManager.NaviAddViewCallback bottomBarView;
    private final Bundle params;

    /* loaded from: classes7.dex */
    public static class Builder {
        private IBNRouteGuideManager.NaviAddViewCallback aboveBottomView;
        private IBNRouteGuideManager.NaviAddViewCallback belowBottomView;
        private IBNRouteGuideManager.NaviAddViewCallback bottomBarView;
        private Bundle params;

        /* JADX INFO: Access modifiers changed from: private */
        public int getHeight(IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback, int i) {
            if (naviAddViewCallback != null && naviAddViewCallback.getAddedView() != null) {
                int dip2px = ScreenUtil.getInstance().dip2px(i);
                if (naviAddViewCallback.getViewHeight() <= dip2px) {
                    if (naviAddViewCallback.getViewHeight() <= 0) {
                        if (naviAddViewCallback.getAddedView().getHeight() <= dip2px) {
                            return naviAddViewCallback.getAddedView().getHeight();
                        }
                        return dip2px;
                    }
                    return naviAddViewCallback.getViewHeight();
                }
                return dip2px;
            }
            return 0;
        }

        public Builder addAboveBottomView(final IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback) {
            if (naviAddViewCallback == null) {
                this.aboveBottomView = null;
                return this;
            }
            this.aboveBottomView = new IBNRouteGuideManager.NaviAddViewCallback() { // from class: com.baidu.navisdk.adapter.struct.BNGuideConfig.Builder.1
                @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager.NaviAddViewCallback
                public View getAddedView() {
                    return naviAddViewCallback.getAddedView();
                }

                @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager.NaviAddViewCallback
                public int getViewHeight() {
                    return Builder.this.getHeight(naviAddViewCallback, 50);
                }
            };
            return this;
        }

        public Builder addBelowBottomView(final IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback) {
            if (naviAddViewCallback == null) {
                this.belowBottomView = null;
                return this;
            }
            this.belowBottomView = new IBNRouteGuideManager.NaviAddViewCallback() { // from class: com.baidu.navisdk.adapter.struct.BNGuideConfig.Builder.2
                @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager.NaviAddViewCallback
                public View getAddedView() {
                    return naviAddViewCallback.getAddedView();
                }

                @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager.NaviAddViewCallback
                public int getViewHeight() {
                    return Builder.this.getHeight(naviAddViewCallback, 60);
                }
            };
            return this;
        }

        public Builder addBottomBarView(IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback) {
            this.bottomBarView = naviAddViewCallback;
            return this;
        }

        public BNGuideConfig build() {
            return new BNGuideConfig(this.params, this.aboveBottomView, this.bottomBarView, this.belowBottomView);
        }

        public Builder params(Bundle bundle) {
            this.params = bundle;
            return this;
        }
    }

    public IBNRouteGuideManager.NaviAddViewCallback getAboveBottomView() {
        return this.aboveBottomView;
    }

    public IBNRouteGuideManager.NaviAddViewCallback getBelowBottomView() {
        return this.belowBottomView;
    }

    public IBNRouteGuideManager.NaviAddViewCallback getBottomBarView() {
        return this.bottomBarView;
    }

    public Bundle getParams() {
        return this.params;
    }

    private BNGuideConfig(Bundle bundle, IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback, IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback2, IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback3) {
        this.params = bundle;
        this.aboveBottomView = naviAddViewCallback;
        this.bottomBarView = naviAddViewCallback2;
        this.belowBottomView = naviAddViewCallback3;
    }
}
