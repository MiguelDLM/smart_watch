package com.androidnetworking.internal;

import com.androidnetworking.interfaces.UploadProgressListener;
import com.androidnetworking.model.Progress;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes.dex */
public class RequestProgressBody extends RequestBody {
    private BufferedSink bufferedSink;
    private final RequestBody requestBody;
    private UploadProgressHandler uploadProgressHandler;

    public RequestProgressBody(RequestBody requestBody, UploadProgressListener uploadProgressListener) {
        this.requestBody = requestBody;
        if (uploadProgressListener != null) {
            this.uploadProgressHandler = new UploadProgressHandler(uploadProgressListener);
        }
    }

    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) { // from class: com.androidnetworking.internal.RequestProgressBody.1
            long bytesWritten = 0;
            long contentLength = 0;

            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                super.write(buffer, j);
                if (this.contentLength == 0) {
                    this.contentLength = RequestProgressBody.this.contentLength();
                }
                this.bytesWritten += j;
                if (RequestProgressBody.this.uploadProgressHandler != null) {
                    RequestProgressBody.this.uploadProgressHandler.obtainMessage(1, new Progress(this.bytesWritten, this.contentLength)).sendToTarget();
                }
            }
        };
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (this.bufferedSink == null) {
            this.bufferedSink = Okio.buffer(sink(bufferedSink));
        }
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
    }
}
