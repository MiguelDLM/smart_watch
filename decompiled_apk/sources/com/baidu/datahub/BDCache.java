package com.baidu.datahub;

import com.baidu.datahub.protocol.OrderInfoProtocol;
import com.baidu.datahub.protocol.ShareLocationInfoProtocol;
import com.huawei.openalliance.ad.constant.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class BDCache {
    private static int MAX_SIZE = 60;
    private static final String TAG = "BDCache";
    private static final int protocol_type_one = 1;
    private static final int protocol_type_two = 2;
    private CopyOnWriteArrayList<ShareLocationInfo> list = new CopyOnWriteArrayList<>();
    private OrderInfoProtocol mParentOrderInfo;

    public BDCache(OrderInfoProtocol orderInfoProtocol) {
        this.mParentOrderInfo = orderInfoProtocol;
    }

    private String calCoordinateDiff(double d, double d2) {
        StringBuilder sb = new StringBuilder();
        sb.append((int) ((d * 100000.0d) - (d2 * 100000.0d)));
        return sb.toString();
    }

    private String calSpeedDirectDiff(float f, float f2, int i) {
        StringBuilder sb = new StringBuilder();
        float f3 = i;
        sb.append((int) ((f * f3) - (f2 * f3)));
        return sb.toString();
    }

    private String getOrderStatsStr(List<? extends OrderInfoProtocol> list) {
        OrderInfoProtocol orderInfoProtocol = this.mParentOrderInfo;
        if (orderInfoProtocol != null && 1 == orderInfoProtocol.orderType) {
            return "10";
        }
        if (list != null && list.size() > 0) {
            Iterator<? extends OrderInfoProtocol> it = list.iterator();
            StringBuilder sb = new StringBuilder();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                OrderInfoProtocol next = it.next();
                if (next == null) {
                    BDLog.e(TAG, "[getOrderStatsStr]: null == orderInfo");
                } else {
                    sb.append(next.orderState);
                    break;
                }
            }
            return sb.toString();
        }
        BDLog.e(TAG, "[getOrderStatsStr]: orderInfos is empty");
        return String.valueOf(0);
    }

    public synchronized void addLocationInfoToCache(ShareLocationInfo shareLocationInfo) {
        while (this.list.size() >= MAX_SIZE) {
            try {
                this.list.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.list.add(shareLocationInfo);
    }

    public String formatPointsData(int i) {
        if (i <= MAX_SIZE && i > 0) {
            Iterator<ShareLocationInfo> it = this.list.iterator();
            if (!it.hasNext()) {
                BDLog.e(TAG, "[formatPointsData]: !value.hasNext()");
                return null;
            }
            ShareLocationInfo next = it.next();
            ShareLocationInfoProtocol info = next.getInfo();
            String valueOf = String.valueOf(1);
            String valueOf2 = String.valueOf(i);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = new StringBuffer();
            StringBuffer stringBuffer5 = new StringBuffer();
            StringBuffer stringBuffer6 = new StringBuffer();
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer.append(next.getTimestamp());
            stringBuffer2.append(getOrderStatsStr(info.orderInfos));
            StringBuilder sb = new StringBuilder();
            ShareLocationInfo shareLocationInfo = next;
            String str = TAG;
            sb.append((int) (info.postLongitude * 100000.0d));
            sb.append(",");
            sb.append((int) (info.postLatitude * 100000.0d));
            stringBuffer3.append(sb.toString());
            stringBuffer4.append((int) info.postDirection);
            stringBuffer5.append(((int) (info.gpsLongitude * 100000.0d)) + "," + ((int) (info.gpsLatitude * 100000.0d)));
            stringBuffer6.append((int) info.gpsDirection);
            stringBuffer7.append((int) (info.gpsSpeed * 10.0f));
            int i2 = i + (-1);
            while (it.hasNext() && i2 != 0) {
                ShareLocationInfo next2 = it.next();
                ShareLocationInfoProtocol info2 = next2.getInfo();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(",");
                long timestamp = next2.getTimestamp();
                long timestamp2 = shareLocationInfo.getTimestamp();
                String str2 = str;
                sb2.append(timestamp - timestamp2);
                stringBuffer.append(sb2.toString());
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(getOrderStatsStr(info2.orderInfos));
                StringBuilder sb3 = new StringBuilder();
                sb3.append(x.aL);
                StringBuffer stringBuffer8 = stringBuffer6;
                StringBuffer stringBuffer9 = stringBuffer7;
                sb3.append(calCoordinateDiff(info2.postLongitude, info.postLongitude));
                sb3.append(",");
                sb3.append(calCoordinateDiff(info2.postLatitude, info.postLatitude));
                stringBuffer3.append(sb3.toString());
                stringBuffer4.append("," + calSpeedDirectDiff(info2.postDirection, info.postDirection, 1));
                stringBuffer5.append(x.aL + calCoordinateDiff(info2.gpsLongitude, info.gpsLongitude) + "," + calCoordinateDiff(info2.gpsLatitude, info.gpsLatitude));
                StringBuilder sb4 = new StringBuilder();
                sb4.append(",");
                sb4.append(calSpeedDirectDiff(info2.gpsDirection, info.gpsDirection, 1));
                stringBuffer8.append(sb4.toString());
                stringBuffer9.append("," + calSpeedDirectDiff(info2.gpsSpeed, info.gpsSpeed, 10));
                info = next2.getInfo();
                i2 += -1;
                stringBuffer7 = stringBuffer9;
                stringBuffer6 = stringBuffer8;
                str = str2;
                stringBuffer = stringBuffer;
                stringBuffer2 = stringBuffer2;
                shareLocationInfo = next2;
            }
            StringBuffer stringBuffer10 = new StringBuffer();
            stringBuffer10.append(valueOf);
            stringBuffer10.append("|");
            stringBuffer10.append(valueOf2);
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer.toString());
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer2.toString());
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer3.toString());
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer4.toString());
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer5.toString());
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer6.toString());
            stringBuffer10.append("|");
            stringBuffer10.append(stringBuffer7.toString());
            BDLog.d(str, "points:" + stringBuffer10.toString());
            return stringBuffer10.toString();
        }
        BDLog.e(TAG, "[formatPointsData]: number > MAX_SIZE || number <= 0, number" + i);
        return null;
    }

    public ShareLocationInfoProtocol getLastLocation(int i) {
        if (i > MAX_SIZE && i <= 0) {
            return null;
        }
        return this.list.get(i - 1).getInfo();
    }

    public int getSize() {
        return this.list.size();
    }

    public synchronized void remove(int i) {
        if (i <= MAX_SIZE && i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                this.list.remove(0);
            }
        }
    }
}
