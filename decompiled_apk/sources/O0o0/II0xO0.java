package O0o0;

import OoOoXO0.II0XooXoX;
import OoOoXO0.Oxx0xo;
import OoOoXO0.XO;
import OoOoXO0.oOoXoXO;
import OoOoXO0.x0xO0oo;
import Oxx0IOOO.II0xO0;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.fd.aliiot.core.entity.ThingPack;
import com.fd.aliiot.core.entity.WearCommonCommand;
import com.google.gson.Gson;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: Oo, reason: collision with root package name */
    public static final II0xO0 f1468Oo = new II0xO0();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f1470II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Context f1471II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public x0xO0oo f1472OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f1473Oxx0IOOO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Handler f1476oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public String f1477oO;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f1480oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public oxoX f1483xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public MqttAndroidClient f1484xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f1469I0Io = "h5qaTREM0SX";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f1474X0o0xo = "";

    /* renamed from: XO, reason: collision with root package name */
    public String f1475XO = "tcp://iot-06z00c6kgq6t1w4.mqtt.iothub.aliyuncs.com";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f1478oOoXoXO = true;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f1479ooOOo0oXI = 60;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f1481x0XOIxOo = 2;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public final oOoXoXO f1482x0xO0oo = new oIX0oI();

    /* loaded from: classes6.dex */
    public class I0Io implements OoOoXO0.I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ x00X0xoXO.oIX0oI f1485oIX0oI;

        public I0Io(II0xO0 iI0xO0, x00X0xoXO.oIX0oI oix0oi) {
            this.f1485oIX0oI = oix0oi;
        }

        @Override // OoOoXO0.I0Io
        public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
            Log.i("AiotMqtt", "publish failed!");
            x00X0xoXO.oIX0oI oix0oi = this.f1485oIX0oI;
            if (oix0oi != null) {
                oix0oi.onFailure(iI0XooXoX, th);
            }
        }

        @Override // OoOoXO0.I0Io
        public void onSuccess(II0XooXoX iI0XooXoX) {
            Log.i("AiotMqtt", "publish succeed!");
            x00X0xoXO.oIX0oI oix0oi = this.f1485oIX0oI;
            if (oix0oi != null) {
                oix0oi.onSuccess(iI0XooXoX);
            }
        }
    }

    /* renamed from: O0o0.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0032II0xO0 implements OoOoXO0.I0Io {
        public C0032II0xO0() {
        }

        @Override // OoOoXO0.I0Io
        public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
            Log.d("AiotMqtt", "disconnect failed..." + th);
        }

        @Override // OoOoXO0.I0Io
        public void onSuccess(II0XooXoX iI0XooXoX) {
            Log.i("AiotMqtt", "disconnect onSuccess...");
            II0xO0.this.II0xO0();
            oxoX oxox = II0xO0.this.f1483xoIox;
            if (oxox != null) {
                ((II0xO0.oIX0oI) oxox).oIX0oI();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements oOoXoXO {

        /* renamed from: O0o0.II0xO0$oIX0oI$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0033II0xO0 extends TypeReference<ThingPack<String>> {
            public C0033II0xO0(oIX0oI oix0oi) {
            }
        }

        /* renamed from: O0o0.II0xO0$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0034oIX0oI extends TypeReference<ThingPack<WearCommonCommand>> {
            public C0034oIX0oI(oIX0oI oix0oi) {
            }
        }

        public oIX0oI() {
        }

        @Override // OoOoXO0.oOoXoXO
        public void connectionLost(Throwable th) {
            Log.d("AiotMqtt", "connectionLost===> " + th);
            II0xO0.this.II0XooXoX();
            oxoX oxox = II0xO0.this.f1483xoIox;
            if (oxox != null) {
                ((II0xO0.oIX0oI) oxox).oIX0oI();
            }
            II0xO0 iI0xO0 = II0xO0.this;
            if (iI0xO0.f1478oOoXoXO) {
                iI0xO0.Oxx0IOOO();
            }
        }

        @Override // OoOoXO0.oOoXoXO
        public void deliveryComplete(XO xo2) {
            Log.i("AiotMqtt", "deliveryComplete msg delivered");
        }

        @Override // OoOoXO0.oOoXoXO
        public void messageArrived(String str, Oxx0xo oxx0xo) {
            Log.i("AiotMqtt", "messageArrived topic: " + str + ", messageArrived msg");
            oxoX oxox = II0xO0.this.f1483xoIox;
            if (oxox != null) {
                II0XooXoX.XO.II0xO0("AliLpImpl", "topic: " + str + ", messageArrived msg: " + new String(oxx0xo.getPayload()));
                byte[] payload = oxx0xo.getPayload();
                if (str.equals(II0xO0.this.f1477oO + "/service/WearCommonCommand")) {
                    String str2 = new String(payload);
                    Log.w("AiotMqtt", "onIotMessageArrived 穿戴通用服务命令调用" + str2);
                    ThingPack thingPack = (ThingPack) JSON.parseObject(str2, new C0034oIX0oI(this), new Feature[0]);
                    WearCommonCommand wearCommonCommand = (WearCommonCommand) thingPack.getParams();
                    long id = thingPack.getId();
                    II0XooXoX.XO.II0xO0("AiotMqtt", "cmdId ===> " + wearCommonCommand.getCmdIdentifier());
                    String str3 = str.split("thing/")[1];
                    II0XooXoX.XO.II0xO0("AiotMqtt", "message.getId() ==> " + oxx0xo.getId());
                    II0XooXoX.XO.II0xO0("AiotMqtt", "id  ==> " + id);
                    ((II0xO0.oIX0oI) II0xO0.this.f1483xoIox).II0xO0(str3, new Gson().toJson(wearCommonCommand), id);
                    return;
                }
                String str4 = str.split("thing/")[1];
                String str5 = new String(payload);
                Log.w("onId2Arrived 下发Id2数据调用", str5);
                ThingPack thingPack2 = (ThingPack) JSON.parseObject(str5, new C0033II0xO0(this), new Feature[0]);
                ((II0xO0.oIX0oI) II0xO0.this.f1483xoIox).II0xO0(str4, (String) thingPack2.getParams(), thingPack2.getId());
            }
        }
    }

    public II0xO0() {
        HandlerThread handlerThread = new HandlerThread("lp-handler");
        handlerThread.start();
        this.f1476oIX0oI = new Handler(handlerThread.getLooper());
    }

    public static II0xO0 xxIXOIIO() {
        return f1468Oo;
    }

    public void I0Io(String str) {
        this.f1475XO = str;
    }

    public void II0XooXoX() {
        Log.i("AiotMqtt", "主动断开");
        if (this.f1484xxIXOIIO != null) {
            try {
                Log.i("AiotMqtt", "call disconnect...");
                this.f1484xxIXOIIO.disconnect(0L, null, new C0032II0xO0());
                II0xO0();
                Log.i("AiotMqtt", "已断开");
                return;
            } catch (Exception e) {
                Log.e("AiotMqtt", "断开异常--" + e.getMessage());
                e.printStackTrace();
                return;
            }
        }
        II0xO0();
    }

    public final void II0xO0() {
        Log.i("AiotMqtt", "-closeMqtt-释放资源---" + this.f1484xxIXOIIO);
        MqttAndroidClient mqttAndroidClient = this.f1484xxIXOIIO;
        if (mqttAndroidClient != null) {
            mqttAndroidClient.unregisterResources();
            this.f1484xxIXOIIO.setCallback(null);
            this.f1484xxIXOIIO = null;
        }
    }

    public boolean OOXIXo() {
        try {
            return this.f1484xxIXOIIO.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public void Oxx0IOOO() {
        try {
            if (OOXIXo()) {
                II0XooXoX();
            }
            II0XooXoX.XO.II0xO0("AiotMqtt", "userName ==> " + this.f1473Oxx0IOOO);
            II0XooXoX.XO.II0xO0("AiotMqtt", "passWord ==> " + this.f1470II0XooXoX);
            x0xO0oo x0xo0oo = new x0xO0oo();
            this.f1472OOXIXo = x0xo0oo;
            x0xo0oo.OxI(this.f1473Oxx0IOOO);
            this.f1472OOXIXo.OxxIIOOXO(this.f1470II0XooXoX.toCharArray());
            this.f1472OOXIXo.oO(this.f1478oOoXoXO);
            this.f1472OOXIXo.IXxxXO(this.f1479ooOOo0oXI);
            this.f1472OOXIXo.x0xO0oo(true);
            this.f1472OOXIXo.Oxx0xo(1000);
            String str = this.f1474X0o0xo;
            MqttAndroidClient mqttAndroidClient = new MqttAndroidClient(this.f1471II0xO0, this.f1475XO, str);
            this.f1484xxIXOIIO = mqttAndroidClient;
            mqttAndroidClient.setCallback(this.f1482x0xO0oo);
            II0XooXoX.XO.II0xO0("AiotMqtt", "mqttConnectOptions ===> " + this.f1472OOXIXo);
            Log.w("AiotMqtt", "mqtt connect:" + str + ", passwd:" + this.f1470II0XooXoX);
            this.f1484xxIXOIIO.connect(this.f1472OOXIXo, null, new O0o0.I0Io(this));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public final /* synthetic */ void X0o0xo(byte[] bArr, String str, x00X0xoXO.oIX0oI oix0oi) {
        try {
            if (this.f1484xxIXOIIO == null) {
                II0XooXoX.XO.II0xO0("AiotMqtt", "mqtt Android Client is null");
                return;
            }
            if (!OOXIXo()) {
                II0XooXoX.XO.II0xO0("AiotMqtt", "mqttAndroidClient.isConnected() ==> " + OOXIXo());
                return;
            }
            Oxx0xo oxx0xo = new Oxx0xo();
            oxx0xo.setPayload(bArr);
            oxx0xo.setQos(this.f1481x0XOIxOo);
            this.f1484xxIXOIIO.publish(str, oxx0xo, (Object) null, new I0Io(this, oix0oi));
        } catch (MqttException e) {
            Log.e("AiotMqtt", e.toString());
            e.printStackTrace();
        }
    }

    public boolean XO(Context context, oxoX oxox) {
        this.f1471II0xO0 = context;
        this.f1483xoIox = oxox;
        if (!TextUtils.isEmpty(this.f1480oxoX) && !TextUtils.isEmpty(null)) {
            Log.e("AiotMqtt", "device info error");
            II0XooXoX.XO.II0xO0("AiotMqtt", "passWord ==> " + this.f1470II0XooXoX);
        }
        return true;
    }

    public void oxoX(final String str, final byte[] bArr, final x00X0xoXO.oIX0oI oix0oi) {
        this.f1476oIX0oI.post(new Runnable() { // from class: O0o0.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                II0xO0.this.X0o0xo(bArr, str, oix0oi);
            }
        });
    }

    public String xoIox() {
        return this.f1477oO;
    }
}
