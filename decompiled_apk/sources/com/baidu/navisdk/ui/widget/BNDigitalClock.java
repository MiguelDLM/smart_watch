package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Calendar;

/* loaded from: classes8.dex */
public class BNDigitalClock extends TextView {
    private static final String m12 = "现在h:mm";
    private static final String m24 = "现在k:mm";
    Calendar mCalendar;
    String mFormat;
    private Handler mHandler;
    private Runnable mTicker;
    private boolean mTickerStopped;

    public BNDigitalClock(Context context) {
        super(context);
        this.mTickerStopped = false;
        this.mFormat = m24;
        initClock(context);
    }

    private void initClock(Context context) {
        if (this.mCalendar == null) {
            this.mCalendar = Calendar.getInstance();
        }
        setFormat();
    }

    private void setFormat() {
        this.mFormat = m24;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        this.mTickerStopped = false;
        super.onAttachedToWindow();
        this.mHandler = new Handler();
        Runnable runnable = new Runnable() { // from class: com.baidu.navisdk.ui.widget.BNDigitalClock.1
            @Override // java.lang.Runnable
            public void run() {
                if (BNDigitalClock.this.mTickerStopped) {
                    return;
                }
                BNDigitalClock.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
                BNDigitalClock bNDigitalClock = BNDigitalClock.this;
                bNDigitalClock.setText(DateFormat.format(bNDigitalClock.mFormat, bNDigitalClock.mCalendar));
                BNDigitalClock.this.invalidate();
                long uptimeMillis = SystemClock.uptimeMillis();
                BNDigitalClock.this.mHandler.postAtTime(BNDigitalClock.this.mTicker, uptimeMillis + (1000 - (uptimeMillis % 1000)));
            }
        };
        this.mTicker = runnable;
        runnable.run();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTickerStopped = true;
    }

    public BNDigitalClock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTickerStopped = false;
        this.mFormat = m24;
        initClock(context);
    }
}
