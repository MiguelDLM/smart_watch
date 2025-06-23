package com.baidu.mapclient.liteapp.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.mapapi.bikenavi.BikeNavigateHelper;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.bikenavi.model.BikeRouteDetailInfo;
import com.baidu.mapapi.bikenavi.model.IBRouteIconInfo;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.mapclient.liteapp.TurnTypeKt;
import com.baidu.mapclient.liteapp.activity.BikeNaviGuideActivity;
import com.baidu.mapclient.liteapp.listener.BleListener;
import com.blankj.utilcode.util.LogUtils;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleBWNaviInfo;
import com.szabh.smable3.entity.BleDeviceInfo;

/* loaded from: classes7.dex */
public class BikeNaviGuideActivity extends Activity {
    private BikeNavigateHelper mNaviHelper;
    private String TAG = "BKN";
    private int mState = 0;
    private int mTurnType = TurnTypeKt.bdBikeRouteGuideKindToTurnType(RouteGuideKind.NE_Maneuver_Kind_Front);
    private String mRemainDistance = "";
    private String mRemainTime = "";
    private String mRoadGuide = "";
    private int mSpeed = 0;
    private int mAltitude = 0;
    private boolean isEndFromDeivce = false;
    private BleHandleCallback mBleHandleCallback = new BleListener() { // from class: com.baidu.mapclient.liteapp.activity.BikeNaviGuideActivity.1
        @Override // com.baidu.mapclient.liteapp.listener.BleListener, com.szabh.smable3.component.BleHandleCallback
        public void onBWNaviInfoUpdate(@NonNull BleBWNaviInfo bleBWNaviInfo) {
            if (bleBWNaviInfo.getMState() == 4) {
                BikeNaviGuideActivity.this.isEndFromDeivce = true;
                BikeNaviGuideActivity.this.finish();
            } else if (bleBWNaviInfo.getMState() == 3) {
                BikeNaviGuideActivity.this.mNaviHelper.resume();
            } else if (bleBWNaviInfo.getMState() == 2) {
                BikeNaviGuideActivity.this.mNaviHelper.pause();
            }
        }
    };

