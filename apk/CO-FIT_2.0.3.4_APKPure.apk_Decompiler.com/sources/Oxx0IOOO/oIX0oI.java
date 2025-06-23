package Oxx0IOOO;

import II0XooXoX.X0o0xo;
import II0XooXoX.XO;
import a.a;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.aliagentsdk.api.IAliAgent;
import com.alibaba.aliagentsdk.api.IAliBt;
import com.alibaba.aliagentsdk.api.IGTDDataHandler;
import com.alibaba.aliagentsdk.callback.IBtDataUploadCallback;
import com.alibaba.aliagentsdk.callback.IConnectCallback;
import com.alibaba.aliagentsdk.callback.IFgsStateCheckCallback;
import com.alibaba.aliagentsdk.callback.IHandlerCallback;
import com.alibaba.aliagentsdk.callback.IID2DispatchCallback;
import com.alibaba.aliagentsdk.callback.ISend2BtCallback;
import com.alibaba.aliagentsdk.callback.ITransCodeDispatchCallback;
import com.alibaba.aliagentsdk.domain.ID2Data;
import com.alibaba.aliagentsdk.domain.SendData;
import com.alibaba.aliagentsdk.domain.Sid;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONStringer;

public class oIX0oI implements IAliAgent, IID2DispatchCallback, IBtDataUploadCallback, ITransCodeDispatchCallback, IHandlerCallback, IConnectCallback {

    /* renamed from: XO  reason: collision with root package name */
    public static String f131XO;

    /* renamed from: I0Io  reason: collision with root package name */
    public a f132I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public IAliBt f133II0xO0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public IConnectCallback f134X0o0xo;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final II0xO0 f135oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public IFgsStateCheckCallback f136oxoX;

    public class I0Io implements ISend2BtCallback {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f138oIX0oI;

        public I0Io(String str) {
            this.f138oIX0oI = str;
        }

        public void onSendFailed(String str, int i) {
            if (this.f138oIX0oI.equals("service/SendId2Provision")) {
                oIX0oI.this.getClass();
            }
        }

        public void onSendSuccess() {
            if (this.f138oIX0oI.equals("service/SendId2Provision")) {
                oIX0oI.this.getClass();
            }
        }
    }

    public class II0xO0 implements ISend2BtCallback {
        public II0xO0(oIX0oI oix0oi) {
        }

        public void onSendFailed(String str, int i) {
            XO.II0xO0("AliAgentImpl", "发送飞鸟盾失败.  msg ==> " + str + " errorCode ==> " + i);
        }

        public void onSendSuccess() {
            XO.II0xO0("AliAgentImpl", "发送飞鸟盾成功.");
        }
    }

    /* renamed from: Oxx0IOOO.oIX0oI$oIX0oI  reason: collision with other inner class name */
    public class C0001oIX0oI implements ISend2BtCallback {
        public C0001oIX0oI() {
        }

        public void onSendFailed(String str, int i) {
            XO.II0xO0("AliAgentImpl", "check FGS state send failed..." + str + " code ==> " + i);
            IFgsStateCheckCallback iFgsStateCheckCallback = oIX0oI.this.f136oxoX;
            if (iFgsStateCheckCallback != null) {
                iFgsStateCheckCallback.onFgsCheckError("send FGS_MSG_TYPE_START_FGS_REQ failed", 0);
            }
        }

        public void onSendSuccess() {
            XO.II0xO0("AliAgentImpl", "send FGS state success.");
        }
    }

    public class oxoX implements ISend2BtCallback {
        public oxoX(oIX0oI oix0oi) {
        }

        public void onSendFailed(String str, int i) {
            XO.II0xO0("AliAgentImpl", "onIotConnected onSendFailed..." + str + " errorCode ==> " + i);
        }

        public void onSendSuccess() {
            XO.II0xO0("AliAgentImpl", "onIotConnected onSendSuccess...");
        }
    }

    public oIX0oI(Context context) {
        this.f135oIX0oI = II0xO0.oIX0oI(context);
        this.f132I0Io = new a(context);
        oIX0oI();
        HandlerThread handlerThread = new HandlerThread("aliAgent");
        handlerThread.start();
        new Handler(handlerThread.getLooper());
    }

