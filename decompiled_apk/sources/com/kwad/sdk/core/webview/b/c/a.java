package com.kwad.sdk.core.webview.b.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes11.dex */
public final class a {
    public static String G(Context context, String str) {
        String bE = bE(context);
        if (TextUtils.isEmpty(bE)) {
            return null;
        }
        return bE + File.separator + str;
    }

    public static String H(Context context, String str) {
        String bE = bE(context);
        if (TextUtils.isEmpty(bE)) {
            return null;
        }
        return bE + File.separator + str + OTAManager.OTA_ZIP_SUFFIX;
    }

    public static String I(Context context, String str) {
        String bE = bE(context);
        if (TextUtils.isEmpty(bE)) {
            return null;
        }
        return bE + File.separator + str;
    }

    public static String J(Context context, String str) {
        String bE = bE(context);
        if (TextUtils.isEmpty(bE)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bE);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("_manifest_.json");
        return sb.toString();
    }

    private static File bD(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return new File("/data/data/" + context.getPackageName() + "/file/");
        }
        return filesDir;
    }

    private static String bE(Context context) {
        String str = bD(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File bF(Context context) {
        String bE = bE(context);
        if (TextUtils.isEmpty(bE)) {
            return null;
        }
        fd(bE);
        File file = new File(bE, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static void f(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String bE = bE(context);
            if (!new File(bE, name).getAbsolutePath().startsWith(bE)) {
                break;
            }
            if (nextEntry.isDirectory()) {
                if (!name.contains("../")) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                }
            } else {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }

    public static String fb(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.e.c.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static String fc(String str) {
        String str2;
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            if (pathSegments != null && pathSegments.size() > 0) {
                str2 = pathSegments.get(pathSegments.size() - 1);
            } else {
                str2 = null;
            }
            if (TextUtils.isEmpty(str2) || !str2.contains(OTAManager.OTA_ZIP_SUFFIX)) {
                return "";
            }
            return str2.substring(0, str2.indexOf(OTAManager.OTA_ZIP_SUFFIX));
        } catch (Throwable unused) {
            com.kwad.sdk.core.e.c.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean fd(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }
}
