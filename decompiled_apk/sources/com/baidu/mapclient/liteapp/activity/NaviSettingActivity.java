package com.baidu.mapclient.liteapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.mapclient.liteapp.BNUtils;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.szabh.navi.R;

/* loaded from: classes7.dex */
public class NaviSettingActivity extends Activity implements View.OnClickListener {
    private static final int AUTO_MODE_INDEX = 0;
    private static final int BOTTOM_BAR_INDEX = 7;
    private static final int DAY_MODE_INDEX = 1;
    private static final int DAY_NIGHT_MODE_OPTION_CNT = 3;
    private static final int FLOAT_WINDOW_INDEX = 12;
    private static final int GUIDE_VIEW_2D_INDEX = 1;
    private static final int GUIDE_VIEW_3D_INDEX = 0;
    private static final int GUIDE_VIEW_OPTION_CNT = 2;
    private static final int HIGHWAY_INDEX = 5;
    private static final int LANE_LINE_INDEX = 3;
    private static final int LIST_OPTION_CNT = 25;
    private static final int MAIN_AUXILIARY_OR_BRIDGE = 6;
    private static final int MEASUREMENT_INDEX = 4;
    private static final int MULTI_ROUTE_INDEX = 1;
    private static final int NAV_DISPLAY_MODE_OPTION_CNT = 2;
    private static final int NAV_DISPLAY_OVERVIEW_INDEX = 0;
    private static final int NAV_DISPLAY_ROAD_COND_BAR_INDEX = 1;
    private static final int NIGHT_MODE_INDEX = 2;
    private static final int REFRESH_BUTTON_INDEX = 10;
    private static final int ROAD_CONDITION_INDEX = 8;
    private static final int ROAD_NAME_INDEX = 2;
    private static final int SCALE_INDEX = 0;
    private static final String TAG = "DemoNaviSettingActivity";
    private static final int VOICE_BUTTON_INDEX = 9;
    private static final int ZOOM_BUTTON_INDEX = 11;
    String cariconoffsetx;
    String cariconoffsety;
    String carnum;
    EditText carnumEdit;
    EditText offsetx;
    EditText offsety;
    private View[] mGuideViewModeViews = new View[2];
    private TextView[] mGuideViewModeTVs = new TextView[2];
    private View[] mDayNightModeViews = new View[3];
    private TextView[] mDayNightModeTVs = new TextView[3];
    private View[] mNavDisplayModeViews = new View[2];
    private TextView[] mNavDisplayModeTVs = new TextView[2];
    private CheckBox[] mCheckBox = new CheckBox[25];
    private boolean[] mIsChecked = new boolean[25];

    private void initClickListener() {
        findViewById(R.id.bnav_view_north2d_layout).setOnClickListener(this);
        findViewById(R.id.bnav_view_car3d_layout).setOnClickListener(this);
        findViewById(R.id.bnav_auto_mode_layout).setOnClickListener(this);
        findViewById(R.id.bnav_day_mode_layout).setOnClickListener(this);
        findViewById(R.id.bnav_night_mode_layout).setOnClickListener(this);
        findViewById(R.id.nav_scale_cb).setOnClickListener(this);
        findViewById(R.id.nav_multi_route_cb).setOnClickListener(this);
        findViewById(R.id.nav_route_name_cb).setOnClickListener(this);
        findViewById(R.id.nav_lane_line_cb).setOnClickListener(this);
        findViewById(R.id.nav_measurement_cb).setOnClickListener(this);
        findViewById(R.id.nav_highway_cb).setOnClickListener(this);
        findViewById(R.id.nav_bridge_cb).setOnClickListener(this);
        findViewById(R.id.nav_bottom_bar_cb).setOnClickListener(this);
        findViewById(R.id.nav_road_condition_cb).setOnClickListener(this);
        findViewById(R.id.nav_voice_cb).setOnClickListener(this);
        findViewById(R.id.nav_refresh_cb).setOnClickListener(this);
        findViewById(R.id.nav_zoom_cb).setOnClickListener(this);
        findViewById(R.id.bnav_display_overview_mode_layout).setOnClickListener(this);
        findViewById(R.id.bnav_display_road_cond_mode_layout).setOnClickListener(this);
    }

