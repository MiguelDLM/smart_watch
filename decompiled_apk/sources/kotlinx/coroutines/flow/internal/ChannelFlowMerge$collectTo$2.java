package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public final class ChannelFlowMerge$collectTo$2<T> implements kotlinx.coroutines.flow.XO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final /* synthetic */ IXxxXO<T> f30160IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.sync.II0xO0 f30161Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final /* synthetic */ ooOOo0oXI<T> f30162Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ oXIO0o0XI f30163XO;

    @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, Object> {
        final /* synthetic */ ooOOo0oXI<T> $collector;
        final /* synthetic */ kotlinx.coroutines.flow.X0o0xo<T> $inner;
        final /* synthetic */ kotlinx.coroutines.sync.II0xO0 $semaphore;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo, ooOOo0oXI<T> ooooo0oxi, kotlinx.coroutines.sync.II0xO0 iI0xO0, kotlin.coroutines.I0Io<? super AnonymousClass1> i0Io) {
            super(2, i0Io);
            this.$inner = x0o0xo;
            this.$collector = ooooo0oxi;
            this.$semaphore = iI0xO0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.OOXIXo
        public final kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
            return new AnonymousClass1(this.$inner, this.$collector, this.$semaphore, i0Io);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @OXOo.oOoXoXO
        public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
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
                    kotlinx.coroutines.flow.X0o0xo<T> x0o0xo = this.$inner;
                    ooOOo0oXI<T> ooooo0oxi = this.$collector;
                    this.label = 1;
                    if (x0o0xo.collect(ooooo0oxi, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                }
                this.$semaphore.release();
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                this.$semaphore.release();
                throw th;
            }
        }

        @Override // Oox.x0xO0oo
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(xii, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2(oXIO0o0XI oxio0o0xi, kotlinx.coroutines.sync.II0xO0 iI0xO0, IXxxXO<? super T> iXxxXO, ooOOo0oXI<T> ooooo0oxi) {
        this.f30163XO = oxio0o0xi;
        this.f30161Oo = iI0xO0;
        this.f30160IXxxXO = iXxxXO;
        this.f30162Oxx0xo = ooooo0oxi;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> r8, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.X0o0xo r8 = (kotlinx.coroutines.flow.X0o0xo) r8
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2) r0
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L53
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.I0oOoX.x0XOIxOo(r9)
            kotlinx.coroutines.oXIO0o0XI r9 = r7.f30163XO
            if (r9 == 0) goto L43
            kotlinx.coroutines.IIX0.X0IIOO(r9)
        L43:
            kotlinx.coroutines.sync.II0xO0 r9 = r7.f30161Oo
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.I0Io(r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            r0 = r7
        L53:
            kotlinx.coroutines.channels.IXxxXO<T> r1 = r0.f30160IXxxXO
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1
            kotlinx.coroutines.flow.internal.ooOOo0oXI<T> r9 = r0.f30162Oxx0xo
            kotlinx.coroutines.sync.II0xO0 r0 = r0.f30161Oo
            r2 = 0
            r4.<init>(r8, r9, r0, r2)
            r5 = 3
            r6 = 0
            r3 = 0
            kotlinx.coroutines.II0XooXoX.X0o0xo(r1, r2, r3, r4, r5, r6)
            kotlin.oXIO0o0XI r8 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2.emit(kotlinx.coroutines.flow.X0o0xo, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
