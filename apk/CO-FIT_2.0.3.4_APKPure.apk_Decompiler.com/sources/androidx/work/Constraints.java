package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
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

public final class Constraints {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @XO
    @OOXIXo
    public static final Constraints NONE = new Constraints((NetworkType) null, false, false, false, 15, (IIXOooo) null);
    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;
    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;
    @ColumnInfo(name = "content_uri_triggers")
    @OOXIXo
    private final Set<ContentUriTrigger> contentUriTriggers;
    @ColumnInfo(defaultValue = "x''", name = "required_network_request")
    @OOXIXo
    private final NetworkRequestCompat requiredNetworkRequestCompat;
    @ColumnInfo(name = "required_network_type")
    @OOXIXo
    private final NetworkType requiredNetworkType;
    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;
    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;
    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;
    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    public static final class Builder {
        @OOXIXo
        private Set<ContentUriTrigger> contentUriTriggers = new LinkedHashSet();
        @OOXIXo
        private NetworkRequestCompat requiredNetworkRequest = new NetworkRequestCompat((Object) null, 1, (IIXOooo) null);
        @OOXIXo
        private NetworkType requiredNetworkType = NetworkType.NOT_REQUIRED;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay = -1;
        private long triggerContentUpdateDelay = -1;

        public Builder() {
        }

        @RequiresApi(24)
        @OOXIXo
        public final Builder addContentUriTrigger(@OOXIXo Uri uri, boolean z) {
            IIX0o.x0xO0oo(uri, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z));
            return this;
        }

