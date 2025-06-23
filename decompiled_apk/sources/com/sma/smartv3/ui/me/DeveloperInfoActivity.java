package com.sma.smartv3.ui.me;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.google.gson.Gson;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.initializer.WeatherInitializer;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleGoMoreSettings;
import com.szabh.smable3.entity.BleSedentarinessSettings;
import com.szabh.smable3.entity.BleWeatherForecast;
import com.szabh.smable3.entity.BleWeatherRealtime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperInfoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperInfoActivity.kt\ncom/sma/smartv3/ui/me/DeveloperInfoActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,75:1\n18#2,2:76\n15#2:78\n*S KotlinDebug\n*F\n+ 1 DeveloperInfoActivity.kt\ncom/sma/smartv3/ui/me/DeveloperInfoActivity\n*L\n30#1:76,2\n30#1:78\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperInfoActivity extends BaseListActivity<OooO0XOx> {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mDeviceInfo$delegate;
    private boolean mIsOpenRunTimeLog;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mMtkOtaMeta$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mNotificationListener$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String>() { // from class: com.sma.smartv3.ui.me.DeveloperInfoActivity$mNotificationListener$2
        {
            super(0);
        }

        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final String invoke() {
            Activity mContext;
            StringBuilder sb = new StringBuilder();
            sb.append("isEnabled=");
            MyNotificationListenerService.oIX0oI oix0oi = MyNotificationListenerService.f20319OxI;
            mContext = DeveloperInfoActivity.this.getMContext();
            sb.append(oix0oi.X0o0xo(mContext));
            sb.append(", isRunning=");
            sb.append(oix0oi.XO());
            return sb.toString();
        }
    });

    @OXOo.OOXIXo
    private final BleSedentarinessSettings mSedentarinessSettings;

    @OXOo.OOXIXo
    private final String mWeather;

    @OXOo.OOXIXo
    private final String mWeatherForecast;

    @OXOo.OOXIXo
    private final String mWeatherRealtime;

    @OXOo.OOXIXo
    private final com.sma.smartv3.initializer.O0xOxO mWeatherStatus;

    public DeveloperInfoActivity() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        Object fromJson = new Gson().fromJson(xo0.II0xO0().getString(com.sma.smartv3.initializer.O0xOxO.class.getName()), (Class<Object>) com.sma.smartv3.initializer.O0xOxO.class);
        com.sma.smartv3.initializer.O0xOxO o0xOxO = (com.sma.smartv3.initializer.O0xOxO) (fromJson == null ? com.sma.smartv3.initializer.O0xOxO.class.newInstance() : fromJson);
        this.mWeatherStatus = o0xOxO;
        BleCache bleCache = BleCache.INSTANCE;
        String valueOf = String.valueOf(BleCache.getObject$default(bleCache, BleKey.WEATHER_REALTIME, BleWeatherRealtime.class, null, 4, null));
        this.mWeatherRealtime = valueOf;
        String valueOf2 = String.valueOf(BleCache.getObject$default(bleCache, BleKey.WEATHER_FORECAST, BleWeatherForecast.class, null, 4, null));
        this.mWeatherForecast = valueOf2;
        this.mWeather = o0xOxO + "\n\n" + valueOf + "\n\n" + valueOf2;
        this.mDeviceInfo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String>() { // from class: com.sma.smartv3.ui.me.DeveloperInfoActivity$mDeviceInfo$2
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final String invoke() {
                return String.valueOf(BleCache.INSTANCE.getMDeviceInfo());
            }
        });
        this.mMtkOtaMeta$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String>() { // from class: com.sma.smartv3.ui.me.DeveloperInfoActivity$mMtkOtaMeta$2
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final String invoke() {
                return BleCache.INSTANCE.getMtkOtaMeta();
            }
        });
        this.mIsOpenRunTimeLog = xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24433XxX0x0xxx, false);
        this.mSedentarinessSettings = (BleSedentarinessSettings) BleCache.getObjectNotNull$default(bleCache, BleKey.SEDENTARINESS, BleSedentarinessSettings.class, null, null, 12, null);
    }

    private final String getMDeviceInfo() {
        return (String) this.mDeviceInfo$delegate.getValue();
    }

    private final String getMMtkOtaMeta() {
        return (String) this.mMtkOtaMeta$delegate.getValue();
    }

    private final String getMNotificationListener() {
        return (String) this.mNotificationListener$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<OooO0XOx> initList() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        return CollectionsKt__CollectionsKt.XOxIOxOx(new OooO0XOx("Support Devices", String.valueOf(productManager.OX())), new OooO0XOx("NotificationListenerService", getMNotificationListener()), new OooO0XOx(WeatherInitializer.f20906Oo, this.mWeather), new OooO0XOx("BleDeviceInfo", getMDeviceInfo()), new OooO0XOx("MtkOtaMeta", getMMtkOtaMeta()), new OooO0XOx("OnlineDeviceConfigInfo", String.valueOf(productManager.IOoo())), new OooO0XOx("gomore", ((BleGoMoreSettings) BleCache.getObjectNotNull$default(BleCache.INSTANCE, BleKey.GOMORE_SET, BleGoMoreSettings.class, null, null, 12, null)).toString()));
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.simple_list_item_2;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return com.sma.smartv3.co_fit.R.layout.activity_developer_info;
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo OooO0XOx item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(R.id.text1, (i + 1) + ". " + item.XO());
        holder.o00(R.id.text2, item.X0o0xo());
    }
}
