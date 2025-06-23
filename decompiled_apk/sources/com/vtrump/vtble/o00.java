package com.vtrump.vtble;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.huawei.openalliance.ad.constant.aw;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.download.api.constant.BaseConstants;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.VTDevice;
import com.vtrump.vtble.b.b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class o00 extends VTDevice {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final String f27470IIX0o = "VTDeviceScale";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f27471IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f27472O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f27473OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f27474OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public boolean f27475X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public ArrayList<Integer> f27476XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public VTDevice.II0xO0 f27477XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public oXoXxOo.II0xO0 f27478XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public Context f27479o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public X0o0xo f27480oI0IIXIo;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public I0Io f27481xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f27482xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public oXoXxOo.oIX0oI f27483xxX;

    /* loaded from: classes13.dex */
    public interface I0Io {
        void a(String str);
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements OXooXo.I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ boolean f27484I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ int f27485II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ int f27487X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f27488XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ byte[] f27489oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ ScaleInfo f27490oxoX;

        public II0xO0(byte[] bArr, int i, boolean z, ScaleInfo scaleInfo, int i2, String str) {
            this.f27489oIX0oI = bArr;
            this.f27485II0xO0 = i;
            this.f27484I0Io = z;
            this.f27490oxoX = scaleInfo;
            this.f27487X0o0xo = i2;
            this.f27488XO = str;
        }

        @Override // OXooXo.I0Io
        public void a() {
            Oxx0xo.oIX0oI(o00.f27470IIX0o, "onFailure: ");
            if (this.f27485II0xO0 != 0 || xoXoI.OOXIxO0().IIX0()) {
                if (this.f27485II0xO0 == 1018) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        this.f27490oxoX.IO(o00.this.f27474OxxIIOOXO);
                        jSONObject.put("code", this.f27490oxoX.o00());
                        jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, this.f27490oxoX.oo(this.f27487X0o0xo, this.f27488XO));
                        jSONObject.put("msg", "");
                        if (this.f27484I0Io) {
                            o00.this.f27480oI0IIXIo.oIX0oI(jSONObject.toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    this.f27490oxoX.IO(o00.this.f27474OxxIIOOXO);
                    boolean IO2 = xoXoI.OOXIxO0().IO();
                    jSONObject2.put("code", IO2 ? this.f27490oxoX.o00() : 4002);
                    jSONObject2.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, IO2 ? this.f27490oxoX.oo(this.f27487X0o0xo, this.f27488XO) : new JSONObject());
                    jSONObject2.put("msg", IO2 ? "" : "厂商服务不可用");
                    if (this.f27484I0Io) {
                        o00.this.f27480oI0IIXIo.oIX0oI(jSONObject2.toString());
                        return;
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            o00.this.f27480oI0IIXIo.oIX0oI(o00.this.XX0());
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
        @Override // OXooXo.I0Io
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "code"
                java.lang.String r1 = "deviceInfo"
                java.lang.String r2 = com.vtrump.vtble.o00.xo0x()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "completeScale:makeresponse= "
                r3.append(r4)
                r3.append(r9)
                java.lang.String r3 = r3.toString()
                com.vtrump.vtble.Oxx0xo.oIX0oI(r2, r3)
                boolean r2 = android.text.TextUtils.isEmpty(r9)
                java.lang.String r3 = "details"
                if (r2 != 0) goto L57
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L53
                r2.<init>(r9)     // Catch: org.json.JSONException -> L53
                boolean r4 = r2.has(r3)     // Catch: org.json.JSONException -> L53
                if (r4 == 0) goto L57
                org.json.JSONObject r4 = r2.getJSONObject(r3)     // Catch: org.json.JSONException -> L53
                boolean r5 = r4.has(r1)     // Catch: org.json.JSONException -> L53
                if (r5 == 0) goto L57
                org.json.JSONObject r5 = r4.getJSONObject(r1)     // Catch: org.json.JSONException -> L53
                java.lang.String r6 = "biaData"
                byte[] r7 = r8.f27489oIX0oI     // Catch: org.json.JSONException -> L53
                java.lang.String r7 = com.vtrump.vtble.xxX.XO(r7)     // Catch: org.json.JSONException -> L53
                r5.put(r6, r7)     // Catch: org.json.JSONException -> L53
                r4.put(r1, r5)     // Catch: org.json.JSONException -> L53
                r2.put(r3, r4)     // Catch: org.json.JSONException -> L53
                java.lang.String r9 = r2.toString()     // Catch: org.json.JSONException -> L53
                goto L57
            L53:
                r1 = move-exception
                r1.printStackTrace()
            L57:
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6a
                r1.<init>(r9)     // Catch: org.json.JSONException -> L6a
                int r1 = r1.getInt(r0)     // Catch: org.json.JSONException -> L6a
                com.vtrump.vtble.xoXoI r2 = com.vtrump.vtble.xoXoI.OOXIxO0()     // Catch: org.json.JSONException -> L68
                r2.xXoOI00O(r1)     // Catch: org.json.JSONException -> L68
                goto L70
            L68:
                r2 = move-exception
                goto L6d
            L6a:
                r1 = move-exception
                r2 = r1
                r1 = 0
            L6d:
                r2.printStackTrace()
            L70:
                int r2 = r8.f27485II0xO0
                if (r2 != 0) goto L85
                java.lang.String r0 = com.vtrump.vtble.o00.xo0x()
                java.lang.String r1 = "localCal is null"
                com.vtrump.vtble.Oxx0xo.oIX0oI(r0, r1)
                com.vtrump.vtble.o00 r0 = com.vtrump.vtble.o00.this
                com.vtrump.vtble.o00$X0o0xo r0 = r0.f27480oI0IIXIo
                r0.oIX0oI(r9)
                return
            L85:
                r2 = 4001(0xfa1, float:5.607E-42)
                if (r1 == r2) goto Lc9
                r2 = 4002(0xfa2, float:5.608E-42)
                if (r1 != r2) goto L8e
                goto Lc9
            L8e:
                boolean r2 = r8.f27484I0Io
                if (r2 == 0) goto Ld0
                r2 = 4015(0xfaf, float:5.626E-42)
                if (r1 != r2) goto Lc9
                org.json.JSONObject r9 = new org.json.JSONObject
                r9.<init>()
                com.vtrump.vtble.Scale.ScaleInfo r1 = r8.f27490oxoX     // Catch: org.json.JSONException -> Lc4
                int r1 = r1.o00()     // Catch: org.json.JSONException -> Lc4
                r9.put(r0, r1)     // Catch: org.json.JSONException -> Lc4
                com.vtrump.vtble.Scale.ScaleInfo r0 = r8.f27490oxoX     // Catch: org.json.JSONException -> Lc4
                int r1 = r8.f27487X0o0xo     // Catch: org.json.JSONException -> Lc4
                java.lang.String r2 = r8.f27488XO     // Catch: org.json.JSONException -> Lc4
                org.json.JSONObject r0 = r0.oo(r1, r2)     // Catch: org.json.JSONException -> Lc4
                r9.put(r3, r0)     // Catch: org.json.JSONException -> Lc4
                java.lang.String r0 = "msg"
                java.lang.String r1 = ""
                r9.put(r0, r1)     // Catch: org.json.JSONException -> Lc4
                com.vtrump.vtble.o00 r0 = com.vtrump.vtble.o00.this     // Catch: org.json.JSONException -> Lc4
                com.vtrump.vtble.o00$X0o0xo r0 = r0.f27480oI0IIXIo     // Catch: org.json.JSONException -> Lc4
                java.lang.String r9 = r9.toString()     // Catch: org.json.JSONException -> Lc4
                r0.oIX0oI(r9)     // Catch: org.json.JSONException -> Lc4
                goto Ld0
            Lc4:
                r9 = move-exception
                r9.printStackTrace()
                goto Ld0
            Lc9:
                com.vtrump.vtble.o00 r0 = com.vtrump.vtble.o00.this
                com.vtrump.vtble.o00$X0o0xo r0 = r0.f27480oI0IIXIo
                r0.oIX0oI(r9)
            Ld0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.o00.II0xO0.a(java.lang.String):void");
        }
    }

    /* loaded from: classes13.dex */
    public static abstract class X0o0xo {
        public void I0Io(int i) {
        }

        public void II0xO0(int i, String str) {
        }

        public void oIX0oI(String str) {
        }

        public void oxoX(int i, int i2) {
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends VTDevice.II0xO0 {
        public oIX0oI() {
        }

        @Override // com.vtrump.vtble.VTDevice.II0xO0
        public void oIX0oI(int i) {
            super.oIX0oI(i);
            Log.d(o00.f27470IIX0o, "onRssiReceived: rssi" + i);
            X0o0xo x0o0xo = o00.this.f27480oI0IIXIo;
            if (x0o0xo != null) {
                x0o0xo.I0Io(i);
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface oxoX {
    }

    public o00(BluetoothDevice bluetoothDevice, Context context) {
        super(bluetoothDevice, context);
        this.f27471IIXOooo = false;
        this.f27482xoXoI = 0;
        this.f27475X0IIOO = true;
        this.f27476XI0IXoo = new ArrayList<>();
        oIX0oI oix0oi = new oIX0oI();
        this.f27477XIxXXX0x0 = oix0oi;
        this.f27479o00 = context;
        ooXIXxIX(oix0oi);
        this.f27474OxxIIOOXO = bluetoothDevice.getAddress();
        this.f27476XI0IXoo.add(Integer.valueOf(ScaleInfo.VTUnit.VTUnitKg.nativeInt));
        this.f27476XI0IXoo.add(Integer.valueOf(ScaleInfo.VTUnit.VTUnitPound.nativeInt));
        this.f27476XI0IXoo.add(Integer.valueOf(ScaleInfo.VTUnit.VTUnitJin.nativeInt));
        this.f27476XI0IXoo.add(Integer.valueOf(ScaleInfo.VTUnit.VTUnitStonePound.nativeInt));
        this.f27476XI0IXoo.add(Integer.valueOf(ScaleInfo.VTUnit.VTUnitStone.nativeInt));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String XX0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new JSONObject());
            jSONObject.put("code", ErrorCode.AD_DATA_NOT_READY);
            jSONObject.put("msg", "网络不可用");
            this.f27480oI0IIXIo.oIX0oI(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void I0(ScaleInfo.VTUnit vTUnit) {
    }

    public byte[] I0X0x0oIo(String str) {
        OIoxIx.oIX0oI oIX0oI2 = OIoxIx.II0xO0.oxoX().oIX0oI(str);
        if (oIX0oI2 == null) {
            return null;
        }
        return oIX0oI2.oxoX();
    }

    public boolean I0oOIX() {
        return this.f27472O0xOxO;
    }

    public void I0oOoX(IIX0o iIX0o) {
        double X0o0xo2 = iIX0o.X0o0xo();
        double I0Io2 = iIX0o.I0Io();
        int oIX0oI2 = iIX0o.oIX0oI();
        boolean XO2 = iIX0o.XO();
        this.f27475X0IIOO = true;
        double ooOx2 = xoXoI.OOXIxO0().ooOx();
        double I02 = xoXoI.OOXIxO0().I0();
        if ((ooOx2 != -100.0d || I02 != -100.0d) && (X0o0xo2 < ooOx2 || X0o0xo2 > I02)) {
            this.f27475X0IIOO = false;
        }
        if (this.f27475X0IIOO) {
            if (this.f27480oI0IIXIo == null) {
                Log.d(f27470IIX0o, "no weight callback:！！！！！！ ");
                new b(X0o0xo.class.getSimpleName());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            int I0Io3 = Oxx0xo().I0Io();
            int II0xO02 = Oxx0xo().II0xO0();
            int X0o0xo3 = Oxx0xo().X0o0xo();
            try {
                jSONObject2.put("weight", X0o0xo2);
                JSONObject jSONObject3 = new JSONObject();
                if (iIX0o.oxoX() != -1) {
                    jSONObject3.put("weightType", iIX0o.oxoX());
                }
                jSONObject3.put("dataScale", oIX0oI2);
                jSONObject3.put("deviceMac", this.f27474OxxIIOOXO);
                jSONObject3.put("deviceSubType", II0xO02 + "");
                jSONObject3.put(aw.e, I0Io3 + "");
                jSONObject3.put("deviceVendor", X0o0xo3 + "");
                jSONObject2.put("deviceInfo", jSONObject3);
                int i = 200;
                if (xoXoI.OOXIxO0().Ox0O()) {
                    jSONObject2.put("rValue", I0Io2);
                    if (XO2) {
                        i = 202;
                    }
                }
                jSONObject.put("code", i);
                jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject2);
                jSONObject.put("msg", "success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f27480oI0IIXIo.oIX0oI(jSONObject.toString());
        }
    }

    public void IIxOXoOo0() {
    }

    public void Io(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i, boolean z) {
        this.f27475X0IIOO = true;
        double ooOx2 = xoXoI.OOXIxO0().ooOx();
        double I02 = xoXoI.OOXIxO0().I0();
        if ((ooOx2 != -100.0d || I02 != -100.0d) && (d < ooOx2 || d > I02)) {
            this.f27475X0IIOO = false;
        }
        if (this.f27480oI0IIXIo == null || !this.f27475X0IIOO) {
            Log.d(f27470IIX0o, "no weight callback:！！！！！！ ");
            new b(X0o0xo.class.getSimpleName());
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        int I0Io2 = Oxx0xo().I0Io();
        int II0xO02 = Oxx0xo().II0xO0();
        int X0o0xo2 = Oxx0xo().X0o0xo();
        try {
            jSONObject2.put("weight", d);
            jSONObject2.put("rValue", d2);
            jSONObject2.put("leftLegImp", xxX.Oo(d4, i));
            jSONObject2.put("rightLegImp", xxX.Oo(d5, i));
            jSONObject2.put("leftArmImp", xxX.Oo(d6, i));
            jSONObject2.put("rightArmImp", xxX.Oo(d7, i));
            jSONObject2.put("allBodyImp", xxX.Oo(d2, i));
            jSONObject2.put("twoLegsImp", xxX.Oo(d3, i));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("dataScale", i);
            jSONObject3.put("deviceMac", this.f27474OxxIIOOXO);
            jSONObject3.put("deviceSubType", II0xO02 + "");
            jSONObject3.put(aw.e, I0Io2 + "");
            jSONObject3.put("deviceVendor", X0o0xo2 + "");
            jSONObject2.put("deviceInfo", jSONObject3);
            jSONObject.put("code", z ? 202 : 200);
            jSONObject.put("create", System.currentTimeMillis());
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject2);
            jSONObject.put("msg", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.f27480oI0IIXIo.oIX0oI(jSONObject.toString());
    }

    public void IoOoo() {
    }

    public void Ioxxx(X0o0xo x0o0xo) {
        this.f27480oI0IIXIo = x0o0xo;
    }

    public void O00XxXI(oXoXxOo.II0xO0 iI0xO0) {
        this.f27478XxX0x0xxx = iI0xO0;
    }

    public boolean O0Xx() {
        return this.f27473OxI;
    }

    public void OO(int i, String str) {
        Oxx0xo.oIX0oI(f27470IIX0o, "listener:" + this.f27480oI0IIXIo + ",;;code:" + i);
        X0o0xo x0o0xo = this.f27480oI0IIXIo;
        if (x0o0xo != null) {
            x0o0xo.II0xO0(i, str);
        }
    }

    public void OO0x0xX(int i) {
        this.f27482xoXoI = i;
    }

    public void OOXIxO0() {
    }

    public void XI0oooXX() {
    }

    public void XIo0oOXIx(byte b) {
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0173 A[Catch: JSONException -> 0x0184, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0184, blocks: (B:63:0x015b, B:65:0x0173, B:67:0x0177), top: B:62:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void XX(com.vtrump.vtble.Scale.ScaleInfo r16, com.vtrump.vtble.Scale.ScaleUserInfo r17, byte[] r18, byte[] r19, int r20, int r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.o00.XX(com.vtrump.vtble.Scale.ScaleInfo, com.vtrump.vtble.Scale.ScaleUserInfo, byte[], byte[], int, int, java.lang.String, java.lang.String):void");
    }

    public void XX0xXo(boolean z) {
        this.f27471IIXOooo = z;
    }

    public void Xo0(String str, JSONObject jSONObject) {
    }

    public ArrayList<Integer> XoI0Ixx0() {
        return this.f27476XI0IXoo;
    }

    public void XoX() {
    }

    public void o0(int i, int i2) {
        X0o0xo x0o0xo = this.f27480oI0IIXIo;
        if (x0o0xo != null) {
            x0o0xo.oxoX(i, i2);
        } else {
            Log.e(f27470IIX0o, "onChangSync: listener is null ");
        }
    }

    public void o0xxxXXxX(ArrayList<Integer> arrayList) {
        this.f27476XI0IXoo = arrayList;
    }

    @Override // com.vtrump.vtble.VTDevice
    public void oOoXoXO(String str, String str2, byte[] bArr) {
        super.oOoXoXO(str, str2, bArr);
    }

    public int oX() {
        return this.f27482xoXoI;
    }

    @Override // com.vtrump.vtble.VTDevice
    public void ooOOo0oXI(String str, String str2, byte[] bArr) {
        super.ooOOo0oXI(str, str2, bArr);
    }

    public void ox(JSONObject jSONObject) {
    }

    public void oxXx0IX() {
    }

    @Override // com.vtrump.vtble.VTDevice
    public void x0XOIxOo(String str, String str2) {
        super.x0XOIxOo(str, str2);
    }

    public void x0xO(I0Io i0Io) {
        this.f27481xXxxox0I = i0Io;
    }

    public void xXOx(int i, oXoXxOo.oIX0oI oix0oi) {
        this.f27483xxX = oix0oi;
    }

    public void xoIxX(boolean z) {
        this.f27473OxI = z;
    }

    public boolean xoxXI() {
        return this.f27471IIXOooo;
    }

    public void xxIO(boolean z) {
        this.f27472O0xOxO = z;
    }

    public o00(Context context) {
        super(context);
        this.f27471IIXOooo = false;
        this.f27482xoXoI = 0;
        this.f27475X0IIOO = true;
        this.f27476XI0IXoo = new ArrayList<>();
        oIX0oI oix0oi = new oIX0oI();
        this.f27477XIxXXX0x0 = oix0oi;
        this.f27479o00 = context;
        ooXIXxIX(oix0oi);
    }
}
