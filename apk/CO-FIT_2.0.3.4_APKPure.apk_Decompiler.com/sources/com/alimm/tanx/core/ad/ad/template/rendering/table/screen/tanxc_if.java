package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd;
import com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.utils.LogUtils;

public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxTableScreenAd> implements ITanxTableScreenExpressAd {
    public ITanxTableScreenAd tanxc_do;
    private ITanxTableScreenExpressAd.OnTableScreenAdListener tanxc_if;
    private TableScreenParam tanxc_int;

    public tanxc_if(ITanxTableScreenAd iTanxTableScreenAd) {
        super(iTanxTableScreenAd);
        this.tanxc_do = iTanxTableScreenAd;
    }

    public void destroy() {
        LogUtils.d("TanxTableScreenExpressAd", "媒体调用destroy（）");
        super.destroy();
        this.tanxc_do = null;
        this.tanxc_if = null;
    }

    public String getScene() {
        return TanxAdType.TABLE_SCREEN_STRING;
    }

    public void refresh() {
    }

    public void setOnTableScreenAdListener(ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener) {
        this.tanxc_if = onTableScreenAdListener;
    }

    public void showAd(Activity activity) {
        showAd(activity, new TableScreenParam());
    }

    public TanxAdView tanxc_do() {
        return null;
    }

    public ITanxTableScreenExpressAd.OnTableScreenAdListener tanxc_for() {
        return this.tanxc_if;
    }

    /* renamed from: tanxc_if */
    public TanxAdView getAdView() {
        return null;
    }

    private void tanxc_do(Context context, Class<?> cls, boolean z) {
        com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.put(getRequestId(), this);
        Intent intent = new Intent(context, cls);
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("REQ_ID", getRequestId());
        context.startActivity(intent);
    }

    public /* synthetic */ View getAdView(Activity activity) {
        return tanxc_do();
    }

    public void showAd(Activity activity, TableScreenParam tableScreenParam) {
        showAd(activity, tableScreenParam, true);
    }

    public void showAd(Activity activity, TableScreenParam tableScreenParam, boolean z) {
        ITanxTableScreenAd iTanxTableScreenAd = this.tanxc_do;
        if (iTanxTableScreenAd == null || iTanxTableScreenAd.getBidInfo() == null || this.tanxc_do.getBidInfo().getTemplateConf() == null || TextUtils.isEmpty(this.tanxc_do.getBidInfo().getTemplateConf().getPidStyleId())) {
            TanxError tanxError = new TanxError("TanxRewardExpressAd showAd() iTanxRewardVideoAd为空|| getBidInfo||getTemplateConf||getPidStyleId为空");
            ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener = this.tanxc_if;
            if (onTableScreenAdListener != null) {
                onTableScreenAdListener.onError(tanxError);
            }
            LogUtils.e(tanxError);
            return;
        }
        LogUtils.d("TanxRewardExpressAd PidStyleId:", this.tanxc_do.getBidInfo().getTemplateConf().getPidStyleId());
        LogUtils.d("TanxRewardExpressAd", "启动插屏广告");
        this.tanxc_int = tableScreenParam;
        tanxc_do(activity, TableScreenPortraitActivity.class, z);
    }
}
