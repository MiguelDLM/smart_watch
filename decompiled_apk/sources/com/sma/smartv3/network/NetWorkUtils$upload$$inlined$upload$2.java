package com.sma.smartv3.network;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.sma.androidnetworklib.model.Response;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import xxxI.II0xO0;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nNetWork.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork$upload$2\n*L\n1#1,359:1\n*E\n"})
/* loaded from: classes12.dex */
public final class NetWorkUtils$upload$$inlined$upload$2<T> implements ParsedRequestListener<Response<T>> {
    final /* synthetic */ II0xO0 $callback;

    public NetWorkUtils$upload$$inlined$upload$2(II0xO0 iI0xO0) {
        this.$callback = iI0xO0;
    }

    @Override // com.androidnetworking.interfaces.ParsedRequestListener
    public void onError(@oOoXoXO ANError aNError) {
        this.$callback.handleError(String.valueOf(aNError));
    }

    @Override // com.androidnetworking.interfaces.ParsedRequestListener
    public void onResponse(@OOXIXo Response<T> response) {
        IIX0o.x0xO0oo(response, "response");
        this.$callback.handleResponse(response);
    }
}
