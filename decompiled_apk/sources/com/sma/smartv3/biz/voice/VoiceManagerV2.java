package com.sma.smartv3.biz.voice;

import android.app.Application;
import com.blankj.utilcode.util.FileUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.voice.AIIdentificationManager;
import com.sma.smartv3.biz.voice.AIModelManagerV2;
import com.sma.smartv3.biz.voice.OpusManager;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.AITranslation;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.entity.BleRecordPacket;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nVoiceManagerV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceManagerV2.kt\ncom/sma/smartv3/biz/voice/VoiceManagerV2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n1#2:332\n*E\n"})
/* loaded from: classes12.dex */
public final class VoiceManagerV2 {

    @OXOo.OOXIXo
    private static final String TAG = "AIManagerV2 VoiceManagerV2";
    private static Application mApp;

    @OXOo.oOoXoXO
    private static LanguageTranslationData mLanguageTranslationData;

    @OXOo.oOoXoXO
    private static OpusManager mOpusManager;

    @OXOo.oOoXoXO
    private static LanguageTranslationData mToLanguageTranslationData;

    @OXOo.OOXIXo
    public static final VoiceManagerV2 INSTANCE = new VoiceManagerV2();
    private static int mLanguage = -1;
    private static int mToLanguage = -1;
    private static int mAIMode = -1;

    @OXOo.OOXIXo
    private static final AIIdentificationManager.OnIdentificationCallback identificationCallback = new AIIdentificationManager.OnIdentificationCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManagerV2$identificationCallback$1
        @Override // com.sma.smartv3.biz.voice.AIIdentificationManager.OnIdentificationCallback
        public void onComplete(@OXOo.OOXIXo String text) {
            IIX0o.x0xO0oo(text, "text");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 identificationError -> onComplete: " + text);
        }

