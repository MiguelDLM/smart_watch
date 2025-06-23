package com.baidu.navisdk.volume;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.x;
import java.lang.ref.WeakReference;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class BNVolumeChangeObserver {

    /* renamed from: a, reason: collision with root package name */
    private b f9408a;
    private VolumeReceiver b;
    private final X0IIOO c;
    private final Context d;

    /* loaded from: classes8.dex */
    public static final class VolumeReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<BNVolumeChangeObserver> f9409a;

        public VolumeReceiver(@OOXIXo BNVolumeChangeObserver observer) {
            IIX0o.x0xO0oo(observer, "observer");
            this.f9409a = new WeakReference<>(observer);
        }

        private final boolean a(Intent intent) {
            if (intent.getAction() != null && IIX0o.Oxx0IOOO(intent.getAction(), x.cg) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                return true;
            }
            return false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@OOXIXo Context context, @OOXIXo Intent intent) {
            BNVolumeChangeObserver bNVolumeChangeObserver;
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(intent, "intent");
            WeakReference<BNVolumeChangeObserver> weakReference = this.f9409a;
            if (weakReference != null && (bNVolumeChangeObserver = weakReference.get()) != null) {
                IIX0o.oO(bNVolumeChangeObserver, "mObserver?.get() ?: return");
                if (bNVolumeChangeObserver.f9408a != null && a(intent)) {
                    b bVar = bNVolumeChangeObserver.f9408a;
                    IIX0o.ooOOo0oXI(bVar);
                    bVar.a(bNVolumeChangeObserver.a());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements oIX0oI<AudioManager> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final AudioManager invoke() {
            Object systemService = BNVolumeChangeObserver.this.d.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (systemService != null) {
                return (AudioManager) systemService;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        }
    }

    static {
        new a(null);
    }

    public BNVolumeChangeObserver(@OOXIXo Context mContext) {
        IIX0o.x0xO0oo(mContext, "mContext");
        this.d = mContext;
        this.c = XIxXXX0x0.oIX0oI(new c());
    }

    private final AudioManager c() {
        return (AudioManager) this.c.getValue();
    }

    public final int a() {
        return c().getStreamVolume(3);
    }

    public final void b() {
        VolumeReceiver volumeReceiver = this.b;
        if (volumeReceiver != null) {
            this.d.unregisterReceiver(volumeReceiver);
        }
        this.f9408a = null;
    }

    public final void a(@oOoXoXO b bVar) {
        b(bVar);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.cg);
        VolumeReceiver volumeReceiver = new VolumeReceiver(this);
        this.b = volumeReceiver;
        this.d.registerReceiver(volumeReceiver, intentFilter);
    }

    public final void b(@oOoXoXO b bVar) {
        this.f9408a = bVar;
    }
}
