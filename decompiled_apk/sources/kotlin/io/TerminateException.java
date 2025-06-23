package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(@OXOo.OOXIXo File file) {
        super(file, null, null, 6, null);
        IIX0o.x0xO0oo(file, "file");
    }
}
