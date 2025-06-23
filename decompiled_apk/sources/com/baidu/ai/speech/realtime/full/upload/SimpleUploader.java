package com.baidu.ai.speech.realtime.full.upload;

import com.baidu.ai.speech.realtime.Util;
import com.baidu.ai.speech.realtime.full.util.Stat;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import okhttp3.WebSocket;

/* loaded from: classes7.dex */
public class SimpleUploader extends AbstractUploader {
    private static Logger logger = Logger.getLogger("SimpleUploader");

    public SimpleUploader(InputStream inputStream, Stat stat) {
        super(inputStream, stat);
    }

    @Override // com.baidu.ai.speech.realtime.full.upload.AbstractUploader
    public void sendAudioFrames(WebSocket webSocket) {
        int i;
        logger.info("begin to send DATA frames");
        byte[] bArr = new byte[Util.BYTES_PER_FRAME];
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        while (!this.isClosed) {
            Util.sleep(currentTimeMillis - System.currentTimeMillis());
            try {
                i = this.inputStream.read(bArr);
            } catch (IOException | RuntimeException e) {
                logger.warning("inputstream is closed:" + e.getClass().getSimpleName() + ":" + e.getMessage());
                i = -2;
            }
            if (i >= 0) {
                i2 += i;
                logger.finer("should wait to send next DATA Frame: " + Util.bytesToTime(i) + "ms | send binary bytes size :" + i + " | total size : " + i2);
            }
            long currentTimeMillis2 = System.currentTimeMillis() + sendBytes(webSocket, bArr, i);
            if (i < 0) {
                return;
            } else {
                currentTimeMillis = currentTimeMillis2;
            }
        }
        logger.severe("websocket has been closed");
    }
}
