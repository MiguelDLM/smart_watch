package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.SoundPool;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;

/* loaded from: classes8.dex */
public class j0 {
    private Context e;

    /* renamed from: a, reason: collision with root package name */
    private SoundPool f9235a = null;
    private int b = -1;
    private AssetFileDescriptor d = null;
    private boolean c = false;

    /* loaded from: classes8.dex */
    public class a implements SoundPool.OnLoadCompleteListener {
        public a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
            if (i2 == 0) {
                j0.this.c = true;
                try {
                    if (j0.this.d != null) {
                        j0.this.d.close();
                        return;
                    }
                    return;
                } catch (IOException e) {
                    LogUtil.e("initSoundPool", "close afd failed, " + e);
                    return;
                }
            }
            j0.this.c = false;
        }
    }

    public j0(Context context, int i) {
        this.e = context;
        a(context, i);
    }

    public void b() {
        SoundPool soundPool = this.f9235a;
        if (soundPool != null) {
            if (this.c) {
                soundPool.unload(this.b);
            }
            this.f9235a.release();
            this.f9235a = null;
        }
    }

    public void c() {
        SoundPool soundPool = this.f9235a;
        if (soundPool != null) {
            soundPool.stop(3);
        }
    }

    private void a(Context context, int i) {
        if (i <= 0) {
            this.c = false;
            return;
        }
        try {
            this.d = context.getResources().openRawResourceFd(i);
        } catch (Exception unused) {
            this.d = null;
        }
        if (this.d == null) {
            this.c = false;
            return;
        }
        try {
            SoundPool soundPool = new SoundPool(3, 3, 0);
            this.f9235a = soundPool;
            soundPool.setOnLoadCompleteListener(new a());
            this.b = this.f9235a.load(this.d, 1);
        } catch (Exception e) {
            LogUtil.e("initSoundPool", "new SoundPool err, " + e);
            this.c = false;
        }
    }

    public boolean a() {
        Context context;
        if (a(this.e) || (context = this.e) == null || !this.c || this.f9235a == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        float streamVolume = audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        this.f9235a.play(this.b, streamVolume, streamVolume, 1, 0, 1.0f);
        return true;
    }

    public static boolean a(Context context) {
        return a0.f(context);
    }
}
