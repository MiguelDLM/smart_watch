package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* loaded from: classes10.dex */
public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.io.Writer initWriter(java.io.File r3, java.lang.Object r4, boolean r5) throws java.io.IOException {
        /*
            if (r3 == 0) goto L4e
            if (r4 == 0) goto L46
            boolean r0 = r3.exists()
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r2.<init>(r3, r5)     // Catch: java.lang.RuntimeException -> L33 java.io.IOException -> L35
            boolean r5 = r4 instanceof java.nio.charset.Charset     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            if (r5 == 0) goto L1f
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            java.nio.charset.Charset r4 = (java.nio.charset.Charset) r4     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            r5.<init>(r2, r4)     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            return r5
        L1a:
            r4 = move-exception
        L1b:
            r1 = r2
            goto L36
        L1d:
            r4 = move-exception
            goto L1b
        L1f:
            boolean r5 = r4 instanceof java.nio.charset.CharsetEncoder     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            if (r5 == 0) goto L2b
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            java.nio.charset.CharsetEncoder r4 = (java.nio.charset.CharsetEncoder) r4     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            r5.<init>(r2, r4)     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            return r5
        L2b:
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            r5.<init>(r2, r4)     // Catch: java.lang.RuntimeException -> L1a java.io.IOException -> L1d
            return r5
        L33:
            r4 = move-exception
            goto L36
        L35:
            r4 = move-exception
        L36:
            if (r1 == 0) goto L40
            r1.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r5 = move-exception
            r4.addSuppressed(r5)
        L40:
            if (r0 != 0) goto L45
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FileUtils.deleteQuietly(r3)
        L45:
            throw r4
        L46:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "Encoding is missing"
            r3.<init>(r4)
            throw r3
        L4e:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "File is missing"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.FileWriterWithEncoding.initWriter(java.io.File, java.lang.Object, boolean):java.io.Writer");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z) throws IOException {
        this(new File(str), str2, z);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z) throws IOException {
        this(new File(str), charset, z);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this(new File(str), charsetEncoder, z);
    }

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z) throws IOException {
        this.out = initWriter(file, str, z);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z) throws IOException {
        this.out = initWriter(file, charset, z);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this.out = initWriter(file, charsetEncoder, z);
    }
}
