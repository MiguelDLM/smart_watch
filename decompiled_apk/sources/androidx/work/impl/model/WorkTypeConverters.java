package androidx.work.impl.model;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.room.TypeConverter;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.utils.NetworkRequest28;
import androidx.work.impl.utils.NetworkRequestCompat;
import androidx.work.impl.utils.NetworkRequestCompatKt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWorkTypeConverters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkTypeConverters.kt\nandroidx/work/impl/model/WorkTypeConverters\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,315:1\n1#2:316\n13600#3,2:317\n13600#3,2:319\n*S KotlinDebug\n*F\n+ 1 WorkTypeConverters.kt\nandroidx/work/impl/model/WorkTypeConverters\n*L\n307#1:317,2\n309#1:319,2\n*E\n"})
/* loaded from: classes.dex */
public final class WorkTypeConverters {

    @OOXIXo
    public static final WorkTypeConverters INSTANCE = new WorkTypeConverters();

    /* loaded from: classes.dex */
    public static final class BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;

        @OOXIXo
        public static final BackoffPolicyIds INSTANCE = new BackoffPolicyIds();
        public static final int LINEAR = 1;

        private BackoffPolicyIds() {
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;

        @OOXIXo
        public static final OutOfPolicyIds INSTANCE = new OutOfPolicyIds();
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;

        private OutOfPolicyIds() {
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[WorkInfo.State.values().length];
            try {
                iArr[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BackoffPolicy.values().length];
            try {
                iArr2[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[NetworkType.values().length];
            try {
                iArr3[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[OutOfQuotaPolicy.values().length];
            try {
                iArr4[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private WorkTypeConverters() {
    }

    @x0XOIxOo
    @TypeConverter
    public static final int backoffPolicyToInt(@OOXIXo BackoffPolicy backoffPolicy) {
        IIX0o.x0xO0oo(backoffPolicy, "backoffPolicy");
        int i = WhenMappings.$EnumSwitchMapping$1[backoffPolicy.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 0;
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final Set<Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(@OOXIXo byte[] bytes) {
        ObjectInputStream objectInputStream;
        IIX0o.x0xO0oo(bytes, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bytes.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                int readInt = objectInputStream.readInt();
                for (int i = 0; i < readInt; i++) {
                    Uri uri = Uri.parse(objectInputStream.readUTF());
                    boolean readBoolean = objectInputStream.readBoolean();
                    IIX0o.oO(uri, "uri");
                    linkedHashSet.add(new Constraints.ContentUriTrigger(uri, readBoolean));
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                kotlin.io.II0xO0.oIX0oI(objectInputStream, null);
                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                kotlin.io.II0xO0.oIX0oI(byteArrayInputStream, null);
                return linkedHashSet;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.II0xO0.oIX0oI(byteArrayInputStream, th);
                throw th2;
            }
        }
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final byte[] fromNetworkRequest$work_runtime_release(@OOXIXo NetworkRequestCompat requestCompat) {
        IIX0o.x0xO0oo(requestCompat, "requestCompat");
        if (Build.VERSION.SDK_INT < 28) {
            return new byte[0];
        }
        NetworkRequest networkRequest = requestCompat.getNetworkRequest();
        if (networkRequest == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                int[] transportTypesCompat = NetworkRequestCompatKt.getTransportTypesCompat(networkRequest);
                int[] capabilitiesCompat = NetworkRequestCompatKt.getCapabilitiesCompat(networkRequest);
                objectOutputStream.writeInt(transportTypesCompat.length);
                for (int i : transportTypesCompat) {
                    objectOutputStream.writeInt(i);
                }
                objectOutputStream.writeInt(capabilitiesCompat.length);
                for (int i2 : capabilitiesCompat) {
                    objectOutputStream.writeInt(i2);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                kotlin.io.II0xO0.oIX0oI(objectOutputStream, null);
                kotlin.io.II0xO0.oIX0oI(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                IIX0o.oO(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.II0xO0.oIX0oI(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final BackoffPolicy intToBackoffPolicy(int i) {
        if (i != 0) {
            if (i == 1) {
                return BackoffPolicy.LINEAR;
            }
            throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
        }
        return BackoffPolicy.EXPONENTIAL;
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final NetworkType intToNetworkType(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (Build.VERSION.SDK_INT >= 30 && i == 5) {
                                return NetworkType.TEMPORARILY_UNMETERED;
                            }
                            throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
                        }
                        return NetworkType.METERED;
                    }
                    return NetworkType.NOT_ROAMING;
                }
                return NetworkType.UNMETERED;
            }
            return NetworkType.CONNECTED;
        }
        return NetworkType.NOT_REQUIRED;
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int i) {
        if (i != 0) {
            if (i == 1) {
                return OutOfQuotaPolicy.DROP_WORK_REQUEST;
            }
            throw new IllegalArgumentException("Could not convert " + i + " to OutOfQuotaPolicy");
        }
        return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final WorkInfo.State intToState(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return WorkInfo.State.CANCELLED;
                            }
                            throw new IllegalArgumentException("Could not convert " + i + " to State");
                        }
                        return WorkInfo.State.BLOCKED;
                    }
                    return WorkInfo.State.FAILED;
                }
                return WorkInfo.State.SUCCEEDED;
            }
            return WorkInfo.State.RUNNING;
        }
        return WorkInfo.State.ENQUEUED;
    }

    @x0XOIxOo
    @TypeConverter
    public static final int networkTypeToInt(@OOXIXo NetworkType networkType) {
        IIX0o.x0xO0oo(networkType, "networkType");
        int i = WhenMappings.$EnumSwitchMapping$2[networkType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            if (i != 3) {
                if (i == 4) {
                    return 3;
                }
                if (i != 5) {
                    if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
                        return 5;
                    }
                    throw new IllegalArgumentException("Could not convert " + networkType + " to int");
                }
                return 4;
            }
            return 2;
        }
        return 0;
    }

    @x0XOIxOo
    @TypeConverter
    public static final int outOfQuotaPolicyToInt(@OOXIXo OutOfQuotaPolicy policy) {
        IIX0o.x0xO0oo(policy, "policy");
        int i = WhenMappings.$EnumSwitchMapping$3[policy.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 0;
    }

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final byte[] setOfTriggersToByteArray(@OOXIXo Set<Constraints.ContentUriTrigger> triggers) {
        IIX0o.x0xO0oo(triggers, "triggers");
        if (triggers.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(triggers.size());
                for (Constraints.ContentUriTrigger contentUriTrigger : triggers) {
                    objectOutputStream.writeUTF(contentUriTrigger.getUri().toString());
                    objectOutputStream.writeBoolean(contentUriTrigger.isTriggeredForDescendants());
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                kotlin.io.II0xO0.oIX0oI(objectOutputStream, null);
                kotlin.io.II0xO0.oIX0oI(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                IIX0o.oO(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.II0xO0.oIX0oI(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    @x0XOIxOo
    @TypeConverter
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

    @x0XOIxOo
    @OOXIXo
    @TypeConverter
    public static final NetworkRequestCompat toNetworkRequest$work_runtime_release(@OOXIXo byte[] bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        if (Build.VERSION.SDK_INT >= 28 && bytes.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    int readInt = objectInputStream.readInt();
                    int[] iArr = new int[readInt];
                    for (int i = 0; i < readInt; i++) {
                        iArr[i] = objectInputStream.readInt();
                    }
                    int readInt2 = objectInputStream.readInt();
                    int[] iArr2 = new int[readInt2];
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        iArr2[i2] = objectInputStream.readInt();
                    }
                    NetworkRequestCompat createNetworkRequestCompat$work_runtime_release = NetworkRequest28.INSTANCE.createNetworkRequestCompat$work_runtime_release(iArr2, iArr);
                    kotlin.io.II0xO0.oIX0oI(objectInputStream, null);
                    kotlin.io.II0xO0.oIX0oI(byteArrayInputStream, null);
                    return createNetworkRequestCompat$work_runtime_release;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.II0xO0.oIX0oI(byteArrayInputStream, th);
                    throw th2;
                }
            }
        } else {
            return new NetworkRequestCompat(null);
        }
    }
}
