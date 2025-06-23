package androidx.work.impl.utils;

import OXOo.OOXIXo;
import android.app.Application;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(28)
final class Api28Impl {
    @OOXIXo
    public static final Api28Impl INSTANCE = new Api28Impl();

    private Api28Impl() {
    }

    @OOXIXo
    public final String getProcessName() {
        String processName = Application.getProcessName();
        IIX0o.oO(processName, "getProcessName()");
        return processName;
    }
}
