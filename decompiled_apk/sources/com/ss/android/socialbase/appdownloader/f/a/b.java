package com.ss.android.socialbase.appdownloader.f.a;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.IOException;

/* loaded from: classes13.dex */
public class b {
    public static final void a(d dVar, int i) throws IOException {
        int b = dVar.b();
        if (b == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(b) + FileUtils.FILE_EXTENSION_SEPARATOR);
    }
}
