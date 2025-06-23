package OIIXOxo;

import OoIXo.xII;
import XXO0.oIX0oI;
import com.google.android.gms.maps.model.FeatureType;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import jxl.read.biff.BiffException;
import jxl.read.biff.XIxXXX0x0;
import jxl.read.biff.xoxXI;
import xIoXXXIXo.O0xOxO;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f1636Oxx0IOOO = 16;

    /* renamed from: I0Io, reason: collision with root package name */
    public HashMap f1637I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public jxl.read.biff.I0Io f1638II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f1639X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f1640XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public BufferedWriter f1641oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f1642oxoX;

    public oIX0oI(File file, OutputStream outputStream) throws IOException, BiffException {
        this.f1641oIX0oI = new BufferedWriter(new OutputStreamWriter(outputStream));
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f1638II0xO0 = new jxl.read.biff.I0Io(new XIxXXX0x0(fileInputStream, new O0xOxO()));
        oIX0oI();
        II0xO0();
        this.f1641oIX0oI.flush();
        this.f1641oIX0oI.close();
        fileInputStream.close();
    }

    public final void I0Io(byte b, StringBuffer stringBuffer) {
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() == 1) {
            stringBuffer.append('0');
        }
        stringBuffer.append(hexString);
    }

    public final void II0xO0() throws IOException {
        boolean z = true;
        while (this.f1638II0xO0.II0xO0() && z) {
            z = oxoX(this.f1638II0xO0.I0Io());
        }
    }

    public final void X0o0xo(int i, StringBuffer stringBuffer) {
        String hexString = Integer.toHexString(i);
        for (int i2 = 6; i2 > hexString.length(); i2--) {
            stringBuffer.append('0');
        }
        stringBuffer.append(hexString);
    }

    public final void oIX0oI() {
        HashMap hashMap = new HashMap(50);
        this.f1637I0Io = hashMap;
        hashMap.put(xII.f2506oxoX, "BOF");
        this.f1637I0Io.put(xII.f2459X0o0xo, "EOF");
        this.f1637I0Io.put(xII.f2412I0, "FONT");
        this.f1637I0Io.put(xII.f2487oI0IIXIo, "SST");
        this.f1637I0Io.put(xII.f2442O0xOxO, "LABELSST");
        this.f1637I0Io.put(xII.f2470XOxIOxOx, "WRITEACCESS");
        this.f1637I0Io.put(xII.f2523xXxxox0I, "FORMULA");
        this.f1637I0Io.put(xII.f2421IIX0o, "FORMULA");
        this.f1637I0Io.put(xII.f2499oo0xXOI0I, "XF");
        this.f1637I0Io.put(xII.f2450Oo, "MULRK");
        this.f1637I0Io.put(xII.f2458X0IIOO, "NUMBER");
        this.f1637I0Io.put(xII.f2469XO, "BOUNDSHEET");
        this.f1637I0Io.put(xII.f2528xoXoI, "CONTINUE");
        this.f1637I0Io.put(xII.f2515xI, "FORMAT");
        this.f1637I0Io.put(xII.f2418II0XooXoX, "EXTERNSHEET");
        this.f1637I0Io.put(xII.f2428IXxxXO, "INDEX");
        this.f1637I0Io.put(xII.f2532xxIXOIIO, "DIMENSION");
        this.f1637I0Io.put(xII.f2493oOoXoXO, "ROW");
        this.f1637I0Io.put(xII.f2455Oxx0xo, "DBCELL");
        this.f1637I0Io.put(xII.f2525xoIox, "BLANK");
        this.f1637I0Io.put(xII.f2447OOXIXo, "MULBLANK");
        this.f1637I0Io.put(xII.f2489oO, "RK");
        this.f1637I0Io.put(xII.f2514x0xO0oo, "RK");
        this.f1637I0Io.put(xII.f2456OxxIIOOXO, "COLINFO");
        this.f1637I0Io.put(xII.f2483o00, "LABEL");
        this.f1637I0Io.put(xII.f2502ooXIXxIX, "SHAREDFORMULA");
        this.f1637I0Io.put(xII.f2429Io, "CODEPAGE");
        this.f1637I0Io.put(xII.f2474XX0xXo, "WINDOW1");
        this.f1637I0Io.put(xII.f2485o0xxxXXxX, "WINDOW2");
        this.f1637I0Io.put(xII.f2491oOo, "MERGEDCELLS");
        this.f1637I0Io.put(xII.f2516xI0oxI00, "HLINK");
        this.f1637I0Io.put(xII.f2494oX, "HEADER");
        this.f1637I0Io.put(xII.f2477Xo0, "FOOTER");
        this.f1637I0Io.put(xII.f2431IoOoX, "INTERFACEHDR");
        this.f1637I0Io.put(xII.f2501ooOx, "MMS");
        this.f1637I0Io.put(xII.f2480Xx000oIo, "INTERFACEEND");
        this.f1637I0Io.put(xII.f2482o0, "DSF");
        this.f1637I0Io.put(xII.f2472XX, "FNGROUPCOUNT");
        this.f1637I0Io.put(xII.f2505oxXx0IX, FeatureType.COUNTRY);
        this.f1637I0Io.put(xII.f2468XIxXXX0x0, "TABID");
        this.f1637I0Io.put(xII.f2524xo0x, "PROTECT");
        this.f1637I0Io.put(xII.f2521xXOx, "SCENPROTECT");
        this.f1637I0Io.put(xII.f2473XX0, "OBJPROTECT");
        this.f1637I0Io.put(xII.f2513x0xO, "WINDOWPROTECT");
        this.f1637I0Io.put(xII.f2434Ioxxx, "PASSWORD");
        this.f1637I0Io.put(xII.f2446OO0x0xX, "PROT4REV");
        this.f1637I0Io.put(xII.f2467XIo0oOXIx, "PROT4REVPASS");
        this.f1637I0Io.put(xII.f2438O00XxXI, "BACKUP");
        this.f1637I0Io.put(xII.f2503ox, "HIDEOBJ");
        this.f1637I0Io.put(xII.f2464XI0oooXX, "1904");
        this.f1637I0Io.put(xII.f2448OOXIxO0, "PRECISION");
        this.f1637I0Io.put(xII.f2423IIxOXoOo0, "BOOKBOOL");
        this.f1637I0Io.put(xII.f2420IIX0, "STYLE");
        this.f1637I0Io.put(xII.f2422IIXOooo, "EXTSST");
        this.f1637I0Io.put(xII.f2531xxIO, "REFRESHALL");
        this.f1637I0Io.put(xII.f2527xoO0xx0, "CALCMODE");
        this.f1637I0Io.put(xII.f2449OX00O0xII, "CALCCOUNT");
        this.f1637I0Io.put(xII.f2463XI0IXoo, "NAME");
        this.f1637I0Io.put(xII.f2484o0oIxOo, "MSODRAWINGGROUP");
        this.f1637I0Io.put(xII.f2504oxIIX0o, "MSODRAWING");
        this.f1637I0Io.put(xII.f2430IoIOOxIIo, "OBJ");
        this.f1637I0Io.put(xII.f2519xOoOIoI, "USESELFS");
        this.f1637I0Io.put(xII.f2454Oxx0IOOO, "SUPBOOK");
        this.f1637I0Io.put(xII.f2466XIXIxO, "LEFTMARGIN");
        this.f1637I0Io.put(xII.f2451OoO, "RIGHTMARGIN");
        this.f1637I0Io.put(xII.f2444OIOoIIOIx, "TOPMARGIN");
        this.f1637I0Io.put(xII.f2509x0OIX00oO, "BOTTOMMARGIN");
        this.f1637I0Io.put(xII.f2478XoI0Ixx0, "HCENTER");
        this.f1637I0Io.put(xII.f2441O0Xx, "VCENTER");
        this.f1637I0Io.put(xII.f2440O0X, "ITERATION");
        this.f1637I0Io.put(xII.f2495oXIO0o0XI, "DELTA");
        this.f1637I0Io.put(xII.f2490oOXoIIIo, "SAVERECALC");
        this.f1637I0Io.put(xII.f2414I0X0x0oIo, "PRINTHEADERS");
        this.f1637I0Io.put(xII.f2445OO, "PRINTGRIDLINES");
        this.f1637I0Io.put(xII.f2529xoxXI, "SETUP");
        this.f1637I0Io.put(xII.f2530xx0X0, "SELECTION");
        this.f1637I0Io.put(xII.f2481XxX0x0xxx, "STRING");
        this.f1637I0Io.put(xII.f2461X0xxXX0, "FONTX");
        this.f1637I0Io.put(xII.f2425IO0XoXxO, "IFMT");
        this.f1637I0Io.put(xII.f2443OI0, "WSBOOL");
        this.f1637I0Io.put(xII.f2432IoOoo, "GRIDSET");
        this.f1637I0Io.put(xII.f2520xX0IIXIx0, "REFMODE");
        this.f1637I0Io.put(xII.f2526xoIxX, "GUTS");
        this.f1637I0Io.put(xII.f2476XXoOx0, "EXTERNNAME");
        this.f1637I0Io.put(xII.f2497oXxOI0oIx, "FBI");
        this.f1637I0Io.put(xII.f2424IO, "CRN");
        this.f1637I0Io.put(xII.f2437O0, "HORIZONTALPAGEBREAKS");
        this.f1637I0Io.put(xII.f2452Ox0O, "VERTICALPAGEBREAKS");
        this.f1637I0Io.put(xII.f2512x0o, "DEFAULTROWHEIGHT");
        this.f1637I0Io.put(xII.f2518xOOOX, "TEMPLATE");
        this.f1637I0Io.put(xII.f2486oI, "PANE");
        this.f1637I0Io.put(xII.f2427IXO, "SCL");
        this.f1637I0Io.put(xII.f2436IxIX0I, "PALETTE");
        this.f1637I0Io.put(xII.f2492oOoIIO0, "PLS");
        this.f1637I0Io.put(xII.f2465XIXIX, "OBJPROJ");
        this.f1637I0Io.put(xII.f2517xII, "DEFCOLWIDTH");
        this.f1637I0Io.put(xII.f2534xxX, "ARRAY");
        this.f1637I0Io.put(xII.f2435Ix00oIoI, "WEIRD1");
        this.f1637I0Io.put(xII.f2498oo, "BOOLERR");
        this.f1637I0Io.put(xII.f2439O0IxXx, "SORT");
        this.f1637I0Io.put(xII.f2508x0, "BUTTONPROPERTYSET");
        this.f1637I0Io.put(xII.f2500ooOOo0oXI, "NOTE");
        this.f1637I0Io.put(xII.f2511x0XOIxOo, "TXO");
        this.f1637I0Io.put(xII.f2522xXoOI00O, "DV");
        this.f1637I0Io.put(xII.f2510x0OxxIOxX, "DVAL");
        this.f1637I0Io.put(xII.f2462XI, "SERIES");
        this.f1637I0Io.put(xII.f2426IOoo, "SERIESLIST");
        this.f1637I0Io.put(xII.f2488oIIxXoo, "SBASEREF");
        this.f1637I0Io.put(xII.f2433IoXIXo, "CONDFMT");
        this.f1637I0Io.put(xII.f2533xxOXOOoIX, "CF");
        this.f1637I0Io.put(xII.f2416I0oOoX, "FILTERMODE");
        this.f1637I0Io.put(xII.f2479XoX, "AUTOFILTER");
        this.f1637I0Io.put(xII.f2507oxxXoxO, "AUTOFILTERINFO");
        this.f1637I0Io.put(xII.f2457X00IoxXI, "XCT");
        this.f1637I0Io.put(xII.f2496oXX0IoI, "???");
    }

    public final boolean oxoX(xoxXI xoxxi) throws IOException {
        boolean z;
        int oIX0oI2 = this.f1638II0xO0.oIX0oI();
        int II0xO02 = xoxxi.II0xO0();
        if (this.f1640XO == 0 && xoxxi.X0o0xo() != xII.f2506oxoX) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return z;
        }
        if (xoxxi.X0o0xo() == xII.f2506oxoX) {
            this.f1640XO++;
        }
        if (xoxxi.X0o0xo() == xII.f2459X0o0xo) {
            this.f1640XO--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        X0o0xo(oIX0oI2, stringBuffer);
        stringBuffer.append(" [");
        stringBuffer.append(this.f1637I0Io.get(xoxxi.X0o0xo()));
        stringBuffer.append("]");
        stringBuffer.append("  (0x");
        stringBuffer.append(Integer.toHexString(II0xO02));
        stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
        if (II0xO02 == xII.f2499oo0xXOI0I.f2535oIX0oI) {
            stringBuffer.append(" (0x");
            stringBuffer.append(Integer.toHexString(this.f1642oxoX));
            stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
            this.f1642oxoX++;
        }
        if (II0xO02 == xII.f2412I0.f2535oIX0oI) {
            int i = this.f1639X0o0xo;
            if (i == 4) {
                this.f1639X0o0xo = i + 1;
            }
            stringBuffer.append(" (0x");
            stringBuffer.append(Integer.toHexString(this.f1639X0o0xo));
            stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
            this.f1639X0o0xo++;
        }
        this.f1641oIX0oI.write(stringBuffer.toString());
        this.f1641oIX0oI.newLine();
        byte[] bArr = {(byte) (II0xO02 & 255), (byte) ((II0xO02 & 65280) >> 8), (byte) (xoxxi.oxoX() & 255), (byte) ((65280 & xoxxi.oxoX()) >> 8)};
        byte[] I0Io2 = xoxxi.I0Io();
        int length = I0Io2.length + 4;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        System.arraycopy(I0Io2, 0, bArr2, 4, I0Io2.length);
        int i2 = 0;
        while (i2 < length) {
            StringBuffer stringBuffer2 = new StringBuffer();
            X0o0xo(oIX0oI2 + i2, stringBuffer2);
            stringBuffer2.append("   ");
            int min = Math.min(16, length - i2);
            for (int i3 = 0; i3 < min; i3++) {
                I0Io(bArr2[i3 + i2], stringBuffer2);
                stringBuffer2.append(TokenParser.SP);
            }
            if (min < 16) {
                for (int i4 = 0; i4 < 16 - min; i4++) {
                    stringBuffer2.append("   ");
                }
            }
            stringBuffer2.append("  ");
            for (int i5 = 0; i5 < min; i5++) {
                char c = (char) bArr2[i5 + i2];
                if (c < ' ' || c > 'z') {
                    c = '.';
                }
                stringBuffer2.append(c);
            }
            i2 += min;
            this.f1641oIX0oI.write(stringBuffer2.toString());
            this.f1641oIX0oI.newLine();
        }
        return z;
    }
}
