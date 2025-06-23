package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.HttpEntityWrapper;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicHeader;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes10.dex */
public class GzipCompressingEntity extends HttpEntityWrapper {
    private static final String GZIP_CODEC = "gzip";

    public GzipCompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.HttpEntityWrapper, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.HttpEntityWrapper, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return new BasicHeader("Content-Encoding", GZIP_CODEC);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.HttpEntityWrapper, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.HttpEntityWrapper, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity
    public boolean isChunked() {
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.HttpEntityWrapper, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        this.wrappedEntity.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
