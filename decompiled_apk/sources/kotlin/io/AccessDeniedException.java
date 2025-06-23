package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public final class AccessDeniedException extends FileSystemException {
    public /* synthetic */ AccessDeniedException(File file, File file2, String str, int i, IIXOooo iIXOooo) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessDeniedException(@OXOo.OOXIXo File file, @OXOo.oOoXoXO File file2, @OXOo.oOoXoXO String str) {
        super(file, file2, str);
        IIX0o.x0xO0oo(file, "file");
    }
}
