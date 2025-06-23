package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {

    @OXOo.OOXIXo
    private final Application application;

    public AndroidViewModel(@OXOo.OOXIXo Application application) {
        IIX0o.x0xO0oo(application, "application");
        this.application = application;
    }

    @OXOo.OOXIXo
    public <T extends Application> T getApplication() {
        T t = (T) this.application;
        IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t;
    }
}
