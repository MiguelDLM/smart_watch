package com.baidu.ar;

import android.text.TextUtils;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes7.dex */
class ez {
    private Charset rA = StandardCharsets.UTF_8;
    private String sf;
    private StringBuilder sg;

    public void a(Charset charset) {
        this.rA = charset;
    }

    public void aG(String str) {
        this.sf = str;
    }

    public URL dO() {
        String str = this.sf;
        if (str == null) {
            str = "";
        }
        StringBuilder sb = this.sg;
        if (sb != null && sb.length() > 0) {
            String str2 = LocationInfo.NA;
            if (str.contains(LocationInfo.NA)) {
                str2 = "&";
            }
            str = str + str2 + this.sg.toString();
        }
        return new URL(str);
    }

    public void m(String str, String str2) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = this.sg;
        if (sb == null) {
            this.sg = new StringBuilder();
        } else if (sb.length() > 0) {
            this.sg.append("&");
        }
        this.sg.append(eu.a(str, this.rA));
        this.sg.append("=");
        this.sg.append(eu.a(str2, this.rA));
    }
}
