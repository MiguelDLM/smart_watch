package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes11.dex */
public final class h {
    private AudioManager aCI;
    private AudioManager.OnAudioFocusChangeListener aPA = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (h.this.hq == null) {
                return;
            }
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        h.this.hq.onAudioBeOccupied();
                    } else {
                        h.this.hq.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a hq;

    /* loaded from: classes11.dex */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.aCI = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    @TargetApi(26)
    private AudioFocusRequest LN() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        audioAttributes = O0xOxO.Oxx0IOOO.oIX0oI(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build());
        acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.aPA);
        build = onAudioFocusChangeListener.build();
        return build;
    }

    public final boolean LM() {
        AudioManager audioManager;
        int requestAudioFocus;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aPA;
        if (onAudioFocusChangeListener != null && (audioManager = this.aCI) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                requestAudioFocus = audioManager.requestAudioFocus(LN());
                if (1 != requestAudioFocus) {
                    return false;
                }
                return true;
            }
            if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(a aVar) {
        this.hq = aVar;
    }
}
