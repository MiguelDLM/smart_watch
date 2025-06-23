package com.baidu.navisdk.debug;

import com.baidu.navisdk.util.common.LogUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes7.dex */
public class f {
    public static ZipOutputStream a(File file) throws FileNotFoundException {
        return new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    public static void a(File file, ZipOutputStream zipOutputStream, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        try {
            zipOutputStream.setLevel(6);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                zipOutputStream.putNextEntry(new ZipEntry(str));
                a(bufferedInputStream, zipOutputStream);
                a(bufferedInputStream);
            } catch (Throwable th) {
                th = th;
                a(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null && outputStream != null) {
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream);
            }
            if (!(outputStream instanceof BufferedOutputStream)) {
                outputStream = new BufferedOutputStream(outputStream);
            }
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } else {
            LogUtil.e("LogZipUtils", "copyStream : outputStream or inputStream is null");
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e("LogZipUtils", "closeQuietly closeable failed");
                return;
            }
        }
        LogUtil.e("LogZipUtils", "closeQuietly closeable is null");
    }
}
