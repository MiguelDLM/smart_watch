package com.sma.smartv3.ui.device;

import com.blankj.utilcode.util.LogUtils;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;

@IXIxx0.oxoX(c = "com.sma.smartv3.ui.device.HrMonitoringSettingsActivity$delayPostEvent$1", f = "HrMonitoringSettingsActivity.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class HrMonitoringSettingsActivity$delayPostEvent$1 extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.xII, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, Object> {
    int label;

    public HrMonitoringSettingsActivity$delayPostEvent$1(kotlin.coroutines.I0Io<? super HrMonitoringSettingsActivity$delayPostEvent$1> i0Io) {
        super(2, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new HrMonitoringSettingsActivity$delayPostEvent$1(i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                kotlin.I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.I0oOoX.x0XOIxOo(obj);
            this.label = 1;
            if (DelayKt.II0xO0(1000L, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24570IIXOooo, null, 2, null);
        LogUtils.i(" delayPostEvent HR_MONITORING_CHANGE");
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo kotlinx.coroutines.xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((HrMonitoringSettingsActivity$delayPostEvent$1) create(xii, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
