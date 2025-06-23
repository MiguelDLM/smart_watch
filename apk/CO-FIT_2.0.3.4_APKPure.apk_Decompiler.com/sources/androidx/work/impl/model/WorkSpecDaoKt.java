package androidx.work.impl.model;

import OXOo.OOXIXo;
import Oo0IXI0.oxoX;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import java.util.UUID;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

@XX({"SMAP\nWorkSpecDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,511:1\n53#2:512\n55#2:516\n53#2:517\n55#2:521\n50#3:513\n55#3:515\n50#3:518\n55#3:520\n107#4:514\n107#4:519\n*S KotlinDebug\n*F\n+ 1 WorkSpecDao.kt\nandroidx/work/impl/model/WorkSpecDaoKt\n*L\n475#1:512\n475#1:516\n491#1:517\n491#1:521\n475#1:513\n475#1:515\n491#1:518\n491#1:520\n475#1:514\n491#1:519\n*E\n"})
public final class WorkSpecDaoKt {
    @oxoX("sql")
    @OOXIXo
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    @oxoX("sql")
    @OOXIXo
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    @oxoX("sql")
    @OOXIXo
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    @OOXIXo
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    @OOXIXo
    public static final X0o0xo<List<WorkInfo>> dedup(@OOXIXo X0o0xo<? extends List<WorkSpec.WorkInfoPojo>> x0o0xo, @OOXIXo CoroutineDispatcher coroutineDispatcher) {
        IIX0o.x0xO0oo(x0o0xo, "<this>");
        IIX0o.x0xO0oo(coroutineDispatcher, "dispatcher");
        return Oxx0IOOO.xx0X0(Oxx0IOOO.Xo0(new WorkSpecDaoKt$dedup$$inlined$map$1(x0o0xo)), coroutineDispatcher);
    }

    @OOXIXo
    public static final X0o0xo<WorkInfo> getWorkStatusPojoFlowDataForIds(@OOXIXo WorkSpecDao workSpecDao, @OOXIXo UUID uuid) {
        IIX0o.x0xO0oo(workSpecDao, "<this>");
        IIX0o.x0xO0oo(uuid, "id");
        return Oxx0IOOO.Xo0(new WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1(workSpecDao.getWorkStatusPojoFlowDataForIds(oI0IIXIo.OOXIXo(String.valueOf(uuid)))));
    }

    @OOXIXo
    public static final X0o0xo<List<WorkInfo>> getWorkStatusPojoFlowForName(@OOXIXo WorkSpecDao workSpecDao, @OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo String str) {
        IIX0o.x0xO0oo(workSpecDao, "<this>");
        IIX0o.x0xO0oo(coroutineDispatcher, "dispatcher");
        IIX0o.x0xO0oo(str, "name");
        return dedup(workSpecDao.getWorkStatusPojoFlowForName(str), coroutineDispatcher);
    }

    @OOXIXo
    public static final X0o0xo<List<WorkInfo>> getWorkStatusPojoFlowForTag(@OOXIXo WorkSpecDao workSpecDao, @OOXIXo CoroutineDispatcher coroutineDispatcher, @OOXIXo String str) {
        IIX0o.x0xO0oo(workSpecDao, "<this>");
        IIX0o.x0xO0oo(coroutineDispatcher, "dispatcher");
        IIX0o.x0xO0oo(str, "tag");
        return dedup(workSpecDao.getWorkStatusPojoFlowForTag(str), coroutineDispatcher);
    }
}
