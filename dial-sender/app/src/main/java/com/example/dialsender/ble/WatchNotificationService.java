package com.example.dialsender.ble;

import android.app.Notification;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import androidx.core.app.NotificationCompat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WatchNotificationService extends NotificationListenerService {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_NOTIF_PACKAGES = "notif_enabled_packages";
    private static final int CATEGORY_CALL = 1;
    private static final int CATEGORY_MESSAGE = 127;

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (sbn == null) return;

        BleManager ble = BleManager.getInstance(getApplicationContext());
        if (!ble.isSessionReady()) return;

        String pkg = sbn.getPackageName();

        // Skip our own notifications
        if (pkg.equals(getPackageName())) return;

        // Check whitelist
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String saved = prefs.getString(PREF_NOTIF_PACKAGES, "");
        Set<String> enabled = new HashSet<>(Arrays.asList(saved.split(",")));
        if (!enabled.contains(pkg)) return;

        Notification notif = sbn.getNotification();
        Bundle extras = notif.extras;

        String title = extras.getString(NotificationCompat.EXTRA_TITLE, "");
        CharSequence bigText = extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        String content = bigText != null ? bigText.toString()
                : extras.getString(NotificationCompat.EXTRA_TEXT, "");

        int category = Notification.CATEGORY_CALL.equals(notif.category) ? CATEGORY_CALL : CATEGORY_MESSAGE;

        ble.sendNotification(category, title, content, pkg);
    }
}
