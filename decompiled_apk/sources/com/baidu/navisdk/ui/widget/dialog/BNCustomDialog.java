package com.baidu.navisdk.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.listener.IDialogViewClickListener;
import com.baidu.navisdk.util.worker.lite.a;
import com.baidu.navisdk.util.worker.lite.b;

/* loaded from: classes8.dex */
public class BNCustomDialog extends Dialog implements IDialogViewClickListener, View.OnClickListener {
    private static final String TAG = "CustomDialog";
    private boolean cancelTouchout;
    private Context context;
    private long delayDismissTime;
    private int height;
    private b mCancelDialogDelayRunnable;
    private int resStyle;
    private View view;
    private int width;

    /* loaded from: classes8.dex */
    public static final class Builder {
        private boolean cancelTouchout;
        private final Context context;
        private View view;
        private int height = -1;
        private int width = -1;
        private int resStyle = -1;
        private long delayDismissTime = -1;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder addViewOnclick(int i, View.OnClickListener onClickListener) {
            this.view.findViewById(i).setOnClickListener(onClickListener);
            return this;
        }

        public BNCustomDialog build() {
            int i = this.resStyle;
            if (i == -1) {
                i = R.style.BNDialog;
            }
            return new BNCustomDialog(this, i);
        }

        public Builder cancelTouchout(boolean z) {
            this.cancelTouchout = z;
            return this;
        }

        public Builder heightDimenRes(int i) {
            this.height = this.context.getResources().getDimensionPixelOffset(i);
            return this;
        }

        public Builder heightdp(int i) {
            this.height = BNCustomDialog.dip2px(this.context, i);
            return this;
        }

        public Builder heightpx(int i) {
            this.height = i;
            return this;
        }

        public Builder setContentView(int i) {
            this.view = LayoutInflater.from(this.context).inflate(i, (ViewGroup) null);
            return this;
        }

        public Builder setDelayDismissTime(long j) {
            this.delayDismissTime = j;
            return this;
        }

        public Builder setViewText(int i, String str) {
            if (this.view.findViewById(i) instanceof TextView) {
                ((TextView) this.view.findViewById(i)).setText(str);
                ((TextView) this.view.findViewById(i)).setVisibility(0);
            }
            return this;
        }

        public Builder style(int i) {
            this.resStyle = i;
            return this;
        }

        public Builder widthDimenRes(int i) {
            this.width = this.context.getResources().getDimensionPixelOffset(i);
            return this;
        }

        public Builder widthdp(int i) {
            this.width = BNCustomDialog.dip2px(this.context, i);
            return this;
        }

        public Builder widthpx(int i) {
            this.width = i;
            return this;
        }
    }

    public BNCustomDialog(@NonNull Context context) {
        super(context);
        this.height = -1;
        this.width = -1;
        this.resStyle = -1;
        this.delayDismissTime = -1L;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        b bVar = this.mCancelDialogDelayRunnable;
        if (bVar != null) {
            a.a(bVar);
        }
    }

    @Override // android.app.Dialog
    public void hide() {
        super.hide();
        b bVar = this.mCancelDialogDelayRunnable;
        if (bVar != null) {
            a.a(bVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.view);
        setCanceledOnTouchOutside(this.cancelTouchout);
    }

    @Override // com.baidu.navisdk.ui.widget.listener.IDialogViewClickListener
    public void onDialogViewClickListener(View view) {
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        int i = this.height;
        int i2 = -2;
        if (i == -1) {
            i = -2;
        }
        attributes.height = i;
        int i3 = this.width;
        if (i3 != -1) {
            i2 = i3;
        }
        attributes.width = i2;
        window.setAttributes(attributes);
        if (this.delayDismissTime != -1) {
            if (this.mCancelDialogDelayRunnable == null) {
                this.mCancelDialogDelayRunnable = new b("CustomDialog::mCancelDialogDelayRunnable") { // from class: com.baidu.navisdk.ui.widget.dialog.BNCustomDialog.1
                    @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
                    public void run() {
                        BNCustomDialog.this.dismiss();
                    }
                };
            }
            a.a(this.mCancelDialogDelayRunnable, this.delayDismissTime);
        }
    }

    public BNCustomDialog(Builder builder, int i) {
        super(builder.context, i);
        this.height = -1;
        this.width = -1;
        this.resStyle = -1;
        this.delayDismissTime = -1L;
        this.context = builder.context;
        this.height = builder.height;
        this.width = builder.width;
        this.cancelTouchout = builder.cancelTouchout;
        this.view = builder.view;
        this.delayDismissTime = builder.delayDismissTime;
        this.resStyle = i;
    }
}
