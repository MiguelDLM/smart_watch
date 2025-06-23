package com.sma.smartv3.ui.me;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.CheckBox;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAddressSettings;
import com.szabh.smable3.entity.BleAlipaySettings;

/* loaded from: classes11.dex */
public final class DeveloperBleAddressSetStartActivity$macOtaToolsFind$2 implements xxxI.II0xO0<XxXX> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ String f23158II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ DeveloperBleAddressSetStartActivity f23159oIX0oI;

    public DeveloperBleAddressSetStartActivity$macOtaToolsFind$2(DeveloperBleAddressSetStartActivity developerBleAddressSetStartActivity, String str) {
        this.f23159oIX0oI = developerBleAddressSetStartActivity;
        this.f23158II0xO0 = str;
    }

    public static final void X0o0xo(DeveloperBleAddressSetStartActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " Ble address settings! Force closeConnection!");
        BleCache bleCache = BleCache.INSTANCE;
        BleCache.remove$default(bleCache, BleKey.BLE_ADDRESS_SET, null, 2, null);
        BleCache.remove$default(bleCache, BleKey.ALIPAY_SET, null, 2, null);
        this$0.reStart();
    }

    public static final void oxoX(DeveloperBleAddressSetStartActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this$0.TAG + " Shutdown success! Force closeConnection!");
        BleCache.remove$default(BleCache.INSTANCE, BleKey.SHUTDOWN, null, 2, null);
        this$0.reStart();
    }

    @Override // xxxI.II0xO0
    /* renamed from: I0Io, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO XxXX xxXX) {
        CheckBox cbAlipay;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.f23159oIX0oI.TAG + " macOtaToolsFind handleResponse -> " + xxXX);
        if (xxXX != null && !TextUtils.isEmpty(xxXX.I0Io())) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(xxXX.I0Io(), this.f23158II0xO0)) {
                oix0oi.oIX0oI(this.f23159oIX0oI.TAG + " macOtaToolsFind handleResponse -> Shutdown directly");
                BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.SHUTDOWN, BleKeyFlag.UPDATE, 0, false, false, 24, null);
                Handler handler = new Handler();
                final DeveloperBleAddressSetStartActivity developerBleAddressSetStartActivity = this.f23159oIX0oI;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.Xx000oIo
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperBleAddressSetStartActivity$macOtaToolsFind$2.oxoX(DeveloperBleAddressSetStartActivity.this);
                    }
                }, 5000L);
                return;
            }
            oix0oi.oIX0oI(this.f23159oIX0oI.TAG + " macOtaToolsFind handleResponse -> Ble address settings");
            cbAlipay = this.f23159oIX0oI.getCbAlipay();
            if (cbAlipay.isChecked()) {
                BleConnector bleConnector = BleConnector.INSTANCE;
                BleKey bleKey = BleKey.ALIPAY_SET;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                byte[] hexString2Bytes = ConvertUtils.hexString2Bytes(xxXX.I0Io());
                kotlin.jvm.internal.IIX0o.oO(hexString2Bytes, "hexString2Bytes(...)");
                BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, new BleAlipaySettings(0, 0, hexString2Bytes), false, false, 24, null);
            } else {
                BleConnector bleConnector2 = BleConnector.INSTANCE;
                BleKey bleKey2 = BleKey.BLE_ADDRESS_SET;
                BleKeyFlag bleKeyFlag2 = BleKeyFlag.UPDATE;
                byte[] hexString2Bytes2 = ConvertUtils.hexString2Bytes(xxXX.I0Io());
                kotlin.jvm.internal.IIX0o.oO(hexString2Bytes2, "hexString2Bytes(...)");
                BleConnector.sendObject$default(bleConnector2, bleKey2, bleKeyFlag2, new BleAddressSettings(hexString2Bytes2), false, false, 24, null);
            }
            Handler handler2 = new Handler();
            final DeveloperBleAddressSetStartActivity developerBleAddressSetStartActivity2 = this.f23159oIX0oI;
            handler2.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.X00IoxXI
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperBleAddressSetStartActivity$macOtaToolsFind$2.X0o0xo(DeveloperBleAddressSetStartActivity.this);
                }
            }, 4000L);
            return;
        }
        ToastUtils.showLong("没有可用的地址...", new Object[0]);
        this.f23159oIX0oI.reStart();
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.f23159oIX0oI.TAG + " macOtaToolsFind handleError -> " + error);
        this.f23159oIX0oI.reStart();
    }
}
