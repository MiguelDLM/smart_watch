package O0Xx;

import com.garmin.fit.Fit;
import com.garmin.fit.I0;
import com.garmin.fit.I0xX0;
import com.garmin.fit.IIxOXoOo0;
import com.garmin.fit.IXIxx0;
import com.garmin.fit.IXXIXx00I;
import com.garmin.fit.O0xO0;
import com.garmin.fit.Oxx;
import com.garmin.fit.X0xII0I;
import com.garmin.fit.XI0oooXX;
import com.garmin.fit.XXXI;
import com.garmin.fit.oIXoXx0;
import com.garmin.fit.x0OxxIOxX;
import com.garmin.fit.xooxxX;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public class XO {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final Pattern f1433OOXIXo = Pattern.compile("\"([^\"]+?)\",?|([^,]+),?|,");

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Pattern f1434oOoXoXO = Pattern.compile("^([0-9]+)?\\.[0-9]+$");

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final Pattern f1435ooOOo0oXI = Pattern.compile("^(0[xX]){1}[a-fA-F0-9]{2}$");

    /* renamed from: I0Io, reason: collision with root package name */
    public int f1436I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f1437II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f1438II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f1439Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f1440X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f1441XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Fit.ProtocolVersion f1442oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f1443oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public HashMap<Short, XI0oooXX> f1444xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public LinkedList<Oxx> f1445xxIXOIIO;

    public XO() {
        this(Fit.ProtocolVersion.V1_0);
    }

    public static boolean I0Io(InputStream inputStream, IXIxx0 iXIxx0, O0xO0 o0xO0) {
        return oxoX(inputStream, iXIxx0, o0xO0, Fit.ProtocolVersion.V1_0);
    }

    public static boolean oxoX(InputStream inputStream, IXIxx0 iXIxx0, O0xO0 o0xO0, Fit.ProtocolVersion protocolVersion) {
        return new XO(protocolVersion).X0o0xo(inputStream, iXIxx0, o0xO0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [com.garmin.fit.IIxOXoOo0] */
    public final boolean II0XooXoX(ArrayList<String> arrayList, O0xO0 o0xO0) {
        I0xX0 xxxi;
        int i = this.f1439Oxx0IOOO;
        oIXoXx0 II0XooXoX2 = x0OxxIOxX.II0XooXoX(arrayList.get(this.f1441XO));
        if (II0XooXoX2.XXoOx0() == IXXIXx00I.f11732XXXI) {
            System.err.printf("CSVReader.read(): Error on line %d - Unknown message \"%s\".\n", Integer.valueOf(this.f1437II0XooXoX), II0XooXoX2.x0OIX00oO());
            return false;
        }
        int i2 = this.f1440X0o0xo;
        if (i2 >= 0) {
            II0XooXoX2.oIIxXoo(Integer.valueOf(arrayList.get(i2)).intValue());
        }
        xooxxX xooxxx = new xooxxX(II0XooXoX2);
        while (i + 2 <= arrayList.size()) {
            String str = arrayList.get(i);
            ArrayList<String> xxIXOIIO2 = xxIXOIIO(arrayList.get(i + 1));
            i += 3;
            if (str == null) {
                break;
            }
            if (str.equalsIgnoreCase("unknown")) {
                this.f1436I0Io++;
            } else {
                X0xII0I oxoX2 = x0OxxIOxX.oxoX(II0XooXoX2.x0OIX00oO(), str);
                if (xxIXOIIO2 != null) {
                    if (oxoX2.OooI() == 255) {
                        Iterator<Oxx> it = this.f1445xxIXOIIO.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Oxx next = it.next();
                                if (next.OooI(0).equals(str)) {
                                    if (this.f1442oIX0oI != Fit.ProtocolVersion.V1_0) {
                                        XI0oooXX xI0oooXX = this.f1444xoIox.get(next.XoIxOXIXo());
                                        ?? iIxOXoOo0 = new IIxOXoOo0(next, xI0oooXX);
                                        xxxi = new I0(next, xI0oooXX);
                                        oxoX2 = iIxOXoOo0;
                                    } else {
                                        throw new RuntimeException("FIT Protocol Error. A developer field was found while using Protocol Version 1.0. To use developer data, specify the -p2 command line option to enable FIT Protocol 2.0.");
                                    }
                                }
                            } else {
                                xxxi = null;
                                oxoX2 = null;
                                break;
                            }
                        }
                    } else {
                        xxxi = new XXXI(oxoX2);
                    }
                    if (oxoX2 == null) {
                        System.err.printf("CSVReader.read(): Error on line %d - Unknown field \"%s\" in message \"%s\".\n", Integer.valueOf(this.f1437II0XooXoX), str, II0XooXoX2.x0OIX00oO());
                        return false;
                    }
                    Iterator<String> it2 = xxIXOIIO2.iterator();
                    while (it2.hasNext()) {
                        xxxi.II0xO0(Integer.valueOf(it2.next()).intValue() * Fit.f11152IoXIXo[oxoX2.oxIIX0o() & 31]);
                    }
                    if (oxoX2 instanceof X0xII0I) {
                        xooxxx.II0xO0((XXXI) xxxi);
                    } else {
                        xooxxx.oIX0oI((I0) xxxi);
                    }
                } else {
                    continue;
                }
            }
        }
        if (o0xO0 != null) {
            o0xO0.oxoX(xooxxx);
        }
        return true;
    }

    public Boolean II0xO0(String str) {
        return Boolean.valueOf(f1435ooOOo0oXI.matcher(str).find());
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x014e, code lost:
    
        if (java.lang.Long.valueOf(r12).equals(com.garmin.fit.Fit.f11230x0xO) != false) goto L67;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:58:0x012c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:141:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Oxx0IOOO(java.util.ArrayList<java.lang.String> r19, com.garmin.fit.IXIxx0 r20) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O0Xx.XO.Oxx0IOOO(java.util.ArrayList, com.garmin.fit.IXIxx0):boolean");
    }

    public boolean X0o0xo(InputStream inputStream, IXIxx0 iXIxx0, O0xO0 o0xO0) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            ArrayList<String> XO2 = XO(xoIox(bufferedReader.readLine()));
            int i = 0;
            while (true) {
                if (i >= XO2.size()) {
                    break;
                }
                if (XO2.get(i).equals("Type")) {
                    this.f1443oxoX = i;
                } else if (XO2.get(i).equals("Local Number")) {
                    this.f1440X0o0xo = i;
                } else if (XO2.get(i).equals("Message")) {
                    this.f1441XO = i;
                } else if (XO2.get(i).equals("Field 1")) {
                    this.f1439Oxx0IOOO = i;
                    break;
                }
                i++;
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    ArrayList<String> XO3 = XO(readLine);
                    this.f1437II0XooXoX++;
                    if (XO3.size() > this.f1443oxoX && XO3.size() > this.f1440X0o0xo) {
                        int size = XO3.size();
                        int i2 = this.f1441XO;
                        if (size > i2) {
                            if (XO3.get(i2).equalsIgnoreCase("unknown")) {
                                this.f1438II0xO0++;
                            } else if (XO3.get(this.f1443oxoX).equalsIgnoreCase("Definition")) {
                                if (!II0XooXoX(XO3, o0xO0)) {
                                    return false;
                                }
                            } else if (XO3.get(this.f1443oxoX).equalsIgnoreCase("Data") && !Oxx0IOOO(XO3, iXIxx0)) {
                                return false;
                            }
                        }
                    }
                } else {
                    if (this.f1438II0xO0 > 0 || this.f1436I0Io > 0) {
                        System.out.printf("Ignored %d unknown field(s) and %d unknown message(s) during encoding.\n", Integer.valueOf(this.f1436I0Io), Integer.valueOf(this.f1438II0xO0));
                    }
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final ArrayList<String> XO(String str) {
        String group;
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null) {
            return null;
        }
        Matcher matcher = f1433OOXIXo.matcher(str);
        while (matcher.find() && (group = matcher.group()) != null) {
            if (group.endsWith(",")) {
                group = group.substring(0, group.length() - 1);
            }
            if (group.startsWith("\"")) {
                group = group.substring(1, group.length() - 1);
            }
            if (group.length() == 0) {
                group = null;
            }
            arrayList.add(group);
        }
        return arrayList;
    }

    public Boolean oIX0oI(String str) {
        return Boolean.valueOf(f1434oOoXoXO.matcher(str).find());
    }

    public final String xoIox(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) {
            int length = bytes.length - 3;
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 3, bArr, 0, length);
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return str;
    }

    public final ArrayList<String> xxIXOIIO(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null) {
            return null;
        }
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '|') {
                arrayList.add(str2);
                str2 = "";
            } else {
                str2 = str2 + str.charAt(i);
            }
        }
        if (str2.length() > 0) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    public XO(Fit.ProtocolVersion protocolVersion) {
        this.f1438II0xO0 = 0;
        this.f1436I0Io = 0;
        this.f1443oxoX = -1;
        this.f1440X0o0xo = -1;
        this.f1441XO = -1;
        this.f1439Oxx0IOOO = -1;
        this.f1437II0XooXoX = 1;
        this.f1445xxIXOIIO = new LinkedList<>();
        this.f1444xoIox = new HashMap<>();
        this.f1442oIX0oI = protocolVersion;
    }
}
