package androidx.sqlite.db;

import OXOo.OOXIXo;

/* loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(@OOXIXo SupportSQLiteProgram supportSQLiteProgram);

    int getArgCount();

    @OOXIXo
    String getSql();
}
