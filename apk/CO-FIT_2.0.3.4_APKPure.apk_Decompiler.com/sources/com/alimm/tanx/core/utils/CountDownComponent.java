package com.alimm.tanx.core.utils;

import android.widget.TextView;
import androidx.annotation.NonNull;

public class CountDownComponent {
    private final TextView tanxc_do;
    private final int tanxc_for;
    private final TanxCountDownTimer tanxc_if;
    /* access modifiers changed from: private */
    public int tanxc_int;
    private boolean tanxc_new = false;
    /* access modifiers changed from: private */
    public OnFinishListener tanxc_try;

    public interface OnFinishListener {
        void onFinish();
    }

    public CountDownComponent(@NonNull TextView textView, int i, OnFinishListener onFinishListener) {
        this.tanxc_do = textView;
        this.tanxc_for = i;
        this.tanxc_try = onFinishListener;
        this.tanxc_if = new TanxCountDownTimer((long) ((i * 1000) + 300), 300) {
            public void onFinish() {
                LogUtils.d("CountDownComponent", "onFinish.");
                if (CountDownComponent.this.tanxc_try != null) {
                    CountDownComponent.this.tanxc_try.onFinish();
                }
            }

            public void onTick(long j) {
                int unused = CountDownComponent.this.tanxc_int = Math.round(((float) j) / 1000.0f);
                LogUtils.d("CountDownComponent", "onTick: millisUntilFinished = " + j + " mCurrentCount :" + CountDownComponent.this.tanxc_int);
                if (CountDownComponent.this.tanxc_int < 1) {
                    int unused2 = CountDownComponent.this.tanxc_int = 1;
                }
                CountDownComponent countDownComponent = CountDownComponent.this;
                countDownComponent.tanxc_do(countDownComponent.tanxc_int);
            }
        };
    }

    public void tanxc_for() {
        TanxCountDownTimer tanxCountDownTimer = this.tanxc_if;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.pause();
        }
    }

    public void tanxc_int() {
        TanxCountDownTimer tanxCountDownTimer = this.tanxc_if;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.resume();
        }
    }

    public void tanxc_if() {
        TanxCountDownTimer tanxCountDownTimer;
        if (this.tanxc_new && (tanxCountDownTimer = this.tanxc_if) != null) {
            tanxCountDownTimer.cancel();
            this.tanxc_new = false;
        }
        this.tanxc_try = null;
    }

    public void tanxc_do() {
        LogUtils.d("CountDownComponent", "startCountDown: mCurrentCount = " + this.tanxc_int + ", mIsTimerStarted = " + this.tanxc_new + ", mCountDownTimer = " + this.tanxc_if);
        if (!this.tanxc_new && this.tanxc_if != null) {
            this.tanxc_do.setText(String.valueOf(this.tanxc_for));
            this.tanxc_if.start();
            this.tanxc_new = true;
        }
    }

    public void tanxc_do(int i) {
        TextView textView = this.tanxc_do;
        if (textView != null && i > 0) {
            textView.setText(String.valueOf(i));
        }
    }
}
