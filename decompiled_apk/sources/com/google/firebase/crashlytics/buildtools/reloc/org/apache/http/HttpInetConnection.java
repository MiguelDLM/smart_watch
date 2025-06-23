package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.net.InetAddress;

/* loaded from: classes10.dex */
public interface HttpInetConnection extends HttpConnection {
    InetAddress getLocalAddress();

    int getLocalPort();

    InetAddress getRemoteAddress();

    int getRemotePort();
}
