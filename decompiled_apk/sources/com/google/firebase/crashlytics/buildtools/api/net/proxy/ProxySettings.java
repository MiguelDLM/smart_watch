package com.google.firebase.crashlytics.buildtools.api.net.proxy;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthScope;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.UsernamePasswordCredentials;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.RequestConfig;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.BasicCredentialsProvider;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.HttpClients;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ProxySettings {
    private final String _proxyHost;
    private final String _proxyPassword;
    private final Integer _proxyPort;
    private final String _proxyUser;

    public ProxySettings(String str, Integer num, String str2, String str3) {
        this._proxyHost = str;
        this._proxyPort = num;
        this._proxyUser = str2;
        this._proxyPassword = str3;
    }

    public HttpClient getClientFor() throws IOException {
        if (this._proxyHost != null && this._proxyPort != null && this._proxyUser != null && this._proxyPassword != null) {
            Buildtools.logD("Crashlytics using proxy auth:" + this._proxyUser);
            BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
            basicCredentialsProvider.setCredentials(new AuthScope(this._proxyHost, this._proxyPort.intValue()), new UsernamePasswordCredentials(this._proxyUser, this._proxyPassword));
            return HttpClients.custom().setDefaultCredentialsProvider(basicCredentialsProvider).build();
        }
        return HttpClients.createDefault();
    }

    public RequestConfig getConfig() {
        if (this._proxyHost != null && this._proxyPort != null) {
            Buildtools.logD("Crashlytics using custom proxy settings: " + this._proxyHost + ":" + this._proxyPort);
            return RequestConfig.custom().setProxy(new HttpHost(this._proxyHost, this._proxyPort.intValue())).build();
        }
        return RequestConfig.DEFAULT;
    }
}
