package o0OO0;

import com.univocity.parsers.common.TextWritingException;
import com.univocity.parsers.common.XO;
import com.univocity.parsers.common.oO;
import com.univocity.parsers.common.oxoX;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Iterator;
import java.util.List;
import oO0IXx.II0XooXoX;
import oO0IXx.Oxx0IOOO;
import oO0IXx.xXxxox0I;
import oO0IXx.xxX;

/* loaded from: classes13.dex */
public abstract class oIX0oI<P extends oxoX<?>, W extends XO<?>> {

    /* renamed from: I0Io, reason: collision with root package name */
    public W f31108I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public P f31109II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f31110oIX0oI;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes13.dex */
    public class I0Io<T> implements Iterable<T> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Object[] f31112Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Reader f31113XO;

        /* renamed from: o0OO0.oIX0oI$I0Io$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C1119oIX0oI implements Iterator<T> {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ com.univocity.parsers.common.oIX0oI f31115XO;

            public C1119oIX0oI(com.univocity.parsers.common.oIX0oI oix0oi) {
                this.f31115XO = oix0oi;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (I0Io.this.f31112Oo[0] == null) {
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public T next() {
                T t = (T) I0Io.this.f31112Oo[0];
                if (this.f31115XO.Xx000oIo() == null) {
                    I0Io.this.f31112Oo[0] = null;
                }
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Can't remove beans");
            }
        }

        public I0Io(Reader reader, Object[] objArr) {
            this.f31113XO = reader;
            this.f31112Oo = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            oIX0oI oix0oi = oIX0oI.this;
            com.univocity.parsers.common.oIX0oI XO2 = oix0oi.XO(oix0oi.f31109II0xO0);
            XO2.Oxx0IOOO(this.f31113XO);
            XO2.Xx000oIo();
            return new C1119oIX0oI(XO2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes13.dex */
    public class II0xO0<T> extends Oxx0IOOO<T> {

        /* renamed from: x0xO0oo, reason: collision with root package name */
        public final /* synthetic */ Object[] f31117x0xO0oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public II0xO0(Class cls, Object[] objArr) {
            super(cls);
            this.f31117x0xO0oo = objArr;
        }

        @Override // oO0IXx.Oxx0IOOO, oO0IXx.xxX
        public void XO(oO oOVar) {
            super.XO(oOVar);
            oIX0oI.this.f31109II0xO0.xXOx(null);
        }

        @Override // oO0IXx.Oxx0IOOO
        public void xII(T t, oO oOVar) {
            this.f31117x0xO0oo[0] = t;
        }
    }

