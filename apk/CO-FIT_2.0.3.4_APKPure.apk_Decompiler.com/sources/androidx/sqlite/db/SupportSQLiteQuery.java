package androidx.sqlite.db;

import OXOo.OOXIXo;

public interface SupportSQLiteQuery {
    void bindTo(@OOXIXo SupportSQLiteProgram supportSQLiteProgram);

    int getArgCount();

    @OOXIXo
    String getSql();
}
