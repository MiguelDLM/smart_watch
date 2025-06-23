package com.bytedance.android.live.base.api.push;

/* loaded from: classes8.dex */
public interface PushInterceptor {

    /* loaded from: classes8.dex */
    public static class InterceptResult {
        public boolean intercept;
        public String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z) {
            this(z, "");
        }

        public InterceptResult(boolean z, String str) {
            this.intercept = z;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
