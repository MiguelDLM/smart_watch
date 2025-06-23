package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.SmaNotification;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.ActivityDao;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.status.CaloriesActivity;
import com.sma.smartv3.ui.status.DistanceActivity;
import com.sma.smartv3.ui.status.Weather2Activity;
import com.sma.smartv3.ui.status.WeatherActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleWeatherRealtime;
import com.szabh.smable3.entity.BleWeatherRealtime2;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMainStepItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainStepItem.kt\ncom/sma/smartv3/ui/status/item/MainStepItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,195:1\n19#2:196\n15#2:197\n*S KotlinDebug\n*F\n+ 1 MainStepItem.kt\ncom/sma/smartv3/ui/status/item/MainStepItem\n*L\n99#1:196\n99#1:197\n*E\n"})
/* loaded from: classes12.dex */
public class MainStepItem extends BaseDslItem {

    @OXOo.oOoXoXO
    private Activity activity;
    public PFMedium distanceUnit;
    private ImageView ivWeather;
    public Context mContext;
    private DINCondBold tvCalorie;
    private DINCondBold tvDistance;
    public DINCondBold tvTemperature;
    public DINCondBold tvWeatherTime;
    public AppUser userProfile;

    @OXOo.OOXIXo
    private final ActivityDao mActivityDao = MyDb.INSTANCE.getMDatabase().activityDao();
    private final boolean initEvent = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(MainStepItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.weatherDetailsEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(MainStepItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (com.sma.smartv3.ui.status.x0XOIxOo.f24154oIX0oI.oIX0oI()) {
            ContextCompat.startActivity(this$0.getMContext(), new Intent(this$0.getMContext(), (Class<?>) CaloriesActivity.class), new Bundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2(MainStepItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (com.sma.smartv3.ui.status.x0XOIxOo.f24154oIX0oI.oIX0oI()) {
            ContextCompat.startActivity(this$0.getMContext(), new Intent(this$0.getMContext(), (Class<?>) DistanceActivity.class), new Bundle());
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.tvCalorie);
        IIX0o.ooOOo0oXI(v);
        this.tvCalorie = (DINCondBold) v;
        View v2 = itemHolder.v(R.id.tvDistance);
        IIX0o.ooOOo0oXI(v2);
        this.tvDistance = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.ivWeather);
        IIX0o.ooOOo0oXI(v3);
        this.ivWeather = (ImageView) v3;
        DINCondBold dINCondBold = null;
        if (ProjectManager.f19822oIX0oI.xOOxI()) {
            ImageView imageView = this.ivWeather;
            if (imageView == null) {
                IIX0o.XOxIOxOx("ivWeather");
                imageView = null;
            }
            Object parent = imageView.getParent();
            IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.xxIXOIIO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainStepItem.bindView$lambda$0(MainStepItem.this, view);
                }
            });
        }
        View v4 = itemHolder.v(R.id.tvTemperature);
        IIX0o.ooOOo0oXI(v4);
        setTvTemperature((DINCondBold) v4);
        View v5 = itemHolder.v(R.id.tvWeatherTime);
        IIX0o.ooOOo0oXI(v5);
        setTvWeatherTime((DINCondBold) v5);
        View v6 = itemHolder.v(R.id.distanceUnit);
        IIX0o.ooOOo0oXI(v6);
        setDistanceUnit((PFMedium) v6);
        DINCondBold dINCondBold2 = this.tvCalorie;
        if (dINCondBold2 == null) {
            IIX0o.XOxIOxOx("tvCalorie");
        } else {
            dINCondBold = dINCondBold2;
        }
        Context context = dINCondBold.getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
        View view = itemHolder.view(R.id.llCalories);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.xoIox
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainStepItem.bindView$lambda$1(MainStepItem.this, view2);
                }
            });
        }
        View view2 = itemHolder.view(R.id.llDistance);
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.OOXIXo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    MainStepItem.bindView$lambda$2(MainStepItem.this, view3);
                }
            });
        }
    }

    @OXOo.oOoXoXO
    public final Activity getActivity() {
        return this.activity;
    }

    @OXOo.OOXIXo
    public final PFMedium getDistanceUnit() {
        PFMedium pFMedium = this.distanceUnit;
        if (pFMedium != null) {
            return pFMedium;
        }
        IIX0o.XOxIOxOx("distanceUnit");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @OXOo.OOXIXo
    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    @OXOo.OOXIXo
    public final DINCondBold getTvTemperature() {
        DINCondBold dINCondBold = this.tvTemperature;
        if (dINCondBold != null) {
            return dINCondBold;
        }
        IIX0o.XOxIOxOx("tvTemperature");
        return null;
    }

    @OXOo.OOXIXo
    public final DINCondBold getTvWeatherTime() {
        DINCondBold dINCondBold = this.tvWeatherTime;
        if (dINCondBold != null) {
            return dINCondBold;
        }
        IIX0o.XOxIOxOx("tvWeatherTime");
        return null;
    }

    @OXOo.OOXIXo
    public final AppUser getUserProfile() {
        AppUser appUser = this.userProfile;
        if (appUser != null) {
            return appUser;
        }
        IIX0o.XOxIOxOx("userProfile");
        return null;
    }

    @OXOo.OOXIXo
    public String getWeatherDateTimeString() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            currentTimeMillis = Xo0.f24349oIX0oI.I0Io().getLong(XoI0Ixx0.f24432Xx000oIo, System.currentTimeMillis());
        } catch (Exception unused) {
        }
        String format = com.sma.smartv3.util.xoIox.I0X0x0oIo(false, 1, null).format(Long.valueOf(currentTimeMillis));
        IIX0o.oO(format, "format(...)");
        return format;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        setUserProfile((AppUser) appUser);
        updateActivity();
        updateWeather();
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_step;
    }

    @XO0.XO(tag = x0xO0oo.f24629oIX0oI)
    public final void onActivityChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onActivityChanged");
        updateActivity();
    }

    @XO0.XO(tag = x0xO0oo.f24578IoOoo)
    public final void onUnitChange(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onUnitChange");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24662xoIox)
    public final void onWeatherRealtimeChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onWeatherRealtimeChanged");
        updateWeather();
    }

    public final void setActivity(@OXOo.oOoXoXO Activity activity) {
        this.activity = activity;
    }

    public final void setDistanceUnit(@OXOo.OOXIXo PFMedium pFMedium) {
        IIX0o.x0xO0oo(pFMedium, "<set-?>");
        this.distanceUnit = pFMedium;
    }

    public final void setMContext(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }

    public final void setTvTemperature(@OXOo.OOXIXo DINCondBold dINCondBold) {
        IIX0o.x0xO0oo(dINCondBold, "<set-?>");
        this.tvTemperature = dINCondBold;
    }

    public final void setTvWeatherTime(@OXOo.OOXIXo DINCondBold dINCondBold) {
        IIX0o.x0xO0oo(dINCondBold, "<set-?>");
        this.tvWeatherTime = dINCondBold;
    }

    public final void setUserProfile(@OXOo.OOXIXo AppUser appUser) {
        IIX0o.x0xO0oo(appUser, "<set-?>");
        this.userProfile = appUser;
    }

    public void updateActivity() {
        getDistanceUnit().setText(TextConvertKt.oI0IIXIo(getUserProfile().getUnit()));
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        Activity activity = this.mActivityDao.getActivity(OxI2[0], OxI2[1]);
        if (activity == null) {
            activity = new Activity(0, 0L, null, 0, 0, 0, 0, 0, 0, 0, 1023, null);
        }
        this.activity = activity;
        DINCondBold dINCondBold = this.tvCalorie;
        if (dINCondBold == null) {
            IIX0o.XOxIOxOx("tvCalorie");
            dINCondBold = null;
        }
        Activity activity2 = this.activity;
        IIX0o.ooOOo0oXI(activity2);
        dINCondBold.setText(String.valueOf(activity2.getMCalorie() / 10000));
        DINCondBold dINCondBold2 = this.tvDistance;
        if (dINCondBold2 == null) {
            IIX0o.XOxIOxOx("tvDistance");
            dINCondBold2 = null;
        }
        Activity activity3 = this.activity;
        IIX0o.ooOOo0oXI(activity3);
        dINCondBold2.setText(TextConvertKt.Oo(activity3.getMDistance() / 10000, getUserProfile().getUnit(), false, 4, null));
        if (ProductManager.f20544oIX0oI.xx00oOoI() && Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24371IoOoo, true)) {
            SmaNotification oIX0oI2 = SmaNotification.f20192Oxx0IOOO.oIX0oI();
            Activity activity4 = this.activity;
            IIX0o.ooOOo0oXI(activity4);
            int mStep = activity4.getMStep();
            Activity activity5 = this.activity;
            IIX0o.ooOOo0oXI(activity5);
            oIX0oI2.oOoXoXO(mStep, activity5.getMCalorie() / 10000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateWeather() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.status.item.MainStepItem.updateWeather():void");
    }

    public final void weatherDetailsEvent() {
        if (ProductManager.f20544oIX0oI.IXIIo()) {
            if (((BleWeatherRealtime2) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WEATHER_REALTIME2, BleWeatherRealtime2.class, null, 4, null)) != null) {
                ContextCompat.startActivity(getMContext(), new Intent(getMContext(), (Class<?>) Weather2Activity.class), new Bundle());
                return;
            } else {
                ToastUtils.showLong(R.string.no_weather);
                return;
            }
        }
        if (((BleWeatherRealtime) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WEATHER_REALTIME, BleWeatherRealtime.class, null, 4, null)) != null) {
            ContextCompat.startActivity(getMContext(), new Intent(getMContext(), (Class<?>) WeatherActivity.class), new Bundle());
        } else {
            ToastUtils.showLong(R.string.no_weather);
        }
    }
}
