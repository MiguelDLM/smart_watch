package androidx.work.impl.constraints;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.oIX0oI;
import Oox.oOoXoXO;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
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
import com.garmin.fit.X0xOO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.I0oOoX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.X0o0xo;
import kotlinx.coroutines.flow.XO;
import kotlinx.coroutines.flow.internal.CombineKt;

@XX({"SMAP\nWorkConstraintsTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,205:1\n766#2:206\n857#2,2:207\n1549#2:209\n1620#2,3:210\n766#2:218\n857#2,2:219\n287#3:213\n288#3:216\n37#4,2:214\n107#5:217\n*S KotlinDebug\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n*L\n92#1:206\n92#1:207,2\n92#1:209\n92#1:210,3\n100#1:218\n100#1:219,2\n93#1:213\n93#1:216\n93#1:214,2\n93#1:217\n*E\n"})
/* loaded from: classes.dex */
public final class WorkConstraintsTracker {

    @OOXIXo
    private final List<ConstraintController> controllers;

    /* JADX WARN: Multi-variable type inference failed */
    public WorkConstraintsTracker(@OOXIXo List<? extends ConstraintController> controllers) {
        IIX0o.x0xO0oo(controllers, "controllers");
        this.controllers = controllers;
    }

    public final boolean areAllConstraintsMet(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "workSpec");
        List<ConstraintController> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).isCurrentlyConstrained(workSpec)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.get().debug(WorkConstraintsTrackerKt.access$getTAG$p(), "Work " + workSpec.id + " constrained by " + CollectionsKt___CollectionsKt.OoIXo(arrayList, null, null, null, 0, null, new oOoXoXO<ConstraintController, CharSequence>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1
                @Override // Oox.oOoXoXO
                public final CharSequence invoke(ConstraintController it) {
                    IIX0o.x0xO0oo(it, "it");
                    String simpleName = it.getClass().getSimpleName();
                    IIX0o.oO(simpleName, "it.javaClass.simpleName");
                    return simpleName;
                }
            }, 31, null));
        }
        return arrayList.isEmpty();
    }

    @OOXIXo
    public final X0o0xo<ConstraintsState> track(@OOXIXo WorkSpec spec) {
        IIX0o.x0xO0oo(spec, "spec");
        List<ConstraintController> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).hasConstraint(spec)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ConstraintController) it.next()).track(spec.constraints));
        }
        final X0o0xo[] x0o0xoArr = (X0o0xo[]) CollectionsKt___CollectionsKt.oOo0o(arrayList2).toArray(new X0o0xo[0]);
        return Oxx0IOOO.Xo0(new X0o0xo<ConstraintsState>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

            @oxoX(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", i = {}, l = {X0xOO.f13752xoX}, m = "invokeSuspend", n = {}, s = {})
            @XX({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2\n+ 2 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,332:1\n94#2:333\n1282#3,2:334\n*S KotlinDebug\n*F\n+ 1 WorkConstraintsTracker.kt\nandroidx/work/impl/constraints/WorkConstraintsTracker\n*L\n94#1:334,2\n*E\n"})
            /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements IXxxXO<XO<? super ConstraintsState>, ConstraintsState[], I0Io<? super oXIO0o0XI>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(I0Io i0Io) {
                    super(3, i0Io);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @OXOo.oOoXoXO
                public final Object invokeSuspend(@OOXIXo Object obj) {
                    ConstraintsState constraintsState;
                    Object oOoXoXO2 = II0xO0.oOoXoXO();
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            I0oOoX.x0XOIxOo(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        I0oOoX.x0XOIxOo(obj);
                        XO xo2 = (XO) this.L$0;
                        ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                        int length = constraintsStateArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                constraintsState = constraintsStateArr[i2];
                                if (!IIX0o.Oxx0IOOO(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                                    break;
                                }
                                i2++;
                            } else {
                                constraintsState = null;
                                break;
                            }
                        }
                        if (constraintsState == null) {
                            constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                        }
                        this.label = 1;
                        if (xo2.emit(constraintsState, this) == oOoXoXO2) {
                            return oOoXoXO2;
                        }
                    }
                    return oXIO0o0XI.f29392oIX0oI;
                }

                @Override // Oox.IXxxXO
                @OXOo.oOoXoXO
                public final Object invoke(@OOXIXo XO<? super ConstraintsState> xo2, @OOXIXo ConstraintsState[] constraintsStateArr, @OXOo.oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(i0Io);
                    anonymousClass3.L$0 = xo2;
                    anonymousClass3.L$1 = constraintsStateArr;
                    return anonymousClass3.invokeSuspend(oXIO0o0XI.f29392oIX0oI);
                }
            }

            @Override // kotlinx.coroutines.flow.X0o0xo
            @OXOo.oOoXoXO
            public Object collect(@OOXIXo XO<? super ConstraintsState> xo2, @OOXIXo I0Io i0Io) {
                final X0o0xo[] x0o0xoArr2 = x0o0xoArr;
                Object oIX0oI2 = CombineKt.oIX0oI(xo2, x0o0xoArr2, new oIX0oI<ConstraintsState[]>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    @OXOo.oOoXoXO
                    public final ConstraintsState[] invoke() {
                        return new ConstraintsState[x0o0xoArr2.length];
                    }
                }, new AnonymousClass3(null), i0Io);
                if (oIX0oI2 == II0xO0.oOoXoXO()) {
                    return oIX0oI2;
                }
                return oXIO0o0XI.f29392oIX0oI;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(@OOXIXo Trackers trackers) {
        this((List<? extends ConstraintController>) CollectionsKt__CollectionsKt.xII(new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker()), Build.VERSION.SDK_INT >= 28 ? WorkConstraintsTrackerKt.NetworkRequestConstraintController(trackers.getContext()) : null));
        IIX0o.x0xO0oo(trackers, "trackers");
    }
}
