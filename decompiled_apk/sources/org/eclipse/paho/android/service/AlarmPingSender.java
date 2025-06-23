package org.eclipse.paho.android.service;

import OoOoXO0.II0XooXoX;
import OoOoXO0.OxxIIOOXO;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.C;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class AlarmPingSender implements OxxIIOOXO {
    private static final String TAG = "AlarmPingSender";
    private BroadcastReceiver alarmReceiver;
    private Ox0XO.II0xO0 comms;
    private volatile boolean hasStarted = false;
    private PendingIntent pendingIntent;
    private MqttService service;
    private AlarmPingSender that;

    /* loaded from: classes6.dex */
    public class AlarmReceiver extends BroadcastReceiver {
        private final String wakeLockTag;
        private PowerManager.WakeLock wakelock;

        public AlarmReceiver() {
            this.wakeLockTag = MqttServiceConstants.PING_WAKELOCK + AlarmPingSender.this.that.comms.o00().getClientId();
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            Log.d(AlarmPingSender.TAG, "Sending Ping at:" + System.currentTimeMillis());
            PowerManager.WakeLock newWakeLock = ((PowerManager) AlarmPingSender.this.service.getSystemService("power")).newWakeLock(1, this.wakeLockTag);
            this.wakelock = newWakeLock;
            newWakeLock.acquire();
            if (AlarmPingSender.this.comms.ooOOo0oXI(new OoOoXO0.I0Io() { // from class: org.eclipse.paho.android.service.AlarmPingSender.AlarmReceiver.1
                @Override // OoOoXO0.I0Io
                public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
                    Log.d(AlarmPingSender.TAG, "Failure. Release lock(" + AlarmReceiver.this.wakeLockTag + "):" + System.currentTimeMillis());
                    AlarmReceiver.this.wakelock.release();
                }

                @Override // OoOoXO0.I0Io
                public void onSuccess(II0XooXoX iI0XooXoX) {
                    Log.d(AlarmPingSender.TAG, "Success. Release lock(" + AlarmReceiver.this.wakeLockTag + "):" + System.currentTimeMillis());
                    AlarmReceiver.this.wakelock.release();
                }
            }) == null && this.wakelock.isHeld()) {
                this.wakelock.release();
            }
        }
    }

    public AlarmPingSender(MqttService mqttService) {
        if (mqttService == null) {
            throw new IllegalArgumentException("Neither service nor client can be null.");
        }
        this.service = mqttService;
        this.that = this;
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void init(Ox0XO.II0xO0 iI0xO0) {
        this.comms = iI0xO0;
        this.alarmReceiver = new AlarmReceiver();
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void schedule(long j) {
        boolean canScheduleExactAlarms;
        long currentTimeMillis = System.currentTimeMillis() + j;
        Log.d(TAG, "Schedule next alarm at " + currentTimeMillis);
        AlarmManager alarmManager = (AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            Log.d(TAG, "Alarm scheule using setExact, delay: " + j);
            alarmManager.setExact(0, currentTimeMillis, this.pendingIntent);
            return;
        }
        Log.d(TAG, "Alarm scheule using setExactAndAllowWhileIdle, next: " + j);
        if (i >= 31) {
            if (ContextCompat.checkSelfPermission(this.service, "android.permission.SCHEDULE_EXACT_ALARM") != 0) {
                Log.e(TAG, "No permission SCHEDULE_EXACT_ALARM ");
                return;
            } else {
                canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
                if (!canScheduleExactAlarms) {
                    return;
                }
            }
        }
        alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis, this.pendingIntent);
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void start() {
        MqttService mqttService;
        Intent intent;
        int i;
        String str = MqttServiceConstants.PING_SENDER + this.comms.o00().getClientId();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 33) {
            Log.d(TAG, "Register alarmreceiver to MqttService--24--" + str);
            this.service.registerReceiver(this.alarmReceiver, new IntentFilter(str), 2);
        } else {
            Log.d(TAG, "Register alarmreceiver to MqttService--" + str);
            this.service.registerReceiver(this.alarmReceiver, new IntentFilter(str));
        }
        if (i2 >= 31) {
            mqttService = this.service;
            intent = new Intent(str);
            i = 201326592;
        } else {
            mqttService = this.service;
            intent = new Intent(str);
            i = C.BUFFER_FLAG_FIRST_SAMPLE;
        }
        this.pendingIntent = PendingIntent.getBroadcast(mqttService, 0, intent, i);
        schedule(this.comms.XI0IXoo());
        this.hasStarted = true;
    }

    @Override // OoOoXO0.OxxIIOOXO
    public void stop() {
        Log.d(TAG, "Unregister alarmreceiver to MqttService" + this.comms.o00().getClientId());
        if (this.hasStarted) {
            if (this.pendingIntent != null) {
                ((AlarmManager) this.service.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.pendingIntent);
            }
            this.hasStarted = false;
            try {
                this.service.unregisterReceiver(this.alarmReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
