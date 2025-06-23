package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.fb;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes10.dex */
public abstract class ax {
    public static String Code(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void Code(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                fb.I("StmUt", "close " + th.getClass().getSimpleName());
            }
        }
    }
}
