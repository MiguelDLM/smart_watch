package kotlin.io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: classes6.dex */
public final class OxI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Path f29246I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Path f29247II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OxI f29248oIX0oI = new OxI();

    static {
        Path path;
        Path path2;
        path = Paths.get("", new String[0]);
        f29247II0xO0 = path;
        path2 = Paths.get("..", new String[0]);
        f29246I0Io = path2;
    }

    @OXOo.OOXIXo
    public final Path oIX0oI(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Path base) {
        Path normalize;
        Path normalize2;
        Path relativize;
        int nameCount;
        int nameCount2;
        FileSystem fileSystem;
        String separator;
        FileSystem fileSystem2;
        FileSystem fileSystem3;
        String separator2;
        Path name;
        Path name2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "path");
        kotlin.jvm.internal.IIX0o.x0xO0oo(base, "base");
        normalize = base.normalize();
        normalize2 = path.normalize();
        relativize = normalize.relativize(normalize2);
        nameCount = normalize.getNameCount();
        nameCount2 = normalize2.getNameCount();
        int min = Math.min(nameCount, nameCount2);
        for (int i = 0; i < min; i++) {
            name = normalize.getName(i);
            Path path2 = f29246I0Io;
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(name, path2)) {
                break;
            }
            name2 = normalize2.getName(i);
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(name2, path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(normalize2, normalize) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(normalize, f29247II0xO0)) {
            String obj = relativize.toString();
            fileSystem = relativize.getFileSystem();
            separator = fileSystem.getSeparator();
            kotlin.jvm.internal.IIX0o.oO(separator, "getSeparator(...)");
            if (kotlin.text.OxI.XO0o(obj, separator, false, 2, null)) {
                fileSystem2 = relativize.getFileSystem();
                fileSystem3 = relativize.getFileSystem();
                separator2 = fileSystem3.getSeparator();
                normalize2 = fileSystem2.getPath(StringsKt___StringsKt.OOOxXxoO(obj, separator2.length()), new String[0]);
            } else {
                normalize2 = relativize;
            }
        }
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(normalize2);
        return normalize2;
    }
}
