package com.baidu.mapclient.liteapp.routeresult;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapclient.liteapp.BNUtils;
import com.baidu.mapclient.liteapp.NavImageManager;
import com.baidu.mapclient.liteapp.NavType;
import com.baidu.mapclient.liteapp.TranslateUtils;
import com.baidu.mapclient.liteapp.activity.NaviActivity;
import com.baidu.mapclient.liteapp.listener.BleListener;
import com.baidu.mapclient.liteapp.routeresult.CarNaviGuideFragment;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.baidu.navisdk.adapter.IBNRouteGuideManager;
import com.baidu.navisdk.adapter.IBNaviListener;
import com.baidu.navisdk.adapter.struct.BNGuideConfig;
import com.baidu.navisdk.adapter.struct.BNaviInfo;
import com.blankj.utilcode.util.LogUtils;
import com.facebook.login.widget.ToolTipPopup;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleNaviInfo;
import com.szabh.smable3.entity.Languages;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes7.dex */
public class CarNaviGuideFragment extends Fragment {
    private NavImageManager mNavImageManager;
    private int mState = 0;
    private int mTurnType = 0;
    private int mRemainDistance = 0;
    private int mRemainTime = 0;
    private int mDistance = 0;
    private int mSpeed = 10;
    private int mMode = 0;
    private String mRoadName = "";
    private boolean isEndFromDeivce = false;
    private BleHandleCallback mBleHandleCallback = new BleListener() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviGuideFragment.1
        @Override // com.baidu.mapclient.liteapp.listener.BleListener, com.szabh.smable3.component.BleHandleCallback
        public void onNaviInfoUpdate(@NonNull BleNaviInfo bleNaviInfo) {
            if (bleNaviInfo.getMState() == 4) {
                CarNaviGuideFragment.this.isEndFromDeivce = true;
                CarNaviGuideFragment.this.getActivity().getSupportFragmentManager().popBackStack();
            } else if (bleNaviInfo.getMState() == 3) {
                BaiduNaviManagerFactory.getRouteGuideManager().resumeRouteGuide();
            } else if (bleNaviInfo.getMState() == 2) {
                BaiduNaviManagerFactory.getRouteGuideManager().pauseRouteGuide();
            }
        }
    };
    private HashMap<String, String> roadMap = new HashMap<>();

    /* renamed from: com.baidu.mapclient.liteapp.routeresult.CarNaviGuideFragment$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 extends IBNaviListener {
        public AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSpeedUpdate$0() {
            CarNaviGuideFragment.this.mState = 1;
            CarNaviGuideFragment.this.sendNavInfo();
        }

        @Override // com.baidu.navisdk.adapter.IBNaviListener
        public void onGuideInfoUpdate(BNaviInfo bNaviInfo) {
            if (!((NaviActivity) CarNaviGuideFragment.this.getActivity()).isRealnavi) {
                CarNaviGuideFragment.this.mSpeed = new Random().nextInt(10) + 5;
            }
            CarNaviGuideFragment.this.mState = 1;
            CarNaviGuideFragment.this.mDistance = bNaviInfo.getDistance();
            CarNaviGuideFragment carNaviGuideFragment = CarNaviGuideFragment.this;
            carNaviGuideFragment.mRoadName = carNaviGuideFragment.getCacheRoad(bNaviInfo.getRoadName());
            CarNaviGuideFragment.this.mTurnType = BleNaviInfo.Companion.bdTurnIconNameToType(bNaviInfo.turnIconName);
            CarNaviGuideFragment.this.sendNavInfo();
            LogUtils.d("onGuideInfoUpdate -> " + bNaviInfo.turnIconName + ", " + bNaviInfo + ", " + CarNaviGuideFragment.this.mRoadName);
        }

        @Override // com.baidu.navisdk.adapter.IBNaviListener
        public void onNaviGuideEnd() {
            try {
                CarNaviGuideFragment.this.getActivity().getSupportFragmentManager().popBackStack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNaviListener
        public void onRemainInfoUpdate(int i, int i2) {
            LogUtils.d("onRemainInfoUpdate -> " + i + "," + i2);
            CarNaviGuideFragment.this.mRemainDistance = i;
            CarNaviGuideFragment.this.mRemainTime = i2;
        }

        @Override // com.baidu.navisdk.adapter.IBNaviListener
        public void onRoadNameUpdate(String str) {
            LogUtils.d("onRoadNameUpdate -> " + str);
        }

        @Override // com.baidu.navisdk.adapter.IBNaviListener
        public void onSpeedUpdate(int i, int i2) {
            LogUtils.d("onSpeedUpdate -> " + i + "," + i2);
            CarNaviGuideFragment.this.mSpeed = i;
            if (CarNaviGuideFragment.this.mMode == 1) {
                if (CarNaviGuideFragment.this.mState == 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.mapclient.liteapp.routeresult.oIX0oI
                        @Override // java.lang.Runnable
                        public final void run() {
                            CarNaviGuideFragment.AnonymousClass3.this.lambda$onSpeedUpdate$0();
                        }
                    }, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                } else if (CarNaviGuideFragment.this.mState == 1) {
                    CarNaviGuideFragment.this.sendNavInfo();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheRoad(final String str) {
        if (!getResources().getConfiguration().locale.getLanguage().equalsIgnoreCase(Languages.DEFAULT_LANGUAGE_ZH)) {
            if (this.roadMap.containsKey(str)) {
                return this.roadMap.get(str);
            }
            TranslateUtils.INSTANCE.trans(str, new TranslateUtils.TransCallback() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviGuideFragment.4
                @Override // com.baidu.mapclient.liteapp.TranslateUtils.TransCallback
                public void onError(@NonNull String str2) {
                }

                @Override // com.baidu.mapclient.liteapp.TranslateUtils.TransCallback
                public void onSuccess(@NonNull String str2) {
                    CarNaviGuideFragment.this.roadMap.put(str, str2);
                }
            });
            return "Unnamed Road";
        }
        return str;
    }

    private void initListener() {
        BaiduNaviManagerFactory.getRouteGuideManager().setNaviListener(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNavInfo() {
        if (this.mRoadName == null) {
            this.mRoadName = "";
        }
        if (this.mMode == 1 && NavImageManager.Companion.isSupportNavImage() && this.mState == 1) {
            BaiduMap map = BaiduNaviManagerFactory.getMapManager().getMapView().getMap();
            if (map != null) {
                this.mNavImageManager.sendNavImage(map, this.mRoadName, NavType.CAR);
                return;
            }
            return;
        }
        BleConnector.INSTANCE.sendObject(BleKey.NAVI_INFO, BleKeyFlag.UPDATE, new BleNaviInfo(this.mState, System.currentTimeMillis(), this.mTurnType, this.mRemainDistance, this.mRemainTime, this.mDistance, this.mSpeed, this.mMode, this.mRoadName), false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        BaiduNaviManagerFactory.getRouteGuideManager().onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        BaiduNaviManagerFactory.getRouteGuideManager().onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
        int i = 1;
        ((NaviActivity) getActivity()).isGuideFragment = true;
        ((NaviActivity) getActivity()).hideContainer();
        this.mNavImageManager = new NavImageManager();
        if (BNUtils.getInt(getActivity(), BNUtils.KEY_GUIDE_MODE) == 1) {
            i = 0;
        }
        this.mMode = i;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("mode -> " + this.mMode);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(BNaviCommonParams.ProGuideKey.IS_REALNAVI, ((NaviActivity) getActivity()).isRealnavi);
        bundle2.putBoolean(BNaviCommonParams.ProGuideKey.ADD_MAP, false);
        if (this.mMode == 1) {
            naviAddViewCallback = new IBNRouteGuideManager.NaviAddViewCallback() { // from class: com.baidu.mapclient.liteapp.routeresult.CarNaviGuideFragment.2
                @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager.NaviAddViewCallback
                public View getAddedView() {
                    TextView textView = new TextView(CarNaviGuideFragment.this.getActivity());
                    textView.setBackgroundColor(Color.parseColor("#ffff00"));
                    textView.setText("请勿锁屏，否则将会影响手表的地图数据");
                    textView.setGravity(17);
                    textView.setTextColor(Color.parseColor("#000000"));
                    textView.setLayoutParams(new FrameLayout.LayoutParams(-1, getViewHeight()));
                    return textView;
                }

                @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager.NaviAddViewCallback
                public int getViewHeight() {
                    return 100;
                }
            };
        } else {
            naviAddViewCallback = null;
        }
        BNGuideConfig build = new BNGuideConfig.Builder().params(bundle2).addBelowBottomView(naviAddViewCallback).build();
        initListener();
        return BaiduNaviManagerFactory.getRouteGuideManager().onCreate(getActivity(), build);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((NaviActivity) getActivity()).isGuideFragment = false;
        ((NaviActivity) getActivity()).showControl();
        BaiduNaviManagerFactory.getRouteGuideManager().onDestroy(false);
        this.mNavImageManager.destroy();
        if (!this.isEndFromDeivce || BleCache.INSTANCE.getMPlatform().equals(BleDeviceInfo.PLATFORM_JL)) {
            this.mState = 4;
            sendNavInfo();
        }
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BaiduNaviManagerFactory.getRouteGuideManager().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BaiduNaviManagerFactory.getRouteGuideManager().onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BaiduNaviManagerFactory.getRouteGuideManager().onStart();
        this.mState = 0;
        sendNavInfo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        BaiduNaviManagerFactory.getRouteGuideManager().onStop();
    }
}
