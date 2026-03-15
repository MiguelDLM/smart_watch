package com.example.dialsender.ble;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import androidx.core.app.NotificationCompat;

import com.example.dialsender.MainActivity;
import com.example.dialsender.R;

public class BleForegroundService extends Service {

    public static final String ACTION_DISCONNECT = "com.example.dialsender.ACTION_DISCONNECT";
    private static final int NOTIF_ID = 1001;
    private static final String CHANNEL_ID = "ble_connection";
    private static final long RECONNECT_INTERVAL_MS = 30_000L;

    private Handler handler;
    private BleManager bleManager;

    private final Runnable reconnectRunnable = new Runnable() {
        @Override
        public void run() {
            if (bleManager != null && !bleManager.isSessionReady()) {
                String addr = bleManager.getLastDeviceAddress();
                if (addr != null) bleManager.reconnect(addr);
            }
            updateNotification(bleManager != null && bleManager.isConnected());
            handler.postDelayed(reconnectRunnable, RECONNECT_INTERVAL_MS);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper());
        bleManager = BleManager.getInstance(this);
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && ACTION_DISCONNECT.equals(intent.getAction())) {
            bleManager.disconnect();
            stopSelf();
            return START_NOT_STICKY;
        }
        startForeground(NOTIF_ID, buildNotification(bleManager.isConnected()));
        handler.removeCallbacks(reconnectRunnable);
        scheduleReconnect();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(reconnectRunnable);
    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID, "Conexión con reloj", NotificationManager.IMPORTANCE_LOW);
        channel.setDescription("Mantiene la conexión BLE activa en segundo plano");
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
    }

    private Notification buildNotification(boolean connected) {
        Intent openApp = new Intent(this, MainActivity.class);
        PendingIntent openPi = PendingIntent.getActivity(this, 0, openApp,
                PendingIntent.FLAG_IMMUTABLE);

        Intent disconnectIntent = new Intent(this, BleForegroundService.class);
        disconnectIntent.setAction(ACTION_DISCONNECT);
        PendingIntent disconnectPi = PendingIntent.getService(this, 1, disconnectIntent,
                PendingIntent.FLAG_IMMUTABLE);

        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Dial Studio")
                .setContentText(connected ? "Reloj conectado" : "Buscando reloj...")
                .setContentIntent(openPi)
                .addAction(0, "Desconectar", disconnectPi)
                .setOngoing(true)
                .build();
    }

    public void updateNotification(boolean connected) {
        NotificationManager nm = getSystemService(NotificationManager.class);
        nm.notify(NOTIF_ID, buildNotification(connected));
    }

    private void scheduleReconnect() {
        handler.postDelayed(reconnectRunnable, RECONNECT_INTERVAL_MS);
    }
}
