package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@IXIxx0.oxoX(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {956, 958}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
@kotlin.jvm.internal.XX({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n958#1:1455,6\n*E\n"})
/* loaded from: classes6.dex */
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Oox.x0xO0oo<kotlin.sequences.oO<? super oXIO0o0XI>, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, kotlin.coroutines.I0Io<? super JobSupport$children$1> i0Io) {
        super(2, i0Io);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> create(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, i0Io);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0069  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x006b -> B:6:0x0081). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007e -> B:6:0x0081). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L26
            if (r1 != r2) goto L1e
            java.lang.Object r1 = r6.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r6.L$1
            kotlinx.coroutines.internal.xoXoI r3 = (kotlinx.coroutines.internal.xoXoI) r3
            java.lang.Object r4 = r6.L$0
            kotlin.sequences.oO r4 = (kotlin.sequences.oO) r4
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L81
        L1e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L26:
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L86
        L2a:
            kotlin.I0oOoX.x0XOIxOo(r7)
            java.lang.Object r7 = r6.L$0
            kotlin.sequences.oO r7 = (kotlin.sequences.oO) r7
            kotlinx.coroutines.JobSupport r1 = r6.this$0
            java.lang.Object r1 = r1.oXIO0o0XI()
            boolean r4 = r1 instanceof kotlinx.coroutines.xoXoI
            if (r4 == 0) goto L48
            kotlinx.coroutines.xoXoI r1 = (kotlinx.coroutines.xoXoI) r1
            kotlinx.coroutines.o00 r1 = r1.f30490oI0IIXIo
            r6.label = r3
            java.lang.Object r7 = r7.II0xO0(r1, r6)
            if (r7 != r0) goto L86
            return r0
        L48:
            boolean r3 = r1 instanceof kotlinx.coroutines.ooOx
            if (r3 == 0) goto L86
            kotlinx.coroutines.ooOx r1 = (kotlinx.coroutines.ooOx) r1
            kotlinx.coroutines.XIXIxO r1 = r1.getList()
            if (r1 == 0) goto L86
            java.lang.Object r3 = r1.OOXIXo()
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, r4)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r7
            r5 = r3
            r3 = r1
            r1 = r5
        L63:
            boolean r7 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r7 != 0) goto L86
            boolean r7 = r1 instanceof kotlinx.coroutines.xoXoI
            if (r7 == 0) goto L81
            r7 = r1
            kotlinx.coroutines.xoXoI r7 = (kotlinx.coroutines.xoXoI) r7
            kotlinx.coroutines.o00 r7 = r7.f30490oI0IIXIo
            r6.L$0 = r4
            r6.L$1 = r3
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r7 = r4.II0xO0(r7, r6)
            if (r7 != r0) goto L81
            return r0
        L81:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.oOoXoXO()
            goto L63
        L86:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // Oox.x0xO0oo
    @OXOo.oOoXoXO
    public final Object invoke(@OXOo.OOXIXo kotlin.sequences.oO<? super oXIO0o0XI> oOVar, @OXOo.oOoXoXO kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        return ((JobSupport$children$1) create(oOVar, i0Io)).invokeSuspend(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
