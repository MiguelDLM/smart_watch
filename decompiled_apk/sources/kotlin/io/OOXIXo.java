package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public class OOXIXo extends FilesKt__FileReadWriteKt {
    @OXOo.OOXIXo
    public static final II0XooXoX IoOoX(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        return oo0xXOI0I(file, FileWalkDirection.BOTTOM_UP);
    }

    @OXOo.OOXIXo
    public static final II0XooXoX oOXoIIIo(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        return oo0xXOI0I(file, FileWalkDirection.TOP_DOWN);
    }

    public static /* synthetic */ II0XooXoX oo(File file, FileWalkDirection fileWalkDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return oo0xXOI0I(file, fileWalkDirection);
    }

    @OXOo.OOXIXo
    public static final II0XooXoX oo0xXOI0I(@OXOo.OOXIXo File file, @OXOo.OOXIXo FileWalkDirection direction) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(direction, "direction");
        return new II0XooXoX(file, direction);
    }
}
