package com.sma.smartv3.biz;

import android.app.Activity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.BGEMMeasurementData;
import com.sma.smartv3.model.BGEMRangeAnalysisResult;
import com.sma.smartv3.model.BGEMResponse;
import com.sma.smartv3.model.BGEMUser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.BGEMAnalysis;
import com.sma.smartv3.network.BGEMUserAuthorise;
import com.sma.smartv3.network.BGEMUserUpdate;
import com.sma.smartv3.network.BGEMeasurementByDate;
import com.sma.smartv3.network.BGEMeasurementById;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBGEMManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BGEMManager.kt\ncom/sma/smartv3/biz/BGEMManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,158:1\n19#2:159\n15#2:160\n19#2:183\n15#2:184\n173#3,12:161\n194#3:182\n173#3,12:185\n194#3:206\n242#3,12:207\n264#3:237\n128#3,12:238\n149#3:259\n128#3,12:260\n149#3:281\n234#4,8:173\n254#4:181\n234#4,8:197\n254#4:205\n285#4,18:219\n182#4,8:250\n201#4:258\n182#4,8:272\n201#4:280\n*S KotlinDebug\n*F\n+ 1 BGEMManager.kt\ncom/sma/smartv3/biz/BGEMManager\n*L\n32#1:159\n32#1:160\n55#1:183\n55#1:184\n33#1:161,12\n33#1:182\n56#1:185,12\n56#1:206\n82#1:207,12\n82#1:237\n117#1:238,12\n117#1:259\n142#1:260,12\n142#1:281\n33#1:173,8\n33#1:181\n56#1:197,8\n56#1:205\n82#1:219,18\n117#1:250,8\n117#1:258\n142#1:272,8\n142#1:280\n*E\n"})
/* loaded from: classes12.dex */
public final class BGEMManager {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19912II0xO0 = "BGEMManager";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final BGEMManager f19913oIX0oI = new BGEMManager();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void II0XooXoX(BGEMManager bGEMManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        bGEMManager.Oxx0IOOO(oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void II0xO0(BGEMManager bGEMManager, Object obj, xxxI.II0xO0 iI0xO0, int i, Object obj2) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        bGEMManager.oIX0oI(obj, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XO(BGEMManager bGEMManager, String str, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        bGEMManager.X0o0xo(str, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void oxoX(BGEMManager bGEMManager, String str, String str2, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 4) != 0) {
            iI0xO0 = null;
        }
        bGEMManager.I0Io(str, str2, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void xoIox(BGEMManager bGEMManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        bGEMManager.xxIXOIIO(oooxoxo);
    }

    public final void I0Io(@OXOo.OOXIXo String startDate, @OXOo.OOXIXo String endDate, @OXOo.oOoXoXO final xxxI.II0xO0<BGEMRangeAnalysisResult[]> iI0xO0) {
        IIX0o.x0xO0oo(startDate, "startDate");
        IIX0o.x0xO0oo(endDate, "endDate");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String url = BGEMeasurementByDate.INSTANCE.getURL(startDate, endDate);
        Map<String, String> O0xOxO2 = o0.O0xOxO();
        final xxxI.II0xO0<BGEMRangeAnalysisResult[]> iI0xO02 = new xxxI.II0xO0<BGEMRangeAnalysisResult[]>() { // from class: com.sma.smartv3.biz.BGEMManager$measurementByDate$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager measurementByDate handleError -> " + error);
                xxxI.II0xO0<BGEMRangeAnalysisResult[]> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BGEMRangeAnalysisResult[] bGEMRangeAnalysisResultArr) {
                Integer num;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                sb.append("BGEMManager measurementByDate handleResponse -> ");
                if (bGEMRangeAnalysisResultArr != null) {
                    num = Integer.valueOf(bGEMRangeAnalysisResultArr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                oix0oi.oIX0oI(sb.toString());
                xxxI.II0xO0<BGEMRangeAnalysisResult[]> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleResponse(bGEMRangeAnalysisResultArr);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, o0.xoIxX(O0xOxO2, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        final xxxI.II0xO0<Response<BGEMRangeAnalysisResult[]>> iI0xO03 = new xxxI.II0xO0<Response<BGEMRangeAnalysisResult[]>>() { // from class: com.sma.smartv3.biz.BGEMManager$measurementByDate$$inlined$getV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BGEMRangeAnalysisResult[]> response) {
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
        AndroidNetworking.get(str).addQueryParameter(O0xOxO2).setTag((Object) str).addHeaders(headersMap).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BGEMRangeAnalysisResult[].class), new ParsedRequestListener<Response<BGEMRangeAnalysisResult[]>>() { // from class: com.sma.smartv3.biz.BGEMManager$measurementByDate$$inlined$getV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BGEMRangeAnalysisResult[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
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

    public final void Oxx0IOOO(@OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> bGEMUserBody = RequestBodyKt.getBGEMUserBody(BGEMUser.Companion.of((AppUser) appUser));
        final xxxI.II0xO0<BGEMUser> iI0xO0 = new xxxI.II0xO0<BGEMUser>() { // from class: com.sma.smartv3.biz.BGEMManager$userAuthorise$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager userAuthorise handleError -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BGEMUser bGEMUser) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager userAuthorise handleResponse -> " + bGEMUser);
                Xo0.f24349oIX0oI.XO().put(BGEMUser.class.getName(), new Gson().toJson(bGEMUser));
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BGEMUserAuthorise.URL);
        netWorkUtils.printParam(convertBaseUrl + BGEMUserAuthorise.URL, o0.xoIxX(bGEMUserBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BGEMUserAuthorise.URL;
        final xxxI.II0xO0<Response<BGEMUser>> iI0xO02 = new xxxI.II0xO0<Response<BGEMUser>>() { // from class: com.sma.smartv3.biz.BGEMManager$userAuthorise$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BGEMUser> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) bGEMUserBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BGEMUser.class), new ParsedRequestListener<Response<BGEMUser>>() { // from class: com.sma.smartv3.biz.BGEMManager$userAuthorise$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BGEMUser> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
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

    public final void X0o0xo(@OXOo.OOXIXo String measurementId, @OXOo.oOoXoXO final xxxI.II0xO0<BGEMRangeAnalysisResult> iI0xO0) {
        IIX0o.x0xO0oo(measurementId, "measurementId");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String url = BGEMeasurementById.INSTANCE.getURL(measurementId);
        Map<String, String> O0xOxO2 = o0.O0xOxO();
        final xxxI.II0xO0<BGEMRangeAnalysisResult> iI0xO02 = new xxxI.II0xO0<BGEMRangeAnalysisResult>() { // from class: com.sma.smartv3.biz.BGEMManager$measurementById$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager measurementById handleError -> " + error);
                xxxI.II0xO0<BGEMRangeAnalysisResult> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BGEMRangeAnalysisResult bGEMRangeAnalysisResult) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager measurementById handleResponse -> " + bGEMRangeAnalysisResult);
                xxxI.II0xO0<BGEMRangeAnalysisResult> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleResponse(bGEMRangeAnalysisResult);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, o0.xoIxX(O0xOxO2, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        final xxxI.II0xO0<Response<BGEMRangeAnalysisResult>> iI0xO03 = new xxxI.II0xO0<Response<BGEMRangeAnalysisResult>>() { // from class: com.sma.smartv3.biz.BGEMManager$measurementById$$inlined$getV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BGEMRangeAnalysisResult> response) {
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
        AndroidNetworking.get(str).addQueryParameter(O0xOxO2).setTag((Object) str).addHeaders(headersMap).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BGEMRangeAnalysisResult.class), new ParsedRequestListener<Response<BGEMRangeAnalysisResult>>() { // from class: com.sma.smartv3.biz.BGEMManager$measurementById$$inlined$getV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BGEMRangeAnalysisResult> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
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

    public final void oIX0oI(@OXOo.OOXIXo Object measurementData, @OXOo.oOoXoXO final xxxI.II0xO0<BGEMResponse<BGEMMeasurementData>> iI0xO0) {
        IIX0o.x0xO0oo(measurementData, "measurementData");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final xxxI.II0xO0<JsonObject> iI0xO02 = new xxxI.II0xO0<JsonObject>() { // from class: com.sma.smartv3.biz.BGEMManager$analysis$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager analysis handleError -> " + error);
                xxxI.II0xO0<BGEMResponse<BGEMMeasurementData>> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO JsonObject jsonObject) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager analysis handleResponse -> " + jsonObject);
                try {
                    Object fromJson = new Gson().fromJson(jsonObject, TypeToken.getParameterized(BGEMResponse.class, BGEMMeasurementData.class));
                    IIX0o.x0XOIxOo(fromJson, "null cannot be cast to non-null type com.sma.smartv3.model.BGEMResponse<com.sma.smartv3.model.BGEMMeasurementData>");
                    BGEMResponse<BGEMMeasurementData> bGEMResponse = (BGEMResponse) fromJson;
                    xxxI.II0xO0<BGEMResponse<BGEMMeasurementData>> iI0xO03 = iI0xO0;
                    if (iI0xO03 != null) {
                        iI0xO03.handleResponse(bGEMResponse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    xxxI.II0xO0<BGEMResponse<BGEMMeasurementData>> iI0xO04 = iI0xO0;
                    if (iI0xO04 != null) {
                        String localizedMessage = e.getLocalizedMessage();
                        IIX0o.oO(localizedMessage, "getLocalizedMessage(...)");
                        iI0xO04.handleError(localizedMessage);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BGEMAnalysis.URL);
        netWorkUtils.printParam(convertBaseUrl + BGEMAnalysis.URL, headersMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BGEMAnalysis.URL;
        final xxxI.II0xO0<Response<JsonObject>> iI0xO03 = new xxxI.II0xO0<Response<JsonObject>>() { // from class: com.sma.smartv3.biz.BGEMManager$analysis$$inlined$postJsonV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<JsonObject> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addApplicationJsonBody(measurementData).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, JsonObject.class), new ParsedRequestListener<Response<JsonObject>>() { // from class: com.sma.smartv3.biz.BGEMManager$analysis$$inlined$postJsonV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<JsonObject> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    public final void xxIXOIIO(@OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> bGEMUserBody = RequestBodyKt.getBGEMUserBody(BGEMUser.Companion.of((AppUser) appUser));
        final xxxI.II0xO0<BGEMUser> iI0xO0 = new xxxI.II0xO0<BGEMUser>() { // from class: com.sma.smartv3.biz.BGEMManager$userUpdate$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager userUpdate handleError -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO BGEMUser bGEMUser) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("BGEMManager userUpdate handleResponse -> " + bGEMUser);
                Xo0.f24349oIX0oI.XO().put(BGEMUser.class.getName(), new Gson().toJson(bGEMUser));
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BGEMUserUpdate.URL);
        netWorkUtils.printParam(convertBaseUrl + BGEMUserUpdate.URL, o0.xoIxX(bGEMUserBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BGEMUserUpdate.URL;
        final xxxI.II0xO0<Response<BGEMUser>> iI0xO02 = new xxxI.II0xO0<Response<BGEMUser>>() { // from class: com.sma.smartv3.biz.BGEMManager$userUpdate$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<BGEMUser> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) bGEMUserBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, BGEMUser.class), new ParsedRequestListener<Response<BGEMUser>>() { // from class: com.sma.smartv3.biz.BGEMManager$userUpdate$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<BGEMUser> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
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
