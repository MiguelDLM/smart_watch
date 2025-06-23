package com.sma.smartv3.location;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleLocationReply;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class oxoX {

    /* renamed from: II0xO0 */
    @oOoXoXO
    public I0Io f20959II0xO0;

    /* renamed from: oIX0oI */
    @oOoXoXO
    public BaiDuLocationClient f20960oIX0oI;

    public oxoX() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ void Oxx0IOOO(oxoX oxox, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        oxox.XO(i, z);
    }

    public final void I0Io(@oOoXoXO BaiDuLocationClient baiDuLocationClient) {
        this.f20960oIX0oI = baiDuLocationClient;
    }

    public final void II0XooXoX() {
        BaiDuLocationClient baiDuLocationClient = this.f20960oIX0oI;
        if (baiDuLocationClient != null) {
            BaiDuLocationClient.Oxx0IOOO(baiDuLocationClient, false, 1, null);
        }
        I0Io i0Io = this.f20959II0xO0;
        if (i0Io != null) {
            I0Io.XO(i0Io, false, 1, null);
        }
    }

    @oOoXoXO
    public final I0Io II0xO0() {
        return this.f20959II0xO0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v3 */
    public final void X0o0xo(@OOXIXo oIX0oI location) {
        String str;
        int i;
        ?? r7;
        IIX0o.x0xO0oo(location, "location");
        int IIX02 = oOIx.oxoX.IIX0(location.oIX0oI());
        BleInitializer bleInitializer = BleInitializer.f20700XO;
        if (!bleInitializer.xoO0xx0()) {
            str = "format(...)";
            i = 1;
            r7 = 0;
        } else {
            Xo0 xo0 = Xo0.f24349oIX0oI;
            String string = xo0.oIX0oI().getString(XoI0Ixx0.f24404Oxx0xo, "");
            IIX0o.ooOOo0oXI(string);
            if (string.length() == 0) {
                bleInitializer.Ix00oIoI(0);
            } else {
                List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(string, new String[]{","}, false, 0, 6, null);
                double distance = DistanceUtil.getDistance(new LatLng(Double.parseDouble((String) XXoO0oX2.get(0)), Double.parseDouble((String) XXoO0oX2.get(1))), new LatLng(location.II0xO0(), location.I0Io()));
                if (distance < 1.0d) {
                    LogUtils.d("Location sportRunLocationInfo -> too short tmpDistance=" + distance);
                    return;
                }
                bleInitializer.Ix00oIoI(bleInitializer.OO0x0xX() + ((int) distance));
            }
            Date date = new Date();
            LocationDao locationDao = MyDb.INSTANCE.getMDatabase().locationDao();
            long time = date.getTime();
            String format = xoIox.I0Io().format(date);
            IIX0o.oO(format, "format(...)");
            str = "format(...)";
            Location location2 = new Location(0, time, format, 0, IIX02, (float) location.I0Io(), (float) location.II0xO0(), location.oxoX(), 0, 0, 768, null);
            i = 1;
            r7 = 0;
            LogUtils.d("Location sportRunLocationInfo save location data -> " + location.I0Io() + TokenParser.SP + location.oIX0oI() + TokenParser.SP + location.X0o0xo());
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            locationDao.insert(CollectionsKt__CollectionsKt.Oxx0xo(location2));
            SPUtils oIX0oI2 = xo0.oIX0oI();
            StringBuilder sb = new StringBuilder();
            sb.append(location.II0xO0());
            sb.append(',');
            sb.append(location.I0Io());
            oIX0oI2.put(XoI0Ixx0.f24404Oxx0xo, sb.toString());
        }
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (bleConnector.isAvailable()) {
            Xo0 xo02 = Xo0.f24349oIX0oI;
            if (xo02.oIX0oI().getBoolean(XoI0Ixx0.f24361IIXOooo, r7)) {
                xo02.oIX0oI().put(XoI0Ixx0.f24361IIXOooo, (boolean) r7, (boolean) i);
                String format2 = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Float.valueOf(bleInitializer.OO0x0xX() / 1000.0f));
                IIX0o.oO(format2, str);
                float parseFloat = Float.parseFloat(format2);
                Object[] objArr = new Object[i];
                objArr[r7] = "Location sportRunLocationInfo send location data -> mSpeed=" + location.X0o0xo() + ", mTotalDistance=" + parseFloat + ", altitude=" + IIX02;
                LogUtils.d(objArr);
                BleConnector.sendObject$default(bleConnector, BleKey.REQUEST_LOCATION, BleKeyFlag.CREATE, new BleLocationReply(location.X0o0xo(), parseFloat, IIX02), false, false, 24, null);
                return;
            }
            return;
        }
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24405OxxIIOOXO, (boolean) i, (boolean) i);
    }

    public final void XO(int i, boolean z) {
        BaiDuLocationClient baiDuLocationClient = this.f20960oIX0oI;
        if (baiDuLocationClient != null) {
            baiDuLocationClient.oxoX(i, z);
        }
        I0Io i0Io = this.f20959II0xO0;
        if (i0Io != null) {
            i0Io.I0Io(i, z);
        }
    }

    @oOoXoXO
    public final BaiDuLocationClient oIX0oI() {
        return this.f20960oIX0oI;
    }

    public final void oxoX(@oOoXoXO I0Io i0Io) {
        this.f20959II0xO0 = i0Io;
    }

    public oxoX(@oOoXoXO BaiDuLocationClient baiDuLocationClient, @oOoXoXO I0Io i0Io) {
        this.f20960oIX0oI = baiDuLocationClient;
        this.f20959II0xO0 = i0Io;
    }

    public /* synthetic */ oxoX(BaiDuLocationClient baiDuLocationClient, I0Io i0Io, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : baiDuLocationClient, (i & 2) != 0 ? null : i0Io);
    }
}
