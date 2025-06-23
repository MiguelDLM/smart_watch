package jxl.write.biff;

import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class XOxIOxOx extends OoIXo.OI0 {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final II0xO0 f28708IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28709IXxxXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(XOxIOxOx.class);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final II0xO0 f28710Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final II0xO0 f28711OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final II0xO0 f28712oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final II0xO0 f28713xoXoI;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28714II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f28715OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f28716Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28717Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28718X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28719XO;

    /* renamed from: oO, reason: collision with root package name */
    public xIoXXXIXo.OxxIIOOXO f28720oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f28721oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public II0xO0 f28722ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public byte[] f28723x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public oIXoXx0.O0xOxO f28724x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public File f28725xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public URL f28726xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    static {
        f28710Oxx0xo = new II0xO0();
        f28712oI0IIXIo = new II0xO0();
        f28711OxxIIOOXO = new II0xO0();
        f28708IIXOooo = new II0xO0();
        f28713xoXoI = new II0xO0();
    }

    public XOxIOxOx(xIoXXXIXo.oO oOVar, oIXoXx0.O0xOxO o0xOxO) {
        super(OoIXo.xII.f2516xI0oxI00);
        if (oOVar instanceof jxl.read.biff.IoOoX) {
            XX0(oOVar, o0xOxO);
        } else {
            I0X0x0oIo(oOVar, o0xOxO);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I0X0x0oIo(xIoXXXIXo.oO oOVar, oIXoXx0.O0xOxO o0xOxO) {
        XOxIOxOx xOxIOxOx = (XOxIOxOx) oOVar;
        this.f28718X0o0xo = xOxIOxOx.f28718X0o0xo;
        this.f28719XO = xOxIOxOx.f28719XO;
        this.f28717Oxx0IOOO = xOxIOxOx.f28717Oxx0IOOO;
        this.f28714II0XooXoX = xOxIOxOx.f28714II0XooXoX;
        if (xOxIOxOx.f28726xxIXOIIO != null) {
            try {
                this.f28726xxIXOIIO = new URL(xOxIOxOx.f28726xxIXOIIO.toString());
            } catch (MalformedURLException unused) {
                XxIIOXIXx.oIX0oI.oIX0oI(false);
            }
        }
        if (xOxIOxOx.f28725xoIox != null) {
            this.f28725xoIox = new File(xOxIOxOx.f28725xoIox.getPath());
        }
        this.f28715OOXIXo = xOxIOxOx.f28715OOXIXo;
        this.f28721oOoXoXO = xOxIOxOx.f28721oOoXoXO;
        this.f28722ooOOo0oXI = xOxIOxOx.f28722ooOOo0oXI;
        this.f28716Oo = true;
        this.f28724x0xO0oo = o0xOxO;
        this.f28720oO = new OoIXo.X00IoxXI(o0xOxO, this.f28717Oxx0IOOO, this.f28718X0o0xo, this.f28714II0XooXoX, this.f28719XO);
    }

    public final byte[] I0oOIX(byte[] bArr) {
        String url = this.f28726xxIXOIIO.toString();
        int length = bArr.length + 20 + ((url.length() + 1) * 2);
        String str = this.f28721oOoXoXO;
        if (str != null) {
            length += ((str.length() + 1) * 2) + 4;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length2 = bArr.length;
        String str2 = this.f28721oOoXoXO;
        if (str2 != null) {
            OoIXo.oo0xXOI0I.oIX0oI(str2.length() + 1, bArr2, length2);
            OoIXo.IO.X0o0xo(this.f28721oOoXoXO, bArr2, length2 + 4);
            length2 += ((this.f28721oOoXoXO.length() + 1) * 2) + 4;
        }
        bArr2[length2] = -32;
        bArr2[length2 + 1] = -55;
        bArr2[length2 + 2] = -22;
        bArr2[length2 + 3] = 121;
        bArr2[length2 + 4] = -7;
        bArr2[length2 + 5] = -70;
        bArr2[length2 + 6] = -50;
        bArr2[length2 + 7] = 17;
        bArr2[length2 + 8] = -116;
        bArr2[length2 + 9] = -126;
        bArr2[length2 + 10] = 0;
        bArr2[length2 + 11] = TransportLayerPacket.SYNC_WORD;
        bArr2[length2 + 12] = 0;
        bArr2[length2 + 13] = 75;
        bArr2[length2 + 14] = -87;
        bArr2[length2 + 15] = 11;
        OoIXo.oo0xXOI0I.oIX0oI((url.length() + 1) * 2, bArr2, length2 + 16);
        OoIXo.IO.X0o0xo(url, bArr2, length2 + 20);
        return bArr2;
    }

    public xIoXXXIXo.OxxIIOOXO II0XooXoX() {
        return this.f28720oO;
    }

    public int II0xO0() {
        return this.f28718X0o0xo;
    }

    public String IIX0o() {
        return this.f28721oOoXoXO;
    }

    public URL IIXOooo() {
        return this.f28726xxIXOIIO;
    }

    public void IoOoo(int i) {
        boolean z;
        if (this.f28724x0xO0oo != null && this.f28720oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        int i2 = this.f28719XO;
        if (i > i2) {
            return;
        }
        int i3 = this.f28718X0o0xo;
        if (i <= i3) {
            this.f28718X0o0xo = i3 + 1;
            this.f28716Oo = true;
        }
        if (i <= i2) {
            this.f28719XO = i2 + 1;
            this.f28716Oo = true;
        }
        if (this.f28716Oo) {
            this.f28720oO = new OoIXo.X00IoxXI(this.f28724x0xO0oo, this.f28717Oxx0IOOO, this.f28718X0o0xo, this.f28714II0XooXoX, this.f28719XO);
        }
    }

    public void Ioxxx(File file) {
        this.f28722ooOOo0oXI = f28712oI0IIXIo;
        this.f28726xxIXOIIO = null;
        this.f28715OOXIXo = null;
        this.f28721oOoXoXO = null;
        this.f28725xoIox = file;
        boolean z = true;
        this.f28716Oo = true;
        oIXoXx0.O0xOxO o0xOxO = this.f28724x0xO0oo;
        if (o0xOxO == null) {
            return;
        }
        oIXoXx0.oI0IIXIo xoIox2 = o0xOxO.xoIox(this.f28717Oxx0IOOO, this.f28718X0o0xo);
        if (xoIox2.getType() != xIoXXXIXo.Oxx0IOOO.f34232I0Io) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        ((oIXoXx0.ooOOo0oXI) xoIox2).O00XxXI(file.toString());
    }

    public final byte[] O0Xx(byte[] bArr) {
        String path = this.f28725xoIox.getPath();
        byte[] bArr2 = new byte[bArr.length + (path.length() * 2) + 6];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length = bArr.length;
        OoIXo.oo0xXOI0I.oIX0oI(path.length() + 1, bArr2, length);
        OoIXo.IO.X0o0xo(path, bArr2, length + 4);
        return bArr2;
    }

    public void OO(int i) {
        boolean z;
        if (this.f28724x0xO0oo != null && this.f28720oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        int i2 = this.f28714II0XooXoX;
        if (i > i2) {
            return;
        }
        int i3 = this.f28717Oxx0IOOO;
        if (i <= i3) {
            this.f28717Oxx0IOOO = i3 + 1;
            this.f28716Oo = true;
        }
        if (i <= i2) {
            this.f28714II0XooXoX = i2 + 1;
            this.f28716Oo = true;
        }
        if (this.f28716Oo) {
            this.f28720oO = new OoIXo.X00IoxXI(this.f28724x0xO0oo, this.f28717Oxx0IOOO, this.f28718X0o0xo, this.f28714II0XooXoX, this.f28719XO);
        }
    }

    public void OO0x0xX(int i) {
        boolean z;
        boolean z2 = false;
        if (this.f28724x0xO0oo != null && this.f28720oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        int i2 = this.f28719XO;
        if (i > i2) {
            return;
        }
        int i3 = this.f28718X0o0xo;
        if (i < i3) {
            this.f28718X0o0xo = i3 - 1;
            this.f28716Oo = true;
        }
        if (i < i2) {
            this.f28719XO = i2 - 1;
            this.f28716Oo = true;
        }
        if (this.f28716Oo) {
            if (this.f28720oO != null) {
                z2 = true;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z2);
            this.f28720oO = new OoIXo.X00IoxXI(this.f28724x0xO0oo, this.f28717Oxx0IOOO, this.f28718X0o0xo, this.f28714II0XooXoX, this.f28719XO);
        }
    }

    public File Oo() {
        return this.f28725xoIox;
    }

    public int Oxx0xo() {
        return this.f28719XO;
    }

    public void XIo0oOXIx(String str) {
        this.f28721oOoXoXO = str;
        this.f28716Oo = true;
    }

    public final void XX0(xIoXXXIXo.oO oOVar, oIXoXx0.O0xOxO o0xOxO) {
        jxl.read.biff.IoOoX ioOoX = (jxl.read.biff.IoOoX) oOVar;
        this.f28723x0XOIxOo = ioOoX.oxXx0IX().I0Io();
        this.f28724x0xO0oo = o0xOxO;
        this.f28718X0o0xo = ioOoX.II0xO0();
        this.f28717Oxx0IOOO = ioOoX.oIX0oI();
        this.f28719XO = ioOoX.Oxx0xo();
        int Xx000oIo2 = ioOoX.Xx000oIo();
        this.f28714II0XooXoX = Xx000oIo2;
        this.f28720oO = new OoIXo.X00IoxXI(o0xOxO, this.f28717Oxx0IOOO, this.f28718X0o0xo, Xx000oIo2, this.f28719XO);
        this.f28722ooOOo0oXI = f28713xoXoI;
        if (ioOoX.ooOOo0oXI()) {
            this.f28722ooOOo0oXI = f28712oI0IIXIo;
            this.f28725xoIox = ioOoX.Oo();
        } else if (ioOoX.x0XOIxOo()) {
            this.f28722ooOOo0oXI = f28710Oxx0xo;
            this.f28726xxIXOIIO = ioOoX.IIXOooo();
        } else if (ioOoX.ooXIXxIX()) {
            this.f28722ooOOo0oXI = f28708IIXOooo;
            this.f28715OOXIXo = ioOoX.xo0x();
        }
        this.f28716Oo = false;
    }

    public final void XX0xXo(oIXoXx0.O0xOxO o0xOxO, int i, int i2, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        if (o0xOxO.getName().indexOf(39) == -1) {
            stringBuffer.append(o0xOxO.getName());
        } else {
            String name = o0xOxO.getName();
            int i5 = 0;
            int indexOf = name.indexOf(39, 0);
            while (indexOf != -1 && i5 < name.length()) {
                stringBuffer.append(name.substring(i5, indexOf));
                stringBuffer.append("''");
                i5 = indexOf + 1;
                indexOf = name.indexOf(39, i5);
            }
            stringBuffer.append(name.substring(i5));
        }
        stringBuffer.append('\'');
        stringBuffer.append(OoIXo.oOoXoXO.f2346I0Io);
        int max = Math.max(i, i3);
        int max2 = Math.max(i2, i4);
        OoIXo.oOoXoXO.oxoX(i, i2, stringBuffer);
        stringBuffer.append(':');
        OoIXo.oOoXoXO.oxoX(max, max2, stringBuffer);
        this.f28715OOXIXo = stringBuffer.toString();
    }

    public final byte[] Xo0(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 4 + ((this.f28715OOXIXo.length() + 1) * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length = bArr.length;
        OoIXo.oo0xXOI0I.oIX0oI(this.f28715OOXIXo.length() + 1, bArr2, length);
        OoIXo.IO.X0o0xo(this.f28715OOXIXo, bArr2, length + 4);
        return bArr2;
    }

    public final String XoI0Ixx0(String str) {
        String substring;
        int indexOf = str.indexOf(46);
        if (indexOf == -1) {
            substring = "";
        } else {
            String substring2 = str.substring(0, indexOf);
            substring = str.substring(indexOf + 1);
            str = substring2;
        }
        if (str.length() > 8) {
            str = (str.substring(0, 6) + "~" + (str.length() - 8)).substring(0, 8);
        }
        String substring3 = substring.substring(0, Math.min(3, substring.length()));
        if (substring3.length() > 0) {
            return str + '.' + substring3;
        }
        return str;
    }

    public int Xx000oIo() {
        return this.f28714II0XooXoX;
    }

    public void o0xxxXXxX(URL url) {
        String substring;
        URL url2 = this.f28726xxIXOIIO;
        this.f28722ooOOo0oXI = f28710Oxx0xo;
        this.f28725xoIox = null;
        this.f28715OOXIXo = null;
        this.f28721oOoXoXO = null;
        this.f28726xxIXOIIO = url;
        this.f28716Oo = true;
        oIXoXx0.O0xOxO o0xOxO = this.f28724x0xO0oo;
        if (o0xOxO == null) {
            return;
        }
        oIXoXx0.oI0IIXIo xoIox2 = o0xOxO.xoIox(this.f28717Oxx0IOOO, this.f28718X0o0xo);
        if (xoIox2.getType() == xIoXXXIXo.Oxx0IOOO.f34232I0Io) {
            oIXoXx0.ooOOo0oXI ooooo0oxi = (oIXoXx0.ooOOo0oXI) xoIox2;
            String url3 = url2.toString();
            if (url3.charAt(url3.length() - 1) != '/' && url3.charAt(url3.length() - 1) != '\\') {
                substring = "";
            } else {
                substring = url3.substring(0, url3.length() - 1);
            }
            if (ooooo0oxi.IoOoX().equals(url3) || ooooo0oxi.IoOoX().equals(substring)) {
                ooooo0oxi.O00XxXI(url.toString());
            }
        }
    }

    public int oIX0oI() {
        return this.f28717Oxx0IOOO;
    }

    public final byte[] oX(byte[] bArr) {
        char charAt;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(this.f28725xoIox.getName());
        arrayList2.add(XoI0Ixx0(this.f28725xoIox.getName()));
        for (File parentFile = this.f28725xoIox.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            arrayList.add(parentFile.getName());
            arrayList2.add(XoI0Ixx0(parentFile.getName()));
        }
        int size = arrayList.size() - 1;
        boolean z = true;
        int i = 0;
        while (z) {
            if (((String) arrayList.get(size)).equals("..")) {
                i++;
                arrayList.remove(size);
                arrayList2.remove(size);
            } else {
                z = false;
            }
            size--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.f28725xoIox.getPath().charAt(1) == ':' && (charAt = this.f28725xoIox.getPath().charAt(0)) != 'C' && charAt != 'c') {
            stringBuffer.append(charAt);
            stringBuffer.append(':');
            stringBuffer2.append(charAt);
            stringBuffer2.append(':');
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            stringBuffer.append((String) arrayList.get(size2));
            stringBuffer2.append((String) arrayList2.get(size2));
            if (size2 != 0) {
                stringBuffer.append("\\");
                stringBuffer2.append("\\");
            }
        }
        String stringBuffer3 = stringBuffer.toString();
        String stringBuffer4 = stringBuffer2.toString();
        int length = bArr.length + 4 + stringBuffer4.length() + 1 + 26 + ((stringBuffer3.length() + 1) * 2) + 24;
        String str = this.f28721oOoXoXO;
        if (str != null) {
            length += ((str.length() + 1) * 2) + 4;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length2 = bArr.length;
        String str2 = this.f28721oOoXoXO;
        if (str2 != null) {
            OoIXo.oo0xXOI0I.oIX0oI(str2.length() + 1, bArr2, length2);
            OoIXo.IO.X0o0xo(this.f28721oOoXoXO, bArr2, length2 + 4);
            length2 += ((this.f28721oOoXoXO.length() + 1) * 2) + 4;
        }
        bArr2[length2] = 3;
        bArr2[length2 + 1] = 3;
        bArr2[length2 + 2] = 0;
        bArr2[length2 + 3] = 0;
        bArr2[length2 + 4] = 0;
        bArr2[length2 + 5] = 0;
        bArr2[length2 + 6] = 0;
        bArr2[length2 + 7] = 0;
        bArr2[length2 + 8] = -64;
        bArr2[length2 + 9] = 0;
        bArr2[length2 + 10] = 0;
        bArr2[length2 + 11] = 0;
        bArr2[length2 + 12] = 0;
        bArr2[length2 + 13] = 0;
        bArr2[length2 + 14] = 0;
        bArr2[length2 + 15] = 70;
        OoIXo.oo0xXOI0I.XO(i, bArr2, length2 + 16);
        int i2 = length2 + 18;
        OoIXo.oo0xXOI0I.oIX0oI(stringBuffer4.length() + 1, bArr2, i2);
        OoIXo.IO.oIX0oI(stringBuffer4, bArr2, length2 + 22);
        int length3 = i2 + stringBuffer4.length() + 5;
        bArr2[length3] = -1;
        bArr2[length3 + 1] = -1;
        bArr2[length3 + 2] = -83;
        bArr2[length3 + 3] = -34;
        bArr2[length3 + 4] = 0;
        bArr2[length3 + 5] = 0;
        bArr2[length3 + 6] = 0;
        bArr2[length3 + 7] = 0;
        bArr2[length3 + 8] = 0;
        bArr2[length3 + 9] = 0;
        bArr2[length3 + 10] = 0;
        bArr2[length3 + 11] = 0;
        bArr2[length3 + 12] = 0;
        bArr2[length3 + 13] = 0;
        bArr2[length3 + 14] = 0;
        bArr2[length3 + 15] = 0;
        bArr2[length3 + 16] = 0;
        bArr2[length3 + 17] = 0;
        bArr2[length3 + 18] = 0;
        bArr2[length3 + 19] = 0;
        bArr2[length3 + 20] = 0;
        bArr2[length3 + 21] = 0;
        bArr2[length3 + 22] = 0;
        bArr2[length3 + 23] = 0;
        OoIXo.oo0xXOI0I.oIX0oI((stringBuffer3.length() * 2) + 6, bArr2, length3 + 24);
        OoIXo.oo0xXOI0I.oIX0oI(stringBuffer3.length() * 2, bArr2, length3 + 28);
        bArr2[length3 + 32] = 3;
        bArr2[length3 + 33] = 0;
        OoIXo.IO.X0o0xo(stringBuffer3, bArr2, length3 + 34);
        return bArr2;
    }

    public boolean ooOOo0oXI() {
        if (this.f28722ooOOo0oXI == f28712oI0IIXIo) {
            return true;
        }
        return false;
    }

    public boolean ooXIXxIX() {
        if (this.f28722ooOOo0oXI == f28708IIXOooo) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (ooOOo0oXI()) {
            return this.f28725xoIox.toString();
        }
        if (x0XOIxOo()) {
            return this.f28726xxIXOIIO.toString();
        }
        if (xoIxX()) {
            return this.f28725xoIox.toString();
        }
        return "";
    }

    public boolean x0XOIxOo() {
        if (this.f28722ooOOo0oXI == f28710Oxx0xo) {
            return true;
        }
        return false;
    }

    public void x0xO(int i) {
        boolean z;
        boolean z2 = false;
        if (this.f28724x0xO0oo != null && this.f28720oO != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        int i2 = this.f28714II0XooXoX;
        if (i > i2) {
            return;
        }
        int i3 = this.f28717Oxx0IOOO;
        if (i < i3) {
            this.f28717Oxx0IOOO = i3 - 1;
            this.f28716Oo = true;
        }
        if (i < i2) {
            this.f28714II0XooXoX = i2 - 1;
            this.f28716Oo = true;
        }
        if (this.f28716Oo) {
            if (this.f28720oO != null) {
                z2 = true;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z2);
            this.f28720oO = new OoIXo.X00IoxXI(this.f28724x0xO0oo, this.f28717Oxx0IOOO, this.f28718X0o0xo, this.f28714II0XooXoX, this.f28719XO);
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        if (!this.f28716Oo) {
            return this.f28723x0XOIxOo;
        }
        int i = 0;
        OoIXo.oo0xXOI0I.XO(this.f28718X0o0xo, r0, 0);
        OoIXo.oo0xXOI0I.XO(this.f28719XO, r0, 2);
        OoIXo.oo0xXOI0I.XO(this.f28717Oxx0IOOO, r0, 4);
        OoIXo.oo0xXOI0I.XO(this.f28714II0XooXoX, r0, 6);
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, -48, -55, -22, 121, -7, -70, -50, 17, -116, -126, 0, TransportLayerPacket.SYNC_WORD, 0, 75, -87, 11, 2, 0, 0, 0};
        if (x0XOIxOo()) {
            if (this.f28721oOoXoXO != null) {
                i = 23;
            } else {
                i = 3;
            }
        } else if (ooOOo0oXI()) {
            if (this.f28721oOoXoXO != null) {
                i = 21;
            } else {
                i = 1;
            }
        } else if (ooXIXxIX()) {
            i = 8;
        } else if (xoIxX()) {
            i = 259;
        }
        OoIXo.oo0xXOI0I.oIX0oI(i, bArr, 28);
        if (x0XOIxOo()) {
            this.f28723x0XOIxOo = I0oOIX(bArr);
        } else if (ooOOo0oXI()) {
            this.f28723x0XOIxOo = oX(bArr);
        } else if (ooXIXxIX()) {
            this.f28723x0XOIxOo = Xo0(bArr);
        } else if (xoIxX()) {
            this.f28723x0XOIxOo = O0Xx(bArr);
        }
        return this.f28723x0XOIxOo;
    }

    public boolean xoIxX() {
        if (this.f28722ooOOo0oXI == f28711OxxIIOOXO) {
            return true;
        }
        return false;
    }

    public void xoxXI(oIXoXx0.O0xOxO o0xOxO) {
        this.f28724x0xO0oo = o0xOxO;
        this.f28720oO = new OoIXo.X00IoxXI(o0xOxO, this.f28717Oxx0IOOO, this.f28718X0o0xo, this.f28714II0XooXoX, this.f28719XO);
    }

    public void xxIO(String str, oIXoXx0.O0xOxO o0xOxO, int i, int i2, int i3, int i4) {
        this.f28722ooOOo0oXI = f28708IIXOooo;
        this.f28726xxIXOIIO = null;
        this.f28725xoIox = null;
        boolean z = true;
        this.f28716Oo = true;
        this.f28721oOoXoXO = str;
        XX0xXo(o0xOxO, i, i2, i3, i4);
        if (o0xOxO == null) {
            return;
        }
        oIXoXx0.oI0IIXIo xoIox2 = o0xOxO.xoIox(this.f28717Oxx0IOOO, this.f28718X0o0xo);
        if (xoIox2.getType() != xIoXXXIXo.Oxx0IOOO.f34232I0Io) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        ((oIXoXx0.ooOOo0oXI) xoIox2).O00XxXI(str);
    }

    public XOxIOxOx(int i, int i2, int i3, int i4, URL url, String str) {
        super(OoIXo.xII.f2516xI0oxI00);
        this.f28717Oxx0IOOO = i;
        this.f28718X0o0xo = i2;
        this.f28714II0XooXoX = Math.max(i, i3);
        this.f28719XO = Math.max(this.f28718X0o0xo, i4);
        this.f28726xxIXOIIO = url;
        this.f28721oOoXoXO = str;
        this.f28722ooOOo0oXI = f28710Oxx0xo;
        this.f28716Oo = true;
    }

    public XOxIOxOx(int i, int i2, int i3, int i4, File file, String str) {
        super(OoIXo.xII.f2516xI0oxI00);
        this.f28717Oxx0IOOO = i;
        this.f28718X0o0xo = i2;
        this.f28714II0XooXoX = Math.max(i, i3);
        this.f28719XO = Math.max(this.f28718X0o0xo, i4);
        this.f28721oOoXoXO = str;
        this.f28725xoIox = file;
        if (file.getPath().startsWith("\\\\")) {
            this.f28722ooOOo0oXI = f28711OxxIIOOXO;
        } else {
            this.f28722ooOOo0oXI = f28712oI0IIXIo;
        }
        this.f28716Oo = true;
    }

    public XOxIOxOx(int i, int i2, int i3, int i4, String str, oIXoXx0.O0xOxO o0xOxO, int i5, int i6, int i7, int i8) {
        super(OoIXo.xII.f2516xI0oxI00);
        this.f28717Oxx0IOOO = i;
        this.f28718X0o0xo = i2;
        this.f28714II0XooXoX = Math.max(i, i3);
        this.f28719XO = Math.max(this.f28718X0o0xo, i4);
        XX0xXo(o0xOxO, i5, i6, i7, i8);
        this.f28721oOoXoXO = str;
        this.f28722ooOOo0oXI = f28708IIXOooo;
        this.f28716Oo = true;
    }
}
