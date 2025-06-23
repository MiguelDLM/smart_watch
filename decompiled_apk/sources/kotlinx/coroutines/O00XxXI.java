package kotlinx.coroutines;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes6.dex */
public final class O00XxXI {
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = TypedValues.TransitionType.S_FROM)
    public static final CoroutineDispatcher I0Io(@OXOo.OOXIXo Executor executor) {
        oX oXVar;
        CoroutineDispatcher coroutineDispatcher;
        if (executor instanceof oX) {
            oXVar = (oX) executor;
        } else {
            oXVar = null;
        }
        if (oXVar == null || (coroutineDispatcher = oXVar.f30342XO) == null) {
            return new o0xxxXXxX(executor);
        }
        return coroutineDispatcher;
    }

    @OXOo.OOXIXo
    public static final Executor II0xO0(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Executor IIXOooo2;
        if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher;
        } else {
            executorCoroutineDispatcher = null;
        }
        if (executorCoroutineDispatcher == null || (IIXOooo2 = executorCoroutineDispatcher.IIXOooo()) == null) {
            return new oX(coroutineDispatcher);
        }
        return IIXOooo2;
    }

    @XI0oooXX
    public static /* synthetic */ void oIX0oI() {
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = TypedValues.TransitionType.S_FROM)
    public static final ExecutorCoroutineDispatcher oxoX(@OXOo.OOXIXo ExecutorService executorService) {
        return new o0xxxXXxX(executorService);
    }
}
