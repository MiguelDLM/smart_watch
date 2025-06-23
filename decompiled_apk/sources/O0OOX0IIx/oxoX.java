package O0OOX0IIx;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.oIX0oI;
import com.tencent.open.utils.HttpUtils;
import org.json.JSONObject;
import xoX.OOXIXo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oxoX extends com.tencent.connect.common.oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f1375I0Io = "add_msg";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f1376II0xO0 = "friend_label";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f1377Oxx0IOOO = "signature";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f1378X0o0xo = "union_name";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f1379XO = "zoneid";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f1380oIX0oI = "fopen_id";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f1381oxoX = "unionid";

    public oxoX(xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public void IXxxXO(Activity activity, String str, String str2, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- start");
        if (activity == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->bindQQGroup, activity is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("mqqapi://opensdk/bind_group?src_type=app&version=1");
        String X0o0xo2 = this.c.X0o0xo();
        if (TextUtils.isEmpty(X0o0xo2)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appId is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1003, "appid is null", "please login."));
                return;
            }
            return;
        }
        String II0XooXoX2 = this.c.II0XooXoX();
        if (TextUtils.isEmpty(II0XooXoX2)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->bindQQGroup, openid is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1004, "openid params is null", "please login."));
                return;
            }
            return;
        }
        String II0XooXoX3 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        if (TextUtils.isEmpty(II0XooXoX3)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appname is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1005, "appName params is null", ""));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization id is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1006, "organizationId params is null", ""));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization name is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1007, "organizationName params is null", ""));
                return;
            }
            return;
        }
        stringBuffer.append("&app_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX3), 2));
        stringBuffer.append("&organization_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str), 2));
        stringBuffer.append("&organization_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str2), 2));
        stringBuffer.append("&openid=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX2), 2));
        stringBuffer.append("&appid=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(X0o0xo2), 2));
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(com.tencent.connect.common.II0xO0.f26901xoIox), 2));
        xxIXOIIO.IXxxXO("openSDK_LOG.GameAppOperation", "-->bindQQGroup, url: " + stringBuffer.toString());
        Uri parse = Uri.parse(stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (II0XooXoX(intent) && XxXX.Oxx0IOOO.x0XOIxOo(activity, "8.1.0") >= 0) {
            I0Io i0Io = new I0Io(iI0xO0, activity, intent);
            Bundle II0xO02 = II0xO0();
            II0xO02.putString("appid", X0o0xo2);
            II0xO02.putString("orgid", str);
            HttpUtils.oOoXoXO(this.c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", II0xO02, "GET", new oIX0oI.C1086oIX0oI(i0Io));
            xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->bindQQGroup() do.");
            return;
        }
        xxIXOIIO.oI0IIXIo("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
        oO(activity);
    }

    public void Oxx0xo(Activity activity, String str, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "joinQQGroup()");
        if (activity == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->joinGroup, activity is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->joinGroup, params is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1006, "param organizationId is null", "organizationId param of api can not be null."));
                return;
            }
            return;
        }
        Intent intent = new Intent();
        String X0o0xo2 = this.c.X0o0xo();
        if (TextUtils.isEmpty(X0o0xo2)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->joinGroup, appid is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1003, "appid is null", "appid is null, please login."));
                return;
            }
            return;
        }
        String II0XooXoX2 = this.c.II0XooXoX();
        if (TextUtils.isEmpty(II0XooXoX2)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->joinGroup, openid is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1004, "openid is null", "openid is null, please login."));
                return;
            }
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("mqqapi://opensdk/join_group?src_type=app&version=1");
        stringBuffer.append("&openid=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX2), 2));
        stringBuffer.append("&appid=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(X0o0xo2), 2));
        stringBuffer.append("&organization_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str), 2));
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(com.tencent.connect.common.II0xO0.f26901xoIox), 2));
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (II0XooXoX(intent) && XxXX.Oxx0IOOO.x0XOIxOo(activity, "8.1.0") >= 0) {
            II0xO0 iI0xO02 = new II0xO0(iI0xO0, activity, intent);
            Bundle II0xO02 = II0xO0();
            II0xO02.putString("appid", X0o0xo2);
            II0xO02.putString("orgid", str);
            HttpUtils.oOoXoXO(this.c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", II0xO02, "GET", new oIX0oI.C1086oIX0oI(iI0xO02));
            xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->joinQQGroup() do.");
            return;
        }
        xxIXOIIO.oI0IIXIo("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
        oO(activity);
    }

    public void OxxIIOOXO(Context context, String str, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "unBindQQGroup()");
        if (context == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->uinBindGroup, activity is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->unBindGroup, params is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1006, "param organizationId is null", "organizationId param of api can not be null."));
                return;
            }
            return;
        }
        String X0o0xo2 = this.c.X0o0xo();
        if (TextUtils.isEmpty(X0o0xo2)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->unBindGroup, appid is empty.");
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(1003, "param appId is null", "appid is null please login."));
                return;
            }
            return;
        }
        oIX0oI oix0oi = new oIX0oI(iI0xO0);
        Bundle II0xO02 = II0xO0();
        II0xO02.putString("appid", X0o0xo2);
        II0xO02.putString("orgid", str);
        HttpUtils.oOoXoXO(this.c, context, "https://openmobile.qq.com/cgi-bin/qunopensdk/unbind", II0xO02, "GET", new oIX0oI.C1086oIX0oI(oix0oi));
        xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->unBindQQGroup() do.");
    }

    public void oI0IIXIo(Activity activity, Bundle bundle) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- start");
        if (bundle == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->makeFriend params is null");
            OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26801X0ooXIooI, com.tencent.connect.common.II0xO0.f26773OO0, "18", "1");
            return;
        }
        String string = bundle.getString(f1380oIX0oI);
        if (TextUtils.isEmpty(string)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid is empty.");
            OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26801X0ooXIooI, com.tencent.connect.common.II0xO0.f26773OO0, "18", "1");
            return;
        }
        String string2 = bundle.getString(f1376II0xO0);
        String string3 = bundle.getString(f1375I0Io);
        String II0XooXoX2 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        String II0XooXoX3 = this.c.II0XooXoX();
        String X0o0xo2 = this.c.X0o0xo();
        xxIXOIIO.IXxxXO("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid: " + string + " | label: " + string2 + " | message: " + string3 + " | openid: " + II0XooXoX3 + " | appid:" + X0o0xo2);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/add_friend?src_type=app&version=1");
        StringBuilder sb = new StringBuilder();
        sb.append("&fopen_id=");
        sb.append(Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string), 2));
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(II0XooXoX3)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX3), 2));
        }
        if (!TextUtils.isEmpty(X0o0xo2)) {
            stringBuffer.append("&app_id=" + X0o0xo2);
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&friend_label=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&add_msg=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string3), 2));
        }
        if (!TextUtils.isEmpty(II0XooXoX2)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(II0XooXoX2), 2));
        }
        xxIXOIIO.IXxxXO("openSDK_LOG.GameAppOperation", "-->make friend, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (II0XooXoX(intent) && !com.tencent.open.utils.II0xO0.Xx000oIo(activity, "5.1.0")) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->makeFriend target activity found, qqver greater than 5.1.0");
            try {
                activity.startActivity(intent);
                OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26801X0ooXIooI, com.tencent.connect.common.II0xO0.f26773OO0, "18", "0");
            } catch (Exception e) {
                xxIXOIIO.xxIXOIIO("openSDK_LOG.GameAppOperation", "-->make friend, start activity exception.", e);
                oO(activity);
                OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26801X0ooXIooI, com.tencent.connect.common.II0xO0.f26773OO0, "18", "1");
            }
        } else {
            xxIXOIIO.oI0IIXIo("openSDK_LOG.GameAppOperation", "-->make friend, there is no activity.");
            oO(activity);
            OOXIXo.oIX0oI().I0Io(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26801X0ooXIooI, com.tencent.connect.common.II0xO0.f26773OO0, "18", "1");
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- end");
    }

    public final void oO(Activity activity) {
        x0xO0oo(activity, "");
    }

    public final void x0xO0oo(Activity activity, String str) {
        new X0o0xo(activity, "", I0Io(str), null, this.c).show();
    }

    /* loaded from: classes13.dex */
    public class I0Io implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ Intent f1382I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Activity f1383II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f1384oIX0oI;

        public I0Io(o0Oo.II0xO0 iI0xO0, Activity activity, Intent intent) {
            this.f1384oIX0oI = iI0xO0;
            this.f1383II0xO0 = activity;
            this.f1382I0Io = intent;
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            xxIXOIIO.IXxxXO("openSDK_LOG.GameAppOperation", "-->bindQQGroup, error: " + i0Io);
            o0Oo.II0xO0 iI0xO0 = this.f1384oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            xxIXOIIO.oI0IIXIo("openSDK_LOG.GameAppOperation", "-->bind group resp is: " + obj);
            if (obj == null) {
                o0Oo.II0xO0 iI0xO0 = this.f1384oIX0oI;
                if (iI0xO0 != null) {
                    iI0xO0.oIX0oI(new o0Oo.I0Io(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                    return;
                }
                return;
            }
            if (((JSONObject) obj).optInt("bind") != 1) {
                try {
                    oxoX.this.oxoX(this.f1383II0xO0, 10112, this.f1382I0Io, false);
                    return;
                } catch (Exception e) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.GameAppOperation", "-->bind group, start activity exception.", e);
                    oxoX.this.oO(this.f1383II0xO0);
                    return;
                }
            }
            o0Oo.II0xO0 iI0xO02 = this.f1384oIX0oI;
            if (iI0xO02 != null) {
                iI0xO02.oIX0oI(new o0Oo.I0Io(3002, "该群已绑定！", "绑定过的群不能再次绑定。"));
            }
            xxIXOIIO.oOoXoXO("openSDK_LOG.GameAppOperation", "-->bindQQGroup() binded return.");
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ Intent f1386I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Activity f1387II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f1388oIX0oI;

        public II0xO0(o0Oo.II0xO0 iI0xO0, Activity activity, Intent intent) {
            this.f1388oIX0oI = iI0xO0;
            this.f1387II0xO0 = activity;
            this.f1386I0Io = intent;
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            xxIXOIIO.IXxxXO("openSDK_LOG.GameAppOperation", "-->joinQQGroup, error: " + i0Io);
            o0Oo.II0xO0 iI0xO0 = this.f1388oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            xxIXOIIO.oI0IIXIo("openSDK_LOG.GameAppOperation", "-->join group resp is: " + obj);
            if (obj == null) {
                o0Oo.II0xO0 iI0xO0 = this.f1388oIX0oI;
                if (iI0xO0 != null) {
                    iI0xO0.oIX0oI(new o0Oo.I0Io(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                    return;
                }
                return;
            }
            if (((JSONObject) obj).optInt("bind") == 1) {
                try {
                    oxoX.this.oxoX(this.f1387II0xO0, 10111, this.f1386I0Io, false);
                    return;
                } catch (Exception e) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.GameAppOperation", "-->join group, start activity exception.", e);
                    oxoX.this.oO(this.f1387II0xO0);
                    return;
                }
            }
            o0Oo.II0xO0 iI0xO02 = this.f1388oIX0oI;
            if (iI0xO02 != null) {
                iI0xO02.oIX0oI(new o0Oo.I0Io(3003, "该组织未绑群，无法加入", "该组织未绑群，无法加入。"));
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements o0Oo.II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f1391oIX0oI;

        public oIX0oI(o0Oo.II0xO0 iI0xO0) {
            this.f1391oIX0oI = iI0xO0;
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            xxIXOIIO.IXxxXO("openSDK_LOG.GameAppOperation", "-->unbindQQGroup, error: " + i0Io);
            o0Oo.II0xO0 iI0xO0 = this.f1391oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            xxIXOIIO.oI0IIXIo("openSDK_LOG.GameAppOperation", "-->unbind group resp is: " + obj);
            if (obj == null) {
                o0Oo.II0xO0 iI0xO0 = this.f1391oIX0oI;
                if (iI0xO0 != null) {
                    iI0xO0.oIX0oI(new o0Oo.I0Io(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                    return;
                }
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            o0Oo.II0xO0 iI0xO02 = this.f1391oIX0oI;
            if (iI0xO02 != null) {
                iI0xO02.onComplete(jSONObject);
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
        }
    }
}
