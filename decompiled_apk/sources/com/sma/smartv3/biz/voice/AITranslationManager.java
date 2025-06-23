package com.sma.smartv3.biz.voice;

import com.sma.smartv3.biz.AISparkChainManager;
import com.sma.smartv3.biz.voice.AIModelManagerV2;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.LanguageTranslationKt;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.entity.Languages;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class AITranslationManager {

    @OXOo.OOXIXo
    public static final AITranslationManager INSTANCE = new AITranslationManager();

    @OXOo.OOXIXo
    private static final String TAG = "AIManager AITranslationManager";

    private AITranslationManager() {
    }

    public static /* synthetic */ void textTranslation$default(AITranslationManager aITranslationManager, String str, AIModelManagerV2.OnAIModelCallback onAIModelCallback, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        aITranslationManager.textTranslation(str, onAIModelCallback, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void translateITS(String str, String str2, final String str3, final AIModelManagerV2.OnAIModelCallback onAIModelCallback) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager AITranslationManager  translateITS leftLang = " + str2 + " , rightLang = " + str3);
        AISparkChainManager.f19871oIX0oI.OOXIxO0(str, str2, str3, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.AITranslationManager$translateITS$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                AIModelManagerV2.OnAIModelCallback.this.onAIModelError(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error));
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str4) {
                if (str4 != null && str4.length() > 0) {
                    AIModelManagerV2.OnAIModelCallback.this.onComplete(str4);
                    DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                    dcsTtsPlayer.initSegmentation();
                    DcsTtsPlayer.play$default(dcsTtsPlayer, str4, true, false, null, LanguageTranslationKt.getTranslationLanguageTtsName(str3), 12, null);
                    return;
                }
                AIModelManagerV2.OnAIModelCallback.this.onAIModelError(UtilsKt.oI0IIXIo(R.string.voice_assistant_common_error));
            }
        });
    }

    public static /* synthetic */ void translateITS$default(AITranslationManager aITranslationManager, String str, String str2, String str3, AIModelManagerV2.OnAIModelCallback onAIModelCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "cn";
        }
        if ((i & 4) != 0) {
            str3 = Languages.DEFAULT_LANGUAGE;
        }
        aITranslationManager.translateITS(str, str2, str3, onAIModelCallback);
    }

    public final void textTranslation(@OXOo.OOXIXo String text, @OXOo.OOXIXo final AIModelManagerV2.OnAIModelCallback mAICallback, int i) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(mAICallback, "mAICallback");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            String formatMicrosoftTargetLang = Languages.INSTANCE.formatMicrosoftTargetLang(VoiceManagerV2.INSTANCE.getMToLanguage(), Languages.DEFAULT_LANGUAGE);
            MicrosoftSDKManage.II0xO0 iI0xO0 = MicrosoftSDKManage.f24259Xx000oIo;
            iI0xO0.oIX0oI().xoIxX();
            iI0xO0.oIX0oI().oXxOI0oIx(text, formatMicrosoftTargetLang, new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.voice.AITranslationManager$textTranslation$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str) {
                    invoke2(str);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo String it) {
                    IIX0o.x0xO0oo(it, "it");
                    DcsTtsPlayer.INSTANCE.stop();
                    AIModelManagerV2.OnAIModelCallback.this.onComplete(it);
                    MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().xI(it, VoiceManagerV2.INSTANCE.getToLanguageTranslationData().getTtsViuceName());
                }
            });
            return;
        }
        if (productManager.oO0OX0() || i == 2) {
            Languages languages = Languages.INSTANCE;
            VoiceManagerV2 voiceManagerV2 = VoiceManagerV2.INSTANCE;
            String formatAISparkTargetLang = languages.formatAISparkTargetLang(voiceManagerV2.getMLanguage(), Languages.DEFAULT_LANGUAGE_ZH);
            final String formatAISparkTargetLang2 = languages.formatAISparkTargetLang(voiceManagerV2.getMToLanguage(), Languages.DEFAULT_LANGUAGE);
            if (!IIX0o.Oxx0IOOO(formatAISparkTargetLang, "cn") && !IIX0o.Oxx0IOOO(formatAISparkTargetLang2, "cn")) {
                AISparkChainManager.f19871oIX0oI.OOXIxO0(text, formatAISparkTargetLang, "cn", new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.AITranslationManager$textTranslation$2
                    @Override // xxxI.II0xO0
                    public void handleError(@OXOo.OOXIXo String error) {
                        IIX0o.x0xO0oo(error, "error");
                        mAICallback.onAIModelError(UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                    }

                    @Override // xxxI.II0xO0
                    public void handleResponse(@OXOo.oOoXoXO String str) {
                        if (str != null && str.length() > 0) {
                            AITranslationManager.INSTANCE.translateITS(str, "cn", formatAISparkTargetLang2, mAICallback);
                        } else {
                            mAICallback.onAIModelError(UtilsKt.oI0IIXIo(R.string.failed_in_translation));
                        }
                    }
                });
            } else {
                translateITS(text, formatAISparkTargetLang, formatAISparkTargetLang2, mAICallback);
            }
        }
    }
}
