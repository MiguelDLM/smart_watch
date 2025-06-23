package androidx.work.impl.constraints;

import OXOo.OOXIXo;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;

@XX({"SMAP\nWorkConstraintsTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,205:1\n766#2:206\n857#2,2:207\n1549#2:209\n1620#2,3:210\n766#2:218\n857#2,2:219\n287#3:213\n288#3:216\n37#4,2:214\n107#5:217\n*S KotlinDebug\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n*L\n92#1:206\n92#1:207,2\n92#1:209\n92#1:210,3\n100#1:218\n100#1:219,2\n93#1:213\n93#1:216\n93#1:214,2\n93#1:217\n*E\n"})
public final class WorkConstraintsTracker {
    @OOXIXo
    private final List<ConstraintController> controllers;

    public WorkConstraintsTracker(@OOXIXo List<? extends ConstraintController> list) {
        IIX0o.x0xO0oo(list, "controllers");
        this.controllers = list;
    }

    public final boolean areAllConstraintsMet(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.controllers) {
            if (((ConstraintController) next).isCurrentlyConstrained(workSpec)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkConstraintsTrackerKt.TAG;
            logger.debug(access$getTAG$p, "Work " + workSpec.id + " constrained by " + CollectionsKt___CollectionsKt.OoIXo(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, WorkConstraintsTracker$areAllConstraintsMet$1.INSTANCE, 31, (Object) null));
        }
        return arrayList.isEmpty();
    }

    @OOXIXo
    public final X0o0xo<ConstraintsState> track(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "spec");
        ArrayList<ConstraintController> arrayList = new ArrayList<>();
        for (Object next : this.controllers) {
            if (((ConstraintController) next).hasConstraint(workSpec)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
        for (ConstraintController track : arrayList) {
            arrayList2.add(track.track(workSpec.constraints));
        }
        return Oxx0IOOO.Xo0(new WorkConstraintsTracker$track$$inlined$combine$1((X0o0xo[]) CollectionsKt___CollectionsKt.oOo0o(arrayList2).toArray(new X0o0xo[0])));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(@OOXIXo Trackers trackers) {
        this((List<? extends ConstraintController>) CollectionsKt__CollectionsKt.xII(new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker()), Build.VERSION.SDK_INT >= 28 ? WorkConstraintsTrackerKt.NetworkRequestConstraintController(trackers.getContext()) : null));
        IIX0o.x0xO0oo(trackers, "trackers");
    }
}
