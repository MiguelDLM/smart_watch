package androidx.lifecycle;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f409XO;

    public /* synthetic */ oIX0oI(ComputableLiveData computableLiveData) {
        this.f409XO = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.refreshRunnable$lambda$0(this.f409XO);
    }
}
