package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class TimeoutKt {
    @OXOo.oOoXoXO
    public static final <T> Object I0Io(long j, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        if (j > 0) {
            Object II0xO02 = II0xO0(new XXXI(j, i0Io), x0xo0oo);
            if (II0xO02 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return II0xO02;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    public static final <U, T extends U> Object II0xO0(XXXI<U, ? super T> xxxi, Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo) {
        IIX0.OxI(xxxi, DelayKt.oxoX(xxxi.f30289Oxx0xo.getContext()).Oxx0xo(xxxi.f29779oI0IIXIo, xxxi, xxxi.getContext()));
        return o0xIoII.II0xO0.XO(xxxi, xxxi, x0xo0oo);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.XXXI] */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object X0o0xo(long r7, @OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.coroutines.xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends java.lang.Object> r9, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$0
            Oox.x0xO0oo r8 = (Oox.x0xO0oo) r8
            kotlin.I0oOoX.x0XOIxOo(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L32
            goto L6f
        L32:
            r8 = move-exception
            goto L70
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.I0oOoX.x0XOIxOo(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L46
            return r3
        L46:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.L$1 = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.J$0 = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r0.label = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            kotlinx.coroutines.XXXI r2 = new kotlinx.coroutines.XXXI     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            java.lang.Object r7 = II0xO0(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            java.lang.Object r8 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            if (r7 != r8) goto L6b
            IXIxx0.XO.I0Io(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L68
            goto L6b
        L68:
            r8 = move-exception
            r7 = r10
            goto L70
        L6b:
            if (r7 != r1) goto L6e
            return r1
        L6e:
            r10 = r7
        L6f:
            return r10
        L70:
            kotlinx.coroutines.oXIO0o0XI r9 = r8.coroutine
            T r7 = r7.element
            if (r9 != r7) goto L77
            return r3
        L77:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.X0o0xo(long, Oox.x0xO0oo, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.oOoXoXO
    public static final <T> Object XO(long j, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return X0o0xo(DelayKt.X0o0xo(j), x0xo0oo, i0Io);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r4 == null) goto L9;
     */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlinx.coroutines.TimeoutCancellationException oIX0oI(long r2, @OXOo.OOXIXo kotlinx.coroutines.XoX r4, @OXOo.OOXIXo kotlinx.coroutines.oXIO0o0XI r5) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.oxXx0IX
            if (r0 == 0) goto L7
            kotlinx.coroutines.oxXx0IX r4 = (kotlinx.coroutines.oxXx0IX) r4
            goto L8
        L7:
            r4 = 0
        L8:
            if (r4 == 0) goto L18
            kotlin.time.oxoX$oIX0oI r0 = kotlin.time.oxoX.f29647Oo
            kotlin.time.DurationUnit r0 = kotlin.time.DurationUnit.MILLISECONDS
            long r0 = kotlin.time.XO.xoIxX(r2, r0)
            java.lang.String r4 = r4.II0XooXoX(r0)
            if (r4 != 0) goto L2e
        L18:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Timed out waiting for "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L2e:
            kotlinx.coroutines.TimeoutCancellationException r2 = new kotlinx.coroutines.TimeoutCancellationException
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.oIX0oI(long, kotlinx.coroutines.XoX, kotlinx.coroutines.oXIO0o0XI):kotlinx.coroutines.TimeoutCancellationException");
    }

    @OXOo.oOoXoXO
    public static final <T> Object oxoX(long j, @OXOo.OOXIXo Oox.x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return I0Io(DelayKt.X0o0xo(j), x0xo0oo, i0Io);
    }
}
