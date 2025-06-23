package com.baidu.ar;

import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes7.dex */
interface ev {
    void a(Charset charset);

    InputStream[] dI();

    String getContentType();

    int getSize();
}
