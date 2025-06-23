package kotlinx.coroutines.future;

import java.util.function.BiFunction;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class XO<T> implements BiFunction<T, Throwable, oXIO0o0XI> {

    @XO0OX.XO
    @OXOo.oOoXoXO
    public volatile kotlin.coroutines.I0Io<? super T> cont;

    public XO(@OXOo.oOoXoXO kotlin.coroutines.I0Io<? super T> i0Io) {
        this.cont = i0Io;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.BiFunction
    public /* bridge */ /* synthetic */ oXIO0o0XI apply(Object obj, Throwable th) {
        oIX0oI(obj, th);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        r2 = r2.getCause();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void oIX0oI(@OXOo.oOoXoXO T r2, @OXOo.oOoXoXO java.lang.Throwable r3) {
        /*
            r1 = this;
            kotlin.coroutines.I0Io<? super T> r0 = r1.cont
            if (r0 != 0) goto L5
            return
        L5:
            if (r3 != 0) goto L11
            kotlin.Result$oIX0oI r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.Result.m287constructorimpl(r2)
            r0.resumeWith(r2)
            goto L34
        L11:
            boolean r2 = kotlinx.coroutines.future.I0Io.oIX0oI(r3)
            if (r2 == 0) goto L1c
            java.util.concurrent.CompletionException r2 = kotlinx.coroutines.future.oxoX.oIX0oI(r3)
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 == 0) goto L27
            java.lang.Throwable r2 = kotlinx.coroutines.future.X0o0xo.oIX0oI(r2)
            if (r2 != 0) goto L26
            goto L27
        L26:
            r3 = r2
        L27:
            kotlin.Result$oIX0oI r2 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.I0oOoX.oIX0oI(r3)
            java.lang.Object r2 = kotlin.Result.m287constructorimpl(r2)
            r0.resumeWith(r2)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.XO.oIX0oI(java.lang.Object, java.lang.Throwable):void");
    }
}
