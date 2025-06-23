package androidx.room;

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
import kotlin.oXIO0o0XI;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;

    @OXOo.OOXIXo
    private final int[] bindingTypes;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final double[] doubleBindings;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final long[] longBindings;

    @OXOo.oOoXoXO
    private volatile String query;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final String[] stringBindings;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    @Retention(RetentionPolicy.SOURCE)
    @XxI.I0Io(AnnotationRetention.SOURCE)
    /* loaded from: classes.dex */
    public @interface Binding {
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
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

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final RoomSQLiteQuery acquire(@OXOo.OOXIXo String query, int i) {
            IIX0o.x0xO0oo(query, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery sqliteQuery = ceilingEntry.getValue();
                    sqliteQuery.init(query, i);
                    IIX0o.oO(sqliteQuery, "sqliteQuery");
                    return sqliteQuery;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i, null);
                roomSQLiteQuery.init(query, i);
                return roomSQLiteQuery;
            }
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final RoomSQLiteQuery copyFrom(@OXOo.OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
            IIX0o.x0xO0oo(supportSQLiteQuery, "supportSQLiteQuery");
            final RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindBlob(int i, @OXOo.OOXIXo byte[] value) {
                    IIX0o.x0xO0oo(value, "value");
                    RoomSQLiteQuery.this.bindBlob(i, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindDouble(int i, double d) {
                    RoomSQLiteQuery.this.bindDouble(i, d);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindLong(int i, long j) {
                    RoomSQLiteQuery.this.bindLong(i, j);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindNull(int i) {
                    RoomSQLiteQuery.this.bindNull(i);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void bindString(int i, @OXOo.OOXIXo String value) {
                    IIX0o.x0xO0oo(value, "value");
                    RoomSQLiteQuery.this.bindString(i, value);
                }

                @Override // androidx.sqlite.db.SupportSQLiteProgram
                public void clearBindings() {
                    RoomSQLiteQuery.this.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    RoomSQLiteQuery.this.close();
                }
            });
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

    public /* synthetic */ RoomSQLiteQuery(int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final RoomSQLiteQuery acquire(@OXOo.OOXIXo String str, int i) {
        return Companion.acquire(str, i);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final RoomSQLiteQuery copyFrom(@OXOo.OOXIXo SupportSQLiteQuery supportSQLiteQuery) {
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

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, @OXOo.OOXIXo byte[] value) {
        IIX0o.x0xO0oo(value, "value");
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, @OXOo.OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(@OXOo.OOXIXo SupportSQLiteProgram statement) {
        IIX0o.x0xO0oo(statement, "statement");
        int argCount = getArgCount();
        if (1 <= argCount) {
            int i = 1;
            while (true) {
                int i2 = this.bindingTypes[i];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5) {
                                    byte[] bArr = this.blobBindings[i];
                                    if (bArr != null) {
                                        statement.bindBlob(i, bArr);
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.");
                                    }
                                }
                            } else {
                                String str = this.stringBindings[i];
                                if (str != null) {
                                    statement.bindString(i, str);
                                } else {
                                    throw new IllegalArgumentException("Required value was null.");
                                }
                            }
                        } else {
                            statement.bindDouble(i, this.doubleBindings[i]);
                        }
                    } else {
                        statement.bindLong(i, this.longBindings[i]);
                    }
                } else {
                    statement.bindNull(i);
                }
                if (i != argCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, (Object) null);
        Arrays.fill(this.blobBindings, (Object) null);
        this.query = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void copyArgumentsFrom(@OXOo.OOXIXo RoomSQLiteQuery other) {
        IIX0o.x0xO0oo(other, "other");
        int argCount = other.getArgCount() + 1;
        System.arraycopy(other.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(other.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(other.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(other.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(other.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    @OXOo.OOXIXo
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(@OXOo.OOXIXo String query, int i) {
        IIX0o.x0xO0oo(query, "query");
        this.query = query;
        this.argCount = i;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    private RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2];
    }
}
