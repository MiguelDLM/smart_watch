package com.sma.smartv3.service;

import android.content.ClipData;
import android.os.Handler;
import com.blankj.utilcode.util.LogUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.service.SuspendWindowService;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class SuspendWindowService$translateITS$1 implements xxxI.II0xO0<String> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ SuspendWindowService f21600oIX0oI;

    public SuspendWindowService$translateITS$1(SuspendWindowService suspendWindowService) {
        this.f21600oIX0oI = suspendWindowService;
    }

    public static final void I0Io(SuspendWindowService this$0) {
        boolean z;
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getTv_translate_t().setVisibility(0);
        this$0.setRecordText();
        z = this$0.onlyshowTranslate;
        if (z) {
            this$0.getClipboard().setPrimaryClip(ClipData.newPlainText("aura", String.valueOf(this$0.getMExtraInfo())));
            return;
        }
        this$0.getClipboard().setPrimaryClip(ClipData.newPlainText("aura", this$0.getMExtraInfo() + "\n(" + this$0.getMContent() + HexStringBuilder.COMMENT_END_CHAR));
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO String str) {
        LogUtils.d(this.f21600oIX0oI.TAG + " translateITS text = " + str);
        if (str != null && str.length() > 0) {
            this.f21600oIX0oI.setMExtraInfo(StringsKt__StringsKt.oIoIXxIO(str).toString());
            Handler handler = this.f21600oIX0oI.handle;
            final SuspendWindowService suspendWindowService = this.f21600oIX0oI;
            handler.post(new Runnable() { // from class: com.sma.smartv3.service.O0xOxO
                @Override // java.lang.Runnable
                public final void run() {
                    SuspendWindowService$translateITS$1.I0Io(SuspendWindowService.this);
                }
            });
            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24579IoXIXo, new SuspendWindowService.II0xO0(this.f21600oIX0oI.getMContent(), this.f21600oIX0oI.getMExtraInfo()));
            this.f21600oIX0oI.saveDBRecord();
            this.f21600oIX0oI.sendTranslationResult();
            SuspendWindowService suspendWindowService2 = this.f21600oIX0oI;
            suspendWindowService2.voiceChainAi(suspendWindowService2.getMExtraInfo());
            return;
        }
        this.f21600oIX0oI.setMContent("");
        this.f21600oIX0oI.setMExtraInfo("");
        this.f21600oIX0oI.saveDBRecord();
        this.f21600oIX0oI.sendTranslationResult();
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        IIX0o.x0xO0oo(error, "error");
        LogUtils.d(this.f21600oIX0oI.TAG + " translateITS text = " + error);
        this.f21600oIX0oI.setMContent("");
        this.f21600oIX0oI.setMExtraInfo("");
        this.f21600oIX0oI.saveDBRecord();
        this.f21600oIX0oI.sendTranslationResult();
    }
}
