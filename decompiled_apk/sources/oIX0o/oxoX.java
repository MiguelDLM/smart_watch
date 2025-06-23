package oIX0o;

import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: classes6.dex */
public class oxoX extends Thread {

    /* renamed from: Oo, reason: collision with root package name */
    public II0xO0 f31637Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int f31638XO;

    public oxoX(II0xO0 iI0xO0, int i) {
        this.f31637Oo = iI0xO0;
        this.f31638XO = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!isInterrupted()) {
            try {
                while (true) {
                    Socket accept = new ServerSocket(this.f31638XO).accept();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Connected to client at ");
                    stringBuffer.append(accept.getInetAddress());
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
                    new Thread(new X0o0xo(accept, this.f31637Oo)).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
