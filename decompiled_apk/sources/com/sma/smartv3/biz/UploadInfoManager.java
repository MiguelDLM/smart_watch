package com.sma.smartv3.biz;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.WeatherRealtime;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppUserUpdate;
import com.sma.smartv3.network.GetWeatherRealtime;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.NetWorkUtils$upload$$inlined$upload$1;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.UploadNoLoginUserInfo;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nUploadInfoManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UploadInfoManager.kt\ncom/sma/smartv3/biz/UploadInfoManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,254:1\n90#2:255\n19#2:256\n15#2:257\n90#2:258\n19#2:279\n15#2:280\n90#2:281\n90#2:342\n151#3,11:259\n171#3:278\n74#3,16:282\n98#3:321\n151#3,11:322\n171#3:341\n208#4,7:270\n226#4:277\n106#4,23:298\n208#4,7:333\n226#4:340\n*S KotlinDebug\n*F\n+ 1 UploadInfoManager.kt\ncom/sma/smartv3/biz/UploadInfoManager\n*L\n64#1:255\n68#1:256\n68#1:257\n71#1:258\n158#1:279\n158#1:280\n161#1:281\n245#1:342\n123#1:259,11\n123#1:278\n186#1:282,16\n186#1:321\n213#1:322,11\n213#1:341\n123#1:270,7\n123#1:277\n186#1:298,23\n213#1:333,7\n213#1:340\n*E\n"})
/* loaded from: classes12.dex */
public final class UploadInfoManager {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static com.sma.smartv3.location.oxoX f20220I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final UploadInfoManager f20222oIX0oI = new UploadInfoManager();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20221II0xO0 = "UploadInfoManager";

