package O0OOX0IIx;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.open.b.b;
import com.tencent.open.utils.HttpUtils;
import fi.iki.elonen.NanoHTTPD;
import org.json.JSONException;
import org.json.JSONObject;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class II0xO0 extends com.tencent.connect.common.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Activity f1339oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f1340I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f1341II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public Activity f1342X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public o0Oo.II0xO0 f1344oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public Bundle f1345oxoX;

        public oIX0oI(Activity activity, o0Oo.II0xO0 iI0xO0, String str, String str2, Bundle bundle) {
            this.f1344oIX0oI = iI0xO0;
            this.f1341II0xO0 = str;
            this.f1340I0Io = str2;
            this.f1345oxoX = bundle;
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            xxIXOIIO.XO("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + i0Io.f31122II0xO0);
            this.f1344oIX0oI.oIX0oI(i0Io);
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            this.f1344oIX0oI.onCancel();
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(I0Io.f1294XxX0x0xxx);
            } catch (JSONException e) {
                e.printStackTrace();
                xxIXOIIO.xxIXOIIO("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e);
                str = null;
            }
            this.f1345oxoX.putString("encrytoken", str);
            II0xO0 iI0xO0 = II0xO0.this;
            iI0xO0.Oxx0xo(iI0xO0.f1339oIX0oI, this.f1341II0xO0, this.f1345oxoX, this.f1340I0Io, this.f1344oIX0oI);
            if (TextUtils.isEmpty(str)) {
                xxIXOIIO.XO("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                II0xO0.this.o00(this.f1342X0o0xo);
            }
        }
    }

    public II0xO0(xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public void IIXOooo(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        this.f1339oIX0oI = activity;
        Intent OOXIXo2 = OOXIXo(I0Io.f1316xo0x);
        if (OOXIXo2 == null) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            OOXIXo2 = OOXIXo(I0Io.f1295o0);
        }
        bundle.putAll(xoIox());
        oO(activity, OOXIXo2, I0Io.f1303oo0xXOI0I, bundle, XxXX.XO.oIX0oI().II0xO0(XxXX.X0o0xo.oIX0oI(), "https://login.imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iI0xO0, false);
    }

    public final void IXxxXO(Activity activity, String str, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        this.f1339oIX0oI = activity;
        Intent OOXIXo2 = OOXIXo(I0Io.f1316xo0x);
        if (OOXIXo2 == null) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            OOXIXo2 = OOXIXo(I0Io.f1289XOxIOxOx);
        }
        Intent intent = OOXIXo2;
        bundle.putAll(xoIox());
        if (I0Io.f1300oOXoIIIo.equals(str)) {
            bundle.putString("type", "request");
        } else if (I0Io.f1293Xx000oIo.equals(str)) {
            bundle.putString("type", I0Io.f1291XX0);
        }
        oO(activity, intent, str, bundle, XxXX.XO.oIX0oI().II0xO0(XxXX.X0o0xo.oIX0oI(), "https://login.imgcache.qq.com/open/mobile/request/sdk_request.html?"), iI0xO0, false);
    }

    public final void Oo(Activity activity, String str, Bundle bundle, String str2, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent xxIXOIIO2 = xxIXOIIO("com.tencent.open.agent.AgentActivity");
        o0Oo.II0xO0 oix0oi = new oIX0oI(activity, iI0xO0, str, str2, bundle);
        Intent xxIXOIIO3 = xxIXOIIO("com.tencent.open.agent.EncryTokenActivity");
        if (xxIXOIIO3 != null && xxIXOIIO2 != null && xxIXOIIO2.getComponent() != null && xxIXOIIO3.getComponent() != null && xxIXOIIO2.getComponent().getPackageName().equals(xxIXOIIO3.getComponent().getPackageName())) {
            xxIXOIIO3.putExtra("oauth_consumer_key", this.c.X0o0xo());
            xxIXOIIO3.putExtra("openid", this.c.II0XooXoX());
            xxIXOIIO3.putExtra("access_token", this.c.oxoX());
            xxIXOIIO3.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, I0Io.f1271IO);
            if (II0XooXoX(xxIXOIIO3)) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                com.tencent.connect.common.I0Io.II0xO0().Oxx0IOOO(11106, oix0oi);
                X0o0xo(activity, xxIXOIIO3, 11106);
                return;
            }
            return;
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String IoOoX2 = com.tencent.open.utils.II0xO0.IoOoX("tencent&sdk&qazxc***14969%%" + this.c.oxoX() + this.c.X0o0xo() + this.c.II0XooXoX() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(I0Io.f1294XxX0x0xxx, IoOoX2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        oix0oi.onComplete(jSONObject);
    }

    public final void Oxx0xo(Context context, String str, Bundle bundle, String str2, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.IXxxXO("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.c.X0o0xo());
        if (this.c.xoIox()) {
            bundle.putString("access_token", this.c.oxoX());
        }
        String II0XooXoX2 = this.c.II0XooXoX();
        if (II0XooXoX2 != null) {
            bundle.putString("openid", II0XooXoX2);
        }
        try {
            bundle.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, XxXX.X0o0xo.oIX0oI().getSharedPreferences(com.tencent.connect.common.II0xO0.f26831XxX0x0xxx, 0).getString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, com.tencent.connect.common.II0xO0.f26794OxxIIOOXO));
        } catch (Exception e) {
            e.printStackTrace();
            bundle.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, com.tencent.connect.common.II0xO0.f26794OxxIIOOXO);
        }
        String str3 = str2 + HttpUtils.XO(bundle);
        xxIXOIIO.XO("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!I0Io.f1302oo.equals(str) && !I0Io.f1274IoOoX.equals(str)) {
            new X0o0xo(this.f1339oIX0oI, str, str3, iI0xO0, this.c).show();
        } else {
            xxIXOIIO.XO("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new II0XooXoX(this.f1339oIX0oI, str, str3, iI0xO0, this.c).show();
        }
    }

    public void OxxIIOOXO(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        IXxxXO(activity, I0Io.f1293Xx000oIo, bundle, iI0xO0);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void o00(Context context) {
        String str;
        String oxoX2 = this.c.oxoX();
        String X0o0xo2 = this.c.X0o0xo();
        String II0XooXoX2 = this.c.II0XooXoX();
        if (oxoX2 != null && oxoX2.length() > 0 && X0o0xo2 != null && X0o0xo2.length() > 0 && II0XooXoX2 != null && II0XooXoX2.length() > 0) {
            str = com.tencent.open.utils.II0xO0.IoOoX("tencent&sdk&qazxc***14969%%" + oxoX2 + X0o0xo2 + II0XooXoX2 + "qzone3.4");
        } else {
            str = null;
        }
        b bVar = new b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        String str2 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.c.II0XooXoX() + "_" + this.c.X0o0xo() + "\"]=\"" + str + "\";</script></head><body></body></html>";
        String II0xO02 = XxXX.XO.oIX0oI().II0xO0(context, "https://login.imgcache.qq.com");
        bVar.loadDataWithBaseURL(II0xO02, str2, NanoHTTPD.MIME_HTML, "utf-8", II0xO02);
    }

    public void oI0IIXIo(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        IXxxXO(activity, I0Io.f1300oOXoIIIo, bundle, iI0xO0);
    }

    public final void oO(Activity activity, Intent intent, String str, Bundle bundle, String str2, o0Oo.II0xO0 iI0xO0, boolean z) {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        if (intent == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            x0xO0oo(activity, intent, str, bundle, iI0xO0);
            return;
        }
        com.tencent.open.utils.oIX0oI oxoX2 = com.tencent.open.utils.oIX0oI.oxoX(XxXX.X0o0xo.oIX0oI(), this.c.X0o0xo());
        if (!z && !oxoX2.xoIox("C_LoginH5")) {
            XO(activity, bundle, iI0xO0);
        } else {
            Oo(activity, str, bundle, str2, iI0xO0);
        }
    }

    public final void x0xO0oo(Activity activity, Intent intent, String str, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, str);
        intent.putExtra(com.tencent.connect.common.II0xO0.f26852oXIO0o0XI, bundle);
        com.tencent.connect.common.I0Io.II0xO0().Oxx0IOOO(11105, iI0xO0);
        X0o0xo(activity, intent, 11105);
    }

    public void xoXoI(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        this.f1339oIX0oI = activity;
        Intent OOXIXo2 = OOXIXo(I0Io.f1290XX);
        bundle.putAll(xoIox());
        oO(activity, OOXIXo2, I0Io.f1312xI, bundle, XxXX.XO.oIX0oI().II0xO0(XxXX.X0o0xo.oIX0oI(), "https://login.imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iI0xO0, false);
    }

    @Override // com.tencent.connect.common.oIX0oI
    public Intent xxIXOIIO(String str) {
        Intent intent = new Intent();
        intent.setClassName(com.tencent.connect.common.II0xO0.f26737II0xO0, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName(com.tencent.connect.common.II0xO0.f26870oxoX, str);
        if (com.tencent.open.utils.II0xO0.ooXIXxIX(XxXX.X0o0xo.oIX0oI()) && XxXX.Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent3)) {
            return intent3;
        }
        if (XxXX.Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent2) && XxXX.Oxx0IOOO.x0XOIxOo(XxXX.X0o0xo.oIX0oI(), "4.7") >= 0) {
            return intent2;
        }
        if (!XxXX.Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent) || XxXX.Oxx0IOOO.II0xO0(XxXX.Oxx0IOOO.Oxx0IOOO(XxXX.X0o0xo.oIX0oI(), com.tencent.connect.common.II0xO0.f26737II0xO0), "4.2") < 0 || !XxXX.Oxx0IOOO.xoIox(XxXX.X0o0xo.oIX0oI(), intent.getComponent().getPackageName(), com.tencent.connect.common.II0xO0.f26909xxIXOIIO)) {
            return null;
        }
        return intent;
    }

    public II0xO0(xIxooxXX.X0o0xo x0o0xo, xIxooxXX.II0xO0 iI0xO0) {
        super(x0o0xo, iI0xO0);
    }
}
