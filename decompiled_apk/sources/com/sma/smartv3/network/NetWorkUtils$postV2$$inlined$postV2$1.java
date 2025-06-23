package com.sma.smartv3.network;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.sma.androidnetworklib.model.Response;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import xxxI.II0xO0;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nNetWork.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork$postV2$1\n*L\n1#1,359:1\n*E\n"})
/* loaded from: classes12.dex */
public final class NetWorkUtils$postV2$$inlined$postV2$1<T> implements ParsedRequestListener<Response<T>> {
    final /* synthetic */ II0xO0 $callback;

    public NetWorkUtils$postV2$$inlined$postV2$1(II0xO0 iI0xO0) {
        this.$callback = iI0xO0;
    }

    @Override // com.androidnetworking.interfaces.ParsedRequestListener
    public void onError(@oOoXoXO ANError aNError) {
        Integer num;
        String str;
        String str2;
        String str3;
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
            str = aNError.getErrorBody();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", errorDetail:");
        if (aNError != null) {
            str2 = aNError.getErrorDetail();
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append(", exception:");
        if (aNError != null) {
            str3 = aNError.getLocalizedMessage();
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
        this.$callback.handleError(String.valueOf(num2));
    }

    @Override // com.androidnetworking.interfaces.ParsedRequestListener
    public void onResponse(@OOXIXo Response<T> response) {
        IIX0o.x0xO0oo(response, "response");
        this.$callback.handleResponse(response);
    }
}
