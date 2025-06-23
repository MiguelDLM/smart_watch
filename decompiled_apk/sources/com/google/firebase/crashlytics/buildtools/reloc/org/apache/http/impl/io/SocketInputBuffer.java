package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.io;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.EofSensor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes10.dex */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.eof = false;
        i = i < 0 ? socket.getReceiveBufferSize() : i;
        init(socket.getInputStream(), i < 1024 ? 1024 : i, httpParams);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.io.AbstractSessionInputBuffer
    public int fillBuffer() throws IOException {
        boolean z;
        int fillBuffer = super.fillBuffer();
        if (fillBuffer == -1) {
            z = true;
        } else {
            z = false;
        }
        this.eof = z;
        return fillBuffer;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (!hasBufferedData) {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(i);
                fillBuffer();
                return hasBufferedData();
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        return hasBufferedData;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
