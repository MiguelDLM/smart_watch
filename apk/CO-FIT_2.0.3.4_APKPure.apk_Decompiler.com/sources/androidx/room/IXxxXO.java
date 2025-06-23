package androidx.room;

public final /* synthetic */ class IXxxXO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f450XO;

    public /* synthetic */ IXxxXO(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f450XO = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f450XO);
    }
}
