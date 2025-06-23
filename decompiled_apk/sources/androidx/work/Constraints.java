package androidx.work;

import android.annotation.SuppressLint;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.work.impl.utils.DurationApi26Impl;
import androidx.work.impl.utils.NetworkRequest30;
import androidx.work.impl.utils.NetworkRequestCompat;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class Constraints {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Constraints NONE = new Constraints(null, false, false, false, 15, null);

    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;

    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;

    @OXOo.OOXIXo
    @ColumnInfo(name = "content_uri_triggers")
    private final Set<ContentUriTrigger> contentUriTriggers;

    @OXOo.OOXIXo
    @ColumnInfo(defaultValue = "x''", name = "required_network_request")
    private final NetworkRequestCompat requiredNetworkRequestCompat;

    @OXOo.OOXIXo
    @ColumnInfo(name = "required_network_type")
    private final NetworkType requiredNetworkType;

    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;

    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;

    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;

    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    /* loaded from: classes.dex */
    public static final class Builder {

        @OXOo.OOXIXo
        private Set<ContentUriTrigger> contentUriTriggers;

        @OXOo.OOXIXo
        private NetworkRequestCompat requiredNetworkRequest;

        @OXOo.OOXIXo
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkRequest = new NetworkRequestCompat(null, 1, null);
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
        }

        @OXOo.OOXIXo
        @RequiresApi(24)
        public final Builder addContentUriTrigger(@OXOo.OOXIXo Uri uri, boolean z) {
            IIX0o.x0xO0oo(uri, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z));
            return this;
        }

        @OXOo.OOXIXo
        public final Constraints build() {
            Set OOXIXo2;
            long j;
            long j2;
            boolean z;
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                OOXIXo2 = CollectionsKt___CollectionsKt.XxI0(this.contentUriTriggers);
                j = this.triggerContentUpdateDelay;
                j2 = this.triggerContentMaxDelay;
            } else {
                OOXIXo2 = Xo0.OOXIXo();
                j = -1;
                j2 = -1;
            }
            NetworkRequestCompat networkRequestCompat = this.requiredNetworkRequest;
            NetworkType networkType = this.requiredNetworkType;
            boolean z2 = this.requiresCharging;
            if (i >= 23 && this.requiresDeviceIdle) {
                z = true;
            } else {
                z = false;
            }
            return new Constraints(networkRequestCompat, networkType, z2, z, this.requiresBatteryNotLow, this.requiresStorageNotLow, j, j2, OOXIXo2);
        }

        @OXOo.OOXIXo
        @RequiresApi(21)
        public final Builder setRequiredNetworkRequest(@OXOo.OOXIXo NetworkRequest networkRequest, @OXOo.OOXIXo NetworkType networkType) {
            IIX0o.x0xO0oo(networkRequest, "networkRequest");
            IIX0o.x0xO0oo(networkType, "networkType");
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                if (i >= 31 && NetworkRequest30.INSTANCE.getNetworkSpecifier(networkRequest) != null) {
                    throw new IllegalArgumentException("NetworkRequests with NetworkSpecifiers set aren't supported.");
                }
                this.requiredNetworkRequest = new NetworkRequestCompat(networkRequest);
                this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            } else {
                this.requiredNetworkType = networkType;
            }
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setRequiredNetworkType(@OXOo.OOXIXo NetworkType networkType) {
            IIX0o.x0xO0oo(networkType, "networkType");
            this.requiredNetworkType = networkType;
            this.requiredNetworkRequest = new NetworkRequestCompat(null, 1, null);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setRequiresBatteryNotLow(boolean z) {
            this.requiresBatteryNotLow = z;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        @OXOo.OOXIXo
        @RequiresApi(23)
        public final Builder setRequiresDeviceIdle(boolean z) {
            this.requiresDeviceIdle = z;
            return this;
        }

        @OXOo.OOXIXo
        public final Builder setRequiresStorageNotLow(boolean z) {
            this.requiresStorageNotLow = z;
            return this;
        }

        @OXOo.OOXIXo
        @RequiresApi(24)
        public final Builder setTriggerContentMaxDelay(long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(j);
            return this;
        }

        @OXOo.OOXIXo
        @RequiresApi(24)
        public final Builder setTriggerContentUpdateDelay(long j, @OXOo.OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(j);
            return this;
        }

        @OXOo.OOXIXo
        @RequiresApi(26)
        public final Builder setTriggerContentMaxDelay(@OXOo.OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @OXOo.OOXIXo
        @RequiresApi(26)
        public final Builder setTriggerContentUpdateDelay(@OXOo.OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@OXOo.OOXIXo Constraints constraints) {
            IIX0o.x0xO0oo(constraints, "constraints");
            this.requiredNetworkRequest = new NetworkRequestCompat(null, 1, null);
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = constraints.requiresCharging();
            int i = Build.VERSION.SDK_INT;
            this.requiresDeviceIdle = i >= 23 && constraints.requiresDeviceIdle();
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            if (i >= 24) {
                this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = CollectionsKt___CollectionsKt.OoOoxX0xo(constraints.getContentUriTriggers());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;

        @OXOo.OOXIXo
        private final Uri uri;

        public ContentUriTrigger(@OXOo.OOXIXo Uri uri, boolean z) {
            IIX0o.x0xO0oo(uri, "uri");
            this.uri = uri;
            this.isTriggeredForDescendants = z;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!IIX0o.Oxx0IOOO(ContentUriTrigger.class, cls)) {
                return false;
            }
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            if (IIX0o.Oxx0IOOO(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants) {
                return true;
            }
            return false;
        }

        @OXOo.OOXIXo
        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + oIX0oI.oIX0oI(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z, boolean z2, boolean z3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    @SuppressLint({"NewApi"})
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !IIX0o.Oxx0IOOO(Constraints.class, obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging != constraints.requiresCharging || this.requiresDeviceIdle != constraints.requiresDeviceIdle || this.requiresBatteryNotLow != constraints.requiresBatteryNotLow || this.requiresStorageNotLow != constraints.requiresStorageNotLow || this.contentTriggerUpdateDelayMillis != constraints.contentTriggerUpdateDelayMillis || this.contentTriggerMaxDelayMillis != constraints.contentTriggerMaxDelayMillis || !IIX0o.Oxx0IOOO(getRequiredNetworkRequest(), constraints.getRequiredNetworkRequest()) || this.requiredNetworkType != constraints.requiredNetworkType) {
            return false;
        }
        return IIX0o.Oxx0IOOO(this.contentUriTriggers, constraints.contentUriTriggers);
    }

    @RequiresApi(24)
    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    @RequiresApi(24)
    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    @OXOo.OOXIXo
    @RequiresApi(24)
    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    @RequiresApi(21)
    @OXOo.oOoXoXO
    public final NetworkRequest getRequiredNetworkRequest() {
        return this.requiredNetworkRequestCompat.getNetworkRequest();
    }

    @OXOo.OOXIXo
    public final NetworkRequestCompat getRequiredNetworkRequestCompat$work_runtime_release() {
        return this.requiredNetworkRequestCompat;
    }

    @OXOo.OOXIXo
    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        if (Build.VERSION.SDK_INT >= 24 && this.contentUriTriggers.isEmpty()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        int i;
        int hashCode = ((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long j = this.contentTriggerUpdateDelayMillis;
        int i2 = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.contentTriggerMaxDelayMillis;
        int hashCode2 = (((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.contentUriTriggers.hashCode()) * 31;
        NetworkRequest requiredNetworkRequest = getRequiredNetworkRequest();
        if (requiredNetworkRequest != null) {
            i = requiredNetworkRequest.hashCode();
        } else {
            i = 0;
        }
        return hashCode2 + i;
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    @RequiresApi(23)
    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    @OXOo.OOXIXo
    @SuppressLint({"NewApi"})
    public String toString() {
        return "Constraints{requiredNetworkType=" + this.requiredNetworkType + ", requiresCharging=" + this.requiresCharging + ", requiresDeviceIdle=" + this.requiresDeviceIdle + ", requiresBatteryNotLow=" + this.requiresBatteryNotLow + ", requiresStorageNotLow=" + this.requiresStorageNotLow + ", contentTriggerUpdateDelayMillis=" + this.contentTriggerUpdateDelayMillis + ", contentTriggerMaxDelayMillis=" + this.contentTriggerMaxDelayMillis + ", contentUriTriggers=" + this.contentUriTriggers + ", }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    @Ignore
    public Constraints(@OXOo.OOXIXo NetworkType requiredNetworkType, boolean z, boolean z2, boolean z3) {
        this(requiredNetworkType, z, false, z2, z3);
        IIX0o.x0xO0oo(requiredNetworkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z, boolean z2, boolean z3, boolean z4, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) == 0 ? z4 : false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(23)
    @SuppressLint({"NewApi"})
    @Ignore
    public Constraints(@OXOo.OOXIXo NetworkType requiredNetworkType, boolean z, boolean z2, boolean z3, boolean z4) {
        this(requiredNetworkType, z, z2, z3, z4, -1L, 0L, null, 192, null);
        IIX0o.x0xO0oo(requiredNetworkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, Set set, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) == 0 ? z4 : false, (i & 32) != 0 ? -1L : j, (i & 64) == 0 ? j2 : -1L, (i & 128) != 0 ? Xo0.OOXIXo() : set);
    }

    @RequiresApi(24)
    @Ignore
    public Constraints(@OXOo.OOXIXo NetworkType requiredNetworkType, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, @OXOo.OOXIXo Set<ContentUriTrigger> contentUriTriggers) {
        IIX0o.x0xO0oo(requiredNetworkType, "requiredNetworkType");
        IIX0o.x0xO0oo(contentUriTriggers, "contentUriTriggers");
        this.requiredNetworkRequestCompat = new NetworkRequestCompat(null, 1, null);
        this.requiredNetworkType = requiredNetworkType;
        this.requiresCharging = z;
        this.requiresDeviceIdle = z2;
        this.requiresBatteryNotLow = z3;
        this.requiresStorageNotLow = z4;
        this.contentTriggerUpdateDelayMillis = j;
        this.contentTriggerMaxDelayMillis = j2;
        this.contentUriTriggers = contentUriTriggers;
    }

    public /* synthetic */ Constraints(NetworkRequestCompat networkRequestCompat, NetworkType networkType, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, Set set, int i, IIXOooo iIXOooo) {
        this(networkRequestCompat, (i & 2) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) == 0 ? z4 : false, (i & 64) != 0 ? -1L : j, (i & 128) == 0 ? j2 : -1L, (i & 256) != 0 ? Xo0.OOXIXo() : set);
    }

    public Constraints(@OXOo.OOXIXo NetworkRequestCompat requiredNetworkRequestCompat, @OXOo.OOXIXo NetworkType requiredNetworkType, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, @OXOo.OOXIXo Set<ContentUriTrigger> contentUriTriggers) {
        IIX0o.x0xO0oo(requiredNetworkRequestCompat, "requiredNetworkRequestCompat");
        IIX0o.x0xO0oo(requiredNetworkType, "requiredNetworkType");
        IIX0o.x0xO0oo(contentUriTriggers, "contentUriTriggers");
        this.requiredNetworkRequestCompat = requiredNetworkRequestCompat;
        this.requiredNetworkType = requiredNetworkType;
        this.requiresCharging = z;
        this.requiresDeviceIdle = z2;
        this.requiresBatteryNotLow = z3;
        this.requiresStorageNotLow = z4;
        this.contentTriggerUpdateDelayMillis = j;
        this.contentTriggerMaxDelayMillis = j2;
        this.contentUriTriggers = contentUriTriggers;
    }

    @SuppressLint({"NewApi"})
    public Constraints(@OXOo.OOXIXo Constraints other) {
        IIX0o.x0xO0oo(other, "other");
        this.requiresCharging = other.requiresCharging;
        this.requiresDeviceIdle = other.requiresDeviceIdle;
        this.requiredNetworkRequestCompat = other.requiredNetworkRequestCompat;
        this.requiredNetworkType = other.requiredNetworkType;
        this.requiresBatteryNotLow = other.requiresBatteryNotLow;
        this.requiresStorageNotLow = other.requiresStorageNotLow;
        this.contentUriTriggers = other.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = other.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = other.contentTriggerMaxDelayMillis;
    }
}
