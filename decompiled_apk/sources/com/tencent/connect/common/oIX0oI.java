package com.tencent.connect.common;

import XxXX.Oxx0IOOO;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import xIxooxXX.X0o0xo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public abstract class oIX0oI {
    public static String businessId = null;
    public static String installChannel = null;
    public static boolean isOEM = false;
    public static String registerChannel;
    protected X0o0xo b;
    protected xIxooxXX.II0xO0 c;

    /* renamed from: com.tencent.connect.common.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1086oIX0oI implements o0Oo.oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Handler f26915II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final o0Oo.II0xO0 f26916oIX0oI;

        /* renamed from: com.tencent.connect.common.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class HandlerC1087oIX0oI extends Handler {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ oIX0oI f26918oIX0oI;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC1087oIX0oI(Looper looper, oIX0oI oix0oi) {
                super(looper);
                this.f26918oIX0oI = oix0oi;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    C1086oIX0oI.this.f26916oIX0oI.onComplete(message.obj);
                } else {
                    C1086oIX0oI.this.f26916oIX0oI.oIX0oI(new o0Oo.I0Io(message.what, (String) message.obj, null));
                }
            }
        }

        public C1086oIX0oI(o0Oo.II0xO0 iI0xO0) {
            this.f26916oIX0oI = iI0xO0;
            this.f26915II0xO0 = new HandlerC1087oIX0oI(XxXX.X0o0xo.oIX0oI().getMainLooper(), oIX0oI.this);
        }

        @Override // o0Oo.oIX0oI
        public void I0Io(Exception exc) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void II0XooXoX(ConnectTimeoutException connectTimeoutException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = connectTimeoutException.getMessage();
            obtainMessage.what = -7;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void II0xO0(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void Oxx0IOOO(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void X0o0xo(JSONObject jSONObject) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void XO(MalformedURLException malformedURLException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void oIX0oI(IOException iOException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void oxoX(JSONException jSONException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }

        @Override // o0Oo.oIX0oI
        public void xxIXOIIO(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.f26915II0xO0.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.f26915II0xO0.sendMessage(obtainMessage);
        }
    }

    public oIX0oI(X0o0xo x0o0xo, xIxooxXX.II0xO0 iI0xO0) {
        this.b = x0o0xo;
        this.c = iI0xO0;
    }

    public String I0Io(String str) {
        Bundle II0xO02 = II0xO0();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            II0xO02.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.XO(II0xO02));
        return sb.toString();
    }

    public boolean II0XooXoX(Intent intent) {
        if (intent != null) {
            return Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent);
        }
        return false;
    }

    public Bundle II0xO0() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", II0xO0.f26901xoIox);
        bundle.putString("sdkp", "a");
        xIxooxXX.II0xO0 iI0xO0 = this.c;
        if (iI0xO0 != null && iI0xO0.xoIox()) {
            bundle.putString("access_token", this.c.oxoX());
            bundle.putString("oauth_consumer_key", this.c.X0o0xo());
            bundle.putString("openid", this.c.II0XooXoX());
            bundle.putString("appid_for_getting_config", this.c.X0o0xo());
        }
        SharedPreferences sharedPreferences = XxXX.X0o0xo.oIX0oI().getSharedPreferences(II0xO0.f26831XxX0x0xxx, 0);
        if (isOEM) {
            bundle.putString(II0xO0.f26810XIxXXX0x0, "desktop_m_qq-" + installChannel + HelpFormatter.DEFAULT_OPT_PREFIX + "android" + HelpFormatter.DEFAULT_OPT_PREFIX + registerChannel + HelpFormatter.DEFAULT_OPT_PREFIX + businessId);
        } else {
            bundle.putString(II0xO0.f26810XIxXXX0x0, sharedPreferences.getString(II0xO0.f26810XIxXXX0x0, II0xO0.f26794OxxIIOOXO));
        }
        return bundle;
    }

    public Intent OOXIXo(String str) {
        Intent intent = new Intent();
        Intent xxIXOIIO2 = xxIXOIIO(str);
        if (xxIXOIIO2 == null || xxIXOIIO2.getComponent() == null) {
            return null;
        }
        intent.setClassName(xxIXOIIO2.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    public void Oxx0IOOO(Fragment fragment, Intent intent, int i) {
        intent.putExtra(II0xO0.f26911xxX, i);
        fragment.startActivityForResult(oIX0oI(fragment.getActivity(), intent), i);
    }

    public void X0o0xo(Activity activity, Intent intent, int i) {
        intent.putExtra(II0xO0.f26911xxX, i);
        activity.startActivityForResult(oIX0oI(activity, intent), i);
    }

    public void XO(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new O0OOX0IIx.X0o0xo(activity, "", "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.XO(bundle), null, this.c).show();
    }

    public final Intent oIX0oI(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(AssistActivity.f26716IIXOooo, intent);
        return intent2;
    }

    public void oOoXoXO() {
    }

    public void oxoX(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(AssistActivity.f26716IIXOooo, intent);
        activity.startActivityForResult(intent2, i);
    }

    public Bundle xoIox() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.c.X0o0xo());
        if (this.c.xoIox()) {
            bundle.putString(II0xO0.f26880x0xO0oo, this.c.oxoX());
            bundle.putString(II0xO0.f26783Oo, "0x80");
        }
        String II0XooXoX2 = this.c.II0XooXoX();
        if (II0XooXoX2 != null) {
            bundle.putString("hopenid", II0XooXoX2);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = XxXX.X0o0xo.oIX0oI().getSharedPreferences(II0xO0.f26831XxX0x0xxx, 0);
        if (isOEM) {
            bundle.putString(II0xO0.f26810XIxXXX0x0, "desktop_m_qq-" + installChannel + HelpFormatter.DEFAULT_OPT_PREFIX + "android" + HelpFormatter.DEFAULT_OPT_PREFIX + registerChannel + HelpFormatter.DEFAULT_OPT_PREFIX + businessId);
        } else {
            bundle.putString(II0xO0.f26810XIxXXX0x0, sharedPreferences.getString(II0xO0.f26810XIxXXX0x0, II0xO0.f26794OxxIIOOXO));
            bundle.putString(II0xO0.f26810XIxXXX0x0, II0xO0.f26794OxxIIOOXO);
        }
        bundle.putString("sdkv", II0xO0.f26901xoIox);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    public Intent xxIXOIIO(String str) {
        Intent intent = new Intent();
        if (com.tencent.open.utils.II0xO0.ooXIXxIX(XxXX.X0o0xo.oIX0oI())) {
            intent.setClassName(II0xO0.f26870oxoX, str);
            if (Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent)) {
            return intent;
        }
        intent.setClassName(II0xO0.f26800X0o0xo, str);
        if (Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent)) {
            return intent;
        }
        intent.setClassName(II0xO0.f26792Oxx0IOOO, str);
        if (Oxx0IOOO.xxIXOIIO(XxXX.X0o0xo.oIX0oI(), intent)) {
            return intent;
        }
        return null;
    }

    public oIX0oI(xIxooxXX.II0xO0 iI0xO0) {
        this(null, iI0xO0);
    }
}
