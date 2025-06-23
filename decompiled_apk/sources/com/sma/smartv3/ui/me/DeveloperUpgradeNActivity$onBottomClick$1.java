package com.sma.smartv3.ui.me;

import android.os.Handler;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import kotlin.random.Random;

/* loaded from: classes11.dex */
public final class DeveloperUpgradeNActivity$onBottomClick$1 implements HttpProgressCallback<String> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ DeveloperUpgradeNActivity f23280oIX0oI;

    public DeveloperUpgradeNActivity$onBottomClick$1(DeveloperUpgradeNActivity developerUpgradeNActivity) {
        this.f23280oIX0oI = developerUpgradeNActivity;
    }

    public static final void I0Io(DeveloperUpgradeNActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        BleConnector bleConnector = BleConnector.INSTANCE;
        BleConnector.sendInt32$default(bleConnector, BleKey.SESSION, BleKeyFlag.CREATE, Random.Default.nextInt(), null, false, false, 56, null);
        BleConnector.sendData$default(bleConnector, BleKey.OTA, BleKeyFlag.UPDATE, null, false, false, 28, null);
        this$0.getMBleScanner().oOoXoXO(true);
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO String str) {
        Handler handler = new Handler();
        final DeveloperUpgradeNActivity developerUpgradeNActivity = this.f23280oIX0oI;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.xOOxIO
            @Override // java.lang.Runnable
            public final void run() {
                DeveloperUpgradeNActivity$onBottomClick$1.I0Io(DeveloperUpgradeNActivity.this);
            }
        }, 4000L);
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        this.f23280oIX0oI.setMStarted(false);
    }

    @Override // com.sma.androidnetworklib.method.HttpProgressCallback
    public void handleProgress(int i) {
    }
}
