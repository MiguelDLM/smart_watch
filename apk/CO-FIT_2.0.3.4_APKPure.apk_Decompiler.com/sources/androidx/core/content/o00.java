package androidx.core.content;

public final /* synthetic */ class o00 implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection f303XO;

    public /* synthetic */ o00(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f303XO = unusedAppRestrictionsBackportServiceConnection;
    }

    public final void run() {
        this.f303XO.disconnectFromService();
    }
}
