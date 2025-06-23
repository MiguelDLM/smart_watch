package com.sma.smartv3.biz.voice;

import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.baidu.ai.speech.realtime.full.connection.Runner;
import com.baidu.ai.speech.realtime.full.download.Result;
import com.baidu.ai.speech.realtime.full.download.SimpleDownloader;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.ai.AIBase;
import com.sma.smartv3.biz.ai.AIError;
import com.sma.smartv3.biz.voice.AIIdentificationManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.network.GetAIAudioToText;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.entity.Languages;
import java.io.File;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public final class AIIdentificationManager {
    private static boolean isPhoneRecord;
    private static boolean isRealTimeRunning;
    private static boolean isSendResults;

    @OXOo.oOoXoXO
    private static Runner mFullRunner;

    @OXOo.oOoXoXO
    private static OnIdentificationCallback mIdentificationCallback;

    @OXOo.oOoXoXO
    private static PipedInputStream mInputStream;

    @OXOo.oOoXoXO
    private static PipedOutputStream mOutputStream;
    private static boolean resetCallBack;

    @OXOo.OOXIXo
    public static final AIIdentificationManager INSTANCE = new AIIdentificationManager();

    @OXOo.OOXIXo
    private static final String TAG = "AIIdentificationManagement";

    @OXOo.OOXIXo
    private static final File mPcmFile = new File(PathUtils.getExternalAppDataPath() + "/files/record.pcm");

    @OXOo.OOXIXo
    private static String mCompleteText = "";
    private static int mDeviceSelectedAIMode = -1;

    @OXOo.OOXIXo
    private static String mContentResult = "";

    @OXOo.OOXIXo
    private static final MicrosoftSDKManage.I0Io microsoftCallBack = new MicrosoftSDKManage.I0Io() { // from class: com.sma.smartv3.biz.voice.AIIdentificationManager$microsoftCallBack$1
        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResults(int i, @OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "str");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
            MicrosoftSDKManage.I0Io.oIX0oI.oIX0oI(this, i, str, str2);
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStartTransmission() {
            String str;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = AIIdentificationManager.TAG;
            sb.append(str);
            sb.append(" onStartTransmission ");
            oix0oi.oIX0oI(sb.toString());
            AIIdentificationManager aIIdentificationManager = AIIdentificationManager.INSTANCE;
            aIIdentificationManager.setSendResults(false);
            aIIdentificationManager.setMContentResult("");
        }

        @Override // com.sma.smartv3.util.MicrosoftSDKManage.I0Io
        public void onStopTransmission() {
            String str;
            String str2;
            AIIdentificationManager.OnIdentificationCallback onIdentificationCallback;
            AIIdentificationManager.OnIdentificationCallback onIdentificationCallback2;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            str = AIIdentificationManager.TAG;
            sb.append(str);
            sb.append(" microsoftCallBack onStopTransmission -> mContentResult = ");
            AIIdentificationManager aIIdentificationManager = AIIdentificationManager.INSTANCE;
            sb.append(aIIdentificationManager.getMContentResult());
            sb.append(" isSendResults = ");
            sb.append(aIIdentificationManager.isSendResults());
            oix0oi.oIX0oI(sb.toString());
            if (!aIIdentificationManager.isSendResults()) {
                VoiceManager voiceManager = VoiceManager.INSTANCE;
                voiceManager.setSpeechRecRunning(false);
                StringBuilder sb2 = new StringBuilder();
                str2 = AIIdentificationManager.TAG;
                sb2.append(str2);
                sb2.append(" microsoftCallBack onStopTransmission -> mContentResult = ");
                sb2.append(aIIdentificationManager.getMContentResult());
                sb2.append("  isSpeechRecRunning = ");
                sb2.append(voiceManager.isSpeechRecRunning());
                oix0oi.oIX0oI(sb2.toString());
                if (aIIdentificationManager.getMContentResult().length() > 0) {
                    onIdentificationCallback2 = AIIdentificationManager.mIdentificationCallback;
                    if (onIdentificationCallback2 != null) {
                        onIdentificationCallback2.onComplete(aIIdentificationManager.getMContentResult());
                        return;
                    }
                    return;
                }
                DcsTtsPlayer.INSTANCE.stop();
                onIdentificationCallback = AIIdentificationManager.mIdentificationCallback;
                if (onIdentificationCallback != null) {
                    onIdentificationCallback.onIdentificationError(UtilsKt.oI0IIXIo(R.string.request_error));
                }
            }
        }
    };

    /* loaded from: classes12.dex */
    public interface OnIdentificationCallback {
        void onComplete(@OXOo.OOXIXo String str);

        void onEndSuccess();

        void onIdentificationError(@OXOo.OOXIXo String str);

        void onProcessComplete(@OXOo.OOXIXo String str);

        void onStartSuccess();
    }

    private AIIdentificationManager() {
    }

    public static /* synthetic */ void identificationBegins$default(AIIdentificationManager aIIdentificationManager, boolean z, OnIdentificationCallback onIdentificationCallback, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        aIIdentificationManager.identificationBegins(z, onIdentificationCallback, z2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identificationCompleted$default(AIIdentificationManager aIIdentificationManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        aIIdentificationManager.identificationCompleted(oooxoxo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pollCheckStop() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.sma.smartv3.biz.voice.AIIdentificationManager$pollCheckStop$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Runner runner;
                boolean z;
                Runner runner2;
                runner = AIIdentificationManager.mFullRunner;
                if (runner != null) {
                    runner2 = AIIdentificationManager.mFullRunner;
                    IIX0o.ooOOo0oXI(runner2);
                    if (runner2.isClosed()) {
                        AIIdentificationManager aIIdentificationManager = AIIdentificationManager.INSTANCE;
                        AIIdentificationManager.isRealTimeRunning = false;
                    }
                }
                z = AIIdentificationManager.isRealTimeRunning;
                if (!z) {
                    cancel();
                    timer.cancel();
                    AIIdentificationManager.INSTANCE.stopRealTime();
                }
            }
        }, 500L, 500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void serviceIdentificationAudio$default(AIIdentificationManager aIIdentificationManager, File file, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        aIIdentificationManager.serviceIdentificationAudio(file, iI0xO0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void serviceIdentificationAudio$lambda$0(long j, long j2) {
    }

    private final void serviceIdentify(final Oox.oOoXoXO<? super String, oXIO0o0XI> oooxoxo) {
        serviceIdentificationAudio(mPcmFile, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.AIIdentificationManager$serviceIdentify$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(UtilsKt.oI0IIXIo(R.string.speech_recognition_error));
                }
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str) {
                Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(str);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void serviceIdentify$default(AIIdentificationManager aIIdentificationManager, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        aIIdentificationManager.serviceIdentify(oooxoxo);
    }

    private final void startRealTime() {
        if (isRealTimeRunning) {
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " -> startRealTime");
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Void>() { // from class: com.sma.smartv3.biz.voice.AIIdentificationManager$startRealTime$1
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(@OXOo.oOoXoXO Void r1) {
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            @OXOo.oOoXoXO
            public Void doInBackground() {
                PipedInputStream pipedInputStream;
                PipedInputStream pipedInputStream2;
                Runner runner;
                AIIdentificationManager aIIdentificationManager = AIIdentificationManager.INSTANCE;
                AIIdentificationManager.isRealTimeRunning = true;
                AIIdentificationManager.mInputStream = new PipedInputStream();
                pipedInputStream = AIIdentificationManager.mInputStream;
                AIIdentificationManager.mOutputStream = new PipedOutputStream(pipedInputStream);
                pipedInputStream2 = AIIdentificationManager.mInputStream;
                AIIdentificationManager.mFullRunner = new Runner(pipedInputStream2, 2);
                runner = AIIdentificationManager.mFullRunner;
                if (runner != null) {
                    runner.run(new SimpleDownloader() { // from class: com.sma.smartv3.biz.voice.AIIdentificationManager$startRealTime$1$doInBackground$1
                        @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
                        public void onFailure(@OXOo.OOXIXo String reason) {
                            String str;
                            AIIdentificationManager.OnIdentificationCallback onIdentificationCallback;
                            IIX0o.x0xO0oo(reason, "reason");
                            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            str = AIIdentificationManager.TAG;
                            sb.append(str);
                            sb.append(" onFailure -> ");
                            sb.append(reason);
                            oix0oi.oIX0oI(sb.toString());
                            ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.speech_recognition_error) + '\n' + reason, new Object[0]);
                            onIdentificationCallback = AIIdentificationManager.mIdentificationCallback;
                            if (onIdentificationCallback != null) {
                                onIdentificationCallback.onIdentificationError(reason);
                            }
                        }

                        @Override // com.baidu.ai.speech.realtime.full.download.SimpleDownloader
                        public void onMessage(@OXOo.OOXIXo Result result) {
                            String str;
                            AIIdentificationManager.OnIdentificationCallback onIdentificationCallback;
                            AIIdentificationManager.OnIdentificationCallback onIdentificationCallback2;
                            AIIdentificationManager.OnIdentificationCallback onIdentificationCallback3;
                            IIX0o.x0xO0oo(result, "result");
                            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                            StringBuilder sb = new StringBuilder();
                            str = AIIdentificationManager.TAG;
                            sb.append(str);
                            sb.append(" onMessage -> ");
                            sb.append(result.getOrignalJsonStr());
                            oix0oi.oIX0oI(sb.toString());
                            if (result.isError()) {
                                onIdentificationCallback = AIIdentificationManager.mIdentificationCallback;
                                if (onIdentificationCallback != null) {
                                    String result2 = result.getResult();
                                    IIX0o.oO(result2, "getResult(...)");
                                    onIdentificationCallback.onIdentificationError(result2);
                                    return;
                                }
                                return;
                            }
                            String result3 = result.getResult();
                            if (result.isFin()) {
                                onIdentificationCallback3 = AIIdentificationManager.mIdentificationCallback;
                                if (onIdentificationCallback3 != null) {
                                    IIX0o.ooOOo0oXI(result3);
                                    onIdentificationCallback3.onComplete(result3);
                                    return;
                                }
                                return;
                            }
                            onIdentificationCallback2 = AIIdentificationManager.mIdentificationCallback;
                            if (onIdentificationCallback2 != null) {
                                IIX0o.ooOOo0oXI(result3);
                                onIdentificationCallback2.onProcessComplete(result3);
                            }
                        }
                    });
                }
                aIIdentificationManager.pollCheckStop();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopRealTime() {
        try {
            try {
                PipedInputStream pipedInputStream = mInputStream;
                if (pipedInputStream != null) {
                    pipedInputStream.close();
                }
                PipedOutputStream pipedOutputStream = mOutputStream;
                if (pipedOutputStream != null) {
                    pipedOutputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mInputStream = null;
            mOutputStream = null;
            mFullRunner = null;
            isRealTimeRunning = false;
        } catch (Throwable th) {
            mInputStream = null;
            mOutputStream = null;
            mFullRunner = null;
            isRealTimeRunning = false;
            throw th;
        }
    }

    @OXOo.OOXIXo
    public final String getMContentResult() {
        return mContentResult;
    }

    public final int getMDeviceSelectedAIMode() {
        return mDeviceSelectedAIMode;
    }

    @OXOo.OOXIXo
    public final MicrosoftSDKManage.I0Io getMicrosoftCallBack() {
        return microsoftCallBack;
    }

    public final void identificationBegins(boolean z, @OXOo.OOXIXo OnIdentificationCallback identificationCallback, boolean z2, int i) {
        LanguageTranslationData toLanguageTranslationData;
        IIX0o.x0xO0oo(identificationCallback, "identificationCallback");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (ProductManager.xOOxIO(productManager, null, 1, null)) {
            RecordingManager.Companion.getInstance().playTip();
        }
        mDeviceSelectedAIMode = i;
        isPhoneRecord = z;
        mCompleteText = "";
        VoiceManagerV2 voiceManagerV2 = VoiceManagerV2.INSTANCE;
        LanguageTranslationData languageTranslationData = voiceManagerV2.getLanguageTranslationData();
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        if (!voiceManager.isSupportAIVoiceTranslation() && !voiceManager.isSupportEarPhoneVoiceTranslation()) {
            toLanguageTranslationData = voiceManagerV2.getLanguageTranslationData();
        } else {
            toLanguageTranslationData = voiceManagerV2.getToLanguageTranslationData();
        }
        mIdentificationCallback = identificationCallback;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 isPhoneRecord =" + isPhoneRecord);
        if (isPhoneRecord) {
            if (productManager.XI0IXoo()) {
                oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 1");
                MicrosoftSDKManage.O0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), languageTranslationData.getAsrLanguage(), true, toLanguageTranslationData.getTtsViuceName(), toLanguageTranslationData.getAsrLanguage(), !z2, null, 32, null);
                return;
            } else if (!productManager.oO0OX0() && mDeviceSelectedAIMode != 2) {
                oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 3");
                startRealTime();
                RecordingManager.Companion.getInstance().recordPermission(voiceManagerV2.getRecordingCallBack(), true, resetCallBack, TAG);
                return;
            } else {
                oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 2");
                RecordingManager.Companion.getInstance().recordPermission(voiceManagerV2.getRecordingCallBack(), false, resetCallBack, TAG);
                return;
            }
        }
        if (productManager.XI0IXoo()) {
            oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 1");
            MicrosoftSDKManage.O0(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), languageTranslationData.getAsrLanguage(), false, toLanguageTranslationData.getTtsViuceName(), toLanguageTranslationData.getAsrLanguage(), false, null, 32, null);
        } else if (!productManager.oO0OX0() && i != 2) {
            oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 3");
            startRealTime();
        } else {
            oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 identificationBegins 进入 2");
            RecordingManager.Companion.getInstance().startRealTimeASR();
        }
    }

    public final void identificationCompleted(@OXOo.oOoXoXO Oox.oOoXoXO<? super String, oXIO0o0XI> oooxoxo) {
        if (isPhoneRecord) {
            RecordingManager.Companion.getInstance().stopRecording();
        }
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            if (isPhoneRecord) {
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0OxxIOxX();
            } else {
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0();
            }
        } else if (productManager.oO0OX0() || mDeviceSelectedAIMode == 2) {
            if (isPhoneRecord) {
                RecordingManager.Companion.getInstance().stopRecording();
            } else {
                RecordingManager.realTimeASRend$default(RecordingManager.Companion.getInstance(), 0, 0, 3, null);
            }
        }
        if (!productManager.XI0IXoo() && !productManager.oO0OX0() && mDeviceSelectedAIMode != 2) {
            if (productManager.XOx()) {
                serviceIdentify(oooxoxo);
            }
        } else if (oooxoxo != null) {
            oooxoxo.invoke(mCompleteText);
        }
    }

    public final void identificationProcess(@OXOo.OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "byte");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!productManager.XOx()) {
            if (productManager.XI0IXoo()) {
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().XX0xXo(bArr);
            } else if (!productManager.oO0OX0() && mDeviceSelectedAIMode != 2) {
                sendRealTime(bArr);
            } else {
                RecordingManager.realTimeASRing$default(RecordingManager.Companion.getInstance(), bArr, 0, bArr.length, 2, null);
            }
        }
        FileIOUtils.writeFileFromBytesByStream(mPcmFile, bArr, true);
    }

    public final boolean isPhoneRecord() {
        return isPhoneRecord;
    }

    public final boolean isSendResults() {
        return isSendResults;
    }

    public final void sendRealTime(@OXOo.OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        try {
            PipedOutputStream pipedOutputStream = mOutputStream;
            if (pipedOutputStream != null) {
                pipedOutputStream.write(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void serviceIdentificationAudio(@OXOo.OOXIXo File file, @OXOo.oOoXoXO final xxxI.II0xO0<String> iI0xO0) {
        String language;
        IIX0o.x0xO0oo(file, "file");
        String IXxxXO2 = AIManager.f19833oIX0oI.IXxxXO(mDeviceSelectedAIMode);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String baseUrl = netWorkUtils.getBaseUrl(GetAIAudioToText.URL);
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        if (UtilsKt.IO(app)) {
            language = Languages.DEFAULT_LANGUAGE_ZH;
        } else {
            language = Utils.getApp().getResources().getConfiguration().locale.getLanguage();
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(TAG + " serviceIdentificationAudio -> " + file + "  toLang = " + language + " , model = " + IXxxXO2);
        AndroidNetworking.upload(baseUrl).addHeaders(netWorkUtils.getHeadersMap()).addQueryParameter("model", IXxxXO2).addQueryParameter("toLang", language).addMultipartFile("audioFile", file).setTag((Object) "serviceIdentificationAudio").setPriority(Priority.HIGH).build().setUploadProgressListener(new UploadProgressListener() { // from class: com.sma.smartv3.biz.voice.oIX0oI
            @Override // com.androidnetworking.interfaces.UploadProgressListener
            public final void onProgress(long j, long j2) {
                AIIdentificationManager.serviceIdentificationAudio$lambda$0(j, j2);
            }
        }).getAsJSONObject(new JSONObjectRequestListener() { // from class: com.sma.smartv3.biz.voice.AIIdentificationManager$serviceIdentificationAudio$2
            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onError(@OXOo.OOXIXo ANError anError) {
                AIError aIError;
                String str;
                IIX0o.x0xO0oo(anError, "anError");
                AIBase aIBase = (AIBase) anError.getErrorAsObject(AIBase.class);
                if (aIBase == null || (aIError = aIBase.getError()) == null) {
                    aIError = new AIError(String.valueOf(anError.getMessage()), null, null, null, 14, null);
                }
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = AIIdentificationManager.TAG;
                sb.append(str);
                sb.append("  serviceIdentificationAudio onError -> ");
                sb.append(anError.getErrorBody());
                sb.append(", ");
                sb.append(aIError);
                oix0oi.oIX0oI(sb.toString());
                xxxI.II0xO0<String> iI0xO02 = iI0xO0;
                if (iI0xO02 != null) {
                    iI0xO02.handleError(aIError.getMessage());
                }
            }

            @Override // com.androidnetworking.interfaces.JSONObjectRequestListener
            public void onResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                String str;
                xxxI.II0xO0<String> iI0xO02;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = AIIdentificationManager.TAG;
                sb.append(str);
                sb.append(" serviceIdentificationAudio onResponse -> ");
                sb.append(jSONObject);
                oix0oi.oIX0oI(sb.toString());
                if (jSONObject != null) {
                    try {
                        String string = jSONObject.getString("data");
                        if (string != null && (iI0xO02 = iI0xO0) != null) {
                            iI0xO02.handleResponse(string);
                        }
                    } catch (Exception unused) {
                        AIError aIError = new AIError(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error), null, null, null, 14, null);
                        xxxI.II0xO0<String> iI0xO03 = iI0xO0;
                        if (iI0xO03 != null) {
                            iI0xO03.handleError(aIError.getMessage());
                        }
                    }
                }
            }
        });
    }

    public final void setMContentResult(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        mContentResult = str;
    }

    public final void setMDeviceSelectedAIMode(int i) {
        mDeviceSelectedAIMode = i;
    }

    public final void setPhoneRecord(boolean z) {
        isPhoneRecord = z;
    }

    public final void setSendResults(boolean z) {
        isSendResults = z;
    }
}