        @Override // com.sma.smartv3.biz.voice.AIIdentificationManager.OnIdentificationCallback
        public void onEndSuccess() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 identificationError -> onEndSuccess: ");
        }

        @Override // com.sma.smartv3.biz.voice.AIIdentificationManager.OnIdentificationCallback
        public void onIdentificationError(@OXOo.OOXIXo String msg) {
            IIX0o.x0xO0oo(msg, "msg");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 identificationError -> onError: " + msg);
        }

        @Override // com.sma.smartv3.biz.voice.AIIdentificationManager.OnIdentificationCallback
        public void onProcessComplete(@OXOo.OOXIXo String text) {
            IIX0o.x0xO0oo(text, "text");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 identificationError -> onProcessComplete: " + text);
        }

        @Override // com.sma.smartv3.biz.voice.AIIdentificationManager.OnIdentificationCallback
        public void onStartSuccess() {
        }
    };

    @OXOo.OOXIXo
    private static final AIModelManagerV2.OnAIModelCallback mAIModelCallback = new AIModelManagerV2.OnAIModelCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManagerV2$mAIModelCallback$1
        @Override // com.sma.smartv3.biz.voice.AIModelManagerV2.OnAIModelCallback
        public void onAIModelError(@OXOo.OOXIXo String msg) {
            IIX0o.x0xO0oo(msg, "msg");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 onAIModelError -> onComplete: " + msg);
        }

        @Override // com.sma.smartv3.biz.voice.AIModelManagerV2.OnAIModelCallback
        public void onComplete(@OXOo.OOXIXo String text) {
            IIX0o.x0xO0oo(text, "text");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 mAIModelCallback -> onComplete: " + text);
        }

        @Override // com.sma.smartv3.biz.voice.AIModelManagerV2.OnAIModelCallback
        public void onProcessComplete(@OXOo.OOXIXo String text) {
            IIX0o.x0xO0oo(text, "text");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 mAIModelCallback -> onProcessComplete: " + text);
        }
    };

    @OXOo.OOXIXo
    private static final RecordingManager.OnRecordingCallback recordingCallBack = new RecordingManager.OnRecordingCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManagerV2$recordingCallBack$1
        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onBeforeRecording() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 onRecordResult -> onBeforeRecording");
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResult(@OXOo.oOoXoXO AITranslation aITranslation) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 onRecordResult -> result: " + aITranslation);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultError(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 onRecordResultError -> error: " + error);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onRecordResultLanguage(@OXOo.oOoXoXO AISpeech aISpeech) {
            RecordingManager.OnRecordingCallback.DefaultImpls.onRecordResultLanguage(this, aISpeech);
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStartRecording() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 onRecordResult ->onStartRecording");
        }

        @Override // com.sma.smartv3.biz.voice.RecordingManager.OnRecordingCallback
        public void onStopRecording() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 onRecordResult -> onStopRecording");
        }
    };

    private VoiceManagerV2() {
    }

    private final void deleteFile() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 startTransfer delete  File");
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        FileUtils.delete(voiceManager.getMOpusFile());
        FileUtils.delete(voiceManager.getMPcmFile());
        FileUtils.delete(voiceManager.getMWavFile());
        DcsTtsPlayer.INSTANCE.deleteReplayMusic();
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis()));
        IIX0o.oO(format, "format(...)");
        voiceManager.setMSavePcmTime(format);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae A[EDGE_INSN: B:34:0x00ae->B:30:0x00ae BREAK  A[LOOP:1: B:24:0x0096->B:33:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void getTranslationLanguageType(com.szabh.smable3.entity.BleRecordPacket r8) {
        /*
            r7 = this;
            int r0 = r8.getMLanguage()
            com.sma.smartv3.biz.voice.VoiceManagerV2.mLanguage = r0
            int r8 = r8.getMToLanguage()
            com.sma.smartv3.biz.voice.VoiceManagerV2.mToLanguage = r8
            android.app.Application r8 = com.sma.smartv3.biz.voice.VoiceManagerV2.mApp
            java.lang.String r0 = "mApp"
            r1 = 0
            if (r8 != 0) goto L17
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r0)
            r8 = r1
        L17:
            boolean r8 = com.sma.smartv3.util.UtilsKt.X00IoxXI(r8)
            java.lang.String r2 = "en"
            java.lang.String r3 = "zh"
            if (r8 == 0) goto L24
            r8 = r3
            goto L25
        L24:
            r8 = r2
        L25:
            android.app.Application r4 = com.sma.smartv3.biz.voice.VoiceManagerV2.mApp
            if (r4 != 0) goto L2d
            kotlin.jvm.internal.IIX0o.XOxIOxOx(r0)
            r4 = r1
        L2d:
            boolean r0 = com.sma.smartv3.util.UtilsKt.X00IoxXI(r4)
            if (r0 == 0) goto L35
            r0 = r2
            goto L36
        L35:
            r0 = r3
        L36:
            com.sma.smartv3.ble.ProductManager r4 = com.sma.smartv3.ble.ProductManager.f20544oIX0oI
            boolean r5 = r4.XI0IXoo()
            if (r5 == 0) goto L50
            com.szabh.smable3.entity.Languages r8 = com.szabh.smable3.entity.Languages.INSTANCE
            int r0 = com.sma.smartv3.biz.voice.VoiceManagerV2.mLanguage
            java.lang.String r0 = r8.formatMicrosoftTargetLang(r0, r3)
            int r3 = com.sma.smartv3.biz.voice.VoiceManagerV2.mToLanguage
            java.lang.String r8 = r8.formatMicrosoftTargetLang(r3, r2)
        L4c:
            r6 = r0
            r0 = r8
            r8 = r6
            goto L65
        L50:
            boolean r4 = r4.oO0OX0()
            if (r4 == 0) goto L65
            com.szabh.smable3.entity.Languages r8 = com.szabh.smable3.entity.Languages.INSTANCE
            int r0 = com.sma.smartv3.biz.voice.VoiceManagerV2.mLanguage
            java.lang.String r0 = r8.formatAISparkTargetLang(r0, r3)
            int r3 = com.sma.smartv3.biz.voice.VoiceManagerV2.mToLanguage
            java.lang.String r8 = r8.formatAISparkTargetLang(r3, r2)
            goto L4c
        L65:
            java.util.List r2 = com.sma.smartv3.model.LanguageTranslationKt.getTranslationLanguageList()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L6f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L87
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.sma.smartv3.model.LanguageTranslationData r4 = (com.sma.smartv3.model.LanguageTranslationData) r4
            java.lang.String r4 = r4.getRtasrLanguage()
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r4, r8)
            if (r4 == 0) goto L6f
            goto L88
        L87:
            r3 = r1
        L88:
            com.sma.smartv3.model.LanguageTranslationData r3 = (com.sma.smartv3.model.LanguageTranslationData) r3
            com.sma.smartv3.biz.voice.VoiceManagerV2.mLanguageTranslationData = r3
            java.util.List r8 = com.sma.smartv3.model.LanguageTranslationKt.getTranslationLanguageList()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L96:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lae
            java.lang.Object r2 = r8.next()
            r3 = r2
            com.sma.smartv3.model.LanguageTranslationData r3 = (com.sma.smartv3.model.LanguageTranslationData) r3
            java.lang.String r3 = r3.getRtasrLanguage()
            boolean r3 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r0)
            if (r3 == 0) goto L96
            r1 = r2
        Lae:
            com.sma.smartv3.model.LanguageTranslationData r1 = (com.sma.smartv3.model.LanguageTranslationData) r1
            com.sma.smartv3.biz.voice.VoiceManagerV2.mToLanguageTranslationData = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.voice.VoiceManagerV2.getTranslationLanguageType(com.szabh.smable3.entity.BleRecordPacket):void");
    }

    @OXOo.OOXIXo
    public final AIIdentificationManager.OnIdentificationCallback getIdentificationCallback() {
        return identificationCallback;
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getLanguageTranslationData() {
        Object obj;
        List<LanguageTranslationData> translationLanguageList;
        int i;
        LanguageTranslationData languageTranslationData = mLanguageTranslationData;
        if (languageTranslationData != null) {
            IIX0o.ooOOo0oXI(languageTranslationData);
            return languageTranslationData;
        }
        Application application = mApp;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        String language = application.getResources().getConfiguration().locale.getLanguage();
        Iterator<T> it = LanguageTranslationKt.getTranslationLanguageList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((LanguageTranslationData) obj).getRtasrLanguage(), language)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) obj;
        if (languageTranslationData2 == null) {
            Application application3 = mApp;
            if (application3 == null) {
                IIX0o.XOxIOxOx("mApp");
            } else {
                application2 = application3;
            }
            if (UtilsKt.X00IoxXI(application2)) {
                translationLanguageList = LanguageTranslationKt.getTranslationLanguageList();
                i = 1;
            } else {
                translationLanguageList = LanguageTranslationKt.getTranslationLanguageList();
                i = 0;
            }
            return translationLanguageList.get(i);
        }
        return languageTranslationData2;
    }

    @OXOo.OOXIXo
    public final AIModelManagerV2.OnAIModelCallback getMAIModelCallback() {
        return mAIModelCallback;
    }

    public final int getMLanguage() {
        return mLanguage;
    }

    @OXOo.oOoXoXO
    public final LanguageTranslationData getMLanguageTranslationData() {
        return mLanguageTranslationData;
    }

    public final int getMToLanguage() {
        return mToLanguage;
    }

    @OXOo.oOoXoXO
    public final LanguageTranslationData getMToLanguageTranslationData() {
        return mToLanguageTranslationData;
    }

    @OXOo.OOXIXo
    public final RecordingManager.OnRecordingCallback getRecordingCallBack() {
        return recordingCallBack;
    }

    @OXOo.OOXIXo
    public final LanguageTranslationData getToLanguageTranslationData() {
        Object obj;
        List<LanguageTranslationData> translationLanguageList;
        int i;
        LanguageTranslationData languageTranslationData = mToLanguageTranslationData;
        if (languageTranslationData != null) {
            IIX0o.ooOOo0oXI(languageTranslationData);
            return languageTranslationData;
        }
        Application application = mApp;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        String language = application.getResources().getConfiguration().locale.getLanguage();
        Iterator<T> it = LanguageTranslationKt.getTranslationLanguageList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((LanguageTranslationData) obj).getRtasrLanguage(), language)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LanguageTranslationData languageTranslationData2 = (LanguageTranslationData) obj;
        if (languageTranslationData2 == null) {
            Application application3 = mApp;
            if (application3 == null) {
                IIX0o.XOxIOxOx("mApp");
            } else {
                application2 = application3;
            }
            if (UtilsKt.X00IoxXI(application2)) {
                translationLanguageList = LanguageTranslationKt.getTranslationLanguageList();
                i = 1;
            } else {
                translationLanguageList = LanguageTranslationKt.getTranslationLanguageList();
                i = 0;
            }
            return translationLanguageList.get(i);
        }
        return languageTranslationData2;
    }

    public final void init(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        mApp = app;
        if (mOpusManager == null) {
            try {
                mOpusManager = new OpusManager();
            } catch (Exception e) {
                e.printStackTrace();
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 -> opus init error！！！");
            }
        }
    }

    public final void onReceiveRecordPacketV2(@OXOo.OOXIXo BleRecordPacket recordPacket) {
        IIX0o.x0xO0oo(recordPacket, "recordPacket");
        int mStatus = recordPacket.getMStatus();
        if (mStatus != 0) {
            if (mStatus != 1) {
                if (mStatus != 2) {
                    if (mStatus != 3) {
                        if (mStatus == 5) {
                            DcsTtsPlayer.INSTANCE.replayMusic();
                            return;
                        }
                        return;
                    }
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    voiceManager.stop();
                    OpusManager opusManager = mOpusManager;
                    if (opusManager != null) {
                        opusManager.stopDecodeStream();
                    }
                    voiceManager.setSpeechRecRunning(false);
                    setVoiceMode(0);
                    return;
                }
                VoiceManager voiceManager2 = VoiceManager.INSTANCE;
                if (voiceManager2.isSpeechRecRunning()) {
                    voiceManager2.setSpeechRecRunning(false);
                    voiceManager2.stop();
                    OpusManager opusManager2 = mOpusManager;
                    if (opusManager2 != null) {
                        opusManager2.stopDecodeStream();
                    }
                    AIIdentificationManager.INSTANCE.identificationCompleted(new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.VoiceManagerV2$onReceiveRecordPacketV2$2
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str) {
                            invoke2(str);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.oOoXoXO String str) {
                            int i;
                            if (str != null && str.length() > 0) {
                                AIModelManagerV2 aIModelManagerV2 = AIModelManagerV2.INSTANCE;
                                AIModelManagerV2.OnAIModelCallback mAIModelCallback2 = VoiceManagerV2.INSTANCE.getMAIModelCallback();
                                i = VoiceManagerV2.mAIMode;
                                aIModelManagerV2.textAIFunction(str, mAIModelCallback2, i);
                                return;
                            }
                            VoiceManager.INSTANCE.sendTranslationResult(UtilsKt.oI0IIXIo(R.string.speech_recognition_error), "");
                        }
                    });
                    voiceManager2.endTransfer();
                    return;
                }
                OI0.oIX0oI.f1507oIX0oI.II0xO0("AIManagerV2 VoiceManagerV2 BleRecordPacket TRANSFER_STATUS_END isSpeechRecRunning = " + voiceManager2.isSpeechRecRunning());
                return;
            }
            OI0.oIX0oI.f1507oIX0oI.II0xO0("AIManagerV2 VoiceManagerV2  出来的一包数据 喂了一包数据给杰里  -> onDecodeStream");
            OpusManager opusManager3 = mOpusManager;
            if (opusManager3 != null) {
                opusManager3.writeAudioStream(recordPacket.getMPacket());
                return;
            }
            return;
        }
        VoiceManager voiceManager3 = VoiceManager.INSTANCE;
        if (voiceManager3.isSpeechRecRunning()) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("AIManagerV2 VoiceManagerV2 BleRecordPacket TRANSFER_STATUS_START isInputAudioSteam = " + voiceManager3.isSpeechRecRunning());
            return;
        }
        deleteFile();
        mAIMode = -1;
        if (ProjectManager.f19822oIX0oI.Ox0O()) {
            int mAIMode2 = recordPacket.getMAIMode();
            if (mAIMode2 != 0) {
                if (mAIMode2 != 1) {
                    if (mAIMode2 != 2) {
                        if (mAIMode2 == 3) {
                            mAIMode = 3;
                        }
                    } else {
                        mAIMode = 2;
                    }
                } else {
                    mAIMode = 1;
                }
            } else {
                mAIMode = 0;
            }
        }
        voiceManager3.setSpeechRecRunning(true);
        setVoiceMode(recordPacket.getMMode());
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.II0xO0("AIManagerV2 VoiceManagerV2 BleRecordPacket TRANSFER_STATUS_START mAIMode = " + mAIMode + " , mVoiceMode =  " + voiceManager3.getMVoiceMode());
        mLanguageTranslationData = null;
        mToLanguageTranslationData = null;
        if (voiceManager3.isSupportAIVoiceTranslation() || voiceManager3.isSupportEarPhoneVoiceTranslation()) {
            getTranslationLanguageType(recordPacket);
        }
        OpusManager opusManager4 = mOpusManager;
        if (opusManager4 != null) {
            opusManager4.stopDecodeStream();
        }
        if (!voiceManager3.isSupportEarPhoneVoiceAIChat() && !voiceManager3.isSupportEarPhoneVoiceTranslation()) {
            oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 BleRecordPacket 22222222222222");
            AIIdentificationManager.identificationBegins$default(AIIdentificationManager.INSTANCE, false, identificationCallback, false, mAIMode, 4, null);
            OpusManager opusManager5 = mOpusManager;
            if (opusManager5 != null) {
                opusManager5.startDecodeStream(new OpusManager.OnDecodeStreamCallback() { // from class: com.sma.smartv3.biz.voice.VoiceManagerV2$onReceiveRecordPacketV2$1
                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onComplete(@OXOo.OOXIXo String complete) {
                        IIX0o.x0xO0oo(complete, "complete");
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnDecodeStreamCallback
                    public void onDecodeStream(@OXOo.OOXIXo byte[] bArr) {
                        IIX0o.x0xO0oo(bArr, "byte");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2  杰里解出来的一包数据  -> onDecodeStream: " + bArr.length);
                        AIIdentificationManager.INSTANCE.identificationProcess(bArr);
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onError(int i, @OXOo.OOXIXo String error) {
                        IIX0o.x0xO0oo(error, "error");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 startDecodeStream -> onError: " + i + ", " + error);
                    }

                    @Override // com.sma.smartv3.biz.voice.OpusManager.OnStateCallback
                    public void onStart() {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManagerV2 VoiceManagerV2 BleRecordPacket 3333333333333");
                    }
                });
                return;
            }
            return;
        }
        oix0oi.oIX0oI("AIManagerV2 VoiceManagerV2 BleRecordPacket 1111111111111");
        AIIdentificationManager.identificationBegins$default(AIIdentificationManager.INSTANCE, true, identificationCallback, false, mAIMode, 4, null);
    }

    public final void setMLanguage(int i) {
        mLanguage = i;
    }

    public final void setMLanguageTranslationData(@OXOo.oOoXoXO LanguageTranslationData languageTranslationData) {
        mLanguageTranslationData = languageTranslationData;
    }

    public final void setMToLanguage(int i) {
        mToLanguage = i;
    }

    public final void setMToLanguageTranslationData(@OXOo.oOoXoXO LanguageTranslationData languageTranslationData) {
        mToLanguageTranslationData = languageTranslationData;
    }

    public final void setTranslationLanguageData(@OXOo.OOXIXo LanguageTranslationData leftTranslation, @OXOo.OOXIXo LanguageTranslationData rightTranslation) {
        IIX0o.x0xO0oo(leftTranslation, "leftTranslation");
        IIX0o.x0xO0oo(rightTranslation, "rightTranslation");
        mLanguageTranslationData = leftTranslation;
        mToLanguageTranslationData = rightTranslation;
    }

    public final void setVoiceMode(int i) {
        VoiceManager.INSTANCE.setMVoiceMode(i);
    }
}
