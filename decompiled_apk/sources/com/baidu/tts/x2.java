package com.baidu.tts;

import androidx.media2.session.RemoteResult;
import com.huawei.openalliance.ad.constant.ah;
import com.kwad.components.offline.api.IOfflineCompo;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class x2 {
    public static final x2 A;
    public static final x2 A0;
    public static final x2 B;
    public static final x2 B0;
    public static final x2 C;
    public static final x2 C0;
    public static final x2 D;
    public static final x2 D0;
    public static final x2 E;
    public static final x2 E0;
    public static final x2 F;
    public static final x2 F0;
    public static final x2 G;
    public static final x2 G0;
    public static final x2 H;
    public static final x2 H0;
    public static final x2 I;

    /* renamed from: I0, reason: collision with root package name */
    public static final x2 f10190I0;
    public static final x2 J;
    public static final x2 J0;
    public static final x2 K;
    public static final x2 K0;
    public static final x2 L;
    public static final x2 L0;
    public static final x2 M;
    public static final x2 M0;
    public static final x2 N;
    public static final x2 N0;
    public static final x2 O;

    /* renamed from: O0, reason: collision with root package name */
    public static final x2 f10191O0;
    public static final x2 P;
    public static final x2 P0;
    public static final x2 Q;
    public static final x2 Q0;
    public static final x2 R;
    public static final x2 R0;
    public static final x2 S;
    public static final x2 S0;
    public static final x2 T;
    public static final /* synthetic */ x2[] T0;
    public static final x2 U;
    public static final x2 V;
    public static final x2 W;
    public static final x2 X;
    public static final x2 Y;
    public static final x2 Z;
    public static final x2 a0;
    public static final x2 b0;
    public static final x2 c0;
    public static final x2 d;
    public static final x2 d0;
    public static final x2 e;
    public static final x2 e0;
    public static final x2 f;
    public static final x2 f0;
    public static final x2 g;
    public static final x2 g0;
    public static final x2 h;
    public static final x2 h0;
    public static final x2 i;
    public static final x2 i0;
    public static final x2 j;
    public static final x2 j0;
    public static final x2 k;
    public static final x2 k0;
    public static final x2 l;
    public static final x2 l0;
    public static final x2 m;
    public static final x2 m0;
    public static final x2 n;
    public static final x2 n0;
    public static final x2 o;

    /* renamed from: o0, reason: collision with root package name */
    public static final x2 f10192o0;
    public static final x2 p;
    public static final x2 p0;
    public static final x2 q;
    public static final x2 q0;
    public static final x2 r;
    public static final x2 r0;
    public static final x2 s;
    public static final x2 s0;
    public static final x2 t;
    public static final x2 t0;
    public static final x2 u;
    public static final x2 u0;
    public static final x2 v;
    public static final x2 v0;
    public static final x2 w;
    public static final x2 w0;
    public static final x2 x;

    /* renamed from: x0, reason: collision with root package name */
    public static final x2 f10193x0;
    public static final x2 y;
    public static final x2 y0;
    public static final x2 z;
    public static final x2 z0;

    /* renamed from: a, reason: collision with root package name */
    public final a f10194a;
    public final int b;
    public final String c;

    /* loaded from: classes8.dex */
    public enum a {
        MIX_ERROR,
        ONLINE_ENGINE_ERROR,
        OFFLINE_ENGINE_ERROR,
        TEXT,
        TTS,
        APP,
        PLAYER,
        MODEL,
        UNKNOW
    }

    static {
        a aVar = a.ONLINE_ENGINE_ERROR;
        x2 x2Var = new x2("ONLINE_ENGINE_AUTH_FAILURE", 0, aVar, -1, "online engine auth failure");
        d = x2Var;
        x2 x2Var2 = new x2("ONLINE_ENGINE_HTTP_REQUEST_FAILURE", 1, aVar, -2, "request failure");
        e = x2Var2;
        x2 x2Var3 = new x2("ONLINE_ENGINE_CANCEL_FAILURE", 2, aVar, -3, "cancel failure");
        f = x2Var3;
        x2 x2Var4 = new x2("ONLINE_AUTH_INTERRUPTED_EXCEPTION", 3, aVar, -4, "InterruptedException");
        g = x2Var4;
        x2 x2Var5 = new x2("ONLINE_AUTH_EXECUTION_EXCEPTION", 4, aVar, -5, "ExecutionException");
        h = x2Var5;
        x2 x2Var6 = new x2("ONLINE_AUTH_TIMEOUT_EXCEPTION", 5, aVar, -6, "TimeoutException");
        i = x2Var6;
        x2 x2Var7 = new x2("ONLINE_ENGINE_REQUEST_RESULT_ERROR", 6, aVar, -7, "request result contains error message");
        j = x2Var7;
        x2 x2Var8 = new x2("ONLINE_TOKEN_IS_NULL", 7, aVar, -8, "access token is null, please check your apikey and secretkey or product id");
        k = x2Var8;
        x2 x2Var9 = new x2("ONLINE_ENGINE_UNINITIALIZED", 8, aVar, -9, "online engine is not initial");
        l = x2Var9;
        x2 x2Var10 = new x2("ONLINE_ENGINE_CALL_EXCEPTION", 9, aVar, -10, "online engine call synthesize exception");
        m = x2Var10;
        x2 x2Var11 = new x2("ONLINE_UNSUPPORTED_OPERATION", 10, aVar, -11, "this method is not supported by online mode(please use other mode)");
        n = x2Var11;
        x2 x2Var12 = new x2("ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR", 11, aVar, -12, "request result parse error may responsebag is null");
        o = x2Var12;
        x2 x2Var13 = new x2("ONLINE_ENGINE_GET_INTERRUPTED", 12, aVar, -13, "online synthesize get was interrupted");
        p = x2Var13;
        x2 x2Var14 = new x2("ONLINE_ENGINE_GET_EXECUTION_EXCEPTION", 13, aVar, -14, "online synthesize get exception");
        q = x2Var14;
        x2 x2Var15 = new x2("ONLINE_ENGINE_GET_TIMEOUT", 14, aVar, -15, "online synthesize get was timeout");
        r = x2Var15;
        x2 x2Var16 = new x2("ONLINE_AUTH_CANCELLATION_EXCEPTION", 15, aVar, -16, "CancellationException");
        s = x2Var16;
        x2 x2Var17 = new x2("ONLINE_ENGINE_SERVER_IP_IS_NULL", 16, aVar, -17, "online engine server ip is null");
        t = x2Var17;
        x2 x2Var18 = new x2("ONLINE_ENGINE_GET_UNKNOWN_HOST", 17, aVar, -18, "online synthesize get was unknown host");
        u = x2Var18;
        x2 x2Var19 = new x2("ONLINE_ENGINE_GET_READ_ERROR", 18, aVar, -19, "online synthesize get was read error");
        v = x2Var19;
        x2 x2Var20 = new x2("ONLINE_ENGINE_GET_CONNECT_EXCEPTION", 19, aVar, -20, "online synthesize connect exception");
        w = x2Var20;
        x2 x2Var21 = new x2("ONLINE_ENGINE_GET_SOCKET_EXCEPTION", 20, aVar, -21, "online synthesize get was socket is closed");
        x = x2Var21;
        x2 x2Var22 = new x2("ONLINE_ENGINE_GET_SSL_HANDSHAKE_EXCEPTION", 21, aVar, -22, "SSLHandshakeException");
        y = x2Var22;
        x2 x2Var23 = new x2("ONLINE_ENGINE_GET_WEBSOCKET_CLOSING", 22, aVar, -23, "online synthesize websocket closing");
        z = x2Var23;
        x2 x2Var24 = new x2("ONLINE_ENGINE_REQUEST_URI_MALFORMED", 23, aVar, -24, "online synthesize request uri malformed");
        A = x2Var24;
        x2 x2Var25 = new x2("ONLINE_ENGINE_NET_WRITE_ERROR", 24, aVar, -25, "online synthesize network write error");
        B = x2Var25;
        x2 x2Var26 = new x2("ONLINE_ENGINE_NET_CLOSE_ERROR", 25, aVar, -26, "online synthesize network close error");
        C = x2Var26;
        x2 x2Var27 = new x2("ONLINE_ENGINE_NET_PROXY_ERROR", 26, aVar, -27, "online synthesize network proxy error");
        D = x2Var27;
        x2 x2Var28 = new x2("ONLINE_ENGINE_PRT_LVTV_ERROR", 27, aVar, -28, "online synthesize protocal error");
        E = x2Var28;
        x2 x2Var29 = new x2("ONLINE_ENGINE_PRT_FIELD_MISS_ERROR", 28, aVar, -29, "online synthesize field miss error");
        F = x2Var29;
        x2 x2Var30 = new x2("ONLINE_ENGINE_PRT_DATA_MISS_ERROR", 29, aVar, -30, "online synthesize need more data error");
        G = x2Var30;
        x2 x2Var31 = new x2("ONLINE_ENGINE_DECODE_BUSY_ERROR", 30, aVar, -31, "online decode is busy error");
        H = x2Var31;
        x2 x2Var32 = new x2("ONLINE_ENGINE_SOCKET_UNKNOWN_ERROR", 31, aVar, -32, "online unknown socket error");
        I = x2Var32;
        x2 x2Var33 = new x2("ONLINE_ENGINE_INIT_FAILED", 32, aVar, -33, "online engine initTTS, init failure");
        J = x2Var33;
        x2 x2Var34 = new x2("ONLINE_ENGINE_NET_IDLE_CLOSE", 33, aVar, -34, "online synthesize network idle timeout");
        K = x2Var34;
        x2 x2Var35 = new x2("ONLINE_ENGINE_GET_CONNECT_BUSY", 34, aVar, -35, "online synthesize connect is busy");
        L = x2Var35;
        x2 x2Var36 = new x2("ONLINE_ENGINE_CONNECTION_NOT_READY", 35, aVar, -36, "online synthesize connect is not ready");
        M = x2Var36;
        x2 x2Var37 = new x2("ONLINE_ENGINE_TTS_EMPTY_AUDIO", 36, aVar, -37, "online synthesize receive no audio.");
        N = x2Var37;
        a aVar2 = a.OFFLINE_ENGINE_ERROR;
        x2 x2Var38 = new x2("OFFLINE_ENGINE_AUTH_FAILURE", 37, aVar2, -100, "offline engine auth failure,please check you offline auth params");
        O = x2Var38;
        x2 x2Var39 = new x2("OFFLINE_ENGINE_CANCEL_FAILURE", 38, aVar2, -101, "offline engine cancel failure");
        P = x2Var39;
        x2 x2Var40 = new x2("OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED", 39, aVar2, RemoteResult.RESULT_ERROR_SESSION_AUTHENTICATION_EXPIRED, "offline engine download license failure");
        Q = x2Var40;
        x2 x2Var41 = new x2("OFFLINE_ENGINE_AUTH_NULL", 40, aVar2, RemoteResult.RESULT_ERROR_SESSION_PREMIUM_ACCOUNT_REQUIRED, "offline engine auth authinfo is null");
        R = x2Var41;
        x2 x2Var42 = new x2("OFFLINE_AUTH_INTERRUPTED_EXCEPTION", 41, aVar2, RemoteResult.RESULT_ERROR_SESSION_PARENTAL_CONTROL_RESTRICTED, "InterruptedException");
        S = x2Var42;
        x2 x2Var43 = new x2("OFFLINE_AUTH_EXECUTION_EXCEPTION", 42, aVar2, RemoteResult.RESULT_ERROR_SESSION_NOT_AVAILABLE_IN_REGION, "ExecutionException");
        T = x2Var43;
        x2 x2Var44 = new x2("OFFLINE_AUTH_TIMEOUT_EXCEPTION", 43, aVar2, RemoteResult.RESULT_ERROR_SESSION_SKIP_LIMIT_REACHED, "TimeoutException");
        U = x2Var44;
        x2 x2Var45 = new x2("OFFLINE_ENGINE_INIT_FAILED", 44, aVar2, RemoteResult.RESULT_ERROR_SESSION_SETUP_REQUIRED, "bdTTSEngineInit failed,please check you offline params");
        V = x2Var45;
        x2 x2Var46 = new x2("OFFLINE_ENGINE_UNINITIALIZED", 45, aVar2, -109, "offline engine is uninitialized,please invoke initTts() method");
        W = x2Var46;
        x2 x2Var47 = new x2("OFFLINE_ENGINE_CALL_EXCEPTION", 46, aVar2, -110, "offline engine call synthesize exception");
        X = x2Var47;
        x2 x2Var48 = new x2("OFFLINE_ENGINE_SYNTHESIZE_ERROR", 47, aVar2, -111, "offline engine synthesize result not 0");
        Y = x2Var48;
        x2 x2Var49 = new x2("OFFLINE_ENGINE_AUTH_EXPIRED", 48, aVar2, -112, "offline engine auth verify expired,formal expired or temp expired");
        Z = x2Var49;
        x2 x2Var50 = new x2("OFFLINE_ENGINE_AUTH_PACKAGE_UNMATCH", 49, aVar2, -113, "package name is unmatch");
        a0 = x2Var50;
        x2 x2Var51 = new x2("OFFLINE_ENGINE_AUTH_SIGN_UNMATCH", 50, aVar2, -114, "app sign is unmatch");
        b0 = x2Var51;
        x2 x2Var52 = new x2("OFFLINE_ENGINE_AUTH_CUID_UNMATCH", 51, aVar2, -115, "devices cuid is unmatch");
        c0 = x2Var52;
        x2 x2Var53 = new x2("OFFLINE_ENGINE_AUTH_PLATFORM_ERROR", 52, aVar2, -116, "platform is unmatch");
        d0 = x2Var53;
        x2 x2Var54 = new x2("OFFLINE_ENGINE_AUTH_LICENSE_FILE_INVALID", 53, aVar2, -117, "license file not exist or file length is 0 (download license fail)");
        e0 = x2Var54;
        x2 x2Var55 = new x2("OFFLINE_AUTH_CANCELLATION_EXCEPTION", 54, aVar, -118, "CancellationException");
        f0 = x2Var55;
        x2 x2Var56 = new x2("OFFLINE_RESOURCES_VERSION_ERROR", 55, aVar2, -119, "offline resources version error");
        g0 = x2Var56;
        x2 x2Var57 = new x2("OFFLINE_RESOURCES_AUTHORIZE_FAILURE", 56, aVar2, -120, "offline resources authorize failed");
        h0 = x2Var57;
        x2 x2Var58 = new x2("OFFLINE_ENGINE_LABEL_FAILED", 57, aVar2, -121, "Offline engine does not support SSML");
        i0 = x2Var58;
        x2 x2Var59 = new x2("OFFLINE_RESOURCE_LOAD_FAILED", 58, aVar2, -122, "offline speaker resource wrong");
        j0 = x2Var59;
        x2 x2Var60 = new x2("OFFLINE_SPEAKER_LOAD_FAILED", 59, aVar2, -123, "offline speaker not exist");
        k0 = x2Var60;
        x2 x2Var61 = new x2("OFFLINE_DOWNLOAD_LICENSE_INVALID_SN", 60, aVar2, -124, "download license failure,invalid SN");
        l0 = x2Var61;
        a aVar3 = a.MIX_ERROR;
        x2 x2Var62 = new x2("MIX_ENGINE_AUTH_FAILURE", 61, aVar3, IOfflineCompo.Priority.HIGHEST, "both online and offline engine auth failue");
        m0 = x2Var62;
        x2 x2Var63 = new x2("MIX_AUTH_INTERRUPTED_EXCEPTION", 62, aVar3, -201, "InterruptedException");
        n0 = x2Var63;
        x2 x2Var64 = new x2("MIX_AUTH_EXECUTION_EXCEPTION", 63, aVar3, -202, "ExecutionException");
        f10192o0 = x2Var64;
        x2 x2Var65 = new x2("MIX_AUTH_TIMEOUT_EXCEPTION", 64, aVar3, -203, "TimeoutException");
        p0 = x2Var65;
        x2 x2Var66 = new x2("MIX_ENGINE_OFFLINE_INIT_FAILURE", 65, aVar3, -204, "mix engine initTTS, the offline init failure");
        q0 = x2Var66;
        x2 x2Var67 = new x2("MIX_AUTH_CANCELLATION_EXCEPTION", 66, aVar3, -205, "CancellationException");
        r0 = x2Var67;
        x2 x2Var68 = new x2("MIX_ENGINE_ONLINE_INIT_FAILURE", 67, aVar3, -206, "mix engine initTTS, the online init failure");
        s0 = x2Var68;
        x2 x2Var69 = new x2("MIX_ENGINE_BOTH_INIT_FAILURE", 68, aVar3, -207, "mix engine initTTS, all engines init failure");
        t0 = x2Var69;
        a aVar4 = a.TEXT;
        x2 x2Var70 = new x2("TEXT_IS_EMPTY", 69, aVar4, -300, "text is null or empty double quotation marks");
        u0 = x2Var70;
        x2 x2Var71 = new x2("TEXT_IS_TOO_LONG", 70, aVar4, ah.I, "text length in gbk is more than 1024, the text is too long, cut it short than 1024");
        v0 = x2Var71;
        x2 x2Var72 = new x2("TEXT_ENCODE_IS_WRONG", 71, aVar4, ah.Z, "text encode is not gbk, please use gbk text");
        w0 = x2Var72;
        a aVar5 = a.TTS;
        x2 x2Var73 = new x2("TTS_UNINITIAL", 72, aVar5, -400, "tts has not been initialized,invoke in a wrong state");
        f10193x0 = x2Var73;
        x2 x2Var74 = new x2("TTS_MODE_ILLEGAL", 73, aVar5, -401, "tts mode unset or not the spechified value");
        y0 = x2Var74;
        x2 x2Var75 = new x2("TTS_QUEUE_IS_FULL", 74, aVar5, -402, "队列长度小于MAX_QUEUE_SIZE时才能加入合成队列");
        z0 = x2Var75;
        x2 x2Var76 = new x2("TTS_LIST_IS_TOO_LONG", 75, aVar5, -403, "list的size小于MAX_LIST_SIZE时才有效");
        A0 = x2Var76;
        x2 x2Var77 = new x2("TTS_ENGINE_STOP_FAILURE", 76, aVar5, -404, "引擎停止失败");
        B0 = x2Var77;
        x2 x2Var78 = new x2("TTS_APP_ID_IS_INVALID", 77, aVar5, -405, "app id is invalid,must be less than int(11)");
        C0 = x2Var78;
        x2 x2Var79 = new x2("TTS_PARAMETER_INVALID", 78, aVar5, -406, "arguments of the method is invalid");
        D0 = x2Var79;
        x2 x2Var80 = new x2("TTS_DATA_TOO_MUCH", 79, aVar5, -407, "too much data in buffer, wait please.");
        E0 = x2Var80;
        x2 x2Var81 = new x2("APP_RESOURCE_IS_NULL", 80, a.APP, -500, "context was released or persistent app value is null");
        F0 = x2Var81;
        x2 x2Var82 = new x2("PLAYER_IS_NULL", 81, a.PLAYER, -600, "player is null");
        G0 = x2Var82;
        a aVar6 = a.MODEL;
        x2 x2Var83 = new x2("MODEL_PARAMS_ERROR", 82, aVar6, -1000, "params is wrong");
        H0 = x2Var83;
        x2 x2Var84 = new x2("MODEL_REQUEST_ERROR", 83, aVar6, -1001, "request error");
        f10190I0 = x2Var84;
        x2 x2Var85 = new x2("MODEL_SERVER_ERROR", 84, aVar6, -1002, "server error");
        J0 = x2Var85;
        x2 x2Var86 = new x2("MODEL_DB_MODEL_INVALID", 85, aVar6, -1003, "model item in db is invalid(fileids is empty)");
        K0 = x2Var86;
        x2 x2Var87 = new x2("MODEL_DB_MODEL_FILE_PATHS_INVALID", 86, aVar6, -1004, "model file in db is invalid(abspath is empty)");
        L0 = x2Var87;
        x2 x2Var88 = new x2("MODEL_EXISTS", 87, aVar6, -1005, "this model exists(have downloaded success ever)");
        M0 = x2Var88;
        x2 x2Var89 = new x2("MODEL_BAGS_EMPTY", 88, aVar6, -1006, "can't get server model info,maybe modelid invalid or request failure");
        N0 = x2Var89;
        x2 x2Var90 = new x2("MODEL_FILE_BAG_EMPTY", 89, aVar6, -1007, "can't get server file info,maybe fileid invalid or request failure");
        f10191O0 = x2Var90;
        x2 x2Var91 = new x2("MODEL_CHECK_EXCEPTION", 90, aVar6, -1008, "CheckWork exception happened");
        P0 = x2Var91;
        x2 x2Var92 = new x2("MODEL_FILE_DOWNLOAD_EXCEPTION", 91, aVar6, -1009, "exception happens when file downloadwork execute");
        Q0 = x2Var92;
        x2 x2Var93 = new x2("MODEL_INACTIVITY_NETWORK", 92, aVar6, -1010, "Inactivity Network");
        R0 = x2Var93;
        x2 x2Var94 = new x2("TTS_ERROR_UNKNOW", 93, a.UNKNOW, -9999, "unknow");
        S0 = x2Var94;
        T0 = new x2[]{x2Var, x2Var2, x2Var3, x2Var4, x2Var5, x2Var6, x2Var7, x2Var8, x2Var9, x2Var10, x2Var11, x2Var12, x2Var13, x2Var14, x2Var15, x2Var16, x2Var17, x2Var18, x2Var19, x2Var20, x2Var21, x2Var22, x2Var23, x2Var24, x2Var25, x2Var26, x2Var27, x2Var28, x2Var29, x2Var30, x2Var31, x2Var32, x2Var33, x2Var34, x2Var35, x2Var36, x2Var37, x2Var38, x2Var39, x2Var40, x2Var41, x2Var42, x2Var43, x2Var44, x2Var45, x2Var46, x2Var47, x2Var48, x2Var49, x2Var50, x2Var51, x2Var52, x2Var53, x2Var54, x2Var55, x2Var56, x2Var57, x2Var58, x2Var59, x2Var60, x2Var61, x2Var62, x2Var63, x2Var64, x2Var65, x2Var66, x2Var67, x2Var68, x2Var69, x2Var70, x2Var71, x2Var72, x2Var73, x2Var74, x2Var75, x2Var76, x2Var77, x2Var78, x2Var79, x2Var80, x2Var81, x2Var82, x2Var83, x2Var84, x2Var85, x2Var86, x2Var87, x2Var88, x2Var89, x2Var90, x2Var91, x2Var92, x2Var93, x2Var94};
    }

    public x2(String str, int i2, a aVar, int i3, String str2) {
        this.f10194a = aVar;
        this.b = i3;
        this.c = str2;
    }

    public static x2 valueOf(String str) {
        return (x2) Enum.valueOf(x2.class, str);
    }

    public static x2[] values() {
        return (x2[]) T0.clone();
    }
}
