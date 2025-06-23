package com.jd.ad.sdk.jad_xk;

import android.content.Context;
import android.net.SSLSessionCache;
import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes10.dex */
public class jad_mz extends SSLSocketFactory {
    public String jad_an = "SSLExtensionSocketFactory";
    public SSLSocketFactory jad_bo;

    public jad_mz(Context context) {
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            this.jad_bo = socketFactory;
            if (socketFactory == null) {
                this.jad_bo = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
            if (context != null) {
                jad_an(new SSLSessionCache(context), sSLContext);
            }
        } catch (Exception e) {
            Log.e(this.jad_an, e.getMessage());
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return jad_an(this.jad_bo.createSocket(str, i));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.jad_bo.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.jad_bo.getSupportedCipherSuites();
    }

    public final void jad_an(SSLSessionCache sSLSessionCache, SSLContext sSLContext) {
        try {
            Field declaredField = sSLSessionCache.getClass().getDeclaredField("mSessionCache");
            declaredField.setAccessible(true);
            sSLContext.getClientSessionContext().getClass().getMethod("setPersistentCache", Class.forName("com.android.org.conscrypt.SSLClientSessionCache")).invoke(sSLContext.getClientSessionContext(), declaredField.get(sSLSessionCache));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return jad_an(this.jad_bo.createSocket(str, i, inetAddress, i2));
    }

    public final Socket jad_an(Socket socket) {
        if ((socket instanceof SSLSocket) && Build.VERSION.SDK_INT >= 29) {
            SSLSockets.setUseSessionTickets((SSLSocket) socket, true);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return jad_an(this.jad_bo.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return jad_an(this.jad_bo.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return jad_an(this.jad_bo.createSocket(socket, str, i, z));
    }
}
