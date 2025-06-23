package com.sma.smartv3.ui.status;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.WeatherRealtime;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleWeather;
import com.szabh.smable3.entity.BleWeatherForecast;
import com.szabh.smable3.entity.BleWeatherRealtime;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeatherActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeatherActivity.kt\ncom/sma/smartv3/ui/status/WeatherActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,165:1\n19#2:166\n15#2:167\n19#2:168\n15#2:169\n90#2:170\n*S KotlinDebug\n*F\n+ 1 WeatherActivity.kt\ncom/sma/smartv3/ui/status/WeatherActivity\n*L\n60#1:166\n60#1:167\n62#1:168\n62#1:169\n148#1:170\n*E\n"})
/* loaded from: classes12.dex */
public final class WeatherActivity extends BaseActivity {

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WeatherActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$bg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return WeatherActivity.this.findViewById(R.id.fl_bg);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$ivWeather$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WeatherActivity.this.findViewById(R.id.iv_weather);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvTemperatureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_temperature_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvTemperatureUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_temperature_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureMin$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvTemperatureMin$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_temperature_min);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureMax$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvTemperatureMax$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_temperature_max);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_name);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvUviValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvUviValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_uvi_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvHumidityValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvHumidityValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_humidity_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvVisibilityValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvVisibilityValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_visibility_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvVisibilityUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvVisibilityUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_visibility_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWindSpeedValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWindSpeedValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_wind_speed_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWindSpeedUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWindSpeedUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_wind_speed_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvPrecipitationValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvPrecipitationValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_precipitation_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvPrecipitationUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvPrecipitationUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_precipitation_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$ivWeather1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WeatherActivity.this.findViewById(R.id.iv_weather1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherValue1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_value1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherDate1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_date1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$ivWeather2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WeatherActivity.this.findViewById(R.id.iv_weather2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherValue2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_value2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherDate2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_date2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$ivWeather3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WeatherActivity.this.findViewById(R.id.iv_weather3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherValue3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_value3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tvWeatherDate3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_weather_date3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tv_city_name$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.WeatherActivity$tv_city_name$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WeatherActivity.this.findViewById(R.id.tv_city_name);
        }
    });

    public WeatherActivity() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        SPUtils XO3 = xo0.XO();
        Object appUser2 = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson2 = new Gson().fromJson(XO3.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson2 != null ? fromJson2 : appUser2);
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final View getBg() {
        return (View) this.bg$delegate.getValue();
    }

    public final ImageView getIvWeather() {
        return (ImageView) this.ivWeather$delegate.getValue();
    }

    public final ImageView getIvWeather1() {
        return (ImageView) this.ivWeather1$delegate.getValue();
    }

    public final ImageView getIvWeather2() {
        return (ImageView) this.ivWeather2$delegate.getValue();
    }

    public final ImageView getIvWeather3() {
        return (ImageView) this.ivWeather3$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getTemp(int i) {
        boolean z = true;
        if (TextConvertKt.XI0IXoo(this.mAppUser.getUnit()) != 1) {
            z = false;
        }
        return TextConvertKt.X0IIOO(this, i, z);
    }

    public final TextView getTvHumidityValue() {
        return (TextView) this.tvHumidityValue$delegate.getValue();
    }

    public final TextView getTvPrecipitationUnit() {
        return (TextView) this.tvPrecipitationUnit$delegate.getValue();
    }

    public final TextView getTvPrecipitationValue() {
        return (TextView) this.tvPrecipitationValue$delegate.getValue();
    }

    public final TextView getTvTemperatureMax() {
        return (TextView) this.tvTemperatureMax$delegate.getValue();
    }

    public final TextView getTvTemperatureMin() {
        return (TextView) this.tvTemperatureMin$delegate.getValue();
    }

    public final TextView getTvTemperatureUnit() {
        return (TextView) this.tvTemperatureUnit$delegate.getValue();
    }

    public final TextView getTvTemperatureValue() {
        return (TextView) this.tvTemperatureValue$delegate.getValue();
    }

    public final TextView getTvUviValue() {
        return (TextView) this.tvUviValue$delegate.getValue();
    }

    public final TextView getTvVisibilityUnit() {
        return (TextView) this.tvVisibilityUnit$delegate.getValue();
    }

    public final TextView getTvVisibilityValue() {
        return (TextView) this.tvVisibilityValue$delegate.getValue();
    }

    public final TextView getTvWeatherDate1() {
        return (TextView) this.tvWeatherDate1$delegate.getValue();
    }

    public final TextView getTvWeatherDate2() {
        return (TextView) this.tvWeatherDate2$delegate.getValue();
    }

    public final TextView getTvWeatherDate3() {
        return (TextView) this.tvWeatherDate3$delegate.getValue();
    }

    public final TextView getTvWeatherName() {
        return (TextView) this.tvWeatherName$delegate.getValue();
    }

    public final TextView getTvWeatherValue1() {
        return (TextView) this.tvWeatherValue1$delegate.getValue();
    }

    public final TextView getTvWeatherValue2() {
        return (TextView) this.tvWeatherValue2$delegate.getValue();
    }

    public final TextView getTvWeatherValue3() {
        return (TextView) this.tvWeatherValue3$delegate.getValue();
    }

    public final TextView getTvWindSpeedUnit() {
        return (TextView) this.tvWindSpeedUnit$delegate.getValue();
    }

    public final TextView getTvWindSpeedValue() {
        return (TextView) this.tvWindSpeedValue$delegate.getValue();
    }

    public final TextView getTv_city_name() {
        return (TextView) this.tv_city_name$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        String str;
        Object valueOf;
        Activity mContext;
        int i;
        int i2;
        BarUtils.transparentStatusBar(this);
        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.fl_container));
        BarUtils.setStatusBarLightMode((Activity) this, false);
        BarUtils.setNavBarLightMode((Activity) this, false);
        getAbhTitleCenter().setText(R.string.weather);
        BleCache bleCache = BleCache.INSTANCE;
        BleWeatherRealtime bleWeatherRealtime = (BleWeatherRealtime) BleCache.getObject$default(bleCache, BleKey.WEATHER_REALTIME, BleWeatherRealtime.class, null, 4, null);
        if (bleWeatherRealtime != null) {
            BleWeather mWeather = bleWeatherRealtime.getMWeather();
            IIX0o.ooOOo0oXI(mWeather);
            int mWeatherCode = mWeather.getMWeatherCode();
            getBg().setBackgroundResource(UtilsKt.X0IIOO(this, mWeatherCode));
            getIvWeather().setImageResource(UtilsKt.xxX(this, mWeatherCode));
            TextView tvTemperatureValue = getTvTemperatureValue();
            if (TextConvertKt.XI0IXoo(this.mAppUser.getUnit()) == 1) {
                IIX0o.ooOOo0oXI(bleWeatherRealtime.getMWeather());
                valueOf = Float.valueOf(TextConvertKt.OOXIXo(r5.getMCurrentTemperature()));
            } else {
                BleWeather mWeather2 = bleWeatherRealtime.getMWeather();
                IIX0o.ooOOo0oXI(mWeather2);
                valueOf = Integer.valueOf(mWeather2.getMCurrentTemperature());
            }
            tvTemperatureValue.setText(String.valueOf(valueOf));
            TextView tvTemperatureUnit = getTvTemperatureUnit();
            if (TextConvertKt.XI0IXoo(this.mAppUser.getUnit()) == 1) {
                mContext = getMContext();
                i = R.string.fahrenheit;
            } else {
                mContext = getMContext();
                i = R.string.degree_centigrade;
            }
            tvTemperatureUnit.setText(mContext.getString(i));
            getTvWeatherName().setText(UtilsKt.XxX0x0xxx(this, mWeatherCode));
            TextView tvHumidityValue = getTvHumidityValue();
            BleWeather mWeather3 = bleWeatherRealtime.getMWeather();
            IIX0o.ooOOo0oXI(mWeather3);
            tvHumidityValue.setText(String.valueOf(mWeather3.getMHumidity()));
            TextView tvVisibilityValue = getTvVisibilityValue();
            BleWeather mWeather4 = bleWeatherRealtime.getMWeather();
            IIX0o.ooOOo0oXI(mWeather4);
            tvVisibilityValue.setText(String.valueOf(TextConvertKt.ooOOo0oXI(mWeather4.getMVisibility() * 1000, this.userProfile.getUnit(), false, 4, null)));
            getTvVisibilityUnit().setText(getString(TextConvertKt.OxxIIOOXO(this.userProfile.getUnit())));
            TextView tvWindSpeedValue = getTvWindSpeedValue();
            IIX0o.ooOOo0oXI(bleWeatherRealtime.getMWeather());
            tvWindSpeedValue.setText(String.valueOf(TextConvertKt.xo0x(r2.getMWindSpeed(), this.userProfile.getUnit())));
            TextView tvWindSpeedUnit = getTvWindSpeedUnit();
            if (this.userProfile.getUnit() == 0) {
                i2 = R.string.km_h;
            } else {
                i2 = R.string.mi_h;
            }
            tvWindSpeedUnit.setText(getString(i2));
        }
        BleWeatherForecast bleWeatherForecast = (BleWeatherForecast) BleCache.getObject$default(bleCache, BleKey.WEATHER_FORECAST, BleWeatherForecast.class, null, 4, null);
        if (bleWeatherForecast != null) {
            TextView tvTemperatureMin = getTvTemperatureMin();
            BleWeather mWeather1 = bleWeatherForecast.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather1);
            tvTemperatureMin.setText(getTemp(mWeather1.getMMinTemperature()));
            TextView tvTemperatureMax = getTvTemperatureMax();
            BleWeather mWeather12 = bleWeatherForecast.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather12);
            tvTemperatureMax.setText(getTemp(mWeather12.getMMaxTemperature()));
            TextView tvUviValue = getTvUviValue();
            BleWeather mWeather13 = bleWeatherForecast.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather13);
            tvUviValue.setText(UtilsKt.OxI(mWeather13.getMUltraVioletIntensity()));
            TextView tvPrecipitationValue = getTvPrecipitationValue();
            IIX0o.ooOOo0oXI(bleWeatherForecast.getMWeather1());
            tvPrecipitationValue.setText(TextConvertKt.XX0(r3.getMPrecipitation(), this.userProfile.getUnit()));
            TextView tvPrecipitationUnit = getTvPrecipitationUnit();
            if (this.userProfile.getUnit() == 0) {
                str = DateFormatUtils.MIN;
            } else {
                str = "in";
            }
            tvPrecipitationUnit.setText(str);
            ImageView ivWeather1 = getIvWeather1();
            BleWeather mWeather14 = bleWeatherForecast.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather14);
            ivWeather1.setImageResource(UtilsKt.xxX(this, mWeather14.getMWeatherCode()));
            TextView tvWeatherValue1 = getTvWeatherValue1();
            StringBuilder sb = new StringBuilder();
            BleWeather mWeather15 = bleWeatherForecast.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather15);
            sb.append(getTemp(mWeather15.getMMinTemperature()));
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather mWeather16 = bleWeatherForecast.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather16);
            sb.append(getTemp(mWeather16.getMMaxTemperature()));
            tvWeatherValue1.setText(sb.toString());
            getTvWeatherDate1().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast.getMTime() * 1000, 0).XO());
            ImageView ivWeather2 = getIvWeather2();
            BleWeather mWeather22 = bleWeatherForecast.getMWeather2();
            IIX0o.ooOOo0oXI(mWeather22);
            ivWeather2.setImageResource(UtilsKt.xxX(this, mWeather22.getMWeatherCode()));
            TextView tvWeatherValue2 = getTvWeatherValue2();
            StringBuilder sb2 = new StringBuilder();
            BleWeather mWeather23 = bleWeatherForecast.getMWeather2();
            IIX0o.ooOOo0oXI(mWeather23);
            sb2.append(getTemp(mWeather23.getMMinTemperature()));
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather mWeather24 = bleWeatherForecast.getMWeather2();
            IIX0o.ooOOo0oXI(mWeather24);
            sb2.append(getTemp(mWeather24.getMMaxTemperature()));
            tvWeatherValue2.setText(sb2.toString());
            getTvWeatherDate2().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast.getMTime() * 1000, 1).XO());
            ImageView ivWeather3 = getIvWeather3();
            BleWeather mWeather32 = bleWeatherForecast.getMWeather3();
            IIX0o.ooOOo0oXI(mWeather32);
            ivWeather3.setImageResource(UtilsKt.xxX(this, mWeather32.getMWeatherCode()));
            TextView tvWeatherValue3 = getTvWeatherValue3();
            StringBuilder sb3 = new StringBuilder();
            BleWeather mWeather33 = bleWeatherForecast.getMWeather3();
            IIX0o.ooOOo0oXI(mWeather33);
            sb3.append(getTemp(mWeather33.getMMinTemperature()));
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather mWeather34 = bleWeatherForecast.getMWeather3();
            IIX0o.ooOOo0oXI(mWeather34);
            sb3.append(getTemp(mWeather34.getMMaxTemperature()));
            tvWeatherValue3.setText(sb3.toString());
            getTvWeatherDate3().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast.getMTime() * 1000, 2).XO());
        }
        SPUtils oIX0oI2 = Xo0.f24349oIX0oI.oIX0oI();
        WeatherRealtime weatherRealtime = (WeatherRealtime) new Gson().fromJson(oIX0oI2.getString(XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName()), WeatherRealtime.class);
        if (weatherRealtime != null) {
            getTv_city_name().setVisibility(0);
            getTv_city_name().setText(weatherRealtime.getName());
        } else {
            getTv_city_name().setVisibility(8);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_weather;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
