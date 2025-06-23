package com.sma.smartv3.location;

import OXOo.OOXIXo;
import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.util.permission.PermissionHelper;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BaiDuLocationClient {

    /* renamed from: X0o0xo */
    @OOXIXo
    public static final oIX0oI f20938X0o0xo = new oIX0oI(null);

    /* renamed from: I0Io */
    @OOXIXo
    public final X0IIOO f20939I0Io;

    /* renamed from: II0xO0 */
    @OOXIXo
    public final String f20940II0xO0;

    /* renamed from: oIX0oI */
    @OOXIXo
    public final Context f20941oIX0oI;

    /* renamed from: oxoX */
    @OOXIXo
    public final LocationManager f20942oxoX;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ BaiDuLocationClient II0xO0(oIX0oI oix0oi, Oxx0IOOO oxx0IOOO, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return oix0oi.oIX0oI(oxx0IOOO, z);
        }

        @OOXIXo
        public final BaiDuLocationClient I0Io(@OOXIXo Oxx0IOOO listener) {
            IIX0o.x0xO0oo(listener, "listener");
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            BaiDuLocationClient baiDuLocationClient = new BaiDuLocationClient(app, "sport show");
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("bd09ll");
            locationClientOption.setOnceLocation(true);
            locationClientOption.setIsNeedAddress(true);
            locationClientOption.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
            LocationClient II0xO02 = baiDuLocationClient.II0xO0();
            II0xO02.setLocOption(locationClientOption);
            II0xO02.registerLocationListener(listener);
            return baiDuLocationClient;
        }

        @OOXIXo
        public final BaiDuLocationClient oIX0oI(@OOXIXo Oxx0IOOO listener, boolean z) {
            IIX0o.x0xO0oo(listener, "listener");
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            BaiDuLocationClient baiDuLocationClient = new BaiDuLocationClient(app, "baidu run");
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            locationClientOption.setCoorType("bd09ll");
            locationClientOption.setScanSpan(ProjectManager.f19822oIX0oI.O0xOxO());
            locationClientOption.setIsNeedAltitude(true);
            locationClientOption.setIsNeedAddress(z);
            locationClientOption.setFirstLocType(LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC);
            LocationClient II0xO02 = baiDuLocationClient.II0xO0();
            II0xO02.setLocOption(locationClientOption);
            II0xO02.registerLocationListener(listener);
            return baiDuLocationClient;
        }

        public oIX0oI() {
        }
    }

    public BaiDuLocationClient(@OOXIXo Context mContext, @OOXIXo String mTag) {
        IIX0o.x0xO0oo(mContext, "mContext");
        IIX0o.x0xO0oo(mTag, "mTag");
        this.f20941oIX0oI = mContext;
        this.f20940II0xO0 = mTag;
        this.f20939I0Io = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationClient>() { // from class: com.sma.smartv3.location.BaiDuLocationClient$mBaiDuClient$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final LocationClient invoke() {
                LocationClient.setAgreePrivacy(true);
                return new LocationClient(BaiDuLocationClient.this.I0Io().getApplicationContext());
            }
        });
        Object systemService = mContext.getSystemService("location");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.f20942oxoX = (LocationManager) systemService;
    }

    public static /* synthetic */ void Oxx0IOOO(BaiDuLocationClient baiDuLocationClient, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        baiDuLocationClient.XO(z);
    }

    public static /* synthetic */ void X0o0xo(BaiDuLocationClient baiDuLocationClient, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        baiDuLocationClient.oxoX(i, z);
    }

    @OOXIXo
    public final Context I0Io() {
        return this.f20941oIX0oI;
    }

    public final LocationClient II0xO0() {
        return (LocationClient) this.f20939I0Io.getValue();
    }

    public final void XO(boolean z) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("LocationClient " + this.f20940II0xO0 + " -> stopLocation");
        if (z) {
            II0xO0().disableLocInForeground(true);
        }
        II0xO0().stop();
    }

    public final void oxoX(int i, boolean z) {
        if (z) {
            II0xO0().enableLocInForeground(1, X0o0xo.I0Io(i).build());
        }
        boolean isProviderEnabled = this.f20942oxoX.isProviderEnabled("gps");
        boolean oI0IIXIo2 = PermissionHelper.f24522oIX0oI.oI0IIXIo(this.f20941oIX0oI);
        LocationClientOption locOption = II0xO0().getLocOption();
        locOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        OI0.oIX0oI.f1507oIX0oI.XO(this.f20940II0xO0 + " -> startLocation " + z + ", p:" + isProviderEnabled + ", m:" + locOption.getLocationMode() + ", b:" + oI0IIXIo2);
        II0xO0().start();
    }
}
