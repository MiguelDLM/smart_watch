package OoOoXO0;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/* loaded from: classes6.dex */
public interface X0o0xo {
    void I0Io(String str, Oxx0IOOO oxx0IOOO) throws MqttException, MqttSecurityException;

    void II0xO0(String str) throws MqttException, MqttSecurityException;

    II0XooXoX X0o0xo(x0xO0oo x0xo0oo) throws MqttSecurityException, MqttException;

    void XO(String[] strArr) throws MqttException;

    void close() throws MqttException;

    void connect() throws MqttSecurityException, MqttException;

    void connect(x0xO0oo x0xo0oo) throws MqttSecurityException, MqttException;

    void disconnect() throws MqttException;

    void disconnect(long j) throws MqttException;

    void disconnectForcibly() throws MqttException;

    void disconnectForcibly(long j) throws MqttException;

    void disconnectForcibly(long j, long j2) throws MqttException;

    String getClientId();

    XO[] getPendingDeliveryTokens();

    String getServerURI();

    boolean isConnected();

    void messageArrivedComplete(int i, int i2) throws MqttException;

    xoXoI oIX0oI(String str);

    void oxoX(String[] strArr, Oxx0IOOO[] oxx0IOOOArr) throws MqttException;

    void publish(String str, Oxx0xo oxx0xo) throws MqttException, MqttPersistenceException;

    void publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException;

    void setCallback(oOoXoXO oooxoxo);

    void setManualAcks(boolean z);

    void subscribe(String str, int i) throws MqttException;

    void subscribe(String str, int i, Oxx0IOOO oxx0IOOO) throws MqttException;

    void subscribe(String[] strArr, int[] iArr) throws MqttException;

    void subscribe(String[] strArr, int[] iArr, Oxx0IOOO[] oxx0IOOOArr) throws MqttException;

    void unsubscribe(String str) throws MqttException;

    void unsubscribe(String[] strArr) throws MqttException;
}
