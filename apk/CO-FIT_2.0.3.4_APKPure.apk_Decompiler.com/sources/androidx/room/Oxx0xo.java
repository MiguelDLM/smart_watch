package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class Oxx0xo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f456IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f457Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f458XO;

    public /* synthetic */ Oxx0xo(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f458XO = queryInterceptorDatabase;
        this.f457Oo = supportSQLiteQuery;
        this.f456IXxxXO = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$9(this.f458XO, this.f457Oo, this.f456IXxxXO);
    }
}
