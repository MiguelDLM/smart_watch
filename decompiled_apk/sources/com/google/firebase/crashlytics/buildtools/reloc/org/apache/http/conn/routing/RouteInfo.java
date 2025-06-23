package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.net.InetAddress;

/* loaded from: classes10.dex */
public interface RouteInfo {

    /* loaded from: classes10.dex */
    public enum LayerType {
        PLAIN,
        LAYERED
    }

    /* loaded from: classes10.dex */
    public enum TunnelType {
        PLAIN,
        TUNNELLED
    }

    int getHopCount();

    HttpHost getHopTarget(int i);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}
