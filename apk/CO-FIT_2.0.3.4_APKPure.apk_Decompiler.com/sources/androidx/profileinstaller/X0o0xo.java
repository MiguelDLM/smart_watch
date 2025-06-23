package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class X0o0xo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Object f438IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f439Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f440XO;

    public /* synthetic */ X0o0xo(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj) {
        this.f440XO = diagnosticsCallback;
        this.f439Oo = i;
        this.f438IXxxXO = obj;
    }

    public final void run() {
        this.f440XO.onDiagnosticReceived(this.f439Oo, this.f438IXxxXO);
    }
}
