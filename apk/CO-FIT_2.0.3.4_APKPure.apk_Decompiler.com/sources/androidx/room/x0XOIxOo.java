package androidx.room;

public final /* synthetic */ class x0XOIxOo implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f474XO;

    public /* synthetic */ x0XOIxOo(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f474XO = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.f474XO);
    }
}
