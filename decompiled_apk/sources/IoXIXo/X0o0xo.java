package IoXIXo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes11.dex */
public abstract class X0o0xo implements IoXIXo.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ExecutorService f815oIX0oI = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public class oIX0oI implements Callable<Void> {

        /* renamed from: XO, reason: collision with root package name */
        public final File f817XO;

        public oIX0oI(File file) {
            this.f817XO = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            X0o0xo.this.X0o0xo(this.f817XO);
            return null;
        }
    }

    public abstract boolean I0Io(File file, long j, int i);

    public final void II0xO0(List<File> list) {
        long oxoX2 = oxoX(list);
        int size = list.size();
        for (File file : list) {
            if (!I0Io(file, oxoX2, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    oxoX2 -= length;
                    com.octopus.ad.internal.utilities.oIX0oI.IIXOooo(com.octopus.ad.internal.utilities.oIX0oI.f18690Oo, "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18690Oo, "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    public final void X0o0xo(File file) throws IOException {
        oxoX.I0Io(file);
        II0xO0(oxoX.II0xO0(file.getParentFile()));
    }

    @Override // IoXIXo.oIX0oI
    public void a(File file) throws IOException {
        this.f815oIX0oI.submit(new oIX0oI(file));
    }

    public final long oxoX(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }
}
