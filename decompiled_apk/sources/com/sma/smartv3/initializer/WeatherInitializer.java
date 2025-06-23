package com.sma.smartv3.initializer;

import android.app.Activity;
import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.garmin.fit.X0xOO;
import com.goodix.ble.libcomx.task.TaskPipe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.constant.ah;
import com.realsil.sdk.dfu.DfuConstants;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.WeatherForecast;
import com.sma.smartv3.model.WeatherRealtime;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetWeatherForecast;
import com.sma.smartv3.network.GetWeatherRealtime;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAgpsPrerequisite;
import com.szabh.smable3.entity.BleAirPressureCalibration;
import com.szabh.smable3.entity.BleWeather;
import com.szabh.smable3.entity.BleWeather2;
import com.szabh.smable3.entity.BleWeatherForecast;
import com.szabh.smable3.entity.BleWeatherForecast2;
import com.szabh.smable3.entity.BleWeatherRealtime;
import com.szabh.smable3.entity.BleWeatherRealtime2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nWeatherInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeatherInitializer.kt\ncom/sma/smartv3/initializer/WeatherInitializer\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,488:1\n151#2,11:489\n171#2:508\n151#2,11:509\n171#2:528\n208#3,7:500\n226#3:507\n208#3,7:520\n226#3:527\n23#4:529\n18#4,2:530\n15#4:532\n11#4,2:534\n24#4:536\n1#5:533\n*S KotlinDebug\n*F\n+ 1 WeatherInitializer.kt\ncom/sma/smartv3/initializer/WeatherInitializer\n*L\n226#1:489,11\n226#1:508\n351#1:509,11\n351#1:528\n226#1:500,7\n226#1:507\n351#1:520,7\n351#1:527\n459#1:529\n459#1:530,2\n459#1:532\n459#1:534,2\n459#1:536\n459#1:533\n*E\n"})
/* loaded from: classes12.dex */
public final class WeatherInitializer implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f20905IXxxXO = 1;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20906Oo = "Weather";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f20907Oxx0xo = 12;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static com.sma.smartv3.location.oxoX f20908OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final WeatherInitializer f20909XO = new WeatherInitializer();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static boolean f20910oI0IIXIo = true;

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oo() {
        com.sma.smartv3.location.oxoX oxox = f20908OxxIIOOXO;
        if (oxox != null) {
            oxox.II0XooXoX();
        }
    }

    public static /* synthetic */ void oO(WeatherInitializer weatherInitializer, double d, double d2, double d3, int i, Object obj) {
        if ((i & 4) != 0) {
            d3 = XIXIX.OOXIXo.f3760XO;
        }
        weatherInitializer.x0XOIxOo(d, d2, d3);
    }

    public final boolean II0XooXoX() {
        if (ProductManager.f20544oIX0oI.IXIIo()) {
            if (((BleWeatherForecast2) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WEATHER_FORECAST2, BleWeatherForecast2.class, null, 4, null)) != null && new Date().getTime() - (r0.getMTime() * 1000) < Xo0.f24349oIX0oI.XO().getInt(XoI0Ixx0.f24360IIX0o, 12) * 3600000) {
                return false;
            }
            return true;
        }
        if (((BleWeatherForecast) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WEATHER_FORECAST, BleWeatherForecast.class, null, 4, null)) != null && new Date().getTime() - (r0.getMTime() * 1000) < Xo0.f24349oIX0oI.XO().getInt(XoI0Ixx0.f24360IIX0o, 12) * 3600000) {
            return false;
        }
        return true;
    }

    public final void IXxxXO() {
        if (!f20910oI0IIXIo) {
            LogUtils.v("Weather syncWeather -> the last Request not done");
            return;
        }
        if (!ProductManager.f20544oIX0oI.oI()) {
            LogUtils.v("Weather syncWeather -> Device does not support weather");
            oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$syncWeather$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                    invoke2(o0xOxO);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                    IIX0o.x0xO0oo(it, "it");
                    it.x0XOIxOo("Device does not support weather");
                }
            });
            return;
        }
        if (!BleConnector.INSTANCE.isAvailable()) {
            LogUtils.v("Weather syncWeather -> BleConnector is not available");
            oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$syncWeather$2
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                    invoke2(o0xOxO);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                    String xoIox2;
                    IIX0o.x0xO0oo(it, "it");
                    StringBuilder sb = new StringBuilder();
                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                    sb.append(xoIox2);
                    sb.append("BleConnector is not available");
                    it.x0XOIxOo(sb.toString());
                }
            });
        } else if (!xxIXOIIO()) {
            LogUtils.v("Weather syncWeather -> Not time to sync weather");
        } else if (BleInitializer.f20700XO.OOXIxO0()) {
            LogUtils.v("Weather firmware update.....");
        } else {
            oOoXoXO();
        }
    }

    @XO0.XO(tag = XoI0Ixx0.f24367IXxxXO)
    public final void OOXIXo(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("Weather onLocationWhere");
        f20908OxxIIOOXO = com.sma.smartv3.location.X0o0xo.II0xO0(new com.sma.smartv3.location.II0xO0() { // from class: com.sma.smartv3.initializer.WeatherInitializer$onLocationWhere$1
            @Override // com.sma.smartv3.location.II0xO0
            public void oIX0oI(@OXOo.OOXIXo final com.sma.smartv3.location.oIX0oI location) {
                IIX0o.x0xO0oo(location, "location");
                WeatherInitializer weatherInitializer = WeatherInitializer.f20909XO;
                weatherInitializer.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$onLocationWhere$1$onLocationChange$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        IIX0o.x0xO0oo(it, "it");
                        it.oOoXoXO("lon:" + com.sma.smartv3.location.oIX0oI.this.I0Io() + ", lat:" + com.sma.smartv3.location.oIX0oI.this.II0xO0() + ", altitude:" + com.sma.smartv3.location.oIX0oI.this.oIX0oI());
                    }
                });
                LogUtils.v("Weather onLocationChange -> lon:" + location.I0Io() + ", lat:" + location.II0xO0() + ", altitude:" + location.oIX0oI());
                weatherInitializer.x0XOIxOo(location.I0Io(), location.II0xO0(), location.oIX0oI());
                weatherInitializer.ooOOo0oXI(location.I0Io(), location.II0xO0());
                weatherInitializer.Oo();
            }

            @Override // com.sma.smartv3.location.II0xO0
            public void onError(@OXOo.OOXIXo final String message) {
                IIX0o.x0xO0oo(message, "message");
                WeatherInitializer weatherInitializer = WeatherInitializer.f20909XO;
                weatherInitializer.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$onLocationWhere$1$onError$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        IIX0o.x0xO0oo(it, "it");
                        it.oOoXoXO(message);
                    }
                });
                weatherInitializer.Oo();
            }
        }, false, 2, null);
    }

    public final boolean Oxx0IOOO() {
        return f20910oI0IIXIo;
    }

    public final int Oxx0xo(int i) {
        switch (i) {
            case 200:
            case 201:
            case 202:
            case 210:
            case 211:
            case 212:
            case 230:
            case 231:
            case 232:
                return 6;
            case 300:
            case 301:
            case 302:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case X0xOO.f13592OIxI0O /* 321 */:
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 511:
            case 520:
            case 521:
            case DfuConstants.PROGRESS_HAND_OVER_PROCESSING /* 522 */:
            case BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM /* 531 */:
                return 4;
            case 600:
            case 601:
            case 602:
            case 611:
            case 612:
            case 613:
            case 615:
            case 616:
            case 620:
            case 621:
            case 622:
                return 8;
            case 701:
            case 711:
            case 721:
            case 741:
                return 9;
            case 731:
            case 751:
            case TaskPipe.EVT_BUSY /* 761 */:
            case 762:
                return 10;
            case 771:
            case 781:
                return 7;
            case 800:
                return 1;
            case ah.W /* 801 */:
                return 3;
            case ah.X /* 802 */:
            case 803:
            case ah.Y /* 804 */:
                return 2;
            default:
                return 0;
        }
    }

    public final void oI0IIXIo(Oox.oOoXoXO<? super O0xOxO, oXIO0o0XI> oooxoxo) {
        SPUtils II0xO02 = Xo0.f24349oIX0oI.II0xO0();
        Object fromJson = new Gson().fromJson(II0xO02.getString(O0xOxO.class.getName()), (Class<Object>) O0xOxO.class);
        if (fromJson == null) {
            fromJson = O0xOxO.class.newInstance();
        }
        oooxoxo.invoke(fromJson);
        II0xO02.put(O0xOxO.class.getName(), new Gson().toJson(fromJson));
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
    }

    public final void oOoXoXO() {
        LogUtils.v("Weather start requestWeather.....");
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Boolean>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeather$1
            public void oIX0oI(boolean z) {
                Object obj;
                if (z) {
                    LogUtils.v("Weather syncWeather");
                    String string = Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24423XX, "");
                    if (!AppUtils.isAppForeground()) {
                        IIX0o.ooOOo0oXI(string);
                        if (string.length() > 0) {
                            LogUtils.v("App foreground false -- get Weather");
                            List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(string, new String[]{","}, false, 0, 6, null);
                            double parseDouble = Double.parseDouble((String) XXoO0oX2.get(0));
                            double parseDouble2 = Double.parseDouble((String) XXoO0oX2.get(1));
                            if (2 <= CollectionsKt__CollectionsKt.oo0xXOI0I(XXoO0oX2)) {
                                obj = XXoO0oX2.get(2);
                            } else {
                                obj = "0";
                            }
                            double parseDouble3 = Double.parseDouble((String) obj);
                            WeatherInitializer weatherInitializer = WeatherInitializer.f20909XO;
                            weatherInitializer.x0XOIxOo(parseDouble, parseDouble2, parseDouble3);
                            weatherInitializer.ooOOo0oXI(parseDouble, parseDouble2);
                            return;
                        }
                    }
                    LogUtils.v("App foreground true -- get Weather");
                    PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
                    IIX0o.oO(permission, "permission(...)");
                    oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeather$1$onSuccess$2
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                            invoke2(permissionStatus);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo PermissionStatus status) {
                            com.sma.smartv3.location.oxoX oxox;
                            IIX0o.x0xO0oo(status, "status");
                            if (status == PermissionStatus.GRANTED) {
                                LogUtils.v("Weather syncWeather -> start Location");
                                oxox = WeatherInitializer.f20908OxxIIOOXO;
                                if (oxox != null) {
                                    oxox.XO(R.string.get_weather_and_phone_get_location_desc, false);
                                }
                                WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeather$1$onSuccess$2.1
                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                        invoke2(o0xOxO);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                        String xoIox2;
                                        IIX0o.x0xO0oo(it, "it");
                                        it.x0XOIxOo("");
                                        StringBuilder sb = new StringBuilder();
                                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                        sb.append(xoIox2);
                                        sb.append("startLocation");
                                        it.oOoXoXO(sb.toString());
                                    }
                                });
                                return;
                            }
                            LogUtils.v("Weather syncWeather -> Location permission is not granted");
                            WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeather$1$onSuccess$2.2
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                    invoke2(o0xOxO);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                    String xoIox2;
                                    IIX0o.x0xO0oo(it, "it");
                                    StringBuilder sb = new StringBuilder();
                                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                    sb.append(xoIox2);
                                    sb.append("Location permission is not granted");
                                    it.x0XOIxOo(sb.toString());
                                }
                            });
                        }
                    }, 3, null);
                    return;
                }
                LogUtils.v("Weather syncWeather -> Network is not available");
                WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeather$1$onSuccess$3
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        String xoIox2;
                        IIX0o.x0xO0oo(it, "it");
                        StringBuilder sb = new StringBuilder();
                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                        sb.append(xoIox2);
                        sb.append("Network is not available");
                        it.x0XOIxOo(sb.toString());
                    }
                });
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                oIX0oI(((Boolean) obj).booleanValue());
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.OOXIXo
            public Boolean doInBackground() {
                return Boolean.valueOf(NetworkUtils.isAvailable());
            }
        });
    }

    public final void ooOOo0oXI(double d, double d2) {
        if (!II0XooXoX()) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.XO("Weather requestWeatherForecast -> lon:" + d + ",lat:" + d2);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> weatherForecastBody = RequestBodyKt.getWeatherForecastBody(d, d2);
        final xxxI.II0xO0<WeatherForecast[]> iI0xO0 = new xxxI.II0xO0<WeatherForecast[]>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo final String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.XO("Weather requestWeatherForecast error -> " + error);
                WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1$handleError$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        String xoIox2;
                        IIX0o.x0xO0oo(it, "it");
                        StringBuilder sb = new StringBuilder();
                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                        sb.append(xoIox2);
                        sb.append(error);
                        it.OOXIXo(sb.toString());
                    }
                });
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO final WeatherForecast[] weatherForecastArr) {
                int Oxx0xo2;
                int Oxx0xo3;
                StringBuilder sb = new StringBuilder();
                sb.append("Weather requestWeatherForecast getWeatherForecast -> ");
                String arrays = Arrays.toString(weatherForecastArr);
                IIX0o.oO(arrays, "toString(...)");
                sb.append(arrays);
                LogUtils.d(sb.toString());
                WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1$handleResponse$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        String xoIox2;
                        IIX0o.x0xO0oo(it, "it");
                        StringBuilder sb2 = new StringBuilder();
                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                        sb2.append(xoIox2);
                        String arrays2 = Arrays.toString(weatherForecastArr);
                        IIX0o.oO(arrays2, "toString(...)");
                        sb2.append(arrays2);
                        it.OOXIXo(sb2.toString());
                    }
                });
                if (ProductManager.f20544oIX0oI.IXIIo()) {
                    if (weatherForecastArr != null) {
                        ArrayList arrayList = new ArrayList(weatherForecastArr.length);
                        for (WeatherForecast weatherForecast : weatherForecastArr) {
                            Calendar calendar = Calendar.getInstance();
                            long j = 1000;
                            calendar.setTimeInMillis(weatherForecast.getSys_sunrise() * j);
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTimeInMillis(weatherForecast.getSys_sunset() * j);
                            int temp_max = (int) weatherForecast.getTemp_max();
                            int temp_min = (int) weatherForecast.getTemp_min();
                            Oxx0xo3 = WeatherInitializer.f20909XO.Oxx0xo(weatherForecast.getWeather_id());
                            int humidity = weatherForecast.getHumidity();
                            int uvi = weatherForecast.getUvi();
                            int rain = (int) weatherForecast.getRain();
                            IIX0o.ooOOo0oXI(calendar);
                            int Oxx0IOOO2 = oOXoIIIo.II0xO0.Oxx0IOOO(calendar);
                            int xxIXOIIO2 = oOXoIIIo.II0xO0.xxIXOIIO(calendar);
                            int ooOOo0oXI2 = oOXoIIIo.II0xO0.ooOOo0oXI(calendar);
                            IIX0o.ooOOo0oXI(calendar2);
                            arrayList.add(new BleWeather2(0, temp_max, temp_min, Oxx0xo3, (int) (weatherForecast.getWind_speed() * 3.6d), humidity, 0, uvi, rain, Oxx0IOOO2, xxIXOIIO2, ooOOo0oXI2, oOXoIIIo.II0xO0.Oxx0IOOO(calendar2), oOXoIIIo.II0xO0.xxIXOIIO(calendar2), oOXoIIIo.II0xO0.ooOOo0oXI(calendar2), 0, 0, 98305, null));
                        }
                        BleWeatherForecast2 bleWeatherForecast2 = new BleWeatherForecast2((int) (new Date().getTime() / 1000), null, (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 0), (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 1), (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 2), (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 3), (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 4), (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 5), (BleWeather2) CollectionsKt___CollectionsKt.OIoxIx(arrayList, 6), 2, null);
                        if (!ProductManager.f20544oIX0oI.Ix00oIoI()) {
                            WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1$handleResponse$3$1$2
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                    invoke2(o0xOxO);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                    String xoIox2;
                                    IIX0o.x0xO0oo(it, "it");
                                    StringBuilder sb2 = new StringBuilder();
                                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                    sb2.append(xoIox2);
                                    sb2.append("OK , but device not support forecast");
                                    it.OOXIXo(sb2.toString());
                                }
                            });
                            BleCache.putObject$default(BleCache.INSTANCE, BleKey.WEATHER_FORECAST2, bleWeatherForecast2, null, 4, null);
                            return;
                        } else {
                            if (BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.WEATHER_FORECAST2, BleKeyFlag.UPDATE, bleWeatherForecast2, false, false, 24, null)) {
                                WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1$handleResponse$3$1$1
                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                        invoke2(o0xOxO);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                        String xoIox2;
                                        IIX0o.x0xO0oo(it, "it");
                                        StringBuilder sb2 = new StringBuilder();
                                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                        sb2.append(xoIox2);
                                        sb2.append("OK");
                                        it.OOXIXo(sb2.toString());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (weatherForecastArr != null) {
                    ArrayList arrayList2 = new ArrayList(weatherForecastArr.length);
                    for (WeatherForecast weatherForecast2 : weatherForecastArr) {
                        int temp_max2 = (int) weatherForecast2.getTemp_max();
                        int temp_min2 = (int) weatherForecast2.getTemp_min();
                        Oxx0xo2 = WeatherInitializer.f20909XO.Oxx0xo(weatherForecast2.getWeather_id());
                        arrayList2.add(new BleWeather(0, temp_max2, temp_min2, Oxx0xo2, (int) (weatherForecast2.getWind_speed() * 3.6d), weatherForecast2.getHumidity(), 0, weatherForecast2.getUvi(), (int) weatherForecast2.getRain(), 1, null));
                    }
                    BleWeatherForecast bleWeatherForecast = new BleWeatherForecast((int) (new Date().getTime() / 1000), (BleWeather) CollectionsKt___CollectionsKt.OIoxIx(arrayList2, 0), (BleWeather) CollectionsKt___CollectionsKt.OIoxIx(arrayList2, 1), (BleWeather) CollectionsKt___CollectionsKt.OIoxIx(arrayList2, 2));
                    if (!ProductManager.f20544oIX0oI.Ix00oIoI()) {
                        WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1$handleResponse$5$1$2
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                invoke2(o0xOxO);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                String xoIox2;
                                IIX0o.x0xO0oo(it, "it");
                                StringBuilder sb2 = new StringBuilder();
                                xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                sb2.append(xoIox2);
                                sb2.append("OK , but device not support forecast");
                                it.OOXIXo(sb2.toString());
                            }
                        });
                        BleCache.putObject$default(BleCache.INSTANCE, BleKey.WEATHER_FORECAST, bleWeatherForecast, null, 4, null);
                    } else if (BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.WEATHER_FORECAST, BleKeyFlag.UPDATE, bleWeatherForecast, false, false, 24, null)) {
                        WeatherInitializer.f20909XO.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$1$handleResponse$5$1$1
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                invoke2(o0xOxO);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                String xoIox2;
                                IIX0o.x0xO0oo(it, "it");
                                StringBuilder sb2 = new StringBuilder();
                                xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                sb2.append(xoIox2);
                                sb2.append("OK");
                                it.OOXIXo(sb2.toString());
                            }
                        });
                    }
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetWeatherForecast.URL);
        netWorkUtils.printParam(convertBaseUrl + GetWeatherForecast.URL, weatherForecastBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetWeatherForecast.URL;
        final xxxI.II0xO0<Response<WeatherForecast[]>> iI0xO02 = new xxxI.II0xO0<Response<WeatherForecast[]>>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WeatherForecast[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) weatherForecastBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WeatherForecast[].class), new ParsedRequestListener<Response<WeatherForecast[]>>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherForecast$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WeatherForecast[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void x0XOIxOo(double d, double d2, final double d3) {
        OI0.oIX0oI.f1507oIX0oI.XO("Weather requestWeatherRealtime -> lon:" + d + ",lat:" + d2 + ",altitude:" + d3);
        f20910oI0IIXIo = false;
        if (BleCache.INSTANCE.getMAGpsType() == 9) {
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AGPS_PREREQUISITE, BleKeyFlag.UPDATE, new BleAgpsPrerequisite((float) d, (float) d2, (int) d3), false, false, 24, null);
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> weatherRealtimeBody = RequestBodyKt.getWeatherRealtimeBody(d, d2);
        final xxxI.II0xO0<WeatherRealtime> iI0xO0 = new xxxI.II0xO0<WeatherRealtime>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo final String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.XO("Weather requestWeatherRealtime error -> " + error);
                WeatherInitializer weatherInitializer = WeatherInitializer.f20909XO;
                weatherInitializer.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1$handleError$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        String xoIox2;
                        IIX0o.x0xO0oo(it, "it");
                        StringBuilder sb = new StringBuilder();
                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                        sb.append(xoIox2);
                        sb.append(error);
                        it.ooOOo0oXI(sb.toString());
                    }
                });
                weatherInitializer.x0xO0oo(true);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO final WeatherRealtime weatherRealtime) {
                WeatherInitializer weatherInitializer;
                int Oxx0xo2;
                int Oxx0xo3;
                LogUtils.d("Weather requestWeatherRealtime getWeather -> " + weatherRealtime);
                Xo0 xo0 = Xo0.f24349oIX0oI;
                xo0.oIX0oI().put(XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName(), new Gson().toJson(weatherRealtime));
                WeatherInitializer weatherInitializer2 = WeatherInitializer.f20909XO;
                weatherInitializer2.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1$handleResponse$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                        invoke2(o0xOxO);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                        String xoIox2;
                        IIX0o.x0xO0oo(it, "it");
                        StringBuilder sb = new StringBuilder();
                        xoIox2 = WeatherInitializer.f20909XO.xoIox();
                        sb.append(xoIox2);
                        sb.append(WeatherRealtime.this);
                        it.ooOOo0oXI(sb.toString());
                    }
                });
                Date date = new Date();
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (productManager.IXIIo()) {
                    if (weatherRealtime != null) {
                        double d4 = d3;
                        Calendar calendar = Calendar.getInstance();
                        long j = 1000;
                        calendar.setTimeInMillis(weatherRealtime.getSys_sunrise() * j);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTimeInMillis(j * weatherRealtime.getSys_sunset());
                        int time = (int) (date.getTime() / 1000);
                        String name = weatherRealtime.getName();
                        int temp = (int) weatherRealtime.getTemp();
                        Oxx0xo3 = weatherInitializer2.Oxx0xo(weatherRealtime.getWeather_id());
                        int humidity = weatherRealtime.getHumidity();
                        int visibility = weatherRealtime.getVisibility() / 1000;
                        int rain_1h = (int) weatherRealtime.getRain_1h();
                        IIX0o.ooOOo0oXI(calendar);
                        int Oxx0IOOO2 = oOXoIIIo.II0xO0.Oxx0IOOO(calendar);
                        int xxIXOIIO2 = oOXoIIIo.II0xO0.xxIXOIIO(calendar);
                        int ooOOo0oXI2 = oOXoIIIo.II0xO0.ooOOo0oXI(calendar);
                        IIX0o.ooOOo0oXI(calendar2);
                        BleWeatherRealtime2 bleWeatherRealtime2 = new BleWeatherRealtime2(time, name, new BleWeather2(temp, 0, 0, Oxx0xo3, (int) (weatherRealtime.getWind_speed() * 3.6d), humidity, visibility, 0, rain_1h, Oxx0IOOO2, xxIXOIIO2, ooOOo0oXI2, oOXoIIIo.II0xO0.Oxx0IOOO(calendar2), oOXoIIIo.II0xO0.xxIXOIIO(calendar2), oOXoIIIo.II0xO0.ooOOo0oXI(calendar2), (int) d4, 0, 65670, null));
                        if (!productManager.O0IxXx()) {
                            weatherInitializer2.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1$handleResponse$2$1$2
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                    invoke2(o0xOxO);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                    String xoIox2;
                                    IIX0o.x0xO0oo(it, "it");
                                    StringBuilder sb = new StringBuilder();
                                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                    sb.append(xoIox2);
                                    sb.append("OK , but device not support realtime");
                                    it.ooOOo0oXI(sb.toString());
                                }
                            });
                            BleCache.putObject$default(BleCache.INSTANCE, BleKey.WEATHER_REALTIME2, bleWeatherRealtime2, null, 4, null);
                        } else if (BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.WEATHER_REALTIME2, BleKeyFlag.UPDATE, bleWeatherRealtime2, false, false, 24, null)) {
                            xo0.I0Io().put(XoI0Ixx0.f24432Xx000oIo, System.currentTimeMillis());
                            weatherInitializer2.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1$handleResponse$2$1$1
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                    invoke2(o0xOxO);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                    String xoIox2;
                                    IIX0o.x0xO0oo(it, "it");
                                    StringBuilder sb = new StringBuilder();
                                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                    sb.append(xoIox2);
                                    sb.append("OK");
                                    it.ooOOo0oXI(sb.toString());
                                }
                            });
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24662xoIox, null, 2, null);
                        }
                        weatherInitializer = weatherInitializer2;
                    } else {
                        weatherInitializer = weatherInitializer2;
                    }
                } else {
                    weatherInitializer = weatherInitializer2;
                    if (weatherRealtime != null) {
                        int time2 = (int) (date.getTime() / 1000);
                        int temp2 = (int) weatherRealtime.getTemp();
                        Oxx0xo2 = weatherInitializer.Oxx0xo(weatherRealtime.getWeather_id());
                        BleWeatherRealtime bleWeatherRealtime = new BleWeatherRealtime(time2, new BleWeather(temp2, 0, 0, Oxx0xo2, (int) (weatherRealtime.getWind_speed() * 3.6d), weatherRealtime.getHumidity(), weatherRealtime.getVisibility() / 1000, 0, (int) weatherRealtime.getRain_1h(), 134, null));
                        if (!productManager.O0IxXx()) {
                            weatherInitializer.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1$handleResponse$3$1$2
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                    invoke2(o0xOxO);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                    String xoIox2;
                                    IIX0o.x0xO0oo(it, "it");
                                    StringBuilder sb = new StringBuilder();
                                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                    sb.append(xoIox2);
                                    sb.append("OK , but device not support realtime");
                                    it.ooOOo0oXI(sb.toString());
                                }
                            });
                            BleCache.putObject$default(BleCache.INSTANCE, BleKey.WEATHER_REALTIME, bleWeatherRealtime, null, 4, null);
                        } else if (BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.WEATHER_REALTIME, BleKeyFlag.UPDATE, bleWeatherRealtime, false, false, 24, null)) {
                            xo0.I0Io().put(XoI0Ixx0.f24432Xx000oIo, System.currentTimeMillis());
                            weatherInitializer.oI0IIXIo(new Oox.oOoXoXO<O0xOxO, oXIO0o0XI>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$1$handleResponse$3$1$1
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(O0xOxO o0xOxO) {
                                    invoke2(o0xOxO);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo O0xOxO it) {
                                    String xoIox2;
                                    IIX0o.x0xO0oo(it, "it");
                                    StringBuilder sb = new StringBuilder();
                                    xoIox2 = WeatherInitializer.f20909XO.xoIox();
                                    sb.append(xoIox2);
                                    sb.append("OK");
                                    it.ooOOo0oXI(sb.toString());
                                }
                            });
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24662xoIox, null, 2, null);
                        }
                    }
                }
                if (productManager.oX0ooo0I0() && weatherRealtime != null) {
                    double d5 = d3;
                    if (d5 == XIXIX.OOXIXo.f3760XO || d5 == Double.MIN_VALUE) {
                        OI0.oIX0oI.f1507oIX0oI.XO("Weather calculateAltitude -> " + weatherRealtime.getPressure());
                        d5 = UtilsKt.oIX0oI((double) weatherRealtime.getPressure());
                    }
                    BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AIR_PRESSURE_CALIBRATION, BleKeyFlag.UPDATE, new BleAirPressureCalibration(weatherRealtime.getPressure() * 100, (int) d5), false, false, 24, null);
                }
                weatherInitializer.x0xO0oo(true);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetWeatherRealtime.URL);
        netWorkUtils.printParam(convertBaseUrl + GetWeatherRealtime.URL, weatherRealtimeBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetWeatherRealtime.URL;
        final xxxI.II0xO0<Response<WeatherRealtime>> iI0xO02 = new xxxI.II0xO0<Response<WeatherRealtime>>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WeatherRealtime> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) weatherRealtimeBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WeatherRealtime.class), new ParsedRequestListener<Response<WeatherRealtime>>() { // from class: com.sma.smartv3.initializer.WeatherInitializer$requestWeatherRealtime$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WeatherRealtime> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void x0xO0oo(boolean z) {
        f20910oI0IIXIo = z;
    }

    public final String xoIox() {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ", Locale.getDefault()).format(new Date());
    }

    public final boolean xxIXOIIO() {
        int i = Xo0.f24349oIX0oI.XO().getInt(XoI0Ixx0.f24487xXxxox0I, 1);
        if (ProductManager.f20544oIX0oI.IXIIo()) {
            BleWeatherRealtime2 bleWeatherRealtime2 = (BleWeatherRealtime2) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WEATHER_REALTIME2, BleWeatherRealtime2.class, null, 4, null);
            if (bleWeatherRealtime2 == null) {
                return true;
            }
            LogUtils.v("Weather isTimeToSyncWeatherRealtime2 ->weatherRealtimeInterval:" + i + ", weatherRealtime:" + bleWeatherRealtime2);
            if (new Date().getTime() - (bleWeatherRealtime2.getMTime() * 1000) >= i * 3600000) {
                return true;
            }
            return false;
        }
        BleWeatherRealtime bleWeatherRealtime = (BleWeatherRealtime) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WEATHER_REALTIME, BleWeatherRealtime.class, null, 4, null);
        if (bleWeatherRealtime == null) {
            return true;
        }
        LogUtils.v("Weather isTimeToSyncWeatherRealtime ->weatherRealtimeInterval:" + i + ", weatherRealtime:" + bleWeatherRealtime);
        if (new Date().getTime() - (bleWeatherRealtime.getMTime() * 1000) >= i * 3600000) {
            return true;
        }
        return false;
    }
}
