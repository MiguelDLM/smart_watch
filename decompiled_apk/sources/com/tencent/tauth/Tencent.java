package com.tencent.tauth;

import XxXX.Oxx0IOOO;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.connect.common.I0Io;
import com.tencent.connect.share.QQShare;
import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o0Oo.II0xO0;
import oo0oIXo.oIX0oI;
import org.json.JSONException;
import org.json.JSONObject;
import xIxooxXX.X0o0xo;
import xx0.OOXIXo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static Tencent c;

    /* renamed from: a, reason: collision with root package name */
    private final X0o0xo f26984a;
    private String b;

    private Tencent(String str, Context context) {
        this.f26984a = X0o0xo.xxIXOIIO(str, context);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            try {
                xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
                createInstance = createInstance(str, context);
                if (createInstance != null) {
                    createInstance.b = str2;
                } else {
                    xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return createInstance;
    }

    public static synchronized String getAuthorities(String str) {
        String str2;
        synchronized (Tencent.class) {
            if (TextUtils.isEmpty(str)) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            Tencent tencent = c;
            if (tencent == null) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "sInstance == null");
                return null;
            }
            if (str.equals(tencent.getAppId())) {
                str2 = c.b;
            } else {
                str2 = "";
            }
            return str2;
        }
    }

    public static void handleResultData(Intent intent, II0xO0 iI0xO0) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        boolean z2 = false;
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(", listener = null ? ");
        if (iI0xO0 == null) {
            z2 = true;
        }
        sb.append(z2);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", sb.toString());
        I0Io.II0xO0().X0o0xo(intent, iI0xO0);
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z;
        if (Oxx0IOOO.x0XOIxOo(context, "5.9.5") < 0 && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo) == null && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26792Oxx0IOOO) == null) {
            z = false;
        } else {
            z = true;
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        return z;
    }

    public static boolean isSupportShareToQQ(Context context) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (com.tencent.open.utils.II0xO0.ooXIXxIX(context) && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26870oxoX) != null) {
            return true;
        }
        if (Oxx0IOOO.x0XOIxOo(context, "4.1") < 0 && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo) == null && Oxx0IOOO.Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26792Oxx0IOOO) == null) {
            z = false;
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        return z;
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, II0xO0 iI0xO0) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        boolean z2 = false;
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(", listener = null ? ");
        if (iI0xO0 == null) {
            z2 = true;
        }
        sb.append(z2);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", sb.toString());
        return I0Io.II0xO0().XO(i, i2, intent, iI0xO0);
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        String stringExtra;
        HashMap hashMap = new HashMap();
        if (intent == null) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (Exception e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.Tencent", "Exception", e);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            xxIXOIIO.XO("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        }
        Uri data = intent.getData();
        if (data == null) {
            xxIXOIIO.XO("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return hashMap;
        }
        String uri = data.toString();
        if (TextUtils.isEmpty(uri)) {
            xxIXOIIO.XO("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return hashMap;
        }
        String substring = uri.substring(uri.lastIndexOf(63) + 1);
        if (TextUtils.isEmpty(substring)) {
            xxIXOIIO.XO("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return hashMap;
        }
        xxIXOIIO.XO("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
        for (String str : substring.split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static void setCustomLogger(OOXIXo oOXIXo) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setCustomLogger");
        xxIXOIIO.OOXIXo().oO(oOXIXo);
    }

    public void checkLogin(II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "checkLogin()");
        this.f26984a.ooOOo0oXI(iI0xO0);
    }

    public String getAccessToken() {
        String oxoX2 = this.f26984a.oO().oxoX();
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + oxoX2);
        return oxoX2;
    }

    public String getAppId() {
        String X0o0xo2 = this.f26984a.oO().X0o0xo();
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "getAppId() appid =" + X0o0xo2);
        return X0o0xo2;
    }

    public long getExpiresIn() {
        long Oxx0IOOO2 = this.f26984a.oO().Oxx0IOOO();
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + Oxx0IOOO2);
        return Oxx0IOOO2;
    }

    public String getOpenId() {
        String II0XooXoX2 = this.f26984a.oO().II0XooXoX();
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "getOpenId() openid= " + II0XooXoX2);
        return II0XooXoX2;
    }

    public xIxooxXX.II0xO0 getQQToken() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "getQQToken()");
        return this.f26984a.oO();
    }

    @Deprecated
    public void handleLoginData(Intent intent, II0xO0 iI0xO0) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        boolean z2 = false;
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(", listener = null ? ");
        if (iI0xO0 == null) {
            z2 = true;
        }
        sb.append(z2);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", sb.toString());
        I0Io.II0xO0().X0o0xo(intent, iI0xO0);
    }

    public void initSessionCache(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e) {
            xxIXOIIO.oOoXoXO("QQToken", "initSessionCache " + e.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean ooOOo0oXI2 = Oxx0IOOO.ooOOo0oXI(context);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isQQInstalled() installed=" + ooOOo0oXI2);
        return ooOOo0oXI2;
    }

    public boolean isReady() {
        boolean z;
        if (isSessionValid() && getOpenId() != null) {
            z = true;
        } else {
            z = false;
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        return z;
    }

    public boolean isSessionValid() {
        boolean Oo2 = this.f26984a.Oo();
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + Oo2);
        return Oo2;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (com.tencent.open.utils.II0xO0.ooXIXxIX(activity) && Oxx0IOOO.Oxx0IOOO(activity, com.tencent.connect.common.II0xO0.f26870oxoX) != null) {
            return true;
        }
        if (Oxx0IOOO.x0XOIxOo(activity, "4.1") < 0 && Oxx0IOOO.x0xO0oo(activity, "1.1") < 0) {
            z = false;
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        return z;
    }

    public JSONObject loadSession(String str) {
        int i;
        JSONObject OOXIXo2 = this.f26984a.oO().OOXIXo(str);
        StringBuilder sb = new StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        if (OOXIXo2 != null) {
            i = OOXIXo2.length();
        } else {
            i = 0;
        }
        sb.append(i);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", sb.toString());
        return OOXIXo2;
    }

    public int login(Activity activity, String str, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f26984a.I0Io(activity, str, iI0xO0);
    }

    public int loginServerSide(Activity activity, String str, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        return this.f26984a.I0Io(activity, str + ",server_side", iI0xO0);
    }

    public int loginWithOEM(Activity activity, String str, II0xO0 iI0xO0, boolean z, String str2, String str3, String str4) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.f26984a.XO(activity, str, iI0xO0, z, str2, str3, str4);
    }

    public void logout(Context context) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "logout()");
        this.f26984a.oO().x0XOIxOo(null, "0");
        this.f26984a.oO().Oo(null);
        this.f26984a.oO().oOoXoXO(this.f26984a.oO().X0o0xo());
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(Activity activity, Bundle bundle, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "publishToQzone()");
        new oIX0oI(activity, this.f26984a.oO()).oO(activity, bundle, iI0xO0);
    }

    public int reAuth(Activity activity, String str, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.f26984a.x0XOIxOo(activity, str, iI0xO0);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "reportDAU() ");
        this.f26984a.xoIox();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "request()");
        return HttpUtils.OOXIXo(this.f26984a.oO(), XxXX.X0o0xo.oIX0oI(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, o0Oo.oIX0oI oix0oi) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.oOoXoXO(this.f26984a.oO(), XxXX.X0o0xo.oIX0oI(), str, bundle, str2, oix0oi);
    }

    public void saveSession(JSONObject jSONObject) {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("saveSession() length=");
        if (jSONObject != null) {
            i = jSONObject.length();
        } else {
            i = 0;
        }
        sb.append(i);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", sb.toString());
        this.f26984a.oO().ooOOo0oXI(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        this.f26984a.oOoXoXO(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setAvatar()");
        String string = bundle.getString("picture");
        new XxIo.oIX0oI(this.f26984a.oO()).x0xO0oo(activity, Uri.parse(string), iI0xO0, bundle.getInt("exitAnim"));
    }

    public void setAvatarByQQ(Activity activity, Uri uri, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setAvatarByQQ()");
        new XxIo.oIX0oI(this.f26984a.oO()).Oo(activity, uri, iI0xO0);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setDynamicAvatar()");
        new XxIo.oIX0oI(this.f26984a.oO()).IXxxXO(activity, uri, iI0xO0);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "saveQQEmotions()");
        new oxIO0IIo.oIX0oI(this.f26984a.oO()).oO(activity, arrayList, iI0xO0);
    }

    public void setOpenId(String str) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setOpenId() --start");
        this.f26984a.x0xO0oo(XxXX.X0o0xo.oIX0oI(), str);
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "shareToQQ()");
        new QQShare(activity, this.f26984a.oO()).oI0IIXIo(activity, bundle, iI0xO0);
    }

    public void shareToQzone(Activity activity, Bundle bundle, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "shareToQzone()");
        new oo0oIXo.II0xO0(activity, this.f26984a.oO()).x0XOIxOo(activity, bundle, iI0xO0);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "startIMAio()");
        return startIMConversation(activity, OIxx0I0.oIX0oI.f1705oIX0oI, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "startIMAudio()");
        return startIMConversation(activity, OIxx0I0.oIX0oI.f1701II0xO0, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        return new OIxx0I0.oIX0oI(getQQToken()).ooOOo0oXI(activity, str, str2, str3);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "startIMVideo()");
        return startIMConversation(activity, OIxx0I0.oIX0oI.f1699I0Io, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "startMiniApp()");
        return new OooO0XOx.oIX0oI(getQQToken()).ooOOo0oXI(activity, OooO0XOx.oIX0oI.f2689oIX0oI, str, "21", str2, str3);
    }

    public int login(Activity activity, String str, II0xO0 iI0xO0, boolean z) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f26984a.X0o0xo(activity, str, iI0xO0, z);
    }

    public int loginServerSide(Fragment fragment, String str, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        return this.f26984a.Oxx0IOOO(fragment, str + ",server_side", iI0xO0, "");
    }

    public int login(Fragment fragment, String str, II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f26984a.Oxx0IOOO(fragment, str, iI0xO0, "");
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            try {
                XxXX.X0o0xo.II0xO0(context.getApplicationContext());
                xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
                Tencent tencent = c;
                if (tencent == null) {
                    c = new Tencent(str, context);
                } else if (!str.equals(tencent.getAppId())) {
                    c.logout(context);
                    c = new Tencent(str, context);
                }
                if (!a(context, str)) {
                    return null;
                }
                com.tencent.open.utils.oIX0oI.oxoX(context, str);
                xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "createInstance()  -- end");
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setAvatar(Activity activity, Bundle bundle, II0xO0 iI0xO0, int i, int i2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "setAvatar()");
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iI0xO0);
    }

    public int login(Fragment fragment, String str, II0xO0 iI0xO0, boolean z) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f26984a.II0XooXoX(fragment, str, iI0xO0, "", z);
    }
}
