package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes8.dex */
public final class b {
    public static void a(d dVar, ByteArrayOutputStream byteArrayOutputStream) {
        List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.f10632a;
        if (aVar != null && (list = aVar.f10629a) != null && list.size() > 0) {
            for (com.bytedance.pangle.util.b.b.c cVar : dVar.f10632a.f10629a) {
                c cVar2 = dVar.c;
                if (cVar != null) {
                    byte[] bArr = {0, 0};
                    cVar2.a((OutputStream) byteArrayOutputStream, 33639248);
                    cVar2.a(byteArrayOutputStream, 0);
                    cVar2.a(byteArrayOutputStream, 0);
                    cVar2.a(byteArrayOutputStream, 0);
                    cVar2.a(byteArrayOutputStream, cVar.f10631a);
                    cVar2.a(byteArrayOutputStream, 2081);
                    cVar2.a(byteArrayOutputStream, 545);
                    cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.b);
                    cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.c);
                    cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.d);
                    byte[] bArr2 = new byte[0];
                    String str = cVar.h;
                    if (str != null && str.trim().length() > 0) {
                        bArr2 = cVar.h.getBytes(Charset.forName("UTF-8"));
                    }
                    cVar2.a(byteArrayOutputStream, bArr2.length);
                    int i = cVar.f;
                    cVar2.a(byteArrayOutputStream, i);
                    cVar2.a(byteArrayOutputStream, 0);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bArr);
                    cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.i);
                    if (bArr2.length > 0) {
                        byteArrayOutputStream.write(bArr2);
                    }
                    if (i > 0) {
                        byteArrayOutputStream.write(new byte[i]);
                    }
                } else {
                    throw new IOException("input parameters is null, cannot write local file header");
                }
            }
        }
    }
}
