package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Object f443IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f444Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f445XO;

    public /* synthetic */ oxoX(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj) {
        this.f445XO = diagnosticsCallback;
        this.f444Oo = i;
        this.f443IXxxXO = obj;
    }

    public final void run() {
        this.f445XO.onResultReceived(this.f444Oo, this.f443IXxxXO);
    }
}
