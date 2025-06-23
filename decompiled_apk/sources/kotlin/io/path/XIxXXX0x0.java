package kotlin.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class XIxXXX0x0 {
    public static final boolean I0Io(OxxIIOOXO oxxIIOOXO) {
        boolean isSameFile;
        for (OxxIIOOXO I0Io2 = oxxIIOOXO.I0Io(); I0Io2 != null; I0Io2 = I0Io2.I0Io()) {
            if (I0Io2.II0xO0() == null || oxxIIOOXO.II0xO0() == null) {
                try {
                    isSameFile = Files.isSameFile(I0Io2.oxoX(), oxxIIOOXO.oxoX());
                    if (isSameFile) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(I0Io2.II0xO0(), oxxIIOOXO.II0xO0())) {
                return true;
            }
        }
        return false;
    }

    public static final Object oxoX(Path path, LinkOption[] linkOptionArr) {
        BasicFileAttributes readAttributes;
        Object fileKey;
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.I0oOoX.oIX0oI(), (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            kotlin.jvm.internal.IIX0o.oO(readAttributes, "readAttributes(...)");
            fileKey = readAttributes.fileKey();
            return fileKey;
        } catch (Throwable unused) {
            return null;
        }
    }
}
