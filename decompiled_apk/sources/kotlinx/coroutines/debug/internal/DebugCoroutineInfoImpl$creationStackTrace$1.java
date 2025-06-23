package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.oXIO0o0XI;
import kotlin.sequences.oO;

@IXIxx0.oxoX(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements x0xO0oo<oO<? super StackTraceElement>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ xxIXOIIO $bottom;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, xxIXOIIO xxixoiio, kotlin.coroutines.I0Io<? super DebugCoroutineInfoImpl$creationStackTrace$1> i0Io) {
        super(2, i0Io);
        this.this$0 = debugCoroutineInfoImpl;
        this.$bottom = xxixoiio;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.this$0, this.$bottom, i0Io);
        debugCoroutineInfoImpl$creationStackTrace$1.L$0 = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object OOXIXo2;
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
            oO oOVar = (oO) this.L$0;
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = this.this$0;
            IXIxx0.I0Io callerFrame = this.$bottom.getCallerFrame();
            this.label = 1;
            OOXIXo2 = debugCoroutineInfoImpl.OOXIXo(oOVar, callerFrame, this);
            if (OOXIXo2 == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @oOoXoXO
    public final Object invoke(@OOXIXo oO<? super StackTraceElement> oOVar, @oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
