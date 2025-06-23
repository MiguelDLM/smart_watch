package org.eclipse.paho.android.service;

import OoOoXO0.II0XooXoX;
import OoOoXO0.Oxx0IOOO;
import OoOoXO0.Oxx0xo;
import OoOoXO0.XO;
import OoOoXO0.oO;
import OoOoXO0.oOoXoXO;
import OoOoXO0.ooOOo0oXI;
import OoOoXO0.oxoX;
import OoOoXO0.x0xO0oo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/* loaded from: classes6.dex */
public class MqttAndroidClient extends BroadcastReceiver implements oxoX {
    private static final int BIND_SERVICE_FLAG = 0;
    private static final String SERVICE_NAME = "org.eclipse.paho.android.service.MqttService";
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private volatile boolean bindedService;
    private oOoXoXO callback;
    private String clientHandle;
    private final String clientId;
    private x0xO0oo connectOptions;
    private II0XooXoX connectToken;
    private final Ack messageAck;
    private MqttService mqttService;
    private Context myContext;
    private oO persistence;
    private volatile boolean receiverRegistered;
    private final String serverURI;
    private final MyServiceConnection serviceConnection;
    private final SparseArray<II0XooXoX> tokenMap;
    private int tokenNumber;
    private MqttTraceHandler traceCallback;
    private boolean traceEnabled;

    /* loaded from: classes6.dex */
    public enum Ack {
        AUTO_ACK,
        MANUAL_ACK
    }

