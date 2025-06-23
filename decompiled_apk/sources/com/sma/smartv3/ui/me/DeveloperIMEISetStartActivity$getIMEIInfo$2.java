package com.sma.smartv3.ui.me;

import android.os.Handler;
import android.text.TextUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;

/* loaded from: classes11.dex */
public final class DeveloperIMEISetStartActivity$getIMEIInfo$2 implements xxxI.II0xO0<OIxx0I0> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ String f23189II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ DeveloperIMEISetStartActivity f23190oIX0oI;

    public DeveloperIMEISetStartActivity$getIMEIInfo$2(DeveloperIMEISetStartActivity developerIMEISetStartActivity, String str) {
        this.f23190oIX0oI = developerIMEISetStartActivity;
        this.f23189II0xO0 = str;
    }

    public static final void I0Io(DeveloperIMEISetStartActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " Shutdown success! Force closeConnection!");
        this$0.reStart();
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO OIxx0I0 oIxx0I0) {
        this.f23190oIX0oI.mCurIMEICheckAvailableData = oIxx0I0;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f23190oIX0oI.TAG + " getIMEIInfo handleResponse -> " + oIxx0I0);
        if (oIxx0I0 != null && !TextUtils.isEmpty(oIxx0I0.I0Io())) {
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(oIxx0I0.I0Io(), this.f23189II0xO0)) {
                this.f23190oIX0oI.sendIMEI(oIxx0I0.I0Io());
                return;
            }
            oix0oi.oIX0oI(this.f23190oIX0oI.TAG + " getIMEIInfo handleResponse -> Shutdown directly");
            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
            Handler handler = new Handler();
            final DeveloperIMEISetStartActivity developerIMEISetStartActivity = this.f23190oIX0oI;
            handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xoxXI
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperIMEISetStartActivity$getIMEIInfo$2.I0Io(DeveloperIMEISetStartActivity.this);
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return;
        }
        ToastUtils.showLong("没有可用的IMEI!...", new Object[0]);
        oix0oi.oIX0oI(this.f23190oIX0oI.TAG + " getIMEIInfo handleResponse -> no IMEI");
        this.f23190oIX0oI.reStart();
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        this.f23190oIX0oI.mCurIMEICheckAvailableData = null;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("getIMEIInfo -> error! " + error);
        this.f23190oIX0oI.reStart();
    }
}
