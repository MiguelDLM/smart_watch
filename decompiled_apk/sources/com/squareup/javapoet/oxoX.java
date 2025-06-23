package com.squareup.javapoet;

import XO00XOO.oOoXoXO;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.squareup.javapoet.II0xO0;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/* loaded from: classes11.dex */
public final class oxoX {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Appendable f25904Oxx0IOOO = new oIX0oI();

    /* renamed from: I0Io, reason: collision with root package name */
    public final TypeSpec f25905I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f25906II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Set<String> f25907X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final String f25908XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final com.squareup.javapoet.II0xO0 f25909oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final boolean f25910oxoX;

    /* loaded from: classes11.dex */
    public static final class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final II0xO0.C1032II0xO0 f25911I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final TypeSpec f25912II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public boolean f25913X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public String f25914XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String f25915oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final Set<String> f25916oxoX;

        public /* synthetic */ I0Io(String str, TypeSpec typeSpec, oIX0oI oix0oi) {
            this(str, typeSpec);
        }

        public I0Io OOXIXo(Class<?> cls, String... strArr) {
            return xoIox(XO00XOO.II0xO0.X0IIOO(cls), strArr);
        }

        public I0Io oO(boolean z) {
            this.f25913X0o0xo = z;
            return this;
        }

        public I0Io oOoXoXO(Enum<?> r2) {
            return xoIox(XO00XOO.II0xO0.X0IIOO(r2.getDeclaringClass()), r2.name());
        }

        public oxoX ooOOo0oXI() {
            return new oxoX(this, null);
        }

        public I0Io x0XOIxOo(String str) {
            this.f25914XO = str;
            return this;
        }

