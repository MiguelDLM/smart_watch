package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressTouchableResponseBody<T extends OSSRequest> extends ResponseBody {
    private BufferedSource mBufferedSource;
    /* access modifiers changed from: private */
    public OSSProgressCallback mProgressListener;
    /* access modifiers changed from: private */
    public final ResponseBody mResponseBody;
    /* access modifiers changed from: private */
    public T request;

    public ProgressTouchableResponseBody(ResponseBody responseBody, ExecutionContext executionContext) {
        this.mResponseBody = responseBody;
        this.mProgressListener = executionContext.getProgressCallback();
        this.request = executionContext.getRequest();
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.buffer(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            private long totalBytesRead = 0;

            public long read(Buffer buffer, long j) throws IOException {
                long j2;
                long read = super.read(buffer, j);
                long j3 = this.totalBytesRead;
                int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                if (i != 0) {
                    j2 = read;
                } else {
                    j2 = 0;
                }
                this.totalBytesRead = j3 + j2;
                if (!(ProgressTouchableResponseBody.this.mProgressListener == null || i == 0 || this.totalBytesRead == 0)) {
                    ProgressTouchableResponseBody.this.mProgressListener.onProgress(ProgressTouchableResponseBody.this.request, this.totalBytesRead, ProgressTouchableResponseBody.this.mResponseBody.contentLength());
                }
                return read;
            }
        };
    }
}
