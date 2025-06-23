package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements XO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final /* synthetic */ XO<T> f30096IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Oox.IXxxXO<T, T, kotlin.coroutines.I0Io<? super T>, Object> f30097Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f30098XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, Oox.IXxxXO<? super T, ? super T, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> iXxxXO, XO<? super T> xo2) {
        this.f30098XO = objectRef;
        this.f30097Oo = iXxxXO;
        this.f30096IXxxXO = xo2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r8, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L79
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1) r2
            kotlin.I0oOoX.x0XOIxOo(r9)
            goto L60
        L40:
            kotlin.I0oOoX.x0XOIxOo(r9)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r7.f30098XO
            T r2 = r9.element
            kotlinx.coroutines.internal.x0o r5 = kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI
            if (r2 != r5) goto L4d
            r2 = r7
            goto L63
        L4d:
            Oox.IXxxXO<T, T, kotlin.coroutines.I0Io<? super T>, java.lang.Object> r5 = r7.f30097Oo
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r5.invoke(r2, r8, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            r2 = r7
            r6 = r9
            r9 = r8
            r8 = r6
        L60:
            r6 = r9
            r9 = r8
            r8 = r6
        L63:
            r9.element = r8
            kotlinx.coroutines.flow.XO<T> r8 = r2.f30096IXxxXO
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r2.f30098XO
            T r9 = r9.element
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L79
            return r1
        L79:
            kotlin.oXIO0o0XI r8 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
