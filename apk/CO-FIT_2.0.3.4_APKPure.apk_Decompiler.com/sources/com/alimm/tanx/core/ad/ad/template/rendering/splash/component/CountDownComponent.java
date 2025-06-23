package com.alimm.tanx.core.ad.ad.template.rendering.splash.component;

import android.widget.TextView;

public class CountDownComponent {
    private final TextView tanxc_do;
    /* access modifiers changed from: private */
    public OnFinishListener tanxc_for;
    /* access modifiers changed from: private */
    public int tanxc_if;

    public interface OnFinishListener {
        void onFinish();
    }

    public void tanxc_do(int i) {
        TextView textView = this.tanxc_do;
        if (textView != null && i > 0) {
            textView.setText(String.valueOf(i));
        }
    }
}
