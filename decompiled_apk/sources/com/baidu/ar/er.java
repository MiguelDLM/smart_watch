package com.baidu.ar;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes7.dex */
class er {
    public String method;
    public Charset rS;
    public es rT;
    public Map<String, String> rU;
    public ev rV;
    private StringBuilder rW = new StringBuilder();
    public URL url;

    public void aB(String str) {
        this.rW.append(str + "\r\n");
    }

    public String dN() {
        return this.rW.toString();
    }

    public boolean hasError() {
        return this.rW.length() > 0;
    }
}
