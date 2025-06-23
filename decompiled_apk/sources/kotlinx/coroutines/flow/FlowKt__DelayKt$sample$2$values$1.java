package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.oXIO0o0XI;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowKt__DelayKt$sample$2$values$1 extends SuspendLambda implements Oox.x0xO0oo<kotlinx.coroutines.channels.IXxxXO<? super Object>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ X0o0xo<T> $this_sample;
    private /* synthetic */ Object L$0;
    int label;

    /* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1<T> implements XO {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.IXxxXO<Object> f29985XO;

        public AnonymousClass1(kotlinx.coroutines.channels.IXxxXO<Object> iXxxXO) {
            this.f29985XO = iXxxXO;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.XO
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.I0oOoX.x0XOIxOo(r6)
                goto L43
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.I0oOoX.x0XOIxOo(r6)
                kotlinx.coroutines.channels.IXxxXO<java.lang.Object> r6 = r4.f29985XO
                if (r5 != 0) goto L3a
                kotlinx.coroutines.internal.x0o r5 = kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI
            L3a:
                r0.label = r3
                java.lang.Object r5 = r6.XOxIOxOx(r5, r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$values$1(X0o0xo<? extends T> x0o0xo, kotlin.coroutines.I0Io<? super FlowKt__DelayKt$sample$2$values$1> i0Io) {
        super(2, i0Io);
        this.$this_sample = x0o0xo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, i0Io);
        flowKt__DelayKt$sample$2$values$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$values$1;
    }

    @Override // Oox.x0xO0oo
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.IXxxXO<? super Object> iXxxXO, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return invoke2((kotlinx.coroutines.channels.IXxxXO<Object>) iXxxXO, i0Io);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object oOoXoXO2 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                I0oOoX.x0XOIxOo(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            I0oOoX.x0XOIxOo(obj);
            kotlinx.coroutines.channels.IXxxXO iXxxXO = (kotlinx.coroutines.channels.IXxxXO) this.L$0;
            X0o0xo<T> x0o0xo = this.$this_sample;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(iXxxXO);
            this.label = 1;
            if (x0o0xo.collect(anonymousClass1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@OXOo.OOXIXo kotlinx.coroutines.channels.IXxxXO<Object> iXxxXO, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__DelayKt$sample$2$values$1) create(iXxxXO, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
