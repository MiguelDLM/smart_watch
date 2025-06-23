package com.baidu.mapclient.liteapp.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.IWRouteIconInfo;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapclient.liteapp.TurnTypeKt;
import com.baidu.mapclient.liteapp.activity.WalkNaviGuideActivity;
import com.baidu.mapclient.liteapp.listener.BleListener;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.blankj.utilcode.util.LogUtils;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleBWNaviInfo;
import com.szabh.smable3.entity.BleDeviceInfo;

/* loaded from: classes7.dex */
public class WalkNaviGuideActivity extends Activity {
    private WalkNavigateHelper mNaviHelper;
    private String TAG = "WKN";
    private int mState = 0;
    private int mTurnType = TurnTypeKt.bdWalkRouteGuideKindToTurnType(RouteGuideKind.NE_Maneuver_Kind_Front);
    private String mRemainDistance = "";
    private String mRemainTime = "";
    private String mRoadGuide = "";
    private boolean isEndFromDeivce = false;
    private BleHandleCallback mBleHandleCallback = new BleListener() { // from class: com.baidu.mapclient.liteapp.activity.WalkNaviGuideActivity.1
        @Override // com.baidu.mapclient.liteapp.listener.BleListener, com.szabh.smable3.component.BleHandleCallback
        public void onBWNaviInfoUpdate(@NonNull BleBWNaviInfo bleBWNaviInfo) {
            if (bleBWNaviInfo.getMState() == 4) {
                WalkNaviGuideActivity.this.isEndFromDeivce = true;
                WalkNaviGuideActivity.this.finish();
            } else if (bleBWNaviInfo.getMState() == 3) {
                WalkNaviGuideActivity.this.mNaviHelper.resume();
            } else if (bleBWNaviInfo.getMState() == 2) {
                WalkNaviGuideActivity.this.mNaviHelper.pause();
            }
        }
    };

    /* renamed from: com.baidu.mapclient.liteapp.activity.WalkNaviGuideActivity$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 implements IWRouteGuidanceListener {
        public AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRoadGuideTextUpdate$0() {
            WalkNaviGuideActivity.this.mState = 1;
            WalkNaviGuideActivity.this.sendNavInfo();
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onArriveDest() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(WalkNaviGuideActivity.this.TAG + " onArriveDest");
            WalkNaviGuideActivity.this.mState = 5;
            WalkNaviGuideActivity.this.sendNavInfo();
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onFinalEnd(Message message) {
            LogUtils.d("onFinalEnd:" + message);
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onGpsStatusChange(CharSequence charSequence, Drawable drawable) {
            LogUtils.d("onGpsStatusChange:" + ((Object) charSequence));
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onIndoorEnd(Message message) {
            LogUtils.d("onIndoorEnd:" + message);
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onReRouteComplete() {
            LogUtils.d("onReRouteComplete");
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRemainDistanceUpdate(CharSequence charSequence) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(WalkNaviGuideActivity.this.TAG + " onRemainDistanceUpdate:" + ((Object) charSequence));
            if (!TextUtils.isEmpty(charSequence)) {
                WalkNaviGuideActivity.this.mRemainDistance = charSequence.toString();
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRemainTimeUpdate(CharSequence charSequence) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(WalkNaviGuideActivity.this.TAG + " onRemainTimeUpdate:" + ((Object) charSequence));
            if (!TextUtils.isEmpty(charSequence)) {
                WalkNaviGuideActivity.this.mRemainTime = charSequence.toString();
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRoadGuideTextUpdate(CharSequence charSequence, CharSequence charSequence2) {
            WalkNaviGuideActivity.this.mRoadGuide = ((Object) charSequence) + "" + ((Object) charSequence2);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(WalkNaviGuideActivity.this.TAG + " onRoadGuideTextUpdate " + WalkNaviGuideActivity.this.mRoadGuide);
            if (WalkNaviGuideActivity.this.mState == 0) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.mapclient.liteapp.activity.x0XOIxOo
                    @Override // java.lang.Runnable
                    public final void run() {
                        WalkNaviGuideActivity.AnonymousClass3.this.lambda$onRoadGuideTextUpdate$0();
                    }
                }, 500L);
            } else if (WalkNaviGuideActivity.this.mState == 1) {
                WalkNaviGuideActivity.this.sendNavInfo();
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRouteFarAway(CharSequence charSequence, Drawable drawable) {
            LogUtils.d("onRouteFarAway: charSequence = :" + ((Object) charSequence));
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRouteGuideIconInfoUpdate(IWRouteIconInfo iWRouteIconInfo) {
            if (iWRouteIconInfo != null) {
                LogUtils.d("onRoadGuideTextUpdate   Drawable=: " + iWRouteIconInfo.getIconDrawable() + " Name=: " + iWRouteIconInfo.getIconName());
            }
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRouteGuideIconUpdate(Drawable drawable) {
            LogUtils.d("onRoadGuideTextUpdate Drawable=: " + drawable);
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRouteGuideKind(RouteGuideKind routeGuideKind) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(WalkNaviGuideActivity.this.TAG + " onRouteGuideKind: " + routeGuideKind);
            WalkNaviGuideActivity.this.mTurnType = TurnTypeKt.bdWalkRouteGuideKindToTurnType(routeGuideKind);
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onRoutePlanYawing(CharSequence charSequence, Drawable drawable) {
            LogUtils.d("onRoutePlanYawing: charSequence = :" + ((Object) charSequence));
        }

        @Override // com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener
        public void onVibrate() {
            LogUtils.d("onVibrate");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNavInfo() {
        BleConnector.INSTANCE.sendObject(BleKey.BW_NAVI_INFO, BleKeyFlag.UPDATE, new BleBWNaviInfo(this.mState, System.currentTimeMillis(), 0, 0, 0, this.mTurnType, this.mRemainTime, this.mRemainDistance, this.mRoadGuide), false, false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
        this.mNaviHelper = WalkNavigateHelper.getInstance();
        this.mNaviHelper.setWalkNaviDisplayOption(new WalkNaviDisplayOption().showImageToAr(false).showCalorieLayoutEnable(true).showLocationImage(true));
        try {
            View onCreate = this.mNaviHelper.onCreate(this);
            if (onCreate != null) {
                setContentView(onCreate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mNaviHelper.setWalkNaviStatusListener(new IWNaviStatusListener() { // from class: com.baidu.mapclient.liteapp.activity.WalkNaviGuideActivity.2
            @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
            public void onNaviExit() {
                LogUtils.d("onNaviExit");
            }

            @Override // com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener
            public void onWalkNaviModeChange(int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
                LogUtils.d("onWalkNaviModeChange : " + i);
                WalkNaviGuideActivity.this.mNaviHelper.switchWalkNaviMode(WalkNaviGuideActivity.this, i, walkNaviModeSwitchListener);
            }
        });
        LogUtils.d("startWalkNavi result : " + this.mNaviHelper.startWalkNavi(this));
        this.mNaviHelper.setRouteGuidanceListener(this, new AnonymousClass3());
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
    public void onPause() {
        super.onPause();
        this.mNaviHelper.pause();
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
