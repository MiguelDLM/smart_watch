package org.eclipse.paho.android.service;

import IXIIo.IIXOooo;
import OoOoXO0.II0XooXoX;
import OoOoXO0.oxoX;
import com.realsil.sdk.dfu.DfuConstants;
import org.eclipse.paho.client.mqttv3.MqttException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MqttTokenAndroid implements II0XooXoX {
    private MqttAndroidClient client;
    private II0XooXoX delegate;
    private volatile boolean isComplete;
    private volatile MqttException lastException;
    private OoOoXO0.I0Io listener;
    private MqttException pendingException;
    private String[] topics;
    private Object userContext;
    private Object waitObject;

    public MqttTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, OoOoXO0.I0Io i0Io) {
        this(mqttAndroidClient, obj, i0Io, null);
    }

    @Override // OoOoXO0.II0XooXoX
    public OoOoXO0.I0Io getActionCallback() {
        return this.listener;
    }

    @Override // OoOoXO0.II0XooXoX
    public oxoX getClient() {
        return this.client;
    }

    @Override // OoOoXO0.II0XooXoX
    public MqttException getException() {
        return this.lastException;
    }

    @Override // OoOoXO0.II0XooXoX
    public int[] getGrantedQos() {
        return this.delegate.getGrantedQos();
    }

    @Override // OoOoXO0.II0XooXoX
    public int getMessageId() {
        II0XooXoX iI0XooXoX = this.delegate;
        if (iI0XooXoX != null) {
            return iI0XooXoX.getMessageId();
        }
        return 0;
    }

    @Override // OoOoXO0.II0XooXoX
    public IIXOooo getResponse() {
        return this.delegate.getResponse();
    }

    @Override // OoOoXO0.II0XooXoX
    public boolean getSessionPresent() {
        return this.delegate.getSessionPresent();
    }

    @Override // OoOoXO0.II0XooXoX
    public String[] getTopics() {
        return this.topics;
    }

    @Override // OoOoXO0.II0XooXoX
    public Object getUserContext() {
        return this.userContext;
    }

    @Override // OoOoXO0.II0XooXoX
    public boolean isComplete() {
        return this.isComplete;
    }

    public void notifyComplete() {
        synchronized (this.waitObject) {
            try {
                this.isComplete = true;
                this.waitObject.notifyAll();
                OoOoXO0.I0Io i0Io = this.listener;
                if (i0Io != null) {
                    i0Io.onSuccess(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyFailure(Throwable th) {
        synchronized (this.waitObject) {
            try {
                this.isComplete = true;
                this.pendingException = th instanceof MqttException ? (MqttException) th : new MqttException(th);
                this.waitObject.notifyAll();
                if (th instanceof MqttException) {
                    this.lastException = (MqttException) th;
                }
                OoOoXO0.I0Io i0Io = this.listener;
                if (i0Io != null) {
                    i0Io.onFailure(this, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // OoOoXO0.II0XooXoX
    public void setActionCallback(OoOoXO0.I0Io i0Io) {
        this.listener = i0Io;
    }

    public void setComplete(boolean z) {
        this.isComplete = z;
    }

    public void setDelegate(II0XooXoX iI0XooXoX) {
        this.delegate = iI0XooXoX;
    }

    public void setException(MqttException mqttException) {
        this.lastException = mqttException;
    }

    @Override // OoOoXO0.II0XooXoX
    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    @Override // OoOoXO0.II0XooXoX
    public void waitForCompletion() {
        synchronized (this.waitObject) {
            try {
                this.waitObject.wait();
            } catch (InterruptedException unused) {
            }
        }
        MqttException mqttException = this.pendingException;
        if (mqttException != null) {
            throw mqttException;
        }
    }

    public MqttTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, OoOoXO0.I0Io i0Io, String[] strArr) {
        this.waitObject = new Object();
        this.client = mqttAndroidClient;
        this.userContext = obj;
        this.listener = i0Io;
        this.topics = strArr;
    }

    @Override // OoOoXO0.II0XooXoX
    public void waitForCompletion(long j) {
        synchronized (this.waitObject) {
            try {
                this.waitObject.wait(j);
            } catch (InterruptedException unused) {
            }
            if (!this.isComplete) {
                throw new MqttException(DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT);
            }
            MqttException mqttException = this.pendingException;
            if (mqttException != null) {
                throw mqttException;
            }
        }
    }
}
