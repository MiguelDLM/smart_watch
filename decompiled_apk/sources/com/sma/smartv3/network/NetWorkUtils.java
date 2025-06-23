package com.sma.smartv3.network;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.baidu.mobads.sdk.internal.an;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.UploadDownloadInfo;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.ui.login.ooOOo0oXI;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.XIxXXX0x0;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;
import org.json.JSONObject;
import x0xO.XO;
import xxxI.II0xO0;

@XX({"SMAP\nNetWorkUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 2 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,631:1\n106#2,23:632\n156#2,7:655\n174#2:662\n156#2,7:663\n174#2:670\n182#2,8:671\n201#2:679\n182#2,8:680\n201#2:688\n208#2,7:689\n226#2:696\n208#2,7:697\n226#2:704\n234#2,8:705\n254#2:713\n234#2,8:714\n254#2:722\n261#2,17:723\n285#2,18:740\n285#2,18:758\n310#2,13:776\n1#3:789\n19#4:790\n15#4:791\n19#4:792\n15#4:793\n*S KotlinDebug\n*F\n+ 1 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n*L\n84#1:632,23\n111#1:655,7\n111#1:662\n111#1:663,7\n111#1:670\n139#1:671,8\n139#1:679\n139#1:680,8\n139#1:688\n161#1:689,7\n161#1:696\n161#1:697,7\n161#1:704\n184#1:705,8\n184#1:713\n184#1:714,8\n184#1:722\n205#1:723,17\n229#1:740,18\n253#1:758,18\n359#1:776,13\n578#1:790\n578#1:791\n591#1:792\n591#1:793\n*E\n"})
/* loaded from: classes12.dex */
public final class NetWorkUtils {

    @OOXIXo
    public static final NetWorkUtils INSTANCE = new NetWorkUtils();

    private NetWorkUtils() {
    }

    public static /* synthetic */ void get$default(NetWorkUtils netWorkUtils, String str, II0xO0 iI0xO0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        netWorkUtils.get(str, iI0xO0, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getV2$default(NetWorkUtils netWorkUtils, String url, Map body, II0xO0 callback, Activity activity, View view, Map headers, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        if ((i & 32) != 0) {
            headers = netWorkUtils.getHeadersMap();
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, o0.xoIxX(body, headers));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$getV2$1 netWorkUtils$getV2$1 = new NetWorkUtils$getV2$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.get(str).addQueryParameter((Map<String, String>) body).setTag((Object) str).addHeaders((Map<String, String>) headers).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$getV2$$inlined$getV2$1(netWorkUtils$getV2$1));
    }

    public static /* synthetic */ void post$default(NetWorkUtils netWorkUtils, String url, Map body, II0xO0 callback, Activity activity, View view, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, body);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$post$1 netWorkUtils$post$1 = new NetWorkUtils$post$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addBodyParameter((Map<String, String>) body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$post$$inlined$post$1(netWorkUtils$post$1));
    }

