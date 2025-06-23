package IXIxx0;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class II0XooXoX implements kotlin.coroutines.I0Io<oXIO0o0XI> {

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public Result<oXIO0o0XI> f723XO;

    @oOoXoXO
    public final Result<oXIO0o0XI> I0Io() {
        return this.f723XO;
    }

    public final void II0xO0() {
        synchronized (this) {
            while (true) {
                try {
                    Result<oXIO0o0XI> result = this.f723XO;
                    if (result == null) {
                        IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
                        wait();
                    } else {
                        I0oOoX.x0XOIxOo(result.m296unboximpl());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // kotlin.coroutines.I0Io
    @OOXIXo
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final void oxoX(@oOoXoXO Result<oXIO0o0XI> result) {
        this.f723XO = result;
    }

    @Override // kotlin.coroutines.I0Io
    public void resumeWith(@OOXIXo Object obj) {
        synchronized (this) {
            this.f723XO = Result.m286boximpl(obj);
            IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }
}
