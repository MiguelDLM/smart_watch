package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0}, l = {EMachine.EM_MANIK}, m = "yieldFrames", n = {"this", "$this$yieldFrames", TypedValues.AttributesType.S_FRAME}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, kotlin.coroutines.I0Io<? super DebugCoroutineInfoImpl$yieldFrames$1> i0Io) {
        super(i0Io);
        this.this$0 = debugCoroutineInfoImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        Object OOXIXo2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        OOXIXo2 = this.this$0.OOXIXo(null, null, this);
        return OOXIXo2;
    }
}
