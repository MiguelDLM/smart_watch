package com.tenmeter.smlibrary.utils;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes13.dex */
public class ZipUtils {
    public static final String TAG = "ZIP";

    public static void UnZipFolder(String str, String str2) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    String str3 = File.separator;
                    sb.append(str3);
                    sb.append(substring);
                    File file = new File(sb.toString());
                    if (file.getCanonicalPath().startsWith(str2 + str3 + substring)) {
                        file.mkdirs();
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    String str4 = File.separator;
                    sb2.append(str4);
                    sb2.append(name);
                    Log.e(TAG, sb2.toString());
                    File file2 = new File(str2 + str4 + name);
                    if (file2.getCanonicalPath().startsWith(str2 + str4 + name)) {
                        if (!file2.exists()) {
                            Log.e(TAG, "Create the file:" + str2 + str4 + name);
                            file2.getParentFile().mkdirs();
                            file2.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                    }
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }
}
