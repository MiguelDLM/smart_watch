package org.apache.log4j.helpers;

import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: classes6.dex */
public class IXxxXO extends Writer {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static String f33241oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f33242IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public InetAddress f33243Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public DatagramSocket f33244Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f33245XO = 514;

    /* JADX WARN: Can't wrap try/catch for region: R(7:3|(4:(3:24|25|(10:27|(1:31)|32|(1:9)|10|11|12|14|15|17))|14|15|17)|7|(0)|10|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        r2 = new java.lang.StringBuffer();
        r2.append("Could not find ");
        r2.append(r8);
        r2.append(". All logging will FAIL.");
        org.apache.log4j.helpers.xxIXOIIO.oxoX(r2.toString(), r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public IXxxXO(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = ". All logging will FAIL."
            r7.<init>()
            r1 = 514(0x202, float:7.2E-43)
            r7.f33245XO = r1
            org.apache.log4j.helpers.IXxxXO.f33241oI0IIXIo = r8
            if (r8 == 0) goto Lb9
            java.lang.String r2 = "["
            int r3 = r8.indexOf(r2)
            r4 = -1
            if (r3 != r4) goto L25
            r3 = 58
            int r5 = r8.indexOf(r3)
            int r3 = r8.lastIndexOf(r3)
            if (r5 != r3) goto L23
            goto L25
        L23:
            r2 = -1
            goto L70
        L25:
            java.net.URL r3 = new java.net.URL     // Catch: java.net.MalformedURLException -> L63
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch: java.net.MalformedURLException -> L63
            r5.<init>()     // Catch: java.net.MalformedURLException -> L63
            java.lang.String r6 = "http://"
            r5.append(r6)     // Catch: java.net.MalformedURLException -> L63
            r5.append(r8)     // Catch: java.net.MalformedURLException -> L63
            java.lang.String r5 = r5.toString()     // Catch: java.net.MalformedURLException -> L63
            r3.<init>(r5)     // Catch: java.net.MalformedURLException -> L63
            java.lang.String r5 = r3.getHost()     // Catch: java.net.MalformedURLException -> L63
            if (r5 == 0) goto L23
            java.lang.String r8 = r3.getHost()     // Catch: java.net.MalformedURLException -> L63
            boolean r2 = r8.startsWith(r2)     // Catch: java.net.MalformedURLException -> L63
            if (r2 == 0) goto L65
            int r2 = r8.length()     // Catch: java.net.MalformedURLException -> L63
            r5 = 1
            int r2 = r2 - r5
            char r2 = r8.charAt(r2)     // Catch: java.net.MalformedURLException -> L63
            r6 = 93
            if (r2 != r6) goto L65
            int r2 = r8.length()     // Catch: java.net.MalformedURLException -> L63
            int r2 = r2 - r5
            java.lang.String r8 = r8.substring(r5, r2)     // Catch: java.net.MalformedURLException -> L63
            goto L65
        L63:
            r2 = move-exception
            goto L6a
        L65:
            int r2 = r3.getPort()     // Catch: java.net.MalformedURLException -> L63
            goto L70
        L6a:
            java.lang.String r3 = "Malformed URL: will attempt to interpret as InetAddress."
            org.apache.log4j.helpers.xxIXOIIO.oxoX(r3, r2)
            goto L23
        L70:
            if (r2 != r4) goto L73
            goto L74
        L73:
            r1 = r2
        L74:
            r7.f33242IXxxXO = r1
            java.net.InetAddress r1 = java.net.InetAddress.getByName(r8)     // Catch: java.net.UnknownHostException -> L7d
            r7.f33243Oo = r1     // Catch: java.net.UnknownHostException -> L7d
            goto L95
        L7d:
            r1 = move-exception
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "Could not find "
            r2.append(r3)
            r2.append(r8)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            org.apache.log4j.helpers.xxIXOIIO.oxoX(r2, r1)
        L95:
            java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch: java.net.SocketException -> L9d
            r1.<init>()     // Catch: java.net.SocketException -> L9d
            r7.f33244Oxx0xo = r1     // Catch: java.net.SocketException -> L9d
            goto Lb8
        L9d:
            r1 = move-exception
            r1.printStackTrace()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "Could not instantiate DatagramSocket to "
            r2.append(r3)
            r2.append(r8)
            r2.append(r0)
            java.lang.String r8 = r2.toString()
            org.apache.log4j.helpers.xxIXOIIO.oxoX(r8, r1)
        Lb8:
            return
        Lb9:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "syslogHost"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.helpers.IXxxXO.<init>(java.lang.String):void");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        write(new String(cArr, i, i2));
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        byte[] bytes = str.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, this.f33243Oo, this.f33242IXxxXO);
        DatagramSocket datagramSocket = this.f33244Oxx0xo;
        if (datagramSocket == null || this.f33243Oo == null) {
            return;
        }
        datagramSocket.send(datagramPacket);
    }
}
