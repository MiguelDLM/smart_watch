package com.sma.androidthirdpartylogin.wechat;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sma.androidthirdpartylogin.R;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes11.dex */
public final class WeChatRegister extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@OOXIXo Context context, @oOoXoXO Intent intent) {
        IIX0o.x0xO0oo(context, "context");
        WXAPIFactory.createWXAPI(context, context.getString(R.string.we_chat_app_id), false);
    }
}
