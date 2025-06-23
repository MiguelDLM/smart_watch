package com.bytedance.android.live.base.api.push;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.push.model.PushData;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;

/* loaded from: classes8.dex */
public interface ILivePush {
    public static final String TAG = "livePush";

    /* loaded from: classes8.dex */
    public static class ClickType {
        public static final String CLOSE = "close";
        public static final String LIVE = "live";
        private String value;

        public ClickType() {
        }

        public final String getValue() {
            return this.value;
        }

        public ClickType(String str) {
            this.value = str;
        }
    }

    /* loaded from: classes8.dex */
    public static class PushType {
        public static final int CLOD_LAUNCH = 2;
        public static final int SELF_DRIVING = 1;
        public static final int VIDEO = 3;
        private int value;

        public PushType() {
        }

        public final int getValue() {
            return this.value;
        }

        public PushType(int i) {
            this.value = i;
        }
    }

    void addPushInterceptor(PushInterceptor pushInterceptor);

    void clickPush(PushData pushData, Context context);

    void dismiss();

    void enterRoom(Context context, PushData pushData);

    boolean isShowing();

    void removePushInterceptor(PushInterceptor pushInterceptor);

    void reportPushClick(PushData pushData, ClickType clickType);

    void reportShow(PushData pushData);

    void requestPush(PushCallback pushCallback);

    void requestPushAndShow(boolean z, Activity activity, PushType pushType, PushCallback pushCallback, PushUIConfig pushUIConfig);

    void requestPushAndShow(boolean z, Activity activity, PushType pushType, PushCallback pushCallback, PushUIConfig pushUIConfig, Bundle bundle);
}
