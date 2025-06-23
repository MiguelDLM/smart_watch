package com.iflytek.sparkchain.core;

import android.annotation.SuppressLint;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes10.dex */
public class AiUrl {
    boolean ssl;
    String url;

    /* loaded from: classes10.dex */
    public static class Builder {
        String url;
        boolean ssl = false;
        int port = 0;

        public AiUrl build() {
            return new AiUrl(this);
        }

        public Builder port(int i) {
            this.port = i;
            return this;
        }

        public Builder ssl(boolean z) {
            this.ssl = z;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    private AiUrl(Builder builder) {
        this.url = builder.url;
        this.ssl = builder.ssl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isSsl() {
        return this.ssl;
    }

    @SuppressLint({"DefaultLocale"})
    public String toJson(String str) throws MalformedURLException {
        URL url = new URL(this.url);
        StringBuilder sb = new StringBuilder("{");
        String format = String.format("{\"host\":\"%s\",\"path\":\"%s\",\"ssl\":%s,\"port\":%d}", url.getHost(), url.getPath(), url.getProtocol().equals("https") ? "true" : "false", Integer.valueOf(url.getPort() > 0 ? url.getPort() : url.getDefaultPort()));
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        sb.append(":");
        sb.append(format);
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }
}
