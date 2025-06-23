package Ox0XO;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes6.dex */
public class oI0IIXIo extends x0xO0oo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public ResourceBundle f2917II0xO0 = ResourceBundle.getBundle("org.eclipse.paho.client.mqttv3.internal.nls.messages");

    @Override // Ox0XO.x0xO0oo
    public String oIX0oI(int i) {
        try {
            return this.f2917II0xO0.getString(Integer.toString(i));
        } catch (MissingResourceException unused) {
            return "MqttException";
        }
    }
}
