package com.bluetrum.fota.manager;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes8.dex */
public interface DataReader {
    void close() throws IOException;

    @NonNull
    byte[] getHash() throws IOException;

    int getSize() throws IOException;

    void open() throws IOException;

    int read(int i, byte[] bArr, int i2, int i3) throws IOException;
}
