package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class Oxx0xo implements KeyEventDispatcher.Component {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f282XO;

    public /* synthetic */ Oxx0xo(AppCompatDialog appCompatDialog) {
        this.f282XO = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f282XO.superDispatchKeyEvent(keyEvent);
    }
}
