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

/* loaded from: classes.dex */
public class oIX0oI implements IAliAgent, IID2DispatchCallback, IBtDataUploadCallback, ITransCodeDispatchCallback, IHandlerCallback, IConnectCallback {

    /* renamed from: XO, reason: collision with root package name */
    public static String f3028XO;

    /* renamed from: I0Io, reason: collision with root package name */
    public a f3029I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public IAliBt f3030II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public IConnectCallback f3031X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Oxx0IOOO.II0xO0 f3032oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public IFgsStateCheckCallback f3033oxoX;

    /* loaded from: classes.dex */
    public class I0Io implements ISend2BtCallback {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f3035oIX0oI;

        public I0Io(String str) {
            this.f3035oIX0oI = str;
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendFailed(String str, int i) {
            if (this.f3035oIX0oI.equals("service/SendId2Provision")) {
                oIX0oI.this.getClass();
            }
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendSuccess() {
            if (this.f3035oIX0oI.equals("service/SendId2Provision")) {
                oIX0oI.this.getClass();
            }
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements ISend2BtCallback {
        public II0xO0(oIX0oI oix0oi) {
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendFailed(String str, int i) {
            XO.II0xO0("AliAgentImpl", "发送飞鸟盾失败.  msg ==> " + str + " errorCode ==> " + i);
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendSuccess() {
            XO.II0xO0("AliAgentImpl", "发送飞鸟盾成功.");
        }
    }

    /* renamed from: Oxx0IOOO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047oIX0oI implements ISend2BtCallback {
        public C0047oIX0oI() {
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendFailed(String str, int i) {
            XO.II0xO0("AliAgentImpl", "check FGS state send failed..." + str + " code ==> " + i);
            IFgsStateCheckCallback iFgsStateCheckCallback = oIX0oI.this.f3033oxoX;
            if (iFgsStateCheckCallback != null) {
                iFgsStateCheckCallback.onFgsCheckError("send FGS_MSG_TYPE_START_FGS_REQ failed", 0);
            }
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendSuccess() {
            XO.II0xO0("AliAgentImpl", "send FGS state success.");
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements ISend2BtCallback {
        public oxoX(oIX0oI oix0oi) {
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendFailed(String str, int i) {
            XO.II0xO0("AliAgentImpl", "onIotConnected onSendFailed..." + str + " errorCode ==> " + i);
        }

        @Override // com.alibaba.aliagentsdk.callback.ISend2BtCallback
        public void onSendSuccess() {
            XO.II0xO0("AliAgentImpl", "onIotConnected onSendSuccess...");
        }
    }

    public oIX0oI(Context context) {
        this.f3032oIX0oI = Oxx0IOOO.II0xO0.oIX0oI(context);
        this.f3029I0Io = new a(context);
        oIX0oI();
        HandlerThread handlerThread = new HandlerThread("aliAgent");
        handlerThread.start();
        new Handler(handlerThread.getLooper());
    }

    @Override // com.alibaba.aliagentsdk.api.IAliAgent
    public void checkFgsState(IFgsStateCheckCallback iFgsStateCheckCallback) {
        this.f3033oxoX = iFgsStateCheckCallback;
        try {
            byte[] II0xO02 = X0o0xo.II0xO0(Sid.FGS, new JSONStringer().object().key("msg_type").value("FGS_MSG_TYPE_START_FGS_REQ").key("sidver").value(1L).endObject().toString());
            XO.II0xO0("AliAgentImpl", "checkFgsState mAliBt ==> " + this.f3030II0xO0);
            IAliBt iAliBt = this.f3030II0xO0;
            if (iAliBt != null) {
                iAliBt.sendData(II0xO02, new C0047oIX0oI());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliAgent
    public void connectLp() {
        byte[] bArr = new byte[16];
        bArr[0] = 1;
        bArr[1] = 13;
        bArr[2] = 0;
        bArr[3] = 49;
        bArr[4] = 50;
        bArr[5] = 51;
        bArr[6] = 52;
        bArr[7] = 53;
        bArr[8] = 54;
        bArr[9] = 55;
        bArr[10] = 56;
        bArr[11] = 57;
        bArr[12] = 48;
        bArr[13] = 49;
        bArr[14] = 50;
        bArr[15] = 51;
        String valueOf = String.valueOf(System.currentTimeMillis());
        f3028XO = valueOf;
        byte[] bytes = valueOf.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < 13; i++) {
            bArr[i + 3] = bytes[i];
        }
        byte[] II0xO02 = X0o0xo.II0xO0(Sid.FND, II0XooXoX.oxoX.oIX0oI(bArr));
        XO.II0xO0("AliAgentImpl", "connectLp ==> " + this.f3030II0xO0);
        IAliBt iAliBt = this.f3030II0xO0;
        if (iAliBt != null) {
            iAliBt.sendData(II0xO02, new II0xO0(this));
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliAgent
    public void customBtImpl(IAliBt iAliBt) {
        this.f3030II0xO0 = iAliBt;
        XO.II0xO0("AliAgentImpl", "customBtImpl aliBt ====> " + iAliBt);
        if (this.f3030II0xO0 != null) {
            XO.II0xO0("AliAgentImpl", "dev er custom customBtImpl setBtDataUploadCallback");
            this.f3030II0xO0.setBtDataUploadCallback(this);
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliAgent
    public void customGTDDataHandler(IGTDDataHandler iGTDDataHandler) {
        this.f3029I0Io.c = iGTDDataHandler;
    }

    @Override // com.alibaba.aliagentsdk.api.IAliAgent
    public void disconnectLp() {
        this.f3032oIX0oI.f3016II0xO0.II0XooXoX();
    }

    public final void oIX0oI() {
        Oxx0IOOO.II0xO0 iI0xO0 = this.f3032oIX0oI;
        if (iI0xO0 != null) {
            if (!iI0xO0.f3021oxoX.contains(this)) {
                iI0xO0.f3021oxoX.add(this);
            }
            Oxx0IOOO.II0xO0 iI0xO02 = this.f3032oIX0oI;
            if (!iI0xO02.f3018X0o0xo.contains(this)) {
                iI0xO02.f3018X0o0xo.add(this);
            }
            Oxx0IOOO.II0xO0 iI0xO03 = this.f3032oIX0oI;
            if (!iI0xO03.f3014I0Io.contains(this)) {
                iI0xO03.f3014I0Io.add(this);
            }
        }
        IAliBt iAliBt = this.f3030II0xO0;
        if (iAliBt != null) {
            iAliBt.setBtDataUploadCallback(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0115 A[Catch: Exception -> 0x0083, TRY_LEAVE, TryCatch #0 {Exception -> 0x0083, blocks: (B:3:0x0027, B:17:0x00ad, B:20:0x00c3, B:22:0x00cc, B:23:0x00d1, B:26:0x00ea, B:28:0x00ee, B:30:0x00f2, B:32:0x00f6, B:34:0x0115, B:36:0x0079, B:39:0x0086, B:42:0x0090, B:45:0x009a), top: B:2:0x0027 }] */
    @Override // com.alibaba.aliagentsdk.callback.IBtDataUploadCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDataUpload(byte[] r11) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Oxx0IOOO.oIX0oI.onDataUpload(byte[]):void");
    }

    @Override // com.alibaba.aliagentsdk.callback.IHandlerCallback
    public void onFgsCheckFailed(String str, int i) {
        IFgsStateCheckCallback iFgsStateCheckCallback = this.f3033oxoX;
        if (iFgsStateCheckCallback != null) {
            iFgsStateCheckCallback.onFgsCheckError(str, i);
        }
    }

    @Override // com.alibaba.aliagentsdk.callback.IHandlerCallback
    public void onFgsCheckSuccess() {
        IFgsStateCheckCallback iFgsStateCheckCallback = this.f3033oxoX;
        if (iFgsStateCheckCallback != null) {
            iFgsStateCheckCallback.onFgsCheckSuccess();
        }
    }

    @Override // com.alibaba.aliagentsdk.callback.IID2DispatchCallback
    public void onID2Dispatch(String str, String str2, long j) {
        a aVar;
        byte[] bytes;
        XO.II0xO0("AliAgentImpl", "onID2Dispatch ==> topicFragment:" + str);
        XO.II0xO0("AliAgentImpl", "onID2Dispatch ==> data:" + str2);
        XO.II0xO0("AliAgentImpl", "onID2Dispatch ==> msgId:" + j);
        if (this.f3030II0xO0 != null && (aVar = this.f3029I0Io) != null) {
            IGTDDataHandler iGTDDataHandler = aVar.c;
            if (iGTDDataHandler != null) {
                bytes = iGTDDataHandler.handleDispatchId2Data(str, str2);
            } else {
                String json = aVar.f4238a.toJson(new SendData(Sid.GTD, aVar.f4238a.toJson(new ID2Data(str, str2))));
                XO.oIX0oI("send to bt id2 ==> " + json);
                bytes = json.getBytes(StandardCharsets.UTF_8);
            }
            this.f3030II0xO0.sendData(bytes, new I0Io(str));
        }
    }

    @Override // com.alibaba.aliagentsdk.callback.IConnectCallback
    public void onIotConnectFailure(String str, int i) {
        if (this.f3030II0xO0 == null) {
            XO.II0xO0("AliAgentImpl", "onIotConnectFailure ==> " + str + " code " + i);
            return;
        }
        if (4 == i) {
            this.f3030II0xO0.sendData(X0o0xo.oIX0oI((byte) 1), null);
        } else if (32103 == i) {
            this.f3030II0xO0.sendData(X0o0xo.oIX0oI((byte) 2), null);
        }
        IConnectCallback iConnectCallback = this.f3031X0o0xo;
        if (iConnectCallback != null) {
            iConnectCallback.onIotConnectFailure(str, i);
        }
    }

    @Override // com.alibaba.aliagentsdk.callback.IConnectCallback
    public void onIotConnected() {
        XO.II0xO0("AliAgentImpl", "onIotConnected..." + this.f3030II0xO0);
        if (this.f3030II0xO0 != null) {
            this.f3030II0xO0.sendData(X0o0xo.oIX0oI((byte) 0), new oxoX(this));
        }
        IConnectCallback iConnectCallback = this.f3031X0o0xo;
        if (iConnectCallback != null) {
            iConnectCallback.onIotConnected();
        }
    }

    @Override // com.alibaba.aliagentsdk.callback.IConnectCallback
    public void onIotDisconnected() {
        XO.II0xO0("AliAgentImpl", "onIotDisconnected..." + this.f3030II0xO0);
        IConnectCallback iConnectCallback = this.f3031X0o0xo;
        if (iConnectCallback != null) {
            iConnectCallback.onIotDisconnected();
        }
    }

    @Override // com.alibaba.aliagentsdk.callback.ITransCodeDispatchCallback
    public void onTransCodeDispatch(String str, String str2, int i) {
        a aVar;
        XO.II0xO0("AliAgentImpl", "onTransCodeDispatch ==>  data " + str + " message ==> " + str2 + " code ==> " + i);
        if (this.f3030II0xO0 != null && (aVar = this.f3029I0Io) != null) {
            String json = aVar.f4238a.toJson(new SendData(Sid.CCM, str));
            XO.oIX0oI("send to bt trans code ==> " + json);
            this.f3030II0xO0.sendData(json.getBytes(StandardCharsets.UTF_8), null);
        }
    }

    @Override // com.alibaba.aliagentsdk.api.IAliAgent
    public void setLpConnectedCallback(IConnectCallback iConnectCallback) {
        this.f3031X0o0xo = iConnectCallback;
    }
}
