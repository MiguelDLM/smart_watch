package com.sma.smartv3.ui.device;

import android.os.Handler;
import android.view.View;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class DeviceFragment$checkAppAvailable$1 extends Lambda implements Oox.oOoXoXO<String, kotlin.oXIO0o0XI> {
    final /* synthetic */ DeviceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceFragment$checkAppAvailable$1(DeviceFragment deviceFragment) {
        super(1);
        this.this$0 = deviceFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(DeviceFragment this$0, final String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "$str");
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this$0.getMActivity(), 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.tip);
        xoI0Ixx0.oo(str);
        xoI0Ixx0.x0xO0oo(false);
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
        xoI0Ixx0.x0o(R.string.copy_content, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.DeviceFragment$checkAppAvailable$1$1$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                ClipboardUtils.copyText(str);
                ToastUtils.showLong(R.string.copied);
                return Boolean.FALSE;
            }
        });
        View rootView = this$0.getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        xoI0Ixx0.OxxIIOOXO(rootView);
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str) {
        invoke2(str);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo final String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
        Handler handler = new Handler();
        final DeviceFragment deviceFragment = this.this$0;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.oOXoIIIo
            @Override // java.lang.Runnable
            public final void run() {
                DeviceFragment$checkAppAvailable$1.invoke$lambda$1(DeviceFragment.this, str);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
