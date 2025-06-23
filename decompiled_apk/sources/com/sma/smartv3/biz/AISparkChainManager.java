package com.sma.smartv3.biz;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.media2.session.RemoteResult;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.AuthenticationTokenClaims;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.iflytek.sparkchain.core.LLM;
import com.iflytek.sparkchain.core.LLMCallbacks;
import com.iflytek.sparkchain.core.LLMConfig;
import com.iflytek.sparkchain.core.LLMError;
import com.iflytek.sparkchain.core.LLMEvent;
import com.iflytek.sparkchain.core.LLMFactory;
import com.iflytek.sparkchain.core.LLMResult;
import com.iflytek.sparkchain.core.Memory;
import com.iflytek.sparkchain.core.SparkChain;
import com.iflytek.sparkchain.core.SparkChainConfig;
import com.iflytek.sparkchain.core.asr.ASR;
import com.iflytek.sparkchain.core.asr.AsrCallbacks;
import com.iflytek.sparkchain.core.asr.AudioAttributes;
import com.iflytek.sparkchain.core.its.ITS;
import com.iflytek.sparkchain.core.its.ITSCallbacks;
import com.iflytek.sparkchain.core.its.TransType;
import com.iflytek.sparkchain.core.rtasr.RTASR;
import com.iflytek.sparkchain.core.rtasr.RTASRCallbacks;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AITranslation;
import com.sma.smartv3.model.DeviceConfigInfo;
import com.sma.smartv3.model.MacConfig;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.Languages;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.Regex;

@XX({"SMAP\nAISparkChainManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AISparkChainManager.kt\ncom/sma/smartv3/biz/AISparkChainManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,843:1\n1#2:844\n*E\n"})
/* loaded from: classes12.dex */
public final class AISparkChainManager {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static xxxI.II0xO0<AIAnswer> f19851II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f19852II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static xxxI.II0xO0<AITranslation> f19854IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static int f19856O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f19858Oo = 0;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static RTASR f19862OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static LLM f19864X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static LLM f19867XO;

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static xxxI.II0xO0<AITranslation> f19869o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static boolean f19870oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public static boolean f19872oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static boolean f19879x0xO0oo;

    /* renamed from: xI, reason: collision with root package name */
    public static boolean f19880xI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static boolean f19882xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static ASR f19883xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static xxxI.II0xO0<Bitmap> f19884xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public static boolean f19885xxX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AISparkChainManager f19871oIX0oI = new AISparkChainManager();

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19850I0Io = "AISparkChainManager";

    /* renamed from: oxoX, reason: collision with root package name */
    public static boolean f19877oxoX = true;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String f19860Oxx0IOOO = "";

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19857OOXIXo = "0c997b55309fdb251dcb1b8cc6c87959";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19873oOoXoXO = "0b99355f";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19875ooOOo0oXI = "9221c3ac55d4516cff992a06d82c21d6";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19878x0XOIxOo = "ZTRhY2U2NzZhN2UyNWNmNGRlM2NmNjI3";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f19855IXxxXO = -101;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f19861Oxx0xo = RemoteResult.RESULT_ERROR_SESSION_AUTHENTICATION_EXPIRED;

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static StringBuffer f19859OxI = new StringBuffer();

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static boolean f19863X0IIOO = true;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static LLMCallbacks f19865XI0IXoo = new II0xO0();

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f19866XIxXXX0x0 = 3;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static boolean f19868XxX0x0xxx = true;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String f19881xXxxox0I = "";

    /* renamed from: IIX0o, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String f19853IIX0o = "";

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String f19876ooXIXxIX = "";

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Regex f19874oo0xXOI0I = new Regex("[,.?，。！？]");

    /* loaded from: classes12.dex */
    public static final class I0Io implements AsrCallbacks {
        @Override // com.iflytek.sparkchain.core.asr.AsrCallbacks
        public void onBeginOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.asr.AsrCallbacks
        public void onEndOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.asr.AsrCallbacks
        public void onError(@OXOo.OOXIXo ASR.ASRError error, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(error, "error");
            LogUtils.d(AISparkChainManager.f19850I0Io + " realTimeSendASRInit TTS.TTSError code =" + error.getCode() + ",  errMsg =  " + error.getErrMsg() + "  ");
            RecordingManager.Companion.getInstance().closeBluetooth();
            xxxI.II0xO0<AITranslation> oO2 = AISparkChainManager.f19871oIX0oI.oO();
            if (oO2 != null) {
                String errMsg = error.getErrMsg();
                IIX0o.oO(errMsg, "getErrMsg(...)");
                oO2.handleError(errMsg);
            }
        }

