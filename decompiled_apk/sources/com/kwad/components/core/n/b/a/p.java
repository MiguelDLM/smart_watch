package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.bw;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes11.dex */
final class p implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return bw.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return bw.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        bw.zipFile(file);
    }
}
