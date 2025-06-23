package androidx.work.impl.model;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.os.Build;
import androidx.room.TypeConverter;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkTypeConverters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkTypeConverters.kt\nandroidx/work/impl/model/WorkTypeConverters\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,315:1\n1#2:316\n13600#3,2:317\n13600#3,2:319\n*S KotlinDebug\n*F\n+ 1 WorkTypeConverters.kt\nandroidx/work/impl/model/WorkTypeConverters\n*L\n307#1:317,2\n309#1:319,2\n*E\n"})
public final class WorkTypeConverters {
    @OOXIXo
    public static final WorkTypeConverters INSTANCE = new WorkTypeConverters();

    public static final class BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        @OOXIXo
        public static final BackoffPolicyIds INSTANCE = new BackoffPolicyIds();
        public static final int LINEAR = 1;

        private BackoffPolicyIds() {
        }
    }

    public static final class NetworkTypeIds {
        public static final int CONNECTED = 1;
        @OOXIXo
        public static final NetworkTypeIds INSTANCE = new NetworkTypeIds();
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;

        private NetworkTypeIds() {
        }
    }

    public static final class OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        @OOXIXo
        public static final OutOfPolicyIds INSTANCE = new OutOfPolicyIds();
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;

        private OutOfPolicyIds() {
        }
    }

    public static final class StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        @OOXIXo
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        @OOXIXo
        public static final StateIds INSTANCE = new StateIds();
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;

        private StateIds() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|41|42|(2:43|44)|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|47) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0098 */
        static {
            /*
                androidx.work.WorkInfo$State[] r0 = androidx.work.WorkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r7 = 6
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                androidx.work.BackoffPolicy[] r0 = androidx.work.BackoffPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.LINEAR     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                $EnumSwitchMapping$1 = r0
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.NetworkType r6 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                androidx.work.NetworkType r6 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x006f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                androidx.work.NetworkType r6 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                androidx.work.NetworkType r3 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r3] = r5     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                $EnumSwitchMapping$2 = r0
                androidx.work.OutOfQuotaPolicy[] r0 = androidx.work.OutOfQuotaPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.OutOfQuotaPolicy r3 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.DROP_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                $EnumSwitchMapping$3 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.WhenMappings.<clinit>():void");
        }
    }

    private WorkTypeConverters() {
    }

    @TypeConverter
    @x0XOIxOo
    public static final int backoffPolicyToInt(@OOXIXo BackoffPolicy backoffPolicy) {
        IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
        int i = WhenMappings.$EnumSwitchMapping$1[backoffPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        kotlin.io.II0xO0.oIX0oI(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        throw r0;
     */
    @androidx.room.TypeConverter
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Set<androidx.work.Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(@OXOo.OOXIXo byte[] r9) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            int r1 = r9.length
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r9)
            r9 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0046 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0046 }
            int r3 = r2.readInt()     // Catch:{ all -> 0x003c }
            r4 = 0
        L_0x001e:
            if (r4 >= r3) goto L_0x003e
            java.lang.String r5 = r2.readUTF()     // Catch:{ all -> 0x003c }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x003c }
            boolean r6 = r2.readBoolean()     // Catch:{ all -> 0x003c }
            androidx.work.Constraints$ContentUriTrigger r7 = new androidx.work.Constraints$ContentUriTrigger     // Catch:{ all -> 0x003c }
            java.lang.String r8 = "uri"
            kotlin.jvm.internal.IIX0o.oO(r5, r8)     // Catch:{ all -> 0x003c }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x003c }
            r0.add(r7)     // Catch:{ all -> 0x003c }
            int r4 = r4 + 1
            goto L_0x001e
        L_0x003c:
            r3 = move-exception
            goto L_0x0048
        L_0x003e:
            kotlin.oXIO0o0XI r3 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x003c }
            kotlin.io.II0xO0.oIX0oI(r2, r9)     // Catch:{ IOException -> 0x0046 }
            goto L_0x0051
        L_0x0044:
            r9 = move-exception
            goto L_0x0057
        L_0x0046:
            r2 = move-exception
            goto L_0x004e
        L_0x0048:
            throw r3     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r4 = move-exception
            kotlin.io.II0xO0.oIX0oI(r2, r3)     // Catch:{ IOException -> 0x0046 }
            throw r4     // Catch:{ IOException -> 0x0046 }
        L_0x004e:
            r2.printStackTrace()     // Catch:{ all -> 0x0044 }
        L_0x0051:
            kotlin.oXIO0o0XI r2 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x0044 }
            kotlin.io.II0xO0.oIX0oI(r1, r9)
            return r0
        L_0x0057:
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r0 = move-exception
            kotlin.io.II0xO0.oIX0oI(r1, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(byte[]):java.util.Set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
        kotlin.io.II0xO0.oIX0oI(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006b, code lost:
        throw r1;
     */
    @androidx.room.TypeConverter
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] fromNetworkRequest$work_runtime_release(@OXOo.OOXIXo androidx.work.impl.utils.NetworkRequestCompat r7) {
        /*
            java.lang.String r0 = "requestCompat"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            r2 = 0
            if (r0 >= r1) goto L_0x000f
            byte[] r7 = new byte[r2]
            return r7
        L_0x000f:
            android.net.NetworkRequest r7 = r7.getNetworkRequest()
            if (r7 != 0) goto L_0x0018
            byte[] r7 = new byte[r2]
            return r7
        L_0x0018:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x005e }
            r1.<init>(r0)     // Catch:{ all -> 0x005e }
            int[] r3 = androidx.work.impl.utils.NetworkRequestCompatKt.getTransportTypesCompat(r7)     // Catch:{ all -> 0x003a }
            int[] r7 = androidx.work.impl.utils.NetworkRequestCompatKt.getCapabilitiesCompat(r7)     // Catch:{ all -> 0x003a }
            int r4 = r3.length     // Catch:{ all -> 0x003a }
            r1.writeInt(r4)     // Catch:{ all -> 0x003a }
            int r4 = r3.length     // Catch:{ all -> 0x003a }
            r5 = 0
        L_0x0030:
            if (r5 >= r4) goto L_0x003c
            r6 = r3[r5]     // Catch:{ all -> 0x003a }
            r1.writeInt(r6)     // Catch:{ all -> 0x003a }
            int r5 = r5 + 1
            goto L_0x0030
        L_0x003a:
            r7 = move-exception
            goto L_0x0060
        L_0x003c:
            int r3 = r7.length     // Catch:{ all -> 0x003a }
            r1.writeInt(r3)     // Catch:{ all -> 0x003a }
            int r3 = r7.length     // Catch:{ all -> 0x003a }
        L_0x0041:
            if (r2 >= r3) goto L_0x004b
            r4 = r7[r2]     // Catch:{ all -> 0x003a }
            r1.writeInt(r4)     // Catch:{ all -> 0x003a }
            int r2 = r2 + 1
            goto L_0x0041
        L_0x004b:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x003a }
            r7 = 0
            kotlin.io.II0xO0.oIX0oI(r1, r7)     // Catch:{ all -> 0x005e }
            kotlin.io.II0xO0.oIX0oI(r0, r7)
            byte[] r7 = r0.toByteArray()
            java.lang.String r0 = "outputStream.toByteArray()"
            kotlin.jvm.internal.IIX0o.oO(r7, r0)
            return r7
        L_0x005e:
            r7 = move-exception
            goto L_0x0066
        L_0x0060:
            throw r7     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r2 = move-exception
            kotlin.io.II0xO0.oIX0oI(r1, r7)     // Catch:{ all -> 0x005e }
            throw r2     // Catch:{ all -> 0x005e }
        L_0x0066:
            throw r7     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r1 = move-exception
            kotlin.io.II0xO0.oIX0oI(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.fromNetworkRequest$work_runtime_release(androidx.work.impl.utils.NetworkRequestCompat):byte[]");
    }

    @TypeConverter
    @x0XOIxOo
    @OOXIXo
    public static final BackoffPolicy intToBackoffPolicy(int i) {
        if (i == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
    }

    @TypeConverter
    @x0XOIxOo
    @OOXIXo
    public static final NetworkType intToNetworkType(int i) {
        if (i == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i == 1) {
            return NetworkType.CONNECTED;
        }
        if (i == 2) {
            return NetworkType.UNMETERED;
        }
        if (i == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
    }

    @TypeConverter
    @x0XOIxOo
    @OOXIXo
    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int i) {
        if (i == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to OutOfQuotaPolicy");
    }

    @TypeConverter
    @x0XOIxOo
    @OOXIXo
    public static final WorkInfo.State intToState(int i) {
        if (i == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to State");
    }

    @TypeConverter
    @x0XOIxOo
    public static final int networkTypeToInt(@OOXIXo NetworkType networkType) {
        IIX0o.x0xO0oo(networkType, "networkType");
        int i = WhenMappings.$EnumSwitchMapping$2[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    @TypeConverter
    @x0XOIxOo
    public static final int outOfQuotaPolicyToInt(@OOXIXo OutOfQuotaPolicy outOfQuotaPolicy) {
        IIX0o.x0xO0oo(outOfQuotaPolicy, "policy");
        int i = WhenMappings.$EnumSwitchMapping$3[outOfQuotaPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        kotlin.io.II0xO0.oIX0oI(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        throw r1;
     */
    @androidx.room.TypeConverter
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] setOfTriggersToByteArray(@OXOo.OOXIXo java.util.Set<androidx.work.Constraints.ContentUriTrigger> r4) {
        /*
            java.lang.String r0 = "triggers"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x000f
            r4 = 0
            byte[] r4 = new byte[r4]
            return r4
        L_0x000f:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0058 }
            r1.<init>(r0)     // Catch:{ all -> 0x0058 }
            int r2 = r4.size()     // Catch:{ all -> 0x0043 }
            r1.writeInt(r2)     // Catch:{ all -> 0x0043 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0043 }
        L_0x0024:
            boolean r2 = r4.hasNext()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0045
            java.lang.Object r2 = r4.next()     // Catch:{ all -> 0x0043 }
            androidx.work.Constraints$ContentUriTrigger r2 = (androidx.work.Constraints.ContentUriTrigger) r2     // Catch:{ all -> 0x0043 }
            android.net.Uri r3 = r2.getUri()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0043 }
            r1.writeUTF(r3)     // Catch:{ all -> 0x0043 }
            boolean r2 = r2.isTriggeredForDescendants()     // Catch:{ all -> 0x0043 }
            r1.writeBoolean(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x0024
        L_0x0043:
            r4 = move-exception
            goto L_0x005a
        L_0x0045:
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x0043 }
            r4 = 0
            kotlin.io.II0xO0.oIX0oI(r1, r4)     // Catch:{ all -> 0x0058 }
            kotlin.io.II0xO0.oIX0oI(r0, r4)
            byte[] r4 = r0.toByteArray()
            java.lang.String r0 = "outputStream.toByteArray()"
            kotlin.jvm.internal.IIX0o.oO(r4, r0)
            return r4
        L_0x0058:
            r4 = move-exception
            goto L_0x0060
        L_0x005a:
            throw r4     // Catch:{ all -> 0x005b }
        L_0x005b:
            r2 = move-exception
            kotlin.io.II0xO0.oIX0oI(r1, r4)     // Catch:{ all -> 0x0058 }
            throw r2     // Catch:{ all -> 0x0058 }
        L_0x0060:
            throw r4     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r1 = move-exception
            kotlin.io.II0xO0.oIX0oI(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.setOfTriggersToByteArray(java.util.Set):byte[]");
    }

    @TypeConverter
    @x0XOIxOo
    public static final int stateToInt(@OOXIXo WorkInfo.State state) {
        IIX0o.x0xO0oo(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        kotlin.io.II0xO0.oIX0oI(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
        throw r1;
     */
    @androidx.room.TypeConverter
    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.work.impl.utils.NetworkRequestCompat toNetworkRequest$work_runtime_release(@OXOo.OOXIXo byte[] r7) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            r2 = 0
            if (r0 < r1) goto L_0x005b
            int r0 = r7.length
            if (r0 != 0) goto L_0x0010
            goto L_0x005b
        L_0x0010:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r7)
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch:{ all -> 0x004d }
            r7.<init>(r0)     // Catch:{ all -> 0x004d }
            int r1 = r7.readInt()     // Catch:{ all -> 0x002d }
            int[] r3 = new int[r1]     // Catch:{ all -> 0x002d }
            r4 = 0
            r5 = 0
        L_0x0022:
            if (r5 >= r1) goto L_0x002f
            int r6 = r7.readInt()     // Catch:{ all -> 0x002d }
            r3[r5] = r6     // Catch:{ all -> 0x002d }
            int r5 = r5 + 1
            goto L_0x0022
        L_0x002d:
            r1 = move-exception
            goto L_0x004f
        L_0x002f:
            int r1 = r7.readInt()     // Catch:{ all -> 0x002d }
            int[] r5 = new int[r1]     // Catch:{ all -> 0x002d }
        L_0x0035:
            if (r4 >= r1) goto L_0x0040
            int r6 = r7.readInt()     // Catch:{ all -> 0x002d }
            r5[r4] = r6     // Catch:{ all -> 0x002d }
            int r4 = r4 + 1
            goto L_0x0035
        L_0x0040:
            androidx.work.impl.utils.NetworkRequest28 r1 = androidx.work.impl.utils.NetworkRequest28.INSTANCE     // Catch:{ all -> 0x002d }
            androidx.work.impl.utils.NetworkRequestCompat r1 = r1.createNetworkRequestCompat$work_runtime_release(r5, r3)     // Catch:{ all -> 0x002d }
            kotlin.io.II0xO0.oIX0oI(r7, r2)     // Catch:{ all -> 0x004d }
            kotlin.io.II0xO0.oIX0oI(r0, r2)
            return r1
        L_0x004d:
            r7 = move-exception
            goto L_0x0055
        L_0x004f:
            throw r1     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r2 = move-exception
            kotlin.io.II0xO0.oIX0oI(r7, r1)     // Catch:{ all -> 0x004d }
            throw r2     // Catch:{ all -> 0x004d }
        L_0x0055:
            throw r7     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r1 = move-exception
            kotlin.io.II0xO0.oIX0oI(r0, r7)
            throw r1
        L_0x005b:
            androidx.work.impl.utils.NetworkRequestCompat r7 = new androidx.work.impl.utils.NetworkRequestCompat
            r7.<init>(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.toNetworkRequest$work_runtime_release(byte[]):androidx.work.impl.utils.NetworkRequestCompat");
    }
}
