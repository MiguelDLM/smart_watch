package com.baidu.mapclient.liteapp.routeresult;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mapclient.liteapp.BNFactory;
import com.baidu.mapclient.liteapp.BNUtils;
import com.baidu.mapclient.liteapp.EventBusKt;
import com.baidu.mapclient.liteapp.activity.NaviActivity;
import com.baidu.mapclient.liteapp.custom.BNRecyclerView;
import com.baidu.mapclient.liteapp.custom.BNScrollLayout;
import com.baidu.mapclient.liteapp.custom.BNScrollView;
import com.baidu.mapclient.liteapp.routeresult.PreferItemsAdapter;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.adapter.struct.BNRouteDetail;
import com.baidu.navisdk.adapter.struct.BNRoutePlanInfos;
import com.baidu.navisdk.adapter.struct.BNRoutePlanItem;
import com.baidu.navisdk.adapter.struct.BNSearchPoi;
import com.blankj.utilcode.util.ToastUtils;
import com.szabh.navi.R;
import com.szabh.smable3.entity.Languages;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class CarNaviRouteResultFragment extends Fragment implements View.OnClickListener, PreferItemsAdapter.ClickPreferListener {
    public static final int DELAY_MILLIS = 1000;
    private static final String TAG = "DemoRouteResultFragment";
    private FrameLayout mFlRetry;
    private PreferItemsAdapter mItemsAdapter;
    private LinearLayout mLDLayout;
    private LinearLayout mLayoutTab0;
    private LinearLayout mLayoutTab1;
    private LinearLayout mLayoutTab2;
    private PopupWindow mPopWindow;
    private Button mPreferBtn;
    private RecyclerView mPreferRecyclerView;
    private BNRecyclerView mRecyclerView;
    private RouteResultAdapter mResultAdapter;
    private RelativeLayout mRlButton;
    private View mRootView;
    private ArrayList<BNRoutePlanItem> mRoutePlanItems;
    private ArrayList<RouteSortModel> mRouteSortList;
    private final ArrayList<BNRouteDetail> mRouteList = new ArrayList<>();
    private ArrayList<ArrayList<BNRouteDetail>> mRouteDetails = new ArrayList<>();
    private int currentPrefer = 1;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            Log.i("rp.onRoutePlan()", " 算路结果msg：" + message.what + ", " + message.arg1 + " nErrorCode arg2:" + message.arg2);
            int i = message.what;
            if (i != 1000) {
                if (i != 1002) {
                    if (i == 1003) {
                        Toast.makeText(CarNaviRouteResultFragment.this.getContext(), R.string.calculate_route_tip, 0).show();
                        CarNaviRouteResultFragment.this.mFlRetry.setVisibility(0);
                        return;
                    }
                    return;
                }
                CarNaviRouteResultFragment.this.mFlRetry.setVisibility(8);
                CarNaviRouteResultFragment.this.mRlButton.setVisibility(0);
                CarNaviRouteResultFragment carNaviRouteResultFragment = CarNaviRouteResultFragment.this;
                carNaviRouteResultFragment.updateBtnText(carNaviRouteResultFragment.currentPrefer);
                BaiduNaviManagerFactory.getRouteResultManager().fullView();
                CarNaviRouteResultFragment.this.initData();
                EventBusKt.postEvent("STAT_NAV", new Object());
                return;
            }
            CarNaviRouteResultFragment.this.mFlRetry.setVisibility(8);
            CarNaviRouteResultFragment.this.mLayoutTab0.setSelected(false);
            CarNaviRouteResultFragment.this.mLayoutTab1.setSelected(false);
            CarNaviRouteResultFragment.this.mLayoutTab2.setSelected(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        BNRoutePlanInfos routePlanInfo = BaiduNaviManagerFactory.getRoutePlanManager().getRoutePlanInfo();
        if (routePlanInfo == null) {
            ToastUtils.showLong("地图数据异常");
            return;
        }
        ArrayList<String> limitInfo = routePlanInfo.getLimitInfo();
        if (limitInfo != null) {
            for (int i = 0; i < limitInfo.size(); i++) {
                String[] split = limitInfo.get(i).split(",");
                Log.e(TAG, split[0] + getString(R.string.route_restriction_tip) + split[1]);
            }
        }
        ArrayList<BNRoutePlanItem> routeTabInfos = routePlanInfo.getRouteTabInfos();
        this.mRoutePlanItems = routeTabInfos;
        if (routeTabInfos != null) {
            if (!getResources().getConfiguration().locale.getLanguage().equalsIgnoreCase(Languages.DEFAULT_LANGUAGE_ZH)) {
                int i2 = 0;
                while (i2 < this.mRoutePlanItems.size()) {
                    i2++;
                    this.mRoutePlanItems.get(i2).setPusLabelName(getString(R.string.nav_plan, Integer.valueOf(i2)));
                }
            }
            if (this.mRoutePlanItems.size() > 0 && this.mRoutePlanItems.get(0) != null) {
                initTabView(this.mLayoutTab0, this.mRoutePlanItems.get(0));
            }
            if (this.mRoutePlanItems.size() > 1 && this.mRoutePlanItems.get(1) != null) {
                initTabView(this.mLayoutTab1, this.mRoutePlanItems.get(1));
                this.mLayoutTab1.setVisibility(0);
            } else {
                this.mLayoutTab1.setVisibility(8);
            }
            if (this.mRoutePlanItems.size() > 2 && this.mRoutePlanItems.get(2) != null) {
                initTabView(this.mLayoutTab2, this.mRoutePlanItems.get(2));
                this.mLayoutTab2.setVisibility(0);
            } else {
                this.mLayoutTab2.setVisibility(8);
            }
        }
        this.mLayoutTab0.setSelected(true);
        this.mRouteDetails = routePlanInfo.getRouteDetailLists();
        this.mRouteList.clear();
        this.mRouteList.addAll(this.mRouteDetails.get(0));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RouteResultAdapter routeResultAdapter = new RouteResultAdapter(this.mRouteList);
        this.mResultAdapter = routeResultAdapter;
        this.mRecyclerView.setAdapter(routeResultAdapter);
        if (BaiduNaviManagerFactory.getRouteResultManager().isLongDistance()) {
            this.mLDLayout.setVisibility(0);
        } else {
            this.mLDLayout.setVisibility(8);
        }
    }

    private void initListener() {
        BaiduNaviManagerFactory.getRouteResultManager().setCalcRouteByViaListener(new IBNRouteResultManager.ICalcRouteByViaListener() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment.2
            @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.ICalcRouteByViaListener
            public void onFailed(int i) {
                CarNaviRouteResultFragment.this.mFlRetry.setVisibility(0);
            }

            @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.ICalcRouteByViaListener
            public void onStart() {
                Log.e(CarNaviRouteResultFragment.TAG, CarNaviRouteResultFragment.this.getString(R.string.start_calculate_route_tip));
            }

            @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.ICalcRouteByViaListener
            public void onSuccess() {
                CarNaviRouteResultFragment.this.mFlRetry.setVisibility(8);
                CarNaviRouteResultFragment.this.mRlButton.setVisibility(0);
                CarNaviRouteResultFragment carNaviRouteResultFragment = CarNaviRouteResultFragment.this;
                carNaviRouteResultFragment.updateBtnText(carNaviRouteResultFragment.currentPrefer);
                CarNaviRouteResultFragment.this.initData();
            }
        });
        BaiduNaviManagerFactory.getRouteResultManager().setRouteClickedListener(new IBNRouteResultManager.IRouteClickedListener() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment.3
            @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.IRouteClickedListener
            public void routeClicked(int i) {
                BaiduNaviManagerFactory.getRouteGuideManager().selectRoute(i);
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            CarNaviRouteResultFragment.this.mLayoutTab0.setSelected(false);
                            CarNaviRouteResultFragment.this.mLayoutTab1.setSelected(false);
                            CarNaviRouteResultFragment.this.mLayoutTab2.setSelected(true);
                            return;
                        }
                        return;
                    }
                    CarNaviRouteResultFragment.this.mLayoutTab0.setSelected(false);
                    CarNaviRouteResultFragment.this.mLayoutTab1.setSelected(true);
                    CarNaviRouteResultFragment.this.mLayoutTab2.setSelected(false);
                    return;
                }
                CarNaviRouteResultFragment.this.mLayoutTab0.setSelected(true);
                CarNaviRouteResultFragment.this.mLayoutTab1.setSelected(false);
                CarNaviRouteResultFragment.this.mLayoutTab2.setSelected(false);
            }
        });
    }

    private void initPreferPopWindow() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_pop_prefer, (ViewGroup) null, false);
        this.mPreferRecyclerView = (RecyclerView) inflate.findViewById(R.id.nsdk_route_sort_gv);
        initPreferView();
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.mPopWindow = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.mPopWindow.setTouchable(true);
    }

    private void initPreferView() {
        initRouteSortList();
        this.mPreferRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.mPreferRecyclerView.setOverScrollMode(2);
        if (this.mItemsAdapter == null) {
            PreferItemsAdapter preferItemsAdapter = new PreferItemsAdapter(getContext(), this.mRouteSortList);
            this.mItemsAdapter = preferItemsAdapter;
            preferItemsAdapter.setClickPreferListener(this);
        }
        this.mPreferRecyclerView.setAdapter(this.mItemsAdapter);
    }

    private void initRouteSortList() {
        ArrayList<RouteSortModel> arrayList = new ArrayList<>();
        this.mRouteSortList = arrayList;
        arrayList.add(new RouteSortModel(getString(R.string.pref_default), 1));
        this.mRouteSortList.add(new RouteSortModel(getString(R.string.pref_time_first), 256));
        this.mRouteSortList.add(new RouteSortModel(getString(R.string.pref_notoll), 8));
        this.mRouteSortList.add(new RouteSortModel(getString(R.string.pref_avoid_traffic_jam), 16));
        this.mRouteSortList.add(new RouteSortModel(getString(R.string.pref_nohighway), 4));
        this.mRouteSortList.add(new RouteSortModel(getString(R.string.pref_road_first), 512));
    }

    private void initTabView(LinearLayout linearLayout, BNRoutePlanItem bNRoutePlanItem) {
        ((TextView) linearLayout.findViewById(R.id.prefer)).setText(bNRoutePlanItem.getPusLabelName());
        ((TextView) linearLayout.findViewById(R.id.time)).setText((((int) bNRoutePlanItem.getPassTime()) / 60) + getString(R.string.nav_minute));
        ((TextView) linearLayout.findViewById(R.id.distance)).setText((((int) bNRoutePlanItem.getLength()) / 1000) + getString(R.string.nav_km));
        ((TextView) linearLayout.findViewById(R.id.traffic_light)).setText(String.valueOf(bNRoutePlanItem.getLights()));
    }

    private void initView() {
        ((BNScrollView) this.mRootView.findViewById(R.id.content_scroll)).setVerticalScrollBarEnabled(false);
        final LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.layout_3tab);
        final BNScrollLayout bNScrollLayout = (BNScrollLayout) this.mRootView.findViewById(R.id.layout_scroll);
        bNScrollLayout.setMaxOffset(0);
        bNScrollLayout.setMinOffset(BNUtils.dip2px(requireContext(), 180.0f));
        bNScrollLayout.setToOpen();
        this.mRlButton.setVisibility(0);
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BNUtils.checkDeviceHasNavigationBar(CarNaviRouteResultFragment.this.getActivity())) {
                        int measuredHeight = linearLayout.getMeasuredHeight() + BNUtils.dip2px(CarNaviRouteResultFragment.this.getActivity(), 10.0f) + BNUtils.getNavigationBarHeight(CarNaviRouteResultFragment.this.getActivity());
                        bNScrollLayout.setMaxOffset(measuredHeight);
                        CarNaviRouteResultFragment.this.mRlButton.setPadding(0, 0, 0, measuredHeight);
                    } else {
                        int measuredHeight2 = linearLayout.getMeasuredHeight() + BNUtils.dip2px(CarNaviRouteResultFragment.this.getActivity(), 10.0f);
                        bNScrollLayout.setMaxOffset(measuredHeight2);
                        CarNaviRouteResultFragment.this.mRlButton.setPadding(0, 0, 0, measuredHeight2);
                    }
                    bNScrollLayout.setToOpen();
                    CarNaviRouteResultFragment.this.mRlButton.invalidate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000L);
    }

    private void routePlan() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BNFactory.getInstance().getStartNode(getActivity()));
        arrayList.add(BNFactory.getInstance().getEndNode(getActivity()));
        if (BaiduNaviManagerFactory.getCruiserManager().isCruiserStarted()) {
            BaiduNaviManagerFactory.getCruiserManager().stopCruise();
        }
        Bundle bundle = new Bundle();
        bundle.putInt(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE, 1);
        BaiduNaviManagerFactory.getRoutePlanManager().routePlan(arrayList, this.currentPrefer, bundle, this.handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnText(int i) {
        if (i != 1) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 256) {
                            if (i == 512) {
                                this.mPreferBtn.setText(R.string.pref_road_first);
                                return;
                            }
                            return;
                        }
                        this.mPreferBtn.setText(R.string.pref_time_first);
                        return;
                    }
                    this.mPreferBtn.setText(R.string.pref_avoid_traffic_jam);
                    return;
                }
                this.mPreferBtn.setText(R.string.pref_notoll);
                return;
            }
            this.mPreferBtn.setText(R.string.pref_nohighway);
            return;
        }
        this.mPreferBtn.setText(R.string.pref_default);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.route_0) {
            if (this.mRouteDetails.size() < 1) {
                return;
            }
            this.mLayoutTab0.setSelected(true);
            this.mLayoutTab1.setSelected(false);
            this.mLayoutTab2.setSelected(false);
            BaiduNaviManagerFactory.getRouteResultManager().selectRoute(0);
            BaiduNaviManagerFactory.getRouteResultManager().fullView();
            this.mRouteList.clear();
            this.mRouteList.addAll(this.mRouteDetails.get(0));
            this.mResultAdapter.notifyDataSetChanged();
            return;
        }
        if (id == R.id.route_1) {
            if (this.mRouteDetails.size() < 2) {
                return;
            }
            this.mLayoutTab0.setSelected(false);
            this.mLayoutTab1.setSelected(true);
            this.mLayoutTab2.setSelected(false);
            BaiduNaviManagerFactory.getRouteResultManager().selectRoute(1);
            BaiduNaviManagerFactory.getRouteResultManager().fullView();
            this.mRouteList.clear();
            this.mRouteList.addAll(this.mRouteDetails.get(1));
            this.mResultAdapter.notifyDataSetChanged();
            return;
        }
        if (id == R.id.route_2) {
            if (this.mRoutePlanItems.size() < 3) {
                return;
            }
            this.mLayoutTab0.setSelected(false);
            this.mLayoutTab1.setSelected(false);
            this.mLayoutTab2.setSelected(true);
            BaiduNaviManagerFactory.getRouteResultManager().selectRoute(2);
            BaiduNaviManagerFactory.getRouteResultManager().fullView();
            this.mRouteList.clear();
            this.mRouteList.addAll(this.mRouteDetails.get(2));
            this.mResultAdapter.notifyDataSetChanged();
            return;
        }
        if (id == R.id.btn_fullView) {
            BaiduNaviManagerFactory.getRouteResultManager().fullView();
            return;
        }
        if (id == R.id.btn_road) {
            BaiduNaviManagerFactory.getRouteResultSettingManager().setRealRoadCondition(getActivity(), true ^ BaiduNaviManagerFactory.getRouteResultSettingManager().isRealRoadConditionOpen());
            return;
        }
        if (id == R.id.btn_prefer) {
            this.mPopWindow.showAtLocation(this.mRootView, 80, 0, 0);
            return;
        }
        if (id == R.id.btn_start_navi) {
            ((NaviActivity) getActivity()).isRealnavi = true;
            BaiduNaviManagerFactory.getRouteResultManager().startNavi();
            FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.fragment_content, new CarNaviGuideFragment(), "DemoGuide");
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
            return;
        }
        if (id == R.id.btn_start_navi2) {
            ((NaviActivity) getActivity()).isRealnavi = false;
            BaiduNaviManagerFactory.getRouteResultManager().startNavi();
            FragmentTransaction beginTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
            beginTransaction2.replace(R.id.fragment_content, new CarNaviGuideFragment(), "DemoGuide");
            beginTransaction2.addToBackStack(null);
            beginTransaction2.commit();
            return;
        }
        if (id == R.id.bank) {
            BaiduNaviManagerFactory.getRouteResultManager().poiSearch(new ArrayList<String>() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment.5
                {
                    add(IBNRouteResultManager.NearbySearchKeyword.Bank);
                }
            }, new IBNRouteResultManager.PoiSearchListener() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment.6
                @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.PoiSearchListener
                public void onFailed() {
                }

                @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.PoiSearchListener
                public void onStart() {
                }

                @Override // com.baidu.navisdk.adapter.IBNRouteResultManager.PoiSearchListener
                public void onSuccess(List<BNSearchPoi> list) {
                }
            });
        }
    }

    @Override // com.baidu.mapclient.liteapp.routeresult.PreferItemsAdapter.ClickPreferListener
    public void onClickPrefer(int i) {
        this.currentPrefer = i;
        this.mItemsAdapter.updatePrefer(i);
        this.mItemsAdapter.notifyDataSetChanged();
        this.mPopWindow.dismiss();
        this.mRlButton.setVisibility(8);
        routePlan();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ((NaviActivity) getActivity()).isRouteResultFragment = true;
        BaiduNaviManagerFactory.getRouteResultManager().onCreate(getActivity());
        View inflate = layoutInflater.inflate(R.layout.fragment_route_result, viewGroup, false);
        this.mRootView = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.route_0);
        this.mLayoutTab0 = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.mRootView.findViewById(R.id.route_1);
        this.mLayoutTab1 = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.mRootView.findViewById(R.id.route_2);
        this.mLayoutTab2 = linearLayout3;
        linearLayout3.setOnClickListener(this);
        this.mRlButton = (RelativeLayout) this.mRootView.findViewById(R.id.rl_button);
        this.mRecyclerView = (BNRecyclerView) this.mRootView.findViewById(R.id.rv);
        Button button = (Button) this.mRootView.findViewById(R.id.btn_prefer);
        this.mPreferBtn = button;
        button.setOnClickListener(this);
        this.mLDLayout = (LinearLayout) this.mRootView.findViewById(R.id.ld_container);
        this.mFlRetry = (FrameLayout) this.mRootView.findViewById(R.id.fl_retry);
        this.mRootView.findViewById(R.id.btn_road).setOnClickListener(this);
        this.mRootView.findViewById(R.id.btn_fullView).setOnClickListener(this);
        this.mRootView.findViewById(R.id.btn_start_navi).setOnClickListener(this);
        this.mRootView.findViewById(R.id.bank).setOnClickListener(this);
        View view = this.mRootView;
        int i = R.id.btn_start_navi2;
        view.findViewById(i).setOnClickListener(this);
        this.mRootView.findViewById(i).setVisibility(8);
        new LongDistanceController(this.mRootView);
        BaiduNaviManagerFactory.getRouteResultSettingManager().setRouteMargin(100, 100, 100, 500);
        initPreferPopWindow();
        initListener();
        routePlan();
        BaiduNaviManagerFactory.getRouteResultManager().showTruckLimitIcon(true);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mItemsAdapter.onDestroy();
        BaiduNaviManagerFactory.getRouteResultManager().onDestroy();
        ((NaviActivity) getActivity()).isRouteResultFragment = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BaiduNaviManagerFactory.getRouteResultManager().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mFlRetry.getVisibility() == 8) {
            initView();
        }
        BaiduNaviManagerFactory.getRouteResultManager().onResume();
        BaiduNaviManagerFactory.getRouteResultManager().addYellowTipsToContainer((FrameLayout) this.mRootView.findViewById(R.id.yb_container));
    }
}
