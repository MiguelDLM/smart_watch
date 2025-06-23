package com.alimm.tanx.core.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.net.constant.NetWorkType;

/* loaded from: classes.dex */
public class NetWorkUtil implements NotConfused {
    private static final BroadcastReceiver Receiver = new BroadcastReceiver() { // from class: com.alimm.tanx.core.utils.NetWorkUtil.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() == 1) {
                        if (NetWorkUtil.listener != null) {
                            NetWorkUtil.listener.onWifiConnect();
                            return;
                        }
                        return;
                    } else if (activeNetworkInfo.getType() == 0) {
                        if (NetWorkUtil.listener != null) {
                            NetWorkUtil.listener.onMobileConnect();
                            return;
                        }
                        return;
                    } else {
                        if (NetWorkUtil.listener != null) {
                            NetWorkUtil.listener.onDisconnect();
                            return;
                        }
                        return;
                    }
                }
                if (NetWorkUtil.listener != null) {
                    NetWorkUtil.listener.onDisconnect();
                }
            }
        }
    };
    static final String TAG = "NetWorkUtil";
    private static NetStateChangeListener listener;

    /* loaded from: classes.dex */
    public interface NetStateChangeListener {
        void onDisconnect();

        void onMobileConnect();

        void onWifiConnect();
    }

    private NetWorkUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetWorkType getNetworkType(Context context) {
        NetWorkType netWorkType;
        NetWorkType netWorkType2 = NetWorkType.NETWORK_NO;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            if (activeNetworkInfo.getType() == 1) {
                return NetWorkType.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        netWorkType = NetWorkType.NETWORK_2G;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        netWorkType = NetWorkType.NETWORK_3G;
                        break;
                    case 13:
                    case 18:
                        netWorkType = NetWorkType.NETWORK_4G;
                        break;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            netWorkType = NetWorkType.NETWORK_UNKNOWN;
                            break;
                        } else {
                            netWorkType = NetWorkType.NETWORK_3G;
                            break;
                        }
                }
                return netWorkType;
            }
            return NetWorkType.NETWORK_UNKNOWN;
        }
        return netWorkType2;
    }

    public static int getOperatorType(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String simOperatorName = telephonyManager.getSimOperatorName();
        if (simOperatorName != null) {
            if (simOperatorName.equals("46000") || simOperatorName.equals("46002") || simOperatorName.equals("46007")) {
                return 1;
            }
            if (simOperatorName.equals("46001")) {
                return 2;
            }
            if (simOperatorName.equals("46003")) {
                return 3;
            }
            return 0;
        }
        try {
            String subscriberId = telephonyManager.getSubscriberId();
            if (subscriberId != null) {
                if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002") && !subscriberId.startsWith("46007")) {
                    if (subscriberId.startsWith("46001")) {
                        return 2;
                    }
                    if (subscriberId.startsWith("46003")) {
                        return 3;
                    }
                    return 0;
                }
                return 1;
            }
            return 0;
        } catch (Exception e) {
            LogUtils.e(e);
            return 0;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static void registerReceiver(NetStateChangeListener netStateChangeListener) {
        listener = netStateChangeListener;
        TanxCoreSdk.getApplication().getApplicationContext().registerReceiver(Receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void unRegisterReceiver() {
        try {
            TanxCoreSdk.getApplication().getApplicationContext().unregisterReceiver(Receiver);
        } catch (Exception e) {
            LogUtils.e(TAG, "网络注册监听——解除监听报错" + e);
        }
    }
}
