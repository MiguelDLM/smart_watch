package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private String liveStartTime;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String qb;
    private String qc;
    private List<String> rQ;
    private String rR;
    private String rS;
    private String rT;
    private boolean rU;
    private String rV;
    private String rW = "查看详情";
    private String rX = "立即预约";
    private List<String> rY;

    @Nullable
    private AdTemplate rZ;
    private String title;

    @Nullable
    public static a I(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo dS = e.dS(adTemplate);
        AdProductInfo cQ = com.kwad.sdk.core.response.b.a.cQ(dS);
        a aVar = new a();
        String name = cQ.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.aw(dS);
        }
        aVar.qb = cQ.getIcon();
        aVar.qc = com.kwad.sdk.core.response.b.a.at(dS);
        aVar.price = cQ.getPrice();
        aVar.originPrice = cQ.getOriginPrice();
        if (!cQ.isCouponListEmpty() && (firstCouponList = cQ.getFirstCouponList()) != null) {
            aVar.N(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.M(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a J(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo dd = com.kwad.sdk.core.response.b.b.dd(adTemplate);
        a aVar = new a();
        aVar.qb = dd.userHeadUrl;
        aVar.liveStartTime = dd.liveStartTime;
        aVar.title = dd.title;
        aVar.rU = dd.needShowSubscriberCount();
        aVar.rV = dd.getFormattedLiveSubscribeCount();
        aVar.rY = dd.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = dd.playEndCard;
        aVar.rW = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.rX = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.rZ = adTemplate;
        return aVar;
    }

    private void M(String str) {
        this.rS = str;
    }

    private void N(String str) {
        this.rT = str;
    }

    @Nullable
    public static a a(r rVar, boolean z) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo dS = e.dS(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cd(dS);
        aVar.qb = com.kwad.sdk.core.response.b.a.cg(dS);
        aVar.qc = com.kwad.sdk.core.response.b.a.at(dS);
        aVar.rQ = com.kwad.sdk.core.response.b.d.dJ(adTemplate);
        aVar.rR = com.kwad.sdk.core.response.b.a.aD(dS);
        aVar.playableStyle = e.l(adTemplate, z);
        aVar.rZ = adTemplate;
        aVar.mApkDownloadHelper = rVar.ha();
        return aVar;
    }

    public final String gX() {
        return this.rT;
    }

    public final String gY() {
        return this.rS;
    }

    @Nullable
    public final AdTemplate gZ() {
        return this.rZ;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String gg() {
        return this.qb;
    }

    public final String gh() {
        return this.qc;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c ha() {
        return this.mApkDownloadHelper;
    }

    public final List<String> hb() {
        return this.rQ;
    }

    public final boolean hc() {
        List<String> list = this.rQ;
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public final int hd() {
        return this.playableStyle;
    }

    public final String he() {
        return this.rV;
    }

    public final String hf() {
        return this.rX;
    }

    public final boolean hg() {
        return this.rU;
    }

    public final List<String> hh() {
        return this.rY;
    }

    public final String hi() {
        return this.liveStartTime;
    }
}
