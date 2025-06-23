package org.eclipse.paho.client.mqttv3;

import Ox0XO.x0xO0oo;
import XXO0.oIX0oI;

/* loaded from: classes6.dex */
public class MqttException extends Exception {
    public static final short REASON_CODE_BROKER_UNAVAILABLE = 3;
    public static final short REASON_CODE_CLIENT_ALREADY_DISCONNECTED = 32101;
    public static final short REASON_CODE_CLIENT_CLOSED = 32111;
    public static final short REASON_CODE_CLIENT_CONNECTED = 32100;
    public static final short REASON_CODE_CLIENT_DISCONNECTING = 32102;
    public static final short REASON_CODE_CLIENT_DISCONNECT_PROHIBITED = 32107;
    public static final short REASON_CODE_CLIENT_EXCEPTION = 0;
    public static final short REASON_CODE_CLIENT_NOT_CONNECTED = 32104;
    public static final short REASON_CODE_CLIENT_TIMEOUT = 32000;
    public static final short REASON_CODE_CONNECTION_LOST = 32109;
    public static final short REASON_CODE_CONNECT_IN_PROGRESS = 32110;
    public static final short REASON_CODE_DISCONNECTED_BUFFER_FULL = 32203;
    public static final short REASON_CODE_FAILED_AUTHENTICATION = 4;
    public static final short REASON_CODE_INVALID_CLIENT_ID = 2;
    public static final short REASON_CODE_INVALID_MESSAGE = 32108;
    public static final short REASON_CODE_INVALID_PROTOCOL_VERSION = 1;
    public static final short REASON_CODE_MAX_INFLIGHT = 32202;
    public static final short REASON_CODE_NOT_AUTHORIZED = 5;
    public static final short REASON_CODE_NO_MESSAGE_IDS_AVAILABLE = 32001;
    public static final short REASON_CODE_SERVER_CONNECT_ERROR = 32103;
    public static final short REASON_CODE_SOCKET_FACTORY_MISMATCH = 32105;
    public static final short REASON_CODE_SSL_CONFIG_ERROR = 32106;
    public static final short REASON_CODE_SUBSCRIBE_FAILED = 128;
    public static final short REASON_CODE_TOKEN_INUSE = 32201;
    public static final short REASON_CODE_UNEXPECTED_ERROR = 6;
    public static final short REASON_CODE_WRITE_TIMEOUT = 32002;
    private static final long serialVersionUID = 300;
    private Throwable cause;
    private int reasonCode;

    public MqttException(int i) {
        this.reasonCode = i;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return x0xO0oo.II0xO0(this.reasonCode);
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(getMessage()));
        stringBuffer.append(" (");
        stringBuffer.append(this.reasonCode);
        stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
        String stringBuffer2 = stringBuffer.toString();
        if (this.cause != null) {
            StringBuffer stringBuffer3 = new StringBuffer(String.valueOf(stringBuffer2));
            stringBuffer3.append(" - ");
            stringBuffer3.append(this.cause.toString());
            return stringBuffer3.toString();
        }
        return stringBuffer2;
    }

    public MqttException(Throwable th) {
        this.reasonCode = 0;
        this.cause = th;
    }

    public MqttException(int i, Throwable th) {
        this.reasonCode = i;
        this.cause = th;
    }
}
