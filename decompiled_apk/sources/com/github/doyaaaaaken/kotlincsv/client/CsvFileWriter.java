package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext;
import com.github.doyaaaaaken.kotlincsv.dsl.context.WriteQuoteMode;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.ooOOo0oXI;

/* loaded from: classes9.dex */
public final class CsvFileWriter implements I0Io, Closeable, Flushable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public final Set<Character> f15755IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public final PrintWriter f15756Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f15757Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final CsvWriterContext f15758XO;

    /* loaded from: classes9.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15759oIX0oI;

        static {
            int[] iArr = new int[WriteQuoteMode.values().length];
            iArr[WriteQuoteMode.ALL.ordinal()] = 1;
            iArr[WriteQuoteMode.CANONICAL.ordinal()] = 2;
            iArr[WriteQuoteMode.NON_NUMERIC.ordinal()] = 3;
            f15759oIX0oI = iArr;
        }
    }

    public CsvFileWriter(@OOXIXo CsvWriterContext ctx, @OOXIXo PrintWriter writer) {
        IIX0o.x0xO0oo(ctx, "ctx");
        IIX0o.x0xO0oo(writer, "writer");
        this.f15758XO = ctx;
        this.f15756Oo = writer;
        this.f15755IXxxXO = Xo0.OxxIIOOXO('\r', '\n', Character.valueOf(ctx.Oxx0IOOO().oIX0oI()), Character.valueOf(ctx.oIX0oI()));
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.I0Io
    public void I0Io(@OOXIXo List<? extends List<? extends Object>> rows) {
        IIX0o.x0xO0oo(rows, "rows");
        xxIXOIIO();
        int i = 0;
        for (Object obj : rows) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            List<? extends Object> list = (List) obj;
            xoIox(list);
            if (i < rows.size() - 1 && !list.isEmpty()) {
                OOXIXo();
            }
            i = i2;
        }
        II0XooXoX();
        if (this.f15756Oo.checkError()) {
            throw new IOException("Failed to write");
        }
    }

    public final void II0XooXoX() {
        if (this.f15758XO.X0o0xo()) {
            OOXIXo();
        }
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.I0Io
    public void II0xO0(@OOXIXo ooOOo0oXI<? extends List<? extends Object>> rows) {
        IIX0o.x0xO0oo(rows, "rows");
        xxIXOIIO();
        Iterator<? extends List<? extends Object>> it = rows.iterator();
        while (it.hasNext()) {
            List<? extends Object> next = it.next();
            xoIox(next);
            if (it.hasNext() && !next.isEmpty()) {
                OOXIXo();
            }
        }
        II0XooXoX();
        if (!this.f15756Oo.checkError()) {
        } else {
            throw new IOException("Failed to write");
        }
    }

    public final void OOXIXo() {
        this.f15756Oo.print(this.f15758XO.XO());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (kotlin.jvm.internal.IIX0o.oI0IIXIo(r4, 57) <= 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Oxx0IOOO(java.lang.String r7) {
        /*
            r6 = this;
            com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext r0 = r6.f15758XO
            OO.oIX0oI r0 = r0.Oxx0IOOO()
            com.github.doyaaaaaken.kotlincsv.dsl.context.WriteQuoteMode r0 = r0.II0xO0()
            int[] r1 = com.github.doyaaaaaken.kotlincsv.client.CsvFileWriter.oIX0oI.f15759oIX0oI
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L6d
            r3 = 2
            if (r0 == r3) goto L52
            r3 = 3
            if (r0 != r3) goto L4c
            r0 = 0
            r3 = 0
        L1e:
            int r4 = r7.length()
            if (r0 >= r4) goto L4a
            char r4 = r7.charAt(r0)
            r5 = 46
            if (r4 != r5) goto L33
            if (r3 == 0) goto L30
        L2e:
            r4 = 1
            goto L44
        L30:
            r3 = 1
        L31:
            r4 = 0
            goto L44
        L33:
            r5 = 48
            int r5 = kotlin.jvm.internal.IIX0o.oI0IIXIo(r4, r5)
            if (r5 < 0) goto L2e
            r5 = 57
            int r4 = kotlin.jvm.internal.IIX0o.oI0IIXIo(r4, r5)
            if (r4 <= 0) goto L31
            goto L2e
        L44:
            if (r4 == 0) goto L47
            goto L6d
        L47:
            int r0 = r0 + 1
            goto L1e
        L4a:
            r2 = 0
            goto L6d
        L4c:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L52:
            r0 = 0
        L53:
            int r3 = r7.length()
            if (r0 >= r3) goto L4a
            char r3 = r7.charAt(r0)
            java.util.Set<java.lang.Character> r4 = r6.f15755IXxxXO
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L6a
            goto L6d
        L6a:
            int r0 = r0 + 1
            goto L53
        L6d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r2 == 0) goto L81
            com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext r3 = r6.f15758XO
            OO.oIX0oI r3 = r3.Oxx0IOOO()
            char r3 = r3.oIX0oI()
            r0.append(r3)
        L81:
            int r3 = r7.length()
            if (r1 >= r3) goto Laa
            char r3 = r7.charAt(r1)
            com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext r4 = r6.f15758XO
            OO.oIX0oI r4 = r4.Oxx0IOOO()
            char r4 = r4.oIX0oI()
            if (r3 != r4) goto La4
            com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext r4 = r6.f15758XO
            OO.oIX0oI r4 = r4.Oxx0IOOO()
            char r4 = r4.oIX0oI()
            r0.append(r4)
        La4:
            r0.append(r3)
            int r1 = r1 + 1
            goto L81
        Laa:
            if (r2 == 0) goto Lb9
            com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext r7 = r6.f15758XO
            OO.oIX0oI r7 = r7.Oxx0IOOO()
            char r7 = r7.oIX0oI()
            r0.append(r7)
        Lb9:
            java.lang.String r7 = r0.toString()
            java.lang.String r0 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.IIX0o.oO(r7, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.doyaaaaaken.kotlincsv.client.CsvFileWriter.Oxx0IOOO(java.lang.String):java.lang.String");
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.I0Io, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15756Oo.close();
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.I0Io, java.io.Flushable
    public void flush() {
        this.f15756Oo.flush();
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.I0Io
    public void oIX0oI(@OOXIXo List<? extends Object> row) {
        IIX0o.x0xO0oo(row, "row");
        xxIXOIIO();
        xoIox(row);
        II0XooXoX();
        if (!this.f15756Oo.checkError()) {
        } else {
            throw new IOException("Failed to write");
        }
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.I0Io
    public void oxoX(@OOXIXo Object... entry) {
        IIX0o.x0xO0oo(entry, "entry");
        oIX0oI(ArraysKt___ArraysKt.IoXOX(entry));
    }

    public final void xoIox(List<? extends Object> list) {
        if (!this.f15757Oxx0xo && this.f15758XO.oxoX()) {
            this.f15756Oo.print((char) 65279);
        }
        this.f15756Oo.print(CollectionsKt___CollectionsKt.OoIXo(list, String.valueOf(this.f15758XO.oIX0oI()), null, null, 0, null, new oOoXoXO<Object, CharSequence>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvFileWriter$writeNext$rowStr$1
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final CharSequence invoke(@OXOo.oOoXoXO Object obj) {
                String Oxx0IOOO2;
                CsvWriterContext csvWriterContext;
                if (obj == null) {
                    csvWriterContext = CsvFileWriter.this.f15758XO;
                    return csvWriterContext.I0Io();
                }
                Oxx0IOOO2 = CsvFileWriter.this.Oxx0IOOO(obj.toString());
                return Oxx0IOOO2;
            }
        }, 30, null));
        this.f15757Oxx0xo = true;
    }

    public final void xxIXOIIO() {
        if (!this.f15758XO.X0o0xo() && this.f15757Oxx0xo) {
            OOXIXo();
        }
    }
}
