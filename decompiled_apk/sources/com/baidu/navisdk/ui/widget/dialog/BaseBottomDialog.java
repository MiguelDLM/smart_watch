package com.baidu.navisdk.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.b;

/* loaded from: classes8.dex */
public class BaseBottomDialog extends Dialog {
    public BaseBottomDialog(@NonNull Context context) {
        super(context, R.style.BNBottomDialogStyle);
        initWindow();
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        b.f(true);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b.f(false);
        b.a();
    }
}
