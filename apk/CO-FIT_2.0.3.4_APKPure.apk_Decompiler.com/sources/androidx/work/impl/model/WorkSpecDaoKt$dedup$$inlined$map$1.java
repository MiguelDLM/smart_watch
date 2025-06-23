package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.WorkInfo;
import java.util.List;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.XO;

@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
public final class WorkSpecDaoKt$dedup$$inlined$map$1 implements X0o0xo<List<? extends WorkInfo>> {
    final /* synthetic */ X0o0xo $this_unsafeTransform$inlined;

    public WorkSpecDaoKt$dedup$$inlined$map$1(X0o0xo x0o0xo) {
        this.$this_unsafeTransform$inlined = x0o0xo;
    }

    @oOoXoXO
    public Object collect(@OOXIXo final XO xo2, @OOXIXo I0Io i0Io) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new XO() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @OXOo.oOoXoXO
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, @OXOo.OOXIXo kotlin.coroutines.I0Io r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.I0oOoX.x0XOIxOo(r7)
                    goto L_0x0066
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.I0oOoX.x0XOIxOo(r7)
                    kotlinx.coroutines.flow.XO r7 = r3
                    java.util.List r6 = (java.util.List) r6
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r4 = kotlin.collections.OxxIIOOXO.xo0x(r6, r4)
                    r2.<init>(r4)
                    java.util.Iterator r6 = r6.iterator()
                L_0x0049:
                    boolean r4 = r6.hasNext()
                    if (r4 == 0) goto L_0x005d
                    java.lang.Object r4 = r6.next()
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r4 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r4
                    androidx.work.WorkInfo r4 = r4.toWorkInfo()
                    r2.add(r4)
                    goto L_0x0049
                L_0x005d:
                    r0.label = r3
                    java.lang.Object r6 = r7.emit(r2, r0)
                    if (r6 != r1) goto L_0x0066
                    return r1
                L_0x0066:
                    kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f19155oIX0oI
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
            }
        }, i0Io);
        if (collect == II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f19155oIX0oI;
    }
}
