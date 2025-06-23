package IXI;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes6.dex */
public class I0Io implements FileFilter {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ oxoX f650XO;

    public I0Io(oxoX oxox) {
        this.f650XO = oxox;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(oxoX.f653X0o0xo);
    }
}
