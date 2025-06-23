package androidx.work;

import OXOo.OOXIXo;
import XO0OX.II0xO0;
import XO0OX.x0XOIxOo;
import android.os.Build;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.reflect.oxoX;

public final class OneTimeWorkRequest extends WorkRequest {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo Class<? extends ListenableWorker> cls) {
            super(cls);
            IIX0o.x0xO0oo(cls, "workerClass");
        }

        @OOXIXo
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @OOXIXo
        public final Builder setInputMerger(@OOXIXo Class<? extends InputMerger> cls) {
            IIX0o.x0xO0oo(cls, "inputMerger");
            WorkSpec workSpec$work_runtime_release = getWorkSpec$work_runtime_release();
            String name = cls.getName();
            IIX0o.oO(name, "inputMerger.name");
            workSpec$work_runtime_release.inputMergerClassName = name;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(@OOXIXo oxoX<? extends ListenableWorker> oxox) {
            this(II0xO0.X0o0xo(oxox));
            IIX0o.x0xO0oo(oxox, "workerClass");
        }

        @OOXIXo
        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if (!getBackoffCriteriaSet$work_runtime_release() || Build.VERSION.SDK_INT < 23 || !getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
    }

    @XX({"SMAP\nOneTimeWorkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequest$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1549#2:113\n1620#2,3:114\n*S KotlinDebug\n*F\n+ 1 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequest$Companion\n*L\n98#1:113\n98#1:114,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final OneTimeWorkRequest from(@OOXIXo Class<? extends ListenableWorker> cls) {
            IIX0o.x0xO0oo(cls, "workerClass");
            return (OneTimeWorkRequest) new Builder(cls).build();
        }

        private Companion() {
        }

        @x0XOIxOo
        @OOXIXo
        public final List<OneTimeWorkRequest> from(@OOXIXo List<? extends Class<? extends ListenableWorker>> list) {
            IIX0o.x0xO0oo(list, "workerClasses");
            Iterable<Class> iterable = list;
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
            for (Class builder : iterable) {
                arrayList.add((OneTimeWorkRequest) new Builder((Class<? extends ListenableWorker>) builder).build());
            }
            return arrayList;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneTimeWorkRequest(@OOXIXo Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        IIX0o.x0xO0oo(builder, "builder");
    }

    @x0XOIxOo
    @OOXIXo
    public static final OneTimeWorkRequest from(@OOXIXo Class<? extends ListenableWorker> cls) {
        return Companion.from(cls);
    }

    @x0XOIxOo
    @OOXIXo
    public static final List<OneTimeWorkRequest> from(@OOXIXo List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }
}
