package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpInetConnection;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSession;

/* loaded from: classes10.dex */
public interface ManagedHttpClientConnection extends HttpClientConnection, HttpInetConnection {
    void bind(Socket socket) throws IOException;

    String getId();

    SSLSession getSSLSession();

    Socket getSocket();
}
