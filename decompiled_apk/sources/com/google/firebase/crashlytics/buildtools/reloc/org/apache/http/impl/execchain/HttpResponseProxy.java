package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.execchain;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderIterator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolVersion;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.StatusLine;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.CloseableHttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes10.dex */
class HttpResponseProxy implements CloseableHttpResponse {
    private final ConnectionHolder connHolder;
    private final HttpResponse original;

    public HttpResponseProxy(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        this.original = httpResponse;
        this.connHolder = connectionHolder;
        ResponseEntityProxy.enchance(httpResponse, connectionHolder);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void addHeader(Header header) {
        this.original.addHeader(header);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            connectionHolder.close();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public boolean containsHeader(String str) {
        return this.original.containsHeader(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        return this.original.getAllHeaders();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public HttpEntity getEntity() {
        return this.original.getEntity();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public Header getFirstHeader(String str) {
        return this.original.getFirstHeader(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public Header[] getHeaders(String str) {
        return this.original.getHeaders(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public Header getLastHeader(String str) {
        return this.original.getLastHeader(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public Locale getLocale() {
        return this.original.getLocale();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        return this.original.getParams();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.original.getProtocolVersion();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public StatusLine getStatusLine() {
        return this.original.getStatusLine();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        return this.original.headerIterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void removeHeader(Header header) {
        this.original.removeHeader(header);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void removeHeaders(String str) {
        this.original.removeHeaders(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setEntity(HttpEntity httpEntity) {
        this.original.setEntity(httpEntity);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void setHeader(Header header) {
        this.original.setHeader(header);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void setHeaders(Header[] headerArr) {
        this.original.setHeaders(headerArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setLocale(Locale locale) {
        this.original.setLocale(locale);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.original.setParams(httpParams);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setReasonPhrase(String str) throws IllegalStateException {
        this.original.setReasonPhrase(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setStatusCode(int i) throws IllegalStateException {
        this.original.setStatusCode(i);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setStatusLine(StatusLine statusLine) {
        this.original.setStatusLine(statusLine);
    }

    public String toString() {
        return "HttpResponseProxy{" + this.original + '}';
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void addHeader(String str, String str2) {
        this.original.addHeader(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String str) {
        return this.original.headerIterator(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpMessage
    public void setHeader(String str, String str2) {
        this.original.setHeader(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion, int i) {
        this.original.setStatusLine(protocolVersion, i);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        this.original.setStatusLine(protocolVersion, i, str);
    }
}