        @OOXIXo
        public final Constraints build() {
            Set<T> set;
            long j;
            long j2;
            boolean z;
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                set = CollectionsKt___CollectionsKt.XxI0(this.contentUriTriggers);
                j2 = this.triggerContentUpdateDelay;
                j = this.triggerContentMaxDelay;
            } else {
                set = Xo0.OOXIXo();
                j2 = -1;
                j = -1;
            }
            NetworkRequestCompat networkRequestCompat = this.requiredNetworkRequest;
            NetworkType networkType = this.requiredNetworkType;
            boolean z2 = this.requiresCharging;
            if (i < 23 || !this.requiresDeviceIdle) {
                z = false;
            } else {
                z = true;
            }
            return new Constraints(networkRequestCompat, networkType, z2, z, this.requiresBatteryNotLow, this.requiresStorageNotLow, j2, j, set);
        }

        @RequiresApi(21)
        @OOXIXo
        public final Builder setRequiredNetworkRequest(@OOXIXo NetworkRequest networkRequest, @OOXIXo NetworkType networkType) {
            IIX0o.x0xO0oo(networkRequest, "networkRequest");
            IIX0o.x0xO0oo(networkType, "networkType");
            int i = Build.VERSION.SDK_INT;
            if (i < 28) {
                this.requiredNetworkType = networkType;
            } else if (i < 31 || NetworkRequest30.INSTANCE.getNetworkSpecifier(networkRequest) == null) {
                this.requiredNetworkRequest = new NetworkRequestCompat(networkRequest);
                this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            } else {
                throw new IllegalArgumentException("NetworkRequests with NetworkSpecifiers set aren't supported.");
            }
            return this;
        }

        @OOXIXo
        public final Builder setRequiredNetworkType(@OOXIXo NetworkType networkType) {
            IIX0o.x0xO0oo(networkType, "networkType");
            this.requiredNetworkType = networkType;
            this.requiredNetworkRequest = new NetworkRequestCompat((Object) null, 1, (IIXOooo) null);
            return this;
        }

        @OOXIXo
        public final Builder setRequiresBatteryNotLow(boolean z) {
            this.requiresBatteryNotLow = z;
            return this;
        }

        @OOXIXo
        public final Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        @RequiresApi(23)
        @OOXIXo
        public final Builder setRequiresDeviceIdle(boolean z) {
            this.requiresDeviceIdle = z;
            return this;
        }

        @OOXIXo
        public final Builder setRequiresStorageNotLow(boolean z) {
            this.requiresStorageNotLow = z;
            return this;
        }

        @RequiresApi(24)
        @OOXIXo
        public final Builder setTriggerContentMaxDelay(long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(24)
        @OOXIXo
        public final Builder setTriggerContentUpdateDelay(long j, @OOXIXo TimeUnit timeUnit) {
            IIX0o.x0xO0oo(timeUnit, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(26)
        @OOXIXo
        public final Builder setTriggerContentMaxDelay(@OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RequiresApi(26)
        @OOXIXo
        public final Builder setTriggerContentUpdateDelay(@OOXIXo Duration duration) {
            IIX0o.x0xO0oo(duration, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@OOXIXo Constraints constraints) {
            IIX0o.x0xO0oo(constraints, "constraints");
            boolean z = true;
            this.requiresCharging = constraints.requiresCharging();
            int i = Build.VERSION.SDK_INT;
            this.requiresDeviceIdle = (i < 23 || !constraints.requiresDeviceIdle()) ? false : z;
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

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        @OOXIXo
        private final Uri uri;

        public ContentUriTrigger(@OOXIXo Uri uri2, boolean z) {
            IIX0o.x0xO0oo(uri2, "uri");
            this.uri = uri2;
            this.isTriggeredForDescendants = z;
        }

        public boolean equals(@oOoXoXO Object obj) {
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

        @OOXIXo
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Constraints(NetworkType networkType, boolean z, boolean z2, boolean z3, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    @SuppressLint({"NewApi"})
    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!IIX0o.Oxx0IOOO(Constraints.class, obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && IIX0o.Oxx0IOOO(getRequiredNetworkRequest(), constraints.getRequiredNetworkRequest()) && this.requiredNetworkType == constraints.requiredNetworkType) {
            return IIX0o.Oxx0IOOO(this.contentUriTriggers, constraints.contentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    @RequiresApi(24)
    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    @RequiresApi(24)
    @OOXIXo
    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    @RequiresApi(21)
    @oOoXoXO
    public final NetworkRequest getRequiredNetworkRequest() {
        return this.requiredNetworkRequestCompat.getNetworkRequest();
    }

    @OOXIXo
    public final NetworkRequestCompat getRequiredNetworkRequestCompat$work_runtime_release() {
        return this.requiredNetworkRequestCompat;
    }

    @OOXIXo
    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        if (Build.VERSION.SDK_INT < 24 || !this.contentUriTriggers.isEmpty()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        int i;
        long j = this.contentTriggerUpdateDelayMillis;
        long j2 = this.contentTriggerMaxDelayMillis;
        int hashCode = ((((((((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.contentUriTriggers.hashCode()) * 31;
        NetworkRequest requiredNetworkRequest = getRequiredNetworkRequest();
        if (requiredNetworkRequest != null) {
            i = requiredNetworkRequest.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
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

    @SuppressLint({"NewApi"})
    @OOXIXo
    public String toString() {
        return "Constraints{requiredNetworkType=" + this.requiredNetworkType + ", requiresCharging=" + this.requiresCharging + ", requiresDeviceIdle=" + this.requiresDeviceIdle + ", requiresBatteryNotLow=" + this.requiresBatteryNotLow + ", requiresStorageNotLow=" + this.requiresStorageNotLow + ", contentTriggerUpdateDelayMillis=" + this.contentTriggerUpdateDelayMillis + ", contentTriggerMaxDelayMillis=" + this.contentTriggerMaxDelayMillis + ", contentUriTriggers=" + this.contentUriTriggers + ", }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Ignore
    @SuppressLint({"NewApi"})
    public Constraints(@OOXIXo NetworkType networkType, boolean z, boolean z2, boolean z3) {
        this(networkType, z, false, z2, z3);
        IIX0o.x0xO0oo(networkType, "requiredNetworkType");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Constraints(androidx.work.NetworkType r4, boolean r5, boolean r6, boolean r7, boolean r8, int r9, kotlin.jvm.internal.IIXOooo r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            androidx.work.NetworkType r4 = androidx.work.NetworkType.NOT_REQUIRED
        L_0x0006:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto L_0x000d
            r10 = 0
            goto L_0x000e
        L_0x000d:
            r10 = r5
        L_0x000e:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0014
            r1 = 0
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001b
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = r7
        L_0x001c:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = r8
        L_0x0022:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.NetworkType, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.IIXOooo):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(23)
    @Ignore
    @SuppressLint({"NewApi"})
    public Constraints(@OOXIXo NetworkType networkType, boolean z, boolean z2, boolean z3, boolean z4) {
        this(networkType, z, z2, z3, z4, -1, 0, (Set) null, 192, (IIXOooo) null);
        IIX0o.x0xO0oo(networkType, "requiredNetworkType");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Constraints(androidx.work.NetworkType r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17, long r19, java.util.Set r21, int r22, kotlin.jvm.internal.IIXOooo r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0012
        L_0x0011:
            r2 = r13
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = r15
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r3 = r16
        L_0x0027:
            r6 = r0 & 32
            r7 = -1
            if (r6 == 0) goto L_0x002f
            r9 = r7
            goto L_0x0031
        L_0x002f:
            r9 = r17
        L_0x0031:
            r6 = r0 & 64
            if (r6 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r7 = r19
        L_0x0038:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0041
            java.util.Set r0 = kotlin.collections.Xo0.OOXIXo()
            goto L_0x0043
        L_0x0041:
            r0 = r21
        L_0x0043:
            r12 = r11
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r5
            r17 = r3
            r18 = r9
            r20 = r7
            r22 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r20, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.NetworkType, boolean, boolean, boolean, boolean, long, long, java.util.Set, int, kotlin.jvm.internal.IIXOooo):void");
    }

    @RequiresApi(24)
    @Ignore
    public Constraints(@OOXIXo NetworkType networkType, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, @OOXIXo Set<ContentUriTrigger> set) {
        IIX0o.x0xO0oo(networkType, "requiredNetworkType");
        IIX0o.x0xO0oo(set, "contentUriTriggers");
        this.requiredNetworkRequestCompat = new NetworkRequestCompat((Object) null, 1, (IIXOooo) null);
        this.requiredNetworkType = networkType;
        this.requiresCharging = z;
        this.requiresDeviceIdle = z2;
        this.requiresBatteryNotLow = z3;
        this.requiresStorageNotLow = z4;
        this.contentTriggerUpdateDelayMillis = j;
        this.contentTriggerMaxDelayMillis = j2;
        this.contentUriTriggers = set;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Constraints(androidx.work.impl.utils.NetworkRequestCompat r12, androidx.work.NetworkType r13, boolean r14, boolean r15, boolean r16, boolean r17, long r18, long r20, java.util.Set r22, int r23, kotlin.jvm.internal.IIXOooo r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r2 = r0 & 4
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0012
        L_0x0011:
            r2 = r14
        L_0x0012:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = r15
        L_0x0019:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001f
            r5 = 0
            goto L_0x0021
        L_0x001f:
            r5 = r16
        L_0x0021:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r3 = r17
        L_0x0028:
            r6 = r0 & 64
            r7 = -1
            if (r6 == 0) goto L_0x0030
            r9 = r7
            goto L_0x0032
        L_0x0030:
            r9 = r18
        L_0x0032:
            r6 = r0 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r7 = r20
        L_0x0039:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0042
            java.util.Set r0 = kotlin.collections.Xo0.OOXIXo()
            goto L_0x0044
        L_0x0042:
            r0 = r22
        L_0x0044:
            r13 = r11
            r14 = r12
            r15 = r1
            r16 = r2
            r17 = r4
            r18 = r5
            r19 = r3
            r20 = r9
            r22 = r7
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r22, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.impl.utils.NetworkRequestCompat, androidx.work.NetworkType, boolean, boolean, boolean, boolean, long, long, java.util.Set, int, kotlin.jvm.internal.IIXOooo):void");
    }

    public Constraints(@OOXIXo NetworkRequestCompat networkRequestCompat, @OOXIXo NetworkType networkType, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, @OOXIXo Set<ContentUriTrigger> set) {
        IIX0o.x0xO0oo(networkRequestCompat, "requiredNetworkRequestCompat");
        IIX0o.x0xO0oo(networkType, "requiredNetworkType");
        IIX0o.x0xO0oo(set, "contentUriTriggers");
        this.requiredNetworkRequestCompat = networkRequestCompat;
        this.requiredNetworkType = networkType;
        this.requiresCharging = z;
        this.requiresDeviceIdle = z2;
        this.requiresBatteryNotLow = z3;
        this.requiresStorageNotLow = z4;
        this.contentTriggerUpdateDelayMillis = j;
        this.contentTriggerMaxDelayMillis = j2;
        this.contentUriTriggers = set;
    }

    @SuppressLint({"NewApi"})
    public Constraints(@OOXIXo Constraints constraints) {
        IIX0o.x0xO0oo(constraints, "other");
        this.requiresCharging = constraints.requiresCharging;
        this.requiresDeviceIdle = constraints.requiresDeviceIdle;
        this.requiredNetworkRequestCompat = constraints.requiredNetworkRequestCompat;
        this.requiredNetworkType = constraints.requiredNetworkType;
        this.requiresBatteryNotLow = constraints.requiresBatteryNotLow;
        this.requiresStorageNotLow = constraints.requiresStorageNotLow;
        this.contentUriTriggers = constraints.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = constraints.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = constraints.contentTriggerMaxDelayMillis;
    }
}
