package jxl.biff.formula;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* loaded from: classes6.dex */
public class xxIO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f28055IXxxXO = -1;

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f28057OxI = "\u0001\u0000\u0001\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\u0000\u0002\u0002\u0001\b\u0001\u0000\u0001\t\u0001\u0000\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0001\u0001\u0011\u0001\u0002\u0001\u0012\u0001\u0000\u0001\u0013\u0001\u0000\u0001\u0002\u0003\u0000\u0002\u0002\u0005\u0000\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0002\u0001\u0000\u0001\u0017\u0001\u0000\u0001\u0012\u0002\u0000\u0001\u0018\u0001\u0000\u0002\u0002\b\u0000\u0001\u0017\u0001\u0000\u0001\u0019\u0001\u0000\u0001\u001a\b\u0000\u0001\u001b\u0002\u0000\u0001\u0019\u0002\u0000\u0001\u001c\u0004\u0000\u0001\u001d\u0003\u0000\u0001\u001d\u0001\u0000\u0001\u001e\u0001\u0000";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f28058Oxx0xo = 16384;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f28059OxxIIOOXO = 0;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f28060X0IIOO = "\u0000\u0000\u0000%\u0000J\u0000o\u0000\u0094\u0000\u0094\u0000\u0094\u0000\u0094\u0000¹\u0000Þ\u0000ă\u0000\u0094\u0000Ĩ\u0000\u0094\u0000ō\u0000\u0094\u0000\u0094\u0000\u0094\u0000\u0094\u0000Ų\u0000\u0094\u0000Ɨ\u0000Ƽ\u0000\u0094\u0000ǡ\u0000Ȇ\u0000ȫ\u0000\u0094\u0000ɐ\u0000ɵ\u0000ʚ\u0000ʿ\u0000ˤ\u0000̉\u0000̮\u0000͓\u0000\u0378\u0000Ν\u0000ς\u0000ϧ\u0000\u0094\u0000\u0094\u0000\u0094\u0000Ќ\u0000б\u0000і\u0000ѻ\u0000Ҡ\u0000Ӆ\u0000Ӫ\u0000ʿ\u0000ԏ\u0000Դ\u0000ՙ\u0000վ\u0000֣\u0000\u05c8\u0000\u05ed\u0000ؒ\u0000ط\u0000ٜ\u0000ځ\u0000\u0094\u0000ڦ\u0000ۋ\u0000ۋ\u0000Ќ\u0000۰\u0000ܕ\u0000ܺ\u0000ݟ\u0000ބ\u0000ީ\u0000ߎ\u0000߳\u0000࠘\u0000࠘\u0000࠽\u0000ࡢ\u0000ࢇ\u0000ࢬ\u0000\u0094\u0000࣑\u0000ࣶ\u0000छ\u0000ी\u0000॥\u0000ঊ\u0000য\u0000\u09d4\u0000\u0094\u0000৹\u0000ਞ\u0000ਞ";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final String f28062XIxXXX0x0 = "\u0001\u0000\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\u0000\u0001\t\u0001\n\u0003\u0003\u0001\u000b\u0003\u0003\u0001\f\u0001\r\u0002\u0000\u0001\u000e\u0001\u000f\u0004\u0003\u0001\u0010\u0001\u0004\u0001\u0003\u0001\u0000\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0011\u0017\u0001\u0018\u0013\u0017\u0001\u0000\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\b\u0019\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004\u0019\u0001\u0000\u0001\u001a\u0001\u0019\t\u0000\u0001\u0004\u0004\u0000\u0001 \u0014\u0000\u0001\u0004.\u0000\u0001!\u0007\u0000\b!\u0006\u0000\u0004!\u0002\u0000\u0001!\b\u0000\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0001\u0019\u0001\"\u0006\u0019\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004\u0019\u0001\u0000\u0001\u001a\u0001\u0019\b\u0000\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0005\u0019\u0001#\u0002\u0019\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004\u0019\u0001\u0000\u0001\u001a\u0001\u0019\u0007\u0000\u0012\r\u0001$\u0012\r\n\u0000\u0001%\f\u0000\u0001&\u0001'\u0001\u0000\u0001(-\u0000\u0001)#\u0000\u0001*\u0001+\u0001\u0000\u0011\u0017\u0001\u0000\u0013\u0017\u0001\u0000\u0001,\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\b,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001a\u0001,\b\u0000\u0001\u001e\u0001\u001a\u0001-\u0005\u0000\b\u001e\u0002\u0000\u0001\u001e\u0003\u0000\u0004\u001e\u0001\u0000\u0001\u001a\u0001\u001e\b\u0000\u0001.\u0006\u0000\u0001/\b.\u0006\u0000\u0004.\u0002\u0000\u0001.\t\u0000\u00010\u0019\u0000\u00010\t\u0000\u0002\u001e\u0006\u0000\b\u001e\u0002\u0000\u0001\u001e\u0003\u0000\u0004\u001e\u0001\u0000\u0002\u001e\b\u0000\u00011\u0006\u0000\u00012\b1\u0006\u0000\u00041\u0002\u0000\u00011\t\u0000\u00013\u0019\u0000\u00013\t\u0000\u00014\u00010\u0001\u001b\u0004\u0000\u0001\u001d\b4\u0006\u0000\u00044\u0001\u0000\u00010\u00014\b\u0000\u0001,\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0002,\u00015\u0005,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001a\u0001,\b\u0000\u0001,\u0001\u001a\u0001\u001b\u0001\u0000\u0001\u001c\u0002\u0000\u0001\u001d\u0006,\u00016\u0001,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001a\u0001,\u001b\u0000\u00017\u001c\u0000\u00018#\u0000\u00019\u0002\u0000\u0001:/\u0000\u0001;\u0019\u0000\u0001<\u0017\u0000\u0001,\u0001\u001e\u0002\u0000\u0001\u001c\u0003\u0000\b,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001e\u0001,\b\u0000\u0001=\u0006\u0000\u0001>\b=\u0006\u0000\u0004=\u0002\u0000\u0001=\b\u0000\u0001?\u0007\u0000\b?\u0006\u0000\u0004?\u0002\u0000\u0001?\b\u0000\u0001.\u0007\u0000\b.\u0006\u0000\u0004.\u0002\u0000\u0001.\t\u0000\u00010\u0001-\u0018\u0000\u00010\t\u0000\u0001@\u0001A\u0005\u0000\u0001B\b@\u0006\u0000\u0004@\u0001\u0000\u0001A\u0001@\b\u0000\u00011\u0007\u0000\b1\u0006\u0000\u00041\u0002\u0000\u00011\t\u0000\u00010\u0001\u001b\u0004\u0000\u0001\u001d\u0013\u0000\u00010\t\u0000\u0001,\u0001\u001e\u0002\u0000\u0001\u001c\u0003\u0000\u0003,\u0001C\u0004,\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001e\u0001,\b\u0000\u0001,\u0001\u001e\u0002\u0000\u0001\u001c\u0003\u0000\u0007,\u00015\u0002\u0000\u0001\u001e\u0001\u001f\u0002\u0000\u0004,\u0001\u0000\u0001\u001e\u0001,\b\u0000\u0001D\u0006\u0000\u0001E\bD\u0006\u0000\u0004D\u0002\u0000\u0001D\u0014\u0000\u0001F&\u0000\u0001G\r\u0000\u0001F$\u0000\u0001H!\u0000\u0001I\u0019\u0000\u0001J\u0016\u0000\u0001K\u0001L\u0005\u0000\u0001M\bK\u0006\u0000\u0004K\u0001\u0000\u0001L\u0001K\b\u0000\u0001=\u0007\u0000\b=\u0006\u0000\u0004=\u0002\u0000\u0001=\t\u0000\u0001A\u0005\u0000\u0001B\u0013\u0000\u0001A\n\u0000\u0001A\u0019\u0000\u0001A\t\u0000\u0001N\u0001O\u0001P\u0004\u0000\u0001Q\bN\u0006\u0000\u0004N\u0001\u0000\u0001O\u0001N\b\u0000\u0001D\u0007\u0000\bD\u0006\u0000\u0004D\u0002\u0000\u0001D\u001b\u0000\u0001R\u001f\u0000\u0001F!\u0000\u0001S3\u0000\u0001T\u0014\u0000\u0001U\u001b\u0000\u0001L\u0005\u0000\u0001M\u0013\u0000\u0001L\n\u0000\u0001L\u0019\u0000\u0001L\n\u0000\u0001O\u0001P\u0004\u0000\u0001Q\u0013\u0000\u0001O\n\u0000\u0001O\u0001V\u0018\u0000\u0001O\t\u0000\u0001W\u0006\u0000\u0001X\bW\u0006\u0000\u0004W\u0002\u0000\u0001W\t\u0000\u0001O\u0019\u0000\u0001O&\u0000\u0001R\"\u0000\u0001F\u0014\u0000\u0001F\u0019\u0000\u0001Y\u0006\u0000\u0001Z\bY\u0006\u0000\u0004Y\u0002\u0000\u0001Y\b\u0000\u0001[\u0007\u0000\b[\u0006\u0000\u0004[\u0002\u0000\u0001[\b\u0000\u0001W\u0007\u0000\bW\u0006\u0000\u0004W\u0002\u0000\u0001W\b\u0000\u0001\\\u0001]\u0005\u0000\u0001^\b\\\u0006\u0000\u0004\\\u0001\u0000\u0001]\u0001\\\b\u0000\u0001Y\u0007\u0000\bY\u0006\u0000\u0004Y\u0002\u0000\u0001Y\t\u0000\u0001]\u0005\u0000\u0001^\u0013\u0000\u0001]\n\u0000\u0001]\u0019\u0000\u0001]\b\u0000";

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f28063XxX0x0xxx = 1;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f28065oI0IIXIo = 1;

    /* renamed from: xI, reason: collision with root package name */
    public static final String f28067xI = "\u0001\u0000\u0003\u0001\u0004\t\u0001\u0000\u0002\u0001\u0001\t\u0001\u0000\u0001\t\u0001\u0000\u0004\t\u0001\u0001\u0001\t\u0002\u0001\u0001\t\u0002\u0001\u0001\u0000\u0001\t\u0001\u0000\u0001\u0001\u0003\u0000\u0002\u0001\u0005\u0000\u0003\t\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0002\u0000\u0001\u0001\u0001\u0000\u0002\u0001\b\u0000\u0001\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\b\u0000\u0001\u0001\u0002\u0000\u0001\u0001\u0002\u0000\u0001\t\u0004\u0000\u0001\u0001\u0003\u0000\u0001\t\u0001\u0000\u0001\u0001\u0001\u0000";

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f28068xXxxox0I = 2;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f28070xxX = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28071I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28072II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28073II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28074OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public OoIXo.x0o f28075Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28076Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28077X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28078XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Reader f28079oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f28080oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f28081oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f28082ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public char[] f28083oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f28084x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OxxIIOOXO f28085x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28086xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28087xxIXOIIO;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f28054IIXOooo = "\b\u0000\u0003\u0015\u0015\u0000\u0001\u0015\u0001\u0014\u0001\u0011\u0001\u0016\u0001\b\u0002\u0000\u0001\u0012\u0001\u0005\u0001\u0006\u0001!\u0001\u001f\u0001\u0004\u0001 \u0001\u0007\u0001\u001b\u0001\u001c\t\u0002\u0001\u0003\u0001\u0000\u0001$\u0001#\u0001\"\u0001\u001e\u0001\u0000\u0001\u000e\u0002\u0001\u0001\u0018\u0001\f\u0001\r\u0002\u0001\u0001\u0019\u0002\u0001\u0001\u000f\u0001\u001d\u0001\u0017\u0003\u0001\u0001\n\u0001\u0010\u0001\t\u0001\u000b\u0001\u001a\u0004\u0001\u0004\u0000\u0001\u0013\u0001\u0000\u001a\u0001ﾅ\u0000";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final char[] f28069xoXoI = Oxx0xo(f28054IIXOooo);

    /* renamed from: o00, reason: collision with root package name */
    public static final int[] f28064o00 = x0xO0oo();

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int[] f28056O0xOxO = OxxIIOOXO();

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int[] f28061XI0IXoo = xoXoI();

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final String[] f28053IIX0o = {"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int[] f28066ooXIXxIX = IXxxXO();

    public xxIO(Reader reader) {
        this.f28071I0Io = 0;
        this.f28083oxoX = new char[16384];
        this.f28082ooOOo0oXI = true;
        this.f28079oIX0oI = reader;
    }

    public static int IIXOooo(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2);
            i2 += 2;
            int charAt2 = str.charAt(i3) - 1;
            do {
                iArr[i] = charAt2;
                charAt--;
                i++;
            } while (charAt > 0);
        }
        return i;
    }

    public static int[] IXxxXO() {
        int[] iArr = new int[94];
        Oo(f28067xI, 0, iArr);
        return iArr;
    }

    public static int Oo(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2);
            i2 += 2;
            char charAt2 = str.charAt(i3);
            do {
                iArr[i] = charAt2;
                charAt--;
                i++;
            } while (charAt > 0);
        }
        return i;
    }

    public static char[] Oxx0xo(String str) {
        char[] cArr = new char[65536];
        int i = 0;
        int i2 = 0;
        while (i < 100) {
            int i3 = i + 1;
            int charAt = str.charAt(i);
            i += 2;
            char charAt2 = str.charAt(i3);
            do {
                cArr[i2] = charAt2;
                charAt--;
                i2++;
            } while (charAt > 0);
        }
        return cArr;
    }

    public static int[] OxxIIOOXO() {
        int[] iArr = new int[94];
        oI0IIXIo(f28060X0IIOO, 0, iArr);
        return iArr;
    }

    public static int oI0IIXIo(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2) << 16;
            i2 += 2;
            iArr[i] = str.charAt(i3) | charAt;
            i++;
        }
        return i;
    }

    public static int oO(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int charAt = str.charAt(i2);
            i2 += 2;
            char charAt2 = str.charAt(i3);
            do {
                iArr[i] = charAt2;
                charAt--;
                i++;
            } while (charAt > 0);
        }
        return i;
    }

    public static int[] x0xO0oo() {
        int[] iArr = new int[94];
        oO(f28057OxI, 0, iArr);
        return iArr;
    }

    public static int[] xoXoI() {
        int[] iArr = new int[2627];
        IIXOooo(f28062XIxXXX0x0, 0, iArr);
        return iArr;
    }

    public void I0Io(OoIXo.x0o x0oVar) {
        this.f28075Oo = x0oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x0090, code lost:
    
        r7 = 65535;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public jxl.biff.formula.OI0 II0XooXoX() throws java.io.IOException, jxl.biff.formula.FormulaException {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.biff.formula.xxIO.II0XooXoX():jxl.biff.formula.OI0");
    }

    public void II0xO0(OxxIIOOXO oxxIIOOXO) {
        this.f28085x0xO0oo = oxxIIOOXO;
    }

    public final int OOXIXo() {
        return this.f28071I0Io;
    }

    public final int Oxx0IOOO() {
        return this.f28077X0o0xo - this.f28072II0XooXoX;
    }

    public final char X0o0xo(int i) {
        return this.f28083oxoX[this.f28072II0XooXoX + i];
    }

    public final void XO() throws IOException {
        this.f28084x0XOIxOo = true;
        this.f28087xxIXOIIO = this.f28072II0XooXoX;
        Reader reader = this.f28079oIX0oI;
        if (reader != null) {
            reader.close();
        }
    }

    public int oIX0oI() {
        return this.f28074OOXIXo;
    }

    public final String oOoXoXO() {
        char[] cArr = this.f28083oxoX;
        int i = this.f28072II0XooXoX;
        return new String(cArr, i, this.f28077X0o0xo - i);
    }

    public final boolean ooOOo0oXI() throws IOException {
        int i = this.f28072II0XooXoX;
        if (i > 0) {
            char[] cArr = this.f28083oxoX;
            System.arraycopy(cArr, i, cArr, 0, this.f28087xxIXOIIO - i);
            int i2 = this.f28087xxIXOIIO;
            int i3 = this.f28072II0XooXoX;
            this.f28087xxIXOIIO = i2 - i3;
            this.f28076Oxx0IOOO -= i3;
            this.f28077X0o0xo -= i3;
            this.f28078XO -= i3;
            this.f28072II0XooXoX = 0;
        }
        int i4 = this.f28076Oxx0IOOO;
        char[] cArr2 = this.f28083oxoX;
        if (i4 >= cArr2.length) {
            char[] cArr3 = new char[i4 * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.f28083oxoX = cArr3;
        }
        Reader reader = this.f28079oIX0oI;
        char[] cArr4 = this.f28083oxoX;
        int i5 = this.f28087xxIXOIIO;
        int read = reader.read(cArr4, i5, cArr4.length - i5);
        if (read < 0) {
            return true;
        }
        this.f28087xxIXOIIO += read;
        return false;
    }

    public final void oxoX(int i) {
        this.f28071I0Io = i;
    }

    public final void x0XOIxOo(int i) {
        String str;
        try {
            str = f28053IIX0o[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = f28053IIX0o[0];
        }
        throw new Error(str);
    }

    public final void xoIox(Reader reader) {
        this.f28079oIX0oI = reader;
        this.f28082ooOOo0oXI = true;
        this.f28084x0XOIxOo = false;
        this.f28072II0XooXoX = 0;
        this.f28087xxIXOIIO = 0;
        this.f28078XO = 0;
        this.f28077X0o0xo = 0;
        this.f28076Oxx0IOOO = 0;
        this.f28081oOoXoXO = 0;
        this.f28074OOXIXo = 0;
        this.f28086xoIox = 0;
        this.f28071I0Io = 0;
    }

    public void xxIXOIIO(int i) {
        if (i > Oxx0IOOO()) {
            x0XOIxOo(2);
        }
        this.f28077X0o0xo -= i;
    }

    public xxIO(InputStream inputStream) {
        this(new InputStreamReader(inputStream));
    }
}
