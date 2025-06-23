package com.sma.smartv3.biz.voice;

import android.media.MediaPlayer;
import com.blankj.utilcode.util.LogUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class VoicePlayer {

    @OXOo.OOXIXo
    public static final VoicePlayer INSTANCE = new VoicePlayer();

    @OXOo.OOXIXo
    private static final String TAG = "VoicePlayer";

    @OXOo.oOoXoXO
    private static MediaPlayer mMediaPlayer;

    private VoicePlayer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void play$default(VoicePlayer voicePlayer, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        voicePlayer.play(str, oooxoxo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$0(Oox.oOoXoXO oooxoxo, MediaPlayer mediaPlayer) {
        if (oooxoxo != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean play$lambda$1(Oox.oOoXoXO oooxoxo, MediaPlayer mediaPlayer, int i, int i2) {
        LogUtils.d("播放失败 " + i);
        if (oooxoxo != null) {
        }
        return true;
    }

    public final boolean isPlay() {
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    public final void play(@OXOo.OOXIXo String url, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(url, "url");
        LogUtils.d(TAG + " play -> " + url);
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
        }
        stop();
        MediaPlayer mediaPlayer = mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        MediaPlayer mediaPlayer2 = mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setDataSource(url);
        }
        MediaPlayer mediaPlayer3 = mMediaPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.sma.smartv3.biz.voice.ooOOo0oXI
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer4) {
                    VoicePlayer.play$lambda$0(Oox.oOoXoXO.this, mediaPlayer4);
                }
            });
        }
        MediaPlayer mediaPlayer4 = mMediaPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.sma.smartv3.biz.voice.x0XOIxOo
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer5, int i, int i2) {
                    boolean play$lambda$1;
                    play$lambda$1 = VoicePlayer.play$lambda$1(Oox.oOoXoXO.this, mediaPlayer5, i, i2);
                    return play$lambda$1;
                }
            });
        }
        MediaPlayer mediaPlayer5 = mMediaPlayer;
        if (mediaPlayer5 != null) {
            mediaPlayer5.prepare();
        }
        MediaPlayer mediaPlayer6 = mMediaPlayer;
        if (mediaPlayer6 != null) {
            mediaPlayer6.start();
        }
    }

    public final void release() {
        if (mMediaPlayer != null) {
            stop();
            MediaPlayer mediaPlayer = mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mMediaPlayer = null;
        }
    }

    public final void stop() {
        try {
            MediaPlayer mediaPlayer = mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = mMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
