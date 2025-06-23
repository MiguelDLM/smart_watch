package o0oIxXOx;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public final class xxIXOIIO extends oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final oIX0oI f31205I0Io = new xxIXOIIO();

    @Override // o0oIxXOx.OxxIIOOXO
    public String lookup(String str) {
        Path path;
        byte[] readAllBytes;
        if (str == null) {
            return null;
        }
        String[] split = str.split(String.valueOf(':'));
        if (split.length >= 2) {
            String str2 = split[0];
            String O0o02 = xXOx.O0o0(str, 58);
            try {
                path = Paths.get(O0o02, new String[0]);
                readAllBytes = Files.readAllBytes(path);
                return new String(readAllBytes, str2);
            } catch (Exception e) {
                throw oOoXoXO.II0xO0(e, "Error looking up file [%s] with charset [%s].", O0o02, str2);
            }
        }
        throw oOoXoXO.oIX0oI("Bad file key format [%s], expected format is CharsetName:DocumentPath.", str);
    }
}
