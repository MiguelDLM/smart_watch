package org.eclipse.paho.android.service;

import OoOoXO0.Oxx0xo;
import OoOoXO0.XO;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MqttDeliveryTokenAndroid extends MqttTokenAndroid implements XO {
    private Oxx0xo message;

    public MqttDeliveryTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, OoOoXO0.I0Io i0Io, Oxx0xo oxx0xo) {
        super(mqttAndroidClient, obj, i0Io);
        this.message = oxx0xo;
    }

    @Override // OoOoXO0.XO
    public Oxx0xo getMessage() {
        return this.message;
    }

    public void notifyDelivery(Oxx0xo oxx0xo) {
        this.message = oxx0xo;
        super.notifyComplete();
    }

    public void setMessage(Oxx0xo oxx0xo) {
        this.message = oxx0xo;
    }
}
