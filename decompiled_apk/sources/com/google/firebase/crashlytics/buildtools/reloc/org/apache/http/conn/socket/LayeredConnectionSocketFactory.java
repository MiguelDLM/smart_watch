package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.socket;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/* loaded from: classes10.dex */
public interface LayeredConnectionSocketFactory extends ConnectionSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i, HttpContext httpContext) throws IOException, UnknownHostException;
}
