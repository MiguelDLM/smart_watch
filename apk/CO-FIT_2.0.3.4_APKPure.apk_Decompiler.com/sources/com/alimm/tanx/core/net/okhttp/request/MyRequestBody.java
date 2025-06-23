package com.alimm.tanx.core.net.okhttp.request;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class MyRequestBody extends RequestBody {
    protected RequestBody tanxc_do;
    protected tanxc_do tanxc_for;
    protected Listener tanxc_if;

    public interface Listener {
        void onRequestProgress(long j, long j2);
    }

    public final class tanxc_do extends ForwardingSink {
        private long tanxc_if = 0;

        public tanxc_do(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            long j2 = this.tanxc_if + j;
            this.tanxc_if = j2;
            MyRequestBody myRequestBody = MyRequestBody.this;
            myRequestBody.tanxc_if.onRequestProgress(j2, myRequestBody.contentLength());
        }
    }

    public long contentLength() {
        try {
            return this.tanxc_do.contentLength();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public MediaType contentType() {
        return this.tanxc_do.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        tanxc_do tanxc_do2 = new tanxc_do(bufferedSink);
        this.tanxc_for = tanxc_do2;
        BufferedSink buffer = Okio.buffer((Sink) tanxc_do2);
        this.tanxc_do.writeTo(buffer);
        buffer.flush();
    }
}
