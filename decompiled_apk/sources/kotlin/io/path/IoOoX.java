package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.IIX0;
import kotlin.io.TextStreamsKt;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt___SequencesKt;

@kotlin.jvm.internal.XX({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,326:1\n1#2:327\n1#2:329\n52#3:328\n1313#4,2:330\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n202#1:329\n202#1:328\n202#1:330,2\n*E\n"})
/* loaded from: classes6.dex */
public class IoOoX {
    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path I0Io(Path path, kotlin.sequences.ooOOo0oXI<? extends CharSequence> lines, Charset charset) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        Iterable Xx000oIo2 = SequencesKt___SequencesKt.Xx000oIo(lines);
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, Xx000oIo2, charset, standardOpenOption);
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final BufferedReader II0XooXoX(Path path, Charset charset, int i, OpenOption... options) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedReader(new InputStreamReader(newInputStream, charset), i);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path II0xO0(Path path, Iterable<? extends CharSequence> lines, Charset charset) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, lines, charset, standardOpenOption);
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    public static /* synthetic */ OutputStreamWriter IIX0o(Path path, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        OutputStream newOutputStream;
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new OutputStreamWriter(newOutputStream, charset);
    }

    public static /* synthetic */ InputStreamReader IIXOooo(Path path, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        InputStream newInputStream;
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new InputStreamReader(newInputStream, charset);
    }

    public static /* synthetic */ List IXxxXO(Path path, Charset charset, int i, Object obj) throws IOException {
        List readAllLines;
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        readAllLines = Files.readAllLines(path, charset);
        kotlin.jvm.internal.IIX0o.oO(readAllLines, "readAllLines(...)");
        return readAllLines;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path O0xOxO(Path path, Iterable<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Path write;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        write = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    public static /* synthetic */ BufferedWriter OOXIXo(Path path, Charset charset, int i, OpenOption[] options, int i2, Object obj) throws IOException {
        OutputStream newOutputStream;
        if ((i2 & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedWriter(new OutputStreamWriter(newOutputStream, charset), i);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final List<String> Oo(Path path, Charset charset) throws IOException {
        List<String> readAllLines;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        readAllLines = Files.readAllLines(path, charset);
        kotlin.jvm.internal.IIX0o.oO(readAllLines, "readAllLines(...)");
        return readAllLines;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final void OxI(Path path, byte[] array, OpenOption... options) throws IOException {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        Files.write(path, array, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    public static /* synthetic */ void Oxx0IOOO(Path path, CharSequence charSequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        XO(path, charSequence, charset);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.5")
    public static final String Oxx0xo(@OXOo.OOXIXo Path path, @OXOo.OOXIXo Charset charset) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
        InputStreamReader inputStreamReader = new InputStreamReader(newInputStream, charset);
        try {
            String OOXIXo2 = TextStreamsKt.OOXIXo(inputStreamReader);
            kotlin.io.II0xO0.oIX0oI(inputStreamReader, null);
            return OOXIXo2;
        } finally {
        }
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final InputStreamReader OxxIIOOXO(Path path, Charset charset, OpenOption... options) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new InputStreamReader(newInputStream, charset);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final Path X0IIOO(Path path, kotlin.sequences.ooOOo0oXI<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Path write;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        write = Files.write(path, SequencesKt___SequencesKt.Xx000oIo(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    public static /* synthetic */ Path X0o0xo(Path path, kotlin.sequences.ooOOo0oXI lines, Charset charset, int i, Object obj) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        Iterable Xx000oIo2 = SequencesKt___SequencesKt.Xx000oIo(lines);
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, Xx000oIo2, charset, standardOpenOption);
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    public static /* synthetic */ Path XI0IXoo(Path path, Iterable lines, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        Path write;
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        write = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    public static /* synthetic */ Path XIxXXX0x0(Path path, kotlin.sequences.ooOOo0oXI lines, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        Path write;
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        write = Files.write(path, SequencesKt___SequencesKt.Xx000oIo(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    public static final void XO(@OXOo.OOXIXo Path path, @OXOo.OOXIXo CharSequence text, @OXOo.OOXIXo Charset charset) throws IOException {
        StandardOpenOption standardOpenOption;
        OutputStream newOutputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        standardOpenOption = StandardOpenOption.APPEND;
        newOutputStream = Files.newOutputStream(path, standardOpenOption);
        kotlin.jvm.internal.IIX0o.oO(newOutputStream, "newOutputStream(...)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.II0xO0.oIX0oI(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void XxX0x0xxx(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        xxX(path, charSequence, charset, openOptionArr);
    }

    public static /* synthetic */ Object o00(Path path, Charset charset, Oox.oOoXoXO block, int i, Object obj) throws IOException {
        BufferedReader newBufferedReader;
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(newBufferedReader);
            Object invoke = block.invoke(TextStreamsKt.II0XooXoX(newBufferedReader));
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newBufferedReader, null);
            } else if (newBufferedReader != null) {
                newBufferedReader.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (newBufferedReader != null) {
                        try {
                            newBufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newBufferedReader, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String oI0IIXIo(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        return Oxx0xo(path, charset);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final void oIX0oI(Path path, byte[] array) throws IOException {
        StandardOpenOption standardOpenOption;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        standardOpenOption = StandardOpenOption.APPEND;
        Files.write(path, array, standardOpenOption);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final OutputStream oO(Path path, OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(newOutputStream, "newOutputStream(...)");
        return newOutputStream;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final void oOoXoXO(Path path, Charset charset, Oox.oOoXoXO<? super String, oXIO0o0XI> action) throws IOException {
        BufferedReader newBufferedReader;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        newBufferedReader = Files.newBufferedReader(path, charset);
        kotlin.jvm.internal.IIX0o.oO(newBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<String> it = TextStreamsKt.II0XooXoX(newBufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newBufferedReader, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void ooOOo0oXI(Path path, Charset charset, Oox.oOoXoXO action, int i, Object obj) throws IOException {
        BufferedReader newBufferedReader;
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        newBufferedReader = Files.newBufferedReader(path, charset);
        kotlin.jvm.internal.IIX0o.oO(newBufferedReader, "newBufferedReader(...)");
        try {
            Iterator<String> it = TextStreamsKt.II0XooXoX(newBufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newBufferedReader, null);
            } else {
                newBufferedReader.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    try {
                        newBufferedReader.close();
                    } catch (Throwable unused) {
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newBufferedReader, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ Path oxoX(Path path, Iterable lines, Charset charset, int i, Object obj) throws IOException {
        StandardOpenOption standardOpenOption;
        Path write;
        if ((i & 2) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(lines, "lines");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        standardOpenOption = StandardOpenOption.APPEND;
        write = Files.write(path, lines, charset, standardOpenOption);
        kotlin.jvm.internal.IIX0o.oO(write, "write(...)");
        return write;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final InputStream x0XOIxOo(Path path, OpenOption... options) throws IOException {
        InputStream newInputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(newInputStream, "newInputStream(...)");
        return newInputStream;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final byte[] x0xO0oo(Path path) throws IOException {
        byte[] readAllBytes;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        readAllBytes = Files.readAllBytes(path);
        kotlin.jvm.internal.IIX0o.oO(readAllBytes, "readAllBytes(...)");
        return readAllBytes;
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final OutputStreamWriter xXxxox0I(Path path, Charset charset, OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new OutputStreamWriter(newOutputStream, charset);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final BufferedWriter xoIox(Path path, Charset charset, int i, OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedWriter(new OutputStreamWriter(newOutputStream, charset), i);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    @xx0o0O.XO
    public static final <T> T xoXoI(Path path, Charset charset, Oox.oOoXoXO<? super kotlin.sequences.ooOOo0oXI<String>, ? extends T> block) throws IOException {
        BufferedReader newBufferedReader;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(newBufferedReader);
            T invoke = block.invoke(TextStreamsKt.II0XooXoX(newBufferedReader));
            kotlin.jvm.internal.xxX.oxoX(1);
            if (xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                kotlin.io.II0xO0.oIX0oI(newBufferedReader, null);
            } else if (newBufferedReader != null) {
                newBufferedReader.close();
            }
            kotlin.jvm.internal.xxX.I0Io(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.xxX.oxoX(1);
                if (!xx0o0O.ooOOo0oXI.oIX0oI(1, 1, 0)) {
                    if (newBufferedReader != null) {
                        try {
                            newBufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    kotlin.io.II0xO0.oIX0oI(newBufferedReader, th);
                }
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ BufferedReader xxIXOIIO(Path path, Charset charset, int i, OpenOption[] options, int i2, Object obj) throws IOException {
        InputStream newInputStream;
        if ((i2 & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        return new BufferedReader(new InputStreamReader(newInputStream, charset), i);
    }

    @IIX0(markerClass = {ooOOo0oXI.class})
    @kotlin.oxxXoxO(version = "1.5")
    public static final void xxX(@OXOo.OOXIXo Path path, @OXOo.OOXIXo CharSequence text, @OXOo.OOXIXo Charset charset, @OXOo.OOXIXo OpenOption... options) throws IOException {
        OutputStream newOutputStream;
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        kotlin.jvm.internal.IIX0o.x0xO0oo(charset, "charset");
        kotlin.jvm.internal.IIX0o.x0xO0oo(options, "options");
        newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.IIX0o.oO(newOutputStream, "newOutputStream(...)");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(text);
            kotlin.io.II0xO0.oIX0oI(outputStreamWriter, null);
        } finally {
        }
    }
}
