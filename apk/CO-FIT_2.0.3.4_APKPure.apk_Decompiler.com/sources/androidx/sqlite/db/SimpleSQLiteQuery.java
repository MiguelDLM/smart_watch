package androidx.sqlite.db;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @oOoXoXO
    private final Object[] bindArgs;
    @OOXIXo
    private final String query;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public final void bind(@OOXIXo SupportSQLiteProgram supportSQLiteProgram, @oOoXoXO Object[] objArr) {
            IIX0o.x0xO0oo(supportSQLiteProgram, "statement");
            if (objArr != null) {
                int length = objArr.length;
                int i = 0;
                while (i < length) {
                    Object obj = objArr[i];
                    i++;
                    bind(supportSQLiteProgram, i, obj);
                }
            }
        }

        private Companion() {
        }

        private final void bind(SupportSQLiteProgram supportSQLiteProgram, int i, Object obj) {
            if (obj == null) {
                supportSQLiteProgram.bindNull(i);
            } else if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i, (byte[]) obj);
            } else if (obj instanceof Float) {
                supportSQLiteProgram.bindDouble(i, (double) ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                supportSQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                supportSQLiteProgram.bindLong(i, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                supportSQLiteProgram.bindLong(i, (long) ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                supportSQLiteProgram.bindLong(i, (long) ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                supportSQLiteProgram.bindLong(i, (long) ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                supportSQLiteProgram.bindString(i, (String) obj);
            } else if (obj instanceof Boolean) {
                supportSQLiteProgram.bindLong(i, ((Boolean) obj).booleanValue() ? 1 : 0);
            } else {
                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
            }
        }
    }

    public SimpleSQLiteQuery(@OOXIXo String str, @oOoXoXO Object[] objArr) {
        IIX0o.x0xO0oo(str, "query");
        this.query = str;
        this.bindArgs = objArr;
    }

    @x0XOIxOo
    public static final void bind(@OOXIXo SupportSQLiteProgram supportSQLiteProgram, @oOoXoXO Object[] objArr) {
        Companion.bind(supportSQLiteProgram, objArr);
    }

    public void bindTo(@OOXIXo SupportSQLiteProgram supportSQLiteProgram) {
        IIX0o.x0xO0oo(supportSQLiteProgram, "statement");
        Companion.bind(supportSQLiteProgram, this.bindArgs);
    }

    public int getArgCount() {
        Object[] objArr = this.bindArgs;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    @OOXIXo
    public String getSql() {
        return this.query;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(@OOXIXo String str) {
        this(str, (Object[]) null);
        IIX0o.x0xO0oo(str, "query");
    }
}
