package com.baidu.platform.comapi.resource;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class a {
    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        if (inputStream != null && outputStream != null && bArr != null) {
            try {
                if (!(inputStream instanceof BufferedInputStream)) {
                    inputStream = new BufferedInputStream(inputStream);
                }
                if (!(outputStream instanceof BufferedOutputStream)) {
                    outputStream = new BufferedOutputStream(outputStream);
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        a(inputStream);
                        a(outputStream);
                        return;
                    }
                }
            } catch (Throwable th) {
                a(inputStream);
                a(outputStream);
                throw th;
            }
        } else {
            throw new IOException("copyStream : outputStream or inputStream is null");
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }
}
