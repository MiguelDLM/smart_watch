package com.baidu.navisdk.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mapframework.app.fpstack.Page;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.b;

/* loaded from: classes8.dex */
public abstract class BNNaviDeclareDialog extends Dialog {
    private BNDeclareClickListener mBNDeclareClickListener;

    /* loaded from: classes8.dex */
    public interface BNDeclareClickListener {
        void clickAgree();

        void clickDisAgree();
    }

    public BNNaviDeclareDialog(@NonNull Context context) {
        super(context, R.style.BNCommonFullScreen);
        View createView = createView(context);
        setContentView(createView);
        changeFullScreenStatus();
        createView.findViewById(R.id.bnav_declare_agree).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNNaviDeclareDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BNNaviDeclareDialog.this.mBNDeclareClickListener != null) {
                    BNNaviDeclareDialog.this.mBNDeclareClickListener.clickAgree();
                }
            }
        });
        createView.findViewById(R.id.bnav_declare_disagree).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNNaviDeclareDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BNNaviDeclareDialog.this.mBNDeclareClickListener != null) {
                    BNNaviDeclareDialog.this.mBNDeclareClickListener.clickDisAgree();
                }
            }
        });
    }

    private void changeFullScreenStatus() {
        int i = Build.VERSION.SDK_INT;
        getWindow().setStatusBarColor(statusBarColor());
        boolean z = false;
        if (supportFullScreen()) {
            if (i >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
                Window window = getWindow();
                if (pageStyle() != Page.PageStyle.BLACK) {
                    z = true;
                }
                b.a(window, z);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(1280);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(statusBarColor());
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(256);
        b.a(getWindow(), false);
    }

    private View createView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.bnav_declare_dialog, (ViewGroup) null);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.bnav_declare_scrollview);
        View onCreateView = onCreateView(context, viewGroup);
        if (onCreateView != null) {
            viewGroup.addView(onCreateView);
        }
        return inflate;
    }

    private Page.PageStyle pageStyle() {
        return Page.PageStyle.WHITE;
    }

    private int statusBarColor() {
        if (supportFullScreen()) {
            if (Build.VERSION.SDK_INT >= 23) {
                return 0;
            }
            return 754974720;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    private boolean supportFullScreen() {
        return true;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public abstract View onCreateView(Context context, ViewGroup viewGroup);

    public void setBNDeclareClickListener(BNDeclareClickListener bNDeclareClickListener) {
        this.mBNDeclareClickListener = bNDeclareClickListener;
    }
}
