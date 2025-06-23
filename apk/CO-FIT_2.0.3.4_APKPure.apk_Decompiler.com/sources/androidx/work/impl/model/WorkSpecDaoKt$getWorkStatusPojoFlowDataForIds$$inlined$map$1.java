package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.WorkInfo;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.XO;

@XX({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
public final class WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1 implements X0o0xo<WorkInfo> {
    final /* synthetic */ X0o0xo $this_unsafeTransform$inlined;

    public WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1(X0o0xo x0o0xo) {
        this.$this_unsafeTransform$inlined = x0o0xo;
    }

    @oOoXoXO
    public Object collect(@OOXIXo final XO xo2, @OOXIXo I0Io i0Io) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new XO() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @OXOo.oOoXoXO
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, @OXOo.OOXIXo kotlin.coroutines.I0Io r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.I0oOoX.x0XOIxOo(r6)
                    goto L_0x004f
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.I0oOoX.x0XOIxOo(r6)
                    kotlinx.coroutines.flow.XO r6 = r3
                    java.util.List r5 = (java.util.List) r5
                    java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.XxXX(r5)
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r5 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r5
                    if (r5 == 0) goto L_0x0045
                    androidx.work.WorkInfo r5 = r5.toWorkInfo()
                    goto L_0x0046
                L_0x0045:
                    r5 = 0
                L_0x0046:
                    r0.label = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x004f
                    return r1
                L_0x004f:
                    kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f19155oIX0oI
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
            }
        }, i0Io);
        if (collect == II0xO0.oOoXoXO()) {
            return collect;
        }
        return oXIO0o0XI.f19155oIX0oI;
    }
}
