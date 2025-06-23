package kotlin.io;

import Oox.x0xO0oo;
import X0.IIXOooo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n1#2:233\n*E\n"})
/* loaded from: classes6.dex */
public class FilesKt__FileReadWriteKt extends xoIox {
    public static final void II0XooXoX(@OXOo.OOXIXo File file, @OXOo.OOXIXo String text, @OXOo.OOXIXo Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        Oxx0IOOO(file, bytes);
    }

    public static /* synthetic */ void IIX0o(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        xXxxox0I(file, str, charset);
    }

    @OXOo.OOXIXo
    public static byte[] IIXOooo(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                int i = (int) length;
                byte[] bArr = new byte[i];
                int i2 = i;
                int i3 = 0;
                while (i2 > 0) {
                    int read = fileInputStream.read(bArr, i3, i2);
                    if (read < 0) {
                        break;
                    }
                    i2 -= read;
                    i3 += read;
                }
                if (i2 > 0) {
                    bArr = Arrays.copyOf(bArr, i3);
                    IIX0o.oO(bArr, "copyOf(...)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        XO xo2 = new XO(8193);
                        xo2.write(read2);
                        oIX0oI.oOoXoXO(fileInputStream, xo2, 0, 2, null);
                        int size = xo2.size() + i;
                        if (size >= 0) {
                            byte[] oIX0oI2 = xo2.oIX0oI();
                            byte[] copyOf = Arrays.copyOf(bArr, size);
                            IIX0o.oO(copyOf, "copyOf(...)");
                            bArr = kotlin.collections.ooOOo0oXI.O00XxXI(oIX0oI2, copyOf, i, 0, xo2.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                II0xO0.oIX0oI(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                II0xO0.oIX0oI(fileInputStream, th);
                throw th2;
            }
        }
    }

    @xx0o0O.XO
    public static final FileInputStream IXxxXO(File file) {
        IIX0o.x0xO0oo(file, "<this>");
        return new FileInputStream(file);
    }

    public static /* synthetic */ String O0xOxO(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        return OxI(file, charset);
    }

    public static /* synthetic */ BufferedReader OOXIXo(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i);
    }

    public static /* synthetic */ void Oo(File file, Charset charset, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        x0xO0oo(file, charset, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final String OxI(@OXOo.OOXIXo File file, @OXOo.OOXIXo Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String OOXIXo2 = TextStreamsKt.OOXIXo(inputStreamReader);
            II0xO0.oIX0oI(inputStreamReader, null);
            return OOXIXo2;
        } finally {
        }
    }

    public static final void Oxx0IOOO(@OXOo.OOXIXo File file, @OXOo.OOXIXo byte[] array) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            II0xO0.oIX0oI(fileOutputStream, null);
        } finally {
        }
    }

    @xx0o0O.XO
    public static final FileOutputStream Oxx0xo(File file) {
        IIX0o.x0xO0oo(file, "<this>");
        return new FileOutputStream(file);
    }

    public static /* synthetic */ PrintWriter OxxIIOOXO(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    @xx0o0O.XO
    public static final InputStreamReader X0IIOO(File file, Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static /* synthetic */ InputStreamReader XI0IXoo(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T XIxXXX0x0(@OXOo.OOXIXo File file, @OXOo.OOXIXo Charset charset, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.sequences.ooOOo0oXI<String>, ? extends T> block) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        IIX0o.x0xO0oo(block, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            T invoke = block.invoke(TextStreamsKt.II0XooXoX(bufferedReader));
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

    public static final void XxX0x0xxx(@OXOo.OOXIXo File file, @OXOo.OOXIXo byte[] array) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            II0xO0.oIX0oI(fileOutputStream, null);
        } finally {
        }
    }

    public static /* synthetic */ List o00(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        return xoXoI(file, charset);
    }

    @xx0o0O.XO
    public static final PrintWriter oI0IIXIo(File file, Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    public static final void oO(@OXOo.OOXIXo File file, @OXOo.OOXIXo x0xO0oo<? super byte[], ? super Integer, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(action, "action");
        x0XOIxOo(file, 4096, action);
    }

    @xx0o0O.XO
    public static final BufferedWriter oOoXoXO(File file, Charset charset, int i) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i);
    }

    public static /* synthetic */ BufferedWriter ooOOo0oXI(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i);
    }

    @xx0o0O.XO
    public static final OutputStreamWriter ooXIXxIX(File file, Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void x0XOIxOo(@OXOo.OOXIXo File file, int i, @OXOo.OOXIXo x0xO0oo<? super byte[], ? super Integer, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(action, "action");
        ?? r2 = new byte[IIXOooo.OxxIIOOXO(i, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(r2);
                if (read <= 0) {
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    II0xO0.oIX0oI(fileInputStream, null);
                    return;
                }
                action.invoke(r2, Integer.valueOf(read));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    II0xO0.oIX0oI(fileInputStream, th);
                    throw th2;
                }
            }
        }
    }

    public static final void x0xO0oo(@OXOo.OOXIXo File file, @OXOo.OOXIXo Charset charset, @OXOo.OOXIXo Oox.oOoXoXO<? super String, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        IIX0o.x0xO0oo(action, "action");
        TextStreamsKt.Oxx0IOOO(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static /* synthetic */ OutputStreamWriter xI(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void xXxxox0I(@OXOo.OOXIXo File file, @OXOo.OOXIXo String text, @OXOo.OOXIXo Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        IIX0o.oO(bytes, "getBytes(...)");
        XxX0x0xxx(file, bytes);
    }

    @xx0o0O.XO
    public static final BufferedReader xoIox(File file, Charset charset, int i) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i);
    }

    @OXOo.OOXIXo
    public static final List<String> xoXoI(@OXOo.OOXIXo File file, @OXOo.OOXIXo Charset charset) {
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        final ArrayList arrayList = new ArrayList();
        x0xO0oo(file, charset, new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: kotlin.io.FilesKt__FileReadWriteKt$readLines$1
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

    public static /* synthetic */ void xxIXOIIO(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        II0XooXoX(file, str, charset);
    }

    public static /* synthetic */ Object xxX(File file, Charset charset, Oox.oOoXoXO block, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        IIX0o.x0xO0oo(file, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        IIX0o.x0xO0oo(block, "block");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            Object invoke = block.invoke(TextStreamsKt.II0XooXoX(bufferedReader));
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
}
