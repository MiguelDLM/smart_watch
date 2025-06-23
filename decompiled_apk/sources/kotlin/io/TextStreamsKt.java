package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt__SequencesKt;

@XO0OX.xxIXOIIO(name = "TextStreamsKt")
@XX({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,151:1\n52#1:152\n1#2:153\n1#2:156\n1313#3,2:154\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n33#1:152\n33#1:153\n33#1:154,2\n*E\n"})
/* loaded from: classes6.dex */
public final class TextStreamsKt {
    public static /* synthetic */ BufferedReader I0Io(Reader reader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        IIX0o.x0xO0oo(reader, "<this>");
        if (reader instanceof BufferedReader) {
            return (BufferedReader) reader;
        }
        return new BufferedReader(reader, i);
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<String> II0XooXoX(@OXOo.OOXIXo BufferedReader bufferedReader) {
        IIX0o.x0xO0oo(bufferedReader, "<this>");
        return SequencesKt__SequencesKt.XO(new ooOOo0oXI(bufferedReader));
    }

    @xx0o0O.XO
    public static final BufferedWriter II0xO0(Writer writer, int i) {
        IIX0o.x0xO0oo(writer, "<this>");
        if (writer instanceof BufferedWriter) {
            return (BufferedWriter) writer;
        }
        return new BufferedWriter(writer, i);
    }

    @OXOo.OOXIXo
    public static final String OOXIXo(@OXOo.OOXIXo Reader reader) {
        IIX0o.x0xO0oo(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        XO(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        IIX0o.oO(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    public static final void Oxx0IOOO(@OXOo.OOXIXo Reader reader, @OXOo.OOXIXo Oox.oOoXoXO<? super String, oXIO0o0XI> action) {
        BufferedReader bufferedReader;
        IIX0o.x0xO0oo(reader, "<this>");
        IIX0o.x0xO0oo(action, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            Iterator<String> it = II0XooXoX(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            II0xO0.oIX0oI(bufferedReader, null);
        } finally {
        }
    }

    public static final long X0o0xo(@OXOo.OOXIXo Reader reader, @OXOo.OOXIXo Writer out, int i) {
        IIX0o.x0xO0oo(reader, "<this>");
        IIX0o.x0xO0oo(out, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j += read;
            read = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long XO(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return X0o0xo(reader, writer, i);
    }

    @xx0o0O.XO
    public static final BufferedReader oIX0oI(Reader reader, int i) {
        IIX0o.x0xO0oo(reader, "<this>");
        if (reader instanceof BufferedReader) {
            return (BufferedReader) reader;
        }
        return new BufferedReader(reader, i);
    }

    public static final <T> T oO(@OXOo.OOXIXo Reader reader, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.sequences.ooOOo0oXI<String>, ? extends T> block) {
        BufferedReader bufferedReader;
        IIX0o.x0xO0oo(reader, "<this>");
        IIX0o.x0xO0oo(block, "block");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            T invoke = block.invoke(II0XooXoX(bufferedReader));
            xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                II0xO0.oIX0oI(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                } else {
                    II0xO0.oIX0oI(bufferedReader, th);
                }
                xxX.I0Io(1);
                throw th2;
            }
        }
    }

    @xx0o0O.XO
    public static final String oOoXoXO(URL url, Charset charset) {
        IIX0o.x0xO0oo(url, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new String(xxIXOIIO(url), charset);
    }

    public static /* synthetic */ String ooOOo0oXI(URL url, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(url, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new String(xxIXOIIO(url), charset);
    }

    public static /* synthetic */ BufferedWriter oxoX(Writer writer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        IIX0o.x0xO0oo(writer, "<this>");
        if (writer instanceof BufferedWriter) {
            return (BufferedWriter) writer;
        }
        return new BufferedWriter(writer, i);
    }

    @xx0o0O.XO
    public static final StringReader x0XOIxOo(String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return new StringReader(str);
    }

    @OXOo.OOXIXo
    public static final List<String> xoIox(@OXOo.OOXIXo Reader reader) {
        IIX0o.x0xO0oo(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        Oxx0IOOO(reader, new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: kotlin.io.TextStreamsKt$readLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str) {
                invoke2(str);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo String it) {
                IIX0o.x0xO0oo(it, "it");
                arrayList.add(it);
            }
        });
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final byte[] xxIXOIIO(@OXOo.OOXIXo URL url) {
        IIX0o.x0xO0oo(url, "<this>");
        InputStream openStream = url.openStream();
        try {
            IIX0o.ooOOo0oXI(openStream);
            byte[] x0xO0oo2 = oIX0oI.x0xO0oo(openStream);
            II0xO0.oIX0oI(openStream, null);
            return x0xO0oo2;
        } finally {
        }
    }
}
