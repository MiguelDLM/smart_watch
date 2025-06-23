package com.huawei.hms.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.huawei.hms.ads.base.R;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class jj {
    private static final int B = 1;
    private static final int C = 110002100;
    private static final String Code = "HwCustomTabsHelper";
    private static final String D = "com.huawei.browser.cct_page_can_go_back";
    private static final String F = "com.huawei.browser.cct_only_show_title";
    private static final String I = "com.android.browser";
    private static final String L = "com.huawei.browser.cct_horizontal_menu_items";
    private static final int S = 110008300;
    private static final String V = "com.huawei.browser";
    private static final String Z = "cct_extension_version";

    /* renamed from: a, reason: collision with root package name */
    private static final String f17309a = "com.huawei.browser.cct_vertical_menu_items";
    private static final String b = "com.huawei.browser.cct_auto_refresh";
    private static final String c = "com.huawei.browser.cct_emui_style";
    private static final String d = "com.huawei.browser.cct_enable_pps";
    private static final String e = "com.huawei.browser.cct_show_open_in_browser_menu";
    private static final String f = "com.huawei.browser.cct_copy_link";
    private static final String g = "com.huawei.browser.cct_tranlate_disable";
    private static final jj h = new jj();

    private jj() {
    }

    private static boolean B(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        if (!Code(context, "com.android.browser", S)) {
            fb.V(Code, "isSupportAndroidCustomizedCustom current browser no support");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.android.browser", 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                int i = bundle != null ? bundle.getInt(Z, 0) : 0;
                fb.V(Code, "isSupportAndroidCustomizedCustom: " + i);
                return i >= 1;
            }
        } catch (Throwable unused) {
            fb.Z(Code, "getApplicationInfo failed due to name not found");
        }
        return false;
    }

    private CustomTabsIntent Code(@NonNull Activity activity, boolean z) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(V());
        CustomTabsIntent build = builder.build();
        builder.setCloseButtonIcon(BitmapFactory.decodeResource(activity.getResources(), R.drawable.hiad_hm_close_btn));
        builder.addDefaultShareMenuItem();
        build.intent.putExtra(F, true);
        build.intent.putExtra(D, true);
        build.intent.putExtra(b, true);
        build.intent.putExtra(c, true);
        build.intent.putExtra(e, false);
        build.intent.putExtra(d, z);
        build.intent.putExtra(f, true);
        build.intent.putExtra(g, true);
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add(jk.REFRESH.Code());
        build.intent.putStringArrayListExtra(f17309a, arrayList);
        build.intent.putStringArrayListExtra(L, new ArrayList<>(10));
        return build;
    }

    private static boolean I(@NonNull Context context) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("com.huawei.browser");
        return "com.huawei.browser".equals(CustomTabsClient.getPackageName(context, arrayList, true)) && Code(context, "com.huawei.browser", C);
    }

    private static Activity V(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return V(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static boolean Z(@NonNull Context context) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("com.android.browser");
        return "com.android.browser".equals(CustomTabsClient.getPackageName(context, arrayList, true)) && B(context);
    }

    public static synchronized jj Code() {
        jj jjVar;
        synchronized (jj.class) {
            jjVar = h;
        }
        return jjVar;
    }

    public CustomTabsSession V() {
        return null;
    }

    public void Code(@NonNull Context context, @NonNull Uri uri, boolean z) {
        fb.Code(Code, "openCustomTab begin");
        Activity V2 = V(context);
        boolean I2 = I(V2);
        CustomTabsIntent Code2 = Code(V2, z);
        Code2.intent.setPackage(I2 ? "com.huawei.browser" : "com.android.browser");
        Code2.intent.setData(uri);
        try {
            Intent intent = Code2.intent;
            if (intent != null) {
                intent.setClipData(com.huawei.openalliance.ad.constant.x.cM);
            }
            V2.startActivityForResult(Code2.intent, 0);
        } catch (ActivityNotFoundException unused) {
            fb.Z(Code, "openCustomTab ActivityNotFoundException");
        }
    }

    public static boolean Code(@NonNull Context context) {
        try {
            if (!I(context)) {
                if (!Z(context)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            fb.I(Code, "not support customTab");
            return false;
        }
    }

    private static boolean Code(@NonNull Context context, String str, int i) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
            return (packageInfo != null ? packageInfo.versionCode : 0) >= i;
        } catch (PackageManager.NameNotFoundException unused) {
            fb.Z(Code, "getTargetApkInfo failed due to name not found");
            return false;
        } catch (Throwable th) {
            fb.I(Code, "getTargetApkInfo ex: %s", th.getClass().getSimpleName());
            return false;
        }
    }
}
