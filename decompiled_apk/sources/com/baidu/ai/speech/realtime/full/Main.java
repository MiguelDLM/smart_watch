package com.baidu.ai.speech.realtime.full;

import com.baidu.ai.speech.realtime.full.connection.Runner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public class Main {
    public static final String FILENAME = "16k-0.pcm";
    private static final int MODE = 1;
    public static final Level LOG_LEVEL = Level.ALL;
    private static Logger logger = Logger.getLogger("Main");

    public static void main(String[] args) {
        String str;
        logger.getParent().setLevel(LOG_LEVEL);
        if (args.length >= 1) {
            str = args[0];
        } else {
            str = FILENAME;
        }
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT.%1$tL] [%4$-7s][%3$s] %5$s%6$s%n");
        Locale.setDefault(Locale.ENGLISH);
        File file = new File(str);
        logger.info("begin demo, will read " + file.getAbsolutePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            logger.info("file total size: " + fileInputStream.available());
            new Runner(fileInputStream, 1).run();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), (Throwable) e);
        }
    }
}
