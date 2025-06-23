package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class OOXIXo extends o00 {

    /* renamed from: IO, reason: collision with root package name */
    public boolean f27267IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public double f27268IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f27269X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f27270Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public BluetoothDevice f27271oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public double f27272oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f27273oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public String f27274ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public ScaleUserInfo f27275xI;

    /* renamed from: xII, reason: collision with root package name */
    public boolean f27276xII;

    public OOXIXo(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27274ooXIXxIX = "DEBNO9XBF7L9IXZL";
        this.f27273oo0xXOI0I = false;
        this.f27270Xx000oIo = -1;
        this.f27269X00IoxXI = -1;
        this.f27267IO = false;
        this.f27276xII = false;
        this.f27271oOXoIIIo = bluetoothDevice;
    }

    @Override // com.vtrump.vtble.o00
    public void I0(ScaleInfo.VTUnit vTUnit) {
        super.I0(vTUnit);
        Log.d("VTDeviceScaleXH", "writeUnit: " + vTUnit.nativeInt);
        int i = vTUnit.nativeInt;
        if (i == ScaleInfo.VTUnit.VTUnitStone.nativeInt || i == ScaleInfo.VTUnit.VTUnitJin.nativeInt) {
            o0(11, oX());
            return;
        }
        this.f27270Xx000oIo = i;
        this.f27269X00IoxXI = 3;
        this.f27276xII = true;
        xII(IXxxXO.f27191XIXIxO, IXxxXO.f27170OIOoIIOIx, new byte[]{1, (byte) i}, true);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        String str3;
        int i;
        String str4;
        boolean z;
        int i2;
        String str5;
        int i3;
        ScaleInfo IIX0o2;
        int i4;
        Ix0x.II0XooXoX I0oOoX2;
        String str6;
        ScaleUserInfo scaleUserInfo;
        double d;
        double d2;
        String str7;
        double ooOOo0oXI2;
        if (IXxxXO.f27191XIXIxO.equalsIgnoreCase(str) && IXxxXO.f27177OoO.equalsIgnoreCase(str2)) {
            int II0xO02 = Oxx0xo().II0xO0();
            int i5 = (bArr[15] >> 3) & 3;
            int i6 = (i5 == 1 ? ScaleInfo.VTUnit.VTUnitJin : i5 == 2 ? ScaleInfo.VTUnit.VTUnitPound : i5 == 3 ? ScaleInfo.VTUnit.VTUnitStonePound : ScaleInfo.VTUnit.VTUnitKg).nativeInt;
            if (this.f27480oI0IIXIo == null) {
                Log.e("VTDeviceScaleXH", "unlock listener is null");
            } else if (this.f27276xII) {
                if (this.f27270Xx000oIo == i6) {
                    o0(10, i6);
                    OO0x0xX(i6);
                    this.f27276xII = false;
                } else {
                    if (this.f27269X00IoxXI == 0) {
                        o0(11, i6);
                        this.f27276xII = false;
                    }
                    this.f27269X00IoxXI--;
                }
            } else if (!this.f27267IO) {
                o0(0, i6);
                OO0x0xX(i6);
                this.f27267IO = true;
            }
            int i7 = (bArr[15] & 6) >> 1;
            if (i7 == 0) {
                i7 = 2;
            } else if (i7 == 1) {
                i7 = 0;
            } else if (i7 == 2) {
                i7 = 1;
            }
            if (3 == i5) {
                this.f27268IoOoX = OxxIIOOXO.Oo((bArr[12] & 255) + ":" + ((bArr[11] & 255) / 10.0d));
                str7 = "VTDeviceScaleXH";
            } else {
                str7 = "VTDeviceScaleXH";
                double d3 = ((bArr[12] & 255) << 8) | (bArr[11] & 255);
                this.f27268IoOoX = d3;
                double pow = d3 / Math.pow(10.0d, i7);
                this.f27268IoOoX = pow;
                if (1 == i5) {
                    ooOOo0oXI2 = pow / 2.0d;
                } else if (2 == i5) {
                    ooOOo0oXI2 = OxxIIOOXO.ooOOo0oXI(pow);
                }
                this.f27268IoOoX = ooOOo0oXI2;
            }
            if (II0xO02 == 29 || II0xO02 == 33) {
                double d4 = ((bArr[17] & 255) << 8) | (bArr[16] & 255);
                this.f27268IoOoX = d4;
                this.f27268IoOoX = d4 / Math.pow(10.0d, i7);
                str3 = str7;
                Oxx0xo.oIX0oI(str3, "hw d w2: " + this.f27268IoOoX);
            } else {
                str3 = str7;
            }
            this.f27273oo0xXOI0I = false;
            I0oOoX(new IIX0o(this.f27268IoOoX, XIXIX.OOXIXo.f3760XO, i7, false));
            Oxx0xo.oIX0oI(str3, "dataChangedNotify: 动态数据:" + xxX.IIXOooo(bArr));
        } else {
            str3 = "VTDeviceScaleXH";
        }
        if (IXxxXO.f27162IxIX0I.equalsIgnoreCase(str) && IXxxXO.f27215oOoIIO0.equalsIgnoreCase(str2)) {
            Oxx0xo.oIX0oI(str3, "dataChangedNotify: 定格数据:" + xxX.IIXOooo(bArr));
            int II0xO03 = Oxx0xo().II0xO0();
            int i8 = (bArr[15] >> 3) & 3;
            if (i8 == 1) {
                i = ScaleInfo.VTUnit.VTUnitJin.nativeInt;
            } else if (i8 == 2) {
                i = ScaleInfo.VTUnit.VTUnitPound.nativeInt;
            } else {
                i = (i8 == 3 ? ScaleInfo.VTUnit.VTUnitStonePound : ScaleInfo.VTUnit.VTUnitKg).nativeInt;
            }
            if (this.f27480oI0IIXIo == null) {
                Log.e(str3, "lock listener is null");
            } else if (this.f27276xII) {
                if (this.f27270Xx000oIo == i) {
                    o0(10, i);
                    OO0x0xX(i);
                    this.f27276xII = false;
                } else {
                    if (this.f27269X00IoxXI == 0) {
                        o0(11, i);
                        this.f27276xII = false;
                    }
                    this.f27269X00IoxXI--;
                }
            } else if (!this.f27267IO) {
                o0(0, i);
                OO0x0xX(i);
                this.f27267IO = true;
            }
            int i9 = (bArr[15] & 6) >> 1;
            if (i9 == 0) {
                i9 = 2;
            } else if (i9 == 1) {
                i9 = 0;
            } else if (i9 == 2) {
                i9 = 1;
            }
            if (3 == i8) {
                this.f27268IoOoX = OxxIIOOXO.Oo((bArr[12] & 255) + ":" + ((bArr[11] & 255) / 10.0d));
                str4 = str3;
            } else {
                double d5 = ((bArr[12] & 255) << 8) | (bArr[11] & 255);
                this.f27268IoOoX = d5;
                str4 = str3;
                double pow2 = d5 / Math.pow(10.0d, i9);
                this.f27268IoOoX = pow2;
                if (1 == i8) {
                    this.f27268IoOoX = pow2 / 2.0d;
                } else if (2 == i8) {
                    this.f27268IoOoX = OxxIIOOXO.ooOOo0oXI(pow2);
                }
            }
            if (II0xO03 == 29 || II0xO03 == 33) {
                double d6 = ((bArr[17] & 255) << 8) | (bArr[16] & 255);
                this.f27268IoOoX = d6;
                this.f27268IoOoX = d6 / Math.pow(10.0d, i9);
                Oxx0xo.oIX0oI(str4, "hw f w2: " + this.f27268IoOoX);
            }
            float f = ((bArr[10] & 255) << 8) | (bArr[9] & 255);
            float f2 = ((bArr[14] & 255) << 8) | (bArr[13] & 255);
            if (Oxx0xo().II0xO0() != 29 && Oxx0xo().II0xO0() != 33) {
                f /= 10.0f;
            }
            this.f27272oo = f;
            float f3 = f2 / 10.0f;
            ScaleUserInfo scaleUserInfo2 = this.f27275xI;
            if (scaleUserInfo2 == null) {
                I0oOoX(new IIX0o(this.f27268IoOoX, this.f27272oo, i9, false));
                return;
            }
            if (this.f27273oo0xXOI0I) {
                z = true;
            } else {
                int I0Io2 = scaleUserInfo2.I0Io();
                double II0xO04 = this.f27275xI.II0xO0();
                int oxoX2 = this.f27275xI.oxoX();
                if (this.f27274ooXIXxIX.equals(xoXoI.OOXIxO0().IIxOXoOo0())) {
                    i2 = I0Io2;
                    ScaleInfo IIX0o3 = Ix0x.II0XooXoX.X0IIOO(1011).IIX0o(this.f27275xI, this.f27268IoOoX, this.f27272oo, "xhjq");
                    Log.d(str4, "j:q ");
                    IIX0o2 = IIX0o3;
                    i4 = 1011;
                } else {
                    i2 = I0Io2;
                    if (II0xO03 == 20) {
                        i3 = 1012;
                        str5 = "xhtsing";
                    } else {
                        str5 = "xh";
                        i3 = 1006;
                    }
                    if (II0xO03 == 21) {
                        i3 = 1000;
                        str5 = "xhsic";
                    }
                    String str8 = str5;
                    if (II0xO03 == 29) {
                        Oxx0xo.oIX0oI("execueHW", "data-value: " + this.f27272oo + "，，W：：" + this.f27268IoOoX);
                        I0oOoX2 = Ix0x.II0XooXoX.X0IIOO(1018).I0oOoX(this.f27275xI, this.f27268IoOoX, this.f27272oo);
                        str6 = "xhhw";
                        scaleUserInfo = this.f27275xI;
                        d = this.f27268IoOoX;
                        d2 = this.f27272oo;
                    } else if (II0xO03 == 33) {
                        I0oOoX2 = Ix0x.II0XooXoX.X0IIOO(1018).I0oOoX(this.f27275xI, this.f27268IoOoX, this.f27272oo);
                        str6 = "xhtjhw";
                        scaleUserInfo = this.f27275xI;
                        d = this.f27268IoOoX;
                        d2 = this.f27272oo;
                    } else {
                        IIX0o2 = Ix0x.II0XooXoX.X0IIOO(i3).IIX0o(this.f27275xI, this.f27268IoOoX, this.f27272oo, str8);
                        i4 = i3;
                    }
                    IIX0o2 = I0oOoX2.IIX0o(scaleUserInfo, d, d2, str6);
                    i4 = 1018;
                }
                byte oxoX3 = (byte) Oxx0xo().oxoX();
                byte I0Io3 = (byte) Oxx0xo().I0Io();
                byte II0xO05 = (byte) Oxx0xo().II0xO0();
                byte X0o0xo2 = (byte) Oxx0xo().X0o0xo();
                byte[] OOXIXo2 = xxX.OOXIXo(this.f27271oOXoIIIo.getAddress());
                byte b = OOXIXo2[0];
                byte b2 = OOXIXo2[1];
                byte b3 = OOXIXo2[2];
                byte b4 = OOXIXo2[3];
                byte b5 = OOXIXo2[4];
                byte b6 = OOXIXo2[5];
                byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(xxX.I0Io(this.f27268IoOoX, 100));
                byte b7 = OxxIIOOXO2[0];
                byte b8 = OxxIIOOXO2[1];
                byte b9 = OxxIIOOXO2[2];
                byte b10 = OxxIIOOXO2[3];
                ScaleInfo scaleInfo = IIX0o2;
                byte[] xoIox2 = xxX.xoIox((int) this.f27272oo);
                byte[] xoIox3 = xxX.xoIox((int) f3);
                byte[] bArr2 = {-1, -1, -2, oxoX3, I0Io3, II0xO05, X0o0xo2, b, b2, b3, b4, b5, b6, TransportLayerPacket.SYNC_WORD, 2, b7, b8, b9, b10, xoIox2[0], xoIox2[1], xoIox3[0], xoIox3[1]};
                Oxx0xo.oIX0oI(str4, "dataChangedNotify: 服务器数据:" + xxX.IIXOooo(bArr2));
                z = true;
                XX(scaleInfo, new ScaleUserInfo().xxIXOIIO(i2).II0XooXoX(II0xO04).xoIox(oxoX2), bArr2, bArr, i9, i4, "xh", "");
            }
            this.f27273oo0xXOI0I = z;
        }
        super.oOoXoXO(str, str2, bArr);
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        super.ooOOo0oXI(str, str2, bArr);
    }

    public void ooOx(boolean z) {
        X0o0xo(IXxxXO.f27191XIXIxO, IXxxXO.f27177OoO, z);
        X0o0xo(IXxxXO.f27162IxIX0I, IXxxXO.f27215oOoIIO0, z);
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27275xI = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27275xI.II0XooXoX(jSONObject.optDouble("age"));
        this.f27275xI.xxIXOIIO(jSONObject.optInt("gender"));
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }

    public void xoO0xx0() {
        X0IIOO(IXxxXO.f27191XIXIxO, IXxxXO.f27170OIOoIIOIx);
    }
}
