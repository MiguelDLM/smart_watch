package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class BNLoadingView extends RelativeLayout {
    public static final int LOAD_END = 2;
    public static final int LOAD_FAILE = 3;
    public static final int LOAD_START = 1;
    private RelativeLayout mLoadFailTab;
    private RelativeLayout mLoadStartTab;
    private BNResultErrorView mRouteErrorView;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface LoadStatus {
    }

    public BNLoadingView(Context context) {
        super(context);
        this.mLoadStartTab = null;
        this.mLoadFailTab = null;
        this.mRouteErrorView = null;
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_rr_route_loading, (ViewGroup) this, true);
        this.mLoadStartTab = (RelativeLayout) findViewById(R.id.load_plan_start);
        this.mLoadFailTab = (RelativeLayout) findViewById(R.id.load_plan_result);
        this.mRouteErrorView = (BNResultErrorView) findViewById(R.id.route_error_view);
    }

    private void setMapClickable(boolean z) {
        RelativeLayout relativeLayout = this.mLoadStartTab;
        if (relativeLayout != null) {
            if (!z) {
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNLoadingView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            } else {
                relativeLayout.setOnClickListener(null);
            }
        }
    }

    public void resetBottomLoadtab(int i) {
        if (i == 1) {
            setVisibility(0);
            RelativeLayout relativeLayout = this.mLoadStartTab;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            RelativeLayout relativeLayout2 = this.mLoadFailTab;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            setMapClickable(false);
            return;
        }
        if (i == 3) {
            setVisibility(0);
            RelativeLayout relativeLayout3 = this.mLoadStartTab;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
            RelativeLayout relativeLayout4 = this.mLoadFailTab;
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(0);
            }
            setMapClickable(true);
            return;
        }
        if (i == 2) {
            setVisibility(8);
            RelativeLayout relativeLayout5 = this.mLoadStartTab;
            if (relativeLayout5 != null) {
                relativeLayout5.setVisibility(8);
            }
            RelativeLayout relativeLayout6 = this.mLoadFailTab;
            if (relativeLayout6 != null) {
                relativeLayout6.setVisibility(8);
            }
            setMapClickable(true);
        }
    }

    public void setErrorRepeatBtnListener(View.OnClickListener onClickListener) {
        BNResultErrorView bNResultErrorView = this.mRouteErrorView;
        if (bNResultErrorView != null) {
            bNResultErrorView.setRepeatButtonListener(onClickListener);
        }
    }

    public void setErrorViewText(String str, boolean z) {
        setErrorViewText(str, "重试", z);
    }

    public void setErrorViewText(String str, String str2, boolean z) {
        if (this.mRouteErrorView != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "重试";
            }
            this.mRouteErrorView.setText(str);
            this.mRouteErrorView.setRepeatText(str2);
            if (z) {
                this.mRouteErrorView.setmRepeatButtonVisible();
            } else {
                this.mRouteErrorView.setmRepeatButtonGone();
            }
        }
    }

    public BNLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLoadStartTab = null;
        this.mLoadFailTab = null;
        this.mRouteErrorView = null;
        initView(context);
    }

    public BNLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLoadStartTab = null;
        this.mLoadFailTab = null;
        this.mRouteErrorView = null;
        initView(context);
    }
}
