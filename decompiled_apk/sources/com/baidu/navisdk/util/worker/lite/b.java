package com.baidu.navisdk.util.worker.lite;

import com.baidu.navisdk.util.worker.f;

/* loaded from: classes8.dex */
public abstract class b extends f<String, String> implements Runnable {
    public b(String str) {
        super(str, null);
    }

    public abstract void run();

    @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
    public final String execute() {
        run();
        return null;
    }
}
