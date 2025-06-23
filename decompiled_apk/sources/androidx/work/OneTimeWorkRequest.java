package androidx.work;

import XO0OX.x0XOIxOo;
import android.os.Build;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

/* loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass) {
            super(workerClass);
            IIX0o.x0xO0oo(workerClass, "workerClass");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        @OXOo.OOXIXo
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setInputMerger(@OXOo.OOXIXo Class<? extends InputMerger> inputMerger) {
            IIX0o.x0xO0oo(inputMerger, "inputMerger");
            WorkSpec workSpec$work_runtime_release = getWorkSpec$work_runtime_release();
            String name = inputMerger.getName();
            IIX0o.oO(name, "inputMerger.name");
            workSpec$work_runtime_release.inputMergerClassName = name;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@OXOo.OOXIXo kotlin.reflect.oxoX<? extends ListenableWorker> workerClass) {
            this((Class<? extends ListenableWorker>) XO0OX.II0xO0.X0o0xo(workerClass));
            IIX0o.x0xO0oo(workerClass, "workerClass");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.work.WorkRequest.Builder
        @OXOo.OOXIXo
        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() && Build.VERSION.SDK_INT >= 23 && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new OneTimeWorkRequest(this);
        }
    }

    @XX({"SMAP\nOneTimeWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequest$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1549#2:113\n1620#2,3:114\n*S KotlinDebug\n*F\n+ 1 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequest$Companion\n*L\n98#1:113\n98#1:114,3\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final OneTimeWorkRequest from(@OXOo.OOXIXo Class<? extends ListenableWorker> workerClass) {
            IIX0o.x0xO0oo(workerClass, "workerClass");
            return new Builder(workerClass).build();
        }

        private Companion() {
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final List<OneTimeWorkRequest> from(@OXOo.OOXIXo List<? extends Class<? extends ListenableWorker>> workerClasses) {
            IIX0o.x0xO0oo(workerClasses, "workerClasses");
            List<? extends Class<? extends ListenableWorker>> list = workerClasses;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Builder((Class<? extends ListenableWorker>) it.next()).build());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneTimeWorkRequest(@OXOo.OOXIXo Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        IIX0o.x0xO0oo(builder, "builder");
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final OneTimeWorkRequest from(@OXOo.OOXIXo Class<? extends ListenableWorker> cls) {
        return Companion.from(cls);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final List<OneTimeWorkRequest> from(@OXOo.OOXIXo List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }
}
