package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class FlowKt__LimitKt$take$2$1<T> implements XO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final /* synthetic */ XO<T> f30027IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ int f30028Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f30029XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$take$2$1(Ref.IntRef intRef, int i, XO<? super T> xo2) {
        this.f30029XO = intRef;
        this.f30028Oo = i;
        this.f30027IXxxXO = xo2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r6, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L5f
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L51
        L38:
            kotlin.I0oOoX.x0XOIxOo(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f30029XO
            int r2 = r7.element
            int r2 = r2 + r4
            r7.element = r2
            int r7 = r5.f30028Oo
            if (r2 >= r7) goto L54
            kotlinx.coroutines.flow.XO<T> r7 = r5.f30027IXxxXO
            r0.label = r4
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        L54:
            kotlinx.coroutines.flow.XO<T> r7 = r5.f30027IXxxXO
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt__LimitKt.oIX0oI(r7, r6, r0)
            if (r6 != r1) goto L5f
            return r1
        L5f:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
