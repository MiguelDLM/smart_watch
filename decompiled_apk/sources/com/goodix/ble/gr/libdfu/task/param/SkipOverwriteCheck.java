package com.goodix.ble.gr.libdfu.task.param;

import com.goodix.ble.libcomx.task.ITaskParameter;

/* loaded from: classes9.dex */
public class SkipOverwriteCheck implements ITaskParameter {

    /* renamed from: a, reason: collision with root package name */
    private boolean f16109a;

    public SkipOverwriteCheck(boolean z) {
        this.f16109a = z;
    }

    public boolean isSkip() {
        return this.f16109a;
    }

    public void setSkip(boolean z) {
        this.f16109a = z;
    }
}
