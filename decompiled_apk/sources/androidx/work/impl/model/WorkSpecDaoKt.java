package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import java.util.UUID;
import kotlin.collections.oI0IIXIo;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;

@XX({"SMAP\nWorkSpecDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,511:1\n53#2:512\n55#2:516\n53#2:517\n55#2:521\n50#3:513\n55#3:515\n50#3:518\n55#3:520\n107#4:514\n107#4:519\n*S KotlinDebug\n*F\n+ 1 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n*L\n475#1:512\n475#1:516\n491#1:517\n491#1:521\n475#1:513\n475#1:515\n491#1:518\n491#1:520\n475#1:514\n491#1:519\n*E\n"})
/* loaded from: classes.dex */
public final class WorkSpecDaoKt {

    @OOXIXo
    @Oo0IXI0.oxoX("sql")
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";

    @OOXIXo
    @Oo0IXI0.oxoX("sql")
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";

    @OOXIXo
    @Oo0IXI0.oxoX("sql")
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";

    @OOXIXo
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    @OOXIXo
    public static final kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> dedup(@OOXIXo final kotlinx.coroutines.flow.X0o0xo<? extends List<WorkSpec.WorkInfoPojo>> x0o0xo, @OOXIXo CoroutineDispatcher dispatcher) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        return kotlinx.coroutines.flow.Oxx0IOOO.xx0X0(kotlinx.coroutines.flow.Oxx0IOOO.Xo0(new kotlinx.coroutines.flow.X0o0xo<List<? extends WorkInfo>>() { // from class: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,222:1\n54#2:223\n491#3:224\n1549#4:225\n1620#4,3:226\n*S KotlinDebug\n*F\n+ 1 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n*L\n491#1:225\n491#1:226,3\n*E\n"})
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.XO {
                final /* synthetic */ kotlinx.coroutines.flow.XO $this_unsafeFlow;

                @IXIxx0.oxoX(c = "androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2", f = "WorkSpecDao.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.I0Io i0Io) {
                        super(i0Io);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @oOoXoXO
                    public final Object invokeSuspend(@OOXIXo Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.XO xo2) {
                    this.$this_unsafeFlow = xo2;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, @OXOo.OOXIXo kotlin.coroutines.I0Io r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.I0oOoX.x0XOIxOo(r7)
                        goto L66
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.I0oOoX.x0XOIxOo(r7)
                        kotlinx.coroutines.flow.XO r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        java.lang.Iterable r6 = (java.lang.Iterable) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.OxxIIOOXO.xo0x(r6, r4)
                        r2.<init>(r4)
                        java.util.Iterator r6 = r6.iterator()
                    L49:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L5d
                        java.lang.Object r4 = r6.next()
                        androidx.work.impl.model.WorkSpec$WorkInfoPojo r4 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r4
                        androidx.work.WorkInfo r4 = r4.toWorkInfo()
                        r2.add(r4)
                        goto L49
                    L5d:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L66
                        return r1
                    L66:
                        kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @oOoXoXO
            public Object collect(@OOXIXo kotlinx.coroutines.flow.XO<? super List<? extends WorkInfo>> xo2, @OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object collect = kotlinx.coroutines.flow.X0o0xo.this.collect(new AnonymousClass2(xo2), i0Io);
                if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return collect;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        }), dispatcher);
    }

    @OOXIXo
    public static final kotlinx.coroutines.flow.X0o0xo<WorkInfo> getWorkStatusPojoFlowDataForIds(@OOXIXo WorkSpecDao workSpecDao, @OOXIXo UUID id) {
        IIX0o.x0xO0oo(workSpecDao, "<this>");
        IIX0o.x0xO0oo(id, "id");
        final kotlinx.coroutines.flow.X0o0xo<List<WorkSpec.WorkInfoPojo>> workStatusPojoFlowDataForIds = workSpecDao.getWorkStatusPojoFlowDataForIds(oI0IIXIo.OOXIXo(String.valueOf(id)));
        return kotlinx.coroutines.flow.Oxx0IOOO.Xo0(new kotlinx.coroutines.flow.X0o0xo<WorkInfo>() { // from class: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1

            @XX({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n*L\n1#1,222:1\n54#2:223\n475#3:224\n*E\n"})
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.XO {
                final /* synthetic */ kotlinx.coroutines.flow.XO $this_unsafeFlow;

                @IXIxx0.oxoX(c = "androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2", f = "WorkSpecDao.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.I0Io i0Io) {
                        super(i0Io);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @oOoXoXO
                    public final Object invokeSuspend(@OOXIXo Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.XO xo2) {
                    this.$this_unsafeFlow = xo2;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.XO
                @OXOo.oOoXoXO
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, @OXOo.OOXIXo kotlin.coroutines.I0Io r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.I0oOoX.x0XOIxOo(r6)
                        goto L4f
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.I0oOoX.x0XOIxOo(r6)
                        kotlinx.coroutines.flow.XO r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.XxXX(r5)
                        androidx.work.impl.model.WorkSpec$WorkInfoPojo r5 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r5
                        if (r5 == 0) goto L45
                        androidx.work.WorkInfo r5 = r5.toWorkInfo()
                        goto L46
                    L45:
                        r5 = 0
                    L46:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @oOoXoXO
            public Object collect(@OOXIXo kotlinx.coroutines.flow.XO<? super WorkInfo> xo2, @OOXIXo kotlin.coroutines.I0Io i0Io) {
                Object collect = kotlinx.coroutines.flow.X0o0xo.this.collect(new AnonymousClass2(xo2), i0Io);
                if (collect == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    return collect;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        });
    }

    @OOXIXo
    public static final kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> getWorkStatusPojoFlowForName(@OOXIXo WorkSpecDao workSpecDao, @OOXIXo CoroutineDispatcher dispatcher, @OOXIXo String name) {
        IIX0o.x0xO0oo(workSpecDao, "<this>");
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        IIX0o.x0xO0oo(name, "name");
        return dedup(workSpecDao.getWorkStatusPojoFlowForName(name), dispatcher);
    }

    @OOXIXo
    public static final kotlinx.coroutines.flow.X0o0xo<List<WorkInfo>> getWorkStatusPojoFlowForTag(@OOXIXo WorkSpecDao workSpecDao, @OOXIXo CoroutineDispatcher dispatcher, @OOXIXo String tag) {
        IIX0o.x0xO0oo(workSpecDao, "<this>");
        IIX0o.x0xO0oo(dispatcher, "dispatcher");
        IIX0o.x0xO0oo(tag, "tag");
        return dedup(workSpecDao.getWorkStatusPojoFlowForTag(tag), dispatcher);
    }
}
