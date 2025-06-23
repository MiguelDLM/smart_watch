package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ConnectionReuseStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderIterator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.TokenIterator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpHead;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicTokenIterator;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes10.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ((httpRequest != null && httpRequest.getRequestLine().getMethod().equalsIgnoreCase(HttpHead.METHOD_NAME)) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }

    public TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x008f, code lost:
    
        if (java.lang.Integer.parseInt(r9[0].getValue()) < 0) goto L33;
     */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean keepAlive(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse r8, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext r9) {
        /*
            r7 = this;
            java.lang.String r0 = "HTTP response"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args.notNull(r8, r0)
            java.lang.String r0 = "HTTP context"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args.notNull(r9, r0)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.StatusLine r0 = r8.getStatusLine()
            int r0 = r0.getStatusCode()
            r1 = 204(0xcc, float:2.86E-43)
            java.lang.String r2 = "Transfer-Encoding"
            java.lang.String r3 = "Content-Length"
            r4 = 0
            if (r0 != r1) goto L34
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header r0 = r8.getFirstHeader(r3)
            if (r0 == 0) goto L2d
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.NumberFormatException -> L2c
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L2c
            if (r0 <= 0) goto L2d
            return r4
        L2c:
        L2d:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header r0 = r8.getFirstHeader(r2)
            if (r0 == 0) goto L34
            return r4
        L34:
            java.lang.String r0 = "http.request"
            java.lang.Object r9 = r9.getAttribute(r0)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest r9 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest) r9
            java.lang.String r0 = "Close"
            java.lang.String r1 = "Connection"
            if (r9 == 0) goto L5c
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicTokenIterator r5 = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicTokenIterator     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> L5b
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderIterator r6 = r9.headerIterator(r1)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> L5b
            r5.<init>(r6)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> L5b
        L4b:
            boolean r6 = r5.hasNext()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> L5b
            if (r6 == 0) goto L5c
            java.lang.String r6 = r5.nextToken()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> L5b
            boolean r6 = r0.equalsIgnoreCase(r6)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> L5b
            if (r6 == 0) goto L4b
        L5b:
            return r4
        L5c:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.StatusLine r5 = r8.getStatusLine()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolVersion r5 = r5.getProtocolVersion()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header r2 = r8.getFirstHeader(r2)
            r6 = 1
            if (r2 == 0) goto L78
            java.lang.String r9 = "chunked"
            java.lang.String r2 = r2.getValue()
            boolean r9 = r9.equalsIgnoreCase(r2)
            if (r9 != 0) goto L92
            return r4
        L78:
            boolean r9 = r7.canResponseHaveBody(r9, r8)
            if (r9 == 0) goto L92
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header[] r9 = r8.getHeaders(r3)
            int r2 = r9.length
            if (r2 != r6) goto L91
            r9 = r9[r4]
            java.lang.String r9 = r9.getValue()     // Catch: java.lang.NumberFormatException -> L91
            int r9 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.NumberFormatException -> L91
            if (r9 >= 0) goto L92
        L91:
            return r4
        L92:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderIterator r9 = r8.headerIterator(r1)
            boolean r1 = r9.hasNext()
            if (r1 != 0) goto La2
            java.lang.String r9 = "Proxy-Connection"
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderIterator r9 = r8.headerIterator(r9)
        La2:
            boolean r8 = r9.hasNext()
            if (r8 == 0) goto Lcd
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicTokenIterator r8 = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicTokenIterator     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> Lcc
            r8.<init>(r9)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> Lcc
            r9 = 0
        Lae:
            boolean r1 = r8.hasNext()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> Lcc
            if (r1 == 0) goto Lc9
            java.lang.String r1 = r8.nextToken()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> Lcc
            boolean r2 = r0.equalsIgnoreCase(r1)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> Lcc
            if (r2 == 0) goto Lbf
            return r4
        Lbf:
            java.lang.String r2 = "Keep-Alive"
            boolean r1 = r2.equalsIgnoreCase(r1)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException -> Lcc
            if (r1 == 0) goto Lae
            r9 = 1
            goto Lae
        Lc9:
            if (r9 == 0) goto Lcd
            return r6
        Lcc:
            return r4
        Lcd:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion r8 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion.HTTP_1_0
            boolean r8 = r5.lessEquals(r8)
            r8 = r8 ^ r6
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.DefaultConnectionReuseStrategy.keepAlive(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext):boolean");
    }
}
