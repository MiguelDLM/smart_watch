package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.a;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes11.dex */
public final class a {
    private final LinkedBlockingQueue<IBinder> aym = new LinkedBlockingQueue<>(1);
    private ServiceConnection ayn = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.aym.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.mContext.bindService(intent, this.ayn, 1)) {
                try {
                    try {
                        str = new a.C0855a(this.aym.take()).getID();
                        context = this.mContext;
                    } catch (Exception unused) {
                        context = this.mContext;
                    }
                    context.unbindService(this.ayn);
                } catch (Throwable th) {
                    this.mContext.unbindService(this.ayn);
                    throw th;
                }
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
