package OoOoXO0;

import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public interface II0XooXoX {
    I0Io getActionCallback();

    oxoX getClient();

    MqttException getException();

    int[] getGrantedQos();

    int getMessageId();

    IXIIo.IIXOooo getResponse();

    boolean getSessionPresent();

    String[] getTopics();

    Object getUserContext();

    boolean isComplete();

    void setActionCallback(I0Io i0Io);

    void setUserContext(Object obj);

    void waitForCompletion() throws MqttException;

    void waitForCompletion(long j) throws MqttException;
}
