package com.baidu.datahub;

import XXO0.oIX0oI;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.datahub.HttpClient;
import com.baidu.datahub.protocol.IRequestListenerProtocol;
import com.baidu.datahub.protocol.OrderInfoProtocol;
import com.baidu.datahub.protocol.RoutePlanNodeProtocol;
import com.baidu.datahub.protocol.ShareETAInfoProtocol;
import com.baidu.datahub.protocol.ShareLocationInfoProtocol;
import com.baidu.datahub.protocol.ShareRouteInfoProtocol;
import com.baidu.datahub.protocol.SyncShareImpl;
import com.baidu.datahub.protocol.TokenInfoProtocol;
import com.baidu.datahub.protocol.WayPointInfoProtocol;
import com.baidu.mapapi.CoordType;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ShareLocationManager {
    private static final int CAR_POOL_PARENT_ORDER_STATUS = 10;
    private static final int DB_VERSION = 6;
    private static final String DEFAULT_PARENT_ORDER_ID = "-+~$#empty_parent_id#$~+-";
    private static final String ETA_PROTOCOL_V_SECOND = "v2";
    private static final String ETA_PROTOCOL_V_THIRD = "v3";
    private static final long MAX_ORDER = 50;
    private static final int MAX_RETRY_TIMES_NET_ERROR = 2;
    private static final int MAX_RETRY_TIMES_PART_REG_FAILED = 1;
    private static final int MAX_RETRY_TIMES_SERVER_ERROR = 1;
    private static final String TAG = "ShareLocationManager";
    private String mAuthToken;
    private BDCache mCache;
    private String mCuid;
    private SQLiteDatabase mDatabase;
    private NavigationType mNavigationType;
    private int mOrderType;
    private SyncShareImpl mShareManagerImpl;
    private ShareLocationHandler mShareLocationHandler = new ShareLocationHandler();
    private int mInterval = 2;
    private boolean mFirstInitTimer = false;
    private DataStatus mUploadStatus = DataStatus.ready;
    private BaseRequest mBaseRequest = new BaseRequest();
    private int mCountRegisterNetError = 0;
    private int mCountRegisterPartFailed = 0;
    private int mCountRegisterServerError = 0;
    private int mCountUpdateNetError = 0;
    private int mCountUpdateServerError = 0;
    private int mCountUpdateRouteInfoError = 0;
    private int mCountUpdateDriverStatusError = 0;
    private long mLastLocationChangeTime = 0;
    private long mLastUpdateLocResponseTime = 0;
    private int mLastUpdateLocationStatus = -1000;
    private boolean mIsStopSynServer = false;
    private boolean mIsOrderRegisted = false;
    private String mHashCode = "";
    private String mRouteID = null;
    private OrderInfoProtocol mParentOrderInfo = new OrderInfoProtocol();
    private final Set<String> mUnRegisterOrderSet = Collections.synchronizedSet(new HashSet());
    private Timer mUpdateInfoTimer = new Timer();
    private TimerTask mUpdateInfoTask = new TimerTask() { // from class: com.baidu.datahub.ShareLocationManager.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (DataStatus.process != ShareLocationManager.this.mUploadStatus) {
                ShareLocationManager.this.loadOrderInfo();
                ShareLocationManager.this.loadUpdateOrderInfo();
                ShareLocationManager shareLocationManager = ShareLocationManager.this;
                shareLocationManager.loadRouteInfo(shareLocationManager.getParentOrderId());
                ShareLocationManager shareLocationManager2 = ShareLocationManager.this;
                shareLocationManager2.updateLocationInfo(shareLocationManager2.mRouteID);
                ShareLocationManager.this.updateWayPointInfo();
            }
        }
    };

    /* renamed from: com.baidu.datahub.ShareLocationManager$11, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$mapapi$CoordType;

        static {
            int[] iArr = new int[CoordType.values().length];
            $SwitchMap$com$baidu$mapapi$CoordType = iArr;
            try {
                iArr[CoordType.GCJ02.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mapapi$CoordType[CoordType.BD09LL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum DataStatus {
        ready,
        success,
        error,
        process
    }

    /* loaded from: classes7.dex */
    public class ShareLocationHandler extends Handler {
        public ShareLocationHandler() {
        }

        private boolean handleLocationChange(Message message) {
            String str;
            if (message != null && message.obj != null) {
                if (ShareLocationManager.this.mIsStopSynServer) {
                    ShareLocationManager.this.mUpdateInfoTask.cancel();
                    ShareLocationManager.this.mUpdateInfoTimer.cancel();
                    return false;
                }
                if (!ShareLocationManager.this.mFirstInitTimer) {
                    ShareLocationManager.this.mUpdateInfoTimer.schedule(ShareLocationManager.this.mUpdateInfoTask, new Date(), ShareLocationManager.this.mInterval * 1000);
                    ShareLocationManager.this.mFirstInitTimer = true;
                }
                if (ShareLocationManager.this.isParentOrderInfoEmpty()) {
                    BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]: mParentOrderInfo is null");
                    return false;
                }
                ShareLocationInfoProtocol shareLocationInfoProtocol = (ShareLocationInfoProtocol) message.obj;
                if (shareLocationInfoProtocol == null) {
                    BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]: locationInfo is null");
                    return false;
                }
                if (ShareLocationManager.this.mParentOrderInfo.orderType == 0) {
                    BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]: BNOrderInfo.OrderType.NORMAL_ORDER == mParentOrderInfo.orderType");
                    List<? extends OrderInfoProtocol> list = shareLocationInfoProtocol.orderInfos;
                    if (list != null && list.size() > 0) {
                        OrderInfoProtocol orderInfoProtocol = shareLocationInfoProtocol.orderInfos.get(0);
                        if (orderInfoProtocol == null) {
                            BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]:orderInfo is null");
                            return false;
                        }
                        if (orderInfoProtocol.orderState != ShareLocationManager.this.mParentOrderInfo.orderState) {
                            BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]:orderState not match parent order");
                            return false;
                        }
                    } else {
                        BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]:locationInfo.orderInfos is empty");
                        return false;
                    }
                }
                ShareLocationInfo shareLocationInfo = new ShareLocationInfo();
                if (Math.abs(shareLocationInfoProtocol.gpsLatitude) <= 90.0d && Math.abs(shareLocationInfoProtocol.gpsLongitude) <= 180.0d && Math.abs(shareLocationInfoProtocol.postLatitude) <= 90.0d && Math.abs(shareLocationInfoProtocol.postLongitude) <= 180.0d) {
                    shareLocationInfo.setTimestamp(System.currentTimeMillis() / 1000);
                    shareLocationInfo.setInfo(shareLocationInfoProtocol);
                    ShareLocationManager.this.mCache.addLocationInfoToCache(shareLocationInfo);
                    String str2 = ((int) (shareLocationInfoProtocol.postLongitude * 100000.0d)) + "," + ((int) (shareLocationInfoProtocol.postLatitude * 100000.0d));
                    HashMap hashMap = new HashMap();
                    ShareLocationManager.this.generateRunAndRemainInfo(hashMap);
                    if (hashMap.containsKey("remain")) {
                        str = (String) hashMap.get("remain");
                    } else {
                        str = "";
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("w.1.7.5", str2);
                    hashMap2.put("w.1.7.3", str);
                    if (ShareLocationManager.this.mLastLocationChangeTime != 0) {
                        if (System.currentTimeMillis() - ShareLocationManager.this.mLastLocationChangeTime >= 60000) {
                            ShareLocationManager.this.mLastLocationChangeTime = System.currentTimeMillis();
                            ShareLocationManager.this.addUserOp(shareLocationInfoProtocol.orderInfos, hashMap2);
                        }
                    } else {
                        ShareLocationManager.this.mLastLocationChangeTime = System.currentTimeMillis();
                        ShareLocationManager.this.addUserOp(shareLocationInfoProtocol.orderInfos, hashMap2);
                    }
                    return true;
                }
                BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]: gps info invalid, gpsLatitude:" + shareLocationInfoProtocol.gpsLatitude + "gpsLongitude:" + shareLocationInfoProtocol.gpsLongitude + "postLatitude:" + shareLocationInfoProtocol.postLatitude + "postLongitude:" + shareLocationInfoProtocol.postLongitude);
                return false;
            }
            BDLog.e(ShareLocationManager.TAG, "[handleLocationChange]: msg is null");
            return false;
        }

        private void handleOrderUpdateImp(List<OrderInfoProtocol> list) {
            for (OrderInfoProtocol orderInfoProtocol : list) {
                if (orderInfoProtocol != null) {
                    ShareLocationManager.this.updateOrder(orderInfoProtocol);
                    if (ShareLocationManager.this.mShareManagerImpl != null) {
                        ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.2", orderInfoProtocol.getOrderId(), orderInfoProtocol.driverId, ShareLocationManager.this.mHashCode);
                    }
                }
            }
        }

        private boolean handleRegisterOrder(Message message) {
            Object obj;
            if (message != null && (obj = message.obj) != null) {
                return ShareLocationManager.this.registerOrder((List) obj);
            }
            BDLog.e(ShareLocationManager.TAG, "[handleRegisterOrder]: msg is null");
            return false;
        }

        private boolean handleRougeChanged(Message message) {
            if (message == null) {
                BDLog.e(ShareLocationManager.TAG, "[handleRougeChanged]: msg is null");
                return false;
            }
            ShareRouteInfoProtocol shareRouteInfoProtocol = (ShareRouteInfoProtocol) message.obj;
            if (shareRouteInfoProtocol != null) {
                ShareLocationManager.this.loadOrderInfo();
                ShareLocationManager.this.updateRoute(shareRouteInfoProtocol);
                ShareLocationManager.this.updateLocationInfo(shareRouteInfoProtocol.curRouteMD5);
                ShareLocationManager.this.updateWayPointInfo();
                HashMap hashMap = new HashMap();
                hashMap.put("w.1.7.4", shareRouteInfoProtocol.curRouteMD5);
                ShareLocationManager.this.addUserOp(shareRouteInfoProtocol.orderInfos, hashMap);
                return true;
            }
            BDLog.e(ShareLocationManager.TAG, "[handleRougeChanged]: routeInfo is null");
            return false;
        }

        private boolean handleTokenChanged(Message message) {
            Object obj = message.obj;
            if (obj == null) {
                BDLog.e(ShareLocationManager.TAG, "[handleTokenChanged]: msg is null");
                return false;
            }
            TokenInfoProtocol tokenInfoProtocol = (TokenInfoProtocol) obj;
            if (TextUtils.isEmpty(tokenInfoProtocol.token)) {
                return false;
            }
            ShareLocationManager.this.mAuthToken = tokenInfoProtocol.token;
            BDLog.d(ShareLocationManager.TAG, "orderId:" + tokenInfoProtocol.orderInfo.getOrderId() + "   orderState:" + tokenInfoProtocol.orderInfo.orderState);
            return true;
        }

        private boolean handleUpdateOrder(Message message) {
            Object obj;
            if (message != null && (obj = message.obj) != null) {
                List<OrderInfoProtocol> list = (List) obj;
                if (list.size() <= 0) {
                    BDLog.e(ShareLocationManager.TAG, "[handleUpdateOrder]: orderInfos is null");
                    return false;
                }
                updateParentOrderState(list.get(0));
                ShareLocationManager.this.loadOrderInfo();
                ShareLocationManager shareLocationManager = ShareLocationManager.this;
                shareLocationManager.loadRouteInfo(shareLocationManager.getParentOrderId());
                handleOrderUpdateImp(list);
                ShareLocationManager shareLocationManager2 = ShareLocationManager.this;
                shareLocationManager2.updateLocationInfo(shareLocationManager2.mRouteID);
                ShareLocationManager.this.updateWayPointInfo();
                return true;
            }
            BDLog.e(ShareLocationManager.TAG, "[handleUpdateOrder]: msg is null");
            return false;
        }

        private boolean handleUpdatePosUploadInterval(Message message) {
            if (message == null) {
                BDLog.e(ShareLocationManager.TAG, "[handleUpdatePosUploadInterval]: msg is null");
                return false;
            }
            int i = message.arg1;
            if (i > 0) {
                ShareLocationManager.this.mInterval = i;
                ShareLocationManager.this.mUpdateInfoTask.cancel();
                if (ShareLocationManager.this.mIsStopSynServer) {
                    ShareLocationManager.this.mUpdateInfoTimer.cancel();
                    BDLog.d(ShareLocationManager.TAG, "[handleUpdatePosUploadInterval]: cancel mUpdateInfoTimer");
                    return false;
                }
                ShareLocationManager.this.mUpdateInfoTask = new TimerTask() { // from class: com.baidu.datahub.ShareLocationManager.ShareLocationHandler.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (DataStatus.process != ShareLocationManager.this.mUploadStatus) {
                            ShareLocationManager.this.loadOrderInfo();
                            ShareLocationManager.this.loadUpdateOrderInfo();
                            ShareLocationManager shareLocationManager = ShareLocationManager.this;
                            shareLocationManager.loadRouteInfo(shareLocationManager.getParentOrderId());
                            ShareLocationManager shareLocationManager2 = ShareLocationManager.this;
                            shareLocationManager2.updateLocationInfo(shareLocationManager2.mRouteID);
                            ShareLocationManager.this.updateWayPointInfo();
                        }
                    }
                };
                ShareLocationManager.this.mUpdateInfoTimer.schedule(ShareLocationManager.this.mUpdateInfoTask, new Date(), ShareLocationManager.this.mInterval * 1000);
                ShareLocationManager.this.mFirstInitTimer = true;
                return true;
            }
            BDLog.e(ShareLocationManager.TAG, "[handleUpdatePosUploadInterval]: msg.arg1 <= 0");
            return false;
        }

        private boolean handlerWayPointStatusChanged(Message message) {
            String str;
            Object obj = message.obj;
            if (obj == null) {
                BDLog.e(ShareLocationManager.TAG, "[handleTokenChanged]: msg is null");
                return false;
            }
            List list = (List) obj;
            if (list.size() <= 0) {
                BDLog.e(ShareLocationManager.TAG, "[handlerDriverChanged]: wayPointInfos is null");
                return false;
            }
            if (!ShareLocationManager.this.isParentOrderInfoEmpty()) {
                str = ShareLocationManager.this.getParentOrderId();
            } else {
                str = "";
            }
            String generateWayPointsOrderSubSeq = ShareLocationManager.this.generateWayPointsOrderSubSeq(list, str, true);
            if (TextUtils.isEmpty(generateWayPointsOrderSubSeq)) {
                BDLog.e(ShareLocationManager.TAG, "generateWayPointsOrderSubSeq empty");
                return false;
            }
            String whetherToEncodeParameter = ShareLocationManager.this.whetherToEncodeParameter(generateWayPointsOrderSubSeq, true);
            if (!TextUtils.isEmpty(whetherToEncodeParameter)) {
                String generatePathPlanWayPointsOrderSubSeq = ShareLocationManager.this.generatePathPlanWayPointsOrderSubSeq(list, str, true);
                if (TextUtils.isEmpty(generatePathPlanWayPointsOrderSubSeq)) {
                    BDLog.e(ShareLocationManager.TAG, "generateNewWayPointsOrderSubSeq empty");
                    return false;
                }
                String whetherToEncodeParameter2 = ShareLocationManager.this.whetherToEncodeParameter(generatePathPlanWayPointsOrderSubSeq, true);
                if (!TextUtils.isEmpty(whetherToEncodeParameter)) {
                    return ShareLocationManager.this.driverOrderChange(whetherToEncodeParameter, whetherToEncodeParameter2, list.size());
                }
                BDLog.e(ShareLocationManager.TAG, "subNewWayPointOrdersSeq is empty");
                return false;
            }
            BDLog.e(ShareLocationManager.TAG, "subRowOrdersSeq is empty");
            return false;
        }

        private void updateParentOrderState(OrderInfoProtocol orderInfoProtocol) {
            if (ShareLocationManager.this.mParentOrderInfo != null && ShareLocationManager.this.mParentOrderInfo.orderType == 0 && orderInfoProtocol != null) {
                BDLog.e(ShareLocationManager.TAG, " [updateParentOrderState]: mParentOrderInfo is null");
                if (!TextUtils.isEmpty(orderInfoProtocol.preOrderId) && !ShareLocationManager.this.mParentOrderInfo.getOrderId().equals(orderInfoProtocol.getOrderId())) {
                    return;
                }
                BDLog.e(ShareLocationManager.TAG, " [updateParentOrderState]: orderState is set");
                ShareLocationManager.this.mParentOrderInfo.orderState = orderInfoProtocol.orderState;
                ShareLocationManager shareLocationManager = ShareLocationManager.this;
                shareLocationManager.insertParentOrderInfoToDataBase(shareLocationManager.mParentOrderInfo);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 30) {
                            switch (i) {
                                case 10:
                                    BDLog.d(ShareLocationManager.TAG, "MSG_SL_ORDER_REGISTER");
                                    handleRegisterOrder(message);
                                    return;
                                case 11:
                                    BDLog.d(ShareLocationManager.TAG, "MSG_SL_ORDER_UPDATE");
                                    handleUpdateOrder(message);
                                    return;
                                case 12:
                                    BDLog.d(ShareLocationManager.TAG, "MSG_SL_TOKEN_CHANGED");
                                    handleTokenChanged(message);
                                    return;
                                default:
                                    return;
                            }
                        }
                        BDLog.d(ShareLocationManager.TAG, "MSG_SL_DRIVER_CHANGED");
                        handlerWayPointStatusChanged(message);
                        return;
                    }
                    BDLog.d(ShareLocationManager.TAG, "MSG_SL_SET_DRIVER_POSITION_UPLOAD_INTERVAL");
                    handleUpdatePosUploadInterval(message);
                    return;
                }
                BDLog.d(ShareLocationManager.TAG, "MSG_SL_ROUTE_CHANGED");
                handleRougeChanged(message);
                return;
            }
            BDLog.d(ShareLocationManager.TAG, "MSG_SL_LOCATION_CHANGED");
            handleLocationChange(message);
        }
    }

    public ShareLocationManager(String str, String str2, int i, SyncShareImpl syncShareImpl, NavigationType navigationType) {
        initManager(str, str2, i, syncShareImpl, navigationType);
    }

    public static /* synthetic */ int access$1308(ShareLocationManager shareLocationManager) {
        int i = shareLocationManager.mCountUpdateServerError;
        shareLocationManager.mCountUpdateServerError = i + 1;
        return i;
    }

    public static /* synthetic */ int access$2008(ShareLocationManager shareLocationManager) {
        int i = shareLocationManager.mCountUpdateRouteInfoError;
        shareLocationManager.mCountUpdateRouteInfoError = i + 1;
        return i;
    }

    public static /* synthetic */ int access$2308(ShareLocationManager shareLocationManager) {
        int i = shareLocationManager.mCountRegisterNetError;
        shareLocationManager.mCountRegisterNetError = i + 1;
        return i;
    }

    public static /* synthetic */ int access$2508(ShareLocationManager shareLocationManager) {
        int i = shareLocationManager.mCountRegisterServerError;
        shareLocationManager.mCountRegisterServerError = i + 1;
        return i;
    }

    public static /* synthetic */ int access$3108(ShareLocationManager shareLocationManager) {
        int i = shareLocationManager.mCountUpdateDriverStatusError;
        shareLocationManager.mCountUpdateDriverStatusError = i + 1;
        return i;
    }

    public static /* synthetic */ int access$908(ShareLocationManager shareLocationManager) {
        int i = shareLocationManager.mCountUpdateNetError;
        shareLocationManager.mCountUpdateNetError = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocationUpdateResponseLog(int i) {
        if (i != this.mLastUpdateLocationStatus) {
            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
            if (syncShareImpl != null) {
                syncShareImpl.addUserOP("w.1.7.6", "dl", String.valueOf(i), this.mHashCode);
            }
            this.mLastUpdateLocationStatus = i;
            this.mLastUpdateLocResponseTime = System.currentTimeMillis();
            return;
        }
        if (System.currentTimeMillis() - this.mLastUpdateLocResponseTime >= 60000) {
            SyncShareImpl syncShareImpl2 = this.mShareManagerImpl;
            if (syncShareImpl2 != null) {
                syncShareImpl2.addUserOP("w.1.7.6", "dl", String.valueOf(i), this.mHashCode);
            }
            this.mLastUpdateLocResponseTime = System.currentTimeMillis();
        }
    }

    private void addOrderToUnRegisterList(final String str) {
        if (TextUtils.isEmpty(str)) {
            BDLog.e(TAG, "[addOrderToUnRegisterList]: orderId is empty");
            return;
        }
        ShareLocationHandler shareLocationHandler = this.mShareLocationHandler;
        if (shareLocationHandler == null) {
            BDLog.e(TAG, "[addOrderToUnRegisterList]: mHandler is null");
        } else {
            shareLocationHandler.post(new Runnable() { // from class: com.baidu.datahub.ShareLocationManager.9
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ShareLocationManager.this.mUnRegisterOrderSet) {
                        ShareLocationManager.this.mUnRegisterOrderSet.add(str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addUserOp(List<? extends OrderInfoProtocol> list, Map<String, String> map) {
        if (list != null && list.size() > 0 && map != null && map.size() > 0) {
            for (OrderInfoProtocol orderInfoProtocol : list) {
                if (orderInfoProtocol != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                            if (syncShareImpl != null) {
                                syncShareImpl.addUserOP(key, orderInfoProtocol.getOrderId(), value, this.mHashCode);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean appendOneSubSeq(StringBuilder sb, String str, String str2, RoutePlanNodeProtocol routePlanNodeProtocol, String str3) {
        if (TextUtils.isEmpty(str)) {
            BDLog.e(TAG, "[appendOneSubSeq]:orderId is empty");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            BDLog.e(TAG, "[appendOneSubSeq]:type is empty");
            return false;
        }
        if (routePlanNodeProtocol == null) {
            BDLog.e(TAG, "[appendOneSubSeq]:routePlanNode is null");
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            BDLog.e(TAG, "[appendOneSubSeq]:companyServerId is null");
            return false;
        }
        String mD5String = MD5Util.getMD5String(str, str3);
        if (TextUtils.isEmpty(mD5String)) {
            BDLog.e(TAG, "[appendOneSubSeq]:encryptOrderId is empty");
            return false;
        }
        sb.append(mD5String);
        sb.append('_');
        sb.append(str2);
        sb.append(';');
        sb.append(routePlanNodeProtocol.getLongitude());
        sb.append(',');
        sb.append(routePlanNodeProtocol.getLatitude());
        sb.append(';');
        sb.append(whetherToEncodeParameter(routePlanNodeProtocol.getName(), true));
        sb.append(';');
        sb.append(routePlanNodeProtocol.getId());
        return true;
    }

    private synchronized void deleteFromDB(String str, ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.delete(str, "orderId = ?", new String[]{next});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean driverOrderChange(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (isParentOrderInfoEmpty()) {
                BDLog.e(TAG, "mParentOrderInfo is null");
                return false;
            }
            HashMap hashMap = new HashMap();
            String parentOrderId = getParentOrderId();
            hashMap.put("order_id", parentOrderId);
            hashMap.put("company", this.mParentOrderInfo.companyServerId);
            hashMap.put("order_attr", this.mParentOrderInfo.driverId);
            hashMap.put("status", Integer.valueOf(this.mParentOrderInfo.orderState));
            hashMap.put("waypoints", str);
            hashMap.put("pathplan_points", str2);
            hashMap.put("trip_mode", getTripMode());
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.delete("driverStatus", "orderId = ?", new String[]{parentOrderId});
                this.mDatabase.execSQL("insert into driverStatus (orderId,companyServerId,driverId,orderState,waypoints,pathplan_points)values(?,?,?,?,?,?)", new String[]{parentOrderId, (String) hashMap.get("company"), (String) hashMap.get("order_attr"), String.valueOf(hashMap.get("status")), str, str2});
            }
            String requestData = getRequestData(hashMap, 0);
            BDLog.e("ShareLocationManager driver data request", requestData);
            return requestUpdateDriverStatus(parentOrderId, requestData, i);
        }
        BDLog.e(TAG, "waypointsSeq is null");
        return false;
    }

    private OrderInfoProtocol findRegisterOrderInfo(List<OrderInfoProtocol> list, String str) {
        OrderInfoProtocol orderInfoProtocol;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<OrderInfoProtocol> it = list.iterator();
        loop0: do {
            orderInfoProtocol = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                orderInfoProtocol = it.next();
                if (orderInfoProtocol != null) {
                    break;
                }
            }
        } while (!str.equals(MD5Util.getMD5String(orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId)));
        return orderInfoProtocol;
    }

    private boolean generateCarpoolOrderSubSeq(List<? extends WayPointInfoProtocol> list, String str, StringBuilder sb) {
        if (list != null && list.size() > 0) {
            if (sb == null) {
                BDLog.e(TAG, "[generateCarpoolOrderSubSeq]:subOrdersSeq is null");
                return false;
            }
            Iterator<? extends WayPointInfoProtocol> it = list.iterator();
            while (it.hasNext()) {
                WayPointInfoProtocol next = it.next();
                if (next == null || !appendOneSubSeq(sb, next.getOrderId(), next.getType(), next.getNode(), str)) {
                    return false;
                }
                if (it.hasNext()) {
                    sb.append('|');
                }
            }
            return true;
        }
        BDLog.e(TAG, "[generateCarpoolOrderSubSeq]:orderInfoList is empty");
        return false;
    }

    private Map<String, Object> generateOneRegParam(OrderInfoProtocol orderInfoProtocol, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Object obj;
        String str8;
        HashMap hashMap = null;
        if (orderInfoProtocol == null) {
            return null;
        }
        if (orderInfoProtocol.getOrderId() != null && orderInfoProtocol.companyServerId != null && orderInfoProtocol.driverId != null) {
            hashMap = new HashMap();
            RoutePlanNodeProtocol routePlanNodeProtocol = orderInfoProtocol.endNode;
            String str9 = x.dt;
            if (routePlanNodeProtocol != null) {
                str2 = orderInfoProtocol.endNode.getLongitude() + "," + orderInfoProtocol.endNode.getLatitude();
                str3 = orderInfoProtocol.endNode.getId();
                str4 = whetherToEncodeParameter(orderInfoProtocol.endNode.getName(), true);
            } else {
                str2 = x.dt;
                str3 = "";
                str4 = str3;
            }
            if (orderInfoProtocol.pickupNode != null) {
                str5 = orderInfoProtocol.pickupNode.getLongitude() + "," + orderInfoProtocol.pickupNode.getLatitude();
                str6 = orderInfoProtocol.pickupNode.getId();
                str7 = whetherToEncodeParameter(orderInfoProtocol.pickupNode.getName(), true);
            } else {
                str5 = x.dt;
                str6 = "";
                str7 = str6;
            }
            if (orderInfoProtocol.curLocationNode != null) {
                str9 = orderInfoProtocol.curLocationNode.getLongitude() + "," + orderInfoProtocol.curLocationNode.getLatitude();
            }
            hashMap.put("order_id", MD5Util.getMD5String(orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId));
            hashMap.put("company", orderInfoProtocol.companyServerId);
            hashMap.put("origin_oid", orderInfoProtocol.getOrderId());
            hashMap.put("order_attr", orderInfoProtocol.driverId);
            hashMap.put("status", Integer.valueOf(orderInfoProtocol.orderState));
            hashMap.put("cur_point", str9);
            hashMap.put("start_point", str5);
            hashMap.put("start_poiid", str6);
            hashMap.put("end_point", str2);
            hashMap.put("end_poiid", str3);
            hashMap.put("start_name", str7);
            hashMap.put("end_name", str4);
            hashMap.put("cuid", this.mCuid);
            hashMap.put("order_type", Integer.valueOf(orderInfoProtocol.orderType));
            hashMap.put("coord_type", str);
            hashMap.put("trip_mode", getTripMode());
            OrderInfoProtocol orderInfoProtocol2 = this.mParentOrderInfo;
            if (orderInfoProtocol2 == null || TextUtils.isEmpty(orderInfoProtocol2.getOrderId())) {
                obj = "end_name";
            } else {
                obj = "end_name";
                if (this.mParentOrderInfo.orderType == 1) {
                    hashMap.put("parent_order_id", getParentOrderId());
                }
            }
            if (orderInfoProtocol.orderType == 0 && (str8 = orderInfoProtocol.preOrderId) != null) {
                hashMap.put("previous_order_id", MD5Util.getMD5String(str8, orderInfoProtocol.companyServerId));
            } else {
                hashMap.put("previous_order_id", "");
            }
            ArrayList<String> outOfRangeOrdersFromDataBase = getOutOfRangeOrdersFromDataBase("orderInfo");
            if (outOfRangeOrdersFromDataBase != null && !outOfRangeOrdersFromDataBase.isEmpty()) {
                deleteFromDB("orderInfo", outOfRangeOrdersFromDataBase);
            }
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.delete("orderInfo", "orderId = ? and remark = ?", new String[]{orderInfoProtocol.getOrderId(), "register_order"});
                this.mDatabase.execSQL("insert into orderInfo (orderId,companyServerId,driverId,orderState,cur_point,start_point,start_poiid,start_name,end_point,end_poiid,end_name,cuid,remark,order_type,parent_order_id,coord_type,previous_order_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[]{orderInfoProtocol.getOrderId(), (String) hashMap.get("company"), (String) hashMap.get("order_attr"), String.valueOf(hashMap.get("status")), (String) hashMap.get("cur_point"), (String) hashMap.get("start_point"), (String) hashMap.get("start_poiid"), (String) hashMap.get("start_name"), (String) hashMap.get("end_point"), (String) hashMap.get("end_poiid"), (String) hashMap.get(obj), (String) hashMap.get("cuid"), "register_order", String.valueOf(hashMap.get("order_type")), (String) hashMap.get("parent_order_id"), (String) hashMap.get("coord_type"), (String) hashMap.get("previous_order_id")});
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generatePathPlanWayPointsOrderSubSeq(List<? extends WayPointInfoProtocol> list, String str, boolean z) {
        WayPointInfoProtocol next;
        RoutePlanNodeProtocol node;
        String str2;
        if (list != null && list.size() > 0) {
            if (str == null) {
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<? extends WayPointInfoProtocol> it = list.iterator();
            while (it.hasNext() && (next = it.next()) != null && (node = next.getNode()) != null) {
                if (z) {
                    sb.append(node.getLongitude());
                    sb.append(',');
                    sb.append(node.getLatitude());
                    sb.append(';');
                    sb.append(whetherToEncodeParameter(node.getName(), true));
                    sb.append(';');
                    sb.append(node.getId());
                    sb.append(';');
                    if (next.isArrive()) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    sb.append(str2);
                    sb.append(';');
                    sb.append(str);
                } else {
                    sb.append(node.getLongitude());
                    sb.append(',');
                    sb.append(node.getLatitude());
                    sb.append(';');
                    sb.append(whetherToEncodeParameter(node.getName(), true));
                    sb.append(';');
                    sb.append(node.getId());
                    sb.append(';');
                    sb.append(next.getType());
                    sb.append(';');
                    sb.append(str);
                }
                if (it.hasNext()) {
                    sb.append('|');
                }
            }
            if (sb.length() <= 0 || "null".equals(sb.toString()) || "".equals(sb.toString()) || "|".equals(sb.toString())) {
                return "";
            }
            return sb.toString();
        }
        BDLog.e(TAG, "[generateWayPointsOrderSubSeq]:orderInfoList is empty");
        return "";
    }

    private String generateRegisterOrderSubUrl(JSONObject jSONObject) {
        String str;
        String jSONObject2 = jSONObject.toString();
        String whetherToEncodeParameter = whetherToEncodeParameter(this.mAuthToken, true);
        String whetherToEncodeParameter2 = whetherToEncodeParameter(jSONObject2, true);
        if (TextUtils.isEmpty(whetherToEncodeParameter) || TextUtils.isEmpty(whetherToEncodeParameter2)) {
            return "";
        }
        String str2 = "orders=" + whetherToEncodeParameter2 + "&token=" + whetherToEncodeParameter;
        SyncShareImpl syncShareImpl = this.mShareManagerImpl;
        if (syncShareImpl == null) {
            str = "";
        } else {
            str = syncShareImpl.getSignMD5String(str2);
        }
        if (TextUtils.isEmpty(str)) {
            BDLog.e(TAG, "[generateRegisterOrderSubUrl]: sign is null");
            return "";
        }
        String str3 = "orders=" + whetherToEncodeParameter(whetherToEncodeParameter2, true) + "&token=" + whetherToEncodeParameter(whetherToEncodeParameter, true) + "&sign=" + whetherToEncodeParameter(str, true);
        BDLog.d(TAG, str3);
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        com.baidu.datahub.BDLog.e(com.baidu.datahub.ShareLocationManager.TAG, "etainfo is error" + r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void generateRunAndRemainInfo(java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r11 = this;
            java.util.List r0 = r11.getETAInfos()
            java.lang.String r1 = "ShareLocationManager"
            if (r0 == 0) goto Ldf
            int r2 = r0.size()
            if (r2 > 0) goto L10
            goto Ldf
        L10:
            boolean r2 = r11.isParentOrderInfoEmpty()
            if (r2 == 0) goto L1c
            java.lang.String r12 = "parent order info is empty"
            com.baidu.datahub.BDLog.e(r1, r12)
            return
        L1c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.baidu.datahub.protocol.OrderInfoProtocol r3 = r11.mParentOrderInfo
            int r3 = r3.orderType
            r4 = 1
            java.lang.String r5 = "|"
            if (r3 != r4) goto L35
            java.lang.String r3 = "v2"
            r2.append(r3)
            r2.append(r5)
            goto L40
        L35:
            if (r3 != 0) goto L40
            java.lang.String r3 = "v3"
            r2.append(r3)
            r2.append(r5)
        L40:
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r5 = r3
        L47:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto Lbc
            java.lang.Object r7 = r0.next()
            com.baidu.datahub.protocol.ShareETAInfoProtocol r7 = (com.baidu.datahub.protocol.ShareETAInfoProtocol) r7
            if (r7 == 0) goto La1
            java.lang.String r8 = r7.orderId
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto La1
            java.lang.String r8 = r7.etaType
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L66
            goto La1
        L66:
            long r8 = r7.leftDist
            r2.append(r8)
            r8 = 59
            r2.append(r8)
            long r8 = r7.leftTime
            r2.append(r8)
            r8 = 35
            r2.append(r8)
            java.lang.String r9 = r7.orderId
            com.baidu.datahub.protocol.OrderInfoProtocol r10 = r11.mParentOrderInfo
            java.lang.String r10 = r10.companyServerId
            java.lang.String r9 = com.baidu.datahub.MD5Util.getMD5String(r9, r10)
            r2.append(r9)
            r2.append(r8)
            java.lang.String r8 = r7.etaType
            r2.append(r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L9a
            r8 = 124(0x7c, float:1.74E-43)
            r2.append(r8)
        L9a:
            long r8 = r7.pastDist
            long r3 = r3 + r8
            long r7 = r7.pastTime
            long r5 = r5 + r7
            goto L47
        La1:
            if (r7 == 0) goto Lde
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "etainfo is error"
            r12.append(r0)
            java.lang.String r0 = r7.toString()
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.baidu.datahub.BDLog.e(r1, r12)
            goto Lde
        Lbc:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "remain"
            r12.put(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r1 = ";"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "run"
            r12.put(r1, r0)
        Lde:
            return
        Ldf:
            java.lang.String r12 = "etaInfos is null"
            com.baidu.datahub.BDLog.e(r1, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.generateRunAndRemainInfo(java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateWayPointsOrderSubSeq(List<? extends WayPointInfoProtocol> list, String str, boolean z) {
        WayPointInfoProtocol next;
        RoutePlanNodeProtocol node;
        if (list != null && list.size() > 0) {
            if (str == null) {
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<? extends WayPointInfoProtocol> it = list.iterator();
            while (it.hasNext() && (next = it.next()) != null && (node = next.getNode()) != null) {
                String str2 = "0";
                if (z) {
                    sb.append(node.getLongitude());
                    sb.append(',');
                    sb.append(node.getLatitude());
                    sb.append(';');
                    sb.append(whetherToEncodeParameter(node.getName(), true));
                    sb.append(';');
                    sb.append(node.getId());
                    sb.append(';');
                    if (next.isArrive()) {
                        str2 = "1";
                    }
                    sb.append(str2);
                    sb.append(';');
                    sb.append(str);
                } else if (next.getType().equals("wp")) {
                    sb.append(node.getLongitude());
                    sb.append(',');
                    sb.append(node.getLatitude());
                    sb.append(';');
                    sb.append(whetherToEncodeParameter(node.getName(), true));
                    sb.append(';');
                    sb.append(node.getId());
                    sb.append(';');
                    sb.append("0");
                    sb.append(';');
                    sb.append(str);
                }
                if (it.hasNext()) {
                    sb.append('|');
                }
            }
            if (sb.length() <= 0 || "null".equals(sb.toString()) || "".equals(sb.toString()) || "|".equals(sb.toString())) {
                return "";
            }
            return sb.toString();
        }
        BDLog.e(TAG, "[generateWayPointsOrderSubSeq]:orderInfoList is empty");
        return "";
    }

    private String getCoordTypeStr() {
        CoordType coordType;
        SyncShareImpl syncShareImpl = this.mShareManagerImpl;
        if (syncShareImpl == null || (coordType = syncShareImpl.getCoordType()) == null) {
            return "";
        }
        int i = AnonymousClass11.$SwitchMap$com$baidu$mapapi$CoordType[coordType.ordinal()];
        if (i == 1 || i != 2) {
            return "gcj02";
        }
        return "bd09ll";
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
    
        if (r3.moveToFirst() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a7, code lost:
    
        r2.add(r3.getString(0));
        r16 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
    
        if (r18.mDatabase.isOpen() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00be, code lost:
    
        if (r3.moveToNext() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
    
        if (r16 > 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ee, code lost:
    
        if (0 == 0) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.ArrayList<java.lang.String> getOutOfRangeOrdersFromDataBase(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.getOutOfRangeOrdersFromDataBase(java.lang.String):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getParentOrderId() {
        OrderInfoProtocol orderInfoProtocol = this.mParentOrderInfo;
        if (orderInfoProtocol != null && !TextUtils.isEmpty(orderInfoProtocol.getOrderId())) {
            OrderInfoProtocol orderInfoProtocol2 = this.mParentOrderInfo;
            if (orderInfoProtocol2.orderType == 0) {
                return MD5Util.getMD5String(orderInfoProtocol2.getOrderId(), this.mParentOrderInfo.companyServerId);
            }
            return orderInfoProtocol2.getOrderId();
        }
        return "";
    }

    private String getRequestData(Map<String, Object> map, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null && i == 0) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(whetherToEncodeParameter(String.valueOf(entry.getValue()), true));
                    stringBuffer.append("&");
                } else {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append("&");
                }
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e) {
            BDLog.dforce(TAG, "getRequestData exception happened.", e);
        }
        return stringBuffer.toString();
    }

    private String[] getSelectArgs(String str, Set<String> set) {
        int size = set.size() + 1;
        String[] strArr = new String[size];
        strArr[0] = str;
        Iterator<String> it = set.iterator();
        for (int i = 1; it.hasNext() && i < size; i++) {
            strArr[i] = it.next();
        }
        return strArr;
    }

    private Map<String, Object> getURLEncodeRequestData(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    hashMap.put(entry.getKey(), whetherToEncodeParameter(String.valueOf(entry.getValue()), true));
                }
            }
        } catch (Exception e) {
            BDLog.dforce(TAG, "getURLEncodeRequestData exception happened.", e);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleEndPositionInfo(String str) {
        OrderInfoProtocol orderInfoProtocol = this.mParentOrderInfo;
        if (orderInfoProtocol != null && orderInfoProtocol.orderType == 0 && !TextUtils.isEmpty(orderInfoProtocol.getOrderId())) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("data")) {
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    parseResponseExtDestination(optJSONObject);
                    parseResponseExtOrigin(optJSONObject);
                    parseResponseExtWayPoints(optJSONObject);
                    parseResponseExtNextDestination(optJSONObject);
                    parseResponseExtNextOrigin(optJSONObject);
                    parseResponseExtNextWayPoints(optJSONObject);
                    parseResponseExtNextPassRoute(optJSONObject);
                }
            } catch (JSONException e) {
                BDLog.dforce(TAG, "Parse endPosition info happened exception", e);
            }
        }
    }

    private void handleNotAllRegisterSuccessResult(JSONObject jSONObject, List<OrderInfoProtocol> list) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("order_detail")) == null) {
            return;
        }
        JSONObject jSONObject2 = null;
        boolean z = false;
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                jSONObject2 = (JSONObject) optJSONArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject2 != null) {
                int optInt = jSONObject2.optInt("status");
                String optString = jSONObject2.optString("order");
                if (optInt != 0) {
                    if (optInt != 1000) {
                        if (optInt != 1100) {
                        }
                    } else {
                        OrderInfoProtocol findRegisterOrderInfo = findRegisterOrderInfo(list, optString);
                        if (findRegisterOrderInfo != null) {
                            removeUnregisterOrder(findRegisterOrderInfo.getOrderId());
                        }
                    }
                }
                this.mIsOrderRegisted = true;
                OrderInfoProtocol findRegisterOrderInfo2 = findRegisterOrderInfo(list, optString);
                if (findRegisterOrderInfo2 != null) {
                    removeUnregisterOrder(findRegisterOrderInfo2.getOrderId());
                    if (!z) {
                        setCommonInfo(jSONObject, findRegisterOrderInfo2);
                        z = true;
                    }
                }
            }
        }
        int i2 = this.mCountRegisterPartFailed;
        if (i2 < 1) {
            this.mCountRegisterPartFailed = i2 + 1;
            loadOrderInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRegisterOrderResult(String str, List<OrderInfoProtocol> list) {
        if (TextUtils.isEmpty(str)) {
            BDLog.e(TAG, "[handleRegOrderResult]:result is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status");
            if (HttpClient.HttpStateError.NO_ERROR.getValue() != optInt && HttpClient.HttpStateError.ORDER_EXIST.getValue() != optInt) {
                handleNotAllRegisterSuccessResult(jSONObject, list);
            } else {
                handleRegisterSuccessResult(jSONObject, list);
                this.mIsOrderRegisted = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handleRegisterSuccessResult(JSONObject jSONObject, List<OrderInfoProtocol> list) {
        if (list != null && list.size() > 0) {
            setCommonInfo(jSONObject, list.get(0));
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                for (OrderInfoProtocol orderInfoProtocol : list) {
                    if (orderInfoProtocol != null) {
                        removeUnregisterOrder(orderInfoProtocol.getOrderId());
                    }
                }
                return;
            }
            BDLog.e(TAG, "datebase is not open");
            return;
        }
        BDLog.e(TAG, "[handleSuccessResult]:orderIdList is empty");
    }

    private void initManager(String str, String str2, int i, SyncShareImpl syncShareImpl, NavigationType navigationType) {
        if (syncShareImpl == null) {
            BDLog.e(TAG, "ShareManagerInterface cannot be empty");
            return;
        }
        this.mAuthToken = str;
        this.mCuid = str2;
        this.mShareManagerImpl = syncShareImpl;
        this.mNavigationType = navigationType;
        this.mOrderType = i;
        this.mCache = new BDCache(this.mParentOrderInfo);
        registerShareLocationHandler(this.mShareLocationHandler);
        Context appContext = this.mShareManagerImpl.getAppContext();
        HttpClient.mContext = appContext;
        try {
            this.mDatabase = new DatabaseHelper(appContext, "drivier.db", null, 6).getWritableDatabase();
        } catch (Exception e) {
            BDLog.dforce(TAG, "Get mDatabase failed, caught SQLiteException", e);
        }
        LogFile.init(appContext);
        String valueOf = String.valueOf(hashCode());
        this.mHashCode = valueOf;
        int length = valueOf.length();
        if (length > 4) {
            this.mHashCode = this.mHashCode.substring(length - 4);
        }
        removeLastParentOrderReleatedInfoFromDB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean insertParentOrderInfoToDataBase(OrderInfoProtocol orderInfoProtocol) {
        if (orderInfoProtocol != null && !TextUtils.isEmpty(orderInfoProtocol.companyServerId) && !TextUtils.isEmpty(orderInfoProtocol.driverId) && !TextUtils.isEmpty(orderInfoProtocol.getOrderId()) && !DEFAULT_PARENT_ORDER_ID.equals(orderInfoProtocol.getOrderId())) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                try {
                    this.mDatabase.delete("parentOrderInfo", "", null);
                    this.mDatabase.execSQL("insert into parentOrderInfo (orderId,companyServerId,driverId,orderState,order_type) values(?,?,?,?,?)", new String[]{orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId, orderInfoProtocol.driverId, String.valueOf(orderInfoProtocol.orderState), String.valueOf(orderInfoProtocol.orderType)});
                    return true;
                } catch (Exception unused) {
                    BDLog.e(TAG, "[loadParentOrderInfo]:Database exception happened");
                }
            }
            return false;
        }
        BDLog.e(TAG, "[insertParentOrderInfoToDataBase]:parent order info is empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        if (com.baidu.datahub.ShareLocationManager.DEFAULT_PARENT_ORDER_ID.equals(r0.getOrderId()) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isParentOrderInfoEmpty() {
        /*
            r4 = this;
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            if (r0 != 0) goto Lb
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = new com.baidu.datahub.protocol.OrderInfoProtocol
            r0.<init>()
            r4.mParentOrderInfo = r0
        Lb:
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            java.lang.String r0 = r0.companyServerId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            java.lang.String r2 = "-+~$#empty_parent_id#$~+-"
            if (r0 != 0) goto L3e
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            java.lang.String r0 = r0.driverId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3e
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            java.lang.String r0 = r0.getOrderId()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L3e
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            int r3 = r0.orderState
            if (r3 == 0) goto L3e
            java.lang.String r0 = r0.getOrderId()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L47
        L3e:
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.loadParentOrderInfo()
            if (r0 != 0) goto L45
            return r1
        L45:
            r4.mParentOrderInfo = r0
        L47:
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            if (r0 == 0) goto L7c
            java.lang.String r0 = r0.companyServerId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L7c
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            java.lang.String r0 = r0.driverId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L7c
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            java.lang.String r0 = r0.getOrderId()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L7c
            com.baidu.datahub.protocol.OrderInfoProtocol r0 = r4.mParentOrderInfo
            int r3 = r0.orderState
            if (r3 == 0) goto L7c
            java.lang.String r0 = r0.getOrderId()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7a
            goto L7c
        L7a:
            r0 = 0
            return r0
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.isParentOrderInfoEmpty():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean loadOrderInfo() {
        String str;
        String[] selectArgs;
        synchronized (this.mUnRegisterOrderSet) {
            str = "remark = ? AND orderId IN (" + makeSqlPlacekHolder(this.mUnRegisterOrderSet.size()) + oIX0oI.I0Io.f4095I0Io;
            selectArgs = getSelectArgs("register_order", this.mUnRegisterOrderSet);
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            List<OrderInfoProtocol> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray();
            Cursor cursor = null;
            try {
                try {
                    Cursor query = this.mDatabase.query("orderInfo", null, str, selectArgs, null, null, null);
                    if (query == null) {
                        BDLog.e(TAG, "[loadOrderInfo]: cursor is null");
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    }
                    if (this.mDatabase.isOpen()) {
                        if (!query.moveToFirst()) {
                        }
                        do {
                            OrderInfoProtocol orderInfoProtocol = new OrderInfoProtocol();
                            HashMap hashMap = new HashMap();
                            orderInfoProtocol.setOrderId(query.getString(0));
                            hashMap.put("order_id", MD5Util.getMD5String(orderInfoProtocol.getOrderId(), query.getString(1)));
                            String string = query.getString(1);
                            orderInfoProtocol.companyServerId = string;
                            hashMap.put("company", string);
                            String string2 = query.getString(2);
                            orderInfoProtocol.driverId = string2;
                            hashMap.put("order_attr", string2);
                            int i = query.getInt(3);
                            orderInfoProtocol.orderState = i;
                            hashMap.put("status", Integer.valueOf(i));
                            hashMap.put("cur_point", query.getString(4));
                            hashMap.put("start_point", query.getString(5));
                            hashMap.put("start_poiid", query.getString(6));
                            hashMap.put("start_name", query.getString(7));
                            hashMap.put("end_point", query.getString(8));
                            hashMap.put("end_poiid", query.getString(9));
                            hashMap.put("end_name", query.getString(10));
                            String string3 = query.getString(11);
                            if (!TextUtils.isEmpty(this.mCuid)) {
                                string3 = this.mCuid;
                            }
                            hashMap.put("cuid", string3);
                            int i2 = query.getInt(13);
                            orderInfoProtocol.orderType = i2;
                            hashMap.put("order_type", Integer.valueOf(i2));
                            String string4 = query.getString(14);
                            if (TextUtils.isEmpty(string4)) {
                                string4 = getParentOrderId();
                            }
                            if (orderInfoProtocol.orderType == 1 && !TextUtils.isEmpty(string4)) {
                                hashMap.put("parent_order_id", string4);
                            }
                            hashMap.put("coord_type", query.getString(15));
                            hashMap.put("trip_mode", getTripMode());
                            try {
                                jSONArray.put(new JSONObject(hashMap));
                            } catch (Exception e) {
                                BDLog.dforce(TAG, "loadOrderInfo exception happened.", e);
                            }
                            arrayList.add(orderInfoProtocol);
                        } while (query.moveToNext());
                        query.close();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("order_detail", jSONArray);
                        } catch (JSONException e2) {
                            BDLog.dforce(TAG, "param build error", e2);
                        }
                        if (!jSONObject.has("order_detail")) {
                            return false;
                        }
                        return sendRegisterOrder(generateRegisterOrderSubUrl(jSONObject), arrayList);
                    }
                    query.close();
                    BDLog.e(TAG, "[loadOrderInfo]:Database is close or cursor is empty when load order info");
                    query.close();
                    return false;
                } catch (Exception unused) {
                    BDLog.e(TAG, "[loadOrderInfo]:Database exception happened");
                    return false;
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        BDLog.dforce(TAG, "[loadOrderInfo]:Load order info error because database error");
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0035: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:54), block:B:46:0x0035 */
    private synchronized OrderInfoProtocol loadParentOrderInfo() {
        Cursor cursor;
        OrderInfoProtocol orderInfoProtocol;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        Cursor cursor3 = null;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                orderInfoProtocol = new OrderInfoProtocol();
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor;
            }
            try {
                cursor2 = this.mDatabase.query("parentOrderInfo", null, null, null, null, null, null);
                try {
                    if (cursor2 == null) {
                        BDLog.e(TAG, "[loadParentOrderInfo]: cursor is null");
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return null;
                    }
                    if (this.mDatabase.isOpen() && cursor2.moveToFirst()) {
                        orderInfoProtocol.setOrderId(cursor2.getString(0));
                        orderInfoProtocol.companyServerId = cursor2.getString(1);
                        orderInfoProtocol.driverId = cursor2.getString(2);
                        orderInfoProtocol.orderState = cursor2.getInt(3);
                        orderInfoProtocol.orderType = cursor2.getInt(4);
                        cursor2.close();
                        return orderInfoProtocol;
                    }
                    cursor2.close();
                    BDLog.e(TAG, "[loadParentOrderInfo]:Database is close or cursor is empty when load order info");
                    cursor2.close();
                    return null;
                } catch (Exception unused) {
                    BDLog.e(TAG, "[loadParentOrderInfo]:Database exception happened");
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return null;
                }
            } catch (Exception unused2) {
                cursor2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        }
        BDLog.dforce(TAG, "[loadParentOrderInfo]:Load order info error because database error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean loadRouteInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            BDLog.e(TAG, "[loadRouteInfo]: orderId is empty");
            return false;
        }
        String[] strArr = {str};
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            HashMap hashMap = new HashMap();
            Cursor cursor = null;
            try {
                try {
                    Cursor query = this.mDatabase.query("routeInfo", null, "orderId = ?", strArr, null, null, null);
                    if (query == null) {
                        BDLog.e(TAG, "[loadRouteInfo]: cursor is null 0");
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    }
                    if (!this.mDatabase.isOpen()) {
                        query.close();
                        BDLog.e(TAG, "[loadRouteInfo]: database is close");
                        query.close();
                        return false;
                    }
                    String str2 = "-+~$#empty_parent_id#$~+-_" + this.mHashCode;
                    if (!query.moveToFirst()) {
                        query.close();
                        query = this.mDatabase.query("routeInfo", null, "orderId = ?", new String[]{str2}, null, null, null);
                        if (query == null) {
                            BDLog.e(TAG, "[loadRouteInfo]: cursor is null");
                            if (query != null) {
                                query.close();
                            }
                            return false;
                        }
                        if (!this.mDatabase.isOpen() || !query.moveToFirst()) {
                            query.close();
                            BDLog.e(TAG, "[loadRouteInfo]: Datsbase is close or cursor is empty");
                            query.close();
                            return false;
                        }
                    }
                    String string = query.getString(0);
                    if (str2.equals(string)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("orderId", str);
                        this.mDatabase.update("routeInfo", contentValues, "orderId = ?", new String[]{str2});
                    } else {
                        str = string;
                    }
                    hashMap.put("order_id", str);
                    hashMap.put("company", query.getString(1));
                    hashMap.put("order_attr", query.getString(2));
                    hashMap.put("status", Integer.valueOf(query.getInt(3)));
                    hashMap.put("session_id", query.getString(4));
                    hashMap.put("route_id", query.getString(5));
                    hashMap.put("modify_time", Integer.valueOf(query.getInt(6)));
                    String string2 = query.getString(7);
                    hashMap.put("order_type", string2);
                    String string3 = query.getString(8);
                    if ("1".equals(string2)) {
                        hashMap.put("sub_orders_seq", string3);
                    }
                    String string4 = query.getString(10);
                    String string5 = query.getString(11);
                    String string6 = query.getString(12);
                    String string7 = query.getString(13);
                    String string8 = query.getString(14);
                    if ("0".equals(string2)) {
                        hashMap.put("end_name", string4);
                        hashMap.put("end_point", string5);
                        hashMap.put("end_poiid", string6);
                        hashMap.put("waypoints", string7);
                        hashMap.put("pathplan_points", string8);
                    }
                    hashMap.put("trip_mode", getTripMode());
                    hashMap.put("token", whetherToEncodeParameter(this.mAuthToken, true));
                    String requestData = getRequestData(hashMap, 1);
                    SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                    if (syncShareImpl != null) {
                        hashMap.put(HttpConstants.SIGN, syncShareImpl.getSignMD5String(requestData));
                    }
                    BDLog.e("ShareLocationManagerparamSign", requestData);
                    String requestData2 = getRequestData(hashMap, 0);
                    BDLog.d(TAG, "*******load route data:" + requestData2);
                    query.close();
                    return sendRouteInfo(str, requestData2, hashMap);
                } catch (Exception e) {
                    BDLog.dforce(TAG, "loadRouteInfo exception happened.", e);
                    return false;
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        BDLog.dforce(TAG, "Load route info error beacause database can't error");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0136, code lost:
    
        if (0 == 0) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean loadUpdateOrderInfo() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.loadUpdateOrderInfo():boolean");
    }

    private String makeSqlPlacekHolder(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LocationInfo.NA);
        for (int i2 = 1; i2 < i; i2++) {
            stringBuffer.append(",?");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBNListener(HttpClient.HttpStateError httpStateError, String str, IRequestListenerProtocol iRequestListenerProtocol) {
        String str2;
        if (httpStateError != HttpClient.HttpStateError.NETWORK_ERROR && httpStateError != HttpClient.HttpStateError.INNER_ERROR && httpStateError != HttpClient.HttpStateError.URL_ERROR) {
            iRequestListenerProtocol.onRequestResult(200, "请求成功", str);
            return;
        }
        if (httpStateError.getValue() >= 500) {
            str2 = HttpClient.HTTP_SERVER_ERROE;
        } else if (httpStateError.getValue() >= 400) {
            str2 = HttpClient.HTTP_CLIENT_ERROR;
        } else if (httpStateError.getValue() == -2) {
            str2 = HttpClient.HTTP_NETWORK_ERROR;
        } else {
            str2 = HttpClient.HTTP_UNKONW_ERROR;
        }
        iRequestListenerProtocol.onRequestResult(httpStateError.getValue(), str2, str);
    }

    private void parseResponseExtDestination(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String[] split;
        long j;
        if (jSONObject.length() != 0 && jSONObject.has("ext_destination") && (optJSONObject = jSONObject.optJSONObject("ext_destination")) != null && optJSONObject.length() != 0) {
            String optString = optJSONObject.optString("name");
            String optString2 = optJSONObject.optString("point");
            if (!TextUtils.isEmpty(optString2) && (split = optString2.split(",")) != null && split.length == 2) {
                double doubleValue = Double.valueOf(split[0]).doubleValue();
                double doubleValue2 = Double.valueOf(split[1]).doubleValue();
                String optString3 = optJSONObject.optString("poiid");
                String optString4 = optJSONObject.optString("order_id");
                String optString5 = optJSONObject.optString("coord_type");
                String optString6 = optJSONObject.optString("modify_time_ms");
                if (!TextUtils.isEmpty(optString6)) {
                    j = Long.valueOf(optString6).longValue();
                } else {
                    j = 0;
                }
                long j2 = j;
                RoutePlanNodeProtocol build = new RoutePlanNodeProtocol.Builder().id(optString3).latitude(doubleValue2).longitude(doubleValue).name(optString).build();
                SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                if (syncShareImpl == null) {
                    BDLog.d(TAG, "parseResponseExtDestinationmShareManagerImpl is empty");
                } else {
                    syncShareImpl.updateOrderEndPosition(optString4, build, j2, optString5);
                }
            }
        }
    }

    private void parseResponseExtNextDestination(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String[] split;
        long j;
        try {
            if (jSONObject.length() != 0 && jSONObject.has("ext_next_order_destinnation") && (optJSONObject = jSONObject.optJSONObject("ext_next_order_destinnation")) != null && optJSONObject.length() != 0) {
                String optString = optJSONObject.optString("name");
                String optString2 = optJSONObject.optString("point");
                if (!TextUtils.isEmpty(optString2) && (split = optString2.split(",")) != null && split.length == 2) {
                    double doubleValue = Double.valueOf(split[0]).doubleValue();
                    double doubleValue2 = Double.valueOf(split[1]).doubleValue();
                    String optString3 = optJSONObject.optString("poiid");
                    String optString4 = optJSONObject.optString("order_id");
                    String optString5 = optJSONObject.optString("coord_type");
                    String optString6 = optJSONObject.optString("modify_time_ms");
                    if (!TextUtils.isEmpty(optString6)) {
                        j = Long.valueOf(optString6).longValue();
                    } else {
                        j = 0;
                    }
                    long j2 = j;
                    RoutePlanNodeProtocol build = new RoutePlanNodeProtocol.Builder().id(optString3).latitude(doubleValue2).longitude(doubleValue).name(optString).build();
                    SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                    if (syncShareImpl == null) {
                        BDLog.d(TAG, "parseResponseExtNextDestinationmShareManagerImpl is empty");
                    } else {
                        syncShareImpl.updateOrderEndPosition(optString4, build, j2, optString5);
                    }
                }
            }
        } catch (Exception e) {
            BDLog.d(TAG, "parseResponseExtNextDestination" + e.getMessage());
        }
    }

    private void parseResponseExtNextOrigin(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String[] split;
        long j;
        try {
            if (jSONObject.length() != 0 && jSONObject.has("ext_next_order_origin") && (optJSONObject = jSONObject.optJSONObject("ext_next_order_origin")) != null && optJSONObject.length() != 0) {
                String optString = optJSONObject.optString("name");
                String optString2 = optJSONObject.optString("point");
                if (!TextUtils.isEmpty(optString2) && (split = optString2.split(",")) != null && split.length == 2) {
                    double doubleValue = Double.valueOf(split[0]).doubleValue();
                    double doubleValue2 = Double.valueOf(split[1]).doubleValue();
                    String optString3 = optJSONObject.optString("poiid");
                    String optString4 = optJSONObject.optString("order_id");
                    String optString5 = optJSONObject.optString("coord_type");
                    String optString6 = optJSONObject.optString("modify_time_ms");
                    if (!TextUtils.isEmpty(optString6)) {
                        j = Long.valueOf(optString6).longValue();
                    } else {
                        j = 0;
                    }
                    long j2 = j;
                    RoutePlanNodeProtocol build = new RoutePlanNodeProtocol.Builder().id(optString3).latitude(doubleValue2).longitude(doubleValue).name(optString).build();
                    SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                    if (syncShareImpl == null) {
                        BDLog.d(TAG, "parseResponseExtNextOriginmShareManagerImpl is empty");
                    } else {
                        syncShareImpl.updateOrderStartPosition(optString4, build, j2, optString5);
                    }
                }
            }
        } catch (Exception e) {
            BDLog.d(TAG, "parseResponseExtNextOrigin" + e.getMessage());
        }
    }

    private void parseResponseExtNextPassRoute(JSONObject jSONObject) {
        if (jSONObject.length() != 0 && jSONObject.has("ext_pass_setroute")) {
            BDLog.d(TAG, "parseResponseExtNextPassRoute" + jSONObject.toString());
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_pass_setroute");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                if (syncShareImpl == null) {
                    BDLog.d(TAG, "parseResponseExtNextPassRoutemShareManagerImpl is empty");
                } else {
                    syncShareImpl.updateOrderPassRoute(optJSONObject.toString());
                }
            }
        }
    }

    private void parseResponseExtNextWayPoints(JSONObject jSONObject) {
        long j;
        String[] split;
        try {
            if (jSONObject.length() != 0 && jSONObject.has("ext_next_order_way_points")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("ext_next_order_way_points");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("pts");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        String optString = optJSONObject.optString("modify_time_ms");
                        if (!TextUtils.isEmpty(optString)) {
                            j = Long.valueOf(optString).longValue();
                        } else {
                            j = 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        char c = 0;
                        String str = "";
                        int i = 0;
                        while (i < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 != null && jSONObject2.length() != 0) {
                                String optString2 = jSONObject2.optString("pt_type");
                                String optString3 = jSONObject2.optString("order_id");
                                if ("way".equals(optString2)) {
                                    String optString4 = jSONObject2.optString("name");
                                    String optString5 = jSONObject2.optString("point");
                                    if (!TextUtils.isEmpty(optString5) && (split = optString5.split(",")) != null && split.length == 2) {
                                        double doubleValue = Double.valueOf(split[c]).doubleValue();
                                        double doubleValue2 = Double.valueOf(split[1]).doubleValue();
                                        String optString6 = jSONObject2.optString("poiid");
                                        CoordType coordType = CoordType.GCJ02;
                                        if ("bd09ll".equals(jSONObject2.optString("coord_type"))) {
                                            coordType = CoordType.BD09LL;
                                        }
                                        arrayList.add(new WayPointInfoProtocol(optString3, "wp", new RoutePlanNodeProtocol.Builder().id(optString6).latitude(doubleValue2).longitude(doubleValue).name(optString4).build(), coordType));
                                    }
                                }
                                str = optString3;
                            }
                            i++;
                            c = 0;
                        }
                        try {
                            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                            if (syncShareImpl == null) {
                                BDLog.d(TAG, "parseResponseExtNextWayPointsmShareManagerImpl is empty");
                            } else {
                                syncShareImpl.updateWayPoints(arrayList, j, str);
                            }
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            BDLog.d(TAG, "parseResponseExtNextWayPoints" + e.getMessage());
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    private void parseResponseExtOrigin(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String[] split;
        long j;
        try {
            if (jSONObject.length() != 0 && jSONObject.has("ext_origin") && (optJSONObject = jSONObject.optJSONObject("ext_origin")) != null && optJSONObject.length() != 0) {
                String optString = optJSONObject.optString("name");
                String optString2 = optJSONObject.optString("point");
                if (!TextUtils.isEmpty(optString2) && (split = optString2.split(",")) != null && split.length == 2) {
                    double doubleValue = Double.valueOf(split[0]).doubleValue();
                    double doubleValue2 = Double.valueOf(split[1]).doubleValue();
                    String optString3 = optJSONObject.optString("poiid");
                    String optString4 = optJSONObject.optString("order_id");
                    String optString5 = optJSONObject.optString("coord_type");
                    String optString6 = optJSONObject.optString("modify_time_ms");
                    if (!TextUtils.isEmpty(optString6)) {
                        j = Long.valueOf(optString6).longValue();
                    } else {
                        j = 0;
                    }
                    long j2 = j;
                    RoutePlanNodeProtocol build = new RoutePlanNodeProtocol.Builder().id(optString3).latitude(doubleValue2).longitude(doubleValue).name(optString).build();
                    SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                    if (syncShareImpl == null) {
                        BDLog.d(TAG, "parseResponseExtOriginmShareManagerImpl is empty");
                    } else {
                        syncShareImpl.updateOrderStartPosition(optString4, build, j2, optString5);
                    }
                }
            }
        } catch (Exception e) {
            BDLog.d(TAG, "parseResponseExtOrigin" + e.getMessage());
        }
    }

    private void parseResponseExtWayPoints(JSONObject jSONObject) {
        long j;
        String[] split;
        try {
            if (jSONObject.length() != 0 && jSONObject.has("ext_way_points")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("ext_way_points");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("pts");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        String optString = optJSONObject.optString("modify_time_ms");
                        if (!TextUtils.isEmpty(optString)) {
                            j = Long.valueOf(optString).longValue();
                        } else {
                            j = 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        char c = 0;
                        String str = "";
                        int i = 0;
                        while (i < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 != null && jSONObject2.length() != 0) {
                                String optString2 = jSONObject2.optString("pt_type");
                                String optString3 = jSONObject2.optString("order_id");
                                if ("way".equals(optString2)) {
                                    String optString4 = jSONObject2.optString("name");
                                    String optString5 = jSONObject2.optString("point");
                                    if (!TextUtils.isEmpty(optString5) && (split = optString5.split(",")) != null && split.length == 2) {
                                        double doubleValue = Double.valueOf(split[c]).doubleValue();
                                        double doubleValue2 = Double.valueOf(split[1]).doubleValue();
                                        String optString6 = jSONObject2.optString("poiid");
                                        CoordType coordType = CoordType.GCJ02;
                                        if ("bd09ll".equals(jSONObject2.optString("coord_type"))) {
                                            coordType = CoordType.BD09LL;
                                        }
                                        arrayList.add(new WayPointInfoProtocol(optString3, "wp", new RoutePlanNodeProtocol.Builder().id(optString6).latitude(doubleValue2).longitude(doubleValue).name(optString4).build(), coordType));
                                    }
                                }
                                str = optString3;
                            }
                            i++;
                            c = 0;
                        }
                        try {
                            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                            if (syncShareImpl == null) {
                                BDLog.d(TAG, "parseResponseExtWayPointsmShareManagerImpl is empty");
                            } else {
                                syncShareImpl.updateWayPoints(arrayList, j, str);
                            }
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            BDLog.d(TAG, "parseResponseExtWayPoints" + e.getMessage());
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseResponsePassengerPoint(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "ShareLocationManager"
            com.baidu.datahub.protocol.OrderInfoProtocol r1 = r13.mParentOrderInfo
            if (r1 == 0) goto Lda
            int r2 = r1.orderType
            if (r2 != 0) goto Lda
            java.lang.String r1 = r1.getOrderId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L16
            goto Lda
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r14)
            if (r1 == 0) goto L1d
            return
        L1d:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> Ld4
            r1.<init>(r14)     // Catch: org.json.JSONException -> Ld4
            java.lang.String r14 = "data"
            boolean r2 = r1.has(r14)
            if (r2 != 0) goto L2b
            return
        L2b:
            org.json.JSONObject r14 = r1.optJSONObject(r14)
            if (r14 == 0) goto Ld3
            int r1 = r14.length()
            if (r1 == 0) goto Ld3
            java.lang.String r1 = "pass_position"
            boolean r2 = r14.has(r1)
            if (r2 != 0) goto L41
            goto Ld3
        L41:
            org.json.JSONObject r14 = r14.optJSONObject(r1)
            if (r14 == 0) goto Ld3
            int r1 = r14.length()
            if (r1 != 0) goto L4f
            goto Ld3
        L4f:
            java.lang.String r1 = "coord_type"
            java.lang.String r4 = r14.optString(r1)
            java.lang.String r1 = "point"
            java.lang.String r1 = r14.optString(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r5 = 0
            r3 = 0
            r7 = 1
            if (r2 != 0) goto La6
            java.lang.String r2 = "\\|"
            java.lang.String[] r1 = r1.split(r2)
            if (r1 == 0) goto La6
            int r2 = r1.length
            r8 = 2
            if (r2 < r8) goto La6
            r2 = r1[r3]
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            long r9 = r2.longValue()
            r1 = r1[r7]
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = ","
            java.lang.String[] r1 = r1.split(r2)
            if (r1 == 0) goto La4
            int r2 = r1.length
            if (r2 != r8) goto La4
            r2 = r1[r3]
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            double r5 = r2.doubleValue()
            r1 = r1[r7]
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            double r1 = r1.doubleValue()
            r11 = r1
            r1 = r5
            r5 = r11
            goto Laa
        La4:
            r1 = r5
            goto Laa
        La6:
            r1 = 0
            r9 = r1
            goto La4
        Laa:
            java.lang.String r8 = "a"
            int r14 = r14.optInt(r8)
            if (r14 != r7) goto Lb3
            goto Lb4
        Lb3:
            r7 = 0
        Lb4:
            com.baidu.datahub.protocol.RoutePlanNodeProtocol$Builder r14 = new com.baidu.datahub.protocol.RoutePlanNodeProtocol$Builder
            r14.<init>()
            com.baidu.datahub.protocol.RoutePlanNodeProtocol$Builder r14 = r14.latitude(r5)
            com.baidu.datahub.protocol.RoutePlanNodeProtocol$Builder r14 = r14.longitude(r1)
            com.baidu.datahub.protocol.RoutePlanNodeProtocol r3 = r14.build()
            com.baidu.datahub.protocol.SyncShareImpl r2 = r13.mShareManagerImpl
            if (r2 != 0) goto Lcf
            java.lang.String r14 = "parseResponsePassengerPointmShareManagerImpl is empty"
            com.baidu.datahub.BDLog.d(r0, r14)
            return
        Lcf:
            r5 = r9
            r2.setUserLocation(r3, r4, r5, r7)
        Ld3:
            return
        Ld4:
            r14 = move-exception
            java.lang.String r1 = "Parse endPosition info happened exception"
            com.baidu.datahub.BDLog.dforce(r0, r1, r14)
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.parseResponsePassengerPoint(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseResponseStatus(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                return -1;
            }
            return jSONObject.getInt("status");
        } catch (JSONException e) {
            BDLog.dforce(TAG, "ParseResponseStatus json happened exception", e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean registerOrder(List<OrderInfoProtocol> list) {
        Map<String, Object> generateOneRegParam;
        if (list != null) {
            if (list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                String coordTypeStr = getCoordTypeStr();
                for (int i = 0; i < list.size(); i++) {
                    try {
                        OrderInfoProtocol orderInfoProtocol = list.get(i);
                        if (orderInfoProtocol != null && (generateOneRegParam = generateOneRegParam(orderInfoProtocol, coordTypeStr)) != null) {
                            addOrderToUnRegisterList(orderInfoProtocol.getOrderId());
                            jSONArray.put(i, new JSONObject(generateOneRegParam));
                            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                            if (syncShareImpl != null) {
                                syncShareImpl.addUserOP("w.1.7.1", orderInfoProtocol.getOrderId(), orderInfoProtocol.driverId, this.mHashCode);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                BDLog.d(TAG, "jsonArray : " + jSONArray.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("order_detail", jSONArray);
                return sendRegisterOrder(generateRegisterOrderSubUrl(jSONObject), list);
            }
        }
        BDLog.e(TAG, "BNOrderInfo is null");
        return false;
    }

    private void registerShareLocationHandler(Handler handler) {
        SyncShareImpl syncShareImpl = this.mShareManagerImpl;
        if (syncShareImpl == null) {
            BDLog.e(TAG, "registerShareLocationHandler ShareManagerInterface cannot be empty");
            return;
        }
        int i = this.mOrderType;
        if (i == 0) {
            syncShareImpl.registerNormalShareLocationHandler(handler);
        } else if (1 == i) {
            syncShareImpl.registerCarPoolShareLocationHandler(handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllUnregisterOrder(List<OrderInfoProtocol> list) {
        SQLiteDatabase sQLiteDatabase;
        if (list != null && list.size() > 0 && (sQLiteDatabase = this.mDatabase) != null && sQLiteDatabase.isOpen()) {
            synchronized (this.mUnRegisterOrderSet) {
                this.mUnRegisterOrderSet.clear();
            }
            for (OrderInfoProtocol orderInfoProtocol : list) {
                if (orderInfoProtocol != null) {
                    this.mDatabase.delete("orderInfo", "orderId = ? and remark = ?", new String[]{orderInfoProtocol.getOrderId(), "register_order"});
                }
            }
        }
    }

    private void removeLastParentOrderReleatedInfoFromDB() {
        removeRouteInfoWithDefaultParentIDFromDB();
        OrderInfoProtocol loadParentOrderInfo = loadParentOrderInfo();
        if (loadParentOrderInfo == null) {
            BDLog.e(TAG, "preOrderInfo is null");
            return;
        }
        if (loadParentOrderInfo.orderType == 0) {
            loadParentOrderInfo.setOrderId(MD5Util.getMD5String(loadParentOrderInfo.getOrderId(), loadParentOrderInfo.companyServerId));
        }
        removeParentOrderRelatedInfoFromDB(loadParentOrderInfo.getOrderId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNotUpdateOrder(String str) {
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(str) && (sQLiteDatabase = this.mDatabase) != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.delete("orderInfo", "orderId = ? and remark = ?", new String[]{str, "update_order"});
        }
    }

    private void removeOrderFromUnRegisterList(final String str) {
        if (TextUtils.isEmpty(str)) {
            BDLog.e(TAG, "[addOrderToUnRegisterList]: orderId is empty");
            return;
        }
        ShareLocationHandler shareLocationHandler = this.mShareLocationHandler;
        if (shareLocationHandler == null) {
            BDLog.e(TAG, "[removeOrderFromUnRegisterList]: mHandler is null");
        } else {
            shareLocationHandler.post(new Runnable() { // from class: com.baidu.datahub.ShareLocationManager.10
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (ShareLocationManager.this.mUnRegisterOrderSet) {
                        ShareLocationManager.this.mUnRegisterOrderSet.remove(str);
                    }
                }
            });
        }
    }

    private void removeOrderInfoFromDB(String str) {
        String[] strArr = {str};
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.mDatabase.delete("orderInfo", "parent_order_id = ?", strArr);
            } catch (Exception unused) {
                BDLog.e(TAG, "[removeParentOrderInfoFromDataBase]:Database exception happened");
            }
        }
    }

    private void removeParentOrderInfoFromDB() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.mDatabase.delete("parentOrderInfo", "", null);
            } catch (Exception unused) {
                BDLog.e(TAG, "[removeParentOrderInfoFromDataBase]:Database exception happened");
            }
        }
    }

    private void removeParentOrderRelatedInfoFromDB(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        removeOrderInfoFromDB(str);
        removeRouteInfoFromDB(str);
        removeParentOrderInfoFromDB();
    }

    private void removeRouteInfoFromDB(String str) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.mDatabase.delete("routeInfo", "orderId = ?", new String[]{str});
            } catch (Exception unused) {
                BDLog.e(TAG, "[removeParentOrderInfoFromDataBase]:Database exception happened");
            }
        }
    }

    private void removeRouteInfoWithDefaultParentIDFromDB() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.mDatabase.delete("routeInfo", "orderId like ?", new String[]{"-+~$#empty_parent_id#$~+-_%"});
            } catch (Exception unused) {
                BDLog.e(TAG, "[removeParentOrderInfoFromDataBase]:Database exception happened");
            }
        }
    }

    private void removeUnregisterOrder(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.delete("orderInfo", "orderId = ? and remark = ?", new String[]{str, "register_order"});
        }
        removeOrderFromUnRegisterList(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean requestUpdateDriverStatus(final String str, final String str2, final int i) {
        if (!this.mIsStopSynServer && this.mIsOrderRegisted) {
            if (str2 != null && !str2.isEmpty()) {
                this.mBaseRequest.sendRequest(7, "POST", str2, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.8
                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onFailed(HttpClient.HttpStateError httpStateError, String str3) {
                        BDLog.e(ShareLocationManager.TAG, "update driver status failed,errCode:" + httpStateError + "result:" + str3);
                        if (HttpClient.HttpStateError.APP_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.APP_SERVER_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.USER_DELETED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.DAY_QUOTA_OVER_LIMIT == httpStateError) {
                            ShareLocationManager.this.mIsStopSynServer = true;
                        } else if (HttpClient.HttpStateError.NETWORK_ERROR != httpStateError) {
                            ShareLocationManager.this.mCountUpdateDriverStatusError = 0;
                        } else if (ShareLocationManager.this.mCountUpdateDriverStatusError >= 2) {
                            ShareLocationManager.this.mCountUpdateDriverStatusError = 0;
                        } else {
                            ShareLocationManager.access$3108(ShareLocationManager.this);
                            ShareLocationManager.this.requestUpdateDriverStatus(str, str2, i);
                        }
                        if (ShareLocationManager.this.mShareManagerImpl != null) {
                            ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.7", str, String.valueOf(i), ShareLocationManager.this.mHashCode);
                        }
                    }

                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onSuccess(String str3) {
                        BDLog.d(ShareLocationManager.TAG, "update driver status success");
                        ShareLocationManager.this.mCountUpdateDriverStatusError = 0;
                        ShareLocationManager.this.mDatabase.delete("driverStatus", "orderId = ?", new String[]{str});
                        if (ShareLocationManager.this.mShareManagerImpl != null) {
                            ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.7", str, String.valueOf(i), ShareLocationManager.this.mHashCode);
                        }
                    }
                });
                return true;
            }
            return false;
        }
        BDLog.e(TAG, "[requestUpdateDriverStatus]: User is deleted by admin or order register failed");
        return false;
    }

    private synchronized boolean sendLocationInfo(String str, final int i) {
        if (!this.mIsStopSynServer && this.mIsOrderRegisted) {
            if (str != null && !str.isEmpty()) {
                this.mBaseRequest.sendRequest(4, "POST", str, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.3
                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onFailed(HttpClient.HttpStateError httpStateError, String str2) {
                        BDLog.e(ShareLocationManager.TAG, "[sendLocationInfo],errCode:" + httpStateError + "result:" + str2);
                        ShareLocationManager.this.mUploadStatus = DataStatus.error;
                        if (HttpClient.HttpStateError.APP_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.APP_SERVER_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.USER_DELETED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.DAY_QUOTA_OVER_LIMIT == httpStateError) {
                            ShareLocationManager.this.mIsStopSynServer = true;
                        }
                        ShareLocationManager.this.addLocationUpdateResponseLog(httpStateError.getValue());
                    }

                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onSuccess(String str2) {
                        BDLog.e(ShareLocationManager.TAG, "[sendLocationInfo] success, result:" + str2);
                        ShareLocationManager.this.mCache.remove(i);
                        ShareLocationManager.this.mUploadStatus = DataStatus.success;
                        ShareLocationManager shareLocationManager = ShareLocationManager.this;
                        shareLocationManager.addLocationUpdateResponseLog(shareLocationManager.parseResponseStatus(str2));
                        ShareLocationManager.this.handleEndPositionInfo(str2);
                        ShareLocationManager.this.parseResponsePassengerPoint(str2);
                    }
                });
                return true;
            }
            this.mUploadStatus = DataStatus.ready;
            return false;
        }
        BDLog.e(TAG, "[sendLocationInfo]: User is deleted by admin or order register failedor order error");
        this.mUploadStatus = DataStatus.ready;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean sendRegisterOrder(final String str, final List<OrderInfoProtocol> list) {
        if (this.mIsStopSynServer) {
            BDLog.e(TAG, "[sendRegisterOrder]: User is deleted by admin");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mBaseRequest.sendRequest(1, "POST", str, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.5
            @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
            public void onFailed(HttpClient.HttpStateError httpStateError, String str2) {
                BDLog.e(ShareLocationManager.TAG, "register order failed,errCode:" + httpStateError + "result:" + str2);
                if (HttpClient.HttpStateError.SERVER_INNER == httpStateError) {
                    if (ShareLocationManager.this.mCountRegisterServerError < 1) {
                        ShareLocationManager.access$2508(ShareLocationManager.this);
                        ShareLocationManager.this.sendRegisterOrder(str, list);
                    }
                } else if (HttpClient.HttpStateError.APP_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.APP_SERVER_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.USER_DELETED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.DAY_QUOTA_OVER_LIMIT == httpStateError) {
                    ShareLocationManager.this.mIsStopSynServer = true;
                } else if (HttpClient.HttpStateError.NETWORK_ERROR == httpStateError) {
                    if (ShareLocationManager.this.mCountRegisterNetError < 2) {
                        ShareLocationManager.access$2308(ShareLocationManager.this);
                        ShareLocationManager.this.sendRegisterOrder(str, list);
                    } else {
                        BDLog.e(ShareLocationManager.TAG, "network error times:" + ShareLocationManager.this.mCountRegisterNetError);
                    }
                } else if (HttpClient.HttpStateError.PART_ORDERS_REG_FAILED == httpStateError) {
                    ShareLocationManager.this.handleRegisterOrderResult(str2, list);
                } else if (HttpClient.HttpStateError.PARAM_ERROR == httpStateError && !ShareLocationManager.this.isParentOrderInfoEmpty()) {
                    ShareLocationManager.this.removeAllUnregisterOrder(list);
                } else if (HttpClient.HttpStateError.ORDER_ATTR_DISMATCH == httpStateError || HttpClient.HttpStateError.PARENT_ORDER_NOT_EXIST == httpStateError || HttpClient.HttpStateError.PARENT_ORDER_FINISH == httpStateError) {
                    ShareLocationManager.this.removeAllUnregisterOrder(list);
                }
                if (ShareLocationManager.this.mShareManagerImpl != null) {
                    ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.6", "dr", String.valueOf(httpStateError.getValue()), ShareLocationManager.this.mHashCode);
                }
            }

            @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
            public void onSuccess(String str2) {
                BDLog.d(ShareLocationManager.TAG, "register order success");
                ShareLocationManager.this.mCountRegisterNetError = 0;
                ShareLocationManager.this.mCountRegisterPartFailed = 0;
                ShareLocationManager.this.mCountRegisterServerError = 0;
                ShareLocationManager.this.handleRegisterOrderResult(str2, list);
                if (ShareLocationManager.this.mShareManagerImpl != null) {
                    ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.6", "dr", String.valueOf(ShareLocationManager.this.parseResponseStatus(str2)), ShareLocationManager.this.mHashCode);
                }
            }
        }, HttpClient.ContentType.FORM_DATA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean sendRouteInfo(final String str, final String str2, final Map<String, Object> map) {
        if (!this.mIsStopSynServer && this.mIsOrderRegisted) {
            if (map != null && str2 != null && !str2.isEmpty()) {
                this.mBaseRequest.sendRequest(3, "POST", str2, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.4
                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onFailed(HttpClient.HttpStateError httpStateError, String str3) {
                        BDLog.e(ShareLocationManager.TAG, "update route failed,errCode:" + httpStateError + "result:" + str3);
                        if (HttpClient.HttpStateError.APP_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.APP_SERVER_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.USER_DELETED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.DAY_QUOTA_OVER_LIMIT == httpStateError) {
                            ShareLocationManager.this.mIsStopSynServer = true;
                        } else if (HttpClient.HttpStateError.NETWORK_ERROR != httpStateError) {
                            ShareLocationManager.this.mCountUpdateRouteInfoError = 0;
                        } else if (ShareLocationManager.this.mCountUpdateRouteInfoError >= 2) {
                            ShareLocationManager.this.mCountUpdateRouteInfoError = 0;
                        } else {
                            ShareLocationManager.access$2008(ShareLocationManager.this);
                            ShareLocationManager.this.sendRouteInfo(str, str2, map);
                        }
                        if (ShareLocationManager.this.mShareManagerImpl != null) {
                            ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.6", t.q, String.valueOf(httpStateError.getValue()), ShareLocationManager.this.mHashCode);
                        }
                    }

                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onSuccess(String str3) {
                        BDLog.d(ShareLocationManager.TAG, "update route success");
                        ShareLocationManager.this.mCountUpdateRouteInfoError = 0;
                        ShareLocationManager.this.mDatabase.delete("routeInfo", "orderId = ?", new String[]{str});
                        if (ShareLocationManager.this.mShareManagerImpl != null) {
                            ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.6", t.q, String.valueOf(ShareLocationManager.this.parseResponseStatus(str3)), ShareLocationManager.this.mHashCode);
                        }
                    }
                });
                return true;
            }
            return false;
        }
        BDLog.e(TAG, "[sendRouteInfo]: User is deleted by admin or order register failed");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean sendUpdateOrder(final String str, final String str2) {
        if (!this.mIsStopSynServer && this.mIsOrderRegisted) {
            if (str2 == null) {
                return false;
            }
            this.mBaseRequest.sendRequest(2, "POST", str2, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.2
                @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                public void onFailed(HttpClient.HttpStateError httpStateError, String str3) {
                    BDLog.e(ShareLocationManager.TAG, "update order failed,errCode:" + httpStateError + "result:" + str3);
                    if (HttpClient.HttpStateError.SERVER_INNER == httpStateError) {
                        if (ShareLocationManager.this.mCountUpdateServerError < 1) {
                            ShareLocationManager.access$1308(ShareLocationManager.this);
                            ShareLocationManager.this.sendUpdateOrder(str, str2);
                        }
                    } else if (HttpClient.HttpStateError.APP_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.APP_SERVER_DISABLED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.USER_DELETED_BY_ADMIN == httpStateError || HttpClient.HttpStateError.DAY_QUOTA_OVER_LIMIT == httpStateError) {
                        ShareLocationManager.this.mIsStopSynServer = true;
                    } else if (HttpClient.HttpStateError.NETWORK_ERROR != httpStateError) {
                        ShareLocationManager.this.mCountUpdateNetError = 0;
                    } else if (ShareLocationManager.this.mCountUpdateNetError >= 2) {
                        ShareLocationManager.this.mCountUpdateNetError = 0;
                    } else {
                        ShareLocationManager.access$908(ShareLocationManager.this);
                        ShareLocationManager.this.sendUpdateOrder(str, str2);
                    }
                    if (ShareLocationManager.this.mShareManagerImpl != null) {
                        ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.6", "ds", String.valueOf(httpStateError.getValue()), ShareLocationManager.this.mHashCode);
                    }
                }

                @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                public void onSuccess(String str3) {
                    BDLog.e(ShareLocationManager.TAG, "update order success");
                    ShareLocationManager.this.removeNotUpdateOrder(str);
                    ShareLocationManager.this.mCountUpdateNetError = 0;
                    if (ShareLocationManager.this.mShareManagerImpl != null) {
                        ShareLocationManager.this.mShareManagerImpl.addUserOP("w.1.7.6", "ds", String.valueOf(ShareLocationManager.this.parseResponseStatus(str3)), ShareLocationManager.this.mHashCode);
                    }
                }
            });
            return true;
        }
        BDLog.e(TAG, "[sendUpdateOrder]: User is deleted by admin or order register failedor order error");
        return false;
    }

    private void setCommonInfo(JSONObject jSONObject, OrderInfoProtocol orderInfoProtocol) {
        OrderInfoProtocol orderInfoProtocol2;
        if (orderInfoProtocol == null) {
            BDLog.e(TAG, "[getParentOrderInfo]:orderIdList is null, getParentOrderInfo failed");
            return;
        }
        String str = orderInfoProtocol.preOrderId;
        if (orderInfoProtocol.orderType == 0 && !TextUtils.isEmpty(str) && (orderInfoProtocol2 = this.mParentOrderInfo) != null && !orderInfoProtocol2.getOrderId().equals(orderInfoProtocol.getOrderId())) {
            BDLog.e(TAG, "[getParentOrderInfo]:previousOrderId is normal");
            return;
        }
        if (this.mParentOrderInfo == null) {
            this.mParentOrderInfo = new OrderInfoProtocol();
        }
        OrderInfoProtocol orderInfoProtocol3 = this.mParentOrderInfo;
        int i = orderInfoProtocol.orderType;
        orderInfoProtocol3.orderType = i;
        orderInfoProtocol3.driverId = orderInfoProtocol.driverId;
        orderInfoProtocol3.companyServerId = orderInfoProtocol.companyServerId;
        if (1 == i) {
            orderInfoProtocol3.orderState = 10;
            orderInfoProtocol3.setOrderId(jSONObject.optString("parent_order_id"));
        } else if (i == 0) {
            orderInfoProtocol3.setOrderId(orderInfoProtocol.getOrderId());
        }
        insertParentOrderInfoToDataBase(this.mParentOrderInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateLocationInfo(String str) {
        if (isParentOrderInfoEmpty()) {
            BDLog.e(TAG, "[updateLocationInfo]:mParentOrderInfo is empty");
            return false;
        }
        this.mUploadStatus = DataStatus.process;
        int size = this.mCache.getSize();
        if (size == 0) {
            this.mUploadStatus = DataStatus.ready;
            return false;
        }
        List<ShareETAInfoProtocol> eTAInfos = getETAInfos();
        String str2 = "";
        if (eTAInfos != null && eTAInfos.size() > 0) {
            str2 = eTAInfos.get(0).routeID;
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("order_id", whetherToEncodeParameter(getParentOrderId(), true));
            hashMap.put("company", whetherToEncodeParameter(this.mParentOrderInfo.companyServerId, true));
            hashMap.put("order_attr", whetherToEncodeParameter(this.mParentOrderInfo.driverId, true));
            hashMap.put("points", whetherToEncodeParameter(this.mCache.formatPointsData(size), true));
            hashMap.put("modify_time", Long.valueOf(System.currentTimeMillis() / 1000));
            int i = this.mParentOrderInfo.orderType;
            if (i == 0) {
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("route_id", whetherToEncodeParameter(str, true));
                } else if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("route_id", whetherToEncodeParameter(str2, true));
                }
                hashMap.put("status", Integer.valueOf(this.mParentOrderInfo.orderState));
                generateRunAndRemainInfo(hashMap);
            } else if (i == 1) {
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("route_id", whetherToEncodeParameter(str, true));
                } else if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("route_id", whetherToEncodeParameter(str2, true));
                }
                hashMap.put("status", "10");
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    generateRunAndRemainInfo(hashMap);
                }
            }
            hashMap.put("order_type", Integer.valueOf(this.mParentOrderInfo.orderType));
            hashMap.put("trip_mode", getTripMode());
            hashMap.put("token", whetherToEncodeParameter(this.mAuthToken, true));
            String requestData = getRequestData(hashMap, 1);
            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
            if (syncShareImpl != null) {
                hashMap.put(HttpConstants.SIGN, syncShareImpl.getSignMD5String(requestData));
            }
            BDLog.e("ShareLocationManagerparamSign", requestData);
            String requestData2 = getRequestData(hashMap, 0);
            BDLog.d(TAG, "*******update location data:" + requestData2);
            return sendLocationInfo(requestData2, size);
        } catch (Exception e) {
            BDLog.dforce(TAG, "updateLocationInfo exception happened.", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateOrder(OrderInfoProtocol orderInfoProtocol) {
        if (orderInfoProtocol == null) {
            BDLog.e(TAG, "BNOrderInfo is null");
            return false;
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("order_id", whetherToEncodeParameter(MD5Util.getMD5String(orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId), true));
            hashMap.put("company", whetherToEncodeParameter(orderInfoProtocol.companyServerId, true));
            hashMap.put("order_attr", whetherToEncodeParameter(orderInfoProtocol.driverId, true));
            hashMap.put("status", Integer.valueOf(orderInfoProtocol.orderState));
            hashMap.put("modify_time", Long.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("order_type", Integer.valueOf(orderInfoProtocol.orderType));
            hashMap.put("trip_mode", getTripMode());
            hashMap.put("token", whetherToEncodeParameter(this.mAuthToken, true));
            String requestData = getRequestData(hashMap, 1);
            SyncShareImpl syncShareImpl = this.mShareManagerImpl;
            if (syncShareImpl != null) {
                hashMap.put(HttpConstants.SIGN, syncShareImpl.getSignMD5String(requestData));
            }
            BDLog.e("ShareLocationManagerparamSign", requestData);
            String requestData2 = getRequestData(hashMap, 0);
            BDLog.d(TAG, "updateOrder data:" + requestData2);
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.delete("orderInfo", "orderId = ? and remark = ?", new String[]{orderInfoProtocol.getOrderId(), "update_order"});
                this.mDatabase.execSQL("insert into orderInfo (orderId,companyServerId,driverId,orderState,cur_point,start_point,start_poiid,start_name,end_point,end_poiid,end_name,cuid,remark,order_type,parent_order_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[]{orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId, orderInfoProtocol.driverId, String.valueOf(orderInfoProtocol.orderState), (String) hashMap.get("cur_pos"), "", "", "", "", "", "", "", "update_order", String.valueOf(orderInfoProtocol.orderType), getParentOrderId()});
            }
            return sendUpdateOrder(orderInfoProtocol.getOrderId(), requestData2);
        } catch (Exception e) {
            BDLog.dforce(TAG, "updateOrder exception happened", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0340 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0008, B:10:0x0014, B:12:0x001b, B:14:0x0026, B:17:0x002e, B:19:0x0036, B:22:0x003f, B:24:0x0045, B:26:0x0049, B:28:0x004d, B:31:0x0052, B:35:0x005d, B:36:0x0079, B:38:0x00ca, B:40:0x00db, B:42:0x00e4, B:44:0x00ed, B:46:0x00f6, B:48:0x0101, B:50:0x010c, B:52:0x011e, B:54:0x0127, B:56:0x0134, B:58:0x0141, B:61:0x014d, B:63:0x015b, B:66:0x0165, B:69:0x025c, B:71:0x0266, B:74:0x027a, B:75:0x0281, B:76:0x0286, B:78:0x02a8, B:80:0x02ae, B:81:0x02b3, B:83:0x02b7, B:85:0x02bd, B:86:0x0338, B:88:0x0340, B:91:0x0349, B:97:0x0171, B:99:0x0193, B:101:0x0199, B:102:0x01bc, B:104:0x01c8, B:106:0x01ce, B:107:0x01ef, B:110:0x01f5, B:112:0x0202, B:114:0x022b, B:116:0x0239, B:117:0x01e8, B:118:0x01b4, B:120:0x034f, B:122:0x0071, B:123:0x0059, B:124:0x0093, B:127:0x009c, B:130:0x00a5), top: B:4:0x0006, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0349 A[Catch: all -> 0x0011, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0008, B:10:0x0014, B:12:0x001b, B:14:0x0026, B:17:0x002e, B:19:0x0036, B:22:0x003f, B:24:0x0045, B:26:0x0049, B:28:0x004d, B:31:0x0052, B:35:0x005d, B:36:0x0079, B:38:0x00ca, B:40:0x00db, B:42:0x00e4, B:44:0x00ed, B:46:0x00f6, B:48:0x0101, B:50:0x010c, B:52:0x011e, B:54:0x0127, B:56:0x0134, B:58:0x0141, B:61:0x014d, B:63:0x015b, B:66:0x0165, B:69:0x025c, B:71:0x0266, B:74:0x027a, B:75:0x0281, B:76:0x0286, B:78:0x02a8, B:80:0x02ae, B:81:0x02b3, B:83:0x02b7, B:85:0x02bd, B:86:0x0338, B:88:0x0340, B:91:0x0349, B:97:0x0171, B:99:0x0193, B:101:0x0199, B:102:0x01bc, B:104:0x01c8, B:106:0x01ce, B:107:0x01ef, B:110:0x01f5, B:112:0x0202, B:114:0x022b, B:116:0x0239, B:117:0x01e8, B:118:0x01b4, B:120:0x034f, B:122:0x0071, B:123:0x0059, B:124:0x0093, B:127:0x009c, B:130:0x00a5), top: B:4:0x0006, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean updateRoute(com.baidu.datahub.protocol.ShareRouteInfoProtocol r22) {
        /*
            Method dump skipped, instructions count: 859
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.updateRoute(com.baidu.datahub.protocol.ShareRouteInfoProtocol):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean updateWayPointInfo() {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.datahub.ShareLocationManager.updateWayPointInfo():boolean");
    }

    public List<ShareETAInfoProtocol> getETAInfos() {
        if (this.mShareManagerImpl == null) {
            BDLog.e(TAG, "getETAInfos ShareManagerInterface cannot be empty");
            return null;
        }
        int i = this.mOrderType;
        if (1 == i) {
            BDLog.e(TAG, "getETAInfos CAR_POOL_ORDER");
            return this.mShareManagerImpl.getCarPoolETAInfos();
        }
        if (i != 0) {
            return null;
        }
        BDLog.e(TAG, "getETAInfos NORMAL_ORDER");
        return this.mShareManagerImpl.getNormalETAInfos();
    }

    public String getTripMode() {
        NavigationType navigationType = this.mNavigationType;
        if (navigationType == NavigationType.DRIVER) {
            return "driving";
        }
        if (navigationType == NavigationType.WALK) {
            return "walking";
        }
        return "riding";
    }

    public boolean isHttpsEnable() {
        return HttpClient.isHttpsEnable;
    }

    public synchronized void onDestory() {
        try {
            unregisterShareLocationHandler(this.mShareLocationHandler);
            TimerTask timerTask = this.mUpdateInfoTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.mUpdateInfoTask = null;
            }
            Timer timer = this.mUpdateInfoTimer;
            if (timer != null) {
                timer.cancel();
                this.mUpdateInfoTimer = null;
            }
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.isOpen()) {
                    this.mDatabase.close();
                }
                this.mDatabase = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void onFinish(List<? extends OrderInfoProtocol> list) {
        try {
            loadOrderInfo();
            loadRouteInfo(getParentOrderId());
            if (list != null) {
                for (OrderInfoProtocol orderInfoProtocol : list) {
                    if (orderInfoProtocol != null) {
                        updateOrder(orderInfoProtocol);
                    }
                }
            }
            updateLocationInfo(this.mRouteID);
            updateWayPointInfo();
            removeRouteInfoWithDefaultParentIDFromDB();
            if (isParentOrderInfoEmpty()) {
                return;
            }
            removeParentOrderRelatedInfoFromDB(getParentOrderId());
        } catch (Throwable th) {
            throw th;
        }
    }

    public void requestRouteInfo(OrderInfoProtocol orderInfoProtocol, final IRequestListenerProtocol iRequestListenerProtocol) {
        if (orderInfoProtocol != null && iRequestListenerProtocol != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", MD5Util.getMD5String(orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId));
            hashMap.put("company", orderInfoProtocol.companyServerId);
            hashMap.put("order_attr", orderInfoProtocol.driverId);
            hashMap.put("status", Integer.valueOf(orderInfoProtocol.orderState));
            hashMap.put("trip_mode", getTripMode());
            try {
                hashMap.put("token", this.mAuthToken);
                String requestData = getRequestData(hashMap, 0);
                SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                if (syncShareImpl != null) {
                    hashMap.put(HttpConstants.SIGN, syncShareImpl.getSignMD5String(requestData));
                }
                BDLog.e("ShareLocationManagerparamSign", requestData);
            } catch (Exception e) {
                BDLog.dforce(TAG, "requestRouteInfo exception happened.", e);
            }
            String requestData2 = getRequestData(hashMap, 0);
            BDLog.e("ShareLocationManagerrequestRoute data = ", requestData2);
            if (TextUtils.isEmpty(requestData2)) {
                BDLog.dforce(TAG, "requestRoute data isEmpty");
                return;
            } else {
                this.mBaseRequest.sendRequest(6, "GET", requestData2, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.7
                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onFailed(HttpClient.HttpStateError httpStateError, String str) {
                        ShareLocationManager.this.notifyBNListener(httpStateError, str, iRequestListenerProtocol);
                    }

                    @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                    public void onSuccess(String str) {
                        iRequestListenerProtocol.onRequestResult(200, "请求成功", str);
                    }
                });
                return;
            }
        }
        BDLog.dforce(TAG, "BNOrderInfo or listener is null");
    }

    public void retryRegisterShareLocationHandler() {
        if (this.mShareLocationHandler == null) {
            this.mShareLocationHandler = new ShareLocationHandler();
        }
        registerShareLocationHandler(this.mShareLocationHandler);
    }

    public void setHttpsEnable(boolean z) {
        HttpClient.isHttpsEnable = z;
    }

    public void setLogEnable(boolean z) {
        BDLog.setLogEnable(z);
    }

    public void unregisterShareLocationHandler(Handler handler) {
        SyncShareImpl syncShareImpl = this.mShareManagerImpl;
        if (syncShareImpl == null) {
            BDLog.e(TAG, "unregisterShareLocationHandler ShareManagerInterface cannot be empty");
            return;
        }
        int i = this.mOrderType;
        if (i == 0) {
            syncShareImpl.unregisterNormalShareLocationHandler(handler);
        } else if (1 == i) {
            syncShareImpl.unregisterCarPoolShareLocationHandler(handler);
        }
    }

    public boolean uploadRouteInfo(ShareRouteInfoProtocol shareRouteInfoProtocol, final IRequestListenerProtocol iRequestListenerProtocol) {
        if (shareRouteInfoProtocol != null && iRequestListenerProtocol != null) {
            List<? extends OrderInfoProtocol> list = shareRouteInfoProtocol.orderInfos;
            if (list != null && list.size() >= 1) {
                OrderInfoProtocol orderInfoProtocol = list.get(0);
                if (orderInfoProtocol == null) {
                    BDLog.dforce(TAG, "bnOrderInfo is null");
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("order_id", MD5Util.getMD5String(orderInfoProtocol.getOrderId(), orderInfoProtocol.companyServerId));
                hashMap.put("company", orderInfoProtocol.companyServerId);
                hashMap.put("order_attr", orderInfoProtocol.driverId);
                hashMap.put("status", Integer.valueOf(orderInfoProtocol.orderState));
                hashMap.put("session_id", shareRouteInfoProtocol.sessionId);
                hashMap.put("mrsl", shareRouteInfoProtocol.mrsl);
                hashMap.put("route_id", shareRouteInfoProtocol.curRouteMD5);
                hashMap.put("start_point", shareRouteInfoProtocol.startNode);
                hashMap.put("end_point", shareRouteInfoProtocol.endNode);
                hashMap.put("preference", Integer.valueOf(shareRouteInfoProtocol.preference));
                hashMap.put("coord_type", "gcj02");
                hashMap.put("trip_mode", getTripMode());
                try {
                    hashMap.put("token", this.mAuthToken);
                    String requestData = getRequestData(hashMap, 0);
                    SyncShareImpl syncShareImpl = this.mShareManagerImpl;
                    if (syncShareImpl != null) {
                        hashMap.put(HttpConstants.SIGN, syncShareImpl.getSignMD5String(requestData));
                    }
                    BDLog.e("ShareLocationManagerparamSign", requestData);
                    String requestData2 = getRequestData(getURLEncodeRequestData(hashMap), 0);
                    BDLog.e("ShareLocationManageruploadRoute data = ", requestData2);
                    if (requestData2.isEmpty()) {
                        BDLog.dforce(TAG, "uploadRoute data isEmpty");
                        return false;
                    }
                    this.mBaseRequest.sendRequest(5, "POST", requestData2, new HttpClient.ProtoResultCallBack() { // from class: com.baidu.datahub.ShareLocationManager.6
                        @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                        public void onFailed(HttpClient.HttpStateError httpStateError, String str) {
                            ShareLocationManager.this.notifyBNListener(httpStateError, str, iRequestListenerProtocol);
                        }

                        @Override // com.baidu.datahub.HttpClient.ProtoResultCallBack
                        public void onSuccess(String str) {
                            iRequestListenerProtocol.onRequestResult(200, "请求成功", str);
                        }
                    });
                    return true;
                } catch (Exception e) {
                    BDLog.dforce(TAG, "uploadRouteInfo exception happened.", e);
                    return false;
                }
            }
            BDLog.dforce(TAG, "orderInfos is null");
            return false;
        }
        BDLog.dforce(TAG, "BNShareRouteInfo or listener is null");
        return false;
    }

    public String whetherToEncodeParameter(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (z) {
                return URLEncoder.encode(str, "utf-8");
            }
            return str;
        } catch (UnsupportedEncodingException e) {
            BDLog.e(TAG, "encode encodeStr failed:" + e.toString());
            return "";
        }
    }

    public ShareLocationManager(String str, String str2, int i, SyncShareImpl syncShareImpl) {
        initManager(str, str2, i, syncShareImpl, NavigationType.DRIVER);
    }
}
