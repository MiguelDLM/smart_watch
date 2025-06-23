package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes10.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17364a = "ads_ModuleCopy";
    private static final int b = 2048;
    private static final String c = "file://";

    private static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            af.b(f17364a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i = 0;
        for (String str : strArr) {
            if (Integer.parseInt(str) > i) {
                i = Integer.parseInt(str);
            }
        }
        return i;
    }

    private static boolean b(Context context, Bundle bundle) {
        try {
            String a2 = a(context, bundle, bundle.getString("module_path"), bundle.getString(com.huawei.hms.ads.dynamicloader.b.k));
            if (TextUtils.isEmpty(a2)) {
                af.c(f17364a, "check Module Path failed: null.");
                return false;
            }
            bundle.putString("module_path", a2);
            return true;
        } catch (Throwable th) {
            af.c(f17364a, "copyOneModule err: " + th.getClass().getSimpleName());
            return false;
        }
    }

    private static String a(Context context, Bundle bundle, String str, String str2) {
        try {
            String string = bundle.getString("module_name");
            String valueOf = String.valueOf(bundle.getInt("module_version"));
            String str3 = string + com.huawei.hms.ads.dynamicloader.b.b;
            StringBuilder sb = new StringBuilder();
            sb.append(ad.a(context));
            String str4 = File.separator;
            sb.append(str4);
            sb.append(com.huawei.hms.ads.dynamicloader.b.f17277a);
            sb.append(str4);
            sb.append(string);
            String sb2 = sb.toString();
            String str5 = sb2 + str4 + valueOf;
            String str6 = str5 + str4 + str3;
            if (!new File(sb2).exists()) {
                af.b(f17364a, "checkModulePath file not exists.");
                return a(context, str5, str, str2, str6);
            }
            String[] list = new File(sb2).list();
            int a2 = a(list);
            af.b(f17364a, "checkModulePath maxVersion:" + a2 + ", version:" + valueOf);
            if (a2 < Integer.parseInt(valueOf)) {
                return a(context, str5, str, str2, str6);
            }
            String str7 = sb2 + str4 + a2 + str4 + str3;
            if (!new File(str7).exists()) {
                return a(context, str5, str, str2, str7);
            }
            w.a(a2, sb2, list, f17364a);
            return str7;
        } catch (Throwable th) {
            af.c(f17364a, "checkModulePath err: " + th.getClass().getSimpleName());
            return "";
        }
    }

    private static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            af.b(f17364a, "remote path is null.");
            return false;
        }
        if (!str.startsWith(c)) {
            str = c.concat(str);
        }
        return a(context, Uri.parse(str), str2);
    }

    private static String a(Context context, String str, String str2, String str3, String str4) {
        String str5;
        if (ad.a(str)) {
            a(context, str2, str3, str4);
            if (TextUtils.isEmpty(str4) || !new File(str4).exists()) {
                str5 = "ModuleFile filePath doesn't exist, or not accessible.";
            } else {
                if (!ac.a(context, str4) || ac.a(new File(str4), ad.c(str4)) == 0) {
                    return str4;
                }
                str5 = "Extract native to current dir failed.";
            }
        } else {
            str5 = "makeDirectory return false";
        }
        af.d(f17364a, str5);
        return null;
    }

    private static void a(Context context, String str, String str2, String str3) {
        boolean a2 = a(context, str2, str3);
        af.b(f17364a, "fromUri result:".concat(String.valueOf(a2)));
        if (a2) {
            return;
        }
        boolean a3 = a(str, str3);
        af.b(f17364a, "fromPath result:".concat(String.valueOf(a3)));
        if (a3) {
            return;
        }
        af.b(f17364a, "FromUriWithPrefix result:".concat(String.valueOf(b(context, str, str3))));
    }

    private static boolean a(Context context, Uri uri, String str) {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                if (openInputStream == null) {
                    af.c(f17364a, "get input stream failed: null.");
                    aj.a(openInputStream);
                    aj.a(null);
                    return false;
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = openInputStream.read(bArr);
                        if (read == -1) {
                            aj.a(openInputStream);
                            aj.a(bufferedOutputStream2);
                            return true;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    inputStream = openInputStream;
                    bufferedOutputStream = bufferedOutputStream2;
                    th = th;
                    try {
                        af.d(f17364a, "ModuleFromUri exception:" + th.getClass().getSimpleName());
                        return false;
                    } finally {
                        aj.a(inputStream);
                        aj.a(bufferedOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        if (context != null && bundle != null) {
            return b(context, bundle);
        }
        af.d(f17364a, "The context or module info bundle is null.");
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return a(context, Uri.parse(str), str2);
        }
        af.b(f17364a, "remote uri is null.");
        return false;
    }

    private static boolean a(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    aj.a(bufferedInputStream);
                    aj.a(bufferedOutputStream);
                    return true;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            try {
                af.d(f17364a, "ModuleFromPath exception:" + th.getClass().getSimpleName());
                return false;
            } finally {
                aj.a(bufferedInputStream2);
                aj.a(bufferedOutputStream);
            }
        }
    }
}
