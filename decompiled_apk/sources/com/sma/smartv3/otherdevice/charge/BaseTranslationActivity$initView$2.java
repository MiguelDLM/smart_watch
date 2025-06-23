package com.sma.smartv3.otherdevice.charge;

import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.util.MicrosoftSDKManage;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class BaseTranslationActivity$initView$2 extends Lambda implements Oox.IXxxXO<Integer, Integer, Integer, Boolean> {
    final /* synthetic */ BaseTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTranslationActivity$initView$2(BaseTranslationActivity baseTranslationActivity) {
        super(3);
        this.this$0 = baseTranslationActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(BaseTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showRecordingPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(BaseTranslationActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.disRecordingPopup();
    }

    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
        return invoke(num.intValue(), num2.intValue(), num3.intValue());
    }

    @OXOo.OOXIXo
    public final Boolean invoke(int i, int i2, int i3) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.this$0.TAG + " mode:" + i + ",type:" + i2 + ",earDirection:" + i3);
        int i4 = 2;
        if (i2 == 0) {
            this.this$0.setEndTranslation(false);
            BaseTranslationActivity baseTranslationActivity = this.this$0;
            if (i3 == 1 && !baseTranslationActivity.isAppSend()) {
                i4 = 1;
            }
            baseTranslationActivity.setMAIRecordsType(i4);
            this.this$0.setStartAnalysis(true);
            this.this$0.setLangAndVoice();
            DcsTtsPlayer.INSTANCE.stop();
            com.sma.smartv3.util.xoxXI.f24733oIX0oI.xxIXOIIO();
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            voiceManager.setLanguageType(this.this$0.getArsLanguage(), this.this$0.getTtsVoiceName());
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.XI0IXoo()) {
                this.this$0.startRecording();
            }
            if (productManager.oO0OX0() && voiceManager.isRecordBluetooth()) {
                this.this$0.startRecording();
            } else {
                this.this$0.setMAIRecords(new AIRecords(0, 0L, null, this.this$0.getMAIFunctionType(), this.this$0.getMAIRecordsType(), "", null, 0, 0, 0, null, null, null, null, null, 0, this.this$0.getTtsVoiceName(), 65479, null));
                final BaseTranslationActivity baseTranslationActivity2 = this.this$0;
                baseTranslationActivity2.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.X0o0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseTranslationActivity$initView$2.invoke$lambda$0(BaseTranslationActivity.this);
                    }
                });
            }
        } else if (i2 == 1) {
            RecordingManager.Companion companion = RecordingManager.Companion;
            if (!companion.getInstance().isRecording()) {
                companion.getInstance().setRecording(true);
            }
        } else if (i2 == 2) {
            this.this$0.setEndTranslation(true);
            BaseTranslationActivity.stopRecording$default(this.this$0, false, 1, null);
            this.this$0.getMHandler().removeMessages(this.this$0.loadTimeOut);
            this.this$0.getMHandler().removeMessages(this.this$0.loadTimeOutToast);
            this.this$0.setStartAnalysis(false);
            ProductManager productManager2 = ProductManager.f20544oIX0oI;
            if (productManager2.XI0IXoo()) {
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0();
            }
            if (productManager2.oO0OX0() && !productManager2.XI0IXoo()) {
                final BaseTranslationActivity baseTranslationActivity3 = this.this$0;
                baseTranslationActivity3.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.otherdevice.charge.XO
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseTranslationActivity$initView$2.invoke$lambda$1(BaseTranslationActivity.this);
                    }
                });
            }
        }
        return Boolean.TRUE;
    }
}
