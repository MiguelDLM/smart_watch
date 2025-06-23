package com.baidu.tts;

import androidx.core.app.NotificationCompat;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class k4 extends WebSocketListener {
    public static ThreadPoolExecutor o;
    public static volatile int p;
    public l4 b;
    public b c;
    public int f;
    public volatile Timer h;

    /* renamed from: a, reason: collision with root package name */
    public volatile m4 f10120a = null;
    public volatile int d = 0;
    public a3 e = new a3("bdsConnPt");
    public volatile boolean g = true;
    public volatile TimerTask i = new c();
    public JSONObject j = new JSONObject();
    public JSONObject k = new JSONObject();
    public volatile String l = null;
    public volatile boolean m = false;
    public volatile boolean n = false;

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public TtsError f10121a = null;

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TtsError ttsError;
            LoggerProxy.d("ConnectPoint", "CloseTask +++ mState " + k4.this.d);
            if (k4.this.d != 2) {
                LoggerProxy.d("ConnectPoint", "WsConnect stop needless, not opened.");
                return;
            }
            k4.this.d = 3;
            try {
                k4.this.k.put("connect_close", System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
            LoggerProxy.d("ConnectPoint", "CloseTask +++ mWsClient " + k4.this.f10120a);
            if (k4.this.f10120a != null) {
                n4 n4Var = (n4) k4.this.f10120a;
                n4Var.getClass();
                LoggerProxy.d("OkWsClient", "start disconnect.");
                if (n4Var.f10139a == null) {
                    ttsError = c3.a().a(x2.C);
                } else {
                    LoggerProxy.i("OkWsClient", "disconnect websocket+++ .");
                    if (!n4Var.f10139a.close(1000, HTTP.CONN_CLOSE)) {
                        LoggerProxy.i("OkWsClient", "disconnect websocket failed---. ");
                        ttsError = c3.a().a(x2.C);
                    } else {
                        LoggerProxy.i("OkWsClient", "disconnect websocket---.");
                        ttsError = null;
                    }
                }
                this.f10121a = ttsError;
                LoggerProxy.d("ConnectPoint", "CloseTask +++ mError " + this.f10121a);
                if (this.f10121a != null) {
                    LoggerProxy.d("ConnectPoint", "WsConnect stop failed, force stop.");
                    k4.this.f10120a = null;
                    k4.this.d = 0;
                }
            }
            LoggerProxy.d("ConnectPoint", "CloseTask ---");
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
    }

    /* loaded from: classes8.dex */
    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LoggerProxy.d("ConnectPoint", "WsConnect, idle timeout.");
            c3.a().a(x2.K);
            ((p4) k4.this.c).a(null, new Throwable(), 0, null);
            k4.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public String f10123a;
        public WebSocketListener b;
        public TtsError c = null;

        public d(String str, String str2, WebSocketListener webSocketListener) {
            this.f10123a = str;
            this.b = webSocketListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            TtsError a2;
            LoggerProxy.d("ConnectPoint", "OpenTask +++ mState " + k4.this.d);
            if (k4.this.d != 0) {
                LoggerProxy.d("ConnectPoint", "WsConnect, open dropped, stop previous one first.");
                return;
            }
            LoggerProxy.d("ConnectPoint", "WsConnect, start new one.");
            k4.this.d = 1;
            try {
                k4.this.k.put("connect_open", System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
            n4 n4Var = new n4(k4.this.b);
            this.f10123a = k4.this.b.a();
            LoggerProxy.d("ConnectPoint", "mConnParams mUrl = " + this.f10123a + ",url = " + k4.this.b.f10131a);
            if (k4.this.b.f10131a == null) {
                LoggerProxy.d("ConnectPoint", "WsConnect, dns failed.");
                this.c = c3.a().a(x2.u);
                k4.this.d = 0;
                return;
            }
            String str = this.f10123a + "?sn=" + k4.this.l;
            this.f10123a = str;
            String str2 = k4.this.b.d;
            WebSocketListener webSocketListener = this.b;
            LoggerProxy.d("OkWsClient", "start connect.");
            n4Var.c = str;
            Request.Builder builder = new Request.Builder();
            builder.url(str);
            if (str2 != null) {
                builder.addHeader("Host", str2);
            }
            try {
                n4Var.f10139a = n4.d.newWebSocket(builder.build(), webSocketListener);
                if (Thread.currentThread().isInterrupted()) {
                    LoggerProxy.d("OkWsClient", "start cancel.");
                    WebSocket webSocket = n4Var.f10139a;
                    if (webSocket != null) {
                        webSocket.cancel();
                    }
                }
                a2 = null;
            } catch (IllegalArgumentException unused) {
                a2 = c3.a().a(x2.A);
            }
            this.c = a2;
            LoggerProxy.d("ConnectPoint", "request with url " + this.f10123a + " mHasConnectError " + k4.this.n + " mError " + this.c);
            if (this.c == null && !k4.this.n) {
                LoggerProxy.d("ConnectPoint", "WsConnect, connection ongoing.");
                k4.this.f10120a = n4Var;
            } else {
                k4.this.d = 0;
                if (this.c != null) {
                    LoggerProxy.d("ConnectPoint", "WsConnect, connection failed " + this.c.getDetailMessage());
                }
            }
            LoggerProxy.d("ConnectPoint", "OpenTask ---");
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoggerProxy.d("ConnectPoint", "SendOpenTask +++");
            LoggerProxy.i("ConnectPoint", "fake open event.");
            k4 k4Var = k4.this;
            ((p4) k4Var.c).c(k4Var);
            LoggerProxy.d("ConnectPoint", "SendOpenTask ---");
        }
    }

    public k4(l4 l4Var, b bVar) {
        this.b = null;
        this.c = null;
        this.f = 0;
        this.h = null;
        int i = p;
        p = i + 1;
        this.f = i;
        this.h = new Timer("CPT" + this.f);
        LoggerProxy.d("ConnectPoint", "CPT" + this.f + " created.");
        this.b = l4Var;
        this.c = bVar;
        if (o == null) {
            o = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), this.e, new ThreadPoolExecutor.AbortPolicy());
        }
        try {
            this.j.put("connect_point_start", System.currentTimeMillis());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public TtsError a(byte[] bArr) {
        LoggerProxy.d("ConnectPoint", "send data.");
        if (this.f10120a != null) {
            n4 n4Var = (n4) this.f10120a;
            n4Var.getClass();
            LoggerProxy.d("OkWsClient", "start send data.");
            if (n4Var.f10139a == null) {
                return c3.a().a(x2.B);
            }
            LoggerProxy.i("OkWsClient", "[sendData]param=" + bArr);
            if (bArr != null) {
                System.currentTimeMillis();
                if (!n4Var.f10139a.send(ByteString.of(bArr, 0, bArr.length))) {
                    TtsError a2 = c3.a().a(x2.B);
                    LoggerProxy.i("OkWsClient", "send failed.");
                    return a2;
                }
            }
            LoggerProxy.i("OkWsClient", "send ok.");
            return null;
        }
        return c3.a().a(x2.M);
    }

    public TtsError b() {
        LoggerProxy.d("ConnectPoint", "detach.mState = " + this.d);
        if (this.g) {
            LoggerProxy.d("ConnectPoint", "already idle, no need detach.");
            return null;
        }
        this.g = true;
        a(false);
        if (this.d == 2) {
            d();
            LoggerProxy.d("ConnectPoint", "enter in idle mode.");
            this.i = new c();
            StringBuilder sb = new StringBuilder();
            sb.append("WsConnect, in idle mode start timer CPT");
            sb.append(this.f);
            sb.append(" trigger after ");
            this.b.getClass();
            sb.append(60000);
            LoggerProxy.d("ConnectPoint", sb.toString());
            Timer timer = this.h;
            TimerTask timerTask = this.i;
            this.b.getClass();
            timer.schedule(timerTask, 60000);
        }
        LoggerProxy.d("ConnectPoint", "detach end.");
        return null;
    }

    public final void c() {
        LoggerProxy.d("ConnectPoint", "resetConnection ");
        d();
        this.g = false;
        this.f10120a = null;
        this.d = 0;
    }

    public final void d() {
        LoggerProxy.d("ConnectPoint", "resetMonitor ");
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
    }

    public void e() {
        LoggerProxy.d("ConnectPoint", "stopConnection = ");
        LoggerProxy.d("ConnectPoint", "CPT" + this.f + " cancel.");
        this.h.cancel();
        o.execute(new a());
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i, String str) {
        super.onClosed(webSocket, i, str);
        if (this.m) {
            return;
        }
        LoggerProxy.d("ConnectPoint", "WsConnect, onClosed");
        if (this.f10120a != null && webSocket == ((n4) this.f10120a).f10139a) {
            this.d = 0;
            try {
                this.k.put("connect_closed", System.currentTimeMillis());
                a(this.k);
                this.k = new JSONObject();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LoggerProxy.d("ConnectPoint", "stop ws connection, details " + this.k.toString());
            c();
            p4 p4Var = (p4) this.c;
            j4 b2 = p4Var.b(this);
            LoggerProxy.d("WsConnectionService", "onClosed code =" + i + " , reason = " + str + " cb = " + b2);
            if (b2 != null) {
                p4Var.a(this);
            } else {
                p4Var.f10150a = null;
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i, String str) {
        int i2;
        super.onClosing(webSocket, i, str);
        LoggerProxy.d("ConnectPoint", "WsConnect, onClosing code=, reason=" + str);
        if (this.m) {
            return;
        }
        LoggerProxy.d("ConnectPoint", "WsConnect, onClosing mWsClient=" + this.f10120a);
        if (this.f10120a != null && webSocket == ((n4) this.f10120a).f10139a) {
            LoggerProxy.d("ConnectPoint", "WsConnect, onClosing ");
            p4 p4Var = (p4) this.c;
            p4Var.getClass();
            LoggerProxy.d("WsConnectionService", "onClosing code= " + i + " reason =" + str);
            j4 b2 = p4Var.b(this);
            if (b2 != null) {
                y3 y3Var = b2.f10116a;
                y3Var.getClass();
                LoggerProxy.d(y3.l, "Channel[" + y3Var.e + "], onClosing");
                if (!y3Var.d.b.f10197a) {
                    f0.b bVar = (f0.b) y3Var.f10203a;
                    synchronized (bVar.p) {
                        LoggerProxy.d(f0.d, "[onClosing]notify");
                        bVar.a(x2.z, null);
                        bVar.m = true;
                        bVar.p.notifyAll();
                    }
                }
                y3Var.h.cancel();
                y3Var.c.cancel();
                i2 = 0;
            } else {
                i2 = -1;
            }
            LoggerProxy.d("ConnectPoint", "WsConnect, onClosing ret= " + i2);
            if (i2 != 0) {
                e();
            }
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        super.onFailure(webSocket, th, response);
        LoggerProxy.d("ConnectPoint", "WsConnect, onFailure " + th.toString() + " mState " + this.d);
        if (this.d == 1) {
            this.n = true;
        }
        LoggerProxy.d("ConnectPoint", "CPT" + this.f + " cancel.");
        this.h.cancel();
        if (this.f10120a != null && webSocket == ((n4) this.f10120a).f10139a) {
            int i = 0;
            if (this.d == 1 || this.d == 3) {
                LoggerProxy.d("ConnectPoint", "WsConnect, mState " + this.d);
                this.d = 0;
                this.f10120a = null;
            }
            try {
                this.k.put("connect_failure", System.currentTimeMillis());
                a(this.k);
                this.k = new JSONObject();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c();
            if (response != null) {
                i = response.code();
            }
            LoggerProxy.d("ConnectPoint", "WsConnect, onFailure ");
            ((p4) this.c).a(this, th, i, null);
            return;
        }
        LoggerProxy.d("ConnectPoint", "WsConnect, mWsClient " + this.f10120a);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) {
        LoggerProxy.d("ConnectPoint", "WsConnect, onMessage String");
        if (this.m || this.f10120a == null || webSocket != ((n4) this.f10120a).f10139a) {
            return;
        }
        ((p4) this.c).a(this, str.getBytes(), true);
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        String sb;
        super.onOpen(webSocket, response);
        LoggerProxy.d("ConnectPoint", "WsConnect, onOpen");
        if (this.m) {
            LoggerProxy.d("ConnectPoint", "WsConnect, onOpen but will stop.");
            return;
        }
        boolean z = false;
        if (this.f10120a != null && webSocket == ((n4) this.f10120a).f10139a) {
            if (Thread.currentThread().isInterrupted()) {
                LoggerProxy.d("ConnectPoint", "isInterrupted");
                webSocket.close(100, "");
                c();
                return;
            }
            LoggerProxy.d("ConnectPoint", "onOpen mState " + this.d);
            this.d = 2;
            try {
                this.k.put("connect_opened", System.currentTimeMillis());
                this.k.put("conn_id", this.l);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (((p4) this.c).c(this) == -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("WsConnect, onOpen no user, directly to idle mode ");
                this.b.getClass();
                sb2.append(60000);
                LoggerProxy.d("ConnectPoint", sb2.toString());
                this.g = true;
                d();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("WsConnect, onOpen start timer CPT");
                sb3.append(this.f);
                sb3.append(" trigger after ");
                this.b.getClass();
                sb3.append(60000);
                LoggerProxy.d("ConnectPoint", sb3.toString());
                this.i = new c();
                Timer timer = this.h;
                TimerTask timerTask = this.i;
                this.b.getClass();
                timer.schedule(timerTask, 60000);
                return;
            }
            this.g = false;
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("WsConnect, onOpen mWsClient ");
        if (this.f10120a == null) {
            sb = "null";
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            if (webSocket == ((n4) this.f10120a).f10139a) {
                z = true;
            }
            sb5.append(!z);
            sb = sb5.toString();
        }
        sb4.append(sb);
        LoggerProxy.d("ConnectPoint", sb4.toString());
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString byteString) {
        LoggerProxy.d("ConnectPoint", "WsConnect, onMessage bytes");
        if (this.m || this.f10120a == null || webSocket != ((n4) this.f10120a).f10139a) {
            return;
        }
        ((p4) this.c).a(this, byteString.toByteArray(), false);
    }

    public TtsError a() {
        LoggerProxy.d("ConnectPoint", "attach.mState =  " + this.d);
        if (this.d == 2) {
            if (this.g) {
                d();
                this.g = false;
                a(true);
                o.execute(new e());
                return null;
            }
            TtsError a2 = c3.a().a(x2.L);
            LoggerProxy.d("ConnectPoint", "attach end " + a2.getDetailMessage());
            return a2;
        }
        if (this.d == 3) {
            LoggerProxy.d("ConnectPoint", "previous connect is closing, please wait.");
            return c3.a().a(x2.L);
        }
        if (this.d == 1) {
            return null;
        }
        this.l = UUID.randomUUID().toString();
        a(true);
        o.execute(new d(this.b.a(), this.b.d, this));
        return null;
    }

    public final void a(JSONObject jSONObject) {
        try {
            if (!this.j.has("connects")) {
                this.j.put("connects", new JSONArray());
            }
            this.j.getJSONArray("connects").put(jSONObject);
            LoggerProxy.d("ConnectPoint", "WsConnect, detail " + jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(boolean z) {
        LoggerProxy.d("ConnectPoint", "updateUsageInfo .attachOrDetach " + z);
        try {
            if (!this.j.has("usage")) {
                this.j.put("usage", new JSONArray());
            }
            JSONArray jSONArray = this.j.getJSONArray("usage");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, z ? "attach" : "detach");
            jSONObject.put("tm", System.currentTimeMillis());
            jSONObject.put("conn_id", this.l);
            jSONArray.put(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
