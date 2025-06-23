package androidx.room;

public final /* synthetic */ class o00 implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f465XO;

    public /* synthetic */ o00(QueryInterceptorStatement queryInterceptorStatement) {
        this.f465XO = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f465XO);
    }
}
