package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes10.dex */
public class d {
    private static d I;
    private static final byte[] Z = new byte[0];
    private Context B;
    private a S;
    private boolean V = false;
    private CopyOnWriteArrayList<WeakReference<b>> C = new CopyOnWriteArrayList<>();

    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            fb.V("ExSplashStartReceiver", "onReceive");
            if (intent == null) {
                return;
            }
            try {
                if (x.br.equals(intent.getAction())) {
                    d.this.V = true;
                    d.this.Z();
                    context.removeStickyBroadcast(intent);
                }
            } catch (Throwable th) {
                fb.I("ExSplashStartReceiver", "ExSplashBeginReceiver err: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Code();
    }

    private d(Context context) {
        this.B = context.getApplicationContext();
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (Z) {
            try {
                if (I == null) {
                    I = new d(context);
                }
                dVar = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.C.isEmpty()) {
            return;
        }
        Iterator<WeakReference<b>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() != null) {
                next.get().Code();
            }
        }
    }

    public void I() {
        String str;
        try {
            fb.V("ExSplashStartReceiver", "unregister receiver");
            a aVar = this.S;
            if (aVar != null) {
                this.B.unregisterReceiver(aVar);
                this.S = null;
            }
        } catch (IllegalStateException unused) {
            str = "unregisterReceiver IllegalStateException";
            fb.I("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "unregisterReceiver exception";
            fb.I("ExSplashStartReceiver", str);
        }
    }

    public void V() {
        String str;
        try {
            I();
            if (!ck.B(this.B)) {
                fb.I("ExSplashStartReceiver", "not inner device, no need to register");
                return;
            }
            IntentFilter intentFilter = new IntentFilter(x.br);
            Intent registerReceiver = this.B.registerReceiver(null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (registerReceiver != null && registerReceiver.getAction() != null && registerReceiver.getAction().equals(x.br)) {
                fb.V("ExSplashStartReceiver", "isExSplashStart");
                this.V = true;
                this.B.removeStickyBroadcast(registerReceiver);
            }
            if (this.S == null) {
                this.S = new a();
            }
            fb.V("ExSplashStartReceiver", "register receiver");
            this.B.registerReceiver(this.S, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            fb.I("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "registerReceiver Exception";
            fb.I("ExSplashStartReceiver", str);
        }
    }

    public void Code(b bVar) {
        if (bVar != null) {
            this.C.add(new WeakReference<>(bVar));
        }
    }

    public void V(b bVar) {
        try {
            CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = this.C;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<WeakReference<b>> it = this.C.iterator();
                while (it.hasNext()) {
                    WeakReference<b> next = it.next();
                    b bVar2 = next.get();
                    if (bVar2 == null || bVar2 == bVar) {
                        this.C.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            fb.V("ExSplashStartReceiver", "removeStartListener err: %s", th.getClass().getSimpleName());
        }
    }

    public void Code(boolean z) {
        this.V = z;
    }
}
