package androidx.fragment.app;

import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.util.Consumer;

public final /* synthetic */ class Oxx0IOOO implements Consumer {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f399XO;

    public /* synthetic */ Oxx0IOOO(FragmentManager fragmentManager) {
        this.f399XO = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f399XO.lambda$new$2((MultiWindowModeChangedInfo) obj);
    }
}
