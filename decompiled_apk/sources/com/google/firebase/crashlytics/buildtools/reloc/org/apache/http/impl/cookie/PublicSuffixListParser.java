package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util.PublicSuffixList;
import java.io.IOException;
import java.io.Reader;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes10.dex */
public class PublicSuffixListParser {
    private final PublicSuffixFilter filter;
    private final com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util.PublicSuffixListParser parser = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util.PublicSuffixListParser();

    public PublicSuffixListParser(PublicSuffixFilter publicSuffixFilter) {
        this.filter = publicSuffixFilter;
    }

    public void parse(Reader reader) throws IOException {
        PublicSuffixList parse = this.parser.parse(reader);
        this.filter.setPublicSuffixes(parse.getRules());
        this.filter.setExceptions(parse.getExceptions());
    }
}
