package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class gy {
    public static final float Code = -1.0f;
    private static final String I = "android.media.VOLUME_CHANGED_ACTION";
    private static final String V = "VolumeChangeObserver";
    private static final String Z = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private b B;
    private a C;
    private boolean D = false;
    private AudioManager F;
    private Context S;

    /* loaded from: classes10.dex */
    public static class a extends BroadcastReceiver {
        private WeakReference<gy> Code;

        public a(gy gyVar) {
            this.Code = new WeakReference<>(gyVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            gy gyVar;
            b I;
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if (intent.getIntExtra(gy.Z, 0) != 3) {
                    }
                    gyVar = this.Code.get();
                    if (gyVar != null || (I = gyVar.I()) == null) {
                    }
                    I.Code();
                    return;
                }
                if (intent.getIntExtra(gy.Z, 0) != 1) {
                    return;
                }
                gyVar = this.Code.get();
                if (gyVar != null) {
                }
            } catch (Throwable th) {
                fb.I(gy.V, "onReceive error:" + th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Code();
    }

    public gy(Context context) {
        this.S = context;
        this.F = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b I() {
        return this.B;
    }

    public float Code(boolean z) {
        AudioManager audioManager = this.F;
        if (audioManager != null) {
            return gz.Code(audioManager, z);
        }
        return 0.0f;
    }

    public void V() {
        if (this.D) {
            try {
                this.S.unregisterReceiver(this.C);
            } catch (Exception e) {
                fb.V(V, "unregisterReceiver, " + e.getClass().getSimpleName());
            }
            this.B = null;
            this.D = false;
        }
    }

    public void Code() {
        if (this.C == null) {
            this.C = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            try {
                this.S.registerReceiver(this.C, intentFilter);
            } catch (Exception e) {
                fb.V(V, "registerReceiver, " + e.getClass().getSimpleName());
            }
            this.D = true;
        }
    }

    public void Code(b bVar) {
        this.B = bVar;
    }
}
