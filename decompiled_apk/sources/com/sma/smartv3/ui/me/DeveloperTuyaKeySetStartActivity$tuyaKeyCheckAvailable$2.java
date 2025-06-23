package com.sma.smartv3.ui.me;

import android.os.Handler;
import android.text.TextUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleTuyaKey;

/* loaded from: classes11.dex */
public final class DeveloperTuyaKeySetStartActivity$tuyaKeyCheckAvailable$2 implements xxxI.II0xO0<OIoxIx> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ String f23239II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ DeveloperTuyaKeySetStartActivity f23240oIX0oI;

    public DeveloperTuyaKeySetStartActivity$tuyaKeyCheckAvailable$2(DeveloperTuyaKeySetStartActivity developerTuyaKeySetStartActivity, String str) {
        this.f23240oIX0oI = developerTuyaKeySetStartActivity;
        this.f23239II0xO0 = str;
    }

    public static final void I0Io(DeveloperTuyaKeySetStartActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " Shutdown success! Force closeConnection!");
        this$0.reStart();
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO OIoxIx oIoxIx) {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f23240oIX0oI.TAG + " tuyaKeyCheckAvailable handleResponse -> " + oIoxIx);
        if (oIoxIx != null && !TextUtils.isEmpty(oIoxIx.getMac())) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(oIoxIx.getMac(), this.f23239II0xO0)) {
                oix0oi.oIX0oI(this.f23240oIX0oI.TAG + " tuyaKeyCheckAvailable handleResponse -> Shutdown directly");
                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
                Handler handler = new Handler();
                final DeveloperTuyaKeySetStartActivity developerTuyaKeySetStartActivity = this.f23240oIX0oI;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xxOXOOoIX
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperTuyaKeySetStartActivity$tuyaKeyCheckAvailable$2.I0Io(DeveloperTuyaKeySetStartActivity.this);
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            BleTuyaKey bleTuyaKey = new BleTuyaKey(0, oIoxIx.XO(), oIoxIx.X0o0xo(), oIoxIx.getMac(), 1, null);
            oix0oi.oIX0oI(this.f23240oIX0oI.TAG + " tuyaKeyCheckAvailable handleResponse -> " + bleTuyaKey);
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.TUYA_KEY_SET, BleKeyFlag.UPDATE, bleTuyaKey, false, false, 24, null);
            return;
        }
        ToastUtils.showLong("没有可用的KEY...", new Object[0]);
        oix0oi.oIX0oI(this.f23240oIX0oI.TAG + " tuyaKeyCheckAvailable handleResponse -> no key");
        this.f23240oIX0oI.reStart();
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23240oIX0oI.TAG + " tuyaKeyCheckAvailable handleError -> " + error);
        ToastUtils.showLong("error", new Object[0]);
        this.f23240oIX0oI.reStart();
    }
}
