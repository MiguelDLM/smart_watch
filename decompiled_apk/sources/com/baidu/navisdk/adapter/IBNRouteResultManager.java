package com.baidu.navisdk.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.navisdk.adapter.struct.BNSearchPoi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public interface IBNRouteResultManager {

    /* loaded from: classes7.dex */
    public interface ICalcRouteByViaListener {
        void onFailed(int i);

        void onStart();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public interface IRouteClickedListener {
        void routeClicked(int i);
    }

    /* loaded from: classes7.dex */
    public interface IThroughNodeClickedListener {
        void onThroughNodeClicked(int i, BNRoutePlanNode bNRoutePlanNode);
    }

    /* loaded from: classes7.dex */
    public interface NearbySearchKeyword {
        public static final String Bank = "银行";
        public static final String Charging_Station = "充电站";
        public static final String Gas_Station = "加油站";
        public static final String Hotel = "酒店";
        public static final String Park = "停车场";
        public static final String Restaurant = "餐饮";
        public static final String Service = "服务区";
        public static final String Spots = "景点";
        public static final String Toilet = "厕所";
    }

    /* loaded from: classes7.dex */
    public interface PoiSearchListener {
        void onFailed();

        void onStart();

        void onSuccess(List<BNSearchPoi> list);
    }

    void addYellowTipsToContainer(ViewGroup viewGroup);

    void fullView();

    void fullViewByNode(List<BNRoutePlanNode> list);

    void handleCheckpointClick(boolean z);

    void handleCityClick(boolean z);

    void handleRouteClick(boolean z);

    void handleServiceClick(boolean z);

    void handleWeatherClick(boolean z);

    boolean isLongDistance();

    void onCreate(Context context);

    void onDestroy();

    void onPause();

    void onResume();

    void poiSearch(ArrayList<String> arrayList, PoiSearchListener poiSearchListener);

    void removeYellowTipsFromContainer();

    void selectRoute(int i);

    void setCalcRouteByViaListener(ICalcRouteByViaListener iCalcRouteByViaListener);

    void setOnThroughNodeClickListener(IThroughNodeClickedListener iThroughNodeClickedListener);

    void setRouteClickedListener(IRouteClickedListener iRouteClickedListener);

    void showTruckLimitIcon(boolean z);

    boolean startNavi();
}
