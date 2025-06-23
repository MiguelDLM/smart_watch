package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.b;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes11.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> ayp = new LinkedBlockingQueue<>(1);
    private ServiceConnection ayn = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.ayp.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.mContext.bindService(intent, this.ayn, 1)) {
                try {
                    b.a aVar = new b.a(this.ayp.take());
                    str = aVar.Fi();
                    aVar.Fj();
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.ayn);
                    throw th;
                }
                context.unbindService(this.ayn);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
