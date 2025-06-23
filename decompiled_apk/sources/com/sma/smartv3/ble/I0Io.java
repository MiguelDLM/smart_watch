package com.sma.smartv3.ble;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleEarphoneState;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class I0Io {
    public static final boolean I0Io(@OOXIXo oOoXoXO<? super BleConnector, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        BleEarphoneState bleEarphoneState = (BleEarphoneState) BleCache.getObject$default(BleCache.INSTANCE, BleKey.EARPHONE_STATE, BleEarphoneState.class, null, 4, null);
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (bleConnector.isAvailable()) {
            if ((bleEarphoneState != null && bleEarphoneState.getMLeftState() == 1) || (bleEarphoneState != null && bleEarphoneState.getMRightState() == 1)) {
                action.invoke(bleConnector);
                return true;
            }
            ToastUtils.showLong(R.string.not_connected);
            return false;
        }
        ToastUtils.showLong(R.string.not_connected);
        return false;
    }

    public static /* synthetic */ boolean II0xO0(boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return oIX0oI(z, oooxoxo);
    }

    public static final boolean oIX0oI(boolean z, @OOXIXo oOoXoXO<? super BleConnector, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        BleConnector bleConnector = BleConnector.INSTANCE;
        if (!bleConnector.isBound()) {
            ToastUtils.showLong(R.string.not_pair_tip);
            return false;
        }
        if (bleConnector.isAvailable()) {
            if (ProductManager.f20544oIX0oI.xOOxI() && z) {
                ToastUtils.showLong(R.string.power_save_mode_tip);
                return false;
            }
            action.invoke(bleConnector);
            return true;
        }
        ToastUtils.showLong(ProductManager.f20544oIX0oI.OxI());
        return false;
    }
}
