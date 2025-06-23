package com.alimm.tanx.core.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class ZipUtils implements NotConfused {
    public static void main(String[] strArr) throws Exception {
        unZip("D:/test.zip", "D:/a");
    }

    private static void mkdir(File file) {
        if (file != null && !file.exists()) {
            mkdir(file.getParentFile());
            file.mkdir();
        }
    }

    public static void unZip(String str, String str2) throws Exception {
        File file = new File(str2);
        if (!file.exists() && !file.mkdir()) {
            throw new Exception("创建解压目标文件夹失败");
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            if (nextEntry.isDirectory()) {
                mkdir(new File(str2 + File.separator + nextEntry.getName()));
            } else {
                String str3 = str2 + File.separator + nextEntry.getName();
                mkdir(new File(str3).getParentFile());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.close();
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
    }
}
