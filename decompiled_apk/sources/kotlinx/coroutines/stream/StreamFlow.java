package kotlinx.coroutines.stream;

import OXOo.OOXIXo;
import XO0OX.o00;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlinx.coroutines.flow.X0o0xo;

/* loaded from: classes6.dex */
public final class StreamFlow<T> implements X0o0xo<T> {

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public static final AtomicIntegerFieldUpdater f30430Oo = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final Stream<T> f30431XO;

    @o00
    private volatile int consumed = 0;

    public StreamFlow(@OOXIXo Stream<T> stream) {
        this.f30431XO = stream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #0 {all -> 0x0036, blocks: (B:11:0x0031, B:14:0x0056, B:16:0x005c), top: B:10:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> r7, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.stream.StreamFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = (kotlinx.coroutines.stream.StreamFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = new kotlinx.coroutines.stream.StreamFlow$collect$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.XO r2 = (kotlinx.coroutines.flow.XO) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.stream.StreamFlow r4 = (kotlinx.coroutines.stream.StreamFlow) r4
            kotlin.I0oOoX.x0XOIxOo(r8)     // Catch: java.lang.Throwable -> L36
            r8 = r2
            goto L56
        L36:
            r7 = move-exception
            goto L79
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.I0oOoX.x0XOIxOo(r8)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r8 = kotlinx.coroutines.stream.StreamFlow.f30430Oo
            r2 = 0
            boolean r8 = r8.compareAndSet(r6, r2, r3)
            if (r8 == 0) goto L7f
            java.util.stream.Stream<T> r8 = r6.f30431XO     // Catch: java.lang.Throwable -> L77
            java.util.Iterator r8 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IOo0.oIX0oI(r8)     // Catch: java.lang.Throwable -> L77
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L56:
            boolean r2 = r7.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r7.next()     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L36
            r0.label = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r2 = r8.emit(r2, r0)     // Catch: java.lang.Throwable -> L36
            if (r2 != r1) goto L56
            return r1
        L6f:
            java.util.stream.Stream<T> r7 = r4.f30431XO
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IOooo0o.oIX0oI(r7)
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        L77:
            r7 = move-exception
            r4 = r6
        L79:
            java.util.stream.Stream<T> r8 = r4.f30431XO
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IOooo0o.oIX0oI(r8)
            throw r7
        L7f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Stream.consumeAsFlow can be collected only once"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.StreamFlow.collect(kotlinx.coroutines.flow.XO, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
