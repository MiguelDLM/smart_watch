package com.sma.smartv3.otherdevice.charge;

import android.os.Handler;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.model.AISpeech;
import com.sma.smartv3.model.LeftAndRightPlayControl;
import com.sma.smartv3.util.MicrosoftSDKManage;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class BinauralTranslationActivity$binauralSendTranslationResultInput$1 extends Lambda implements Oox.oOoXoXO<String, kotlin.oXIO0o0XI> {
    final /* synthetic */ AISpeech $aiSpeech;
    final /* synthetic */ BinauralTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinauralTranslationActivity$binauralSendTranslationResultInput$1(AISpeech aISpeech, BinauralTranslationActivity binauralTranslationActivity) {
        super(1);
        this.$aiSpeech = aISpeech;
        this.this$0 = binauralTranslationActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(final BinauralTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        MultiItemTypeAdapter multiItemTypeAdapter = this$0.mAdapter;
        if (multiItemTypeAdapter == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
            multiItemTypeAdapter = null;
        }
        multiItemTypeAdapter.notifyDataSetChanged();
        this$0.getMHandler().postDelayed(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.OxI
            @Override // java.lang.Runnable
            public final void run() {
                BinauralTranslationActivity$binauralSendTranslationResultInput$1.invoke$lambda$1$lambda$0(BinauralTranslationActivity.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(BinauralTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.aiSpeechList.size() > 0) {
            this$0.getRv().smoothScrollToPosition(this$0.aiSpeechList.size() - 1);
        }
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str) {
        invoke2(str);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo String it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
        this.$aiSpeech.setDst(StringsKt__StringsKt.oIoIXxIO(it).toString());
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.this$0.TAG + " binauralSendTranslationResultInput ===> str = " + this.$aiSpeech.getText() + TokenParser.SP + this.$aiSpeech.getDst());
        Handler mHandler = this.this$0.getMHandler();
        final BinauralTranslationActivity binauralTranslationActivity = this.this$0;
        mHandler.post(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.O0xOxO
            @Override // java.lang.Runnable
            public final void run() {
                BinauralTranslationActivity$binauralSendTranslationResultInput$1.invoke$lambda$1(BinauralTranslationActivity.this);
            }
        });
        MicrosoftSDKManage.IoOoX(MicrosoftSDKManage.f24259Xx000oIo.oIX0oI(), this.$aiSpeech.getDst(), this.$aiSpeech.getTtsVoiceName(), this.$aiSpeech.getLanguageModel() == 0 ? LeftAndRightPlayControl.RIGHT : LeftAndRightPlayControl.LEFT, 0, 8, null);
    }
}
