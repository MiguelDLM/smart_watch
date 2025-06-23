package com.baidu.ar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

/* loaded from: classes7.dex */
public class lr extends BroadcastReceiver {
    private a Eq;

    /* loaded from: classes7.dex */
    public interface a {
        void aa(int i);
    }

    public void a(a aVar) {
        this.Eq = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        a aVar;
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            intent.getIntExtra("wifi_state", 0);
        }
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) == null) {
            return;
        }
        if (NetworkInfo.State.CONNECTED != networkInfo.getState() || !networkInfo.isAvailable()) {
            a aVar2 = this.Eq;
            if (aVar2 != null) {
                aVar2.aa(2);
                return;
            }
            return;
        }
        if ((networkInfo.getType() == 1 || networkInfo.getType() == 0) && (aVar = this.Eq) != null) {
            aVar.aa(1);
        }
    }

    public void removeAllCallback() {
        this.Eq = null;
    }
}
