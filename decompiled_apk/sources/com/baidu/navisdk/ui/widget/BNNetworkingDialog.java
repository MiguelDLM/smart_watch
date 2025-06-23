package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNNetworkingDialog extends BNBaseDialog {
    private OnBackPressedListener mBackPressedListener;
    private TextView mConfirmNetworkingTv;
    private LinearLayout mContentLayout;
    private TextView mDownloadOfflinedataTv;
    private TextView mNetworkingCancleTv;
    private TextView mNetworkingContent;

    /* loaded from: classes8.dex */
    public interface OnBackPressedListener {
        void onBackPressed();
    }

    public BNNetworkingDialog(Activity activity) {
        super(activity);
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_network_dialog, null);
        setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rp_alert_notification));
        setContent(inflate);
        this.mContentLayout = (LinearLayout) inflate.findViewById(R.id.content_layout);
        this.mNetworkingContent = (TextView) inflate.findViewById(R.id.networking_content);
        this.mConfirmNetworkingTv = (TextView) inflate.findViewById(R.id.confirm_networking_tv);
        this.mDownloadOfflinedataTv = (TextView) inflate.findViewById(R.id.dl_offline_data_tv);
        this.mNetworkingCancleTv = (TextView) inflate.findViewById(R.id.network_cancle_tv);
        setCanceledOnTouchOutside(false);
        initStyle();
    }

    public void initStyle() {
        TextView textView = this.mConfirmNetworkingTv;
        int i = R.drawable.nsdk_common_dialog_middle;
        textView.setBackgroundDrawable(b.f(i));
        this.mDownloadOfflinedataTv.setBackgroundDrawable(b.f(i));
        this.mNetworkingCancleTv.setBackgroundDrawable(b.f(i));
        this.mNetworkingContent.setTextColor(b.b(R.color.nsdk_color_dialog_content_text));
        TextView textView2 = this.mConfirmNetworkingTv;
        int i2 = R.color.nsdk_color_dialog_other_btn_text;
        textView2.setTextColor(b.b(i2));
        this.mDownloadOfflinedataTv.setTextColor(b.b(i2));
        this.mNetworkingCancleTv.setTextColor(b.b(i2));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        OnBackPressedListener onBackPressedListener = this.mBackPressedListener;
        if (onBackPressedListener != null) {
            onBackPressedListener.onBackPressed();
        }
    }

    public BNNetworkingDialog setCancleListener(View.OnClickListener onClickListener) {
        this.mNetworkingCancleTv.setOnClickListener(onClickListener);
        return this;
    }

    public BNNetworkingDialog setConfirmNetworkMessage(String str) {
        this.mConfirmNetworkingTv.setText(str);
        return this;
    }

    public BNNetworkingDialog setConfirmNetworkingListener(View.OnClickListener onClickListener) {
        this.mConfirmNetworkingTv.setOnClickListener(onClickListener);
        return this;
    }

    public BNNetworkingDialog setDownloadListener(View.OnClickListener onClickListener) {
        this.mDownloadOfflinedataTv.setOnClickListener(onClickListener);
        return this;
    }

    public BNNetworkingDialog setNetworkingContentMessage(String str) {
        this.mNetworkingContent.setText(str);
        return this;
    }

    public BNNetworkingDialog setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.mBackPressedListener = onBackPressedListener;
        return this;
    }

    public BNNetworkingDialog setOneButtonMode(boolean z) {
        if (z) {
            this.mDownloadOfflinedataTv.setVisibility(8);
            this.mNetworkingCancleTv.setVisibility(8);
        }
        return this;
    }

    public BNNetworkingDialog setTwoButtonMode(boolean z) {
        if (z) {
            this.mDownloadOfflinedataTv.setVisibility(8);
        }
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog, android.app.Dialog
    public void show() {
        initStyle();
        super.show();
    }
}
