package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class i4 {

    /* renamed from: a, reason: collision with root package name */
    public URI f10110a = null;

    public abstract void a(int i, Map<String, List<String>> map, String str, byte[] bArr);

    public abstract void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th);

    public void a(d4 d4Var) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        LoggerProxy.d("TtsResponseHandler", "response: " + d4Var.d);
        int i = d4Var.d;
        Map<String, List<String>> map = d4Var.c;
        String str = d4Var.e;
        try {
            InputStream inputStream = d4Var.b;
            if (inputStream == null) {
                throw new IllegalStateException("response getInputstream is null");
            }
            if (i == 200) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedInputStream.close();
                        a(i, map, str, byteArrayOutputStream.toByteArray());
                        return;
                    }
                }
            } else {
                LoggerProxy.d("TtsResponseHandler", "request fail statusCode: " + i);
                a(i, map, d4Var.e, null, null);
            }
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            e.printStackTrace();
            a(i, d4Var.c, d4Var.e, null, e);
        }
    }
}