    public static /* synthetic */ void I0Io(UploadInfoManager uploadInfoManager, double d, double d2, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 4) != 0) {
            iI0xO0 = null;
        }
        uploadInfoManager.II0xO0(d, d2, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void OOXIXo(UploadInfoManager uploadInfoManager, AppUser appUser, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        uploadInfoManager.xoIox(appUser, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void xxIXOIIO(UploadInfoManager uploadInfoManager, AppUser appUser, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        uploadInfoManager.II0XooXoX(appUser, iI0xO0);
    }

    public final void II0XooXoX(@OXOo.OOXIXo AppUser appUser, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        IIX0o.x0xO0oo(appUser, "appUser");
        if (appUser.getHeight() == 0.0f && appUser.getWeight() == 0.0f) {
            ToastUtils.showLong(R.string.user_does_not_exist);
            return;
        }
        X0o0xo(appUser);
        LogUtils.d(f20221II0xO0 + " uploadLoginUserInfo -> " + appUser);
        final Activity activity = null;
        appUser.setThirdPlatform(null);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        File II0XooXoX2 = IXxxXO.II0XooXoX(X00IoxXI.oIX0oI.f3233oIX0oI);
        final xxxI.II0xO0<AppUser> iI0xO02 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadLoginUserInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d(UploadInfoManager.f20222oIX0oI.oxoX() + " uploadLoginUserInfo error -> " + error);
                xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                LogUtils.d(UploadInfoManager.f20222oIX0oI.oxoX() + " save LoginUserInfo -> " + appUser2);
                Xo0.f24349oIX0oI.XO().put(AppUser.class.getName(), new Gson().toJson(appUser2));
                xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleResponse(new Gson().toJson(appUser2));
                }
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = Api.INSTANCE.getBASE_URL() + AppUserUpdate.URL;
        final xxxI.II0xO0<Response<AppUser>> iI0xO03 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadLoginUserInfo$$inlined$upload$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO04 = iI0xO02;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO04);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(str);
        if (II0XooXoX2.exists()) {
            upload.addMultipartFile("avatar", II0XooXoX2);
        }
        upload.addMultipartParameter(appUser).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE).getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadLoginUserInfo$$inlined$upload$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    public final void II0xO0(double d, double d2, @OXOo.oOoXoXO final xxxI.II0xO0<WeatherRealtime> iI0xO0) {
        LogUtils.d(f20221II0xO0 + " getCity -> " + d + ", " + d2);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> weatherRealtimeBody = RequestBodyKt.getWeatherRealtimeBody(d, d2);
        final xxxI.II0xO0<WeatherRealtime> iI0xO02 = new xxxI.II0xO0<WeatherRealtime>() { // from class: com.sma.smartv3.biz.UploadInfoManager$getCity$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                xxxI.II0xO0<WeatherRealtime> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO WeatherRealtime weatherRealtime) {
                LogUtils.d(UploadInfoManager.f20222oIX0oI.oxoX() + " getWeather -> " + weatherRealtime);
                Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName(), new Gson().toJson(weatherRealtime));
                xxxI.II0xO0<WeatherRealtime> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleResponse(weatherRealtime);
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetWeatherRealtime.URL);
        netWorkUtils.printParam(convertBaseUrl + GetWeatherRealtime.URL, weatherRealtimeBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetWeatherRealtime.URL;
        final xxxI.II0xO0<Response<WeatherRealtime>> iI0xO03 = new xxxI.II0xO0<Response<WeatherRealtime>>() { // from class: com.sma.smartv3.biz.UploadInfoManager$getCity$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WeatherRealtime> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO04 = iI0xO02;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO04);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) weatherRealtimeBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WeatherRealtime.class), new ParsedRequestListener<Response<WeatherRealtime>>() { // from class: com.sma.smartv3.biz.UploadInfoManager$getCity$$inlined$post$default$2
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Oxx0IOOO() {
        /*
            r33 = this;
            r0 = r33
            com.szabh.smable3.component.BleConnector r1 = com.szabh.smable3.component.BleConnector.INSTANCE
            boolean r1 = r1.isBound()
            if (r1 == 0) goto L16
            com.sma.smartv3.network.RequestCommonMethod r1 = com.sma.smartv3.network.RequestCommonMethod.INSTANCE
            com.sma.smartv3.biz.UploadInfoManager$uploadInfo$1 r2 = new com.sma.smartv3.biz.UploadInfoManager$uploadInfo$1
            r2.<init>()
            r1.updateDeviceInfo(r2)
            goto Lbd
        L16:
            com.sma.smartv3.util.Xo0 r1 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r2 = r1.XO()
            com.sma.smartv3.model.AppUser r32 = new com.sma.smartv3.model.AppUser
            r3 = r32
            r30 = 67108863(0x3ffffff, float:1.5046327E-36)
            r31 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            com.google.gson.Gson r3 = new com.google.gson.Gson
            r3.<init>()
            java.lang.Class<com.sma.smartv3.model.AppUser> r4 = com.sma.smartv3.model.AppUser.class
            java.lang.String r5 = r4.getName()
            java.lang.String r2 = r2.getString(r5)
            java.lang.Object r2 = r3.fromJson(r2, r4)
            if (r2 != 0) goto L66
            goto L68
        L66:
            r32 = r2
        L68:
            r2 = r32
            com.sma.smartv3.model.AppUser r2 = (com.sma.smartv3.model.AppUser) r2
            java.lang.String r2 = r2.getIdentity()
            int r2 = r2.length()
            if (r2 != 0) goto La9
            com.blankj.utilcode.util.SPUtils r1 = r1.oIX0oI()
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "NO_LOGIN_USER_INFO"
            r3.append(r5)
            r5 = 95
            r3.append(r5)
            java.lang.String r5 = r4.getName()
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object r1 = r2.fromJson(r1, r4)
            com.sma.smartv3.model.AppUser r1 = (com.sma.smartv3.model.AppUser) r1
            if (r1 == 0) goto La9
            r2 = 1
            r32 = r1
            goto Laa
        La9:
            r2 = 0
        Laa:
            r1 = 2
            r3 = 0
            if (r2 == 0) goto Lb6
            r2 = r32
            com.sma.smartv3.model.AppUser r2 = (com.sma.smartv3.model.AppUser) r2
            OOXIXo(r0, r2, r3, r1, r3)
            goto Lbd
        Lb6:
            r2 = r32
            com.sma.smartv3.model.AppUser r2 = (com.sma.smartv3.model.AppUser) r2
            xxIXOIIO(r0, r2, r3, r1, r3)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.UploadInfoManager.Oxx0IOOO():void");
    }

    public final void X0o0xo(@OXOo.OOXIXo AppUser appUser) {
        IIX0o.x0xO0oo(appUser, "appUser");
        appUser.setServer(UtilsKt.Oxx0xo());
        appUser.setProjectId(2);
        appUser.setOsVersion(UtilsKt.oO());
        appUser.setPhoneModel(UtilsKt.x0xO0oo());
        appUser.setPhoneIdentity(UtilsKt.O0xOxO());
        if (TextUtils.isEmpty(appUser.getCountry())) {
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            appUser.setCountry(UtilsKt.xoXoI(app));
        }
        SPUtils oIX0oI2 = Xo0.f24349oIX0oI.oIX0oI();
        WeatherRealtime weatherRealtime = (WeatherRealtime) new Gson().fromJson(oIX0oI2.getString(XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName()), WeatherRealtime.class);
        if (weatherRealtime != null) {
            appUser.setCountry(weatherRealtime.getSys_country());
            if (!TextUtils.isEmpty(weatherRealtime.getName())) {
                appUser.setCity(weatherRealtime.getName());
            }
            appUser.setLongitude(weatherRealtime.getLon());
            appUser.setLatitude(weatherRealtime.getLat());
        }
    }

    public final void XO() {
        com.sma.smartv3.location.oxoX oxox = f20220I0Io;
        if (oxox != null) {
            oxox.II0XooXoX();
        }
    }

    public final void oOoXoXO() {
        boolean z;
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils oIX0oI2 = xo0.oIX0oI();
        WeatherRealtime weatherRealtime = (WeatherRealtime) new Gson().fromJson(oIX0oI2.getString(XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName()), WeatherRealtime.class);
        StringBuilder sb = new StringBuilder();
        String str = f20221II0xO0;
        sb.append(str);
        sb.append(" uploadPhoneInfo weather -> ");
        sb.append(weatherRealtime);
        LogUtils.d(sb.toString());
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        if (appUser2.getIdentity().length() == 0) {
            SPUtils oIX0oI3 = xo0.oIX0oI();
            AppUser appUser3 = (AppUser) new Gson().fromJson(oIX0oI3.getString(XoI0Ixx0.f24462ox + '_' + AppUser.class.getName()), AppUser.class);
            if (appUser3 != null) {
                z = true;
                appUser2 = appUser3;
            } else {
                OOXIXo(this, appUser2, null, 2, null);
                return;
            }
        } else {
            z = false;
        }
        LogUtils.d(str + " uploadPhoneInfo appUser -> " + z + TokenParser.SP + appUser2);
        if (weatherRealtime == null) {
            if (PermissionUtils.isGranted(PermissionConstants.LOCATION)) {
                if (f20220I0Io == null) {
                    f20220I0Io = com.sma.smartv3.location.X0o0xo.II0xO0(new com.sma.smartv3.location.II0xO0() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadPhoneInfo$1
                        @Override // com.sma.smartv3.location.II0xO0
                        public void oIX0oI(@OXOo.OOXIXo com.sma.smartv3.location.oIX0oI location) {
                            IIX0o.x0xO0oo(location, "location");
                            UploadInfoManager uploadInfoManager = UploadInfoManager.f20222oIX0oI;
                            uploadInfoManager.II0xO0(location.I0Io(), location.II0xO0(), new xxxI.II0xO0<WeatherRealtime>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadPhoneInfo$1$onLocationChange$1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    IIX0o.x0xO0oo(error, "error");
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO WeatherRealtime weatherRealtime2) {
                                    UploadInfoManager.f20222oIX0oI.Oxx0IOOO();
                                }
                            });
                            uploadInfoManager.XO();
                        }

                        @Override // com.sma.smartv3.location.II0xO0
                        public void onError(@OXOo.OOXIXo String message) {
                            IIX0o.x0xO0oo(message, "message");
                            UploadInfoManager.f20222oIX0oI.XO();
                        }
                    }, false, 2, null);
                }
                LogUtils.d(str + " startLocation");
                com.sma.smartv3.location.oxoX oxox = f20220I0Io;
                if (oxox != null) {
                    oxox.XO(R.string.get_weather_and_phone_get_location_desc, false);
                    return;
                }
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(weatherRealtime.getName()) && !IIX0o.Oxx0IOOO(weatherRealtime.getName(), appUser2.getCity())) {
            Oxx0IOOO();
        }
    }

    @OXOo.OOXIXo
    public final String oxoX() {
        return f20221II0xO0;
    }

    public final void xoIox(@OXOo.OOXIXo AppUser appUser, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        IIX0o.x0xO0oo(appUser, "appUser");
        X0o0xo(appUser);
        appUser.setServer(-1);
        LogUtils.d(f20221II0xO0 + " uploadNoLoginUserInfo -> " + appUser);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> uploadNoLoginUserInfo = RequestBodyKt.getUploadNoLoginUserInfo(appUser);
        final xxxI.II0xO0<AppUser> iI0xO02 = new xxxI.II0xO0<AppUser>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadNoLoginUserInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d(UploadInfoManager.f20222oIX0oI.oxoX() + " uploadNoLoginUserInfo error -> " + error);
                xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppUser appUser2) {
                LogUtils.d(UploadInfoManager.f20222oIX0oI.oxoX() + " save NoLoginUserInfo -> " + appUser2);
                Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24462ox + '_' + AppUser.class.getName(), new Gson().toJson(appUser2));
                x0xO0oo.II0xO0(x0xO0oo.f24657xX0IIXIx0, null, 2, null);
                xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleResponse(new Gson().toJson(appUser2));
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), UploadNoLoginUserInfo.URL);
        netWorkUtils.printParam(convertBaseUrl + UploadNoLoginUserInfo.URL, uploadNoLoginUserInfo);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + UploadNoLoginUserInfo.URL;
        final xxxI.II0xO0<Response<AppUser>> iI0xO03 = new xxxI.II0xO0<Response<AppUser>>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadNoLoginUserInfo$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppUser> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO04 = iI0xO02;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO04);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) uploadNoLoginUserInfo).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppUser.class), new ParsedRequestListener<Response<AppUser>>() { // from class: com.sma.smartv3.biz.UploadInfoManager$uploadNoLoginUserInfo$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppUser> response) {
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
}
