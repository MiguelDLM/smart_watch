package com.sma.androidthirdpartylogin.wechat;

import O0OOX0IIx.oxoX;
import O0xxXxI.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.JsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidthirdpartylogin.R;
import com.sma.androidthirdpartylogin.model.LoginResponse;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONObject;
import xxxI.II0xO0;

/* loaded from: classes11.dex */
public abstract class WeChatBaseActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @OOXIXo
    private final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    public IWXAPI api;

    @OOXIXo
    public final IWXAPI getApi() {
        IWXAPI iwxapi = this.api;
        if (iwxapi != null) {
            return iwxapi;
        }
        IIX0o.XOxIOxOx("api");
        return null;
    }

    public abstract void loginSuccess(@OOXIXo LoginResponse loginResponse);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_we_chat_login);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, getString(R.string.we_chat_app_id), false);
        IIX0o.oO(createWXAPI, "createWXAPI(...)");
        setApi(createWXAPI);
        try {
            getApi().handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        getApi().handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@oOoXoXO BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@OOXIXo BaseResp resp) {
        IIX0o.x0xO0oo(resp, "resp");
        LogUtils.d("onResp ");
        if (resp.getType() == 1) {
            String str = ((SendAuth.Resp) resp).code;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(this.ACCESS_TOKEN_URL, Arrays.copyOf(new Object[]{getString(R.string.we_chat_app_id), getString(R.string.we_chat_app_secret), str}, 3));
            IIX0o.oO(format, "format(...)");
            LogUtils.d(format);
            NetWork.xoIox(NetWork.f19682oIX0oI, format, new II0xO0<JSONObject>() { // from class: com.sma.androidthirdpartylogin.wechat.WeChatBaseActivity$onResp$1
                @Override // xxxI.II0xO0
                public void handleError(@OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    WeChatBaseActivity.this.toStartActivity(error);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@oOoXoXO JSONObject jSONObject) {
                    String str2;
                    String str3;
                    String jSONObject2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("result ==");
                    if (jSONObject != null) {
                        str2 = jSONObject.toString();
                    } else {
                        str2 = null;
                    }
                    sb.append(str2);
                    LogUtils.i(sb.toString());
                    String string = JsonUtils.getString(jSONObject, "openid", "");
                    String string2 = JsonUtils.getString(jSONObject, "access_token", "");
                    String string3 = JsonUtils.getString(jSONObject, "refresh_token", "");
                    String string4 = JsonUtils.getString(jSONObject, oxoX.f1381oxoX, "");
                    if (jSONObject == null || (jSONObject2 = jSONObject.toString()) == null) {
                        str3 = "";
                    } else {
                        str3 = jSONObject2;
                    }
                    IIX0o.ooOOo0oXI(string);
                    if (string.length() == 0) {
                        WeChatBaseActivity.this.toStartActivity(String.valueOf(jSONObject));
                        return;
                    }
                    WeChatBaseActivity weChatBaseActivity = WeChatBaseActivity.this;
                    IIX0o.ooOOo0oXI(string2);
                    IIX0o.ooOOo0oXI(string3);
                    IIX0o.ooOOo0oXI(string4);
                    weChatBaseActivity.loginSuccess(new LoginResponse(oIX0oI.f1499II0xO0, string, string2, string3, str3, string4));
                    WeChatBaseActivity.this.toStartActivity(null);
                }
            }, 0, 4, null);
            return;
        }
        if (resp.getType() == 2) {
            finish();
        } else {
            toStartActivity(String.valueOf(resp.getType()));
        }
    }

    public final void setApi(@OOXIXo IWXAPI iwxapi) {
        IIX0o.x0xO0oo(iwxapi, "<set-?>");
        this.api = iwxapi;
    }

    public abstract void toStartActivity(@oOoXoXO String str);
}
