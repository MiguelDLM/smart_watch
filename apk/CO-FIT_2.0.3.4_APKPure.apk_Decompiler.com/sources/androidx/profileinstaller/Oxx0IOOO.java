package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class Oxx0IOOO implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Context f437XO;

    public /* synthetic */ Oxx0IOOO(Context context) {
        this.f437XO = context;
    }

    public final void run() {
        ProfileInstallerInitializer.writeInBackground(this.f437XO);
    }
}
