package kotlinx.coroutines.flow;

import kotlin.I0oOoX;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
@XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6\n*L\n1#1,332:1\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__ZipKt$combineTransform$6<R> extends SuspendLambda implements Oox.x0xO0oo<XO<? super R>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
    final /* synthetic */ X0o0xo<T>[] $flows;
    final /* synthetic */ Oox.IXxxXO<XO<? super R>, T[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$1\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1<T> extends Lambda implements Oox.oIX0oI<T[]> {
        final /* synthetic */ X0o0xo<T>[] $flows;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(X0o0xo<? extends T>[] x0o0xoArr) {
            super(0);
            this.$flows = x0o0xoArr;
        }

        @Override // Oox.oIX0oI
        @OXOo.oOoXoXO
        public final T[] invoke() {
            int length = this.$flows.length;
            IIX0o.OxI(0, "T?");
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @IXIxx0.oxoX(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6$2\n*L\n1#1,332:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2<T> extends SuspendLambda implements Oox.IXxxXO<XO<? super R>, T[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> {
        final /* synthetic */ Oox.IXxxXO<XO<? super R>, T[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Oox.IXxxXO<? super XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, kotlin.coroutines.I0Io<? super AnonymousClass2> i0Io) {
            super(3, i0Io);
            this.$transform = iXxxXO;
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
                Oox.IXxxXO<XO<? super R>, T[], kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> iXxxXO = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (iXxxXO.invoke(xo2, objArr, this) == oOoXoXO2) {
                    return oOoXoXO2;
                }
            }
            return oXIO0o0XI.f29392oIX0oI;
        }

        @OXOo.oOoXoXO
        public final Object invokeSuspend$$forInline(@OXOo.OOXIXo Object obj) {
            this.$transform.invoke((XO) this.L$0, (Object[]) this.L$1, this);
            return oXIO0o0XI.f29392oIX0oI;
        }

        @Override // Oox.IXxxXO
        @OXOo.oOoXoXO
        public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.OOXIXo T[] tArr, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            IIX0o.xoXoI();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, i0Io);
            anonymousClass2.L$0 = xo2;
            anonymousClass2.L$1 = tArr;
            return anonymousClass2.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransform$6(X0o0xo<? extends T>[] x0o0xoArr, Oox.IXxxXO<? super XO<? super R>, ? super T[], ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, kotlin.coroutines.I0Io<? super FlowKt__ZipKt$combineTransform$6> i0Io) {
        super(2, i0Io);
        this.$flows = x0o0xoArr;
        this.$transform = iXxxXO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.$flows, this.$transform, i0Io);
        flowKt__ZipKt$combineTransform$6.L$0 = obj;
        return flowKt__ZipKt$combineTransform$6;
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
            X0o0xo<T>[] x0o0xoArr = this.$flows;
            IIX0o.xoXoI();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flows);
            IIX0o.xoXoI();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            this.label = 1;
            if (CombineKt.oIX0oI(xo2, x0o0xoArr, anonymousClass1, anonymousClass2, this) == oOoXoXO2) {
                return oOoXoXO2;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object invokeSuspend$$forInline(@OXOo.OOXIXo Object obj) {
        XO xo2 = (XO) this.L$0;
        X0o0xo<T>[] x0o0xoArr = this.$flows;
        IIX0o.xoXoI();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flows);
        IIX0o.xoXoI();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
        xxX.X0o0xo(0);
        CombineKt.oIX0oI(xo2, x0o0xoArr, anonymousClass1, anonymousClass2, this);
        xxX.X0o0xo(1);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo XO<? super R> xo2, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ((FlowKt__ZipKt$combineTransform$6) create(xo2, i0Io)).invokeSuspend(oXIO0o0XI.f29392oIX0oI);
    }
}
