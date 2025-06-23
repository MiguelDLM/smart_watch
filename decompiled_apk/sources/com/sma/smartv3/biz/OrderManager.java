package com.sma.smartv3.biz;

import android.app.Activity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AccountCreateOrder;
import com.sma.smartv3.model.AccountIntegralData;
import com.sma.smartv3.model.AccountOrderData;
import com.sma.smartv3.model.AccountPoints;
import com.sma.smartv3.model.DeductionConfig;
import com.sma.smartv3.model.OrderContentData;
import com.sma.smartv3.model.UserAloneGameDetail;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.network.AccountIntegralDetails;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.CreateOrder;
import com.sma.smartv3.network.DeleteAccountOrderList;
import com.sma.smartv3.network.GetAccountOrderList;
import com.sma.smartv3.network.GetFreeMember;
import com.sma.smartv3.network.GetFreePoints;
import com.sma.smartv3.network.GetGameDetail;
import com.sma.smartv3.network.GetOrderStatus;
import com.sma.smartv3.network.GetUserMember;
import com.sma.smartv3.network.GetUserPoints;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.component.BleCache;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nOrderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OrderManager.kt\ncom/sma/smartv3/biz/OrderManager\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,508:1\n173#2,12:509\n194#2:530\n173#2,12:531\n194#2:552\n173#2,12:553\n194#2:574\n173#2,12:575\n194#2:596\n173#2,12:597\n194#2:618\n173#2,12:619\n194#2:640\n173#2,12:641\n194#2:662\n173#2,12:663\n194#2:684\n173#2,12:685\n194#2:706\n173#2,12:707\n194#2:728\n173#2,12:729\n194#2:750\n234#3,8:521\n254#3:529\n234#3,8:543\n254#3:551\n234#3,8:565\n254#3:573\n234#3,8:587\n254#3:595\n234#3,8:609\n254#3:617\n234#3,8:631\n254#3:639\n234#3,8:653\n254#3:661\n234#3,8:675\n254#3:683\n234#3,8:697\n254#3:705\n234#3,8:719\n254#3:727\n234#3,8:741\n254#3:749\n*S KotlinDebug\n*F\n+ 1 OrderManager.kt\ncom/sma/smartv3/biz/OrderManager\n*L\n110#1:509,12\n110#1:530\n138#1:531,12\n138#1:552\n173#1:553,12\n173#1:574\n200#1:575,12\n200#1:596\n229#1:597,12\n229#1:618\n261#1:619,12\n261#1:640\n291#1:641,12\n291#1:662\n320#1:663,12\n320#1:684\n353#1:685,12\n353#1:706\n378#1:707,12\n378#1:728\n465#1:729,12\n465#1:750\n110#1:521,8\n110#1:529\n138#1:543,8\n138#1:551\n173#1:565,8\n173#1:573\n200#1:587,8\n200#1:595\n229#1:609,8\n229#1:617\n261#1:631,8\n261#1:639\n291#1:653,8\n291#1:661\n320#1:675,8\n320#1:683\n353#1:697,8\n353#1:705\n378#1:719,8\n378#1:727\n465#1:741,8\n465#1:749\n*E\n"})
/* loaded from: classes12.dex */
public final class OrderManager {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static boolean f20125II0XooXoX = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20126II0xO0 = "OrderManager";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static boolean f20127Oxx0IOOO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static DeductionConfig f20132xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OrderManager f20130oIX0oI = new OrderManager();

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20124I0Io = "Member";

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20131oxoX = "GameMember";

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20128X0o0xo = "Game";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20129XO = "WatchFace";