    public static /* synthetic */ void postJson$default(NetWorkUtils netWorkUtils, String url, Object body, II0xO0 callback, Activity activity, View view, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postJson$1 netWorkUtils$postJson$1 = new NetWorkUtils$postJson$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postJson$$inlined$postJson$1(netWorkUtils$postJson$1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postJsonV2$default(NetWorkUtils netWorkUtils, String url, Map body, II0xO0 callback, Activity activity, View view, Map headers, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        if ((i & 32) != 0) {
            headers = netWorkUtils.getHeadersMap();
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, o0.xoIxX(body, headers));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postJsonV2$1 netWorkUtils$postJsonV2$1 = new NetWorkUtils$postJsonV2$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addHeaders((Map<String, String>) headers).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postJsonV2$$inlined$postJsonV2$1(netWorkUtils$postJsonV2$1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventSource postStreamRequest$default(NetWorkUtils netWorkUtils, String str, Map map, Object obj, II0xO0 iI0xO0, int i, Object obj2) {
        if ((i & 2) != 0) {
            map = netWorkUtils.getHeadersMap();
        }
        return netWorkUtils.postStreamRequest(str, map, obj, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postV2$default(NetWorkUtils netWorkUtils, String url, Map body, II0xO0 callback, Activity activity, View view, Map headers, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        if ((i & 32) != 0) {
            headers = netWorkUtils.getHeadersMap();
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, o0.xoIxX(body, headers));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postV2$1 netWorkUtils$postV2$1 = new NetWorkUtils$postV2$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addHeaders((Map<String, String>) headers).addBodyParameter((Map<String, String>) body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postV2$$inlined$postV2$1(netWorkUtils$postV2$1));
    }

    public static /* synthetic */ void upload$default(NetWorkUtils netWorkUtils, String url, String fileParameter, File file, Object body, II0xO0 callback, Activity activity, View view, int i, Object obj) {
        if ((i & 32) != 0) {
            activity = null;
        }
        if ((i & 64) != 0) {
            view = null;
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(fileParameter, "fileParameter");
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = Api.INSTANCE.getBASE_URL() + url;
        IIX0o.xoXoI();
        NetWorkUtils$upload$1 netWorkUtils$upload$1 = new NetWorkUtils$upload$1(activity, callback, loadPopup);
        ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(str);
        if (file.exists()) {
            upload.addMultipartFile(fileParameter, file);
        }
        ANRequest uploadProgressListener = upload.addMultipartParameter(body).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        uploadProgressListener.getAsParsed(parameterized, new NetWorkUtils$upload$$inlined$upload$2(netWorkUtils$upload$1));
    }

    public final void clearAllBitmap() {
        NetWork.f19682oIX0oI.I0Io();
    }

    @OOXIXo
    public final String convertBaseUrl(@OOXIXo String baseUrl, @OOXIXo String url) {
        String str;
        IIX0o.x0xO0oo(baseUrl, "baseUrl");
        IIX0o.x0xO0oo(url, "url");
        if (StringsKt__StringsKt.ooO0oXxI(baseUrl, ooOOo0oXI.f23074oIX0oI, true) || StringsKt__StringsKt.ooO0oXxI(baseUrl, ooOOo0oXI.f23072II0xO0, true) || StringsKt__StringsKt.ooO0oXxI(baseUrl, ooOOo0oXI.f23071I0Io, true) || StringsKt__StringsKt.ooO0oXxI(baseUrl, ooOOo0oXI.f23075oxoX, true) || StringsKt__StringsKt.ooO0oXxI(baseUrl, ooOOo0oXI.f23073X0o0xo, true)) {
            if (!OxI.o0IXXIx(url, BleFirmwareList.URL, true) && !OxI.o0IXXIx(url, BleFirmwareVersionList.URL, true) && !OxI.o0IXXIx(url, FirmwareVersionLatest.URL, true) && !OxI.o0IXXIx(url, BleExtraPackVersionList.URL, true) && !OxI.o0IXXIx(url, ExtraPackVersionLatest.URL, true) && !OxI.o0IXXIx(url, BleExtraPackVersionLanguage.URL, true) && !OxI.o0IXXIx(url, BleExtraPackVersionUi.URL, true) && !OxI.o0IXXIx(url, BleExtraPackVersionFont.URL, true) && !OxI.o0IXXIx(url, GetPayMacAddress.URL, true) && !OxI.o0IXXIx(url, ChangeDeviceState.URL, true) && !OxI.o0IXXIx(url, GetDeviceState.URL, true) && !OxI.o0IXXIx(url, GetDeviceList.URL, true) && !OxI.o0IXXIx(url, GetDeviceListObject.URL, true) && !OxI.o0IXXIx(url, GetDeviceInfo.URL, true) && !OxI.o0IXXIx(url, AigcCreateJob.URL, true) && !OxI.o0IXXIx(url, AigcFindJob.URL, true) && !OxI.o0IXXIx(url, GetDcsToken.INSTANCE.getURL(), true) && !OxI.o0IXXIx(url, UploadDownloadInfo.URL, true) && !OxI.o0IXXIx(url, GetGomoreAuthKey.URL, true) && !OxI.o0IXXIx(url, AppVersionLatest.URL, true) && !OxI.o0IXXIx(url, BleExtraPackVersionGPSFirmware.URL, true) && !OxI.o0IXXIx(url, GetTeraBoxToken.URL, true) && !OxI.o0IXXIx(url, GetInternalTeraBoxToken.URL, true) && !OxI.o0IXXIx(url, GetTeraBoxTokenInfo.URL, true) && !OxI.o0IXXIx(url, GetTeraBoxRefreshToken.URL, true) && !OxI.o0IXXIx(url, GetInternalTeraBoxRefreshToken.URL, true) && !OxI.o0IXXIx(url, AppStoreFileListSearch.URL, true)) {
                str = baseUrl;
            } else {
                str = ooOOo0oXI.f23074oIX0oI;
            }
            if (!StringsKt__StringsKt.ooO0oXxI(baseUrl, ooOOo0oXI.f23071I0Io, true) && (OxI.o0IXXIx(url, GetWeatherRealtime.URL, true) || OxI.o0IXXIx(url, GetWeatherForecast.URL, true) || OxI.o0IXXIx(url, GetNewDeviceListObject.URL, true))) {
                return ooOOo0oXI.f23074oIX0oI;
            }
            return str;
        }
        return baseUrl;
    }

    public final void download(@OOXIXo String url, @OOXIXo String path, @OOXIXo String fileName, @OOXIXo HttpProgressCallback<String> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(callback, "callback");
        NetWork.f19682oIX0oI.oxoX(url, path, fileName, callback);
    }

    public final void downloadV2(@OOXIXo String url, @OOXIXo Map<String, String> headers, @OOXIXo String path, @OOXIXo String fileName, @OOXIXo HttpProgressCallback<String> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(callback, "callback");
        NetWork.f19682oIX0oI.XO(url, headers, path, fileName, callback);
    }

    public final <T> void errorData(@oOoXoXO String str, @OOXIXo II0xO0<T> callback, @oOoXoXO I0X0x0oIo i0X0x0oIo) {
        IIX0o.x0xO0oo(callback, "callback");
        callback.handleError(String.valueOf(str));
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    public final void get(@OOXIXo String url, @OOXIXo II0xO0<JSONObject> callback, int i) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(callback, "callback");
        NetWork.f19682oIX0oI.xxIXOIIO(url, callback, i);
    }

    @OOXIXo
    public final String getBaseUrl(@OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        return convertBaseUrl(Api.INSTANCE.getBASE_URL(), url) + url;
    }

    @OOXIXo
    public final Map<String, String> getHeadersMap() {
        Gson gson = new Gson();
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        String mFirmwareFlag = bleCache.getMFirmwareFlag();
        String string$default = BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        String appVersionName = AppUtils.getAppVersionName();
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        String identity = ((AppUser) appUser).getIdentity();
        String IIOIX2 = OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null);
        IIX0o.ooOOo0oXI(appVersionName);
        String json = gson.toJson(new BleInfo(identity, mBleName, mFirmwareFlag, "2", string$default, appVersionName, IIOIX2, 0));
        HashMap hashMap = new HashMap();
        hashMap.put("accept-language", Utils.getApp().getResources().getConfiguration().locale.getLanguage());
        SPUtils XO3 = xo0.XO();
        Object appUser2 = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson2 = new Gson().fromJson(XO3.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson2 != null) {
            appUser2 = fromJson2;
        }
        hashMap.put("APP-UID", ((AppUser) appUser2).getIdentity());
        hashMap.put("BleInfo", json);
        return hashMap;
    }

    public final <T> void getImage(@OOXIXo String url, @OOXIXo File file, @OOXIXo II0xO0<T> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(callback, "callback");
        NetWork.f19682oIX0oI.OOXIXo(url, file, callback);
    }

    public final /* synthetic */ <T> void getV2(String url, Map<String, String> body, II0xO0<T> callback, Activity activity, View view, Map<String, String> headers) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        printParam(convertBaseUrl + url, o0.xoIxX(body, headers));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$getV2$1 netWorkUtils$getV2$1 = new NetWorkUtils$getV2$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.get(str).addQueryParameter(body).setTag((Object) str).addHeaders(headers).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$getV2$$inlined$getV2$1(netWorkUtils$getV2$1));
    }

    @oOoXoXO
    public final I0X0x0oIo loadPopup(@oOoXoXO Activity activity, @oOoXoXO View view) {
        if (view == null || activity == null) {
            return null;
        }
        I0X0x0oIo i0X0x0oIo = new I0X0x0oIo(activity);
        i0X0x0oIo.OxxIIOOXO(view);
        return i0X0x0oIo;
    }

    public final /* synthetic */ <T> void post(String url, Map<String, String> body, II0xO0<T> callback, Activity activity, View view) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        printParam(convertBaseUrl + url, body);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$post$1 netWorkUtils$post$1 = new NetWorkUtils$post$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addBodyParameter(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$post$$inlined$post$1(netWorkUtils$post$1));
    }

    public final /* synthetic */ <T> void postJson(String url, Object body, II0xO0<T> callback, Activity activity, View view) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postJson$1 netWorkUtils$postJson$1 = new NetWorkUtils$postJson$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postJson$$inlined$postJson$1(netWorkUtils$postJson$1));
    }

    public final <T> void postJsonExecute(@OOXIXo String url, @OOXIXo Object body, @OOXIXo II0xO0<T> callback) {
        Response<T> response;
        Object result;
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = Api.INSTANCE.getBASE_URL() + url;
        try {
            result = AndroidNetworking.post(str).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build().executeForObject(Response.class).getResult();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.d(oXIO0o0XI.f29392oIX0oI);
            response = null;
        }
        if (result != null) {
            response = (Response) result;
            if (response == null) {
                response = new Response<>();
                response.setCode(-1000);
            }
            responseWhenCheck(null, response, callback);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.sma.androidnetworklib.model.Response<T>");
    }

    public final /* synthetic */ <T> void postJsonV2(String url, Map<String, ? extends Object> body, II0xO0<T> callback, Activity activity, View view, Map<String, String> headers) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        printParam(convertBaseUrl + url, o0.xoIxX(body, headers));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postJsonV2$1 netWorkUtils$postJsonV2$1 = new NetWorkUtils$postJsonV2$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addHeaders(headers).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postJsonV2$$inlined$postJsonV2$1(netWorkUtils$postJsonV2$1));
    }

