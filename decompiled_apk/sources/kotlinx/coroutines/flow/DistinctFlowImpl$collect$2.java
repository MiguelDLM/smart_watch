package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class DistinctFlowImpl$collect$2<T> implements XO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final /* synthetic */ XO<T> f29961IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f29962Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl<T> f29963XO;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref.ObjectRef<Object> objectRef, XO<? super T> xo2) {
        this.f29963XO = distinctFlowImpl;
        this.f29962Oo = objectRef;
        this.f29961IXxxXO = xo2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r6, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L67
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.I0oOoX.x0XOIxOo(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.f29963XO
            Oox.oOoXoXO<T, java.lang.Object> r7 = r7.f29959Oo
            java.lang.Object r7 = r7.invoke(r6)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f29962Oo
            T r2 = r2.element
            kotlinx.coroutines.internal.x0o r4 = kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI
            if (r2 == r4) goto L58
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.f29963XO
            Oox.x0xO0oo<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f29958IXxxXO
            java.lang.Object r2 = r4.invoke(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L55
            goto L58
        L55:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        L58:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f29962Oo
            r2.element = r7
            kotlinx.coroutines.flow.XO<T> r7 = r5.f29961IXxxXO
            r0.label = r3
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L67
            return r1
        L67:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
