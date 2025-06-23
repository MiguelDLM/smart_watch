package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class tanxc_do extends Dialog {
    public tanxc_do(@NonNull Context context, int i) {
        super(context, i);
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null, false));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
