package com.sma.smartv3.co_fit.wxapi;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import com.sma.androidthirdpartylogin.wechat.WeChatBaseActivity;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WXEntryActivity extends WeChatBaseActivity {
    @Override // com.sma.androidthirdpartylogin.wechat.WeChatBaseActivity
    public void loginSuccess(@OOXIXo LoginResponse loginResponse) {
        IIX0o.x0xO0oo(loginResponse, "loginResponse");
        x0xO0oo.oIX0oI(x0xO0oo.f24615XX0, loginResponse);
    }

    @Override // com.sma.androidthirdpartylogin.wechat.WeChatBaseActivity
    public void toStartActivity(@oOoXoXO String str) {
        if (str != null) {
            LogUtils.d(str);
            ToastUtils.showLong(str, new Object[0]);
        }
        finish();
    }
}
