package jxl.read.biff;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public final class ooOx {

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28415ooXIXxIX = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooOx.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public oIX0oI f28416I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xIoXXXIXo.I0Io[][] f28417II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XIo0oOXIx f28418II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public I0 f28419IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f28420IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public OoIXo.OxxIIOOXO f28421IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int[] f28422O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public xIoXXXIXo.OxxIIOOXO[] f28424Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public OoIXo.XOxIOxOx f28425OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28426Oxx0IOOO;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public X0xOO.OxxIIOOXO f28428OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int[] f28429X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public OoIXo.xXxxox0I f28430X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f28431XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f28432XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f28433XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28434XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public xxIXOIIO f28435o00;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public XIxXXX0x0 f28437oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public oIX0oI f28441oxoX;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OoIXo.oIX0oI f28443x0xO0oo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public IIX0 f28444xXxxox0I;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28445xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public oxXx0IX f28446xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public xIoXXXIXo.xoXoI f28448xxX;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public ArrayList f28439oOoXoXO = new ArrayList();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public ArrayList f28440ooOOo0oXI = new ArrayList();

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList f28442x0XOIxOo = new ArrayList();

    /* renamed from: oO, reason: collision with root package name */
    public ArrayList f28438oO = new ArrayList();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ArrayList f28423OOXIXo = new ArrayList(10);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public ArrayList f28427Oxx0xo = new ArrayList();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public ArrayList f28436oI0IIXIo = new ArrayList();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public ArrayList f28447xxIXOIIO = new ArrayList();

    public ooOx(XIxXXX0x0 xIxXXX0x0, XIo0oOXIx xIo0oOXIx, OoIXo.xXxxox0I xxxxox0i, oIX0oI oix0oi, oIX0oI oix0oi2, boolean z, IIX0 iix0, int i, I0 i0) {
        this.f28437oIX0oI = xIxXXX0x0;
        this.f28418II0xO0 = xIo0oOXIx;
        this.f28430X0o0xo = xxxxox0i;
        this.f28416I0Io = oix0oi;
        this.f28441oxoX = oix0oi2;
        this.f28420IIXOooo = z;
        this.f28444xXxxox0I = iix0;
        this.f28445xoIox = i;
        this.f28419IIX0o = i0;
        this.f28448xxX = new xIoXXXIXo.xoXoI(i0);
        this.f28434XxX0x0xxx = this.f28444xXxxox0I.XX();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I0Io(int r9, int r10, int r11, int r12, OoIXo.xoXoI r13) {
        /*
            r8 = this;
        L0:
            if (r10 > r12) goto L79
            r6 = r9
        L3:
            if (r6 > r11) goto L76
            xIoXXXIXo.I0Io[][] r0 = r8.f28417II0XooXoX
            int r1 = r0.length
            if (r1 <= r10) goto L12
            r0 = r0[r10]
            int r1 = r0.length
            if (r1 <= r6) goto L12
            r0 = r0[r6]
            goto L13
        L12:
            r0 = 0
        L13:
            if (r0 != 0) goto L31
            jxl.read.biff.x0o r7 = new jxl.read.biff.x0o
            OoIXo.xXxxox0I r4 = r8.f28430X0o0xo
            jxl.read.biff.I0 r5 = r8.f28419IIX0o
            r3 = 0
            r0 = r7
            r1 = r10
            r2 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            xIoXXXIXo.oxoX r0 = new xIoXXXIXo.oxoX
            r0.<init>()
            r0.o00(r13)
            r7.oO(r0)
            r8.oIX0oI(r7)
            goto L73
        L31:
            boolean r1 = r0 instanceof jxl.read.biff.OOXIXo
            if (r1 == 0) goto L49
            jxl.read.biff.OOXIXo r0 = (jxl.read.biff.OOXIXo) r0
            xIoXXXIXo.oxoX r1 = r0.XO()
            if (r1 != 0) goto L45
            xIoXXXIXo.oxoX r1 = new xIoXXXIXo.oxoX
            r1.<init>()
            r0.oO(r1)
        L45:
            r1.o00(r13)
            goto L73
        L49:
            XxIIOXIXx.X0o0xo r1 = jxl.read.biff.ooOx.f28415ooXIXxIX
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Not able to add comment to cell type "
            r2.append(r3)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r2.append(r0)
            java.lang.String r0 = " at "
            r2.append(r0)
            java.lang.String r0 = xIoXXXIXo.XO.oIX0oI(r6, r10)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.ooOOo0oXI(r0)
        L73:
            int r6 = r6 + 1
            goto L3
        L76:
            int r10 = r10 + 1
            goto L0
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.read.biff.ooOx.I0Io(int, int, int, int, OoIXo.xoXoI):void");
    }

    public final ArrayList II0XooXoX() {
        return this.f28427Oxx0xo;
    }

    public final void II0xO0(int i, int i2, String str, double d, double d2) {
        xIoXXXIXo.I0Io i0Io = this.f28417II0XooXoX[i2][i];
        if (i0Io == null) {
            f28415ooXIXxIX.ooOOo0oXI("Cell at " + xIoXXXIXo.XO.oIX0oI(i, i2) + " not present - adding a blank");
            x0o x0oVar = new x0o(i2, i, 0, this.f28430X0o0xo, this.f28419IIX0o);
            xIoXXXIXo.oxoX oxox = new xIoXXXIXo.oxoX();
            oxox.xoXoI(str, d, d2);
            x0oVar.oO(oxox);
            oIX0oI(x0oVar);
            return;
        }
        if (i0Io instanceof OOXIXo) {
            OOXIXo oOXIXo = (OOXIXo) i0Io;
            xIoXXXIXo.oxoX XO2 = oOXIXo.XO();
            if (XO2 == null) {
                XO2 = new xIoXXXIXo.oxoX();
                oOXIXo.oO(XO2);
            }
            XO2.xoXoI(str, d, d2);
            return;
        }
        f28415ooXIXxIX.ooOOo0oXI("Not able to add comment to cell type " + i0Io.getClass().getName() + " at " + xIoXXXIXo.XO.oIX0oI(i, i2));
    }

    public final int[] IIXOooo() {
        return this.f28422O0xOxO;
    }

    public final xIoXXXIXo.OxxIIOOXO[] IXxxXO() {
        return this.f28424Oo;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ee A[Catch: DrawingDataException -> 0x001f, TryCatch #0 {DrawingDataException -> 0x001f, blocks: (B:7:0x000b, B:9:0x0013, B:11:0x0017, B:12:0x0022, B:14:0x003a, B:16:0x0043, B:18:0x0047, B:19:0x004e, B:21:0x006e, B:23:0x0084, B:26:0x008f, B:29:0x00a9, B:31:0x00c0, B:32:0x00c8, B:35:0x0076, B:36:0x00d5, B:38:0x00dd, B:40:0x00e1, B:41:0x00e8, B:43:0x0100, B:45:0x0108, B:47:0x010c, B:48:0x0113, B:50:0x0133, B:54:0x013f, B:56:0x0148, B:58:0x015e, B:61:0x0169, B:64:0x017b, B:67:0x018a, B:69:0x01a1, B:70:0x01a9, B:73:0x0150, B:75:0x01af, B:77:0x01b7, B:79:0x01bb, B:80:0x01c2, B:82:0x01e2, B:86:0x01ee, B:88:0x01f7, B:90:0x020d, B:93:0x0218, B:96:0x0232, B:98:0x0249, B:99:0x0251, B:102:0x01ff, B:104:0x0257, B:107:0x0263, B:109:0x028b, B:110:0x0292, B:112:0x02a9, B:116:0x02b5, B:118:0x02be, B:120:0x02da, B:123:0x02e3, B:125:0x02ee, B:128:0x02c6, B:130:0x02f8, B:132:0x0300, B:134:0x0328, B:135:0x032f, B:137:0x0340), top: B:6:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017b A[Catch: DrawingDataException -> 0x001f, TryCatch #0 {DrawingDataException -> 0x001f, blocks: (B:7:0x000b, B:9:0x0013, B:11:0x0017, B:12:0x0022, B:14:0x003a, B:16:0x0043, B:18:0x0047, B:19:0x004e, B:21:0x006e, B:23:0x0084, B:26:0x008f, B:29:0x00a9, B:31:0x00c0, B:32:0x00c8, B:35:0x0076, B:36:0x00d5, B:38:0x00dd, B:40:0x00e1, B:41:0x00e8, B:43:0x0100, B:45:0x0108, B:47:0x010c, B:48:0x0113, B:50:0x0133, B:54:0x013f, B:56:0x0148, B:58:0x015e, B:61:0x0169, B:64:0x017b, B:67:0x018a, B:69:0x01a1, B:70:0x01a9, B:73:0x0150, B:75:0x01af, B:77:0x01b7, B:79:0x01bb, B:80:0x01c2, B:82:0x01e2, B:86:0x01ee, B:88:0x01f7, B:90:0x020d, B:93:0x0218, B:96:0x0232, B:98:0x0249, B:99:0x0251, B:102:0x01ff, B:104:0x0257, B:107:0x0263, B:109:0x028b, B:110:0x0292, B:112:0x02a9, B:116:0x02b5, B:118:0x02be, B:120:0x02da, B:123:0x02e3, B:125:0x02ee, B:128:0x02c6, B:130:0x02f8, B:132:0x0300, B:134:0x0328, B:135:0x032f, B:137:0x0340), top: B:6:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0249 A[Catch: DrawingDataException -> 0x001f, TryCatch #0 {DrawingDataException -> 0x001f, blocks: (B:7:0x000b, B:9:0x0013, B:11:0x0017, B:12:0x0022, B:14:0x003a, B:16:0x0043, B:18:0x0047, B:19:0x004e, B:21:0x006e, B:23:0x0084, B:26:0x008f, B:29:0x00a9, B:31:0x00c0, B:32:0x00c8, B:35:0x0076, B:36:0x00d5, B:38:0x00dd, B:40:0x00e1, B:41:0x00e8, B:43:0x0100, B:45:0x0108, B:47:0x010c, B:48:0x0113, B:50:0x0133, B:54:0x013f, B:56:0x0148, B:58:0x015e, B:61:0x0169, B:64:0x017b, B:67:0x018a, B:69:0x01a1, B:70:0x01a9, B:73:0x0150, B:75:0x01af, B:77:0x01b7, B:79:0x01bb, B:80:0x01c2, B:82:0x01e2, B:86:0x01ee, B:88:0x01f7, B:90:0x020d, B:93:0x0218, B:96:0x0232, B:98:0x0249, B:99:0x0251, B:102:0x01ff, B:104:0x0257, B:107:0x0263, B:109:0x028b, B:110:0x0292, B:112:0x02a9, B:116:0x02b5, B:118:0x02be, B:120:0x02da, B:123:0x02e3, B:125:0x02ee, B:128:0x02c6, B:130:0x02f8, B:132:0x0300, B:134:0x0328, B:135:0x032f, B:137:0x0340), top: B:6:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O0xOxO(X0xOO.ooXIXxIX r11, X0xOO.xXxxox0I r12, java.util.HashMap r13) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jxl.read.biff.ooOx.O0xOxO(X0xOO.ooXIXxIX, X0xOO.xXxxox0I, java.util.HashMap):void");
    }

    public final ArrayList OOXIXo() {
        return this.f28438oO;
    }

    public int Oo() {
        return this.f28431XI0IXoo;
    }

    public final OoIXo.XOxIOxOx OxI() {
        return this.f28425OxI;
    }

    public final xIoXXXIXo.I0Io[][] Oxx0IOOO() {
        return this.f28417II0XooXoX;
    }

    public final int Oxx0xo() {
        return this.f28426Oxx0IOOO;
    }

    public final oxXx0IX OxxIIOOXO() {
        return this.f28446xoXoI;
    }

    public final void X0IIOO() {
        int i = this.f28433XO;
        int i2 = this.f28426Oxx0IOOO;
        Iterator it = this.f28447xxIXOIIO.iterator();
        while (it.hasNext()) {
            xIoXXXIXo.I0Io i0Io = (xIoXXXIXo.I0Io) it.next();
            i = Math.max(i, i0Io.II0xO0() + 1);
            i2 = Math.max(i2, i0Io.oIX0oI() + 1);
        }
        if (i2 > this.f28426Oxx0IOOO) {
            for (int i3 = 0; i3 < this.f28433XO; i3++) {
                xIoXXXIXo.I0Io[] i0IoArr = new xIoXXXIXo.I0Io[i2];
                xIoXXXIXo.I0Io[] i0IoArr2 = this.f28417II0XooXoX[i3];
                System.arraycopy(i0IoArr2, 0, i0IoArr, 0, i0IoArr2.length);
                this.f28417II0XooXoX[i3] = i0IoArr;
            }
        }
        if (i > this.f28433XO) {
            xIoXXXIXo.I0Io[][] i0IoArr3 = new xIoXXXIXo.I0Io[i];
            xIoXXXIXo.I0Io[][] i0IoArr4 = this.f28417II0XooXoX;
            System.arraycopy(i0IoArr4, 0, i0IoArr3, 0, i0IoArr4.length);
            this.f28417II0XooXoX = i0IoArr3;
            for (int i4 = this.f28433XO; i4 < i; i4++) {
                i0IoArr3[i4] = new xIoXXXIXo.I0Io[i2];
            }
        }
        this.f28433XO = i;
        this.f28426Oxx0IOOO = i2;
        Iterator it2 = this.f28447xxIXOIIO.iterator();
        while (it2.hasNext()) {
            oIX0oI((xIoXXXIXo.I0Io) it2.next());
        }
        this.f28447xxIXOIIO.clear();
    }

    public final OoIXo.oIX0oI X0o0xo() {
        return this.f28443x0xO0oo;
    }

    public final void XI0IXoo() {
        OoIXo.XI0IXoo xI0IXoo;
        II0xO0 iI0xO0;
        OoIXo.ooOOo0oXI ooooo0oxi;
        HashMap hashMap;
        ArrayList arrayList;
        boolean z;
        X0xOO.xXxxox0I xxxxox0i;
        X0xOO.ooXIXxIX ooxixxix;
        OoIXo.II0xO0 iI0xO02;
        HashMap hashMap2;
        ArrayList arrayList2;
        II0xO0 iI0xO03;
        int i;
        int i2;
        int i3;
        X0xOO.xXxxox0I xxxxox0i2;
        oXIO0o0XI oxio0o0xi;
        oo0xXOI0I oo0xxoi0i;
        xxX xxx2;
        ooXIXxIX ooxixxix2;
        xIoXXXIXo.I0Io ooxoiiio;
        II0xO0 iI0xO04;
        oOo ooo;
        int i4;
        xoXoI xoxoi;
        this.f28437oIX0oI.OOXIXo(this.f28445xoIox);
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        int i5 = 0;
        char c = 1;
        OoIXo.XI0IXoo xI0IXoo2 = null;
        OoIXo.II0xO0 iI0xO05 = null;
        II0xO0 iI0xO06 = null;
        OoIXo.ooOOo0oXI ooooo0oxi2 = null;
        boolean z2 = true;
        boolean z3 = false;
        X0xOO.xXxxox0I xxxxox0i3 = null;
        X0xOO.ooXIXxIX ooxixxix3 = null;
        oOo ooo2 = null;
        OoIXo.x0xO0oo x0xo0oo = null;
        boolean z4 = true;
        while (z2) {
            xoxXI Oxx0IOOO2 = this.f28437oIX0oI.Oxx0IOOO();
            OoIXo.xII X0o0xo2 = Oxx0IOOO2.X0o0xo();
            if (X0o0xo2 == OoIXo.xII.f2496oXX0IoI && Oxx0IOOO2.II0xO0() == 0) {
                f28415ooXIXxIX.ooOOo0oXI("Biff code zero found");
                if (Oxx0IOOO2.oxoX() == 10) {
                    f28415ooXIXxIX.ooOOo0oXI("Biff code zero found - trying a dimension record.");
                    Oxx0IOOO2.XO(OoIXo.xII.f2532xxIXOIIO);
                } else {
                    f28415ooXIXxIX.ooOOo0oXI("Biff code zero found - Ignoring.");
                }
            }
            if (X0o0xo2 == OoIXo.xII.f2532xxIXOIIO) {
                if (this.f28441oxoX.XX0()) {
                    xoxoi = new xoXoI(Oxx0IOOO2);
                } else {
                    xoxoi = new xoXoI(Oxx0IOOO2, xoXoI.f28529XO);
                }
                this.f28433XO = xoxoi.xXOx();
                int xo0x2 = xoxoi.xo0x();
                this.f28426Oxx0IOOO = xo0x2;
                int i6 = this.f28433XO;
                int[] iArr = new int[2];
                iArr[c] = xo0x2;
                iArr[i5] = i6;
                this.f28417II0XooXoX = (xIoXXXIXo.I0Io[][]) Array.newInstance((Class<?>) xIoXXXIXo.I0Io.class, iArr);
            } else if (X0o0xo2 == OoIXo.xII.f2442O0xOxO) {
                oIX0oI(new Xx000oIo(Oxx0IOOO2, this.f28418II0xO0, this.f28430X0o0xo, this.f28419IIX0o));
            } else {
                if (X0o0xo2 == OoIXo.xII.f2489oO || X0o0xo2 == OoIXo.xII.f2514x0xO0oo) {
                    xI0IXoo = xI0IXoo2;
                    iI0xO0 = iI0xO06;
                    ooooo0oxi = ooooo0oxi2;
                    hashMap = hashMap3;
                    arrayList = arrayList3;
                    z = z2;
                    xxxxox0i = xxxxox0i3;
                    ooxixxix = ooxixxix3;
                    iI0xO02 = iI0xO05;
                    O0Xx o0Xx = new O0Xx(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o);
                    if (this.f28430X0o0xo.OOXIXo(o0Xx.xXOx())) {
                        oIX0oI(new oI0IIXIo(o0Xx, o0Xx.xXOx(), this.f28430X0o0xo, this.f28420IIXOooo, this.f28419IIX0o));
                    } else {
                        oIX0oI(o0Xx);
                    }
                } else if (X0o0xo2 == OoIXo.xII.f2516xI0oxI00) {
                    this.f28442x0XOIxOo.add(new IoOoX(Oxx0IOOO2, this.f28419IIX0o, this.f28434XxX0x0xxx));
                } else if (X0o0xo2 == OoIXo.xII.f2491oOo) {
                    xII xii = new xII(Oxx0IOOO2, this.f28419IIX0o);
                    xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr = this.f28424Oo;
                    if (oxxIIOOXOArr == null) {
                        this.f28424Oo = xii.xo0x();
                    } else {
                        xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr2 = new xIoXXXIXo.OxxIIOOXO[oxxIIOOXOArr.length + xii.xo0x().length];
                        xIoXXXIXo.OxxIIOOXO[] oxxIIOOXOArr3 = this.f28424Oo;
                        System.arraycopy(oxxIIOOXOArr3, i5, oxxIIOOXOArr2, i5, oxxIIOOXOArr3.length);
                        System.arraycopy(xii.xo0x(), i5, oxxIIOOXOArr2, this.f28424Oo.length, xii.xo0x().length);
                        this.f28424Oo = oxxIIOOXOArr2;
                    }
                } else if (X0o0xo2 == OoIXo.xII.f2450Oo) {
                    OI0 oi0 = new OI0(Oxx0IOOO2);
                    int xXOx2 = oi0.xXOx();
                    int i7 = 0;
                    while (i7 < xXOx2) {
                        int I0X0x0oIo2 = oi0.I0X0x0oIo(i7);
                        XoX xoX2 = new XoX(oi0.II0xO0(), oi0.xo0x() + i7, XoI0Ixx0.oIX0oI(oi0.XX0(i7)), I0X0x0oIo2, this.f28430X0o0xo, this.f28419IIX0o);
                        if (this.f28430X0o0xo.OOXIXo(I0X0x0oIo2)) {
                            i4 = xXOx2;
                            oIX0oI(new oI0IIXIo(xoX2, I0X0x0oIo2, this.f28430X0o0xo, this.f28420IIXOooo, this.f28419IIX0o));
                        } else {
                            i4 = xXOx2;
                            xoX2.I0Io(this.f28430X0o0xo.Oxx0IOOO(I0X0x0oIo2));
                            oIX0oI(xoX2);
                        }
                        i7++;
                        xXOx2 = i4;
                    }
                } else if (X0o0xo2 == OoIXo.xII.f2458X0IIOO) {
                    oxxXoxO oxxxoxo = new oxxXoxO(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o);
                    if (this.f28430X0o0xo.OOXIXo(oxxxoxo.xXOx())) {
                        oIX0oI(new oI0IIXIo(oxxxoxo, oxxxoxo.xXOx(), this.f28430X0o0xo, this.f28420IIXOooo, this.f28419IIX0o));
                    } else {
                        oIX0oI(oxxxoxo);
                    }
                } else if (X0o0xo2 == OoIXo.xII.f2498oo) {
                    XO xo2 = new XO(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o);
                    if (xo2.XX0()) {
                        oIX0oI(new OxI(xo2.oxXx0IX(), this.f28430X0o0xo, this.f28419IIX0o));
                    } else {
                        oIX0oI(xo2);
                    }
                } else if (X0o0xo2 == OoIXo.xII.f2445OO) {
                    this.f28448xxX.O00XxXI(new I0X0x0oIo(Oxx0IOOO2).xo0x());
                } else if (X0o0xo2 == OoIXo.xII.f2414I0X0x0oIo) {
                    this.f28448xxX.ox(new oX(Oxx0IOOO2).xo0x());
                } else {
                    if (X0o0xo2 == OoIXo.xII.f2485o0xxxXXxX) {
                        if (this.f28441oxoX.XX0()) {
                            ooo = new oOo(Oxx0IOOO2);
                        } else {
                            ooo = new oOo(Oxx0IOOO2, oOo.f28389oOoXoXO);
                        }
                        ooo2 = ooo;
                        this.f28448xxX.XIXIX(ooo2.Xo0());
                        this.f28448xxX.oxxXoxO(ooo2.xo0x());
                        this.f28448xxX.xOOOX(true);
                        this.f28448xxX.x0xO(ooo2.XoI0Ixx0());
                    } else if (X0o0xo2 == OoIXo.xII.f2486oI) {
                        xXOx xxox = new xXOx(Oxx0IOOO2);
                        if (ooo2 != null && ooo2.xXOx()) {
                            this.f28448xxX.O0X(xxox.xXOx());
                            this.f28448xxX.O0Xx(xxox.xo0x());
                        }
                    } else if (X0o0xo2 == OoIXo.xII.f2528xoXoI) {
                        x0xo0oo = new OoIXo.x0xO0oo(Oxx0IOOO2);
                    } else {
                        if (X0o0xo2 == OoIXo.xII.f2500ooOOo0oXI) {
                            if (!this.f28434XxX0x0xxx.X0o0xo()) {
                                X0xOO.IIX0o iIX0o = new X0xOO.IIX0o(Oxx0IOOO2);
                                X0xOO.ooOOo0oXI ooooo0oxi3 = (X0xOO.ooOOo0oXI) hashMap3.remove(new Integer(iIX0o.XX0()));
                                if (ooooo0oxi3 == null) {
                                    f28415ooXIXxIX.ooOOo0oXI(" cannot find comment for note id " + iIX0o.XX0() + "...ignoring");
                                } else {
                                    ooooo0oxi3.xXxxox0I(iIX0o);
                                    this.f28436oI0IIXIo.add(ooooo0oxi3);
                                    xI0IXoo = xI0IXoo2;
                                    z = z2;
                                    iI0xO02 = iI0xO05;
                                    iI0xO0 = iI0xO06;
                                    ooooo0oxi = ooooo0oxi2;
                                    hashMap2 = hashMap3;
                                    arrayList2 = arrayList3;
                                    xxxxox0i = xxxxox0i3;
                                    ooxixxix = ooxixxix3;
                                    II0xO0(ooooo0oxi3.II0xO0(), ooooo0oxi3.x0xO0oo(), ooooo0oxi3.IXxxXO(), ooooo0oxi3.getWidth(), ooooo0oxi3.getHeight());
                                }
                            }
                            xI0IXoo = xI0IXoo2;
                            iI0xO0 = iI0xO06;
                            ooooo0oxi = ooooo0oxi2;
                            hashMap2 = hashMap3;
                            arrayList2 = arrayList3;
                            z = z2;
                            xxxxox0i = xxxxox0i3;
                            ooxixxix = ooxixxix3;
                            iI0xO02 = iI0xO05;
                        } else {
                            xI0IXoo = xI0IXoo2;
                            iI0xO0 = iI0xO06;
                            ooooo0oxi = ooooo0oxi2;
                            hashMap2 = hashMap3;
                            arrayList2 = arrayList3;
                            z = z2;
                            xxxxox0i = xxxxox0i3;
                            ooxixxix = ooxixxix3;
                            iI0xO02 = iI0xO05;
                            if (X0o0xo2 != OoIXo.xII.f2534xxX) {
                                if (X0o0xo2 == OoIXo.xII.f2524xo0x) {
                                    this.f28448xxX.I0(new Xo0(Oxx0IOOO2).xo0x());
                                } else {
                                    if (X0o0xo2 == OoIXo.xII.f2502ooXIXxIX) {
                                        if (iI0xO0 == null) {
                                            f28415ooXIXxIX.ooOOo0oXI("Shared template formula is null - trying most recent formula template");
                                            ArrayList arrayList4 = this.f28440ooOOo0oXI;
                                            XI0oooXX xI0oooXX = (XI0oooXX) arrayList4.get(arrayList4.size() - 1);
                                            if (xI0oooXX != null) {
                                                iI0xO04 = xI0oooXX.I0Io();
                                                IIX0 iix0 = this.f28444xXxxox0I;
                                                this.f28440ooOOo0oXI.add(new XI0oooXX(Oxx0IOOO2, iI0xO04, iix0, iix0, this.f28419IIX0o));
                                                xxxxox0i3 = xxxxox0i;
                                                ooxixxix3 = ooxixxix;
                                                ooooo0oxi2 = ooooo0oxi;
                                                xI0IXoo2 = xI0IXoo;
                                                iI0xO05 = iI0xO02;
                                                z2 = z;
                                                hashMap = hashMap2;
                                                arrayList = arrayList2;
                                                iI0xO0 = null;
                                            }
                                        }
                                        iI0xO04 = iI0xO0;
                                        IIX0 iix02 = this.f28444xXxxox0I;
                                        this.f28440ooOOo0oXI.add(new XI0oooXX(Oxx0IOOO2, iI0xO04, iix02, iix02, this.f28419IIX0o));
                                        xxxxox0i3 = xxxxox0i;
                                        ooxixxix3 = ooxixxix;
                                        ooooo0oxi2 = ooooo0oxi;
                                        xI0IXoo2 = xI0IXoo;
                                        iI0xO05 = iI0xO02;
                                        z2 = z;
                                        hashMap = hashMap2;
                                        arrayList = arrayList2;
                                        iI0xO0 = null;
                                    } else if (X0o0xo2 == OoIXo.xII.f2523xXxxox0I || X0o0xo2 == OoIXo.xII.f2421IIX0o) {
                                        hashMap = hashMap2;
                                        arrayList = arrayList2;
                                        XIxXXX0x0 xIxXXX0x0 = this.f28437oIX0oI;
                                        OoIXo.xXxxox0I xxxxox0i4 = this.f28430X0o0xo;
                                        IIX0 iix03 = this.f28444xXxxox0I;
                                        xXxxox0I xxxxox0i5 = new xXxxox0I(Oxx0IOOO2, xIxXXX0x0, xxxxox0i4, iix03, iix03, this.f28419IIX0o, this.f28434XxX0x0xxx);
                                        if (xxxxox0i5.I0X0x0oIo()) {
                                            iI0xO03 = (II0xO0) xxxxox0i5.XX0();
                                            z3 = oxoX(iI0xO03);
                                            if (z3) {
                                                iI0xO03 = iI0xO0;
                                            }
                                            if (!z3 && iI0xO0 != null) {
                                                oIX0oI(XIxXXX0x0(iI0xO0));
                                            }
                                        } else {
                                            xIoXXXIXo.I0Io XX02 = xxxxox0i5.XX0();
                                            try {
                                                if (xxxxox0i5.XX0().getType() == xIoXXXIXo.Oxx0IOOO.f34236Oxx0IOOO) {
                                                    I0oOoX i0oOoX = (I0oOoX) xxxxox0i5.XX0();
                                                    if (this.f28430X0o0xo.OOXIXo(i0oOoX.xXOx())) {
                                                        OoIXo.xXxxox0I xxxxox0i6 = this.f28430X0o0xo;
                                                        IIX0 iix04 = this.f28444xXxxox0I;
                                                        XX02 = new Oxx0xo(i0oOoX, xxxxox0i6, iix04, iix04, this.f28420IIXOooo, this.f28419IIX0o);
                                                    }
                                                }
                                                oIX0oI(XX02);
                                            } catch (FormulaException e) {
                                                f28415ooXIXxIX.ooOOo0oXI(xIoXXXIXo.XO.oIX0oI(XX02.oIX0oI(), XX02.II0xO0()) + " " + e.getMessage());
                                            }
                                            iI0xO03 = iI0xO0;
                                        }
                                        iI0xO0 = iI0xO03;
                                    } else if (X0o0xo2 == OoIXo.xII.f2483o00) {
                                        if (this.f28441oxoX.XX0()) {
                                            ooxoiiio = new oOXoIIIo(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o, this.f28434XxX0x0xxx);
                                        } else {
                                            ooxoiiio = new oOXoIIIo(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o, this.f28434XxX0x0xxx, oOXoIIIo.f28385x0XOIxOo);
                                        }
                                        oIX0oI(ooxoiiio);
                                    } else if (X0o0xo2 == OoIXo.xII.f2453OxI) {
                                        XxIIOXIXx.oIX0oI.oIX0oI(!this.f28441oxoX.XX0());
                                        oIX0oI(new I0oOIX(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o, this.f28434XxX0x0xxx, I0oOIX.f28139x0XOIxOo));
                                    } else if (X0o0xo2 != OoIXo.xII.f2463XI0IXoo) {
                                        if (X0o0xo2 == OoIXo.xII.f2434Ioxxx) {
                                            this.f28448xxX.XX0xXo(new XX0(Oxx0IOOO2).xo0x());
                                        } else if (X0o0xo2 == OoIXo.xII.f2493oOoXoXO) {
                                            x0xO x0xo = new x0xO(Oxx0IOOO2);
                                            if (!x0xo.O0Xx() || !x0xo.I0oOIX() || x0xo.XoI0Ixx0() || x0xo.Xo0() || x0xo.xXOx() != 0) {
                                                this.f28423OOXIXo.add(x0xo);
                                            }
                                        } else if (X0o0xo2 == OoIXo.xII.f2525xoIox) {
                                            if (!this.f28434XxX0x0xxx.x0XOIxOo()) {
                                                oIX0oI(new oxoX(Oxx0IOOO2, this.f28430X0o0xo, this.f28419IIX0o));
                                            }
                                        } else if (X0o0xo2 == OoIXo.xII.f2447OOXIXo) {
                                            if (!this.f28434XxX0x0xxx.x0XOIxOo()) {
                                                XOxIOxOx xOxIOxOx = new XOxIOxOx(Oxx0IOOO2);
                                                int i8 = 0;
                                                for (int xXOx3 = xOxIOxOx.xXOx(); i8 < xXOx3; xXOx3 = xXOx3) {
                                                    oIX0oI(new x0o(xOxIOxOx.II0xO0(), xOxIOxOx.xo0x() + i8, xOxIOxOx.XX0(i8), this.f28430X0o0xo, this.f28419IIX0o));
                                                    i8++;
                                                }
                                            }
                                        } else if (X0o0xo2 == OoIXo.xII.f2427IXO) {
                                            this.f28448xxX.xOoOIoI(new OO0x0xX(Oxx0IOOO2).xo0x());
                                        } else if (X0o0xo2 == OoIXo.xII.f2456OxxIIOOXO) {
                                            this.f28439oOoXoXO.add(new oO(Oxx0IOOO2));
                                        } else if (X0o0xo2 == OoIXo.xII.f2494oX) {
                                            if (this.f28441oxoX.XX0()) {
                                                ooxixxix2 = new ooXIXxIX(Oxx0IOOO2, this.f28434XxX0x0xxx);
                                            } else {
                                                ooxixxix2 = new ooXIXxIX(Oxx0IOOO2, this.f28434XxX0x0xxx, ooXIXxIX.f28449X0o0xo);
                                            }
                                            this.f28448xxX.I0X0x0oIo(new xIoXXXIXo.x0XOIxOo(ooxixxix2.xo0x()));
                                        } else if (X0o0xo2 == OoIXo.xII.f2477Xo0) {
                                            if (this.f28441oxoX.XX0()) {
                                                xxx2 = new xxX(Oxx0IOOO2, this.f28434XxX0x0xxx);
                                            } else {
                                                xxx2 = new xxX(Oxx0IOOO2, this.f28434XxX0x0xxx, xxX.f28556oxoX);
                                            }
                                            this.f28448xxX.xXOx(new xIoXXXIXo.x0XOIxOo(xxx2.xo0x()));
                                        } else if (X0o0xo2 == OoIXo.xII.f2529xoxXI) {
                                            xxIO xxio = new xxIO(Oxx0IOOO2);
                                            if (xxio.XoI0Ixx0()) {
                                                if (xxio.IoOoo()) {
                                                    this.f28448xxX.IoOoo(oI0X0.OOXIXo.f31385oIX0oI);
                                                } else {
                                                    this.f28448xxX.IoOoo(oI0X0.OOXIXo.f31384II0xO0);
                                                }
                                                if (xxio.xoIxX()) {
                                                    this.f28448xxX.OO0x0xX(oI0X0.xoIox.f31602II0xO0);
                                                } else {
                                                    this.f28448xxX.OO0x0xX(oI0X0.xoIox.f31603oIX0oI);
                                                }
                                                this.f28448xxX.Ioxxx(oI0X0.oOoXoXO.oIX0oI(xxio.I0oOIX()));
                                                this.f28448xxX.oX(xxio.oX());
                                                this.f28448xxX.XX0(xxio.I0X0x0oIo());
                                                this.f28448xxX.OX00O0xII(xxio.xoxXI());
                                                this.f28448xxX.XIo0oOXIx(xxio.O0Xx());
                                                this.f28448xxX.xo0x(xxio.XX0());
                                                this.f28448xxX.XoX(xxio.xXOx());
                                                this.f28448xxX.I0oOIX(xxio.Xo0());
                                                this.f28448xxX.IIX0(xxio.OO());
                                                this.f28448xxX.o0(xxio.xo0x());
                                                OoIXo.XOxIOxOx xOxIOxOx2 = this.f28425OxI;
                                                if (xOxIOxOx2 != null) {
                                                    this.f28448xxX.oxXx0IX(xOxIOxOx2.XX0());
                                                }
                                            }
                                        } else if (X0o0xo2 == OoIXo.xII.f2443OI0) {
                                            this.f28425OxI = new OoIXo.XOxIOxOx(Oxx0IOOO2);
                                        } else if (X0o0xo2 == OoIXo.xII.f2517xII) {
                                            this.f28448xxX.XX(new OxxIIOOXO(Oxx0IOOO2).xo0x());
                                        } else if (X0o0xo2 == OoIXo.xII.f2512x0o) {
                                            IIXOooo iIXOooo = new IIXOooo(Oxx0IOOO2);
                                            if (iIXOooo.xo0x() != 0) {
                                                this.f28448xxX.I0oOoX(iIXOooo.xo0x());
                                            }
                                        } else {
                                            if (X0o0xo2 == OoIXo.xII.f2433IoXIXo) {
                                                ooooo0oxi2 = new OoIXo.ooOOo0oXI(new OoIXo.x0XOIxOo(Oxx0IOOO2));
                                                this.f28438oO.add(ooooo0oxi2);
                                                xxxxox0i3 = xxxxox0i;
                                                ooxixxix3 = ooxixxix;
                                                xI0IXoo2 = xI0IXoo;
                                            } else if (X0o0xo2 == OoIXo.xII.f2533xxOXOOoIX) {
                                                ooooo0oxi.oIX0oI(new OoIXo.oO(Oxx0IOOO2));
                                            } else if (X0o0xo2 == OoIXo.xII.f2416I0oOoX) {
                                                xI0IXoo2 = new OoIXo.XI0IXoo(Oxx0IOOO2);
                                                xxxxox0i3 = xxxxox0i;
                                                ooxixxix3 = ooxixxix;
                                                ooooo0oxi2 = ooooo0oxi;
                                            } else {
                                                if (X0o0xo2 == OoIXo.xII.f2507oxxXoxO) {
                                                    iI0xO05 = new OoIXo.II0xO0(Oxx0IOOO2);
                                                    xxxxox0i3 = xxxxox0i;
                                                    ooxixxix3 = ooxixxix;
                                                    ooooo0oxi2 = ooooo0oxi;
                                                    xI0IXoo2 = xI0IXoo;
                                                } else if (X0o0xo2 == OoIXo.xII.f2479XoX) {
                                                    if (!this.f28434XxX0x0xxx.II0xO0()) {
                                                        OoIXo.I0Io i0Io = new OoIXo.I0Io(Oxx0IOOO2);
                                                        if (this.f28443x0xO0oo == null) {
                                                            this.f28443x0xO0oo = new OoIXo.oIX0oI(xI0IXoo, iI0xO02);
                                                            xI0IXoo2 = null;
                                                            iI0xO05 = null;
                                                        } else {
                                                            xI0IXoo2 = xI0IXoo;
                                                            iI0xO05 = iI0xO02;
                                                        }
                                                        this.f28443x0xO0oo.oIX0oI(i0Io);
                                                        xxxxox0i3 = xxxxox0i;
                                                        ooxixxix3 = ooxixxix;
                                                        ooooo0oxi2 = ooooo0oxi;
                                                    }
                                                } else if (X0o0xo2 == OoIXo.xII.f2466XIXIxO) {
                                                    this.f28448xxX.xoxXI(new X00IoxXI(Oxx0IOOO2).xo0x());
                                                } else if (X0o0xo2 == OoIXo.xII.f2451OoO) {
                                                    this.f28448xxX.xoO0xx0(new xoIxX(Oxx0IOOO2).xo0x());
                                                } else if (X0o0xo2 == OoIXo.xII.f2444OIOoIIOIx) {
                                                    this.f28448xxX.oXIO0o0XI(new XIXIX(Oxx0IOOO2).xo0x());
                                                } else if (X0o0xo2 == OoIXo.xII.f2509x0OIX00oO) {
                                                    this.f28448xxX.Io(new Oxx0IOOO(Oxx0IOOO2).xo0x());
                                                } else if (X0o0xo2 == OoIXo.xII.f2437O0) {
                                                    if (this.f28441oxoX.XX0()) {
                                                        oo0xxoi0i = new oo0xXOI0I(Oxx0IOOO2);
                                                    } else {
                                                        oo0xxoi0i = new oo0xXOI0I(Oxx0IOOO2, oo0xXOI0I.f28411X0o0xo);
                                                    }
                                                    this.f28422O0xOxO = oo0xxoi0i.xo0x();
                                                } else if (X0o0xo2 == OoIXo.xII.f2452Ox0O) {
                                                    if (this.f28441oxoX.XX0()) {
                                                        oxio0o0xi = new oXIO0o0XI(Oxx0IOOO2);
                                                    } else {
                                                        oxio0o0xi = new oXIO0o0XI(Oxx0IOOO2, oXIO0o0XI.f28408X0o0xo);
                                                    }
                                                    this.f28429X0IIOO = oxio0o0xi.xo0x();
                                                } else if (X0o0xo2 == OoIXo.xII.f2492oOoIIO0) {
                                                    this.f28446xoXoI = new oxXx0IX(Oxx0IOOO2);
                                                    while (this.f28437oIX0oI.II0XooXoX().X0o0xo() == OoIXo.xII.f2528xoXoI) {
                                                        Oxx0IOOO2.oIX0oI(this.f28437oIX0oI.Oxx0IOOO());
                                                    }
                                                } else if (X0o0xo2 == OoIXo.xII.f2510x0OxxIOxX) {
                                                    if (!this.f28434XxX0x0xxx.I0Io()) {
                                                        OoIXo.IIXOooo iIXOooo2 = new OoIXo.IIXOooo(Oxx0IOOO2);
                                                        if (iIXOooo2.Xo0() == -1) {
                                                            if (xxxxox0i != null && ooxixxix == null) {
                                                                if (this.f28428OxxIIOOXO == null) {
                                                                    this.f28428OxxIIOOXO = new X0xOO.OxxIIOOXO();
                                                                }
                                                                this.f28436oI0IIXIo.add(new X0xOO.oI0IIXIo(xxxxox0i, this.f28428OxxIIOOXO, this.f28444xXxxox0I.X00IoxXI()));
                                                                this.f28421IXxxXO = new OoIXo.OxxIIOOXO(iIXOooo2);
                                                                arrayList = arrayList2;
                                                                xxxxox0i3 = null;
                                                                ooxixxix3 = ooxixxix;
                                                                ooooo0oxi2 = ooooo0oxi;
                                                                xI0IXoo2 = xI0IXoo;
                                                                iI0xO05 = iI0xO02;
                                                                z2 = z;
                                                                hashMap = hashMap2;
                                                            } else {
                                                                this.f28421IXxxXO = new OoIXo.OxxIIOOXO(iIXOooo2);
                                                                arrayList = arrayList2;
                                                            }
                                                        } else {
                                                            arrayList = arrayList2;
                                                            if (arrayList.contains(new Integer(iIXOooo2.Xo0()))) {
                                                                this.f28421IXxxXO = new OoIXo.OxxIIOOXO(iIXOooo2);
                                                            } else {
                                                                f28415ooXIXxIX.ooOOo0oXI("object id " + iIXOooo2.Xo0() + " referenced  by data validity list record not found - ignoring");
                                                            }
                                                        }
                                                        xxxxox0i3 = xxxxox0i;
                                                        ooxixxix3 = ooxixxix;
                                                        ooooo0oxi2 = ooooo0oxi;
                                                        xI0IXoo2 = xI0IXoo;
                                                        iI0xO05 = iI0xO02;
                                                        z2 = z;
                                                        hashMap = hashMap2;
                                                    } else {
                                                        arrayList = arrayList2;
                                                        hashMap = hashMap2;
                                                    }
                                                } else {
                                                    arrayList = arrayList2;
                                                    if (X0o0xo2 == OoIXo.xII.f2478XoI0Ixx0) {
                                                        this.f28448xxX.XoI0Ixx0(new ooOOo0oXI(Oxx0IOOO2).xo0x());
                                                    } else if (X0o0xo2 == OoIXo.xII.f2441O0Xx) {
                                                        this.f28448xxX.oOo(new ooOOo0oXI(Oxx0IOOO2).xo0x());
                                                    } else if (X0o0xo2 == OoIXo.xII.f2522xXoOI00O) {
                                                        if (!this.f28434XxX0x0xxx.I0Io()) {
                                                            IIX0 iix05 = this.f28444xXxxox0I;
                                                            OoIXo.xoXoI xoxoi2 = new OoIXo.xoXoI(Oxx0IOOO2, iix05, iix05, iix05.XX());
                                                            OoIXo.OxxIIOOXO oxxIIOOXO = this.f28421IXxxXO;
                                                            if (oxxIIOOXO != null) {
                                                                oxxIIOOXO.oIX0oI(xoxoi2);
                                                                I0Io(xoxoi2.I0X0x0oIo(), xoxoi2.oX(), xoxoi2.Xx000oIo(), xoxoi2.Oxx0xo(), xoxoi2);
                                                            } else {
                                                                f28415ooXIXxIX.ooOOo0oXI("cannot add data validity settings");
                                                            }
                                                        }
                                                    } else if (X0o0xo2 == OoIXo.xII.f2430IoIOOxIIo) {
                                                        X0xOO.ooXIXxIX ooxixxix4 = new X0xOO.ooXIXxIX(Oxx0IOOO2);
                                                        if (!this.f28434XxX0x0xxx.X0o0xo()) {
                                                            if (xxxxox0i == null && x0xo0oo != null) {
                                                                f28415ooXIXxIX.ooOOo0oXI("Cannot find drawing record - using continue record");
                                                                xxxxox0i2 = new X0xOO.xXxxox0I(x0xo0oo.oxXx0IX());
                                                                hashMap = hashMap2;
                                                                x0xo0oo = null;
                                                            } else {
                                                                xxxxox0i2 = xxxxox0i;
                                                                hashMap = hashMap2;
                                                            }
                                                            O0xOxO(ooxixxix4, xxxxox0i2, hashMap);
                                                            arrayList.add(new Integer(ooxixxix4.oX()));
                                                            xxxxox0i3 = xxxxox0i2;
                                                        } else {
                                                            hashMap = hashMap2;
                                                            xxxxox0i3 = xxxxox0i;
                                                        }
                                                        if (ooxixxix4.XoI0Ixx0() != X0xOO.ooXIXxIX.f3566x0XOIxOo) {
                                                            ooooo0oxi2 = ooooo0oxi;
                                                            xI0IXoo2 = xI0IXoo;
                                                            iI0xO05 = iI0xO02;
                                                            z2 = z;
                                                            xxxxox0i3 = null;
                                                            ooxixxix3 = null;
                                                        } else {
                                                            ooxixxix3 = ooxixxix4;
                                                            ooooo0oxi2 = ooooo0oxi;
                                                            xI0IXoo2 = xI0IXoo;
                                                            iI0xO05 = iI0xO02;
                                                            z2 = z;
                                                        }
                                                    } else {
                                                        hashMap = hashMap2;
                                                        if (X0o0xo2 == OoIXo.xII.f2504oxIIX0o) {
                                                            if (!this.f28434XxX0x0xxx.X0o0xo()) {
                                                                if (xxxxox0i != null) {
                                                                    this.f28428OxxIIOOXO.II0xO0(xxxxox0i.xo0x());
                                                                }
                                                                X0xOO.xXxxox0I xxxxox0i7 = new X0xOO.xXxxox0I(Oxx0IOOO2);
                                                                if (z4) {
                                                                    xxxxox0i7.I0X0x0oIo();
                                                                    xxxxox0i3 = xxxxox0i7;
                                                                    ooxixxix3 = ooxixxix;
                                                                    ooooo0oxi2 = ooooo0oxi;
                                                                    xI0IXoo2 = xI0IXoo;
                                                                    iI0xO05 = iI0xO02;
                                                                    z2 = z;
                                                                    z4 = false;
                                                                } else {
                                                                    xxxxox0i3 = xxxxox0i7;
                                                                }
                                                            }
                                                        } else if (X0o0xo2 == OoIXo.xII.f2508x0) {
                                                            this.f28435o00 = new xxIXOIIO(Oxx0IOOO2);
                                                        } else if (X0o0xo2 == OoIXo.xII.f2527xoO0xx0) {
                                                            this.f28448xxX.OI0(new xoIox(Oxx0IOOO2).xo0x());
                                                        } else if (X0o0xo2 == OoIXo.xII.f2490oOXoIIIo) {
                                                            this.f28448xxX.ooOx(new Ioxxx(Oxx0IOOO2).xo0x());
                                                        } else if (X0o0xo2 == OoIXo.xII.f2526xoIxX) {
                                                            IIX0o iIX0o2 = new IIX0o(Oxx0IOOO2);
                                                            if (iIX0o2.xXOx() > 0) {
                                                                i = 1;
                                                                i2 = iIX0o2.xXOx() - 1;
                                                            } else {
                                                                i = 1;
                                                                i2 = 0;
                                                            }
                                                            this.f28431XI0IXoo = i2;
                                                            if (iIX0o2.xo0x() > 0) {
                                                                i3 = iIX0o2.xXOx() - i;
                                                            } else {
                                                                i3 = 0;
                                                            }
                                                            this.f28432XIxXXX0x0 = i3;
                                                        } else if (X0o0xo2 == OoIXo.xII.f2506oxoX) {
                                                            oIX0oI oix0oi = new oIX0oI(Oxx0IOOO2);
                                                            XxIIOXIXx.oIX0oI.oIX0oI(!oix0oi.XoI0Ixx0());
                                                            int oxoX2 = (this.f28437oIX0oI.oxoX() - Oxx0IOOO2.oxoX()) - 4;
                                                            xoxXI Oxx0IOOO3 = this.f28437oIX0oI.Oxx0IOOO();
                                                            while (Oxx0IOOO3.II0xO0() != OoIXo.xII.f2459X0o0xo.f2535oIX0oI) {
                                                                Oxx0IOOO3 = this.f28437oIX0oI.Oxx0IOOO();
                                                            }
                                                            if (oix0oi.I0X0x0oIo()) {
                                                                if (!this.f28444xXxxox0I.II0XooXoX().XX0()) {
                                                                    f28415ooXIXxIX.ooOOo0oXI("only biff8 charts are supported");
                                                                } else {
                                                                    if (this.f28428OxxIIOOXO == null) {
                                                                        this.f28428OxxIIOOXO = new X0xOO.OxxIIOOXO();
                                                                    }
                                                                    if (!this.f28434XxX0x0xxx.X0o0xo()) {
                                                                        X0xOO.X0o0xo x0o0xo = new X0xOO.X0o0xo(xxxxox0i, ooxixxix, this.f28428OxxIIOOXO, oxoX2, this.f28437oIX0oI.oxoX(), this.f28437oIX0oI, this.f28434XxX0x0xxx);
                                                                        this.f28427Oxx0xo.add(x0o0xo);
                                                                        if (this.f28444xXxxox0I.X00IoxXI() != null) {
                                                                            this.f28444xXxxox0I.X00IoxXI().oIX0oI(x0o0xo);
                                                                        }
                                                                    }
                                                                }
                                                                xxxxox0i3 = null;
                                                                ooxixxix3 = null;
                                                            } else {
                                                                xxxxox0i3 = xxxxox0i;
                                                                ooxixxix3 = ooxixxix;
                                                            }
                                                            if (this.f28416I0Io.I0X0x0oIo()) {
                                                                z = false;
                                                            }
                                                            ooooo0oxi2 = ooooo0oxi;
                                                            xI0IXoo2 = xI0IXoo;
                                                            iI0xO05 = iI0xO02;
                                                            z2 = z;
                                                        } else if (X0o0xo2 == OoIXo.xII.f2459X0o0xo) {
                                                            xxxxox0i3 = xxxxox0i;
                                                            ooxixxix3 = ooxixxix;
                                                            ooooo0oxi2 = ooooo0oxi;
                                                            xI0IXoo2 = xI0IXoo;
                                                            iI0xO05 = iI0xO02;
                                                            z2 = false;
                                                        }
                                                        ooxixxix3 = ooxixxix;
                                                        ooooo0oxi2 = ooooo0oxi;
                                                        xI0IXoo2 = xI0IXoo;
                                                        iI0xO05 = iI0xO02;
                                                        z2 = z;
                                                    }
                                                    hashMap = hashMap2;
                                                }
                                                z2 = z;
                                                hashMap = hashMap2;
                                                arrayList = arrayList2;
                                            }
                                            iI0xO05 = iI0xO02;
                                            z2 = z;
                                            hashMap = hashMap2;
                                            arrayList = arrayList2;
                                        }
                                    }
                                    hashMap3 = hashMap;
                                    arrayList3 = arrayList;
                                    iI0xO06 = iI0xO0;
                                    i5 = 0;
                                    c = 1;
                                }
                            }
                        }
                        hashMap = hashMap2;
                        arrayList = arrayList2;
                    }
                    iI0xO0 = iI0xO06;
                    hashMap = hashMap3;
                    arrayList = arrayList3;
                    hashMap3 = hashMap;
                    arrayList3 = arrayList;
                    iI0xO06 = iI0xO0;
                    i5 = 0;
                    c = 1;
                }
                xxxxox0i3 = xxxxox0i;
                ooxixxix3 = ooxixxix;
                ooooo0oxi2 = ooooo0oxi;
                xI0IXoo2 = xI0IXoo;
                iI0xO05 = iI0xO02;
                z2 = z;
                hashMap3 = hashMap;
                arrayList3 = arrayList;
                iI0xO06 = iI0xO0;
                i5 = 0;
                c = 1;
            }
            xI0IXoo = xI0IXoo2;
            iI0xO0 = iI0xO06;
            ooooo0oxi = ooooo0oxi2;
            hashMap = hashMap3;
            arrayList = arrayList3;
            z = z2;
            xxxxox0i = xxxxox0i3;
            ooxixxix = ooxixxix3;
            iI0xO02 = iI0xO05;
            xxxxox0i3 = xxxxox0i;
            ooxixxix3 = ooxixxix;
            ooooo0oxi2 = ooooo0oxi;
            xI0IXoo2 = xI0IXoo;
            iI0xO05 = iI0xO02;
            z2 = z;
            hashMap3 = hashMap;
            arrayList3 = arrayList;
            iI0xO06 = iI0xO0;
            i5 = 0;
            c = 1;
        }
        II0xO0 iI0xO07 = iI0xO06;
        HashMap hashMap4 = hashMap3;
        X0xOO.xXxxox0I xxxxox0i8 = xxxxox0i3;
        X0xOO.ooXIXxIX ooxixxix5 = ooxixxix3;
        this.f28437oIX0oI.xoIox();
        if (this.f28447xxIXOIIO.size() > 0) {
            X0IIOO();
        }
        Iterator it = this.f28440ooOOo0oXI.iterator();
        while (it.hasNext()) {
            for (xIoXXXIXo.I0Io i0Io2 : ((XI0oooXX) it.next()).II0xO0(this.f28430X0o0xo, this.f28420IIXOooo)) {
                oIX0oI(i0Io2);
            }
        }
        if (!z3 && iI0xO07 != null) {
            oIX0oI(XIxXXX0x0(iI0xO07));
        }
        if (xxxxox0i8 != null && this.f28444xXxxox0I.X00IoxXI() != null) {
            this.f28444xXxxox0I.X00IoxXI().ooOOo0oXI(xxxxox0i8, ooxixxix5);
        }
        if (!hashMap4.isEmpty()) {
            f28415ooXIXxIX.ooOOo0oXI("Not all comments have a corresponding Note record");
        }
    }

    public final xIoXXXIXo.I0Io XIxXXX0x0(II0xO0 iI0xO0) {
        int oxoX2 = this.f28437oIX0oI.oxoX();
        this.f28437oIX0oI.OOXIXo(iI0xO0.I0X0x0oIo());
        xoxXI oxXx0IX2 = iI0xO0.oxXx0IX();
        XIxXXX0x0 xIxXXX0x0 = this.f28437oIX0oI;
        OoIXo.xXxxox0I xxxxox0i = this.f28430X0o0xo;
        IIX0 iix0 = this.f28444xXxxox0I;
        xXxxox0I xxxxox0i2 = new xXxxox0I(oxXx0IX2, xIxXXX0x0, xxxxox0i, iix0, iix0, xXxxox0I.f28510oO, this.f28419IIX0o, this.f28434XxX0x0xxx);
        try {
            xIoXXXIXo.I0Io XX02 = xxxxox0i2.XX0();
            if (xxxxox0i2.XX0().getType() == xIoXXXIXo.Oxx0IOOO.f34236Oxx0IOOO) {
                I0oOoX i0oOoX = (I0oOoX) xxxxox0i2.XX0();
                if (this.f28430X0o0xo.OOXIXo(xxxxox0i2.xXOx())) {
                    OoIXo.xXxxox0I xxxxox0i3 = this.f28430X0o0xo;
                    IIX0 iix02 = this.f28444xXxxox0I;
                    XX02 = new Oxx0xo(i0oOoX, xxxxox0i3, iix02, iix02, this.f28420IIXOooo, this.f28419IIX0o);
                }
            }
            this.f28437oIX0oI.OOXIXo(oxoX2);
            return XX02;
        } catch (FormulaException e) {
            f28415ooXIXxIX.ooOOo0oXI(xIoXXXIXo.XO.oIX0oI(xxxxox0i2.oIX0oI(), xxxxox0i2.II0xO0()) + " " + e.getMessage());
            return null;
        }
    }

    public final xxIXOIIO XO() {
        return this.f28435o00;
    }

    public final xIoXXXIXo.xoXoI o00() {
        return this.f28448xxX;
    }

    public final int oI0IIXIo() {
        return this.f28433XO;
    }

    public final void oIX0oI(xIoXXXIXo.I0Io i0Io) {
        if (i0Io.II0xO0() < this.f28433XO && i0Io.oIX0oI() < this.f28426Oxx0IOOO) {
            if (this.f28417II0XooXoX[i0Io.II0xO0()][i0Io.oIX0oI()] != null) {
                StringBuffer stringBuffer = new StringBuffer();
                xIoXXXIXo.XO.Oxx0IOOO(i0Io.oIX0oI(), i0Io.II0xO0(), stringBuffer);
                f28415ooXIXxIX.ooOOo0oXI("Cell " + stringBuffer.toString() + " already contains data");
            }
            this.f28417II0XooXoX[i0Io.II0xO0()][i0Io.oIX0oI()] = i0Io;
            return;
        }
        this.f28447xxIXOIIO.add(i0Io);
    }

    public final ArrayList oO() {
        return this.f28442x0XOIxOo;
    }

    public final OoIXo.OxxIIOOXO oOoXoXO() {
        return this.f28421IXxxXO;
    }

    public X0xOO.OxxIIOOXO ooOOo0oXI() {
        return this.f28428OxxIIOOXO;
    }

    public final boolean oxoX(II0xO0 iI0xO0) {
        int size = this.f28440ooOOo0oXI.size();
        boolean z = false;
        for (int i = 0; i < size && !z; i++) {
            z = ((XI0oooXX) this.f28440ooOOo0oXI.get(i)).oIX0oI(iI0xO0);
        }
        return z;
    }

    public final ArrayList x0XOIxOo() {
        return this.f28436oI0IIXIo;
    }

    public int x0xO0oo() {
        return this.f28432XIxXXX0x0;
    }

    public final ArrayList xoIox() {
        return this.f28439oOoXoXO;
    }

    public final ArrayList xoXoI() {
        return this.f28423OOXIXo;
    }

    public final int[] xxIXOIIO() {
        return this.f28429X0IIOO;
    }
}
