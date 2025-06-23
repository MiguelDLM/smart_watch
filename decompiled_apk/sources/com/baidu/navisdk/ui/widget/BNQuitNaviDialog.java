package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNQuitNaviDialog extends Dialog {
    public static final int TYPE_COMPLETE_UGC = 2;
    public static final int TYPE_QUIT_NAVI = 1;
    private TextView cancleTv;
    private TextView completeUgcInfoTv;
    private OnNaviClickListener listener;
    private TextView quitNaviTv;

    /* loaded from: classes8.dex */
    public interface OnNaviClickListener {
        void onClick(int i);
    }

    public BNQuitNaviDialog(Activity activity) {
        super(activity, R.style.BNDialog);
        this.listener = null;
        this.quitNaviTv = null;
        this.cancleTv = null;
        this.completeUgcInfoTv = null;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_quit_navi_dialog, null);
        try {
            setContentView(inflate);
            this.completeUgcInfoTv = (TextView) inflate.findViewById(R.id.complete_ugc_info_tv);
            this.cancleTv = (TextView) inflate.findViewById(R.id.cancle_tv);
            this.quitNaviTv = (TextView) inflate.findViewById(R.id.quit_navi_tv);
            this.completeUgcInfoTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNQuitNaviDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNQuitNaviDialog.this.listener != null) {
                        BNQuitNaviDialog.this.listener.onClick(2);
                    }
                }
            });
            this.cancleTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNQuitNaviDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BNQuitNaviDialog.this.dismiss();
                }
            });
            this.quitNaviTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNQuitNaviDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BNQuitNaviDialog.this.listener != null) {
                        BNQuitNaviDialog.this.listener.onClick(1);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        TextView textView = this.quitNaviTv;
        if (textView != null) {
            textView.performClick();
        }
    }

    public BNQuitNaviDialog setOnBtnClickListener(OnNaviClickListener onNaviClickListener) {
        this.listener = onNaviClickListener;
        return this;
    }

    public void setUgcInfoTv(boolean z) {
        TextView textView = this.completeUgcInfoTv;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