        public I0Io xoIox(XO00XOO.II0xO0 iI0xO0, String... strArr) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            if (iI0xO0 != null) {
                z = true;
            } else {
                z = false;
            }
            oOoXoXO.II0xO0(z, "className == null", new Object[0]);
            if (strArr != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            oOoXoXO.II0xO0(z2, "names == null", new Object[0]);
            if (strArr.length > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            oOoXoXO.II0xO0(z3, "names array is empty", new Object[0]);
            for (String str : strArr) {
                if (str != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                oOoXoXO.II0xO0(z4, "null entry in names array: %s", Arrays.toString(strArr));
                this.f25916oxoX.add(iI0xO0.f3868oOXoIIIo + FileUtils.FILE_EXTENSION_SEPARATOR + str);
            }
            return this;
        }

        public I0Io xxIXOIIO(String str, Object... objArr) {
            this.f25911I0Io.II0xO0(str, objArr);
            return this;
        }

        public I0Io(String str, TypeSpec typeSpec) {
            this.f25911I0Io = com.squareup.javapoet.II0xO0.I0Io();
            this.f25916oxoX = new TreeSet();
            this.f25914XO = "  ";
            this.f25915oIX0oI = str;
            this.f25912II0xO0 = typeSpec;
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 extends SimpleJavaFileObject {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final long f25918oIX0oI;

        public II0xO0(URI uri, JavaFileObject.Kind kind) {
            super(uri, kind);
            this.f25918oIX0oI = System.currentTimeMillis();
        }

        public long I0Io() {
            return this.f25918oIX0oI;
        }

        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public String oIX0oI(boolean z) {
            return oxoX.this.toString();
        }

        public InputStream oxoX() throws IOException {
            return new ByteArrayInputStream(oIX0oI(true).getBytes(StandardCharsets.UTF_8));
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Appendable {
        @Override // java.lang.Appendable
        public Appendable append(char c) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            return this;
        }
    }

    public /* synthetic */ oxoX(I0Io i0Io, oIX0oI oix0oi) {
        this(i0Io);
    }

    public static I0Io oIX0oI(String str, TypeSpec typeSpec) {
        oOoXoXO.I0Io(str, "packageName == null", new Object[0]);
        oOoXoXO.I0Io(typeSpec, "typeSpec == null", new Object[0]);
        return new I0Io(str, typeSpec, null);
    }

    public I0Io I0Io() {
        I0Io i0Io = new I0Io(this.f25906II0xO0, this.f25905I0Io, null);
        i0Io.f25911I0Io.oIX0oI(this.f25909oIX0oI);
        i0Io.f25913X0o0xo = this.f25910oxoX;
        i0Io.f25914XO = this.f25908XO;
        return i0Io;
    }

    public void II0XooXoX(Filer filer) throws IOException {
        String str;
        if (this.f25906II0xO0.isEmpty()) {
            str = this.f25905I0Io.f25838II0xO0;
        } else {
            str = this.f25906II0xO0 + FileUtils.FILE_EXTENSION_SEPARATOR + this.f25905I0Io.f25838II0xO0;
        }
        List<Element> list = this.f25905I0Io.f25849x0xO0oo;
        JavaFileObject createSourceFile = filer.createSourceFile(str, (Element[]) list.toArray(new Element[list.size()]));
        try {
            Writer openWriter = createSourceFile.openWriter();
            try {
                XO(openWriter);
                if (openWriter != null) {
                    openWriter.close();
                }
            } finally {
            }
        } catch (Exception e) {
            try {
                createSourceFile.delete();
            } catch (Exception unused) {
            }
            throw e;
        }
    }

    public final void II0xO0(XO00XOO.oxoX oxox) throws IOException {
        oxox.xoXoI(this.f25906II0xO0);
        if (!this.f25909oIX0oI.oxoX()) {
            oxox.XO(this.f25909oIX0oI);
        }
        if (!this.f25906II0xO0.isEmpty()) {
            oxox.I0Io("package $L;\n", this.f25906II0xO0);
            oxox.II0xO0("\n");
        }
        if (!this.f25907X0o0xo.isEmpty()) {
            Iterator<String> it = this.f25907X0o0xo.iterator();
            while (it.hasNext()) {
                oxox.I0Io("import static $L;\n", (String) it.next());
            }
            oxox.II0xO0("\n");
        }
        Iterator it2 = new TreeSet(oxox.Oo().values()).iterator();
        int i = 0;
        while (it2.hasNext()) {
            XO00XOO.II0xO0 iI0xO0 = (XO00XOO.II0xO0) it2.next();
            if (!this.f25910oxoX || !iI0xO0.IIX0o().equals("java.lang")) {
                oxox.I0Io("import $L;\n", iI0xO0);
                i++;
            }
        }
        if (i > 0) {
            oxox.II0xO0("\n");
        }
        this.f25905I0Io.Oxx0IOOO(oxox, null, Collections.emptySet());
        oxox.OxxIIOOXO();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Oxx0IOOO(java.nio.file.Path r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.nio.file.LinkOption[] r2 = new java.nio.file.LinkOption[r1]
            boolean r2 = XO00XOO.X0o0xo.oIX0oI(r7, r2)
            if (r2 != 0) goto L15
            java.nio.file.LinkOption[] r2 = new java.nio.file.LinkOption[r1]
            boolean r2 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.x0XOIxOo.oIX0oI(r7, r2)
            if (r2 == 0) goto L13
            goto L15
        L13:
            r2 = 0
            goto L16
        L15:
            r2 = 1
        L16:
            java.lang.String r3 = "path %s exists but is not a directory."
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r1] = r7
            XO00XOO.oOoXoXO.II0xO0(r2, r3, r4)
            java.lang.String r2 = r6.f25906II0xO0
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L40
            java.lang.String r2 = r6.f25906II0xO0
            java.lang.String r3 = "\\."
            java.lang.String[] r2 = r2.split(r3)
            int r3 = r2.length
            r4 = 0
        L31:
            if (r4 >= r3) goto L3b
            r5 = r2[r4]
            java.nio.file.Path r7 = XO00XOO.XO.oIX0oI(r7, r5)
            int r4 = r4 + r0
            goto L31
        L3b:
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.o00.oIX0oI(r7, r0)
        L40:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.squareup.javapoet.TypeSpec r2 = r6.f25905I0Io
            java.lang.String r2 = r2.f25838II0xO0
            r0.append(r2)
            java.lang.String r2 = ".java"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.nio.file.Path r7 = XO00XOO.XO.oIX0oI(r7, r0)
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.OutputStream r7 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io.XOxIOxOx.oIX0oI(r7, r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8
            r0.<init>(r7, r1)
            r6.XO(r0)     // Catch: java.lang.Throwable -> L6d
            r0.close()
            return
        L6d:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L6f
        L6f:
            r1 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L74
            goto L78
        L74:
            r0 = move-exception
            r7.addSuppressed(r0)
        L78:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.javapoet.oxoX.Oxx0IOOO(java.nio.file.Path):void");
    }

    public void X0o0xo(File file) throws IOException {
        Path path;
        path = file.toPath();
        Oxx0IOOO(path);
    }

    public void XO(Appendable appendable) throws IOException {
        XO00XOO.oxoX oxox = new XO00XOO.oxoX(f25904Oxx0IOOO, this.f25908XO, this.f25907X0o0xo);
        II0xO0(oxox);
        II0xO0(new XO00XOO.oxoX(appendable, this.f25908XO, oxox.X0IIOO(), this.f25907X0o0xo));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || oxoX.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public JavaFileObject oxoX() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f25906II0xO0.isEmpty()) {
            str = this.f25905I0Io.f25838II0xO0;
        } else {
            str = this.f25906II0xO0.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + IOUtils.DIR_SEPARATOR_UNIX + this.f25905I0Io.f25838II0xO0;
        }
        sb.append(str);
        sb.append(JavaFileObject.Kind.SOURCE.extension);
        return new II0xO0(URI.create(sb.toString()), JavaFileObject.Kind.SOURCE);
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            XO(sb);
            return sb.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public oxoX(I0Io i0Io) {
        this.f25909oIX0oI = i0Io.f25911I0Io.OOXIXo();
        this.f25906II0xO0 = i0Io.f25915oIX0oI;
        this.f25905I0Io = i0Io.f25912II0xO0;
        this.f25910oxoX = i0Io.f25913X0o0xo;
        this.f25907X0o0xo = oOoXoXO.xxIXOIIO(i0Io.f25916oxoX);
        this.f25908XO = i0Io.f25914XO;
    }
}
