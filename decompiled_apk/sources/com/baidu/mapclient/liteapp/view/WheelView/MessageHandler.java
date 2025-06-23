package com.baidu.mapclient.liteapp.view.WheelView;

import android.os.Handler;
import android.os.Message;
import com.baidu.mapclient.liteapp.view.WheelView.WheelView;

/* loaded from: classes7.dex */
final class MessageHandler extends Handler {
    static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    static final int WHAT_ITEM_SELECTED = 3000;
    static final int WHAT_SMOOTH_SCROLL = 2000;
    private WheelView loopview;

    public MessageHandler(WheelView wheelView) {
        this.loopview = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1000) {
            if (i != 2000) {
                if (i == 3000) {
                    this.loopview.onItemSelected();
                    return;
                }
                return;
            }
            this.loopview.smoothScroll(WheelView.ACTION.FLING);
            return;
        }
        this.loopview.invalidate();
    }
}
