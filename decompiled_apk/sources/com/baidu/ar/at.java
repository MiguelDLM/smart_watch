package com.baidu.ar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.ar.au;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class at extends BroadcastReceiver {
    private static final String TAG = "at";
    private static boolean hZ = false;
    private static au.a ia;
    private static ArrayList<aq> ib = new ArrayList<>();
    private static volatile BroadcastReceiver ic;

    public static void a(aq aqVar) {
        if (ib == null) {
            ib = new ArrayList<>();
        }
        ib.add(aqVar);
    }

    public static void b(aq aqVar) {
        ArrayList<aq> arrayList = ib;
        if (arrayList == null || !arrayList.contains(aqVar)) {
            return;
        }
        ib.remove(aqVar);
    }

    private static BroadcastReceiver bf() {
        if (ic == null) {
            synchronized (at.class) {
                try {
                    if (ic == null) {
                        ic = new at();
                    }
                } finally {
                }
            }
        }
        return ic;
    }

    public static boolean bg() {
        return hZ;
    }

    private void bh() {
        if (ib.isEmpty()) {
            return;
        }
        int size = ib.size();
        for (int i = 0; i < size; i++) {
            aq aqVar = ib.get(i);
            if (aqVar != null) {
                if (bg()) {
                    aqVar.a(ia);
                } else {
                    aqVar.aL();
                }
            }
        }
    }

    public static void c(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(bf(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ic = this;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) || "com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            if (au.d(context)) {
                Log.e(getClass().getName(), "<--- network connected --->");
                hZ = true;
                ia = au.e(context);
            } else {
                Log.e(getClass().getName(), "<--- network disconnected --->");
                hZ = false;
            }
            bh();
        }
    }
}
