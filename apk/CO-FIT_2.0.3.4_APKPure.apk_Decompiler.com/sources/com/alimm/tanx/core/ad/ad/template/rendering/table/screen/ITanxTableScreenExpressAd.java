package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.app.Activity;
import com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.request.TanxError;

public interface ITanxTableScreenExpressAd extends INewTanxExpressAd {

    public interface OnTableScreenAdListener extends ITanxInteractionListener {
        void onAdClose();

        void onAdShake();

        void onError(TanxError tanxError);
    }

    void setOnTableScreenAdListener(OnTableScreenAdListener onTableScreenAdListener);

    void showAd(Activity activity);

    void showAd(Activity activity, TableScreenParam tableScreenParam);

    void showAd(Activity activity, TableScreenParam tableScreenParam, boolean z);
}
