package XxXX;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.List;

/* loaded from: classes13.dex */
public class Oxx0IOOO {
    public static long I0Io(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                xx0.xxIXOIIO.oOoXoXO("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    public static boolean II0XooXoX() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", null).invoke(Environment.class, null)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static int II0xO0(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        if (split2.length <= i) {
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean OOXIXo(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->extractSecureLib, libName: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.SystemUtils"
            xx0.xxIXOIIO.oOoXoXO(r1, r0)
            android.content.Context r0 = XxXX.X0o0xo.oIX0oI()
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            xx0.xxIXOIIO.oOoXoXO(r1, r10)
            return r2
        L23:
            java.lang.String r3 = "secure_lib"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r2)
            java.io.File r4 = new java.io.File
            java.io.File r5 = r0.getFilesDir()
            r4.<init>(r5, r11)
            boolean r5 = r4.exists()
            r6 = 1
            java.lang.String r7 = "version"
            if (r5 != 0) goto L52
            java.io.File r5 = r4.getParentFile()
            if (r5 == 0) goto L75
            boolean r5 = r5.mkdirs()
            if (r5 == 0) goto L75
            r4.createNewFile()     // Catch: java.io.IOException -> L4d
            goto L75
        L4d:
            r4 = move-exception
            r4.printStackTrace()
            goto L75
        L52:
            int r4 = r3.getInt(r7, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "-->extractSecureLib, libVersion: "
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = " | oldVersion: "
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            xx0.xxIXOIIO.oOoXoXO(r1, r5)
            if (r12 != r4) goto L75
            return r6
        L75:
            r4 = 0
            android.content.res.AssetManager r5 = r0.getAssets()     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.io.InputStream r10 = r5.open(r10)     // Catch: java.lang.Throwable -> La6 java.lang.Exception -> La9
            java.io.FileOutputStream r4 = r0.openFileOutput(r11, r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> La1
            I0Io(r10, r4)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> La1
            android.content.SharedPreferences$Editor r11 = r3.edit()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> La1
            r11.putInt(r7, r12)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> La1
            r11.commit()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> La1
            if (r10 == 0) goto L96
            r10.close()     // Catch: java.io.IOException -> L95
            goto L96
        L95:
        L96:
            if (r4 == 0) goto L9b
            r4.close()     // Catch: java.io.IOException -> L9b
        L9b:
            return r6
        L9c:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto Lbe
        La1:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto Lab
        La6:
            r11 = move-exception
            r10 = r4
            goto Lbe
        La9:
            r11 = move-exception
            r10 = r4
        Lab:
            java.lang.String r12 = "-->extractSecureLib, when copy lib execption."
            xx0.xxIXOIIO.xxIXOIIO(r1, r12, r11)     // Catch: java.lang.Throwable -> Lbd
            if (r4 == 0) goto Lb7
            r4.close()     // Catch: java.io.IOException -> Lb6
            goto Lb7
        Lb6:
        Lb7:
            if (r10 == 0) goto Lbc
            r10.close()     // Catch: java.io.IOException -> Lbc
        Lbc:
            return r2
        Lbd:
            r11 = move-exception
        Lbe:
            if (r4 == 0) goto Lc5
            r4.close()     // Catch: java.io.IOException -> Lc4
            goto Lc5
        Lc4:
        Lc5:
            if (r10 == 0) goto Lca
            r10.close()     // Catch: java.io.IOException -> Lca
        Lca:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: XxXX.Oxx0IOOO.OOXIXo(java.lang.String, java.lang.String, int):boolean");
    }

    public static String Oxx0IOOO(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String X0o0xo(Activity activity, String str) {
        if (activity == null) {
            xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] oxoX2 = oxoX.oxoX(str);
            if (oxoX2 == null) {
                xx0.xxIXOIIO.II0XooXoX("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(oxoX2, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(oxoX2, 8, bArr2, 0, 16);
            return oxoX.II0xO0(activity.getPackageName(), oxoX.I0Io(bArr2), bArr);
        } catch (Exception e) {
            xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static String XO(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int oIX0oI(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return 10105;
        }
        if ("sendToMyComputer".equals(str)) {
            return 10106;
        }
        if ("shareToTroopBar".equals(str)) {
            return 10107;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        if ("action_request".equals(str)) {
            return 10100;
        }
        return -1;
    }

    public static boolean oO(Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29 || II0XooXoX()) {
            return false;
        }
        return true;
    }

    public static String oOoXoXO(Context context, String str) {
        xx0.xxIXOIIO.IXxxXO("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String oOoXoXO2 = com.tencent.open.utils.II0xO0.oOoXoXO(messageDigest.digest());
            messageDigest.reset();
            xx0.xxIXOIIO.IXxxXO("openSDK_LOG.SystemUtils", "-->sign: " + oOoXoXO2);
            messageDigest.update(com.tencent.open.utils.II0xO0.OI0(packageName + "_" + oOoXoXO2 + "_" + str + ""));
            str2 = com.tencent.open.utils.II0xO0.oOoXoXO(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            xx0.xxIXOIIO.IXxxXO("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            xx0.xxIXOIIO.xxIXOIIO("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static boolean ooOOo0oXI(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String oxoX(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }

    public static int x0XOIxOo(Context context, String str) {
        return II0xO0(Oxx0IOOO(context, "com.tencent.mobileqq"), str);
    }

    public static int x0xO0oo(Context context, String str) {
        return II0xO0(Oxx0IOOO(context, com.tencent.connect.common.II0xO0.f26800X0o0xo), str);
    }

    public static boolean xoIox(Context context, String str, String str2) {
        xx0.xxIXOIIO.IXxxXO("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (com.tencent.open.utils.II0xO0.IoOoX(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean xxIXOIIO(Context context, Intent intent) {
        if (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
            return false;
        }
        return true;
    }
}
