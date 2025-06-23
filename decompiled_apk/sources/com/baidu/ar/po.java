package com.baidu.ar;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class po implements ThreadFactory {
    private final ThreadFactory JR = Executors.defaultThreadFactory();
    private final AtomicInteger JS = new AtomicInteger(1);
    private final String JT;

    public po(String str) {
        this.JT = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.JR.newThread(runnable);
        newThread.setName(this.JT + HelpFormatter.DEFAULT_OPT_PREFIX + this.JS);
        return newThread;
    }
}
