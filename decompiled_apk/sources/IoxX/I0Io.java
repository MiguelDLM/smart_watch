package IoxX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;
import org.eclipse.paho.client.mqttv3.internal.websocket.HandshakeFailedException;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f847II0XooXoX = "sec-websocket-accept";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f848OOXIXo = "";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f849Oxx0IOOO = "SHA1";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f850XO = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: oO, reason: collision with root package name */
    public static final String f851oO = "sec-websocket-protocol";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f852oOoXoXO = "\r\n";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f853ooOOo0oXI = "connection";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f854x0XOIxOo = "upgrade";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f855xoIox = "websocket";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f856xxIXOIIO = "upgrade";

    /* renamed from: I0Io, reason: collision with root package name */
    public String f857I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OutputStream f858II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f859X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public InputStream f860oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f861oxoX;

    public I0Io(InputStream inputStream, OutputStream outputStream, String str, String str2, int i) {
        this.f860oIX0oI = inputStream;
        this.f858II0xO0 = outputStream;
        this.f857I0Io = str;
        this.f861oxoX = str2;
        this.f859X0o0xo = i;
    }

    public final void I0Io(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f860oIX0oI));
        ArrayList arrayList = new ArrayList();
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            while (!readLine.equals("")) {
                arrayList.add(readLine);
                readLine = bufferedReader.readLine();
            }
            Map II0xO02 = II0xO0(arrayList);
            String str2 = (String) II0xO02.get(f853ooOOo0oXI);
            if (str2 != null && !str2.equalsIgnoreCase("upgrade")) {
                if (((String) II0xO02.get("upgrade")).toLowerCase().contains(f855xoIox)) {
                    if (((String) II0xO02.get(f851oO)) != null) {
                        if (II0xO02.containsKey(f847II0XooXoX)) {
                            try {
                                XO(str, (String) II0xO02.get(f847II0XooXoX));
                                return;
                            } catch (NoSuchAlgorithmException e) {
                                throw new IOException(e.getMessage());
                            } catch (HandshakeFailedException unused) {
                                throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
                            }
                        }
                        throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
                    }
                    throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
                }
                throw new IOException("WebSocket Response header: Incorrect upgrade.");
            }
            throw new IOException("WebSocket Response header: Incorrect connection header");
        }
        throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
    }

    public final Map II0xO0(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i < arrayList.size(); i++) {
            String[] split = ((String) arrayList.get(i)).split(":");
            hashMap.put(split[0].toLowerCase(), split[1]);
        }
        return hashMap;
    }

    public final byte[] X0o0xo(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(f849Oxx0IOOO).digest(str.getBytes());
    }

    public final void XO(String str, String str2) throws NoSuchAlgorithmException, HandshakeFailedException {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
        stringBuffer.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        String trim = oIX0oI.II0xO0(X0o0xo(stringBuffer.toString())).trim();
        if (trim.equals(trim)) {
        } else {
            throw new HandshakeFailedException();
        }
    }

    public void oIX0oI() throws IOException {
        StringBuffer stringBuffer = new StringBuffer("mqtt-");
        stringBuffer.append(System.currentTimeMillis() / 1000);
        String oIX0oI2 = oIX0oI.oIX0oI(stringBuffer.toString());
        oxoX(oIX0oI2);
        I0Io(oIX0oI2);
    }

    public final void oxoX(String str) throws IOException {
        try {
            String str2 = "/mqtt";
            URI uri = new URI(this.f857I0Io);
            if (uri.getRawPath() != null && !uri.getRawPath().isEmpty()) {
                str2 = uri.getRawPath();
                if (uri.getRawQuery() != null && !uri.getRawQuery().isEmpty()) {
                    StringBuffer stringBuffer = new StringBuffer(String.valueOf(str2));
                    stringBuffer.append(LocationInfo.NA);
                    stringBuffer.append(uri.getRawQuery());
                    str2 = stringBuffer.toString();
                }
            }
            PrintWriter printWriter = new PrintWriter(this.f858II0xO0);
            StringBuffer stringBuffer2 = new StringBuffer("GET ");
            stringBuffer2.append(str2);
            stringBuffer2.append(" HTTP/1.1");
            stringBuffer2.append("\r\n");
            printWriter.print(stringBuffer2.toString());
            StringBuffer stringBuffer3 = new StringBuffer("Host: ");
            stringBuffer3.append(this.f861oxoX);
            stringBuffer3.append(":");
            stringBuffer3.append(this.f859X0o0xo);
            stringBuffer3.append("\r\n");
            printWriter.print(stringBuffer3.toString());
            printWriter.print("Upgrade: websocket\r\n");
            printWriter.print("Connection: Upgrade\r\n");
            StringBuffer stringBuffer4 = new StringBuffer("Sec-WebSocket-Key: ");
            stringBuffer4.append(str);
            stringBuffer4.append("\r\n");
            printWriter.print(stringBuffer4.toString());
            printWriter.print("Sec-WebSocket-Protocol: mqttv3.1\r\n");
            printWriter.print("Sec-WebSocket-Version: 13\r\n");
            printWriter.print("\r\n");
            printWriter.flush();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}
