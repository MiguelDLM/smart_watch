package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;

/* loaded from: classes13.dex */
public class VTDeviceToy extends VTDevice {

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final String f27396xXxxox0I = "VTDeviceToy";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f27397IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f27398O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public short f27399OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f27400OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public byte f27401X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public short f27402XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public Context f27403XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public oIX0oI f27404XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f27405o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f27406oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f27407xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public VTChipSchemeType f27408xxX;

    /* loaded from: classes13.dex */
    public enum VTChipSchemeType {
        VTSchemeTypeTI,
        VTSchemeTypeTL
    }

    /* loaded from: classes13.dex */
    public static abstract class oIX0oI {
        public void I0Io(int i) {
        }

        public void II0xO0(short[] sArr) {
        }

        public void X0o0xo(int i) {
        }

        public void oIX0oI(String str) {
        }

        public void oxoX(int i) {
        }
    }

    public VTDeviceToy(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27403XIxXXX0x0 = context;
        this.f27408xxX = XoX();
    }

    private void Io(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            Oxx0xo.oIX0oI(f27396xXxxox0I, "GSenor steps, invalid data.");
            return;
        }
        int i = (bArr[3] << 24) | (bArr[0] & 255) | (bArr[1] << 8) | (bArr[2] << 16);
        Oxx0xo.oIX0oI(f27396xXxxox0I, "steps: " + i);
        this.f27404XxX0x0xxx.I0Io(i);
    }

    public void I0(boolean z) {
        this.f27398O0xOxO = z;
    }

    public int I0X0x0oIo() {
        return this.f27406oI0IIXIo;
    }

    public boolean I0oOIX() {
        return this.f27405o00;
    }

    public void I0oOoX() {
    }

    public void IIX0(int i) {
    }

    public void IIxOXoOo0(boolean z) {
        this.f27397IIXOooo = z;
    }

    public boolean IoIOOxIIo(int i) {
        byte[] bArr = {4, (byte) (i & 255), (byte) ((i >> 8) & 255), 0, 0};
        xoO0xx0(i);
        return xII(IXxxXO.f27217oX, IXxxXO.f27200Xo0, bArr, false);
    }

    public void IoOoo(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            return;
        }
        int i = ((bArr[2] & 255) * 256) + (bArr[1] & 255);
        Oxx0xo.oIX0oI(f27396xXxxox0I, "offset: " + i);
        xoO0xx0(i);
    }

    public void Ioxxx() {
        X0IIOO(IXxxXO.f27227oxXx0IX, IXxxXO.f27197XX0);
    }

    public void O0(byte b) {
        OX00O0xII(b);
        xII(IXxxXO.f27252xx0X0, IXxxXO.f27238xI0oxI00, new byte[]{3, 4, 3, b}, false);
    }

    public void O00XxXI() {
        X0IIOO(IXxxXO.f27143I0oOIX, IXxxXO.f27171OO);
    }

    public void O0X() {
        xOoOIoI((byte) 0, (byte) 0);
    }

    public boolean O0Xx() {
        return this.f27397IIXOooo;
    }

    public void OI0(boolean z) {
        X0o0xo(IXxxXO.f27227oxXx0IX, IXxxXO.f27243xXOx, z);
    }

    public boolean OO() {
        return this.f27407xoXoI;
    }

    public void OO0x0xX() {
    }

    public void OOXIxO0(VTAlarm vTAlarm) {
    }

    public void OX00O0xII(byte b) {
        this.f27401X0IIOO = b;
    }

    public boolean Ox0O(byte b, byte b2, byte b3) {
        Oxx0xo.oIX0oI(f27396xXxxox0I, "writeGroup, subType: " + Oxx0xo().II0xO0());
        if (b > 100) {
            b = 100;
        }
        if (b2 > 100) {
            b2 = 100;
        }
        if (b3 > 100) {
            b3 = 100;
        }
        boolean z = this.f27408xxX.equals(VTChipSchemeType.VTSchemeTypeTI) || !this.f27408xxX.equals(VTChipSchemeType.VTSchemeTypeTL);
        byte b4 = IXxxXO.f27140I0;
        return xII(IXxxXO.f27172OO0x0xX, IXxxXO.f27192XIo0oOXIx, new byte[]{16, IXxxXO.f27147IIX0, 4, IXxxXO.f27249xoO0xx0, b2, b2, 0, 4, b4, b, 100, 0, 4, b4, b3, 100, 1}, z);
    }

    public void XI0oooXX() {
        X0IIOO(IXxxXO.f27217oX, IXxxXO.f27167O0Xx);
    }

    public void XIXIX() {
    }

    public void XIo0oOXIx() {
    }

    public void XX(boolean z) {
        X0o0xo(IXxxXO.f27227oxXx0IX, IXxxXO.f27246xo0x, z);
    }

    public boolean XX0() {
        return this.f27398O0xOxO;
    }

    public void XX0xXo() {
        X0IIOO(IXxxXO.f27217oX, IXxxXO.f27155Io);
    }

    public short Xo0() {
        return this.f27402XI0IXoo;
    }

    public short XoI0Ixx0() {
        return this.f27399OxI;
    }

    public VTChipSchemeType XoX() {
        X0IIOO Oxx0xo2 = Oxx0xo();
        if (Oxx0xo2 != null) {
            int II0xO02 = Oxx0xo2.II0xO0();
            int I0Io2 = Oxx0xo2.I0Io();
            if (I0Io2 == 2) {
                if (II0xO02 == 32 || II0xO02 == 28) {
                    return VTChipSchemeType.VTSchemeTypeTL;
                }
            } else if (I0Io2 == 6 && II0xO02 == 14) {
                return VTChipSchemeType.VTSchemeTypeTL;
            }
        }
        return VTChipSchemeType.VTSchemeTypeTI;
    }

    public void o0(boolean z) {
        X0o0xo(IXxxXO.f27227oxXx0IX, IXxxXO.f27142I0X0x0oIo, z);
    }

    public boolean o0oIxOo(short s) {
        byte[] bArr = {2, (byte) (s & 255), (byte) ((s >> 8) & 255)};
        oXIO0o0XI(s);
        return xII(IXxxXO.f27217oX, IXxxXO.f27167O0Xx, bArr, false);
    }

    public void o0xxxXXxX() {
        X0IIOO(IXxxXO.f27217oX, IXxxXO.f27200Xo0);
    }

    public void oOo(oIX0oI oix0oi) {
        this.f27404XxX0x0xxx = oix0oi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x009c, code lost:
    
        if (r0 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00c8, code lost:
    
        r0.oxoX(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c6, code lost:
    
        if (r0 != null) goto L19;
     */
    @Override // com.vtrump.vtble.VTDevice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void oOoXoXO(java.lang.String r11, java.lang.String r12, byte[] r13) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.VTDeviceToy.oOoXoXO(java.lang.String, java.lang.String, byte[]):void");
    }

    public byte oX() {
        return this.f27401X0IIOO;
    }

    public void oXIO0o0XI(short s) {
        this.f27399OxI = s;
    }

    @Override // com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        String str3 = f27396xXxxox0I;
        Oxx0xo.oIX0oI(str3, "dataReadNotify.sssss" + str + ",,,charUuid: " + str2 + ",,data: " + xxX.XO(bArr));
        if (str.equals(IXxxXO.f27217oX) && str2.equals(IXxxXO.f27200Xo0)) {
            IoOoo(bArr);
        } else if (str.equals(IXxxXO.f27217oX) && str2.equals(IXxxXO.f27167O0Xx)) {
            x0xO(bArr);
        } else if (str.equals(IXxxXO.f27143I0oOIX) && str2.equals(IXxxXO.f27171OO)) {
            xoIxX(bArr);
        } else if (str.equals(IXxxXO.f27227oxXx0IX) && str2.equals(IXxxXO.f27197XX0)) {
            Io(bArr);
        } else if (str.equals(IXxxXO.f27217oX) && str2.equals(IXxxXO.f27155Io)) {
            byte[] bArr2 = new byte[bArr.length - 1];
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            Log.d(str3, "dataReadNotify:paireKeyStr " + xxX.Oxx0xo(bArr2));
        }
        super.ooOOo0oXI(str, str2, bArr);
    }

    public void ooOx(boolean z) {
        this.f27405o00 = z;
    }

    public void ox() {
    }

    public boolean oxIIX0o(short s) {
        byte[] bArr = {3, (byte) (s & 255), (byte) ((s >> 8) & 255), 30};
        OOXIXo();
        xOOOX(s);
        return xII(IXxxXO.f27143I0oOIX, IXxxXO.f27171OO, bArr, false);
    }

    public void oxXx0IX() {
        X0o0xo(IXxxXO.f27248xoIxX, IXxxXO.f27235x0xO, true);
    }

    public void oxxXoxO(boolean z) {
        this.f27400OxxIIOOXO = z;
    }

    public void x0xO(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return;
        }
        short s = (short) ((bArr[2] << 8) | bArr[1]);
        Oxx0xo.oIX0oI(f27396xXxxox0I, "time to power off: " + ((int) s));
        oXIO0o0XI(s);
    }

    public boolean xI0oxI00(byte b) {
        boolean z = true;
        if (b > 100) {
            b = 100;
        }
        byte[] bArr = {4, IXxxXO.f27140I0, b, 100, 0};
        if (!this.f27408xxX.equals(VTChipSchemeType.VTSchemeTypeTI) && this.f27408xxX.equals(VTChipSchemeType.VTSchemeTypeTL)) {
            z = false;
        }
        return xII(IXxxXO.f27172OO0x0xX, IXxxXO.f27192XIo0oOXIx, bArr, z);
    }

    public void xOOOX(short s) {
        this.f27402XI0IXoo = s;
    }

    public boolean xOoOIoI(byte b, byte b2) {
        if (b > 100) {
            b = 100;
        }
        if (b2 > 100) {
            b2 = 100;
        }
        return xII(IXxxXO.f27172OO0x0xX, IXxxXO.f27192XIo0oOXIx, new byte[]{11, IXxxXO.f27147IIX0, 4, IXxxXO.f27249xoO0xx0, b2, b2, 0, 4, IXxxXO.f27140I0, b, 100, 0}, this.f27408xxX.equals(VTChipSchemeType.VTSchemeTypeTI) || !this.f27408xxX.equals(VTChipSchemeType.VTSchemeTypeTL));
    }

    public void xX0IIXIx0(boolean z) {
        this.f27407xoXoI = z;
    }

    public void xXOx(boolean z) {
        X0o0xo(IXxxXO.f27143I0oOIX, IXxxXO.f27251xoxXI, z);
    }

    public void xo0x(boolean z) {
        X0o0xo(IXxxXO.f27252xx0X0, IXxxXO.f27238xI0oxI00, z);
    }

    public void xoIxX(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return;
        }
        short s = (short) (((bArr[2] & 255) << 8) | (bArr[1] & 255));
        Oxx0xo.oIX0oI(f27396xXxxox0I, "temperature limit: " + ((int) s));
        xOOOX(s);
    }

    public void xoO0xx0(int i) {
        this.f27406oI0IIXIo = i;
    }

    public boolean xoxXI() {
        return this.f27400OxxIIOOXO;
    }

    public boolean xx0X0(byte b) {
        if (b > 100) {
            b = 100;
        }
        return xII(IXxxXO.f27172OO0x0xX, IXxxXO.f27192XIo0oOXIx, new byte[]{4, IXxxXO.f27249xoO0xx0, b, b, b}, false);
    }

    public void xxIO() {
        O0((byte) -1);
    }

    public VTDeviceToy(Context context) {
        super(context);
        this.f27403XIxXXX0x0 = context;
        this.f27408xxX = XoX();
    }
}
