package com.baidu.navisdk.ui.widget.routesearchfilterview;

import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes8.dex */
public enum BNRouteNearbySearchUtils {
    INSTANCE;

    private static final int DELAY_TIME = 10000;
    private static final long ONE_HUNDRED_KILOMETERS = 100000;
    private static final String TAG = "BNRouteNearbySearchUtils";
    private f<String, String> queryTask;
    private long lastMilea = 0;
    private int times = 0;

    BNRouteNearbySearchUtils() {
        initTask();
    }

    public static /* synthetic */ int access$008(BNRouteNearbySearchUtils bNRouteNearbySearchUtils) {
        int i = bNRouteNearbySearchUtils.times;
        bNRouteNearbySearchUtils.times = i + 1;
        return i;
    }

    public static int getPoiViaPointNotificationIcon(int i, int i2) {
        LogUtil.e(TAG, "getPoiViaPointNotificationIcon: --> type: " + i + ", brandId: " + i2);
        int i3 = R.drawable.nsdk_notification_via_point;
        if (i != 0) {
            if (i != 7) {
                if (i == 8) {
                    return R.drawable.nsdk_notification_charge_station_default;
                }
                return i3;
            }
            if (i2 != 480) {
                if (i2 != 492) {
                    if (i2 != 534) {
                        if (i2 != 649) {
                            return R.drawable.nsdk_notification_bank_default;
                        }
                        return R.drawable.nsdk_notification_bank_gsyh;
                    }
                    return R.drawable.nsdk_notification_bank_nyyh;
                }
                return R.drawable.nsdk_notification_bank_zgyh;
            }
            return R.drawable.nsdk_notification_bank_jsyh;
        }
        if (i2 != 460) {
            if (i2 != 470) {
                return R.drawable.nsdk_notification_gas_station_default;
            }
            return R.drawable.nsdk_notification_gas_station_zsy;
        }
        return R.drawable.nsdk_notification_gas_station_zsh;
    }

    public static String getRouteAroundCategoryByStyleId(int i) {
        if (i == 71269) {
            return IBNRouteResultManager.NearbySearchKeyword.Spots;
        }
        switch (i) {
            case 71199:
            case 71203:
                return IBNRouteResultManager.NearbySearchKeyword.Charging_Station;
            case 71200:
                return IBNRouteResultManager.NearbySearchKeyword.Service;
            case 71201:
            case 71202:
            case 71204:
            case 71205:
            case 71206:
                return IBNRouteResultManager.NearbySearchKeyword.Gas_Station;
            default:
                return "";
        }
    }

    public static int getRouteAroundIconByStyleId(int i) {
        if (i != 71269) {
            switch (i) {
                case 71199:
                case 71203:
                    return R.drawable.nsdk_notification_around_charging_station;
                case 71200:
                    return R.drawable.nsdk_notification_around_service_area;
                case 71201:
                case 71202:
                case 71204:
                case 71205:
                case 71206:
                    return R.drawable.nsdk_notification_around_gas_station;
                default:
                    return R.drawable.nsdk_notification_via_point;
            }
        }
        return R.drawable.nsdk_notification_around_spots;
    }

    public static String getRouteAroundOpsTypeByStyleId(int i) {
        if (i == 71269) {
            return "4";
        }
        switch (i) {
            case 71199:
            case 71203:
                return "2";
            case 71200:
                return "1";
            case 71201:
            case 71202:
            case 71204:
            case 71205:
            case 71206:
                return "3";
            default:
                return "";
        }
    }

    private void initTask() {
        if (this.queryTask == null) {
            this.queryTask = new f<String, String>("queryTask-" + BNRouteNearbySearchUtils.class.getSimpleName(), null) { // from class: com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchUtils.1
                @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                public String execute() {
                    String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
                    if (currentUUID != null && currentUUID.length() > 0) {
                        long trajectoryLength = JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID);
                        if (BNRouteNearbySearchUtils.this.times == 0) {
                            BNRouteNearbySearchUtils.access$008(BNRouteNearbySearchUtils.this);
                            BNRouteNearbySearchUtils.this.lastMilea = trajectoryLength;
                        }
                        if (trajectoryLength - BNRouteNearbySearchUtils.this.lastMilea >= BNRouteNearbySearchUtils.ONE_HUNDRED_KILOMETERS) {
                            BNRouteNearbySearchUtils.this.lastMilea = trajectoryLength;
                            if (!BNRouteNearbySearchUtils.this.isOffLineMode() && b.M()) {
                                TTSPlayerControl.playTTS(JarUtils.getResources().getString(R.string.nsdk_string_route_search_charging_play_text), 0);
                            }
                        }
                    }
                    c.a().a((g) BNRouteNearbySearchUtils.this.queryTask, false);
                    c.a().a(BNRouteNearbySearchUtils.this.queryTask, new e(2, 0), 10000L);
                    return null;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOffLineMode() {
        if (a.c().a() == null || y.d(a.c().a())) {
            return true;
        }
        return BNRoutePlaner.getInstance().B();
    }

    public void startQuery() {
        this.lastMilea = 0L;
        this.times = 0;
        c.a().a(this.queryTask, new e(2, 0), 10000L);
    }

    public void stopQuery() {
        if (this.queryTask != null) {
            c.a().a((g) this.queryTask, false);
        }
        this.lastMilea = 0L;
        this.times = 0;
    }
}
