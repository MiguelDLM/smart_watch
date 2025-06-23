package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import com.vtrump.vtble.o00;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class xoIox extends o00 {

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27553IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public boolean f27554X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public byte[] f27555Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f27556oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f27557oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f27558oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ScaleUserInfo f27559ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public double f27560xI;

    public xoIox(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27557oo = 2;
        XX0xXo(true);
    }

    private byte[] OX00O0xII() {
        byte[] OOXIXo2 = xxX.OOXIXo(Oo().getAddress());
        byte[] xoIox2 = xxX.xoIox(xxX.I0Io(this.f27560xI, 10));
        byte[] bArr = this.f27555Xx000oIo;
        return new byte[]{-1, -2, (byte) Oxx0xo().II0xO0(), (byte) Oxx0xo().X0o0xo(), OOXIXo2[0], OOXIXo2[1], OOXIXo2[2], OOXIXo2[3], OOXIXo2[4], OOXIXo2[5], TransportLayerPacket.SYNC_WORD, 32, xoIox2[0], xoIox2[1], 0, 0, bArr[9], bArr[10]};
    }

    @Override // com.vtrump.vtble.o00
    public void I0(ScaleInfo.VTUnit vTUnit) {
        int i;
        super.I0(vTUnit);
        int II0xO02 = Oxx0xo().II0xO0();
        byte b = II0xO02 == 40 ? (byte) 36 : (byte) 0;
        if (II0xO02 == 41) {
            b = 37;
        }
        if (II0xO02 == 42) {
            b = 38;
        }
        ScaleInfo.VTUnit vTUnit2 = ScaleInfo.VTUnit.VTUnitJin;
        if (vTUnit == vTUnit2 || vTUnit == ScaleInfo.VTUnit.VTUnitStonePound) {
            o0(11, oX());
            return;
        }
        if (vTUnit == vTUnit2) {
            i = 0;
        } else {
            if (vTUnit != ScaleInfo.VTUnit.VTUnitKg) {
                if (vTUnit == ScaleInfo.VTUnit.VTUnitPound) {
                    i = 2;
                } else if (vTUnit == ScaleInfo.VTUnit.VTUnitStone) {
                    i = 3;
                }
            }
            i = 1;
        }
        this.f27553IoOoX = vTUnit.nativeInt;
        byte[] bArr = {-91, 5, b, 23, (byte) i, (byte) (i ^ (b ^ 18)), TransportLayerPacket.SYNC_WORD};
        x0o(IXxxXO.f27187X0xxXX0, IXxxXO.f27219oXxOI0oIx, bArr, true);
        Oxx0xo.oIX0oI("senhe writeUnit", xxX.XO(bArr));
    }

    @Override // com.vtrump.vtble.o00
    public void XIo0oOXIx(byte b) {
        int II0xO02 = Oxx0xo().II0xO0();
        byte b2 = II0xO02 == 40 ? (byte) 36 : (byte) 0;
        if (II0xO02 == 41) {
            b2 = 37;
        }
        if (II0xO02 == 42) {
            b2 = 38;
        }
        this.f27556oOXoIIIo = b;
        byte[] bArr = {-91, 5, b2, 19, b, (byte) ((b2 ^ 22) ^ b), TransportLayerPacket.SYNC_WORD};
        x0o(IXxxXO.f27187X0xxXX0, IXxxXO.f27219oXxOI0oIx, bArr, true);
        Oxx0xo.oIX0oI("senhe setModel", xxX.XO(bArr));
    }

    @Override // com.vtrump.vtble.o00
    public void XoX() {
        int II0xO02 = Oxx0xo().II0xO0();
        byte b = II0xO02 == 40 ? (byte) 36 : (byte) 0;
        if (II0xO02 == 41) {
            b = 37;
        }
        if (II0xO02 == 42) {
            b = 38;
        }
        byte[] bArr = {-91, 4, b, 20, (byte) (b ^ 16), TransportLayerPacket.SYNC_WORD};
        x0o(IXxxXO.f27187X0xxXX0, IXxxXO.f27219oXxOI0oIx, bArr, true);
        Oxx0xo.oIX0oI("senhe checkModel", xxX.XO(bArr));
    }

    @Override // com.vtrump.vtble.o00, com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        int i;
        byte b;
        byte b2;
        int i2;
        ScaleInfo.VTUnit vTUnit;
        super.oOoXoXO(str, str2, bArr);
        if (IXxxXO.f27187X0xxXX0.equalsIgnoreCase(str) && IXxxXO.f27152IO0XoXxO.equalsIgnoreCase(str2)) {
            Oxx0xo.II0xO0("VTDeviceScaleSenHe", "dataChangedNotify: " + xxX.XO(bArr));
            if (bArr.length < 7) {
                if (bArr[0] == 90 && bArr[1] == 4 && bArr[3] == 23) {
                    OO0x0xX(this.f27553IoOoX);
                    o0(10, this.f27553IoOoX);
                    return;
                }
                return;
            }
            if (bArr.length == 7 && bArr[0] == 90 && bArr[1] == 5 && bArr[3] == 20) {
                byte b3 = bArr[4];
                if (b3 == 1) {
                    this.f27554X00IoxXI = true;
                }
                String format = String.format("{\"model\":%1$d}", Integer.valueOf(b3));
                Oxx0xo.II0xO0("VTDeviceScaleSenHe", "callback: " + this.f27481xXxxox0I + " , content: " + format);
                o00.I0Io i0Io = this.f27481xXxxox0I;
                if (i0Io != null) {
                    i0Io.a(format);
                    return;
                }
                return;
            }
            if (bArr.length == 6 && bArr[0] == 90 && bArr[1] == 4 && bArr[3] == 19) {
                if (this.f27556oOXoIIIo == 1) {
                    this.f27554X00IoxXI = true;
                } else {
                    this.f27554X00IoxXI = false;
                }
            }
            int i3 = bArr[2] & 255;
            if (bArr[3] == 16) {
                byte b4 = bArr[7];
                this.f27557oo = (b4 >> 4) & 15;
                int i4 = b4 & 15;
                if (i4 == 0) {
                    vTUnit = ScaleInfo.VTUnit.VTUnitJin;
                } else if (i4 == 1) {
                    vTUnit = ScaleInfo.VTUnit.VTUnitKg;
                } else if (i4 == 2) {
                    vTUnit = ScaleInfo.VTUnit.VTUnitPound;
                } else if (i4 == 3) {
                    vTUnit = ScaleInfo.VTUnit.VTUnitStone;
                } else {
                    i2 = 0;
                    OO0x0xX(i2);
                    this.f27560xI = ((bArr[8] & 255) << 8) | (bArr[9] & 255);
                    Oxx0xo.II0xO0("VTDeviceScaleSenHe", "8、9字节解析结果： " + this.f27560xI);
                    this.f27560xI = this.f27560xI / Math.pow(10.0d, (double) this.f27557oo);
                    this.f27560xI = new BigDecimal(String.valueOf(this.f27560xI)).setScale(this.f27557oo, RoundingMode.HALF_UP).doubleValue();
                    Oxx0xo.II0xO0("VTDeviceScaleSenHe", "mWeight3=: " + this.f27560xI + " ,unit: " + i4 + " ,accuway: " + this.f27557oo + " , type: " + (bArr[4] & 255));
                    ooOx(bArr[2], (byte) 16, bArr[4]);
                    double d = this.f27560xI;
                    int i5 = this.f27557oo;
                    byte b5 = bArr[4];
                    I0oOoX(new IIX0o(d, XIXIX.OOXIXo.f3760XO, i5, b5 != 2 || b5 == 3).II0xO0(bArr[4]));
                }
                i2 = vTUnit.nativeInt;
                OO0x0xX(i2);
                this.f27560xI = ((bArr[8] & 255) << 8) | (bArr[9] & 255);
                Oxx0xo.II0xO0("VTDeviceScaleSenHe", "8、9字节解析结果： " + this.f27560xI);
                this.f27560xI = this.f27560xI / Math.pow(10.0d, (double) this.f27557oo);
                this.f27560xI = new BigDecimal(String.valueOf(this.f27560xI)).setScale(this.f27557oo, RoundingMode.HALF_UP).doubleValue();
                Oxx0xo.II0xO0("VTDeviceScaleSenHe", "mWeight3=: " + this.f27560xI + " ,unit: " + i4 + " ,accuway: " + this.f27557oo + " , type: " + (bArr[4] & 255));
                ooOx(bArr[2], (byte) 16, bArr[4]);
                double d2 = this.f27560xI;
                int i52 = this.f27557oo;
                byte b52 = bArr[4];
                I0oOoX(new IIX0o(d2, XIXIX.OOXIXo.f3760XO, i52, b52 != 2 || b52 == 3).II0xO0(bArr[4]));
            }
            if (i3 == 36 && bArr[4] == 2) {
                this.f27558oo0xXOI0I = true;
                b = 16;
                i = i3;
                b2 = 2;
                XX(Ix0x.II0XooXoX.X0IIOO(100).XxX0x0xxx(this.f27559ooXIXxIX, this.f27560xI), this.f27559ooXIXxIX, bArr, bArr, this.f27557oo, 1019, "senhe", "");
            } else {
                i = i3;
                b = 16;
                b2 = 2;
            }
            if (i == 38) {
                if (bArr[3] == b) {
                    ooOx((byte) 38, b, bArr[4]);
                    if (bArr[4] == b2 && this.f27554X00IoxXI) {
                        this.f27558oo0xXOI0I = true;
                        XX(Ix0x.II0XooXoX.X0IIOO(100).XxX0x0xxx(this.f27559ooXIXxIX, this.f27560xI), this.f27559ooXIXxIX, bArr, bArr, this.f27557oo, 1019, "senhe", "");
                        return;
                    }
                    return;
                }
                ooOx((byte) 38, (byte) 17, bArr[6]);
                Oxx0xo.oIX0oI("", "还有下笔数据" + ((int) bArr[4]));
                this.f27555Xx000oIo = bArr;
                int i6 = ((bArr[9] & 255) << 8) | (bArr[10] & 255);
                Oxx0xo.oIX0oI("", "阻值： " + i6);
                double d3 = (double) i6;
                XX(Ix0x.II0XooXoX.X0IIOO(1019).X00IoxXI(this.f27559ooXIXxIX, this.f27560xI, d3).IIX0o(this.f27559ooXIXxIX, this.f27560xI, d3, "senhe"), this.f27559ooXIXxIX, OX00O0xII(), bArr, this.f27557oo, 1019, "senhe", "");
            }
        }
    }

    public final void ooOx(byte b, byte b2, byte b3) {
        XOxIOxOx(IXxxXO.f27187X0xxXX0, IXxxXO.f27219oXxOI0oIx, new byte[]{-91, 5, b, b2, b3, (byte) (((b ^ 5) ^ b2) ^ b3), TransportLayerPacket.SYNC_WORD}, false, 20);
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        Oxx0xo.II0xO0("VTDeviceScaleSenHe", "setmUserInfo: " + jSONObject);
        if (jSONObject == null) {
            return;
        }
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        this.f27559ooXIXxIX = scaleUserInfo;
        scaleUserInfo.xoIox(jSONObject.optInt("height"));
        this.f27559ooXIXxIX.II0XooXoX(jSONObject.optDouble("age"));
        this.f27559ooXIXxIX.xxIXOIIO(jSONObject.optInt("gender"));
    }

    public void xoO0xx0(boolean z) {
        X0o0xo(IXxxXO.f27187X0xxXX0, IXxxXO.f27152IO0XoXxO, z);
    }
}
