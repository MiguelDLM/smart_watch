package com.sma.smartv3.biz;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.biz.ai.AIError;
import com.sma.smartv3.biz.dcs.DcsData;
import com.sma.smartv3.biz.dcs.DcsStruct;
import com.sma.smartv3.biz.dcs.DcsToken;
import com.sma.smartv3.biz.dcs.Directive;
import com.sma.smartv3.biz.dcs.ResponseData;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.biz.voice.VoicePlayer;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIAnswer;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIQuestion;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.GetAIChat;
import com.sma.smartv3.network.GetDcsToken;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.AIRapidRecoveryUtils;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleVoice;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import okhttp3.sse.EventSource;
import org.json.JSONObject;

@XX({"SMAP\nAIManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIManager.kt\ncom/sma/smartv3/biz/AIManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 5 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,664:1\n18#2,2:665\n15#2:667\n18#2,2:669\n15#2:671\n18#2,2:672\n15#2:674\n1#3:668\n151#4,11:675\n171#4:694\n208#5,7:686\n226#5:693\n*S KotlinDebug\n*F\n+ 1 AIManager.kt\ncom/sma/smartv3/biz/AIManager\n*L\n352#1:665,2\n352#1:667\n357#1:669,2\n357#1:671\n488#1:672,2\n488#1:674\n496#1:675,11\n496#1:694\n496#1:686,7\n496#1:693\n*E\n"})
/* loaded from: classes12.dex */
public final class AIManager {

    /* renamed from: I0Io */
    @OXOo.oOoXoXO
    public static xxxI.II0xO0<AIAnswer> f19826I0Io = null;

    /* renamed from: II0XooXoX */
    @OXOo.oOoXoXO
    public static EventSource f19827II0XooXoX = null;

    /* renamed from: II0xO0 */
    @OXOo.OOXIXo
    public static final String f19828II0xO0 = "AIManager";

    /* renamed from: OOXIXo */
    @OXOo.OOXIXo
    public static final String f19829OOXIXo = "https://duer-kids.baidu.com/botwatch/api/operation/aigc/stream/dcschat";

    /* renamed from: Oxx0IOOO */
    @OXOo.oOoXoXO
    public static EventSource f19830Oxx0IOOO = null;

    /* renamed from: oOoXoXO */
    @OXOo.oOoXoXO
    public static ThreadUtils.SimpleTask<Void> f19834oOoXoXO = null;

    /* renamed from: ooOOo0oXI */
    @OXOo.OOXIXo
    public static final String f19835ooOOo0oXI = "https://api.openai.com/v1/chat/completions";

    /* renamed from: xoIox */
    @OXOo.OOXIXo
    public static final String f19837xoIox = "CkWnW1dv5poz8AGkU78hjsDuu7M38XnH";

    /* renamed from: xxIXOIIO */
    @OXOo.OOXIXo
    public static final String f19838xxIXOIIO = "openAiChatCompletion";

    /* renamed from: oIX0oI */
    @OXOo.OOXIXo
    public static final AIManager f19833oIX0oI = new AIManager();

    /* renamed from: oxoX */
    public static boolean f19836oxoX = true;

    /* renamed from: X0o0xo */
    public static int f19831X0o0xo = 80;

    /* renamed from: XO */
    @OXOo.OOXIXo
    public static final Handler f19832XO = new Handler(Looper.getMainLooper());

