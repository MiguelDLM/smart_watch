package com.androidnetworking.internal;

import com.androidnetworking.interfaces.DownloadProgressListener;
import com.androidnetworking.model.Progress;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes.dex */
public class ResponseProgressBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private DownloadProgressHandler downloadProgressHandler;
    private final ResponseBody mResponseBody;

    public ResponseProgressBody(ResponseBody responseBody, DownloadProgressListener downloadProgressListener) {
        this.mResponseBody = responseBody;
        if (downloadProgressListener != null) {
            this.downloadProgressHandler = new DownloadProgressHandler(downloadProgressListener);
        }
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.mResponseBody.source()));
        }
        return this.bufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.androidnetworking.internal.ResponseProgressBody.1
            long totalBytesRead;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long j2;
                long read = super.read(buffer, j);
                long j3 = this.totalBytesRead;
                if (read != -1) {
                    j2 = read;
                } else {
                    j2 = 0;
                }
                this.totalBytesRead = j3 + j2;
                if (ResponseProgressBody.this.downloadProgressHandler != null) {
                    ResponseProgressBody.this.downloadProgressHandler.obtainMessage(1, new Progress(this.totalBytesRead, ResponseProgressBody.this.mResponseBody.contentLength())).sendToTarget();
                }
                return read;
            }
        };
    }
}
