package com.sma.smartv3.ui.device;

import com.google.android.cameraview.CameraView;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class CameraActivity$permissionRemind$1$1 extends Lambda implements Oox.oIX0oI<Boolean> {
    final /* synthetic */ CameraActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraActivity$permissionRemind$1$1(CameraActivity cameraActivity) {
        super(0);
        this.this$0 = cameraActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CameraActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.finish();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oIX0oI
    @OXOo.OOXIXo
    public final Boolean invoke() {
        this.this$0.mNeedSendExitCamera = true;
        CameraView cameraView = this.this$0.getCameraView();
        final CameraActivity cameraActivity = this.this$0;
        return Boolean.valueOf(cameraView.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.xoXoI
            @Override // java.lang.Runnable
            public final void run() {
                CameraActivity$permissionRemind$1$1.invoke$lambda$0(CameraActivity.this);
            }
        }, 400L));
    }
}
