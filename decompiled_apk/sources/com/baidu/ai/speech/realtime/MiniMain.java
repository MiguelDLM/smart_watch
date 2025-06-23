package com.baidu.ai.speech.realtime;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.ai.speech.realtime.MiniMain;
import com.baidu.ai.speech.realtime.full.Main;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class MiniMain {
    private static Logger logger = Logger.getLogger("MiniMain");
    private InputStream inputStream;
    private volatile boolean isClosed = false;

    /* loaded from: classes7.dex */
    public class WListener extends WebSocketListener {
        private WListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onOpen$0(WebSocket webSocket) {
            try {
                sendStartFrame(webSocket);
                sendAudioFrames(webSocket);
                sendFinishFrame(webSocket);
            } catch (JSONException e) {
                MiniMain.logger.log(Level.SEVERE, e.getClass().getSimpleName(), (Throwable) e);
                throw new RuntimeException(e);
            }
        }

        private void sendAudioFrames(WebSocket webSocket) {
            int i;
            MiniMain.logger.info("begin to send DATA frames");
            byte[] bArr = new byte[Util.BYTES_PER_FRAME];
            long currentTimeMillis = System.currentTimeMillis();
            do {
                Util.sleep(currentTimeMillis - System.currentTimeMillis());
                try {
                    i = MiniMain.this.inputStream.read(bArr);
                } catch (IOException | RuntimeException e) {
                    MiniMain.logger.warning("inputstream is closed:" + e.getClass().getSimpleName() + ":" + e.getMessage());
                    i = -2;
                }
                if (i > 0) {
                    ByteString of = ByteString.of(bArr, 0, i);
                    long currentTimeMillis2 = System.currentTimeMillis() + Util.bytesToTime(i);
                    MiniMain.logger.finer("should wait to send next DATA Frame: " + Util.bytesToTime(i) + "ms | send binary bytes size :" + i);
                    webSocket.send(of);
                    currentTimeMillis = currentTimeMillis2;
                }
            } while (i >= 0);
        }

        private void sendFinishFrame(WebSocket webSocket) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "FINISH");
            MiniMain.logger.info("send FINISH FRAME:" + jSONObject.toString());
            webSocket.send(jSONObject.toString());
        }

        private void sendStartFrame(WebSocket webSocket) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", Const.APPID);
            jSONObject.put("appkey", Const.APPKEY);
            jSONObject.put("dev_pid", oIX0oI.oIX0oI());
            jSONObject.put("cuid", "self_defined_server_id_like_mac_address");
            jSONObject.put("format", "pcm");
            jSONObject.put("sample", 16000);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "START");
            jSONObject2.put("data", jSONObject);
            MiniMain.logger.info("send start FRAME:" + jSONObject2.toString());
            webSocket.send(jSONObject2.toString());
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(@OOXIXo WebSocket webSocket, int code, @OOXIXo String reason) {
            super.onClosed(webSocket, code, reason);
            MiniMain.logger.info("websocket closed: " + code + " | " + reason);
            MiniMain.this.isClosed = true;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(@OOXIXo WebSocket webSocket, int code, @OOXIXo String reason) {
            super.onClosing(webSocket, code, reason);
            MiniMain.logger.info("websocket event closing :" + code + " | " + reason);
            webSocket.close(1000, "");
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(@OOXIXo WebSocket webSocket, @OOXIXo Throwable t, @oOoXoXO Response response) {
            super.onFailure(webSocket, t, response);
            MiniMain.logger.log(Level.SEVERE, "websocket failure", t);
            MiniMain.this.isClosed = true;
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(@OOXIXo WebSocket webSocket, @OOXIXo String text) {
            super.onMessage(webSocket, text);
            if (text.contains("\"TYPE_HEARTBEAT\"")) {
                MiniMain.logger.finer("receive heartbeat: " + text.trim());
                return;
            }
            MiniMain.logger.info("receive text: " + text.trim());
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(@OOXIXo final WebSocket webSocket, @OOXIXo Response response) {
            super.onOpen(webSocket, response);
            new Thread(new Runnable() { // from class: com.baidu.ai.speech.realtime.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniMain.WListener.this.lambda$onOpen$0(webSocket);
                }
            }).start();
        }
    }

    private MiniMain(String filename) {
        File file = new File(filename);
        logger.info("begin demo, will read " + file.getAbsolutePath());
        try {
            this.inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage(), (Throwable) e);
        }
    }

    public static void main(String[] args) {
        String str;
        if (args.length >= 1) {
            str = args[0];
        } else {
            str = Main.FILENAME;
        }
        Logger.getLogger("").setLevel(Level.ALL);
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT.%1$tL] [%4$-7s][%3$s] %5$s%6$s%n");
        Locale.setDefault(Locale.ENGLISH);
        new MiniMain(str).run();
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public void run() {
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS).build();
        String str = "ws://vop.baidu.com/realtime_asr?sn=" + UUID.randomUUID().toString();
        logger.info("runner begin: " + str);
        build.newWebSocket(new Request.Builder().url(str).build(), new WListener());
        build.dispatcher().executorService().shutdown();
    }

    public MiniMain(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
