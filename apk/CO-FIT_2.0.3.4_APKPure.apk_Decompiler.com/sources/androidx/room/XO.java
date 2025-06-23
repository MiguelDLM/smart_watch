package androidx.room;

public final /* synthetic */ class XO implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String[] f463Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f464XO;

    public /* synthetic */ XO(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        this.f464XO = multiInstanceInvalidationClient;
        this.f463Oo = strArr;
    }

    public final void run() {
        MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(this.f464XO, this.f463Oo);
    }
}
