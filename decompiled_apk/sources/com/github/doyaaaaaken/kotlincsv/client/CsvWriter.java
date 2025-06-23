package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvWriterContext;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.II0XooXoX;
import kotlinx.coroutines.Xo0;

/* loaded from: classes9.dex */
public final class CsvWriter implements OO.I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final CsvWriterContext f15762oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public CsvWriter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Object IIX0o(CsvWriter csvWriter, List list, File file, boolean z, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return csvWriter.xxX(list, file, z, i0Io);
    }

    public static /* synthetic */ Object IIXOooo(CsvWriter csvWriter, File file, boolean z, x0xO0oo x0xo0oo, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return csvWriter.Oxx0xo(file, z, x0xo0oo, i0Io);
    }

    public static /* synthetic */ CsvFileWriter IXxxXO(CsvWriter csvWriter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return csvWriter.x0xO0oo(str, z);
    }

    public static /* synthetic */ CsvFileWriter Oo(CsvWriter csvWriter, File file, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return csvWriter.x0XOIxOo(file, z);
    }

    public static /* synthetic */ void X0IIOO(CsvWriter csvWriter, List list, File file, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        csvWriter.o00(list, file, z);
    }

    public static /* synthetic */ void XI0IXoo(CsvWriter csvWriter, List list, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        csvWriter.O0xOxO(list, str, z);
    }

    public static /* synthetic */ void oOoXoXO(CsvWriter csvWriter, File file, boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        csvWriter.xxIXOIIO(file, z, oooxoxo);
    }

    public static /* synthetic */ void ooOOo0oXI(CsvWriter csvWriter, String str, boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        csvWriter.OOXIXo(str, z, oooxoxo);
    }

    public static /* synthetic */ Object ooXIXxIX(CsvWriter csvWriter, List list, String str, boolean z, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return csvWriter.xXxxox0I(list, str, z, i0Io);
    }

    public static /* synthetic */ Object xoXoI(CsvWriter csvWriter, String str, boolean z, x0xO0oo x0xo0oo, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return csvWriter.OxxIIOOXO(str, z, x0xo0oo, i0Io);
    }

    @Override // OO.I0Io
    @OOXIXo
    public String I0Io() {
        return this.f15762oIX0oI.I0Io();
    }

    @Override // OO.I0Io
    @OOXIXo
    public String II0xO0() {
        return this.f15762oIX0oI.II0xO0();
    }

    public final void O0xOxO(@OOXIXo final List<? extends List<? extends Object>> rows, @OOXIXo String targetFileName, boolean z) {
        IIX0o.x0xO0oo(rows, "rows");
        IIX0o.x0xO0oo(targetFileName, "targetFileName");
        OOXIXo(targetFileName, z, new oOoXoXO<I0Io, oXIO0o0XI>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvWriter$writeAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(I0Io i0Io) {
                invoke2(i0Io);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo I0Io open) {
                IIX0o.x0xO0oo(open, "$this$open");
                open.I0Io(rows);
            }
        });
    }

    public final void OOXIXo(@OOXIXo String targetFileName, boolean z, @OOXIXo oOoXoXO<? super I0Io, oXIO0o0XI> write) {
        IIX0o.x0xO0oo(targetFileName, "targetFileName");
        IIX0o.x0xO0oo(write, "write");
        xxIXOIIO(new File(targetFileName), z, write);
    }

    public final void OxI(@OOXIXo final List<? extends List<? extends Object>> rows, @OOXIXo OutputStream ops) {
        IIX0o.x0xO0oo(rows, "rows");
        IIX0o.x0xO0oo(ops, "ops");
        xoIox(ops, new oOoXoXO<I0Io, oXIO0o0XI>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvWriter$writeAll$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(I0Io i0Io) {
                invoke2(i0Io);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo I0Io open) {
                IIX0o.x0xO0oo(open, "$this$open");
                open.I0Io(rows);
            }
        });
    }

    @Override // OO.I0Io
    @OOXIXo
    public OO.oIX0oI Oxx0IOOO() {
        return this.f15762oIX0oI.Oxx0IOOO();
    }

    @OXOo.oOoXoXO
    public final Object Oxx0xo(@OOXIXo File file, boolean z, @OOXIXo x0xO0oo<? super I0Io, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object II0XooXoX2 = II0XooXoX.II0XooXoX(Xo0.I0Io(), new CsvWriter$openAsync$3(file, z, this, x0xo0oo, null), i0Io);
        if (II0XooXoX2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return II0XooXoX2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object OxxIIOOXO(@OOXIXo String str, boolean z, @OOXIXo x0xO0oo<? super I0Io, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object Oxx0xo2 = Oxx0xo(new File(str), z, x0xo0oo, i0Io);
        if (Oxx0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return Oxx0xo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // OO.I0Io
    public boolean X0o0xo() {
        return this.f15762oIX0oI.X0o0xo();
    }

    @OOXIXo
    public final String XIxXXX0x0(@OOXIXo final List<? extends List<? extends Object>> rows) {
        IIX0o.x0xO0oo(rows, "rows");
        return xI(new oOoXoXO<I0Io, oXIO0o0XI>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvWriter$writeAllAsString$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(I0Io i0Io) {
                invoke2(i0Io);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo I0Io writeAsString) {
                IIX0o.x0xO0oo(writeAsString, "$this$writeAsString");
                writeAsString.I0Io(rows);
            }
        });
    }

    @Override // OO.I0Io
    @OOXIXo
    public String XO() {
        return this.f15762oIX0oI.XO();
    }

    @OXOo.oOoXoXO
    public final Object XxX0x0xxx(@OOXIXo List<? extends List<? extends Object>> list, @OOXIXo OutputStream outputStream, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object oI0IIXIo2 = oI0IIXIo(outputStream, new CsvWriter$writeAllAsync$6(list, null), i0Io);
        if (oI0IIXIo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oI0IIXIo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void o00(@OOXIXo final List<? extends List<? extends Object>> rows, @OOXIXo File targetFile, boolean z) {
        IIX0o.x0xO0oo(rows, "rows");
        IIX0o.x0xO0oo(targetFile, "targetFile");
        xxIXOIIO(targetFile, z, new oOoXoXO<I0Io, oXIO0o0XI>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvWriter$writeAll$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(I0Io i0Io) {
                invoke2(i0Io);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo I0Io open) {
                IIX0o.x0xO0oo(open, "$this$open");
                open.I0Io(rows);
            }
        });
    }

    @OXOo.oOoXoXO
    public final Object oI0IIXIo(@OOXIXo OutputStream outputStream, @OOXIXo x0xO0oo<? super I0Io, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object II0XooXoX2 = II0XooXoX.II0XooXoX(Xo0.I0Io(), new CsvWriter$openAsync$5(outputStream, this, x0xo0oo, null), i0Io);
        if (II0XooXoX2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return II0XooXoX2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // OO.I0Io
    public char oIX0oI() {
        return this.f15762oIX0oI.oIX0oI();
    }

    @OOXIXo
    @oxoX
    public final CsvFileWriter oO(@OOXIXo OutputStream ops) {
        IIX0o.x0xO0oo(ops, "ops");
        return new CsvFileWriter(this.f15762oIX0oI, new PrintWriter(new OutputStreamWriter(ops, this.f15762oIX0oI.II0xO0())));
    }

    @Override // OO.I0Io
    public boolean oxoX() {
        return this.f15762oIX0oI.oxoX();
    }

    @OOXIXo
    @oxoX
    public final CsvFileWriter x0XOIxOo(@OOXIXo File targetFile, boolean z) {
        IIX0o.x0xO0oo(targetFile, "targetFile");
        return oO(new FileOutputStream(targetFile, z));
    }

    @OOXIXo
    @oxoX
    public final CsvFileWriter x0xO0oo(@OOXIXo String targetFileName, boolean z) {
        IIX0o.x0xO0oo(targetFileName, "targetFileName");
        return x0XOIxOo(new File(targetFileName), z);
    }

    @OOXIXo
    public final String xI(@OOXIXo oOoXoXO<? super I0Io, oXIO0o0XI> write) {
        IIX0o.x0xO0oo(write, "write");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xoIox(byteArrayOutputStream, write);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        IIX0o.oO(byteArray, "baos.toByteArray()");
        Charset forName = Charset.forName(this.f15762oIX0oI.II0xO0());
        IIX0o.oO(forName, "forName(ctx.charset)");
        return new String(byteArray, forName);
    }

    @OXOo.oOoXoXO
    public final Object xXxxox0I(@OOXIXo List<? extends List<? extends Object>> list, @OOXIXo String str, boolean z, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object OxxIIOOXO2 = OxxIIOOXO(str, z, new CsvWriter$writeAllAsync$2(list, null), i0Io);
        if (OxxIIOOXO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return OxxIIOOXO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void xoIox(@OOXIXo OutputStream ops, @OOXIXo oOoXoXO<? super I0Io, oXIO0o0XI> write) {
        IIX0o.x0xO0oo(ops, "ops");
        IIX0o.x0xO0oo(write, "write");
        CsvFileWriter csvFileWriter = new CsvFileWriter(this.f15762oIX0oI, new PrintWriter(new OutputStreamWriter(ops, this.f15762oIX0oI.II0xO0())));
        try {
            write.invoke(csvFileWriter);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            kotlin.io.II0xO0.oIX0oI(csvFileWriter, null);
        } finally {
        }
    }

    public final void xxIXOIIO(@OOXIXo File targetFile, boolean z, @OOXIXo oOoXoXO<? super I0Io, oXIO0o0XI> write) {
        IIX0o.x0xO0oo(targetFile, "targetFile");
        IIX0o.x0xO0oo(write, "write");
        xoIox(new BufferedOutputStream(new FileOutputStream(targetFile, z), 8192), write);
    }

    @OXOo.oOoXoXO
    public final Object xxX(@OOXIXo List<? extends List<? extends Object>> list, @OOXIXo File file, boolean z, @OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object Oxx0xo2 = Oxx0xo(file, z, new CsvWriter$writeAllAsync$4(list, null), i0Io);
        if (Oxx0xo2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return Oxx0xo2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public /* synthetic */ CsvWriter(CsvWriterContext csvWriterContext, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? new CsvWriterContext() : csvWriterContext);
    }

    public CsvWriter(@OOXIXo CsvWriterContext ctx) {
        IIX0o.x0xO0oo(ctx, "ctx");
        this.f15762oIX0oI = ctx;
    }
}