    @OOXIXo
    public final EventSource postStreamRequest(@OOXIXo String url, @OOXIXo Map<String, String> headers, @OOXIXo Object body, @OOXIXo final II0xO0<String> callback) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(headers, "headers");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        if (!OxI.IOOoXo0Ix(url, "http", false, 2, null)) {
            String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
            printParam(convertBaseUrl + url, o0.xoIxX(o0.O0xOxO(), headers));
            url = convertBaseUrl + url;
        }
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        EventSource.Factory createFactory = EventSources.createFactory(newBuilder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build());
        Request.Builder post = new Request.Builder().url(url).post(RequestBody.Companion.create(MediaType.Companion.parse(an.d), body.toString()));
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            post.addHeader(entry.getKey(), entry.getValue());
        }
        post.addHeader("Accept", "*/*");
        return createFactory.newEventSource(post.build(), new EventSourceListener() { // from class: com.sma.smartv3.network.NetWorkUtils$postStreamRequest$1
            @Override // okhttp3.sse.EventSourceListener
            public void onClosed(@OOXIXo EventSource eventSource) {
                IIX0o.x0xO0oo(eventSource, "eventSource");
                super.onClosed(eventSource);
                oIX0oI.f1507oIX0oI.oIX0oI("SSE onClosed");
            }

            @Override // okhttp3.sse.EventSourceListener
            public void onEvent(@OOXIXo EventSource eventSource, @oOoXoXO String str, @oOoXoXO String str2, @OOXIXo String data) {
                IIX0o.x0xO0oo(eventSource, "eventSource");
                IIX0o.x0xO0oo(data, "data");
                super.onEvent(eventSource, str, str2, data);
                callback.handleResponse(data);
            }

            @Override // okhttp3.sse.EventSourceListener
            public void onFailure(@OOXIXo EventSource eventSource, @oOoXoXO Throwable th, @oOoXoXO okhttp3.Response response) {
                int i;
                String str;
                ResponseBody body2;
                IIX0o.x0xO0oo(eventSource, "eventSource");
                super.onFailure(eventSource, th, response);
                if (response != null) {
                    i = response.code();
                } else {
                    i = 0;
                }
                if (response == null || (body2 = response.body()) == null || (str = body2.string()) == null) {
                    str = "";
                }
                oIX0oI.f1507oIX0oI.oIX0oI("SSE onFailure -> t= " + th + ",  code=" + i + ",  msg=" + str);
                if (i == 200) {
                    if (str.length() > 0) {
                        callback.handleResponse(str);
                        return;
                    } else {
                        callback.handleError(String.valueOf(i));
                        return;
                    }
                }
                if (th != null) {
                    callback.handleError(th.toString());
                } else {
                    callback.handleError(String.valueOf(i));
                }
            }

            @Override // okhttp3.sse.EventSourceListener
            public void onOpen(@OOXIXo EventSource eventSource, @OOXIXo okhttp3.Response response) {
                IIX0o.x0xO0oo(eventSource, "eventSource");
                IIX0o.x0xO0oo(response, "response");
                super.onOpen(eventSource, response);
                oIX0oI.f1507oIX0oI.oIX0oI("SSE onOpen");
            }
        });
    }

    public final /* synthetic */ <T> void postV2(String url, Map<String, ? extends Object> body, II0xO0<T> callback, Activity activity, View view, Map<String, String> headers) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        printParam(convertBaseUrl + url, o0.xoIxX(body, headers));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postV2$1 netWorkUtils$postV2$1 = new NetWorkUtils$postV2$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addHeaders(headers).addBodyParameter((Map<String, String>) body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postV2$$inlined$postV2$1(netWorkUtils$postV2$1));
    }

    public final void printParam(@OOXIXo String url, @OOXIXo Map<String, ? extends Object> body) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(UtilsKt.IXxxXO() + ": ");
        int size = body.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(XIxXXX0x0.f29558oxoX);
            }
            stringBuffer.append((String) CollectionsKt___CollectionsKt.oOo0o(body.keySet()).get(i));
            stringBuffer.append('=');
            stringBuffer.append(CollectionsKt___CollectionsKt.oOo0o(body.values()).get(i));
        }
        oIX0oI.f1507oIX0oI.oIX0oI("p -> " + ((Object) stringBuffer));
    }

    public final /* synthetic */ <T> void responseData(Response<T> response, Activity activity, II0xO0<T> callback, I0X0x0oIo i0X0x0oIo) {
        IIX0o.x0xO0oo(callback, "callback");
        LogUtils.d(XO.f34062II0XooXoX + response);
        if (response == null) {
            response = new Response<>();
            response.setCode(-1000);
        }
        responseWhenCheck(activity, response, callback);
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    public final <T> void responseWhenCheck(@oOoXoXO Activity activity, @OOXIXo Response<T> response, @OOXIXo II0xO0<T> callback) {
        String mesg;
        String mesg2;
        IIX0o.x0xO0oo(response, "response");
        IIX0o.x0xO0oo(callback, "callback");
        if (activity == null) {
            int code = response.getCode();
            if (code != 0) {
                if (code != 1 && code != 2) {
                    callback.handleError(response.toString());
                    return;
                }
                if (response.getData() != null) {
                    mesg2 = String.valueOf(response.getData());
                } else {
                    mesg2 = response.getMesg();
                }
                callback.handleError(mesg2);
                return;
            }
            callback.handleResponse(response.getData());
            return;
        }
        int code2 = response.getCode();
        if (code2 != 0) {
            if (code2 != 1 && code2 != 2) {
                if (code2 != 1001) {
                    if (code2 != 2010) {
                        if (code2 != 2012) {
                            if (code2 != 4002) {
                                if (code2 != 4007) {
                                    switch (code2) {
                                        case 2001:
                                            ToastUtils.showLong(R.string.code_limit);
                                            return;
                                        case 2002:
                                            ToastUtils.showLong(R.string.verification_code_error);
                                            callback.handleError(response.toString());
                                            return;
                                        case 2003:
                                            ToastUtils.showLong(R.string.user_already_exists);
                                            callback.handleError(response.toString());
                                            return;
                                        case 2004:
                                            ToastUtils.showLong(R.string.user_does_not_exist);
                                            return;
                                        case 2005:
                                            break;
                                        default:
                                            ToastUtils.showLong(response.getCode() + ", " + ((Object) activity.getText(R.string.request_error)), new Object[0]);
                                            callback.handleError(response.toString());
                                            return;
                                    }
                                } else {
                                    ToastUtils.showLong(response.getMesg(), new Object[0]);
                                    return;
                                }
                            } else {
                                ToastUtils.showLong(R.string.project_does_not_exist);
                                return;
                            }
                        } else {
                            ToastUtils.showLong(R.string.wrong_password);
                            return;
                        }
                    }
                    ToastUtils.showLong(R.string.account_or_password_error);
                    return;
                }
                ToastUtils.showLong(R.string.parameter_check_failed);
                return;
            }
            if (response.getData() != null) {
                mesg = String.valueOf(response.getData());
            } else {
                mesg = response.getMesg();
            }
            callback.handleError(mesg);
            return;
        }
        callback.handleResponse(response.getData());
    }

    public final /* synthetic */ <T> void upload(String url, String fileParameter, File file, Object body, II0xO0<T> callback, Activity activity, View view) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(fileParameter, "fileParameter");
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = Api.INSTANCE.getBASE_URL() + url;
        IIX0o.xoXoI();
        NetWorkUtils$upload$1 netWorkUtils$upload$1 = new NetWorkUtils$upload$1(activity, callback, loadPopup);
        ANRequest.MultiPartBuilder upload = AndroidNetworking.upload(str);
        if (file.exists()) {
            upload.addMultipartFile(fileParameter, file);
        }
        ANRequest uploadProgressListener = upload.addMultipartParameter(body).setTag((Object) str).setPriority(Priority.HIGH).build().setUploadProgressListener(NetWorkUtils$upload$$inlined$upload$1.INSTANCE);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        uploadProgressListener.getAsParsed(parameterized, new NetWorkUtils$upload$$inlined$upload$2(netWorkUtils$upload$1));
    }

    public static /* synthetic */ void get$default(NetWorkUtils netWorkUtils, String url, Map body, II0xO0 callback, Activity activity, View view, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, body);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$get$1 netWorkUtils$get$1 = new NetWorkUtils$get$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.get(str).addQueryParameter((Map<String, String>) body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$get$$inlined$get$1(netWorkUtils$get$1));
    }

    public final /* synthetic */ <T> void get(String url, Map<String, String> body, II0xO0<T> callback, Activity activity, View view) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        printParam(convertBaseUrl + url, body);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$get$1 netWorkUtils$get$1 = new NetWorkUtils$get$1(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.get(str).addQueryParameter(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$get$$inlined$get$1(netWorkUtils$get$1));
    }

    public final /* synthetic */ <T> void postJsonV2(String url, Object body, II0xO0<T> callback, Activity activity, View view, Map<String, String> headers) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = loadPopup(activity, view);
        String convertBaseUrl = convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        printParam(convertBaseUrl + url, headers);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postJsonV2$2 netWorkUtils$postJsonV2$2 = new NetWorkUtils$postJsonV2$2(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addHeaders(headers).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postJsonV2$$inlined$postJsonV2$2(netWorkUtils$postJsonV2$2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postJsonV2$default(NetWorkUtils netWorkUtils, String url, Object body, II0xO0 callback, Activity activity, View view, Map headers, int i, Object obj) {
        if ((i & 8) != 0) {
            activity = null;
        }
        if ((i & 16) != 0) {
            view = null;
        }
        if ((i & 32) != 0) {
            headers = netWorkUtils.getHeadersMap();
        }
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(body, "body");
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(headers, "headers");
        I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, headers);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        IIX0o.xoXoI();
        NetWorkUtils$postJsonV2$2 netWorkUtils$postJsonV2$2 = new NetWorkUtils$postJsonV2$2(activity, callback, loadPopup);
        ANRequest build = AndroidNetworking.post(str).addHeaders((Map<String, String>) headers).addApplicationJsonBody(body).setTag((Object) str).setPriority(Priority.HIGH).build();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeToken<?> parameterized = TypeToken.getParameterized(Response.class, Object.class);
        IIX0o.xoXoI();
        build.getAsParsed(parameterized, new NetWorkUtils$postJsonV2$$inlined$postJsonV2$2(netWorkUtils$postJsonV2$2));
    }
}
