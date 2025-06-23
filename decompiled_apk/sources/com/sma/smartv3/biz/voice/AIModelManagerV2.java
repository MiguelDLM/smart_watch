package com.sma.smartv3.biz.voice;

import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.AIWatchFaceManager;
import com.sma.smartv3.biz.voice.AIModelManagerV2;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIQuestion;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AIModelManagerV2 {

    @OXOo.OOXIXo
    public static final AIModelManagerV2 INSTANCE = new AIModelManagerV2();

    @OXOo.OOXIXo
    private static final String TAG = "AIModelManagerV2";

    @OXOo.oOoXoXO
    private static OnAIModelCallback mAIModelCallback;

    /* loaded from: classes12.dex */
    public interface OnAIModelCallback {
        void onAIModelError(@OXOo.OOXIXo String str);

        void onComplete(@OXOo.OOXIXo String str);

        void onProcessComplete(@OXOo.OOXIXo String str);
    }

    private AIModelManagerV2() {
    }

    public static /* synthetic */ void textAIFunction$default(AIModelManagerV2 aIModelManagerV2, String str, OnAIModelCallback onAIModelCallback, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        aIModelManagerV2.textAIFunction(str, onAIModelCallback, i);
    }

    public static /* synthetic */ void textAiChat$default(AIModelManagerV2 aIModelManagerV2, String str, OnAIModelCallback onAIModelCallback, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        aIModelManagerV2.textAiChat(str, onAIModelCallback, i);
    }

    public static /* synthetic */ void textAiTranslation$default(AIModelManagerV2 aIModelManagerV2, String str, OnAIModelCallback onAIModelCallback, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        aIModelManagerV2.textAiTranslation(str, onAIModelCallback, i);
    }

    public static /* synthetic */ void textAiWatchFace$default(AIModelManagerV2 aIModelManagerV2, String str, OnAIModelCallback onAIModelCallback, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        aIModelManagerV2.textAiWatchFace(str, onAIModelCallback, i);
    }

    public final void textAIFunction(@OXOo.OOXIXo String query, @OXOo.OOXIXo OnAIModelCallback mAICallback, int i) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(mAICallback, "mAICallback");
        mAIModelCallback = mAICallback;
        VoiceManager voiceManager = VoiceManager.INSTANCE;
        if (!voiceManager.isSupportAIVoiceTranslation() && !voiceManager.isSupportEarPhoneVoiceTranslation()) {
            if (voiceManager.isSupportAIVoiceWatchface()) {
                textAiWatchFace(query, mAICallback, i);
                return;
            } else {
                textAiChat(query, mAICallback, i);
                return;
            }
        }
        textAiTranslation(query, mAICallback, i);
    }

    public final void textAiChat(@OXOo.OOXIXo final String query, @OXOo.OOXIXo final OnAIModelCallback mAICallback, int i) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(mAICallback, "mAICallback");
        AIManager.f19833oIX0oI.xI(new AIQuestion(AIFunctionType.AI, query, null, null, false, 28, null), new xxxI.II0xO0<AIAnswer>() { // from class: com.sma.smartv3.biz.voice.AIModelManagerV2$textAiChat$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                mAICallback.onAIModelError(error);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO AIAnswer aIAnswer) {
                String str;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                str = AIModelManagerV2.TAG;
                sb.append(str);
                sb.append(" AIChat handleResponse -> ");
                sb.append(query);
                oix0oi.oIX0oI(sb.toString());
                if (aIAnswer != null) {
                    AIModelManagerV2.OnAIModelCallback onAIModelCallback = mAICallback;
                    if (aIAnswer.getEnded() == 1) {
                        onAIModelCallback.onComplete(aIAnswer.getText());
                    } else {
                        onAIModelCallback.onProcessComplete(aIAnswer.getText());
                    }
                }
            }
        }, true, false, ProductManager.f20544oIX0oI.xX(), i);
    }

    public final void textAiTranslation(@OXOo.OOXIXo String query, @OXOo.OOXIXo OnAIModelCallback mAICallback, int i) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(mAICallback, "mAICallback");
        AITranslationManager.INSTANCE.textTranslation(query, mAICallback, i);
    }

    public final void textAiWatchFace(@OXOo.OOXIXo String query, @OXOo.OOXIXo final OnAIModelCallback mAICallback, int i) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(mAICallback, "mAICallback");
        AIWatchFaceManager.f19897oIX0oI.IIXOooo(query, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.voice.AIModelManagerV2$textAiWatchFace$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                AIModelManagerV2.OnAIModelCallback.this.onAIModelError(error);
            }

            @Override // xxxI.II0xO0
            public void handleResponse(@OXOo.oOoXoXO String str) {
                if (str != null && str.length() > 0) {
                    AIModelManagerV2.OnAIModelCallback.this.onComplete(str);
                } else {
                    AIModelManagerV2.OnAIModelCallback.this.onAIModelError("Path Error");
                }
            }
        }, i);
    }
}
