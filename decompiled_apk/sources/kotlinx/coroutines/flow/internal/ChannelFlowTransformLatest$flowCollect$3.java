package kotlinx.coroutines.flow.internal;

import Oox.IXxxXO;
import Oox.x0xO0oo;
import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.xII;

@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.XO<R> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.XO {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ ChannelFlowTransformLatest<T, R> f30166IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ xII f30167Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.XO<R> f30168Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<kotlinx.coroutines.oXIO0o0XI> f30169XO;

        @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2, reason: invalid class name */
        /* loaded from: classes6.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements x0xO0oo<xII, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.XO<R> $collector;
            final /* synthetic */ T $value;
            int label;
            final /* synthetic */ ChannelFlowTransformLatest<T, R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.XO<? super R> xo2, T t, kotlin.coroutines.I0Io<? super AnonymousClass2> i0Io) {
                super(2, i0Io);
                this.this$0 = channelFlowTransformLatest;
                this.$collector = xo2;
                this.$value = t;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.OOXIXo
            public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
                return new AnonymousClass2(this.this$0, this.$collector, this.$value, i0Io);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                IXxxXO iXxxXO;
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
                    iXxxXO = this.this$0.f30165oI0IIXIo;
                    Object obj2 = this.$collector;
                    T t = this.$value;
                    this.label = 1;
                    if (iXxxXO.invoke(obj2, t, this) == oOoXoXO2) {
                        return oOoXoXO2;
                    }
                }
                return oXIO0o0XI.f29392oIX0oI;
            }

            @Override // Oox.x0xO0oo
            @OXOo.oOoXoXO
            public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
                return ((AnonymousClass2) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.ObjectRef<kotlinx.coroutines.oXIO0o0XI> objectRef, xII xii, ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.XO<? super R> xo2) {
            this.f30169XO = objectRef;
            this.f30167Oo = xii;
            this.f30166IXxxXO = channelFlowTransformLatest;
            this.f30168Oxx0xo = xo2;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.XO
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r8, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3b
                if (r2 != r3) goto L33
                java.lang.Object r8 = r0.L$2
                kotlinx.coroutines.oXIO0o0XI r8 = (kotlinx.coroutines.oXIO0o0XI) r8
                java.lang.Object r8 = r0.L$1
                java.lang.Object r0 = r0.L$0
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                kotlin.I0oOoX.x0XOIxOo(r9)
                goto L5e
            L33:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3b:
                kotlin.I0oOoX.x0XOIxOo(r9)
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.oXIO0o0XI> r9 = r7.f30169XO
                T r9 = r9.element
                kotlinx.coroutines.oXIO0o0XI r9 = (kotlinx.coroutines.oXIO0o0XI) r9
                if (r9 == 0) goto L5d
                kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                r2.<init>()
                r9.II0xO0(r2)
                r0.L$0 = r7
                r0.L$1 = r8
                r0.L$2 = r9
                r0.label = r3
                java.lang.Object r9 = r9.oOXoIIIo(r0)
                if (r9 != r1) goto L5d
                return r1
            L5d:
                r0 = r7
            L5e:
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.oXIO0o0XI> r9 = r0.f30169XO
                kotlinx.coroutines.xII r1 = r0.f30167Oo
                kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r2 = r0.f30166IXxxXO
                kotlinx.coroutines.flow.XO<R> r0 = r0.f30168Oxx0xo
                r5 = 0
                r4.<init>(r2, r0, r8, r5)
                r5 = 1
                r6 = 0
                r2 = 0
                kotlinx.coroutines.oXIO0o0XI r8 = kotlinx.coroutines.II0XooXoX.X0o0xo(r1, r2, r3, r4, r5, r6)
                r9.element = r8
                kotlin.oXIO0o0XI r8 = kotlin.oXIO0o0XI.f29392oIX0oI
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, kotlinx.coroutines.flow.XO<? super R> xo2, kotlin.coroutines.I0Io<? super ChannelFlowTransformLatest$flowCollect$3> i0Io) {
        super(2, i0Io);
        this.this$0 = channelFlowTransformLatest;
        this.$collector = xo2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.this$0, this.$collector, i0Io);
        channelFlowTransformLatest$flowCollect$3.L$0 = obj;
        return channelFlowTransformLatest$flowCollect$3;
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
            xII xii = (xII) this.L$0;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.this$0;
            kotlinx.coroutines.flow.X0o0xo<S> x0o0xo = channelFlowTransformLatest.f30164Oxx0xo;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(objectRef, xii, channelFlowTransformLatest, this.$collector);
            this.label = 1;
            if (x0o0xo.collect(anonymousClass1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo xII xii, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((ChannelFlowTransformLatest$flowCollect$3) create(xii, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
