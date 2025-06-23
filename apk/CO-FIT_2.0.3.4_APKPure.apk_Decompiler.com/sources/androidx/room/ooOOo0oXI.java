package androidx.room;

public final /* synthetic */ class ooOOo0oXI implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f472XO;

    public /* synthetic */ ooOOo0oXI(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f472XO = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f472XO);
    }
}
