package androidx.room;

public final /* synthetic */ class OxI implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ RoomTrackingLiveData f454XO;

    public /* synthetic */ OxI(RoomTrackingLiveData roomTrackingLiveData) {
        this.f454XO = roomTrackingLiveData;
    }

    public final void run() {
        RoomTrackingLiveData.refreshRunnable$lambda$0(this.f454XO);
    }
}
