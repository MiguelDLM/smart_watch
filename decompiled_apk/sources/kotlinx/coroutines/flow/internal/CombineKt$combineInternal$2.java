package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import Oox.x0xO0oo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.I0oOoX;
import kotlin.collections.xI;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.oI0IIXIo;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, 76, 79}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: classes6.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ Oox.oIX0oI<T[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.X0o0xo<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.XO<R> $this_combineInternal;
    final /* synthetic */ IXxxXO<kotlinx.coroutines.flow.XO<? super R>, T[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.X0o0xo<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.Oxx0IOOO<xI<Object>> $resultChannel;
        int label;

        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C11131<T> implements kotlinx.coroutines.flow.XO {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ int f30171Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.Oxx0IOOO<xI<Object>> f30172XO;

            public C11131(kotlinx.coroutines.channels.Oxx0IOOO<xI<Object>> oxx0IOOO, int i) {
                this.f30172XO = oxx0IOOO;
                this.f30171Oo = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
            @Override // kotlinx.coroutines.flow.XO
            @OXOo.oOoXoXO
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r7, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L38
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.I0oOoX.x0XOIxOo(r8)
                    goto L56
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    kotlin.I0oOoX.x0XOIxOo(r8)
                    goto L4d
                L38:
                    kotlin.I0oOoX.x0XOIxOo(r8)
                    kotlinx.coroutines.channels.Oxx0IOOO<kotlin.collections.xI<java.lang.Object>> r8 = r6.f30172XO
                    kotlin.collections.xI r2 = new kotlin.collections.xI
                    int r5 = r6.f30171Oo
                    r2.<init>(r5, r7)
                    r0.label = r4
                    java.lang.Object r7 = r8.XOxIOxOx(r2, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    r0.label = r3
                    java.lang.Object r7 = kotlinx.coroutines.OO0.oIX0oI(r0)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C11131.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.X0o0xo<? extends T>[] x0o0xoArr, int i, AtomicInteger atomicInteger, kotlinx.coroutines.channels.Oxx0IOOO<xI<Object>> oxx0IOOO, kotlin.coroutines.I0Io<? super AnonymousClass1> i0Io) {
            super(2, i0Io);
            this.$flows = x0o0xoArr;
            this.$i = i;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = oxx0IOOO;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.OOXIXo
        public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, i0Io);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.oOoXoXO
        public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
            AtomicInteger atomicInteger;
            Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        I0oOoX.x0XOIxOo(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    I0oOoX.x0XOIxOo(obj);
                    kotlinx.coroutines.flow.X0o0xo[] x0o0xoArr = this.$flows;
                    int i2 = this.$i;
                    kotlinx.coroutines.flow.X0o0xo x0o0xo = x0o0xoArr[i2];
                    C11131 c11131 = new C11131(this.$resultChannel, i2);
                    this.label = 1;
                    if (x0o0xo.collect(c11131, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    oI0IIXIo.oIX0oI.oIX0oI(this.$resultChannel, null, 1, null);
                }
                return oXIO0o0XI.f29392oIX0oI;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    oI0IIXIo.oIX0oI.oIX0oI(this.$resultChannel, null, 1, null);
                }
            }
        }

        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.X0o0xo<? extends T>[] x0o0xoArr, Oox.oIX0oI<T[]> oix0oi, IXxxXO<? super kotlinx.coroutines.flow.XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, kotlinx.coroutines.flow.XO<? super R> xo2, kotlin.coroutines.I0Io<? super CombineKt$combineInternal$2> i0Io) {
        super(2, i0Io);
        this.$flows = x0o0xoArr;
        this.$arrayFactory = oix0oi;
        this.$transform = iXxxXO;
        this.$this_combineInternal = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, i0Io);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ee A[EDGE_INSN: B:38:0x00ee->B:27:0x00ee BREAK  A[LOOP:0: B:19:0x00c9->B:37:?], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [kotlinx.coroutines.flow.X0o0xo<T>[], kotlinx.coroutines.flow.X0o0xo[]] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.X0o0xo<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0134 -> B:10:0x0136). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((CombineKt$combineInternal$2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
