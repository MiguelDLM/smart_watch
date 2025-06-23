package com.baidu.navisdk.module.carlogo;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.v;
import java.io.File;

/* loaded from: classes7.dex */
public class a {
    public static boolean a() {
        String f = m0.j().f();
        if (TextUtils.isEmpty(f)) {
            return false;
        }
        try {
            File file = new File(f + File.separator + "navi_car_logo");
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static String b() {
        String f = m0.j().f();
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        return f + File.separator + "navi_car_logo";
    }

    public static String c(String str, String str2) {
        int lastIndexOf;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarLogoFileCache", "getCacheUnzipDirPathByUrl() url=" + str);
        }
        if (a() && !TextUtils.isEmpty(str)) {
            String b = b();
            if (!TextUtils.isEmpty(b) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                try {
                    if (TextUtils.isEmpty(str.substring(lastIndexOf, str.length()))) {
                        return null;
                    }
                    String b2 = v.b(str);
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(b);
                    sb.append(File.separator);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "";
                    }
                    sb.append(str2);
                    sb.append(b2);
                    String sb2 = sb.toString();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("CarLogoFileCache", "getCacheUnzipDirPathByUrl() fp=" + sb2);
                    }
                    File file = new File(sb2);
                    if (file.exists()) {
                        if (file.isDirectory()) {
                            return sb2;
                        }
                    }
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                    LogUtil.e("CarLogoFileCache", "getCacheUnzipDirPathByUrl() Exception = " + e.toString());
                }
            }
        }
        return null;
    }

    public static String b(String str, String str2) {
        int lastIndexOf;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarLogoFileCache", "createUnzipDirPath() filePath=" + str);
        }
        if (a() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(b()) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
            try {
                String substring = str.substring(0, lastIndexOf);
                if (TextUtils.isEmpty(substring)) {
                    return null;
                }
                String str3 = substring + str2;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("CarLogoFileCache", "createUnzipDirPath: " + str3);
                }
                s.a(str3);
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdir();
                }
                return str3;
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.e("CarLogoFileCache", "createUnzipDirPath() Exception = " + e.toString());
            }
        }
        return null;
    }

    public static String a(String str, String str2) {
        int lastIndexOf;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarLogoFileCache", "createCacheFilePath() url=" + str);
        }
        if (a() && !TextUtils.isEmpty(str)) {
            String b = b();
            if (!TextUtils.isEmpty(b) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                try {
                    String substring = str.substring(lastIndexOf, str.length());
                    if (TextUtils.isEmpty(substring)) {
                        return null;
                    }
                    String b2 = v.b(str);
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(b);
                    sb.append(File.separator);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "";
                    }
                    sb.append(str2);
                    sb.append(b2);
                    sb.append(substring);
                    String sb2 = sb.toString();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("CarLogoFileCache", "createCacheFilePath() fp=" + sb2);
                    }
                    return sb2;
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                    LogUtil.e("CarLogoFileCache", "createCacheFilePath() Exception = " + e.toString());
                }
            }
        }
        return null;
    }
}
