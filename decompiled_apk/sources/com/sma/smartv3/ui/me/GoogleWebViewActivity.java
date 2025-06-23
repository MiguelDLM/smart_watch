package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.GooglePayOrderData;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetGooglePayCheckOrder;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.smart.playlib.SmartGooglePlayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@kotlin.jvm.internal.XX({"SMAP\nGoogleWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoogleWebViewActivity.kt\ncom/sma/smartv3/ui/me/GoogleWebViewActivity\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,143:1\n218#2,12:144\n240#2:174\n285#3,18:156\n*S KotlinDebug\n*F\n+ 1 GoogleWebViewActivity.kt\ncom/sma/smartv3/ui/me/GoogleWebViewActivity\n*L\n110#1:144,12\n110#1:174\n110#1:156,18\n*E\n"})
/* loaded from: classes11.dex */
public final class GoogleWebViewActivity extends WebViewActivity {
    private long lastCheckOrderTime;

    @OXOo.oOoXoXO
    private SmartGooglePlayUtil smartGooglePlayUtil;

    @OXOo.OOXIXo
    private String productId = "";

    @OXOo.OOXIXo
    private String orderNum = "";

    @OXOo.OOXIXo
    private String lastCheckOrderNum = "";

    @OXOo.OOXIXo
    private String lastCheckOrderToken = "";

    /* loaded from: classes11.dex */
    public static final class oIX0oI implements SmartGooglePlayUtil.GooglePlayCallBack {
        public oIX0oI() {
        }

        public void onFail(@OXOo.OOXIXo String msg) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
            OI0.oIX0oI.f1507oIX0oI.II0xO0("smartGooglePlayUtil pay fail: " + msg);
            ToastUtils.showLong(R.string.voice_assistant_network_error);
        }

