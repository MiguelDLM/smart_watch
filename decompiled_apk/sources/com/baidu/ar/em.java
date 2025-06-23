package com.baidu.ar;

import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.utils.URLEncodedUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes7.dex */
class em implements ev {
    private Charset rA;
    private StringBuilder rB = new StringBuilder();

    @Override // com.baidu.ar.ev
    public void a(Charset charset) {
        this.rA = charset;
    }

    @Override // com.baidu.ar.ev
    public InputStream[] dI() {
        return this.rB.length() > 0 ? new InputStream[]{new ByteArrayInputStream(this.rB.toString().getBytes(this.rA))} : new InputStream[0];
    }

    @Override // com.baidu.ar.ev
    public String getContentType() {
        return URLEncodedUtils.CONTENT_TYPE;
    }

    @Override // com.baidu.ar.ev
    public int getSize() {
        return 0;
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.rB.length() > 0) {
            this.rB.append("&");
        }
        StringBuilder sb = this.rB;
        sb.append(eu.a(str, this.rA));
        sb.append("=");
        sb.append(eu.a(str2, this.rA));
    }
}