    @XX({"SMAP\nAIManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIManager.kt\ncom/sma/smartv3/biz/AIManager$openAiChatCompletion$1\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,664:1\n107#2:665\n79#2,22:666\n*S KotlinDebug\n*F\n+ 1 AIManager.kt\ncom/sma/smartv3/biz/AIManager$openAiChatCompletion$1\n*L\n575#1:665\n575#1:666,22\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: IXxxXO */
        public final /* synthetic */ AIFunctionType f19846IXxxXO;

        /* renamed from: Oo */
        public final /* synthetic */ int f19847Oo;

        /* renamed from: XO */
        public final /* synthetic */ String f19848XO;

        public oIX0oI(String str, int i, AIFunctionType aIFunctionType) {
            this.f19848XO = str;
            this.f19847Oo = i;
            this.f19846IXxxXO = aIFunctionType;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@OXOo.oOoXoXO Void r1) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x01c0, code lost:
        
            r2 = r2.string();
         */
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground() {
            /*
                Method dump skipped, instructions count: 606
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.biz.AIManager.oIX0oI.doInBackground():java.lang.Void");
        }
    }

    public static /* synthetic */ void II0XooXoX(AIManager aIManager, String str, AIFunctionType aIFunctionType, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 2;
        }
        if ((i3 & 8) != 0) {
            i2 = ProductManager.f20544oIX0oI.x00IOx();
        }
        aIManager.Oxx0IOOO(str, aIFunctionType, i, i2);
    }

    public static final void IoOoX(AIQuestion question, AIRapidRecoveryUtils.oIX0oI mRapidRecovery) {
        IIX0o.x0xO0oo(question, "$question");
        IIX0o.x0xO0oo(mRapidRecovery, "$mRapidRecovery");
        AIFunctionType type = question.getType();
        String substring = mRapidRecovery.xxIXOIIO().substring(0, mRapidRecovery.xxIXOIIO().length() / 4);
        IIX0o.oO(substring, "substring(...)");
        AIAnswer aIAnswer = new AIAnswer(type, substring, 0, null, null, 24, null);
        xxxI.II0xO0<AIAnswer> iI0xO0 = f19826I0Io;
        if (iI0xO0 != null) {
            iI0xO0.handleResponse(aIAnswer);
        }
        if (f19836oxoX && mRapidRecovery.x0XOIxOo()) {
            DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, mRapidRecovery.xxIXOIIO(), false, ProductManager.f20544oIX0oI.II0OOXOx(), null, null, 26, null);
        }
    }

    public static /* synthetic */ String O0xOxO(AIManager aIManager, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        return aIManager.OxI(str, i);
    }

    public static /* synthetic */ String Oo(AIManager aIManager, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        return aIManager.x0xO0oo(str, z, i);
    }

    public static /* synthetic */ String Oxx0xo(AIManager aIManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return aIManager.IXxxXO(i);
    }

    public static /* synthetic */ String OxxIIOOXO(AIManager aIManager, String str, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = true;
        }
        if ((i3 & 8) != 0) {
            i2 = 500;
        }
        return aIManager.oI0IIXIo(str, i, z, i2);
    }

    public static /* synthetic */ void X0o0xo(AIManager aIManager, AIQuestion aIQuestion, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        aIManager.oxoX(aIQuestion, i, i2);
    }

    public static final void Xx000oIo(AIQuestion question, AIRapidRecoveryUtils.oIX0oI mRapidRecovery) {
        IIX0o.x0xO0oo(question, "$question");
        IIX0o.x0xO0oo(mRapidRecovery, "$mRapidRecovery");
        AIAnswer aIAnswer = new AIAnswer(question.getType(), mRapidRecovery.xxIXOIIO(), 1, null, null, 24, null);
        xxxI.II0xO0<AIAnswer> iI0xO0 = f19826I0Io;
        if (iI0xO0 != null) {
            iI0xO0.handleResponse(aIAnswer);
        }
    }

    public static /* synthetic */ String o00(AIManager aIManager, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        return aIManager.xoXoI(str, i);
    }

    public static final void oOXoIIIo(AIQuestion question, AIRapidRecoveryUtils.oIX0oI mRapidRecovery) {
        IIX0o.x0xO0oo(question, "$question");
        IIX0o.x0xO0oo(mRapidRecovery, "$mRapidRecovery");
        AIFunctionType type = question.getType();
        String substring = mRapidRecovery.xxIXOIIO().substring(0, mRapidRecovery.xxIXOIIO().length() / 2);
        IIX0o.oO(substring, "substring(...)");
        AIAnswer aIAnswer = new AIAnswer(type, substring, 0, null, null, 24, null);
        xxxI.II0xO0<AIAnswer> iI0xO0 = f19826I0Io;
        if (iI0xO0 != null) {
            iI0xO0.handleResponse(aIAnswer);
        }
    }

    public static /* synthetic */ int oOoXoXO(AIManager aIManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aIManager.OOXIXo(z);
    }

    public static /* synthetic */ void oo0xXOI0I(AIManager aIManager, AIQuestion aIQuestion, xxxI.II0xO0 iI0xO0, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
        boolean z3;
        boolean z4;
        int i4;
        if ((i3 & 2) != 0) {
            iI0xO0 = null;
        }
        xxxI.II0xO0 iI0xO02 = iI0xO0;
        if ((i3 & 4) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i3 & 8) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        if ((i3 & 16) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        int i5 = i;
        if ((i3 & 32) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        aIManager.xI(aIQuestion, iI0xO02, z3, z4, i5, i4);
    }

    public static /* synthetic */ void ooXIXxIX(AIManager aIManager, String str, AIFunctionType aIFunctionType, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = ProductManager.f20544oIX0oI.x00IOx();
        }
        aIManager.IIX0o(str, aIFunctionType, i);
    }

    public static /* synthetic */ String x0XOIxOo(AIManager aIManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = oOoXoXO(aIManager, false, 1, null);
        }
        return aIManager.ooOOo0oXI(i);
    }

