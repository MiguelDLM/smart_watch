package com.baidu.navisdk.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.widget.Toast;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes7.dex */
public class BNBluetoothAudio {
    private static final String g = com.baidu.navisdk.bluetooth.b.h;

    /* renamed from: a, reason: collision with root package name */
    private AudioManager f6664a;
    private Context b;
    private boolean c;
    private g d;
    private BroadcastReceiver e = new BroadcastReceiver() { // from class: com.baidu.navisdk.bluetooth.BNBluetoothAudio.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            LogUtil.e(BNBluetoothAudio.g, "openSCO onReceive state = " + intExtra);
            if (1 == intExtra) {
                if (Build.VERSION.SDK_INT >= 30) {
                    BNBluetoothAudio.this.f6664a.setSpeakerphoneOn(false);
                }
                BNBluetoothAudio.this.f6664a.setBluetoothScoOn(true);
                if (Build.MODEL.equals("e1810c_v75_gwdz1")) {
                    BNBluetoothAudio.this.f6664a.setMode(2);
                } else {
                    BNBluetoothAudio.this.f6664a.setMode(3);
                }
                com.baidu.navisdk.framework.b.l(3);
                BNBluetoothAudio.this.c(1);
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) BNBluetoothAudio.this.f, true);
                try {
                    BNBluetoothAudio.this.b.unregisterReceiver(BNBluetoothAudio.this.e);
                } catch (IllegalArgumentException e2) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(BNBluetoothAudio.g, e2.getMessage());
                    }
                }
            }
        }
    };
    private com.baidu.navisdk.util.worker.f f = new b("open_sco_timeout", null);

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6667a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, int i) {
            super(str, str2);
            this.f6667a = i;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            int i = this.f6667a;
            if (i == 1) {
                BNBluetoothAudio.this.e();
                return null;
            }
            if (i == 2) {
                BNBluetoothAudio.this.f();
                return null;
            }
            BNBluetoothAudio.this.d();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "startBluetoothSco timeout");
            }
            BNBluetoothAudio.this.b(1);
            try {
                Toast.makeText(BNBluetoothAudio.this.b, "蓝牙电话声道设置失败", 1).show();
                BNBluetoothAudio.this.b.unregisterReceiver(BNBluetoothAudio.this.e);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            BNBluetoothAudio.this.i();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6670a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, int i) {
            super(str, str2);
            this.f6670a = i;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (BNBluetoothAudio.this.d != null) {
                BNBluetoothAudio.this.d.a(this.f6670a);
                BNBluetoothAudio.this.d = null;
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6671a;
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, int i, int i2) {
            super(str, str2);
            this.f6671a = i;
            this.b = i2;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (BNBluetoothAudio.this.d != null) {
                BNBluetoothAudio.this.d.a(this.f6671a, this.b);
                BNBluetoothAudio.this.d = null;
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6672a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, String str2, int i) {
            super(str, str2);
            this.f6672a = i;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (BNBluetoothAudio.this.d != null) {
                BNBluetoothAudio.this.d.a(this.f6672a, 0);
                BNBluetoothAudio.this.d = null;
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface g {
        void a(int i);

        void a(int i, int i2);
    }

    public BNBluetoothAudio(Context context) {
        this.b = context;
        this.f6664a = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.baidu.navisdk.framework.b.l(3);
        if (this.f6664a.isBluetoothScoOn()) {
            a(0);
            return;
        }
        this.f6664a.setMode(0);
        if (!this.f6664a.isSpeakerphoneOn()) {
            this.f6664a.setSpeakerphoneOn(true);
        }
        c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f6664a.isBluetoothScoOn()) {
            c(1);
        } else if (this.f6664a.isBluetoothScoAvailableOffCall()) {
            LogUtil.e(g, "openSCO startBluetoothSco");
            h();
        } else {
            b(1);
            LogUtil.e(g, "openSCO not support BluetoothScoAvailableOffCall");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!com.baidu.navisdk.bluetooth.a.a()) {
            b(2);
            return;
        }
        if (this.f6664a.isBluetoothScoOn()) {
            a(3);
            return;
        }
        this.f6664a.setMode(3);
        if (this.f6664a.getMode() != 3) {
            b(2);
            return;
        }
        if (!this.f6664a.isSpeakerphoneOn()) {
            this.f6664a.setSpeakerphoneOn(true);
        }
        com.baidu.navisdk.framework.b.l(3);
        c(2);
    }

    private boolean g() {
        boolean isStreamMute;
        if (Build.VERSION.SDK_INT >= 23) {
            isStreamMute = this.f6664a.isStreamMute(3);
            return isStreamMute;
        }
        try {
            return ((Boolean) AudioManager.class.getMethod("isStreamMute", Integer.TYPE).invoke(this.f6664a, 3)).booleanValue();
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    private void h() {
        this.b.registerReceiver(this.e, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        this.f6664a.startBluetoothSco();
        com.baidu.navisdk.util.worker.c.a().b(this.f, new com.baidu.navisdk.util.worker.e(2, 0), 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.c) {
            return;
        }
        this.c = true;
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new d("modeSwitchSuccess", null, i), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    public void b() {
        LogUtil.e(g, "resetAudio");
        com.baidu.navisdk.framework.b.l(3);
        AudioManager audioManager = this.f6664a;
        if (audioManager != null) {
            audioManager.setMode(0);
            if (this.f6664a.isSpeakerphoneOn()) {
                return;
            }
            this.f6664a.setSpeakerphoneOn(true);
        }
    }

    public void a(int i, g gVar) {
        this.d = gVar;
        if (a()) {
            a(i, 1);
        } else {
            com.baidu.navisdk.util.worker.c.a().c(new a("BNBluetoothAudio-setPlayMode", null, i), new com.baidu.navisdk.util.worker.e(99, 0));
        }
    }

    private void a(final int i) {
        final boolean g2 = g();
        if (!g2) {
            a(true);
            this.c = false;
            a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        this.f6664a.stopBluetoothSco();
        this.b.registerReceiver(new BroadcastReceiver() { // from class: com.baidu.navisdk.bluetooth.BNBluetoothAudio.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                LogUtil.e(com.baidu.navisdk.bluetooth.b.h, "closeSCO onReceive state = " + intExtra);
                if (intExtra == 0 || !BNBluetoothAudio.this.f6664a.isBluetoothScoOn()) {
                    BNBluetoothAudio.this.f6664a.setBluetoothScoOn(false);
                    BNBluetoothAudio.this.f6664a.setMode(i);
                    com.baidu.navisdk.framework.b.l(3);
                    if (!BNBluetoothAudio.this.f6664a.isSpeakerphoneOn()) {
                        BNBluetoothAudio.this.f6664a.setSpeakerphoneOn(true);
                    }
                    boolean z = g2;
                    if (!z) {
                        BNBluetoothAudio.this.a(z);
                    }
                    if (i == 0) {
                        BNBluetoothAudio.this.c(0);
                    } else {
                        BNBluetoothAudio.this.c(2);
                    }
                    try {
                        BNBluetoothAudio.this.b.unregisterReceiver(this);
                    } catch (IllegalArgumentException e2) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e(BNBluetoothAudio.g, e2.getMessage());
                        }
                    }
                }
            }
        }, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new f("modeSwitchFail", null, i), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    public boolean a() {
        return a0.f(this.b);
    }

    private void a(long j) {
        com.baidu.navisdk.util.worker.c.a().a(new c("BNBluetoothAudio-setPlayMode", null), new com.baidu.navisdk.util.worker.e(99, 0), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            if (!z) {
                this.f6664a.adjustStreamVolume(3, 1, 8);
            }
            this.f6664a.setStreamMute(3, z);
        } else if (z) {
            this.f6664a.adjustStreamVolume(3, -100, 8);
        } else {
            this.f6664a.adjustStreamVolume(3, 1, 8);
            this.f6664a.adjustStreamVolume(3, 100, 8);
        }
    }

    private void a(int i, int i2) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new e("modeSwitchFail", null, i, i2), new com.baidu.navisdk.util.worker.e(99, 0));
    }
}
