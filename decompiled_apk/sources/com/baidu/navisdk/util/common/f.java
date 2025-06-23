package com.baidu.navisdk.util.common;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.text.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9226a;

    @OOXIXo
    public static final f b = new f();

    static {
        String a2 = m0.j().a();
        IIX0o.oO(a2, "SysOSAPI.getInstance().GetModuleFileName()");
        f9226a = a2;
    }

    private f() {
    }

    private final boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "navi_cache";
        }
        String str2 = f9226a;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str2 + File.separator + str);
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

    @oOoXoXO
    public final String a(@oOoXoXO String str) {
        if (TextUtils.isEmpty(str)) {
            str = "navi_cache";
        }
        String str2 = f9226a;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + File.separator + str;
    }

    @oOoXoXO
    @xoIox
    public final String a(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO String str3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNFileCacheUtil", "createCacheFilePath() url=" + str + ", " + str2);
        }
        if (b(str2) && !TextUtils.isEmpty(str)) {
            String a2 = a(str2);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            IIX0o.ooOOo0oXI(str);
            int XIxO2 = StringsKt__StringsKt.XIxO(str, '.', 0, false, 6, null);
            if (XIxO2 >= 0 && XIxO2 < str.length() - 1) {
                try {
                    String substring = str.substring(XIxO2, str.length());
                    IIX0o.oO(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (TextUtils.isEmpty(substring)) {
                        return null;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = v.b(str);
                    }
                    String str4 = a2 + File.separator + str3 + substring;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BNFileCacheUtil", "createCacheFilePath() fp=" + str4);
                    }
                    return str4;
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        e.printStackTrace();
                    }
                    LogUtil.e("BNFileCacheUtil", "createCacheFilePath() Exception = " + e);
                }
            }
        }
        return null;
    }

    @oOoXoXO
    public final String b(@OOXIXo String url, @oOoXoXO String str, @OOXIXo String dirName) {
        IIX0o.x0xO0oo(url, "url");
        IIX0o.x0xO0oo(dirName, "dirName");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNFileCacheUtil", "getCacheUnzipDirPathByUrl() url=" + url + ", " + dirName);
        }
        if (b(dirName) && !TextUtils.isEmpty(url)) {
            String a2 = a(dirName);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            try {
                if (TextUtils.isEmpty(str)) {
                    str = v.b(url);
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String str2 = a2 + File.separator + str;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNFileCacheUtil", "getCacheUnzipDirPathByUrl() fp=" + str2);
                }
                File file = new File(str2);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        return str2;
                    }
                }
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.e("BNFileCacheUtil", "getCacheUnzipDirPathByUrl() Exception = " + e);
            }
        }
        return null;
    }

    @oOoXoXO
    @xoIox
    public final String a(@OOXIXo String filePath, @oOoXoXO String str) {
        int XIxO2;
        IIX0o.x0xO0oo(filePath, "filePath");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNFileCacheUtil", "createUnzipDirPath() filePath=" + filePath + ", " + str);
        }
        if (b(str) && !TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(a(str)) && (XIxO2 = StringsKt__StringsKt.XIxO(filePath, '.', 0, false, 6, null)) >= 0 && XIxO2 < filePath.length() - 1) {
            try {
                String substring = filePath.substring(0, XIxO2);
                IIX0o.oO(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (TextUtils.isEmpty(substring)) {
                    return null;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNFileCacheUtil", "createUnzipDirPath: " + substring);
                }
                File file = new File(substring);
                if (!file.exists()) {
                    file.mkdir();
                }
                return substring;
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                }
                LogUtil.e("BNFileCacheUtil", "createUnzipDirPath() Exception = " + e);
            }
        }
        return null;
    }

    @oOoXoXO
    @xoIox
    public final String a(@oOoXoXO File file, @oOoXoXO String str) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("unzip ");
            sb.append(file != null ? file.getPath() : null);
            LogUtil.e("BNFileCacheUtil", sb.toString());
        }
        if (file == null) {
            if (gVar.d()) {
                LogUtil.e("BNFileCacheUtil", "unzipPart : path or partName is null");
            }
            throw new IOException("unzipPart : path or partName is null");
        }
        String path = file.getPath();
        IIX0o.oO(path, "needUnzipFile.path");
        String a2 = a(path, str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            IIX0o.oO(nextElement, "zipList.nextElement()");
            ZipEntry zipEntry = nextElement;
            if (!zipEntry.isDirectory()) {
                String name = zipEntry.getName();
                IIX0o.oO(name, "ze.name");
                if (StringsKt__StringsKt.o00xOoIO(name, "../", false, 2, null)) {
                    continue;
                } else {
                    String zeName = zipEntry.getName();
                    IIX0o.oO(zeName, "zeName");
                    if (StringsKt__StringsKt.o00xOoIO(zeName, "/", false, 2, null)) {
                        Object[] array = StringsKt__StringsKt.XXoO0oX(zeName, new String[]{"/"}, false, 0, 6, null).toArray(new String[0]);
                        if (array != null) {
                            zeName = ((String[]) array)[r4.length - 1];
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    IIX0o.oO(zeName, "zeName");
                    if (!OxI.IOOoXo0Ix(zeName, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                        ZipUtils.writeToFile(new File(a2, zeName), zipFile.getInputStream(zipEntry));
                    }
                }
            }
        }
        zipFile.close();
        return a2;
    }
}
