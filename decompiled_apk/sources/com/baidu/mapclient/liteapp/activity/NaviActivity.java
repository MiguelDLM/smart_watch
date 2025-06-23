package com.baidu.mapclient.liteapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.bikenavi.BikeNavigateHelper;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.bikenavi.params.BikeRouteNodeInfo;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.mapapi.walknavi.params.WalkRouteNodeInfo;
import com.baidu.mapclient.liteapp.BNUtils;
import com.baidu.mapclient.liteapp.NavImageManager;
import com.baidu.mapclient.liteapp.NavType;
import com.baidu.mapclient.liteapp.pop.PickerPopup2;
import com.baidu.mapclient.liteapp.routeresult.CarNaviRouteResultFragment;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.szabh.navi.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class NaviActivity extends FragmentActivity {
    private View btnDelete;
    private View btnLocation;
    private View btnSearch;
    private View btnSearchBack;
    private TextView btnStart;
    private View controlContainer;
    private TextView etEnd;
    private EditText etSearch;
    private TextView etStart;
    private View layoutStart;
    private BaiduMap mBaiduMap;
    private BikeNaviLaunchParam mBikeParam;
    private GeoCoder mCoder;
    private Marker mEndMarker;
    private LocationClient mLocClient;
    private MapView mMapView;
    private Marker mStartMarker;
    private WalkNaviLaunchParam mWalkParam;
    private MyLocationData myLocationData;
    private View searchContainer;
    private ListView sugListView;
    private View sugPanel;
    private TabLayout table;
    public boolean isRouteResultFragment = false;
    public boolean isGuideFragment = false;
    public boolean isRealnavi = false;
    private boolean isWalkAndBike = false;
    private SuggestionSearch mSuggestionSearch = null;
    private Map<String, String> startPt = null;
    private Map<String, String> endPt = null;
    private String mCurCity = "北京";
    private PointType pointType = PointType.START_POINT;
    private NavType navType = NavType.CAR;
    private boolean isFirstLoc = true;
    private MyLocationListener myListener = new MyLocationListener();
    private BitmapDescriptor bdStart = BitmapDescriptorFactory.fromResource(R.drawable.bnav_icon_start);
    private BitmapDescriptor bdEnd = BitmapDescriptorFactory.fromResource(R.drawable.bnav_icon_end);

    /* renamed from: com.baidu.mapclient.liteapp.activity.NaviActivity$8, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$mapclient$liteapp$NavType;

        static {
            int[] iArr = new int[NavType.values().length];
            $SwitchMap$com$baidu$mapclient$liteapp$NavType = iArr;
            try {
                iArr[NavType.CAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mapclient$liteapp$NavType[NavType.WALK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$mapclient$liteapp$NavType[NavType.BIKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class MyLocationListener implements BDLocationListener {
        public MyLocationListener() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation != null && NaviActivity.this.mMapView != null) {
                NaviActivity.this.myLocationData = new MyLocationData.Builder().accuracy(bDLocation.getRadius()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).build();
                if (NaviActivity.this.isFirstLoc) {
                    NaviActivity.this.isFirstLoc = false;
                    NaviActivity.this.mBaiduMap.setMyLocationData(NaviActivity.this.myLocationData);
                    LatLng latLng = new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude());
                    MapStatus.Builder builder = new MapStatus.Builder();
                    builder.target(latLng).zoom(14.0f);
                    NaviActivity.this.mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                    String str = bDLocation.getLongitude() + "," + bDLocation.getLatitude();
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("MyLocation ->" + bDLocation.getAddrStr() + ", pt:" + str);
                    if (!TextUtils.isEmpty(bDLocation.getCity())) {
                        NaviActivity.this.mCurCity = bDLocation.getCity();
                    }
                    if (NaviActivity.this.startPt == null) {
                        String string = NaviActivity.this.getString(R.string.my_point);
                        NaviActivity.this.startPt = new HashMap();
                        NaviActivity.this.startPt.put("pt", str);
                        NaviActivity.this.startPt.put("key", string);
                        NaviActivity.this.etStart.setText(string);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum PointType {
        START_POINT,
        END_POINT
    }

    private Marker addMarker(LatLng latLng, BitmapDescriptor bitmapDescriptor, int i) {
        return (Marker) this.mBaiduMap.addOverlay(new MarkerOptions().position(latLng).icon(bitmapDescriptor).zIndex(i));
    }

    private LatLng getLatFromPt(Map<String, String> map) {
        String[] split = map.get("pt").split(",");
        return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private void initControl() {
        this.layoutStart = findViewById(R.id.layout_start);
        TextView textView = (TextView) findViewById(R.id.btn_start);
        this.btnStart = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initControl$2(view);
            }
        });
        this.btnStart.setText(R.string.route);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.table);
        this.table = tabLayout;
        if (!this.isWalkAndBike) {
            tabLayout.setVisibility(8);
        }
        this.table.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position != 0) {
                    if (position != 1) {
                        if (position == 2) {
                            NaviActivity.this.navType = NavType.BIKE;
                            NaviActivity.this.btnStart.setText(R.string.start_nav);
                            return;
                        }
                        return;
                    }
                    NaviActivity.this.navType = NavType.WALK;
                    NaviActivity.this.btnStart.setText(R.string.start_nav);
                    return;
                }
                NaviActivity.this.navType = NavType.CAR;
                NaviActivity.this.btnStart.setText(R.string.route);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        this.controlContainer = findViewById(R.id.control_container);
        TextView textView2 = (TextView) findViewById(R.id.et_start);
        this.etStart = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.II0XooXoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initControl$3(view);
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.et_end);
        this.etEnd = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.xxIXOIIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initControl$4(view);
            }
        });
    }

    private void initMap() {
        BaiduNaviManagerFactory.getMapManager().attach((ViewGroup) findViewById(R.id.map_container));
        MapView mapView = BaiduNaviManagerFactory.getMapManager().getMapView();
        this.mMapView = mapView;
        BaiduMap map = mapView.getMap();
        this.mBaiduMap = map;
        map.setOnMapLongClickListener(new BaiduMap.OnMapLongClickListener() { // from class: com.baidu.mapclient.liteapp.activity.I0Io
            @Override // com.baidu.mapapi.map.BaiduMap.OnMapLongClickListener
            public final void onMapLongClick(LatLng latLng) {
                NaviActivity.this.lambda$initMap$0(latLng);
            }
        });
        this.mCoder = GeoCoder.newInstance();
        this.mBaiduMap.setMyLocationEnabled(true);
    }

    private void initSearch() {
        this.searchContainer = findViewById(R.id.search_container);
        View findViewById = findViewById(R.id.iv_search_back);
        this.btnSearchBack = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.OOXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initSearch$5(view);
            }
        });
        View findViewById2 = findViewById(R.id.iv_delete);
        this.btnDelete = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initSearch$6(view);
            }
        });
        View findViewById3 = findViewById(R.id.tv_search);
        this.btnSearch = findViewById3;
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.ooOOo0oXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initSearch$7(view);
            }
        });
        EditText editText = (EditText) findViewById(R.id.et_search);
        this.etSearch = editText;
        editText.setFocusableInTouchMode(true);
        View findViewById4 = findViewById(R.id.sug_panel);
        this.sugPanel = findViewById4;
        findViewById4.setVisibility(8);
        this.sugListView = (ListView) findViewById(R.id.sug_list);
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NaviActivity.this.sugPanel.setVisibility(8);
                if (charSequence.length() > 0 && !TextUtils.isEmpty(NaviActivity.this.mCurCity)) {
                    NaviActivity.this.sugPanel.setVisibility(0);
                    NaviActivity.this.mSuggestionSearch.requestSuggestion(new SuggestionSearchOption().keyword(charSequence.toString()).city(NaviActivity.this.mCurCity));
                }
            }
        });
        SuggestionSearch newInstance = SuggestionSearch.newInstance();
        this.mSuggestionSearch = newInstance;
        newInstance.setOnGetSuggestionResultListener(new OnGetSuggestionResultListener() { // from class: com.baidu.mapclient.liteapp.activity.oxoX
            @Override // com.baidu.mapapi.search.sug.OnGetSuggestionResultListener
            public final void onGetSuggestionResult(SuggestionResult suggestionResult) {
                NaviActivity.this.lambda$initSearch$9(suggestionResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initControl$2(View view) {
        if (NavImageManager.Companion.isSupportNavImage() && this.navType == NavType.CAR) {
            showNavGuidePop();
        } else {
            BNUtils.setInt(this, BNUtils.KEY_GUIDE_MODE, 1);
            toStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initControl$3(View view) {
        this.etSearch.setText("");
        this.etSearch.setHint(R.string.start_point);
        showSearch();
        this.pointType = PointType.START_POINT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initControl$4(View view) {
        this.etSearch.setText("");
        this.etSearch.setHint(R.string.end_point);
        showSearch();
        this.pointType = PointType.END_POINT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLocation$1(View view) {
        this.isFirstLoc = true;
        setMylocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMap$0(final LatLng latLng) {
        if (this.isGuideFragment) {
            return;
        }
        this.mCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.1
            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
            }

            @Override // com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult != null && reverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    String address = reverseGeoCodeResult.getAddress();
                    LogUtils.d("MyLocation =>" + address);
                    if (NaviActivity.this.startPt == null) {
                        NaviActivity.this.startPt = new HashMap();
                        NaviActivity.this.startPt.put("pt", latLng.longitude + "," + latLng.latitude);
                        NaviActivity.this.startPt.put("key", address);
                        NaviActivity.this.etStart.setText(address);
                    } else {
                        NaviActivity.this.endPt = new HashMap();
                        NaviActivity.this.endPt.put("pt", latLng.longitude + "," + latLng.latitude);
                        NaviActivity.this.endPt.put("key", address);
                        NaviActivity.this.etEnd.setText(address);
                    }
                    NaviActivity.this.showStart();
                }
            }
        });
        this.mCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).newVersion(1).radius(500));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearch$5(View view) {
        KeyboardUtils.hideSoftInput(this);
        showControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearch$6(View view) {
        this.etSearch.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearch$7(View view) {
        String obj = this.etSearch.getText().toString();
        if (!TextUtils.isEmpty(this.mCurCity) && !TextUtils.isEmpty(obj)) {
            this.sugPanel.setVisibility(0);
            this.mSuggestionSearch.requestSuggestion(new SuggestionSearchOption().keyword(obj).city(this.mCurCity));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearch$8(List list, AdapterView adapterView, View view, int i, long j) {
        Map<String, String> map = (Map) list.get(i);
        String str = map.get("key");
        if (this.pointType.ordinal() != 0) {
            this.endPt = map;
            this.etEnd.setText(str);
        } else {
            this.startPt = map;
            this.etStart.setText(str);
        }
        showControl();
        showStart();
        KeyboardUtils.hideSoftInput(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearch$9(SuggestionResult suggestionResult) {
        LogUtils.d("setOnGetSuggestionResultListener -> " + suggestionResult);
        if (suggestionResult != null && suggestionResult.getAllSuggestions() != null) {
            final ArrayList arrayList = new ArrayList();
            for (SuggestionResult.SuggestionInfo suggestionInfo : suggestionResult.getAllSuggestions()) {
                if (suggestionInfo.getKey() != null && suggestionInfo.getDistrict() != null && suggestionInfo.getCity() != null && suggestionInfo.getPt() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("key", suggestionInfo.getKey());
                    hashMap.put("city", suggestionInfo.getCity());
                    hashMap.put("dis", suggestionInfo.getDistrict());
                    hashMap.put("pt", suggestionInfo.pt.longitude + "," + suggestionInfo.pt.latitude);
                    arrayList.add(hashMap);
                }
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), arrayList, R.layout.item_layout, new String[]{"key", "city", "dis"}, new int[]{R.id.sug_key, R.id.sug_city, R.id.sug_dis});
            this.sugListView.setAdapter((ListAdapter) simpleAdapter);
            this.sugListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.mapclient.liteapp.activity.XO
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    NaviActivity.this.lambda$initSearch$8(arrayList, adapterView, view, i, j);
                }
            });
            simpleAdapter.notifyDataSetChanged();
            return;
        }
        this.sugListView.setEmptyView(findViewById(R.id.tv_sug_empty));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showNavGuidePop$10(int i) {
        BNUtils.setInt(this, BNUtils.KEY_GUIDE_MODE, i);
        toStart();
        return true;
    }

    private void removeMarker(Marker marker) {
        if (marker != null) {
            marker.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void routePlanWithBikeParam() {
        BikeNavigateHelper.getInstance().routePlanWithRouteNode(this.mBikeParam, new IBRoutePlanListener() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.6
            @Override // com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener
            public void onRoutePlanFail(BikeRoutePlanError bikeRoutePlanError) {
                LogUtils.d("BikeNavi onRoutePlanFail " + bikeRoutePlanError);
                String obj = bikeRoutePlanError.toString();
                if (bikeRoutePlanError == BikeRoutePlanError.DISTANCE_MORE_THAN) {
                    obj = "距离太长";
                }
                ToastUtils.showLong("骑行行路线计算出错，" + obj);
            }

            @Override // com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener
            public void onRoutePlanStart() {
                LogUtils.d("BikeNavi onRoutePlanStart");
            }

            @Override // com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener
            public void onRoutePlanSuccess() {
                LogUtils.d("BikeNavi onRoutePlanSuccess");
                Intent intent = new Intent();
                intent.setClass(NaviActivity.this, BikeNaviGuideActivity.class);
                NaviActivity.this.startActivity(intent);
                NaviActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void routePlanWithWalkParam() {
        WalkNavigateHelper.getInstance().routePlanWithRouteNode(this.mWalkParam, new IWRoutePlanListener() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.7
            @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
            public void onRoutePlanFail(WalkRoutePlanError walkRoutePlanError) {
                LogUtils.d("WalkNavi onRoutePlanFail " + walkRoutePlanError);
                String obj = walkRoutePlanError.toString();
                if (walkRoutePlanError == WalkRoutePlanError.DISTANCE_LESS_THAN_30M) {
                    obj = "距离不少于30米";
                } else if (walkRoutePlanError == WalkRoutePlanError.DISTANCE_MORE_THAN_50KM) {
                    obj = "距离超过50公里";
                }
                ToastUtils.showLong("步行路线计算出错，" + obj);
            }

            @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
            public void onRoutePlanStart() {
                LogUtils.d("WalkNavi onRoutePlanStart");
            }

            @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
            public void onRoutePlanSuccess() {
                LogUtils.d("onRoutePlanSuccess");
                Intent intent = new Intent();
                intent.setClass(NaviActivity.this, WalkNaviGuideActivity.class);
                NaviActivity.this.startActivity(intent);
                NaviActivity.this.finish();
            }
        });
    }

    private void setMylocation() {
        try {
            this.mBaiduMap.setMyLocationEnabled(true);
            LocationClient.setAgreePrivacy(true);
            LocationClient locationClient = new LocationClient(this);
            this.mLocClient = locationClient;
            locationClient.registerLocationListener(this.myListener);
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setIsNeedAddress(true);
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType("bd09ll");
            locationClientOption.setScanSpan(1000);
            this.mLocClient.setLocOption(locationClientOption);
            this.mLocClient.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showStart() {
        removeMarker(this.mStartMarker);
        removeMarker(this.mEndMarker);
        if (this.isRouteResultFragment) {
            BNUtils.setInt(this, BNUtils.KEY_GUIDE_MODE, 1);
            toStart();
            return;
        }
        this.layoutStart.setVisibility(0);
        Map<String, String> map = this.startPt;
        if (map != null) {
            this.mStartMarker = addMarker(getLatFromPt(map), this.bdStart, 9);
        }
        Map<String, String> map2 = this.endPt;
        if (map2 != null) {
            this.mEndMarker = addMarker(getLatFromPt(map2), this.bdEnd, 5);
        }
    }

    private void startBikeNavi() {
        LogUtils.d("startBikeNavi");
        try {
            if (BikeNavigateHelper.getInstance().isInitEngine()) {
                LogUtils.d("BikeNavi engineInitSuccess");
                routePlanWithBikeParam();
            } else {
                BikeNavigateHelper.getInstance().initNaviEngine(this, new IBEngineInitListener() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.4
                    @Override // com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener
                    public void engineInitFail() {
                        LogUtils.d("BikeNavi engineInitFail");
                        BikeNavigateHelper.getInstance().unInitNaviEngine();
                        ToastUtils.showLong("BikeNavi engineInitFail");
                    }

                    @Override // com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener
                    public void engineInitSuccess() {
                        LogUtils.d("BikeNavi engineInitSuccess");
                        NaviActivity.this.routePlanWithBikeParam();
                    }
                });
            }
        } catch (Exception e) {
            LogUtils.d("startBikeNavi Exception");
            e.printStackTrace();
        }
    }

    private void startCarNavi() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStack();
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(R.id.fragment_content, new CarNaviRouteResultFragment(), "RouteResult");
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    private void startWalkNavi() {
        LogUtils.d("startWalkNavi");
        try {
            if (WalkNavigateHelper.getInstance().isInitEngine()) {
                LogUtils.d("WalkNavi engineInitSuccess");
                routePlanWithWalkParam();
            } else {
                WalkNavigateHelper.getInstance().initNaviEngine(this, new IWEngineInitListener() { // from class: com.baidu.mapclient.liteapp.activity.NaviActivity.5
                    @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
                    public void engineInitFail() {
                        LogUtils.d("WalkNavi engineInitFail");
                        WalkNavigateHelper.getInstance().unInitNaviEngine();
                        ToastUtils.showLong("WalkNavi engineInitFail");
                    }

                    @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
                    public void engineInitSuccess() {
                        LogUtils.d("WalkNavi engineInitSuccess");
                        NaviActivity.this.routePlanWithWalkParam();
                    }
                });
            }
        } catch (Exception e) {
            LogUtils.d("startBikeNavi Exception");
            e.printStackTrace();
        }
    }

    private void toStart() {
        Map<String, String> map = this.startPt;
        if (map == null) {
            ToastUtils.showLong(R.string.input_start_point_tip);
            return;
        }
        if (this.endPt == null) {
            ToastUtils.showLong(R.string.input_end_point_tip);
            return;
        }
        BNUtils.setString(this, "start_node", map.get("pt"));
        BNUtils.setString(this, "end_node", this.endPt.get("pt"));
        LatLng latFromPt = getLatFromPt(this.startPt);
        LatLng latFromPt2 = getLatFromPt(this.endPt);
        int i = AnonymousClass8.$SwitchMap$com$baidu$mapclient$liteapp$NavType[this.navType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    BikeRouteNodeInfo bikeRouteNodeInfo = new BikeRouteNodeInfo();
                    bikeRouteNodeInfo.setLocation(latFromPt);
                    BikeRouteNodeInfo bikeRouteNodeInfo2 = new BikeRouteNodeInfo();
                    bikeRouteNodeInfo2.setLocation(latFromPt2);
                    this.mBikeParam = new BikeNaviLaunchParam().startNodeInfo(bikeRouteNodeInfo).endNodeInfo(bikeRouteNodeInfo2);
                    startBikeNavi();
                    return;
                }
                return;
            }
            WalkRouteNodeInfo walkRouteNodeInfo = new WalkRouteNodeInfo();
            walkRouteNodeInfo.setLocation(latFromPt);
            WalkRouteNodeInfo walkRouteNodeInfo2 = new WalkRouteNodeInfo();
            walkRouteNodeInfo2.setLocation(latFromPt2);
            this.mWalkParam = new WalkNaviLaunchParam().startNodeInfo(walkRouteNodeInfo).endNodeInfo(walkRouteNodeInfo2);
            startWalkNavi();
            return;
        }
        showControl();
        this.table.setVisibility(8);
        this.layoutStart.setVisibility(8);
        startCarNavi();
    }

    public void hideContainer() {
        this.searchContainer.setVisibility(8);
        this.controlContainer.setVisibility(8);
    }

    public void initLocation() {
        View findViewById = findViewById(R.id.iv_location);
        this.btnLocation = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.activity.xoIox
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NaviActivity.this.lambda$initLocation$1(view);
            }
        });
        setMylocation();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isGuideFragment) {
            BaiduNaviManagerFactory.getRouteGuideManager().onBackPressed(false);
        } else if (this.searchContainer.getVisibility() == 0) {
            showControl();
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_navi);
        this.isWalkAndBike = getIntent().getBooleanExtra("isWalkAndBike", false);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("isWalkAndBike -> " + this.isWalkAndBike);
        try {
            initMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initLocation();
        initControl();
        initSearch();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mSuggestionSearch.destroy();
        LocationClient locationClient = this.mLocClient;
        if (locationClient != null) {
            locationClient.unRegisterLocationListener(this.myListener);
            this.mLocClient.stop();
            this.mLocClient = null;
        }
        removeMarker(this.mStartMarker);
        removeMarker(this.mEndMarker);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BaiduNaviManagerFactory.getMapManager().onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BaiduNaviManagerFactory.getMapManager().onResume();
    }

    public void showControl() {
        this.searchContainer.setVisibility(8);
        this.controlContainer.setVisibility(0);
    }

    public void showNavGuidePop() {
        PickerPopup2 pickerPopup2 = new PickerPopup2(this, (List<String>) Arrays.asList("地图模式", "文字模式"));
        pickerPopup2.getTvTitle().setText("同步至手表端的导航模式");
        pickerPopup2.setNoLoop(true);
        pickerPopup2.setMListener(new PickerPopup2.OnPickedListener() { // from class: com.baidu.mapclient.liteapp.activity.X0o0xo
            @Override // com.baidu.mapclient.liteapp.pop.PickerPopup2.OnPickedListener
            public final boolean invoke(int i) {
                boolean lambda$showNavGuidePop$10;
                lambda$showNavGuidePop$10 = NaviActivity.this.lambda$showNavGuidePop$10(i);
                return lambda$showNavGuidePop$10;
            }
        });
        pickerPopup2.setPicked(0);
        pickerPopup2.showAlignBottomContentView();
    }

    public void showSearch() {
        this.searchContainer.setVisibility(0);
        this.controlContainer.setVisibility(8);
    }
}
