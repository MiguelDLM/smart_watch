package com.sma.smartv3.service;

import android.os.Handler;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.RecordingManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.xoxXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class SuspendWindowService$initViedo$1 extends Lambda implements Oox.IXxxXO<Integer, Integer, Integer, Boolean> {
    final /* synthetic */ SuspendWindowService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendWindowService$initViedo$1(SuspendWindowService suspendWindowService) {
        super(3);
        this.this$0 = suspendWindowService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(SuspendWindowService this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showRecordingPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(SuspendWindowService this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.disRecordingPopup();
    }

    @Override // Oox.IXxxXO
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Integer num3) {
        return invoke(num.intValue(), num2.intValue(), num3.intValue());
    }

    @OXOo.OOXIXo
    public final Boolean invoke(int i, int i2, int i3) {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.this$0.TAG + " mode:" + i + ",type:" + i2 + ",earDirection:" + i3);
        if (i2 == 0) {
            oix0oi.oIX0oI(this.this$0.TAG + " TRANSFER_STATUS_START");
            this.this$0.setEndTranslation(false);
            this.this$0.setStartAnalysis(true);
            DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
            dcsTtsPlayer.deleteReplayMusic();
            dcsTtsPlayer.stop();
            xoxXI.f24733oIX0oI.xxIXOIIO();
            VoiceManager.INSTANCE.setLanguageType(this.this$0.getArsLanguage(), this.this$0.getTtsVoiceName());
            this.this$0.getTv_original_t().setText("");
            this.this$0.getTv_translate_t().setText("");
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.XI0IXoo()) {
                this.this$0.startRecording();
            } else if (!productManager.oO0OX0()) {
                Handler handler = this.this$0.handle;
                final SuspendWindowService suspendWindowService = this.this$0;
                handler.post(new Runnable() { // from class: com.sma.smartv3.service.IXxxXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuspendWindowService$initViedo$1.invoke$lambda$0(SuspendWindowService.this);
                    }
                });
            } else {
                oix0oi.oIX0oI(this.this$0.TAG + " startRecording1");
                this.this$0.startRecording();
            }
        } else if (i2 == 1) {
            oix0oi.oIX0oI(this.this$0.TAG + " TRANSFER_STATUS_GO_ON");
            RecordingManager.Companion companion = RecordingManager.Companion;
            if (!companion.getInstance().isRecording()) {
                companion.getInstance().setRecording(true);
            }
        } else if (i2 == 2) {
            oix0oi.oIX0oI(this.this$0.TAG + " TRANSFER_STATUS_END");
            this.this$0.setEndTranslation(true);
            SuspendWindowService.stopRecording$default(this.this$0, false, 1, null);
            this.this$0.setStartAnalysis(false);
            ProductManager productManager2 = ProductManager.f20544oIX0oI;
            if (productManager2.XI0IXoo()) {
                MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().x0();
            }
            if (productManager2.oO0OX0() && !productManager2.XI0IXoo()) {
                Handler handler2 = this.this$0.handle;
                final SuspendWindowService suspendWindowService2 = this.this$0;
                handler2.post(new Runnable() { // from class: com.sma.smartv3.service.Oxx0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuspendWindowService$initViedo$1.invoke$lambda$1(SuspendWindowService.this);
                    }
                });
            }
        }
        return Boolean.TRUE;
    }
}
