package com.baidu.navisdk.ugc.dialog;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class e extends f {
    private View c;

    public e(Activity activity, View view, int i) {
        super(activity, R.style.UgcPreviewPicDialog);
        boolean z;
        if (i != 2 && i != 4) {
            z = false;
        } else {
            z = true;
        }
        this.f8029a = z;
        this.c = view;
        setContentView(view);
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        View view = this.c;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        this.c = null;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog
    public void show() {
        super.show();
    }
}
