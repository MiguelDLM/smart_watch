package com.baidu.ar.content;

import android.content.Context;
import com.baidu.ar.kf;
import com.baidu.ar.km;
import com.baidu.ar.ko;
import com.baidu.ar.kx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* loaded from: classes7.dex */
public class ARResourceManager {
    private static String nX = File.separator;
    private String nY;

    public ARResourceManager(Context context) {
        File file = new File(km.o(context), "sticker");
        if (!file.exists()) {
            file.mkdir();
        }
        this.nY = file.getAbsolutePath();
    }

    private String W(String str) {
        return this.nY.concat(nX).concat(str);
    }

    private void g(String str, String str2) {
        ZipFile zipFile;
        InputStream inputStream;
        File file = new File(str2);
        File file2 = new File(str);
        File file3 = new File(file + File.separator + "succeed.txt");
        if (file3.exists()) {
            file3.delete();
        }
        if (kx.cr(file2.getAbsolutePath())) {
            km.d(file);
            ZipFile zipFile2 = null;
            try {
                try {
                    zipFile = new ZipFile(str);
                } catch (ZipException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                kf.b("ARResourceManager", "unzip start");
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.getName().contains("../") && !nextElement.isDirectory()) {
                        File file4 = new File(str2, nextElement.getName());
                        if (!file4.getParentFile().exists()) {
                            file4.getParentFile().mkdirs();
                        }
                        kf.b("ARResourceManager", "file path =" + file4.getAbsolutePath() + ", parent path = " + file4.getParentFile().getAbsolutePath() + ", exists:" + file4.exists());
                        try {
                            try {
                                inputStream = zipFile.getInputStream(nextElement);
                            } catch (IOException e2) {
                                e = e2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            ko.a(inputStream, file4);
                            ko.closeQuietly(inputStream);
                        } catch (IOException e3) {
                            e = e3;
                            zipFile2 = inputStream;
                            e.printStackTrace();
                            ko.closeQuietly(zipFile2);
                            kx.a(zipFile);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            zipFile2 = inputStream;
                            ko.closeQuietly(zipFile2);
                            throw th;
                        }
                    }
                }
                kx.a(zipFile);
                try {
                    kf.b("ARResourceManager", "unzip end");
                    file3.createNewFile();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (ZipException e5) {
                e = e5;
                zipFile2 = zipFile;
                e.printStackTrace();
                kf.b("ARResourceManager", "unzip break !!!" + e.getMessage());
                kx.a(zipFile2);
            } catch (Throwable th4) {
                th = th4;
                zipFile2 = zipFile;
                kx.a(zipFile2);
                throw th;
            }
        }
    }

    public String getCaseDirPath(String str) {
        return W(String.format("bar_%s", str));
    }

    public String getCaseMainZipFile(ARResourceInfo aRResourceInfo) {
        return getCaseDirPath(aRResourceInfo.arKey) + String.format("/temp/main_%s.zip", aRResourceInfo.versionCode);
    }

    public String getCaseResourceDirPath(ARResourceInfo aRResourceInfo) {
        return getCaseDirPath(aRResourceInfo.arKey) + "/ar";
    }

    public boolean hasValidResource(ARResourceInfo aRResourceInfo, int i) {
        String caseMainZipFile = getCaseMainZipFile(aRResourceInfo);
        File file = new File(caseMainZipFile);
        return file.exists() && file.length() == ((long) i) && kx.cr(caseMainZipFile);
    }

    public String unzipResource(ARResourceInfo aRResourceInfo) {
        String caseMainZipFile = getCaseMainZipFile(aRResourceInfo);
        String caseDirPath = getCaseDirPath(aRResourceInfo.arKey);
        g(caseMainZipFile, caseDirPath);
        return caseDirPath;
    }

    public String unzipStepRes(String str, String str2) {
        String caseDirPath = getCaseDirPath(str2);
        g(str, caseDirPath);
        return caseDirPath;
    }

    public ARResourceManager(String str) {
        this.nY = str;
    }
}
