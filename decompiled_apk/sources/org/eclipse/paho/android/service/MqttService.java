package org.eclipse.paho.android.service;

import OoOoXO0.Oxx0IOOO;
import OoOoXO0.Oxx0xo;
import OoOoXO0.XO;
import OoOoXO0.oO;
import OoOoXO0.x0xO0oo;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"Registered"})
/* loaded from: classes6.dex */
public class MqttService extends Service implements MqttTraceHandler {
    public static final String TAG = "MqttService";
    private BackgroundDataPreferenceReceiver backgroundDataPreferenceMonitor;
    public MessageStore messageStore;
    private MqttServiceBinder mqttServiceBinder;
    private NetworkConnectionIntentReceiver networkConnectionMonitor;
    private String traceCallbackId;
    private boolean traceEnabled = false;
    private volatile boolean backgroundDataEnabled = true;
    private Map<String, MqttConnection> connections = new ConcurrentHashMap();

    /* loaded from: classes6.dex */
    public class BackgroundDataPreferenceReceiver extends BroadcastReceiver {
        private BackgroundDataPreferenceReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) MqttService.this.getSystemService("connectivity");
            MqttService.this.traceDebug("MqttService", "Reconnect since BroadcastReceiver.");
            if (!connectivityManager.getBackgroundDataSetting()) {
                MqttService.this.backgroundDataEnabled = false;
                MqttService.this.notifyClientsOffline();
            } else {
                if (MqttService.this.backgroundDataEnabled) {
                    return;
                }
                MqttService.this.backgroundDataEnabled = true;
                MqttService.this.reconnect();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class NetworkConnectionIntentReceiver extends BroadcastReceiver {
        private NetworkConnectionIntentReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            MqttService.this.traceDebug("MqttService", "Internal network status receive.");
            PowerManager.WakeLock newWakeLock = ((PowerManager) MqttService.this.getSystemService("power")).newWakeLock(1, "MQTT");
            newWakeLock.acquire();
            MqttService.this.traceDebug("MqttService", "Reconnect for Network recovery.");
            if (MqttService.this.isOnline()) {
                MqttService.this.traceDebug("MqttService", "Online,reconnect.");
                MqttService.this.reconnect();
            } else {
                MqttService.this.notifyClientsOffline();
            }
            newWakeLock.release();
        }
    }

    private MqttConnection getConnection(String str) {
        MqttConnection mqttConnection = this.connections.get(str);
        if (mqttConnection != null) {
            return mqttConnection;
        }
        throw new IllegalArgumentException("Invalid ClientHandle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyClientsOffline() {
        Iterator<MqttConnection> it = this.connections.values().iterator();
        while (it.hasNext()) {
            it.next().offline();
        }
    }

    private void registerBroadcastReceivers() {
        if (this.networkConnectionMonitor == null) {
            NetworkConnectionIntentReceiver networkConnectionIntentReceiver = new NetworkConnectionIntentReceiver();
            this.networkConnectionMonitor = networkConnectionIntentReceiver;
            registerReceiver(networkConnectionIntentReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void traceCallback(String str, String str2, String str3) {
        if (this.traceCallbackId == null || !this.traceEnabled) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.TRACE_ACTION);
        bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, str);
        bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str2);
        bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str3);
        callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
    }

    private void unregisterBroadcastReceivers() {
        NetworkConnectionIntentReceiver networkConnectionIntentReceiver = this.networkConnectionMonitor;
        if (networkConnectionIntentReceiver != null) {
            unregisterReceiver(networkConnectionIntentReceiver);
            this.networkConnectionMonitor = null;
        }
    }

    public Status acknowledgeMessageArrival(String str, String str2) {
        return this.messageStore.discardArrived(str, str2) ? Status.OK : Status.ERROR;
    }

