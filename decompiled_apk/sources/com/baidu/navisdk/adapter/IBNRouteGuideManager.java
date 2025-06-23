package com.baidu.navisdk.adapter;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.navisdk.adapter.struct.BNGuideConfig;
import com.baidu.navisdk.adapter.struct.BNRoutePlanInfo;
import com.baidu.navisdk.adapter.struct.BNSearchPoi;
import com.baidu.navisdk.adapter.struct.BNaviResultInfo;
import com.baidu.navisdk.adapter.struct.RoadEventItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public interface IBNRouteGuideManager {

    /* loaded from: classes7.dex */
    public interface ChangeRouteListener {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public interface ISearchPoiListener {
        void onSearchExit();

        void onSearchFailed();

        void onSearchSuccess(List<BNSearchPoi> list);
    }

    /* loaded from: classes7.dex */
    public static abstract class NaviAddViewCallback {
        public abstract View getAddedView();

        public int getViewHeight() {
            return 0;
        }
    }

    /* loaded from: classes7.dex */
    public interface RefreshRouteListener {
        void onFail();

        void onNoNewRoute();

        void onRefreshTimeout();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public interface RoutePlanCallbackListener {
        public static final int TYPE_ADD_VIA = 1;
        public static final int TYPE_CHANGE_END_NODE = 10;
        public static final int TYPE_DELETE_VIA = 6;

        void onFail(int i, BNRoutePlanInfo bNRoutePlanInfo);

        void onStart();

        void onSuccess(int i, BNRoutePlanInfo bNRoutePlanInfo);
    }

    void addViaNodes(List<BNRoutePlanNode> list);

    void changeRouteByMainSideBridge(int i, ChangeRouteListener changeRouteListener);

    void continueNavi();

    void deleteViaNodes();

    void forceQuitNaviWithoutDialog();

    void fullView(boolean z);

    List<RoadEventItem> getForwardRoadEvent();

    int getMainSideBridgeType();

    BNaviResultInfo getNaviResultInfo();

    String getNextGuideText();

    void onActivityResult(int i, int i2, Intent intent);

    void onBackPressed(boolean z);

    void onBackPressed(boolean z, boolean z2);

    void onBackground();

    void onConfigurationChanged(Configuration configuration);

    View onCreate(FragmentActivity fragmentActivity, BNGuideConfig bNGuideConfig);

    void onDestroy(boolean z);

    void onForeground();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    void onPause();

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onResume();

    void onStart();

    void onStop();

    void pauseRouteGuide();

    void reCalcRouteWithPrefer(int i);

    void refreshRoute(RefreshRouteListener refreshRouteListener);

    boolean resetEndNodeInNavi(BNRoutePlanNode bNRoutePlanNode);

    boolean resetEndNodeInNavi(BNRoutePlanNode bNRoutePlanNode, boolean z);

    void resumeRouteGuide();

    boolean routeSearchPoi(String str, ArrayList<String> arrayList, ISearchPoiListener iSearchPoiListener);

    void selectRoute(int i);

    void setNaviListener(IBNaviListener iBNaviListener);

    void setNaviViewListener(IBNaviViewListener iBNaviViewListener);

    void setRoutePlanCallback(RoutePlanCallbackListener routePlanCallbackListener);

    void stopNavi();
}
