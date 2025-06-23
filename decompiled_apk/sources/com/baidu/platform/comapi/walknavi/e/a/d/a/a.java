package com.baidu.platform.comapi.walknavi.e.a.d.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public final class a {
    public static void a(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static void b(File file) {
        a(file, true);
    }

    public static boolean c(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static FileOutputStream d(File file) throws IOException {
        c(file);
        a(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static void a(File file, boolean z) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2, z);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }
}