    private void initUserConfig() {
        this.mIsChecked[0] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isAutoScale(1);
        this.mIsChecked[1] = BaiduNaviManagerFactory.getCommonSettingManager().isMultiRouteEnable();
        this.mIsChecked[2] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isRoadNameEnable();
        this.mIsChecked[3] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isLaneLineEnable();
        this.mIsChecked[4] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isMeasurementEnable();
        this.mIsChecked[5] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isHighwayEnable();
        this.mIsChecked[6] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isShowMainAuxiliaryOrBridge();
        this.mIsChecked[7] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isBottomBarOpen();
        this.mIsChecked[8] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isRoadConditionButtonVisible();
        this.mIsChecked[9] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isVoiceButtonVisible();
        this.mIsChecked[10] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isRefreshButtonVisible();
        this.mIsChecked[11] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isZoomButtonVisible();
        this.mIsChecked[12] = BNUtils.getBoolean(this, "float_window").booleanValue();
        this.mIsChecked[13] = BNUtils.getBoolean(this, BNUtils.KEY_GB_ICONSET).booleanValue();
        this.mIsChecked[14] = BNUtils.getBoolean(this, BNUtils.KEY_GB_ICONSHOW, true).booleanValue();
        this.mIsChecked[15] = BNUtils.getBoolean(this, BNUtils.KEY_GB_CARNUM).booleanValue();
        this.carnum = BNUtils.getString(this, BNUtils.KEY_GB_CARNUMTXT);
        this.mIsChecked[16] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isShowCarLogoToEndRedLine(1);
        this.mIsChecked[17] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isShowRoadEnlargeView(1);
        this.mIsChecked[18] = BaiduNaviManagerFactory.getProfessionalNaviSettingManager().isAutoQuitWhenArrived();
        this.mIsChecked[19] = BNUtils.getBoolean(this, BNUtils.KEY_GB_CARICONOFFSET).booleanValue();
        this.cariconoffsetx = BNUtils.getString(this, BNUtils.KEY_GB_CARICONOFFSET_X);
        this.cariconoffsety = BNUtils.getString(this, BNUtils.KEY_GB_CARICONOFFSET_Y);
        this.mIsChecked[20] = BNUtils.getBoolean(this, BNUtils.KEY_GB_MARGIN).booleanValue();
        this.mIsChecked[21] = BNUtils.getBoolean(this, BNUtils.KEY_GB_ROUTE_SORT, true).booleanValue();
        this.mIsChecked[22] = BNUtils.getBoolean(this, BNUtils.KEY_GB_ROUTE_SEARCH, true).booleanValue();
        this.mIsChecked[23] = BNUtils.getBoolean(this, BNUtils.KEY_GB_MORE_SETTINGS, true).booleanValue();
        this.mIsChecked[24] = BNUtils.getBoolean(this, BNUtils.KEY_GB_SEEALL).booleanValue();
    }

