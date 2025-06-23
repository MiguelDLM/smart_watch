package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;

public final /* synthetic */ class XO implements Choreographer.FrameCallback {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Context f441Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f442XO;

    public /* synthetic */ XO(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f442XO = profileInstallerInitializer;
        this.f441Oo = context;
    }

    public final void doFrame(long j) {
        this.f442XO.lambda$create$0(this.f441Oo, j);
    }
}
