package com.sma.smartv3.util;

import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.EvaluationKt;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;

/* loaded from: classes12.dex */
public final class oO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oO f24511oIX0oI = new oO();

    public static /* synthetic */ String II0xO0(oO oOVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return oOVar.oIX0oI(i);
    }

    public static /* synthetic */ String oxoX(oO oOVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return oOVar.I0Io(i);
    }

    @OXOo.OOXIXo
    public final String I0Io(int i) {
        EvaluationKt.putDialFailureTime();
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 5) {
                        return UtilsKt.oI0IIXIo(R.string.dial_generated_failure);
                    }
                    return UtilsKt.oI0IIXIo(R.string.dial_error_failure_5);
                }
                return UtilsKt.oI0IIXIo(R.string.dial_error_failure_4);
            }
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                return UtilsKt.oI0IIXIo(R.string.dial_error_failure_2_2);
            }
            return UtilsKt.oI0IIXIo(R.string.dial_error_failure_2_2);
        }
        return UtilsKt.oI0IIXIo(R.string.dial_error_failure_1);
    }

    @OXOo.OOXIXo
    public final String X0o0xo() {
        EvaluationKt.putOtaFailureTime();
        return UtilsKt.oI0IIXIo(R.string.firmware_upgrading_failed_and_retry);
    }

    @OXOo.OOXIXo
    public final String oIX0oI(int i) {
        EvaluationKt.putDialFailureTime();
        if (i != 0) {
            if (i != 1) {
                return UtilsKt.oI0IIXIo(R.string.sync_failed);
            }
            return UtilsKt.oI0IIXIo(R.string.sync_failed);
        }
        return UtilsKt.oI0IIXIo(R.string.dial_sync_failed_msg);
    }
}