    /* loaded from: classes6.dex */
    public final class MyServiceConnection implements ServiceConnection {
        private MyServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MqttAndroidClient.this.mqttService = ((MqttServiceBinder) iBinder).getService();
            MqttAndroidClient.this.bindedService = true;
            MqttAndroidClient.this.doConnect();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MqttAndroidClient.this.mqttService = null;
        }
    }

    public MqttAndroidClient(Context context, String str, String str2) {
        this(context, str, str2, null, Ack.AUTO_ACK);
    }

    private void connectAction(Bundle bundle) {
        II0XooXoX iI0XooXoX = this.connectToken;
        removeMqttToken(bundle);
        simpleAction(iI0XooXoX, bundle);
    }

    private void connectExtendedAction(Bundle bundle) {
        if (this.callback instanceof ooOOo0oXI) {
            ((ooOOo0oXI) this.callback).connectComplete(bundle.getBoolean(MqttServiceConstants.CALLBACK_RECONNECT, false), bundle.getString(MqttServiceConstants.CALLBACK_SERVER_URI));
        }
    }

    private void connectionLostAction(Bundle bundle) {
        if (this.callback != null) {
            this.callback.connectionLost((Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
        }
    }

    private void disconnected(Bundle bundle) {
        this.clientHandle = null;
        II0XooXoX removeMqttToken = removeMqttToken(bundle);
        if (removeMqttToken != null) {
            ((MqttTokenAndroid) removeMqttToken).notifyComplete();
        }
        oOoXoXO oooxoxo = this.callback;
        if (oooxoxo != null) {
            oooxoxo.connectionLost(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doConnect() {
        if (this.clientHandle == null) {
            this.clientHandle = this.mqttService.getClient(this.serverURI, this.clientId, this.myContext.getApplicationInfo().packageName, this.persistence);
        }
        this.mqttService.setTraceEnabled(this.traceEnabled);
        this.mqttService.setTraceCallbackId(this.clientHandle);
        try {
            this.mqttService.connect(this.clientHandle, this.connectOptions, null, storeToken(this.connectToken));
        } catch (MqttException e) {
            OoOoXO0.I0Io actionCallback = this.connectToken.getActionCallback();
            if (actionCallback != null) {
                actionCallback.onFailure(this.connectToken, e);
            }
        }
    }

    private synchronized II0XooXoX getMqttToken(Bundle bundle) {
        return this.tokenMap.get(Integer.parseInt(bundle.getString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN)));
    }

    private void messageArrivedAction(Bundle bundle) {
        if (this.callback != null) {
            String string = bundle.getString(MqttServiceConstants.CALLBACK_MESSAGE_ID);
            String string2 = bundle.getString(MqttServiceConstants.CALLBACK_DESTINATION_NAME);
            ParcelableMqttMessage parcelableMqttMessage = (ParcelableMqttMessage) bundle.getParcelable(MqttServiceConstants.CALLBACK_MESSAGE_PARCEL);
            try {
                if (this.messageAck == Ack.AUTO_ACK) {
                    this.callback.messageArrived(string2, parcelableMqttMessage);
                    this.mqttService.acknowledgeMessageArrival(this.clientHandle, string);
                } else {
                    parcelableMqttMessage.messageId = string;
                    this.callback.messageArrived(string2, parcelableMqttMessage);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void messageDeliveredAction(Bundle bundle) {
        II0XooXoX removeMqttToken = removeMqttToken(bundle);
        if (removeMqttToken == null || this.callback == null || ((Status) bundle.getSerializable(MqttServiceConstants.CALLBACK_STATUS)) != Status.OK || !(removeMqttToken instanceof XO)) {
            return;
        }
        this.callback.deliveryComplete((XO) removeMqttToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerReceiver(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        LocalBroadcastManager.getInstance(this.myContext).registerReceiver(broadcastReceiver, intentFilter);
        this.receiverRegistered = true;
    }

    private synchronized II0XooXoX removeMqttToken(Bundle bundle) {
        String string = bundle.getString(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN);
        if (string != null) {
            int parseInt = Integer.parseInt(string);
            II0XooXoX iI0XooXoX = this.tokenMap.get(parseInt);
            this.tokenMap.delete(parseInt);
            return iI0XooXoX;
        }
        return null;
    }

    private void sendAction(Bundle bundle) {
        simpleAction(getMqttToken(bundle), bundle);
    }

    private void simpleAction(II0XooXoX iI0XooXoX, Bundle bundle) {
        if (iI0XooXoX != null) {
            if (((Status) bundle.getSerializable(MqttServiceConstants.CALLBACK_STATUS)) == Status.OK) {
                ((MqttTokenAndroid) iI0XooXoX).notifyComplete();
                return;
            } else {
                ((MqttTokenAndroid) iI0XooXoX).notifyFailure((Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
                return;
            }
        }
        this.mqttService.traceError("MqttService", "simpleAction : token is null");
    }

    private synchronized String storeToken(II0XooXoX iI0XooXoX) {
        int i;
        this.tokenMap.put(this.tokenNumber, iI0XooXoX);
        i = this.tokenNumber;
        this.tokenNumber = i + 1;
        return Integer.toString(i);
    }

    private void subscribeAction(Bundle bundle) {
        simpleAction(removeMqttToken(bundle), bundle);
    }

    private void traceAction(Bundle bundle) {
        if (this.traceCallback != null) {
            String string = bundle.getString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY);
            String string2 = bundle.getString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE);
            String string3 = bundle.getString(MqttServiceConstants.CALLBACK_TRACE_TAG);
            if ("debug".equals(string)) {
                this.traceCallback.traceDebug(string3, string2);
            } else if ("error".equals(string)) {
                this.traceCallback.traceError(string3, string2);
            } else {
                this.traceCallback.traceException(string3, string2, (Exception) bundle.getSerializable(MqttServiceConstants.CALLBACK_EXCEPTION));
            }
        }
    }

    private void unSubscribeAction(Bundle bundle) {
        simpleAction(removeMqttToken(bundle), bundle);
    }

    public boolean acknowledgeMessage(String str) {
        return this.messageAck == Ack.MANUAL_ACK && this.mqttService.acknowledgeMessageArrival(this.clientHandle, str) == Status.OK;
    }

    @Override // OoOoXO0.oxoX
    public void close() {
        MqttService mqttService = this.mqttService;
        if (mqttService != null) {
            if (this.clientHandle == null) {
                this.clientHandle = mqttService.getClient(this.serverURI, this.clientId, this.myContext.getApplicationInfo().packageName, this.persistence);
            }
            this.mqttService.close(this.clientHandle);
        }
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect() {
        return connect(null, null);
    }

    public void deleteBufferedMessage(int i) {
        this.mqttService.deleteBufferedMessage(this.clientHandle, i);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect() {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, null, null);
        this.mqttService.disconnect(this.clientHandle, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public void disconnectForcibly() {
        throw new UnsupportedOperationException();
    }

    public Oxx0xo getBufferedMessage(int i) {
        return this.mqttService.getBufferedMessage(this.clientHandle, i);
    }

    public int getBufferedMessageCount() {
        return this.mqttService.getBufferedMessageCount(this.clientHandle);
    }

    @Override // OoOoXO0.oxoX
    public String getClientId() {
        return this.clientId;
    }

    @Override // OoOoXO0.oxoX
    public XO[] getPendingDeliveryTokens() {
        return this.mqttService.getPendingDeliveryTokens(this.clientHandle);
    }

    public SSLSocketFactory getSSLSocketFactory(InputStream inputStream, String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("BKS");
            keyStore.load(inputStream, str.toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            SSLContext sSLContext = SSLContext.getInstance("TLSv1");
            sSLContext.init(null, trustManagers, null);
            return sSLContext.getSocketFactory();
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new MqttSecurityException(e);
        }
    }

    @Override // OoOoXO0.oxoX
    public String getServerURI() {
        return this.serverURI;
    }

    @Override // OoOoXO0.oxoX
    public boolean isConnected() {
        MqttService mqttService;
        String str = this.clientHandle;
        return (str == null || (mqttService = this.mqttService) == null || !mqttService.isConnected(str)) ? false : true;
    }

    @Override // OoOoXO0.oxoX
    public void messageArrivedComplete(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString(MqttServiceConstants.CALLBACK_CLIENT_HANDLE);
        if (string == null || !string.equals(this.clientHandle)) {
            return;
        }
        String string2 = extras.getString(MqttServiceConstants.CALLBACK_ACTION);
        if (MqttServiceConstants.CONNECT_ACTION.equals(string2)) {
            connectAction(extras);
            return;
        }
        if (MqttServiceConstants.CONNECT_EXTENDED_ACTION.equals(string2)) {
            connectExtendedAction(extras);
            return;
        }
        if (MqttServiceConstants.MESSAGE_ARRIVED_ACTION.equals(string2)) {
            messageArrivedAction(extras);
            return;
        }
        if (MqttServiceConstants.SUBSCRIBE_ACTION.equals(string2)) {
            subscribeAction(extras);
            return;
        }
        if (MqttServiceConstants.UNSUBSCRIBE_ACTION.equals(string2)) {
            unSubscribeAction(extras);
            return;
        }
        if (MqttServiceConstants.SEND_ACTION.equals(string2)) {
            sendAction(extras);
            return;
        }
        if (MqttServiceConstants.MESSAGE_DELIVERED_ACTION.equals(string2)) {
            messageDeliveredAction(extras);
            return;
        }
        if (MqttServiceConstants.ON_CONNECTION_LOST_ACTION.equals(string2)) {
            connectionLostAction(extras);
            return;
        }
        if (MqttServiceConstants.DISCONNECT_ACTION.equals(string2)) {
            disconnected(extras);
        } else if (MqttServiceConstants.TRACE_ACTION.equals(string2)) {
            traceAction(extras);
        } else {
            this.mqttService.traceError("MqttService", "Callback action doesn't exist.");
        }
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, Oxx0xo oxx0xo) {
        return publish(str, oxx0xo, (Object) null, (OoOoXO0.I0Io) null);
    }

    public void registerResources(Context context) {
        if (context != null) {
            this.myContext = context;
            if (this.receiverRegistered) {
                return;
            }
            registerReceiver(this);
        }
    }

    public void setBufferOpts(OoOoXO0.II0xO0 iI0xO0) {
        this.mqttService.setBufferOpts(this.clientHandle, iI0xO0);
    }

    @Override // OoOoXO0.oxoX
    public void setCallback(oOoXoXO oooxoxo) {
        this.callback = oooxoxo;
    }

    @Override // OoOoXO0.oxoX
    public void setManualAcks(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTraceCallback(MqttTraceHandler mqttTraceHandler) {
        this.traceCallback = mqttTraceHandler;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
        MqttService mqttService = this.mqttService;
        if (mqttService != null) {
            mqttService.setTraceEnabled(z);
        }
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i) {
        return subscribe(str, i, (Object) null, (OoOoXO0.I0Io) null);
    }

    public void unregisterResources() {
        if (this.myContext == null || !this.receiverRegistered) {
            return;
        }
        synchronized (this) {
            LocalBroadcastManager.getInstance(this.myContext).unregisterReceiver(this);
            this.receiverRegistered = false;
        }
        if (this.bindedService) {
            try {
                this.myContext.unbindService(this.serviceConnection);
                this.bindedService = false;
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String str) {
        return unsubscribe(str, (Object) null, (OoOoXO0.I0Io) null);
    }

    public MqttAndroidClient(Context context, String str, String str2, oO oOVar) {
        this(context, str, str2, oOVar, Ack.AUTO_ACK);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect(x0xO0oo x0xo0oo) {
        return connect(x0xo0oo, null, null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect(long j) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, null, null);
        this.mqttService.disconnect(this.clientHandle, j, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public void disconnectForcibly(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, Oxx0xo oxx0xo, Object obj, OoOoXO0.I0Io i0Io) {
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, obj, i0Io, oxx0xo);
        mqttDeliveryTokenAndroid.setDelegate(this.mqttService.publish(this.clientHandle, str, oxx0xo, null, storeToken(mqttDeliveryTokenAndroid)));
        return mqttDeliveryTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i, Oxx0IOOO oxx0IOOO) {
        return subscribe(str, i, (Object) null, (OoOoXO0.I0Io) null, oxx0IOOO);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String str, Object obj, OoOoXO0.I0Io i0Io) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io);
        this.mqttService.unsubscribe(this.clientHandle, str, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    public MqttAndroidClient(Context context, String str, String str2, oO oOVar, Ack ack) {
        this.serviceConnection = new MyServiceConnection();
        this.tokenMap = new SparseArray<>();
        this.tokenNumber = 0;
        this.persistence = null;
        this.traceEnabled = false;
        this.receiverRegistered = false;
        this.bindedService = false;
        this.myContext = context;
        this.serverURI = str;
        this.clientId = str2;
        this.persistence = oOVar;
        this.messageAck = ack;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect(x0xO0oo x0xo0oo, Object obj, OoOoXO0.I0Io i0Io) {
        OoOoXO0.I0Io actionCallback;
        II0XooXoX mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io);
        this.connectOptions = x0xo0oo;
        this.connectToken = mqttTokenAndroid;
        if (this.mqttService == null) {
            Intent intent = new Intent();
            intent.setClassName(this.myContext, SERVICE_NAME);
            if (this.myContext.startService(intent) == null && (actionCallback = mqttTokenAndroid.getActionCallback()) != null) {
                actionCallback.onFailure(mqttTokenAndroid, new RuntimeException("cannot start service org.eclipse.paho.android.service.MqttService"));
            }
            this.myContext.bindService(intent, this.serviceConnection, 1);
            if (!this.receiverRegistered) {
                registerReceiver(this);
            }
        } else {
            pool.execute(new Runnable() { // from class: org.eclipse.paho.android.service.MqttAndroidClient.1
                @Override // java.lang.Runnable
                public void run() {
                    MqttAndroidClient.this.doConnect();
                    if (MqttAndroidClient.this.receiverRegistered) {
                        return;
                    }
                    MqttAndroidClient mqttAndroidClient = MqttAndroidClient.this;
                    mqttAndroidClient.registerReceiver(mqttAndroidClient);
                }
            });
        }
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect(long j, Object obj, OoOoXO0.I0Io i0Io) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io);
        this.mqttService.disconnect(this.clientHandle, j, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public void disconnectForcibly(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, byte[] bArr, int i, boolean z) {
        return publish(str, bArr, i, z, null, null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i, Object obj, OoOoXO0.I0Io i0Io) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io, new String[]{str});
        this.mqttService.subscribe(this.clientHandle, str, i, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String[] strArr) {
        return unsubscribe(strArr, (Object) null, (OoOoXO0.I0Io) null);
    }

    public MqttAndroidClient(Context context, String str, String str2, Ack ack) {
        this(context, str, str2, null, ack);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX connect(Object obj, OoOoXO0.I0Io i0Io) {
        return connect(new x0xO0oo(), obj, i0Io);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX disconnect(Object obj, OoOoXO0.I0Io i0Io) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io);
        this.mqttService.disconnect(this.clientHandle, null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public XO publish(String str, byte[] bArr, int i, boolean z, Object obj, OoOoXO0.I0Io i0Io) {
        Oxx0xo oxx0xo = new Oxx0xo(bArr);
        oxx0xo.setQos(i);
        oxx0xo.setRetained(z);
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, obj, i0Io, oxx0xo);
        mqttDeliveryTokenAndroid.setDelegate(this.mqttService.publish(this.clientHandle, str, bArr, i, z, null, storeToken(mqttDeliveryTokenAndroid)));
        return mqttDeliveryTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String str, int i, Object obj, OoOoXO0.I0Io i0Io, Oxx0IOOO oxx0IOOO) {
        return subscribe(new String[]{str}, new int[]{i}, obj, i0Io, new Oxx0IOOO[]{oxx0IOOO});
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX unsubscribe(String[] strArr, Object obj, OoOoXO0.I0Io i0Io) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io);
        this.mqttService.unsubscribe(this.clientHandle, strArr, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr) {
        return subscribe(strArr, iArr, (Object) null, (OoOoXO0.I0Io) null);
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr, Object obj, OoOoXO0.I0Io i0Io) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, obj, i0Io, strArr);
        this.mqttService.subscribe(this.clientHandle, strArr, iArr, (String) null, storeToken(mqttTokenAndroid));
        return mqttTokenAndroid;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr, Object obj, OoOoXO0.I0Io i0Io, Oxx0IOOO[] oxx0IOOOArr) {
        this.mqttService.subscribe(this.clientHandle, strArr, iArr, null, storeToken(new MqttTokenAndroid(this, obj, i0Io, strArr)), oxx0IOOOArr);
        return null;
    }

    @Override // OoOoXO0.oxoX
    public II0XooXoX subscribe(String[] strArr, int[] iArr, Oxx0IOOO[] oxx0IOOOArr) {
        return subscribe(strArr, iArr, (Object) null, (OoOoXO0.I0Io) null, oxx0IOOOArr);
    }
}