    /* renamed from: com.baidu.mapclient.liteapp.activity.BikeNaviGuideActivity$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass2 implements IBRouteGuidanceListener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRoadGuideTextUpdate$0() {
            BikeNaviGuideActivity.this.mState = 1;
            BikeNaviGuideActivity.this.sendNavInfo();
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onArriveDest() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BikeNaviGuideActivity.this.TAG + " onArriveDest");
            BikeNaviGuideActivity.this.mState = 5;
            BikeNaviGuideActivity.this.sendNavInfo();
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onGetRouteDetailInfo(BikeRouteDetailInfo bikeRouteDetailInfo) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BikeNaviGuideActivity.this.TAG + "onGetRouteDetailInfo  speed:" + bikeRouteDetailInfo.speed + ",avSpeed:" + bikeRouteDetailInfo.avSpeed + ",maxSpeed:" + bikeRouteDetailInfo.maxSpeed + ",altitude:" + bikeRouteDetailInfo.altitude + ",diffAltitude:" + bikeRouteDetailInfo.diffAltitude);
            BikeNaviGuideActivity.this.mSpeed = (int) bikeRouteDetailInfo.speed;
            BikeNaviGuideActivity.this.mAltitude = (int) bikeRouteDetailInfo.altitude;
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onGpsStatusChange(CharSequence charSequence, Drawable drawable) {
            LogUtils.d("onGpsStatusChange -> " + ((Object) charSequence));
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onReRouteComplete() {
            LogUtils.d("onReRouteComplete");
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRemainDistanceUpdate(CharSequence charSequence) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BikeNaviGuideActivity.this.TAG + " onRemainDistanceUpdate:" + ((Object) charSequence));
            if (!TextUtils.isEmpty(charSequence)) {
                BikeNaviGuideActivity.this.mRemainDistance = charSequence.toString();
            }
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRemainTimeUpdate(CharSequence charSequence) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BikeNaviGuideActivity.this.TAG + " onRemainTimeUpdate:" + ((Object) charSequence));
            if (!TextUtils.isEmpty(charSequence)) {
                BikeNaviGuideActivity.this.mRemainTime = charSequence.toString();
            }
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRoadGuideTextUpdate(CharSequence charSequence, CharSequence charSequence2) {
            BikeNaviGuideActivity.this.mRoadGuide = ((Object) charSequence) + "" + ((Object) charSequence2);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BikeNaviGuideActivity.this.TAG + " onRoadGuideTextUpdate " + BikeNaviGuideActivity.this.mRoadGuide);
            if (BikeNaviGuideActivity.this.mState == 0) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.mapclient.liteapp.activity.II0xO0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BikeNaviGuideActivity.AnonymousClass2.this.lambda$onRoadGuideTextUpdate$0();
                    }
                }, 500L);
            } else if (BikeNaviGuideActivity.this.mState == 1) {
                BikeNaviGuideActivity.this.sendNavInfo();
            }
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRouteFarAway(CharSequence charSequence, Drawable drawable) {
            LogUtils.d("onRouteFarAway: charSequence = :" + ((Object) charSequence));
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRouteGuideIconInfoUpdate(IBRouteIconInfo iBRouteIconInfo) {
            if (iBRouteIconInfo != null) {
                LogUtils.d("onRouteGuideIconInfoUpdate -> iconName：" + iBRouteIconInfo.getIconName());
            }
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRouteGuideIconUpdate(Drawable drawable) {
            LogUtils.d("onRouteGuideIconUpdate Drawable=: " + drawable);
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRouteGuideKind(RouteGuideKind routeGuideKind) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(BikeNaviGuideActivity.this.TAG + " onRouteGuideKind: " + routeGuideKind);
            BikeNaviGuideActivity.this.mTurnType = TurnTypeKt.bdBikeRouteGuideKindToTurnType(routeGuideKind);
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onRoutePlanYawing(CharSequence charSequence, Drawable drawable) {
            LogUtils.d("onRoutePlanYawing: charSequence = :" + ((Object) charSequence));
        }

        @Override // com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener
        public void onVibrate() {
            LogUtils.d("onVibrate");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$0() {
        LogUtils.d("onNaviExit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNavInfo() {
        BleConnector.INSTANCE.sendObject(BleKey.BW_NAVI_INFO, BleKeyFlag.UPDATE, new BleBWNaviInfo(this.mState, System.currentTimeMillis(), 1, this.mSpeed, this.mAltitude, this.mTurnType, this.mRemainTime, this.mRemainDistance, this.mRoadGuide), false, false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
        this.mNaviHelper = BikeNavigateHelper.getInstance();
        this.mNaviHelper.setBikeNaviDisplayOption(new BikeNaviDisplayOption().showSpeedLayout(true).showTopGuideLayout(true).showLocationImage(true));
        View onCreate = this.mNaviHelper.onCreate(this);
        if (onCreate != null) {
            setContentView(onCreate);
        }
        this.mNaviHelper.setBikeNaviStatusListener(new IBNaviStatusListener() { // from class: com.baidu.mapclient.liteapp.activity.oIX0oI
            @Override // com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener
            public final void onNaviExit() {
                BikeNaviGuideActivity.lambda$onCreate$0();
            }
        });
        this.mNaviHelper.startBikeNavi(this);
        this.mNaviHelper.setRouteGuidanceListener(this, new AnonymousClass2());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mNaviHelper.quit();
        if (!this.isEndFromDeivce || BleCache.INSTANCE.getMPlatform().equals(BleDeviceInfo.PLATFORM_JL)) {
            this.mState = 4;
            sendNavInfo();
        }
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mNaviHelper.resume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " navi start");
        this.mState = 0;
        sendNavInfo();
    }
}