    /* renamed from: o0OO0.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1120oIX0oI implements xxX {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Writer f31119II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public com.univocity.parsers.common.II0xO0<W> f31120oIX0oI;

        public C1120oIX0oI(Writer writer) {
            this.f31119II0xO0 = writer;
        }

        @Override // oO0IXx.xxX
        public void XO(oO oOVar) {
            this.f31120oIX0oI.xoIox();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // oO0IXx.xxX
        public void oO(oO oOVar) {
            oIX0oI oix0oi = oIX0oI.this;
            this.f31120oIX0oI = oix0oi.Oxx0IOOO(this.f31119II0xO0, oix0oi.f31108I0Io);
        }

        @Override // oO0IXx.xxX
        public void x0XOIxOo(String[] strArr, oO oOVar) {
            this.f31120oIX0oI.OX00O0xII(strArr);
        }
    }

    public oIX0oI(String str) {
        this(str, null, null);
    }

    public final xxX II0XooXoX(Writer writer) {
        return new C1120oIX0oI(writer);
    }

    public final void IIX0o(ResultSet resultSet, File file, String str) {
        IoOoX(resultSet, com.univocity.parsers.common.I0Io.OOXIXo(file, str));
    }

    public <T> List<T> IIXOooo(Class<T> cls, InputStream inputStream, String str) {
        return o00(cls, com.univocity.parsers.common.I0Io.II0XooXoX(inputStream, str));
    }

    public <T> void IO(Iterable<T> iterable, Class<T> cls, OutputStream outputStream, String str, String[] strArr) {
        XOxIOxOx(iterable, cls, com.univocity.parsers.common.I0Io.x0XOIxOo(outputStream, str), strArr);
    }

    public <T> List<T> IXxxXO(Class<T> cls, File file) {
        return o00(cls, com.univocity.parsers.common.I0Io.oxoX(file));
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00a8: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:66:0x00ad (LINE:169), block:B:64:0x00a8 */
    public final void IoOoX(ResultSet resultSet, Writer writer) {
        boolean z;
        com.univocity.parsers.common.II0xO0 iI0xO0;
        int i;
        XxX0x0xxx();
        if (this.f31108I0Io.oo() != null) {
            z = true;
        } else {
            z = false;
        }
        long j = 0;
        try {
            try {
                try {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    String[] strArr = new String[columnCount];
                    int[] iArr = new int[columnCount];
                    for (int i2 = 1; i2 <= columnCount; i2++) {
                        int i3 = i2 - 1;
                        strArr[i3] = metaData.getColumnLabel(i2);
                        int precision = metaData.getPrecision(i2);
                        int scale = metaData.getScale(i2);
                        if (precision != 0 && scale != 0) {
                            i = precision + scale + 2;
                        } else {
                            i = precision + scale;
                        }
                        iArr[i3] = i;
                    }
                    this.f31108I0Io.O0xOxO(strArr);
                    I0Io(strArr, iArr);
                    com.univocity.parsers.common.II0xO0<W> Oxx0IOOO2 = Oxx0IOOO(writer, this.f31108I0Io);
                    try {
                        if (this.f31108I0Io.IoOoX()) {
                            Oxx0IOOO2.xoIxX();
                        }
                        Object[] objArr = new Object[columnCount];
                        while (resultSet.next()) {
                            for (int i4 = 1; i4 <= columnCount; i4++) {
                                try {
                                    objArr[i4 - 1] = resultSet.getObject(i4);
                                } catch (Throwable th) {
                                    th = th;
                                    resultSet.close();
                                    throw th;
                                }
                            }
                            if (z) {
                                Oxx0IOOO2.XxX0x0xxx(objArr);
                            } else {
                                Oxx0IOOO2.xoO0xx0(objArr);
                            }
                            j++;
                        }
                        resultSet.close();
                        if (Oxx0IOOO2 != null) {
                            Oxx0IOOO2.xoIox();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e) {
                throw new TextWritingException("Error writing data from result set", 0L, (Object[]) null, e);
            }
        } catch (Throwable th4) {
            if (iI0xO0 != null) {
                iI0xO0.xoIox();
            }
            throw th4;
        }
    }

    public final void O0xOxO(P p) {
        this.f31109II0xO0 = p;
    }

    public <T> Iterable<T> OOXIXo(Class<T> cls, File file) {
        return Oo(cls, com.univocity.parsers.common.I0Io.oxoX(file));
    }

    public <T> Iterable<T> Oo(Class<T> cls, Reader reader) {
        Object[] objArr = new Object[1];
        X0IIOO(new II0xO0(cls, objArr));
        return new I0Io(reader, objArr);
    }

    public final void OxI(Reader reader, Writer writer) {
        XI0IXoo(null);
        X0IIOO(II0XooXoX(writer));
        try {
            XO(this.f31109II0xO0).o00(reader);
        } finally {
            this.f31109II0xO0.xXOx(null);
        }
    }

    public abstract com.univocity.parsers.common.II0xO0<W> Oxx0IOOO(Writer writer, W w);

    public <T> List<T> Oxx0xo(Class<T> cls, File file, String str) {
        return o00(cls, com.univocity.parsers.common.I0Io.X0o0xo(file, str));
    }

    public <T> List<T> OxxIIOOXO(Class<T> cls, InputStream inputStream) {
        return o00(cls, com.univocity.parsers.common.I0Io.Oxx0IOOO(inputStream));
    }

    public <T> void X00IoxXI(Iterable<T> iterable, Class<T> cls, File file, String... strArr) {
        XOxIOxOx(iterable, cls, com.univocity.parsers.common.I0Io.xoIox(file), strArr);
    }

    public final void X0IIOO(xxX xxx2) {
        xxX();
        this.f31109II0xO0.xXOx(xxx2);
    }

    public abstract W X0o0xo();

    public final void XI0IXoo(xXxxox0I xxxxox0i) {
        XxX0x0xxx();
        this.f31108I0Io.IO(xxxxox0i);
    }

    public final void XIxXXX0x0(W w) {
        this.f31108I0Io = w;
    }

    public abstract com.univocity.parsers.common.oIX0oI<P> XO(P p);

    public <T> void XOxIOxOx(Iterable<T> iterable, Class<T> cls, Writer writer, String... strArr) {
        XI0IXoo(new II0XooXoX(cls));
        try {
            if (strArr.length > 0) {
                this.f31108I0Io.O0xOxO(strArr);
                this.f31108I0Io.X00IoxXI(true);
            }
            Oxx0IOOO(writer, this.f31108I0Io).Xx000oIo(iterable);
            this.f31108I0Io.IO(null);
        } catch (Throwable th) {
            this.f31108I0Io.IO(null);
            throw th;
        }
    }

    public <T> void Xx000oIo(Iterable<T> iterable, Class<T> cls, File file, Charset charset, String... strArr) {
        XOxIOxOx(iterable, cls, com.univocity.parsers.common.I0Io.oOoXoXO(file, charset), strArr);
    }

    public final void XxX0x0xxx() {
        if (this.f31108I0Io == null) {
            this.f31108I0Io = X0o0xo();
        }
    }

    public <T> List<T> o00(Class<T> cls, Reader reader) {
        oO0IXx.XO xo2 = new oO0IXx.XO(cls);
        X0IIOO(xo2);
        try {
            XO(this.f31109II0xO0).o00(reader);
            return xo2.x0o();
        } finally {
            this.f31109II0xO0.xXOx(null);
        }
    }

    public <T> List<T> oI0IIXIo(Class<T> cls, File file, Charset charset) {
        return o00(cls, com.univocity.parsers.common.I0Io.XO(file, charset));
    }

    public <T> Iterable<T> oO(Class<T> cls, InputStream inputStream, String str) {
        return Oo(cls, com.univocity.parsers.common.I0Io.II0XooXoX(inputStream, str));
    }

    public <T> void oOXoIIIo(Iterable<T> iterable, Class<T> cls, File file, String str, String[] strArr) {
        XOxIOxOx(iterable, cls, com.univocity.parsers.common.I0Io.OOXIXo(file, str), strArr);
    }

    public <T> Iterable<T> oOoXoXO(Class<T> cls, File file, String str) {
        return Oo(cls, com.univocity.parsers.common.I0Io.X0o0xo(file, str));
    }

    public final void oo(ResultSet resultSet, OutputStream outputStream, Charset charset) {
        IoOoX(resultSet, com.univocity.parsers.common.I0Io.oO(outputStream, charset));
    }

    public final void oo0xXOI0I(ResultSet resultSet, OutputStream outputStream, String str) {
        IoOoX(resultSet, com.univocity.parsers.common.I0Io.x0XOIxOo(outputStream, str));
    }

    public <T> Iterable<T> ooOOo0oXI(Class<T> cls, File file, Charset charset) {
        return Oo(cls, com.univocity.parsers.common.I0Io.XO(file, charset));
    }

    public final void ooXIXxIX(ResultSet resultSet, File file, Charset charset) {
        IoOoX(resultSet, com.univocity.parsers.common.I0Io.oOoXoXO(file, charset));
    }

    public abstract P oxoX();

    public String toString() {
        return this.f31110oIX0oI;
    }

    public <T> Iterable<T> x0XOIxOo(Class<T> cls, InputStream inputStream) {
        return Oo(cls, com.univocity.parsers.common.I0Io.Oxx0IOOO(inputStream));
    }

    public <T> void x0o(Iterable<T> iterable, Class<T> cls, OutputStream outputStream, String... strArr) {
        XOxIOxOx(iterable, cls, com.univocity.parsers.common.I0Io.ooOOo0oXI(outputStream), strArr);
    }

    public <T> Iterable<T> x0xO0oo(Class<T> cls, InputStream inputStream, Charset charset) {
        return Oo(cls, com.univocity.parsers.common.I0Io.xxIXOIIO(inputStream, charset));
    }

    public final void xI(ResultSet resultSet, OutputStream outputStream) {
        IoOoX(resultSet, com.univocity.parsers.common.I0Io.ooOOo0oXI(outputStream));
    }

    public <T> void xII(Iterable<T> iterable, Class<T> cls, OutputStream outputStream, Charset charset, String... strArr) {
        XOxIOxOx(iterable, cls, com.univocity.parsers.common.I0Io.oO(outputStream, charset), strArr);
    }

    public final void xXxxox0I(ResultSet resultSet, File file) {
        IoOoX(resultSet, com.univocity.parsers.common.I0Io.xoIox(file));
    }

    public final W xoIox() {
        return this.f31108I0Io;
    }

    public <T> List<T> xoXoI(Class<T> cls, InputStream inputStream, Charset charset) {
        return o00(cls, com.univocity.parsers.common.I0Io.xxIXOIIO(inputStream, charset));
    }

    public final P xxIXOIIO() {
        return this.f31109II0xO0;
    }

    public final void xxX() {
        if (this.f31109II0xO0 == null) {
            this.f31109II0xO0 = oxoX();
        }
    }

    public oIX0oI(String str, P p) {
        this(str, p, null);
    }

    public oIX0oI(String str, W w) {
        this(str, null, w);
    }

    public oIX0oI(String str, P p, W w) {
        this.f31110oIX0oI = str;
        this.f31109II0xO0 = p;
        this.f31108I0Io = w;
    }

    public void I0Io(String[] strArr, int[] iArr) {
    }
}
