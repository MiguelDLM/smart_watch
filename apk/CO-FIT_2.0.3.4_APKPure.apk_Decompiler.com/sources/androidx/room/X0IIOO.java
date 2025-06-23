package androidx.room;

public final /* synthetic */ class X0IIOO implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ TransactionExecutor f460Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Runnable f461XO;

    public /* synthetic */ X0IIOO(Runnable runnable, TransactionExecutor transactionExecutor) {
        this.f461XO = runnable;
        this.f460Oo = transactionExecutor;
    }

    public final void run() {
        TransactionExecutor.execute$lambda$1$lambda$0(this.f461XO, this.f460Oo);
    }
}
