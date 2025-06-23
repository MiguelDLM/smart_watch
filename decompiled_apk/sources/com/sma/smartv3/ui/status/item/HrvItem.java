package com.sma.smartv3.ui.status.item;

import android.view.View;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HrvDao;
import com.sma.smartv3.db.entity.Hrv;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFRegular;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class HrvItem extends BaseDslItem {
    private long[] range;
    private DINCondBold tempLastTime;
    private DINCondBold tempLastValue;
    private PFRegular tmpUnit;

    @OXOo.OOXIXo
    private final HrvDao mHrvDao = MyDb.INSTANCE.getMDatabase().hrvDao();
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.tempLastTime);
        IIX0o.ooOOo0oXI(v);
        this.tempLastTime = (DINCondBold) v;
        View v2 = itemHolder.v(R.id.tempLastValue);
        IIX0o.ooOOo0oXI(v2);
        this.tempLastValue = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.tmpUnit);
        IIX0o.ooOOo0oXI(v3);
        this.tmpUnit = (PFRegular) v3;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        PFRegular pFRegular = null;
        long[] OxI2 = com.sma.smartv3.util.xoIox.OxI(null, TimePeriod.DAY, 0, 5, null);
        this.range = OxI2;
        HrvDao hrvDao = this.mHrvDao;
        if (OxI2 == null) {
            IIX0o.XOxIOxOx("range");
            OxI2 = null;
        }
        long j = OxI2[0];
        long[] jArr = this.range;
        if (jArr == null) {
            IIX0o.XOxIOxOx("range");
            jArr = null;
        }
        List<Hrv> hrv = hrvDao.getHrv(j, jArr[1]);
        if (hrv.isEmpty()) {
            DINCondBold dINCondBold = this.tempLastTime;
            if (dINCondBold == null) {
                IIX0o.XOxIOxOx("tempLastTime");
                dINCondBold = null;
            }
            dINCondBold.setText(R.string.data_none);
            DINCondBold dINCondBold2 = this.tempLastValue;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("tempLastValue");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
        } else {
            DINCondBold dINCondBold3 = this.tempLastTime;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("tempLastTime");
                dINCondBold3 = null;
            }
            dINCondBold3.setText(TimeUtils.millis2String(((Hrv) CollectionsKt___CollectionsKt.O0OOX0IIx(hrv)).getMTime(), com.sma.smartv3.util.xoIox.oo0xXOI0I()));
            DINCondBold dINCondBold4 = this.tempLastValue;
            if (dINCondBold4 == null) {
                IIX0o.XOxIOxOx("tempLastValue");
                dINCondBold4 = null;
            }
            dINCondBold4.setText(String.valueOf(((Hrv) CollectionsKt___CollectionsKt.O0OOX0IIx(hrv)).getMValue()));
        }
        PFRegular pFRegular2 = this.tmpUnit;
        if (pFRegular2 == null) {
            IIX0o.XOxIOxOx("tmpUnit");
        } else {
            pFRegular = pFRegular2;
        }
        pFRegular.setText(R.string.ms);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_hrv;
    }

    @XO0.XO(tag = x0xO0oo.f24669xxIXOIIO)
    public final void onHrvChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onHrvChanged");
        initView();
    }
}
