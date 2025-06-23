package com.sma.smartv3.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.baidu.ar.base.MsgField;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.utils.bc;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.microsoft.cognitiveservices.speech.AudioDataStream;
import com.microsoft.cognitiveservices.speech.AutoDetectSourceLanguageConfig;
import com.microsoft.cognitiveservices.speech.AutoDetectSourceLanguageResult;
import com.microsoft.cognitiveservices.speech.CancellationDetails;
import com.microsoft.cognitiveservices.speech.Connection;
import com.microsoft.cognitiveservices.speech.ConnectionEventArgs;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SessionEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionCanceledEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisCancellationDetails;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisOutputFormat;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisResult;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisWordBoundaryEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioStreamFormat;
import com.microsoft.cognitiveservices.speech.audio.PullAudioInputStreamCallback;
import com.microsoft.cognitiveservices.speech.util.EventHandler;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AITranslatorText;
import com.sma.smartv3.model.DeviceKeyManager;
import com.sma.smartv3.model.LeftAndRightPlayControl;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.network.ToTranslatorText;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nMicrosoftSDKManage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MicrosoftSDKManage.kt\ncom/sma/smartv3/util/MicrosoftSDKManage\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 4 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1168:1\n15#2:1169\n27#2,2:1170\n27#2,2:1172\n15#2:1174\n27#2,2:1175\n27#2,2:1199\n173#3,12:1177\n194#3:1198\n234#4,8:1189\n254#4:1197\n1#5:1201\n*S KotlinDebug\n*F\n+ 1 MicrosoftSDKManage.kt\ncom/sma/smartv3/util/MicrosoftSDKManage\n*L\n363#1:1169\n367#1:1170,2\n413#1:1172,2\n429#1:1174\n433#1:1175,2\n943#1:1199,2\n785#1:1177,12\n785#1:1198\n785#1:1189,8\n785#1:1197\n*E\n"})
/* loaded from: classes12.dex */
public final class MicrosoftSDKManage {

    /* renamed from: X00IoxXI */
    @OXOo.OOXIXo
    public static volatile MicrosoftSDKManage f24258X00IoxXI;

    /* renamed from: Xx000oIo */
    @OXOo.OOXIXo
    public static final II0xO0 f24259Xx000oIo;

    /* renamed from: IIX0o */
    @OXOo.oOoXoXO
    public SpeechSynthesizer f24263IIX0o;

    /* renamed from: IIXOooo */
    @OXOo.oOoXoXO
    public Connection f24264IIXOooo;

    /* renamed from: IXxxXO */
    @OXOo.oOoXoXO
    public SpeechRecognizer f24265IXxxXO;

    /* renamed from: IoOoX */
    public boolean f24266IoOoX;

    /* renamed from: OOXIXo */
    @OXOo.oOoXoXO
    public AudioRecord f24268OOXIXo;

    /* renamed from: Oo */
    @OXOo.oOoXoXO
    public AudioConfig f24269Oo;

    /* renamed from: OxI */
    public boolean f24270OxI;

    /* renamed from: OxxIIOOXO */
    @OXOo.oOoXoXO
    public I0Io f24273OxxIIOOXO;

    /* renamed from: X0IIOO */
    public boolean f24274X0IIOO;

    /* renamed from: XxX0x0xxx */
    @OXOo.oOoXoXO
    public List<String> f24279XxX0x0xxx;

    /* renamed from: o00 */
    public boolean f24280o00;

    /* renamed from: oO */
    @OXOo.oOoXoXO
    public PipedOutputStream f24283oO;

    /* renamed from: oOoXoXO */
    @OXOo.oOoXoXO
    public SpeechConfig f24285oOoXoXO;

    /* renamed from: oo0xXOI0I */
    @OXOo.oOoXoXO
    public AudioTrack f24287oo0xXOI0I;

    /* renamed from: ooOOo0oXI */
    @OXOo.oOoXoXO
    public ExecutorService f24288ooOOo0oXI;

    /* renamed from: ooXIXxIX */
    @OXOo.oOoXoXO
    public Connection f24289ooXIXxIX;

    /* renamed from: x0XOIxOo */
    @OXOo.oOoXoXO
    public PipedInputStream f24291x0XOIxOo;

    /* renamed from: x0xO0oo */
    @OXOo.oOoXoXO
    public oIX0oI f24292x0xO0oo;

    /* renamed from: xI */
    @OXOo.oOoXoXO
    public XO f24293xI;

    /* renamed from: xXxxox0I */
    public int f24294xXxxox0I;

    /* renamed from: xoIox */
    @OXOo.oOoXoXO
    public AudioStreamFormat f24295xoIox;

    /* renamed from: xoXoI */
    public boolean f24296xoXoI;

    /* renamed from: oIX0oI */
    @OXOo.OOXIXo
    public final String f24282oIX0oI = "MicrosoftSDKManage";

    /* renamed from: II0xO0 */
    @OXOo.OOXIXo
    public String f24262II0xO0 = "";

    /* renamed from: I0Io */
    @OXOo.OOXIXo
    public final String f24260I0Io = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMSYRDL622EITIIaa0WmoN+Ha4/3uUoRibYSFtrpgnHIN0VX62SGtJ4YxFYDH60Y9G/A+YvBYss4AccMPFQ0lyEDjYoDveJk1sbIWCrcEbTfMJumx1X3wBkIvrlymsiZ6NnVYKYEmee+0Gco0Yo/4T1t8dXhQESlHGPxoA78IKPBAgMBAAECgYAG+xWr3kDBOa1WzteZi+zJNyqsfGpHzSbf0FVfrVxAjFCbHZ+6DHb4KK67E6YRrFHMsJRj4ChxCSJ2BhMT1eC6X1G3G+mFu8KgMfLq6D1WRPWkvkVXPZf0hKyftiZs/Az0qDPeJSVw8tWCuYSMXshSMFDxX0Fmy4dHJY4XSWNpOQJBANw/eDyd0tZ3xBtDSJ6cJ6l2yxtMQOaWr9x4NltNXMg7yHLoLU3+rzlzTOguRy7uGv5TnKtztS1Oe5VTsE75TXkCQQDkgeB7DgDr7w5GDDH92Sl0tuQRFronSvpov/jrbAsVkhfmHmR/e7wPHFRYyCBrOw4DveKAuZeoTzOcJR1gMh6JAkAopo5KodaIPxKy9XgxziCD5qkWILzZ0nYi+w0NTPoS+vXEP5YdDyTINb+8Gs6Imunghw4jlveZpSKqLQgdi2YBAkEApN1fzOjJmXAc6EUcPH5V/rOF0R6IqJjcGn+HZLPLO4DwZUNAVwo7INvbr0KUwUkWT3TM2vsMhI7AOcQ9cY43oQJBAMeunVJ5aeCSwCLyrc19YfYj4tc2ouscFSDoeJ3gHdEB4+sNhhny9R91xOqBZGPYOxD2Vokly9nSCfIz3wtuGq0=";

    /* renamed from: oxoX */
    @OXOo.OOXIXo
    public final String f24290oxoX = "eastus";

    /* renamed from: X0o0xo */
    @OXOo.OOXIXo
    public final String f24275X0o0xo = "RSA";

    /* renamed from: XO */
    @OXOo.OOXIXo
    public final String f24278XO = "RSA/ECB/PKCS1Padding";

    /* renamed from: Oxx0IOOO */
    @OXOo.OOXIXo
    public final String f24271Oxx0IOOO = "AES";

    /* renamed from: II0XooXoX */
    @OXOo.OOXIXo
    public final String f24261II0XooXoX = "AES/ECB/PKCS5Padding";

    /* renamed from: xxIXOIIO */
    public final int f24297xxIXOIIO = 16000;

    /* renamed from: Oxx0xo */
    @OXOo.OOXIXo
    public final ArrayList<String> f24272Oxx0xo = new ArrayList<>();

    /* renamed from: oI0IIXIo */
    @OXOo.OOXIXo
    public final ArrayList<String> f24281oI0IIXIo = new ArrayList<>();

    /* renamed from: O0xOxO */
    @OXOo.OOXIXo
    public final Handler f24267O0xOxO = new Handler(Looper.getMainLooper());

    /* renamed from: XI0IXoo */
    public boolean f24276XI0IXoo = true;

    /* renamed from: XIxXXX0x0 */
    @OXOo.OOXIXo
    public String f24277XIxXXX0x0 = bc.Code;

    /* renamed from: xxX */
    @OXOo.OOXIXo
    public String f24298xxX = "zh-CN-XiaomoNeural";

    /* renamed from: oo */
    @OXOo.OOXIXo
    public final Object f24286oo = new Object();

    /* renamed from: oOXoIIIo */
    public boolean f24284oOXoIIIo = true;

    /* loaded from: classes12.dex */
    public interface I0Io {

        /* loaded from: classes12.dex */
        public static final class oIX0oI {
            public static void oIX0oI(@OXOo.OOXIXo I0Io i0Io, int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String detectedLanguage) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
                kotlin.jvm.internal.IIX0o.x0xO0oo(detectedLanguage, "detectedLanguage");
            }
        }

        void onIdentifyResults(int i, @OXOo.OOXIXo String str);

        void onIdentifyResultsDetectedLanguage(int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2);

        void onStartTransmission();

