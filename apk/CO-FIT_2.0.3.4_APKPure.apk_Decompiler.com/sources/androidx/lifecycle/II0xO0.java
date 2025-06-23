package androidx.lifecycle;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f405XO;

    public /* synthetic */ II0xO0(ComputableLiveData computableLiveData) {
        this.f405XO = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.invalidationRunnable$lambda$1(this.f405XO);
    }
}
