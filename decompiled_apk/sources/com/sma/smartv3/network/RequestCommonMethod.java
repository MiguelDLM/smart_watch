package com.sma.smartv3.network;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.xoIox;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;
import x0xO.XO;
import xxxI.II0xO0;

@XX({"SMAP\nRequestCommonMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestCommonMethod.kt\ncom/sma/smartv3/network/RequestCommonMethod\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,133:1\n158#2,4:134\n171#2:146\n151#2,11:150\n171#2:169\n151#2,11:173\n171#2:192\n208#3,7:138\n226#3:145\n208#3,7:161\n226#3:168\n208#3,7:184\n226#3:191\n19#4:147\n15#4:148\n90#4:149\n18#4,2:170\n15#4:172\n*S KotlinDebug\n*F\n+ 1 RequestCommonMethod.kt\ncom/sma/smartv3/network/RequestCommonMethod\n*L\n56#1:134,4\n56#1:146\n100#1:150,11\n100#1:169\n130#1:173,11\n130#1:192\n56#1:138,7\n56#1:145\n100#1:161,7\n100#1:168\n130#1:184,7\n130#1:191\n77#1:147\n77#1:148\n80#1:149\n115#1:170,2\n115#1:172\n*E\n"})
/* loaded from: classes12.dex */
public final class RequestCommonMethod {

    @OOXIXo
    public static final RequestCommonMethod INSTANCE = new RequestCommonMethod();

    private RequestCommonMethod() {
    }

    public static /* synthetic */ String getPhoneWithCode$default(RequestCommonMethod requestCommonMethod, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "+86";
        }
        return requestCommonMethod.getPhoneWithCode(str, str2);
    }

    public static /* synthetic */ void requestVerificationCode$default(RequestCommonMethod requestCommonMethod, Activity activity, View view, String str, TextView textView, int i, II0xO0 iI0xO0, int i2, Object obj) {
        int i3;
        if ((i2 & 16) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            iI0xO0 = null;
        }
        requestCommonMethod.requestVerificationCode(activity, view, str, textView, i3, iI0xO0);
    }

    @OOXIXo
    public final String getPhoneWithCode(@OOXIXo String code, @OOXIXo String text) {
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(text, "text");
        return code + '-' + text;
    }

    public final void requestVerificationCode(@OOXIXo final Activity context, @oOoXoXO View view, @OOXIXo String text, @OOXIXo final TextView showCountDownTimeView, int i, @oOoXoXO final II0xO0<String> iI0xO0) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(showCountDownTimeView, "showCountDownTimeView");
        if (!StringsKt__StringsKt.o00xOoIO(text, "@", false, 2, null) && text.length() != 0) {
            if (!UtilsKt.IoOoX(text)) {
                ToastUtils.showShort(R.string.input_phone_format_error);
                return;
            }
            text = getPhoneWithCode$default(this, null, text, 1, null);
        } else if (!RegexUtils.isEmail(text)) {
            ToastUtils.showShort(R.string.email_format_error);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> verificationCodeBody = RequestBodyKt.getVerificationCodeBody(text, i);
        final II0xO0<String> iI0xO02 = new II0xO0<String>() { // from class: com.sma.smartv3.network.RequestCommonMethod$requestVerificationCode$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@oOoXoXO String str) {
                ToastUtils.showLong(R.string.code_send_success);
                xoIox.XOxIOxOx(context, ProjectManager.f19822oIX0oI.OxxIIOOXO(), 1000L, showCountDownTimeView);
                II0xO0<String> iI0xO03 = iI0xO0;
                if (iI0xO03 != null) {
                    iI0xO03.handleResponse(str);
                }
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(context, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), VerificationCodeRequest.URL);
        netWorkUtils.printParam(convertBaseUrl + VerificationCodeRequest.URL, verificationCodeBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + VerificationCodeRequest.URL;
        final II0xO0<Response<String>> iI0xO03 = new II0xO0<Response<String>>() { // from class: com.sma.smartv3.network.RequestCommonMethod$requestVerificationCode$$inlined$post$1
            @Override // xxxI.II0xO0
            public void handleError(@OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO02, loadPopup);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@oOoXoXO Response<String> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity = context;
                II0xO0 iI0xO04 = iI0xO02;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity, response, iI0xO04);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) verificationCodeBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.network.RequestCommonMethod$requestVerificationCode$$inlined$post$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@oOoXoXO ANError aNError) {
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
                II0xO0.this.handleError(String.valueOf(num2));
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onResponse(@OOXIXo Response<String> response) {
                IIX0o.x0xO0oo(response, "response");
                II0xO0.this.handleResponse(response);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateDeviceInfo(@OXOo.OOXIXo final xxxI.II0xO0<java.lang.String> r43) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.network.RequestCommonMethod.updateDeviceInfo(xxxI.II0xO0):void");
    }
}
