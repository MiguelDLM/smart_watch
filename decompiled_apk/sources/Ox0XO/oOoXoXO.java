package Ox0XO;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/* loaded from: classes6.dex */
public class oOoXoXO {
    public static boolean I0Io(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static MqttException II0xO0(Throwable th) {
        if (th.getClass().getName().equals("java.security.GeneralSecurityException")) {
            return new MqttSecurityException(th);
        }
        return new MqttException(th);
    }

    public static MqttException oIX0oI(int i) {
        if (i != 4 && i != 5) {
            return new MqttException(i);
        }
        return new MqttSecurityException(i);
    }
}
