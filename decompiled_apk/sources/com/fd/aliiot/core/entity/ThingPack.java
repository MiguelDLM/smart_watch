package com.fd.aliiot.core.entity;

/* loaded from: classes8.dex */
public class ThingPack<T> {
    private long id;
    private String method;
    private T params;
    private String version;

    public long getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public T getParams() {
        return this.params;
    }

    public String getVersion() {
        return this.version;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(T t) {
        this.params = t;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
