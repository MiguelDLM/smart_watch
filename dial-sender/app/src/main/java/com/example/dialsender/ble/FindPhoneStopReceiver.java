package com.example.dialsender.ble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** Handles the "Detener" action from the find-phone notification. */
public class FindPhoneStopReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (BleManager.ACTION_FIND_PHONE_STOP.equals(intent.getAction())) {
            BleManager.getInstance(context).stopFindPhoneAlert();
        }
    }
}
