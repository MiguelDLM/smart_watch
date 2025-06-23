package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XxI.I0Io;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    @XO
    @OOXIXo
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();
    private int argCount;
    @OOXIXo
    private final int[] bindingTypes;
    @XO
    @OOXIXo
    public final byte[][] blobBindings;
    @VisibleForTesting
    private final int capacity;
    @XO
    @OOXIXo
    public final double[] doubleBindings;
    @XO
    @OOXIXo
    public final long[] longBindings;
    @oOoXoXO
    private volatile String query;
    @XO
    @OOXIXo
    public final String[] stringBindings;

    @I0Io(AnnotationRetention.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }

        @x0XOIxOo
        @OOXIXo
        public final RoomSQLiteQuery acquire(@OOXIXo String str, int i) {
            IIX0o.x0xO0oo(str, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery value = ceilingEntry.getValue();
                    value.init(str, i);
                    IIX0o.oO(value, "sqliteQuery");
                    return value;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i, (IIXOooo) null);
                roomSQLiteQuery.init(str, i);
                return roomSQLiteQuery;
            }
        }

        @x0XOIxOo
        @OOXIXo
        public final RoomSQLiteQuery copyFrom(@OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
            IIX0o.x0xO0oo(supportSQLiteQuery, "supportSQLiteQuery");
            RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new RoomSQLiteQuery$Companion$copyFrom$1(acquire));
            return acquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                IIX0o.oO(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i, IIXOooo iIXOooo) {
        this(i);
    }

    @x0XOIxOo
    @OOXIXo
    public static final RoomSQLiteQuery acquire(@OOXIXo String str, int i) {
        return Companion.acquire(str, i);
    }

    @x0XOIxOo
    @OOXIXo
    public static final RoomSQLiteQuery copyFrom(@OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    public void bindBlob(int i, @OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "value");
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    public void bindDouble(int i, double d) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    public void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    public void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    public void bindString(int i, @OOXIXo String str) {
        IIX0o.x0xO0oo(str, "value");
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    public void bindTo(@OOXIXo SupportSQLiteProgram supportSQLiteProgram) {
        IIX0o.x0xO0oo(supportSQLiteProgram, "statement");
        int argCount2 = getArgCount();
        if (1 <= argCount2) {
            int i = 1;
            while (true) {
                int i2 = this.bindingTypes[i];
                if (i2 == 1) {
                    supportSQLiteProgram.bindNull(i);
                } else if (i2 == 2) {
                    supportSQLiteProgram.bindLong(i, this.longBindings[i]);
                } else if (i2 == 3) {
                    supportSQLiteProgram.bindDouble(i, this.doubleBindings[i]);
                } else if (i2 == 4) {
                    String str = this.stringBindings[i];
                    if (str != null) {
                        supportSQLiteProgram.bindString(i, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else if (i2 == 5) {
                    byte[] bArr = this.blobBindings[i];
                    if (bArr != null) {
                        supportSQLiteProgram.bindBlob(i, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                }
                if (i != argCount2) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, (Object) null);
        Arrays.fill(this.blobBindings, (Object) null);
        this.query = null;
    }

    public void close() {
    }

    public final void copyArgumentsFrom(@OOXIXo RoomSQLiteQuery roomSQLiteQuery) {
        IIX0o.x0xO0oo(roomSQLiteQuery, "other");
        int argCount2 = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount2);
    }

    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @OOXIXo
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(@OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "query");
        this.query = str;
        this.argCount = i;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        }
    }

    private RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2][];
    }
}
