package com.baidu.navisdk.ui.routeguide.tts;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.listener.BNVolumeChangeObserver;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes8.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private int f9140a;
    private boolean b;
    private BNVolumeChangeObserver c;

    /* renamed from: com.baidu.navisdk.ui.routeguide.tts.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0484a implements BNVolumeChangeObserver.a {
        public C0484a() {
        }

        @Override // com.baidu.navisdk.util.listener.BNVolumeChangeObserver.a
        public void a(int i, int i2) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNTTSVolumeController", "onVolumeChange currentVolume: " + i + ",preVolume: " + i2);
            }
            if (a.this.b && i < i2) {
                a.this.a(a.this.a(TTSPlayerControl.getCurrentVolume()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f9142a = new a(null);
    }

    public /* synthetic */ a(C0484a c0484a) {
        this();
    }

    private void b() {
        BNVolumeChangeObserver bNVolumeChangeObserver = this.c;
        if (bNVolumeChangeObserver != null) {
            bNVolumeChangeObserver.a();
            this.c = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.tts.c
    public void i() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "resetTTSVolume2DefaultIfNeed isSupportTTSVolumeIncrease: " + this.b);
        }
        b();
        if (!this.b) {
            return;
        }
        int currentVolume = TTSPlayerControl.getCurrentVolume();
        int a2 = com.baidu.navisdk.ui.routeguide.tts.b.DEFAULT_VOLUME.a();
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "resetTTSVolume2Default currTTSVolume: " + currentVolume + ", defaultVolume:" + a2);
        }
        if (currentVolume != a2) {
            TTSPlayerControl.setTTSVolume(a2);
        }
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "resetTTSVolume2DefaultIfNeed current tts volume: " + TTSPlayerControl.getCurrentVolume());
        }
    }

    private a() {
        this.f9140a = 9;
        this.b = false;
    }

    public static c a() {
        return b.f9142a;
    }

    @Override // com.baidu.navisdk.ui.routeguide.tts.c
    public void a(Context context, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "initTTSVolume last tts volume: " + this.f9140a + ", isSupportOperateTTSVolume:" + z + ", context:" + context);
        }
        this.b = z;
        int currentVolume = TTSPlayerControl.getCurrentVolume();
        if (z) {
            AudioManager audioManager = context != null ? (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO) : null;
            if (audioManager != null) {
                int streamVolume = audioManager.getStreamVolume(3);
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                if (gVar.d()) {
                    gVar.e("BNTTSVolumeController", "initTTSVolume current volume: " + streamVolume + ",maxVolume: " + streamMaxVolume);
                    gVar.e("BNTTSVolumeController", "initTTSVolume current TTS volume: " + currentVolume + ",setTTSVolume: " + this.f9140a);
                }
                if (streamVolume == streamMaxVolume) {
                    int i = this.f9140a;
                    if (currentVolume != i) {
                        TTSPlayerControl.setTTSVolume(i);
                    }
                } else {
                    this.f9140a = 9;
                    VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
                    if (currentVolume != 9 && o != null && currentVolume != o.getTTSVolParam()) {
                        TTSPlayerControl.setTTSVolume(9);
                    }
                }
            } else {
                if (gVar.d()) {
                    gVar.e("BNTTSVolumeController", "initTTSVolume audio == null");
                }
                TTSPlayerControl.setTTSVolume(9);
            }
            b();
            BNVolumeChangeObserver bNVolumeChangeObserver = new BNVolumeChangeObserver();
            this.c = bNVolumeChangeObserver;
            bNVolumeChangeObserver.a(context, new C0484a());
        } else {
            VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
            if (currentVolume != 9 && o2 != null && currentVolume != o2.getTTSVolParam()) {
                TTSPlayerControl.setTTSVolume(9);
            }
        }
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "initTTSVolume last tts volume to: " + TTSPlayerControl.getCurrentVolume());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.tts.c
    public void a(Context context, int i, int i2, boolean z, int i3, int i4) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "plusMinusTTSVolume(), lastSysVolume = " + i + ", currSysVolume = " + i2 + ", maxSysVolume = " + i3 + ", currTTSVolume = " + i4 + ", isUpVolume = " + z);
        }
        com.baidu.navisdk.ui.routeguide.tts.b a2 = a(i4);
        if (a2 == null) {
            return;
        }
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "plusMinusTTSVolume currRegulation: " + a2);
        }
        if (!z) {
            a(a2);
        } else if (i == i3) {
            com.baidu.navisdk.ui.routeguide.tts.b d = a2.d();
            if (gVar.d()) {
                gVar.e("BNTTSVolumeController", "plusMinusTTSVolume plusVolume: " + d);
            }
            if (d != null) {
                TTSPlayerControl.setTTSVolume(d.a());
                TipTool.onCreateToastDialog(context.getApplicationContext(), d.b());
                this.f9140a = d.a();
            } else {
                TipTool.onCreateToastDialog(context.getApplicationContext(), a2.b());
            }
        } else if (i2 == i3) {
            TipTool.onCreateToastDialog(context.getApplicationContext(), context.getString(R.string.tts_volume_plus_tips));
        }
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "plusMinusTTSVolume current tts volume: " + TTSPlayerControl.getCurrentVolume());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public com.baidu.navisdk.ui.routeguide.tts.b a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "getCurrent: " + i);
        }
        for (com.baidu.navisdk.ui.routeguide.tts.b bVar : com.baidu.navisdk.ui.routeguide.tts.b.values()) {
            if (bVar.a() == i) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.ui.routeguide.tts.b bVar) {
        if (bVar == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.tts.b c = bVar.c();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "handlerMinusTTSVolume minVolume: " + c);
        }
        if (c == null || c.a() == TTSPlayerControl.getCurrentVolume()) {
            return;
        }
        TTSPlayerControl.setTTSVolume(c.a());
        this.f9140a = c.a();
        if (gVar.d()) {
            gVar.e("BNTTSVolumeController", "handlerMinusTTSVolume: " + TTSPlayerControl.getCurrentVolume());
        }
    }
}
