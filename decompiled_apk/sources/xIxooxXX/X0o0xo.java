package xIxooxXX;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.util.Iterator;
import xox.oO;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public II0xO0 f34407II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public oIX0oI f34408oIX0oI;

    public X0o0xo(String str, Context context) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f34407II0xO0 = new II0xO0(str);
        this.f34408oIX0oI = new oIX0oI(this.f34407II0xO0);
        oO.oxoX(context, this.f34407II0xO0);
        OOXIXo(context, com.tencent.connect.common.II0xO0.f26901xoIox);
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static void OOXIXo(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("bcb3903995", str);
        edit.apply();
    }

    public static X0o0xo xxIXOIIO(String str, Context context) {
        XxXX.X0o0xo.II0xO0(context.getApplicationContext());
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            X0o0xo x0o0xo = new X0o0xo(str, context);
            xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
            return x0o0xo;
        } catch (PackageManager.NameNotFoundException e) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.QQAuth", "createInstance() error --end", e);
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }

    public int I0Io(Activity activity, String str, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "login()");
        return oxoX(activity, str, iI0xO0, "");
    }

    public int II0XooXoX(Fragment fragment, String str, o0Oo.II0xO0 iI0xO0, String str2, boolean z) {
        FragmentActivity activity = fragment.getActivity();
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return II0xO0(activity, fragment, str, iI0xO0, str2, z);
    }

    public final int II0xO0(Activity activity, Fragment fragment, String str, o0Oo.II0xO0 iI0xO0, String str2, boolean z) {
        String str3;
        String packageName = activity.getApplicationContext().getPackageName();
        try {
            Iterator<ApplicationInfo> it = activity.getPackageManager().getInstalledApplications(128).iterator();
            while (true) {
                if (it.hasNext()) {
                    ApplicationInfo next = it.next();
                    if (packageName.equals(next.packageName)) {
                        str3 = next.sourceDir;
                        break;
                    }
                } else {
                    str3 = null;
                    break;
                }
            }
            if (str3 != null) {
                String II0xO02 = XxXX.oIX0oI.II0xO0(new File(str3));
                if (!TextUtils.isEmpty(II0xO02)) {
                    xxIXOIIO.IXxxXO("openSDK_LOG.QQAuth", "-->login channelId: " + II0xO02);
                    return XO(activity, str, iI0xO0, z, II0xO02, II0xO02, "");
                }
            }
        } catch (Throwable th) {
            xxIXOIIO.xxIXOIIO("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
            th.printStackTrace();
        }
        xxIXOIIO.XO("openSDK_LOG.QQAuth", "-->login channelId is null ");
        com.tencent.connect.common.oIX0oI.isOEM = false;
        return this.f34408oIX0oI.OxI(activity, str, iI0xO0, false, fragment, z);
    }

    public boolean Oo() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        if (this.f34407II0xO0.xoIox()) {
            str = "true";
        } else {
            str = "false";
        }
        sb.append(str);
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", sb.toString());
        return this.f34407II0xO0.xoIox();
    }

    public int Oxx0IOOO(Fragment fragment, String str, o0Oo.II0xO0 iI0xO0, String str2) {
        FragmentActivity activity = fragment.getActivity();
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return oIX0oI(activity, fragment, str, iI0xO0, str2);
    }

    public int X0o0xo(Activity activity, String str, o0Oo.II0xO0 iI0xO0, boolean z) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "login()");
        return II0xO0(activity, null, str, iI0xO0, "", z);
    }

    @Deprecated
    public int XO(Activity activity, String str, o0Oo.II0xO0 iI0xO0, boolean z, String str2, String str3, String str4) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "loginWithOEM");
        com.tencent.connect.common.oIX0oI.isOEM = true;
        if (str2.equals("")) {
            str2 = "null";
        }
        if (str3.equals("")) {
            str3 = "null";
        }
        if (str4.equals("")) {
            str4 = "null";
        }
        com.tencent.connect.common.oIX0oI.installChannel = str3;
        com.tencent.connect.common.oIX0oI.registerChannel = str2;
        com.tencent.connect.common.oIX0oI.businessId = str4;
        return this.f34408oIX0oI.OxI(activity, str, iI0xO0, false, null, z);
    }

    public final int oIX0oI(Activity activity, Fragment fragment, String str, o0Oo.II0xO0 iI0xO0, String str2) {
        return II0xO0(activity, fragment, str, iI0xO0, str2, false);
    }

    public II0xO0 oO() {
        return this.f34407II0xO0;
    }

    public void oOoXoXO(String str, String str2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f34407II0xO0.x0XOIxOo(str, str2);
    }

    public void ooOOo0oXI(o0Oo.II0xO0 iI0xO0) {
        this.f34408oIX0oI.oI0IIXIo(iI0xO0);
    }

    public int oxoX(Activity activity, String str, o0Oo.II0xO0 iI0xO0, String str2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return oIX0oI(activity, null, str, iI0xO0, str2);
    }

    public int x0XOIxOo(Activity activity, String str, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "reAuth()");
        return this.f34408oIX0oI.o00(activity, str, iI0xO0, true, null);
    }

    public void x0xO0oo(Context context, String str) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f34407II0xO0.Oo(str);
        oO.X0o0xo(context, this.f34407II0xO0);
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public void xoIox() {
        this.f34408oIX0oI.Oo(null);
    }
}