        @Override // com.iflytek.sparkchain.core.asr.AsrCallbacks
        public void onResult(@OXOo.OOXIXo ASR.ASRResult result, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(result, "result");
            LogUtils.d(AISparkChainManager.f19850I0Io + " realTimeSendASRInit result.st = " + result.getStatus() + " bestMatchText = " + result.getBestMatchText());
            if (result.getStatus() == 2) {
                AITranslation aITranslation = new AITranslation(null, null, 0, 7, null);
                String bestMatchText = result.getBestMatchText();
                IIX0o.oO(bestMatchText, "getBestMatchText(...)");
                aITranslation.setText(bestMatchText);
                aITranslation.setStatus(result.getStatus());
                LogUtils.d(AISparkChainManager.f19850I0Io + " realTimeSendASRInit  bestMatchText = " + result.getBestMatchText());
                xxxI.II0xO0<AITranslation> oO2 = AISparkChainManager.f19871oIX0oI.oO();
                if (oO2 != null) {
                    oO2.handleResponse(aITranslation);
                }
                RecordingManager.Companion companion = RecordingManager.Companion;
                companion.getInstance().setRecording(false);
                companion.getInstance().closeBluetooth();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements LLMCallbacks {
        @Override // com.iflytek.sparkchain.core.LLMCallbacks
        public void onLLMError(@OXOo.OOXIXo LLMError error, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + " onLLMError event = " + error.getErrCode() + "  msg = " + error.getErrMsg());
            xxxI.II0xO0<AIAnswer> Oxx0IOOO2 = AISparkChainManager.f19871oIX0oI.Oxx0IOOO();
            if (Oxx0IOOO2 != null) {
                Oxx0IOOO2.handleError(String.valueOf(error.getErrCode()));
            }
            AISparkChainManager.f19877oxoX = true;
        }

        @Override // com.iflytek.sparkchain.core.LLMCallbacks
        public void onLLMEvent(@OXOo.OOXIXo LLMEvent event, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(event, "event");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + " onLLMEvent event = " + event.getEventID() + " msg = " + event.getEventMsg());
            xxxI.II0xO0<AIAnswer> Oxx0IOOO2 = AISparkChainManager.f19871oIX0oI.Oxx0IOOO();
            if (Oxx0IOOO2 != null) {
                String eventMsg = event.getEventMsg();
                IIX0o.oO(eventMsg, "getEventMsg(...)");
                Oxx0IOOO2.handleError(eventMsg);
            }
            AISparkChainManager.f19877oxoX = true;
        }

        @Override // com.iflytek.sparkchain.core.LLMCallbacks
        public void onLLMResult(@OXOo.OOXIXo LLMResult llmResult, @OXOo.oOoXoXO Object obj) {
            int i;
            IIX0o.x0xO0oo(llmResult, "llmResult");
            StringBuilder sb = new StringBuilder();
            sb.append(AISparkChainManager.f19850I0Io);
            sb.append(" onLLMResult usrContext = ");
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Int");
            sb.append(((Integer) obj).intValue());
            sb.append("  token = ");
            sb.append(AISparkChainManager.f19852II0xO0);
            sb.append("   content = ");
            sb.append(llmResult.getContent());
            LogUtils.d(sb.toString());
            int i2 = AISparkChainManager.f19852II0xO0;
            if ((obj instanceof Integer) && i2 == ((Number) obj).intValue()) {
                int status = llmResult.getStatus();
                String content = llmResult.getContent();
                IIX0o.ooOOo0oXI(content);
                if (content.length() > 0) {
                    AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
                    if (aISparkChainManager.O0xOxO().length() == 0) {
                        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞开始回答 , 第一个字进来");
                    }
                    aISparkChainManager.x0xO(aISparkChainManager.O0xOxO() + content);
                    aISparkChainManager.Oo().append(content);
                    xxxI.II0xO0<AIAnswer> Oxx0IOOO2 = aISparkChainManager.Oxx0IOOO();
                    if (Oxx0IOOO2 != null) {
                        AIFunctionType aIFunctionType = AIFunctionType.AI;
                        String O0xOxO2 = aISparkChainManager.O0xOxO();
                        if (status == 2) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        Oxx0IOOO2.handleResponse(new AIAnswer(aIFunctionType, O0xOxO2, i, null, null, 24, null));
                    }
                }
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI(AISparkChainManager.f19850I0Io + " onLLMResult  status = " + status + "  content = " + llmResult.getContent());
                AISparkChainManager aISparkChainManager2 = AISparkChainManager.f19871oIX0oI;
                if (aISparkChainManager2.ooXIXxIX()) {
                    if (ProductManager.f20544oIX0oI.XI0IXoo()) {
                        if (status == 2) {
                            DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, aISparkChainManager2.O0xOxO(), false, false, null, null, 30, null);
                        }
                    } else {
                        aISparkChainManager2.xI(status);
                    }
                }
                if (status == 2) {
                    x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "APP-->转语音  科大讯飞接受答案完毕, 转语音播放");
                    oix0oi.oIX0oI(AISparkChainManager.f19850I0Io + " completionTokens: " + llmResult.getCompletionTokens() + " promptTokens: " + llmResult.getPromptTokens() + " totalTokens: " + llmResult.getTotalTokens());
                    AISparkChainManager.f19877oxoX = true;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class X0o0xo implements RTASRCallbacks {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ AITranslation f19886oIX0oI;

        public X0o0xo(AITranslation aITranslation) {
            this.f19886oIX0oI = aITranslation;
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onBeginOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onEndOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onError(@OXOo.OOXIXo RTASR.RtAsrError error, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + "  sendRTASRDataIdentify error=" + error.getCode() + "  msg = " + error.getErrMsg() + TokenParser.SP);
            AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
            aISparkChainManager.IoOoo(false);
            xxxI.II0xO0<AITranslation> oI0IIXIo2 = aISparkChainManager.oI0IIXIo();
            if (oI0IIXIo2 != null) {
                String errMsg = error.getErrMsg();
                IIX0o.oO(errMsg, "getErrMsg(...)");
                oI0IIXIo2.handleError(errMsg);
            }
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onResult(@OXOo.OOXIXo RTASR.RtAsrResult result, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(result, "result");
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.oIX0oI(AISparkChainManager.f19850I0Io + "  sendRTASRDataIdentify  result.result=" + result.getStatus() + "   result.transResult.status = " + result.getTransResult().getStatus() + "  ");
            AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
            if (!aISparkChainManager.XO()) {
                aISparkChainManager.oxxXoxO(true);
                x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别开始回答文案");
            }
            oix0oi.oIX0oI(AISparkChainManager.f19850I0Io + "  sendRTASRDataIdentify result=" + result.getStatus() + TokenParser.SP);
            if (result.getStatus() == 2 && aISparkChainManager.xoXoI()) {
                x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别回调文案完成  " + result.getData());
                aISparkChainManager.IoOoo(false);
                AITranslation aITranslation = this.f19886oIX0oI;
                String data = result.getData();
                IIX0o.oO(data, "getData(...)");
                aITranslation.setText(data);
                xxxI.II0xO0<AITranslation> oI0IIXIo2 = aISparkChainManager.oI0IIXIo();
                if (oI0IIXIo2 != null) {
                    oI0IIXIo2.handleResponse(this.f19886oIX0oI);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class XO implements ITSCallbacks {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ xxxI.II0xO0<String> f19887oIX0oI;

        public XO(xxxI.II0xO0<String> iI0xO0) {
            this.f19887oIX0oI = iI0xO0;
        }

        @Override // com.iflytek.sparkchain.core.its.ITSCallbacks
        public void onError(@OXOo.OOXIXo ITS.ITSError error, @OXOo.OOXIXo Object usrTag) {
            IIX0o.x0xO0oo(error, "error");
            IIX0o.x0xO0oo(usrTag, "usrTag");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + "  translateITS error  code =" + error.getCode() + ",  errMsg =  " + error.getErrMsg() + TokenParser.SP);
            xxxI.II0xO0<String> iI0xO0 = this.f19887oIX0oI;
            String errMsg = error.getErrMsg();
            IIX0o.oO(errMsg, "getErrMsg(...)");
            iI0xO0.handleError(errMsg);
        }

        @Override // com.iflytek.sparkchain.core.its.ITSCallbacks
        public void onResult(@OXOo.OOXIXo ITS.ITSResult result, @OXOo.OOXIXo Object usrTag) {
            IIX0o.x0xO0oo(result, "result");
            IIX0o.x0xO0oo(usrTag, "usrTag");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + "  translateITS   result.status = " + result.getStatus() + "   result.transResult.dst= " + result.getTransResult().getDst());
            if (result.getStatus() == 3) {
                x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞翻译, 中转翻译完成");
                this.f19887oIX0oI.handleResponse(result.getTransResult().getDst());
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements LLMCallbacks {
        @Override // com.iflytek.sparkchain.core.LLMCallbacks
        public void onLLMError(@OXOo.OOXIXo LLMError error, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.II0xO0(AISparkChainManager.f19850I0Io + "  onLLMError  ");
            xxxI.II0xO0<AIAnswer> Oxx0IOOO2 = AISparkChainManager.f19871oIX0oI.Oxx0IOOO();
            if (Oxx0IOOO2 != null) {
                Oxx0IOOO2.handleError(String.valueOf(error.getErrCode()));
            }
            AISparkChainManager.f19877oxoX = false;
        }

        @Override // com.iflytek.sparkchain.core.LLMCallbacks
        public void onLLMEvent(@OXOo.OOXIXo LLMEvent event, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(event, "event");
            OI0.oIX0oI.f1507oIX0oI.II0xO0(AISparkChainManager.f19850I0Io + "  onLLMEvent  ");
            xxxI.II0xO0<AIAnswer> Oxx0IOOO2 = AISparkChainManager.f19871oIX0oI.Oxx0IOOO();
            if (Oxx0IOOO2 != null) {
                String eventMsg = event.getEventMsg();
                IIX0o.oO(eventMsg, "getEventMsg(...)");
                Oxx0IOOO2.handleError(eventMsg);
            }
            AISparkChainManager.f19877oxoX = false;
        }

        @Override // com.iflytek.sparkchain.core.LLMCallbacks
        public void onLLMResult(@OXOo.OOXIXo LLMResult result, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(result, "result");
            byte[] image = result.getImage();
            if (image != null) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(image, 0, image.length);
                xxxI.II0xO0<Bitmap> II0XooXoX2 = AISparkChainManager.f19871oIX0oI.II0XooXoX();
                if (II0XooXoX2 != null) {
                    II0XooXoX2.handleResponse(decodeByteArray);
                }
                AISparkChainManager.f19877oxoX = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX implements RTASRCallbacks {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ AITranslation f19888oIX0oI;

        public oxoX(AITranslation aITranslation) {
            this.f19888oIX0oI = aITranslation;
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onBeginOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onEndOfSpeech() {
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onError(@OXOo.OOXIXo RTASR.RtAsrError error, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + "  RTASRCallbacks error code =" + error.getCode() + " , msg = " + error.getErrMsg() + "  ");
            AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
            aISparkChainManager.IoOoo(false);
            xxxI.II0xO0<AITranslation> oI0IIXIo2 = aISparkChainManager.oI0IIXIo();
            if (oI0IIXIo2 != null) {
                String errMsg = error.getErrMsg();
                IIX0o.oO(errMsg, "getErrMsg(...)");
                oI0IIXIo2.handleError(errMsg);
            }
        }

        @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
        public void onResult(@OXOo.OOXIXo RTASR.RtAsrResult result, @OXOo.oOoXoXO Object obj) {
            IIX0o.x0xO0oo(result, "result");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + "  RTASRCallbacks result.result=" + result.getStatus() + "  result.data = " + result.getData() + "   result.transResult.status = " + result.getTransResult().getStatus() + "  ");
            AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
            if (!aISparkChainManager.XO()) {
                aISparkChainManager.oxxXoxO(true);
                x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别开始回答文案  进来流式回答");
            }
            if (result.getTransResult().getStatus() == 2 && aISparkChainManager.xoXoI()) {
                x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别并且翻译 完成回调 --> " + result.getTransResult().getSrc());
                aISparkChainManager.IoOoo(false);
                AITranslation aITranslation = this.f19888oIX0oI;
                String src = result.getTransResult().getSrc();
                IIX0o.oO(src, "getSrc(...)");
                aITranslation.setText(src);
                AITranslation aITranslation2 = this.f19888oIX0oI;
                String dst = result.getTransResult().getDst();
                IIX0o.oO(dst, "getDst(...)");
                aITranslation2.setDst(dst);
                xxxI.II0xO0<AITranslation> oI0IIXIo2 = aISparkChainManager.oI0IIXIo();
                if (oI0IIXIo2 != null) {
                    oI0IIXIo2.handleResponse(this.f19888oIX0oI);
                }
            }
        }
    }

    public static /* synthetic */ void IIxOXoOo0(AISparkChainManager aISparkChainManager, String str, String str2, String str3, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "cn";
        }
        if ((i & 4) != 0) {
            str3 = Languages.DEFAULT_LANGUAGE;
        }
        aISparkChainManager.OOXIxO0(str, str2, str3, iI0xO0);
    }

    public static /* synthetic */ void OI0(AISparkChainManager aISparkChainManager, String str, xxxI.II0xO0 iI0xO0, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        if ((i2 & 8) != 0) {
            z = f19863X0IIOO;
        }
        aISparkChainManager.XOxIOxOx(str, iI0xO0, i, z);
    }

    public static /* synthetic */ void X00IoxXI(AISparkChainManager aISparkChainManager, byte[] bArr, String str, String str2, boolean z, int i, xxxI.II0xO0 iI0xO0, int i2, Object obj) {
        boolean z2;
        if ((i2 & 8) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i2 & 32) != 0) {
            iI0xO0 = null;
        }
        aISparkChainManager.Xx000oIo(bArr, str, str2, z2, i, iI0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void X0o0xo(AISparkChainManager aISparkChainManager, String str, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            iI0xO0 = null;
        }
        aISparkChainManager.oxoX(str, iI0xO0);
    }

    public static /* synthetic */ void o0(AISparkChainManager aISparkChainManager, String str, String str2, String str3, xxxI.II0xO0 iI0xO0, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "cn";
        }
        if ((i & 4) != 0) {
            str3 = Languages.DEFAULT_LANGUAGE;
        }
        aISparkChainManager.Io(str, str2, str3, iI0xO0);
    }

    public static /* synthetic */ void oOXoIIIo(AISparkChainManager aISparkChainManager, xxxI.II0xO0 iI0xO0, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 900;
        }
        if ((i2 & 4) != 0) {
            str = "zh_cn";
        }
        if ((i2 & 8) != 0) {
            str2 = "mandarin";
        }
        aISparkChainManager.IoOoX(iI0xO0, i, str, str2);
    }

    public static /* synthetic */ void oo(AISparkChainManager aISparkChainManager, byte[] bArr, boolean z, int i, xxxI.II0xO0 iI0xO0, boolean z2, int i2, String str, String str2, int i3, Object obj) {
        boolean z3;
        xxxI.II0xO0 iI0xO02;
        boolean z4;
        int i4;
        String str3;
        String str4;
        if ((i3 & 2) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i3 & 8) != 0) {
            iI0xO02 = null;
        } else {
            iI0xO02 = iI0xO0;
        }
        if ((i3 & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i3 & 32) != 0) {
            i4 = 900;
        } else {
            i4 = i2;
        }
        if ((i3 & 64) != 0) {
            str3 = "zh_cn";
        } else {
            str3 = str;
        }
        if ((i3 & 128) != 0) {
            str4 = "mandarin";
        } else {
            str4 = str2;
        }
        aISparkChainManager.oo0xXOI0I(bArr, z3, i, iI0xO02, z4, i4, str3, str4);
    }

    public static /* synthetic */ void x0o(AISparkChainManager aISparkChainManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 900;
        }
        aISparkChainManager.xII(i);
    }

    public static /* synthetic */ void xxX(AISparkChainManager aISparkChainManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        aISparkChainManager.XIxXXX0x0(i);
    }

    public final void I0() {
        SparkChain.getInst().unInit();
    }

    public final void I0X0x0oIo(@OXOo.oOoXoXO xxxI.II0xO0<AITranslation> iI0xO0) {
        f19869o00 = iI0xO0;
    }

    public final void I0oOIX(@OXOo.oOoXoXO xxxI.II0xO0<AITranslation> iI0xO0) {
        f19854IIXOooo = iI0xO0;
    }

    public final void I0oOoX(boolean z) {
        f19880xI = z;
    }

    @OXOo.oOoXoXO
    public final xxxI.II0xO0<Bitmap> II0XooXoX() {
        return f19884xxIXOIIO;
    }

    public final boolean IIX0o() {
        return f19885xxX;
    }

    @OXOo.OOXIXo
    public final String IIXOooo() {
        return f19853IIX0o;
    }

    public final void IO(@OXOo.OOXIXo String lang, @OXOo.OOXIXo final String targetLang) {
        boolean z;
        IIX0o.x0xO0oo(lang, "lang");
        IIX0o.x0xO0oo(targetLang, "targetLang");
        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "发给科大讯飞语音 , 去识别");
        boolean z2 = false;
        f19870oI0IIXIo = false;
        f19882xoIox = true;
        f19862OxxIIOOXO = new RTASR(f19857OOXIXo);
        if (!IIX0o.Oxx0IOOO(lang, "cn") && !IIX0o.Oxx0IOOO(targetLang, "cn")) {
            z = true;
        } else {
            z = false;
        }
        f19885xxX = z;
        final AITranslation aITranslation = new AITranslation(null, null, 0, 7, null);
        DcsTtsPlayer.INSTANCE.initSegmentation();
        RTASR rtasr = f19862OxxIIOOXO;
        if (rtasr != null) {
            rtasr.registerCallbacks(new RTASRCallbacks() { // from class: com.sma.smartv3.biz.AISparkChainManager$realTimeSendRTASRInit$1
                @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
                public void onBeginOfSpeech() {
                }

                @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
                public void onEndOfSpeech() {
                }

                @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
                public void onError(@OXOo.OOXIXo RTASR.RtAsrError error, @OXOo.oOoXoXO Object obj) {
                    IIX0o.x0xO0oo(error, "error");
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(AISparkChainManager.f19850I0Io + "  sendRTASRDataIdentify error=" + error.getCode() + " , msg = " + error.getErrMsg());
                    AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
                    aISparkChainManager.IoOoo(false);
                    xxxI.II0xO0<AITranslation> oI0IIXIo2 = aISparkChainManager.oI0IIXIo();
                    if (oI0IIXIo2 != null) {
                        String errMsg = error.getErrMsg();
                        IIX0o.oO(errMsg, "getErrMsg(...)");
                        oI0IIXIo2.handleError(errMsg);
                    }
                }

                @Override // com.iflytek.sparkchain.core.rtasr.RTASRCallbacks
                public void onResult(@OXOo.OOXIXo RTASR.RtAsrResult result, @OXOo.oOoXoXO Object obj) {
                    String dst;
                    IIX0o.x0xO0oo(result, "result");
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    oix0oi.oIX0oI(AISparkChainManager.f19850I0Io + "  sendRTASRDataIdentify  result.result=" + result.getStatus() + "  , result.transResult.status = " + result.getTransResult().getStatus() + "  ");
                    oix0oi.oIX0oI(AISparkChainManager.f19850I0Io + "  sendRTASRDataIdentify  result.data=" + result.getData() + " ,  result.transResult.src = " + result.getTransResult().getSrc() + " ,  result.transResult.dst = " + result.getTransResult().getDst());
                    AISparkChainManager aISparkChainManager = AISparkChainManager.f19871oIX0oI;
                    if (!aISparkChainManager.XO()) {
                        aISparkChainManager.oxxXoxO(true);
                        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别开始回答文案");
                    }
                    if (aISparkChainManager.o00()) {
                        aISparkChainManager.xoIxX(false);
                        AITranslation aITranslation2 = AITranslation.this;
                        String data = result.getData();
                        IIX0o.oO(data, "getData(...)");
                        aITranslation2.setText(data);
                        if (!aISparkChainManager.IIX0o()) {
                            AITranslation aITranslation3 = AITranslation.this;
                            if (aISparkChainManager.xoXoI()) {
                                dst = "...";
                            } else {
                                dst = result.getTransResult().getDst();
                                IIX0o.oO(dst, "getDst(...)");
                            }
                            aITranslation3.setDst(dst);
                        }
                        AITranslation.this.setStatus(0);
                        xxxI.II0xO0<AITranslation> oI0IIXIo2 = aISparkChainManager.oI0IIXIo();
                        if (oI0IIXIo2 != null) {
                            oI0IIXIo2.handleResponse(AITranslation.this);
                        }
                    }
                    if (result.getStatus() == 1 || result.getTransResult().getStatus() == 1) {
                        AITranslation.this.setText(aISparkChainManager.OxxIIOOXO() + result.getData());
                        if (!aISparkChainManager.IIX0o()) {
                            AITranslation.this.setDst(aISparkChainManager.IIXOooo() + result.getTransResult().getDst());
                        }
                        AITranslation.this.setStatus(1);
                        xxxI.II0xO0<AITranslation> oI0IIXIo3 = aISparkChainManager.oI0IIXIo();
                        if (oI0IIXIo3 != null) {
                            oI0IIXIo3.handleResponse(AITranslation.this);
                        }
                    }
                    if (result.getStatus() == 2) {
                        aISparkChainManager.xoxXI(aISparkChainManager.OxxIIOOXO() + result.getData());
                    }
                    if (result.getTransResult().getStatus() == 2) {
                        aISparkChainManager.OO(aISparkChainManager.IIXOooo() + result.getTransResult().getDst());
                    }
                    if (result.getStatus() == 3 && aISparkChainManager.xoXoI()) {
                        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞去语音识别回调文案完成  " + result.getData());
                        aISparkChainManager.IoOoo(false);
                        if (aISparkChainManager.IIX0o()) {
                            AITranslation.this.setText(aISparkChainManager.OxxIIOOXO());
                            String IIXOooo2 = aISparkChainManager.IIXOooo();
                            String str = targetLang;
                            final AITranslation aITranslation4 = AITranslation.this;
                            aISparkChainManager.OOXIxO0(IIXOooo2, "cn", str, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.AISparkChainManager$realTimeSendRTASRInit$1$onResult$1
                                @Override // xxxI.II0xO0
                                public void handleError(@OXOo.OOXIXo String error) {
                                    IIX0o.x0xO0oo(error, "error");
                                    AITranslation.this.setDst(error);
                                    AITranslation.this.setStatus(3);
                                    xxxI.II0xO0<AITranslation> oI0IIXIo4 = AISparkChainManager.f19871oIX0oI.oI0IIXIo();
                                    if (oI0IIXIo4 != null) {
                                        oI0IIXIo4.handleResponse(AITranslation.this);
                                    }
                                }

                                @Override // xxxI.II0xO0
                                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                                public void handleResponse(@OXOo.oOoXoXO String str2) {
                                    AITranslation aITranslation5 = AITranslation.this;
                                    IIX0o.ooOOo0oXI(str2);
                                    aITranslation5.setDst(str2);
                                    AITranslation.this.setStatus(3);
                                    xxxI.II0xO0<AITranslation> oI0IIXIo4 = AISparkChainManager.f19871oIX0oI.oI0IIXIo();
                                    if (oI0IIXIo4 != null) {
                                        oI0IIXIo4.handleResponse(AITranslation.this);
                                    }
                                }
                            });
                            aISparkChainManager.OO0x0xX(false);
                            return;
                        }
                        AITranslation.this.setText(aISparkChainManager.OxxIIOOXO());
                        AITranslation.this.setDst(aISparkChainManager.IIXOooo());
                        AITranslation.this.setStatus(3);
                        xxxI.II0xO0<AITranslation> oI0IIXIo4 = aISparkChainManager.oI0IIXIo();
                        if (oI0IIXIo4 != null) {
                            oI0IIXIo4.handleResponse(AITranslation.this);
                        }
                    }
                }
            });
        }
        RTASR rtasr2 = f19862OxxIIOOXO;
        if (rtasr2 != null) {
            rtasr2.transType(PrerollVideoResponse.NORMAL);
        }
        RTASR rtasr3 = f19862OxxIIOOXO;
        if (rtasr3 != null) {
            rtasr3.lang(lang);
        }
        if (f19885xxX) {
            RTASR rtasr4 = f19862OxxIIOOXO;
            if (rtasr4 != null) {
                rtasr4.targetLang("cn");
            }
        } else {
            RTASR rtasr5 = f19862OxxIIOOXO;
            if (rtasr5 != null) {
                rtasr5.targetLang(targetLang);
            }
        }
        RTASR rtasr6 = f19862OxxIIOOXO;
        IIX0o.ooOOo0oXI(rtasr6);
        int start = rtasr6.start("xdx");
        XX0xXo(Integer.valueOf(start));
        if (start == 0) {
            z2 = true;
        }
        f19868XxX0x0xxx = z2;
    }

    public final int IXxxXO() {
        return f19856O0xOxO;
    }

    public final void Io(@OXOo.OOXIXo String pcmFilePath, @OXOo.OOXIXo String lang, @OXOo.OOXIXo String targetLang, @OXOo.OOXIXo xxxI.II0xO0<AITranslation> callback) {
        RTASR rtasr;
        IIX0o.x0xO0oo(pcmFilePath, "pcmFilePath");
        IIX0o.x0xO0oo(lang, "lang");
        IIX0o.x0xO0oo(targetLang, "targetLang");
        IIX0o.x0xO0oo(callback, "callback");
        if (o0xxxXXxX() != 0) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRData  sparkChainInit return ");
            return;
        }
        if (f19882xoIox) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRData  mRTASRIsRun = return ");
            return;
        }
        f19854IIXOooo = callback;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRData  pcmFilePath = " + pcmFilePath + "  lang = " + lang + "  targetLang = " + targetLang);
        f19882xoIox = true;
        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "发给科大讯飞去语音识别, 并且翻译");
        f19870oI0IIXIo = false;
        f19862OxxIIOOXO = new RTASR(f19857OOXIXo);
        AITranslation aITranslation = new AITranslation(null, null, 0, 7, null);
        DcsTtsPlayer.INSTANCE.initSegmentation();
        RTASR rtasr2 = f19862OxxIIOOXO;
        if (rtasr2 != null) {
            rtasr2.registerCallbacks(new oxoX(aITranslation));
        }
        RTASR rtasr3 = f19862OxxIIOOXO;
        if (rtasr3 != null) {
            rtasr3.transType(PrerollVideoResponse.NORMAL);
        }
        RTASR rtasr4 = f19862OxxIIOOXO;
        if (rtasr4 != null) {
            rtasr4.lang(lang);
        }
        RTASR rtasr5 = f19862OxxIIOOXO;
        if (rtasr5 != null) {
            rtasr5.targetLang(targetLang);
        }
        RTASR rtasr6 = f19862OxxIIOOXO;
        IIX0o.ooOOo0oXI(rtasr6);
        int start = rtasr6.start("xdx");
        XX0xXo(Integer.valueOf(start));
        if (start == 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(pcmFilePath);
                byte[] bArr = new byte[1280];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    if (-1 == read) {
                        break;
                    } else if (read > 0 && (rtasr = f19862OxxIIOOXO) != null) {
                        rtasr.write((byte[]) bArr.clone());
                    }
                }
                fileInputStream.close();
                RTASR rtasr7 = f19862OxxIIOOXO;
                if (rtasr7 != null) {
                    rtasr7.stop();
                }
            } catch (Exception e) {
                RTASR rtasr8 = f19862OxxIIOOXO;
                if (rtasr8 != null) {
                    rtasr8.stop();
                }
                e.printStackTrace();
            }
        }
    }

    public final void IoOoX(@OXOo.oOoXoXO xxxI.II0xO0<AITranslation> iI0xO0, int i, @OXOo.OOXIXo String language, @OXOo.OOXIXo String accent) {
        IIX0o.x0xO0oo(language, "language");
        IIX0o.x0xO0oo(accent, "accent");
        if (iI0xO0 != null) {
            f19869o00 = iI0xO0;
        }
        ASR asr = new ASR(language, AuthenticationTokenClaims.JSON_KEY_IAT, accent);
        f19883xoXoI = asr;
        asr.registerCallbacks(new I0Io());
        xII(i);
    }

    public final void IoOoo(boolean z) {
        f19882xoIox = z;
    }

    public final void Ioxxx(boolean z) {
        f19868XxX0x0xxx = z;
        if (z) {
            f19881xXxxox0I = "";
            f19853IIX0o = "";
        }
    }

    public final List<String> O00XxXI(String str) {
        return f19874oo0xXOI0I.split(str, 0);
    }

    public final void O0Xx(@OXOo.oOoXoXO RTASR rtasr) {
        f19862OxxIIOOXO = rtasr;
    }

    @OXOo.OOXIXo
    public final String O0xOxO() {
        return f19860Oxx0IOOO;
    }

    public final void OO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        f19853IIX0o = str;
    }

    public final void OO0x0xX(boolean z) {
        f19885xxX = z;
    }

    public final int OOXIXo() {
        return f19858Oo;
    }

    public final void OOXIxO0(@OXOo.OOXIXo String text, @OXOo.OOXIXo String lang, @OXOo.OOXIXo String targetLang, @OXOo.OOXIXo xxxI.II0xO0<String> callback) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(lang, "lang");
        IIX0o.x0xO0oo(targetLang, "targetLang");
        IIX0o.x0xO0oo(callback, "callback");
        if (o0xxxXXxX() != 0) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRDataIdentify  sparkChainInit return ");
            return;
        }
        ITS its = new ITS(lang, targetLang, TransType.ITRANS);
        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞翻译,  进入中转翻译");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + "  translateITS  text = " + text + "  lang = " + lang + "  targetLang = " + targetLang);
        its.registerCallbacks(new XO(callback));
        its.arun(text, "xdx");
        f19863X0IIOO = true;
    }

    @OXOo.OOXIXo
    public final StringBuffer Oo() {
        return f19859OxI;
    }

    public final int OxI() {
        return f19866XIxXXX0x0;
    }

    @OXOo.oOoXoXO
    public final xxxI.II0xO0<AIAnswer> Oxx0IOOO() {
        return f19851II0XooXoX;
    }

    @OXOo.oOoXoXO
    public final RTASR Oxx0xo() {
        return f19862OxxIIOOXO;
    }

    @OXOo.OOXIXo
    public final String OxxIIOOXO() {
        return f19881xXxxox0I;
    }

    @OXOo.OOXIXo
    public final String X0IIOO() {
        return f19876ooXIXxIX;
    }

    public final void XI0IXoo() {
        LLMConfig builder = LLMConfig.builder();
        builder.domain("tti");
        builder.url("tti:https://spark-api.cn-huabei-1.xf-yun.com/v2.1/tti");
        f19867XO = LLMFactory.imageGeneration(builder);
    }

    public final void XI0oooXX() {
        RTASR rtasr = f19862OxxIIOOXO;
        if (rtasr != null) {
            rtasr.stop();
        }
        LLM llm = f19864X0o0xo;
        if (llm != null) {
            llm.stop();
        }
        f19863X0IIOO = false;
    }

    public final void XIo0oOXIx(boolean z) {
        f19863X0IIOO = z;
    }

    public final void XIxXXX0x0(int i) {
        LLMConfig builder = LLMConfig.builder();
        builder.domain("generalv3.5");
        builder.url("ws(s)://spark-api.xf-yun.com/v3.5/chat");
        LLM llm = new LLM(builder, Memory.windowMemory(5));
        f19864X0o0xo = llm;
        llm.registerLLMCallbacks(f19865XI0IXoo);
    }

    public final boolean XO() {
        return f19870oI0IIXIo;
    }

    public final void XOxIOxOx(@OXOo.OOXIXo String inputText, @OXOo.oOoXoXO xxxI.II0xO0<AIAnswer> iI0xO0, int i, boolean z) {
        IIX0o.x0xO0oo(inputText, "inputText");
        if (o0xxxXXxX() != 0) {
            return;
        }
        f19856O0xOxO = 0;
        f19859OxI.setLength(0);
        XIxXXX0x0(i);
        LLM llm = f19864X0o0xo;
        IIX0o.ooOOo0oXI(llm);
        llm.stop();
        AIManager aIManager = AIManager.f19833oIX0oI;
        aIManager.o0(0);
        f19860Oxx0IOOO = "";
        f19852II0xO0++;
        String OxI2 = aIManager.OxI(inputText, i);
        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "发送问题给科大讯飞  " + OxI2);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        String str = f19850I0Io;
        sb.append(str);
        sb.append(" sendMsg inputText = ");
        sb.append(inputText);
        sb.append("  limitQuery = ");
        sb.append(OxI2);
        oix0oi.oIX0oI(sb.toString());
        LLM llm2 = f19864X0o0xo;
        IIX0o.ooOOo0oXI(llm2);
        int arun = llm2.arun(OxI2, Integer.valueOf(f19852II0xO0));
        if (arun != 0) {
            oix0oi.oIX0oI(str + " SparkChain sendMsg failed:" + arun + "  token = " + f19852II0xO0);
            return;
        }
        f19863X0IIOO = z;
        f19884xxIXOIIO = null;
        f19851II0XooXoX = iI0xO0;
        f19877oxoX = false;
    }

    public final void XX(@OXOo.OOXIXo String pcmFilePath, @OXOo.OOXIXo xxxI.II0xO0<AITranslation> callback) {
        RTASR rtasr;
        String str;
        IIX0o.x0xO0oo(pcmFilePath, "pcmFilePath");
        IIX0o.x0xO0oo(callback, "callback");
        if (o0xxxXXxX() != 0) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRDataIdentify  sparkChainInit return ");
            return;
        }
        if (f19882xoIox) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRDataIdentify  mRTASRIsRun = return");
            return;
        }
        f19854IIXOooo = callback;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sendRTASRDataIdentify  pcmFilePath = " + pcmFilePath);
        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "发给科大讯飞语音 , 去识别");
        f19870oI0IIXIo = false;
        f19882xoIox = true;
        f19862OxxIIOOXO = new RTASR(f19857OOXIXo);
        AITranslation aITranslation = new AITranslation(null, null, 0, 7, null);
        DcsTtsPlayer.INSTANCE.initSegmentation();
        RTASR rtasr2 = f19862OxxIIOOXO;
        if (rtasr2 != null) {
            rtasr2.registerCallbacks(new X0o0xo(aITranslation));
        }
        RTASR rtasr3 = f19862OxxIIOOXO;
        if (rtasr3 != null) {
            rtasr3.transType(PrerollVideoResponse.NORMAL);
        }
        RTASR rtasr4 = f19862OxxIIOOXO;
        if (rtasr4 != null) {
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            if (UtilsKt.X00IoxXI(app)) {
                str = "cn";
            } else {
                str = Languages.DEFAULT_LANGUAGE;
            }
            rtasr4.lang(str);
        }
        RTASR rtasr5 = f19862OxxIIOOXO;
        IIX0o.ooOOo0oXI(rtasr5);
        int start = rtasr5.start("xdx");
        XX0xXo(Integer.valueOf(start));
        if (start == 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(pcmFilePath);
                byte[] bArr = new byte[1280];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    if (-1 == read) {
                        break;
                    } else if (read > 0 && (rtasr = f19862OxxIIOOXO) != null) {
                        rtasr.write((byte[]) bArr.clone());
                    }
                }
                fileInputStream.close();
                RTASR rtasr6 = f19862OxxIIOOXO;
                if (rtasr6 != null) {
                    rtasr6.stop();
                }
            } catch (Exception e) {
                RTASR rtasr7 = f19862OxxIIOOXO;
                if (rtasr7 != null) {
                    rtasr7.stop();
                }
                e.printStackTrace();
            }
        }
    }

    public final void XX0(@OXOo.OOXIXo LLMCallbacks lLMCallbacks) {
        IIX0o.x0xO0oo(lLMCallbacks, "<set-?>");
        f19865XI0IXoo = lLMCallbacks;
    }

    public final void XX0xXo(@OXOo.oOoXoXO Integer num) {
        if (num != null && num.intValue() == 18020) {
            Xo0.f24349oIX0oI.II0xO0().put(XoI0Ixx0.f24455oXxOI0oIx + OxI.IIOIX(BleCache.INSTANCE.getMBleAddress(), ":", "", false, 4, null), "");
            ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.spark_exist_fail) + "  " + num, new Object[0]);
        }
    }

    public final void Xo0(@OXOo.OOXIXo StringBuffer stringBuffer) {
        IIX0o.x0xO0oo(stringBuffer, "<set-?>");
        f19859OxI = stringBuffer;
    }

    public final void XoI0Ixx0(int i) {
        f19856O0xOxO = i;
    }

    public final void XoX(@OXOo.oOoXoXO xxxI.II0xO0<AIAnswer> iI0xO0) {
        f19851II0XooXoX = iI0xO0;
    }

    public final void Xx000oIo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo String lang, @OXOo.OOXIXo String targetLang, boolean z, int i, @OXOo.oOoXoXO xxxI.II0xO0<AITranslation> iI0xO0) {
        RTASR rtasr;
        IIX0o.x0xO0oo(bArr, "byte");
        IIX0o.x0xO0oo(lang, "lang");
        IIX0o.x0xO0oo(targetLang, "targetLang");
        if (o0xxxXXxX() != 0) {
            return;
        }
        if (z) {
            RTASR rtasr2 = f19862OxxIIOOXO;
            if (rtasr2 != null) {
                rtasr2.stop();
            }
            f19862OxxIIOOXO = null;
            return;
        }
        f19854IIXOooo = iI0xO0;
        if (f19862OxxIIOOXO == null) {
            IO(lang, targetLang);
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArr2 = new byte[i];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                if (-1 != read) {
                    if (read > 0 && (rtasr = f19862OxxIIOOXO) != null) {
                        rtasr.write((byte[]) bArr2.clone());
                    }
                } else {
                    byteArrayInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean XxX0x0xxx() {
        return f19880xI;
    }

    public final boolean o00() {
        return f19868XxX0x0xxx;
    }

    public final int o0xxxXXxX() {
        String IIOIX2;
        MacConfig macConfig;
        if (f19872oO) {
            return f19858Oo;
        }
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMBleAddress().length() == 0) {
            ToastUtils.showLong(R.string.not_connected);
            return f19855IXxxXO;
        }
        if (f19879x0xO0oo) {
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.XO0o()) {
                DeviceConfigInfo IOoo2 = productManager.IOoo();
                if (IOoo2 != null && (macConfig = IOoo2.getMacConfig()) != null) {
                    IIOIX2 = macConfig.getMac();
                } else {
                    IIOIX2 = null;
                }
            } else {
                IIOIX2 = OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null);
            }
            SparkChainConfig builder = SparkChainConfig.builder();
            boolean z = false;
            builder.appID(f19873oOoXoXO).apiKey(f19875ooOOo0oXI).apiSecret(f19878x0XOIxOo).uid(IIOIX2).logLevel(0).logPath(IXxxXO.I0Io(X00IoxXI.oIX0oI.f3233oIX0oI, "AI_SPARK_CHAIN_" + com.sma.smartv3.util.xoIox.oxoX().format(new Date()) + ".txt").getAbsolutePath());
            int init = SparkChain.getInst().init(Utils.getApp(), builder);
            if (init == 0) {
                z = true;
            }
            f19872oO = z;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " sparkChainInit ret = " + init + "  uid = " + IIOIX2 + " , isForceSparkChainAI = " + productManager.XO0o() + " ,  isConfigurationSparkChainAI = " + productManager.O0xxXxI() + TokenParser.SP);
            return init;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + "   sparkChainInit  isSupportInitializeSDK = " + f19879x0xO0oo);
        ToastUtils.showLong(R.string.spark_exist_fail);
        return f19861Oxx0xo;
    }

    @OXOo.oOoXoXO
    public final xxxI.II0xO0<AITranslation> oI0IIXIo() {
        return f19854IIXOooo;
    }

    @OXOo.oOoXoXO
    public final xxxI.II0xO0<AITranslation> oO() {
        return f19869o00;
    }

    public final boolean oOoXoXO() {
        return f19879x0xO0oo;
    }

    public final void oX(@OXOo.oOoXoXO ASR asr) {
        f19883xoXoI = asr;
    }

    public final void oo0xXOI0I(@OXOo.OOXIXo byte[] bArr, boolean z, int i, @OXOo.oOoXoXO xxxI.II0xO0<AITranslation> iI0xO0, boolean z2, int i2, @OXOo.OOXIXo String language, @OXOo.OOXIXo String accent) {
        ASR asr;
        IIX0o.x0xO0oo(bArr, "byte");
        IIX0o.x0xO0oo(language, "language");
        IIX0o.x0xO0oo(accent, "accent");
        if (o0xxxXXxX() != 0) {
            return;
        }
        if (z) {
            ASR asr2 = f19883xoXoI;
            if (asr2 != null) {
                asr2.stop(false);
            }
            f19883xoXoI = null;
            return;
        }
        f19880xI = z2;
        if (f19883xoXoI == null) {
            IoOoX(iI0xO0, i2, language, accent);
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArr2 = new byte[i];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                if (-1 != read) {
                    if (read > 0 && (asr = f19883xoXoI) != null) {
                        asr.write((byte[]) bArr2.clone());
                    }
                } else {
                    byteArrayInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int ooOOo0oXI(@OXOo.OOXIXo String input) {
        IIX0o.x0xO0oo(input, "input");
        int length = input.length();
        do {
            length--;
            if (-1 >= length) {
                return -1;
            }
        } while (!f19874oo0xXOI0I.matches(String.valueOf(input.charAt(length))));
        return length;
    }

    public final boolean ooXIXxIX() {
        return f19863X0IIOO;
    }

    public final void ox() {
        ASR asr = f19883xoXoI;
        if (asr != null) {
            asr.stop(false);
        }
        LLM llm = f19864X0o0xo;
        if (llm != null) {
            llm.stop();
        }
        f19863X0IIOO = false;
    }

    public final void oxXx0IX(@OXOo.oOoXoXO xxxI.II0xO0<Bitmap> iI0xO0) {
        f19884xxIXOIIO = iI0xO0;
    }

    public final void oxoX(@OXOo.OOXIXo String inputText, @OXOo.oOoXoXO xxxI.II0xO0<Bitmap> iI0xO0) {
        IIX0o.x0xO0oo(inputText, "inputText");
        if (o0xxxXXxX() != 0) {
            return;
        }
        XI0IXoo();
        f19884xxIXOIIO = iI0xO0;
        LLM llm = f19867XO;
        if (llm != null) {
            llm.arun(inputText);
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + " generateAIGC inputText = " + inputText);
        LLM llm2 = f19867XO;
        if (llm2 != null) {
            llm2.registerLLMCallbacks(new oIX0oI());
        }
    }

    public final void oxxXoxO(boolean z) {
        f19870oI0IIXIo = z;
    }

    @OXOo.OOXIXo
    public final LLMCallbacks x0XOIxOo() {
        return f19865XI0IXoo;
    }

    public final void x0xO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        f19860Oxx0IOOO = str;
    }

    @OXOo.oOoXoXO
    public final ASR x0xO0oo() {
        return f19883xoXoI;
    }

    public final void xI(int i) {
        String substring;
        if (f19863X0IIOO && f19859OxI.length() > 0 && i == 1 && f19856O0xOxO < 2) {
            String stringBuffer = f19859OxI.toString();
            IIX0o.oO(stringBuffer, "toString(...)");
            List<String> O00XxXI2 = O00XxXI(stringBuffer);
            int size = O00XxXI2.size();
            int i2 = f19866XIxXXX0x0;
            int i3 = f19856O0xOxO;
            if (size >= i2 + i3) {
                if (i3 == 0) {
                    DcsTtsPlayer.INSTANCE.initSegmentation();
                }
                int indexOf = f19859OxI.indexOf(O00XxXI2.get(i2 - 1));
                if (O00XxXI2.get(i2 - 1).length() + indexOf + 1 < f19859OxI.length()) {
                    substring = f19859OxI.substring(0, indexOf + O00XxXI2.get(i2 - 1).length() + 1);
                } else {
                    StringBuffer stringBuffer2 = f19859OxI;
                    String stringBuffer3 = stringBuffer2.toString();
                    IIX0o.oO(stringBuffer3, "toString(...)");
                    substring = stringBuffer2.substring(0, ooOOo0oXI(stringBuffer3));
                }
                if (substring.length() > 10) {
                    int i4 = f19856O0xOxO + 1;
                    f19856O0xOxO = i4;
                    if (i4 == 1) {
                        x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞分段播放 , 第一段开始请求");
                    }
                    DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                    IIX0o.ooOOo0oXI(substring);
                    DcsTtsPlayer.play$default(dcsTtsPlayer, substring, true, false, null, null, 28, null);
                    f19859OxI.delete(0, substring.length());
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            if (f19856O0xOxO == 0) {
                x0xO0oo.oIX0oI(XoI0Ixx0.f24422XOxxooXI, "科大讯飞分段播放 , 第一段开始请求");
                DcsTtsPlayer.INSTANCE.initSegmentation();
            }
            DcsTtsPlayer dcsTtsPlayer2 = DcsTtsPlayer.INSTANCE;
            String stringBuffer4 = f19859OxI.toString();
            IIX0o.oO(stringBuffer4, "toString(...)");
            DcsTtsPlayer.play$default(dcsTtsPlayer2, stringBuffer4, true, false, null, null, 28, null);
        }
    }

    public final void xII(int i) {
        Integer num;
        ASR asr;
        ASR asr2 = f19883xoXoI;
        if (asr2 != null) {
            if (asr2 != null) {
                asr2.stop(false);
            }
            AudioAttributes audioAttributes = new AudioAttributes();
            if (!f19880xI && (asr = f19883xoXoI) != null) {
                asr.vadEos(i);
            }
            ASR asr3 = f19883xoXoI;
            if (asr3 != null) {
                num = Integer.valueOf(asr3.start(audioAttributes, "tag"));
            } else {
                num = null;
            }
            XX0xXo(num);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + "  isASRSteam = " + f19880xI + " , vadEos = " + i + " , realTimeStart_ASR asr  ret = " + num);
        }
    }

    public final void xXOx(boolean z) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f19850I0Io + "  setIsSupportInitializeSDK  b = " + z);
        f19879x0xO0oo = z;
    }

    public final boolean xXxxox0I() {
        return f19872oO;
    }

    public final void xo0x(boolean z) {
        f19872oO = z;
    }

    public final int xoIox() {
        return f19855IXxxXO;
    }

    public final void xoIxX(boolean z) {
        f19868XxX0x0xxx = z;
    }

    public final boolean xoXoI() {
        return f19882xoIox;
    }

    public final void xoxXI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        f19881xXxxox0I = str;
    }

    public final void xxIO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        f19876ooXIXxIX = str;
    }

    public final int xxIXOIIO() {
        return f19861Oxx0xo;
    }
}
