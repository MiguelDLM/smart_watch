package com.sma.smartv3.ui.status;

import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.sma.smartv3.ui.status.RealTimeMeasurementActivity$sendHeartRate$1", f = "RealTimeMeasurementActivity.kt", i = {}, l = {136, 138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class RealTimeMeasurementActivity$sendHeartRate$1 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    int label;

    public RealTimeMeasurementActivity$sendHeartRate$1(kotlin.coroutines.I0Io<? super RealTimeMeasurementActivity$sendHeartRate$1> i0Io) {
        super(2, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new RealTimeMeasurementActivity$sendHeartRate$1(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    I0oOoX.x0XOIxOo(obj);
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24567II0xO0, null, 2, null);
                    return oXIO0o0XI.f29392oIX0oI;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            I0oOoX.x0XOIxOo(obj);
        } else {
            I0oOoX.x0XOIxOo(obj);
            this.label = 1;
            if (DelayKt.II0xO0(50L, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.HEART_RATE, BleKeyFlag.READ, null, false, false, 28, null);
        this.label = 2;
        if (DelayKt.II0xO0(500L, this) == oOoXoXO2) {
            return oOoXoXO2;
        }
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24567II0xO0, null, 2, null);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((RealTimeMeasurementActivity$sendHeartRate$1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
