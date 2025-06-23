package com.baidu.navisdk.module.business;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.k;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.v;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7059a = "c";

    public static boolean a() {
        String f = m0.j().f();
        if (TextUtils.isEmpty(f)) {
            return false;
        }
        try {
            File file = new File(f + File.separator + "navi_activity");
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
        return f + File.separator + "navi_activity";
    }

    public static Bitmap b(String str, String str2) {
        int lastIndexOf;
        String str3 = f7059a;
        LogUtil.e(str3, "loadBitmapCache() url=" + str);
        if (!a() && TextUtils.isEmpty(str)) {
            return null;
        }
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
                LogUtil.e(str3, "loadBitmapCache() fp=" + sb2);
                if (new File(sb2).exists()) {
                    LogUtil.e(str3, "loadBitmapCache() got it.");
                    return k.a(sb2);
                }
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String a(String str, String str2) {
        int lastIndexOf;
        String str3 = f7059a;
        LogUtil.e(str3, "getCacheFilePath() url=" + str);
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
                    LogUtil.e(str3, "getCacheFilePath() fp=" + sb2);
                    if (new File(sb2).exists()) {
                        LogUtil.e(str3, "getCacheFilePath() got it.");
                        return sb2;
                    }
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                    LogUtil.e(f7059a, "getCacheFilePath() Exception = " + e.toString());
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    public static String a(String str, String str2, byte[] bArr) {
        int lastIndexOf;
        FileOutputStream fileOutputStream;
        String str3 = f7059a;
        LogUtil.e(str3, "cacheFile() url=" + str);
        ?? r2 = 0;
        if (!a() && TextUtils.isEmpty(str)) {
            return null;
        }
        String b = b();
        if (!TextUtils.isEmpty(b) && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
            try {
                if (lastIndexOf < str.length() - 1) {
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
                        LogUtil.e(str3, "cacheFile() fp=" + sb2);
                        fileOutputStream = new FileOutputStream(sb2);
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused) {
                            }
                            return sb2;
                        } catch (Exception e) {
                            e = e;
                            if (LogUtil.LOGGABLE) {
                                e.printStackTrace();
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = str2;
            }
        }
        return null;
    }
}
