package com.baidu.mshield.utility;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f6393a = {"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "8aRmj9NoeaLTFLe54rCmNLYIZoWE7hrVdjvM3xBfHQ4=", "WtGvBTWjt2PyMX5rQclkgiNR3aDxFtoBNe1UnNpbL1I="};

    public static Bundle a(Context context, String str, Bundle bundle) {
        return a(context, str, bundle, "mshield");
    }

    public static Bundle a(Context context, String str, Bundle bundle, boolean z, String str2, boolean z2) {
        ProviderInfo[] providerInfoArr;
        String str3;
        try {
            try {
                providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            } catch (Throwable th) {
                a.a(th);
                providerInfoArr = null;
            }
        } catch (Throwable th2) {
            a.a(th2);
        }
        if (providerInfoArr != null && providerInfoArr.length > 0) {
            boolean z3 = false;
            for (String str4 : f6393a) {
                try {
                    str3 = new String(com.baidu.mshield.b.f.d.b(Base64.decode(str4, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");
                } catch (Throwable th3) {
                    a.a(th3);
                    str3 = null;
                }
                if (!TextUtils.isEmpty(str3)) {
                    if ("mshield".equals(str3)) {
                        if (!z) {
                            return null;
                        }
                        z3 = true;
                    }
                    StringBuilder sb = new StringBuilder("content://");
                    sb.append(context.getPackageName());
                    sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                    sb.append(str3);
                    sb.append(".ac.provider");
                    String sb2 = sb.toString();
                    com.baidu.mshield.b.c.a.b("request targetUri=" + sb2);
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        String str5 = providerInfo.authority;
                        com.baidu.mshield.b.c.a.b("request authority=" + str5);
                        if (sb2.contains(str5)) {
                            Bundle a2 = a(context, str, bundle, Uri.parse(sb.toString()));
                            if (!z2) {
                                return a2;
                            }
                            boolean z4 = a2.getBoolean("handle_flag");
                            String string = a2.getString("server_version");
                            if (z4) {
                                if (a(string, str2)) {
                                    return a2;
                                }
                            }
                        }
                    }
                    if (z3) {
                        break;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static Bundle a(Context context, String str, Bundle bundle, String str2) {
        try {
            context.getApplicationContext().getContentResolver();
            return a(context, str, bundle, Uri.parse("content://" + context.getPackageName() + FileUtils.FILE_EXTENSION_SEPARATOR + str2 + ".ac.provider"));
        } catch (Throwable th) {
            a.a(th);
            return null;
        }
    }

    public static Bundle a(Context context, String str, Bundle bundle, Uri uri) {
        ContentProviderClient contentProviderClient;
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            int i = Build.VERSION.SDK_INT;
            try {
                contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                try {
                    Bundle call = contentProviderClient.call(str, null, bundle);
                    if (i < 24) {
                        contentProviderClient.release();
                    } else {
                        contentProviderClient.release();
                    }
                    return call;
                } catch (Throwable th) {
                    th = th;
                    try {
                        a.a(th);
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT < 24) {
                                contentProviderClient.release();
                            } else {
                                contentProviderClient.release();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (contentProviderClient != null) {
                            if (Build.VERSION.SDK_INT < 24) {
                                contentProviderClient.release();
                            } else {
                                contentProviderClient.release();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                contentProviderClient = null;
            }
        } catch (Throwable th4) {
            a.a(th4);
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        try {
            if (str.equals(str2)) {
                return true;
            }
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i = 0; i < split.length && i < split2.length; i++) {
                int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
                if (intValue != 0) {
                    return intValue > 0;
                }
            }
            return split.length > split2.length;
        } catch (Throwable unused) {
            return false;
        }
    }
}
