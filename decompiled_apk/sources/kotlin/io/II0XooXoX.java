package kotlin.io;

import Oox.x0xO0oo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class II0XooXoX implements kotlin.sequences.ooOOo0oXI<File> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<File, Boolean> f29198I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final FileWalkDirection f29199II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final x0xO0oo<File, IOException, oXIO0o0XI> f29200X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f29201XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final File f29202oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<File, oXIO0o0XI> f29203oxoX;

    /* loaded from: classes6.dex */
    public static abstract class I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final File f29204oIX0oI;

        public I0Io(@OXOo.OOXIXo File root) {
            IIX0o.x0xO0oo(root, "root");
            this.f29204oIX0oI = root;
        }

        @OXOo.oOoXoXO
        public abstract File II0xO0();

        @OXOo.OOXIXo
        public final File oIX0oI() {
            return this.f29204oIX0oI;
        }
    }

    /* loaded from: classes6.dex */
    public final class II0xO0 extends kotlin.collections.oIX0oI<File> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final ArrayDeque<I0Io> f29205IXxxXO;

        /* loaded from: classes6.dex */
        public final class I0Io extends oIX0oI {

            /* renamed from: I0Io, reason: collision with root package name */
            @OXOo.oOoXoXO
            public File[] f29207I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            public boolean f29208II0xO0;

            /* renamed from: X0o0xo, reason: collision with root package name */
            public final /* synthetic */ II0xO0 f29209X0o0xo;

            /* renamed from: oxoX, reason: collision with root package name */
            public int f29210oxoX;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public I0Io(@OXOo.OOXIXo II0xO0 iI0xO0, File rootDir) {
                super(rootDir);
                IIX0o.x0xO0oo(rootDir, "rootDir");
                this.f29209X0o0xo = iI0xO0;
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.II0XooXoX.I0Io
            @OXOo.oOoXoXO
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File II0xO0() {
                /*
                    r10 = this;
                    boolean r0 = r10.f29208II0xO0
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.II0XooXoX$II0xO0 r0 = r10.f29209X0o0xo
                    kotlin.io.II0XooXoX r0 = kotlin.io.II0XooXoX.this
                    Oox.oOoXoXO r0 = kotlin.io.II0XooXoX.oxoX(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r10.oIX0oI()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r10.f29208II0xO0 = r0
                    java.io.File r0 = r10.oIX0oI()
                    return r0
                L28:
                    java.io.File[] r0 = r10.f29207I0Io
                    if (r0 == 0) goto L47
                    int r2 = r10.f29210oxoX
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    kotlin.io.II0XooXoX$II0xO0 r0 = r10.f29209X0o0xo
                    kotlin.io.II0XooXoX r0 = kotlin.io.II0XooXoX.this
                    Oox.oOoXoXO r0 = kotlin.io.II0XooXoX.XO(r0)
                    if (r0 == 0) goto L46
                    java.io.File r2 = r10.oIX0oI()
                    r0.invoke(r2)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r10.f29207I0Io
                    if (r0 != 0) goto L93
                    java.io.File r0 = r10.oIX0oI()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f29207I0Io = r0
                    if (r0 != 0) goto L77
                    kotlin.io.II0XooXoX$II0xO0 r0 = r10.f29209X0o0xo
                    kotlin.io.II0XooXoX r0 = kotlin.io.II0XooXoX.this
                    Oox.x0xO0oo r0 = kotlin.io.II0XooXoX.X0o0xo(r0)
                    if (r0 == 0) goto L77
                    java.io.File r2 = r10.oIX0oI()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.oIX0oI()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L77:
                    java.io.File[] r0 = r10.f29207I0Io
                    if (r0 == 0) goto L81
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L93
                L81:
                    kotlin.io.II0XooXoX$II0xO0 r0 = r10.f29209X0o0xo
                    kotlin.io.II0XooXoX r0 = kotlin.io.II0XooXoX.this
                    Oox.oOoXoXO r0 = kotlin.io.II0XooXoX.XO(r0)
                    if (r0 == 0) goto L92
                    java.io.File r2 = r10.oIX0oI()
                    r0.invoke(r2)
                L92:
                    return r1
                L93:
                    java.io.File[] r0 = r10.f29207I0Io
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                    int r1 = r10.f29210oxoX
                    int r2 = r1 + 1
                    r10.f29210oxoX = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.II0XooXoX.II0xO0.I0Io.II0xO0():java.io.File");
            }
        }

        @XX({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        /* renamed from: kotlin.io.II0XooXoX$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public final class C1107II0xO0 extends I0Io {

            /* renamed from: I0Io, reason: collision with root package name */
            public final /* synthetic */ II0xO0 f29211I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            public boolean f29212II0xO0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1107II0xO0(@OXOo.OOXIXo II0xO0 iI0xO0, File rootFile) {
                super(rootFile);
                IIX0o.x0xO0oo(rootFile, "rootFile");
                this.f29211I0Io = iI0xO0;
            }

            @Override // kotlin.io.II0XooXoX.I0Io
            @OXOo.oOoXoXO
            public File II0xO0() {
                if (this.f29212II0xO0) {
                    return null;
                }
                this.f29212II0xO0 = true;
                return oIX0oI();
            }
        }

        /* loaded from: classes6.dex */
        public final class oIX0oI extends oIX0oI {

            /* renamed from: I0Io, reason: collision with root package name */
            @OXOo.oOoXoXO
            public File[] f29213I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            public boolean f29214II0xO0;

            /* renamed from: X0o0xo, reason: collision with root package name */
            public boolean f29215X0o0xo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ II0xO0 f29216XO;

            /* renamed from: oxoX, reason: collision with root package name */
            public int f29217oxoX;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public oIX0oI(@OXOo.OOXIXo II0xO0 iI0xO0, File rootDir) {
                super(rootDir);
                IIX0o.x0xO0oo(rootDir, "rootDir");
                this.f29216XO = iI0xO0;
            }

            @Override // kotlin.io.II0XooXoX.I0Io
            @OXOo.oOoXoXO
            public File II0xO0() {
                if (!this.f29215X0o0xo && this.f29213I0Io == null) {
                    Oox.oOoXoXO oooxoxo = II0XooXoX.this.f29198I0Io;
                    if (oooxoxo != null && !((Boolean) oooxoxo.invoke(oIX0oI())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = oIX0oI().listFiles();
                    this.f29213I0Io = listFiles;
                    if (listFiles == null) {
                        x0xO0oo x0xo0oo = II0XooXoX.this.f29200X0o0xo;
                        if (x0xo0oo != null) {
                            x0xo0oo.invoke(oIX0oI(), new AccessDeniedException(oIX0oI(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f29215X0o0xo = true;
                    }
                }
                File[] fileArr = this.f29213I0Io;
                if (fileArr != null) {
                    int i = this.f29217oxoX;
                    IIX0o.ooOOo0oXI(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.f29213I0Io;
                        IIX0o.ooOOo0oXI(fileArr2);
                        int i2 = this.f29217oxoX;
                        this.f29217oxoX = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (this.f29214II0xO0) {
                    Oox.oOoXoXO oooxoxo2 = II0XooXoX.this.f29203oxoX;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(oIX0oI());
                    }
                    return null;
                }
                this.f29214II0xO0 = true;
                return oIX0oI();
            }
        }

        /* loaded from: classes6.dex */
        public /* synthetic */ class oxoX {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public static final /* synthetic */ int[] f29218oIX0oI;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f29218oIX0oI = iArr;
            }
        }

        public II0xO0() {
            ArrayDeque<I0Io> arrayDeque = new ArrayDeque<>();
            this.f29205IXxxXO = arrayDeque;
            if (II0XooXoX.this.f29202oIX0oI.isDirectory()) {
                arrayDeque.push(XO(II0XooXoX.this.f29202oIX0oI));
            } else if (II0XooXoX.this.f29202oIX0oI.isFile()) {
                arrayDeque.push(new C1107II0xO0(this, II0XooXoX.this.f29202oIX0oI));
            } else {
                II0xO0();
            }
        }

        public final File Oxx0IOOO() {
            File II0xO02;
            while (true) {
                I0Io peek = this.f29205IXxxXO.peek();
                if (peek == null) {
                    return null;
                }
                II0xO02 = peek.II0xO0();
                if (II0xO02 == null) {
                    this.f29205IXxxXO.pop();
                } else {
                    if (IIX0o.Oxx0IOOO(II0xO02, peek.oIX0oI()) || !II0xO02.isDirectory() || this.f29205IXxxXO.size() >= II0XooXoX.this.f29201XO) {
                        break;
                    }
                    this.f29205IXxxXO.push(XO(II0xO02));
                }
            }
            return II0xO02;
        }

        public final oIX0oI XO(File file) {
            int i = oxoX.f29218oIX0oI[II0XooXoX.this.f29199II0xO0.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new oIX0oI(this, file);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new I0Io(this, file);
        }

        @Override // kotlin.collections.oIX0oI
        public void oIX0oI() {
            File Oxx0IOOO2 = Oxx0IOOO();
            if (Oxx0IOOO2 != null) {
                oxoX(Oxx0IOOO2);
            } else {
                II0xO0();
            }
        }
    }

    @XX({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    /* loaded from: classes6.dex */
    public static abstract class oIX0oI extends I0Io {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public oIX0oI(@OXOo.OOXIXo File rootDir) {
            super(rootDir);
            IIX0o.x0xO0oo(rootDir, "rootDir");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX(File file, FileWalkDirection fileWalkDirection, Oox.oOoXoXO<? super File, Boolean> oooxoxo, Oox.oOoXoXO<? super File, oXIO0o0XI> oooxoxo2, x0xO0oo<? super File, ? super IOException, oXIO0o0XI> x0xo0oo, int i) {
        this.f29202oIX0oI = file;
        this.f29199II0xO0 = fileWalkDirection;
        this.f29198I0Io = oooxoxo;
        this.f29203oxoX = oooxoxo2;
        this.f29200X0o0xo = x0xo0oo;
        this.f29201XO = i;
    }

    @OXOo.OOXIXo
    public final II0XooXoX II0XooXoX(int i) {
        if (i > 0) {
            return new II0XooXoX(this.f29202oIX0oI, this.f29199II0xO0, this.f29198I0Io, this.f29203oxoX, this.f29200X0o0xo, i);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i + '.');
    }

    @OXOo.OOXIXo
    public final II0XooXoX OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super File, oXIO0o0XI> function) {
        IIX0o.x0xO0oo(function, "function");
        return new II0XooXoX(this.f29202oIX0oI, this.f29199II0xO0, this.f29198I0Io, function, this.f29200X0o0xo, this.f29201XO);
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<File> iterator() {
        return new II0xO0();
    }

    @OXOo.OOXIXo
    public final II0XooXoX xoIox(@OXOo.OOXIXo x0xO0oo<? super File, ? super IOException, oXIO0o0XI> function) {
        IIX0o.x0xO0oo(function, "function");
        return new II0XooXoX(this.f29202oIX0oI, this.f29199II0xO0, this.f29198I0Io, this.f29203oxoX, function, this.f29201XO);
    }

    @OXOo.OOXIXo
    public final II0XooXoX xxIXOIIO(@OXOo.OOXIXo Oox.oOoXoXO<? super File, Boolean> function) {
        IIX0o.x0xO0oo(function, "function");
        return new II0XooXoX(this.f29202oIX0oI, this.f29199II0xO0, function, this.f29203oxoX, this.f29200X0o0xo, this.f29201XO);
    }

    public /* synthetic */ II0XooXoX(File file, FileWalkDirection fileWalkDirection, Oox.oOoXoXO oooxoxo, Oox.oOoXoXO oooxoxo2, x0xO0oo x0xo0oo, int i, int i2, IIXOooo iIXOooo) {
        this(file, (i2 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, oooxoxo, oooxoxo2, x0xo0oo, (i2 & 32) != 0 ? Integer.MAX_VALUE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public II0XooXoX(@OXOo.OOXIXo File start, @OXOo.OOXIXo FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        IIX0o.x0xO0oo(start, "start");
        IIX0o.x0xO0oo(direction, "direction");
    }

    public /* synthetic */ II0XooXoX(File file, FileWalkDirection fileWalkDirection, int i, IIXOooo iIXOooo) {
        this(file, (i & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }
}
