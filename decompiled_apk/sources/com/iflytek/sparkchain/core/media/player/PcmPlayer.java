package com.iflytek.sparkchain.core.media.player;

import android.content.Context;
import com.iflytek.sparkchain.core.media.speech.SpeechError;
import com.iflytek.sparkchain.media.player.b;
import com.iflytek.sparkchain.media.record.a;

@Deprecated
/* loaded from: classes10.dex */
public class PcmPlayer extends b {

    /* loaded from: classes10.dex */
    public interface PcmPlayerListener {
        void onError(SpeechError speechError);

        void onPaused();

        void onPercent(int i, int i2, int i3);

        void onResume();

        void onStoped();
    }

    public PcmPlayer(Context context) {
        super(context);
    }

    public boolean play(a aVar, PcmPlayerListener pcmPlayerListener) {
        setListener(pcmPlayerListener);
        return play(aVar);
    }

    public boolean rePlay(a aVar, PcmPlayerListener pcmPlayerListener) {
        super.setState(0);
        return play(aVar, pcmPlayerListener);
    }

    public PcmPlayer(Context context, int i, boolean z, boolean z2, boolean z3) {
        super(context, i, z, z2, z3);
    }
}
