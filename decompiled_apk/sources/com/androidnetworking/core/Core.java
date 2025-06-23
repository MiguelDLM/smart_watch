package com.androidnetworking.core;

/* loaded from: classes.dex */
public class Core {
    private static Core sInstance;
    private final ExecutorSupplier mExecutorSupplier = new DefaultExecutorSupplier();

    private Core() {
    }

    public static Core getInstance() {
        if (sInstance == null) {
            synchronized (Core.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new Core();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public static void shutDown() {
        if (sInstance != null) {
            sInstance = null;
        }
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mExecutorSupplier;
    }
}
