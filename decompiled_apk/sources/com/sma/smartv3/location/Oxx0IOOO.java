package com.sma.smartv3.location;

import OXOo.OOXIXo;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class Oxx0IOOO extends BDAbstractLocationListener {
    public abstract void II0xO0(@OOXIXo oIX0oI oix0oi);

    public abstract void oIX0oI(@OOXIXo String str);

    @Override // com.baidu.location.BDAbstractLocationListener
    public void onReceiveLocation(@OOXIXo BDLocation location) {
        IIX0o.x0xO0oo(location, "location");
        if (!PermissionUtils.isGranted(PermissionConstants.LOCATION)) {
            return;
        }
        float radius = location.getRadius();
        String coorType = location.getCoorType();
        int locType = location.getLocType();
        String locTypeDescription = location.getLocTypeDescription();
        try {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("onReceiveLocation -> latitude=" + location.getLatitude() + ", longitude=" + location.getLongitude() + ", altitude=" + location.getAltitude() + ", speed=" + location.getSpeed() + ", radius=" + radius + ", coorType=" + coorType + ", locType=" + locType + ", locTypeDescription=" + locTypeDescription + ", GPS=" + location.getGpsAccuracyStatus() + ", gpsCheckStatus=" + location.getGpsCheckStatus() + ", isAppForeground=" + AppUtils.isAppForeground());
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        String str = location.getAddress().address;
        if (str != null) {
            LogUtils.d("onReceiveLocation -> address:" + str);
        }
        if (locType != 61 && locType != 161 && locType != 65 && locType != 66) {
            oIX0oI("error=" + location.getLocType() + ", description=" + location.getLocTypeDescription());
            return;
        }
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLongitude());
        sb.append(',');
        sb.append(location.getLatitude());
        sb.append(',');
        sb.append(location.getAltitude());
        XO2.put(XoI0Ixx0.f24423XX, sb.toString());
        x0xO0oo.II0xO0(XoI0Ixx0.f24423XX, null, 2, null);
        II0xO0(new oIX0oI(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getSpeed(), 1));
    }
}
