package oI00o;

import android.content.Context;
import android.media.SoundPool;
import me.devilsen.czxing.R;

/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f31360II0xO0 = -1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SoundPool f31361oIX0oI = new SoundPool(1, 2, 0);

    public void I0Io() {
        int i = this.f31360II0xO0;
        if (i == -1) {
            return;
        }
        this.f31361oIX0oI.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void II0xO0(Context context) {
        oIX0oI(context, R.raw.voice_correct);
    }

    public void oIX0oI(Context context, int i) {
        this.f31360II0xO0 = this.f31361oIX0oI.load(context, i, 1);
    }

    public void oxoX() {
        SoundPool soundPool = this.f31361oIX0oI;
        if (soundPool != null) {
            soundPool.release();
            this.f31361oIX0oI = null;
        }
    }
}
