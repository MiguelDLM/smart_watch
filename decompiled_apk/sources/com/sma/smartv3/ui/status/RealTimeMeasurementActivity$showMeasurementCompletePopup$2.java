package com.sma.smartv3.ui.status;

import com.sma.smartv3.pop.XoI0Ixx0;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "com.sma.smartv3.ui.status.RealTimeMeasurementActivity$showMeasurementCompletePopup$2", f = "RealTimeMeasurementActivity.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class RealTimeMeasurementActivity$showMeasurementCompletePopup$2 extends SuspendLambda implements Oox.x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    int label;
    final /* synthetic */ RealTimeMeasurementActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealTimeMeasurementActivity$showMeasurementCompletePopup$2(RealTimeMeasurementActivity realTimeMeasurementActivity, kotlin.coroutines.I0Io<? super RealTimeMeasurementActivity$showMeasurementCompletePopup$2> i0Io) {
        super(2, i0Io);
        this.this$0 = realTimeMeasurementActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return new RealTimeMeasurementActivity$showMeasurementCompletePopup$2(this.this$0, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        XoI0Ixx0 xoI0Ixx0;
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            this.label = 1;
            if (DelayKt.II0xO0(3000L, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        xoI0Ixx0 = this.this$0.mMeasurementCompletePopup;
        if (xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((RealTimeMeasurementActivity$showMeasurementCompletePopup$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
