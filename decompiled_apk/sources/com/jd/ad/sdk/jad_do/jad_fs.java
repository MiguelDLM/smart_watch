package com.jd.ad.sdk.jad_do;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_fs {
    public static byte[] jad_an(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
