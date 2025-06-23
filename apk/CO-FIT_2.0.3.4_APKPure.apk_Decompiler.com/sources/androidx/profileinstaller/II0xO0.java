package androidx.profileinstaller;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Object f434IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f435Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ DeviceProfileWriter f436XO;

    public /* synthetic */ II0xO0(DeviceProfileWriter deviceProfileWriter, int i, Object obj) {
        this.f436XO = deviceProfileWriter;
        this.f435Oo = i;
        this.f434IXxxXO = obj;
    }

    public final void run() {
        this.f436XO.lambda$result$0(this.f435Oo, this.f434IXxxXO);
    }
}
