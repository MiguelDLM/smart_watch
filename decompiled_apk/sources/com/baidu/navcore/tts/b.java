package com.baidu.navcore.tts;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.SoundPool;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.tts.BNTTSUtils;
import com.baidu.navisdk.util.common.g;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes7.dex */
public class b {
    private static final String f = "b";

    /* renamed from: a, reason: collision with root package name */
    private Context f6468a;
    private SoundPool b = null;
    private int c = -1;
    private AssetFileDescriptor e = null;
    private boolean d = false;

    public b(Context context, int i) {
        this.f6468a = context;
        a(i);
    }

    private void a(int i) {
        Context context = this.f6468a;
        if (context != null && i > 0) {
            try {
                this.e = context.getResources().openRawResourceFd(i);
            } catch (Exception unused) {
                this.e = null;
            }
            if (this.e == null) {
                this.d = false;
                return;
            }
            try {
                SoundPool soundPool = new SoundPool(3, 3, 0);
                this.b = soundPool;
                this.c = soundPool.load(this.e, 1);
                this.d = true;
                AssetFileDescriptor assetFileDescriptor = this.e;
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                this.d = false;
                return;
            }
        }
        this.d = false;
    }

    public void b() {
        SoundPool soundPool = this.b;
        if (soundPool != null) {
            soundPool.stop(3);
        }
    }

    public void a() {
        if (this.f6468a == null) {
            return;
        }
        if (BNSettingManager.getVoiceMode() == 2) {
            g gVar = g.OPEN_SDK;
            if (gVar.d()) {
                gVar.e(f, "voice mode is Quite, return");
                return;
            }
            return;
        }
        if (BNTTSUtils.isCalling(this.f6468a)) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f6468a.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (!this.d || this.b == null || audioManager == null) {
            return;
        }
        float streamVolume = audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        try {
            this.b.play(this.c, streamVolume, streamVolume, 1, 0, 1.0f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
