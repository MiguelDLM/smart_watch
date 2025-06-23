package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes6.dex */
public class FileSystemException extends IOException {

    @OXOo.OOXIXo
    private final File file;

    @OXOo.oOoXoXO
    private final File other;

    @OXOo.oOoXoXO
    private final String reason;

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, IIXOooo iIXOooo) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    @OXOo.OOXIXo
    public final File getFile() {
        return this.file;
    }

    @OXOo.oOoXoXO
    public final File getOther() {
        return this.other;
    }

    @OXOo.oOoXoXO
    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FileSystemException(@OXOo.OOXIXo java.io.File r2, @OXOo.oOoXoXO java.io.File r3, @OXOo.oOoXoXO java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = kotlin.io.X0o0xo.oIX0oI(r2, r3, r4)
            r1.<init>(r0)
            r1.file = r2
            r1.other = r3
            r1.reason = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileSystemException.<init>(java.io.File, java.io.File, java.lang.String):void");
    }
}