    private void initViews() {
        this.mGuideViewModeViews[0] = findViewById(R.id.bnav_view_car3d_layout);
        this.mGuideViewModeViews[1] = findViewById(R.id.bnav_view_north2d_layout);
        this.mGuideViewModeTVs[0] = (TextView) findViewById(R.id.bnav_view_car3d_tv);
        this.mGuideViewModeTVs[1] = (TextView) findViewById(R.id.bnav_view_north2d_tv);
        this.mDayNightModeViews[0] = findViewById(R.id.bnav_auto_mode_layout);
        this.mDayNightModeViews[1] = findViewById(R.id.bnav_day_mode_layout);
        this.mDayNightModeViews[2] = findViewById(R.id.bnav_night_mode_layout);
        this.mDayNightModeTVs[0] = (TextView) findViewById(R.id.bnav_auto_mode_tv);
        this.mDayNightModeTVs[1] = (TextView) findViewById(R.id.bnav_day_mode_tv);
        this.mDayNightModeTVs[2] = (TextView) findViewById(R.id.bnav_night_mode_tv);
        this.mNavDisplayModeViews[0] = findViewById(R.id.bnav_display_overview_mode_layout);
        this.mNavDisplayModeTVs[0] = (TextView) findViewById(R.id.nav_display_overview_mode_tv);
        this.mNavDisplayModeViews[1] = findViewById(R.id.bnav_display_road_cond_mode_layout);
        this.mNavDisplayModeTVs[1] = (TextView) findViewById(R.id.nav_display_road_condition_mode_tv);
        this.mCheckBox[0] = (CheckBox) findViewById(R.id.nav_scale_cb);
        this.mCheckBox[1] = (CheckBox) findViewById(R.id.nav_multi_route_cb);
        this.mCheckBox[2] = (CheckBox) findViewById(R.id.nav_route_name_cb);
        this.mCheckBox[3] = (CheckBox) findViewById(R.id.nav_lane_line_cb);
        this.mCheckBox[4] = (CheckBox) findViewById(R.id.nav_measurement_cb);
        this.mCheckBox[5] = (CheckBox) findViewById(R.id.nav_highway_cb);
        this.mCheckBox[6] = (CheckBox) findViewById(R.id.nav_bridge_cb);
        this.mCheckBox[7] = (CheckBox) findViewById(R.id.nav_bottom_bar_cb);
        this.mCheckBox[8] = (CheckBox) findViewById(R.id.nav_road_condition_cb);
        this.mCheckBox[9] = (CheckBox) findViewById(R.id.nav_voice_cb);
        this.mCheckBox[10] = (CheckBox) findViewById(R.id.nav_refresh_cb);
        this.mCheckBox[11] = (CheckBox) findViewById(R.id.nav_zoom_cb);
        this.mCheckBox[12] = (CheckBox) findViewById(R.id.float_window_cb);
        this.mCheckBox[13] = (CheckBox) findViewById(R.id.nav_iconset_cb);
        this.mCheckBox[14] = (CheckBox) findViewById(R.id.nav_iconvisibility_cb);
        this.mCheckBox[15] = (CheckBox) findViewById(R.id.nav_carnum_cb);
        this.mCheckBox[16] = (CheckBox) findViewById(R.id.nav_redline_cb);
        this.mCheckBox[17] = (CheckBox) findViewById(R.id.nav_RoadEnlargeView_cb);
        this.mCheckBox[18] = (CheckBox) findViewById(R.id.nav_AutoQuit_cb);
        this.mCheckBox[19] = (CheckBox) findViewById(R.id.nav_CarIconOffset_cb);
        this.mCheckBox[20] = (CheckBox) findViewById(R.id.nav_margin_cb);
        this.mCheckBox[21] = (CheckBox) findViewById(R.id.nav_RouteSort_cb);
        this.mCheckBox[22] = (CheckBox) findViewById(R.id.nav_RouteSearch_cb);
        this.mCheckBox[23] = (CheckBox) findViewById(R.id.nav_moreset_cb);
        this.mCheckBox[24] = (CheckBox) findViewById(R.id.nav_seeallwhenbegin_cb);
        this.carnumEdit = (EditText) findViewById(R.id.carnum_edit);
        this.offsetx = (EditText) findViewById(R.id.offset_x);
        this.offsety = (EditText) findViewById(R.id.offset_y);
        this.carnumEdit.setText(this.carnum);
        this.offsetx.setText(this.cariconoffsetx);
        this.offsety.setText(this.cariconoffsety);
        updateDayNightModeView(BaiduNaviManagerFactory.getProfessionalNaviSettingManager().getDayNightMode(1));
        updateGuideViewModeView(BaiduNaviManagerFactory.getProfessionalNaviSettingManager().getGuideViewMode(1));
        updateNavDisplayViewModeView(BaiduNaviManagerFactory.getProfessionalNaviSettingManager().getFullViewMode(1));
        for (int i = 0; i < 25; i++) {
            this.mCheckBox[i].setChecked(this.mIsChecked[i]);
            this.mCheckBox[i].setOnClickListener(this);
        }
    }

