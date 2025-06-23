package com.baidu.ai.speech.realtime.full.upload;

import com.baidu.ai.speech.realtime.Const;
import com.baidu.ai.speech.realtime.Util;
import com.baidu.ai.speech.realtime.full.util.Stat;
import com.baidu.ai.speech.realtime.oIX0oI;
import java.io.InputStream;
import java.util.logging.Logger;
import okhttp3.WebSocket;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class AbstractUploader {
    private static Logger logger = Logger.getLogger("AbstractUploader");
    InputStream inputStream;
    protected volatile boolean isClosed = false;
    private Stat stat;

    public AbstractUploader(InputStream inputStream, Stat stat) {
        this.inputStream = inputStream;
        this.stat = stat;
    }

    public void execute(WebSocket webSocket) throws JSONException {
        logger.info("begin to send");
        if (this.isClosed) {
            logger.severe("websocket is closed, stop transferring frames ");
            return;
        }
        sendStartFrame(webSocket);
        this.stat.updateAfterStartFrameTime();
        sendAudioFrames(webSocket);
        if (this.isClosed) {
            logger.severe("websocket is closed, stop transferring frames ");
        } else {
            sendFinishFrame(webSocket);
            this.stat.updateAfterFinishFrameTime();
        }
    }

    public Stat getStat() {
        return this.stat;
    }

    public abstract void sendAudioFrames(WebSocket webSocket);

    public int sendBytes(WebSocket webSocket, byte[] buffer) {
        return sendBytes(webSocket, buffer, buffer.length);
    }

    public void sendCancelFrame(WebSocket webSocket) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "CANCEL");
        logger.info("send CANCEL FRAME:" + jSONObject.toString());
        webSocket.send(jSONObject.toString());
    }

    public void sendFinishFrame(WebSocket webSocket) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "FINISH");
        logger.info("send FINISH FRAME:" + jSONObject.toString());
        webSocket.send(jSONObject.toString());
    }

    public void sendStartFrame(WebSocket webSocket) throws JSONException {
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
        logger.info("send start FRAME:" + jSONObject2.toString());
        webSocket.send(jSONObject2.toString());
    }

    public void setClosed() {
        this.isClosed = true;
    }

    public int sendBytes(WebSocket webSocket, byte[] buffer, int size) {
        if (size > 0) {
            webSocket.send(ByteString.of(buffer, 0, size));
            return Util.bytesToTime(size);
        }
        if (size != 0) {
            return 0;
        }
        logger.severe("read size is 0");
        return 100;
    }
}
