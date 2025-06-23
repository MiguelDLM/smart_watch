package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class XOxIOxOx extends o00 {

    /* renamed from: IO, reason: collision with root package name */
    public boolean f27443IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f27444IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public boolean f27445X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f27446Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f27447oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f27448oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f27449oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public double f27450ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public int f27451xI;

    /* renamed from: xII, reason: collision with root package name */
    public byte[] f27452xII;

    public XOxIOxOx(BluetoothDevice bluetoothDevice, Context context, XIxXXX0x0 xIxXXX0x0) {
        super(bluetoothDevice, context);
        String str;
        StringBuilder sb;
        int i;
        byte b;
        this.f27452xII = xIxXXX0x0.II0xO0();
        Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", "VTDeviceScaleAdvFat10: " + xxX.Oxx0xo(this.f27452xII));
        byte[] bArr = this.f27452xII;
        byte b2 = bArr[1];
        if (b2 == -40) {
            this.f27445X00IoxXI = false;
            this.f27443IO = false;
            ooOx(bArr[2], bArr[3]);
            sb = new StringBuilder();
            sb.append(" d8,mWeight: ");
            sb.append(this.f27450ooXIXxIX);
        } else if (b2 == -35) {
            this.f27445X00IoxXI = true;
            ooOx(bArr[2], bArr[3]);
            byte[] bArr2 = this.f27452xII;
            byte b3 = bArr2[4];
            if ((b3 & 255) == 0 && (bArr2[5] & 255) == 0 && (bArr2[6] & 255) == 0) {
                str = " dd,false";
                Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", str);
            }
            this.f27443IO = false;
            this.f27448oo = (bArr2[6] & 255) | ((b3 & 255) << 16) | ((bArr2[5] & 255) << 8);
            sb = new StringBuilder();
            sb.append(" dd,true,mLegImp: ");
            i = this.f27448oo;
            sb.append(i);
        } else if (b2 == -34) {
            OIoxIx.oxoX.oxoX().II0xO0(this.f27452xII);
            byte[] bArr3 = this.f27452xII;
            if (bArr3 != null && ((b = bArr3[2]) != 0 || bArr3[3] != 0)) {
                ooOx(b, bArr3[3]);
            }
            Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", " de，first： " + this.f27450ooXIXxIX);
            sb = new StringBuilder();
            sb.append(" de，first data： ");
            sb.append(xxX.Oxx0xo(this.f27452xII));
        } else {
            if (b2 != -33) {
                if (b2 == 15) {
                    str = " 0f";
                    Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", str);
                }
                return;
            }
            byte[] I0Io2 = OIoxIx.oxoX.oxoX().I0Io();
            if (I0Io2[2] == 0 && I0Io2[3] == 0) {
                Log.d("VTDeviceScaleAdvFat10", "No 0xde");
                return;
            }
            OIoxIx.oxoX.oxoX().oIX0oI();
            Log.d("VTDeviceScaleAdvFat10", " clear first");
            this.f27443IO = true;
            this.f27445X00IoxXI = true;
            Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", "first: " + xxX.Oxx0xo(I0Io2));
            Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", "second: " + xxX.Oxx0xo(this.f27452xII));
            ooOx(I0Io2[2], I0Io2[3]);
            this.f27451xI = ((I0Io2[4] & 255) << 16) | ((I0Io2[5] & 255) << 8) | (I0Io2[6] & 255);
            this.f27449oo0xXOI0I = (I0Io2[9] & 255) | ((I0Io2[7] & 255) << 16) | ((I0Io2[8] & 255) << 8);
            byte[] bArr4 = this.f27452xII;
            this.f27446Xx000oIo = ((bArr4[2] & 255) << 16) | ((bArr4[3] & 255) << 8) | (bArr4[10] & 255);
            this.f27444IoOoX = ((bArr4[4] & 255) << 16) | ((bArr4[5] & 255) << 8) | (bArr4[6] & 255);
            this.f27447oOXoIIIo = (bArr4[9] & 255) | ((bArr4[7] & 255) << 16) | ((bArr4[8] & 255) << 8);
            sb = new StringBuilder();
            sb.append(" df,mLeftLegImp: ");
            sb.append(this.f27451xI);
            sb.append(",mRightLegImp: ");
            sb.append(this.f27449oo0xXOI0I);
            sb.append(",mImp: ");
            sb.append(this.f27446Xx000oIo);
            sb.append(",mLeftArmImp: ");
            sb.append(this.f27444IoOoX);
            sb.append(",mRightArmImp: ");
            i = this.f27447oOXoIIIo;
            sb.append(i);
        }
        str = sb.toString();
        Oxx0xo.oIX0oI("VTDeviceScaleAdvFat10", str);
    }

    public void OX00O0xII() {
        if (xoXoI.OOXIxO0().Ox0O()) {
            Io(this.f27450ooXIXxIX, this.f27446Xx000oIo, this.f27448oo, this.f27451xI, this.f27449oo0xXOI0I, this.f27444IoOoX, this.f27447oOXoIIIo, 1, xoO0xx0());
        } else {
            I0oOoX(new IIX0o(this.f27450ooXIXxIX, this.f27446Xx000oIo, 1, xoO0xx0()));
        }
    }

    public final void ooOx(byte b, byte b2) {
        this.f27450ooXIXxIX = (((b & Utf8.REPLACEMENT_BYTE) << 8) | (b2 & 255)) / 10.0d;
    }

    @Override // com.vtrump.vtble.o00
    public void ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        ScaleUserInfo scaleUserInfo = new ScaleUserInfo();
        scaleUserInfo.II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt);
        if (xoO0xx0()) {
            ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1004).XIxXXX0x0(scaleUserInfo, this.f27450ooXIXxIX, this.f27446Xx000oIo, this.f27448oo, this.f27451xI, this.f27449oo0xXOI0I, this.f27444IoOoX, this.f27447oOXoIIIo, this.f27443IO).IIX0o(scaleUserInfo, this.f27450ooXIXxIX, 100.0d, "fat10");
            ScaleUserInfo xoIox2 = new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt);
            byte[] bArr = this.f27452xII;
            XX(IIX0o2, xoIox2, bArr, bArr, 1, 1004, "fat10", "");
        }
    }

    public boolean xoO0xx0() {
        return this.f27445X00IoxXI && this.f27475X0IIOO;
    }
}
