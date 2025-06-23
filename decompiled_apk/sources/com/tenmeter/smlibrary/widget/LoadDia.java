package com.tenmeter.smlibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tenmeter.smlibrary.R;

/* loaded from: classes13.dex */
public class LoadDia extends Dialog {
    public LoadDia(@NonNull Context context) {
        super(context, R.style.LoadDiaStyle);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sm_sdk_device_loading);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public LoadDia(@NonNull Context context, int i) {
        super(context, R.style.LoadDiaStyle);
    }

    public LoadDia(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
