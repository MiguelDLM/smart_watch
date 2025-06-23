package androidx.room;

public final /* synthetic */ class OxxIIOOXO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f459XO;

    public /* synthetic */ OxxIIOOXO(QueryInterceptorStatement queryInterceptorStatement) {
        this.f459XO = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.executeInsert$lambda$2(this.f459XO);
    }
}
