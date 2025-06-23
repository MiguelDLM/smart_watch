package com.garmin.fit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class Decode implements xx0o0O {

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f11084IoOoX = 12;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f11085Xx000oIo = 512;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static boolean f11086oOXoIIIo = false;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f11087oo = 14;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f11088oo0xXOI0I = 1;

    /* renamed from: xI, reason: collision with root package name */
    public static final long f11089xI = Long.MAX_VALUE;

    /* renamed from: I0Io, reason: collision with root package name */
    public byte f11090I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public oIXoXx0 f11091II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public STATE f11092II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f11093IIX0o;

    /* renamed from: Oo, reason: collision with root package name */
    public int f11098Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f11100Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f11101Oxx0xo;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public String f11103X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f11104X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public long f11107XO;

    /* renamed from: o00, reason: collision with root package name */
    public InputStream f11109o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public long f11110oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f11111oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public int f11112oO;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public byte[] f11115ooXIXxIX;

    /* renamed from: oxoX, reason: collision with root package name */
    public byte f11116oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f11117x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f11118x0xO0oo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public int f11119xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f11121xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f11122xxIXOIIO;

    /* renamed from: xoIox, reason: collision with root package name */
    public xooxxX[] f11120xoIox = new xooxxX[16];

    /* renamed from: OOXIXo, reason: collision with root package name */
    public HashMap<Short, XI0oooXX> f11097OOXIXo = new HashMap<>();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public HashMap<Short, HashMap<Short, Oxx>> f11113oOoXoXO = new HashMap<>();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f11114ooOOo0oXI = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public byte[] f11095IXxxXO = new byte[255];

    /* renamed from: IIXOooo, reason: collision with root package name */
    public I0Io f11094IIXOooo = new I0Io();

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f11096O0xOxO = false;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f11105XI0IXoo = 0;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public ArrayList<IXIxx0> f11106XIxXXX0x0 = new ArrayList<>();

    /* renamed from: xxX, reason: collision with root package name */
    public ArrayList<O0xO0> f11123xxX = new ArrayList<>();

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public ArrayList<xoO0xx0> f11108XxX0x0xxx = new ArrayList<>();

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public long f11102OxxIIOOXO = 0;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f11099OxI = true;

    /* loaded from: classes9.dex */
    public class I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public ArrayList<II0xO0> f11125oIX0oI = new ArrayList<>();

        public I0Io() {
        }

        public void II0xO0(int i, int i2, long j) {
            II0xO0 iI0xO0 = null;
            int i3 = 0;
            while (i3 < this.f11125oIX0oI.size()) {
                iI0xO0 = this.f11125oIX0oI.get(i3);
                if (iI0xO0.f11129oIX0oI == i && iI0xO0.f11127II0xO0 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == this.f11125oIX0oI.size()) {
                iI0xO0 = new II0xO0(i, i2);
                this.f11125oIX0oI.add(iI0xO0);
            }
            iI0xO0.II0xO0(j);
        }

        public long oIX0oI(int i, int i2, long j, int i3) {
            II0xO0 iI0xO0 = null;
            int i4 = 0;
            while (i4 < this.f11125oIX0oI.size()) {
                iI0xO0 = this.f11125oIX0oI.get(i4);
                if (iI0xO0.f11129oIX0oI == i && iI0xO0.f11127II0xO0 == i2) {
                    break;
                }
                i4++;
            }
            if (i4 == this.f11125oIX0oI.size()) {
                iI0xO0 = new II0xO0(i, i2);
                this.f11125oIX0oI.add(iI0xO0);
            }
            return iI0xO0.oIX0oI(j, i3);
        }
    }

    /* loaded from: classes9.dex */
    public class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f11127II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f11129oIX0oI;

        /* renamed from: I0Io, reason: collision with root package name */
        public long f11126I0Io = 0;

        /* renamed from: oxoX, reason: collision with root package name */
        public long f11130oxoX = 0;

        public II0xO0(int i, int i2) {
            this.f11129oIX0oI = i;
            this.f11127II0xO0 = i2;
        }

        public long II0xO0(long j) {
            this.f11130oxoX = j;
            this.f11126I0Io = j;
            return j;
        }

        public long oIX0oI(long j, int i) {
            long j2 = this.f11130oxoX + (((1 << i) - 1) & (j - this.f11126I0Io));
            this.f11130oxoX = j2;
            this.f11126I0Io = j;
            return j2;
        }
    }

    /* loaded from: classes9.dex */
    public enum RETURN {
        CONTINUE,
        MESG,
        MESG_DEF,
        END_OF_FILE
    }

    /* loaded from: classes9.dex */
    public enum STATE {
        FILE_HDR,
        RECORD,
        RESERVED1,
        ARCH,
        MESG_NUM_0,
        MESG_NUM_1,
        NUM_FIELDS,
        FIELD_NUM,
        FIELD_SIZE,
        FIELD_TYPE,
        NUM_DEV_FIELDS,
        DEV_FIELD_NUM,
        DEV_FIELD_SIZE,
        DEV_FIELD_DEV_ID,
        FIELD_DATA,
        DEV_FIELD_DATA,
        FILE_CRC_HIGH
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f11131II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f11132oIX0oI;

        static {
            int[] iArr = new int[STATE.values().length];
            f11131II0xO0 = iArr;
            try {
                iArr[STATE.FILE_HDR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11131II0xO0[STATE.RECORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11131II0xO0[STATE.RESERVED1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11131II0xO0[STATE.ARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11131II0xO0[STATE.MESG_NUM_0.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11131II0xO0[STATE.MESG_NUM_1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11131II0xO0[STATE.NUM_FIELDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11131II0xO0[STATE.FIELD_NUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11131II0xO0[STATE.FIELD_SIZE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11131II0xO0[STATE.FIELD_TYPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11131II0xO0[STATE.NUM_DEV_FIELDS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11131II0xO0[STATE.DEV_FIELD_NUM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11131II0xO0[STATE.DEV_FIELD_SIZE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11131II0xO0[STATE.DEV_FIELD_DEV_ID.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11131II0xO0[STATE.FIELD_DATA.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11131II0xO0[STATE.DEV_FIELD_DATA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr2 = new int[RETURN.values().length];
            f11132oIX0oI = iArr2;
            try {
                iArr2[RETURN.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11132oIX0oI[RETURN.MESG.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f11132oIX0oI[RETURN.MESG_DEF.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f11132oIX0oI[RETURN.END_OF_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public Decode() {
        oOoXoXO();
        this.f11119xXxxox0I = 0;
        this.f11093IIX0o = 0;
        this.f11115ooXIXxIX = new byte[512];
        if (Fit.f11206oIX0oI) {
            System.out.printf("Fit.Decode: Starting decode...\n", new Object[0]);
        }
    }

    public void I0Io(xoO0xx0 xoo0xx0) {
        if (xoo0xx0 != null && !this.f11108XxX0x0xxx.contains(xoo0xx0)) {
            this.f11108XxX0x0xxx.add(xoo0xx0);
        }
    }

    public boolean II0XooXoX() {
        return this.f11096O0xOxO;
    }

    public final void II0xO0(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i / 2; i4++) {
                byte[] bArr = this.f11095IXxxXO;
                int i5 = i3 * i;
                int i6 = i5 + i4;
                byte b = bArr[i6];
                int i7 = ((i5 + i) - i4) - 1;
                bArr[i6] = bArr[i7];
                bArr[i7] = b;
            }
        }
    }

    public void IIXOooo() {
        if (this.f11109o00 == null) {
            this.f11092II0xO0 = STATE.RECORD;
            this.f11107XO = Long.MAX_VALUE;
            return;
        }
        throw new FitRuntimeException("Can't set skipHeader option after Decode started!");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0113, code lost:
    
        r10.f11093IIX0o = 0;
        r2 = r10.f11109o00;
        r3 = r10.f11115ooXIXxIX;
        r2 = r2.read(r3, 0, r3.length);
        r10.f11119xXxxox0I = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean IXxxXO() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garmin.fit.Decode.IXxxXO():boolean");
    }

    public boolean OOXIXo(InputStream inputStream) {
        while (true) {
            try {
                int i = this.f11093IIX0o;
                if (i < this.f11119xXxxox0I) {
                    int i2 = oIX0oI.f11132oIX0oI[x0XOIxOo(this.f11115ooXIXxIX[i]).ordinal()];
                    if (i2 != 1 && i2 != 2 && i2 != 3) {
                        if (i2 != 4) {
                            return false;
                        }
                        return true;
                    }
                    if (this.f11092II0xO0 != STATE.FILE_HDR) {
                        return true;
                    }
                    this.f11093IIX0o++;
                } else {
                    this.f11093IIX0o = 0;
                    byte[] bArr = this.f11115ooXIXxIX;
                    int read = inputStream.read(bArr, 0, bArr.length);
                    this.f11119xXxxox0I = read;
                    if (read < 0) {
                        break;
                    }
                }
            } catch (FitRuntimeException unused) {
                this.f11119xXxxox0I = 0;
                this.f11093IIX0o = 0;
            } catch (IOException e) {
                throw new FitRuntimeException(e);
            }
        }
        return false;
    }

    public boolean Oo(InputStream inputStream, IXIxx0 iXIxx0, O0xO0 o0xO0) {
        oIX0oI(iXIxx0);
        oxoX(o0xO0);
        this.f11105XI0IXoo = 0;
        boolean z = true;
        while (X0o0xo(inputStream) && z) {
            try {
                z = oO(inputStream);
                oOoXoXO();
            } catch (IOException e) {
                throw new FitRuntimeException(e);
            }
        }
        return z;
    }

    public void Oxx0IOOO(X0xII0I x0xII0I, ArrayList<oXX0IoI> arrayList) {
        Double valueOf;
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            oXX0IoI oxx0ioi = arrayList.get(i2);
            int i3 = oxx0ioi.f14807oIX0oI;
            if (i3 != 255) {
                X0xII0I oIX0oI2 = x0OxxIOxX.oIX0oI(this.f11091II0XooXoX.f14424II0xO0, i3);
                xxOoXO xI0oxI002 = oIX0oI2.xI0oxI00(this.f11091II0XooXoX.xoIox(oxx0ioi.f14807oIX0oI));
                oIX0oI2.xIXX(true);
                Long Oo2 = x0xII0I.Oo(i, oxx0ioi.f14804I0Io, oIX0oI2.IoXIXo());
                if (Oo2 != null) {
                    if (oxx0ioi.f14805II0xO0) {
                        Oo2 = Long.valueOf(this.f11094IIXOooo.oIX0oI(this.f11091II0XooXoX.f14424II0xO0, oxx0ioi.f14807oIX0oI, Oo2.longValue(), oxx0ioi.f14804I0Io));
                    }
                    if (oIX0oI2.f13537xoIox.size() == 1) {
                        Double valueOf2 = Double.valueOf((((Oo2.longValue() / oxx0ioi.f14808oxoX) - oxx0ioi.f14806X0o0xo) + oIX0oI2.f13537xoIox.get(0).f14806X0o0xo) * oIX0oI2.f13537xoIox.get(0).f14808oxoX);
                        if (this.f11091II0XooXoX.IoXIXo(oIX0oI2.f13536oxoX)) {
                            this.f11091II0XooXoX.oO(oIX0oI2.f13536oxoX).XO(valueOf2);
                        } else {
                            oIX0oI2.XO(valueOf2);
                            this.f11091II0XooXoX.xxIXOIIO(oIX0oI2);
                        }
                    } else if (oIX0oI2.f13537xoIox.size() > 1) {
                        int i4 = 0;
                        while (i4 < oxx0ioi.f14804I0Io) {
                            int[] iArr = Fit.f11152IoXIXo;
                            long j = (1 << iArr[oIX0oI2.f13532X0o0xo & 31]) - 1;
                            if (this.f11091II0XooXoX.IoXIXo(oIX0oI2.f13536oxoX)) {
                                this.f11091II0XooXoX.oO(oIX0oI2.f13536oxoX).Oxx0IOOO(Long.valueOf(Oo2.longValue() & j));
                            } else {
                                oIX0oI2.Oxx0IOOO(Long.valueOf(Oo2.longValue() & j));
                                this.f11091II0XooXoX.xxIXOIIO(oIX0oI2);
                            }
                            Oo2 = Long.valueOf(Oo2.longValue() >>> iArr[oIX0oI2.f13532X0o0xo & 31]);
                            i4 += iArr[oIX0oI2.f13532X0o0xo & 31];
                        }
                    } else {
                        if (xI0oxI002 == null) {
                            valueOf = Double.valueOf((((Oo2.longValue() / oxx0ioi.f14808oxoX) - oxx0ioi.f14806X0o0xo) + oIX0oI2.f13531Oxx0IOOO) * oIX0oI2.f13533XO);
                        } else {
                            valueOf = Double.valueOf((((Oo2.longValue() / oxx0ioi.f14808oxoX) - oxx0ioi.f14806X0o0xo) + xI0oxI002.f15704oxoX) * xI0oxI002.f15698I0Io);
                        }
                        if (this.f11091II0XooXoX.IoXIXo(oIX0oI2.f13536oxoX)) {
                            this.f11091II0XooXoX.oO(oIX0oI2.f13536oxoX).XO(valueOf);
                        } else {
                            oIX0oI2.XO(valueOf);
                            this.f11091II0XooXoX.xxIXOIIO(oIX0oI2);
                        }
                    }
                } else {
                    return;
                }
            }
            i += oxx0ioi.f14804I0Io;
        }
    }

    public void Oxx0xo(boolean z) {
        this.f11096O0xOxO = z;
    }

    public void OxxIIOOXO() {
        if (this.f11109o00 == null) {
            XOxxooXI.f13923II0xO0 = true;
            return;
        }
        throw new FitRuntimeException("Can't set showInvalidValues option after Decode started!");
    }

    public boolean X0o0xo(InputStream inputStream) throws IOException {
        int i = this.f11093IIX0o;
        if ((i > 0 && i < this.f11119xXxxox0I) || inputStream.available() > 0) {
            return true;
        }
        return false;
    }

    public boolean XO(InputStream inputStream) {
        boolean z = true;
        while (true) {
            try {
                int i = this.f11093IIX0o;
                if (i < this.f11119xXxxox0I) {
                    int i2 = oIX0oI.f11132oIX0oI[x0XOIxOo(this.f11115ooXIXxIX[i]).ordinal()];
                    if (i2 != 1 && i2 != 2 && i2 != 3) {
                        if (i2 != 4) {
                            z = false;
                        } else {
                            oOoXoXO();
                        }
                    }
                    this.f11093IIX0o++;
                } else {
                    this.f11093IIX0o = 0;
                    byte[] bArr = this.f11115ooXIXxIX;
                    int read = inputStream.read(bArr, 0, bArr.length);
                    this.f11119xXxxox0I = read;
                    if (read < 0) {
                        return z;
                    }
                }
            } catch (FitRuntimeException unused) {
                if (II0XooXoX()) {
                    oOoXoXO();
                }
                this.f11119xXxxox0I = 0;
                this.f11093IIX0o = 0;
                return false;
            } catch (IOException e) {
                throw new FitRuntimeException(e);
            }
        }
    }

    public void oI0IIXIo(long j) {
        this.f11102OxxIIOOXO = j;
    }

    @Override // com.garmin.fit.xx0o0O
    public void oIX0oI(IXIxx0 iXIxx0) {
        if (iXIxx0 != null && !this.f11106XIxXXX0x0.contains(iXIxx0)) {
            this.f11106XIxXXX0x0.add(iXIxx0);
        }
    }

    public boolean oO(InputStream inputStream) {
        this.f11109o00 = inputStream;
        return IXxxXO();
    }

    public void oOoXoXO() {
        if (this.f11099OxI) {
            this.f11107XO = 3L;
            this.f11090I0Io = (byte) 0;
            this.f11100Oxx0IOOO = 0;
            this.f11092II0xO0 = STATE.FILE_HDR;
            this.f11101Oxx0xo = 0;
            this.f11121xoXoI = false;
            f11086oOXoIIIo = false;
            this.f11096O0xOxO = false;
            this.f11103X0IIOO = null;
        }
    }

    public void ooOOo0oXI() {
        this.f11121xoXoI = true;
    }

    public void oxoX(O0xO0 o0xO0) {
        if (o0xO0 != null && !this.f11123xxX.contains(o0xO0)) {
            this.f11123xxX.add(o0xO0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0241, code lost:
    
        if (r6 != r3) goto L91;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:243:0x06bb. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.garmin.fit.Decode.RETURN x0XOIxOo(byte r22) {
        /*
            Method dump skipped, instructions count: 2140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garmin.fit.Decode.x0XOIxOo(byte):com.garmin.fit.Decode$RETURN");
    }

    public boolean x0xO0oo(InputStream inputStream, IXIxx0 iXIxx0) {
        oIX0oI(iXIxx0);
        return oO(inputStream);
    }

    public void xoIox() {
        if (this.f11109o00 == null) {
            this.f11099OxI = false;
            return;
        }
        throw new FitRuntimeException("Can't set incompleteStream option after Decode started!");
    }

    public oIXoXx0 xxIXOIIO() {
        return this.f11091II0XooXoX;
    }
}
