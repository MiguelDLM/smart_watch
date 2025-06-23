package okhttp3.internal.io;

import OXOo.OOXIXo;
import XO0OX.XO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;
import okio.Source;

/* loaded from: classes6.dex */
public interface FileSystem {

    @OOXIXo
    public static final Companion Companion = Companion.$$INSTANCE;

    @OOXIXo
    @XO
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* loaded from: classes6.dex */
        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            @OOXIXo
            public Sink appendingSink(@OOXIXo File file) throws FileNotFoundException {
                IIX0o.x0xO0oo(file, "file");
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(@OOXIXo File file) throws IOException {
                IIX0o.x0xO0oo(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(@OOXIXo File directory) throws IOException {
                IIX0o.x0xO0oo(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isDirectory()) {
                            IIX0o.oO(file, "file");
                            deleteContents(file);
                        }
                        if (!file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + directory);
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(@OOXIXo File file) {
                IIX0o.x0xO0oo(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(@OOXIXo File from, @OOXIXo File to) throws IOException {
                IIX0o.x0xO0oo(from, "from");
                IIX0o.x0xO0oo(to, "to");
                delete(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // okhttp3.internal.io.FileSystem
            @OOXIXo
            public Sink sink(@OOXIXo File file) throws FileNotFoundException {
                Sink sink$default;
                Sink sink$default2;
                IIX0o.x0xO0oo(file, "file");
                try {
                    sink$default2 = Okio__JvmOkioKt.sink$default(file, false, 1, null);
                    return sink$default2;
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    sink$default = Okio__JvmOkioKt.sink$default(file, false, 1, null);
                    return sink$default;
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(@OOXIXo File file) {
                IIX0o.x0xO0oo(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            @OOXIXo
            public Source source(@OOXIXo File file) throws FileNotFoundException {
                IIX0o.x0xO0oo(file, "file");
                return Okio.source(file);
            }

            @OOXIXo
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    @OOXIXo
    Sink appendingSink(@OOXIXo File file) throws FileNotFoundException;

    void delete(@OOXIXo File file) throws IOException;

    void deleteContents(@OOXIXo File file) throws IOException;

    boolean exists(@OOXIXo File file);

    void rename(@OOXIXo File file, @OOXIXo File file2) throws IOException;

    @OOXIXo
    Sink sink(@OOXIXo File file) throws FileNotFoundException;

    long size(@OOXIXo File file);

    @OOXIXo
    Source source(@OOXIXo File file) throws FileNotFoundException;
}
