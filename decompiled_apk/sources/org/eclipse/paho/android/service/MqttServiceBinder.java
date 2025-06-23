package org.eclipse.paho.android.service;

import android.os.Binder;

/* loaded from: classes6.dex */
class MqttServiceBinder extends Binder {
    private String activityToken;
    private MqttService mqttService;

    public MqttServiceBinder(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    public String getActivityToken() {
        return this.activityToken;
    }

    public MqttService getService() {
        return this.mqttService;
    }

    public void setActivityToken(String str) {
        this.activityToken = str;
    }
}
