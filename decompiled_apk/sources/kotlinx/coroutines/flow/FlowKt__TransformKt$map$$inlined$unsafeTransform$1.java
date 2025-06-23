package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [R] */
@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__TransformKt$map$$inlined$unsafeTransform$1<R> implements X0o0xo<R> {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.x0xO0oo f30075Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ X0o0xo f30076XO;

    @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n54#2:223\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2<T> implements XO {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.x0xO0oo f30077Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ XO f30078XO;

        @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
        @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        /* loaded from: classes6.dex */
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(kotlin.coroutines.I0Io i0Io) {
                super(i0Io);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(XO xo2, Oox.x0xO0oo x0xo0oo) {
            this.f30078XO = xo2;
            this.f30077Oo = x0xo0oo;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
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
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3c
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.I0oOoX.x0XOIxOo(r8)
                goto L5d
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.L$0
                kotlinx.coroutines.flow.XO r7 = (kotlinx.coroutines.flow.XO) r7
                kotlin.I0oOoX.x0XOIxOo(r8)
                goto L51
            L3c:
                kotlin.I0oOoX.x0XOIxOo(r8)
                kotlinx.coroutines.flow.XO r8 = r6.f30078XO
                Oox.x0xO0oo r2 = r6.f30077Oo
                r0.L$0 = r8
                r0.label = r4
                java.lang.Object r7 = r2.invoke(r7, r0)
                if (r7 != r1) goto L4e
                return r1
            L4e:
                r5 = r8
                r8 = r7
                r7 = r5
            L51:
                r2 = 0
                r0.L$0 = r2
                r0.label = r3
                java.lang.Object r7 = r7.emit(r8, r0)
                if (r7 != r1) goto L5d
                return r1
            L5d:
                kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @OXOo.oOoXoXO
        public final Object oIX0oI(Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
            xxX.X0o0xo(4);
            new AnonymousClass1(i0Io);
            xxX.X0o0xo(5);
            XO xo2 = this.f30078XO;
            Object invoke = this.f30077Oo.invoke(obj, i0Io);
            xxX.X0o0xo(0);
            xo2.emit(invoke, i0Io);
            xxX.X0o0xo(1);
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    public FlowKt__TransformKt$map$$inlined$unsafeTransform$1(X0o0xo x0o0xo, Oox.x0xO0oo x0xo0oo) {
        this.f30076XO = x0o0xo;
        this.f30075Oo = x0xo0oo;
    }

    @OXOo.oOoXoXO
    public Object XO(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
        xxX.X0o0xo(4);
        new ContinuationImpl(i0Io) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @OXOo.oOoXoXO
            public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$map$$inlined$unsafeTransform$1.this.collect(null, this);
            }
        };
        xxX.X0o0xo(5);
        X0o0xo x0o0xo = this.f30076XO;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(xo2, this.f30075Oo);
        xxX.X0o0xo(0);
        x0o0xo.collect(anonymousClass2, i0Io);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io i0Io) {
        Object collect = this.f30076XO.collect(new AnonymousClass2(xo2, this.f30075Oo), i0Io);
        if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }
}
