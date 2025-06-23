package com.huawei.openalliance.ad.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jm;
import com.huawei.hms.ads.jn;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.net.URISyntaxException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class g {
    private static final String Code = "ApkUtil";
    private static final Map<String, List<String>> V;

    static {
        HashMap hashMap = new HashMap();
        V = hashMap;
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        hashMap.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        hashMap.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static boolean B(Context context, String str) {
        return Code(V.get(str), Z(context, str));
    }

    public static ApplicationInfo C(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getApplicationInfo(str, 128);
            }
            fb.V(Code, "pm is null");
            return null;
        } catch (Throwable th) {
            fb.I(Code, "getApplicationInfo " + th.getClass().getSimpleName());
            return null;
        }
    }

    public static Intent Code(Context context, String str, String str2) {
        String str3;
        PackageManager packageManager;
        try {
            if (!TextUtils.isEmpty(str) && (packageManager = context.getPackageManager()) != null) {
                Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
                if (!Code(parseUri, str2)) {
                    return null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    parseUri.setPackage(str2);
                }
                if (parseUri.getData() != null) {
                    parseUri = parseUri.setDataAndTypeAndNormalize(parseUri.getData(), parseUri.getType());
                }
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(parseUri, 0);
                if (!Code(queryIntentActivities)) {
                    fb.I(Code, "parseAndCheckIntent, activity not exists or not exported.");
                    return null;
                }
                if (ed.Code(context).S(parseUri.getPackage())) {
                    Code(parseUri);
                }
                if (!queryIntentActivities.isEmpty() || !Code()) {
                    return parseUri;
                }
            }
        } catch (URISyntaxException unused) {
            str3 = "parseAndCheckIntent, parse uri fail";
            fb.I(Code, str3);
            return null;
        } catch (Exception unused2) {
            str3 = "handle intent url fail";
            fb.I(Code, str3);
            return null;
        }
        return null;
    }

    public static int I(Context context, String str) {
        try {
            PackageInfo V2 = V(context, str);
            if (V2 == null) {
                return 0;
            }
            return V2.versionCode;
        } catch (AndroidRuntimeException | Exception unused) {
            fb.I(Code, "getAppVersionCode fail");
            return 0;
        }
    }

    private static byte[] S(Context context, String str) {
        String str2;
        PackageInfo packageInfo;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr.length > 0) {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                        try {
                            byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getEncoded();
                            ax.Code((Closeable) byteArrayInputStream2);
                            return encoded;
                        } catch (RuntimeException e) {
                            e = e;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes RuntimeException:" + e.getClass().getSimpleName();
                            fb.Z(Code, str2);
                            ax.Code((Closeable) byteArrayInputStream);
                            fb.V(Code, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes Exception:" + e.getClass().getSimpleName();
                            fb.Z(Code, str2);
                            ax.Code((Closeable) byteArrayInputStream);
                            fb.V(Code, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream2;
                            ax.Code((Closeable) byteArrayInputStream);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (RuntimeException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
        ax.Code((Closeable) byteArrayInputStream);
        fb.V(Code, "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public static PackageInfo V(Context context, String str) {
        String str2;
        if (fb.Code()) {
            fb.Code(Code, "getPackageInfo, packageName:%s", str);
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            fb.I(Code, str2);
            return null;
        } catch (Throwable unused2) {
            str2 = "getPackageInfo Exception";
            fb.I(Code, str2);
            return null;
        }
    }

    public static String Z(Context context, String str) {
        byte[] S = S(context, str);
        if (S == null || S.length == 0) {
            return null;
        }
        return v.Code(au.Code(S));
    }

    public static String Code(Context context, Intent intent) {
        ActivityInfo activityInfo;
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) {
            return null;
        }
        return activityInfo.packageName;
    }

    public static String I(Context context) {
        if (Code(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        return Code(context, "com.huawei.hms") ? "com.huawei.hms" : Code(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    public static String V(Context context) {
        String I = I(context);
        if (TextUtils.isEmpty(I)) {
            return null;
        }
        if (Code(V.get(I), Z(context, I))) {
            return I;
        }
        return null;
    }

    public static void Code(Context context, Intent intent, jn jnVar) {
        if (jnVar != null && ay.Code(jnVar.I())) {
            jnVar.I(Code(context, intent));
        }
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(com.huawei.openalliance.ad.constant.x.cM);
            context.startActivity(intent);
            jm.Code(context, jnVar);
        } catch (Throwable th) {
            fb.I(Code, "start activity error");
            cy.Code(context, jnVar, th.getMessage());
        }
    }

    public static boolean V() {
        try {
            return ((Boolean) Class.forName("com.huawei.openalliance.ad.ppskit.utils.AdsCoreScopeUtil").getMethod("isScopePrime", null).invoke(null, null)).booleanValue();
        } catch (Throwable unused) {
            fb.V(Code, "AdsCoreScopeUtil wrapper not found");
            fb.Code(Code, "is prime sdk: %s.", Boolean.FALSE);
            return false;
        }
    }

    public static void Code(Intent intent) {
        intent.addFlags(536870912);
        intent.addFlags(32768);
        fb.V(Code, "addFlagsToIntent: Success");
    }

    public static boolean Code() {
        return Build.VERSION.SDK_INT <= 29 || !V();
    }

    public static boolean Code(Context context) {
        return !TextUtils.isEmpty(V(context));
    }

    public static boolean Code(Context context, String str) {
        return V(context, str) != null;
    }

    public static boolean Code(Context context, String str, jn jnVar) {
        Intent launchIntentForPackage;
        fb.V(Code, "open app main page");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(str)) == null) {
            return false;
        }
        launchIntentForPackage.addFlags(268435456);
        launchIntentForPackage.setPackage(str);
        if (jnVar != null) {
            jnVar.Z(null);
        }
        Code(context, launchIntentForPackage, jnVar);
        return true;
    }

    public static boolean Code(Context context, String str, String str2, jn jnVar) {
        String str3;
        Intent Code2;
        fb.V(Code, "openApp intent");
        try {
            if (context.getPackageManager() == null || (Code2 = Code(context, str2, str)) == null) {
                return false;
            }
            Code2.addFlags(268435456);
            if (jnVar == null) {
                return true;
            }
            jnVar.Code(Code2);
            Code(context, Code2, jnVar);
            return true;
        } catch (ActivityNotFoundException unused) {
            str3 = "activity not exist";
            fb.I(Code, str3);
            return false;
        } catch (Exception unused2) {
            str3 = "handle intent url fail";
            fb.I(Code, str3);
            return false;
        }
    }

    private static boolean Code(Intent intent, String str) {
        ComponentName component;
        if (intent == null || TextUtils.isEmpty(str) || (component = intent.getComponent()) == null) {
            return true;
        }
        String packageName = component.getPackageName();
        return TextUtils.isEmpty(packageName) || str.equalsIgnoreCase(packageName);
    }

    public static boolean Code(String str) {
        return "com.huawei.hwid".equals(str) || "com.huawei.hms".equals(str) || "com.huawei.hwid.tv".equals(str);
    }

    private static boolean Code(List<ResolveInfo> list) {
        if (ad.Code(list)) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!it.next().activityInfo.exported) {
                z = false;
            }
        }
        return z;
    }

    private static boolean Code(List<String> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
