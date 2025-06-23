package com.baidu.mobads.sdk.api;

import javax.lang.model.element.Element;

/* loaded from: classes7.dex */
public class RouteInfo {
    private Class<?> destination;
    private String path;
    private Element rawType;

    public RouteInfo() {
    }

    public static RouteInfo build(Class<?> cls, String str) {
        return new RouteInfo(cls, str);
    }

    public Class<?> getDestination() {
        return this.destination;
    }

    public String getPath() {
        return this.path;
    }

    public Element getRawType() {
        return this.rawType;
    }

    public RouteInfo setDestination(Class<?> cls) {
        this.destination = cls;
        return this;
    }

    public RouteInfo setPath(String str) {
        this.path = str;
        return this;
    }

    public RouteInfo(Class<?> cls, String str) {
        this.destination = cls;
        this.path = str;
    }

    public RouteInfo(Element element, String str) {
        this.rawType = element;
        this.path = str;
    }
}