    public void callbackToActivity(String str, Status status, Bundle bundle) {
        Intent intent = new Intent(MqttServiceConstants.CALLBACK_TO_ACTIVITY);
        if (str != null) {
            intent.putExtra(MqttServiceConstants.CALLBACK_CLIENT_HANDLE, str);
        }
        intent.putExtra(MqttServiceConstants.CALLBACK_STATUS, status);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void close(String str) {
        getConnection(str).close();
    }

    public void connect(String str, x0xO0oo x0xo0oo, String str2, String str3) {
        getConnection(str).connect(x0xo0oo, null, str3);
    }

    public void deleteBufferedMessage(String str, int i) {
        getConnection(str).deleteBufferedMessage(i);
    }

    public void disconnect(String str, long j, String str2, String str3) {
        getConnection(str).disconnect(j, str2, str3);
        this.connections.remove(str);
        stopSelf();
    }

    public Oxx0xo getBufferedMessage(String str, int i) {
        return getConnection(str).getBufferedMessage(i);
    }

    public int getBufferedMessageCount(String str) {
        return getConnection(str).getBufferedMessageCount();
    }

    public String getClient(String str, String str2, String str3, oO oOVar) {
        String str4 = str + ":" + str2 + ":" + str3;
        if (!this.connections.containsKey(str4)) {
            this.connections.put(str4, new MqttConnection(this, str, str2, oOVar, str4));
        }
        return str4;
    }

    public XO[] getPendingDeliveryTokens(String str) {
        return getConnection(str).getPendingDeliveryTokens();
    }

    public boolean isConnected(String str) {
        return getConnection(str).isConnected();
    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && this.backgroundDataEnabled;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.mqttServiceBinder.setActivityToken(intent.getStringExtra(MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN));
        return this.mqttServiceBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mqttServiceBinder = new MqttServiceBinder(this);
        this.messageStore = new DatabaseMessageStore(this, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Iterator<MqttConnection> it = this.connections.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect(null, null);
        }
        if (this.mqttServiceBinder != null) {
            this.mqttServiceBinder = null;
        }
        unregisterBroadcastReceivers();
        MessageStore messageStore = this.messageStore;
        if (messageStore != null) {
            messageStore.close();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        registerBroadcastReceivers();
        return 1;
    }

    public XO publish(String str, String str2, Oxx0xo oxx0xo, String str3, String str4) {
        return getConnection(str).publish(str2, oxx0xo, str3, str4);
    }

    public void reconnect() {
        traceDebug("MqttService", "Reconnect to server, client size=" + this.connections.size());
        for (MqttConnection mqttConnection : this.connections.values()) {
            traceDebug("Reconnect Client:", mqttConnection.getClientId() + IOUtils.DIR_SEPARATOR_UNIX + mqttConnection.getServerURI());
            if (isOnline()) {
                mqttConnection.reconnect();
            }
        }
    }

    public void setBufferOpts(String str, OoOoXO0.II0xO0 iI0xO0) {
        getConnection(str).setBufferOpts(iI0xO0);
    }

    public void setTraceCallbackId(String str) {
        this.traceCallbackId = str;
    }

    public void setTraceEnabled(boolean z) {
        this.traceEnabled = z;
    }

    public void subscribe(String str, String str2, int i, String str3, String str4) {
        getConnection(str).subscribe(str2, i, str3, str4);
    }

    @Override // org.eclipse.paho.android.service.MqttTraceHandler
    public void traceDebug(String str, String str2) {
        traceCallback("debug", str, str2);
    }

    @Override // org.eclipse.paho.android.service.MqttTraceHandler
    public void traceError(String str, String str2) {
        traceCallback("error", str, str2);
    }

    @Override // org.eclipse.paho.android.service.MqttTraceHandler
    public void traceException(String str, String str2, Exception exc) {
        if (this.traceCallbackId != null) {
            Bundle bundle = new Bundle();
            bundle.putString(MqttServiceConstants.CALLBACK_ACTION, MqttServiceConstants.TRACE_ACTION);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_SEVERITY, MqttServiceConstants.TRACE_EXCEPTION);
            bundle.putString(MqttServiceConstants.CALLBACK_ERROR_MESSAGE, str2);
            bundle.putSerializable(MqttServiceConstants.CALLBACK_EXCEPTION, exc);
            bundle.putString(MqttServiceConstants.CALLBACK_TRACE_TAG, str);
            callbackToActivity(this.traceCallbackId, Status.ERROR, bundle);
        }
    }

    public void unsubscribe(String str, String str2, String str3, String str4) {
        getConnection(str).unsubscribe(str2, str3, str4);
    }

    public void disconnect(String str, String str2, String str3) {
        getConnection(str).disconnect(str2, str3);
        this.connections.remove(str);
        stopSelf();
    }

    public XO publish(String str, String str2, byte[] bArr, int i, boolean z, String str3, String str4) {
        return getConnection(str).publish(str2, bArr, i, z, str3, str4);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3) {
        getConnection(str).subscribe(strArr, iArr, str2, str3);
    }

    public void unsubscribe(String str, String[] strArr, String str2, String str3) {
        getConnection(str).unsubscribe(strArr, str2, str3);
    }

    public void subscribe(String str, String[] strArr, int[] iArr, String str2, String str3, Oxx0IOOO[] oxx0IOOOArr) {
        getConnection(str).subscribe(strArr, iArr, str2, str3, oxx0IOOOArr);
    }
}
