package oIX0o;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/* loaded from: classes6.dex */
public class X0o0xo implements Runnable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public DataOutputStream f31631IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public DataInputStream f31632Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public II0xO0 f31633Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Socket f31634XO;

    public X0o0xo(Socket socket, II0xO0 iI0xO0) {
        this.f31634XO = socket;
        this.f31633Oxx0xo = iI0xO0;
        try {
            this.f31632Oo = new DataInputStream(socket.getInputStream());
            this.f31631IXxxXO = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String readUTF = this.f31632Oo.readUTF();
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Got external roll over signal.");
            if (II0xO0.f31620Oxx0xo.equals(readUTF)) {
                synchronized (this.f31633Oxx0xo) {
                    this.f31633Oxx0xo.XoX();
                }
                this.f31631IXxxXO.writeUTF("OK");
            } else {
                this.f31631IXxxXO.writeUTF("Expecting [RollOver] string.");
            }
            this.f31631IXxxXO.close();
        } catch (Exception e) {
            org.apache.log4j.helpers.xxIXOIIO.oxoX("Unexpected exception. Exiting HUPNode.", e);
        }
    }
}
