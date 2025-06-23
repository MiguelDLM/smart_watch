package com.sma.smartv3.ui.ai;

import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class AIChatActivity$startRecording$1 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    final /* synthetic */ AIChatActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatActivity$startRecording$1(AIChatActivity aIChatActivity) {
        super(0);
        this.this$0 = aIChatActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(AIChatActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.disRecordingPopup();
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x002c */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke2() {
        /*
            r6 = this;
            r0 = 0
            com.sma.smartv3.ui.ai.AIChatActivity r1 = r6.this$0     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            android.media.AudioRecord r1 = com.sma.smartv3.ui.ai.AIChatActivity.access$getMAudioRecord$p(r1)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            if (r1 == 0) goto L13
            r1.startRecording()     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            goto L13
        Ld:
            r1 = move-exception
            goto La1
        L10:
            r1 = move-exception
            goto L80
        L13:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            X00IoxXI.oIX0oI r2 = X00IoxXI.oIX0oI.f3233oIX0oI     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            java.io.File r2 = com.sma.smartv3.initializer.IXxxXO.o0(r2)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            int r0 = r0.getMBufferSize()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            byte[] r2 = new byte[r0]     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
        L26:
            com.sma.smartv3.ui.ai.AIChatActivity r3 = r6.this$0     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            boolean r3 = com.sma.smartv3.ui.ai.AIChatActivity.access$isRecording$p(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            if (r3 == 0) goto L4c
            com.sma.smartv3.ui.ai.AIChatActivity r3 = r6.this$0     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            android.media.AudioRecord r3 = com.sma.smartv3.ui.ai.AIChatActivity.access$getMAudioRecord$p(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            if (r3 == 0) goto L45
            r4 = 0
            r3.read(r2, r4, r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            goto L45
        L3b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto La1
        L40:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L80
        L45:
            r1.write(r2)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            r1.flush()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            goto L26
        L4c:
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            android.media.AudioRecord r0 = com.sma.smartv3.ui.ai.AIChatActivity.access$getMAudioRecord$p(r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            if (r0 == 0) goto L57
            r0.stop()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
        L57:
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            android.media.AudioRecord r0 = com.sma.smartv3.ui.ai.AIChatActivity.access$getMAudioRecord$p(r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            if (r0 == 0) goto L62
            r0.release()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
        L62:
            r1.flush()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L40
            r1.close()
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            com.sma.smartv3.ui.ai.OOXIXo r1 = new com.sma.smartv3.ui.ai.OOXIXo
            r1.<init>()
            r0.runOnUiThread(r1)
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            boolean r0 = r0.getRecordingIsClear()
            if (r0 != 0) goto La0
        L7a:
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            r0.recognition()
            goto La0
        L80:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto L88
            r0.close()     // Catch: java.lang.Throwable -> Ld
        L88:
            if (r0 == 0) goto L8d
            r0.close()
        L8d:
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            com.sma.smartv3.ui.ai.OOXIXo r1 = new com.sma.smartv3.ui.ai.OOXIXo
            r1.<init>()
            r0.runOnUiThread(r1)
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            boolean r0 = r0.getRecordingIsClear()
            if (r0 != 0) goto La0
            goto L7a
        La0:
            return
        La1:
            if (r0 == 0) goto La6
            r0.close()
        La6:
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            com.sma.smartv3.ui.ai.OOXIXo r2 = new com.sma.smartv3.ui.ai.OOXIXo
            r2.<init>()
            r0.runOnUiThread(r2)
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            boolean r0 = r0.getRecordingIsClear()
            if (r0 != 0) goto Lbd
            com.sma.smartv3.ui.ai.AIChatActivity r0 = r6.this$0
            r0.recognition()
        Lbd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.ai.AIChatActivity$startRecording$1.invoke2():void");
    }
}
