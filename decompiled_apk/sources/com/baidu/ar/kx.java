package com.baidu.ar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes7.dex */
public class kx {
    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean b(File file, File file2) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            a(zipInputStream, file2);
            ko.closeQuietly(zipInputStream);
            return true;
        } catch (IOException e2) {
            e = e2;
            zipInputStream2 = zipInputStream;
            e.printStackTrace();
            ko.closeQuietly(zipInputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream2 = zipInputStream;
            ko.closeQuietly(zipInputStream2);
            throw th;
        }
    }

    public static boolean cr(String str) {
        boolean z;
        try {
            try {
                a(new ZipFile(str));
                z = true;
            } catch (IOException e) {
                e.printStackTrace();
                a(null);
                z = false;
            }
            return z;
        } catch (Throwable th) {
            a(null);
            throw th;
        }
    }

    private static void a(ZipInputStream zipInputStream, File file) {
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            String name = nextEntry.getName();
            if (name == null || !name.contains("../")) {
                File file2 = new File(file, name);
                km.e(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    ko.a(zipInputStream, file2);
                }
                zipInputStream.closeEntry();
            }
        }
    }
}
