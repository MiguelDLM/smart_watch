package Oxx0IOOO;

import II0XooXoX.XO;
import OoOoXO0.II0XooXoX;
import XOo0.I0Io;
import XOo0.X0o0xo;
import android.content.Context;
import android.util.Log;
import com.alibaba.aliagentsdk.api.IAli2LpSender;
import com.alibaba.aliagentsdk.api.IAliLp;
import com.alibaba.aliagentsdk.callback.IConnectCallback;
import com.alibaba.aliagentsdk.callback.IID2DispatchCallback;
import com.alibaba.aliagentsdk.callback.IRegisterCallback;
import com.alibaba.aliagentsdk.callback.ISend2LpCallback;
import com.alibaba.aliagentsdk.callback.ITransCodeDispatchCallback;
import com.alibaba.aliagentsdk.domain.FGSInfoConfig;
import com.alibaba.fastjson.JSON;
import com.fd.aliiot.core.entity.Id2ReplyPack;
import com.fd.aliiot.core.entity.ThingPack;
import com.fd.aliiot.core.entity.WearCommonEvent;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes.dex */
public class II0xO0 implements IAliLp, IAli2LpSender {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static II0xO0 f3013OOXIXo;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public X0o0xo f3015II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final O0o0.II0xO0 f3016II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OIxI0O.I0Io f3017Oxx0IOOO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f3020oIX0oI;

    /* renamed from: xoIox, reason: collision with root package name */
    public XOo0.oxoX f3022xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public OIxI0O.oIX0oI f3023xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public final List<IConnectCallback> f3014I0Io = new ArrayList();

    /* renamed from: oxoX, reason: collision with root package name */
    public final List<IID2DispatchCallback> f3021oxoX = new ArrayList();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final List<ITransCodeDispatchCallback> f3018X0o0xo = new ArrayList();

    /* renamed from: XO, reason: collision with root package name */
    public boolean f3019XO = false;

    /* loaded from: classes.dex */
    public class I0Io implements x00X0xoXO.oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ISend2LpCallback f3024oIX0oI;

        public I0Io(II0xO0 iI0xO0, ISend2LpCallback iSend2LpCallback) {
            this.f3024oIX0oI = iSend2LpCallback;
        }

