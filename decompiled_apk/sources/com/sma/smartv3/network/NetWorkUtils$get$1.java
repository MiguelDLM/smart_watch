package com.sma.smartv3.network;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.pop.I0X0x0oIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import x0xO.XO;
import xxxI.II0xO0;

/* JADX INFO: Add missing generic type declarations: [T] */
@XX({"SMAP\nNetWorkUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils$get$1\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,631:1\n406#2,8:632\n415#2,5:641\n1#3:640\n*S KotlinDebug\n*F\n+ 1 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils$get$1\n*L\n114#1:632,8\n114#1:641,5\n114#1:640\n*E\n"})
/* loaded from: classes12.dex */
public final class NetWorkUtils$get$1<T> implements II0xO0<Response<T>> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ II0xO0<T> $callback;
    final /* synthetic */ I0X0x0oIo $progressPopup;

    public NetWorkUtils$get$1(Activity activity, II0xO0<T> iI0xO0, I0X0x0oIo i0X0x0oIo) {
        this.$activity = activity;
        this.$callback = iI0xO0;
        this.$progressPopup = i0X0x0oIo;
    }

    @Override // xxxI.II0xO0
    public void handleError(@OOXIXo String error) {
        IIX0o.x0xO0oo(error, "error");
        NetWorkUtils.INSTANCE.errorData(error, this.$callback, this.$progressPopup);
    }

    @Override // xxxI.II0xO0
    public void handleResponse(@oOoXoXO Response<T> response) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        Activity activity = this.$activity;
        II0xO0<T> iI0xO0 = this.$callback;
        I0X0x0oIo i0X0x0oIo = this.$progressPopup;
        LogUtils.d(XO.f34062II0XooXoX + response);
        if (response == null) {
            response = new Response<>();
            response.setCode(-1000);
        }
        netWorkUtils.responseWhenCheck(activity, response, iI0xO0);
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }
}
