package androidx.work;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public enum DirectExecutor implements Executor {
    INSTANCE;

    public void execute(@OOXIXo Runnable runnable) {
        IIX0o.x0xO0oo(runnable, "command");
        runnable.run();
    }

    @OOXIXo
    public String toString() {
        return "DirectExecutor";
    }
}
