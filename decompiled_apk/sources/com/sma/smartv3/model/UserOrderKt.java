package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public final class UserOrderKt {
    @OOXIXo
    public static final List<VipBenefit> getVipBenefitList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VipBenefit(UtilsKt.oI0IIXIo(R.string.member_aiqa), R.drawable.vip_member_aiqa_icon, VipBenefitType.AI.getType()));
        if (!ProductManager.f20544oIX0oI.Xo()) {
            arrayList.add(new VipBenefit(UtilsKt.oI0IIXIo(R.string.member_aigc), R.drawable.vip_member_aigc_icon, VipBenefitType.AIGC.getType()));
            arrayList.add(new VipBenefit(UtilsKt.oI0IIXIo(R.string.member_vip_dial), R.drawable.vip_member_vip_dial_icon, VipBenefitType.DIAL.getType()));
        }
        String oI0IIXIo2 = UtilsKt.oI0IIXIo(R.string.member_ad_free);
        VipBenefitType vipBenefitType = VipBenefitType.BUY_VIP;
        arrayList.add(new VipBenefit(oI0IIXIo2, R.drawable.vip_member_ad_free_icon, vipBenefitType.getType()));
        arrayList.add(new VipBenefit(UtilsKt.oI0IIXIo(R.string.member_prestigious_logo), R.drawable.vip_member_prestigious_logo_icon, vipBenefitType.getType()));
        return arrayList;
    }
}
