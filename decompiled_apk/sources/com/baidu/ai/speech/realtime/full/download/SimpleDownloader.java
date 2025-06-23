package com.baidu.ai.speech.realtime.full.download;

import com.baidu.ai.speech.realtime.full.util.Stat;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public class SimpleDownloader {
    private static Logger logger = Logger.getLogger("SimpleDownloader");

    public void onFailure(String reason) {
    }

    public void onMessage(Result result) {
        if (!result.isHeartBeat()) {
            logger.fine(Stat.formatResult(result).toString());
        }
    }
}
