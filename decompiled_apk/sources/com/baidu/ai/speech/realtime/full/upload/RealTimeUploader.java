package com.baidu.ai.speech.realtime.full.upload;

import com.baidu.ai.speech.realtime.Util;
import com.baidu.ai.speech.realtime.full.util.Stat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import okhttp3.WebSocket;

/* loaded from: classes7.dex */
public class RealTimeUploader extends AbstractUploader {
    private static Logger logger = Logger.getLogger("RealTimeUploader");

    public RealTimeUploader(InputStream inputStream, Stat stat) {
        super(inputStream, stat);
    }

    @Override // com.baidu.ai.speech.realtime.full.upload.AbstractUploader
    public void sendAudioFrames(WebSocket webSocket) {
        int i;
        byte[] bArr = new byte[Util.BYTES_PER_FRAME];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (!this.isClosed) {
            try {
                i = this.inputStream.read(bArr);
            } catch (IOException | RuntimeException e) {
                logger.warning("inputstream is closed:" + e.getClass().getSimpleName() + ":" + e.getMessage());
                i = -2;
            }
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
                if (byteArrayOutputStream.size() >= 5120) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    sendBytes(webSocket, byteArray);
                    byteArrayOutputStream.reset();
                    byteArrayOutputStream.write(byteArray, Util.BYTES_PER_FRAME, byteArray.length - Util.BYTES_PER_FRAME);
                    i2 += Util.BYTES_PER_FRAME;
                    logger.finer("should wait to send next DATA Frame: 160ms | send binary bytes size :" + Util.BYTES_PER_FRAME + " | total size: " + i2);
                }
            } else if (i == -1) {
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                if (byteArray2.length > 0) {
                    sendBytes(webSocket, byteArray2);
                    i2 += byteArray2.length;
                    logger.finer("last pack send size " + byteArray2.length + " | total size :" + i2);
                }
            }
            if (i < 0) {
                return;
            }
        }
        logger.severe("websocket is closed before all data sent");
    }
}
