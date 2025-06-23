package OoOoXO0;

import java.util.Enumeration;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public interface oO {
    boolean I0Io(String str) throws MqttPersistenceException;

    void II0xO0(String str, oI0IIXIo oi0iixio) throws MqttPersistenceException;

    void clear() throws MqttPersistenceException;

    void close() throws MqttPersistenceException;

    oI0IIXIo get(String str) throws MqttPersistenceException;

    Enumeration keys() throws MqttPersistenceException;

    void oIX0oI(String str, String str2) throws MqttPersistenceException;

    void remove(String str) throws MqttPersistenceException;
}
