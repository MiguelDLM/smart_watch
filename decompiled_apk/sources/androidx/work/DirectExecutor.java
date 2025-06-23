package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(@OXOo.OOXIXo Runnable command) {
        IIX0o.x0xO0oo(command, "command");
        command.run();
    }

    @Override // java.lang.Enum
    @OXOo.OOXIXo
    public String toString() {
        return "DirectExecutor";
    }
}
