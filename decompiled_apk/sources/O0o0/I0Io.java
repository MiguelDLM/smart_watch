package O0o0;

import II0XooXoX.XO;
import OoOoXO0.II0XooXoX;
import Oxx0IOOO.II0xO0;
import XOo0.X0o0xo;
import android.util.Log;
import com.alibaba.aliagentsdk.callback.IConnectCallback;
import com.fd.aliiot.core.entity.VersionReply;
import com.google.gson.Gson;
import java.util.Iterator;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class I0Io implements OoOoXO0.I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ II0xO0 f1467oIX0oI;

    public I0Io(II0xO0 iI0xO0) {
        this.f1467oIX0oI = iI0xO0;
    }

    @Override // OoOoXO0.I0Io
    public void onFailure(II0XooXoX iI0XooXoX, Throwable th) {
        Log.i("AiotMqtt", "connect failed--" + th.toString());
        oxoX oxox = this.f1467oIX0oI.f1483xoIox;
        if (oxox != null) {
            II0xO0.oIX0oI oix0oi = (II0xO0.oIX0oI) oxox;
            XO.II0xO0("AliLpImpl", "onIotConnectFailure..." + th);
            Oxx0IOOO.II0xO0.this.f3019XO = false;
            if (th instanceof MqttException) {
                MqttException mqttException = (MqttException) th;
                int reasonCode = mqttException.getReasonCode();
                String message = mqttException.getMessage();
                Iterator<IConnectCallback> it = Oxx0IOOO.II0xO0.this.f3014I0Io.iterator();
                while (it.hasNext()) {
                    it.next().onIotConnectFailure(message, reasonCode);
                }
            }
        }
        this.f1467oIX0oI.II0XooXoX();
        th.printStackTrace();
    }

    @Override // OoOoXO0.I0Io
    public void onSuccess(II0XooXoX iI0XooXoX) {
        Log.i("AiotMqtt", "connect succeed");
        oxoX oxox = this.f1467oIX0oI.f1483xoIox;
        if (oxox != null) {
            II0xO0.oIX0oI oix0oi = (II0xO0.oIX0oI) oxox;
            XO.II0xO0("AliLpImpl", "onIotConnected...");
            Oxx0IOOO.II0xO0.this.f3019XO = true;
            Iterator<IConnectCallback> it = Oxx0IOOO.II0xO0.this.f3014I0Io.iterator();
            while (it.hasNext()) {
                it.next().onIotConnected();
            }
            if (Oxx0IOOO.II0xO0.this.f3017Oxx0IOOO == null) {
                XO.II0xO0("AliLpImpl", "准备乘车码链路...");
                Oxx0IOOO.II0xO0 iI0xO0 = Oxx0IOOO.II0xO0.this;
                iI0xO0.f3017Oxx0IOOO = new OIxI0O.I0Io(iI0xO0.f3016II0xO0);
                Oxx0IOOO.II0xO0 iI0xO02 = Oxx0IOOO.II0xO0.this;
                iI0xO02.f3015II0XooXoX = new X0o0xo(iI0xO02.f3017Oxx0IOOO);
            }
            if (Oxx0IOOO.II0xO0.this.f3023xxIXOIIO == null) {
                XO.II0xO0("AliLpImpl", "准备ID2链路...");
                Oxx0IOOO.II0xO0 iI0xO03 = Oxx0IOOO.II0xO0.this;
                OIxI0O.oIX0oI oix0oi2 = new OIxI0O.oIX0oI(iI0xO03.f3016II0xO0);
                iI0xO03.f3023xxIXOIIO = oix0oi2;
                iI0xO03.f3022xoIox = new XOo0.oxoX(oix0oi2);
            }
            String string = Oxx0IOOO.II0xO0.this.f3020oIX0oI.getSharedPreferences("deviceAuthInfo", 0).getString("deviceVersion", null);
            XO.II0xO0("AliLpImpl", "deviceVersion is ==> " + string);
            OIxI0O.I0Io i0Io = Oxx0IOOO.II0xO0.this.f3017Oxx0IOOO;
            i0Io.getClass();
            try {
                String str = i0Io.f1689II0xO0 + "/event/property/post";
                VersionReply versionReply = new VersionReply();
                versionReply.setMethod("thing.event.property.post");
                XO.II0xO0("ThingCommunicate", "reply sdk version code...4.2.2");
                versionReply.setParams(new VersionReply.ParamsBean("Andorid_SDK_Ver:4.2.2 Dev_SDK_Ver:" + string));
                String json = new Gson().toJson(versionReply);
                StringBuilder sb = new StringBuilder();
                sb.append("sdk reply ===> ");
                sb.append(json);
                XO.II0xO0("ThingCommunicate", sb.toString());
                i0Io.f1690oIX0oI.oxoX(str, json.getBytes(), new OIxI0O.II0xO0(i0Io));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
