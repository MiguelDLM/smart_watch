package com.baidu.ai.speech.realtime.full.connection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.baidu.ai.speech.realtime.full.download.Result;
import com.baidu.ai.speech.realtime.full.download.SimpleDownloader;
import com.baidu.ai.speech.realtime.full.upload.AbstractUploader;
import com.baidu.ai.speech.realtime.full.util.Stat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class MyWebSocketListener extends WebSocketListener {
    private static Logger logger = Logger.getLogger("MyWebSocketListener");
    private SimpleDownloader downloader;
    private AtomicBoolean isClosed = new AtomicBoolean(false);
    private Stat stat;
    private AbstractUploader uploader;

    public MyWebSocketListener(AbstractUploader uploader, SimpleDownloader downloader) {
        Stat stat = uploader.getStat();
        this.stat = stat;
        this.uploader = uploader;
        this.downloader = downloader;
        stat.updateBeforeConnectTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOpen$0(WebSocket webSocket) {
        try {
            this.uploader.execute(webSocket);
        } catch (JSONException e) {
            logger.log(Level.SEVERE, "upload " + e.getClass().getSimpleName(), (Throwable) e);
            throw new RuntimeException(e);
        }
    }

    private void setClosed() {
        this.isClosed.set(true);
        this.uploader.setClosed();
    }

    public boolean isClosed() {
        return this.isClosed.get();
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(@OOXIXo WebSocket webSocket, int code, @OOXIXo String reason) {
        super.onClosed(webSocket, code, reason);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("onClosed -> " + code + " | " + reason);
        StringBuilder sb = new StringBuilder();
        sb.append("onClosed -> ");
        sb.append(this.stat.toReportString());
        oix0oi.oIX0oI(sb.toString());
        String result = this.stat.getResult();
        oix0oi.oIX0oI("onClosed -> result: " + result);
        if (this.stat.getErrNo() != 0 && TextUtils.isEmpty(result)) {
            this.downloader.onFailure("websocket closed: " + this.stat.getErrNo());
        } else if (TextUtils.isEmpty(result)) {
            this.downloader.onFailure("websocket closed: empty");
        }
        setClosed();
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(@OOXIXo WebSocket webSocket, int code, @OOXIXo String reason) {
        super.onClosing(webSocket, code, reason);
        logger.info("websocket event closing :" + code + " | " + reason);
        webSocket.close(1000, "");
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(@OOXIXo WebSocket webSocket, @OOXIXo Throwable t, @oOoXoXO Response response) {
        super.onFailure(webSocket, t, response);
        String str = "websocket failure :" + t.getMessage();
        logger.log(Level.SEVERE, "websocket failure :" + t.getMessage(), t);
        setClosed();
        this.downloader.onFailure(str);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(@OOXIXo WebSocket webSocket, @OOXIXo String text) {
        super.onMessage(webSocket, text);
        try {
            Result result = new Result(text);
            if (result.isHeartBeat()) {
                logger.finest("receive heartbeat: " + text.trim());
            } else {
                logger.info("receive text: " + text.trim());
            }
            if (result.isFin()) {
                this.stat.addResult(result);
            }
            this.downloader.onMessage(result);
        } catch (JSONException e) {
            logger.log(Level.SEVERE, "receive json parse error: " + e.getMessage() + ":" + text, (Throwable) e);
            e.printStackTrace();
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(@OOXIXo final WebSocket webSocket, @OOXIXo Response response) {
        super.onOpen(webSocket, response);
        this.stat.updateOnOpenTime();
        new Thread(new Runnable() { // from class: com.baidu.ai.speech.realtime.full.connection.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                MyWebSocketListener.this.lambda$onOpen$0(webSocket);
            }
        }).start();
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(@OOXIXo WebSocket webSocket, @OOXIXo ByteString bytes) {
        super.onMessage(webSocket, bytes);
        logger.severe("receive binary unexpected: " + bytes.size());
    }
}
