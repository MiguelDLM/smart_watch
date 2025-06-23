package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class x0xO0oo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f475IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f476Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f477XO;

    public /* synthetic */ x0xO0oo(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f477XO = queryInterceptorDatabase;
        this.f476Oo = supportSQLiteQuery;
        this.f475IXxxXO = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$8(this.f477XO, this.f476Oo, this.f475IXxxXO);
    }
}
