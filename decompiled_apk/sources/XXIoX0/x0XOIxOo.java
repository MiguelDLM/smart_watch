package XXIoX0;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.internal.oI0IIXIo;

/* loaded from: classes6.dex */
public final class x0XOIxOo extends CoroutineDispatcher {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0XOIxOo f4071XO = new x0XOIxOo();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        II0xO0.f4039IIXOooo.o00(runnable, ooOOo0oXI.f4069xoIox, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OX00O0xII
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        II0xO0.f4039IIXOooo.o00(runnable, ooOOo0oXI.f4069xoIox, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    @XI0oooXX
    public CoroutineDispatcher limitedParallelism(int i) {
        oI0IIXIo.oIX0oI(i);
        if (i >= ooOOo0oXI.f4068oxoX) {
            return this;
        }
        return super.limitedParallelism(i);
    }
}
