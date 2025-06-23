package androidx.work;

import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class WorkQuery {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private final List<UUID> ids;

    @OXOo.OOXIXo
    private final List<WorkInfo.State> states;

    @OXOo.OOXIXo
    private final List<String> tags;

    @OXOo.OOXIXo
    private final List<String> uniqueWorkNames;

    /* loaded from: classes.dex */
    public static final class Builder {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        private final List<UUID> ids;

        @OXOo.OOXIXo
        private final List<WorkInfo.State> states;

        @OXOo.OOXIXo
        private final List<String> tags;

        @OXOo.OOXIXo
        private final List<String> uniqueWorkNames;

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OXOo.OOXIXo
            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromIds(@OXOo.OOXIXo List<UUID> ids) {
                IIX0o.x0xO0oo(ids, "ids");
                Builder builder = new Builder(null);
                builder.addIds(ids);
                return builder;
            }

            @x0XOIxOo
            @OXOo.OOXIXo
            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromStates(@OXOo.OOXIXo List<? extends WorkInfo.State> states) {
                IIX0o.x0xO0oo(states, "states");
                Builder builder = new Builder(null);
                builder.addStates(states);
                return builder;
            }

            @x0XOIxOo
            @OXOo.OOXIXo
            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromTags(@OXOo.OOXIXo List<String> tags) {
                IIX0o.x0xO0oo(tags, "tags");
                Builder builder = new Builder(null);
                builder.addTags(tags);
                return builder;
            }

            @x0XOIxOo
            @OXOo.OOXIXo
            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromUniqueWorkNames(@OXOo.OOXIXo List<String> uniqueWorkNames) {
                IIX0o.x0xO0oo(uniqueWorkNames, "uniqueWorkNames");
                Builder builder = new Builder(null);
                builder.addUniqueWorkNames(uniqueWorkNames);
                return builder;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Builder(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromIds(@OXOo.OOXIXo List<UUID> list) {
            return Companion.fromIds(list);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromStates(@OXOo.OOXIXo List<? extends WorkInfo.State> list) {
            return Companion.fromStates(list);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromTags(@OXOo.OOXIXo List<String> list) {
            return Companion.fromTags(list);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromUniqueWorkNames(@OXOo.OOXIXo List<String> list) {
            return Companion.fromUniqueWorkNames(list);
        }

        @OXOo.OOXIXo
        public final Builder addIds(@OXOo.OOXIXo List<UUID> ids) {
            IIX0o.x0xO0oo(ids, "ids");
            OxI.XIo0oOXIx(this.ids, ids);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder addStates(@OXOo.OOXIXo List<? extends WorkInfo.State> states) {
            IIX0o.x0xO0oo(states, "states");
            OxI.XIo0oOXIx(this.states, states);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder addTags(@OXOo.OOXIXo List<String> tags) {
            IIX0o.x0xO0oo(tags, "tags");
            OxI.XIo0oOXIx(this.tags, tags);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder addUniqueWorkNames(@OXOo.OOXIXo List<String> uniqueWorkNames) {
            IIX0o.x0xO0oo(uniqueWorkNames, "uniqueWorkNames");
            OxI.XIo0oOXIx(this.uniqueWorkNames, uniqueWorkNames);
            return this;
        }

        @OXOo.OOXIXo
        public final WorkQuery build() {
            if (this.ids.isEmpty() && this.uniqueWorkNames.isEmpty() && this.tags.isEmpty() && this.states.isEmpty()) {
                throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
            }
            return new WorkQuery(this.ids, this.uniqueWorkNames, this.tags, this.states);
        }

        private Builder() {
            this.ids = new ArrayList();
            this.uniqueWorkNames = new ArrayList();
            this.tags = new ArrayList();
            this.states = new ArrayList();
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromIds(@OXOo.OOXIXo List<UUID> ids) {
            IIX0o.x0xO0oo(ids, "ids");
            return new WorkQuery(ids, null, null, null, 14, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromStates(@OXOo.OOXIXo List<? extends WorkInfo.State> states) {
            IIX0o.x0xO0oo(states, "states");
            return new WorkQuery(null, null, null, states, 7, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromTags(@OXOo.OOXIXo List<String> tags) {
            IIX0o.x0xO0oo(tags, "tags");
            return new WorkQuery(null, null, tags, null, 11, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromUniqueWorkNames(@OXOo.OOXIXo String... uniqueWorkNames) {
            IIX0o.x0xO0oo(uniqueWorkNames, "uniqueWorkNames");
            return new WorkQuery(null, ArraysKt___ArraysKt.IoXOX(uniqueWorkNames), null, null, 13, null);
        }

        private Companion() {
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromIds(@OXOo.OOXIXo UUID... ids) {
            IIX0o.x0xO0oo(ids, "ids");
            return new WorkQuery(ArraysKt___ArraysKt.IoXOX(ids), null, null, null, 14, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromStates(@OXOo.OOXIXo WorkInfo.State... states) {
            IIX0o.x0xO0oo(states, "states");
            return new WorkQuery(null, null, null, ArraysKt___ArraysKt.IoXOX(states), 7, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromTags(@OXOo.OOXIXo String... tags) {
            IIX0o.x0xO0oo(tags, "tags");
            return new WorkQuery(null, null, ArraysKt___ArraysKt.IoXOX(tags), null, 11, null);
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        public final WorkQuery fromUniqueWorkNames(@OXOo.OOXIXo List<String> uniqueWorkNames) {
            IIX0o.x0xO0oo(uniqueWorkNames, "uniqueWorkNames");
            return new WorkQuery(null, uniqueWorkNames, null, null, 13, null);
        }
    }

    public WorkQuery() {
        this(null, null, null, null, 15, null);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromIds(@OXOo.OOXIXo List<UUID> list) {
        return Companion.fromIds(list);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromStates(@OXOo.OOXIXo List<? extends WorkInfo.State> list) {
        return Companion.fromStates(list);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromTags(@OXOo.OOXIXo List<String> list) {
        return Companion.fromTags(list);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromUniqueWorkNames(@OXOo.OOXIXo List<String> list) {
        return Companion.fromUniqueWorkNames(list);
    }

    @OXOo.OOXIXo
    public final List<UUID> getIds() {
        return this.ids;
    }

    @OXOo.OOXIXo
    public final List<WorkInfo.State> getStates() {
        return this.states;
    }

    @OXOo.OOXIXo
    public final List<String> getTags() {
        return this.tags;
    }

    @OXOo.OOXIXo
    public final List<String> getUniqueWorkNames() {
        return this.uniqueWorkNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkQuery(@OXOo.OOXIXo List<UUID> ids, @OXOo.OOXIXo List<String> uniqueWorkNames, @OXOo.OOXIXo List<String> tags, @OXOo.OOXIXo List<? extends WorkInfo.State> states) {
        IIX0o.x0xO0oo(ids, "ids");
        IIX0o.x0xO0oo(uniqueWorkNames, "uniqueWorkNames");
        IIX0o.x0xO0oo(tags, "tags");
        IIX0o.x0xO0oo(states, "states");
        this.ids = ids;
        this.uniqueWorkNames = uniqueWorkNames;
        this.tags = tags;
        this.states = states;
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromIds(@OXOo.OOXIXo UUID... uuidArr) {
        return Companion.fromIds(uuidArr);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromStates(@OXOo.OOXIXo WorkInfo.State... stateArr) {
        return Companion.fromStates(stateArr);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromTags(@OXOo.OOXIXo String... strArr) {
        return Companion.fromTags(strArr);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    public static final WorkQuery fromUniqueWorkNames(@OXOo.OOXIXo String... strArr) {
        return Companion.fromUniqueWorkNames(strArr);
    }

    public /* synthetic */ WorkQuery(List list, List list2, List list3, List list4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list, (i & 2) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list3, (i & 8) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list4);
    }
}
