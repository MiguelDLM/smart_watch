package com.vtrump.vtble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.openalliance.ad.constant.aw;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import com.ss.android.download.api.constant.BaseConstants;
import com.vtrump.vtble.Scale.ScaleInfo;
import com.vtrump.vtble.Scale.ScaleUserInfo;
import com.vtrump.vtble.VTBluetoothLeService;
import com.vtrump.vtble.VTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class xoXoI {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static xoXoI f27561IIX0o = null;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final String f27562xXxxox0I = "VTDeviceManager";

    /* renamed from: I0Io, reason: collision with root package name */
    public String f27563I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public oo0xXOI0I f27564II0XooXoX;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f27566IIXOooo;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public BluetoothLeScanner f27569OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Context f27572Oxx0IOOO;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public oO f27574OxxIIOOXO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public oIX0oI f27577XI0IXoo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public String f27580XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public ScanCallback f27581o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f27582oI0IIXIo;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public VTBluetoothLeService f27586ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public BluetoothAdapter f27590xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public II0xO0 f27592xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f27583oIX0oI = 20000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f27565II0xO0 = -100;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f27587oxoX = -100;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f27576X0o0xo = -100;

    /* renamed from: XO, reason: collision with root package name */
    public int f27579XO = 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f27585oOoXoXO = false;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ArrayList<VTDevice> f27588x0XOIxOo = new ArrayList<>();

    /* renamed from: oO, reason: collision with root package name */
    public ArrayList<VTDevice> f27584oO = new ArrayList<>();

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public ArrayList<VTDevice> f27589x0xO0oo = new ArrayList<>();

    /* renamed from: Oo, reason: collision with root package name */
    public ArrayList<X0IIOO> f27570Oo = new ArrayList<>();

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f27567IXxxXO = true;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f27573Oxx0xo = false;

    /* renamed from: xoXoI, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    public Handler f27591xoXoI = new I0Io();

    /* renamed from: OxI, reason: collision with root package name */
    public BluetoothAdapter.LeScanCallback f27571OxI = new oxoX();

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f27568O0xOxO = 100;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public final ServiceConnection f27575X0IIOO = new XO();

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f27578XIxXXX0x0 = true;

    /* renamed from: xxX, reason: collision with root package name */
    public final BroadcastReceiver f27593xxX = new II0XooXoX();

    /* loaded from: classes13.dex */
    public class I0Io extends Handler {
        public I0Io() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                if (xoXoI.this.f27592xxIXOIIO != null) {
                    xoXoI.this.f27592xxIXOIIO.onScanTimeOut();
                }
                xoXoI.this.IIXOooo(false, "timeout");
            } else if (i == 2) {
                xoXoI.this.f27567IXxxXO = true;
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes13.dex */
    public class II0XooXoX extends BroadcastReceiver {
        public II0XooXoX() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("com.vtble.service..EXTRA_ADDRESS");
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "onReceive, action: " + action);
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12 && !xoXoI.this.xOoOIoI()) {
                try {
                    Thread.sleep(1000L);
                    Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "reinit ble");
                    xoXoI xoxoi = xoXoI.this;
                    xoxoi.XOxxooXI(xoxoi.f27572Oxx0IOOO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (stringExtra == null || stringExtra.isEmpty()) {
                Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "onReceive, return for address is null. ");
                return;
            }
            BluetoothDevice I0Io2 = xoXoI.this.I0Io(xxX.OOXIXo(stringExtra));
            VTDevice xxIO2 = xoXoI.this.xxIO(stringExtra);
            if (xxIO2 == null) {
                xxIO2 = xoXoI.this.ox(stringExtra);
            }
            if (xxIO2 == null) {
                return;
            }
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "device name: " + I0Io2.getName() + ", address: " + I0Io2.getAddress());
            try {
                if ("com.vtble.service..ACTION_GATT_CONNECTED".equals(action)) {
                    VTDevice.VTDeviceStatus xoXoI2 = xxIO2.xoXoI();
                    VTDevice.VTDeviceStatus vTDeviceStatus = VTDevice.VTDeviceStatus.STATUS_CONNECTED;
                    if (xoXoI2 != vTDeviceStatus) {
                        xxIO2.X00IoxXI(vTDeviceStatus);
                        if (xoXoI.this.f27592xxIXOIIO != null) {
                            xoXoI.this.f27592xxIXOIIO.onDeviceConnected(xxIO2);
                        }
                    }
                } else if ("com.vtble.service..ACTION_GATT_DISCONNECTED".equals(action)) {
                    String str = xoXoI.f27562xXxxox0I;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onReceive:ACTION_GATT_DISCONNECTED ");
                    sb.append(System.currentTimeMillis());
                    Log.e(str, sb.toString());
                    xoXoI.this.XxX0x0xxx(xxIO2);
                    xxIO2.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_DISCONNECTED);
                    if (xoXoI.this.f27592xxIXOIIO != null) {
                        xoXoI.this.f27592xxIXOIIO.onDeviceDisconnected(xxIO2);
                    }
                } else if ("com.vtble.service..ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
                    Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED");
                    xxIO2.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_SERVICE_DISCOVERED);
                    xoXoI.this.XXoOx0(xxIO2);
                    xoXoI.this.IoXIXo(xxIO2);
                    xxIO2.xxIXOIIO();
                    xoXoI xoxoi2 = xoXoI.this;
                    xoxoi2.oOoXoXO(xxIO2, xoxoi2.f27586ooOOo0oXI.oOoXoXO(xxIO2.Oo().getAddress()));
                    if (xoXoI.this.f27592xxIXOIIO != null) {
                        xoXoI.this.f27592xxIXOIIO.onDeviceServiceDiscovered(xxIO2);
                    } else {
                        Log.d(xoXoI.f27562xXxxox0I, "onReceive: mDMListener is null");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface II0xO0 {
        void onDeviceAdvDiscovered(VTDevice vTDevice);

        void onDeviceConnected(VTDevice vTDevice);

        void onDeviceDisconnected(VTDevice vTDevice);

        void onDeviceDiscovered(VTDevice vTDevice, int i);

        void onDeviceServiceDiscovered(VTDevice vTDevice);

        void onInited();

        void onScanStop();

        void onScanTimeOut();
    }

    /* loaded from: classes13.dex */
    public class Oxx0IOOO implements OXooXo.I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ ScaleInfo f27596I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ String f27597II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ boolean f27598oIX0oI;

        public Oxx0IOOO(boolean z, String str, ScaleInfo scaleInfo) {
            this.f27598oIX0oI = z;
            this.f27597II0xO0 = str;
            this.f27596I0Io = scaleInfo;
        }

        @Override // OXooXo.I0Io
        public void a() {
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "completeScale: err net");
            if (this.f27598oIX0oI) {
                JSONObject jSONObject = new JSONObject();
                try {
                    this.f27596I0Io.IO("");
                    boolean IO2 = xoXoI.OOXIxO0().IO();
                    jSONObject.put("code", IO2 ? this.f27596I0Io.o00() : 4002);
                    jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, IO2 ? this.f27596I0Io.oo(2, "") : new JSONObject());
                    jSONObject.put("msg", IO2 ? "" : "厂商服务不可用");
                    xoXoI.this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // OXooXo.I0Io
        public void a(String str) {
            JSONException e;
            int i;
            if (!this.f27598oIX0oI) {
                Oxx0xo.I0Io("onSuccess ", "needCloudReturn: " + this.f27598oIX0oI);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has(BaseConstants.MARKET_URI_AUTHORITY_DETAIL)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(BaseConstants.MARKET_URI_AUTHORITY_DETAIL);
                        if (jSONObject2.has("deviceInfo")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("deviceInfo");
                            jSONObject3.put("biaData", new JSONObject(this.f27597II0xO0).getJSONObject("data").getString("adv"));
                            jSONObject2.put("deviceInfo", jSONObject3);
                            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject2);
                            str = jSONObject.toString();
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                i = new JSONObject(str).getInt("code");
                try {
                    xoXoI.OOXIxO0().xXoOI00O(i);
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (!xoXoI.this.xoIxX()) {
                    }
                    Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "CloudEnable: true");
                    xoXoI.this.f27577XI0IXoo.oIX0oI(str);
                    return;
                }
            } catch (JSONException e4) {
                e = e4;
                i = 0;
            }
            if (!xoXoI.this.xoIxX() || i == 4001 || i == 4002) {
                Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "CloudEnable: true");
                xoXoI.this.f27577XI0IXoo.oIX0oI(str);
                return;
            }
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "CloudEnable: false");
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("code", this.f27596I0Io.o00());
                jSONObject4.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, this.f27596I0Io.oo(1, ""));
                jSONObject4.put("msg", "");
                xoXoI.this.f27577XI0IXoo.oIX0oI(jSONObject4.toString());
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class X0o0xo implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ BluetoothDevice f27600IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f27601Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ byte[] f27602Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f27603XO;

        public X0o0xo(int i, int i2, BluetoothDevice bluetoothDevice, byte[] bArr) {
            this.f27603XO = i;
            this.f27601Oo = i2;
            this.f27600IXxxXO = bluetoothDevice;
            this.f27602Oxx0xo = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xoXoI.this.f27586ooOOo0oXI == null) {
                Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "service is null");
                return;
            }
            if (this.f27603XO < xoXoI.this.f27565II0xO0) {
                Log.e(xoXoI.f27562xXxxox0I, "run: rssi :" + this.f27603XO + "< mRssiLimit so return");
                return;
            }
            Log.d(xoXoI.f27562xXxxox0I, Thread.currentThread().getName() + " version:" + this.f27601Oo + ",," + this.f27600IXxxXO.getName() + ",address: " + this.f27600IXxxXO.getAddress() + ":::" + xxX.IIXOooo(this.f27602Oxx0xo));
            List<XIxXXX0x0> oIX0oI2 = XIxXXX0x0.oIX0oI(this.f27602Oxx0xo);
            for (int i = 0; i < oIX0oI2.size(); i++) {
                XIxXXX0x0 xIxXXX0x0 = oIX0oI2.get(i);
                if (xoXoI.this.f27585oOoXoXO && xIxXXX0x0 != null && xIxXXX0x0.X0o0xo() == -1 && xIxXXX0x0.oxoX() != null && xoXoI.this.f27570Oo != null) {
                    byte X0o0xo2 = xIxXXX0x0.oxoX().X0o0xo();
                    if (X0o0xo2 == -40) {
                        xoXoI.this.OOXIXo(this.f27600IXxxXO, this.f27602Oxx0xo, xIxXXX0x0, this.f27603XO);
                    } else if (X0o0xo2 == 48) {
                        xoXoI.this.o0(this.f27600IXxxXO, this.f27602Oxx0xo, xIxXXX0x0, this.f27603XO);
                    } else if (X0o0xo2 != 64) {
                        if (X0o0xo2 != -2) {
                            if (X0o0xo2 == -1) {
                                xoXoI.this.II0XooXoX(this.f27600IXxxXO, this.f27603XO, this.f27602Oxx0xo);
                            } else if (X0o0xo2 != 0) {
                            }
                        }
                        xoXoI.this.xo0x(this.f27600IXxxXO, this.f27602Oxx0xo, xIxXXX0x0, this.f27603XO);
                    } else {
                        xoXoI.this.xxX(this.f27600IXxxXO, this.f27602Oxx0xo, xIxXXX0x0, this.f27603XO);
                    }
                }
            }
            if ("HOLTEK".equals(this.f27600IXxxXO.getName()) || "KS_Scale".equals(this.f27600IXxxXO.getName())) {
                xoXoI.this.xoIox(this.f27600IXxxXO, this.f27602Oxx0xo, null);
            }
            if (xoXoI.this.f27585oOoXoXO) {
                if ("HS11".equalsIgnoreCase(this.f27600IXxxXO.getName()) || "HS23".equalsIgnoreCase(this.f27600IXxxXO.getName()) || "HS25".equalsIgnoreCase(this.f27600IXxxXO.getName())) {
                    xoXoI.this.oo0xXOI0I(this.f27600IXxxXO, this.f27602Oxx0xo, oIX0oI2.get(2), this.f27603XO);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class XO implements ServiceConnection {
        public XO() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "onServiceConnected");
            xoXoI.this.f27586ooOOo0oXI = ((VTBluetoothLeService.oIX0oI) iBinder).oIX0oI();
            if (!xoXoI.this.f27586ooOOo0oXI.x0xO0oo()) {
                Oxx0xo.II0xO0(xoXoI.f27562xXxxox0I, "Unable to initialize Bluetooth");
            } else if (xoXoI.this.f27592xxIXOIIO != null) {
                xoXoI.this.f27592xxIXOIIO.onInited();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "onServiceDisconnected");
            xoXoI.this.f27586ooOOo0oXI = null;
        }
    }

    /* loaded from: classes13.dex */
    public interface oIX0oI {
        void oIX0oI(String str);
    }

    /* loaded from: classes13.dex */
    public class oxoX implements BluetoothAdapter.LeScanCallback {
        public oxoX() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            Oxx0xo.oIX0oI(xoXoI.f27562xXxxox0I, "->device: " + bluetoothDevice.getName() + ",rssi:" + i + ",mRssiLimit:" + xoXoI.this.f27565II0xO0);
            if (i >= xoXoI.this.f27565II0xO0) {
                xoXoI.this.xxIXOIIO(bluetoothDevice, i, bArr, Build.VERSION.SDK_INT);
                return;
            }
            Log.d(xoXoI.f27562xXxxox0I, "onLeScan: rssi:" + i + "<-100,return");
        }
    }

    /* loaded from: classes13.dex */
    public class xoIox extends ScanCallback {
        public xoIox() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            super.onScanFailed(i);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            xoXoI.this.xxIXOIIO(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes(), Build.VERSION.SDK_INT);
        }
    }

    /* loaded from: classes13.dex */
    public class xxIXOIIO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ VTDevice f27609XO;

        public xxIXOIIO(VTDevice vTDevice) {
            this.f27609XO = vTDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((VTDeviceToy) this.f27609XO).xxIO();
        }
    }

    public xoXoI() {
        Log.d(f27562xXxxox0I, "vtble, VERSION: 3.7.7");
    }

    public static IntentFilter Io() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.vtble.service..ACTION_GATT_CONNECTED");
        intentFilter.addAction("com.vtble.service..ACTION_GATT_DISCONNECTED");
        intentFilter.addAction("com.vtble.service..ACTION_GATT_SERVICES_DISCOVERED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        return intentFilter;
    }

    public static xoXoI OOXIxO0() {
        if (f27561IIX0o == null) {
            f27561IIX0o = new xoXoI();
        }
        return f27561IIX0o;
    }

    public double I0() {
        return this.f27587oxoX;
    }

    public final BluetoothDevice I0Io(byte[] bArr) {
        return this.f27590xoIox.getRemoteDevice(xxX.O0xOxO(bArr));
    }

    public final void I0X0x0oIo() {
        ArrayList<VTDevice> arrayList = this.f27589x0xO0oo;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        Oxx0xo.oIX0oI(f27562xXxxox0I, "mHistoryDeviceList.size(): " + size);
        for (int i = size + (-1); i >= 0; i--) {
            x0OIX00oO(this.f27589x0xO0oo.get(i));
        }
    }

    public VTDevice I0oOIX(String str) {
        VTDevice vTDevice = null;
        for (int i = 0; i < this.f27584oO.size(); i++) {
            VTDevice vTDevice2 = this.f27584oO.get(i);
            if (vTDevice2.Oo().getAddress().trim().equals(str)) {
                vTDevice = vTDevice2;
            }
        }
        return vTDevice;
    }

    public void I0oOoX(VTDevice vTDevice) {
        String address = vTDevice.Oo().getAddress();
        VTBluetoothLeService vTBluetoothLeService = this.f27586ooOOo0oXI;
        if (vTBluetoothLeService != null) {
            vTBluetoothLeService.X0o0xo(address);
        }
    }

    public final void II0XooXoX(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        oO oOVar;
        II0xO0 iI0xO0;
        for (int i2 = 0; i2 < this.f27570Oo.size(); i2++) {
            X0IIOO x0iioo = this.f27570Oo.get(i2);
            for (int i3 = 0; i3 < XIxXXX0x0().intValue(); i3++) {
                VTDevice O00XxXI2 = O00XxXI(Integer.valueOf(i3));
                if (bluetoothDevice.getAddress().equalsIgnoreCase(O00XxXI2.Oo().getAddress())) {
                    X0IIOO Oxx0xo2 = O00XxXI2.Oxx0xo();
                    if (Oxx0xo2.oxoX() == x0iioo.oxoX() && Oxx0xo2.I0Io() == x0iioo.I0Io() && ((x0iioo.II0xO0() == -1 || x0iioo.II0xO0() == Oxx0xo2.II0xO0()) && (x0iioo.X0o0xo() == -1 || Oxx0xo2.X0o0xo() == x0iioo.X0o0xo()))) {
                        IIXOooo(false, "Reconnect,sb=" + Oxx0xo2.II0xO0() + ",vendor=" + x0iioo.X0o0xo());
                        O00XxXI2.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_DISCOVERED);
                        O00XxXI2.oOXoIIIo(bArr);
                        int intValue = XX0xXo().intValue();
                        oo(O00XxXI2);
                        if (Oxx0xo2.II0xO0() == 29 || Oxx0xo2.II0xO0() == 30) {
                            Log.e(f27562xXxxox0I, "onScanModelIdentifer:alarm");
                            ((O0xOxO) O00XxXI2).xX0IIXIx0(true);
                        }
                        if (Oxx0xo2.II0xO0() == 1 || Oxx0xo2.II0xO0() == 30) {
                            ((O0xOxO) O00XxXI2).ooOx(true);
                        }
                        oO oOVar2 = this.f27574OxxIIOOXO;
                        if (oOVar2 == null || !oOVar2.II0XooXoX()) {
                            if (this.f27592xxIXOIIO != null) {
                                if (((O00XxXI2 instanceof oOoXoXO) || (O00XxXI2 instanceof com.vtrump.vtble.xoIox) || (O00XxXI2 instanceof com.vtrump.vtble.Oxx0IOOO)) && (oOVar = this.f27574OxxIIOOXO) != null) {
                                    String II0xO02 = oOVar.II0xO0();
                                    if (!TextUtils.isEmpty(II0xO02) && !II0xO02.equals(O00XxXI2.Oo().getAddress())) {
                                        return;
                                    }
                                }
                                this.f27592xxIXOIIO.onDeviceDiscovered(O00XxXI2, i);
                            }
                            oO oOVar3 = this.f27574OxxIIOOXO;
                            if (oOVar3 == null || !oOVar3.Oxx0IOOO()) {
                                IIXOooo(false, "ScanModelIdentifer,sb=" + Oxx0xo2.II0xO0() + ",vendor= " + Oxx0xo2.X0o0xo());
                            }
                            XOxIOxOx(O00XxXI2);
                            return;
                        }
                        if (XX0xXo().intValue() > intValue) {
                            String oIX0oI2 = this.f27574OxxIIOOXO.oIX0oI();
                            if (TextUtils.isEmpty(oIX0oI2)) {
                                iI0xO0 = this.f27592xxIXOIIO;
                                if (iI0xO0 == null) {
                                }
                                iI0xO0.onDeviceDiscovered(O00XxXI2, i);
                            } else if (this.f27592xxIXOIIO != null && oIX0oI2.equals(O00XxXI2.oI0IIXIo())) {
                                iI0xO0 = this.f27592xxIXOIIO;
                                iI0xO0.onDeviceDiscovered(O00XxXI2, i);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean IIX0() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f27572Oxx0IOOO.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public final void IIX0o(XIxXXX0x0 xIxXXX0x0, ScaleUserInfo scaleUserInfo) {
        OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(xIxXXX0x0.II0xO0(), 2002, null, null);
        try {
            JSONObject jSONObject = new JSONObject();
            if (II0xO02 == null || II0xO02.xoIox() != 170) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weight", II0xO02.Oxx0xo());
                jSONObject2.put("sn", II0xO02.x0xO0oo());
                jSONObject.put("code", 200);
                jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject2);
                jSONObject.put("msg", "success");
                this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                return;
            }
            if (this.f27567IXxxXO) {
                OxxIIOOXO(xxX.X0o0xo(scaleUserInfo, II0xO02.xxIXOIIO(), II0xO02.Oo(), II0xO02.x0xO0oo(), "", 4, null), Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(scaleUserInfo, II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "comp-acc 10"), true);
            } else {
                jSONObject.put("code", 3001);
                jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new JSONObject());
                jSONObject.put("msg", "Request too frequently!!! request interval is 2s");
                this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final synchronized void IIXOooo(boolean z, String str) {
        BluetoothAdapter bluetoothAdapter;
        UUID[] uuidArr;
        String[] XO2;
        BluetoothAdapter bluetoothAdapter2;
        String str2 = f27562xXxxox0I;
        Oxx0xo.oxoX(str2, "scanLeDevice, enable: " + z + ",reason:" + str);
        try {
            if (z) {
                if (!X00IoxXI()) {
                    BluetoothAdapter bluetoothAdapter3 = this.f27590xoIox;
                    if (bluetoothAdapter3 == null) {
                        Log.d(str2, "scanLeDevice: mBluetoothAdapter ==null ");
                        return;
                    }
                    bluetoothAdapter3.enable();
                }
                if (!this.f27585oOoXoXO) {
                    this.f27591xoXoI.sendEmptyMessageDelayed(1, this.f27583oIX0oI);
                    this.f27585oOoXoXO = true;
                    if (xxX.II0XooXoX()) {
                        if (this.f27581o00 == null) {
                            this.f27581o00 = new xoIox();
                        }
                        ScanSettings XoX2 = XoX();
                        if (this.f27569OOXIXo == null && (bluetoothAdapter2 = this.f27590xoIox) != null) {
                            this.f27569OOXIXo = bluetoothAdapter2.getBluetoothLeScanner();
                        }
                        ScanFilter.Builder builder = new ScanFilter.Builder();
                        oO oOVar = this.f27574OxxIIOOXO;
                        if (oOVar != null) {
                            String II0xO02 = oOVar.II0xO0();
                            if (!TextUtils.isEmpty(II0xO02)) {
                                builder.setDeviceAddress(II0xO02);
                            }
                            String[] XO3 = this.f27574OxxIIOOXO.XO();
                            if (XO3 != null && XO3.length > 0 && !TextUtils.isEmpty(XO3[0])) {
                                builder.setServiceUuid(new ParcelUuid(UUID.fromString(XO3[0])));
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(builder.build());
                        this.f27569OOXIXo.startScan(arrayList, XoX2, this.f27581o00);
                    } else {
                        oO oOVar2 = this.f27574OxxIIOOXO;
                        if (oOVar2 == null || (XO2 = oOVar2.XO()) == null || XO2.length <= 0) {
                            uuidArr = null;
                        } else {
                            uuidArr = new UUID[XO2.length];
                            for (int i = 0; i < XO2.length; i++) {
                                uuidArr[i] = UUID.fromString(XO2[i]);
                            }
                        }
                        this.f27590xoIox.startLeScan(uuidArr, this.f27571OxI);
                    }
                }
            } else {
                this.f27585oOoXoXO = false;
                this.f27591xoXoI.removeMessages(1);
                if (xxX.II0XooXoX()) {
                    if (this.f27569OOXIXo == null && (bluetoothAdapter = this.f27590xoIox) != null) {
                        this.f27569OOXIXo = bluetoothAdapter.getBluetoothLeScanner();
                    }
                    if (this.f27581o00 != null && this.f27569OOXIXo != null && this.f27590xoIox.isEnabled()) {
                        this.f27569OOXIXo.stopScan(this.f27581o00);
                    }
                } else {
                    BluetoothAdapter bluetoothAdapter4 = this.f27590xoIox;
                    if (bluetoothAdapter4 != null && bluetoothAdapter4.isEnabled()) {
                        this.f27590xoIox.stopLeScan(this.f27571OxI);
                    }
                }
                II0xO0 iI0xO0 = this.f27592xxIXOIIO;
                if (iI0xO0 != null) {
                    iI0xO0.onScanStop();
                }
            }
        } catch (Exception e) {
            Log.e(f27562xXxxox0I, "scanLeDevice:err ", e);
        }
    }

    public String IIxOXoOo0() {
        return this.f27580XxX0x0xxx;
    }

    public boolean IO() {
        return this.f27572Oxx0IOOO.getSharedPreferences("vtblesp", 0).getBoolean("isKeyEnable", true);
    }

    public void IO0XoXxO(boolean z) {
        this.f27582oI0IIXIo = z;
    }

    public void IOoo(int i, @NonNull ArrayList<X0IIOO> arrayList) {
        xXxxox0I.oIX0oI().oxoX();
        oIIxXoo(i, arrayList, 0);
    }

    public void IXO(int i) {
        this.f27579XO = i;
    }

    public void IoIOOxIIo(Context context, byte[] bArr, ScaleUserInfo scaleUserInfo) {
        oIX0oI oix0oi;
        this.f27572Oxx0IOOO = context;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 3001);
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new JSONObject());
            if (bArr != null && bArr.length > 0) {
                if (scaleUserInfo == null) {
                    jSONObject.put("code", 4004);
                    jSONObject.put("msg", "userinfo is null");
                    this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                    return;
                }
                if (this.f27577XI0IXoo == null) {
                    jSONObject.put("msg", "DataCallback is null,please invoke setOnDataCallback()");
                    this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                    return;
                }
                if (this.f27572Oxx0IOOO == null) {
                    jSONObject.put("msg", "context is null");
                    this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                    return;
                }
                if (TextUtils.isEmpty(IIxOXoOo0())) {
                    jSONObject.put("msg", "key is null,please invoke setKey()");
                    this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                    return;
                }
                if (!IIX0() && IO()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 4001);
                    jSONObject2.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new ScaleInfo().oo(1, ""));
                    jSONObject2.put("msg", "厂商不存在");
                    this.f27577XI0IXoo.oIX0oI(jSONObject2.toString());
                    return;
                }
                if (bArr.length == 11 && (bArr[0] & 255) == 26 && (bArr[1] & 255) == 65) {
                    xoXoI(bArr, scaleUserInfo);
                    return;
                }
                List<XIxXXX0x0> oIX0oI2 = XIxXXX0x0.oIX0oI(bArr);
                for (int i = 0; i < oIX0oI2.size(); i++) {
                    XIxXXX0x0 xIxXXX0x0 = oIX0oI2.get(i);
                    XI0IXoo oxoX2 = xIxXXX0x0.oxoX();
                    if (xIxXXX0x0.X0o0xo() == -1) {
                        if (oxoX2 == null) {
                            return;
                        }
                        if (oxoX2.X0o0xo() == -40) {
                            oI0IIXIo(xIxXXX0x0, scaleUserInfo);
                        } else {
                            if (oxoX2.X0o0xo() == 48) {
                                X0IIOO oxoX3 = oxoX2.oxoX();
                                if (oxoX3 == null) {
                                    return;
                                }
                                if (oxoX3.II0xO0() == 16 && oxoX3.X0o0xo() == 15) {
                                    IIX0o(xIxXXX0x0, scaleUserInfo);
                                } else {
                                    Oxx0xo.oIX0oI(f27562xXxxox0I, "parseData compat: unkown type");
                                    jSONObject.put("msg", "unkown type");
                                    oix0oi = this.f27577XI0IXoo;
                                }
                            } else {
                                Oxx0xo.oIX0oI(f27562xXxxox0I, "parseData: unkown type");
                                jSONObject.put("msg", "unkown type");
                                oix0oi = this.f27577XI0IXoo;
                            }
                            oix0oi.oIX0oI(jSONObject.toString());
                        }
                    }
                }
                return;
            }
            jSONObject.put("msg", "data is null or length <= 0");
            this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String IoOoo(ScaleUserInfo scaleUserInfo, double d) {
        return Ix0x.II0XooXoX.X0IIOO(1016).XI0IXoo(scaleUserInfo, d, 53237.0d).IIX0o(scaleUserInfo, d, 53237.0d, "bon").oo(2, "bon").toString();
    }

    public void IoXIXo(VTDevice vTDevice) {
        if (vTDevice == null || this.f27589x0xO0oo == null) {
            return;
        }
        if (vTDevice.o00()) {
            I0X0x0oIo();
        } else {
            int oIX0oI2 = oIX0oI(vTDevice.Oo().getAddress());
            if (-1 != oIX0oI2) {
                this.f27589x0xO0oo.set(oIX0oI2, vTDevice);
                this.f27564II0XooXoX.X0o0xo(vTDevice);
                return;
            }
        }
        this.f27589x0xO0oo.add(vTDevice);
        this.f27564II0XooXoX.I0Io(vTDevice);
    }

    public VTDevice Ioxxx(Integer num) {
        return this.f27588x0XOIxOo.get(num.intValue());
    }

    public void Ix00oIoI(JSONObject jSONObject) {
        SharedPreferences.Editor edit = this.f27572Oxx0IOOO.getSharedPreferences("vtblesp", 0).edit();
        edit.putString("deviceInfo", jSONObject.toString());
        edit.commit();
    }

    public void IxIX0I(VTDevice vTDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) {
        bluetoothGattCharacteristic.setValue(bArr);
        this.f27586ooOOo0oXI.Oxx0IOOO(vTDevice.Oo().getAddress(), bluetoothGattCharacteristic, z);
    }

    public boolean O0() {
        return this.f27582oI0IIXIo;
    }

    public VTDevice O00XxXI(Integer num) {
        return this.f27589x0xO0oo.get(num.intValue());
    }

    public void O0IxXx(II0xO0 iI0xO0) {
        this.f27592xxIXOIIO = iI0xO0;
    }

    public boolean O0X() {
        return this.f27573Oxx0xo;
    }

    public VTDevice O0Xx(Integer num) {
        if (num.intValue() < this.f27584oO.size()) {
            return this.f27584oO.get(num.intValue());
        }
        return null;
    }

    public final boolean O0xOxO(X0IIOO x0iioo) {
        ArrayList<X0IIOO> arrayList = this.f27570Oo;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < this.f27570Oo.size(); i++) {
                if (this.f27570Oo.get(i).II0xO0() == -1 || this.f27570Oo.get(i).II0xO0() == x0iioo.II0xO0()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void OIOoIIOIx() {
        this.f27592xxIXOIIO = null;
    }

    public ArrayList<VTDevice> OO() {
        return this.f27584oO;
    }

    public Context OO0x0xX(String str) {
        Context context = this.f27572Oxx0IOOO;
        if (context != null) {
            return context;
        }
        Log.d(f27562xXxxox0I, "getContext: " + str);
        return null;
    }

    public final void OOXIXo(BluetoothDevice bluetoothDevice, byte[] bArr, XIxXXX0x0 xIxXXX0x0, int i) {
        X0IIOO oxoX2;
        VTDevice x0oVar;
        if (!"dr01".equals(bluetoothDevice.getName()) && !"duorui01".equals(bluetoothDevice.getName()) && !"dr".equals(bluetoothDevice.getName()) && !"da".equals(bluetoothDevice.getName())) {
            Oxx0xo.oIX0oI("onScanModeAdvAcc", " return , name:" + bluetoothDevice.getName());
            return;
        }
        if (this.f27586ooOOo0oXI == null || (oxoX2 = xIxXXX0x0.oxoX().oxoX()) == null || !O0xOxO(oxoX2)) {
            return;
        }
        if (oxoX2.II0xO0() == 6) {
            oxoX2 = new X0IIOO((byte) 3, (byte) 3, (byte) 6, (byte) 15);
            x0oVar = new X00IoxXI(bluetoothDevice, this.f27572Oxx0IOOO, xIxXXX0x0);
        } else {
            x0oVar = new x0o(bluetoothDevice, this.f27572Oxx0IOOO, xIxXXX0x0);
        }
        x0oVar.oo0xXOI0I(oxoX2);
        x0oVar.oOXoIIIo(bArr);
        oo(x0oVar);
        x0oVar.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_SERVICE_DISCOVERED);
        II0xO0 iI0xO0 = this.f27592xxIXOIIO;
        if (iI0xO0 != null) {
            iI0xO0.onDeviceAdvDiscovered(x0oVar);
        }
        x0oVar.oxoX(i);
        if (x0oVar instanceof X00IoxXI) {
            X00IoxXI x00IoxXI = (X00IoxXI) x0oVar;
            x00IoxXI.xX0IIXIx0();
            if (x00IoxXI.OX00O0xII()) {
                Oxx0xo.oIX0oI(f27562xXxxox0I, "onScanModeAdvAcc: final weight");
                IIXOooo(false, "ScanModeAdvAcc");
            }
        }
        if (x0oVar instanceof x0o) {
            x0o x0oVar2 = (x0o) x0oVar;
            x0oVar2.xoO0xx0();
            if (x0oVar2.ooOx()) {
                Oxx0xo.oIX0oI(f27562xXxxox0I, "onScanModeAdvAccdr: final weight");
                IIXOooo(false, "ScanModeAdvAccdr");
            }
        }
    }

    public void OX00O0xII(String str, JSONObject jSONObject) {
        Oxx0xo.I0Io("", "cash data request");
        if (jSONObject == null) {
            return;
        }
        OIoxIx.oIX0oI oIX0oI2 = OIoxIx.II0xO0.oxoX().oIX0oI(str);
        if (oIX0oI2 == null) {
            Log.e("getReportByDataId", "dataId is cleared or not support");
            return;
        }
        String Oxx0IOOO2 = oIX0oI2.Oxx0IOOO();
        int optInt = jSONObject.optInt("height");
        double optDouble = jSONObject.optDouble("age");
        int optInt2 = jSONObject.optInt("gender");
        byte[] oxoX2 = oIX0oI2.oxoX();
        o00 o00Var = (o00) xxIO(Oxx0IOOO2);
        if (o00Var.Oxx0xo().II0xO0() == 16) {
            OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(oxoX2, 2002, null, null);
            o00Var.XX(Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "comp-acc 10"), new ScaleUserInfo().II0XooXoX(optDouble).xxIXOIIO(optInt2).xoIox(optInt), II0xO02.xxIXOIIO(), II0xO02.Oo(), II0xO02.oIX0oI(), 1002, "comp-acc 10", "");
            OIoxIx.II0xO0.oxoX().II0xO0();
            Log.i("getReportByDataId", "dataId is cleared");
        }
    }

    public void OoO() {
        this.f27577XI0IXoo = null;
    }

    public boolean Ox0O() {
        return this.f27566IIXOooo;
    }

    public final void Oxx0IOOO(int i, JSONObject jSONObject, String str, oIX0oI oix0oi) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", i);
            jSONObject2.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject);
            jSONObject2.put("msg", str);
            oix0oi.oIX0oI(jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void OxxIIOOXO(String str, ScaleInfo scaleInfo, boolean z) {
        xI();
        new OXooXo.II0xO0(str, new Oxx0IOOO(z, str, scaleInfo)).execute(new Void[0]);
    }

    public boolean X00IoxXI() {
        Context context = this.f27572Oxx0IOOO;
        if (context == null) {
            Log.e(f27562xXxxox0I, "checkBleAvailable: context is null");
            return false;
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            Toast.makeText(this.f27572Oxx0IOOO, "BLE is not supported", 0).show();
            return false;
        }
        BluetoothAdapter adapter = ((BluetoothManager) this.f27572Oxx0IOOO.getSystemService("bluetooth")).getAdapter();
        this.f27590xoIox = adapter;
        if (adapter == null) {
            Toast.makeText(this.f27572Oxx0IOOO, "BLE is not supported", 0).show();
            return false;
        }
        if (xxX.II0XooXoX()) {
            this.f27569OOXIXo = this.f27590xoIox.getBluetoothLeScanner();
        }
        return this.f27590xoIox.isEnabled();
    }

    public final boolean X0IIOO(X0IIOO x0iioo, X0IIOO x0iioo2) {
        if (x0iioo.oxoX() == x0iioo2.oxoX() && x0iioo.I0Io() == x0iioo2.I0Io()) {
            return x0iioo2.II0xO0() == -1 || x0iioo.II0xO0() == x0iioo2.II0xO0();
        }
        return false;
    }

    public void X0xII0I(int i) {
        this.f27565II0xO0 = i;
    }

    public void X0xxXX0(oO oOVar) {
        this.f27574OxxIIOOXO = oOVar;
    }

    public void XI(String str) {
        this.f27563I0Io = str;
        if (TextUtils.isEmpty(str)) {
            Log.e(f27562xXxxox0I, "startConn: mac canot null");
            return;
        }
        VTBluetoothLeService vTBluetoothLeService = this.f27586ooOOo0oXI;
        if (vTBluetoothLeService != null) {
            vTBluetoothLeService.OOXIXo(str, false);
        } else {
            Log.e(f27562xXxxox0I, "startConn: mBluetoothLeService is null,please init again");
        }
    }

    public ArrayList<VTDevice> XI0oooXX() {
        return this.f27589x0xO0oo;
    }

    public String XIXIX(ScaleUserInfo scaleUserInfo, double d) {
        return Ix0x.II0XooXoX.X0IIOO(1019).X00IoxXI(scaleUserInfo, d, 500.0d).IIX0o(scaleUserInfo, d, 500.0d, "sen").oo(2, "sen").toString();
    }

    public void XIXIxO() {
        Oxx0xo.oIX0oI(f27562xXxxox0I, "releaseBleManager");
        oxxXoxO();
        this.f27584oO.clear();
        BroadcastReceiver broadcastReceiver = this.f27593xxX;
        if (broadcastReceiver != null) {
            try {
                Context context = this.f27572Oxx0IOOO;
                if (context != null) {
                    context.unregisterReceiver(broadcastReceiver);
                }
            } catch (Exception unused) {
            }
        }
        this.f27592xxIXOIIO = null;
        XoI0Ixx0();
    }

    public OIoxIx.I0Io XIo0oOXIx() {
        return new OIoxIx.I0Io(this.f27572Oxx0IOOO.getSharedPreferences("vtblesp", 0).getString("deviceInfo", ""));
    }

    public final Integer XIxXXX0x0() {
        return Integer.valueOf(this.f27589x0xO0oo.size());
    }

    public void XOxIOxOx(VTDevice vTDevice) {
        String address = vTDevice.Oo().getAddress();
        Oxx0xo.oIX0oI(f27562xXxxox0I, "connect device: " + address);
        this.f27586ooOOo0oXI.OOXIXo(address, o00(vTDevice));
    }

    public boolean XOxxooXI(Context context) {
        if (context == null) {
            return false;
        }
        if (xOoOIoI()) {
            return true;
        }
        this.f27572Oxx0IOOO = context;
        context.registerReceiver(this.f27593xxX, Io());
        if (!X00IoxXI()) {
            Log.e(f27562xXxxox0I, "ble is not avaiable,startBle failed,please open ble and init again!!! ");
            return false;
        }
        oo0xXOI0I oIX0oI2 = oo0xXOI0I.oIX0oI(context);
        this.f27564II0XooXoX = oIX0oI2;
        if (oIX0oI2 != null && oIX0oI2.II0xO0() != null) {
            this.f27589x0xO0oo.addAll(this.f27564II0XooXoX.II0xO0());
        }
        Intent intent = new Intent(this.f27572Oxx0IOOO, (Class<?>) VTBluetoothLeService.class);
        String str = f27562xXxxox0I;
        Oxx0xo.oIX0oI(str, "Start to bind ble service");
        boolean bindService = this.f27572Oxx0IOOO.bindService(intent, this.f27575X0IIOO, 1);
        if (!bindService) {
            Log.e(str, "startBle: 初始化失败，请重新初始化！！！");
        }
        return bindService;
    }

    public void XX0(boolean z) {
        if (z) {
            if (this.f27590xoIox.isEnabled()) {
                return;
            }
            this.f27590xoIox.enable();
        } else if (this.f27590xoIox.isEnabled()) {
            this.f27590xoIox.disable();
        }
    }

    public Integer XX0xXo() {
        return Integer.valueOf(this.f27588x0XOIxOo.size());
    }

    public boolean XXXI(VTDevice vTDevice, String str, String str2, byte[] bArr, boolean z) {
        VTBluetoothLeService vTBluetoothLeService;
        if (vTDevice == null || vTDevice.xoXoI() == VTDevice.VTDeviceStatus.STATUS_DISCONNECTED || vTDevice.xoXoI() == VTDevice.VTDeviceStatus.STATUS_DISCOVERED || vTDevice.Oo() == null || str == null || str2 == null || (vTBluetoothLeService = this.f27586ooOOo0oXI) == null) {
            return false;
        }
        BluetoothGattCharacteristic II0xO02 = vTBluetoothLeService.II0xO0(vTDevice.Oo().getAddress(), str, str2);
        if (II0xO02 == null) {
            return true;
        }
        II0xO02.setValue(bArr);
        this.f27586ooOOo0oXI.Oxx0IOOO(vTDevice.Oo().getAddress(), II0xO02, z);
        return true;
    }

    public void XXoOx0(VTDevice vTDevice) {
        if (vTDevice == null || vTDevice.Oo() == null) {
            return;
        }
        if (vTDevice.o00()) {
            this.f27584oO.clear();
        } else {
            for (int i = 0; i < this.f27584oO.size(); i++) {
                if (this.f27584oO.get(i).Oo().getAddress().equalsIgnoreCase(vTDevice.Oo().getAddress())) {
                    Oxx0xo.oxoX(f27562xXxxox0I, "replace device name = " + vTDevice.oI0IIXIo() + " address = " + vTDevice.Oo().getAddress());
                    this.f27584oO.set(i, vTDevice);
                    return;
                }
            }
            if (this.f27584oO.contains(vTDevice)) {
                return;
            }
            Oxx0xo.oxoX(f27562xXxxox0I, "setActiveDevice device name = " + vTDevice.oI0IIXIo() + " address = " + vTDevice.Oo().getAddress());
        }
        this.f27584oO.add(vTDevice);
    }

    public final void XoI0Ixx0() {
        try {
            if (this.f27575X0IIOO != null) {
                Oxx0xo.oxoX(f27562xXxxox0I, "unBindBleService");
                this.f27572Oxx0IOOO.unbindService(this.f27575X0IIOO);
                this.f27586ooOOo0oXI = null;
            }
        } catch (IllegalArgumentException unused) {
            Oxx0xo.oxoX(f27562xXxxox0I, "unBindBleService exception.");
        }
    }

    public final ScanSettings XoX() {
        if (!xxX.II0XooXoX()) {
            return null;
        }
        ScanSettings.Builder scanMode = new ScanSettings.Builder().setScanMode(2);
        if (xxX.oI0IIXIo()) {
            scanMode.setCallbackType(1);
            scanMode.setMatchMode(2);
        }
        BluetoothAdapter bluetoothAdapter = this.f27590xoIox;
        if (bluetoothAdapter != null && bluetoothAdapter.isOffloadedScanBatchingSupported()) {
            scanMode.setReportDelay(0L);
        }
        return scanMode.build();
    }

    public void Xx000oIo() {
        VTBluetoothLeService vTBluetoothLeService = this.f27586ooOOo0oXI;
        if (vTBluetoothLeService != null) {
            vTBluetoothLeService.x0XOIxOo();
        }
    }

    public final void XxX0x0xxx(VTDevice vTDevice) {
        for (int intValue = xoxXI().intValue() - 1; intValue >= 0; intValue--) {
            if (O0Xx(Integer.valueOf(intValue)).OxI(vTDevice)) {
                Log.e(f27562xXxxox0I, "removeActiveDevice device name = " + vTDevice.oI0IIXIo() + " address = " + vTDevice.Oo().getAddress());
                this.f27584oO.remove(intValue);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o0(android.bluetooth.BluetoothDevice r18, byte[] r19, com.vtrump.vtble.XIxXXX0x0 r20, int r21) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.xoXoI.o0(android.bluetooth.BluetoothDevice, byte[], com.vtrump.vtble.XIxXXX0x0, int):void");
    }

    public final boolean o00(VTDevice vTDevice) {
        return false;
    }

    public void o0oIxOo(VTDevice vTDevice) {
        String address = vTDevice.Oo().getAddress();
        VTBluetoothLeService vTBluetoothLeService = this.f27586ooOOo0oXI;
        if (vTBluetoothLeService != null) {
            vTBluetoothLeService.oO(address);
        }
    }

    public ArrayList<VTDevice> o0xxxXXxX() {
        return this.f27588x0XOIxOo;
    }

    public void oI(boolean z) {
        this.f27573Oxx0xo = z;
    }

    public final void oI0IIXIo(XIxXXX0x0 xIxXXX0x0, ScaleUserInfo scaleUserInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            byte[] II0xO02 = xIxXXX0x0.II0xO0();
            byte b = II0xO02[1];
            int i = (b >> 6) & 3;
            double d = ((b & Utf8.REPLACEMENT_BYTE) << 8) | (II0xO02[2] & 255);
            if (i == 0) {
                d /= 10.0d;
            } else if (i == 2) {
                d = OxxIIOOXO.ooOOo0oXI(d);
            } else if (i == 3) {
                d = OxxIIOOXO.oO(d);
            }
            double d2 = ((II0xO02[5] & 255) << 8) | (II0xO02[6] & 255);
            if ((II0xO02[0] & 255) == 221) {
                if (!this.f27567IXxxXO) {
                    jSONObject.put("code", 3001);
                    jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new JSONObject());
                    jSONObject.put("msg", "Request too frequently!!! request interval is 2s");
                    this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                    return;
                }
                byte[] OxxIIOOXO2 = xxX.OxxIIOOXO(xxX.I0Io(d, 10));
                OxxIIOOXO(xxX.X0o0xo(scaleUserInfo, new byte[]{-1, -1, 48, 1, 3, 6, 15, 0, 0, 0, 0, 0, 0, TransportLayerPacket.SYNC_WORD, 1, OxxIIOOXO2[0], OxxIIOOXO2[1], OxxIIOOXO2[2], OxxIIOOXO2[3], II0xO02[5], II0xO02[6]}, II0xO02, "", "", 4, null), Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(scaleUserInfo, d, d2, ""), true);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weight", d);
            jSONObject2.put("sn", "");
            jSONObject.put("code", 200);
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject2);
            jSONObject.put("msg", "success");
            this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void oIIxXoo(int i, ArrayList<X0IIOO> arrayList, int i2) {
        this.f27570Oo = arrayList;
        this.f27583oIX0oI = i * 1000;
        ArrayList<VTDevice> arrayList2 = this.f27588x0XOIxOo;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        Oxx0xo.oIX0oI(f27562xXxxox0I, "startScan, connectType: " + i2);
        IXO(i2);
        IIXOooo(true, "startScan");
    }

    public final int oIX0oI(String str) {
        if (this.f27589x0xO0oo == null) {
            return -1;
        }
        for (int i = 0; i < this.f27589x0xO0oo.size(); i++) {
            if (this.f27589x0xO0oo.get(i).Oo().getAddress().equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    public void oOXoIIIo() {
        VTBluetoothLeService vTBluetoothLeService;
        for (int i = 0; i < this.f27589x0xO0oo.size(); i++) {
            VTDevice vTDevice = this.f27589x0xO0oo.get(i);
            if (vTDevice.xoXoI() != VTDevice.VTDeviceStatus.STATUS_SERVICE_DISCOVERED && (vTBluetoothLeService = this.f27586ooOOo0oXI) != null) {
                vTBluetoothLeService.X0o0xo(vTDevice.Oo().getAddress());
            }
        }
    }

    public boolean oOo() {
        BluetoothAdapter bluetoothAdapter = this.f27590xoIox;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public void oOoIIO0(VTDevice vTDevice, String str, String str2, boolean z) {
        VTBluetoothLeService vTBluetoothLeService;
        BluetoothGattCharacteristic II0xO02;
        if (vTDevice == null || vTDevice.xoXoI() == VTDevice.VTDeviceStatus.STATUS_DISCONNECTED || vTDevice.xoXoI() == VTDevice.VTDeviceStatus.STATUS_DISCOVERED || vTDevice.Oo() == null || str == null || str2 == null || (vTBluetoothLeService = this.f27586ooOOo0oXI) == null || (II0xO02 = vTBluetoothLeService.II0xO0(vTDevice.Oo().getAddress(), str, str2)) == null) {
            return;
        }
        this.f27586ooOOo0oXI.xxIXOIIO(vTDevice.Oo().getAddress(), str, II0xO02, z);
    }

    public final void oOoXoXO(VTDevice vTDevice, List<BluetoothGattService> list) {
        if (list == null) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : list) {
            List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
            if (characteristics != null) {
                try {
                    String uuid = bluetoothGattService.getUuid().toString();
                    if (IXxxXO.f27248xoIxX.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it = characteristics.iterator();
                        while (it.hasNext()) {
                            if (IXxxXO.f27235x0xO.equalsIgnoreCase(it.next().getUuid().toString())) {
                                ((VTDeviceToy) vTDevice).oxXx0IX();
                            }
                        }
                    }
                    if (IXxxXO.f27227oxXx0IX.equalsIgnoreCase(uuid)) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                            if (IXxxXO.f27246xo0x.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                                if ((bluetoothGattCharacteristic.getProperties() | 16) > 0) {
                                    Oxx0xo.oIX0oI(f27562xXxxox0I, "setCharacteristicNotification");
                                    ((VTDeviceToy) vTDevice).oxxXoxO(true);
                                    ((VTDeviceToy) vTDevice).XX(true);
                                    ((VTDeviceToy) vTDevice).o0xxxXXxX();
                                }
                            } else if (IXxxXO.f27243xXOx.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                                if ((bluetoothGattCharacteristic.getProperties() | 16) > 0) {
                                    Oxx0xo.oIX0oI(f27562xXxxox0I, "setNotification GSENSOR_DATA");
                                    ((VTDeviceToy) vTDevice).IIxOXoOo0(true);
                                    ((VTDeviceToy) vTDevice).OI0(true);
                                }
                            } else if (IXxxXO.f27197XX0.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                                ((VTDeviceToy) vTDevice).o0(true);
                            }
                        }
                    }
                    if (IXxxXO.f27217oX.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it2 = characteristics.iterator();
                        while (it2.hasNext()) {
                            if (IXxxXO.f27167O0Xx.equalsIgnoreCase(it2.next().getUuid().toString())) {
                                if (vTDevice instanceof VTDeviceToy) {
                                    ((VTDeviceToy) vTDevice).XI0oooXX();
                                }
                                ((VTDeviceToy) vTDevice).XX0xXo();
                            }
                        }
                    }
                    if (IXxxXO.f27143I0oOIX.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it3 = characteristics.iterator();
                        while (it3.hasNext()) {
                            if (IXxxXO.f27251xoxXI.equalsIgnoreCase(it3.next().getUuid().toString()) && (vTDevice instanceof VTDeviceToy)) {
                                ((VTDeviceToy) vTDevice).I0(true);
                                ((VTDeviceToy) vTDevice).xXOx(true);
                                ((VTDeviceToy) vTDevice).xo0x(true);
                                this.f27591xoXoI.post(new xxIXOIIO(vTDevice));
                            }
                        }
                    }
                    if (IXxxXO.f27141I0Io.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it4 = characteristics.iterator();
                        while (it4.hasNext()) {
                            if (IXxxXO.f27228oxoX.equalsIgnoreCase(it4.next().getUuid().toString())) {
                                X0IIOO Oxx0xo2 = vTDevice.Oxx0xo();
                                if (Oxx0xo2.I0Io() == 3 && (vTDevice instanceof com.vtrump.vtble.Oxx0IOOO)) {
                                    ((com.vtrump.vtble.Oxx0IOOO) vTDevice).ooOx(true);
                                    ((com.vtrump.vtble.Oxx0IOOO) vTDevice).oXIO0o0XI();
                                }
                                if (Oxx0xo2.I0Io() == 8 && (vTDevice instanceof com.vtrump.vtble.X0o0xo)) {
                                    ((com.vtrump.vtble.X0o0xo) vTDevice).ooOx(true);
                                    ((com.vtrump.vtble.X0o0xo) vTDevice).OX00O0xII();
                                }
                                if (Oxx0xo2.II0xO0() == 26) {
                                    Log.d(f27562xXxxox0I, "lepu:setNotify ");
                                    if (vTDevice instanceof com.vtrump.vtble.xxIXOIIO) {
                                        ((com.vtrump.vtble.xxIXOIIO) vTDevice).xX0IIXIx0();
                                        ((com.vtrump.vtble.xxIXOIIO) vTDevice).OX00O0xII();
                                    }
                                }
                            }
                        }
                    }
                    if (IXxxXO.f27156IoIOOxIIo.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it5 = characteristics.iterator();
                        while (it5.hasNext()) {
                            if (IXxxXO.f27226oxIIX0o.equalsIgnoreCase(it5.next().getUuid().toString())) {
                                if (vTDevice instanceof com.vtrump.vtble.II0XooXoX) {
                                    Oxx0xo.oIX0oI(f27562xXxxox0I, "findDeviceGattServices: htks");
                                    ((com.vtrump.vtble.II0XooXoX) vTDevice).xoO0xx0(true);
                                }
                                if (vTDevice instanceof x0XOIxOo) {
                                    Oxx0xo.oIX0oI(f27562xXxxox0I, "findDeviceGattServices :okok ");
                                    ((x0XOIxOo) vTDevice).ooOx(true);
                                }
                            }
                        }
                    }
                    if (IXxxXO.f27250xoXoI.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it6 = characteristics.iterator();
                        while (it6.hasNext()) {
                            if (IXxxXO.f27168O0xOxO.equalsIgnoreCase(it6.next().getUuid().toString()) && (vTDevice instanceof com.vtrump.vtble.XO)) {
                                ((com.vtrump.vtble.XO) vTDevice).xX0IIXIx0(true);
                                ((com.vtrump.vtble.XO) vTDevice).IIxOXoOo0();
                            }
                        }
                    }
                    if (IXxxXO.f27191XIXIxO.equalsIgnoreCase(uuid) || IXxxXO.f27162IxIX0I.equalsIgnoreCase(uuid)) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                            if (IXxxXO.f27177OoO.equalsIgnoreCase(bluetoothGattCharacteristic2.getUuid().toString()) || IXxxXO.f27215oOoIIO0.equalsIgnoreCase(bluetoothGattCharacteristic2.getUuid().toString())) {
                                if (vTDevice instanceof OOXIXo) {
                                    ((OOXIXo) vTDevice).ooOx(true);
                                    ((OOXIXo) vTDevice).xoO0xx0();
                                }
                            }
                        }
                    }
                    if (IXxxXO.f27153IXO.equalsIgnoreCase(uuid)) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic3 : characteristics) {
                            if ((vTDevice instanceof oOoXoXO) && IXxxXO.f27161Ix00oIoI.equalsIgnoreCase(bluetoothGattCharacteristic3.getUuid().toString())) {
                                ((oOoXoXO) vTDevice).xoO0xx0(true);
                                ((oOoXoXO) vTDevice).oOo();
                                ((oOoXoXO) vTDevice).oXIO0o0XI();
                            }
                        }
                    }
                    if (IXxxXO.f27187X0xxXX0.equalsIgnoreCase(uuid)) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic4 : characteristics) {
                            String str = f27562xXxxox0I;
                            StringBuilder sb = new StringBuilder();
                            sb.append(vTDevice instanceof com.vtrump.vtble.xoIox);
                            sb.append("   setCharacteristicNotification  ");
                            sb.append(bluetoothGattCharacteristic4.getUuid().toString());
                            Oxx0xo.oIX0oI(str, sb.toString());
                            if ((vTDevice instanceof com.vtrump.vtble.xoIox) && IXxxXO.f27152IO0XoXxO.equalsIgnoreCase(bluetoothGattCharacteristic4.getUuid().toString())) {
                                ((com.vtrump.vtble.xoIox) vTDevice).xoO0xx0(true);
                            }
                        }
                    }
                    if (IXxxXO.f27210oI0IIXIo.equalsIgnoreCase(uuid)) {
                        Iterator<BluetoothGattCharacteristic> it7 = characteristics.iterator();
                        while (it7.hasNext()) {
                            if (IXxxXO.f27182OxxIIOOXO.equalsIgnoreCase(it7.next().getUuid().toString()) && (vTDevice instanceof IoOoX)) {
                                ((IoOoX) vTDevice).Io();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void oXIO0o0XI(byte[] bArr, byte[] bArr2, ScaleUserInfo scaleUserInfo, oIX0oI oix0oi) {
        this.f27577XI0IXoo = oix0oi;
        if (bArr == null || bArr2 == null || scaleUserInfo == null || oix0oi == null) {
            return;
        }
        if (TextUtils.isEmpty(IIxOXoOo0())) {
            Oxx0IOOO(0, new JSONObject(), "key is null,please invoke setKey()", oix0oi);
            return;
        }
        List<XIxXXX0x0> oIX0oI2 = XIxXXX0x0.oIX0oI(bArr);
        for (int i = 0; i < oIX0oI2.size(); i++) {
            XIxXXX0x0 xIxXXX0x0 = oIX0oI2.get(i);
            if (xIxXXX0x0 != null && xIxXXX0x0.X0o0xo() == -1 && xIxXXX0x0.oxoX() != null && this.f27570Oo != null) {
                X0IIOO oxoX2 = xIxXXX0x0.oxoX().oxoX();
                if (xIxXXX0x0.X0o0xo() != -1) {
                    continue;
                } else {
                    if (oxoX2 == null) {
                        return;
                    }
                    if (oxoX2.I0Io() == 3 && oxoX2.II0xO0() == 15) {
                        OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(bArr2, 2004, null, oxoX2);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("weight", II0xO02.Oxx0xo());
                            byte[] bArr3 = new byte[6];
                            System.arraycopy(xIxXXX0x0.II0xO0(), 10, bArr3, 0, 6);
                            jSONObject.put("sn", xxX.OxI(bArr3).toUpperCase());
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("code", 200);
                            jSONObject2.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject);
                            jSONObject2.put("msg", "success");
                            this.f27577XI0IXoo.oIX0oI(jSONObject2.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void oXX0IoI() {
        Oxx0xo.oxoX(f27562xXxxox0I, "stopScan");
        IIXOooo(false, "app stopScan");
    }

    public void oXxOI0oIx(int i, int i2) {
        this.f27587oxoX = i2;
        this.f27576X0o0xo = i;
    }

    public final void oo(VTDevice vTDevice) {
        int i = -1;
        for (int i2 = 0; i2 < this.f27588x0XOIxOo.size(); i2++) {
            if (this.f27588x0XOIxOo.get(i2).Oo().getAddress().equals(vTDevice.Oo().getAddress())) {
                i = i2;
            }
        }
        if (i >= 0) {
            this.f27588x0XOIxOo.remove(i);
        }
        this.f27588x0XOIxOo.add(vTDevice);
    }

    public final void oo0xXOI0I(BluetoothDevice bluetoothDevice, byte[] bArr, XIxXXX0x0 xIxXXX0x0, int i) {
        if (this.f27586ooOOo0oXI != null) {
            X0IIOO x0iioo = new X0IIOO((byte) 3, (byte) 3, (byte) 27, (byte) 15);
            if (O0xOxO(x0iioo)) {
                o0 o0Var = new o0(bluetoothDevice, this.f27572Oxx0IOOO, xIxXXX0x0);
                o0Var.oo0xXOI0I(x0iioo);
                o0Var.oOXoIIIo(bArr);
                oo(o0Var);
                o0Var.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_SERVICE_DISCOVERED);
                XXoOx0(o0Var);
                II0xO0 iI0xO0 = this.f27592xxIXOIIO;
                if (iI0xO0 != null) {
                    iI0xO0.onDeviceAdvDiscovered(o0Var);
                }
                o0Var.oxoX(i);
                o0Var.xoO0xx0();
                if (o0Var.ooOx()) {
                    IIXOooo(false, "VTDeviceScaleAdvHS");
                }
            }
        }
    }

    public double ooOx() {
        return this.f27576X0o0xo;
    }

    public VTDevice ox(String str) {
        for (int i = 0; i < this.f27589x0xO0oo.size(); i++) {
            VTDevice vTDevice = this.f27589x0xO0oo.get(i);
            if (vTDevice.Oo().getAddress().equalsIgnoreCase(str)) {
                return vTDevice;
            }
        }
        return null;
    }

    public void oxIIX0o(VTDevice vTDevice, String str, String str2) {
        VTBluetoothLeService vTBluetoothLeService;
        BluetoothGattCharacteristic II0xO02;
        if (vTDevice == null || vTDevice.xoXoI() == VTDevice.VTDeviceStatus.STATUS_DISCONNECTED || vTDevice.xoXoI() == VTDevice.VTDeviceStatus.STATUS_DISCOVERED || vTDevice.Oo() == null || str == null || str2 == null || (vTBluetoothLeService = this.f27586ooOOo0oXI) == null || (II0xO02 = vTBluetoothLeService.II0xO0(vTDevice.Oo().getAddress(), str, str2)) == null) {
            return;
        }
        this.f27586ooOOo0oXI.XO(vTDevice.Oo().getAddress(), II0xO02);
    }

    public void oxxXoxO() {
        for (int i = 0; i < this.f27584oO.size(); i++) {
            this.f27586ooOOo0oXI.X0o0xo(this.f27584oO.get(i).Oo().getAddress());
        }
    }

    public void x0(oIX0oI oix0oi) {
        this.f27577XI0IXoo = oix0oi;
    }

    public void x0OIX00oO(VTDevice vTDevice) {
        Oxx0xo.oIX0oI(f27562xXxxox0I, "removeHistoryDevice");
        this.f27589x0xO0oo.remove(vTDevice);
        this.f27564II0XooXoX.oxoX(vTDevice);
    }

    public void x0OxxIOxX(boolean z) {
        this.f27566IIXOooo = z;
    }

    public void x0o(boolean z) {
        this.f27578XIxXXX0x0 = z;
    }

    public int x0xO() {
        return this.f27579XO;
    }

    public final void xI() {
        this.f27567IXxxXO = false;
        this.f27591xoXoI.sendEmptyMessageDelayed(2, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public String xI0oxI00(ScaleUserInfo scaleUserInfo, double d, double d2) {
        ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1016).XI0IXoo(scaleUserInfo, d, d2).IIX0o(scaleUserInfo, d, d2, "bonso");
        IIX0o2.oOXoIIIo(scaleUserInfo.II0xO0());
        IIX0o2.xoxXI(scaleUserInfo.I0Io());
        IIX0o2.XX0xXo(scaleUserInfo.oxoX());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(aw.e, -1);
            jSONObject2.put("deviceSubType", -1);
            jSONObject2.put("deviceVendor", -1);
            jSONObject2.put("deviceMac", this.f27590xoIox.getAddress());
            jSONObject2.put("dataScale", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IIX0o2.xII(jSONObject2);
        try {
            BluetoothAdapter bluetoothAdapter = this.f27590xoIox;
            IIX0o2.IO(bluetoothAdapter == null ? "0" : bluetoothAdapter.getAddress());
            jSONObject.put("code", IIX0o2.o00());
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, IIX0o2.oo(2, "bonso"));
            jSONObject.put("msg", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void xII() {
        this.f27590xoIox.disable();
    }

    public String xOOOX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TTDownloadField.TT_VERSION_NAME, "3.7.7");
            jSONObject.put("versionCode", 377);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean xOoOIoI() {
        return this.f27586ooOOo0oXI != null;
    }

    public void xX0IIXIx0(byte[] bArr, byte[] bArr2, ScaleUserInfo scaleUserInfo, oIX0oI oix0oi) {
        JSONObject jSONObject;
        this.f27577XI0IXoo = oix0oi;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!this.f27567IXxxXO) {
            jSONObject.put("code", 3001);
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new JSONObject());
            jSONObject.put("msg", "Request too frequently!!! request interval is 2s");
            this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
            return;
        }
        if (bArr != null && bArr2 != null && scaleUserInfo != null && oix0oi != null) {
            if (TextUtils.isEmpty(IIxOXoOo0())) {
                Oxx0IOOO(0, new JSONObject(), "key is null,please invoke setKey()", oix0oi);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(IIxOXoOo0())) {
                jSONObject2.put("msg", "key is null,please invoke setKey()");
                this.f27577XI0IXoo.oIX0oI(jSONObject2.toString());
                return;
            }
            if (!IIX0() && IO()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 4001);
                jSONObject3.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new ScaleInfo().oo(1, ""));
                jSONObject3.put("msg", "厂商不存在");
                this.f27577XI0IXoo.oIX0oI(jSONObject3.toString());
                return;
            }
            List<XIxXXX0x0> oIX0oI2 = XIxXXX0x0.oIX0oI(bArr);
            for (int i = 0; i < oIX0oI2.size(); i++) {
                XIxXXX0x0 xIxXXX0x0 = oIX0oI2.get(i);
                if (xIxXXX0x0 != null && xIxXXX0x0.X0o0xo() == -1 && xIxXXX0x0.oxoX() != null && this.f27570Oo != null) {
                    X0IIOO oxoX2 = xIxXXX0x0.oxoX().oxoX();
                    if (xIxXXX0x0.X0o0xo() != -1) {
                        continue;
                    } else {
                        if (oxoX2 == null) {
                            return;
                        }
                        if (oxoX2.I0Io() == 3 && oxoX2.II0xO0() == 15) {
                            OIoxIx.X0o0xo II0xO02 = ooXIXxIX.II0xO0(bArr2, 2004, null, oxoX2);
                            ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1006).IIX0o(scaleUserInfo, II0xO02.Oxx0xo(), II0xO02.IXxxXO(), "");
                            byte[] bArr3 = new byte[6];
                            System.arraycopy(xIxXXX0x0.II0xO0(), 10, bArr3, 0, 6);
                            OxxIIOOXO(xxX.X0o0xo(scaleUserInfo, II0xO02.xxIXOIIO(), II0xO02.Oo(), xxX.OxI(bArr3), "", 4, null), IIX0o2, true);
                        }
                    }
                }
            }
        }
    }

    public void xXoOI00O(int i) {
        SharedPreferences.Editor edit = this.f27572Oxx0IOOO.getSharedPreferences("vtblesp", 0).edit();
        if (i == 4001 || i == 4002) {
            edit.putBoolean("isKeyEnable", false);
        } else {
            edit.putBoolean("isKeyEnable", true);
        }
        edit.commit();
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0172, code lost:
    
        if (r12.II0xO0() == 30) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void xo0x(android.bluetooth.BluetoothDevice r10, byte[] r11, com.vtrump.vtble.XIxXXX0x0 r12, int r13) {
        /*
            Method dump skipped, instructions count: 579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vtrump.vtble.xoXoI.xo0x(android.bluetooth.BluetoothDevice, byte[], com.vtrump.vtble.XIxXXX0x0, int):void");
    }

    public final void xoIox(BluetoothDevice bluetoothDevice, byte[] bArr, XIxXXX0x0 xIxXXX0x0) {
        if (this.f27586ooOOo0oXI != null) {
            X0IIOO x0iioo = new X0IIOO((byte) 1, (byte) 3, (byte) 12, (byte) 15);
            if (O0xOxO(x0iioo)) {
                IIXOooo(false, "ScanKS");
                com.vtrump.vtble.II0XooXoX iI0XooXoX = new com.vtrump.vtble.II0XooXoX(bluetoothDevice, this.f27572Oxx0IOOO);
                iI0XooXoX.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_DISCOVERED);
                iI0XooXoX.oo0xXOI0I(x0iioo);
                iI0XooXoX.oOXoIIIo(bArr);
                oo(iI0XooXoX);
                II0xO0 iI0xO0 = this.f27592xxIXOIIO;
                if (iI0xO0 != null) {
                    iI0xO0.onDeviceDiscovered(iI0XooXoX, this.f27568O0xOxO);
                }
                oO oOVar = this.f27574OxxIIOOXO;
                if (oOVar == null || !oOVar.II0XooXoX()) {
                    XOxIOxOx(iI0XooXoX);
                }
            }
        }
    }

    public boolean xoIxX() {
        return this.f27578XIxXXX0x0;
    }

    public void xoO0xx0(String str, ScaleUserInfo scaleUserInfo, oIX0oI oix0oi) {
        this.f27577XI0IXoo = oix0oi;
        if (str == null || str.length() < 5 || scaleUserInfo == null || oix0oi == null) {
            return;
        }
        if (TextUtils.isEmpty(IIxOXoOo0())) {
            Oxx0IOOO(0, new JSONObject(), "key is null,please invoke setKey()", oix0oi);
            return;
        }
        OIoxIx.X0o0xo oIX0oI2 = ooXIXxIX.oIX0oI(xxX.xoXoI(str.replace(HelpFormatter.DEFAULT_OPT_PREFIX, "")), 2002);
        if (!this.f27567IXxxXO) {
            Oxx0IOOO(3001, new JSONObject(), "Request too frequently!!! request interval is 2s", oix0oi);
            return;
        }
        ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1002).IIX0o(scaleUserInfo, oIX0oI2.Oxx0xo(), oIX0oI2.IXxxXO(), "comp-acc 10");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biaData", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IIX0o2.xII(jSONObject);
        if (!IIX0()) {
            if (IO()) {
                Oxx0IOOO(IIX0o2.o00(), IIX0o2.oo(2, ""), "网络不可用", oix0oi);
                return;
            } else {
                Oxx0IOOO(4001, new JSONObject(), "厂商不存在", oix0oi);
                return;
            }
        }
        String X0o0xo2 = xxX.X0o0xo(scaleUserInfo, oIX0oI2.xxIXOIIO(), oIX0oI2.Oo(), oIX0oI2.x0xO0oo(), "", 4, null);
        if (!xoIxX() && IO()) {
            Oxx0IOOO(IIX0o2.o00(), IIX0o2.oo(2, ""), "", oix0oi);
        }
        OxxIIOOXO(X0o0xo2, IIX0o2, this.f27578XIxXXX0x0);
    }

    public final void xoXoI(byte[] bArr, ScaleUserInfo scaleUserInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = bArr[2] & 255;
            double d = (bArr[5] & 255) | ((bArr[4] & 255) << 8);
            int i2 = ((bArr[6] & 255) << 24) | ((bArr[7] & 255) << 16) | ((bArr[8] & 255) << 8) | (bArr[9] & 255);
            double pow = d / Math.pow(10.0d, (bArr[3] >> 4) & 15);
            if (i == 170) {
                if (!this.f27567IXxxXO) {
                    jSONObject.put("code", 3001);
                    jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, new JSONObject());
                    jSONObject.put("msg", "Request too frequently!!! request interval is 2s");
                    this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
                    return;
                }
                byte b = bArr[0];
                byte b2 = bArr[1];
                byte[] xoIox2 = xxX.xoIox(xxX.I0Io(pow, 10));
                byte[] bArr2 = {-1, -2, b, b2, 0, 0, 0, 0, 0, 0, TransportLayerPacket.SYNC_WORD, 16, xoIox2[0], xoIox2[1], bArr[6], bArr[7], bArr[8], bArr[9]};
                ScaleInfo IIX0o2 = Ix0x.II0XooXoX.X0IIOO(1004).XIxXXX0x0(new ScaleUserInfo().II0XooXoX(scaleUserInfo.II0xO0()).xxIXOIIO(scaleUserInfo.I0Io()).xoIox(scaleUserInfo.oxoX()), pow, i2, 0, 0, 0, 0, 0, false).IIX0o(scaleUserInfo, pow, i2, "lepu api");
                String X0o0xo2 = xxX.X0o0xo(scaleUserInfo, bArr2, bArr, "", "", 4, null);
                x0o(true);
                OxxIIOOXO(X0o0xo2, IIX0o2, true);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weight", pow);
            jSONObject2.put("sn", "");
            jSONObject.put("code", 200);
            jSONObject.put(BaseConstants.MARKET_URI_AUTHORITY_DETAIL, jSONObject2);
            jSONObject.put("msg", "success");
            this.f27577XI0IXoo.oIX0oI(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Integer xoxXI() {
        return Integer.valueOf(this.f27584oO.size());
    }

    public void xx0X0() {
        this.f27590xoIox.enable();
    }

    public VTDevice xxIO(String str) {
        for (int i = 0; i < this.f27588x0XOIxOo.size(); i++) {
            VTDevice vTDevice = this.f27588x0XOIxOo.get(i);
            if (vTDevice.Oo().getAddress().equalsIgnoreCase(str)) {
                return vTDevice;
            }
        }
        return null;
    }

    public final void xxIXOIIO(BluetoothDevice bluetoothDevice, int i, byte[] bArr, int i2) {
        this.f27591xoXoI.post(new X0o0xo(i, i2, bluetoothDevice, bArr));
    }

    public void xxOXOOoIX(@NonNull String str) {
        this.f27580XxX0x0xxx = str;
    }

    public final void xxX(BluetoothDevice bluetoothDevice, byte[] bArr, XIxXXX0x0 xIxXXX0x0, int i) {
        Oxx0xo.oIX0oI(f27562xXxxox0I, "onScanModeAdvFat10");
        if (this.f27586ooOOo0oXI != null) {
            X0IIOO x0iioo = new X0IIOO((byte) 3, (byte) 3, (byte) 10, (byte) 15);
            if (O0xOxO(x0iioo)) {
                XOxIOxOx xOxIOxOx = new XOxIOxOx(bluetoothDevice, this.f27572Oxx0IOOO, xIxXXX0x0);
                xOxIOxOx.oo0xXOI0I(x0iioo);
                xOxIOxOx.oOXoIIIo(bArr);
                oo(xOxIOxOx);
                xOxIOxOx.X00IoxXI(VTDevice.VTDeviceStatus.STATUS_SERVICE_DISCOVERED);
                XXoOx0(xOxIOxOx);
                II0xO0 iI0xO0 = this.f27592xxIXOIIO;
                if (iI0xO0 != null) {
                    iI0xO0.onDeviceAdvDiscovered(xOxIOxOx);
                }
                xOxIOxOx.oxoX(i);
                xOxIOxOx.OX00O0xII();
                if (xOxIOxOx.xoO0xx0()) {
                    IIXOooo(false, "ScanModeAdvFat10");
                }
            }
        }
    }
}
