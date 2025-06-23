package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class II0XooXoX implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Context f433XO;

    public /* synthetic */ II0XooXoX(Context context) {
        this.f433XO = context;
    }

    public final void run() {
        ProfileInstaller.writeProfile(this.f433XO);
    }
}