    public void checkFgsState(IFgsStateCheckCallback iFgsStateCheckCallback) {
        this.f136oxoX = iFgsStateCheckCallback;
        try {
            byte[] II0xO02 = X0o0xo.II0xO0(Sid.FGS, new JSONStringer().object().key("msg_type").value("FGS_MSG_TYPE_START_FGS_REQ").key("sidver").value(1).endObject().toString());
            XO.II0xO0("AliAgentImpl", "checkFgsState mAliBt ==> " + this.f133II0xO0);
            IAliBt iAliBt = this.f133II0xO0;
            if (iAliBt != null) {
                iAliBt.sendData(II0xO02, new C0001oIX0oI());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void connectLp() {
        byte[] bArr = {1, 13, 0, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 51};
        String valueOf = String.valueOf(System.currentTimeMillis());
        f131XO = valueOf;
        byte[] bytes = valueOf.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < 13; i++) {
            bArr[i + 3] = bytes[i];
        }
        byte[] II0xO02 = X0o0xo.II0xO0(Sid.FND, II0XooXoX.oxoX.oIX0oI(bArr));
        XO.II0xO0("AliAgentImpl", "connectLp ==> " + this.f133II0xO0);
        IAliBt iAliBt = this.f133II0xO0;
        if (iAliBt != null) {
            iAliBt.sendData(II0xO02, new II0xO0(this));
        }
    }

    public void customBtImpl(IAliBt iAliBt) {
        this.f133II0xO0 = iAliBt;
        XO.II0xO0("AliAgentImpl", "customBtImpl aliBt ====> " + iAliBt);
        if (this.f133II0xO0 != null) {
            XO.II0xO0("AliAgentImpl", "dev er custom customBtImpl setBtDataUploadCallback");
            this.f133II0xO0.setBtDataUploadCallback(this);
        }
    }

    public void customGTDDataHandler(IGTDDataHandler iGTDDataHandler) {
        this.f132I0Io.c = iGTDDataHandler;
    }

    public void disconnectLp() {
        this.f135oIX0oI.f119II0xO0.II0XooXoX();
    }

    public final void oIX0oI() {
        II0xO0 iI0xO0 = this.f135oIX0oI;
        if (iI0xO0 != null) {
            if (!iI0xO0.f124oxoX.contains(this)) {
                iI0xO0.f124oxoX.add(this);
            }
            II0xO0 iI0xO02 = this.f135oIX0oI;
            if (!iI0xO02.f121X0o0xo.contains(this)) {
                iI0xO02.f121X0o0xo.add(this);
            }
            II0xO0 iI0xO03 = this.f135oIX0oI;
            if (!iI0xO03.f117I0Io.contains(this)) {
                iI0xO03.f117I0Io.add(this);
            }
        }
        IAliBt iAliBt = this.f133II0xO0;
        if (iAliBt != null) {
            iAliBt.setBtDataUploadCallback(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7 A[Catch:{ Exception -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0115 A[Catch:{ Exception -> 0x0083 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDataUpload(byte[] r11) {
        /*
            r10 = this;
            a.a r0 = r10.f132I0Io
            Oxx0IOOO.II0xO0 r1 = r10.f135oIX0oI
            com.alibaba.aliagentsdk.api.IAliBt r2 = r10.f133II0xO0
            r0.getClass()
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            r3.<init>(r11, r4)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r4 = "从设备端接收的数据:"
            r11.append(r4)
            r11.append(r3)
            java.lang.String r11 = r11.toString()
            java.lang.String r4 = "DefaultDataHandler"
            II0XooXoX.XO.II0xO0(r4, r11)
            com.google.gson.Gson r11 = r0.f244a     // Catch:{ Exception -> 0x0083 }
            java.lang.Class<com.alibaba.aliagentsdk.domain.SendData> r5 = com.alibaba.aliagentsdk.domain.SendData.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r3, r5)     // Catch:{ Exception -> 0x0083 }
            com.alibaba.aliagentsdk.domain.SendData r11 = (com.alibaba.aliagentsdk.domain.SendData) r11     // Catch:{ Exception -> 0x0083 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r3.<init>()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r5 = "sendData ==> "
            r3.append(r5)     // Catch:{ Exception -> 0x0083 }
            r3.append(r11)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0083 }
            II0XooXoX.XO.II0xO0(r4, r3)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r3 = r11.getSid()     // Catch:{ Exception -> 0x0083 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r5.<init>()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r6 = "sid ==> "
            r5.append(r6)     // Catch:{ Exception -> 0x0083 }
            r5.append(r3)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0083 }
            II0XooXoX.XO.II0xO0(r4, r5)     // Catch:{ Exception -> 0x0083 }
            int r5 = r3.hashCode()     // Catch:{ Exception -> 0x0083 }
            r6 = 66541(0x103ed, float:9.3244E-41)
            r7 = 3
            r8 = 2
            r9 = 1
            if (r5 == r6) goto L_0x009a
            r6 = 69554(0x10fb2, float:9.7466E-41)
            if (r5 == r6) goto L_0x0090
            r6 = 69756(0x1107c, float:9.7749E-41)
            if (r5 == r6) goto L_0x0086
            r6 = 70903(0x114f7, float:9.9356E-41)
            if (r5 == r6) goto L_0x0079
            goto L_0x00a4
        L_0x0079:
            java.lang.String r5 = "GTD"
            boolean r5 = r3.equals(r5)     // Catch:{ Exception -> 0x0083 }
            if (r5 == 0) goto L_0x00a4
            r5 = 1
            goto L_0x00a5
        L_0x0083:
            r11 = move-exception
            goto L_0x0119
        L_0x0086:
            java.lang.String r5 = "FND"
            boolean r5 = r3.equals(r5)     // Catch:{ Exception -> 0x0083 }
            if (r5 == 0) goto L_0x00a4
            r5 = 2
            goto L_0x00a5
        L_0x0090:
            java.lang.String r5 = "FGS"
            boolean r5 = r3.equals(r5)     // Catch:{ Exception -> 0x0083 }
            if (r5 == 0) goto L_0x00a4
            r5 = 0
            goto L_0x00a5
        L_0x009a:
            java.lang.String r5 = "CCM"
            boolean r5 = r3.equals(r5)     // Catch:{ Exception -> 0x0083 }
            if (r5 == 0) goto L_0x00a4
            r5 = 3
            goto L_0x00a5
        L_0x00a4:
            r5 = -1
        L_0x00a5:
            if (r5 == 0) goto L_0x0115
            if (r5 == r9) goto L_0x00ee
            if (r5 == r8) goto L_0x00ea
            if (r5 == r7) goto L_0x00c3
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r11.<init>()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r0 = "无法识别的sid："
            r11.append(r0)     // Catch:{ Exception -> 0x0083 }
            r11.append(r3)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0083 }
            android.util.Log.d(r4, r11)     // Catch:{ Exception -> 0x0083 }
            goto L_0x011c
        L_0x00c3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r2.<init>()     // Catch:{ Exception -> 0x0083 }
            O0o0.II0xO0 r3 = r1.f119II0xO0     // Catch:{ Exception -> 0x0083 }
            if (r3 == 0) goto L_0x00cf
            java.lang.String r3 = r3.f15471oO     // Catch:{ Exception -> 0x0083 }
            goto L_0x00d1
        L_0x00cf:
            java.lang.String r3 = ""
        L_0x00d1:
            r2.append(r3)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r3 = "/event/WearCommonEvent/post"
            r2.append(r3)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r11 = r11.getData()     // Catch:{ Exception -> 0x0083 }
            a.b r3 = new a.b     // Catch:{ Exception -> 0x0083 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0083 }
            r1.sendId2Data(r2, r11, r3)     // Catch:{ Exception -> 0x0083 }
            goto L_0x011c
        L_0x00ea:
            r0.a(r11, r1)     // Catch:{ Exception -> 0x0083 }
            goto L_0x011c
        L_0x00ee:
            com.alibaba.aliagentsdk.api.IGTDDataHandler r2 = r0.c     // Catch:{ Exception -> 0x0083 }
            if (r2 == 0) goto L_0x00f6
            r2.handleGTD(r11, r1)     // Catch:{ Exception -> 0x0083 }
            goto L_0x011c
        L_0x00f6:
            java.lang.String r11 = r11.getData()     // Catch:{ Exception -> 0x0083 }
            com.google.gson.Gson r2 = r0.f244a     // Catch:{ Exception -> 0x0083 }
            java.lang.Class<com.alibaba.aliagentsdk.domain.ID2Data> r3 = com.alibaba.aliagentsdk.domain.ID2Data.class
            java.lang.Object r11 = r2.fromJson((java.lang.String) r11, r3)     // Catch:{ Exception -> 0x0083 }
            com.alibaba.aliagentsdk.domain.ID2Data r11 = (com.alibaba.aliagentsdk.domain.ID2Data) r11     // Catch:{ Exception -> 0x0083 }
            java.lang.String r2 = r11.getTopic()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r11 = r11.getMsg()     // Catch:{ Exception -> 0x0083 }
            a.c r3 = new a.c     // Catch:{ Exception -> 0x0083 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0083 }
            r1.sendId2Data(r2, r11, r3)     // Catch:{ Exception -> 0x0083 }
            goto L_0x011c
        L_0x0115:
            r0.a(r11, r1, r2, r10)     // Catch:{ Exception -> 0x0083 }
            goto L_0x011c
        L_0x0119:
            r11.printStackTrace()
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Oxx0IOOO.oIX0oI.onDataUpload(byte[]):void");
    }

    public void onFgsCheckFailed(String str, int i) {
        IFgsStateCheckCallback iFgsStateCheckCallback = this.f136oxoX;
        if (iFgsStateCheckCallback != null) {
            iFgsStateCheckCallback.onFgsCheckError(str, i);
        }
    }

    public void onFgsCheckSuccess() {
        IFgsStateCheckCallback iFgsStateCheckCallback = this.f136oxoX;
        if (iFgsStateCheckCallback != null) {
            iFgsStateCheckCallback.onFgsCheckSuccess();
        }
    }

    public void onID2Dispatch(String str, String str2, long j) {
        a aVar;
        byte[] bArr;
        XO.II0xO0("AliAgentImpl", "onID2Dispatch ==> topicFragment:" + str);
        XO.II0xO0("AliAgentImpl", "onID2Dispatch ==> data:" + str2);
        XO.II0xO0("AliAgentImpl", "onID2Dispatch ==> msgId:" + j);
        if (this.f133II0xO0 != null && (aVar = this.f132I0Io) != null) {
            IGTDDataHandler iGTDDataHandler = aVar.c;
            if (iGTDDataHandler != null) {
                bArr = iGTDDataHandler.handleDispatchId2Data(str, str2);
            } else {
                String json = aVar.f244a.toJson((Object) new SendData(Sid.GTD, aVar.f244a.toJson((Object) new ID2Data(str, str2))));
                XO.oIX0oI("send to bt id2 ==> " + json);
                bArr = json.getBytes(StandardCharsets.UTF_8);
            }
            this.f133II0xO0.sendData(bArr, new I0Io(str));
        }
    }

    public void onIotConnectFailure(String str, int i) {
        if (this.f133II0xO0 == null) {
            XO.II0xO0("AliAgentImpl", "onIotConnectFailure ==> " + str + " code " + i);
            return;
        }
        if (4 == i) {
            this.f133II0xO0.sendData(X0o0xo.oIX0oI((byte) 1), (ISend2BtCallback) null);
        } else if (32103 == i) {
            this.f133II0xO0.sendData(X0o0xo.oIX0oI((byte) 2), (ISend2BtCallback) null);
        }
        IConnectCallback iConnectCallback = this.f134X0o0xo;
        if (iConnectCallback != null) {
            iConnectCallback.onIotConnectFailure(str, i);
        }
    }

    public void onIotConnected() {
        XO.II0xO0("AliAgentImpl", "onIotConnected..." + this.f133II0xO0);
        if (this.f133II0xO0 != null) {
            this.f133II0xO0.sendData(X0o0xo.oIX0oI((byte) 0), new oxoX(this));
        }
        IConnectCallback iConnectCallback = this.f134X0o0xo;
        if (iConnectCallback != null) {
            iConnectCallback.onIotConnected();
        }
    }

    public void onIotDisconnected() {
        XO.II0xO0("AliAgentImpl", "onIotDisconnected..." + this.f133II0xO0);
        IConnectCallback iConnectCallback = this.f134X0o0xo;
        if (iConnectCallback != null) {
            iConnectCallback.onIotDisconnected();
        }
    }

    public void onTransCodeDispatch(String str, String str2, int i) {
        a aVar;
        XO.II0xO0("AliAgentImpl", "onTransCodeDispatch ==>  data " + str + " message ==> " + str2 + " code ==> " + i);
        if (this.f133II0xO0 != null && (aVar = this.f132I0Io) != null) {
            String json = aVar.f244a.toJson((Object) new SendData(Sid.CCM, str));
            XO.oIX0oI("send to bt trans code ==> " + json);
            this.f133II0xO0.sendData(json.getBytes(StandardCharsets.UTF_8), (ISend2BtCallback) null);
        }
    }

    public void setLpConnectedCallback(IConnectCallback iConnectCallback) {
        this.f134X0o0xo = iConnectCallback;
    }
}
