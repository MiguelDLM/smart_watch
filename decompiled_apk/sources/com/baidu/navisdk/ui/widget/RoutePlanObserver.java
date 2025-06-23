package com.baidu.navisdk.ui.widget;

import XXO0.oIX0oI;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.baidu.navisdk.comapi.base.c;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.e;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.offlinedownload.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class RoutePlanObserver implements e {
    private static BNNetworkingDialog mRoutePlanAvoidTrafficJamDialog;
    private static BNMessageDialog mRoutePlanFirstCalcDialog;
    private static BNMessageDialog mRoutePlanNetworkingDialog;
    private static BNMessageDialog mRoutePlanNoNetNoDataDialog;
    private static BNMessageDialog mRoutePlanOvertimeDialog;
    private static BNCommonProgressDialog mWaitProgress;
    protected WeakReference<Activity> mActivity;
    private a mJumpToDownloadListener;
    private BNMessageDialog mNaviMessageDialog = null;

    public RoutePlanObserver(Activity activity, a aVar) {
        this.mActivity = null;
        this.mJumpToDownloadListener = null;
        this.mActivity = new WeakReference<>(activity);
        this.mJumpToDownloadListener = aVar;
    }

    private boolean dismissRoutePlanFirstCalcDialog() {
        BNMessageDialog bNMessageDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanFirstCalcDialog) != null && bNMessageDialog.isShowing()) {
            try {
                mRoutePlanFirstCalcDialog.dismiss();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("", e);
                }
            }
        }
        mRoutePlanFirstCalcDialog = null;
        return true;
    }

    private String getDebugToastMessage(e.c cVar) {
        if (LogUtil.LOGGABLE) {
            return oIX0oI.I0Io.f4096II0xO0 + cVar.f6721a + oIX0oI.I0Io.f4095I0Io;
        }
        return "";
    }

    public boolean dismissMessageDialog() {
        BNMessageDialog bNMessageDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = this.mNaviMessageDialog) != null && bNMessageDialog.isShowing()) {
            try {
                this.mNaviMessageDialog.dismiss();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("", e);
                }
            }
        }
        this.mNaviMessageDialog = null;
        return true;
    }

    public boolean dismissRoutePlanAvoidTrafficJamDialog() {
        BNNetworkingDialog bNNetworkingDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNNetworkingDialog = mRoutePlanAvoidTrafficJamDialog) != null && bNNetworkingDialog.isShowing()) {
            try {
                mRoutePlanAvoidTrafficJamDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        mRoutePlanAvoidTrafficJamDialog = null;
        return true;
    }

    public boolean dismissRoutePlanNetworkingDialog() {
        BNMessageDialog bNMessageDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanNetworkingDialog) != null && bNMessageDialog.isShowing()) {
            try {
                mRoutePlanNetworkingDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        mRoutePlanNetworkingDialog = null;
        return true;
    }

    public boolean dismissRoutePlanNoNetNoDataDialog() {
        BNMessageDialog bNMessageDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanNoNetNoDataDialog) != null && bNMessageDialog.isShowing()) {
            try {
                mRoutePlanNoNetNoDataDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        mRoutePlanNoNetNoDataDialog = null;
        return true;
    }

    public boolean dismissRoutePlanOvertimeDialog() {
        BNMessageDialog bNMessageDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanOvertimeDialog) != null && bNMessageDialog.isShowing()) {
            try {
                mRoutePlanOvertimeDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        mRoutePlanOvertimeDialog = null;
        return true;
    }

    public boolean dismissWaitProgressDialog() {
        BNCommonProgressDialog bNCommonProgressDialog;
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNCommonProgressDialog = mWaitProgress) != null && bNCommonProgressDialog.isShowing()) {
            try {
                mWaitProgress.dismiss();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RoutePlan", e);
                }
            }
        }
        mWaitProgress = null;
        return true;
    }

    public a getJumpToDownloadListener() {
        return this.mJumpToDownloadListener;
    }

    public String getRoutePlanTipsMsg() {
        String h;
        int s = BNRoutePlaner.getInstance().s();
        if (s != 1) {
            if (s != 2) {
                if (s != 4) {
                    h = b.h(R.string.nsdk_string_rg_guide_normal);
                } else {
                    h = b.h(R.string.nsdk_string_rg_navi_recomment_park);
                }
            } else {
                h = b.h(R.string.nsdk_string_rg_guide_end);
            }
        } else {
            h = b.h(R.string.nsdk_string_rg_guide_normal);
        }
        BNRoutePlaner.getInstance().o(1);
        return h;
    }

    public void handleRoutePlanBefore() {
        if (BNRoutePlaner.getInstance().d() == 16 || BNRoutePlaner.getInstance().d() == 7 || x.t()) {
            return;
        }
        showWaitProgressDialog(this.mActivity.get());
    }

    public void onRouterPlanFailReasonShow(e.c cVar) {
        int i = cVar.f6721a;
        if (i != 420) {
            if (i != 421) {
                if (this.mActivity.get() != null && !this.mActivity.get().isFinishing()) {
                    TipTool.onCreateToastDialog(this.mActivity.get(), cVar.b + getDebugToastMessage(cVar));
                    return;
                }
                return;
            }
            if (this.mActivity.get() != null && !this.mActivity.get().isFinishing()) {
                TipTool.onCreateToastDialog(this.mActivity.get(), "无网络无数据，请检查" + getDebugToastMessage(cVar));
                return;
            }
            return;
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing()) {
            TipTool.onCreateToastDialog(this.mActivity.get(), "数据缺失，请检查" + getDebugToastMessage(cVar));
        }
    }

    public void onRouterPlanTipShow(e.c cVar) {
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing()) {
            TipTool.onCreateToastDialog(this.mActivity.get(), cVar.b + getDebugToastMessage(cVar));
        }
    }

    public void setJumpToDownloadListener(a aVar) {
        this.mJumpToDownloadListener = aVar;
    }

    public void showMessageDialog(Context context, String str) {
        BNMessageDialog bNMessageDialog;
        dismissMessageDialog();
        if (this.mNaviMessageDialog == null && context != null) {
            this.mNaviMessageDialog = new BNMessageDialog((Activity) context).setMessage(str).setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rp_alert_notification)).setFirstBtnEnabled(true).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_alert_iknown));
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = this.mNaviMessageDialog) != null) {
            try {
                bNMessageDialog.show();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("", e);
                }
            }
        }
    }

    public void showReCalRouteQuitDialog() {
    }

    public void showRoutePlanAvoidTrafficJamDialog(Context context, String str, String str2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        BNNetworkingDialog bNNetworkingDialog;
        dismissRoutePlanAvoidTrafficJamDialog();
        if (mRoutePlanAvoidTrafficJamDialog == null) {
            mRoutePlanAvoidTrafficJamDialog = new BNNetworkingDialog((Activity) context).setNetworkingContentMessage(str).setConfirmNetworkMessage(str2).setConfirmNetworkingListener(onClickListener).setCancleListener(onClickListener2).setTwoButtonMode(true);
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNNetworkingDialog = mRoutePlanAvoidTrafficJamDialog) != null) {
            try {
                bNNetworkingDialog.show();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("", e);
                }
            }
        }
    }

    public void showRoutePlanFirstCalcDialog(Context context, BNBaseDialog.OnNaviClickListener onNaviClickListener) {
        BNMessageDialog bNMessageDialog;
        dismissRoutePlanFirstCalcDialog();
        if (mRoutePlanFirstCalcDialog == null && this.mActivity.get() != null) {
            mRoutePlanFirstCalcDialog = new BNMessageDialog(this.mActivity.get()).setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rp_alert_notification)).setMessage(JarUtils.getResources().getString(R.string.nsdk_string_rp_fist_calc_tip)).setSecondBtnEnabled(false).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_alert_iknown)).setOnFirstBtnClickListener(onNaviClickListener);
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanFirstCalcDialog) != null) {
            try {
                bNMessageDialog.show();
            } catch (Exception e) {
                LogUtil.e("wy", e.toString());
            }
        }
    }

    public void showRoutePlanNetworkingDialog(Context context, String str, String str2, BNBaseDialog.OnNaviClickListener onNaviClickListener, BNBaseDialog.OnNaviClickListener onNaviClickListener2) {
        BNMessageDialog bNMessageDialog;
        dismissRoutePlanNetworkingDialog();
        if (mRoutePlanNetworkingDialog == null && this.mActivity.get() != null) {
            mRoutePlanNetworkingDialog = new BNMessageDialog(this.mActivity.get()).setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rp_alert_notification)).setMessage(str).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_rp_down_data)).setSecondBtnText(JarUtils.getResources().getString(R.string.nsdk_string_rp_use_online)).setOnFirstBtnClickListener(onNaviClickListener2).setOnSecondBtnClickListener(onNaviClickListener);
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanNetworkingDialog) != null) {
            try {
                bNMessageDialog.show();
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("", e);
                }
            }
        }
    }

    public void showRoutePlanNoNetNoDataDialog(Context context, String str) {
        BNMessageDialog bNMessageDialog;
        dismissRoutePlanNoNetNoDataDialog();
        if (mRoutePlanNoNetNoDataDialog == null && this.mActivity.get() != null) {
            mRoutePlanNoNetNoDataDialog = new BNMessageDialog(this.mActivity.get()).setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rp_alert_notification)).setMessage(JarUtils.getResources().getString(R.string.nsdk_string_rp_no_net_no_data_tip) + "\n缺失以下数据：" + str).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_rp_down_data)).setSecondBtnText(JarUtils.getResources().getString(R.string.nsdk_string_rp_open_net)).setOnFirstBtnClickListener(new BNBaseDialog.OnNaviClickListener() { // from class: com.baidu.navisdk.ui.widget.RoutePlanObserver.2
                @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
                public void onClick() {
                    RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
                    if (RoutePlanObserver.this.mJumpToDownloadListener != null) {
                        RoutePlanObserver.this.mJumpToDownloadListener.a();
                    }
                }
            }).setOnSecondBtnClickListener(new BNBaseDialog.OnNaviClickListener() { // from class: com.baidu.navisdk.ui.widget.RoutePlanObserver.1
                @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
                public void onClick() {
                    RoutePlanObserver.this.dismissRoutePlanNoNetNoDataDialog();
                    if (RoutePlanObserver.this.mActivity.get() != null) {
                        RoutePlanObserver.this.mActivity.get().startActivity(new Intent("android.settings.AIRPLANE_MODE_SETTINGS"));
                    }
                }
            });
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanNoNetNoDataDialog) != null) {
            try {
                bNMessageDialog.show();
            } catch (Exception e) {
                LogUtil.e("wy", e.toString());
            }
        }
    }

    public void showRoutePlanOvertimeDialog(Context context, BNBaseDialog.OnNaviClickListener onNaviClickListener, BNBaseDialog.OnNaviClickListener onNaviClickListener2) {
        BNMessageDialog bNMessageDialog;
        dismissRoutePlanOvertimeDialog();
        if (mRoutePlanOvertimeDialog == null && this.mActivity.get() != null) {
            mRoutePlanOvertimeDialog = new BNMessageDialog(this.mActivity.get()).setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rp_alert_notification)).setMessage(JarUtils.getResources().getString(R.string.nsdk_string_rp_recalc_tip)).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_negative)).setSecondBtnText(JarUtils.getResources().getString(R.string.nsdk_string_recalc)).setOnFirstBtnClickListener(onNaviClickListener2).setOnSecondBtnClickListener(onNaviClickListener);
        }
        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNMessageDialog = mRoutePlanOvertimeDialog) != null) {
            try {
                bNMessageDialog.show();
            } catch (Exception unused) {
            }
        }
    }

    public void showWaitProgressDialog(Context context) {
        BNCommonProgressDialog bNCommonProgressDialog;
        dismissWaitProgressDialog();
        try {
            if (mWaitProgress == null && context != null) {
                mWaitProgress = new BNCommonProgressDialog((Activity) context);
            }
            if (this.mActivity.get() != null && !this.mActivity.get().isFinishing() && (bNCommonProgressDialog = mWaitProgress) != null) {
                bNCommonProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.navisdk.ui.widget.RoutePlanObserver.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LogUtil.e("RoutePlan", "WaitProgress onCancel!");
                        RoutePlanObserver.this.showReCalRouteQuitDialog();
                    }
                });
                mWaitProgress.setMessage(getRoutePlanTipsMsg());
                mWaitProgress.show();
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e);
            }
        }
    }

    @Override // com.baidu.navisdk.comapi.base.b
    public void update(c cVar, int i, int i2, Object obj) {
        switch (i) {
            case 1:
                switch (i2) {
                    case 1:
                        handleRoutePlanBefore();
                        return;
                    case 2:
                    case 4:
                        dismissWaitProgressDialog();
                        return;
                    case 3:
                        if (x.t()) {
                            return;
                        }
                        if (this.mActivity.get() != null && !this.mActivity.get().isFinishing()) {
                            TipTool.onCreateToastDialog(this.mActivity.get(), "抱歉，小度没找到");
                        }
                        dismissWaitProgressDialog();
                        return;
                    case 5:
                        onRouterPlanTipShow((e.c) obj);
                        BNRoutePlaner.getInstance().o(1);
                        BNRoutePlaner.getInstance().h(0);
                        BNRouteGuider.getInstance().setGuideEndType(0);
                        return;
                    case 6:
                        if (!x.t()) {
                            onRouterPlanTipShow((e.c) obj);
                        }
                        BNRoutePlaner.getInstance().o(1);
                        BNRoutePlaner.getInstance().h(0);
                        BNRouteGuider.getInstance().setGuideEndType(0);
                        return;
                    case 7:
                        dismissWaitProgressDialog();
                        if (!x.t()) {
                            onRouterPlanFailReasonShow((e.c) obj);
                        }
                        BNRoutePlaner.getInstance().o(1);
                        BNRoutePlaner.getInstance().h(0);
                        BNRouteGuider.getInstance().setGuideEndType(0);
                        return;
                    default:
                        return;
                }
            case 2:
                if (8 != i2) {
                    if (9 == i2) {
                        dismissRoutePlanNetworkingDialog();
                        return;
                    }
                    return;
                }
                e.b bVar = (e.b) obj;
                showRoutePlanNetworkingDialog(this.mActivity.get(), "小度需要" + bVar.b + "数据，才可以带您去这里，请选择：", JarUtils.getResources().getString(R.string.nsdk_string_rp_confirm), bVar.f6720a, new BNBaseDialog.OnNaviClickListener() { // from class: com.baidu.navisdk.ui.widget.RoutePlanObserver.5
                    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
                    public void onClick() {
                        RoutePlanObserver.this.dismissRoutePlanNetworkingDialog();
                        if (RoutePlanObserver.this.mJumpToDownloadListener != null) {
                            RoutePlanObserver.this.mJumpToDownloadListener.a();
                        }
                    }
                });
                return;
            case 3:
                if (8 == i2) {
                    showRoutePlanAvoidTrafficJamDialog(this.mActivity.get(), JarUtils.getResources().getString(R.string.nsdk_string_rp_avoid_trafficjam), JarUtils.getResources().getString(R.string.nsdk_string_rp_avoid_trafficjam_iknow), ((e.a) obj).f6719a, new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.RoutePlanObserver.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            RoutePlanObserver.this.dismissRoutePlanAvoidTrafficJamDialog();
                        }
                    });
                    return;
                } else {
                    if (9 == i2) {
                        dismissRoutePlanAvoidTrafficJamDialog();
                        return;
                    }
                    return;
                }
            case 4:
                if (8 == i2) {
                    showMessageDialog(this.mActivity.get(), JarUtils.getResources().getString(R.string.nsdk_string_rp_online_network_error, ((e.d) obj).f6722a));
                    return;
                } else {
                    if (9 == i2) {
                        dismissMessageDialog();
                        return;
                    }
                    return;
                }
            case 5:
                if (BNRoutePlaner.getInstance().z()) {
                    return;
                }
                if (16 == i2) {
                    showRoutePlanOvertimeDialog(this.mActivity.get(), ((e.b) obj).f6720a, new BNBaseDialog.OnNaviClickListener() { // from class: com.baidu.navisdk.ui.widget.RoutePlanObserver.6
                        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
                        public void onClick() {
                            RoutePlanObserver.this.dismissRoutePlanOvertimeDialog();
                        }
                    });
                    return;
                } else {
                    if (17 == i2) {
                        dismissRoutePlanOvertimeDialog();
                        return;
                    }
                    return;
                }
            case 6:
                if (18 == i2) {
                    showRoutePlanNoNetNoDataDialog(this.mActivity.get(), (String) obj);
                    return;
                } else {
                    if (19 == i2) {
                        dismissRoutePlanNoNetNoDataDialog();
                        return;
                    }
                    return;
                }
            case 7:
                if (8 == i2) {
                    showRoutePlanFirstCalcDialog(this.mActivity.get(), ((e.b) obj).f6720a);
                    return;
                } else {
                    if (9 == i2) {
                        dismissRoutePlanNoNetNoDataDialog();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }
}
