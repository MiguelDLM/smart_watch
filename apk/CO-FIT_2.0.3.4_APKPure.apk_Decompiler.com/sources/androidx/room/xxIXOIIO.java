package androidx.room;

public final /* synthetic */ class xxIXOIIO implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f482Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f483XO;

    public /* synthetic */ xxIXOIIO(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f483XO = queryInterceptorDatabase;
        this.f482Oo = str;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$6(this.f483XO, this.f482Oo);
    }
}
