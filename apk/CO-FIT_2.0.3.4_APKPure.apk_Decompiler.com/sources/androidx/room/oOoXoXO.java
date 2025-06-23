package androidx.room;

public final /* synthetic */ class oOoXoXO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f471XO;

    public /* synthetic */ oOoXoXO(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f471XO = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransaction$lambda$0(this.f471XO);
    }
}
