package com.sma.smartv3.biz;

import android.app.Activity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.model.OnlineWatchFaceV2;
import com.sma.smartv3.model.WatchFaceBanner;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.model.WatchFaceDetail;
import com.sma.smartv3.model.WatchFaceInstallRecord;
import com.sma.smartv3.network.AddUserWatchDownloadRecord;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetOnLinWatchFaceList;
import com.sma.smartv3.network.GetPurchaseHistoryList;
import com.sma.smartv3.network.GetUserWatchDownloadRecord;
import com.sma.smartv3.network.GetWatchFaceBanner;
import com.sma.smartv3.network.GetWatchFaceDetail;
import com.sma.smartv3.network.GetWatchFaceDetailList;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWatchFaceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WatchFaceManager.kt\ncom/sma/smartv3/biz/WatchFaceManager\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,260:1\n173#2,12:261\n194#2:282\n173#2,12:283\n194#2:304\n173#2,12:305\n194#2:326\n173#2,12:327\n194#2:348\n173#2,12:349\n194#2:370\n173#2,12:371\n194#2:392\n173#2,12:393\n194#2:414\n234#3,8:273\n254#3:281\n234#3,8:295\n254#3:303\n234#3,8:317\n254#3:325\n234#3,8:339\n254#3:347\n234#3,8:361\n254#3:369\n234#3,8:383\n254#3:391\n234#3,8:405\n254#3:413\n*S KotlinDebug\n*F\n+ 1 WatchFaceManager.kt\ncom/sma/smartv3/biz/WatchFaceManager\n*L\n43#1:261,12\n43#1:282\n80#1:283,12\n80#1:304\n115#1:305,12\n115#1:326\n146#1:327,12\n146#1:348\n177#1:349,12\n177#1:370\n210#1:371,12\n210#1:392\n233#1:393,12\n233#1:414\n43#1:273,8\n43#1:281\n80#1:295,8\n80#1:303\n115#1:317,8\n115#1:325\n146#1:339,8\n146#1:347\n177#1:361,8\n177#1:369\n210#1:383,8\n210#1:391\n233#1:405,8\n233#1:413\n*E\n"})
/* loaded from: classes12.dex */
public final class WatchFaceManager {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20244II0xO0 = "WatchFaceManager";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final WatchFaceManager f20245oIX0oI = new WatchFaceManager();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void I0Io(WatchFaceManager watchFaceManager, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        watchFaceManager.II0xO0(z, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void OOXIXo(WatchFaceManager watchFaceManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        watchFaceManager.xoIox(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Oxx0IOOO(WatchFaceManager watchFaceManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        watchFaceManager.XO(oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void X0o0xo(WatchFaceManager watchFaceManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        watchFaceManager.oxoX(oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ooOOo0oXI(WatchFaceManager watchFaceManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        watchFaceManager.oOoXoXO(oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void xxIXOIIO(WatchFaceManager watchFaceManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        watchFaceManager.II0XooXoX(str, oooxoxo);
    }

    public final void II0XooXoX(@OXOo.OOXIXo String watchFaceId, @OXOo.oOoXoXO final Oox.oOoXoXO<? super WatchFaceDetail, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getWatchFaceDetail -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> watchFaceDetails = RequestBodyKt.getWatchFaceDetails(ooXIXxIX2, watchFaceId);
        final xxxI.II0xO0<WatchFaceDetail> iI0xO0 = new xxxI.II0xO0<WatchFaceDetail>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceDetail$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getWatchFaceDetail -> " + error);
                Oox.oOoXoXO<WatchFaceDetail, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO WatchFaceDetail watchFaceDetail) {
                LogUtils.d("getWatchFaceDetail -> " + watchFaceDetail);
                try {
                    if (watchFaceDetail != null) {
                        Oox.oOoXoXO<WatchFaceDetail, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(watchFaceDetail);
                        }
                    } else {
                        Oox.oOoXoXO<WatchFaceDetail, oXIO0o0XI> oooxoxo3 = oooxoxo;
                        if (oooxoxo3 != null) {
                            oooxoxo3.invoke(null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<WatchFaceDetail, oXIO0o0XI> oooxoxo4 = oooxoxo;
                    if (oooxoxo4 != null) {
                        oooxoxo4.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetWatchFaceDetail.URL);
        netWorkUtils.printParam(convertBaseUrl + GetWatchFaceDetail.URL, o0.xoIxX(watchFaceDetails, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetWatchFaceDetail.URL;
        final xxxI.II0xO0<Response<WatchFaceDetail>> iI0xO02 = new xxxI.II0xO0<Response<WatchFaceDetail>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceDetail$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WatchFaceDetail> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) watchFaceDetails).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WatchFaceDetail.class), new ParsedRequestListener<Response<WatchFaceDetail>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceDetail$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WatchFaceDetail> response) {
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

    public final void II0xO0(boolean z, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final Activity activity = null;
        HashMap onLinWatchFace$default = RequestBodyKt.getOnLinWatchFace$default(null, z, 1, null);
        final xxxI.II0xO0<OnlineWatchFaceV2[]> iI0xO0 = new xxxI.II0xO0<OnlineWatchFaceV2[]>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getOnLineWatchFaceList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getOnLinWatchFaceList -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO OnlineWatchFaceV2[] onlineWatchFaceV2Arr) {
                Integer num;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                sb.append("getOnLinWatchFaceList -> ");
                if (onlineWatchFaceV2Arr != null) {
                    num = Integer.valueOf(onlineWatchFaceV2Arr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                oix0oi.oIX0oI(sb.toString());
                try {
                    if (onlineWatchFaceV2Arr != null) {
                        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24362IIxOXoOo0, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(onlineWatchFaceV2Arr)));
                    } else {
                        Xo0.f24349oIX0oI.XO().remove(XoI0Ixx0.f24362IIxOXoOo0);
                        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.FALSE);
                        }
                    }
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.TRUE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo4 = oooxoxo;
                    if (oooxoxo4 != null) {
                        oooxoxo4.invoke(Boolean.FALSE);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetOnLinWatchFaceList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetOnLinWatchFaceList.URL, o0.xoIxX(onLinWatchFace$default, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetOnLinWatchFaceList.URL;
        final xxxI.II0xO0<Response<OnlineWatchFaceV2[]>> iI0xO02 = new xxxI.II0xO0<Response<OnlineWatchFaceV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getOnLineWatchFaceList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<OnlineWatchFaceV2[]> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) onLinWatchFace$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, OnlineWatchFaceV2[].class), new ParsedRequestListener<Response<OnlineWatchFaceV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getOnLineWatchFaceList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<OnlineWatchFaceV2[]> response) {
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

    public final void XO(@OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> watchFaceBannerBody = RequestBodyKt.getWatchFaceBannerBody();
        final xxxI.II0xO0<List<? extends WatchFaceBanner>> iI0xO0 = new xxxI.II0xO0<List<? extends WatchFaceBanner>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceBanner$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getWatchFaceBanner -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO List<WatchFaceBanner> list) {
                LogUtils.d("getWatchFaceBanner -> " + list);
                try {
                    if (list != null) {
                        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24424XX0, new Gson().toJson(CollectionsKt___CollectionsKt.o0Xo0XII(list)));
                        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.TRUE);
                        }
                    } else {
                        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                        if (oooxoxo3 != null) {
                            oooxoxo3.invoke(Boolean.FALSE);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo4 = oooxoxo;
                    if (oooxoxo4 != null) {
                        oooxoxo4.invoke(Boolean.FALSE);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetWatchFaceBanner.URL);
        netWorkUtils.printParam(convertBaseUrl + GetWatchFaceBanner.URL, o0.xoIxX(watchFaceBannerBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetWatchFaceBanner.URL;
        final xxxI.II0xO0<Response<List<? extends WatchFaceBanner>>> iI0xO02 = new xxxI.II0xO0<Response<List<? extends WatchFaceBanner>>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceBanner$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<List<? extends WatchFaceBanner>> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) watchFaceBannerBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, List.class), new ParsedRequestListener<Response<List<? extends WatchFaceBanner>>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceBanner$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<List<? extends WatchFaceBanner>> response) {
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

    public final void oIX0oI(@OXOo.OOXIXo String watchFaceId) {
        IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> addUserWatchDownloadRecordBody = RequestBodyKt.getAddUserWatchDownloadRecordBody(ooXIXxIX2, watchFaceId);
        final xxxI.II0xO0<WatchFaceInstallRecord> iI0xO0 = new xxxI.II0xO0<WatchFaceInstallRecord>() { // from class: com.sma.smartv3.biz.WatchFaceManager$addWatchDownloadRecord$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("addWatchDownloadRecord handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO WatchFaceInstallRecord watchFaceInstallRecord) {
                LogUtils.d("addWatchDownloadRecord handleResponse");
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AddUserWatchDownloadRecord.URL);
        netWorkUtils.printParam(convertBaseUrl + AddUserWatchDownloadRecord.URL, o0.xoIxX(addUserWatchDownloadRecordBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AddUserWatchDownloadRecord.URL;
        final xxxI.II0xO0<Response<WatchFaceInstallRecord>> iI0xO02 = new xxxI.II0xO0<Response<WatchFaceInstallRecord>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$addWatchDownloadRecord$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WatchFaceInstallRecord> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) addUserWatchDownloadRecordBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WatchFaceInstallRecord.class), new ParsedRequestListener<Response<WatchFaceInstallRecord>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$addWatchDownloadRecord$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WatchFaceInstallRecord> response) {
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

    public final void oOoXoXO(@OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final Activity activity = null;
        HashMap purchaseHistoryWatchFace$default = RequestBodyKt.getPurchaseHistoryWatchFace$default(null, 1, null);
        final xxxI.II0xO0<WatchFaceCategoryV2[]> iI0xO0 = new xxxI.II0xO0<WatchFaceCategoryV2[]>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFacePayedSearchList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getWatchFacePayedSearchList -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
                Integer num;
                StringBuilder sb = new StringBuilder();
                sb.append("getWatchFacePayedSearchList -> ");
                if (watchFaceCategoryV2Arr != null) {
                    num = Integer.valueOf(watchFaceCategoryV2Arr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                LogUtils.d(sb.toString());
                if (watchFaceCategoryV2Arr != null) {
                    try {
                        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24351I0, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(watchFaceCategoryV2Arr)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                }
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetPurchaseHistoryList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetPurchaseHistoryList.URL, o0.xoIxX(purchaseHistoryWatchFace$default, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetPurchaseHistoryList.URL;
        final xxxI.II0xO0<Response<WatchFaceCategoryV2[]>> iI0xO02 = new xxxI.II0xO0<Response<WatchFaceCategoryV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFacePayedSearchList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WatchFaceCategoryV2[]> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) purchaseHistoryWatchFace$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WatchFaceCategoryV2[].class), new ParsedRequestListener<Response<WatchFaceCategoryV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFacePayedSearchList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WatchFaceCategoryV2[]> response) {
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

    public final void oxoX(@OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> userPointsMemberBody = RequestBodyKt.getUserPointsMemberBody(ooXIXxIX2);
        final xxxI.II0xO0<WatchFaceCategoryV2[]> iI0xO0 = new xxxI.II0xO0<WatchFaceCategoryV2[]>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getUserWatchFaceInstallRecord$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getUserWatchFaceInstallRecord -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
                Integer num;
                StringBuilder sb = new StringBuilder();
                sb.append("getUserWatchFaceInstallRecord -> ");
                if (watchFaceCategoryV2Arr != null) {
                    num = Integer.valueOf(watchFaceCategoryV2Arr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                LogUtils.d(sb.toString());
                if (watchFaceCategoryV2Arr != null) {
                    try {
                        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24460ooOx, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(watchFaceCategoryV2Arr)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                }
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetUserWatchDownloadRecord.URL);
        netWorkUtils.printParam(convertBaseUrl + GetUserWatchDownloadRecord.URL, o0.xoIxX(userPointsMemberBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetUserWatchDownloadRecord.URL;
        final xxxI.II0xO0<Response<WatchFaceCategoryV2[]>> iI0xO02 = new xxxI.II0xO0<Response<WatchFaceCategoryV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getUserWatchFaceInstallRecord$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WatchFaceCategoryV2[]> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) userPointsMemberBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WatchFaceCategoryV2[].class), new ParsedRequestListener<Response<WatchFaceCategoryV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getUserWatchFaceInstallRecord$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WatchFaceCategoryV2[]> response) {
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

    public final void xoIox(@OXOo.OOXIXo String watchFaceId, @OXOo.oOoXoXO final Oox.oOoXoXO<? super WatchFaceCategoryV2[], oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager createOrder -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> watchFaceDetailsList = RequestBodyKt.getWatchFaceDetailsList(ooXIXxIX2, watchFaceId);
        final xxxI.II0xO0<WatchFaceCategoryV2[]> iI0xO0 = new xxxI.II0xO0<WatchFaceCategoryV2[]>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceDetailList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getWatchFaceDetail -> " + error);
                Oox.oOoXoXO<WatchFaceCategoryV2[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO WatchFaceCategoryV2[] watchFaceCategoryV2Arr) {
                Integer num;
                StringBuilder sb = new StringBuilder();
                sb.append("getWatchFaceDetail -> ");
                if (watchFaceCategoryV2Arr != null) {
                    num = Integer.valueOf(watchFaceCategoryV2Arr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                LogUtils.d(sb.toString());
                try {
                    if (watchFaceCategoryV2Arr != null) {
                        Oox.oOoXoXO<WatchFaceCategoryV2[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(watchFaceCategoryV2Arr);
                        }
                    } else {
                        Oox.oOoXoXO<WatchFaceCategoryV2[], oXIO0o0XI> oooxoxo3 = oooxoxo;
                        if (oooxoxo3 != null) {
                            oooxoxo3.invoke(null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<WatchFaceCategoryV2[], oXIO0o0XI> oooxoxo4 = oooxoxo;
                    if (oooxoxo4 != null) {
                        oooxoxo4.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetWatchFaceDetailList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetWatchFaceDetailList.URL, o0.xoIxX(watchFaceDetailsList, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetWatchFaceDetailList.URL;
        final xxxI.II0xO0<Response<WatchFaceCategoryV2[]>> iI0xO02 = new xxxI.II0xO0<Response<WatchFaceCategoryV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceDetailList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<WatchFaceCategoryV2[]> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) watchFaceDetailsList).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, WatchFaceCategoryV2[].class), new ParsedRequestListener<Response<WatchFaceCategoryV2[]>>() { // from class: com.sma.smartv3.biz.WatchFaceManager$getWatchFaceDetailList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<WatchFaceCategoryV2[]> response) {
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
