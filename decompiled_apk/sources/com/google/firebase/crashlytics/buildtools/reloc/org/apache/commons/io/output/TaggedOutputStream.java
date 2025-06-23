package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.TaggedIOException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes10.dex */
public class TaggedOutputStream extends ProxyOutputStream {
    private final Serializable tag;

    public TaggedOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.tag = UUID.randomUUID();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.ProxyOutputStream
    public void handleIOException(IOException iOException) throws IOException {
        throw new TaggedIOException(iOException, this.tag);
    }

    public boolean isCauseOf(Exception exc) {
        return TaggedIOException.isTaggedWith(exc, this.tag);
    }

    public void throwIfCauseOf(Exception exc) throws IOException {
        TaggedIOException.throwCauseIfTaggedWith(exc, this.tag);
    }
}
