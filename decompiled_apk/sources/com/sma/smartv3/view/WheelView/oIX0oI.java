package com.sma.smartv3.view.WheelView;

import android.os.Handler;
import android.os.Message;
import com.sma.smartv3.view.WheelView.WheelView;

/* loaded from: classes12.dex */
public final class oIX0oI extends Handler {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f25429I0Io = 2000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f25430II0xO0 = 1000;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f25431oxoX = 3000;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public WheelView f25432oIX0oI;

    public oIX0oI(WheelView loopview) {
        this.f25432oIX0oI = loopview;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        int i = msg.what;
        if (i != 1000) {
            if (i != 2000) {
                if (i == 3000) {
                    this.f25432oIX0oI.XO();
                    return;
                }
                return;
            }
            this.f25432oIX0oI.OOXIXo(WheelView.ACTION.FLING);
            return;
        }
        this.f25432oIX0oI.invalidate();
    }
}