    public static /* synthetic */ void xII(AIManager aIManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Utils.getApp().getString(R.string.request_error);
            IIX0o.oO(str, "getString(...)");
        }
        aIManager.IO(str);
    }

    public static /* synthetic */ String xoIox(AIManager aIManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = oOoXoXO(aIManager, false, 1, null);
        }
        return aIManager.xxIXOIIO(i);
    }

    public final void I0oOoX() {
        XX();
    }

    public final void IIX0o(@OXOo.OOXIXo String query, @OXOo.OOXIXo AIFunctionType messageType, int i) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(messageType, "messageType");
        oIX0oI oix0oi = new oIX0oI(query, i, messageType);
        f19834oOoXoXO = oix0oi;
        ThreadUtils.executeByIo(oix0oi);
    }

    @OXOo.OOXIXo
    public final Map<String, String> IIXOooo() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        Object fromJson = new Gson().fromJson(xo0.XO().getString(DcsToken.class.getName()), (Class<Object>) DcsToken.class);
        if (fromJson == null) {
            fromJson = DcsToken.class.newInstance();
        }
        DcsToken dcsToken = (DcsToken) fromJson;
        String client_id = dcsToken.getClient_id();
        if (client_id.length() == 0) {
            client_id = f19837xoIox;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager dcsToken -> " + dcsToken + "  clientId = " + client_id);
        Pair oIX0oI2 = kotlin.Xo0.oIX0oI("Client-Id", client_id);
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        Object fromJson2 = new Gson().fromJson(xo0.XO().getString(DcsToken.class.getName()), (Class<Object>) DcsToken.class);
        if (fromJson2 == null) {
            fromJson2 = DcsToken.class.newInstance();
        }
        sb.append(((DcsToken) fromJson2).getAccess_token());
        return o0.XX(oIX0oI2, kotlin.Xo0.oIX0oI("Authorization", sb.toString()), kotlin.Xo0.oIX0oI("Device-Id", OxI.IIOIX(BleCache.INSTANCE.getMBleAddress(), ":", "", false, 4, null)));
    }

    public final void IO(String str) {
        x0o(str);
    }

    @OXOo.OOXIXo
    public final String IXxxXO(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return xoIox(this, 0, 1, null);
                    }
                    return "deepseekAIService";
                }
                return "sparkAIService";
            }
            return "openAIService";
        }
        return "baiduAIService";
    }

    public final void Io(boolean z) {
        f19836oxoX = z;
    }

    public final void OI0(@OXOo.oOoXoXO xxxI.II0xO0<AIAnswer> iI0xO0) {
        f19826I0Io = iI0xO0;
    }

    public final int OOXIXo(boolean z) {
        int i;
        if (ProductManager.f20544oIX0oI.xXo()) {
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            i = XO2.getInt(XoI0Ixx0.f24379O00XxXI, UtilsKt.X00IoxXI(app) ? 1 : 0);
        } else {
            i = 1;
        }
        OrderManager.f20130oIX0oI.oo0xXOI0I(z);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("AIManager getAIModel -> ");
        sb.append(i);
        sb.append("  isZh(Utils.getApp()) = ");
        Application app2 = Utils.getApp();
        IIX0o.oO(app2, "getApp(...)");
        sb.append(UtilsKt.X00IoxXI(app2));
        oix0oi.oIX0oI(sb.toString());
        return i;
    }

    @OXOo.OOXIXo
    public final String OxI(@OXOo.OOXIXo String query, int i) {
        IIX0o.x0xO0oo(query, "query");
        if (ProductManager.f20544oIX0oI.XOx()) {
            return query;
        }
        return String.valueOf(Utils.getApp().getString(R.string.ai_max_tokens_question2, query, UtilsKt.oI0IIXIo(R.string.app_name)));
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo String query, @OXOo.OOXIXo final AIFunctionType messageType, int i, int i2) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(messageType, "messageType");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager duserStreamChat -> q:" + query);
        f19831X0o0xo = 80;
        DcsTtsPlayer.INSTANCE.clearSegmentation();
        StatManager.f20200oIX0oI.II0xO0(3);
        f19827II0XooXoX = NetWorkUtils.INSTANCE.postStreamRequest(f19829OOXIXo, IIXOooo(), OxxIIOOXO(this, xoXoI(query, i2), i, false, i2, 4, null), new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.AIManager$duserStreamChat$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                AIManager aIManager = AIManager.f19833oIX0oI;
                if (aIManager.xXxxox0I()) {
                    DcsTtsPlayer.INSTANCE.stop();
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager duserStreamChat -> error:" + error);
                xxxI.II0xO0<AIAnswer> oO2 = aIManager.oO();
                if (oO2 != null) {
                    oO2.handleError(error);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.String] */
            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                Directive directive;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI("AIManager duserStreamChat line -> " + str);
                try {
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "";
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("type");
                    int i3 = jSONObject.getInt("ended");
                    if (IIX0o.Oxx0IOOO(string, "response")) {
                        String answer = ((ResponseData) new Gson().fromJson(jSONObject.getJSONObject("data").toString(), ResponseData.class)).getAnswer();
                        AIAnswer aIAnswer = new AIAnswer(AIFunctionType.this, answer, i3, null, null, 24, null);
                        AIManager aIManager = AIManager.f19833oIX0oI;
                        xxxI.II0xO0<AIAnswer> oO2 = aIManager.oO();
                        if (oO2 != null) {
                            oO2.handleResponse(aIAnswer);
                        }
                        if (i3 == 1 && aIManager.xXxxox0I()) {
                            DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, answer, false, ProductManager.f20544oIX0oI.II0OOXOx(), null, null, 26, null);
                            return;
                        }
                        ProductManager productManager = ProductManager.f20544oIX0oI;
                        if (productManager.II0OOXOx() && aIManager.xXxxox0I() && answer.length() > aIManager.X0IIOO()) {
                            aIManager.o0(aIManager.X0IIOO() + aIManager.X0IIOO());
                            DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, answer, false, productManager.II0OOXOx(), null, null, 26, null);
                            return;
                        }
                        return;
                    }
                    if (IIX0o.Oxx0IOOO(string, "dcs")) {
                        DcsData dcsData = (DcsData) new Gson().fromJson(jSONObject.getJSONObject("data").toString(), DcsData.class);
                        oix0oi.oIX0oI("AIManager duserStreamChat dcsData -> " + dcsData);
                        String text = dcsData.getTts().getText();
                        AIAnswer aIAnswer2 = new AIAnswer(AIFunctionType.this, text, i3, (String) objectRef.element, null, 16, null);
                        AIManager aIManager2 = AIManager.f19833oIX0oI;
                        xxxI.II0xO0<AIAnswer> oO3 = aIManager2.oO();
                        if (oO3 != null) {
                            oO3.handleResponse(aIAnswer2);
                        }
                        if (i3 == 1 || (ProductManager.f20544oIX0oI.II0OOXOx() && text.length() > aIManager2.X0IIOO())) {
                            aIManager2.o0(aIManager2.X0IIOO() + aIManager2.X0IIOO());
                            BleConnector.INSTANCE.setDisableStreamLog(true);
                            if (aIManager2.xXxxox0I()) {
                                DcsStruct dcsStruct = (DcsStruct) CollectionsKt___CollectionsKt.OIoxIx(dcsData.getDcs(), 0);
                                if (dcsStruct != null) {
                                    directive = dcsStruct.getDirective();
                                } else {
                                    directive = null;
                                }
                                if (directive != null) {
                                    if (IIX0o.Oxx0IOOO(directive.getHeader().getName(), "Play")) {
                                        objectRef.element = directive.getPayload().getAudioItem().getStream().getUrl();
                                        DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, text, false, ProductManager.f20544oIX0oI.II0OOXOx(), new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.AIManager$duserStreamChat$1$handleResponse$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                                invoke(bool.booleanValue());
                                                return oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(boolean z) {
                                                if (z) {
                                                    VoicePlayer.play$default(VoicePlayer.INSTANCE, objectRef.element, null, 2, null);
                                                }
                                            }
                                        }, null, 18, null);
                                        return;
                                    } else {
                                        DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, text, false, ProductManager.f20544oIX0oI.II0OOXOx(), null, null, 26, null);
                                        return;
                                    }
                                }
                                DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, text, false, ProductManager.f20544oIX0oI.II0OOXOx(), null, null, 26, null);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (str == null) {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager duserStreamChat -> error: empty");
                        xxxI.II0xO0<AIAnswer> oO4 = AIManager.f19833oIX0oI.oO();
                        if (oO4 != null) {
                            oO4.handleError("null");
                        }
                    } else {
                        xxxI.II0xO0<AIAnswer> oO5 = AIManager.f19833oIX0oI.oO();
                        if (oO5 != null) {
                            oO5.handleError(str);
                        }
                    }
                    DcsTtsPlayer.INSTANCE.clearSegmentation();
                }
            }
        });
    }

    public final void X00IoxXI(@OXOo.OOXIXo final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(callback, "callback");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String url = GetDcsToken.INSTANCE.getURL();
        HashMap<String, String> dcsTokenBody = RequestBodyKt.getDcsTokenBody();
        final xxxI.II0xO0<DcsToken> iI0xO0 = new xxxI.II0xO0<DcsToken>() { // from class: com.sma.smartv3.biz.AIManager$refreshToken$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager refreshToken onError -> " + error);
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (productManager.oo00()) {
                    AIManager.f19833oIX0oI.IO("请先到App上激活" + productManager.x0OxxIOxX());
                } else if (IIX0o.Oxx0IOOO(error, "SSLException: Read timed out")) {
                    ToastUtils.showLong("Read timed out , " + UtilsKt.oI0IIXIo(R.string.request_error), new Object[0]);
                } else {
                    ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.request_error) + TokenParser.SP + error, new Object[0]);
                }
                callback.invoke(Boolean.FALSE);
                xxxI.II0xO0<AIAnswer> oO2 = AIManager.f19833oIX0oI.oO();
                if (oO2 != null) {
                    oO2.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO DcsToken dcsToken) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager refreshToken handleResponse -> " + dcsToken);
                if (dcsToken != null) {
                    dcsToken.setTimestamp(System.currentTimeMillis());
                    Xo0.f24349oIX0oI.XO().put(DcsToken.class.getName(), new Gson().toJson(dcsToken));
                    callback.invoke(Boolean.TRUE);
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), url);
        netWorkUtils.printParam(convertBaseUrl + url, dcsTokenBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + url;
        final xxxI.II0xO0<Response<DcsToken>> iI0xO02 = new xxxI.II0xO0<Response<DcsToken>>() { // from class: com.sma.smartv3.biz.AIManager$refreshToken$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<DcsToken> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) dcsTokenBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DcsToken.class), new ParsedRequestListener<Response<DcsToken>>() { // from class: com.sma.smartv3.biz.AIManager$refreshToken$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<DcsToken> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final int X0IIOO() {
        return f19831X0o0xo;
    }

    @OXOo.OOXIXo
    public final String XI0IXoo(@OXOo.OOXIXo String query) {
        IIX0o.x0xO0oo(query, "query");
        return query + " , " + Utils.getApp().getString(R.string.ai_translate_question_tip);
    }

    public final void XIxXXX0x0(@OXOo.OOXIXo AIError error) {
        IIX0o.x0xO0oo(error, "error");
        String code = error.getCode();
        int hashCode = code.hashCode();
        if (hashCode != -656062448) {
            if (hashCode != 221600882) {
                if (hashCode == 1715548988 && code.equals("insufficient_quota")) {
                    ToastUtils.showLong(R.string.insufficient_quota);
                    return;
                }
            } else if (code.equals("invalid_api_key")) {
                ToastUtils.showLong(R.string.invalid_api_key);
                return;
            }
        } else if (code.equals("invalid_request_error")) {
            ToastUtils.showLong(R.string.invalid_api_key_tip);
            return;
        }
        ToastUtils.showLong(UtilsKt.oI0IIXIo(R.string.request_error), new Object[0]);
    }

    @OXOo.OOXIXo
    public final String XOxIOxOx(@OXOo.OOXIXo String titleStr) {
        IIX0o.x0xO0oo(titleStr, "titleStr");
        switch (titleStr.hashCode()) {
            case -1671190941:
                if (titleStr.equals("openAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.chatgpt);
                }
                break;
            case -361646967:
                if (titleStr.equals("deepseekAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.pay_dail_aigc_deep_seek);
                }
                break;
            case -345876046:
                if (titleStr.equals("baiduAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.wenxinyiyan);
                }
                break;
            case 1088442160:
                if (titleStr.equals("sparkAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.ai_model_spark_desk);
                }
                break;
        }
        if (titleStr.length() <= 0) {
            return UtilsKt.oI0IIXIo(R.string.pay_dail_aigc_modle);
        }
        return titleStr;
    }

    public final void XX() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager -> AndroidNetworking.cancelAll stop ");
        AndroidNetworking.cancelAll();
        DcsTtsPlayer.INSTANCE.stop();
        VoicePlayer.INSTANCE.stop();
        ThreadUtils.SimpleTask<Void> simpleTask = f19834oOoXoXO;
        if (simpleTask != null) {
            ThreadUtils.cancel(simpleTask);
        }
        EventSource eventSource = f19827II0XooXoX;
        if (eventSource != null && eventSource != null) {
            eventSource.cancel();
        }
        EventSource eventSource2 = f19830Oxx0IOOO;
        if (eventSource2 != null && eventSource2 != null) {
            eventSource2.cancel();
        }
    }

    public final boolean XxX0x0xxx() {
        if (ProductManager.f20544oIX0oI.XI0IXoo()) {
            return true;
        }
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        if ((UtilsKt.X00IoxXI(app) && IIX0o.Oxx0IOOO(xoIox(this, 0, 1, null), "baiduAIService")) || IIX0o.Oxx0IOOO(xoIox(this, 0, 1, null), "sparkAIService")) {
            return true;
        }
        return false;
    }

    public final void o0(int i) {
        f19831X0o0xo = i;
    }

    @OXOo.OOXIXo
    public final String oI0IIXIo(@OXOo.OOXIXo String query, int i, boolean z, int i2) {
        IIX0o.x0xO0oo(query, "query");
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        if (UtilsKt.IO(app)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager getDuserStreamChatBody -> p:108, " + query + ", mode:" + i + ", maxTokens:" + i2);
            return "{\"pid\":\"108\",\"mode\": " + i + ",\"qid\":\"abc\",\"data\":{\"prompt\":\"" + query + "\",\"stream\":" + z + ",\"max_tokens\":" + i2 + "},\"dcs_data\":{\"cuid\":\"lyxabc1234\",\"didp\":\"11\",\"sn\":\"lyxabc1234\",\"events\":\"{\\\"clientContext\\\":[{\\\"header\\\":{\\\"name\\\":\\\"AlertsState\\\",\\\"namespace\\\":\\\"ai.dueros.device_interface.alerts\\\"},\\\"payload\\\":{\\\"activeAlerts\\\":[],\\\"allAlerts\\\":[]}},{\\\"header\\\":{\\\"name\\\":\\\"VolumeState\\\",\\\"namespace\\\":\\\"ai.dueros.device_interface.speaker_controller\\\"},\\\"payload\\\":{\\\"muted\\\":false,\\\"volume\\\":80}},{\\\"header\\\":{\\\"name\\\":\\\"PlaybackState\\\",\\\"namespace\\\":\\\"ai.dueros.device_interface.video_player\\\"},\\\"payload\\\":{\\\"offsetInMilliseconds\\\":0,\\\"playerActivity\\\":\\\"FINISHED\\\",\\\"token\\\":\\\"\\\"}},{\\\"header\\\":{\\\"name\\\":\\\"SpeechState\\\",\\\"namespace\\\":\\\"ai.dueros.device_interface.voice_output\\\"},\\\"payload\\\":{\\\"offsetInMilliseconds\\\":0,\\\"playerActivity\\\":\\\"FINISHED\\\",\\\"token\\\":\\\"\\\"}}],\\\"event\\\":{\\\"header\\\":{\\\"name\\\":\\\"ListenStarted\\\",\\\"namespace\\\":\\\"ai.dueros.device_interface.voice_input\\\",\\\"messageId\\\":\\\"123\\\",\\\"dialogRequestId\\\":\\\"123\\\"},\\\"payload\\\":{\\\"format\\\":\\\"AUDIO_L16_RATE_16000_CHANNELS_1\\\",\\\"profile\\\":\\\"\\\"}}}\"}}";
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager getDuserStreamChatBody -> p:106, " + query + ", mode:" + i + ", maxTokens:" + i2);
        return "{\"pid\": \"106\",\"mode\": 2,\"qid\": \"abc\",\"data\": {\"prompt\": \"" + query + "\",\"stream\": " + z + ",\"max_tokens\": " + i2 + "}}";
    }

    @OXOo.oOoXoXO
    public final xxxI.II0xO0<AIAnswer> oO() {
        return f19826I0Io;
    }

    public final void oo(final AIQuestion aIQuestion, final AIRapidRecoveryUtils.oIX0oI oix0oi) {
        Handler handler = f19832XO;
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.biz.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                AIManager.IoOoX(AIQuestion.this, oix0oi);
            }
        }, 400L);
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.biz.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                AIManager.oOXoIIIo(AIQuestion.this, oix0oi);
            }
        }, 700L);
        handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.biz.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                AIManager.Xx000oIo(AIQuestion.this, oix0oi);
            }
        }, 1000L);
    }

    @OXOo.OOXIXo
    public final String ooOOo0oXI(int i) {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.oI0IIXIo().length() > 0) {
            return productManager.oI0IIXIo();
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "deepseekAIService";
                }
            } else if (productManager.O0xxXxI()) {
                return "sparkAIService";
            }
            return "baiduAIService";
        }
        return "openAIService";
    }

    public final void oxoX(@OXOo.OOXIXo final AIQuestion question, int i, int i2) {
        IIX0o.x0xO0oo(question, "question");
        question.setStream(true);
        question.setModel(IXxxXO(i2));
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager AIChat -> " + question);
        question.setText(xoXoI(question.getText(), i));
        final StringBuilder sb = new StringBuilder();
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String json = new Gson().toJson(question);
        IIX0o.oO(json, "toJson(...)");
        f19830Oxx0IOOO = NetWorkUtils.postStreamRequest$default(netWorkUtils, GetAIChat.URL, null, json, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.AIManager$AIChat$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                AIManager aIManager = AIManager.f19833oIX0oI;
                if (aIManager.xXxxox0I()) {
                    DcsTtsPlayer.INSTANCE.stop();
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager AIChat -> error:" + error);
                xxxI.II0xO0<AIAnswer> oO2 = aIManager.oO();
                if (oO2 != null) {
                    oO2.handleError(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager AIChat line -> " + str);
                try {
                    Object fromJson = new Gson().fromJson(str, TypeToken.getParameterized(Response.class, AIAnswer.class));
                    IIX0o.x0XOIxOo(fromJson, "null cannot be cast to non-null type com.sma.androidnetworklib.model.Response<com.sma.smartv3.model.AIAnswer>");
                    Response response = (Response) fromJson;
                    if (response.getData() == null) {
                        int code = response.getCode();
                        if (code != 4006 && code != 5001 && code != 5002) {
                            xxxI.II0xO0<AIAnswer> oO2 = AIManager.f19833oIX0oI.oO();
                            if (oO2 != null) {
                                oO2.handleError(response.getMesg());
                                return;
                            }
                            return;
                        }
                        xxxI.II0xO0<AIAnswer> oO3 = AIManager.f19833oIX0oI.oO();
                        if (oO3 != null) {
                            oO3.handleError(String.valueOf(response.getCode()));
                            return;
                        }
                        return;
                    }
                    AIAnswer aIAnswer = (AIAnswer) response.getData();
                    if (aIAnswer != null) {
                        StringBuilder sb2 = sb;
                        AIQuestion aIQuestion = question;
                        sb2.append(aIAnswer.getText());
                        aIAnswer.setType(aIQuestion.getType());
                        String sb3 = sb2.toString();
                        IIX0o.oO(sb3, "toString(...)");
                        aIAnswer.setText(sb3);
                        AIManager aIManager = AIManager.f19833oIX0oI;
                        xxxI.II0xO0<AIAnswer> oO4 = aIManager.oO();
                        if (oO4 != null) {
                            oO4.handleResponse(aIAnswer);
                        }
                        if (aIAnswer.getEnded() == 1 && aIManager.xXxxox0I()) {
                            DcsTtsPlayer dcsTtsPlayer = DcsTtsPlayer.INSTANCE;
                            String sb4 = sb2.toString();
                            IIX0o.oO(sb4, "toString(...)");
                            DcsTtsPlayer.play$default(dcsTtsPlayer, sb4, false, false, null, null, 30, null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (str == null) {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("AIManager AIChat -> error: empty");
                        xxxI.II0xO0<AIAnswer> oO5 = AIManager.f19833oIX0oI.oO();
                        if (oO5 != null) {
                            oO5.handleError("null");
                            return;
                        }
                        return;
                    }
                    xxxI.II0xO0<AIAnswer> oO6 = AIManager.f19833oIX0oI.oO();
                    if (oO6 != null) {
                        oO6.handleError(str);
                    }
                }
            }
        }, 2, null);
    }

    public final void x0o(String str) {
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.AUDIO_TEXT, BleKeyFlag.UPDATE, new BleVoice(0, System.currentTimeMillis(), str, 0, 8, null), false, false, 24, null);
    }

    @OXOo.OOXIXo
    public final String x0xO0oo(@OXOo.OOXIXo String text, boolean z, int i) {
        IIX0o.x0xO0oo(text, "text");
        return "{    \"model\": \"gpt-3.5-turbo\",    \"messages\": [        {            \"role\": \"system\",            \"content\": \"You are a helpful assistant.\"        },        {            \"role\": \"user\",            \"content\": \"" + xoXoI(text, i) + "\"        }    ],    \"stream\": " + z + ",    \"max_tokens\": 250}";
    }

    public final void xI(@OXOo.OOXIXo final AIQuestion question, @OXOo.oOoXoXO xxxI.II0xO0<AIAnswer> iI0xO0, boolean z, boolean z2, final int i, int i2) {
        IIX0o.x0xO0oo(question, "question");
        f19826I0Io = iI0xO0;
        f19836oxoX = z;
        if (z2) {
            XX();
        }
        AIRapidRecoveryUtils.oIX0oI II0xO02 = AIRapidRecoveryUtils.f24195oIX0oI.II0xO0(question.getText());
        if (II0xO02 != null) {
            oo(question, II0xO02);
            return;
        }
        DcsTtsPlayer.INSTANCE.deleteReplayMusic();
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("query  isUseAIService = ");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sb.append(productManager.XOx());
        sb.append(" , isSupportDirectAI = ");
        sb.append(productManager.O0o0());
        oix0oi.oIX0oI(sb.toString());
        if (i2 == 2) {
            AISparkChainManager.f19871oIX0oI.XOxIOxOx(question.getText(), f19826I0Io, i, z);
            return;
        }
        if (i2 >= 0 && i2 <= 3) {
            oxoX(question, i, i2);
            return;
        }
        if (productManager.oO0OX0()) {
            AISparkChainManager.f19871oIX0oI.XOxIOxOx(question.getText(), f19826I0Io, i, z);
            return;
        }
        if (productManager.XOx()) {
            X0o0xo(this, question, i, 0, 4, null);
            return;
        }
        if (productManager.xIx0XO()) {
            if (xxX()) {
                X00IoxXI(new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.AIManager$query$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(boolean z3) {
                        if (z3) {
                            AIManager.II0XooXoX(AIManager.f19833oIX0oI, AIQuestion.this.getText(), AIQuestion.this.getType(), 0, i, 4, null);
                        }
                    }
                });
                return;
            } else {
                II0XooXoX(this, question.getText(), question.getType(), 0, i, 4, null);
                return;
            }
        }
        if (TextUtils.isEmpty(productManager.I0Io())) {
            ToastUtils.showLong(R.string.no_ai_key);
            xxxI.II0xO0<AIAnswer> iI0xO02 = f19826I0Io;
            if (iI0xO02 != null) {
                iI0xO02.handleError(UtilsKt.oI0IIXIo(R.string.no_ai_key));
                return;
            }
            return;
        }
        IIX0o(question.getText(), question.getType(), i);
    }

    public final boolean xXxxox0I() {
        return f19836oxoX;
    }

    @OXOo.OOXIXo
    public final String xoXoI(@OXOo.OOXIXo String query, int i) {
        IIX0o.x0xO0oo(query, "query");
        if (ProductManager.f20544oIX0oI.XOx()) {
            return query;
        }
        return query + " . " + Utils.getApp().getString(R.string.ai_max_tokens_question, Integer.valueOf(i));
    }

    @OXOo.OOXIXo
    public final String xxIXOIIO(int i) {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.O0xOxO().length() > 0) {
            return productManager.O0xOxO();
        }
        if (productManager.oI0IIXIo().length() > 0) {
            return productManager.oI0IIXIo();
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "deepseekAIService";
                }
            } else if (productManager.O0xxXxI()) {
                return "sparkAIService";
            }
            return "baiduAIService";
        }
        return "openAIService";
    }

    public final boolean xxX() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(DcsToken.class.getName()), (Class<Object>) DcsToken.class);
        if (fromJson == null) {
            fromJson = DcsToken.class.newInstance();
        }
        if (System.currentTimeMillis() - ((DcsToken) fromJson).getTimestamp() > r0.getExpires_in()) {
            return true;
        }
        return false;
    }
}
