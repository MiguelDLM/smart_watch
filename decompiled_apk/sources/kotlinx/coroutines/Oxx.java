package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

@kotlin.jvm.internal.XX({"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,314:1\n1#2:315\n107#3,13:316\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n269#1:316,13\n*E\n"})
/* loaded from: classes6.dex */
public final class Oxx<T> extends kotlinx.coroutines.internal.Xx000oIo<T> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ThreadLocal<Pair<CoroutineContext, Object>> f29746oI0IIXIo;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Oxx(@OXOo.OOXIXo kotlin.coroutines.CoroutineContext r3, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.oXIoO r0 = kotlinx.coroutines.oXIoO.f30345XO
            kotlin.coroutines.CoroutineContext$oIX0oI r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f29746oI0IIXIo = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.oxoX$II0xO0 r0 = kotlin.coroutines.oxoX.f29196Oxx0IOOO
            kotlin.coroutines.CoroutineContext$oIX0oI r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.I0Io(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.oIX0oI(r3, r4)
            r2.OIx00oxx(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.Oxx.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.I0Io):void");
    }

    public final void OIx00oxx(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO Object obj) {
        this.threadLocalIsSet = true;
        this.f29746oI0IIXIo.set(kotlin.Xo0.oIX0oI(coroutineContext, obj));
    }

    @Override // kotlinx.coroutines.internal.Xx000oIo, kotlinx.coroutines.oIX0oI
    public void OX(@OXOo.oOoXoXO Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.f29746oI0IIXIo.get();
            if (pair != null) {
                ThreadContextKt.oIX0oI(pair.component1(), pair.component2());
            }
            this.f29746oI0IIXIo.remove();
        }
        Object oIX0oI2 = xI.oIX0oI(obj, this.f30289Oxx0xo);
        kotlin.coroutines.I0Io<T> i0Io = this.f30289Oxx0xo;
        CoroutineContext context = i0Io.getContext();
        Oxx<?> oxx = null;
        Object I0Io2 = ThreadContextKt.I0Io(context, null);
        if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
            oxx = CoroutineContextKt.Oxx0IOOO(i0Io, context, I0Io2);
        }
        try {
            this.f30289Oxx0xo.resumeWith(oIX0oI2);
            kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
        } finally {
            if (oxx == null || oxx.OooI()) {
                ThreadContextKt.oIX0oI(context, I0Io2);
            }
        }
    }

    public final boolean OooI() {
        boolean z;
        if (this.threadLocalIsSet && this.f29746oI0IIXIo.get() == null) {
            z = true;
        } else {
            z = false;
        }
        this.f29746oI0IIXIo.remove();
        return !z;
    }
}
