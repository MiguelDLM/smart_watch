package com.baidu.ai.speech.realtime.full.upload;

import com.baidu.ai.speech.realtime.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public class RealTimeAudioFeeder {
    private static Logger logger = Logger.getLogger("RealTimeAudioFeeder");
    private InputStream inputStream;
    private volatile PipedInputStream pipedInputStream = new PipedInputStream();
    private PipedOutputStream pipedOutputStream = new PipedOutputStream(this.pipedInputStream);

    public RealTimeAudioFeeder(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
    }

    public InputStream getRealTimeInputStream() {
        return this.pipedInputStream;
    }

    public void startFeed() throws IOException {
        int i;
        byte[] bArr = new byte[Util.BYTES_PER_FRAME];
        do {
            try {
                i = this.inputStream.read(bArr);
            } catch (IOException | RuntimeException e) {
                logger.warning("inputstream is closed:" + e.getClass().getSimpleName() + ":" + e.getMessage());
                i = -2;
            }
            if (i > 0) {
                int bytesToTime = Util.bytesToTime(i);
                logger.finer("should wait to send next Frame: " + bytesToTime + "ms | feeded binary bytes size :" + i);
                this.pipedOutputStream.write(bArr, 0, i);
                this.pipedOutputStream.flush();
                Util.sleep((long) bytesToTime);
            } else if (i == 0) {
                logger.severe("read size is 0");
                Util.sleep(100L);
            }
        } while (i >= 0);
        this.pipedOutputStream.close();
    }
}
