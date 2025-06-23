package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3<R> extends SuspendLambda implements Oox.x0xO0oo<XO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ X0o0xo[] $flows;
    final /* synthetic */ Oox.oI0IIXIo $transform$inlined;
    private /* synthetic */ Object L$0;
    int label;

    @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n139#2,6:333\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, Object[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
        final /* synthetic */ Oox.oI0IIXIo $transform$inlined;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(kotlin.coroutines.I0Io i0Io, Oox.oI0IIXIo oi0iixio) {
            super(3, i0Io);
            this.$transform$inlined = oi0iixio;
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
                XO xo2 = (XO) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                Oox.oI0IIXIo oi0iixio = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.label = 1;
                xxX.X0o0xo(6);
                Object invoke = oi0iixio.invoke(xo2, obj2, obj3, obj4, this);
                xxX.X0o0xo(7);
                if (invoke == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        }

        @Override // Oox.IXxxXO
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo Object[] objArr, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(i0Io, this.$transform$inlined);
            anonymousClass1.L$0 = xo2;
            anonymousClass1.L$1 = objArr;
            return anonymousClass1.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(X0o0xo[] x0o0xoArr, kotlin.coroutines.I0Io i0Io, Oox.oI0IIXIo oi0iixio) {
        super(2, i0Io);
        this.$flows = x0o0xoArr;
        this.$transform$inlined = oi0iixio;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(this.$flows, i0Io, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3;
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
            XO xo2 = (XO) this.L$0;
            X0o0xo[] x0o0xoArr = this.$flows;
            Oox.oIX0oI oIX0oI2 = FlowKt__ZipKt.oIX0oI();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, this.$transform$inlined);
            this.label = 1;
            if (CombineKt.oIX0oI(xo2, x0o0xoArr, oIX0oI2, anonymousClass1, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3) create(xo2, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