        @Override // x00X0xoXO.oIX0oI
        public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
            XO.II0xO0("AliLpImpl", "sendTransData onFailure===> " + th);
            ISend2LpCallback iSend2LpCallback = this.f3024oIX0oI;
            if (iSend2LpCallback != null && (th instanceof MqttException)) {
                MqttException mqttException = (MqttException) th;
                iSend2LpCallback.onSendFailed(iI0XooXoX.getMessageId(), mqttException.getMessage(), mqttException.getReasonCode());
            }
        }

        @Override // x00X0xoXO.oIX0oI
        public void onSuccess(II0XooXoX iI0XooXoX) {
            int messageId = iI0XooXoX.getMessageId();
            XO.II0xO0("AliLpImpl", "sendTransData onSuccess===> " + messageId);
            ISend2LpCallback iSend2LpCallback = this.f3024oIX0oI;
            if (iSend2LpCallback != null) {
                iSend2LpCallback.onSendSuccess(messageId);
            }
        }
    }

    /* renamed from: Oxx0IOOO.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046II0xO0 implements x00X0xoXO.oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ISend2LpCallback f3025oIX0oI;

        public C0046II0xO0(II0xO0 iI0xO0, ISend2LpCallback iSend2LpCallback) {
            this.f3025oIX0oI = iSend2LpCallback;
        }

        @Override // x00X0xoXO.oIX0oI
        public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
            XO.II0xO0("AliLpImpl", "sendId2Data onFailure " + th);
            ISend2LpCallback iSend2LpCallback = this.f3025oIX0oI;
            if (iSend2LpCallback != null && (th instanceof MqttException)) {
                MqttException mqttException = (MqttException) th;
                iSend2LpCallback.onSendFailed(iI0XooXoX.getMessageId(), mqttException.getMessage(), mqttException.getReasonCode());
            }
        }

        @Override // x00X0xoXO.oIX0oI
        public void onSuccess(II0XooXoX iI0XooXoX) {
            int messageId = iI0XooXoX.getMessageId();
            XO.II0xO0("AliLpImpl", "sendId2Data success ==> " + messageId);
            ISend2LpCallback iSend2LpCallback = this.f3025oIX0oI;
            if (iSend2LpCallback != null) {
                iSend2LpCallback.onSendSuccess(messageId);
            }
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements O0o0.oxoX {
        public oIX0oI() {
        }

        public void II0xO0(String str, String str2, long j) {
            XO.II0xO0("AliLpImpl", "receiver from lp ==> " + str + " dat ==> " + str2 + "msgId ==> " + j);
            Iterator<IID2DispatchCallback> it = II0xO0.this.f3021oxoX.iterator();
            while (it.hasNext()) {
                it.next().onID2Dispatch(str, str2, j);
            }
            Id2ReplyPack id2ReplyPack = Id2ReplyPack.getInstance();
            id2ReplyPack.setId(String.valueOf(j));
            OIxI0O.oIX0oI oix0oi = II0xO0.this.f3023xxIXOIIO;
            String addData = Id2ReplyPack.addData(id2ReplyPack, "{}");
            String str3 = oix0oi.f1691oIX0oI.f1477oO + "/" + str + "_reply";
            Log.d("Id2Communicate", "上行topic:" + str3);
            Log.d("Id2Communicate", "上行数据:" + addData);
            oix0oi.f1691oIX0oI.oxoX(str3, addData.getBytes(), null);
        }

        public void oIX0oI() {
            XO.II0xO0("AliLpImpl", "onIotDisconnected...");
            II0xO0.this.f3019XO = false;
            Iterator<IConnectCallback> it = II0xO0.this.f3014I0Io.iterator();
            while (it.hasNext()) {
                it.next().onIotDisconnected();
            }
            II0xO0 iI0xO0 = II0xO0.this;
            iI0xO0.f3017Oxx0IOOO = null;
            iI0xO0.f3023xxIXOIIO = null;
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements I0Io.oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ IRegisterCallback f3027oIX0oI;

        public oxoX(II0xO0 iI0xO0, IRegisterCallback iRegisterCallback) {
            this.f3027oIX0oI = iRegisterCallback;
        }

        public void oIX0oI(String str, String str2, String str3, String str4, String str5) {
            XO.II0xO0("AliLpImpl", "register success ==> productKey " + str + " deviceName ==> " + str2 + " timeStamp ==> " + str4 + " sonce ==> " + str5 + " deviceSecret ==> " + str3);
            FGSInfoConfig.sDeviceName = str2;
            FGSInfoConfig.sDeviceSecret = str3;
            FGSInfoConfig.sProductKey = str;
            FGSInfoConfig.sTimeStamp = str4;
            FGSInfoConfig.sonce = str5;
            Oxx0IOOO.oIX0oI.f3028XO = str4;
            IRegisterCallback iRegisterCallback = this.f3027oIX0oI;
            if (iRegisterCallback != null) {
                iRegisterCallback.onRegisterSuccess(str, str2, str3, str4, str5);
            }
        }
    }

    public II0xO0(Context context) {
        this.f3020oIX0oI = context;
        O0o0.II0xO0 xxIXOIIO2 = O0o0.II0xO0.xxIXOIIO();
        this.f3016II0xO0 = xxIXOIIO2;
        xxIXOIIO2.f1478oOoXoXO = false;
        xxIXOIIO2.f1479ooOOo0oXI = 30;
        xxIXOIIO2.f1481x0XOIxOo = 2;
        xxIXOIIO2.I0Io("tcp://iot-06z00c6kgq6t1w4.mqtt.iothub.aliyuncs.com");
        xxIXOIIO2.XO(context, new oIX0oI());
    }

    public static II0xO0 oIX0oI(Context context) {
        if (f3013OOXIXo == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f3013OOXIXo == null) {
                        f3013OOXIXo = new II0xO0(context);
                    }
                } finally {
                }
            }
        }
        return f3013OOXIXo;
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void addId2DispatchCallback(IID2DispatchCallback iID2DispatchCallback) {
        if (!this.f3021oxoX.contains(iID2DispatchCallback)) {
            this.f3021oxoX.add(iID2DispatchCallback);
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void addLpConnectStateCallback(IConnectCallback iConnectCallback) {
        if (!this.f3014I0Io.contains(iConnectCallback)) {
            this.f3014I0Io.add(iConnectCallback);
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void addTransDispatchCallback(ITransCodeDispatchCallback iTransCodeDispatchCallback) {
        if (!this.f3018X0o0xo.contains(iTransCodeDispatchCallback)) {
            this.f3018X0o0xo.add(iTransCodeDispatchCallback);
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void disconnect() {
        this.f3016II0xO0.II0XooXoX();
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void doConnect(String str, String str2, String str3) {
        String str4;
        XO.II0xO0("AliLpImpl", "doConnect ==> productKey " + str + " deviceName ==> " + str2 + " AliAgentImpl.sAuthTimestamp ==> " + Oxx0IOOO.oIX0oI.f3028XO + " deviceSecret == > " + str3);
        O0o0.II0xO0 iI0xO0 = this.f3016II0xO0;
        if (iI0xO0 != null) {
            iI0xO0.f1469I0Io = str;
            iI0xO0.f1480oxoX = str2;
            iI0xO0.f1477oO = "/sys/" + iI0xO0.f1469I0Io + "/" + iI0xO0.f1480oxoX + "/thing";
            String str5 = iI0xO0.f1474X0o0xo;
            if (str5 != null && str5.indexOf("timestamp=") != -1) {
                int indexOf = iI0xO0.f1474X0o0xo.indexOf("timestamp=");
                str4 = iI0xO0.f1474X0o0xo.substring(indexOf + 10, indexOf + 23);
            } else {
                str4 = "1234567890123";
            }
            iI0xO0.f1474X0o0xo = str + "&" + str2 + "|timestamp=" + str4 + ",securemode=2,signmethod=hmacsha1|";
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("&");
            sb.append(str);
            iI0xO0.f1473Oxx0IOOO = sb.toString();
            O0o0.II0xO0 iI0xO02 = this.f3016II0xO0;
            String str6 = Oxx0IOOO.oIX0oI.f3028XO;
            if (iI0xO02.f1474X0o0xo.contains("timestamp=")) {
                int indexOf2 = iI0xO02.f1474X0o0xo.indexOf("timestamp=");
                iI0xO02.f1474X0o0xo = iI0xO02.f1474X0o0xo.substring(0, indexOf2 + 10).concat(str6).concat(iI0xO02.f1474X0o0xo.substring(indexOf2 + 23));
                Log.w("iot mqtt", "new client id = " + iI0xO02.f1474X0o0xo);
            }
            XO.II0xO0("AiotMqtt", "password ===> " + str3);
            iI0xO02.f1470II0XooXoX = str3;
            XO.II0xO0("AliLpImpl", "do connect...");
            this.f3016II0xO0.Oxx0IOOO();
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void doRegister(String str, String str2, String str3, String str4, String str5, IRegisterCallback iRegisterCallback) {
        XOo0.I0Io i0Io = new XOo0.I0Io(this.f3020oIX0oI, null);
        oxoX oxox = new oxoX(this, iRegisterCallback);
        i0Io.f3937oxoX = str;
        i0Io.f3934X0o0xo = str2;
        i0Io.f3935XO = str3;
        i0Io.f3933Oxx0IOOO = str4;
        i0Io.f3931II0XooXoX = str5;
        i0Io.f3936oIX0oI = oxox;
        new Thread(new XOo0.oIX0oI(i0Io)).start();
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public String getThingTopicSegment() {
        O0o0.II0xO0 iI0xO0 = this.f3016II0xO0;
        if (iI0xO0 != null) {
            return iI0xO0.f1477oO;
        }
        return "";
    }

    @Override // com.alibaba.aliagentsdk.api.IAli2LpSender
    public void sendId2Data(String str, String str2, ISend2LpCallback iSend2LpCallback) {
        XO.II0xO0("AliLpImpl", "sendId2Data isIotConnected ==> " + this.f3019XO);
        if (!this.f3019XO) {
            if (iSend2LpCallback != null) {
                iSend2LpCallback.onSendFailed(-1, "IOT not connected.", 0);
                return;
            }
            return;
        }
        XOo0.oxoX oxox = this.f3022xoIox;
        if (oxox != null) {
            C0046II0xO0 c0046II0xO0 = new C0046II0xO0(this, iSend2LpCallback);
            OIxI0O.oIX0oI oix0oi = oxox.f3942oIX0oI;
            oix0oi.getClass();
            String str3 = "thing." + str.replace("/", FileUtils.FILE_EXTENSION_SEPARATOR);
            String str4 = oix0oi.f1691oIX0oI.f1477oO + "/" + str;
            ThingPack thingPack = new ThingPack();
            thingPack.setMethod(str3);
            thingPack.setId(IXX.oIX0oI.f745oIX0oI.incrementAndGet());
            thingPack.setVersion("1.0");
            thingPack.setParams("");
            String jSONString = JSON.toJSONString(thingPack);
            XO.II0xO0("Id2Communicate", "jsonStr ==> " + jSONString);
            String[] split = jSONString.split("\"params\":\"\"");
            String str5 = split[0] + "\"params\":" + str2.toString() + split[1];
            Log.d("Id2Communicate", "上行topic:" + str4);
            Log.d("Id2Communicate", "上行数据:" + str5);
            oix0oi.f1691oIX0oI.oxoX(str4, str5.getBytes(), c0046II0xO0);
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliLp
    public void sendTransData(String str, String str2, ISend2LpCallback iSend2LpCallback) {
        XO.II0xO0("AliLpImpl", "sendTransData isIotConnected ==> " + this.f3019XO);
        if (!this.f3019XO) {
            if (iSend2LpCallback != null) {
                iSend2LpCallback.onSendFailed(-1, "IOT not connected.", 0);
                return;
            }
            return;
        }
        X0o0xo x0o0xo = this.f3015II0XooXoX;
        if (x0o0xo != null) {
            I0Io i0Io = new I0Io(this, iSend2LpCallback);
            WearCommonEvent wearCommonEvent = new WearCommonEvent();
            wearCommonEvent.setEventIdentifier("AlipayRideyard");
            wearCommonEvent.setEventContent(str);
            if (str2 != null) {
                wearCommonEvent.setTrackId(str2);
            }
            OIxI0O.I0Io i0Io2 = x0o0xo.f3940oIX0oI;
            String str3 = i0Io2.f1689II0xO0 + "/event/WearCommonEvent/post";
            ThingPack thingPack = new ThingPack();
            thingPack.setMethod("thing.event.WearCommonEvent.post");
            thingPack.setId(IXX.oIX0oI.f745oIX0oI.incrementAndGet());
            thingPack.setVersion("1.0");
            thingPack.setParams(wearCommonEvent);
            i0Io2.f1690oIX0oI.oxoX(str3, JSON.toJSONString(thingPack).getBytes(), i0Io);
        }
    }
}
