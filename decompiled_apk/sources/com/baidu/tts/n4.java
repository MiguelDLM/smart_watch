package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.database.FsFileInfoTable;
import com.facebook.login.widget.ToolTipPopup;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* loaded from: classes8.dex */
public class n4 implements m4 {
    public static volatile OkHttpClient d;
    public l4 b;

    /* renamed from: a, reason: collision with root package name */
    public WebSocket f10139a = null;
    public String c = null;

    public n4(l4 l4Var) {
        this.b = l4Var;
        if (d == null) {
            synchronized (n4.class) {
                ConnectionPool connectionPool = new ConnectionPool(3, 70L, TimeUnit.SECONDS);
                Dispatcher dispatcher = new Dispatcher();
                StringBuilder sb = new StringBuilder();
                sb.append("netconfig: keepalive 70s, connect timeout 6000ms,read time");
                this.b.getClass();
                sb.append(2000);
                sb.append("ms, write time ");
                this.b.getClass();
                sb.append(2000);
                sb.append("ping interval ");
                this.b.getClass();
                sb.append(10000);
                LoggerProxy.d("OkWsClient", sb.toString());
                OkHttpClient.Builder dispatcher2 = new OkHttpClient.Builder().connectionPool(connectionPool).dispatcher(dispatcher);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                OkHttpClient.Builder connectTimeout = dispatcher2.connectTimeout(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, timeUnit);
                this.b.getClass();
                long j = 2000;
                OkHttpClient.Builder readTimeout = connectTimeout.readTimeout(j, timeUnit);
                this.b.getClass();
                OkHttpClient.Builder hostnameVerifier = readTimeout.writeTimeout(j, timeUnit).retryOnConnectionFailure(false).hostnameVerifier(FsFileInfoTable.a());
                this.b.getClass();
                d = hostnameVerifier.pingInterval(10000, timeUnit).build();
                LoggerProxy.d("OkWsClient", "build OkHttpClient.");
            }
        }
    }
}
