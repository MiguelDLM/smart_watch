package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class FlowKt__ReduceKt$reduce$2<T> implements XO {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.IXxxXO<S, T, kotlin.coroutines.I0Io<? super S>, Object> f30053Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f30054XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$reduce$2(Ref.ObjectRef<Object> objectRef, Oox.IXxxXO<? super S, ? super T, ? super kotlin.coroutines.I0Io<? super S>, ? extends Object> iXxxXO) {
        this.f30054XO = objectRef;
        this.f30053Oo = iXxxXO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r7, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L50
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.I0oOoX.x0XOIxOo(r8)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r8 = r6.f30054XO
            T r2 = r8.element
            kotlinx.coroutines.internal.x0o r4 = kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI
            if (r2 == r4) goto L53
            Oox.IXxxXO<S, T, kotlin.coroutines.I0Io<? super S>, java.lang.Object> r4 = r6.f30053Oo
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r4.invoke(r2, r7, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            r5 = r8
            r8 = r7
            r7 = r5
        L50:
            r5 = r8
            r8 = r7
            r7 = r5
        L53:
            r8.element = r7
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
