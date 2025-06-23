package OoOoXO0;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/* loaded from: classes6.dex */
public interface oxoX {
    void close() throws MqttException;

    II0XooXoX connect() throws MqttException, MqttSecurityException;

    II0XooXoX connect(x0xO0oo x0xo0oo) throws MqttException, MqttSecurityException;

    II0XooXoX connect(x0xO0oo x0xo0oo, Object obj, I0Io i0Io) throws MqttException, MqttSecurityException;

    II0XooXoX connect(Object obj, I0Io i0Io) throws MqttException, MqttSecurityException;

    II0XooXoX disconnect() throws MqttException;

    II0XooXoX disconnect(long j) throws MqttException;

    II0XooXoX disconnect(long j, Object obj, I0Io i0Io) throws MqttException;

    II0XooXoX disconnect(Object obj, I0Io i0Io) throws MqttException;

    void disconnectForcibly() throws MqttException;

    void disconnectForcibly(long j) throws MqttException;

    void disconnectForcibly(long j, long j2) throws MqttException;

    String getClientId();

    XO[] getPendingDeliveryTokens();

    String getServerURI();

    boolean isConnected();

    void messageArrivedComplete(int i, int i2) throws MqttException;

    XO publish(String str, Oxx0xo oxx0xo) throws MqttException, MqttPersistenceException;

    XO publish(String str, Oxx0xo oxx0xo, Object obj, I0Io i0Io) throws MqttException, MqttPersistenceException;

    XO publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException;

    XO publish(String str, byte[] bArr, int i, boolean z, Object obj, I0Io i0Io) throws MqttException, MqttPersistenceException;

    void setCallback(oOoXoXO oooxoxo);

    void setManualAcks(boolean z);

    II0XooXoX subscribe(String str, int i) throws MqttException;

    II0XooXoX subscribe(String str, int i, Oxx0IOOO oxx0IOOO) throws MqttException;

    II0XooXoX subscribe(String str, int i, Object obj, I0Io i0Io) throws MqttException;

    II0XooXoX subscribe(String str, int i, Object obj, I0Io i0Io, Oxx0IOOO oxx0IOOO) throws MqttException;

    II0XooXoX subscribe(String[] strArr, int[] iArr) throws MqttException;

    II0XooXoX subscribe(String[] strArr, int[] iArr, Object obj, I0Io i0Io) throws MqttException;

    II0XooXoX subscribe(String[] strArr, int[] iArr, Object obj, I0Io i0Io, Oxx0IOOO[] oxx0IOOOArr) throws MqttException;

    II0XooXoX subscribe(String[] strArr, int[] iArr, Oxx0IOOO[] oxx0IOOOArr) throws MqttException;

    II0XooXoX unsubscribe(String str) throws MqttException;

    II0XooXoX unsubscribe(String str, Object obj, I0Io i0Io) throws MqttException;

    II0XooXoX unsubscribe(String[] strArr) throws MqttException;

    II0XooXoX unsubscribe(String[] strArr, Object obj, I0Io i0Io) throws MqttException;
}
