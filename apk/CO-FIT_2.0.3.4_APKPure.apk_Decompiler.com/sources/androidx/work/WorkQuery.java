package androidx.work;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import androidx.work.WorkInfo;
import com.baidu.mobads.sdk.internal.bn;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class WorkQuery {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @OOXIXo
    private final List<UUID> ids;
    @OOXIXo
    private final List<WorkInfo.State> states;
    @OOXIXo
    private final List<String> tags;
    @OOXIXo
    private final List<String> uniqueWorkNames;

    public static final class Builder {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        private final List<UUID> ids;
        @OOXIXo
        private final List<WorkInfo.State> states;
        @OOXIXo
        private final List<String> tags;
        @OOXIXo
        private final List<String> uniqueWorkNames;

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @SuppressLint({"BuilderSetStyle"})
            @OOXIXo
            public final Builder fromIds(@OOXIXo List<UUID> list) {
                IIX0o.x0xO0oo(list, "ids");
                Builder builder = new Builder((IIXOooo) null);
                builder.addIds(list);
                return builder;
            }

            @x0XOIxOo
            @SuppressLint({"BuilderSetStyle"})
            @OOXIXo
            public final Builder fromStates(@OOXIXo List<? extends WorkInfo.State> list) {
                IIX0o.x0xO0oo(list, "states");
                Builder builder = new Builder((IIXOooo) null);
                builder.addStates(list);
                return builder;
            }

            @x0XOIxOo
            @SuppressLint({"BuilderSetStyle"})
            @OOXIXo
            public final Builder fromTags(@OOXIXo List<String> list) {
                IIX0o.x0xO0oo(list, bn.l);
                Builder builder = new Builder((IIXOooo) null);
                builder.addTags(list);
                return builder;
            }

            @x0XOIxOo
            @SuppressLint({"BuilderSetStyle"})
            @OOXIXo
            public final Builder fromUniqueWorkNames(@OOXIXo List<String> list) {
                IIX0o.x0xO0oo(list, "uniqueWorkNames");
                Builder builder = new Builder((IIXOooo) null);
                builder.addUniqueWorkNames(list);
                return builder;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Builder(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @SuppressLint({"BuilderSetStyle"})
        @OOXIXo
        public static final Builder fromIds(@OOXIXo List<UUID> list) {
            return Companion.fromIds(list);
        }

        @x0XOIxOo
        @SuppressLint({"BuilderSetStyle"})
        @OOXIXo
        public static final Builder fromStates(@OOXIXo List<? extends WorkInfo.State> list) {
            return Companion.fromStates(list);
        }

        @x0XOIxOo
        @SuppressLint({"BuilderSetStyle"})
        @OOXIXo
        public static final Builder fromTags(@OOXIXo List<String> list) {
            return Companion.fromTags(list);
        }

        @x0XOIxOo
        @SuppressLint({"BuilderSetStyle"})
        @OOXIXo
        public static final Builder fromUniqueWorkNames(@OOXIXo List<String> list) {
            return Companion.fromUniqueWorkNames(list);
        }

        @OOXIXo
        public final Builder addIds(@OOXIXo List<UUID> list) {
            IIX0o.x0xO0oo(list, "ids");
            OxI.XIo0oOXIx(this.ids, list);
            return this;
        }

        @OOXIXo
        public final Builder addStates(@OOXIXo List<? extends WorkInfo.State> list) {
            IIX0o.x0xO0oo(list, "states");
            OxI.XIo0oOXIx(this.states, list);
            return this;
        }

        @OOXIXo
        public final Builder addTags(@OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, bn.l);
            OxI.XIo0oOXIx(this.tags, list);
            return this;
        }

        @OOXIXo
        public final Builder addUniqueWorkNames(@OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, "uniqueWorkNames");
            OxI.XIo0oOXIx(this.uniqueWorkNames, list);
            return this;
        }

        @OOXIXo
        public final WorkQuery build() {
            if (!this.ids.isEmpty() || !this.uniqueWorkNames.isEmpty() || !this.tags.isEmpty() || !this.states.isEmpty()) {
                return new WorkQuery(this.ids, this.uniqueWorkNames, this.tags, this.states);
            }
            throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        }

        private Builder() {
            this.ids = new ArrayList();
            this.uniqueWorkNames = new ArrayList();
            this.tags = new ArrayList();
            this.states = new ArrayList();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromIds(@OOXIXo List<UUID> list) {
            IIX0o.x0xO0oo(list, "ids");
            return new WorkQuery(list, (List) null, (List) null, (List) null, 14, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromStates(@OOXIXo List<? extends WorkInfo.State> list) {
            IIX0o.x0xO0oo(list, "states");
            return new WorkQuery((List) null, (List) null, (List) null, list, 7, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromTags(@OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, bn.l);
            return new WorkQuery((List) null, (List) null, list, (List) null, 11, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromUniqueWorkNames(@OOXIXo String... strArr) {
            IIX0o.x0xO0oo(strArr, "uniqueWorkNames");
            return new WorkQuery((List) null, ArraysKt___ArraysKt.IoXOX(strArr), (List) null, (List) null, 13, (IIXOooo) null);
        }

        private Companion() {
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromIds(@OOXIXo UUID... uuidArr) {
            IIX0o.x0xO0oo(uuidArr, "ids");
            return new WorkQuery(ArraysKt___ArraysKt.IoXOX(uuidArr), (List) null, (List) null, (List) null, 14, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromStates(@OOXIXo WorkInfo.State... stateArr) {
            IIX0o.x0xO0oo(stateArr, "states");
            return new WorkQuery((List) null, (List) null, (List) null, ArraysKt___ArraysKt.IoXOX(stateArr), 7, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromTags(@OOXIXo String... strArr) {
            IIX0o.x0xO0oo(strArr, bn.l);
            return new WorkQuery((List) null, (List) null, ArraysKt___ArraysKt.IoXOX(strArr), (List) null, 11, (IIXOooo) null);
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkQuery fromUniqueWorkNames(@OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, "uniqueWorkNames");
            return new WorkQuery((List) null, list, (List) null, (List) null, 13, (IIXOooo) null);
        }
    }

    public WorkQuery() {
        this((List) null, (List) null, (List) null, (List) null, 15, (IIXOooo) null);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromIds(@OOXIXo List<UUID> list) {
        return Companion.fromIds(list);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromStates(@OOXIXo List<? extends WorkInfo.State> list) {
        return Companion.fromStates(list);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromTags(@OOXIXo List<String> list) {
        return Companion.fromTags(list);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromUniqueWorkNames(@OOXIXo List<String> list) {
        return Companion.fromUniqueWorkNames(list);
    }

    @OOXIXo
    public final List<UUID> getIds() {
        return this.ids;
    }

    @OOXIXo
    public final List<WorkInfo.State> getStates() {
        return this.states;
    }

    @OOXIXo
    public final List<String> getTags() {
        return this.tags;
    }

    @OOXIXo
    public final List<String> getUniqueWorkNames() {
        return this.uniqueWorkNames;
    }

    public WorkQuery(@OOXIXo List<UUID> list, @OOXIXo List<String> list2, @OOXIXo List<String> list3, @OOXIXo List<? extends WorkInfo.State> list4) {
        IIX0o.x0xO0oo(list, "ids");
        IIX0o.x0xO0oo(list2, "uniqueWorkNames");
        IIX0o.x0xO0oo(list3, bn.l);
        IIX0o.x0xO0oo(list4, "states");
        this.ids = list;
        this.uniqueWorkNames = list2;
        this.tags = list3;
        this.states = list4;
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromIds(@OOXIXo UUID... uuidArr) {
        return Companion.fromIds(uuidArr);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromStates(@OOXIXo WorkInfo.State... stateArr) {
        return Companion.fromStates(stateArr);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromTags(@OOXIXo String... strArr) {
        return Companion.fromTags(strArr);
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkQuery fromUniqueWorkNames(@OOXIXo String... strArr) {
        return Companion.fromUniqueWorkNames(strArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkQuery(List list, List list2, List list3, List list4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list, (i & 2) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list3, (i & 8) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list4);
    }
}
