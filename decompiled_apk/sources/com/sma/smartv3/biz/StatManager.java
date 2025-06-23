package com.sma.smartv3.biz;

import android.app.Activity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.UploadBaiduServiceCallLog;
import com.sma.smartv3.model.UploadBaiduServiceCallLogData;
import com.sma.smartv3.model.UploadData;
import com.sma.smartv3.model.UploadDownloadInfo;
import com.sma.smartv3.model.UploadDownloadInfoData;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.szabh.smable3.component.BleCache;
import java.util.Arrays;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;

@XX({"SMAP\nStatManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatManager.kt\ncom/sma/smartv3/biz/StatManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,95:1\n19#2:96\n15#2:97\n196#3,10:98\n216#3:125\n196#3,10:126\n216#3:153\n261#4,17:108\n261#4,17:136\n*S KotlinDebug\n*F\n+ 1 StatManager.kt\ncom/sma/smartv3/biz/StatManager\n*L\n30#1:96\n30#1:97\n48#1:98,10\n48#1:125\n78#1:126,10\n78#1:153\n48#1:108,17\n78#1:136,17\n*E\n"})
/* loaded from: classes12.dex */
public final class StatManager {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20199II0xO0 = "StatManager";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final StatManager f20200oIX0oI = new StatManager();

    public static /* synthetic */ void oxoX(StatManager statManager, String str, long j, int i, int i2, int i3, Object obj) {
        int i4;
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        statManager.I0Io(str, j, i, i4);
    }

    public final void I0Io(@OXOo.OOXIXo String filePath, long j, int i, int i2) {
        IIX0o.x0xO0oo(filePath, "filePath");
        UploadDownloadInfoData uploadDownloadInfoData = new UploadDownloadInfoData();
        uploadDownloadInfoData.setFilePath(filePath);
        uploadDownloadInfoData.setFileSize(f20200oIX0oI.oIX0oI(j));
        uploadDownloadInfoData.setFileCategory(String.valueOf(i));
        BleCache bleCache = BleCache.INSTANCE;
        uploadDownloadInfoData.setBleName(bleCache.getMBleName());
        uploadDownloadInfoData.setFirmwareFlag(bleCache.getMFirmwareFlag());
        uploadDownloadInfoData.setProjectId("2");
        if (i2 != -1) {
            uploadDownloadInfoData.setEleId(String.valueOf(i2));
        }
        LogUtils.d("StatManager uploadDownloadInfo -> " + new Gson().toJson(uploadDownloadInfoData));
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final xxxI.II0xO0<Object> iI0xO0 = new xxxI.II0xO0<Object>() { // from class: com.sma.smartv3.biz.StatManager$uploadDownloadInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("StatManager handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Object obj) {
                LogUtils.d("StatManager handleResponse -> " + obj);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), UploadDownloadInfo.URL);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + UploadDownloadInfo.URL;
        final xxxI.II0xO0<Response<Object>> iI0xO02 = new xxxI.II0xO0<Response<Object>>() { // from class: com.sma.smartv3.biz.StatManager$uploadDownloadInfo$$inlined$postJson$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Object> response) {
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
        AndroidNetworking.post(str).addApplicationJsonBody(uploadDownloadInfoData).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Object.class), new ParsedRequestListener<Response<Object>>() { // from class: com.sma.smartv3.biz.StatManager$uploadDownloadInfo$$inlined$postJson$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Object> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    public final void II0xO0(int i) {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        UploadData uploadData = new UploadData();
        uploadData.setIdentity(((AppUser) appUser).getIdentity());
        UploadBaiduServiceCallLogData uploadBaiduServiceCallLogData = new UploadBaiduServiceCallLogData();
        BleCache bleCache = BleCache.INSTANCE;
        uploadBaiduServiceCallLogData.setBleName(bleCache.getMBleName());
        uploadBaiduServiceCallLogData.setFirmwareFlag(bleCache.getMFirmwareFlag());
        uploadBaiduServiceCallLogData.setProjectId(2);
        uploadBaiduServiceCallLogData.setPlatform(2);
        String appVersionName = AppUtils.getAppVersionName();
        IIX0o.oO(appVersionName, "getAppVersionName(...)");
        uploadBaiduServiceCallLogData.setAppVersion(appVersionName);
        uploadBaiduServiceCallLogData.setCallType(i);
        uploadBaiduServiceCallLogData.setCallTime(System.currentTimeMillis());
        uploadBaiduServiceCallLogData.setMacAddress(OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        uploadBaiduServiceCallLogData.setRemark("");
        uploadData.setData(oI0IIXIo.OOXIXo(uploadBaiduServiceCallLogData));
        LogUtils.d("StatManager uploadBaiduServiceCallLog -> " + new Gson().toJson(uploadData));
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final xxxI.II0xO0<Object> iI0xO0 = new xxxI.II0xO0<Object>() { // from class: com.sma.smartv3.biz.StatManager$uploadBaiduServiceCallLog$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("StatManager handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO Object obj) {
                LogUtils.d("StatManager handleResponse -> " + obj);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), UploadBaiduServiceCallLog.URL);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + UploadBaiduServiceCallLog.URL;
        final xxxI.II0xO0<Response<Object>> iI0xO02 = new xxxI.II0xO0<Response<Object>>() { // from class: com.sma.smartv3.biz.StatManager$uploadBaiduServiceCallLog$$inlined$postJson$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Object> response) {
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
        AndroidNetworking.post(str).addApplicationJsonBody(uploadData).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Object.class), new ParsedRequestListener<Response<Object>>() { // from class: com.sma.smartv3.biz.StatManager$uploadBaiduServiceCallLog$$inlined$postJson$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Object> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    public final String oIX0oI(long j) {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%dkb", Arrays.copyOf(new Object[]{Long.valueOf(j / 1024)}, 1));
        IIX0o.oO(format, "format(...)");
        return format;
    }
}
