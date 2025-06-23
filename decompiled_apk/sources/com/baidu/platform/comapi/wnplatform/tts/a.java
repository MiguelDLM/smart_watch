package com.baidu.platform.comapi.wnplatform.tts;

import android.content.Context;
import android.media.AudioManager;
import com.baidu.mapapi.tts.WNTTSManager;
import com.baidu.mapapi.tts.WNTTsInitConfig;
import com.baidu.navisdk.tts.BNTTS;
import com.baidu.navisdk.tts.BNTTSPlayer;
import com.baidu.navisdk.tts.ITTSInitListener;
import com.baidu.navisdk.tts.OnTTSStateChangedListener;
import com.baidu.platform.comapi.wnplatform.f;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public abstract class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9969a = false;
    public static Context b = null;
    public static AudioManager.OnAudioFocusChangeListener c = new AudioManager.OnAudioFocusChangeListener() { // from class: com.baidu.platform.comapi.wnplatform.tts.BaseTTSPlayer$3
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -2 || i == -1) {
                a.e();
            }
        }
    };
    private static boolean d = false;

    public static void a(WNTTsInitConfig wNTTsInitConfig, WNTTSManager.IWNOuterTTSPlayerCallback iWNOuterTTSPlayerCallback) {
        if (iWNOuterTTSPlayerCallback != null) {
            f9969a = true;
            WNaviTTSPlayer.addOutTTSPlayerListener(iWNOuterTTSPlayerCallback);
        } else {
            if (wNTTsInitConfig == null) {
                return;
            }
            try {
                f9969a = false;
                BNTTS.init(wNTTsInitConfig.context, wNTTsInitConfig.appKey, wNTTsInitConfig.secretKey, wNTTsInitConfig.authsn, new ITTSInitListener() { // from class: com.baidu.platform.comapi.wnplatform.tts.BaseTTSPlayer$1
                    @Override // com.baidu.navisdk.tts.ITTSInitListener
                    public void onFail(int i) {
                    }

                    @Override // com.baidu.navisdk.tts.ITTSInitListener
                    public void onSuccess() {
                    }
                });
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public static int b(String str, boolean z) {
        try {
        } catch (Throwable th) {
            th.getMessage();
        }
        if (f.a().f()) {
            return 0;
        }
        d();
        BNTTSPlayer bNTTSPlayer = BNTTSPlayer.getInstance();
        if (bNTTSPlayer != null) {
            Method declaredMethod = BNTTSPlayer.class.getDeclaredMethod("playTTSText", String.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(bNTTSPlayer, str, Boolean.valueOf(z))).intValue();
        }
        return 0;
    }

    public static boolean d() {
        Context context = b;
        if (context == null) {
            return false;
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null && audioManager.requestAudioFocus(c, 3, 3) == 1) {
                d = true;
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return false;
    }

    public static boolean e() {
        Context context = b;
        if (context == null || !d) {
            return false;
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                audioManager.abandonAudioFocus(c);
                d = false;
                return true;
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return true;
        }
    }

    public abstract void a(c cVar);

    public static void a(final WNTTSManager.IOnTTSPlayStateChangedListener iOnTTSPlayStateChangedListener) {
        if (iOnTTSPlayStateChangedListener == null) {
            return;
        }
        try {
            if (f9969a) {
                return;
            }
            BNTTS.setOnTTSStateChangedListener(new OnTTSStateChangedListener() { // from class: com.baidu.platform.comapi.wnplatform.tts.BaseTTSPlayer$2
                @Override // com.baidu.navisdk.tts.OnTTSStateChangedListener
                public void onPlayEnd(String str) {
                    WNTTSManager.IOnTTSPlayStateChangedListener.this.onPlayEnd(str);
                    a.e();
                }

                @Override // com.baidu.navisdk.tts.OnTTSStateChangedListener
                public void onPlayError(int i, String str) {
                    WNTTSManager.IOnTTSPlayStateChangedListener.this.onPlayError(i, str);
                }

                @Override // com.baidu.navisdk.tts.OnTTSStateChangedListener
                public void onPlayStart() {
                    WNTTSManager.IOnTTSPlayStateChangedListener.this.onPlayStart();
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void a(WNTTSManager.IWNOuterTTSPlayerCallback iWNOuterTTSPlayerCallback) {
        WNaviTTSPlayer.removeOutTTSPlayerListener(iWNOuterTTSPlayerCallback);
    }
}
