package Ox0XO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public interface Oxx0xo {
    InputStream getInputStream() throws IOException;

    String getServerURI();

    OutputStream oIX0oI() throws IOException;

    void start() throws IOException, MqttException;

    void stop() throws IOException;
}
