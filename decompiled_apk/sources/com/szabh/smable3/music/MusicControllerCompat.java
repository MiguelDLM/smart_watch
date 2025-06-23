package com.szabh.smable3.music;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.x;
import com.szabh.smable3.music.MusicControllerCompat$mReceiver$2;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public class MusicControllerCompat {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";

    @OOXIXo
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";

    @oOoXoXO
    private AudioManager mAudioManager;

    @oOoXoXO
    private Context mContext;

    @OOXIXo
    private final X0IIOO mReceiver$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<MusicControllerCompat$mReceiver$2.AnonymousClass1>() { // from class: com.szabh.smable3.music.MusicControllerCompat$mReceiver$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.szabh.smable3.music.MusicControllerCompat$mReceiver$2$1] */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final AnonymousClass1 invoke() {
            final MusicControllerCompat musicControllerCompat = MusicControllerCompat.this;
            return new BroadcastReceiver() { // from class: com.szabh.smable3.music.MusicControllerCompat$mReceiver$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@OOXIXo Context context, @OOXIXo Intent intent) {
                    IIX0o.x0xO0oo(context, "context");
                    IIX0o.x0xO0oo(intent, "intent");
                    String action = intent.getAction();
                    if (action != null && action.hashCode() == -1940635523 && action.equals(x.cg) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        MusicControllerCompat.this.updateVolume();
                    }
                }
            };
        }
    });

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final MusicControllerCompat newInstance() {
            return new MusicController();
        }

        private Companion() {
        }
    }

    private final BroadcastReceiver getMReceiver() {
        return (BroadcastReceiver) this.mReceiver$delegate.getValue();
    }

    @CallSuper
    public void exit() {
        Context context = this.mContext;
        if (context != null) {
            context.unregisterReceiver(getMReceiver());
        }
        this.mContext = null;
    }

    @oOoXoXO
    public final AudioManager getMAudioManager() {
        return this.mAudioManager;
    }

    @oOoXoXO
    public final Context getMContext() {
        return this.mContext;
    }

    public final int getStreamMaxVolume(int i) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(i);
        }
        return 15;
    }

    public final int getStreamVolume(int i) {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            return audioManager.getStreamVolume(i);
        }
        return -1;
    }

    @SuppressLint({"WrongConstant"})
    @CallSuper
    public void launch(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(context, getMReceiver(), new IntentFilter("android.media.VOLUME_CHANGED_ACTION"), 2);
        } else {
            context.registerReceiver(getMReceiver(), new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        }
        Object systemService = context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
    }

    public final void setMAudioManager(@oOoXoXO AudioManager audioManager) {
        this.mAudioManager = audioManager;
    }

    public final void setMContext(@oOoXoXO Context context) {
        this.mContext = context;
    }

    public void updateVolume() {
    }
}