    private void updateDayNightModeView(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        View view = this.mDayNightModeViews[0];
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        TextView textView = this.mDayNightModeTVs[0];
        if (i == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        textView.setSelected(z2);
        View view2 = this.mDayNightModeViews[1];
        if (i == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        view2.setSelected(z3);
        TextView textView2 = this.mDayNightModeTVs[1];
        if (i == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        textView2.setSelected(z4);
        View view3 = this.mDayNightModeViews[2];
        if (i == 3) {
            z5 = true;
        } else {
            z5 = false;
        }
        view3.setSelected(z5);
        TextView textView3 = this.mDayNightModeTVs[2];
        if (i == 3) {
            z6 = true;
        }
        textView3.setSelected(z6);
    }

    private void updateGuideViewModeView(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        View view = this.mGuideViewModeViews[0];
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        TextView textView = this.mGuideViewModeTVs[0];
        if (i == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        textView.setSelected(z2);
        View view2 = this.mGuideViewModeViews[1];
        if (i == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        view2.setSelected(z3);
        TextView textView2 = this.mGuideViewModeTVs[1];
        if (i == 2) {
            z4 = true;
        }
        textView2.setSelected(z4);
    }

    private void updateNavDisplayViewModeView(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        View view = this.mNavDisplayModeViews[0];
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        TextView textView = this.mNavDisplayModeTVs[0];
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        textView.setSelected(z2);
        View view2 = this.mNavDisplayModeViews[1];
        if (i == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        view2.setSelected(z3);
        TextView textView2 = this.mNavDisplayModeTVs[1];
        if (i == 1) {
            z4 = true;
        }
        textView2.setSelected(z4);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 23)
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean canDrawOverlays;
        if (i == 1234) {
            canDrawOverlays = Settings.canDrawOverlays(this);
            if (canDrawOverlays) {
                BNUtils.setBoolean(this, "float_window", true);
            } else {
                BNUtils.setBoolean(this, "float_window", false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    @RequiresApi(api = 23)
    public void onClick(View view) {
        boolean canDrawOverlays;
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.bnav_view_car3d_layout) {
            updateGuideViewModeView(1);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setGuideViewMode(1, 1);
            return;
        }
        if (id == R.id.bnav_view_north2d_layout) {
            updateGuideViewModeView(2);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setGuideViewMode(2, 1);
            return;
        }
        if (id == R.id.bnav_auto_mode_layout) {
            updateDayNightModeView(1);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setDayNightMode(1, 1);
            return;
        }
        if (id == R.id.bnav_day_mode_layout) {
            updateDayNightModeView(2);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setDayNightMode(2, 1);
            return;
        }
        if (id == R.id.bnav_night_mode_layout) {
            updateDayNightModeView(3);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setDayNightMode(3, 1);
            return;
        }
        if (id == R.id.bnav_display_overview_mode_layout) {
            updateNavDisplayViewModeView(0);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setFullViewMode(0, 1);
            return;
        }
        if (id == R.id.bnav_display_road_cond_mode_layout) {
            updateNavDisplayViewModeView(1);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setFullViewMode(1, 1);
            return;
        }
        if (id == R.id.nav_scale_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setAutoScale(this.mCheckBox[0].isChecked(), 1);
            return;
        }
        if (id == R.id.nav_multi_route_cb) {
            BaiduNaviManagerFactory.getCommonSettingManager().setMultiRouteEnable(this.mCheckBox[1].isChecked());
            return;
        }
        if (id == R.id.nav_route_name_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setRoadNameEnable(this.mCheckBox[2].isChecked());
            return;
        }
        if (id == R.id.nav_lane_line_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setLaneLineEnable(this.mCheckBox[3].isChecked());
            return;
        }
        if (id == R.id.nav_measurement_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setMeasurementEnable(this.mCheckBox[4].isChecked());
            return;
        }
        if (id == R.id.nav_highway_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setHighwayEnable(this.mCheckBox[5].isChecked());
            return;
        }
        if (id == R.id.nav_bridge_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setShowMainAuxiliaryOrBridge(false);
            return;
        }
        if (id == R.id.nav_bottom_bar_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().enableBottomBarOpen(this.mCheckBox[7].isChecked());
            return;
        }
        if (id == R.id.nav_road_condition_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setRoadConditionButtonVisible(this.mCheckBox[8].isChecked());
            return;
        }
        if (id == R.id.nav_voice_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setVoiceButtonVisible(this.mCheckBox[9].isChecked());
            return;
        }
        if (id == R.id.nav_refresh_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setRefreshButtonVisible(this.mCheckBox[10].isChecked());
            return;
        }
        if (id == R.id.nav_zoom_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setZoomButtonVisible(this.mCheckBox[11].isChecked());
            return;
        }
        if (id == R.id.float_window_cb) {
            boolean isChecked = this.mCheckBox[12].isChecked();
            BNUtils.setBoolean(this, "float_window", isChecked);
            if (isChecked) {
                canDrawOverlays = Settings.canDrawOverlays(this);
                if (!canDrawOverlays) {
                    startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 1234);
                    return;
                }
                return;
            }
            return;
        }
        if (id == R.id.nav_iconset_cb) {
            boolean isChecked2 = this.mCheckBox[13].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_ICONSET, isChecked2);
            if (isChecked2) {
                BaiduNaviManagerFactory.getCommonSettingManager().setDIYImageToMap(BitmapFactory.decodeResource(getResources(), R.drawable.bnav_setting_btn_bg_selector, null), 0);
                return;
            } else {
                BaiduNaviManagerFactory.getCommonSettingManager().clearDIYImage(0);
                return;
            }
        }
        if (id == R.id.nav_iconvisibility_cb) {
            boolean isChecked3 = this.mCheckBox[14].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_ICONSHOW, isChecked3);
            BaiduNaviManagerFactory.getCommonSettingManager().setDIYImageStatus(isChecked3, 0);
            return;
        }
        if (id == R.id.nav_carnum_cb) {
            boolean isChecked4 = this.mCheckBox[15].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_CARNUM, isChecked4);
            if (this.carnumEdit.getText() != null && isChecked4) {
                BaiduNaviManagerFactory.getCommonSettingManager().setCarNum(this.carnumEdit.getText().toString());
                BNUtils.setString(this, BNUtils.KEY_GB_CARNUMTXT, this.carnumEdit.getText().toString());
                return;
            } else {
                BaiduNaviManagerFactory.getCommonSettingManager().setCarNum("");
                this.mCheckBox[15].setChecked(false);
                return;
            }
        }
        if (id == R.id.nav_redline_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setShowCarLogoToEndRedLine(this.mCheckBox[16].isChecked(), 1);
            return;
        }
        if (id == R.id.nav_RoadEnlargeView_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setShowRoadEnlargeView(this.mCheckBox[17].isChecked(), 1);
            return;
        }
        if (id == R.id.nav_AutoQuit_cb) {
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setIsAutoQuitWhenArrived(this.mCheckBox[18].isChecked());
            return;
        }
        if (id == R.id.nav_CarIconOffset_cb) {
            boolean isChecked5 = this.mCheckBox[19].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_CARICONOFFSET, isChecked5);
            if (isChecked5) {
                BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setCarIconOffsetForNavi(Integer.valueOf(this.offsetx.getText().toString()).intValue(), Integer.valueOf(this.offsety.getText().toString()).intValue());
                BNUtils.setString(this, BNUtils.KEY_GB_CARICONOFFSET_X, this.offsetx.getText().toString());
                BNUtils.setString(this, BNUtils.KEY_GB_CARICONOFFSET_Y, this.offsety.getText().toString());
                return;
            }
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setCarIconOffsetForNavi(0, 0);
            return;
        }
        if (id == R.id.nav_margin_cb) {
            boolean isChecked6 = this.mCheckBox[20].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_MARGIN, isChecked6);
            if (isChecked6) {
                BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setFullViewMarginSize(40, 40, 40, 40);
                return;
            } else {
                BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setCarIconOffsetForNavi(0, 0);
                return;
            }
        }
        if (id == R.id.nav_RouteSort_cb) {
            boolean isChecked7 = this.mCheckBox[21].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_ROUTE_SORT, isChecked7);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().enableRouteSort(isChecked7);
            return;
        }
        if (id == R.id.nav_RouteSearch_cb) {
            boolean isChecked8 = this.mCheckBox[22].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_ROUTE_SEARCH, isChecked8);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().enableRouteSearch(isChecked8);
        } else if (id == R.id.nav_moreset_cb) {
            boolean isChecked9 = this.mCheckBox[23].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_MORE_SETTINGS, isChecked9);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().enableMoreSettings(isChecked9);
        } else if (id == R.id.nav_seeallwhenbegin_cb) {
            boolean isChecked10 = this.mCheckBox[24].isChecked();
            BNUtils.setBoolean(this, BNUtils.KEY_GB_SEEALL, isChecked10);
            BaiduNaviManagerFactory.getProfessionalNaviSettingManager().setStartByFullView(isChecked10);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_navi_setting);
        initUserConfig();
        initViews();
        initClickListener();
    }
}
