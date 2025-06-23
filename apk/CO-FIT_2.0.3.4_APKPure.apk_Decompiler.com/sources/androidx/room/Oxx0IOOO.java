package androidx.room;

public final /* synthetic */ class Oxx0IOOO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f455XO;

    public /* synthetic */ Oxx0IOOO(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f455XO = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.endTransaction$lambda$4(this.f455XO);
    }
}
