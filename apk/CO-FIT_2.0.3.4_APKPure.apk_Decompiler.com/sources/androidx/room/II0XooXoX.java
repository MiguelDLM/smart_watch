package androidx.room;

public final /* synthetic */ class II0XooXoX implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f447XO;

    public /* synthetic */ II0XooXoX(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f447XO = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.f447XO);
    }
}
