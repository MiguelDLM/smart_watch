package com.baidu.navisdk.ugc.utils;

import O0xOxO.Oxx0IOOO;
import OXOo.OOXIXo;
import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final e f8333a = new e();

    /* loaded from: classes8.dex */
    public static final class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8334a = new a();

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f8335a = new b();

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
        }
    }

    private e() {
    }

    public final boolean a(@OOXIXo Context mContext) {
        AudioFocusRequest build;
        IIX0o.x0xO0oo(mContext, "mContext");
        Object systemService = mContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (systemService != null) {
            AudioManager audioManager = (AudioManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                build = Oxx0IOOO.oIX0oI(4).build();
                audioManager.abandonAudioFocusRequest(build);
                return true;
            }
            audioManager.abandonAudioFocus(a.f8334a);
            return true;
        }
        return false;
    }

    public final boolean b(@OOXIXo Context mContext) {
        IIX0o.x0xO0oo(mContext, "mContext");
        Object systemService = mContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (systemService == null || ((AudioManager) systemService).requestAudioFocus(b.f8335a, 3, 2) != 1) {
            return false;
        }
        return true;
    }
}
