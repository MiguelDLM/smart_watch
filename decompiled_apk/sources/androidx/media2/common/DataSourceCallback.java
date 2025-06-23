package androidx.media2.common;

import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class DataSourceCallback implements Closeable {
    public abstract long getSize() throws IOException;

    public abstract int readAt(long j, @NonNull byte[] bArr, int i, int i2) throws IOException;
}
