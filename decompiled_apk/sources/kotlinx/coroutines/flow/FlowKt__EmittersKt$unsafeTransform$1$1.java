package kotlinx.coroutines.flow;

import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n*L\n1#1,222:1\n*E\n"})
/* loaded from: classes6.dex */
public final class FlowKt__EmittersKt$unsafeTransform$1$1<T> implements XO {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ XO<R> f30000Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Oox.IXxxXO<XO<? super R>, T, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30001XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$unsafeTransform$1$1(Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, XO<? super R> xo2) {
        this.f30001XO = iXxxXO;
        this.f30000Oo = xo2;
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
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.I0oOoX.x0XOIxOo(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.I0oOoX.x0XOIxOo(r6)
            Oox.IXxxXO<kotlinx.coroutines.flow.XO<? super R>, T, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, java.lang.Object> r6 = r4.f30001XO
            kotlinx.coroutines.flow.XO<R> r2 = r4.f30000Oo
            r0.label = r3
            java.lang.Object r5 = r6.invoke(r2, r5, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.oOoXoXO
    public final Object oIX0oI(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        xxX.X0o0xo(4);
        new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, i0Io);
        xxX.X0o0xo(5);
        this.f30001XO.invoke(this.f30000Oo, t, i0Io);
        return oXIO0o0XI.f29392oIX0oI;
    }
}
