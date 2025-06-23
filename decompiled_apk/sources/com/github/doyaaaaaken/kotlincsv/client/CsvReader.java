package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext;
import com.github.doyaaaaaken.kotlincsv.dsl.context.ExcessFieldsRowBehaviour;
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oO;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes9.dex */
public final class CsvReader implements OO.II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Charset f15760II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final CsvReaderContext f15761oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public CsvReader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // OO.II0xO0
    public boolean I0Io() {
        return this.f15761oIX0oI.I0Io();
    }

    @Override // OO.II0xO0
    @OOXIXo
    public InsufficientFieldsRowBehaviour II0XooXoX() {
        return this.f15761oIX0oI.II0XooXoX();
    }

    @Override // OO.II0xO0
    @OOXIXo
    public String II0xO0() {
        return this.f15761oIX0oI.II0xO0();
    }

    @OOXIXo
    public final List<Map<String, String>> IIXOooo(@OOXIXo File file) {
        IIX0o.x0xO0oo(file, "file");
        FileInputStream fileInputStream = new FileInputStream(file);
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return (List) OOXIXo(XO.oIX0oI(fileInputStream, charsetCode), new oOoXoXO<CsvFileReader, List<? extends Map<String, ? extends String>>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvReader$readAllWithHeader$2
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final List<Map<String, String>> invoke(@OOXIXo CsvFileReader open) {
                IIX0o.x0xO0oo(open, "$this$open");
                return SequencesKt___SequencesKt.oox000IX(open.xxIXOIIO());
            }
        });
    }

    @OXOo.oOoXoXO
    public final <T> Object IXxxXO(@OOXIXo String str, @OOXIXo x0xO0oo<? super CsvFileReader, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return x0xO0oo(new File(str), x0xo0oo, i0Io);
    }

    public final <T> T OOXIXo(X0o0xo x0o0xo, oOoXoXO<? super CsvFileReader, ? extends T> oooxoxo) {
        CsvFileReader csvFileReader = new CsvFileReader(this.f15761oIX0oI, x0o0xo, getLogger());
        try {
            T invoke = oooxoxo.invoke(csvFileReader);
            csvFileReader.oxoX();
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    csvFileReader.oxoX();
                } catch (Throwable th3) {
                    oO.oIX0oI(th, th3);
                }
                throw th2;
            }
        }
    }

    @OXOo.oOoXoXO
    public final <T> Object Oo(@OOXIXo InputStream inputStream, @OOXIXo x0xO0oo<? super CsvFileReader, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return oO(XO.oIX0oI(inputStream, charsetCode), x0xo0oo, i0Io);
    }

    @Override // OO.II0xO0
    public char Oxx0IOOO() {
        return this.f15761oIX0oI.Oxx0IOOO();
    }

    @OOXIXo
    public final List<List<String>> Oxx0xo(@OOXIXo File file) {
        IIX0o.x0xO0oo(file, "file");
        FileInputStream fileInputStream = new FileInputStream(file);
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return (List) OOXIXo(XO.oIX0oI(fileInputStream, charsetCode), new oOoXoXO<CsvFileReader, List<? extends List<? extends String>>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvReader$readAll$2
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final List<List<String>> invoke(@OOXIXo CsvFileReader open) {
                IIX0o.x0xO0oo(open, "$this$open");
                return SequencesKt___SequencesKt.oox000IX(CsvFileReader.II0XooXoX(open, null, 1, null));
            }
        });
    }

    @OOXIXo
    public final List<List<String>> OxxIIOOXO(@OOXIXo String data) {
        IIX0o.x0xO0oo(data, "data");
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        byte[] bytes = data.getBytes(charsetCode);
        IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Charset charsetCode2 = this.f15760II0xO0;
        IIX0o.oO(charsetCode2, "charsetCode");
        return (List) OOXIXo(XO.oIX0oI(byteArrayInputStream, charsetCode2), new oOoXoXO<CsvFileReader, List<? extends List<? extends String>>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvReader$readAll$1
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final List<List<String>> invoke(@OOXIXo CsvFileReader open) {
                IIX0o.x0xO0oo(open, "$this$open");
                return SequencesKt___SequencesKt.oox000IX(CsvFileReader.II0XooXoX(open, null, 1, null));
            }
        });
    }

    @Override // OO.II0xO0
    @OOXIXo
    public ExcessFieldsRowBehaviour X0o0xo() {
        return this.f15761oIX0oI.X0o0xo();
    }

    @Override // OO.II0xO0
    public boolean XO() {
        return this.f15761oIX0oI.XO();
    }

    @Override // OO.II0xO0
    @OOXIXo
    public xoIxX.oIX0oI getLogger() {
        return this.f15761oIX0oI.getLogger();
    }

    @OOXIXo
    public final List<Map<String, String>> o00(@OOXIXo String data) {
        IIX0o.x0xO0oo(data, "data");
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        byte[] bytes = data.getBytes(charsetCode);
        IIX0o.oO(bytes, "this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Charset charsetCode2 = this.f15760II0xO0;
        IIX0o.oO(charsetCode2, "charsetCode");
        return (List) OOXIXo(XO.oIX0oI(byteArrayInputStream, charsetCode2), new oOoXoXO<CsvFileReader, List<? extends Map<String, ? extends String>>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvReader$readAllWithHeader$1
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final List<Map<String, String>> invoke(@OOXIXo CsvFileReader open) {
                IIX0o.x0xO0oo(open, "$this$open");
                return SequencesKt___SequencesKt.oox000IX(open.xxIXOIIO());
            }
        });
    }

    @OOXIXo
    public final List<List<String>> oI0IIXIo(@OOXIXo InputStream ips) {
        IIX0o.x0xO0oo(ips, "ips");
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return (List) OOXIXo(XO.oIX0oI(ips, charsetCode), new oOoXoXO<CsvFileReader, List<? extends List<? extends String>>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvReader$readAll$3
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final List<List<String>> invoke(@OOXIXo CsvFileReader open) {
                IIX0o.x0xO0oo(open, "$this$open");
                return SequencesKt___SequencesKt.oox000IX(CsvFileReader.II0XooXoX(open, null, 1, null));
            }
        });
    }

    @Override // OO.II0xO0
    public char oIX0oI() {
        return this.f15761oIX0oI.oIX0oI();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object oO(com.github.doyaaaaaken.kotlincsv.client.X0o0xo r7, Oox.x0xO0oo<? super com.github.doyaaaaaken.kotlincsv.client.CsvFileReader, ? super kotlin.coroutines.I0Io<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.I0Io<? super T> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.github.doyaaaaaken.kotlincsv.client.CsvReader$openAsync$4
            if (r0 == 0) goto L13
            r0 = r9
            com.github.doyaaaaaken.kotlincsv.client.CsvReader$openAsync$4 r0 = (com.github.doyaaaaaken.kotlincsv.client.CsvReader$openAsync$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.github.doyaaaaaken.kotlincsv.client.CsvReader$openAsync$4 r0 = new com.github.doyaaaaaken.kotlincsv.client.CsvReader$openAsync$4
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r7 = r0.L$0
            com.github.doyaaaaaken.kotlincsv.client.CsvFileReader r7 = (com.github.doyaaaaaken.kotlincsv.client.CsvFileReader) r7
            kotlin.I0oOoX.x0XOIxOo(r9)     // Catch: java.lang.Throwable -> L2d
            goto L53
        L2d:
            r8 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.I0oOoX.x0XOIxOo(r9)
            com.github.doyaaaaaken.kotlincsv.client.CsvFileReader r9 = new com.github.doyaaaaaken.kotlincsv.client.CsvFileReader
            com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext r2 = r6.f15761oIX0oI
            xoIxX.oIX0oI r4 = r6.getLogger()
            r9.<init>(r2, r7, r4)
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L57
            r0.label = r3     // Catch: java.lang.Throwable -> L57
            java.lang.Object r7 = r8.invoke(r9, r0)     // Catch: java.lang.Throwable -> L57
            if (r7 != r1) goto L50
            return r1
        L50:
            r5 = r9
            r9 = r7
            r7 = r5
        L53:
            r7.oxoX()
            return r9
        L57:
            r8 = move-exception
            r7 = r9
        L59:
            throw r8     // Catch: java.lang.Throwable -> L5a
        L5a:
            r9 = move-exception
            r7.oxoX()     // Catch: java.lang.Throwable -> L5f
            goto L63
        L5f:
            r7 = move-exception
            kotlin.oO.oIX0oI(r8, r7)
        L63:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.doyaaaaaken.kotlincsv.client.CsvReader.oO(com.github.doyaaaaaken.kotlincsv.client.X0o0xo, Oox.x0xO0oo, kotlin.coroutines.I0Io):java.lang.Object");
    }

    public final <T> T oOoXoXO(@OOXIXo File file, @OOXIXo oOoXoXO<? super CsvFileReader, ? extends T> read) {
        IIX0o.x0xO0oo(file, "file");
        IIX0o.x0xO0oo(read, "read");
        FileInputStream fileInputStream = new FileInputStream(file);
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return (T) OOXIXo(XO.oIX0oI(fileInputStream, charsetCode), read);
    }

    public final <T> T ooOOo0oXI(@OOXIXo InputStream ips, @OOXIXo oOoXoXO<? super CsvFileReader, ? extends T> read) {
        IIX0o.x0xO0oo(ips, "ips");
        IIX0o.x0xO0oo(read, "read");
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return (T) OOXIXo(XO.oIX0oI(ips, charsetCode), read);
    }

    @Override // OO.II0xO0
    public boolean oxoX() {
        return this.f15761oIX0oI.oxoX();
    }

    public final <T> T x0XOIxOo(@OOXIXo String fileName, @OOXIXo oOoXoXO<? super CsvFileReader, ? extends T> read) {
        IIX0o.x0xO0oo(fileName, "fileName");
        IIX0o.x0xO0oo(read, "read");
        return (T) oOoXoXO(new File(fileName), read);
    }

    @OXOo.oOoXoXO
    public final <T> Object x0xO0oo(@OOXIXo File file, @OOXIXo x0xO0oo<? super CsvFileReader, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        FileInputStream fileInputStream = new FileInputStream(file);
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return oO(XO.oIX0oI(fileInputStream, charsetCode), x0xo0oo, i0Io);
    }

    @OOXIXo
    public final List<Map<String, String>> xoXoI(@OOXIXo InputStream ips) {
        IIX0o.x0xO0oo(ips, "ips");
        Charset charsetCode = this.f15760II0xO0;
        IIX0o.oO(charsetCode, "charsetCode");
        return (List) OOXIXo(XO.oIX0oI(ips, charsetCode), new oOoXoXO<CsvFileReader, List<? extends Map<String, ? extends String>>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvReader$readAllWithHeader$3
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final List<Map<String, String>> invoke(@OOXIXo CsvFileReader open) {
                IIX0o.x0xO0oo(open, "$this$open");
                return SequencesKt___SequencesKt.oox000IX(open.xxIXOIIO());
            }
        });
    }

    @Override // OO.II0xO0
    public char xxIXOIIO() {
        return this.f15761oIX0oI.xxIXOIIO();
    }

    public /* synthetic */ CsvReader(CsvReaderContext csvReaderContext, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new CsvReaderContext() : csvReaderContext);
    }

    public CsvReader(@OOXIXo CsvReaderContext ctx) {
        IIX0o.x0xO0oo(ctx, "ctx");
        this.f15761oIX0oI = ctx;
        this.f15760II0xO0 = Charset.forName(II0xO0());
    }
}
