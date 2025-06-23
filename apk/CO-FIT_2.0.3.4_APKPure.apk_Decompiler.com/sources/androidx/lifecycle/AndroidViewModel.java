package androidx.lifecycle;

import OXOo.OOXIXo;
import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.IIX0o;

public class AndroidViewModel extends ViewModel {
    @OOXIXo
    private final Application application;

    public AndroidViewModel(@OOXIXo Application application2) {
        IIX0o.x0xO0oo(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    @OOXIXo
    public <T extends Application> T getApplication() {
        T t = this.application;
        IIX0o.x0XOIxOo(t, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t;
    }
}
