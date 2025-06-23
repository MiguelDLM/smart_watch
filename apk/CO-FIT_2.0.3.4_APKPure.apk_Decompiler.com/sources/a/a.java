package a;

import II0XooXoX.X0o0xo;
import II0XooXoX.XO;
import II0XooXoX.oxoX;
import Oxx0IOOO.II0xO0;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.aliagentsdk.api.IAli2LpSender;
import com.alibaba.aliagentsdk.api.IAliBtSender;
import com.alibaba.aliagentsdk.api.IGTDDataHandler;
import com.alibaba.aliagentsdk.callback.IHandlerCallback;
import com.alibaba.aliagentsdk.callback.IRegisterCallback;
import com.alibaba.aliagentsdk.callback.ISend2BtCallback;
import com.alibaba.aliagentsdk.domain.FGSInfoConfig;
import com.alibaba.aliagentsdk.domain.SendData;
import com.alibaba.aliagentsdk.domain.Sid;
import com.baidu.ar.constants.HttpConstants;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Gson f244a = new Gson();
    public final Context b;
    public IGTDDataHandler c;

    /* renamed from: a.a$a  reason: collision with other inner class name */
    public class C0002a implements ISend2BtCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IHandlerCallback f245a;

        public C0002a(a aVar, IHandlerCallback iHandlerCallback) {
            this.f245a = iHandlerCallback;
        }

        public void onSendFailed(String str, int i) {
            IHandlerCallback iHandlerCallback = this.f245a;
            if (iHandlerCallback != null) {
                iHandlerCallback.onFgsCheckFailed("send FGS_MSG_TYPE_START_LP_AUTH_REQ failed", 0);
            }
        }

        public void onSendSuccess() {
            XO.II0xO0("DefaultDataHandler", "check FGS send success...");
        }
    }

    public class b implements ISend2BtCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IHandlerCallback f246a;

        public b(a aVar, IHandlerCallback iHandlerCallback) {
            this.f246a = iHandlerCallback;
        }

        public void onSendFailed(String str, int i) {
            IHandlerCallback iHandlerCallback = this.f246a;
            iHandlerCallback.onFgsCheckFailed("send 2 bt device failed :" + str, i);
        }

        public void onSendSuccess() {
            this.f246a.onFgsCheckSuccess();
        }
    }

    public class c implements IRegisterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final IAliBtSender f247a;
        public final IAli2LpSender b;
        public final IHandlerCallback c;

        /* renamed from: a.a$c$a  reason: collision with other inner class name */
        public class C0003a implements ISend2BtCallback {
            public C0003a() {
            }

            public void onSendFailed(String str, int i) {
                IHandlerCallback iHandlerCallback = c.this.c;
                if (iHandlerCallback != null) {
                    iHandlerCallback.onFgsCheckFailed("send FGS_MSG_TYPE_DS_DOWNLOAD_REQ failed", 0);
                }
            }

            public void onSendSuccess() {
            }
        }

        public c(a aVar, IAli2LpSender iAli2LpSender, IAliBtSender iAliBtSender, IHandlerCallback iHandlerCallback) {
            this.b = iAli2LpSender;
            this.f247a = iAliBtSender;
            this.c = iHandlerCallback;
        }

        public void onRegisterFailed(String str, int i) {
            IHandlerCallback iHandlerCallback = this.c;
            if (iHandlerCallback != null) {
                iHandlerCallback.onFgsCheckFailed("register failed : " + str, 1);
            }
        }

        public void onRegisterSuccess(String str, String str2, String str3, String str4, String str5) {
            try {
                this.f247a.sendData(FGSInfoConfig.fgs2Byte(str2, str3, str, str4, str5), new C0003a());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public a(Context context) {
        this.b = context;
    }

    public final void a(SendData sendData, II0xO0 iI0xO0) {
        try {
            String substring = sendData.getData().substring(4);
            XO.oIX0oI("sourceDat ==> " + substring);
            String str = new String(oxoX.II0xO0(substring));
            Log.d("DefaultDataHandler", "decodeData string " + str);
            XO.II0xO0("DefaultDataHandler", "resData2 ==> " + str);
            String substring2 = str.substring(0, 11);
            String substring3 = str.substring(11);
            String substring4 = substring3.substring(substring3.length() + -40);
            String substring5 = substring3.substring(0, substring3.length() - 40);
            XO.II0xO0("DefaultDataHandler", "passWd ==>   " + substring4);
            XO.II0xO0("DefaultDataHandler", "productKey ==>   " + substring2);
            XO.II0xO0("DefaultDataHandler", "deviceName ==>   " + substring5);
            if (iI0xO0 != null) {
                iI0xO0.doConnect(substring2, substring5, substring4);
            }
        } catch (Exception e) {
            Log.e("DefaultDataHandler", "处理接收飞鸟盾数据异常");
            e.printStackTrace();
        }
    }

    public final void a(SendData sendData, II0xO0 iI0xO0, IAliBtSender iAliBtSender, IHandlerCallback iHandlerCallback) {
        String str;
        IAliBtSender iAliBtSender2 = iAliBtSender;
        IHandlerCallback iHandlerCallback2 = iHandlerCallback;
        try {
            JSONObject jSONObject = new JSONObject(sendData.getData());
            String string = jSONObject.getString("msg_type");
            XO.II0xO0("DefaultDataHandler", "FGS msg_type:" + string);
            if (string.equals("FGS_MSG_TYPE_START_FGS_RESP")) {
                String string2 = jSONObject.getString("tripplestatus");
                String string3 = jSONObject.getString("sdk_ver");
                str = "";
                this.b.getSharedPreferences("deviceAuthInfo", 0).edit().putString("deviceVersion", string3).apply();
                XO.II0xO0("DefaultDataHandler", "DeviceVersion ==> " + string3);
                Log.d("DefaultDataHandler", "trippleStatus:" + string2);
                String string4 = jSONObject.getString("sidver");
                Log.d("DefaultDataHandler", "sidver:" + string4);
                if (string2.equals("needfetch")) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    try {
                        iAliBtSender2.sendData(X0o0xo.II0xO0(Sid.FGS, new JSONStringer().object().key("msg_type").value("FGS_MSG_TYPE_START_LP_AUTH_REQ").key("timeStamp").value(valueOf).key("sidver").value(1).key("message").value("success").endObject().toString()), new C0002a(this, iHandlerCallback2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    FGSInfoConfig.sTimeStamp = valueOf;
                } else if (iHandlerCallback2 != null) {
                    iHandlerCallback.onFgsCheckSuccess();
                }
            } else {
                str = "";
            }
            if (string.equals("FGS_MSG_TYPE_START_LP_AUTH_RESP")) {
                String string5 = jSONObject.getString("productKey");
                String string6 = jSONObject.getString("deviceName");
                String string7 = jSONObject.getString("timeStamp");
                String string8 = jSONObject.getString(HttpConstants.SIGN);
                jSONObject.getString("signmethod");
                String string9 = jSONObject.getString("sonce");
                jSONObject.getString("ver");
                Log.d("DefaultDataHandler", "productKey " + string5);
                Log.d("DefaultDataHandler", "deviceName " + string6);
                Log.d("DefaultDataHandler", "timestamp " + string7);
                Log.d("DefaultDataHandler", "sign " + string8);
                Log.d("DefaultDataHandler", "sonce " + string9);
                XO.II0xO0("DefaultDataHandler", "FGSInfoConfig.sDeviceName ==> " + FGSInfoConfig.sDeviceName);
                XO.II0xO0("DefaultDataHandler", "FGSInfoConfig.sDeviceSecret ==> " + FGSInfoConfig.sDeviceSecret);
                XO.II0xO0("DefaultDataHandler", "FGSInfoConfig.sProductKey ==> " + FGSInfoConfig.sProductKey);
                if (TextUtils.isEmpty(FGSInfoConfig.sDeviceName) || !FGSInfoConfig.sDeviceName.equals(string6) || TextUtils.isEmpty(FGSInfoConfig.sDeviceSecret) || TextUtils.isEmpty(FGSInfoConfig.sProductKey) || !FGSInfoConfig.sProductKey.equals(string5)) {
                    FGSInfoConfig.sDeviceName = str;
                    FGSInfoConfig.sDeviceSecret = str;
                    FGSInfoConfig.sProductKey = str;
                    XO.II0xO0("DefaultDataHandler", "注册设备...");
                    iI0xO0.doRegister(string5, string6, string8, string7, string9, new c(this, iI0xO0, iAliBtSender2, iHandlerCallback2));
                } else {
                    XO.II0xO0("DefaultDataHandler", "有三元组缓存信息，说明已经注册过了，不进行注册，直接返回注册给蓝牙设备");
                    try {
                        String str2 = FGSInfoConfig.sDeviceName;
                        String str3 = FGSInfoConfig.sDeviceSecret;
                        String str4 = FGSInfoConfig.sProductKey;
                        String str5 = FGSInfoConfig.sTimeStamp;
                        if (TextUtils.isEmpty(string9)) {
                            string9 = FGSInfoConfig.sonce;
                        }
                        iAliBtSender2.sendData(FGSInfoConfig.fgs2Byte(str2, str3, str4, str5, string9), new b(this, iHandlerCallback2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (string.equals("FGS_MSG_TYPE_DS_DOWNLOAD_RESP")) {
                String string10 = jSONObject.getString("message");
                String string11 = jSONObject.getString("sidver");
                Log.d("DefaultDataHandler", "message " + string10);
                Log.d("DefaultDataHandler", "sidver " + string11);
                if (string10.equals("success")) {
                    if (iHandlerCallback2 != null) {
                        iHandlerCallback.onFgsCheckSuccess();
                    }
                    Log.d("DefaultDataHandler", "device is received deviceSecret, it is " + string10);
                    return;
                }
                Log.d("DefaultDataHandler", "device receive deviceSecret is failed, it is " + string10);
                if (iHandlerCallback2 != null) {
                    iHandlerCallback2.onFgsCheckFailed("device receive deviceSecret is failed", 0);
                }
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
