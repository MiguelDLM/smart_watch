package org.eclipse.paho.android.service;

import IXI.oxoX;
import OoOoXO0.II0XooXoX;
import OoOoXO0.OOXIXo;
import OoOoXO0.Oxx0IOOO;
import OoOoXO0.Oxx0xo;
import OoOoXO0.XO;
import OoOoXO0.oO;
import OoOoXO0.ooOOo0oXI;
import OoOoXO0.x0xO0oo;
import XXO0.oIX0oI;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.android.service.MessageStore;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MqttConnection implements ooOOo0oXI {
    private static final String NOT_CONNECTED = "not connected";
    private static final String TAG = "MqttConnection";
    private String clientHandle;
    private String clientId;
    private x0xO0oo connectOptions;
    private oO persistence;
    private String serverURI;
    private MqttService service;
    private String wakeLockTag;
    private String reconnectActivityToken = null;
    private OOXIXo myClient = null;
    private AlarmPingSender alarmPingSender = null;
    private volatile boolean disconnected = true;
    private boolean cleanSession = true;
    private volatile boolean isConnecting = false;
    private Map<XO, String> savedTopics = new HashMap();
    private Map<XO, Oxx0xo> savedSentMessages = new HashMap();
    private Map<XO, String> savedActivityTokens = new HashMap();
    private Map<XO, String> savedInvocationContexts = new HashMap();
    private PowerManager.WakeLock wakelock = null;
    private OoOoXO0.II0xO0 bufferOpts = null;

    /* loaded from: classes6.dex */
    public class MqttConnectionListener implements OoOoXO0.I0Io {
        private final Bundle resultBundle;

        private MqttConnectionListener(Bundle bundle) {
            this.resultBundle = bundle;
        }

        @Override // OoOoXO0.I0Io
        public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
            this.resultBundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
            this.resultBundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, this.resultBundle);
        }

        @Override // OoOoXO0.I0Io
        public void onSuccess(II0XooXoX iI0XooXoX) {
            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.OK, this.resultBundle);
        }
    }

    public MqttConnection(MqttService mqttService, String str, String str2, oO oOVar, String str3) {
        this.persistence = null;
        this.service = null;
        this.wakeLockTag = null;
        this.serverURI = str;
        this.service = mqttService;
        this.clientId = str2;
        this.persistence = oOVar;
        this.clientHandle = str3;
        this.wakeLockTag = getClass().getCanonicalName() + " " + str2 + " on host " + str;
    }

    private void acquireWakeLock() {
        if (this.wakelock == null) {
            this.wakelock = ((PowerManager) this.service.getSystemService("power")).newWakeLock(1, this.wakeLockTag);
        }
        this.wakelock.acquire();
    }

    private void deliverBacklog() {
        Iterator<MessageStore.StoredMessage> allArrivedMessages = this.service.messageStore.getAllArrivedMessages(this.clientHandle);
        while (allArrivedMessages.hasNext()) {
            MessageStore.StoredMessage next = allArrivedMessages.next();
            Bundle messageToBundle = messageToBundle(next.getMessageId(), next.getTopic(), next.getMessage());
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterConnectFail(Bundle bundle) {
        acquireWakeLock();
        this.disconnected = true;
        setConnectingState(false);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        releaseWakeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterConnectSuccess(Bundle bundle) {
        acquireWakeLock();
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        deliverBacklog();
        setConnectingState(false);
        this.disconnected = false;
        releaseWakeLock();
    }

    private void handleException(Bundle bundle, Exception exc) {
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, exc.getLocalizedMessage());
        bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    private Bundle messageToBundle(String str, String str2, Oxx0xo oxx0xo) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, str);
        bundle.putString(MqttServiceConstants.CALLBACK_DESTINATION_NAME, str2);
        bundle.putParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL, new ParcelableMqttMessage(oxx0xo));
        return bundle;
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.wakelock.release();
    }

    private synchronized void setConnectingState(boolean z) {
        this.isConnecting = z;
    }

    private void storeSendDetails(String str, Oxx0xo oxx0xo, XO xo2, String str2, String str3) {
        this.savedTopics.put(xo2, str);
        this.savedSentMessages.put(xo2, oxx0xo);
        this.savedActivityTokens.put(xo2, str3);
        this.savedInvocationContexts.put(xo2, str2);
    }

    public void close() {
        this.service.traceDebug(TAG, "close()");
        try {
            OOXIXo oOXIXo = this.myClient;
            if (oOXIXo != null) {
                oOXIXo.close();
            }
        } catch (MqttException e) {
            handleException(new Bundle(), e);
        }
    }

    public void connect(x0xO0oo x0xo0oo, String str, String str2) {
        OOXIXo oOXIXo;
        this.connectOptions = x0xo0oo;
        this.reconnectActivityToken = str2;
        if (x0xo0oo != null) {
            this.cleanSession = x0xo0oo.x0XOIxOo();
        }
        if (this.connectOptions.x0XOIxOo()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        this.service.traceDebug(TAG, "Connecting {" + this.serverURI + "} as {" + this.clientId + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        final Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
        try {
            if (this.persistence == null) {
                File externalFilesDir = this.service.getExternalFilesDir(TAG);
                if (externalFilesDir == null && (externalFilesDir = this.service.getDir(TAG, 0)) == null) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, "Error! No external and internal storage available");
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, new MqttPersistenceException());
                    this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
                    return;
                }
                this.persistence = new oxoX(externalFilesDir.getAbsolutePath());
            }
            MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle) { // from class: org.eclipse.paho.android.service.MqttConnection.1
                @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, OoOoXO0.I0Io
                public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
                    bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                    bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                    MqttConnection.this.service.traceError(MqttConnection.TAG, "connect fail, call connect to reconnect.reason:" + th.getMessage());
                    MqttConnection.this.doAfterConnectFail(bundle);
                }

                @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, OoOoXO0.I0Io
                public void onSuccess(II0XooXoX iI0XooXoX) {
                    MqttConnection.this.doAfterConnectSuccess(bundle);
                    MqttConnection.this.service.traceDebug(MqttConnection.TAG, "connect success!");
                }
            };
            if (this.myClient != null) {
                if (this.isConnecting) {
                    this.service.traceDebug(TAG, "myClient != null and the client is connecting. Connect return directly.");
                    this.service.traceDebug(TAG, "Connect return:isConnecting:" + this.isConnecting + ".disconnected:" + this.disconnected);
                    return;
                }
                if (!this.disconnected) {
                    this.service.traceDebug(TAG, "myClient != null and the client is connected and notify!");
                    doAfterConnectSuccess(bundle);
                    return;
                } else {
                    this.service.traceDebug(TAG, "myClient != null and the client is not connected");
                    this.service.traceDebug(TAG, "Do Real connect!");
                    setConnectingState(true);
                    oOXIXo = this.myClient;
                }
            } else {
                this.alarmPingSender = new AlarmPingSender(this.service);
                OOXIXo oOXIXo2 = new OOXIXo(this.serverURI, this.clientId, this.persistence, this.alarmPingSender);
                this.myClient = oOXIXo2;
                oOXIXo2.setCallback(this);
                this.service.traceDebug(TAG, "Do Real connect!");
                setConnectingState(true);
                oOXIXo = this.myClient;
            }
            oOXIXo.connect(this.connectOptions, str, mqttConnectionListener);
        } catch (Exception e) {
            this.service.traceError(TAG, "Exception occurred attempting to connect: " + e.getMessage());
            setConnectingState(false);
            handleException(bundle, e);
        }
    }

    @Override // OoOoXO0.ooOOo0oXI
    public void connectComplete(boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_EXTENDED_ACTION);
        bundle.putBoolean(MqttServiceConstants.CALLBACK_RECONNECT, z);
        bundle.putString(MqttServiceConstants.CALLBACK_SERVER_URI, str);
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
    }

    @Override // OoOoXO0.oOoXoXO
    public void connectionLost(Throwable th) {
        this.service.traceDebug(TAG, "connectionLost(" + th.getMessage() + oIX0oI.I0Io.f4095I0Io);
        this.disconnected = true;
        try {
            if (this.connectOptions.ooOOo0oXI()) {
                this.alarmPingSender.schedule(100L);
            } else {
                this.myClient.disconnect(null, new OoOoXO0.I0Io() { // from class: org.eclipse.paho.android.service.MqttConnection.2
                    @Override // OoOoXO0.I0Io
                    public void onSuccess(II0XooXoX iI0XooXoX) {
                    }

                    @Override // OoOoXO0.I0Io
                    public void onFailure(II0XooXoX iI0XooXoX, Throwable th2) {
                    }
                });
            }
        } catch (Exception unused) {
        }
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.ON_CONNECTION_LOST_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getMessage());
        if (th instanceof MqttException) {
            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
        }
        bundle.putString(MqttServiceConstants.CALLBACK_EXCEPTION_STACK, Log.getStackTraceString(th));
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        releaseWakeLock();
    }

    public void deleteBufferedMessage(int i) {
        this.myClient.oO(i);
    }

    @Override // OoOoXO0.oOoXoXO
    public void deliveryComplete(XO xo2) {
        this.service.traceDebug(TAG, "deliveryComplete(" + xo2 + oIX0oI.I0Io.f4095I0Io);
        Oxx0xo remove = this.savedSentMessages.remove(xo2);
        if (remove != null) {
            String remove2 = this.savedTopics.remove(xo2);
            String remove3 = this.savedActivityTokens.remove(xo2);
            String remove4 = this.savedInvocationContexts.remove(xo2);
            Bundle messageToBundle = messageToBundle(null, remove2, remove);
            if (remove3 != null) {
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, remove3);
                messageToBundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, remove4);
                this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
            }
            messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_DELIVERED_ACTION);
            this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
        }
    }

    public void disconnect(long j, String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.disconnect(j, str, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
        x0xO0oo x0xo0oo = this.connectOptions;
        if (x0xo0oo != null && x0xo0oo.x0XOIxOo()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    public Oxx0xo getBufferedMessage(int i) {
        return this.myClient.Oo(i);
    }

    public int getBufferedMessageCount() {
        return this.myClient.IXxxXO();
    }

    public String getClientHandle() {
        return this.clientHandle;
    }

    public String getClientId() {
        return this.clientId;
    }

    public x0xO0oo getConnectOptions() {
        return this.connectOptions;
    }

    public XO[] getPendingDeliveryTokens() {
        return this.myClient.getPendingDeliveryTokens();
    }

    public String getServerURI() {
        return this.serverURI;
    }

    public boolean isConnected() {
        OOXIXo oOXIXo = this.myClient;
        return oOXIXo != null && oOXIXo.isConnected();
    }

    @Override // OoOoXO0.oOoXoXO
    public void messageArrived(String str, Oxx0xo oxx0xo) {
        this.service.traceDebug(TAG, "messageArrived(" + str + ",{" + oxx0xo.toString() + "})");
        String storeArrived = this.service.messageStore.storeArrived(this.clientHandle, str, oxx0xo);
        Bundle messageToBundle = messageToBundle(storeArrived, str, oxx0xo);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.MESSAGE_ARRIVED_ACTION);
        messageToBundle.putString(MqttServiceConstants.CALLBACK_MESSAGE_ID, storeArrived);
        this.service.callbackToActivity(this.clientHandle, Status.OK, messageToBundle);
    }

    public void offline() {
        if (this.disconnected || this.cleanSession) {
            return;
        }
        connectionLost(new Exception("Android offline"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    public XO publish(String str, Oxx0xo oxx0xo, String str2, String str3) {
        OoOoXO0.II0xO0 iI0xO0;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        OOXIXo oOXIXo = this.myClient;
        AnonymousClass1 anonymousClass1 = 0;
        XO xo2 = null;
        try {
        } catch (Exception e) {
            handleException(bundle, e);
            xo2 = anonymousClass1;
        }
        if (oOXIXo != null && oOXIXo.isConnected()) {
            anonymousClass1 = this.myClient.publish(str, oxx0xo, str2, new MqttConnectionListener(bundle));
        } else {
            if (this.myClient == null || (iI0xO0 = this.bufferOpts) == null || !iI0xO0.II0xO0()) {
                Log.i(TAG, "Client is not connected, so not sending message");
                bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
                this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
                this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
                return xo2;
            }
            anonymousClass1 = this.myClient.publish(str, oxx0xo, str2, new MqttConnectionListener(bundle));
        }
        storeSendDetails(str, oxx0xo, anonymousClass1, str2, str3);
        xo2 = anonymousClass1;
        return xo2;
    }

    public synchronized void reconnect() {
        final Bundle bundle;
        if (this.myClient == null) {
            this.service.traceError(TAG, "Reconnect myClient = null. Will not do reconnect");
            return;
        }
        if (this.isConnecting) {
            this.service.traceDebug(TAG, "The client is connecting. Reconnect return directly.");
            return;
        }
        if (!this.service.isOnline()) {
            this.service.traceDebug(TAG, "The network is not reachable. Will not do reconnect");
            return;
        }
        if (this.connectOptions.ooOOo0oXI()) {
            Log.i(TAG, "Requesting Automatic reconnect using New Java AC");
            bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
            bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
            try {
                this.myClient.o00();
            } catch (MqttException e) {
                e = e;
                Log.e(TAG, "Exception occurred attempting to reconnect: " + e.getMessage());
                setConnectingState(false);
                handleException(bundle, e);
                return;
            }
            return;
        }
        if (this.disconnected && !this.cleanSession) {
            this.service.traceDebug(TAG, "Do Real Reconnect!");
            bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, this.reconnectActivityToken);
            bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, null);
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.CONNECT_ACTION);
            try {
                try {
                    this.myClient.connect(this.connectOptions, null, new MqttConnectionListener(bundle) { // from class: org.eclipse.paho.android.service.MqttConnection.3
                        @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, OoOoXO0.I0Io
                        public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
                            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, th.getLocalizedMessage());
                            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, th);
                            MqttConnection.this.service.callbackToActivity(MqttConnection.this.clientHandle, Status.ERROR, bundle);
                            MqttConnection.this.doAfterConnectFail(bundle);
                        }

                        @Override // org.eclipse.paho.android.service.MqttConnection.MqttConnectionListener, OoOoXO0.I0Io
                        public void onSuccess(II0XooXoX iI0XooXoX) {
                            MqttConnection.this.service.traceDebug(MqttConnection.TAG, "Reconnect Success!");
                            MqttConnection.this.service.traceDebug(MqttConnection.TAG, "DeliverBacklog when reconnect.");
                            MqttConnection.this.doAfterConnectSuccess(bundle);
                        }
                    });
                    setConnectingState(true);
                } catch (MqttException e2) {
                    e = e2;
                    this.service.traceError(TAG, "Cannot reconnect to remote server." + e.getMessage());
                    setConnectingState(false);
                    handleException(bundle, e);
                    return;
                }
            } catch (Exception e3) {
                this.service.traceError(TAG, "Cannot reconnect to remote server." + e3.getMessage());
                setConnectingState(false);
                handleException(bundle, new MqttException(6, e3.getCause()));
            }
        }
        return;
    }

    public void setBufferOpts(OoOoXO0.II0xO0 iI0xO0) {
        this.bufferOpts = iI0xO0;
        this.myClient.O0xOxO(iI0xO0);
    }

    public void setClientHandle(String str) {
        this.clientHandle = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setConnectOptions(x0xO0oo x0xo0oo) {
        this.connectOptions = x0xo0oo;
    }

    public void setServerURI(String str) {
        this.serverURI = str;
    }

    public void subscribe(String str, int i, String str2, String str3) {
        this.service.traceDebug(TAG, "subscribe({" + str + "}," + i + ",{" + str2 + "}, {" + str3 + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.subscribe(str, i, str2, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
    }

    public void unsubscribe(String str, String str2, String str3) {
        this.service.traceDebug(TAG, "unsubscribe({" + str + "},{" + str2 + "}, {" + str3 + "})");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.unsubscribe(str, str2, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
    }

    public void disconnect(String str, String str2) {
        this.service.traceDebug(TAG, "disconnect()");
        this.disconnected = true;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.DISCONNECT_ACTION);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.DISCONNECT_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.disconnect(str, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
        x0xO0oo x0xo0oo = this.connectOptions;
        if (x0xo0oo != null && x0xo0oo.x0XOIxOo()) {
            this.service.messageStore.clearArrivedMessages(this.clientHandle);
        }
        releaseWakeLock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XO publish(String str, byte[] bArr, int i, boolean z, String str2, String str3) {
        Oxx0xo oxx0xo;
        XO publish;
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SEND_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str3);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str2);
        OOXIXo oOXIXo = this.myClient;
        XO xo2 = null;
        Object[] objArr = 0;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SEND_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
            return null;
        }
        MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle);
        try {
            oxx0xo = new Oxx0xo(bArr);
            oxx0xo.setQos(i);
            oxx0xo.setRetained(z);
            publish = this.myClient.publish(str, bArr, i, z, str2, mqttConnectionListener);
        } catch (Exception e) {
            e = e;
        }
        try {
            storeSendDetails(str, oxx0xo, publish, str2, str3);
            return publish;
        } catch (Exception e2) {
            e = e2;
            xo2 = publish;
            handleException(bundle, e);
            return xo2;
        }
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2) {
        this.service.traceDebug(TAG, "subscribe({" + Arrays.toString(strArr) + "}," + Arrays.toString(iArr) + ",{" + str + "}, {" + str2 + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.subscribe(strArr, iArr, str, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
    }

    public void unsubscribe(String[] strArr, String str, String str2) {
        this.service.traceDebug(TAG, "unsubscribe({" + Arrays.toString(strArr) + "},{" + str + "}, {" + str2 + "})");
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            try {
                this.myClient.unsubscribe(strArr, str, new MqttConnectionListener(bundle));
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
    }

    public void subscribe(String[] strArr, int[] iArr, String str, String str2, Oxx0IOOO[] oxx0IOOOArr) {
        this.service.traceDebug(TAG, "subscribe({" + Arrays.toString(strArr) + "}," + Arrays.toString(iArr) + ",{" + str + "}, {" + str2 + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.SUBSCRIBE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT, str);
        OOXIXo oOXIXo = this.myClient;
        if (oOXIXo == null || !oOXIXo.isConnected()) {
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, NOT_CONNECTED);
            this.service.traceError(MqttServiceConstants.SUBSCRIBE_ACTION, NOT_CONNECTED);
            this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        } else {
            new MqttConnectionListener(bundle);
            try {
                this.myClient.subscribe(strArr, iArr, oxx0IOOOArr);
            } catch (Exception e) {
                handleException(bundle, e);
            }
        }
    }
}
