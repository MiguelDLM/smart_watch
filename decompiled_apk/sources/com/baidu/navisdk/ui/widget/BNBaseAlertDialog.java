package com.baidu.navisdk.ui.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* loaded from: classes8.dex */
public class BNBaseAlertDialog extends AlertDialog {
    public BNBaseAlertDialog(Context context) {
        super(context);
    }

    public BNBaseAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public BNBaseAlertDialog(Context context, int i) {
        super(context, i);
    }
}
