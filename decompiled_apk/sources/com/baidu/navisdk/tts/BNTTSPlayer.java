package com.baidu.navisdk.tts;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class BNTTSPlayer {
    private static final int DEFAULT_SPEED = 5;
    public static final int INIT_STATE_INITING = 1;
    public static final int INIT_STATE_NO = 0;
    public static final int INIT_STATE_OK = 2;
    private static final String K_TTS_DATA_FILE = "bd_etts_ch_speech.dat";
    private static final String K_TTS_TEXT_DATA_FILE = "bd_etts_ch_text_default.dat";
    private static final int MSG_RESET_TTS_FOR_TIMEOUT = 1;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_NOT_INIT = 0;
    public static final int PLAYER_STATE_PAUSE = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    private static final String TAG = "tts";
    private boolean isLogEnable;
    private Context mContext;
    private OnTTSStateChangedListener mOnTTSStateChangedListener;
    private SpeechSynthesizer ttsPlayer;
    private final Object mPlayStateLock = new Object();
    private int mInitState = 0;
    private String mSDCardAPPBasePath = null;
    private String mNormalVoicePath = null;
    private boolean mIsTTSPlaying = false;
    private boolean mIsPausing = false;
    private boolean isTimeOutEnable = false;
    private int mCurrentVolume = 7;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.navisdk.tts.BNTTSPlayer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                BNTTSPlayer.this.resetTTSForTimeout();
            }
        }
    };
    private final SpeechSynthesizerListener mSpeechSynthesizerListener = new SpeechSynthesizerListener() { // from class: com.baidu.navisdk.tts.BNTTSPlayer.2
        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onError(String str, SpeechError speechError) {
            BNTTSPlayer.this.loge("BdTTSPlayer", "onError() arg = " + speechError.toString());
            if (BNTTSPlayer.this.mOnTTSStateChangedListener != null) {
                BNTTSPlayer.this.mOnTTSStateChangedListener.onPlayError(speechError.code, speechError.description);
            }
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onLipDataArrived(String str, byte[] bArr) {
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onSpeechFinish(String str) {
            BNTTSPlayer.this.loge("BdTTSPlayer", "onPlayFinish() arg = " + str);
            synchronized (BNTTSPlayer.this.mPlayStateLock) {
                try {
                    BNTTSPlayer.this.mIsTTSPlaying = false;
                    if (BNTTSPlayer.this.mHandler.hasMessages(1)) {
                        BNTTSPlayer.this.mHandler.removeMessages(1);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (BNTTSPlayer.this.mOnTTSStateChangedListener != null) {
                BNTTSPlayer.this.mOnTTSStateChangedListener.onPlayEnd(str);
            }
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onSpeechProgressChanged(String str, int i) {
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onSpeechStart(String str) {
            BNTTSPlayer.this.loge("BdTTSPlayer", "onPlayStart() arg = " + str);
            if (BNTTSPlayer.this.mOnTTSStateChangedListener != null) {
                BNTTSPlayer.this.mOnTTSStateChangedListener.onPlayStart();
            }
            synchronized (BNTTSPlayer.this.mPlayStateLock) {
                BNTTSPlayer.this.mIsTTSPlaying = true;
            }
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onSynthesizeDataArrived(String str, byte[] bArr, int i, int i2) {
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onSynthesizeFinish(String str) {
        }

        @Override // com.baidu.tts.client.SpeechSynthesizerListener
        public void onSynthesizeStart(String str) {
        }
    };

    /* loaded from: classes7.dex */
    public static final class Holder {
        private static final BNTTSPlayer INSTANCE = new BNTTSPlayer();

        private Holder() {
        }
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean copyAssetsFile(String str, String str2, String str3) {
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            InputStream openAssetRes = openAssetRes(str);
            if (openAssetRes == null) {
                close(openAssetRes);
                close(null);
                return false;
            }
            try {
                File file = new File(str2 + File.separator + str3);
                long length = file.length();
                int available = openAssetRes.available();
                if (file.exists() && length == available) {
                    close(openAssetRes);
                    close(null);
                    return true;
                }
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(str2 + "/" + str3);
                loge(TAG, "copyAssetsFile path = " + str2 + "/" + str3);
                if (file3.exists()) {
                    file3.delete();
                    loge(TAG, "copyAssetsFile file exists -> delete");
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = openAssetRes.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            close(openAssetRes);
                            close(fileOutputStream);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    closeable2 = openAssetRes;
                    closeable = fileOutputStream;
                    e = e;
                    try {
                        loge(TAG, e.toString());
                        close(closeable2);
                        close(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        close(closeable2);
                        close(closeable);
                        throw th;
                    }
                } catch (Throwable th2) {
                    closeable2 = openAssetRes;
                    closeable = fileOutputStream;
                    th = th2;
                    close(closeable2);
                    close(closeable);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                closeable2 = openAssetRes;
                closeable = null;
            } catch (Throwable th3) {
                th = th3;
                closeable2 = openAssetRes;
                closeable = null;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
        }
    }

    private boolean copyRes() {
        if (this.mContext == null) {
            return false;
        }
        boolean copyAssetsFile = copyAssetsFile(K_TTS_DATA_FILE, this.mNormalVoicePath, K_TTS_DATA_FILE);
        loge("BdTTSPlayer", "initPlayer() copy, ret=" + copyAssetsFile + ", path=" + this.mNormalVoicePath + "/" + K_TTS_DATA_FILE);
        boolean copyAssetsFile2 = copyAssetsFile & copyAssetsFile(K_TTS_TEXT_DATA_FILE, this.mNormalVoicePath, K_TTS_TEXT_DATA_FILE);
        loge("BdTTSPlayer", "initPlayer() copy text, ret=" + copyAssetsFile2 + ", path=" + this.mNormalVoicePath + "/" + K_TTS_TEXT_DATA_FILE);
        return copyAssetsFile2;
    }

    public static BNTTSPlayer getInstance() {
        return Holder.INSTANCE;
    }

    private synchronized boolean initPlayerInner(String str, String str2, String str3, ITTSInitListener iTTSInitListener) {
        String str4;
        if (this.mContext != null && (str4 = this.mSDCardAPPBasePath) != null && str4.length() != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                if (this.ttsPlayer == null) {
                    loge("BdTTSPlayer", "initPlayer() start");
                    if (this.isLogEnable) {
                        LoggerProxy.printable(true);
                    }
                    SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.getInstance();
                    this.ttsPlayer = speechSynthesizer;
                    speechSynthesizer.setContext(this.mContext);
                    this.ttsPlayer.setSpeechSynthesizerListener(this.mSpeechSynthesizerListener);
                    this.ttsPlayer.setParam(SpeechSynthesizer.PARAM_SPEED, String.valueOf(5));
                    setCurrentVolume(7);
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.mNormalVoicePath);
                    String str5 = File.separator;
                    sb.append(str5);
                    sb.append(K_TTS_TEXT_DATA_FILE);
                    String sb2 = sb.toString();
                    SpeechSynthesizer speechSynthesizer2 = this.ttsPlayer;
                    String str6 = SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE;
                    speechSynthesizer2.setParam(str6, sb2);
                    SpeechSynthesizer speechSynthesizer3 = this.ttsPlayer;
                    String str7 = SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE;
                    speechSynthesizer3.setParam(str7, this.mNormalVoicePath + str5 + K_TTS_DATA_FILE);
                    this.ttsPlayer.setParam(SpeechSynthesizer.PARAM_AUTH_SN, str3);
                    this.ttsPlayer.setParam(SpeechSynthesizer.PARAM_PRODUCT_ID, "90014");
                    this.ttsPlayer.setAppId("90014");
                    this.ttsPlayer.setApiKey(str, str2);
                    SpeechSynthesizer speechSynthesizer4 = this.ttsPlayer;
                    TtsMode ttsMode = TtsMode.OFFLINE;
                    speechSynthesizer4.auth(ttsMode);
                    int initTts = this.ttsPlayer.initTts(ttsMode);
                    loge(TAG, "initResult:" + initTts);
                    if (initTts != 0) {
                        if (copyRes()) {
                            this.ttsPlayer.setParam(str7, this.mNormalVoicePath + str5 + K_TTS_DATA_FILE);
                            this.ttsPlayer.setParam(str6, this.mNormalVoicePath + str5 + K_TTS_TEXT_DATA_FILE);
                            initTts = this.ttsPlayer.initTts(ttsMode);
                            loge(TAG, "initPlayerInner initTts-initTTSResult = " + initTts + ", init ttsPlayer init again");
                        }
                        if (initTts != 0) {
                            this.ttsPlayer = null;
                            this.mInitState = 0;
                            if (iTTSInitListener != null) {
                                iTTSInitListener.onFail(initTts);
                            }
                            return false;
                        }
                    }
                    this.ttsPlayer.setParam(SpeechSynthesizer.PARAM_OPEN_XML, "1");
                    this.ttsPlayer.setParam(SpeechSynthesizer.PARAM_CUSTOM_SYNTH, "1");
                    loge("BdTTSPlayer", "initPlayer() end, initTime=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "/ms");
                }
                this.mInitState = 2;
                if (iTTSInitListener != null) {
                    iTTSInitListener.onSuccess();
                }
                return true;
            } catch (Throwable unused) {
                this.ttsPlayer = null;
                this.mInitState = 0;
                if (iTTSInitListener != null) {
                    iTTSInitListener.onFail(100);
                }
                return false;
            }
        }
        this.mInitState = 0;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loge(String str, String str2) {
        if (this.isLogEnable) {
            Log.e(TAG, str + ": " + str2);
        }
    }

    private void makeSureDirs() {
        File file = new File(this.mSDCardAPPBasePath + File.separator + TAG);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(this.mNormalVoicePath);
        if (!file2.exists()) {
            file2.mkdir();
        }
    }

    private int playTTSText(String str, boolean z) {
        return playTTSText(str, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTTSForTimeout() {
        if (this.ttsPlayer != null && this.mInitState == 2) {
            loge("BdTTSPlayer", "resetTTSForTimeout() ");
            stopTTS();
        }
    }

    public void doSpeak(String str, String str2) {
        if (this.ttsPlayer == null) {
            return;
        }
        synchronized (this.mPlayStateLock) {
            this.mIsTTSPlaying = true;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.ttsPlayer.speak(str, str2);
            } else {
                this.ttsPlayer.speak(str);
            }
        } finally {
        }
    }

    public int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public int getInitState() {
        return this.mInitState;
    }

    public int getTTSState() {
        int i;
        if (this.ttsPlayer == null) {
            return 0;
        }
        synchronized (this.mPlayStateLock) {
            try {
                i = 1;
                if (this.isTimeOutEnable) {
                    if (this.mIsTTSPlaying && !this.mIsPausing) {
                        if (!this.mHandler.hasMessages(1)) {
                            this.mHandler.sendEmptyMessageDelayed(1, 20000L);
                        }
                    }
                    if (this.mHandler.hasMessages(1)) {
                        this.mHandler.removeMessages(1);
                    }
                }
                if (this.mIsPausing) {
                    i = 3;
                } else if (this.mIsTTSPlaying) {
                    i = 2;
                }
                loge("BdTTSPlayer", "TTSState: " + i + ", mIsTTSPlaying: " + this.mIsTTSPlaying + ", mIsPausing: " + this.mIsPausing + ", isTimeOutEnable: " + this.isTimeOutEnable);
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public void initPlayer(Context context, String str, String str2, String str3, ITTSInitListener iTTSInitListener) {
        if (context != null && this.mInitState == 0) {
            this.mInitState = 1;
            try {
                System.loadLibrary("bd_tts_log");
                System.loadLibrary("BDSpeechDecoder_V1");
                System.loadLibrary("bd_etts");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.mContext = context.getApplicationContext();
            this.mSDCardAPPBasePath = context.getExternalFilesDir(null).getPath() + File.separator + TAG;
            this.mNormalVoicePath = context.getDir(TAG, 0).getPath();
            makeSureDirs();
            if (copyRes()) {
                initPlayerInner(str, str2, str3, iTTSInitListener);
            } else {
                this.mInitState = 0;
            }
        }
    }

    public InputStream openAssetRes(String str) {
        Context context = this.mContext;
        if (context != null) {
            try {
                return context.getAssets().open(str);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public int pauseTTS() {
        loge("BdTTSPlayer", "pauseTTS");
        if (this.ttsPlayer != null) {
            synchronized (this.mPlayStateLock) {
                this.mIsPausing = true;
            }
            return this.ttsPlayer.pause();
        }
        return -1;
    }

    public int resumeTTS() {
        loge("BdTTSPlayer", "resumeTTS");
        if (this.ttsPlayer != null) {
            synchronized (this.mPlayStateLock) {
                this.mIsPausing = false;
            }
            return this.ttsPlayer.resume();
        }
        return -1;
    }

    public void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        SpeechSynthesizer speechSynthesizer = this.ttsPlayer;
        if (speechSynthesizer != null) {
            speechSynthesizer.setParam(SpeechSynthesizer.PARAM_VOLUME, String.valueOf(i));
        }
    }

    public void setEnableTimeOut(boolean z) {
        this.isTimeOutEnable = z;
        if (!z && this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
    }

    public void setOnTTSStateChangedListener(OnTTSStateChangedListener onTTSStateChangedListener) {
        this.mOnTTSStateChangedListener = onTTSStateChangedListener;
    }

    public void setTTSLogEnable(boolean z) {
        this.isLogEnable = z;
    }

    public void stopTTS() {
        loge("BdTTSPlayer", "stopTTS");
        try {
            if (this.ttsPlayer != null) {
                synchronized (this.mPlayStateLock) {
                    this.mIsTTSPlaying = false;
                    this.mIsPausing = false;
                }
                Context context = this.mContext;
                if (context != null) {
                    BNTTSUtils.releaseAudioFocus(context);
                }
                this.ttsPlayer.stop();
            }
        } catch (Throwable unused) {
        }
    }

    private int playTTSText(String str, String str2, boolean z) {
        if (this.ttsPlayer != null && this.mInitState == 2) {
            try {
                if (!BNTTSUtils.isCalling(this.mContext)) {
                    if (z && getTTSState() == 2) {
                        this.ttsPlayer.stop();
                    }
                    doSpeak(str, str2);
                } else {
                    loge(TAG, " BdTTSPlayer playTTSText isCalling");
                }
            } catch (Exception e) {
                loge("", e.toString());
            }
        }
        return 0;
    }
}
