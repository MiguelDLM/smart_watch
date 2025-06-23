package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.io;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.HttpMessageWriter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.HttpMessageWriterFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.SessionOutputBuffer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicLineFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.LineFormatter;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes10.dex */
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter) {
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpResponseWriter(sessionOutputBuffer, this.lineFormatter);
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }
}
