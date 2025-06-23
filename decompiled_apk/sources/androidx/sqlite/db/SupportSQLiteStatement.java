package androidx.sqlite.db;

import OXOo.oOoXoXO;

/* loaded from: classes.dex */
public interface SupportSQLiteStatement extends SupportSQLiteProgram {
    void execute();

    long executeInsert();

    int executeUpdateDelete();

    long simpleQueryForLong();

    @oOoXoXO
    String simpleQueryForString();
}
