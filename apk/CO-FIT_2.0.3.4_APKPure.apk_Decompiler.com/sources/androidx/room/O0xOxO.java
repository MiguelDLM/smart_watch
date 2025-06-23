package androidx.room;

public final /* synthetic */ class O0xOxO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ RoomTrackingLiveData f451XO;

    public /* synthetic */ O0xOxO(RoomTrackingLiveData roomTrackingLiveData) {
        this.f451XO = roomTrackingLiveData;
    }

    public final void run() {
        RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f451XO);
    }
}
