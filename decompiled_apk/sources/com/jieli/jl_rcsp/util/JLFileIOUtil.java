package com.jieli.jl_rcsp.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class JLFileIOUtil {
    public static void isToFile(String str, InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                return;
            }
        }
    }
}