        void onStopTransmission();
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 {
        public /* synthetic */ II0xO0(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(@OXOo.OOXIXo MicrosoftSDKManage microsoftSDKManage) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(microsoftSDKManage, "<set-?>");
            MicrosoftSDKManage.f24258X00IoxXI = microsoftSDKManage;
        }

        @OXOo.OOXIXo
        public final MicrosoftSDKManage oIX0oI() {
            return MicrosoftSDKManage.f24258X00IoxXI;
        }

        public II0xO0() {
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
            kotlin.jvm.internal.IIX0o.x0xO0oo(intent, "intent");
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO("android.media.ACTION_SCO_AUDIO_STATE_UPDATED", intent.getAction())) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                if (intExtra != -1) {
                    if (intExtra != 0) {
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                OI0.oIX0oI.f1507oIX0oI.oIX0oI(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24282oIX0oI + " RecordingManager SCO Audio State: CONNECTING");
                                return;
                            }
                            return;
                        }
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24282oIX0oI + " RecordingManager SCO Audio State: CONNECTED");
                        RecordingManager.Companion.getInstance().setScoOnOpen();
                        return;
                    }
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24282oIX0oI + " RecordingManager SCO Audio State: DISCONNECTED");
                    return;
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24282oIX0oI + " RecordingManager SCO Audio State: ERROR");
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class XO implements Runnable {

        /* renamed from: XO */
        @OXOo.oOoXoXO
        public String f24306XO;

        /* renamed from: Oo */
        @OXOo.OOXIXo
        public String f24304Oo = "";

        /* renamed from: IXxxXO */
        @OXOo.OOXIXo
        public LeftAndRightPlayControl f24303IXxxXO = LeftAndRightPlayControl.LEFT_AND_RIGHT;

        /* renamed from: Oxx0xo */
        public int f24305Oxx0xo = -1;

        public final void I0Io(int i) {
            AudioDeviceInfo[] devices;
            int type;
            int type2;
            Object systemService = Utils.getApp().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            if (Build.VERSION.SDK_INT >= 23) {
                devices = audioManager.getDevices(2);
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(devices);
                AudioDeviceInfo audioDeviceInfo = null;
                AudioDeviceInfo audioDeviceInfo2 = null;
                for (AudioDeviceInfo audioDeviceInfo3 : devices) {
                    type = audioDeviceInfo3.getType();
                    if (type != 8) {
                        type2 = audioDeviceInfo3.getType();
                        if (type2 == 2) {
                            audioDeviceInfo = audioDeviceInfo3;
                        }
                    } else {
                        audioDeviceInfo2 = audioDeviceInfo3;
                    }
                }
                if (i != 2) {
                    if (i != 8) {
                        AudioTrack audioTrack = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24287oo0xXOI0I;
                        if (audioTrack != null) {
                            audioTrack.setPreferredDevice(null);
                            return;
                        }
                        return;
                    }
                    if (audioDeviceInfo2 != null) {
                        AudioTrack audioTrack2 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24287oo0xXOI0I;
                        if (audioTrack2 != null) {
                            audioTrack2.setPreferredDevice(audioDeviceInfo2);
                            return;
                        }
                        return;
                    }
                    AudioTrack audioTrack3 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24287oo0xXOI0I;
                    if (audioTrack3 != null) {
                        audioTrack3.setPreferredDevice(null);
                        return;
                    }
                    return;
                }
                if (audioDeviceInfo != null) {
                    AudioTrack audioTrack4 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24287oo0xXOI0I;
                    if (audioTrack4 != null) {
                        audioTrack4.setPreferredDevice(audioDeviceInfo);
                        return;
                    }
                    return;
                }
                AudioTrack audioTrack5 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24287oo0xXOI0I;
                if (audioTrack5 != null) {
                    audioTrack5.setPreferredDevice(null);
                }
            }
        }

        public final void II0xO0(@OXOo.OOXIXo String ttsName) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(ttsName, "ttsName");
            this.f24304Oo = ttsName;
        }

        public final void X0o0xo(@OXOo.OOXIXo LeftAndRightPlayControl leftOrRight) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(leftOrRight, "leftOrRight");
            this.f24303IXxxXO = leftOrRight;
        }

        public final void oIX0oI(int i) {
            this.f24305Oxx0xo = i;
        }

        public final void oxoX(@OXOo.oOoXoXO String str) {
            this.f24306XO = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            II0xO0 iI0xO0;
            byte b;
            byte b2;
            byte b3;
            byte b4;
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            II0xO0 iI0xO02 = MicrosoftSDKManage.f24259Xx000oIo;
            sb.append(iI0xO02.oIX0oI().f24282oIX0oI);
            sb.append(" run content = ");
            sb.append(this.f24306XO);
            oix0oi.oIX0oI(sb.toString());
            try {
                DcsTtsPlayer.INSTANCE.getMTtsFilePcm().delete();
                I0Io(this.f24305Oxx0xo);
                AudioTrack audioTrack = iI0xO02.oIX0oI().f24287oo0xXOI0I;
                if (audioTrack != null) {
                    audioTrack.play();
                }
                synchronized (iI0xO02.oIX0oI().f24286oo) {
                    iI0xO02.oIX0oI().f24266IoOoX = false;
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
                if (iI0xO02.oIX0oI().f24263IIX0o == null) {
                    oix0oi.oIX0oI(iI0xO02.oIX0oI().f24282oIX0oI + " synthesizer = null.");
                    return;
                }
                if (!iI0xO02.oIX0oI().f24284oOXoIIIo) {
                    return;
                }
                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24304Oo, iI0xO02.oIX0oI().XOxIOxOx())) {
                    SpeechConfig speechConfig = iI0xO02.oIX0oI().f24285oOoXoXO;
                    if (speechConfig != null) {
                        speechConfig.setSpeechSynthesisOutputFormat(SpeechSynthesisOutputFormat.Raw24Khz16BitMonoPcm);
                    }
                    SpeechConfig speechConfig2 = iI0xO02.oIX0oI().f24285oOoXoXO;
                    if (speechConfig2 != null) {
                        speechConfig2.setSpeechSynthesisVoiceName(this.f24304Oo);
                    }
                    iI0xO02.oIX0oI().f24263IIX0o = new SpeechSynthesizer(iI0xO02.oIX0oI().f24285oOoXoXO, (AudioConfig) null);
                }
                iI0xO02.oIX0oI().f24284oOXoIIIo = false;
                StatManager.f20200oIX0oI.II0xO0(10);
                SpeechSynthesizer speechSynthesizer = iI0xO02.oIX0oI().f24263IIX0o;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechSynthesizer);
                SpeechSynthesisResult speechSynthesisResult = speechSynthesizer.StartSpeakingTextAsync(this.f24306XO).get();
                kotlin.jvm.internal.IIX0o.oO(speechSynthesisResult, "get(...)");
                AudioDataStream fromResult = AudioDataStream.fromResult(speechSynthesisResult);
                byte[] bArr = new byte[MsgField.MSG_PADDLE_INIT];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(iI0xO02.oIX0oI().f24282oIX0oI);
                sb2.append(" microsoftLeftOrRight = ");
                sb2.append(this.f24303IXxxXO);
                sb2.append(TokenParser.SP);
                if (this.f24303IXxxXO != LeftAndRightPlayControl.RIGHT) {
                    z = true;
                } else {
                    z = false;
                }
                sb2.append(z);
                sb2.append(TokenParser.SP);
                if (this.f24303IXxxXO != LeftAndRightPlayControl.LEFT) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sb2.append(z2);
                oix0oi.oIX0oI(sb2.toString());
                while (true) {
                    iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
                    if (iI0xO0.oIX0oI().f24266IoOoX || fromResult.readData(bArr) == 0) {
                        break;
                    }
                    byte[] bArr2 = new byte[4800];
                    for (int i = 0; i < 4800; i++) {
                        bArr2[i] = 0;
                    }
                    int I0Io2 = xx0o0O.x0XOIxOo.I0Io(0, 2399, 2);
                    if (I0Io2 >= 0) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2 * 2;
                            LeftAndRightPlayControl leftAndRightPlayControl = this.f24303IXxxXO;
                            LeftAndRightPlayControl leftAndRightPlayControl2 = LeftAndRightPlayControl.RIGHT;
                            if (leftAndRightPlayControl != leftAndRightPlayControl2) {
                                b = bArr[i2];
                            } else {
                                b = 0;
                            }
                            bArr2[i3] = b;
                            int i4 = i3 + 1;
                            if (leftAndRightPlayControl != leftAndRightPlayControl2) {
                                b2 = bArr[i2 + 1];
                            } else {
                                b2 = 0;
                            }
                            bArr2[i4] = b2;
                            int i5 = i3 + 2;
                            LeftAndRightPlayControl leftAndRightPlayControl3 = LeftAndRightPlayControl.LEFT;
                            if (leftAndRightPlayControl != leftAndRightPlayControl3) {
                                b3 = bArr[i2];
                            } else {
                                b3 = 0;
                            }
                            bArr2[i5] = b3;
                            int i6 = i3 + 3;
                            if (leftAndRightPlayControl != leftAndRightPlayControl3) {
                                b4 = bArr[i2 + 1];
                            } else {
                                b4 = 0;
                            }
                            bArr2[i6] = b4;
                            if (i2 == I0Io2) {
                                break;
                            } else {
                                i2 += 2;
                            }
                        }
                    }
                    AudioTrack audioTrack2 = MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24287oo0xXOI0I;
                    if (audioTrack2 != null) {
                        audioTrack2.write(bArr2, 0, 4800);
                    }
                    FileIOUtils.writeFileFromBytesByStream(DcsTtsPlayer.INSTANCE.getMTtsFilePcm(), bArr, true);
                }
                iI0xO0.oIX0oI().f24284oOXoIIIo = true;
                fromResult.close();
            } catch (Exception e) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().f24282oIX0oI + " unexpected " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nMicrosoftSDKManage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MicrosoftSDKManage.kt\ncom/sma/smartv3/util/MicrosoftSDKManage$AudioInputStream\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,1168:1\n15#2:1169\n27#2,2:1170\n*S KotlinDebug\n*F\n+ 1 MicrosoftSDKManage.kt\ncom/sma/smartv3/util/MicrosoftSDKManage$AudioInputStream\n*L\n718#1:1169\n720#1:1170,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI extends PullAudioInputStreamCallback {

        /* renamed from: II0xO0 */
        @OXOo.oOoXoXO
        public PipedOutputStream f24307II0xO0;

        /* renamed from: oIX0oI */
        @OXOo.oOoXoXO
        public PipedInputStream f24308oIX0oI;

        public final void I0Io(@OXOo.oOoXoXO PipedInputStream pipedInputStream) {
            this.f24308oIX0oI = pipedInputStream;
        }

        @OXOo.oOoXoXO
        public final PipedOutputStream II0xO0() {
            return this.f24307II0xO0;
        }

        public final void X0o0xo(@OXOo.oOoXoXO PipedInputStream pipedInputStream, @OXOo.oOoXoXO PipedOutputStream pipedOutputStream) {
            this.f24308oIX0oI = pipedInputStream;
            this.f24307II0xO0 = pipedOutputStream;
            if (pipedInputStream != null && pipedOutputStream != null && pipedInputStream != null) {
                pipedInputStream.connect(pipedOutputStream);
            }
        }

        public final void XO(@OXOo.OOXIXo byte[] bytes) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(bytes, "bytes");
            try {
                PipedOutputStream pipedOutputStream = this.f24307II0xO0;
                if (pipedOutputStream != null && pipedOutputStream != null) {
                    pipedOutputStream.write(bytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
                synchronized (this) {
                    try {
                        II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
                        MicrosoftSDKManage oIX0oI2 = iI0xO0.oIX0oI();
                        oIX0oI2.ox(oIX0oI2.X00IoxXI() + 1);
                        if (iI0xO0.oIX0oI().X00IoxXI() > 50) {
                            iI0xO0.oIX0oI().ox(0);
                            Xo0 xo0 = Xo0.f24349oIX0oI;
                            if (((DeviceKeyManager) new Gson().fromJson(xo0.oIX0oI().getString(DeviceKeyManager.class.getName()), DeviceKeyManager.class)) != null) {
                                xo0.oIX0oI().remove(DeviceKeyManager.class.getName());
                                iI0xO0.oIX0oI().x0();
                                iI0xO0.oIX0oI().I0oOoX();
                            }
                        }
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("MicrosoftSDKManage writeDynamicsData e = " + e);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // com.microsoft.cognitiveservices.speech.audio.PullAudioInputStreamCallback
        public void close() {
            try {
                PipedOutputStream pipedOutputStream = this.f24307II0xO0;
                if (pipedOutputStream != null) {
                    pipedOutputStream.close();
                }
                PipedInputStream pipedInputStream = this.f24308oIX0oI;
                if (pipedInputStream != null) {
                    pipedInputStream.close();
                }
                RecordingManager.Companion.getInstance().setRecording(false);
                II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
                if (iI0xO0.oIX0oI().OI0() != null) {
                    AudioRecord OI02 = iI0xO0.oIX0oI().OI0();
                    if (OI02 != null) {
                        OI02.stop();
                    }
                    AudioRecord OI03 = iI0xO0.oIX0oI().OI0();
                    if (OI03 != null) {
                        OI03.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("MicrosoftSDKManage close e = " + e);
            }
        }

        @OXOo.oOoXoXO
        public final PipedInputStream oIX0oI() {
            return this.f24308oIX0oI;
        }

        public final void oxoX(@OXOo.oOoXoXO PipedOutputStream pipedOutputStream) {
            this.f24307II0xO0 = pipedOutputStream;
        }

        @Override // com.microsoft.cognitiveservices.speech.audio.PullAudioInputStreamCallback
        public int read(@OXOo.oOoXoXO byte[] bArr) {
            PipedInputStream pipedInputStream;
            long j;
            long j2;
            int i;
            II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            if (iI0xO0.oIX0oI().xXOx()) {
                if (iI0xO0.oIX0oI().OI0() != null && bArr != null) {
                    try {
                        synchronized (iI0xO0.oIX0oI()) {
                            try {
                                AudioRecord OI02 = iI0xO0.oIX0oI().OI0();
                                if (OI02 != null) {
                                    j2 = OI02.read(bArr, 0, bArr.length);
                                } else {
                                    j2 = 0;
                                }
                                FileIOUtils.writeFileFromBytesByStream(VoiceManager.INSTANCE.getMPcmFile(), bArr, true);
                                i = (int) j2;
                            } finally {
                            }
                        }
                        return i;
                    } catch (Exception e) {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI(e.toString());
                    }
                }
            } else if (bArr != null && (pipedInputStream = this.f24308oIX0oI) != null) {
                if (pipedInputStream != null) {
                    j = pipedInputStream.read(bArr, 0, bArr.length);
                } else {
                    j = -1;
                }
                return (int) j;
            }
            return 0;
        }
    }

    /* loaded from: classes12.dex */
    public interface oxoX<T> {
        void oIX0oI(T t);
    }

    static {
        MicrosoftSDKManage microsoftSDKManage;
        II0xO0 iI0xO0 = new II0xO0(null);
        f24259Xx000oIo = iI0xO0;
        synchronized (iI0xO0) {
            microsoftSDKManage = new MicrosoftSDKManage();
            f24258X00IoxXI = microsoftSDKManage;
        }
        f24258X00IoxXI = microsoftSDKManage;
    }

    public static final void I0oOIX(Object obj, SpeechSynthesisEventArgs e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
        e.close();
    }

    public static /* synthetic */ void IIX0(MicrosoftSDKManage microsoftSDKManage, I0Io i0Io, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        microsoftSDKManage.O0X(i0Io, str);
    }

    public static final void IXO(MicrosoftSDKManage this$0, Object obj, SpeechRecognitionEventArgs speechRecognitionResultEventArgs) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(speechRecognitionResultEventArgs, "speechRecognitionResultEventArgs");
        SpeechRecognitionResult result = speechRecognitionResultEventArgs.getResult();
        String text = result.getText();
        String language = AutoDetectSourceLanguageResult.fromResult(result).getLanguage();
        this$0.f24281oI0IIXIo.add(text);
        this$0.f24272Oxx0xo.clear();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this$0.f24282oIX0oI);
        sb.append("  Final result received:  -> ");
        sb.append(text);
        sb.append(" , detectedLanguage: ");
        sb.append(language);
        sb.append("  , mSpeechCallback = ");
        if (this$0.f24273OxxIIOOXO != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        oix0oi.oIX0oI(sb.toString());
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            String join = TextUtils.join("*", this$0.f24281oI0IIXIo);
            kotlin.jvm.internal.IIX0o.oO(join, "join(...)");
            i0Io.onIdentifyResults(2, join);
        }
        I0Io i0Io2 = this$0.f24273OxxIIOOXO;
        if (i0Io2 != null) {
            String join2 = TextUtils.join("*", this$0.f24281oI0IIXIo);
            kotlin.jvm.internal.IIX0o.oO(join2, "join(...)");
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(language);
            i0Io2.onIdentifyResultsDetectedLanguage(2, join2, language);
        }
    }

    public static /* synthetic */ void IoOoX(MicrosoftSDKManage microsoftSDKManage, String str, String str2, LeftAndRightPlayControl leftAndRightPlayControl, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = microsoftSDKManage.f24298xxX;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        microsoftSDKManage.oo(str, str2, leftAndRightPlayControl, i);
    }

    public static final void IoOoo(MicrosoftSDKManage this$0, Object obj, SpeechSynthesisWordBoundaryEventArgs e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Word boundary. Text offset " + e.getTextOffset() + ", length " + e.getWordLength() + "; audio offset " + (e.getAudioOffset() / 10000) + " ms.");
    }

    public static final void IoXIXo(MicrosoftSDKManage this$0, Object obj, ConnectionEventArgs connectionEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Recognizer connection established.");
    }

    public static final void Ix00oIoI(MicrosoftSDKManage this$0, Object obj, SessionEventArgs sessionEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(sessionEventArgs, "sessionEventArgs");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + "  sessionStarted:  --->");
    }

    public static /* synthetic */ void O0(MicrosoftSDKManage microsoftSDKManage, String str, boolean z, String str2, String str3, boolean z2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bc.Code;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str2 = "zh-CN-XiaomoNeural";
        }
        if ((i & 8) != 0) {
            str3 = bc.Code;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        if ((i & 32) != 0) {
            str4 = "";
        }
        microsoftSDKManage.Ox0O(str, z, str2, str3, z2, str4);
    }

    public static final void O0IxXx(MicrosoftSDKManage this$0, Object obj, SessionEventArgs sessionEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(sessionEventArgs, "sessionEventArgs");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + "  sessionStopped:  --->");
    }

    public static final void O0Xx(MicrosoftSDKManage this$0, Object obj, SpeechSynthesisEventArgs e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Synthesis started..");
        e.close();
    }

    public static final void OIOoIIOIx(MicrosoftSDKManage this$0, Void r1) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            i0Io.onStartTransmission();
        }
    }

    public static final void OO(MicrosoftSDKManage this$0, Object obj, SpeechSynthesisEventArgs e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
        String speechSynthesisCancellationDetails = SpeechSynthesisCancellationDetails.fromResult(e.getResult()).toString();
        kotlin.jvm.internal.IIX0o.oO(speechSynthesisCancellationDetails, "toString(...)");
        LogUtils.d(this$0.f24282oIX0oI + " Error synthesizing. Result ID. = " + e.getResult().getResultId() + " , Error detail = " + System.lineSeparator() + speechSynthesisCancellationDetails + System.lineSeparator() + "    Did you update the subscription info?");
        e.close();
    }

    public static final void OoO(MicrosoftSDKManage this$0, Object obj, SpeechRecognitionEventArgs speechRecognitionResultEventArgs) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(speechRecognitionResultEventArgs, "speechRecognitionResultEventArgs");
        String text = speechRecognitionResultEventArgs.getResult().getText();
        this$0.f24281oI0IIXIo.add(text);
        this$0.f24272Oxx0xo.clear();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this$0.f24282oIX0oI);
        sb.append("  Final result received:  -> ");
        sb.append(text);
        sb.append(" ,  mSpeechCallback = ");
        if (this$0.f24273OxxIIOOXO != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        oix0oi.oIX0oI(sb.toString());
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            String join = TextUtils.join(" ", this$0.f24281oI0IIXIo);
            kotlin.jvm.internal.IIX0o.oO(join, "join(...)");
            i0Io.onIdentifyResults(2, join);
        }
    }

    public static final void X0xII0I(MicrosoftSDKManage this$0, Void r3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Continuous recognition stopped");
        this$0.oOXoIIIo();
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            i0Io.onStopTransmission();
        }
    }

    public static /* synthetic */ void XIo0oOXIx(MicrosoftSDKManage microsoftSDKManage, I0Io i0Io, int i, Object obj) {
        if ((i & 1) != 0) {
            i0Io = null;
        }
        microsoftSDKManage.OO0x0xX(i0Io);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XOxxooXI(MicrosoftSDKManage microsoftSDKManage, String str, String str2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        microsoftSDKManage.oXxOI0oIx(str, str2, oooxoxo);
    }

    public static final void XXoOx0(MicrosoftSDKManage this$0, Object obj, SpeechRecognitionEventArgs speechRecognitionResultEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(speechRecognitionResultEventArgs, "speechRecognitionResultEventArgs");
        this$0.f24272Oxx0xo.add(speechRecognitionResultEventArgs.getResult().getText());
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Intermediate result received:  ---> " + TextUtils.join(" ", this$0.f24272Oxx0xo));
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            i0Io.onIdentifyResults(1, TextUtils.join(" ", this$0.f24281oI0IIXIo) + TextUtils.join(" ", this$0.f24272Oxx0xo));
        }
        ArrayList<String> arrayList = this$0.f24272Oxx0xo;
        arrayList.remove(arrayList.size() - 1);
    }

    public static final void Xo0(MicrosoftSDKManage this$0, Object obj, ConnectionEventArgs connectionEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f24296xoXoI = true;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Connection established..");
    }

    public static final void XoI0Ixx0(MicrosoftSDKManage this$0, Object obj, ConnectionEventArgs connectionEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.f24296xoXoI = false;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Disconnected..");
    }

    public static final void o0oIxOo(MicrosoftSDKManage this$0, Void r1) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            i0Io.onStartTransmission();
        }
    }

    public static final void oI(MicrosoftSDKManage this$0, Object obj, SpeechRecognitionEventArgs speechRecognitionResultEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(speechRecognitionResultEventArgs, "speechRecognitionResultEventArgs");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + "  canceled:  ---> Reason=  " + speechRecognitionResultEventArgs.getResult().getReason());
    }

    public static final void oOoIIO0(MicrosoftSDKManage this$0, Object obj, SpeechRecognitionEventArgs speechRecognitionResultEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(speechRecognitionResultEventArgs, "speechRecognitionResultEventArgs");
        SpeechRecognitionResult result = speechRecognitionResultEventArgs.getResult();
        String text = result.getText();
        String language = AutoDetectSourceLanguageResult.fromResult(result).getLanguage();
        this$0.f24272Oxx0xo.add(text);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Intermediate result received:  ---> " + TextUtils.join(" ", this$0.f24272Oxx0xo));
        I0Io i0Io = this$0.f24273OxxIIOOXO;
        if (i0Io != null) {
            i0Io.onIdentifyResults(1, TextUtils.join("*", this$0.f24281oI0IIXIo) + '*' + TextUtils.join(" ", this$0.f24272Oxx0xo));
        }
        I0Io i0Io2 = this$0.f24273OxxIIOOXO;
        if (i0Io2 != null) {
            String str = TextUtils.join("*", this$0.f24281oI0IIXIo) + '*' + TextUtils.join(" ", this$0.f24272Oxx0xo);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(language);
            i0Io2.onIdentifyResultsDetectedLanguage(1, str, language);
        }
        ArrayList<String> arrayList = this$0.f24272Oxx0xo;
        arrayList.remove(arrayList.size() - 1);
    }

    public static /* synthetic */ void oo0xXOI0I(MicrosoftSDKManage microsoftSDKManage, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = microsoftSDKManage.f24298xxX;
        }
        microsoftSDKManage.xI(str, str2);
    }

    public static /* synthetic */ void oxIIX0o(MicrosoftSDKManage microsoftSDKManage, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        microsoftSDKManage.IoIOOxIIo(z);
    }

    public static final void x0OIX00oO(MicrosoftSDKManage this$0, SpeechRecognitionResult result) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
        String text = result.getText();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (ProductManager.xOOxIO(productManager, null, 1, null) && !this$0.f24270OxI) {
            DcsTtsPlayer.playAssetsFile$default(DcsTtsPlayer.INSTANCE, "voice_end_cycle_audio.mp3", true, null, 4, null);
        }
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this$0.f24282oIX0oI + " setOnTaskCompletedListener  result: ---> " + text);
        if (result.getReason() != ResultReason.RecognizedSpeech) {
            ResultReason reason = result.getReason();
            ResultReason resultReason = ResultReason.Canceled;
            if (reason != resultReason) {
                str = "";
            } else {
                str = CancellationDetails.fromResult(result).getErrorDetails();
            }
            oix0oi.oIX0oI(this$0.f24282oIX0oI + " setOnTaskCompletedListener error : ---> " + ("Recognition failed with " + result.getReason() + ". Did you enter your subscription?" + System.lineSeparator() + str));
            if (result.getReason() == resultReason) {
                I0Io i0Io = this$0.f24273OxxIIOOXO;
                if (i0Io != null) {
                    i0Io.onIdentifyResults(2, "");
                }
            } else {
                I0Io i0Io2 = this$0.f24273OxxIIOOXO;
                if (i0Io2 != null) {
                    i0Io2.onIdentifyResults(2, "");
                }
                if (ProductManager.xOOxIO(productManager, null, 1, null)) {
                    oo0xXOI0I(this$0, UtilsKt.oI0IIXIo(R.string.speech_recognition_error), null, 2, null);
                }
            }
        } else {
            I0Io i0Io3 = this$0.f24273OxxIIOOXO;
            if (i0Io3 != null) {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(text);
                i0Io3.onIdentifyResults(2, text);
            }
        }
        this$0.Xx000oIo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void xI0oxI00(MicrosoftSDKManage microsoftSDKManage, String str, boolean z, String str2, String str3, boolean z2, String str4, List list, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bc.Code;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str2 = "zh-CN-XiaomoNeural";
        }
        if ((i & 8) != 0) {
            str3 = bc.Code;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        if ((i & 32) != 0) {
            str4 = "";
        }
        if ((i & 64) != 0) {
            list = CollectionsKt__CollectionsKt.X00IoxXI(bc.Code, "en-US");
        }
        if ((i & 128) != 0) {
            z3 = true;
        }
        microsoftSDKManage.xx0X0(str, z, str2, str3, z2, str4, list, z3);
    }

    public static final Object xX0IIXIx0(Future task, oxoX listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(task, "$task");
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "$listener");
        listener.oIX0oI(task.get());
        return null;
    }

    public static final void xoxXI(MicrosoftSDKManage this$0, Object obj, SpeechSynthesisEventArgs e) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this$0.f24282oIX0oI + " Synthesis finished.");
        oix0oi.oIX0oI(this$0.f24282oIX0oI + " First byte latency: " + e.getResult().getProperties().getProperty(PropertyId.SpeechServiceResponse_SynthesisFirstByteLatencyMs) + " ms.");
        oix0oi.oIX0oI(this$0.f24282oIX0oI + " Finish latency: " + e.getResult().getProperties().getProperty(PropertyId.SpeechServiceResponse_SynthesisFinishLatencyMs) + " ms.");
        e.close();
    }

    public static final void xxOXOOoIX(MicrosoftSDKManage this$0, Object obj, ConnectionEventArgs connectionEventArgs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.f24282oIX0oI + " Recognizer connection disconnected.");
    }

    public final void I0(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f24277XIxXXX0x0 = str;
    }

    public final boolean I0X0x0oIo() {
        return this.f24280o00;
    }

    public final void I0oOoX() {
        f24258X00IoxXI = new MicrosoftSDKManage();
        this.f24285oOoXoXO = null;
        this.f24269Oo = null;
        this.f24273OxxIIOOXO = null;
        Xo0.f24349oIX0oI.oIX0oI().remove(DeviceKeyManager.class.getName());
        DeviceInfoChecker.f19983oIX0oI.OxxIIOOXO();
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        voiceManager.sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.fail));
        voiceManager.sendTranslationResultOutput(UtilsKt.oI0IIXIo(R.string.microsoft_sdk_unbind_tip));
    }

    public final void IIxOXoOo0(boolean z) {
        this.f24270OxI = z;
    }

    @OXOo.oOoXoXO
    public final List<String> IO() {
        return this.f24279XxX0x0xxx;
    }

    public final void IO0XoXxO() {
        SpeechSynthesizer speechSynthesizer;
        try {
            if (this.f24263IIX0o != null && !f24258X00IoxXI.f24284oOXoIIIo && (speechSynthesizer = this.f24263IIX0o) != null) {
                speechSynthesizer.StopSpeakingAsync();
            }
            if (this.f24287oo0xXOI0I != null) {
                synchronized (this.f24286oo) {
                    this.f24266IoOoX = true;
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
                AudioTrack audioTrack = this.f24287oo0xXOI0I;
                if (audioTrack != null) {
                    audioTrack.pause();
                }
                AudioTrack audioTrack2 = this.f24287oo0xXOI0I;
                if (audioTrack2 != null) {
                    audioTrack2.flush();
                }
            }
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(this.f24282oIX0oI + " stopSynthesizing Exception e = " + e);
        }
    }

    @OXOo.oOoXoXO
    public final ExecutorService Io() {
        return this.f24288ooOOo0oXI;
    }

    public final void IoIOOxIIo(boolean z) {
        this.f24294xXxxox0I = 0;
        if (this.f24269Oo == null) {
            o0();
        }
        this.f24281oI0IIXIo.clear();
        xXoOI00O();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " startContinuousRecognitionAsync");
        if (this.f24265IXxxXO == null) {
            IxIX0I(z);
        }
        SpeechRecognizer speechRecognizer = this.f24265IXxxXO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer);
        Future<Void> startContinuousRecognitionAsync = speechRecognizer.startContinuousRecognitionAsync();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(startContinuousRecognitionAsync);
        OX00O0xII(startContinuousRecognitionAsync, new oxoX() { // from class: com.sma.smartv3.util.o0
            @Override // com.sma.smartv3.util.MicrosoftSDKManage.oxoX
            public final void oIX0oI(Object obj) {
                MicrosoftSDKManage.o0oIxOo(MicrosoftSDKManage.this, (Void) obj);
            }
        });
    }

    public final void Ioxxx(@OXOo.OOXIXo Application mApp) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mApp, "mApp");
        if (this.f24280o00) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(mApp, new X0o0xo(), new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"), 2);
        } else {
            mApp.registerReceiver(new X0o0xo(), new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        }
        this.f24280o00 = true;
    }

    public final void IxIX0I(boolean z) {
        String str;
        boolean z2;
        EventHandlerImpl<ConnectionEventArgs> eventHandlerImpl;
        EventHandlerImpl<ConnectionEventArgs> eventHandlerImpl2;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f24282oIX0oI + "  isAutoEnd: " + this.f24276XI0IXoo + "  ");
        BleDeviceInfo mDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
        if (mDeviceInfo != null) {
            str = mDeviceInfo.getMPrototype();
        } else {
            str = null;
        }
        LogUtils.d(str);
        if (this.f24265IXxxXO == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        LogUtils.d(String.valueOf(z2));
        if (this.f24265IXxxXO == null) {
            oix0oi.oIX0oI(this.f24282oIX0oI + " build reco");
            oix0oi.oIX0oI(this.f24282oIX0oI + " languageList: " + this.f24279XxX0x0xxx + TokenParser.SP);
            List<String> list = this.f24279XxX0x0xxx;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.X00IoxXI(bc.Code, "ja-JP");
            }
            AutoDetectSourceLanguageConfig fromLanguages = AutoDetectSourceLanguageConfig.fromLanguages(list);
            oix0oi.oIX0oI(this.f24282oIX0oI + " languageList: " + this.f24279XxX0x0xxx + TokenParser.SP);
            if (z) {
                oix0oi.oIX0oI(this.f24282oIX0oI + " isMoreLanguage: " + z + TokenParser.SP);
                this.f24265IXxxXO = new SpeechRecognizer(this.f24285oOoXoXO, fromLanguages, this.f24269Oo);
            } else {
                this.f24265IXxxXO = new SpeechRecognizer(this.f24285oOoXoXO, this.f24277XIxXXX0x0, this.f24269Oo);
            }
            SpeechRecognizer speechRecognizer = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer);
            speechRecognizer.recognizing.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.oOXoIIIo
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.oOoIIO0(MicrosoftSDKManage.this, obj, (SpeechRecognitionEventArgs) obj2);
                }
            });
            SpeechRecognizer speechRecognizer2 = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer2);
            speechRecognizer2.recognized.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.Xx000oIo
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.IXO(MicrosoftSDKManage.this, obj, (SpeechRecognitionEventArgs) obj2);
                }
            });
            SpeechRecognizer speechRecognizer3 = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer3);
            speechRecognizer3.canceled.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.X00IoxXI
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.oI(MicrosoftSDKManage.this, obj, (SpeechRecognitionCanceledEventArgs) obj2);
                }
            });
            SpeechRecognizer speechRecognizer4 = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer4);
            speechRecognizer4.sessionStarted.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.IO
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.Ix00oIoI(MicrosoftSDKManage.this, obj, (SessionEventArgs) obj2);
                }
            });
            SpeechRecognizer speechRecognizer5 = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer5);
            speechRecognizer5.sessionStopped.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.xII
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.O0IxXx(MicrosoftSDKManage.this, obj, (SessionEventArgs) obj2);
                }
            });
        }
        Connection fromRecognizer = Connection.fromRecognizer(this.f24265IXxxXO);
        this.f24264IIXOooo = fromRecognizer;
        if (fromRecognizer != null && (eventHandlerImpl2 = fromRecognizer.connected) != null) {
            eventHandlerImpl2.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.x0o
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.IoXIXo(MicrosoftSDKManage.this, obj, (ConnectionEventArgs) obj2);
                }
            });
        }
        Connection connection = this.f24264IIXOooo;
        if (connection != null && (eventHandlerImpl = connection.disconnected) != null) {
            eventHandlerImpl.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.XOxIOxOx
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.xxOXOOoIX(MicrosoftSDKManage.this, obj, (ConnectionEventArgs) obj2);
                }
            });
        }
        Connection connection2 = this.f24264IIXOooo;
        if (connection2 != null) {
            connection2.openConnection(true);
        }
    }

    public final void O00XxXI(boolean z) {
        this.f24276XI0IXoo = z;
    }

    public final void O0X(@OXOo.OOXIXo I0Io callback, @OXOo.OOXIXo String name) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(callback, "callback");
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " setSpeechCallback name=" + name);
        this.f24273OxxIIOOXO = callback;
    }

    @OXOo.oOoXoXO
    public final AudioRecord OI0() {
        return this.f24268OOXIXo;
    }

    public final void OO0x0xX(@OXOo.oOoXoXO I0Io i0Io) {
        if (i0Io != null) {
            IIX0(this, i0Io, null, 2, null);
        }
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.MICROPHONE, "android.permission.MODIFY_AUDIO_SETTINGS");
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, UtilsKt.oI0IIXIo(R.string.microphone_explain_title), UtilsKt.oI0IIXIo(R.string.microphone_explain_content), new Oox.oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.MicrosoftSDKManage$recordPermission$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (it == PermissionStatus.GRANTED) {
                    MicrosoftSDKManage.this.xXoOI00O();
                    MicrosoftSDKManage.this.XIXIxO();
                }
            }
        });
    }

    public final void OOXIxO0() {
    }

    public final <T> void OX00O0xII(final Future<T> future, final oxoX<T> oxox) {
        ExecutorService executorService = this.f24288ooOOo0oXI;
        if (executorService != null) {
            executorService.submit(new Callable() { // from class: com.sma.smartv3.util.I0oOoX
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object xX0IIXIx02;
                    xX0IIXIx02 = MicrosoftSDKManage.xX0IIXIx0(future, oxox);
                    return xX0IIXIx02;
                }
            });
        }
    }

    public final void Ox0O(@OXOo.OOXIXo String mLanguage, boolean z, @OXOo.OOXIXo String ttsName, @OXOo.OOXIXo String ttsLanguage, boolean z2, @OXOo.OOXIXo String name) {
        boolean z3;
        kotlin.jvm.internal.IIX0o.x0xO0oo(mLanguage, "mLanguage");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsName, "ttsName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsLanguage, "ttsLanguage");
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f24282oIX0oI + "  startAudioStreamInput name=" + name + "  mLanguage: ---> " + mLanguage + " , phoneRecord = " + z + " , ttsName = " + ttsName + " , ttsLanguage = " + ttsLanguage);
        try {
            if (this.f24262II0xO0.length() == 0) {
                Xo0 xo0 = Xo0.f24349oIX0oI;
                DeviceKeyManager deviceKeyManager = (DeviceKeyManager) new Gson().fromJson(xo0.oIX0oI().getString(DeviceKeyManager.class.getName()), DeviceKeyManager.class);
                if (deviceKeyManager != null) {
                    xOoOIoI(deviceKeyManager.getFirst(), deviceKeyManager.getSecond());
                } else {
                    xo0.oIX0oI().remove(DeviceKeyManager.class.getName());
                    DeviceInfoChecker.f19983oIX0oI.OxxIIOOXO();
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    voiceManager.sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.fail));
                    voiceManager.sendTranslationResultOutput(UtilsKt.oI0IIXIo(R.string.microsoft_sdk_unbind_tip));
                    return;
                }
            }
            IO0XoXxO();
            DcsTtsPlayer.INSTANCE.stop();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24282oIX0oI);
            sb.append("  startAudioStreamInput  Language: ---> ");
            sb.append(this.f24277XIxXXX0x0);
            sb.append(" , reco = ");
            boolean z4 = false;
            if (this.f24265IXxxXO == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            sb.append(z3);
            oix0oi.oIX0oI(sb.toString());
            if (this.f24265IXxxXO != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24277XIxXXX0x0, mLanguage)) {
                this.f24265IXxxXO = null;
            }
            this.f24277XIxXXX0x0 = mLanguage;
            this.f24298xxX = ttsName;
            o0();
            this.f24274X0IIOO = z;
            this.f24276XI0IXoo = z2;
            this.f24281oI0IIXIo.clear();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f24282oIX0oI);
            sb2.append(" startAudioStreamInput  Language: ---> ");
            sb2.append(this.f24277XIxXXX0x0);
            sb2.append(" , reco = ");
            if (this.f24265IXxxXO == null) {
                z4 = true;
            }
            sb2.append(z4);
            oix0oi.oIX0oI(sb2.toString());
            SpeechConfig speechConfig = this.f24285oOoXoXO;
            if (speechConfig != null) {
                speechConfig.setSpeechRecognitionLanguage(this.f24277XIxXXX0x0);
            }
            StatManager.f20200oIX0oI.II0xO0(8);
            if (this.f24274X0IIOO) {
                XIo0oOXIx(this, null, 1, null);
            } else {
                XoX();
                XIXIxO();
            }
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(this.f24282oIX0oI + "  e = " + e + "  ");
        }
    }

    public final int X00IoxXI() {
        return this.f24294xXxxox0I;
    }

    public final void X0xxXX0() {
        SpeechRecognizer speechRecognizer = this.f24265IXxxXO;
        if (speechRecognizer != null) {
            speechRecognizer.stopContinuousRecognitionAsync();
        }
        SpeechRecognizer speechRecognizer2 = this.f24265IXxxXO;
        if (speechRecognizer2 != null) {
            speechRecognizer2.close();
        }
        this.f24265IXxxXO = null;
    }

    public final void XI0oooXX(@OXOo.oOoXoXO List<String> list) {
        this.f24279XxX0x0xxx = list;
    }

    public final void XIXIX(@OXOo.oOoXoXO AudioRecord audioRecord) {
        this.f24268OOXIXo = audioRecord;
    }

    public final void XIXIxO() {
        String str;
        boolean z;
        if (this.f24276XI0IXoo) {
            SpeechRecognizer speechRecognizer = new SpeechRecognizer(this.f24285oOoXoXO, this.f24277XIxXXX0x0, this.f24269Oo);
            this.f24265IXxxXO = speechRecognizer;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer);
            Future<SpeechRecognitionResult> recognizeOnceAsync = speechRecognizer.recognizeOnceAsync();
            I0Io i0Io = this.f24273OxxIIOOXO;
            if (i0Io != null) {
                i0Io.onStartTransmission();
            }
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(recognizeOnceAsync);
            OX00O0xII(recognizeOnceAsync, new oxoX() { // from class: com.sma.smartv3.util.oo0xXOI0I
                @Override // com.sma.smartv3.util.MicrosoftSDKManage.oxoX
                public final void oIX0oI(Object obj) {
                    MicrosoftSDKManage.x0OIX00oO(MicrosoftSDKManage.this, (SpeechRecognitionResult) obj);
                }
            });
            return;
        }
        if (this.f24269Oo == null) {
            o0();
        }
        BleDeviceInfo mDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
        if (mDeviceInfo != null) {
            str = mDeviceInfo.getMPrototype();
        } else {
            str = null;
        }
        LogUtils.d(str);
        if (this.f24265IXxxXO == null) {
            z = true;
        } else {
            z = false;
        }
        LogUtils.d(String.valueOf(z));
        if (ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null) || this.f24265IXxxXO == null) {
            SpeechRecognizer speechRecognizer2 = new SpeechRecognizer(this.f24285oOoXoXO, this.f24277XIxXXX0x0, this.f24269Oo);
            this.f24265IXxxXO = speechRecognizer2;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer2);
            speechRecognizer2.recognizing.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.XX
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.XXoOx0(MicrosoftSDKManage.this, obj, (SpeechRecognitionEventArgs) obj2);
                }
            });
            SpeechRecognizer speechRecognizer3 = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer3);
            speechRecognizer3.recognized.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.oxxXoxO
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.OoO(MicrosoftSDKManage.this, obj, (SpeechRecognitionEventArgs) obj2);
                }
            });
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " startContinuousRecognitionAsync");
        SpeechRecognizer speechRecognizer4 = this.f24265IXxxXO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer4);
        Future<Void> startContinuousRecognitionAsync = speechRecognizer4.startContinuousRecognitionAsync();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(startContinuousRecognitionAsync);
        OX00O0xII(startContinuousRecognitionAsync, new oxoX() { // from class: com.sma.smartv3.util.XoX
            @Override // com.sma.smartv3.util.MicrosoftSDKManage.oxoX
            public final void oIX0oI(Object obj) {
                MicrosoftSDKManage.OIOoIIOIx(MicrosoftSDKManage.this, (Void) obj);
            }
        });
    }

    @OXOo.OOXIXo
    public final String XOxIOxOx() {
        return this.f24298xxX;
    }

    public final void XX() {
        if (this.f24287oo0xXOI0I == null) {
            this.f24287oo0xXOI0I = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(ErrorCode.ERROR_TTS_INVALID_PARA).setChannelMask(12).build(), AudioTrack.getMinBufferSize(ErrorCode.ERROR_TTS_INVALID_PARA, 12, 2) * 2, 1, 0);
        }
    }

    public final boolean XX0() {
        return this.f24296xoXoI;
    }

    public final void XX0xXo(@OXOo.OOXIXo byte[] bytes) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bytes, "bytes");
        oIX0oI oix0oi = this.f24292x0xO0oo;
        if (oix0oi != null && oix0oi != null) {
            oix0oi.XO(bytes);
        }
    }

    public final void XoX() {
        this.f24291x0XOIxOo = new PipedInputStream();
        this.f24283oO = new PipedOutputStream();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + "  initStream ");
        oIX0oI oix0oi = this.f24292x0xO0oo;
        if (oix0oi != null) {
            PipedInputStream pipedInputStream = this.f24291x0XOIxOo;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(pipedInputStream);
            PipedOutputStream pipedOutputStream = this.f24283oO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(pipedOutputStream);
            oix0oi.X0o0xo(pipedInputStream, pipedOutputStream);
        }
    }

    public final void Xx000oIo() {
        SpeechRecognizer speechRecognizer = this.f24265IXxxXO;
        if (speechRecognizer != null) {
            speechRecognizer.close();
        }
        x0OxxIOxX();
        RecordingManager.Companion.getInstance().closeBluetooth();
        I0Io i0Io = this.f24273OxxIIOOXO;
        if (i0Io != null) {
            i0Io.onStopTransmission();
        }
        this.f24269Oo = null;
    }

    public final void o0() {
        if (this.f24292x0xO0oo == null) {
            this.f24292x0xO0oo = new oIX0oI();
        }
        if (this.f24269Oo == null) {
            this.f24269Oo = AudioConfig.fromStreamInput(this.f24292x0xO0oo);
        }
    }

    public final void o0xxxXXxX(@OXOo.OOXIXo String ttsName) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsName, "ttsName");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " setAudioTTSName ttsVoiceName = " + ttsName);
        this.f24298xxX = ttsName;
    }

    public final void oOXoIIIo() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + "  closeAudioInputStream ");
        oIX0oI oix0oi = this.f24292x0xO0oo;
        if (oix0oi != null) {
            oix0oi.X0o0xo(null, null);
        }
        oIX0oI oix0oi2 = this.f24292x0xO0oo;
        if (oix0oi2 != null) {
            oix0oi2.close();
        }
    }

    public final void oOo(@OXOo.oOoXoXO ExecutorService executorService) {
        this.f24288ooOOo0oXI = executorService;
    }

    public final void oX() {
        EventHandlerImpl<SpeechSynthesisWordBoundaryEventArgs> eventHandlerImpl;
        EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl2;
        EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl3;
        EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl4;
        EventHandlerImpl<SpeechSynthesisEventArgs> eventHandlerImpl5;
        EventHandlerImpl<ConnectionEventArgs> eventHandlerImpl6;
        EventHandlerImpl<ConnectionEventArgs> eventHandlerImpl7;
        if (this.f24263IIX0o != null) {
            SpeechConfig speechConfig = this.f24285oOoXoXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechConfig);
            speechConfig.close();
            Connection connection = this.f24289ooXIXxIX;
            if (connection != null) {
                connection.close();
            }
            SpeechSynthesizer speechSynthesizer = this.f24263IIX0o;
            if (speechSynthesizer != null) {
                speechSynthesizer.close();
            }
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " Initializing synthesizer...");
        if (this.f24285oOoXoXO == null) {
            this.f24285oOoXoXO = SpeechConfig.fromSubscription(this.f24262II0xO0, this.f24290oxoX);
        }
        if (this.f24293xI == null) {
            this.f24293xI = new XO();
        }
        XX();
        SpeechConfig speechConfig2 = this.f24285oOoXoXO;
        if (speechConfig2 != null) {
            speechConfig2.setSpeechSynthesisOutputFormat(SpeechSynthesisOutputFormat.Raw24Khz16BitMonoPcm);
        }
        SpeechConfig speechConfig3 = this.f24285oOoXoXO;
        if (speechConfig3 != null) {
            speechConfig3.setProperty(PropertyId.SpeechServiceConnection_LanguageIdMode, "Continuous");
        }
        SpeechSynthesizer speechSynthesizer2 = new SpeechSynthesizer(this.f24285oOoXoXO, (AudioConfig) null);
        this.f24263IIX0o = speechSynthesizer2;
        Connection fromSpeechSynthesizer = Connection.fromSpeechSynthesizer(speechSynthesizer2);
        this.f24289ooXIXxIX = fromSpeechSynthesizer;
        if (fromSpeechSynthesizer != null && (eventHandlerImpl7 = fromSpeechSynthesizer.connected) != null) {
            eventHandlerImpl7.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.oxXx0IX
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.Xo0(MicrosoftSDKManage.this, obj, (ConnectionEventArgs) obj2);
                }
            });
        }
        Connection connection2 = this.f24289ooXIXxIX;
        if (connection2 != null && (eventHandlerImpl6 = connection2.disconnected) != null) {
            eventHandlerImpl6.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.xo0x
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.XoI0Ixx0(MicrosoftSDKManage.this, obj, (ConnectionEventArgs) obj2);
                }
            });
        }
        SpeechSynthesizer speechSynthesizer3 = this.f24263IIX0o;
        if (speechSynthesizer3 != null && (eventHandlerImpl5 = speechSynthesizer3.SynthesisStarted) != null) {
            eventHandlerImpl5.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.xXOx
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.O0Xx(MicrosoftSDKManage.this, obj, (SpeechSynthesisEventArgs) obj2);
                }
            });
        }
        SpeechSynthesizer speechSynthesizer4 = this.f24263IIX0o;
        if (speechSynthesizer4 != null && (eventHandlerImpl4 = speechSynthesizer4.Synthesizing) != null) {
            eventHandlerImpl4.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.XX0
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.I0oOIX(obj, (SpeechSynthesisEventArgs) obj2);
                }
            });
        }
        SpeechSynthesizer speechSynthesizer5 = this.f24263IIX0o;
        if (speechSynthesizer5 != null && (eventHandlerImpl3 = speechSynthesizer5.SynthesisCompleted) != null) {
            eventHandlerImpl3.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.I0X0x0oIo
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.xoxXI(MicrosoftSDKManage.this, obj, (SpeechSynthesisEventArgs) obj2);
                }
            });
        }
        SpeechSynthesizer speechSynthesizer6 = this.f24263IIX0o;
        if (speechSynthesizer6 != null && (eventHandlerImpl2 = speechSynthesizer6.SynthesisCanceled) != null) {
            eventHandlerImpl2.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.oX
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.OO(MicrosoftSDKManage.this, obj, (SpeechSynthesisEventArgs) obj2);
                }
            });
        }
        SpeechSynthesizer speechSynthesizer7 = this.f24263IIX0o;
        if (speechSynthesizer7 != null && (eventHandlerImpl = speechSynthesizer7.WordBoundary) != null) {
            eventHandlerImpl.addEventListener(new EventHandler() { // from class: com.sma.smartv3.util.IoOoX
                @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
                public final void onEvent(Object obj, Object obj2) {
                    MicrosoftSDKManage.IoOoo(MicrosoftSDKManage.this, obj, (SpeechSynthesisWordBoundaryEventArgs) obj2);
                }
            });
        }
    }

    public final void oXIO0o0XI(boolean z) {
        this.f24280o00 = z;
    }

    public final void oXxOI0oIx(@OXOo.OOXIXo String text, @OXOo.OOXIXo String translationLanguage, @OXOo.oOoXoXO final Oox.oOoXoXO<? super String, oXIO0o0XI> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        kotlin.jvm.internal.IIX0o.x0xO0oo(translationLanguage, "translationLanguage");
        StatManager.f20200oIX0oI.II0xO0(9);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> translatorTextBody = RequestBodyKt.getTranslatorTextBody(text, translationLanguage);
        final xxxI.II0xO0<AITranslatorText> iI0xO0 = new xxxI.II0xO0<AITranslatorText>() { // from class: com.sma.smartv3.util.MicrosoftSDKManage$toTranslatorText$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + "  toTranslatorText  error = " + error);
                Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AITranslatorText aITranslatorText) {
                if (aITranslatorText != null && aITranslatorText.getText() != null) {
                    Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(aITranslatorText.getText());
                        return;
                    }
                    return;
                }
                Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), ToTranslatorText.URL);
        netWorkUtils.printParam(convertBaseUrl + ToTranslatorText.URL, kotlin.collections.o0.xoIxX(translatorTextBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + ToTranslatorText.URL;
        final xxxI.II0xO0<Response<AITranslatorText>> iI0xO02 = new xxxI.II0xO0<Response<AITranslatorText>>() { // from class: com.sma.smartv3.util.MicrosoftSDKManage$toTranslatorText$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AITranslatorText> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) translatorTextBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AITranslatorText.class), new ParsedRequestListener<Response<AITranslatorText>>() { // from class: com.sma.smartv3.util.MicrosoftSDKManage$toTranslatorText$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AITranslatorText> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void oo(@OXOo.OOXIXo String text, @OXOo.OOXIXo String ttsName, @OXOo.OOXIXo LeftAndRightPlayControl leftOrRight, int i) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsName, "ttsName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(leftOrRight, "leftOrRight");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f24282oIX0oI + " audioSpeech ttsVoiceName = " + ttsName);
        this.f24298xxX = ttsName;
        if (this.f24289ooXIXxIX == null) {
            oix0oi.II0xO0(this.f24282oIX0oI + " Please initialize the speech synthesizer first.");
            return;
        }
        if (!this.f24296xoXoI) {
            xoIxX();
        }
        DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
        if (dcsTtsPlayer.getMTtsFile().exists()) {
            dcsTtsPlayer.getMTtsFile().delete();
        }
        try {
            this.f24289ooXIXxIX = Connection.fromSpeechSynthesizer(this.f24263IIX0o);
            XO xo2 = new XO();
            this.f24293xI = xo2;
            xo2.II0xO0(ttsName);
            XO xo3 = this.f24293xI;
            if (xo3 != null) {
                xo3.X0o0xo(leftOrRight);
            }
            XO xo4 = this.f24293xI;
            if (xo4 != null) {
                xo4.oxoX(text);
            }
            XO xo5 = this.f24293xI;
            if (xo5 != null) {
                xo5.oIX0oI(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24282oIX0oI);
            sb.append(" audioSpeech text = ");
            sb.append(text);
            sb.append(TokenParser.SP);
            if (this.f24293xI == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            oix0oi.oIX0oI(sb.toString());
            ExecutorService executorService = this.f24288ooOOo0oXI;
            if (executorService != null) {
                executorService.execute(this.f24293xI);
            }
        } catch (Exception unused) {
            IO0XoXxO();
        }
    }

    public final void ooOx(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f24298xxX = str;
    }

    public final byte[] ooXIXxIX(String str, byte[] bArr) {
        Cipher cipher = Cipher.getInstance(this.f24271Oxx0IOOO);
        cipher.init(2, new SecretKeySpec(bArr, this.f24261II0XooXoX));
        byte[] doFinal = cipher.doFinal(Base64.decode(str, 0));
        kotlin.jvm.internal.IIX0o.oO(doFinal, "doFinal(...)");
        return doFinal;
    }

    public final void ox(int i) {
        this.f24294xXxxox0I = i;
    }

    public final boolean oxXx0IX() {
        return this.f24276XI0IXoo;
    }

    public final void oxxXoxO() {
        try {
            boolean z = true;
            if (this.f24285oOoXoXO == null) {
                this.f24285oOoXoXO = SpeechConfig.fromSubscription(this.f24262II0xO0, this.f24290oxoX);
                if (this.f24288ooOOo0oXI == null) {
                    this.f24288ooOOo0oXI = Executors.newSingleThreadExecutor();
                }
                o0();
                oX();
                xoIxX();
                this.f24295xoIox = AudioStreamFormat.getWaveFormatPCM(this.f24297xxIXOIIO, (short) 16, (short) 1);
            }
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24282oIX0oI);
            sb.append(" init sdk speechConfig = ");
            if (this.f24285oOoXoXO == null) {
                z = false;
            }
            sb.append(z);
            sb.append(TokenParser.SP);
            oix0oi.oIX0oI(sb.toString());
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " init sdk speechConfig = " + e.getMessage());
        }
    }

    public final void x0() {
        if (this.f24265IXxxXO != null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f24282oIX0oI + " stopAudioStreamInput stopped");
            SpeechRecognizer speechRecognizer = this.f24265IXxxXO;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(speechRecognizer);
            Future<Void> stopContinuousRecognitionAsync = speechRecognizer.stopContinuousRecognitionAsync();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(stopContinuousRecognitionAsync);
            OX00O0xII(stopContinuousRecognitionAsync, new oxoX() { // from class: com.sma.smartv3.util.OI0
                @Override // com.sma.smartv3.util.MicrosoftSDKManage.oxoX
                public final void oIX0oI(Object obj) {
                    MicrosoftSDKManage.X0xII0I(MicrosoftSDKManage.this, (Void) obj);
                }
            });
        }
    }

    public final void x0OxxIOxX() {
        boolean z;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24282oIX0oI);
        sb.append(" stopAudio recorder.isNull = ");
        if (this.f24268OOXIXo == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        oix0oi.oIX0oI(sb.toString());
        try {
            if (this.f24268OOXIXo != null) {
                RecordingManager.Companion.getInstance().setRecording(false);
                AudioRecord audioRecord = this.f24268OOXIXo;
                if (audioRecord != null) {
                    audioRecord.stop();
                }
                AudioRecord audioRecord2 = this.f24268OOXIXo;
                if (audioRecord2 != null) {
                    audioRecord2.release();
                }
                this.f24268OOXIXo = null;
            }
        } catch (Exception unused) {
        }
    }

    @OXOo.OOXIXo
    public final String x0o() {
        return this.f24277XIxXXX0x0;
    }

    public final void x0xO() {
        Connection connection = this.f24264IIXOooo;
        if (connection == null) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(this.f24282oIX0oI + " Please initialize SpeechRecognizer.");
            return;
        }
        if (connection != null) {
            connection.openConnection(true);
        }
    }

    public final void xI(@OXOo.OOXIXo String text, @OXOo.OOXIXo String ttsName) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsName, "ttsName");
        if (this.f24262II0xO0.length() == 0 || this.f24285oOoXoXO == null) {
            Xo0.f24349oIX0oI.oIX0oI().remove(DeviceKeyManager.class.getName());
            ToastUtils.showLong(R.string.microsoft_sdk_unbind_tip);
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            voiceManager.sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.fail));
            voiceManager.sendTranslationResultOutput(UtilsKt.oI0IIXIo(R.string.microsoft_sdk_unbind_tip));
            return;
        }
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f24282oIX0oI + " audioSpeech ttsVoiceName = " + ttsName);
        this.f24298xxX = ttsName;
        DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
        dcsTtsPlayer.stop();
        if (this.f24289ooXIXxIX == null) {
            oix0oi.II0xO0(this.f24282oIX0oI + " Please initialize the speech synthesizer first.");
            return;
        }
        if (!this.f24296xoXoI) {
            xoIxX();
        }
        if (dcsTtsPlayer.getMTtsFile().exists()) {
            dcsTtsPlayer.getMTtsFile().delete();
        }
        try {
            this.f24289ooXIXxIX = Connection.fromSpeechSynthesizer(this.f24263IIX0o);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24282oIX0oI);
            sb.append(" audioSpeech text = ");
            sb.append(text);
            sb.append(TokenParser.SP);
            if (this.f24293xI == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            oix0oi.oIX0oI(sb.toString());
            XO xo2 = this.f24293xI;
            if (xo2 != null) {
                xo2.II0xO0(ttsName);
            }
            XO xo3 = this.f24293xI;
            if (xo3 != null) {
                xo3.X0o0xo(LeftAndRightPlayControl.LEFT_AND_RIGHT);
            }
            XO xo4 = this.f24293xI;
            if (xo4 != null) {
                xo4.oxoX(text);
            }
            ExecutorService executorService = this.f24288ooOOo0oXI;
            if (executorService != null) {
                executorService.execute(this.f24293xI);
            }
        } catch (Exception unused) {
            IO0XoXxO();
        }
    }

    @OXOo.OOXIXo
    public final Handler xII() {
        return this.f24267O0xOxO;
    }

    public final void xOOOX(boolean z) {
        this.f24296xoXoI = z;
    }

    public final void xOoOIoI(@OXOo.OOXIXo String first, @OXOo.OOXIXo String second) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(first, "first");
        kotlin.jvm.internal.IIX0o.x0xO0oo(second, "second");
        PrivateKey generatePrivate = KeyFactory.getInstance(this.f24275X0o0xo).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(this.f24260I0Io, 0)));
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(generatePrivate);
        byte[] decode = Base64.decode(xxIO(second, generatePrivate), 0);
        kotlin.jvm.internal.IIX0o.oO(decode, "decode(...)");
        this.f24262II0xO0 = new String(ooXIXxIX(first, decode), kotlin.text.oxoX.f29581II0xO0);
        VoiceManager.INSTANCE.initMicrosoftSDKManage();
    }

    public final boolean xXOx() {
        return this.f24274X0IIOO;
    }

    @SuppressLint({"MissingPermission"})
    public final void xXoOI00O() {
        ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null);
        RecordingManager.Companion companion = RecordingManager.Companion;
        companion.getInstance().setRecording(true);
        this.f24268OOXIXo = new AudioRecord(0, this.f24297xxIXOIIO, 16, 2, AudioRecord.getMinBufferSize(this.f24297xxIXOIIO, 16, 2));
        companion.getInstance().setStartBluetooth();
        AudioRecord audioRecord = this.f24268OOXIXo;
        if (audioRecord != null) {
            audioRecord.startRecording();
        }
    }

    public final boolean xo0x() {
        return this.f24270OxI;
    }

    public final void xoIxX() {
        Connection connection = this.f24289ooXIXxIX;
        if (connection == null) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(this.f24282oIX0oI + " Please initialize the speech synthesizer first.");
            return;
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(connection);
        connection.openConnection(true);
    }

    public final void xoO0xx0(boolean z) {
        this.f24274X0IIOO = z;
    }

    public final void xx0X0(@OXOo.OOXIXo String mLanguage, boolean z, @OXOo.OOXIXo String ttsName, @OXOo.OOXIXo String ttsLanguage, boolean z2, @OXOo.OOXIXo String name, @OXOo.OOXIXo List<String> languages, boolean z3) {
        boolean z4;
        SpeechConfig speechConfig;
        kotlin.jvm.internal.IIX0o.x0xO0oo(mLanguage, "mLanguage");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsName, "ttsName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ttsLanguage, "ttsLanguage");
        kotlin.jvm.internal.IIX0o.x0xO0oo(name, "name");
        kotlin.jvm.internal.IIX0o.x0xO0oo(languages, "languages");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f24282oIX0oI + "  startAudioStreamInput name=" + name + "  mLanguage: ---> " + mLanguage + " , phoneRecord = " + z + " , ttsName = " + ttsName + " , ttsLanguage = " + ttsLanguage);
        try {
            if (this.f24262II0xO0.length() == 0) {
                Xo0 xo0 = Xo0.f24349oIX0oI;
                DeviceKeyManager deviceKeyManager = (DeviceKeyManager) new Gson().fromJson(xo0.oIX0oI().getString(DeviceKeyManager.class.getName()), DeviceKeyManager.class);
                if (deviceKeyManager != null) {
                    xOoOIoI(deviceKeyManager.getFirst(), deviceKeyManager.getSecond());
                } else {
                    xo0.oIX0oI().remove(DeviceKeyManager.class.getName());
                    DeviceInfoChecker.f19983oIX0oI.OxxIIOOXO();
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    voiceManager.sendTranslationResultInput(UtilsKt.oI0IIXIo(R.string.fail));
                    voiceManager.sendTranslationResultOutput(UtilsKt.oI0IIXIo(R.string.microsoft_sdk_unbind_tip));
                    return;
                }
            }
            IO0XoXxO();
            DcsTtsPlayer.INSTANCE.stop();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f24282oIX0oI);
            sb.append("  startAudioStreamInput  Language: ---> ");
            sb.append(this.f24277XIxXXX0x0);
            sb.append(" , reco = ");
            boolean z5 = false;
            if (this.f24265IXxxXO == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            sb.append(z4);
            oix0oi.oIX0oI(sb.toString());
            this.f24265IXxxXO = null;
            this.f24279XxX0x0xxx = languages;
            this.f24277XIxXXX0x0 = mLanguage;
            this.f24298xxX = ttsName;
            o0();
            this.f24274X0IIOO = z;
            this.f24276XI0IXoo = z2;
            FileUtils.delete(VoiceManager.INSTANCE.getMPcmFile());
            this.f24281oI0IIXIo.clear();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f24282oIX0oI);
            sb2.append(" startAudioStreamInput  Language: ---> ");
            sb2.append(this.f24277XIxXXX0x0);
            sb2.append(" , reco = ");
            if (this.f24265IXxxXO == null) {
                z5 = true;
            }
            sb2.append(z5);
            oix0oi.oIX0oI(sb2.toString());
            if (!z3 && (speechConfig = this.f24285oOoXoXO) != null) {
                speechConfig.setSpeechRecognitionLanguage(this.f24277XIxXXX0x0);
            }
            oix0oi.oIX0oI(this.f24282oIX0oI + " speechRecognitionLanguage");
            IxIX0I(z3);
            StatManager.f20200oIX0oI.II0xO0(8);
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0(this.f24282oIX0oI + "  e = " + e + "  ");
        }
    }

    public final byte[] xxIO(String str, PrivateKey privateKey) {
        Cipher cipher = Cipher.getInstance(this.f24278XO);
        cipher.init(2, privateKey);
        byte[] doFinal = cipher.doFinal(Base64.decode(str, 0));
        kotlin.jvm.internal.IIX0o.oO(doFinal, "doFinal(...)");
        return doFinal;
    }
}
