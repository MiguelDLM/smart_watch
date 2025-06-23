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
import com.szabh.smable3.entity.BleWeather2;
import com.szabh.smable3.entity.BleWeatherForecast2;
import com.szabh.smable3.entity.BleWeatherRealtime2;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeather2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Weather2Activity.kt\ncom/sma/smartv3/ui/status/Weather2Activity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,238:1\n19#2:239\n15#2:240\n19#2:241\n15#2:242\n90#2:243\n*S KotlinDebug\n*F\n+ 1 Weather2Activity.kt\ncom/sma/smartv3/ui/status/Weather2Activity\n*L\n75#1:239\n75#1:240\n77#1:241\n77#1:242\n210#1:243\n*E\n"})
/* loaded from: classes12.dex */
public final class Weather2Activity extends BaseActivity {

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) Weather2Activity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO bg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$bg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return Weather2Activity.this.findViewById(R.id.fl_bg);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvTemperatureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_temperature_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvTemperatureUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_temperature_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureMin$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvTemperatureMin$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_temperature_min);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTemperatureMax$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvTemperatureMax$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_temperature_max);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_name);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvUviValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvUviValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_uvi_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvHumidityValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvHumidityValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_humidity_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvVisibilityValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvVisibilityValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_visibility_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvVisibilityUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvVisibilityUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_visibility_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWindSpeedValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWindSpeedValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_wind_speed_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWindSpeedUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWindSpeedUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_wind_speed_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvPrecipitationValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvPrecipitationValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_precipitation_value);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvPrecipitationUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvPrecipitationUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_precipitation_unit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather4$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather4$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather4);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue4$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue4$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value4);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate4$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate4$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date4);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather5$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather5$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather5);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue5$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue5$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value5);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate5$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate5$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date5);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather6$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather6$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather6);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue6$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue6$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value6);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate6$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate6$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date6);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO ivWeather7$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$ivWeather7$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) Weather2Activity.this.findViewById(R.id.iv_weather7);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherValue7$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherValue7$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_value7);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeatherDate7$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tvWeatherDate7$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_weather_date7);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tv_city_name$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.Weather2Activity$tv_city_name$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) Weather2Activity.this.findViewById(R.id.tv_city_name);
        }
    });

    public Weather2Activity() {
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

    private final void setWeatherView(BleWeatherForecast2 bleWeatherForecast2, ImageView imageView, TextView textView) {
        BleWeather2 mWeather3 = bleWeatherForecast2.getMWeather3();
        IIX0o.ooOOo0oXI(mWeather3);
        imageView.setImageResource(UtilsKt.xxX(this, mWeather3.getMWeatherCode()));
        StringBuilder sb = new StringBuilder();
        BleWeather2 mWeather32 = bleWeatherForecast2.getMWeather3();
        IIX0o.ooOOo0oXI(mWeather32);
        sb.append(getTemp(mWeather32.getMMinTemperature()));
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        BleWeather2 mWeather33 = bleWeatherForecast2.getMWeather3();
        IIX0o.ooOOo0oXI(mWeather33);
        sb.append(getTemp(mWeather33.getMMaxTemperature()));
        textView.setText(sb.toString());
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

    public final ImageView getIvWeather4() {
        return (ImageView) this.ivWeather4$delegate.getValue();
    }

    public final ImageView getIvWeather5() {
        return (ImageView) this.ivWeather5$delegate.getValue();
    }

    public final ImageView getIvWeather6() {
        return (ImageView) this.ivWeather6$delegate.getValue();
    }

    public final ImageView getIvWeather7() {
        return (ImageView) this.ivWeather7$delegate.getValue();
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

    public final TextView getTvWeatherDate4() {
        return (TextView) this.tvWeatherDate4$delegate.getValue();
    }

    public final TextView getTvWeatherDate5() {
        return (TextView) this.tvWeatherDate5$delegate.getValue();
    }

    public final TextView getTvWeatherDate6() {
        return (TextView) this.tvWeatherDate6$delegate.getValue();
    }

    public final TextView getTvWeatherDate7() {
        return (TextView) this.tvWeatherDate7$delegate.getValue();
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

    public final TextView getTvWeatherValue4() {
        return (TextView) this.tvWeatherValue4$delegate.getValue();
    }

    public final TextView getTvWeatherValue5() {
        return (TextView) this.tvWeatherValue5$delegate.getValue();
    }

    public final TextView getTvWeatherValue6() {
        return (TextView) this.tvWeatherValue6$delegate.getValue();
    }

    public final TextView getTvWeatherValue7() {
        return (TextView) this.tvWeatherValue7$delegate.getValue();
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
        BleWeatherRealtime2 bleWeatherRealtime2 = (BleWeatherRealtime2) BleCache.getObject$default(bleCache, BleKey.WEATHER_REALTIME2, BleWeatherRealtime2.class, null, 4, null);
        if (bleWeatherRealtime2 != null) {
            BleWeather2 mWeather = bleWeatherRealtime2.getMWeather();
            IIX0o.ooOOo0oXI(mWeather);
            int mWeatherCode = mWeather.getMWeatherCode();
            getBg().setBackgroundResource(UtilsKt.X0IIOO(this, mWeatherCode));
            getIvWeather().setImageResource(UtilsKt.xxX(this, mWeatherCode));
            TextView tvTemperatureValue = getTvTemperatureValue();
            if (TextConvertKt.XI0IXoo(this.mAppUser.getUnit()) == 1) {
                IIX0o.ooOOo0oXI(bleWeatherRealtime2.getMWeather());
                valueOf = Float.valueOf(TextConvertKt.OOXIXo(r5.getMCurrentTemperature()));
            } else {
                BleWeather2 mWeather2 = bleWeatherRealtime2.getMWeather();
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
            BleWeather2 mWeather3 = bleWeatherRealtime2.getMWeather();
            IIX0o.ooOOo0oXI(mWeather3);
            tvHumidityValue.setText(String.valueOf(mWeather3.getMHumidity()));
            TextView tvVisibilityValue = getTvVisibilityValue();
            BleWeather2 mWeather4 = bleWeatherRealtime2.getMWeather();
            IIX0o.ooOOo0oXI(mWeather4);
            tvVisibilityValue.setText(String.valueOf(TextConvertKt.ooOOo0oXI(mWeather4.getMVisibility() * 1000, this.userProfile.getUnit(), false, 4, null)));
            getTvVisibilityUnit().setText(getString(TextConvertKt.OxxIIOOXO(this.userProfile.getUnit())));
            TextView tvWindSpeedValue = getTvWindSpeedValue();
            IIX0o.ooOOo0oXI(bleWeatherRealtime2.getMWeather());
            tvWindSpeedValue.setText(String.valueOf(TextConvertKt.xo0x(r2.getMWindSpeed(), this.userProfile.getUnit())));
            TextView tvWindSpeedUnit = getTvWindSpeedUnit();
            if (this.userProfile.getUnit() == 0) {
                i2 = R.string.km_h;
            } else {
                i2 = R.string.mi_h;
            }
            tvWindSpeedUnit.setText(getString(i2));
        }
        BleWeatherForecast2 bleWeatherForecast2 = (BleWeatherForecast2) BleCache.getObject$default(bleCache, BleKey.WEATHER_FORECAST2, BleWeatherForecast2.class, null, 4, null);
        if (bleWeatherForecast2 != null) {
            TextView tvTemperatureMin = getTvTemperatureMin();
            BleWeather2 mWeather1 = bleWeatherForecast2.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather1);
            tvTemperatureMin.setText(getTemp(mWeather1.getMMinTemperature()));
            TextView tvTemperatureMax = getTvTemperatureMax();
            BleWeather2 mWeather12 = bleWeatherForecast2.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather12);
            tvTemperatureMax.setText(getTemp(mWeather12.getMMaxTemperature()));
            TextView tvUviValue = getTvUviValue();
            BleWeather2 mWeather13 = bleWeatherForecast2.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather13);
            tvUviValue.setText(UtilsKt.OxI(mWeather13.getMUltraVioletIntensity()));
            TextView tvPrecipitationValue = getTvPrecipitationValue();
            IIX0o.ooOOo0oXI(bleWeatherForecast2.getMWeather1());
            tvPrecipitationValue.setText(TextConvertKt.XX0(r3.getMPrecipitation(), this.userProfile.getUnit()));
            TextView tvPrecipitationUnit = getTvPrecipitationUnit();
            if (this.userProfile.getUnit() == 0) {
                str = DateFormatUtils.MIN;
            } else {
                str = "in";
            }
            tvPrecipitationUnit.setText(str);
            ImageView ivWeather1 = getIvWeather1();
            BleWeather2 mWeather14 = bleWeatherForecast2.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather14);
            ivWeather1.setImageResource(UtilsKt.xxX(this, mWeather14.getMWeatherCode()));
            TextView tvWeatherValue1 = getTvWeatherValue1();
            StringBuilder sb = new StringBuilder();
            BleWeather2 mWeather15 = bleWeatherForecast2.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather15);
            sb.append(getTemp(mWeather15.getMMinTemperature()));
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather2 mWeather16 = bleWeatherForecast2.getMWeather1();
            IIX0o.ooOOo0oXI(mWeather16);
            sb.append(getTemp(mWeather16.getMMaxTemperature()));
            tvWeatherValue1.setText(sb.toString());
            getTvWeatherDate1().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 0).XO());
            ImageView ivWeather2 = getIvWeather2();
            BleWeather2 mWeather22 = bleWeatherForecast2.getMWeather2();
            IIX0o.ooOOo0oXI(mWeather22);
            ivWeather2.setImageResource(UtilsKt.xxX(this, mWeather22.getMWeatherCode()));
            TextView tvWeatherValue2 = getTvWeatherValue2();
            StringBuilder sb2 = new StringBuilder();
            BleWeather2 mWeather23 = bleWeatherForecast2.getMWeather2();
            IIX0o.ooOOo0oXI(mWeather23);
            sb2.append(getTemp(mWeather23.getMMinTemperature()));
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather2 mWeather24 = bleWeatherForecast2.getMWeather2();
            IIX0o.ooOOo0oXI(mWeather24);
            sb2.append(getTemp(mWeather24.getMMaxTemperature()));
            tvWeatherValue2.setText(sb2.toString());
            getTvWeatherDate2().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 1).XO());
            ImageView ivWeather3 = getIvWeather3();
            IIX0o.oO(ivWeather3, "<get-ivWeather3>(...)");
            TextView tvWeatherValue3 = getTvWeatherValue3();
            IIX0o.oO(tvWeatherValue3, "<get-tvWeatherValue3>(...)");
            setWeatherView(bleWeatherForecast2, ivWeather3, tvWeatherValue3);
            getTvWeatherDate3().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 2).XO());
            if (bleWeatherForecast2.getMWeather4() == null) {
                ImageView ivWeather4 = getIvWeather4();
                IIX0o.oO(ivWeather4, "<get-ivWeather4>(...)");
                TextView tvWeatherValue4 = getTvWeatherValue4();
                IIX0o.oO(tvWeatherValue4, "<get-tvWeatherValue4>(...)");
                setWeatherView(bleWeatherForecast2, ivWeather4, tvWeatherValue4);
                ImageView ivWeather5 = getIvWeather5();
                IIX0o.oO(ivWeather5, "<get-ivWeather5>(...)");
                TextView tvWeatherValue5 = getTvWeatherValue5();
                IIX0o.oO(tvWeatherValue5, "<get-tvWeatherValue5>(...)");
                setWeatherView(bleWeatherForecast2, ivWeather5, tvWeatherValue5);
                ImageView ivWeather6 = getIvWeather6();
                IIX0o.oO(ivWeather6, "<get-ivWeather6>(...)");
                TextView tvWeatherValue6 = getTvWeatherValue6();
                IIX0o.oO(tvWeatherValue6, "<get-tvWeatherValue6>(...)");
                setWeatherView(bleWeatherForecast2, ivWeather6, tvWeatherValue6);
                ImageView ivWeather7 = getIvWeather7();
                IIX0o.oO(ivWeather7, "<get-ivWeather7>(...)");
                TextView tvWeatherValue7 = getTvWeatherValue7();
                IIX0o.oO(tvWeatherValue7, "<get-tvWeatherValue7>(...)");
                setWeatherView(bleWeatherForecast2, ivWeather7, tvWeatherValue7);
                return;
            }
            ImageView ivWeather42 = getIvWeather4();
            BleWeather2 mWeather42 = bleWeatherForecast2.getMWeather4();
            IIX0o.ooOOo0oXI(mWeather42);
            ivWeather42.setImageResource(UtilsKt.xxX(this, mWeather42.getMWeatherCode()));
            TextView tvWeatherValue42 = getTvWeatherValue4();
            StringBuilder sb3 = new StringBuilder();
            BleWeather2 mWeather43 = bleWeatherForecast2.getMWeather4();
            IIX0o.ooOOo0oXI(mWeather43);
            sb3.append(getTemp(mWeather43.getMMinTemperature()));
            sb3.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather2 mWeather44 = bleWeatherForecast2.getMWeather4();
            IIX0o.ooOOo0oXI(mWeather44);
            sb3.append(getTemp(mWeather44.getMMaxTemperature()));
            tvWeatherValue42.setText(sb3.toString());
            getTvWeatherDate4().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 3).XO());
            ImageView ivWeather52 = getIvWeather5();
            BleWeather2 mWeather5 = bleWeatherForecast2.getMWeather5();
            IIX0o.ooOOo0oXI(mWeather5);
            ivWeather52.setImageResource(UtilsKt.xxX(this, mWeather5.getMWeatherCode()));
            TextView tvWeatherValue52 = getTvWeatherValue5();
            StringBuilder sb4 = new StringBuilder();
            BleWeather2 mWeather52 = bleWeatherForecast2.getMWeather5();
            IIX0o.ooOOo0oXI(mWeather52);
            sb4.append(getTemp(mWeather52.getMMinTemperature()));
            sb4.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather2 mWeather53 = bleWeatherForecast2.getMWeather5();
            IIX0o.ooOOo0oXI(mWeather53);
            sb4.append(getTemp(mWeather53.getMMaxTemperature()));
            tvWeatherValue52.setText(sb4.toString());
            getTvWeatherDate5().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 4).XO());
            ImageView ivWeather62 = getIvWeather6();
            BleWeather2 mWeather6 = bleWeatherForecast2.getMWeather6();
            IIX0o.ooOOo0oXI(mWeather6);
            ivWeather62.setImageResource(UtilsKt.xxX(this, mWeather6.getMWeatherCode()));
            TextView tvWeatherValue62 = getTvWeatherValue6();
            StringBuilder sb5 = new StringBuilder();
            BleWeather2 mWeather62 = bleWeatherForecast2.getMWeather6();
            IIX0o.ooOOo0oXI(mWeather62);
            sb5.append(getTemp(mWeather62.getMMinTemperature()));
            sb5.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather2 mWeather63 = bleWeatherForecast2.getMWeather6();
            IIX0o.ooOOo0oXI(mWeather63);
            sb5.append(getTemp(mWeather63.getMMaxTemperature()));
            tvWeatherValue62.setText(sb5.toString());
            getTvWeatherDate6().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 5).XO());
            ImageView ivWeather72 = getIvWeather7();
            BleWeather2 mWeather7 = bleWeatherForecast2.getMWeather7();
            IIX0o.ooOOo0oXI(mWeather7);
            ivWeather72.setImageResource(UtilsKt.xxX(this, mWeather7.getMWeatherCode()));
            TextView tvWeatherValue72 = getTvWeatherValue7();
            StringBuilder sb6 = new StringBuilder();
            BleWeather2 mWeather72 = bleWeatherForecast2.getMWeather7();
            IIX0o.ooOOo0oXI(mWeather72);
            sb6.append(getTemp(mWeather72.getMMinTemperature()));
            sb6.append(IOUtils.DIR_SEPARATOR_UNIX);
            BleWeather2 mWeather73 = bleWeatherForecast2.getMWeather7();
            IIX0o.ooOOo0oXI(mWeather73);
            sb6.append(getTemp(mWeather73.getMMaxTemperature()));
            tvWeatherValue72.setText(sb6.toString());
            getTvWeatherDate7().setText(com.sma.smartv3.util.xoIox.XIxXXX0x0(bleWeatherForecast2.getMTime() * 1000, 6).XO());
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
        return R.layout.activity_weather2;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