        public void onQueryPurchasesAsync(@OXOo.oOoXoXO String str) {
            com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24410X0xII0I, str);
        }

        public void onSuccess(@OXOo.oOoXoXO String str) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("smartGooglePlayUtil pay onSuccess: " + str);
            if (str == null) {
                return;
            }
            com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24410X0xII0I, str);
            GoogleWebViewActivity.this.googlePayCheckOrder(str);
        }
    }

    @OXOo.OOXIXo
    public final String getLastCheckOrderNum() {
        return this.lastCheckOrderNum;
    }

    public final long getLastCheckOrderTime() {
        return this.lastCheckOrderTime;
    }

    @OXOo.OOXIXo
    public final String getLastCheckOrderToken() {
        return this.lastCheckOrderToken;
    }

    @OXOo.OOXIXo
    public final String getOrderNum() {
        return this.orderNum;
    }

    @OXOo.OOXIXo
    public final String getProductId() {
        return this.productId;
    }

    @OXOo.oOoXoXO
    public final SmartGooglePlayUtil getSmartGooglePlayUtil() {
        return this.smartGooglePlayUtil;
    }

    public final void googlePayCheckOrder(@OXOo.OOXIXo String purchaseToken) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(purchaseToken, "purchaseToken");
        if (this.lastCheckOrderTime != 0 && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.lastCheckOrderToken, purchaseToken) && System.currentTimeMillis() - this.lastCheckOrderTime < 1000) {
            return;
        }
        this.lastCheckOrderTime = System.currentTimeMillis();
        this.lastCheckOrderNum = this.orderNum;
        this.lastCheckOrderToken = purchaseToken;
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String appPackageName = AppUtils.getAppPackageName();
        kotlin.jvm.internal.IIX0o.oO(appPackageName, "getAppPackageName(...)");
        String string = getString(R.string.app_name);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        HashMap<String, String> checkOrderBody = RequestBodyKt.getCheckOrderBody(appPackageName, string, this.productId, purchaseToken, this.orderNum);
        final xxxI.II0xO0<GooglePayOrderData> iI0xO0 = new xxxI.II0xO0<GooglePayOrderData>() { // from class: com.sma.smartv3.ui.me.GoogleWebViewActivity$googlePayCheckOrder$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                boolean Oxx0IOOO2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("smartGooglePlayUtil handleError -> error = " + error + " , orderType = " + GoogleWebViewActivity.this.getOrderType());
                SmartGooglePlayUtil smartGooglePlayUtil = GoogleWebViewActivity.this.getSmartGooglePlayUtil();
                if (smartGooglePlayUtil != null) {
                    smartGooglePlayUtil.handlePurchase();
                }
                com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().remove(com.sma.smartv3.util.XoI0Ixx0.f24410X0xII0I);
                String orderType = GoogleWebViewActivity.this.getOrderType();
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(orderType, "")) {
                    Oxx0IOOO2 = true;
                } else {
                    Oxx0IOOO2 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(orderType, OrderManager.f20130oIX0oI.XI0IXoo());
                }
                if (Oxx0IOOO2) {
                    GoogleWebViewActivity.this.getWebView().loadUrl(OrderManager.IIXOooo(OrderManager.f20130oIX0oI, "2", null, 2, null));
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(orderType, OrderManager.f20130oIX0oI.X0IIOO())) {
                    GoogleWebViewActivity.this.getWebView().loadUrl(com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oO("2"));
                } else {
                    GoogleWebViewActivity.this.payStatusCallBackSuccess();
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO GooglePayOrderData googlePayOrderData) {
                boolean Oxx0IOOO2;
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("smartGooglePlayUtil handleResponse -> " + googlePayOrderData + ", orderType = " + GoogleWebViewActivity.this.getOrderType());
                SmartGooglePlayUtil smartGooglePlayUtil = GoogleWebViewActivity.this.getSmartGooglePlayUtil();
                if (smartGooglePlayUtil != null) {
                    smartGooglePlayUtil.handlePurchase();
                }
                com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().remove(com.sma.smartv3.util.XoI0Ixx0.f24410X0xII0I);
                String orderType = GoogleWebViewActivity.this.getOrderType();
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(orderType, "")) {
                    Oxx0IOOO2 = true;
                } else {
                    Oxx0IOOO2 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(orderType, OrderManager.f20130oIX0oI.XI0IXoo());
                }
                if (Oxx0IOOO2) {
                    GoogleWebViewActivity.this.getWebView().loadUrl(OrderManager.IIXOooo(OrderManager.f20130oIX0oI, "1", null, 2, null));
                } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(orderType, OrderManager.f20130oIX0oI.X0IIOO())) {
                    GoogleWebViewActivity.this.getWebView().loadUrl(com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oO("1"));
                } else {
                    GoogleWebViewActivity.this.payStatusCallBackSuccess();
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetGooglePayCheckOrder.URL);
        netWorkUtils.printParam(convertBaseUrl + GetGooglePayCheckOrder.URL, kotlin.collections.o0.xoIxX(checkOrderBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetGooglePayCheckOrder.URL;
        final xxxI.II0xO0<Response<GooglePayOrderData>> iI0xO02 = new xxxI.II0xO0<Response<GooglePayOrderData>>() { // from class: com.sma.smartv3.ui.me.GoogleWebViewActivity$googlePayCheckOrder$$inlined$postJsonV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<GooglePayOrderData> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
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
        AndroidNetworking.post(str).addHeaders(headersMap).addApplicationJsonBody(checkOrderBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, GooglePayOrderData.class), new ParsedRequestListener<Response<GooglePayOrderData>>() { // from class: com.sma.smartv3.ui.me.GoogleWebViewActivity$googlePayCheckOrder$$inlined$postJsonV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<GooglePayOrderData> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                xxxI.II0xO0.this.handleError(String.valueOf(aNError));
            }
        });
    }

    @Override // com.sma.smartv3.ui.me.WebViewActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        if (ProductManager.f20544oIX0oI.XxI()) {
            this.smartGooglePlayUtil = SmartGooglePlayUtil.Companion.getInstance();
        }
    }

    @JavascriptInterface
    public final void overseasPay(@OXOo.OOXIXo String data) {
        SmartGooglePlayUtil smartGooglePlayUtil;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.II0xO0("overseasPay  " + data);
        try {
            JSONObject jSONObject = new JSONObject(data);
            String string = jSONObject.getString("eleId");
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            this.productId = string;
            String string2 = jSONObject.getString("orderNum");
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            this.orderNum = string2;
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.XxI() && this.productId.length() > 0 && this.orderNum.length() > 0) {
                if (this.productId.length() > 0) {
                    String string3 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24410X0xII0I);
                    if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(string3, "") && (smartGooglePlayUtil = this.smartGooglePlayUtil) != null) {
                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string3);
                        smartGooglePlayUtil.handlePurchase(string3);
                    }
                    SmartGooglePlayUtil smartGooglePlayUtil2 = this.smartGooglePlayUtil;
                    if (smartGooglePlayUtil2 != null) {
                        smartGooglePlayUtil2.launchBillingFlow(this.productId, this);
                    }
                } else {
                    ToastUtils.showLong("error : productId is null", new Object[0]);
                }
                SmartGooglePlayUtil smartGooglePlayUtil3 = this.smartGooglePlayUtil;
                if (smartGooglePlayUtil3 != null) {
                    smartGooglePlayUtil3.setGooglePlayCallBack(new oIX0oI());
                    return;
                }
                return;
            }
            oix0oi.II0xO0("overseasPay error :  isSupportGooglePay = " + productManager.XxI() + " ,  " + this.orderNum + " , " + this.productId);
            ToastUtils.showLong(R.string.voice_assistant_network_error);
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("overseasPay error : " + e.getMessage());
            ToastUtils.showLong(R.string.voice_assistant_network_error);
        }
    }

    public final void setLastCheckOrderNum(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.lastCheckOrderNum = str;
    }

    public final void setLastCheckOrderTime(long j) {
        this.lastCheckOrderTime = j;
    }

    public final void setLastCheckOrderToken(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.lastCheckOrderToken = str;
    }

    public final void setOrderNum(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.orderNum = str;
    }

    public final void setProductId(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.productId = str;
    }

    public final void setSmartGooglePlayUtil(@OXOo.oOoXoXO SmartGooglePlayUtil smartGooglePlayUtil) {
        this.smartGooglePlayUtil = smartGooglePlayUtil;
    }
}
