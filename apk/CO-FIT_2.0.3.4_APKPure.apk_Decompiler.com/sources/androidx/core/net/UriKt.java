package androidx.core.net;

import OXOo.OOXIXo;
import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class UriKt {
    @OOXIXo
    public static final File toFile(@OOXIXo Uri uri) {
        if (IIX0o.Oxx0IOOO(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    @OOXIXo
    public static final Uri toUri(@OOXIXo String str) {
        return Uri.parse(str);
    }

    @OOXIXo
    public static final Uri toUri(@OOXIXo File file) {
        return Uri.fromFile(file);
    }
}
