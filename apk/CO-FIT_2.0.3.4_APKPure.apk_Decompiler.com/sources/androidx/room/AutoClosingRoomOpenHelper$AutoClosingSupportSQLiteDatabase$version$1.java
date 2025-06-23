package androidx.room;

import OXOo.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

public /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 extends MutablePropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1() {
        super(SupportSQLiteDatabase.class, "version", "getVersion()I", 0);
    }

    @oOoXoXO
    public Object get(@oOoXoXO Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }

    public void set(@oOoXoXO Object obj, @oOoXoXO Object obj2) {
        ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
    }
}
