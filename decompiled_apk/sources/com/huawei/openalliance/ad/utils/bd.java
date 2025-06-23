package com.huawei.openalliance.ad.utils;

/* loaded from: classes10.dex */
public class bd implements Runnable {
    private static final String Code = "TaskWrapper";
    private Runnable V;

    public bd(Runnable runnable) {
        this.V = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.V;
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
