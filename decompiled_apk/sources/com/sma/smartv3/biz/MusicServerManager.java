package com.sma.smartv3.biz;

import android.app.Activity;
import android.content.Context;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.TeraBoxItemDLink;
import com.sma.smartv3.model.TeraBoxListItem;
import com.sma.smartv3.model.TeraBoxShareLink;
import com.sma.smartv3.model.TeraBoxToken;
import com.sma.smartv3.model.TeraBoxTokenInfo;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetInternalTeraBoxRefreshToken;
import com.sma.smartv3.network.GetInternalTeraBoxToken;
import com.sma.smartv3.network.GetShareUrl;
import com.sma.smartv3.network.GetTeraBoxRefreshToken;
import com.sma.smartv3.network.GetTeraBoxToken;
import com.sma.smartv3.network.GetTeraBoxTokenInfo;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.work.UploadOSSWorker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.o0;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import org.json.JSONArray;
import org.json.JSONObject;

@XX({"SMAP\nMusicServerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MusicServerManager.kt\ncom/sma/smartv3/biz/MusicServerManager\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,527:1\n173#2,12:528\n194#2:549\n173#2,12:550\n194#2:571\n173#2,12:572\n194#2:593\n173#2,12:594\n194#2:615\n101#2,11:619\n121#2:638\n234#3,8:540\n254#3:548\n234#3,8:562\n254#3:570\n234#3,8:584\n254#3:592\n234#3,8:606\n254#3:614\n156#3,7:630\n174#3:637\n93#4,2:616\n90#4:618\n*S KotlinDebug\n*F\n+ 1 MusicServerManager.kt\ncom/sma/smartv3/biz/MusicServerManager\n*L\n310#1:528,12\n310#1:549\n340#1:550,12\n340#1:571\n385#1:572,12\n385#1:593\n437#1:594,12\n437#1:615\n490#1:619,11\n490#1:638\n310#1:540,8\n310#1:548\n340#1:562,8\n340#1:570\n385#1:584,8\n385#1:592\n437#1:606,8\n437#1:614\n490#1:630,7\n490#1:637\n477#1:616,2\n477#1:618\n*E\n"})
/* loaded from: classes12.dex */
public final class MusicServerManager {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f20076I0Io = -1;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20077II0xO0 = "TeraBoxManager";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static OSSClient f20079XO = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f20081oxoX = 200;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final MusicServerManager f20080oIX0oI = new MusicServerManager();

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String f20078X0o0xo = "";

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void X0o0xo(MusicServerManager musicServerManager, String str, String str2, String str3, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 8) != 0) {
            oooxoxo = null;
        }
        musicServerManager.oxoX(str, str2, str3, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x0XOIxOo(MusicServerManager musicServerManager, String str, String str2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        musicServerManager.ooOOo0oXI(str, str2, oooxoxo);
    }

    public static /* synthetic */ void x0xO0oo(MusicServerManager musicServerManager, String str, String str2, int i, int i2, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        int i4;
        int i5;
        if ((i3 & 2) != 0) {
            str2 = "/";
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i4 = 1;
        } else {
            i4 = i;
        }
        if ((i3 & 8) != 0) {
            i5 = 100;
        } else {
            i5 = i2;
        }
        if ((i3 & 16) != 0) {
            oooxoxo = null;
        }
        musicServerManager.oO(str, str3, i4, i5, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void xoIox(MusicServerManager musicServerManager, String str, List list, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        musicServerManager.xxIXOIIO(str, list, oooxoxo);
    }

    public final boolean I0Io(long j) {
        if (System.currentTimeMillis() - j > 864000) {
            return true;
        }
        return false;
    }

    @OXOo.oOoXoXO
    public final OSSClient II0XooXoX() {
        return f20079XO;
    }

    @OXOo.oOoXoXO
    public final OSSClient II0xO0(@OXOo.oOoXoXO UploadOSSWorker.StsRamData stsRamData) {
        String str;
        String str2;
        String str3;
        String str4;
        String endPoint;
        UploadOSSWorker.ResponseData response;
        UploadOSSWorker.Credentials credentials;
        UploadOSSWorker.ResponseData response2;
        UploadOSSWorker.Credentials credentials2;
        UploadOSSWorker.ResponseData response3;
        UploadOSSWorker.Credentials credentials3;
        String str5 = "";
        if (stsRamData == null || (response3 = stsRamData.getResponse()) == null || (credentials3 = response3.getCredentials()) == null || (str = credentials3.getAccessKeySecret()) == null) {
            str = "";
        }
        if (stsRamData == null || (response2 = stsRamData.getResponse()) == null || (credentials2 = response2.getCredentials()) == null || (str2 = credentials2.getAccessKeyId()) == null) {
            str2 = "";
        }
        if (stsRamData == null || (response = stsRamData.getResponse()) == null || (credentials = response.getCredentials()) == null || (str3 = credentials.getSecurityToken()) == null) {
            str3 = "";
        }
        if (stsRamData == null || (str4 = stsRamData.getBucket()) == null) {
            str4 = "";
        }
        if (stsRamData != null && (endPoint = stsRamData.getEndPoint()) != null) {
            str5 = endPoint;
        }
        if (str3.length() > 0 && str.length() > 0 && str2.length() > 0 && str4.length() > 0) {
            f20079XO = new OSSClient(Utils.getApp(), str5, new OSSStsTokenCredentialProvider(str2, str, str3));
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("TeraBoxManager  createOSSClient   bucket = " + str4);
        }
        return f20079XO;
    }

    public final void IIXOooo() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.XO().remove(XoI0Ixx0.f24397OoO);
        xo0.XO().remove(XoI0Ixx0.f24386OIOoIIOIx);
    }

    public final void IXxxXO(@OXOo.OOXIXo String code, @OXOo.OOXIXo final Oox.oOoXoXO<? super String, oXIO0o0XI> callback) {
        HashMap<String, String> internalTeraBoxTokenBody;
        String str;
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(callback, "callback");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            internalTeraBoxTokenBody = RequestBodyKt.getTeraBoxTokenBody(code);
            str = GetTeraBoxToken.URL;
        } else {
            internalTeraBoxTokenBody = RequestBodyKt.getInternalTeraBoxTokenBody(code, UtilsKt.oI0IIXIo(R.string.tera_box_domestic_url_scheme));
            str = GetInternalTeraBoxToken.URL;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final xxxI.II0xO0<TeraBoxToken> iI0xO0 = new xxxI.II0xO0<TeraBoxToken>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxToken$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getOnLinWatchFaceList -> " + error);
                callback.invoke("");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO TeraBoxToken teraBoxToken) {
                LogUtils.d("getTeraBoxToken -> " + teraBoxToken);
                try {
                    if (teraBoxToken != null) {
                        Xo0 xo0 = Xo0.f24349oIX0oI;
                        xo0.XO().put(XoI0Ixx0.f24397OoO, teraBoxToken.getAccess_token());
                        xo0.XO().put(XoI0Ixx0.f24386OIOoIIOIx, teraBoxToken.getRefresh_token());
                        xo0.XO().put(XoI0Ixx0.f24470x0OIX00oO, System.currentTimeMillis());
                        callback.invoke(teraBoxToken.getAccess_token());
                    } else {
                        callback.invoke("");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.invoke("");
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), str);
        netWorkUtils.printParam(convertBaseUrl + str, o0.xoIxX(internalTeraBoxTokenBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + str;
        final xxxI.II0xO0<Response<TeraBoxToken>> iI0xO02 = new xxxI.II0xO0<Response<TeraBoxToken>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxToken$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<TeraBoxToken> response) {
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
        AndroidNetworking.post(str2).addHeaders(headersMap).addBodyParameter((Map<String, String>) internalTeraBoxTokenBody).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, TeraBoxToken.class), new ParsedRequestListener<Response<TeraBoxToken>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxToken$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<TeraBoxToken> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
                String str5;
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
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", exception:");
                if (aNError != null) {
                    str5 = aNError.getLocalizedMessage();
                } else {
                    str5 = null;
                }
                sb.append(str5);
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

    public final void OOXIXo(@OXOo.OOXIXo final Oox.oOoXoXO<? super String, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        boolean xxxI2 = ProjectManager.f19822oIX0oI.xxxI();
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        hashMap.put("internalFlag", String.valueOf(xxxI2 ? 1 : 0));
        final xxxI.II0xO0<TeraBoxShareLink> iI0xO0 = new xxxI.II0xO0<TeraBoxShareLink>() { // from class: com.sma.smartv3.biz.MusicServerManager$getNetDiskShareUrl$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getNetDiskShareUrl -> " + error);
                callback.invoke("");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO TeraBoxShareLink teraBoxShareLink) {
                LogUtils.d("getNetDiskShareUrl -> " + teraBoxShareLink);
                try {
                    if (teraBoxShareLink != null) {
                        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24427XXoOx0, teraBoxShareLink.getShareUrl());
                        callback.invoke(teraBoxShareLink.getShareUrl());
                    } else {
                        callback.invoke("");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.invoke("");
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetShareUrl.URL);
        netWorkUtils.printParam(convertBaseUrl + GetShareUrl.URL, o0.xoIxX(hashMap, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetShareUrl.URL;
        final xxxI.II0xO0<Response<TeraBoxShareLink>> iI0xO02 = new xxxI.II0xO0<Response<TeraBoxShareLink>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getNetDiskShareUrl$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<TeraBoxShareLink> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, TeraBoxShareLink.class), new ParsedRequestListener<Response<TeraBoxShareLink>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getNetDiskShareUrl$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<TeraBoxShareLink> response) {
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

    public final void Oo(@OXOo.OOXIXo String token, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        HashMap<String, String> internalTeraBoxRefreshTokenBody;
        String str;
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(callback, "callback");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            internalTeraBoxRefreshTokenBody = RequestBodyKt.getTeraBoxRefreshTokenBody(token);
            str = GetTeraBoxRefreshToken.URL;
        } else {
            internalTeraBoxRefreshTokenBody = RequestBodyKt.getInternalTeraBoxRefreshTokenBody(token);
            str = GetInternalTeraBoxRefreshToken.URL;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final xxxI.II0xO0<TeraBoxToken> iI0xO0 = new xxxI.II0xO0<TeraBoxToken>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxRefreshToken$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getTeraBoxRefreshToken -> " + error);
                MusicServerManager.f20080oIX0oI.IIXOooo();
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO TeraBoxToken teraBoxToken) {
                LogUtils.d("getTeraBoxRefreshToken -> " + teraBoxToken);
                try {
                    if (teraBoxToken != null) {
                        Xo0 xo0 = Xo0.f24349oIX0oI;
                        xo0.XO().put(XoI0Ixx0.f24397OoO, teraBoxToken.getAccess_token());
                        xo0.XO().put(XoI0Ixx0.f24386OIOoIIOIx, teraBoxToken.getRefresh_token());
                        xo0.XO().put(XoI0Ixx0.f24470x0OIX00oO, System.currentTimeMillis());
                        callback.invoke(Boolean.TRUE);
                    } else {
                        MusicServerManager.f20080oIX0oI.IIXOooo();
                        callback.invoke(Boolean.FALSE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    MusicServerManager.f20080oIX0oI.IIXOooo();
                    callback.invoke(Boolean.FALSE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), str);
        netWorkUtils.printParam(convertBaseUrl + str, o0.xoIxX(internalTeraBoxRefreshTokenBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + str;
        final xxxI.II0xO0<Response<TeraBoxToken>> iI0xO02 = new xxxI.II0xO0<Response<TeraBoxToken>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxRefreshToken$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<TeraBoxToken> response) {
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
        AndroidNetworking.post(str2).addHeaders(headersMap).addBodyParameter((Map<String, String>) internalTeraBoxRefreshTokenBody).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, TeraBoxToken.class), new ParsedRequestListener<Response<TeraBoxToken>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxRefreshToken$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<TeraBoxToken> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
                String str5;
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
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", exception:");
                if (aNError != null) {
                    str5 = aNError.getLocalizedMessage();
                } else {
                    str5 = null;
                }
                sb.append(str5);
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

    @OXOo.OOXIXo
    public final String Oxx0IOOO() {
        return f20078X0o0xo;
    }

    public final void Oxx0xo(@OXOo.OOXIXo String token, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(token, "token");
        IIX0o.x0xO0oo(callback, "callback");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            HashMap<String, String> teraBoxTokenInfoBody = RequestBodyKt.getTeraBoxTokenInfoBody(token);
            final xxxI.II0xO0<TeraBoxTokenInfo> iI0xO0 = new xxxI.II0xO0<TeraBoxTokenInfo>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxTokenInfo$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    LogUtils.d("getTeraBoxTokenInfo -> " + error);
                    callback.invoke(Boolean.FALSE);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO TeraBoxTokenInfo teraBoxTokenInfo) {
                    LogUtils.d("getTeraBoxTokenInfo -> " + teraBoxTokenInfo);
                    if (teraBoxTokenInfo != null) {
                        try {
                            String user_id = teraBoxTokenInfo.getUser_id();
                            if (user_id != null && user_id.length() > 0) {
                                callback.invoke(Boolean.TRUE);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            callback.invoke(Boolean.FALSE);
                            return;
                        }
                    }
                    callback.invoke(Boolean.FALSE);
                }
            };
            Map<String, String> headersMap = netWorkUtils.getHeadersMap();
            final Activity activity = null;
            final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
            String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetTeraBoxTokenInfo.URL);
            netWorkUtils.printParam(convertBaseUrl + GetTeraBoxTokenInfo.URL, o0.xoIxX(teraBoxTokenInfoBody, headersMap));
            NetWork netWork = NetWork.f19682oIX0oI;
            String str = convertBaseUrl + GetTeraBoxTokenInfo.URL;
            final xxxI.II0xO0<Response<TeraBoxTokenInfo>> iI0xO02 = new xxxI.II0xO0<Response<TeraBoxTokenInfo>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxTokenInfo$$inlined$postV2$default$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO Response<TeraBoxTokenInfo> response) {
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
            AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) teraBoxTokenInfoBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, TeraBoxTokenInfo.class), new ParsedRequestListener<Response<TeraBoxTokenInfo>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxTokenInfo$$inlined$postV2$default$2
                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void onResponse(@OXOo.OOXIXo Response<TeraBoxTokenInfo> response) {
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
            return;
        }
        callback.invoke(Boolean.valueOf(I0Io(Xo0.f24349oIX0oI.XO().getLong(XoI0Ixx0.f24470x0OIX00oO, 0L))));
    }

    public final void OxxIIOOXO(@OXOo.OOXIXo Oox.oOoXoXO<? super Pair<UploadOSSWorker.StsRamData, Integer>, oXIO0o0XI> callback) {
        UploadOSSWorker.Credentials credentials;
        String expiration;
        IIX0o.x0xO0oo(callback, "callback");
        SPUtils I0Io2 = Xo0.f24349oIX0oI.I0Io();
        UploadOSSWorker uploadOSSWorker = UploadOSSWorker.f25800oIX0oI;
        String oO2 = uploadOSSWorker.oO();
        Object fromJson = new Gson().fromJson(I0Io2.getString(oO2 + '_' + UploadOSSWorker.StsRamData.class.getName()), (Class<Object>) UploadOSSWorker.StsRamData.class);
        if (fromJson == null) {
            fromJson = UploadOSSWorker.StsRamData.class.newInstance();
        }
        UploadOSSWorker.StsRamData stsRamData = (UploadOSSWorker.StsRamData) fromJson;
        UploadOSSWorker.ResponseData response = stsRamData.getResponse();
        if (response != null && (credentials = response.getCredentials()) != null && (expiration = credentials.getExpiration()) != null && expiration.length() > 0) {
            if (uploadOSSWorker.xoIox(stsRamData.getResponse().getCredentials().getExpiration())) {
                oOoXoXO(callback);
                return;
            } else {
                callback.invoke(new Pair(stsRamData, 0));
                return;
            }
        }
        oOoXoXO(callback);
    }

    @OXOo.OOXIXo
    public final String XO(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            return "https://www.terabox.com/wap/outside/login?clientId=" + context.getString(R.string.tera_box_client) + "&isFromApp=1";
        }
        return "http://openapi.baidu.com/oauth/2.0/authorize?response_type=code&display=mobile&device_id=" + context.getString(R.string.tera_box_domestic_client_id) + "&client_id=" + context.getString(R.string.tera_box_domestic_client_key) + "&redirect_uri=" + UtilsKt.oI0IIXIo(R.string.tera_box_domestic_url_scheme) + "&scope=basic,netdisk";
    }

    public final void o00(@OXOo.oOoXoXO OSSClient oSSClient) {
        f20079XO = oSSClient;
    }

    public final boolean oI0IIXIo(@OXOo.OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        if (!OxI.XO0o(name, ".mp3", false, 2, null) && !OxI.XO0o(name, ".MP3", false, 2, null)) {
            return false;
        }
        return true;
    }

    public final void oIX0oI() {
        if (f20078X0o0xo.length() > 0) {
            AndroidNetworking.cancel(f20078X0o0xo);
        }
    }

    public final void oO(@OXOo.OOXIXo String access_tokens, @OXOo.OOXIXo String dir, int i, int i2, @OXOo.oOoXoXO final Oox.oOoXoXO<? super List<TeraBoxListItem>, oXIO0o0XI> oooxoxo) {
        String str;
        IIX0o.x0xO0oo(access_tokens, "access_tokens");
        IIX0o.x0xO0oo(dir, "dir");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            str = "https://www.terabox.com/openapi/api/list?access_tokens=" + access_tokens + "&page=" + i + "&dir=" + dir + "&num=" + i2;
        } else {
            str = "https://pan.baidu.com/rest/2.0/xpan/file?method=list&access_token=" + access_tokens + "&dir=" + dir;
        }
        AndroidNetworking.get(str).setPriority(Priority.LOW).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxList$1

            @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 MusicServerManager.kt\ncom/sma/smartv3/biz/MusicServerManager$getTeraBoxList$1\n*L\n1#1,328:1\n114#2:329\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class oIX0oI<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    boolean z;
                    boolean z2 = false;
                    if (((TeraBoxListItem) t).getIsdir() < 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    if (((TeraBoxListItem) t2).getIsdir() < 1) {
                        z2 = true;
                    }
                    return xX0ox.Oxx0IOOO.oOoXoXO(valueOf, Boolean.valueOf(z2));
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                String str2;
                String str3;
                String str4;
                StringBuilder sb = new StringBuilder();
                sb.append("onError -> error = ");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                LogUtils.d(sb.toString());
                if (aNError != null) {
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    ToastUtils.showLong("TeraBox is not available in current area", new Object[0]);
                } else {
                    if (aNError != null) {
                        str4 = aNError.getErrorBody();
                    } else {
                        str4 = null;
                    }
                    ToastUtils.showLong(str4, new Object[0]);
                }
                Oox.oOoXoXO<List<TeraBoxListItem>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                int i3;
                String str2 = "server_filename";
                LogUtils.d("onResponse -> " + jSONObject);
                if (jSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("list");
                        if (jSONArray != null) {
                            Oox.oOoXoXO<List<TeraBoxListItem>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                            ArrayList arrayList = new ArrayList();
                            int length = jSONArray.length();
                            int i4 = 0;
                            while (i4 < length) {
                                int i5 = jSONArray.getJSONObject(i4).getInt("isdir");
                                String string = jSONArray.getJSONObject(i4).getString(str2);
                                long j = jSONArray.getJSONObject(i4).getLong("fs_id");
                                String string2 = jSONArray.getJSONObject(i4).getString("category");
                                IIX0o.oO(string2, "getString(...)");
                                long j2 = jSONArray.getJSONObject(i4).getLong("local_mtime");
                                long j3 = jSONArray.getJSONObject(i4).getLong("server_ctime");
                                String string3 = jSONArray.getJSONObject(i4).getString(str2);
                                IIX0o.oO(string3, "getString(...)");
                                String str3 = str2;
                                int i6 = jSONArray.getJSONObject(i4).getInt(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE);
                                int i7 = jSONArray.getJSONObject(i4).getInt("isdir");
                                String string4 = jSONArray.getJSONObject(i4).getString("path");
                                IIX0o.oO(string4, "getString(...)");
                                JSONArray jSONArray2 = jSONArray;
                                TeraBoxListItem teraBoxListItem = new TeraBoxListItem(j, string2, j2, j3, string3, i6, i7, string4);
                                LogUtils.d("terabox list item teraBox = " + teraBoxListItem + TokenParser.SP);
                                if (i5 == 0) {
                                    MusicServerManager musicServerManager = MusicServerManager.f20080oIX0oI;
                                    IIX0o.ooOOo0oXI(string);
                                    if (musicServerManager.oI0IIXIo(string)) {
                                        i3 = 1;
                                        arrayList.add(teraBoxListItem);
                                        i4 += i3;
                                        jSONArray = jSONArray2;
                                        str2 = str3;
                                    }
                                }
                                i3 = 1;
                                if (i5 != 1) {
                                    i4 += i3;
                                    jSONArray = jSONArray2;
                                    str2 = str3;
                                }
                                arrayList.add(teraBoxListItem);
                                i4 += i3;
                                jSONArray = jSONArray2;
                                str2 = str3;
                            }
                            if (arrayList.size() > 0 && arrayList.size() > 1) {
                                o00.OO0x0xX(arrayList, new oIX0oI());
                            }
                            if (oooxoxo2 != null) {
                                oooxoxo2.invoke(arrayList);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<List<TeraBoxListItem>, oXIO0o0XI> oooxoxo3 = oooxoxo;
                        if (oooxoxo3 != null) {
                            oooxoxo3.invoke(null);
                        }
                    }
                }
            }
        });
    }

    public final void oOoXoXO(final Oox.oOoXoXO<? super Pair<UploadOSSWorker.StsRamData, Integer>, oXIO0o0XI> oooxoxo) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        final xxxI.II0xO0<UploadOSSWorker.StsRamData> iI0xO0 = new xxxI.II0xO0<UploadOSSWorker.StsRamData>() { // from class: com.sma.smartv3.biz.MusicServerManager$getNetWorkUtilsSts$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                oooxoxo.invoke(new Pair<>(null, 2));
                ToastUtils.showLong(R.string.request_error);
                OI0.oIX0oI.f1507oIX0oI.II0xO0("TeraBoxManager getStsError : " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO UploadOSSWorker.StsRamData stsRamData) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("TeraBoxManager handleResponse : " + stsRamData);
                MusicServerManager.f20080oIX0oI.II0xO0(stsRamData);
                Xo0.f24349oIX0oI.I0Io().put(UploadOSSWorker.f25800oIX0oI.oO() + '_' + UploadOSSWorker.StsRamData.class.getName(), new Gson().toJson(stsRamData));
                oooxoxo.invoke(new Pair<>(stsRamData, 1));
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), "/ali/getStsRam");
        netWorkUtils.printParam(convertBaseUrl + "/ali/getStsRam", hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + "/ali/getStsRam";
        final xxxI.II0xO0<Response<UploadOSSWorker.StsRamData>> iI0xO02 = new xxxI.II0xO0<Response<UploadOSSWorker.StsRamData>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getNetWorkUtilsSts$$inlined$get$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<UploadOSSWorker.StsRamData> response) {
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
        AndroidNetworking.get(str).addQueryParameter((Map<String, String>) hashMap).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, UploadOSSWorker.StsRamData.class), new ParsedRequestListener<Response<UploadOSSWorker.StsRamData>>() { // from class: com.sma.smartv3.biz.MusicServerManager$getNetWorkUtilsSts$$inlined$get$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<UploadOSSWorker.StsRamData> response) {
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

    public final void ooOOo0oXI(@OXOo.OOXIXo String access_tokens, @OXOo.OOXIXo String key, @OXOo.oOoXoXO final Oox.oOoXoXO<? super List<TeraBoxListItem>, oXIO0o0XI> oooxoxo) {
        String str;
        IIX0o.x0xO0oo(access_tokens, "access_tokens");
        IIX0o.x0xO0oo(key, "key");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            str = "https://www.terabox.com/openapi/api/search?access_tokens=" + access_tokens + "&key=" + key;
        } else {
            str = "http://pan.baidu.com/rest/2.0/xpan/file?access_token=" + access_tokens + "&key=" + key + "&method=search&recursion=1";
        }
        LogUtils.d("getMusicSearch url -> " + str);
        AndroidNetworking.get(str).setPriority(Priority.LOW).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.MusicServerManager$getTeraBoxFileSearch$1

            @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 MusicServerManager.kt\ncom/sma/smartv3/biz/MusicServerManager$getTeraBoxFileSearch$1\n*L\n1#1,328:1\n281#2:329\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class oIX0oI<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    boolean z;
                    boolean z2 = false;
                    if (((TeraBoxListItem) t).getIsdir() < 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    if (((TeraBoxListItem) t2).getIsdir() < 1) {
                        z2 = true;
                    }
                    return xX0ox.Oxx0IOOO.oOoXoXO(valueOf, Boolean.valueOf(z2));
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                String str2;
                String str3;
                StringBuilder sb = new StringBuilder();
                sb.append("getMusicSearch onError -> error = ");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                LogUtils.d(sb.toString());
                if (aNError != null) {
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                ToastUtils.showLong(str3, new Object[0]);
                Oox.oOoXoXO<List<TeraBoxListItem>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                int i;
                String str2 = "server_filename";
                LogUtils.d("getMusicSearch onResponse -> " + jSONObject);
                if (jSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("list");
                        if (jSONArray != null) {
                            Oox.oOoXoXO<List<TeraBoxListItem>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                            ArrayList arrayList = new ArrayList();
                            int length = jSONArray.length();
                            int i2 = 0;
                            while (i2 < length) {
                                int i3 = jSONArray.getJSONObject(i2).getInt("isdir");
                                String string = jSONArray.getJSONObject(i2).getString(str2);
                                long j = jSONArray.getJSONObject(i2).getLong("fs_id");
                                String string2 = jSONArray.getJSONObject(i2).getString("category");
                                IIX0o.oO(string2, "getString(...)");
                                long j2 = jSONArray.getJSONObject(i2).getLong("local_mtime");
                                long j3 = jSONArray.getJSONObject(i2).getLong("server_ctime");
                                String string3 = jSONArray.getJSONObject(i2).getString(str2);
                                IIX0o.oO(string3, "getString(...)");
                                String str3 = str2;
                                int i4 = jSONArray.getJSONObject(i2).getInt(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE);
                                int i5 = jSONArray.getJSONObject(i2).getInt("isdir");
                                String string4 = jSONArray.getJSONObject(i2).getString("path");
                                IIX0o.oO(string4, "getString(...)");
                                JSONArray jSONArray2 = jSONArray;
                                TeraBoxListItem teraBoxListItem = new TeraBoxListItem(j, string2, j2, j3, string3, i4, i5, string4);
                                LogUtils.d("getMusicSearch terabox list item teraBox = " + teraBoxListItem + TokenParser.SP);
                                if (i3 == 0) {
                                    MusicServerManager musicServerManager = MusicServerManager.f20080oIX0oI;
                                    IIX0o.ooOOo0oXI(string);
                                    if (musicServerManager.oI0IIXIo(string)) {
                                        i = 1;
                                        arrayList.add(teraBoxListItem);
                                        i2 += i;
                                        jSONArray = jSONArray2;
                                        str2 = str3;
                                    }
                                }
                                i = 1;
                                if (i3 != 1) {
                                    i2 += i;
                                    jSONArray = jSONArray2;
                                    str2 = str3;
                                }
                                arrayList.add(teraBoxListItem);
                                i2 += i;
                                jSONArray = jSONArray2;
                                str2 = str3;
                            }
                            if (arrayList.size() > 0 && arrayList.size() > 1) {
                                o00.OO0x0xX(arrayList, new oIX0oI());
                            }
                            if (oooxoxo2 != null) {
                                oooxoxo2.invoke(arrayList);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<List<TeraBoxListItem>, oXIO0o0XI> oooxoxo3 = oooxoxo;
                        if (oooxoxo3 != null) {
                            oooxoxo3.invoke(null);
                        }
                    }
                }
            }
        });
    }

    public final void oxoX(@OXOo.OOXIXo String url, @OXOo.OOXIXo String access_tokens, @OXOo.OOXIXo String fileName, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(access_tokens, "access_tokens");
        IIX0o.x0xO0oo(fileName, "fileName");
        LogUtils.d("terabox list item downLoaLink = " + fileName + TokenParser.SP);
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            f20078X0o0xo = url + "&access_tokens=" + access_tokens;
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            String str = url + "&access_tokens=" + access_tokens;
            String absolutePath = IXxxXO.xII(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath();
            IIX0o.oO(absolutePath, "getAbsolutePath(...)");
            netWorkUtils.download(str, absolutePath, fileName, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.biz.MusicServerManager$downLoadLink$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(-1);
                    }
                }

                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                public void handleProgress(int i) {
                    Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Integer.valueOf(i));
                    }
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str2) {
                    Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(200);
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "pan.baidu.com");
        f20078X0o0xo = url + "&access_token=" + access_tokens;
        String absolutePath2 = IXxxXO.xII(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath();
        IIX0o.oO(absolutePath2, "getAbsolutePath(...)");
        NetWorkUtils.INSTANCE.downloadV2(url + "&access_token=" + access_tokens, hashMap, absolutePath2, fileName, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.biz.MusicServerManager$downLoadLink$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(-1);
                }
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
                Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Integer.valueOf(i));
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str2) {
                Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(200);
                }
            }
        });
    }

    public final void xoXoI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        f20078X0o0xo = str;
    }

    public final void xxIXOIIO(@OXOo.OOXIXo String access_tokens, @OXOo.OOXIXo List<Long> fidlist, @OXOo.oOoXoXO final Oox.oOoXoXO<? super List<TeraBoxItemDLink>, oXIO0o0XI> oooxoxo) {
        String str;
        IIX0o.x0xO0oo(access_tokens, "access_tokens");
        IIX0o.x0xO0oo(fidlist, "fidlist");
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            str = "https://www.terabox.com/openapi/api/download?access_tokens=" + access_tokens + "&fidlist=" + fidlist + "&type=dlink";
        } else {
            str = "http://pan.baidu.com/rest/2.0/xpan/multimedia?method=filemetas&access_token=" + access_tokens + "&fsids=" + fidlist + "&dlink=1";
        }
        AndroidNetworking.get(str).setPriority(Priority.LOW).build().getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.MusicServerManager$getMusicDownLoaLink$1
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                String str2;
                String str3;
                StringBuilder sb = new StringBuilder();
                sb.append("getMusicDownLoaLink onError -> error = ");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                LogUtils.d(sb.toString());
                if (aNError != null) {
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                ToastUtils.showLong(str3, new Object[0]);
                Oox.oOoXoXO<List<TeraBoxItemDLink>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                String str2;
                JSONArray jSONArray;
                LogUtils.d("getMusicDownLoaLink onResponse -> " + jSONObject);
                try {
                    if (ProjectManager.f19822oIX0oI.xxxI()) {
                        str2 = "dlink";
                    } else {
                        str2 = "list";
                    }
                    if (jSONObject != null && (jSONArray = jSONObject.getJSONArray(str2)) != null) {
                        Oox.oOoXoXO<List<TeraBoxItemDLink>, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        ArrayList arrayList = new ArrayList();
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            long j = jSONArray.getJSONObject(i).getLong("fs_id");
                            String string = jSONArray.getJSONObject(i).getString("dlink");
                            IIX0o.oO(string, "getString(...)");
                            arrayList.add(new TeraBoxItemDLink(j, string));
                        }
                        LogUtils.d("terabox list item teraBox = " + arrayList.size() + TokenParser.SP);
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(arrayList);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<List<TeraBoxItemDLink>, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(null);
                    }
                }
            }
        });
    }
}
