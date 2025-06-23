package com.baidu.navisdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNScaleLevelView {
    private static final String TAG = "BNScaleLevelView";
    private BNScaleLevelViewPlugin mBNScaleLevelViewPlugin;
    private View mContentView;
    private Context mContext;
    private boolean visibility;
    private TextView mScaleTitle = null;
    private TextView mScaleIndicator = null;
    private ImageView mScaleLogo = null;
    private View mAppNameIV = null;
    private View mScaleView = null;
    private View mScaleInnerView = null;

    private View inflateView(Context context, int i, boolean z) {
        if (z) {
            return b.a(context, i, null);
        }
        return JarUtils.inflate(context, i, null);
    }

    private boolean init(Context context, View view) {
        if (view != null && context != null) {
            this.mContentView = view;
            this.mContext = context;
            this.mScaleTitle = (TextView) view.findViewById(R.id.scale_title);
            this.mScaleIndicator = (TextView) view.findViewById(R.id.scale_indicator);
            this.mAppNameIV = view.findViewById(R.id.app_name);
            this.mScaleLogo = (ImageView) view.findViewById(R.id.baidu_map_logo);
            this.mScaleInnerView = view.findViewById(R.id.scale_inner_container);
            this.mScaleView = view.findViewById(R.id.map_scale_level_layout);
            if (this.mAppNameIV != null && j.d()) {
                this.mAppNameIV.setVisibility(8);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchMode(int i) {
        if (i == 1) {
            this.mScaleInnerView.setVisibility(8);
            this.mScaleLogo.setVisibility(0);
        } else {
            this.mScaleInnerView.setVisibility(0);
            this.mScaleLogo.setVisibility(8);
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public void hide() {
        this.mScaleView.setVisibility(8);
        this.visibility = false;
    }

    public void initView(Context context, View view) {
        if (init(context, view)) {
            this.mBNScaleLevelViewPlugin = new BNScaleLevelViewPlugin(new BNScaleLevelViewPlugin.SwitchModeCallback() { // from class: com.baidu.navisdk.ui.widget.BNScaleLevelView.1
                @Override // com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin.SwitchModeCallback
                public void switchMode(int i) {
                    BNScaleLevelView.this.onSwitchMode(i);
                }
            });
        }
    }

    public boolean isShown() {
        View view = this.mContentView;
        if (view != null && view.isShown()) {
            return true;
        }
        return false;
    }

    public View onCreateView(Context context) {
        View a2 = b.a(context, R.layout.nsdk_layout_scale_level, null);
        initView(context, a2);
        return a2;
    }

    @SuppressLint({"NewApi"})
    public void onUpdateStyle(boolean z) {
        int i;
        TextView textView = this.mScaleTitle;
        if (textView != null) {
            if (z) {
                i = -13223362;
            } else {
                i = -1052432;
            }
            textView.setTextColor(i);
        }
        TextView textView2 = this.mScaleIndicator;
        if (textView2 != null) {
            textView2.setBackgroundDrawable(b.c(R.drawable.nsdk_common_ic_scale_indicator, z));
        }
    }

    public void release() {
        BNScaleLevelViewPlugin bNScaleLevelViewPlugin = this.mBNScaleLevelViewPlugin;
        if (bNScaleLevelViewPlugin != null) {
            bNScaleLevelViewPlugin.release();
        }
    }

    public void setLogoMargin(int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mScaleLogo.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.bottomMargin = i4;
        this.mScaleLogo.setLayoutParams(layoutParams);
    }

    public void show() {
        this.mScaleView.setVisibility(0);
        this.visibility = true;
    }

    public void updateScaleView(String str, int i) {
        this.mScaleTitle.setText(str);
        this.mScaleIndicator.setWidth(i);
    }

    public void updateScaleViewMode(int i) {
        this.mBNScaleLevelViewPlugin.switchScaleViewMode(i);
    }

    public void initView(Context context, View view, long j) {
        if (init(context, view)) {
            this.mBNScaleLevelViewPlugin = new BNScaleLevelViewPlugin(new BNScaleLevelViewPlugin.SwitchModeCallback() { // from class: com.baidu.navisdk.ui.widget.BNScaleLevelView.2
                @Override // com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin.SwitchModeCallback
                public void switchMode(int i) {
                    BNScaleLevelView.this.onSwitchMode(i);
                }
            }, j);
        }
    }

    public View onCreateView(Context context, boolean z) {
        View inflateView = inflateView(context, R.layout.nsdk_layout_scale_level, z);
        initView(context, inflateView);
        return inflateView;
    }

    public boolean updateScaleView() {
        int i;
        String str;
        int screenWidth = BNMapController.getInstance().getScreenWidth();
        if (screenWidth <= 0) {
            LogUtil.e(TAG, "updateScaleView,scrWidth-0=" + screenWidth);
            screenWidth = ScreenUtil.getInstance().getWidthPixels();
        }
        if (screenWidth <= 0) {
            LogUtil.e(TAG, "updateScaleView,scrWidth-1=" + screenWidth);
            return false;
        }
        int zoomLevel = BNMapController.getInstance().getZoomLevel();
        double zoomUnitsInMeter = BNMapController.getInstance().getZoomUnitsInMeter();
        int o = com.baidu.nplatform.comapi.map.j.o(zoomLevel);
        LogUtil.e(TAG, "updateScaleView,dis=" + o + " level=" + zoomLevel + " scrWidht=" + screenWidth + " u=" + zoomUnitsInMeter);
        double ceil = Math.ceil(((double) o) / zoomUnitsInMeter);
        while (true) {
            i = (int) ceil;
            if (i <= screenWidth / 2 || zoomLevel < 4 || zoomLevel > 21) {
                break;
            }
            zoomLevel++;
            o = com.baidu.nplatform.comapi.map.j.o(zoomLevel);
            ceil = Math.ceil(o / zoomUnitsInMeter);
        }
        if (o >= 1000) {
            str = (o / 1000) + JarUtils.getResources().getString(R.string.nsdk_string_mapcontrol_panel_kilometer);
        } else {
            str = o + JarUtils.getResources().getString(R.string.nsdk_string_mapcontrol_panel_meter);
        }
        updateScaleView(str, i);
        return true;
    }
}