    public static /* synthetic */ void II0xO0(OrderManager orderManager, String str, String str2, Activity activity, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            activity = null;
        }
        orderManager.oIX0oI(str, str2, activity, oooxoxo);
    }

    public static /* synthetic */ String IIX0o(OrderManager orderManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderManager.xoXoI();
        }
        if ((i & 2) != 0) {
            str2 = f20124I0Io;
        }
        return orderManager.xXxxox0I(str, str2);
    }

    public static /* synthetic */ String IIXOooo(OrderManager orderManager, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "2";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        return orderManager.OxxIIOOXO(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void OOXIXo(OrderManager orderManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        orderManager.xoIox(oooxoxo);
    }

    public static /* synthetic */ String Oo(OrderManager orderManager, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = orderManager.oI0IIXIo();
        }
        return orderManager.x0xO0oo(str, str2, str3);
    }

    public static /* synthetic */ boolean Oxx0IOOO(OrderManager orderManager, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        return orderManager.XO(j, i);
    }

    public static /* synthetic */ boolean X0o0xo(OrderManager orderManager, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        return orderManager.oxoX(j, i);
    }

    public final void I0Io(@OXOo.OOXIXo String orderId, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(orderId, "orderId");
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> deleteAccountOrderBody = RequestBodyKt.deleteAccountOrderBody(ooXIXxIX2, orderId);
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.OrderManager$deleteOrderList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager deleteOrderList handleError -> " + error);
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager deleteOrderList handleResponse -> " + str);
                callback.invoke(Boolean.TRUE);
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), DeleteAccountOrderList.URL);
        netWorkUtils.printParam(convertBaseUrl + DeleteAccountOrderList.URL, o0.xoIxX(deleteAccountOrderBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + DeleteAccountOrderList.URL;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.biz.OrderManager$deleteOrderList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) deleteAccountOrderBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.biz.OrderManager$deleteOrderList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
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

    public final void II0XooXoX(final int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super AccountIntegralData, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getAccountIntegralDetails -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> accountDetails = RequestBodyKt.getAccountDetails(ooXIXxIX2, i);
        final xxxI.II0xO0<AccountIntegralData> iI0xO0 = new xxxI.II0xO0<AccountIntegralData>() { // from class: com.sma.smartv3.biz.OrderManager$getAccountIntegralDetails$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                callback.invoke(null);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getAccountIntegralDetails handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AccountIntegralData accountIntegralData) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getAccountIntegralDetails handleResponse -> " + accountIntegralData);
                if (accountIntegralData == null) {
                    callback.invoke(null);
                    return;
                }
                if (i == 1) {
                    Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24366IXO + '_' + AccountIntegralData.class.getName(), new Gson().toJson(accountIntegralData));
                }
                callback.invoke(accountIntegralData);
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AccountIntegralDetails.URL);
        netWorkUtils.printParam(convertBaseUrl + AccountIntegralDetails.URL, o0.xoIxX(accountDetails, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AccountIntegralDetails.URL;
        final xxxI.II0xO0<Response<AccountIntegralData>> iI0xO02 = new xxxI.II0xO0<Response<AccountIntegralData>>() { // from class: com.sma.smartv3.biz.OrderManager$getAccountIntegralDetails$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AccountIntegralData> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) accountDetails).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AccountIntegralData.class), new ParsedRequestListener<Response<AccountIntegralData>>() { // from class: com.sma.smartv3.biz.OrderManager$getAccountIntegralDetails$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AccountIntegralData> response) {
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

    public final void IXxxXO(@OXOo.OOXIXo String orderNum, @OXOo.OOXIXo String orderType, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getOrderStatus -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> orderStatusBody = RequestBodyKt.getOrderStatusBody(ooXIXxIX2, orderNum, orderType);
        final xxxI.II0xO0<OrderContentData> iI0xO0 = new xxxI.II0xO0<OrderContentData>() { // from class: com.sma.smartv3.biz.OrderManager$getOrderStatus$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getOrderStatus handleError -> " + error);
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO OrderContentData orderContentData) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getOrderStatus handleResponse -> " + orderContentData);
                if (orderContentData != null && IIX0o.Oxx0IOOO(orderContentData.getPayStatus(), "Payed")) {
                    callback.invoke(Boolean.TRUE);
                } else {
                    callback.invoke(Boolean.FALSE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetOrderStatus.URL);
        netWorkUtils.printParam(convertBaseUrl + GetOrderStatus.URL, o0.xoIxX(orderStatusBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetOrderStatus.URL;
        final xxxI.II0xO0<Response<OrderContentData>> iI0xO02 = new xxxI.II0xO0<Response<OrderContentData>>() { // from class: com.sma.smartv3.biz.OrderManager$getOrderStatus$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<OrderContentData> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) orderStatusBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, OrderContentData.class), new ParsedRequestListener<Response<OrderContentData>>() { // from class: com.sma.smartv3.biz.OrderManager$getOrderStatus$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<OrderContentData> response) {
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

    @OXOo.OOXIXo
    public final String O0xOxO() {
        return f20128X0o0xo;
    }

    public final String OxI() {
        return OxI.IIOIX(Api.INSTANCE.getBASE_URL(), "kotlinweb", "", false, 4, null);
    }

    @OXOo.OOXIXo
    public final String Oxx0xo(@OXOo.OOXIXo String orderNum, @OXOo.OOXIXo String payType) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(payType, "payType");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getPayInfoUrl -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return "";
        }
        return Api.INSTANCE.getBASE_URL() + "//aliPay/wapPay?payType=" + payType + "&orderNum=" + orderNum;
    }

    @OXOo.OOXIXo
    public final String OxxIIOOXO(@OXOo.OOXIXo String result, @OXOo.OOXIXo String orderType) {
        IIX0o.x0xO0oo(result, "result");
        IIX0o.x0xO0oo(orderType, "orderType");
        return StringsKt__StringsKt.oIoIXxIO(IIX0o(this, null, orderType, 1, null) + "&result=" + result).toString();
    }

    @OXOo.OOXIXo
    public final String X0IIOO() {
        return f20131oxoX;
    }

    @OXOo.OOXIXo
    public final String XI0IXoo() {
        return f20124I0Io;
    }

    @OXOo.OOXIXo
    public final String XIxXXX0x0() {
        return f20129XO;
    }

    public final boolean XO(long j, int i) {
        if (j == 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis >= 0 && currentTimeMillis > i * 86400000) {
            return true;
        }
        return false;
    }

    public final void XxX0x0xxx() {
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getUserPoints -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> userPointsMemberBody = RequestBodyKt.getUserPointsMemberBody(ooXIXxIX2);
        final xxxI.II0xO0<AccountPoints> iI0xO0 = new xxxI.II0xO0<AccountPoints>() { // from class: com.sma.smartv3.biz.OrderManager$getUserPoints$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getUserPoints handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AccountPoints accountPoints) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getUserPoints handleResponse -> " + accountPoints);
                if (accountPoints != null) {
                    Xo0.f24349oIX0oI.XO().put(x0xO0oo.f24568IIX0 + '_' + AccountPoints.class.getName(), new Gson().toJson(accountPoints));
                    x0xO0oo.II0xO0(x0xO0oo.f24568IIX0, null, 2, null);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetUserPoints.URL);
        netWorkUtils.printParam(convertBaseUrl + GetUserPoints.URL, o0.xoIxX(userPointsMemberBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetUserPoints.URL;
        final xxxI.II0xO0<Response<AccountPoints>> iI0xO02 = new xxxI.II0xO0<Response<AccountPoints>>() { // from class: com.sma.smartv3.biz.OrderManager$getUserPoints$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AccountPoints> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) userPointsMemberBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AccountPoints.class), new ParsedRequestListener<Response<AccountPoints>>() { // from class: com.sma.smartv3.biz.OrderManager$getUserPoints$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AccountPoints> response) {
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

    public final boolean o00() {
        return f20125II0XooXoX;
    }

    @OXOo.OOXIXo
    public final String oI0IIXIo() {
        if (ProjectManager.f19822oIX0oI.x0o()) {
            return "orderDetail/#/pointsDetail";
        }
        return "orderDetail/#/orderDetail";
    }

    public final void oIX0oI(@OXOo.OOXIXo String orderType, @OXOo.OOXIXo String eleId, @OXOo.oOoXoXO final Activity activity, @OXOo.OOXIXo final Oox.oOoXoXO<? super AccountCreateOrder, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(eleId, "eleId");
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager createOrder -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.login_required_tip), new Object[0]);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap createOrder$default = RequestBodyKt.getCreateOrder$default(ooXIXxIX2, orderType, eleId, null, 8, null);
        final xxxI.II0xO0<AccountCreateOrder> iI0xO0 = new xxxI.II0xO0<AccountCreateOrder>() { // from class: com.sma.smartv3.biz.OrderManager$createOrder$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager createOrder handleError -> " + error);
                callback.invoke(null);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AccountCreateOrder accountCreateOrder) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager createOrder handleResponse -> " + accountCreateOrder);
                if (accountCreateOrder != null) {
                    callback.invoke(accountCreateOrder);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), CreateOrder.URL);
        netWorkUtils.printParam(convertBaseUrl + CreateOrder.URL, o0.xoIxX(createOrder$default, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + CreateOrder.URL;
        final xxxI.II0xO0<Response<AccountCreateOrder>> iI0xO02 = new xxxI.II0xO0<Response<AccountCreateOrder>>() { // from class: com.sma.smartv3.biz.OrderManager$createOrder$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AccountCreateOrder> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) createOrder$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AccountCreateOrder.class), new ParsedRequestListener<Response<AccountCreateOrder>>() { // from class: com.sma.smartv3.biz.OrderManager$createOrder$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AccountCreateOrder> response) {
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

    @OXOo.oOoXoXO
    public final DeductionConfig oO() {
        return f20132xxIXOIIO;
    }

    public final void oOoXoXO(@OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getFreeMember -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> userPointsMemberBody = RequestBodyKt.getUserPointsMemberBody(ooXIXxIX2);
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.OrderManager$getFreeMember$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getFreeMember handleError -> " + error);
                callback.invoke(Boolean.FALSE);
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getFreeMember handleResponse -> " + str);
                if (str != null) {
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = callback;
                    Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24375IxIX0I + '_' + String.class.getName(), new Gson().toJson(str));
                    oooxoxo.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetFreeMember.URL);
        netWorkUtils.printParam(convertBaseUrl + GetFreeMember.URL, o0.xoIxX(userPointsMemberBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetFreeMember.URL;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.biz.OrderManager$getFreeMember$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) userPointsMemberBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.biz.OrderManager$getFreeMember$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
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

    public final void oo(boolean z) {
        f20127Oxx0IOOO = z;
    }

    public final void oo0xXOI0I(boolean z) {
        f20125II0XooXoX = z;
    }

    public final void ooOOo0oXI(@OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getFreePoints -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> freePointsBody = RequestBodyKt.getFreePointsBody(ooXIXxIX2);
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.OrderManager$getFreePoints$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getFreePoints handleError -> " + error);
                callback.invoke(Boolean.FALSE);
                ToastUtils.showLong(error, new Object[0]);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getFreePoints handleResponse -> " + str);
                if (str != null) {
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = callback;
                    Xo0.f24349oIX0oI.XO().put(x0xO0oo.f24598Ox0O + '_' + String.class.getName(), new Gson().toJson(str));
                    oooxoxo.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetFreePoints.URL);
        netWorkUtils.printParam(convertBaseUrl + GetFreePoints.URL, o0.xoIxX(freePointsBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetFreePoints.URL;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.biz.OrderManager$getFreePoints$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) freePointsBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.biz.OrderManager$getFreePoints$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
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

    public final boolean ooXIXxIX() {
        return f20127Oxx0IOOO;
    }

    public final boolean oxoX(long j, int i) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if (currentTimeMillis < i * 86400000 && currentTimeMillis > 0) {
            return true;
        }
        return false;
    }

    public final void x0XOIxOo(@OXOo.OOXIXo String gid, @OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(gid, "gid");
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getGameDetail -> " + ooXIXxIX2 + "  ,  gid = " + gid);
        if (ooXIXxIX2.length() == 0) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> userGameDetailBody = RequestBodyKt.getUserGameDetailBody(gid);
        final xxxI.II0xO0<UserAloneGameDetail> iI0xO0 = new xxxI.II0xO0<UserAloneGameDetail>() { // from class: com.sma.smartv3.biz.OrderManager$getGameDetail$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getGameDetail handleError -> " + error);
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO UserAloneGameDetail userAloneGameDetail) {
                String str;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                sb.append("OrderManager getGameDetail handleResponse ");
                if (userAloneGameDetail != null) {
                    str = userAloneGameDetail.getGid();
                } else {
                    str = null;
                }
                sb.append(str);
                oix0oi.oIX0oI(sb.toString());
                Xo0.f24349oIX0oI.XO().put(x0xO0oo.f24597OoO + '_' + UserAloneGameDetail.class.getName(), new Gson().toJson(userAloneGameDetail));
                x0xO0oo.II0xO0(x0xO0oo.f24597OoO, null, 2, null);
                callback.invoke(Boolean.TRUE);
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetGameDetail.URL);
        netWorkUtils.printParam(convertBaseUrl + GetGameDetail.URL, o0.xoIxX(userGameDetailBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetGameDetail.URL;
        final xxxI.II0xO0<Response<UserAloneGameDetail>> iI0xO02 = new xxxI.II0xO0<Response<UserAloneGameDetail>>() { // from class: com.sma.smartv3.biz.OrderManager$getGameDetail$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<UserAloneGameDetail> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) userGameDetailBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, UserAloneGameDetail.class), new ParsedRequestListener<Response<UserAloneGameDetail>>() { // from class: com.sma.smartv3.biz.OrderManager$getGameDetail$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<UserAloneGameDetail> response) {
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

    @OXOo.OOXIXo
    public final String x0xO0oo(@OXOo.OOXIXo String orderNum, @OXOo.OOXIXo String orderType, @OXOo.OOXIXo String payWeb) {
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(payWeb, "payWeb");
        if (ProjectManager.f19822oIX0oI.ooXIXxIX().length() == 0) {
            return "";
        }
        return xXxxox0I(payWeb, orderType) + "&orderNum=" + orderNum;
    }

    public final void xI(@OXOo.oOoXoXO DeductionConfig deductionConfig) {
        f20132xxIXOIIO = deductionConfig;
    }

    @OXOo.OOXIXo
    public final String xXxxox0I(@OXOo.OOXIXo String payUrl, @OXOo.OOXIXo String orderType) {
        IIX0o.x0xO0oo(payUrl, "payUrl");
        IIX0o.x0xO0oo(orderType, "orderType");
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.ooXIXxIX().length() == 0) {
            return "";
        }
        f20127Oxx0IOOO = IIX0o.Oxx0IOOO(payUrl, xoXoI());
        f20125II0XooXoX = true;
        String obj = StringsKt__StringsKt.oIoIXxIO("").toString();
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append("&supCreate=");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sb.append(productManager.Ix0x());
        sb.append("&internalFlag=");
        sb.append(projectManager.oXO0oOx0());
        sb.append("&pid=2");
        String sb2 = sb.toString();
        if (oIxOXo.oxoX.II0XooXoX().OxxIIOOXO()) {
            sb2 = sb2 + StringsKt__StringsKt.oIoIXxIO("&dark=dark").toString();
        }
        if (productManager.Xo()) {
            sb2 = sb2 + StringsKt__StringsKt.oIoIXxIO("&deviceType=ring").toString();
        }
        if (orderType.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(StringsKt__StringsKt.oIoIXxIO("&orderType=" + orderType).toString());
            sb2 = sb3.toString();
        }
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMBleAddress().length() > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(StringsKt__StringsKt.oIoIXxIO("&mac=" + OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null)).toString());
            sb2 = sb4.toString();
        }
        String obj2 = StringsKt__StringsKt.oIoIXxIO(OxI() + payUrl + "?identity=" + projectManager.ooXIXxIX() + sb2).toString();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("OrderManager getVipPayWebUrl -> ");
        sb5.append(obj2);
        oix0oi.oIX0oI(sb5.toString());
        return obj2;
    }

    public final void xoIox(@OXOo.oOoXoXO final Oox.oOoXoXO<? super DeductionConfig, oXIO0o0XI> oooxoxo) {
        DeductionConfig deductionConfig = f20132xxIXOIIO;
        if (deductionConfig != null) {
            if (oooxoxo != null) {
                oooxoxo.invoke(deductionConfig);
                return;
            }
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> appDeductionConfigBody = RequestBodyKt.getAppDeductionConfigBody();
        final xxxI.II0xO0<DeductionConfig> iI0xO0 = new xxxI.II0xO0<DeductionConfig>() { // from class: com.sma.smartv3.biz.OrderManager$getDeductionConfig$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getDeductionConfig -> " + error);
                Oox.oOoXoXO<DeductionConfig, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO DeductionConfig deductionConfig2) {
                LogUtils.d("getDeductionConfig -> " + deductionConfig2);
                try {
                    if (deductionConfig2 != null) {
                        OrderManager.f20130oIX0oI.xI(deductionConfig2);
                        Oox.oOoXoXO<DeductionConfig, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(deductionConfig2);
                        }
                    } else {
                        Oox.oOoXoXO<DeductionConfig, oXIO0o0XI> oooxoxo3 = oooxoxo;
                        if (oooxoxo3 != null) {
                            oooxoxo3.invoke(null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<DeductionConfig, oXIO0o0XI> oooxoxo4 = oooxoxo;
                    if (oooxoxo4 != null) {
                        oooxoxo4.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), "/appConfigInfo/getAppConfigById");
        netWorkUtils.printParam(convertBaseUrl + "/appConfigInfo/getAppConfigById", o0.xoIxX(appDeductionConfigBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + "/appConfigInfo/getAppConfigById";
        final xxxI.II0xO0<Response<DeductionConfig>> iI0xO02 = new xxxI.II0xO0<Response<DeductionConfig>>() { // from class: com.sma.smartv3.biz.OrderManager$getDeductionConfig$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<DeductionConfig> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) appDeductionConfigBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DeductionConfig.class), new ParsedRequestListener<Response<DeductionConfig>>() { // from class: com.sma.smartv3.biz.OrderManager$getDeductionConfig$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<DeductionConfig> response) {
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

    @OXOo.OOXIXo
    public final String xoXoI() {
        if (ProjectManager.f19822oIX0oI.x0o()) {
            return "orderDetail/#/selectPoints";
        }
        return "orderDetail/#/selectOrder";
    }

    public final void xxIXOIIO(@OXOo.OOXIXo final String orderType, final int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super AccountOrderData, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getAccountOrderList -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> accountOrderSelectList = RequestBodyKt.getAccountOrderSelectList(ooXIXxIX2, orderType, i);
        final xxxI.II0xO0<AccountOrderData> iI0xO0 = new xxxI.II0xO0<AccountOrderData>() { // from class: com.sma.smartv3.biz.OrderManager$getAccountOrderList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getAccountOrderList handleError -> " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AccountOrderData accountOrderData) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getAccountOrderList handleResponse -> " + accountOrderData);
                if (accountOrderData != null) {
                    int i2 = i;
                    String str = orderType;
                    Oox.oOoXoXO<AccountOrderData, oXIO0o0XI> oooxoxo = callback;
                    if (i2 == 1) {
                        Xo0.f24349oIX0oI.XO().put((XoI0Ixx0.f24440oI + str) + '_' + AccountOrderData.class.getName(), new Gson().toJson(accountOrderData));
                    }
                    oooxoxo.invoke(accountOrderData);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetAccountOrderList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetAccountOrderList.URL, o0.xoIxX(accountOrderSelectList, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetAccountOrderList.URL;
        final xxxI.II0xO0<Response<AccountOrderData>> iI0xO02 = new xxxI.II0xO0<Response<AccountOrderData>>() { // from class: com.sma.smartv3.biz.OrderManager$getAccountOrderList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AccountOrderData> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) accountOrderSelectList).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AccountOrderData.class), new ParsedRequestListener<Response<AccountOrderData>>() { // from class: com.sma.smartv3.biz.OrderManager$getAccountOrderList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AccountOrderData> response) {
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

    public final void xxX(@OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        String ooXIXxIX2 = ProjectManager.f19822oIX0oI.ooXIXxIX();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getUserMember -> " + ooXIXxIX2);
        if (ooXIXxIX2.length() == 0) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> userPointsMemberBody = RequestBodyKt.getUserPointsMemberBody(ooXIXxIX2);
        final xxxI.II0xO0<UserMember> iI0xO0 = new xxxI.II0xO0<UserMember>() { // from class: com.sma.smartv3.biz.OrderManager$getUserMember$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getUserMember handleError -> " + error);
                callback.invoke(Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO UserMember userMember) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("OrderManager getUserMember handleResponse -> " + userMember);
                ProjectManager projectManager = ProjectManager.f19822oIX0oI;
                boolean IxIo2 = projectManager.IxIo();
                if (userMember != null) {
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = callback;
                    Xo0.f24349oIX0oI.XO().put(x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName(), new Gson().toJson(userMember));
                    x0xO0oo.II0xO0(x0xO0oo.f24656xOoOIoI, null, 2, null);
                    if (IxIo2 != projectManager.IxIo()) {
                        x0xO0oo.II0xO0(x0xO0oo.f24576IoIOOxIIo, null, 2, null);
                    }
                    oooxoxo.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetUserMember.URL);
        netWorkUtils.printParam(convertBaseUrl + GetUserMember.URL, o0.xoIxX(userPointsMemberBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetUserMember.URL;
        final xxxI.II0xO0<Response<UserMember>> iI0xO02 = new xxxI.II0xO0<Response<UserMember>>() { // from class: com.sma.smartv3.biz.OrderManager$getUserMember$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<UserMember> response) {
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
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) userPointsMemberBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, UserMember.class), new ParsedRequestListener<Response<UserMember>>() { // from class: com.sma.smartv3.biz.OrderManager$getUserMember$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<UserMember> response) {
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
