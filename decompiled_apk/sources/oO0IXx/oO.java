package oO0IXx;

import com.univocity.parsers.common.DataProcessingException;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes13.dex */
public class oO extends XxX0x0xxx {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final Comparator<String> f31926OOXIXo = new oIX0oI();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Comparator<String> f31927oOoXoXO = new II0xO0();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String[] f31928II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public I0Io f31929Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f31930X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public I0Io[] f31931XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f31932oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public Comparator<String> f31933xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int[] f31934xxIXOIIO;

    /* loaded from: classes13.dex */
    public static class I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final int[] f31935I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String[] f31936II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final x0XOIxOo f31937X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final xxX f31938oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final String f31939oxoX;

        public I0Io(xxX xxx2, String[] strArr, int[] iArr, String str, x0XOIxOo x0xoixoo) {
            this.f31938oIX0oI = xxx2;
            this.f31936II0xO0 = (strArr == null || strArr.length == 0) ? null : strArr;
            this.f31935I0Io = (iArr == null || iArr.length == 0) ? null : iArr;
            this.f31939oxoX = str != null ? str.intern() : null;
            this.f31937X0o0xo = x0xoixoo;
        }
    }

    /* loaded from: classes13.dex */
    public static class II0xO0 implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str != str2 && (str == null || !str.equalsIgnoreCase(str2))) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes13.dex */
    public static class oIX0oI implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str != str2 && (str == null || !str.equals(str2))) {
                return 1;
            }
            return 0;
        }
    }

    public oO() {
        this(0);
    }

    @Override // oO0IXx.XxX0x0xxx
    public int[] I0Io() {
        return this.f31934xxIXOIIO;
    }

    public void II0XooXoX(String str, xxX xxx2, int... iArr) {
        I0Io[] i0IoArr = this.f31931XO;
        I0Io[] i0IoArr2 = (I0Io[]) Arrays.copyOf(i0IoArr, i0IoArr.length + 1);
        this.f31931XO = i0IoArr2;
        i0IoArr2[i0IoArr2.length - 1] = new I0Io(xxx2, null, iArr, str, null);
    }

    @Override // oO0IXx.XxX0x0xxx
    public String[] II0xO0() {
        return this.f31928II0XooXoX;
    }

    public void IXxxXO(xxX xxx2, int... iArr) {
        this.f31929Oxx0IOOO = new I0Io(xxx2, null, iArr, null, null);
    }

    public void OOXIXo(x0XOIxOo x0xoixoo, xxX xxx2, int... iArr) {
        I0Io[] i0IoArr = this.f31931XO;
        I0Io[] i0IoArr2 = (I0Io[]) Arrays.copyOf(i0IoArr, i0IoArr.length + 1);
        this.f31931XO = i0IoArr2;
        i0IoArr2[i0IoArr2.length - 1] = new I0Io(xxx2, null, iArr, null, x0xoixoo);
    }

    public void Oo(xxX xxx2) {
        this.f31929Oxx0IOOO = new I0Io(xxx2, null, null, null, null);
    }

    public void Oxx0IOOO(String str, xxX xxx2) {
        I0Io[] i0IoArr = this.f31931XO;
        I0Io[] i0IoArr2 = (I0Io[]) Arrays.copyOf(i0IoArr, i0IoArr.length + 1);
        this.f31931XO = i0IoArr2;
        i0IoArr2[i0IoArr2.length - 1] = new I0Io(xxx2, null, null, str, null);
    }

    public void Oxx0xo(xxX xxx2, String... strArr) {
        this.f31929Oxx0IOOO = new I0Io(xxx2, strArr, null, null, null);
    }

    @Override // oO0IXx.XxX0x0xxx
    public xxX X0o0xo(String[] strArr, com.univocity.parsers.common.oO oOVar) {
        if (this.f31932oxoX == -1) {
            String[] X0o0xo2 = oOVar.X0o0xo();
            if (X0o0xo2 != null) {
                int I0Io2 = com.univocity.parsers.common.I0Io.I0Io(X0o0xo2, this.f31930X0o0xo);
                this.f31932oxoX = I0Io2;
                if (I0Io2 == -1) {
                    throw new DataProcessingException("Unable to determine position of column named '" + this.f31930X0o0xo + "' as it does not exist in the headers. Available headers are " + Arrays.toString(X0o0xo2));
                }
            } else {
                throw new DataProcessingException("Unable to determine position of column named '" + this.f31930X0o0xo + "' as no headers have been defined nor extracted from the input");
            }
        }
        int i = this.f31932oxoX;
        if (i < strArr.length) {
            String str = strArr[i];
            int i2 = 0;
            while (true) {
                I0Io[] i0IoArr = this.f31931XO;
                if (i2 >= i0IoArr.length) {
                    break;
                }
                I0Io i0Io = i0IoArr[i2];
                x0XOIxOo x0xoixoo = i0Io.f31937X0o0xo;
                if (x0xoixoo != null && x0xoixoo.matches(str)) {
                    return i0Io.f31938oIX0oI;
                }
                if (this.f31933xoIox.compare(str, i0Io.f31939oxoX) == 0) {
                    this.f31928II0XooXoX = i0Io.f31936II0xO0;
                    this.f31934xxIXOIIO = i0Io.f31935I0Io;
                    return i0Io.f31938oIX0oI;
                }
                i2++;
            }
        }
        I0Io i0Io2 = this.f31929Oxx0IOOO;
        if (i0Io2 != null) {
            this.f31928II0XooXoX = i0Io2.f31936II0xO0;
            this.f31934xxIXOIIO = i0Io2.f31935I0Io;
            return i0Io2.f31938oIX0oI;
        }
        this.f31928II0XooXoX = null;
        this.f31934xxIXOIIO = null;
        throw new DataProcessingException("Unable to process input row. No switches activated and no default switch defined.", this.f31932oxoX, strArr, null);
    }

    public void oOoXoXO(x0XOIxOo x0xoixoo, xxX xxx2, String... strArr) {
        I0Io[] i0IoArr = this.f31931XO;
        I0Io[] i0IoArr2 = (I0Io[]) Arrays.copyOf(i0IoArr, i0IoArr.length + 1);
        this.f31931XO = i0IoArr2;
        i0IoArr2[i0IoArr2.length - 1] = new I0Io(xxx2, strArr, null, null, x0xoixoo);
    }

    public void ooOOo0oXI(boolean z) {
        Comparator<String> comparator;
        if (z) {
            comparator = f31926OOXIXo;
        } else {
            comparator = f31927oOoXoXO;
        }
        this.f31933xoIox = comparator;
    }

    public void x0xO0oo(Comparator<String> comparator) {
        if (comparator != null) {
            this.f31933xoIox = comparator;
            return;
        }
        throw new IllegalArgumentException("Comparator must not be null");
    }

    public void xoIox(x0XOIxOo x0xoixoo, xxX xxx2) {
        I0Io[] i0IoArr = this.f31931XO;
        I0Io[] i0IoArr2 = (I0Io[]) Arrays.copyOf(i0IoArr, i0IoArr.length + 1);
        this.f31931XO = i0IoArr2;
        i0IoArr2[i0IoArr2.length - 1] = new I0Io(xxx2, null, null, null, x0xoixoo);
    }

    public void xxIXOIIO(String str, xxX xxx2, String... strArr) {
        I0Io[] i0IoArr = this.f31931XO;
        I0Io[] i0IoArr2 = (I0Io[]) Arrays.copyOf(i0IoArr, i0IoArr.length + 1);
        this.f31931XO = i0IoArr2;
        i0IoArr2[i0IoArr2.length - 1] = new I0Io(xxx2, strArr, null, str, null);
    }

    public oO(int i) {
        this.f31932oxoX = -1;
        this.f31930X0o0xo = null;
        this.f31931XO = new I0Io[0];
        this.f31929Oxx0IOOO = null;
        this.f31933xoIox = f31927oOoXoXO;
        if (i >= 0) {
            this.f31932oxoX = i;
            return;
        }
        throw new IllegalArgumentException("Column index must be positive");
    }

    public oO(String str) {
        this.f31932oxoX = -1;
        this.f31930X0o0xo = null;
        this.f31931XO = new I0Io[0];
        this.f31929Oxx0IOOO = null;
        this.f31933xoIox = f31927oOoXoXO;
        if (str != null && !str.trim().isEmpty()) {
            this.f31930X0o0xo = str;
            return;
        }
        throw new IllegalArgumentException("Column name cannot be blank");
    }
}
